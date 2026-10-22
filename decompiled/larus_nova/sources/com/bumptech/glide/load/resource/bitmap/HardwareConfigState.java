package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.bumptech.glide.util.GlideLogUtil;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public final class HardwareConfigState {
    private static final File FD_SIZE_LIST = null;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_O = 700;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    static final int MIN_HARDWARE_DIMENSION_O = 128;
    private static final int MIN_HARDWARE_DIMENSION_P = 0;
    private static volatile HardwareConfigState instance;
    private int decodesSinceLastFdCheck;
    private final int fdCountLimit;
    private boolean isFdSizeBelowHardwareLimit;
    private final boolean isHardwareConfigAllowedByDeviceModel;
    private final int minHardwareDimension;

    static {
        FD_SIZE_LIST = new PolarisFileWrapper("/proc/self/fd");
    }

    public static HardwareConfigState getInstance() {
        if (instance != null) goto L15;
        monitor-enter(HardwareConfigState.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new HardwareConfigState();     // Catch: Throwable -> L11
    L9:
        monitor-exit(HardwareConfigState.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        monitor-enter(this);
        boolean r100 = true;
        int r101 = this.decodesSinceLastFdCheck + 1;     // Catch: Throwable -> L16
        this.decodesSinceLastFdCheck = r101;     // Catch: Throwable -> L16
        if (r101 < 50) goto L13;
        this.decodesSinceLastFdCheck = 0;     // Catch: Throwable -> L16
        int r102 = FD_SIZE_LIST.list().length;     // Catch: Throwable -> L16
        if (r102 < this.fdCountLimit) goto L10;
        r100 = false;
    L10:
        this.isFdSizeBelowHardwareLimit = r100;     // Catch: Throwable -> L16
        if (r100 == true) goto L13;
        GlideLogUtil.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + r102 + ", limit " + this.fdCountLimit);     // Catch: Throwable -> L16
    L13:
        boolean r103 = this.isFdSizeBelowHardwareLimit;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r103;
    L16:
        th = move-exception;
        throw th;
    }

    private static boolean isHardwareConfigAllowedByDeviceModel() {
        String r100 = Build.MODEL;
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.length() < 7) goto L46;
        String r101 = r100.substring(0, 7);
        r101.getClass();
        byte r102 = -1;
        switch(r101.hashCode()) {
            case -1398613787: goto L35;
            case -1398431166: goto L31;
            case -1398431161: goto L27;
            case -1398431073: goto L23;
            case -1398431068: goto L19;
            case -1398343746: goto L15;
            case -1398222624: goto L11;
            default: goto L38;
        };
    L38:
        switch(r102) {
            case 0: goto L41;
            case 1: goto L41;
            case 2: goto L41;
            case 3: goto L41;
            case 4: goto L41;
            case 5: goto L41;
            case 6: goto L41;
            default: goto L39;
        };
    L39:
        return true;
    L41:
        if (Build.VERSION.SDK_INT != 26) goto L47;
        return false;
    L47:
        return true;
    L11:
        if (r101.equals("SM-N935") == false) goto L38;
        r102 = 6;
        goto L38
    L15:
        if (r101.equals("SM-J720") == false) goto L38;
        r102 = 5;
        goto L38
    L19:
        if (r101.equals("SM-G965") == false) goto L38;
        r102 = 4;
        goto L38
    L23:
        if (r101.equals("SM-G960") == false) goto L38;
        r102 = 3;
        goto L38
    L27:
        if (r101.equals("SM-G935") == false) goto L38;
        r102 = 2;
        goto L38
    L31:
        if (r101.equals("SM-G930") == false) goto L38;
        r102 = 1;
        goto L38
    L35:
        if (r101.equals("SM-A520") == false) goto L38;
        r102 = 0;
        goto L38
    L46:
        return true;
    }

    public HardwareConfigState() {
        this.isFdSizeBelowHardwareLimit = true;
        this.isHardwareConfigAllowedByDeviceModel = isHardwareConfigAllowedByDeviceModel();
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.fdCountLimit = 20000;
        this.minHardwareDimension = 0;
        return;
    L5:
        this.fdCountLimit = 700;
        this.minHardwareDimension = 128;
    }

    public boolean isHardwareConfigAllowed(int r100, int r101, boolean r102, boolean r103) {
        if (r102 == true) goto L5;
        return false;
    L5:
        if (this.isHardwareConfigAllowedByDeviceModel == true) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 26) goto L19;
        if (r103 == true) goto L23;
        int r104 = this.minHardwareDimension;
        if (r100 < r104) goto L20;
        if (r101 >= r104) goto L14;
        return false;
    L14:
        if (isFdSizeBelowHardwareLimit() == false) goto L22;
        return true;
    L22:
        return false;
    L20:
        return false;
    L23:
        return false;
    L19:
        return false;
    }

    public boolean setHardwareConfigIfAllowed(int r100, int r101, BitmapFactory.Options r102, boolean r103, boolean r104) {
        boolean r105 = isHardwareConfigAllowed(r100, r101, r103, r104);
        if (r105 == false) goto L5;
        r102.inPreferredConfig = Bitmap.Config.HARDWARE;
        r102.inMutable = false;
    L5:
        return r105;
    }
}
