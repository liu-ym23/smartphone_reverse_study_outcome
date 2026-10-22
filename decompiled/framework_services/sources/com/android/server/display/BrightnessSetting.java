package com.android.server.display;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Slog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessSetting {
    private static final int MSG_BRIGHTNESS_CHANGED = 1;
    private static final String TAG = "BrightnessSetting";
    private float mBrightness;
    private final Handler mHandler;
    private final CopyOnWriteArraySet<BrightnessSettingListener> mListeners;
    private final LogicalDisplay mLogicalDisplay;
    private final PersistentDataStore mPersistentDataStore;
    private final DisplayManagerService.SyncRoot mSyncRoot;
    private int mUserSerial;

    public interface BrightnessSettingListener {
        void onBrightnessChanged(float r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3584$$Nest$mnotifyListeners(BrightnessSetting r0, float r1) {
        r0.notifyListeners(r1);
    }

    BrightnessSetting(int userSerial, PersistentDataStore persistentDataStore, LogicalDisplay logicalDisplay, DisplayManagerService.SyncRoot syncRoot) {
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        this.mListeners = new CopyOnWriteArraySet();
        this.mPersistentDataStore = persistentDataStore;
        this.mLogicalDisplay = logicalDisplay;
        this.mUserSerial = userSerial;
        this.mBrightness = this.mPersistentDataStore.getBrightness(this.mLogicalDisplay.getPrimaryDisplayDeviceLocked(), userSerial);
        this.mSyncRoot = syncRoot;
    }

    public float getBrightness() {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        float r1 = this.mBrightness;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void registerListener(BrightnessSettingListener l) {
        if (this.mListeners.contains(l) == false) goto L5;
        Slog.wtf(TAG, "Duplicate Listener added");
    L5:
        this.mListeners.add(l);
    }

    public void unregisterListener(BrightnessSettingListener l) {
        this.mListeners.remove(l);
    }

    public void setUserSerial(int userSerial) {
        this.mUserSerial = userSerial;
    }

    public void setBrightness(float brightness) {
        if (Float.isNaN(brightness) == false) goto L6;
        Slog.w(TAG, "Attempting to set invalid brightness");
        return;
    L6:
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (brightness == this.mBrightness) goto L13;
        this.mPersistentDataStore.setBrightness(this.mLogicalDisplay.getPrimaryDisplayDeviceLocked(), brightness, this.mUserSerial);     // Catch: Throwable -> L11
    L13:
        this.mBrightness = brightness;     // Catch: Throwable -> L11
        int toSend = Float.floatToIntBits(this.mBrightness);     // Catch: Throwable -> L11
        Message msg = this.mHandler.obtainMessage(1, toSend, 0);     // Catch: Throwable -> L11
        this.mHandler.sendMessage(msg);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void setBrightnessNoNotify(float brightness) {
        if (Float.isNaN(brightness) == false) goto L6;
        Slog.w(TAG, "Attempting to init invalid brightness");
        return;
    L6:
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (brightness == this.mBrightness) goto L13;
        this.mPersistentDataStore.setBrightness(this.mLogicalDisplay.getPrimaryDisplayDeviceLocked(), brightness, this.mUserSerial);     // Catch: Throwable -> L11
    L13:
        this.mBrightness = brightness;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void saveIfNeeded() {
        this.mPersistentDataStore.saveIfNeeded();
    }

    public float getBrightnessNitsForDefaultDisplay() {
        return this.mPersistentDataStore.getBrightnessNitsForDefaultDisplay();
    }

    public void setBrightnessNitsForDefaultDisplay(float nits) {
        this.mPersistentDataStore.setBrightnessNitsForDefaultDisplay(nits);
    }

    private void notifyListeners(float brightness) {
        Iterator<BrightnessSettingListener> r0 = this.mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        BrightnessSettingListener l = r0.next();
        l.onBrightnessChanged(brightness);
        goto L4
    }
}
