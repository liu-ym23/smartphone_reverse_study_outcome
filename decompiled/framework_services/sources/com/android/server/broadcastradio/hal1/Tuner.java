package com.android.server.broadcastradio.hal1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.radio.ITuner;
import android.hardware.radio.ITunerCallback;
import android.hardware.radio.ProgramList;
import android.hardware.radio.ProgramSelector;
import android.hardware.radio.RadioManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.server.broadcastradio.RadioServiceUserController;
import com.android.server.broadcastradio.RadioServiceUserControllerImpl;
import com.android.server.utils.Slogf;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class Tuner extends ITuner.Stub {
    private static final String TAG = "BcRadio1Srv.Tuner";
    private final ITunerCallback mClientCallback;
    private final IBinder.DeathRecipient mDeathRecipient;
    private boolean mIsClosed;
    private boolean mIsMuted;
    private final Object mLock;
    private final long mNativeContext;
    private int mRegion;
    private final TunerCallback mTunerCallback;
    private final RadioServiceUserController mUserController;
    private final boolean mWithAudio;

    private native void nativeCancel(long r1);

    private native void nativeCancelAnnouncement(long r1);

    private native void nativeClose(long r1);

    private native void nativeFinalize(long r1);

    private native RadioManager.BandConfig nativeGetConfiguration(long r1, int r3);

    private native byte[] nativeGetImage(long r1, int r3);

    private native List<RadioManager.ProgramInfo> nativeGetProgramList(long r1, Map<String, String> r3);

    private native long nativeInit(int r1, boolean r2, int r3);

    private native boolean nativeIsAnalogForced(long r1);

    private native void nativeScan(long r1, boolean r3, boolean r4);

    private native void nativeSetAnalogForced(long r1, boolean r3);

    private native void nativeSetConfiguration(long r1, RadioManager.BandConfig r3);

    private native boolean nativeStartBackgroundScan(long r1);

    private native void nativeStep(long r1, boolean r3, boolean r4);

    private native void nativeTune(long r1, ProgramSelector r3);

    Tuner(ITunerCallback clientCallback, int halRev, int region, boolean withAudio, int band) {
        this.mLock = new Object();
        this.mIsClosed = false;
        this.mIsMuted = false;
        this.mUserController = new RadioServiceUserControllerImpl();
        this.mClientCallback = clientCallback;
        this.mTunerCallback = new TunerCallback(this, clientCallback, halRev);
        this.mRegion = region;
        this.mWithAudio = withAudio;
        this.mNativeContext = nativeInit(halRev, withAudio, band);
        this.mDeathRecipient = new Tuner$$ExternalSyntheticLambda0(this);
        this.mClientCallback.asBinder().linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L5
        return;
    L6:
        close();
    }

    protected void finalize() throws Throwable {
        nativeFinalize(this.mNativeContext);
        super/*java.lang.Object*/.finalize();
    }

    public void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIsClosed = true;     // Catch: Throwable -> L8
        this.mTunerCallback.detach();     // Catch: Throwable -> L8
        this.mClientCallback.asBinder().unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L8
        nativeClose(this.mNativeContext);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public boolean isClosed() {
        return this.mIsClosed;
    }

    private void checkNotClosedLocked() {
        if (this.mIsClosed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Tuner is closed, no further operations are allowed");
    }

    private boolean checkConfiguredLocked() {
        if (this.mTunerCallback.isInitialConfigurationDone() == false) goto L6;
        return true;
    L6:
        Slogf.w(TAG, "Initial configuration is still pending, skipping the operation");
        return false;
    }

    public void setConfiguration(RadioManager.BandConfig config) {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot set configuration for HAL 1.x client from non-current user");
        return;
    L6:
        if (config == null) goto L16;
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L12
        nativeSetConfiguration(this.mNativeContext, config);     // Catch: Throwable -> L12
        this.mRegion = config.getRegion();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalArgumentException("The argument must not be a null pointer");
    }

    public RadioManager.BandConfig getConfiguration() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L7
        RadioManager.BandConfig r1 = nativeGetConfiguration(this.mNativeContext, this.mRegion);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMuted(boolean mute) {
        if (this.mWithAudio == false) goto L18;
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L10
        if (this.mIsMuted != mute) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        this.mIsMuted = mute;     // Catch: Throwable -> L10
        Slogf.w(TAG, "Mute via RadioService is not implemented - please handle it via app");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L18:
        throw new IllegalStateException("Can't operate on mute - no audio requested");
    }

    public boolean isMuted() {
        if (this.mWithAudio == true) goto L6;
        Slogf.w(TAG, "Tuner did not request audio, pretending it was muted");
        return true;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L11
        boolean r1 = this.mIsMuted;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public void step(boolean directionDown, boolean skipSubChannel) {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot step on HAL 1.x client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L12
        if (checkConfiguredLocked() == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        nativeStep(this.mNativeContext, directionDown, skipSubChannel);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void seek(boolean directionDown, boolean skipSubChannel) {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot seek on HAL 1.x client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L12
        if (checkConfiguredLocked() == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        nativeScan(this.mNativeContext, directionDown, skipSubChannel);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void tune(ProgramSelector selector) {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot tune on HAL 1.x client from non-current user");
        return;
    L6:
        if (selector == null) goto L21;
        Slogf.i(TAG, "Tuning to " + selector);
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L13
        if (checkConfiguredLocked() == true) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        nativeTune(this.mNativeContext, selector);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L21:
        throw new IllegalArgumentException("The argument must not be a null pointer");
    }

    public void cancel() {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot cancel on HAL 1.x client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L11
        nativeCancel(this.mNativeContext);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void cancelAnnouncement() {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot cancel announcement on HAL 1.x client from non-current user");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L11
        nativeCancelAnnouncement(this.mNativeContext);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public Bitmap getImage(int id) {
        if (id == 0) goto L19;
        Object r0 = this.mLock;
        monitor-enter(r0);
        byte[] rawImage = nativeGetImage(this.mNativeContext, id);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (rawImage != null) goto L9;
        return null;
    L9:
        if (rawImage.length != 0) goto L12;
        return null;
    L12:
        return BitmapFactory.decodeByteArray(rawImage, 0, rawImage.length);
    L15:
        th = move-exception;
        throw th;
    L19:
        throw new IllegalArgumentException("Image ID is missing");
    }

    public boolean startBackgroundScan() {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot start background scan on HAL 1.x client from non-current user");
        return false;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L11
        boolean r1 = nativeStartBackgroundScan(this.mNativeContext);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    List<RadioManager.ProgramInfo> getProgramList(Map vendorFilter) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        checkNotClosedLocked();     // Catch: Throwable -> L8
        List<RadioManager.ProgramInfo> list = nativeGetProgramList(this.mNativeContext, vendorFilter);     // Catch: Throwable -> L8
        if (list == null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return list;
    L11:
        throw new IllegalStateException("Program list is not ready");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void startProgramListUpdates(ProgramList.Filter filter) {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot start program list updates on HAL 1.x client from non-current user");
        return;
    L6:
        this.mTunerCallback.startProgramListUpdates(filter);
    }

    public void stopProgramListUpdates() {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L6;
        Slogf.w(TAG, "Cannot stop program list updates on HAL 1.x client from non-current user");
        return;
    L6:
        this.mTunerCallback.stopProgramListUpdates();
    }

    public boolean isConfigFlagSupported(int flag) {
        if (flag != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isConfigFlagSet(int flag) {
        if (flag != 2) goto L13;
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L9
        boolean r1 = nativeIsAnalogForced(this.mNativeContext);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new UnsupportedOperationException("Not supported by HAL 1.x");
    }

    public void setConfigFlag(int flag, boolean value) {
        if (this.mUserController.isCurrentOrSystemUser() == true) goto L7;
        Slogf.w(TAG, "Cannot set config flag for HAL 1.x client from non-current user");
        return;
    L7:
        if (flag != 2) goto L17;
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosedLocked();     // Catch: Throwable -> L13
        nativeSetAnalogForced(this.mNativeContext, value);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new UnsupportedOperationException("Not supported by HAL 1.x");
    }

    public Map<String, String> setParameters(Map<String, String> parameters) {
        throw new UnsupportedOperationException("Not supported by HAL 1.x");
    }

    public Map<String, String> getParameters(List<String> keys) {
        throw new UnsupportedOperationException("Not supported by HAL 1.x");
    }
}
