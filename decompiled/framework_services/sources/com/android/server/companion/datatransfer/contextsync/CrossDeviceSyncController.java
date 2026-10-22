package com.android.server.companion.datatransfer.contextsync;

import android.app.admin.DevicePolicyManager;
import android.companion.AssociationInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import android.util.proto.ProtoUtils;
import com.android.server.audio.AudioService$$ExternalSyntheticLambda2;
import com.android.server.companion.CompanionDeviceConfig;
import com.android.server.companion.transport.CompanionTransportManager;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class CrossDeviceSyncController {
    private static final int CURRENT_VERSION = 1;
    static final String EXTRA_ASSOCIATION_ID = "com.android.server.companion.datatransfer.contextsync.extra.ASSOCIATION_ID";
    static final String EXTRA_CALL = "com.android.server.companion.datatransfer.contextsync.extra.CALL";
    static final String EXTRA_CALL_FACILITATOR_ID = "com.android.server.companion.datatransfer.contextsync.extra.CALL_FACILITATOR_ID";
    public static final String EXTRA_CALL_ID = "com.android.companion.datatransfer.contextsync.extra.CALL_ID";
    static final String EXTRA_FACILITATOR_ICON = "com.android.companion.datatransfer.contextsync.extra.FACILITATOR_ICON";
    static final String EXTRA_IS_REMOTE_ORIGIN = "com.android.companion.datatransfer.contextsync.extra.IS_REMOTE_ORIGIN";
    public static final String FACILITATOR_ID_SYSTEM = "system";
    private static final String TAG = "CrossDeviceSyncController";
    private static final int VERSION_1 = 1;
    private final Set<Integer> mBlocklist;
    private final List<CallMetadataSyncData.CallFacilitator> mCallFacilitators;
    private final CallManager mCallManager;
    private final CompanionTransportManager mCompanionTransportManager;
    private final List<AssociationInfo> mConnectedAssociations;
    private WeakReference<CrossDeviceSyncControllerCallback> mConnectionServiceCallbackRef;
    private final Context mContext;
    private WeakReference<CrossDeviceSyncControllerCallback> mInCallServiceCallbackRef;
    private final PhoneAccountManager mPhoneAccountManager;

    static class CallManager {
        final Map<Integer, Set<String>> mCallIds;
        final Set<String> mExternallyOwnedCalls;
        private final PhoneAccountManager mPhoneAccountManager;
        final Set<String> mSelfOwnedCalls;
        private final TelecomManager mTelecomManager;

        CallManager(Context context, PhoneAccountManager phoneAccountManager) {
            this.mSelfOwnedCalls = new HashSet();
            this.mExternallyOwnedCalls = new HashSet();
            this.mCallIds = new HashMap();
            this.mTelecomManager = (TelecomManager) context.getSystemService(TelecomManager.class);
            this.mPhoneAccountManager = phoneAccountManager;
        }

        void updateCalls(int associationId, CallMetadataSyncData data) {
            Set<String> oldCallIds = this.mCallIds.getOrDefault(Integer.valueOf(associationId), new HashSet());
            Set<String> newCallIds = (Set) data.getCalls().stream().map(new CrossDeviceSyncController$CallManager$$ExternalSyntheticLambda0()).collect(Collectors.toSet());
            if (oldCallIds.equals(newCallIds) == false) goto L5;
            return;
        L5:
            Iterator<CallMetadataSyncData.Call> r2 = data.getCalls().iterator();
        L7:
            if (r2.hasNext() == false) goto L23;
            CallMetadataSyncData.Call currentCall = r2.next();
            if (oldCallIds.contains(currentCall.getId()) == true) goto L7;
            if (currentCall.getFacilitator() == null) goto L7;
            if (isSelfOwned(currentCall.getId()) == true) goto L7;
            this.mExternallyOwnedCalls.add(currentCall.getId());
            Bundle extras = new Bundle();
            extras.putInt(CrossDeviceSyncController.EXTRA_ASSOCIATION_ID, associationId);
            extras.putBoolean(CrossDeviceSyncController.EXTRA_IS_REMOTE_ORIGIN, true);
            extras.putBundle(CrossDeviceSyncController.EXTRA_CALL, currentCall.writeToBundle());
            extras.putString(CrossDeviceSyncController.EXTRA_CALL_ID, currentCall.getId());
            extras.putByteArray(CrossDeviceSyncController.EXTRA_FACILITATOR_ICON, currentCall.getAppIcon());
            PhoneAccountHandle handle = this.mPhoneAccountManager.getPhoneAccountHandle(associationId, currentCall.getFacilitator().getIdentifier());
            if (currentCall.getDirection() == 1) goto L16;
            if (currentCall.getDirection() != 2) goto L7;
            Bundle wrappedExtras = new Bundle();
            wrappedExtras.putParcelable("android.telecom.extra.OUTGOING_CALL_EXTRAS", extras);
            wrappedExtras.putParcelable("android.telecom.extra.PHONE_ACCOUNT_HANDLE", handle);
            String address = currentCall.getCallerId();
            if (address == null) goto L7;
            this.mTelecomManager.placeCall(Uri.fromParts("sip", address, null), wrappedExtras);
            goto L7
        L16:
            this.mTelecomManager.addNewIncomingCall(handle, extras);
            goto L7
        L23:
            this.mCallIds.put(Integer.valueOf(associationId), newCallIds);
        }

        Set<String> clearCallIdsForAssociationId(int associationId) {
            return this.mCallIds.remove(Integer.valueOf(associationId));
        }

        void addSelfOwnedCallId(String callId) {
            this.mSelfOwnedCalls.add(callId);
        }

        void removeSelfOwnedCallId(String callId) {
            this.mSelfOwnedCalls.remove(callId);
        }

        boolean isExternallyOwned(String callId) {
            return this.mExternallyOwnedCalls.contains(callId);
        }

        private boolean isSelfOwned(String currentCallId) {
            Iterator<String> r0 = this.mSelfOwnedCalls.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            String selfOwnedCallId = r0.next();
            if (currentCallId.endsWith(selfOwnedCallId) == false) goto L4;
            return true;
        L10:
            return false;
        }
    }

    static final class PhoneAccountHandleIdentifier {
        private final String mAppIdentifier;
        private final int mAssociationId;

        PhoneAccountHandleIdentifier(int associationId, String appIdentifier) {
            this.mAssociationId = associationId;
            this.mAppIdentifier = appIdentifier;
        }

        public int getAssociationId() {
            return this.mAssociationId;
        }

        public String getAppIdentifier() {
            return this.mAppIdentifier;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mAssociationId), this.mAppIdentifier});
        }

        public boolean equals(Object other) {
            if ((other instanceof PhoneAccountHandleIdentifier) == true) goto L5;
            return false;
        L5:
            if (((PhoneAccountHandleIdentifier) other).getAssociationId() == this.mAssociationId) goto L7;
            return false;
        L7:
            if (this.mAppIdentifier != null) goto L9;
            return false;
        L9:
            if (this.mAppIdentifier.equals(((PhoneAccountHandleIdentifier) other).getAppIdentifier()) == false) goto L16;
            return true;
        L16:
            return false;
        }
    }

    static class PhoneAccountManager {
        private final ComponentName mConnectionServiceComponentName;
        private final Map<PhoneAccountHandleIdentifier, PhoneAccountHandle> mPhoneAccountHandles;
        private final TelecomManager mTelecomManager;

        /* JADX INFO: renamed from: $r8$lambda$U45LhdqXcddw-6P8AxhBeL4zdLw, reason: not valid java name */
        public static /* synthetic */ boolean m2947$r8$lambda$U45LhdqXcddw6P8AxhBeL4zdLw(String r0, CallMetadataSyncData.CallFacilitator r1) {
            return lambda$updateFacilitators$0(r0, r1);
        }

        PhoneAccountManager(Context context) {
            this.mPhoneAccountHandles = new HashMap();
            this.mTelecomManager = (TelecomManager) context.getSystemService(TelecomManager.class);
            this.mConnectionServiceComponentName = new ComponentName(context, CallMetadataSyncConnectionService.class);
        }

        void onBootCompleted() {
            this.mTelecomManager.clearPhoneAccounts();
        }

        PhoneAccountHandle getPhoneAccountHandle(int associationId, String appIdentifier) {
            return this.mPhoneAccountHandles.get(new PhoneAccountHandleIdentifier(associationId, appIdentifier));
        }

        void updateFacilitators(int associationId, CallMetadataSyncData data) {
            ArrayList<CallMetadataSyncData.CallFacilitator> facilitators = new ArrayList();
            Iterator<CallMetadataSyncData.Call> r1 = data.getCalls().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            CallMetadataSyncData.Call call = r1.next();
            facilitators.add(call.getFacilitator());
            goto L4
        L6:
            facilitators.addAll(data.getFacilitators());
            updateFacilitators(associationId, facilitators);
        }

        private void updateFacilitators(int associationId, List<CallMetadataSyncData.CallFacilitator> facilitators) {
            Iterator<PhoneAccountHandleIdentifier> iterator = this.mPhoneAccountHandles.keySet().iterator();
        L4:
            if (iterator.hasNext() == false) goto L11;
            PhoneAccountHandleIdentifier handleIdentifier = iterator.next();
            final String handleAppIdentifier = handleIdentifier.getAppIdentifier();
            int handleAssociationId = handleIdentifier.getAssociationId();
            if (associationId != handleAssociationId) goto L4;
            if (facilitators.stream().noneMatch(new CrossDeviceSyncController$PhoneAccountManager$$ExternalSyntheticLambda0(handleAppIdentifier)) == false) goto L4;
            unregisterPhoneAccount(this.mPhoneAccountHandles.get(handleIdentifier));
            iterator.remove();
            goto L4
        L11:
            Iterator<CallMetadataSyncData.CallFacilitator> r1 = facilitators.iterator();
        L13:
            if (r1.hasNext() == false) goto L18;
            CallMetadataSyncData.CallFacilitator facilitator = r1.next();
            PhoneAccountHandleIdentifier phoneAccountHandleIdentifier = new PhoneAccountHandleIdentifier(associationId, facilitator.getIdentifier());
            if (this.mPhoneAccountHandles.containsKey(phoneAccountHandleIdentifier) == true) goto L13;
            registerPhoneAccount(phoneAccountHandleIdentifier, facilitator.getName(), facilitator.isTel());
            goto L13
        }

        private static /* synthetic */ boolean lambda$updateFacilitators$0(String handleAppIdentifier, CallMetadataSyncData.CallFacilitator facilitator) {
            if (handleAppIdentifier != null) goto L4;
        L6:
            return false;
        L4:
            if (handleAppIdentifier.equals(facilitator.getIdentifier()) == false) goto L6;
            return true;
        }

        private void registerPhoneAccount(PhoneAccountHandleIdentifier handleIdentifier, String humanReadableAppName, boolean isTel) {
            if (this.mPhoneAccountHandles.containsKey(handleIdentifier) == false) goto L5;
            return;
        L5:
            PhoneAccountHandle handle = new PhoneAccountHandle(this.mConnectionServiceComponentName, UUID.randomUUID().toString());
            this.mPhoneAccountHandles.put(handleIdentifier, handle);
            PhoneAccount phoneAccount = createPhoneAccount(handle, humanReadableAppName, handleIdentifier.getAppIdentifier(), handleIdentifier.getAssociationId(), isTel);
            this.mTelecomManager.registerPhoneAccount(phoneAccount);
            this.mTelecomManager.enablePhoneAccount(this.mPhoneAccountHandles.get(handleIdentifier), true);
        }

        private void unregisterPhoneAccount(PhoneAccountHandle phoneAccountHandle) {
            this.mTelecomManager.unregisterPhoneAccount(phoneAccountHandle);
        }

        static PhoneAccount createPhoneAccount(PhoneAccountHandle handle, String humanReadableAppName, String appIdentifier, int associationId, boolean isTel) {
            Bundle extras = new Bundle();
            extras.putString(CrossDeviceSyncController.EXTRA_CALL_FACILITATOR_ID, appIdentifier);
            extras.putInt(CrossDeviceSyncController.EXTRA_ASSOCIATION_ID, associationId);
            PhoneAccount.Builder r1 = new PhoneAccount.Builder(handle, humanReadableAppName).setExtras(extras);
            if (isTel == false) goto L5;
            String r2 = "tel";
        L7:
            return r1.setSupportedUriSchemes(List.of(r2)).setCapabilities(3).build();
        L5:
            r2 = "sip";
            goto L7
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBlocklist, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m2934$$Nest$fgetmBlocklist(CrossDeviceSyncController r0) {
        return r0.mBlocklist;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ CallManager m2935$$Nest$fgetmCallManager(CrossDeviceSyncController r0) {
        return r0.mCallManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectedAssociations, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2936$$Nest$fgetmConnectedAssociations(CrossDeviceSyncController r0) {
        return r0.mConnectedAssociations;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectionServiceCallbackRef, reason: not valid java name */
    static /* bridge */ /* synthetic */ WeakReference m2937$$Nest$fgetmConnectionServiceCallbackRef(CrossDeviceSyncController r0) {
        return r0.mConnectionServiceCallbackRef;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInCallServiceCallbackRef, reason: not valid java name */
    static /* bridge */ /* synthetic */ WeakReference m2938$$Nest$fgetmInCallServiceCallbackRef(CrossDeviceSyncController r0) {
        return r0.mInCallServiceCallbackRef;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPhoneAccountManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PhoneAccountManager m2939$$Nest$fgetmPhoneAccountManager(CrossDeviceSyncController r0) {
        return r0.mPhoneAccountManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmConnectionServiceCallbackRef, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2940$$Nest$fputmConnectionServiceCallbackRef(CrossDeviceSyncController r0, WeakReference r1) {
        r0.mConnectionServiceCallbackRef = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInCallServiceCallbackRef, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2941$$Nest$fputmInCallServiceCallbackRef(CrossDeviceSyncController r0, WeakReference r1) {
        r0.mInCallServiceCallbackRef = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mclearInProgressCalls, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2942$$Nest$mclearInProgressCalls(CrossDeviceSyncController r0, int r1) {
        r0.clearInProgressCalls(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateFacilitatorMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m2943$$Nest$mcreateFacilitatorMessage(CrossDeviceSyncController r0) {
        return r0.createFacilitatorMessage();
    }

    /* JADX INFO: renamed from: -$$Nest$misAssociationBlockedLocal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2944$$Nest$misAssociationBlockedLocal(CrossDeviceSyncController r0, int r1) {
        return r0.isAssociationBlockedLocal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mprocessCallCreateRequests, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2945$$Nest$mprocessCallCreateRequests(CrossDeviceSyncController r0, CallMetadataSyncData r1) {
        r0.processCallCreateRequests(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisAssociationBlocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2946$$Nest$smisAssociationBlocked(AssociationInfo r0) {
        return isAssociationBlocked(r0);
    }

    public CrossDeviceSyncController(Context context, CompanionTransportManager companionTransportManager) {
        this.mConnectedAssociations = new ArrayList();
        this.mBlocklist = new HashSet();
        this.mCallFacilitators = new ArrayList();
        this.mContext = context;
        this.mCompanionTransportManager = companionTransportManager;
        this.mCompanionTransportManager.addListener(new AnonymousClass1(this));
        this.mCompanionTransportManager.addListener(1667729539, new AnonymousClass2(this));
        this.mPhoneAccountManager = new PhoneAccountManager(this.mContext);
        this.mCallManager = new CallManager(this.mContext, this.mPhoneAccountManager);
    }

    private void clearInProgressCalls(int associationId) {
        Set<String> removedIds = this.mCallManager.clearCallIdsForAssociationId(associationId);
        if (this.mConnectionServiceCallbackRef == null) goto L5;
        CrossDeviceSyncControllerCallback connectionServiceCallback = this.mConnectionServiceCallbackRef.get();
    L6:
        if (connectionServiceCallback == null) goto L9;
        connectionServiceCallback.cleanUpCallIds(removedIds);
        return;
    L9:
        return;
    L5:
        connectionServiceCallback = null;
        goto L6
    }

    private static boolean isAssociationBlocked(AssociationInfo info) {
        if ((info.getSystemDataSyncFlags() & 1) != 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void onBootCompleted() {
        if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == true) goto L5;
        return;
    L5:
        this.mPhoneAccountManager.onBootCompleted();
        TelecomManager telecomManager = (TelecomManager) this.mContext.getSystemService(TelecomManager.class);
        if (telecomManager != null) goto L8;
        return;
    L8:
        if (telecomManager.getCallCapablePhoneAccounts().size() == 0) goto L16;
        PhoneAccountHandle defaultOutgoingTelAccountHandle = telecomManager.getDefaultOutgoingPhoneAccount("tel");
        if (defaultOutgoingTelAccountHandle == null) goto L17;
        PhoneAccount defaultOutgoingTelAccount = telecomManager.getPhoneAccount(defaultOutgoingTelAccountHandle);
        if (defaultOutgoingTelAccount == null) goto L18;
        this.mCallFacilitators.add(new CallMetadataSyncData.CallFacilitator(defaultOutgoingTelAccount.getLabel().toString(), "system", "system"));
        return;
    L18:
        return;
    L17:
        return;
    }

    private void processCallCreateRequests(CallMetadataSyncData callMetadataSyncData) {
        Iterator<CallMetadataSyncData.CallCreateRequest> iterator = callMetadataSyncData.getCallCreateRequests().iterator();
    L4:
        if (iterator.hasNext() == false) goto L14;
        CallMetadataSyncData.CallCreateRequest request = iterator.next();
        if ("system".equals(request.getFacilitator().getIdentifier()) == true) goto L8;
        Slog.e(TAG, "Non-system facilitated calls are not supported yet");
    L13:
        iterator.remove();
        goto L4
    L8:
        if (request.getAddress() == null) goto L13;
        if (request.getAddress().startsWith("tel") == false) goto L13;
        this.mCallManager.addSelfOwnedCallId(request.getId());
        Uri uri = Uri.fromParts("tel", request.getAddress().replaceAll("\\D+", ""), null);
        Bundle extras = new Bundle();
        extras.putString(EXTRA_CALL_ID, request.getId());
        Bundle outerExtras = new Bundle();
        outerExtras.putParcelable("android.telecom.extra.OUTGOING_CALL_EXTRAS", extras);
        ((TelecomManager) this.mContext.getSystemService(TelecomManager.class)).placeCall(uri, outerExtras);
        goto L13
    }

    private boolean isAssociationBlockedLocal(int associationId) {
        return this.mBlocklist.contains(Integer.valueOf(associationId));
    }

    public void registerCallMetadataSyncCallback(CrossDeviceSyncControllerCallback callback, int type) {
        if (type != 2) goto L13;
        this.mInCallServiceCallbackRef = new WeakReference(callback);
        Iterator<AssociationInfo> r0 = this.mConnectedAssociations.iterator();
    L6:
        if (r0.hasNext() == false) goto L24;
        AssociationInfo associationInfo = r0.next();
        if (isAssociationBlocked(associationInfo) == false) goto L9;
        this.mBlocklist.add(Integer.valueOf(associationInfo.getId()));
        goto L6
    L9:
        this.mBlocklist.remove(Integer.valueOf(associationInfo.getId()));
        callback.updateNumberOfActiveSyncAssociations(associationInfo.getUserId(), true);
        callback.requestCrossDeviceSync(associationInfo);
        goto L6
    L24:
        return;
    L13:
        if (type != 1) goto L15;
        this.mConnectionServiceCallbackRef = new WeakReference(callback);
        return;
    L15:
        Slog.e(TAG, "Cannot register callback of unknown type: " + type);
    }

    private boolean isAdminBlocked(int userId) {
        return ((DevicePolicyManager) this.mContext.getSystemService(DevicePolicyManager.class)).getBluetoothContactSharingDisabled(UserHandle.of(userId));
    }

    public void syncToAllDevicesForUserId(int userId, Collection<CrossDeviceCall> calls) {
        Set<Integer> associationIds = new HashSet();
        Iterator<AssociationInfo> r1 = this.mConnectedAssociations.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        AssociationInfo associationInfo = r1.next();
        if (associationInfo.getUserId() != userId) goto L4;
        if (isAssociationBlocked(associationInfo) == true) goto L4;
        associationIds.add(Integer.valueOf(associationInfo.getId()));
        goto L4
    L12:
        if (associationIds.isEmpty() == false) goto L15;
        Slog.w(TAG, "No eligible devices to sync to");
        return;
    L15:
        this.mCompanionTransportManager.sendMessage(1667729539, createCallUpdateMessage(calls, userId), associationIds.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray());
    }

    public void syncToSingleDevice(AssociationInfo associationInfo, Collection<CrossDeviceCall> calls) {
        if (isAssociationBlocked(associationInfo) == false) goto L6;
        Slog.e(TAG, "Cannot sync to requested device; connection is blocked");
        return;
    L6:
        this.mCompanionTransportManager.sendMessage(1667729539, createCallUpdateMessage(calls, associationInfo.getUserId()), new int[]{associationInfo.getId()});
    }

    public void syncMessageToDevice(int associationId, byte[] message) {
        if (isAssociationBlockedLocal(associationId) == false) goto L6;
        Slog.e(TAG, "Cannot sync to requested device; connection is blocked");
        return;
    L6:
        this.mCompanionTransportManager.sendMessage(1667729539, message, new int[]{associationId});
    }

    public void syncMessageToAllDevicesForUserId(int userId, byte[] message) {
        Set<Integer> associationIds = new HashSet();
        Iterator<AssociationInfo> r1 = this.mConnectedAssociations.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        AssociationInfo associationInfo = r1.next();
        if (associationInfo.getUserId() != userId) goto L4;
        if (isAssociationBlocked(associationInfo) == true) goto L4;
        associationIds.add(Integer.valueOf(associationInfo.getId()));
        goto L4
    L12:
        if (associationIds.isEmpty() == false) goto L15;
        Slog.w(TAG, "No eligible devices to sync to");
        return;
    L15:
        this.mCompanionTransportManager.sendMessage(1667729539, message, associationIds.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray());
    }

    public void addSelfOwnedCallId(String callId) {
        this.mCallManager.addSelfOwnedCallId(callId);
    }

    public void removeSelfOwnedCallId(String callId) {
        if (callId == null) goto L5;
        this.mCallManager.removeSelfOwnedCallId(callId);
        return;
    }

    CallMetadataSyncData processTelecomDataFromSync(byte[] data) {
        CallMetadataSyncData callMetadataSyncData = new CallMetadataSyncData();
        ProtoInputStream pis = new ProtoInputStream(data);
        int version = -1;
    L42:
        if (pis.nextField() == (-1)) goto L39;
        switch(pis.getFieldNumber()) {
            case 1: goto L36;
            case 4: goto L12;
            default: goto L8;
        };
    L12:
        if (version == 1) goto L13;
        Slog.e(TAG, "Cannot process unsupported version " + version);     // Catch: Throwable -> L9 Throwable -> L9
        goto L42
    L13:
        long telecomToken = pis.start(1146756268036L);     // Catch: Throwable -> L9 Throwable -> L9
    L15:
        if (pis.nextField() == (-1)) goto L34;
        if (pis.getFieldNumber() == 1) goto L18;
        if (pis.getFieldNumber() == 2) goto L21;
        if (pis.getFieldNumber() == 3) goto L32;
        Slog.e(TAG, "Unhandled field in Telecom:" + ProtoUtils.currentFieldToString(pis));     // Catch: Throwable -> L9 Throwable -> L9
        goto L15
    L32:
        long facilitatorsToken = pis.start(2246267895811L);     // Catch: Throwable -> L9 Throwable -> L9
        CallMetadataSyncData.CallFacilitator facilitator = processFacilitatorDataFromSync(pis);     // Catch: Throwable -> L9 Throwable -> L9
        facilitator.setIsTel(true);     // Catch: Throwable -> L9 Throwable -> L9
        callMetadataSyncData.addFacilitator(facilitator);     // Catch: Throwable -> L9 Throwable -> L9
        pis.end(facilitatorsToken);     // Catch: Throwable -> L9 Throwable -> L9
        goto L15
    L21:
        long requestsToken = pis.start(2246267895810L);     // Catch: Throwable -> L9 Throwable -> L9
    L23:
        if (pis.nextField() == (-1)) goto L29;
        switch(pis.getFieldNumber()) {
            case 1: goto L28;
            case 2: goto L27;
            default: goto L26;
        };     // Catch: Throwable -> L9 Throwable -> L9
    L27:
        long controlActionToken = pis.start(1146756268034L);     // Catch: Throwable -> L9 Throwable -> L9
        callMetadataSyncData.addCallControlRequest(processCallControlRequestDataFromSync(pis));     // Catch: Throwable -> L9 Throwable -> L9
        pis.end(controlActionToken);     // Catch: Throwable -> L9 Throwable -> L9
        goto L23
    L28:
        long createActionToken = pis.start(1146756268033L);     // Catch: Throwable -> L9 Throwable -> L9
        callMetadataSyncData.addCallCreateRequest(processCallCreateRequestDataFromSync(pis));     // Catch: Throwable -> L9 Throwable -> L9
        pis.end(createActionToken);     // Catch: Throwable -> L9 Throwable -> L9
        goto L23
    L26:
        Slog.e(TAG, "Unhandled field in Request:" + ProtoUtils.currentFieldToString(pis));     // Catch: Throwable -> L9 Throwable -> L9
        goto L23
    L29:
        pis.end(requestsToken);     // Catch: Throwable -> L9 Throwable -> L9
        goto L15
    L18:
        long callsToken = pis.start(2246267895809L);     // Catch: Throwable -> L9 Throwable -> L9
        callMetadataSyncData.addCall(processCallDataFromSync(pis));     // Catch: Throwable -> L9 Throwable -> L9
        pis.end(callsToken);     // Catch: Throwable -> L9 Throwable -> L9
        goto L15
    L34:
        pis.end(telecomToken);     // Catch: Throwable -> L9 Throwable -> L9
        goto L42
    L36:
        version = pis.readInt(1120986464257L);     // Catch: Throwable -> L9 Throwable -> L9
        Slog.e(TAG, "Processing context sync message version " + version);     // Catch: Throwable -> L9 Throwable -> L9
        goto L42
    L8:
        Slog.e(TAG, "Unhandled field in ContextSyncMessage:" + ProtoUtils.currentFieldToString(pis));     // Catch: Throwable -> L9 Throwable -> L9
        goto L42
    L39:
        return callMetadataSyncData;
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static CallMetadataSyncData.CallCreateRequest processCallCreateRequestDataFromSync(ProtoInputStream pis) throws IOException {
        CallMetadataSyncData.CallCreateRequest callCreateRequest = new CallMetadataSyncData.CallCreateRequest();
    L4:
        if (pis.nextField() == (-1)) goto L11;
        switch(pis.getFieldNumber()) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            default: goto L7;
        };
    L8:
        long facilitatorToken = pis.start(1146756268035L);
        callCreateRequest.setFacilitator(processFacilitatorDataFromSync(pis));
        pis.end(facilitatorToken);
        goto L4
    L9:
        callCreateRequest.setAddress(pis.readString(1138166333442L));
        goto L4
    L10:
        callCreateRequest.setId(pis.readString(1138166333441L));
        goto L4
    L7:
        Slog.e(TAG, "Unhandled field in CreateAction:" + ProtoUtils.currentFieldToString(pis));
        goto L4
    L11:
        return callCreateRequest;
    }

    public static CallMetadataSyncData.CallControlRequest processCallControlRequestDataFromSync(ProtoInputStream pis) throws IOException {
        CallMetadataSyncData.CallControlRequest callControlRequest = new CallMetadataSyncData.CallControlRequest();
    L4:
        if (pis.nextField() == (-1)) goto L10;
        switch(pis.getFieldNumber()) {
            case 1: goto L9;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        callControlRequest.setControl(pis.readInt(1159641169922L));
        goto L4
    L9:
        callControlRequest.setId(pis.readString(1138166333441L));
        goto L4
    L7:
        Slog.e(TAG, "Unhandled field in ControlAction:" + ProtoUtils.currentFieldToString(pis));
        goto L4
    L10:
        return callControlRequest;
    }

    public static CallMetadataSyncData.CallFacilitator processFacilitatorDataFromSync(ProtoInputStream pis) throws IOException {
        CallMetadataSyncData.CallFacilitator facilitator = new CallMetadataSyncData.CallFacilitator();
    L4:
        if (pis.nextField() == (-1)) goto L11;
        switch(pis.getFieldNumber()) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            default: goto L7;
        };
    L8:
        facilitator.setExtendedIdentifier(pis.readString(1138166333443L));
        goto L4
    L9:
        facilitator.setIdentifier(pis.readString(1138166333442L));
        goto L4
    L10:
        facilitator.setName(pis.readString(1138166333441L));
        goto L4
    L7:
        Slog.e(TAG, "Unhandled field in Facilitator:" + ProtoUtils.currentFieldToString(pis));
        goto L4
    L11:
        return facilitator;
    }

    CallMetadataSyncData.Call processCallDataFromSync(ProtoInputStream pis) throws IOException {
        CallMetadataSyncData.Call call = new CallMetadataSyncData.Call();
    L4:
        if (pis.nextField() == (-1)) goto L22;
        switch(pis.getFieldNumber()) {
            case 1: goto L21;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            default: goto L7;
        };
    L8:
        call.setDirection(pis.readInt(1159641169925L));
        goto L4
    L9:
        call.addControl(pis.readInt(2259152797700L));
        goto L4
    L10:
        call.setStatus(pis.readInt(1159641169923L));
        goto L4
    L11:
        long originToken = pis.start(1146756268034L);
    L13:
        if (pis.nextField() == (-1)) goto L20;
        switch(pis.getFieldNumber()) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            default: goto L16;
        };
    L17:
        long facilitatorToken = pis.start(1146756268035L);
        call.setFacilitator(processFacilitatorDataFromSync(pis));
        pis.end(facilitatorToken);
        goto L13
    L18:
        call.setAppIcon(pis.readBytes(1151051235330L));
        goto L13
    L19:
        call.setCallerId(pis.readString(1138166333441L));
        goto L13
    L16:
        Slog.e(TAG, "Unhandled field in Origin:" + ProtoUtils.currentFieldToString(pis));
        goto L13
    L20:
        pis.end(originToken);
        goto L4
    L21:
        call.setId(pis.readString(1138166333441L));
        goto L4
    L7:
        Slog.e(TAG, "Unhandled field in Telecom:" + ProtoUtils.currentFieldToString(pis));
        goto L4
    L22:
        return call;
    }

    byte[] createCallUpdateMessage(Collection<CrossDeviceCall> calls, int userId) {
        ProtoOutputStream pos = new ProtoOutputStream();
        pos.write(1120986464257L, 1);
        long telecomToken = pos.start(1146756268036L);
        Iterator<CrossDeviceCall> r4 = calls.iterator();
    L4:
        if (r4.hasNext() == false) goto L15;
        CrossDeviceCall call = r4.next();
        if (call.isCallPlacedByContextSync() == true) goto L4;
        if (this.mCallManager.isExternallyOwned(call.getId()) == true) goto L4;
        long callsToken = pos.start(2246267895809L);
        pos.write(1138166333441L, call.getId());
        long originToken = pos.start(1146756268034L);
        pos.write(1138166333441L, call.getReadableCallerId(isAdminBlocked(call.getUserId())));
        pos.write(1151051235330L, call.getCallingAppIcon());
        long facilitatorToken = pos.start(1146756268035L);
        pos.write(1138166333441L, call.getCallingAppName());
        pos.write(1138166333442L, call.getCallingAppPackageName());
        pos.write(1138166333443L, call.getSerializedPhoneAccountHandle());
        pos.end(facilitatorToken);
        pos.end(originToken);
        pos.write(1159641169923L, call.getStatus());
        pos.write(1159641169925L, call.getDirection());
        Iterator<Integer> r8 = call.getControls().iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        int control = r8.next().intValue();
        pos.write(2259152797700L, control);
        goto L12
    L14:
        pos.end(callsToken);
        goto L4
    L15:
        Iterator<CallMetadataSyncData.CallFacilitator> r5 = this.mCallFacilitators.iterator();
    L17:
        if (r5.hasNext() == false) goto L19;
        CallMetadataSyncData.CallFacilitator facilitator = r5.next();
        long facilitatorsToken = pos.start(2246267895811L);
        pos.write(1138166333441L, facilitator.getName());
        pos.write(1138166333442L, facilitator.getIdentifier());
        pos.write(1138166333443L, facilitator.getExtendedIdentifier());
        pos.end(facilitatorsToken);
        goto L17
    L19:
        pos.end(telecomToken);
        return pos.getBytes();
    }

    public static byte[] createCallControlMessage(String callId, int control) {
        ProtoOutputStream pos = new ProtoOutputStream();
        pos.write(1120986464257L, 1);
        long telecomToken = pos.start(1146756268036L);
        long requestsToken = pos.start(2246267895810L);
        long actionToken = pos.start(1146756268034L);
        pos.write(1138166333441L, callId);
        pos.write(1159641169922L, control);
        pos.end(actionToken);
        pos.end(requestsToken);
        pos.end(telecomToken);
        return pos.getBytes();
    }

    public static byte[] createCallCreateMessage(String id, String callAddress, String facilitatorIdentifier) {
        ProtoOutputStream pos = new ProtoOutputStream();
        pos.write(1120986464257L, 1);
        long telecomToken = pos.start(1146756268036L);
        long requestsToken = pos.start(2246267895810L);
        long actionToken = pos.start(1146756268033L);
        pos.write(1138166333441L, id);
        pos.write(1138166333442L, callAddress);
        long facilitatorToken = pos.start(1146756268035L);
        pos.write(1138166333442L, facilitatorIdentifier);
        pos.end(facilitatorToken);
        pos.end(actionToken);
        pos.end(requestsToken);
        pos.end(telecomToken);
        return pos.getBytes();
    }

    public static byte[] createEmptyMessage() {
        ProtoOutputStream pos = new ProtoOutputStream();
        pos.write(1120986464257L, 1);
        return pos.getBytes();
    }

    private byte[] createFacilitatorMessage() {
        return createCallUpdateMessage(Collections.emptyList(), -1);
    }
}
