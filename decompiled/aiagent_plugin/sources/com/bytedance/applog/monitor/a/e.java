package com.bytedance.applog.monitor.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ExceptionType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f5744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f5745b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f5746c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f5747d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f5748e = null;
    public static final e f = null;
    public static final e g = null;
    public static final e h = null;
    public static final e i = null;
    private static final /* synthetic */ e[] j = null;

    private e(String r1, int r2) {
        super(r1, r2);
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(j.clone(), e[].class, "com.obric.aiagent.plugin");
    }

    static {
        e r0 = new e("InterruptionInvalidDid", 0);
        f5744a = r0;
        e r1 = new e("InterruptionBlockList", 1);
        f5745b = r1;
        e r3 = new e("InterruptionTouristMode", 2);
        f5746c = r3;
        e r5 = new e("InterruptionEventList", 3);
        f5747d = r5;
        e r7 = new e("InterruptionSampling", 4);
        f5748e = r7;
        e r9 = new e("OutOfDataBoundary", 5);
        f = r9;
        e r11 = new e("CacheOverflow", 6);
        g = r11;
        e r13 = new e("CommonError", 7);
        h = r13;
        e r15 = new e("HighFrequency", 8);
        i = r15;
        j = new e[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
    }
}
