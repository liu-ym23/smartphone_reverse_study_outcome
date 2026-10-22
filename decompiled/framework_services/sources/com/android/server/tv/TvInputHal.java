package com.android.server.tv;

import android.media.tv.TvInputHardwareInfo;
import android.media.tv.TvStreamConfig;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Surface;

/* JADX INFO: loaded from: classes3.dex */
final class TvInputHal implements Handler.Callback {
    private static final boolean DEBUG = false;
    public static final int ERROR_NO_INIT = -1;
    public static final int ERROR_STALE_CONFIG = -2;
    public static final int ERROR_UNKNOWN = -3;
    public static final int EVENT_DEVICE_AVAILABLE = 1;
    public static final int EVENT_DEVICE_UNAVAILABLE = 2;
    public static final int EVENT_FIRST_FRAME_CAPTURED = 4;
    public static final int EVENT_STREAM_CONFIGURATION_CHANGED = 3;
    public static final int EVENT_TV_MESSAGE = 5;
    public static final int SUCCESS = 0;
    private static final String TAG = null;
    private final Callback mCallback;
    private final Handler mHandler;
    private final Object mLock;
    private long mPtr;
    private final SparseIntArray mStreamConfigGenerations;
    private final SparseArray<TvStreamConfig[]> mStreamConfigs;

    public interface Callback {
        void onDeviceAvailable(TvInputHardwareInfo r1, TvStreamConfig[] r2);

        void onDeviceUnavailable(int r1);

        void onFirstFrameCaptured(int r1, int r2);

        void onStreamConfigurationChanged(int r1, TvStreamConfig[] r2, int r3);

        void onTvMessage(int r1, int r2, Bundle r3);
    }

    private static native int nativeAddOrUpdateStream(long r0, int r2, int r3, Surface r4);

    private static native void nativeClose(long r0);

    private static native TvStreamConfig[] nativeGetStreamConfigs(long r0, int r2, int r3);

    private native long nativeOpen(MessageQueue r1);

    private static native int nativeRemoveStream(long r0, int r2, int r3);

    private static native int nativeSetPictureProfile(long r0, int r2, int r3, long r4);

    private static native int nativeSetTvMessageEnabled(long r0, int r2, int r3, int r4, boolean r5);

    static {
        TAG = TvInputHal.class.getSimpleName();
    }

    public TvInputHal(Callback callback) {
        this.mLock = new Object();
        this.mPtr = 0;
        this.mStreamConfigGenerations = new SparseIntArray();
        this.mStreamConfigs = new SparseArray();
        this.mCallback = callback;
        this.mHandler = new Handler(this);
    }

    public void init() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPtr = nativeOpen(this.mHandler.getLooper().getQueue());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int addOrUpdateStream(int deviceId, Surface surface, TvStreamConfig streamConfig) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPtr != 0) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -1;
    L11:
        int generation = this.mStreamConfigGenerations.get(deviceId, 0);     // Catch: Throwable -> L9
        if (generation == streamConfig.getGeneration()) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -2;
    L17:
        if (nativeAddOrUpdateStream(this.mPtr, deviceId, streamConfig.getStreamId(), surface) != 0) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -3;
    }

    public int setTvMessageEnabled(int deviceId, TvStreamConfig streamConfig, int type, boolean enabled) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L23:
        th = th;
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L23
        throw th;
    L28:
        th = th;
        goto L30
    L34:
        if (this.mPtr != 0) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return -1;
    L12:
        int generation = this.mStreamConfigGenerations.get(deviceId, 0);     // Catch: Throwable -> L28
        if (generation == streamConfig.getGeneration()) goto L17;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return -2;
    L17:
        if (nativeSetTvMessageEnabled(this.mPtr, deviceId, streamConfig.getStreamId(), type, enabled) != 0) goto L25;
        monitor-exit(r1);     // Catch: Throwable -> L23
        return 0;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L23
        return -3;
    L10:
        th = th;
        goto L30
    }

    public int setPictureProfile(int deviceId, TvStreamConfig streamConfig, long profileHandle) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L23:
        th = th;
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L23
        throw th;
    L28:
        th = th;
        goto L30
    L34:
        if (this.mPtr != 0) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return -1;
    L12:
        int generation = this.mStreamConfigGenerations.get(deviceId, 0);     // Catch: Throwable -> L28
        if (generation == streamConfig.getGeneration()) goto L17;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return -2;
    L17:
        if (nativeSetPictureProfile(this.mPtr, deviceId, streamConfig.getStreamId(), profileHandle) != 0) goto L25;
        monitor-exit(r1);     // Catch: Throwable -> L23
        return 0;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L23
        return -3;
    L10:
        th = th;
        goto L30
    }

    public int removeStream(int deviceId, TvStreamConfig streamConfig) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPtr != 0) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -1;
    L11:
        int generation = this.mStreamConfigGenerations.get(deviceId, 0);     // Catch: Throwable -> L9
        if (generation == streamConfig.getGeneration()) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -2;
    L17:
        if (nativeRemoveStream(this.mPtr, deviceId, streamConfig.getStreamId()) != 0) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -3;
    }

    public void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mPtr == 0) goto L9;
        nativeClose(this.mPtr);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void retrieveStreamConfigsLocked(int deviceId) {
        int generation = this.mStreamConfigGenerations.get(deviceId, 0) + 1;
        this.mStreamConfigs.put(deviceId, nativeGetStreamConfigs(this.mPtr, deviceId, generation));
        this.mStreamConfigGenerations.put(deviceId, generation);
    }

    private void deviceAvailableFromNative(TvInputHardwareInfo info) {
        this.mHandler.obtainMessage(1, info).sendToTarget();
    }

    private void deviceUnavailableFromNative(int deviceId) {
        this.mHandler.obtainMessage(2, deviceId, 0).sendToTarget();
    }

    private void streamConfigsChangedFromNative(int deviceId, int cableConnectionStatus) {
        this.mHandler.obtainMessage(3, deviceId, cableConnectionStatus).sendToTarget();
    }

    private void firstFrameCapturedFromNative(int deviceId, int streamId) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, deviceId, streamId));
    }

    private void tvMessageReceivedFromNative(int deviceId, int type, Bundle data) {
        this.mHandler.obtainMessage(5, deviceId, type, data).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "Unknown event: " + msg);
        return false;
    L6:
        int deviceId = msg.arg1;
        int type = msg.arg2;
        Bundle data = (Bundle) msg.obj;
        this.mCallback.onTvMessage(deviceId, type, data);
        return true;
    L7:
        int deviceId2 = msg.arg1;
        int streamId = msg.arg2;
        this.mCallback.onFirstFrameCaptured(deviceId2, streamId);
        return true;
    L8:
        int deviceId3 = msg.arg1;
        int cableConnectionStatus = msg.arg2;
        Object r2 = this.mLock;
        monitor-enter(r2);
        retrieveStreamConfigsLocked(deviceId3);     // Catch: Throwable -> L13
        TvStreamConfig[] configs = this.mStreamConfigs.get(deviceId3);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        this.mCallback.onStreamConfigurationChanged(deviceId3, configs, cableConnectionStatus);
        return true;
    L13:
        th = move-exception;
        throw th;
    L16:
        this.mCallback.onDeviceUnavailable(msg.arg1);
        return true;
    L17:
        TvInputHardwareInfo info = (TvInputHardwareInfo) msg.obj;
        Object r1 = this.mLock;
        monitor-enter(r1);
        retrieveStreamConfigsLocked(info.getDeviceId());     // Catch: Throwable -> L24
        TvStreamConfig[] configs2 = this.mStreamConfigs.get(info.getDeviceId());     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        this.mCallback.onDeviceAvailable(info, configs2);
        return true;
    L24:
        th = move-exception;
        throw th;
    }
}
