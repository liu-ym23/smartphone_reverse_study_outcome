package com.android.server.companion.datatransfer.contextsync;

import android.companion.AssociationInfo;
import android.telecom.Call;
import android.telecom.InCallService;
import android.telecom.TelecomManager;
import com.android.server.LocalServices;
import com.android.server.companion.CompanionDeviceConfig;
import com.android.server.companion.CompanionDeviceManagerServiceInternal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class CallMetadataSyncInCallService extends InCallService {
    private static final String TAG = "CallMetadataIcs";
    private CompanionDeviceManagerServiceInternal mCdmsi;
    final CrossDeviceSyncControllerCallback mCrossDeviceSyncControllerCallback;
    final Map<Call, CrossDeviceCall> mCurrentCalls;
    int mNumberOfActiveSyncAssociations;
    final Call.Callback mTelecomCallback;

    public static /* synthetic */ void $r8$lambda$11nkymNg0jmMhUFoweHkcVIoht0(CallMetadataSyncInCallService r0, Call r1) {
        r0.lambda$initializeCalls$2(r1);
    }

    public static /* synthetic */ CrossDeviceCall $r8$lambda$Kh_TmD3nr5AK1Sc_BRzZim7OXuE(CallMetadataSyncInCallService r0, Call r1) {
        return r0.lambda$initializeCalls$1(r1);
    }

    public static /* synthetic */ Call $r8$lambda$zAFgR1GNEGdXdpHNTe_Z5WEVJ_s(Call r0) {
        return lambda$initializeCalls$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$mdoMute, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2928$$Nest$mdoMute(CallMetadataSyncInCallService r0) {
        r0.doMute();
    }

    /* JADX INFO: renamed from: -$$Nest$mdoSilence, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2929$$Nest$mdoSilence(CallMetadataSyncInCallService r0) {
        r0.doSilence();
    }

    /* JADX INFO: renamed from: -$$Nest$mdoUnmute, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2930$$Nest$mdoUnmute(CallMetadataSyncInCallService r0) {
        r0.doUnmute();
    }

    /* JADX INFO: renamed from: -$$Nest$minitializeCalls, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2931$$Nest$minitializeCalls(CallMetadataSyncInCallService r0) {
        r0.initializeCalls();
    }

    /* JADX INFO: renamed from: -$$Nest$msync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2932$$Nest$msync(CallMetadataSyncInCallService r0, int r1) {
        r0.sync(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2933$$Nest$msync(CallMetadataSyncInCallService r0, AssociationInfo r1) {
        r0.sync(r1);
    }

    public CallMetadataSyncInCallService() {
        this.mCurrentCalls = new HashMap();
        this.mTelecomCallback = new AnonymousClass1(this);
        this.mCrossDeviceSyncControllerCallback = new AnonymousClass2(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == false) goto L6;
        this.mCdmsi = (CompanionDeviceManagerServiceInternal) LocalServices.getService(CompanionDeviceManagerServiceInternal.class);
        this.mCdmsi.registerCallMetadataSyncCallback(this.mCrossDeviceSyncControllerCallback, 2);
        return;
    }

    private void initializeCalls() {
        if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == true) goto L5;
        return;
    L5:
        if (this.mNumberOfActiveSyncAssociations <= 0) goto L9;
        this.mCurrentCalls.putAll((Map) getCalls().stream().collect(Collectors.toMap(new CallMetadataSyncInCallService$$ExternalSyntheticLambda0(), new CallMetadataSyncInCallService$$ExternalSyntheticLambda1(this))));
        this.mCurrentCalls.keySet().forEach(new CallMetadataSyncInCallService$$ExternalSyntheticLambda2(this));
        sync(getUserId());
        return;
    }

    private static /* synthetic */ Call lambda$initializeCalls$0(Call call) {
        return call;
    }

    private /* synthetic */ CrossDeviceCall lambda$initializeCalls$1(Call call) {
        return new CrossDeviceCall(this, call, getCallAudioState());
    }

    private /* synthetic */ void lambda$initializeCalls$2(Call call) {
        call.registerCallback(this.mTelecomCallback, getMainThreadHandler());
    }

    CrossDeviceCall getCallForId(String crossDeviceCallId, Collection<CrossDeviceCall> calls) {
        if (crossDeviceCallId != null) goto L5;
        return null;
    L5:
        Iterator<CrossDeviceCall> r1 = calls.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        CrossDeviceCall crossDeviceCall = r1.next();
        if (crossDeviceCallId.equals(crossDeviceCall.getId()) == false) goto L7;
        return crossDeviceCall;
    L12:
        return null;
    }

    @Override // android.telecom.InCallService
    public void onCallAdded(Call call) {
        if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == true) goto L5;
        return;
    L5:
        if (this.mNumberOfActiveSyncAssociations <= 0) goto L9;
        this.mCurrentCalls.put(call, new CrossDeviceCall(this, call, getCallAudioState()));
        call.registerCallback(this.mTelecomCallback);
        sync(getUserId());
        return;
    }

    @Override // android.telecom.InCallService
    public void onCallRemoved(Call call) {
        if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == true) goto L5;
        return;
    L5:
        if (this.mNumberOfActiveSyncAssociations <= 0) goto L9;
        this.mCurrentCalls.remove(call);
        call.unregisterCallback(this.mTelecomCallback);
        this.mCdmsi.removeSelfOwnedCallId(call.getDetails().getExtras().getString(CrossDeviceSyncController.EXTRA_CALL_ID));
        sync(getUserId());
        return;
    }

    @Override // android.telecom.InCallService
    public void onMuteStateChanged(boolean isMuted) {
        if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == true) goto L5;
        return;
    L5:
        if (this.mNumberOfActiveSyncAssociations <= 0) goto L13;
        CompanionDeviceManagerServiceInternal r0 = this.mCdmsi;
        int r1 = getUserId();
        if (isMuted == false) goto L9;
        int r2 = 4;
    L10:
        r0.sendCrossDeviceSyncMessageToAllDevices(r1, CrossDeviceSyncController.createCallControlMessage(null, r2));
        return;
    L9:
        r2 = 5;
        goto L10
    }

    @Override // android.telecom.InCallService
    public void onSilenceRinger() {
        if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == true) goto L5;
        return;
    L5:
        if (this.mNumberOfActiveSyncAssociations <= 0) goto L9;
        this.mCdmsi.sendCrossDeviceSyncMessageToAllDevices(getUserId(), CrossDeviceSyncController.createCallControlMessage(null, 3));
        return;
    }

    private void doMute() {
        setMuted(true);
    }

    private void doUnmute() {
        setMuted(false);
    }

    private void doSilence() {
        TelecomManager telecomManager = (TelecomManager) getSystemService(TelecomManager.class);
        if (telecomManager == null) goto L6;
        telecomManager.silenceRinger();
        return;
    }

    private void sync(int userId) {
        this.mCdmsi.crossDeviceSync(userId, this.mCurrentCalls.values());
    }

    private void sync(AssociationInfo associationInfo) {
        this.mCdmsi.crossDeviceSync(associationInfo, this.mCurrentCalls.values());
    }
}
