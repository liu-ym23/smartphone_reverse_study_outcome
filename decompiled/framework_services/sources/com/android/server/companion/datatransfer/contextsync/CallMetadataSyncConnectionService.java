package com.android.server.companion.datatransfer.contextsync;

import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.telecom.ConnectionService;
import android.telecom.DisconnectCause;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.companion.CompanionDeviceManagerServiceInternal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CallMetadataSyncConnectionService extends ConnectionService {
    private static final String TAG = "CallMetadataSyncConnectionService";
    final Map<CallMetadataSyncConnectionIdentifier, CallMetadataSyncConnection> mActiveConnections;
    AudioManager mAudioManager;
    private CompanionDeviceManagerServiceInternal mCdmsi;
    final CrossDeviceSyncControllerCallback mCrossDeviceSyncControllerCallback;
    TelecomManager mTelecomManager;

    /* JADX INFO: renamed from: com.android.server.companion.datatransfer.contextsync.CallMetadataSyncConnectionService$1, reason: invalid class name */
    class AnonymousClass1 extends CrossDeviceSyncControllerCallback {
        final /* synthetic */ CallMetadataSyncConnectionService this$0;

        /* JADX INFO: renamed from: $r8$lambda$rEYQhX91L2tNvKjLo3-8qpufBYc, reason: not valid java name */
        public static /* synthetic */ boolean m2925$r8$lambda$rEYQhX91L2tNvKjLo38qpufBYc(Set r0, CallMetadataSyncConnection r1) {
            return lambda$cleanUpCallIds$1(r0, r1);
        }

        public static /* synthetic */ boolean $r8$lambda$tj50yy_A0UhnSALmCji8VWpPXWE(int r0, CallMetadataSyncData r1, CallMetadataSyncConnection r2) {
            return lambda$processContextSyncMessage$0(r0, r1, r2);
        }

        AnonymousClass1(CallMetadataSyncConnectionService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.companion.datatransfer.contextsync.CrossDeviceSyncControllerCallback
        void processContextSyncMessage(final int associationId, final CallMetadataSyncData callMetadataSyncData) {
            Iterator<CallMetadataSyncData.Call> r0 = callMetadataSyncData.getCalls().iterator();
        L4:
            if (r0.hasNext() == false) goto L22;
            CallMetadataSyncData.Call call = r0.next();
            CallMetadataSyncConnection existingConnection = this.this$0.mActiveConnections.get(new CallMetadataSyncConnectionIdentifier(associationId, call.getId()));
            if (existingConnection != null) goto L7;
            CallMetadataSyncConnectionIdentifier key = null;
            Iterator<Map.Entry<CallMetadataSyncConnectionIdentifier, CallMetadataSyncConnection>> r4 = this.this$0.mActiveConnections.entrySet().iterator();
        L10:
            if (r4.hasNext() == false) goto L19;
            Map.Entry<CallMetadataSyncConnectionIdentifier, CallMetadataSyncConnection> e = r4.next();
            if (e.getValue().getAssociationId() != associationId) goto L10;
            if (e.getValue().isIdFinalized() == true) goto L10;
            if (call.getId().endsWith(e.getValue().getCallId()) == false) goto L10;
            CallMetadataSyncConnectionIdentifier key2 = e.getKey();
            key = key2;
        L19:
            if (key == null) goto L4;
            CallMetadataSyncConnection connection = this.this$0.mActiveConnections.remove(key);
            CallMetadataSyncConnection.m2927$$Nest$mupdate(connection, call);
            this.this$0.mActiveConnections.put(new CallMetadataSyncConnectionIdentifier(associationId, call.getId()), connection);
            goto L4
        L7:
            CallMetadataSyncConnection.m2927$$Nest$mupdate(existingConnection, call);
            goto L4
        L22:
            this.this$0.mActiveConnections.values().removeIf(new CallMetadataSyncConnectionService$1$$ExternalSyntheticLambda1(associationId, callMetadataSyncData));
        }

        private static /* synthetic */ boolean lambda$processContextSyncMessage$0(int associationId, CallMetadataSyncData callMetadataSyncData, CallMetadataSyncConnection connection) {
            if (connection.isIdFinalized() == true) goto L5;
            return false;
        L5:
            if (associationId == connection.getAssociationId()) goto L7;
            return false;
        L7:
            if (callMetadataSyncData.hasCall(connection.getCallId()) == true) goto L13;
            connection.setDisconnected(new DisconnectCause(3));
            return true;
        L13:
            return false;
        }

        @Override // com.android.server.companion.datatransfer.contextsync.CrossDeviceSyncControllerCallback
        void cleanUpCallIds(final Set<String> callIds) {
            this.this$0.mActiveConnections.values().removeIf(new CallMetadataSyncConnectionService$1$$ExternalSyntheticLambda0(callIds));
        }

        private static /* synthetic */ boolean lambda$cleanUpCallIds$1(Set callIds, CallMetadataSyncConnection connection) {
            if (callIds.contains(connection.getCallId()) == false) goto L6;
            connection.setDisconnected(new DisconnectCause(3));
            return true;
        L6:
            return false;
        }
    }

    static class CallMetadataSyncConnection extends Connection {
        private final int mAssociationId;
        private final AudioManager mAudioManager;
        private final CallMetadataSyncData.Call mCall;
        private final CallMetadataSyncConnectionCallback mCallback;
        private boolean mIsIdFinalized;
        private final TelecomManager mTelecomManager;

        /* JADX INFO: renamed from: -$$Nest$minitialize, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2926$$Nest$minitialize(CallMetadataSyncConnection r0) {
            r0.initialize();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdate, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2927$$Nest$mupdate(CallMetadataSyncConnection r0, CallMetadataSyncData.Call r1) {
            r0.update(r1);
        }

        CallMetadataSyncConnection(TelecomManager telecomManager, AudioManager audioManager, int associationId, CallMetadataSyncData.Call call, CallMetadataSyncConnectionCallback callback) {
            this.mTelecomManager = telecomManager;
            this.mAudioManager = audioManager;
            this.mAssociationId = associationId;
            this.mCall = call;
            this.mCallback = callback;
        }

        public String getCallId() {
            return this.mCall.getId();
        }

        public int getAssociationId() {
            return this.mAssociationId;
        }

        public boolean isIdFinalized() {
            return this.mIsIdFinalized;
        }

        private void initialize() {
            int status = this.mCall.getStatus();
            if (status != 4) goto L5;
            this.mTelecomManager.silenceRinger();
        L5:
            int state = CrossDeviceCall.convertStatusToState(status);
            if (state != 2) goto L8;
            setRinging();
        L18:
            String callerId = this.mCall.getCallerId();
            if (callerId == null) goto L21;
            setCallerDisplayName(callerId, 1);
            setAddress(Uri.fromParts("custom", this.mCall.getCallerId(), null), 1);
        L21:
            Bundle extras = new Bundle();
            extras.putString(CrossDeviceSyncController.EXTRA_CALL_ID, this.mCall.getId());
            putExtras(extras);
            int capabilities = getConnectionCapabilities();
            if (this.mCall.hasControl(7) == false) goto L24;
            int capabilities2 = capabilities | 1;
        L26:
            if (this.mCall.hasControl(4) == false) goto L28;
            int capabilities3 = capabilities2 | 64;
        L29:
            this.mAudioManager.setMicrophoneMute(this.mCall.hasControl(5));
            if (capabilities3 == getConnectionCapabilities()) goto L33;
            setConnectionCapabilities(capabilities3);
            return;
        L33:
            return;
        L28:
            capabilities3 = capabilities2 & (-65);
            goto L29
        L24:
            capabilities2 = capabilities & (-2);
            goto L26
        L8:
            if (state != 4) goto L11;
            setActive();
            goto L18
        L11:
            if (state != 3) goto L13;
            setOnHold();
            goto L18
        L13:
            if (state != 7) goto L15;
            setDisconnected(new DisconnectCause(3));
            goto L18
        L15:
            if (state != 1) goto L17;
            setDialing();
            goto L18
        L17:
            setInitialized();
            goto L18
        }

        private void update(CallMetadataSyncData.Call call) {
            boolean hasMuteControl = true;
            if (this.mIsIdFinalized == true) goto L5;
            this.mCall.setId(call.getId());
            this.mIsIdFinalized = true;
        L5:
            int status = call.getStatus();
            if (status == 4) goto L8;
        L10:
            this.mCall.setStatus(status);
            int state = CrossDeviceCall.convertStatusToState(status);
            if (state != getState()) goto L13;
        L25:
            int capabilities = getConnectionCapabilities();
            this.mCall.setControls(call.getControls());
            if (this.mCall.hasControl(7) == false) goto L28;
        L31:
            boolean hasHoldControl = true;
        L33:
            if (hasHoldControl == false) goto L35;
            int capabilities2 = capabilities | 1;
        L37:
            if (this.mCall.hasControl(4) == false) goto L39;
        L44:
            if (hasMuteControl == false) goto L46;
            int capabilities3 = capabilities2 | 64;
        L47:
            this.mAudioManager.setMicrophoneMute(this.mCall.hasControl(5));
            if (capabilities3 == getConnectionCapabilities()) goto L51;
            setConnectionCapabilities(capabilities3);
            return;
        L51:
            return;
        L46:
            capabilities3 = capabilities2 & (-65);
            goto L47
        L39:
            if (this.mCall.hasControl(5) == true) goto L44;
            hasMuteControl = false;
            goto L44
        L35:
            capabilities2 = capabilities & (-2);
            goto L37
        L28:
            if (this.mCall.hasControl(8) == true) goto L31;
            hasHoldControl = false;
            goto L33
        L13:
            if (state != 2) goto L15;
            setRinging();
            goto L25
        L15:
            if (state != 4) goto L18;
            setActive();
            goto L25
        L18:
            if (state != 3) goto L20;
            setOnHold();
            goto L25
        L20:
            if (state != 7) goto L22;
            setDisconnected(new DisconnectCause(3));
            goto L25
        L22:
            if (state != 1) goto L24;
            setDialing();
            goto L25
        L24:
            Slog.e(CallMetadataSyncConnectionService.TAG, "Could not update call to unknown state");
            goto L25
        L8:
            if (this.mCall.getStatus() == 4) goto L10;
            this.mTelecomManager.silenceRinger();
            goto L10
        }

        @Override // android.telecom.Connection
        public void onAnswer(int videoState) {
            sendCallAction(1);
        }

        @Override // android.telecom.Connection
        public void onReject() {
            sendCallAction(2);
        }

        @Override // android.telecom.Connection
        public void onReject(int rejectReason) {
            onReject();
        }

        @Override // android.telecom.Connection
        public void onReject(String replyMessage) {
            onReject();
        }

        @Override // android.telecom.Connection
        public void onSilence() {
            sendCallAction(3);
        }

        @Override // android.telecom.Connection
        public void onHold() {
            sendCallAction(7);
        }

        @Override // android.telecom.Connection
        public void onUnhold() {
            sendCallAction(8);
        }

        @Override // android.telecom.Connection
        public void onMuteStateChanged(boolean isMuted) {
            if (isMuted == false) goto L4;
            int r0 = 4;
        L5:
            sendCallAction(r0);
            return;
        L4:
            r0 = 5;
            goto L5
        }

        @Override // android.telecom.Connection
        public void onDisconnect() {
            sendCallAction(6);
        }

        private void sendCallAction(int action) {
            this.mCallback.sendCallAction(this.mAssociationId, this.mCall.getId(), action);
        }
    }

    static abstract class CallMetadataSyncConnectionCallback {
        abstract void sendCallAction(int r1, String r2, int r3);

        CallMetadataSyncConnectionCallback() {
        }
    }

    static final class CallMetadataSyncConnectionIdentifier {
        private final int mAssociationId;
        private final String mCallId;

        CallMetadataSyncConnectionIdentifier(int associationId, String callId) {
            this.mAssociationId = associationId;
            this.mCallId = callId;
        }

        public int getAssociationId() {
            return this.mAssociationId;
        }

        public String getCallId() {
            return this.mCallId;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mAssociationId), this.mCallId});
        }

        public boolean equals(Object other) {
            if ((other instanceof CallMetadataSyncConnectionIdentifier) == true) goto L5;
            return false;
        L5:
            if (((CallMetadataSyncConnectionIdentifier) other).getAssociationId() == this.mAssociationId) goto L7;
            return false;
        L7:
            if (this.mCallId != null) goto L9;
            return false;
        L9:
            if (this.mCallId.equals(((CallMetadataSyncConnectionIdentifier) other).getCallId()) == false) goto L16;
            return true;
        L16:
            return false;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCdmsi, reason: not valid java name */
    static /* bridge */ /* synthetic */ CompanionDeviceManagerServiceInternal m2924$$Nest$fgetmCdmsi(CallMetadataSyncConnectionService r0) {
        return r0.mCdmsi;
    }

    public CallMetadataSyncConnectionService() {
        this.mActiveConnections = new HashMap();
        this.mCrossDeviceSyncControllerCallback = new AnonymousClass1(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mAudioManager = (AudioManager) getSystemService(AudioManager.class);
        this.mTelecomManager = (TelecomManager) getSystemService(TelecomManager.class);
        this.mCdmsi = (CompanionDeviceManagerServiceInternal) LocalServices.getService(CompanionDeviceManagerServiceInternal.class);
        this.mCdmsi.registerCallMetadataSyncCallback(this.mCrossDeviceSyncControllerCallback, 1);
    }

    @Override // android.telecom.ConnectionService
    public Connection onCreateIncomingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        int associationId = connectionRequest.getExtras().getInt("com.android.server.companion.datatransfer.contextsync.extra.ASSOCIATION_ID");
        CallMetadataSyncData.Call call = CallMetadataSyncData.Call.fromBundle(connectionRequest.getExtras().getBundle("com.android.server.companion.datatransfer.contextsync.extra.CALL"));
        call.setDirection(1);
        connectionRequest.getExtras().remove("com.android.server.companion.datatransfer.contextsync.extra.CALL");
        connectionRequest.getExtras().remove("com.android.server.companion.datatransfer.contextsync.extra.CALL_FACILITATOR_ID");
        connectionRequest.getExtras().remove("com.android.server.companion.datatransfer.contextsync.extra.ASSOCIATION_ID");
        CallMetadataSyncConnection connection = new CallMetadataSyncConnection(this.mTelecomManager, this.mAudioManager, associationId, call, new AnonymousClass2(this));
        connection.setConnectionProperties(16);
        connection.setInitializing();
        return connection;
    }

    @Override // android.telecom.ConnectionService
    public void onCreateIncomingConnectionFailed(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        if (phoneAccountHandle == null) goto L4;
        String id = phoneAccountHandle.getId();
    L5:
        Slog.e(TAG, "onCreateOutgoingConnectionFailed for: " + id);
        return;
    L4:
        id = "unknown PhoneAccount";
        goto L5
    }

    @Override // android.telecom.ConnectionService
    public Connection onCreateOutgoingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        if (phoneAccountHandle == null) goto L4;
        PhoneAccountHandle handle = phoneAccountHandle;
    L5:
        PhoneAccount phoneAccount = this.mTelecomManager.getPhoneAccount(handle);
        CallMetadataSyncData.Call call = new CallMetadataSyncData.Call();
        call.setId(connectionRequest.getExtras().getString(CrossDeviceSyncController.EXTRA_CALL_ID));
        call.setStatus(0);
        if (phoneAccount == null) goto L8;
        String r3 = phoneAccount.getLabel().toString();
    L10:
        if (phoneAccount == null) goto L12;
        String r5 = phoneAccount.getExtras().getString("com.android.server.companion.datatransfer.contextsync.extra.CALL_FACILITATOR_ID");
    L13:
        CallMetadataSyncData.CallFacilitator callFacilitator = new CallMetadataSyncData.CallFacilitator(r3, r5, handle.getComponentName().flattenToString());
        call.setFacilitator(callFacilitator);
        call.setDirection(2);
        call.setCallerId(connectionRequest.getAddress().getSchemeSpecificPart());
        int associationId = phoneAccount.getExtras().getInt("com.android.server.companion.datatransfer.contextsync.extra.ASSOCIATION_ID");
        connectionRequest.getExtras().remove("com.android.server.companion.datatransfer.contextsync.extra.CALL");
        connectionRequest.getExtras().remove("com.android.server.companion.datatransfer.contextsync.extra.CALL_FACILITATOR_ID");
        connectionRequest.getExtras().remove("com.android.server.companion.datatransfer.contextsync.extra.ASSOCIATION_ID");
        CallMetadataSyncConnection connection = new CallMetadataSyncConnection(this.mTelecomManager, this.mAudioManager, associationId, call, new AnonymousClass3(this));
        connection.setCallerDisplayName(call.getCallerId(), 1);
        this.mCdmsi.addSelfOwnedCallId(call.getId());
        this.mCdmsi.sendCrossDeviceSyncMessage(associationId, CrossDeviceSyncController.createCallCreateMessage(call.getId(), connectionRequest.getAddress().toString(), call.getFacilitator().getIdentifier()));
        connection.setInitializing();
        return connection;
    L12:
        r5 = handle.getComponentName().getPackageName();
        goto L13
    L8:
        r3 = handle.getComponentName().getShortClassName();
        goto L10
    L4:
        handle = connectionRequest.getAccountHandle();
        goto L5
    }

    @Override // android.telecom.ConnectionService
    public void onCreateOutgoingConnectionFailed(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        if (phoneAccountHandle == null) goto L4;
        String id = phoneAccountHandle.getId();
    L5:
        Slog.e(TAG, "onCreateOutgoingConnectionFailed for: " + id);
        return;
    L4:
        id = "unknown PhoneAccount";
        goto L5
    }

    public void onCreateConnectionComplete(Connection connection) {
        if ((connection instanceof CallMetadataSyncConnection) == false) goto L6;
        CallMetadataSyncConnection callMetadataSyncConnection = (CallMetadataSyncConnection) connection;
        CallMetadataSyncConnection.m2926$$Nest$minitialize(callMetadataSyncConnection);
        this.mActiveConnections.put(new CallMetadataSyncConnectionIdentifier(callMetadataSyncConnection.getAssociationId(), callMetadataSyncConnection.getCallId()), callMetadataSyncConnection);
        return;
    }
}
