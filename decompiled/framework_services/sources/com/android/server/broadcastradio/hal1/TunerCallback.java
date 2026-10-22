package com.android.server.broadcastradio.hal1;

import android.hardware.radio.ITunerCallback;
import android.hardware.radio.ProgramList;
import android.hardware.radio.ProgramSelector;
import android.hardware.radio.RadioManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.server.utils.Slogf;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
class TunerCallback implements ITunerCallback {
    private static final String TAG = "BcRadio1Srv.TunerCallback";
    private final ITunerCallback mClientCallback;
    private boolean mInitialConfigurationDone;
    private final long mNativeContext;
    private final AtomicReference<ProgramList.Filter> mProgramListFilter;
    private final Tuner mTuner;

    private interface RunnableThrowingRemoteException {
        void run() throws RemoteException;
    }

    /* JADX INFO: renamed from: $r8$lambda$BEptR6OfHvcr-ORNAWuoOHPaBYQ, reason: not valid java name */
    public static /* synthetic */ void m2816$r8$lambda$BEptR6OfHvcrORNAWuoOHPaBYQ(TunerCallback r0) {
        r0.lambda$onProgramListChanged$8();
    }

    public static /* synthetic */ void $r8$lambda$E0zIG4Yw6pVtOAUFhN10ADcHMg0(TunerCallback r0, ProgramList.Chunk r1) {
        r0.lambda$onProgramListUpdated$10(r1);
    }

    public static /* synthetic */ void $r8$lambda$GpS0DDBRZs8St4BUdrloZS5ADIY(TunerCallback r0, RadioManager.BandConfig r1) {
        r0.lambda$onConfigurationChanged$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$JFrVoDQSYhRyL7AMNscRU2QYC5U(TunerCallback r0, boolean r1) {
        r0.lambda$onBackgroundScanAvailabilityChange$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$QXMXSR80L_3Yq4FgVGqGIEyMBpk(TunerCallback r0, boolean r1) {
        r0.lambda$onTrafficAnnouncement$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$QdCP8aweSlGbKZnceCvrJYjqp00(TunerCallback r0, boolean r1) {
        r0.lambda$onAntennaState$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Y__o-kylXH4xI41YLcjSY_qMj4c, reason: not valid java name */
    public static /* synthetic */ void m2817$r8$lambda$Y__okylXH4xI41YLcjSY_qMj4c(TunerCallback r0, boolean r1) {
        r0.lambda$onEmergencyAnnouncement$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$ffad22RVDIzXrp0J12JT5_sibF4(TunerCallback r0, ProgramList.Chunk r1) {
        r0.lambda$sendProgramListUpdate$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$uhb23Z6eMUN461SVGkGeC_z2I30(TunerCallback r0, RadioManager.ProgramInfo r1) {
        r0.lambda$onCurrentProgramInfoChanged$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$yxysqaLIXGY5VYpoZNA5pJTjGcQ(TunerCallback r0) {
        r0.lambda$onBackgroundScanComplete$7();
    }

    public static /* synthetic */ void $r8$lambda$zrOP4JTsuGfQjOvnAINHHxFqfIY(TunerCallback r0, int r1) {
        r0.lambda$onError$0(r1);
    }

    private native void nativeDetach(long r1);

    private native void nativeFinalize(long r1);

    private native long nativeInit(Tuner r1, int r2);

    TunerCallback(Tuner tuner, ITunerCallback clientCallback, int halRev) {
        this.mProgramListFilter = new AtomicReference();
        this.mInitialConfigurationDone = false;
        this.mTuner = tuner;
        this.mClientCallback = clientCallback;
        this.mNativeContext = nativeInit(tuner, halRev);
    }

    protected void finalize() throws Throwable {
        nativeFinalize(this.mNativeContext);
        super.finalize();
    }

    public void detach() {
        nativeDetach(this.mNativeContext);
    }

    private void dispatch(RunnableThrowingRemoteException func) {
        func.run();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slogf.e(TAG, "client died", e);
    }

    private void handleHwFailure() {
        onError(0);
        this.mTuner.close();
    }

    void startProgramListUpdates(ProgramList.Filter filter) {
        if (filter != null) goto L4;
        filter = new ProgramList.Filter();
    L4:
        this.mProgramListFilter.set(filter);
        sendProgramListUpdate();
    }

    void stopProgramListUpdates() {
        this.mProgramListFilter.set(null);
    }

    boolean isInitialConfigurationDone() {
        return this.mInitialConfigurationDone;
    }

    private /* synthetic */ void lambda$onError$0(int status) throws RemoteException {
        this.mClientCallback.onError(status);
    }

    public void onError(final int status) {
        dispatch(new TunerCallback$$ExternalSyntheticLambda9(this, status));
    }

    public void onTuneFailed(int result, ProgramSelector selector) {
        Slogf.e(TAG, "Not applicable for HAL 1.x");
    }

    public void onConfigurationChanged(final RadioManager.BandConfig config) {
        this.mInitialConfigurationDone = true;
        dispatch(new TunerCallback$$ExternalSyntheticLambda5(this, config));
    }

    private /* synthetic */ void lambda$onConfigurationChanged$1(RadioManager.BandConfig config) throws RemoteException {
        this.mClientCallback.onConfigurationChanged(config);
    }

    private /* synthetic */ void lambda$onCurrentProgramInfoChanged$2(RadioManager.ProgramInfo info) throws RemoteException {
        this.mClientCallback.onCurrentProgramInfoChanged(info);
    }

    public void onCurrentProgramInfoChanged(final RadioManager.ProgramInfo info) {
        dispatch(new TunerCallback$$ExternalSyntheticLambda7(this, info));
    }

    private /* synthetic */ void lambda$onTrafficAnnouncement$3(boolean active) throws RemoteException {
        this.mClientCallback.onTrafficAnnouncement(active);
    }

    public void onTrafficAnnouncement(final boolean active) {
        dispatch(new TunerCallback$$ExternalSyntheticLambda6(this, active));
    }

    private /* synthetic */ void lambda$onEmergencyAnnouncement$4(boolean active) throws RemoteException {
        this.mClientCallback.onEmergencyAnnouncement(active);
    }

    public void onEmergencyAnnouncement(final boolean active) {
        dispatch(new TunerCallback$$ExternalSyntheticLambda3(this, active));
    }

    private /* synthetic */ void lambda$onAntennaState$5(boolean connected) throws RemoteException {
        this.mClientCallback.onAntennaState(connected);
    }

    public void onAntennaState(final boolean connected) {
        dispatch(new TunerCallback$$ExternalSyntheticLambda4(this, connected));
    }

    private /* synthetic */ void lambda$onBackgroundScanAvailabilityChange$6(boolean isAvailable) throws RemoteException {
        this.mClientCallback.onBackgroundScanAvailabilityChange(isAvailable);
    }

    public void onBackgroundScanAvailabilityChange(final boolean isAvailable) {
        dispatch(new TunerCallback$$ExternalSyntheticLambda1(this, isAvailable));
    }

    private /* synthetic */ void lambda$onBackgroundScanComplete$7() throws RemoteException {
        this.mClientCallback.onBackgroundScanComplete();
    }

    public void onBackgroundScanComplete() {
        dispatch(new TunerCallback$$ExternalSyntheticLambda10(this));
    }

    private /* synthetic */ void lambda$onProgramListChanged$8() throws RemoteException {
        this.mClientCallback.onProgramListChanged();
    }

    public void onProgramListChanged() {
        dispatch(new TunerCallback$$ExternalSyntheticLambda2(this));
        sendProgramListUpdate();
    }

    private void sendProgramListUpdate() {
        ProgramList.Filter filter = this.mProgramListFilter.get();
        if (filter != null) goto L11;
        return;
    L11:
        List<RadioManager.ProgramInfo> modified = this.mTuner.getProgramList(filter.getVendorFilter());     // Catch: IllegalStateException -> L8
        Set<RadioManager.ProgramInfo> modifiedSet = (Set) modified.stream().collect(Collectors.toSet());
        final ProgramList.Chunk chunk = new ProgramList.Chunk(true, true, modifiedSet, null);
        dispatch(new TunerCallback$$ExternalSyntheticLambda0(this, chunk));
        return;
    L9:
        Slogf.d(TAG, "Program list not ready yet");
    }

    private /* synthetic */ void lambda$sendProgramListUpdate$9(ProgramList.Chunk chunk) throws RemoteException {
        this.mClientCallback.onProgramListUpdated(chunk);
    }

    private /* synthetic */ void lambda$onProgramListUpdated$10(ProgramList.Chunk chunk) throws RemoteException {
        this.mClientCallback.onProgramListUpdated(chunk);
    }

    public void onProgramListUpdated(final ProgramList.Chunk chunk) {
        dispatch(new TunerCallback$$ExternalSyntheticLambda8(this, chunk));
    }

    public void onConfigFlagUpdated(int flag, boolean value) {
        Slogf.w(TAG, "Not applicable for HAL 1.x");
    }

    public void onParametersUpdated(Map<String, String> parameters) {
        Slogf.w(TAG, "Not applicable for HAL 1.x");
    }

    public IBinder asBinder() {
        throw new RuntimeException("Not a binder");
    }
}
