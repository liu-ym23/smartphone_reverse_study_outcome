package com.bytedance.applog.monitor.v3;

import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final enum Features$IntFeatureKeys extends Enum<Features$IntFeatureKeys> {
    public static final Features$IntFeatureKeys REPORT_INTERVAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Features$IntFeatureKeys[] f192497a = null;
    private final int length;
    private final int position;

    static {
        Features$IntFeatureKeys r100 = new Features$IntFeatureKeys();
        REPORT_INTERVAL = r100;
        f192497a = new Features$IntFeatureKeys[]{r100};
    }

    public Features$IntFeatureKeys() {
        super("REPORT_INTERVAL", 0);
        this.position = 19;
        this.length = 2;
    }

    public static Features$IntFeatureKeys[] values() {
        return (Features$IntFeatureKeys[]) f192497a.clone();
    }

    public static Features$IntFeatureKeys valueOf(String r100) {
        return (Features$IntFeatureKeys) a.a(Features$IntFeatureKeys.class, r100);
    }

    public int toBits(int r100, int r101) {
        int r102 = 0;
        if (r101 < (1 << this.length)) goto L8;
        r101 = 1;
        int r103 = 0;
    L6:
        if (r103 >= this.length) goto L8;
        r101 = r101 & (1 << r103);
        r103 = r103 + 1;
    L8:
        int r104 = 1;
    L10:
        if (r102 >= this.length) goto L13;
        r104 = r104 & (1 << r102);
        r102 = r102 + 1;
        goto L10
    L13:
        return (r100 & (~r104)) | (r101 << this.position);
    }
}
