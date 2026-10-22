package com.android.server.dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public class SystemVolumeUpdateDispatcher extends AbsDispatcher<SystemVolumeUpdateObserver> {
    private static final AbsDispatcher.Lazy<SystemVolumeUpdateDispatcher> INSTANCE = null;
    public static final String TAG = "GameAssist.SystemVolumeUpdateDispatcher";

    public static /* synthetic */ void $r8$lambda$8ooXFmFxMhBbcBlj_dY5eDMfZe4(SystemVolumeUpdateDispatcher r0, int r1, int r2, int r3, String r4) {
        r0.lambda$notifyVolumeUpdated$0(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$Ac7lhWPPeGPl1EqJ6UM2jI2hO4g(int r0, int r1, int r2, String r3, SystemVolumeUpdateObserver r4) {
        lambda$notifyVolumeUpdated$1(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$MQO73kHft-n5FyjCtLsqhjZs-DI, reason: not valid java name */
    public static /* synthetic */ SystemVolumeUpdateDispatcher m3556$r8$lambda$MQO73kHftn5FyjCtLsqhjZsDI() {
        return new SystemVolumeUpdateDispatcher();
    }

    static {
        INSTANCE = new AbsDispatcher.Lazy(new SystemVolumeUpdateDispatcher$$ExternalSyntheticLambda0());
    }

    private SystemVolumeUpdateDispatcher() {
    }

    public static SystemVolumeUpdateDispatcher getInstance() {
        return (SystemVolumeUpdateDispatcher) INSTANCE.get();
    }

    private /* synthetic */ void lambda$notifyVolumeUpdated$0(int streamType, int index, int device, String caller) {
        notifyVolumeUpdated(streamType, index, device, caller);
    }

    public void notifyVolumeUpdated(final int streamType, final int index, final int device, final String caller) {
        if (switchThreads(new SystemVolumeUpdateDispatcher$$ExternalSyntheticLambda1(this, streamType, index, device, caller)) == false) goto L5;
        return;
    L5:
        notifyObserver(new SystemVolumeUpdateDispatcher$$ExternalSyntheticLambda2(streamType, index, device, caller));
    }

    private static /* synthetic */ void lambda$notifyVolumeUpdated$1(int streamType, int index, int device, String caller, SystemVolumeUpdateObserver observer) {
        observer.onVolumeUpdated(streamType, index, device, caller);
    }
}
