package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
final class HardwareConfigState {
    private static final File FD_SIZE_LIST = null;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS = 700;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    private static final int MIN_HARDWARE_DIMENSION = 128;
    private static volatile HardwareConfigState instance;
    private volatile int decodesSinceLastFdCheck;
    private volatile boolean isHardwareConfigAllowed;

    static {
        FD_SIZE_LIST = new File("/proc/self/fd");
    }

    private HardwareConfigState() {
        this.isHardwareConfigAllowed = true;
    }

    public static HardwareConfigState getInstance() {
        if (instance != null) goto L16;
        monitor-enter(HardwareConfigState.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L11;
        instance = new HardwareConfigState();     // Catch: Throwable -> L9
    L11:
        monitor-exit(HardwareConfigState.class);     // Catch: Throwable -> L9
    L16:
        return instance;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        monitor-enter(this);
        boolean r10 = true;
        int r11 = this.decodesSinceLastFdCheck + 1;     // Catch: Throwable -> L14
        this.decodesSinceLastFdCheck = r11;     // Catch: Throwable -> L14
        if (r11 < 50) goto L16;
        this.decodesSinceLastFdCheck = 0;     // Catch: Throwable -> L14
        int r12 = FD_SIZE_LIST.list().length;     // Catch: Throwable -> L14
        if (r12 < 700) goto L9;
        r10 = false;
    L9:
        this.isHardwareConfigAllowed = r10;     // Catch: Throwable -> L14
        if (this.isHardwareConfigAllowed == true) goto L16;
        if (Log.isLoggable("Downsampler", 5) == false) goto L16;
        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + r12 + ", limit 700");     // Catch: Throwable -> L14
    L16:
        boolean r13 = this.isHardwareConfigAllowed;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r13;
    L14:
        th = move-exception;
        throw th;
    }

    @TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int r10, int r11, BitmapFactory.Options r12, DecodeFormat r13, boolean r14, boolean r15) {
        if (r14 == false) goto L16;
        if (r15 == true) goto L16;
        if (r10 < 128) goto L12;
        if (r11 < 128) goto L12;
        if (isFdSizeBelowHardwareLimit() == false) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L15;
        r12.inPreferredConfig = Bitmap.Config.HARDWARE;
        r12.inMutable = false;
    L15:
        return r16;
    L12:
        r16 = false;
    L16:
        return false;
    }
}
