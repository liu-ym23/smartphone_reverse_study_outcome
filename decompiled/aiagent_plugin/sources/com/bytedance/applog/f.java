package com.bytedance.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f5632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f5633b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f5634c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f5635d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f5636e = null;
    public static final f f = null;
    public static final f g = null;
    public static final f h = null;
    private static final /* synthetic */ f[] j = null;
    final int i;

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(j.clone(), f[].class, "com.obric.aiagent.plugin");
    }

    static {
        f r0 = new f("V3", 0, 0);
        f5632a = r0;
        f r1 = new f("V1", 1, 1);
        f5633b = r1;
        f r3 = new f("LogData", 2, 2);
        f5634c = r3;
        f r5 = new f("Launch", 3, 3);
        f5635d = r5;
        f r7 = new f("Terminate", 4, 4);
        f5636e = r7;
        f r9 = new f("IMPRESSION", 5, 5);
        f = r9;
        f r11 = new f("FORWARD_V3", 6, 6);
        g = r11;
        f r13 = new f("UNKNOWN", 7, 99);
        h = r13;
        j = new f[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    private f(String r1, int r2, int r3) {
        super(r1, r2);
        this.i = r3;
    }

    public int a() {
        return this.i;
    }
}
