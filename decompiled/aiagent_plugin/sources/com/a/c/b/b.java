package com.a.c.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CronFieldName.java */
/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3105b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f3106c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f3107d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f3108e = null;
    public static final b f = null;
    public static final b g = null;
    public static final b h = null;
    private static final /* synthetic */ b[] j = null;
    private int i;

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(j.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        b r0 = new b("SECOND", 0, 0);
        f3104a = r0;
        b r1 = new b("MINUTE", 1, 1);
        f3105b = r1;
        b r3 = new b("HOUR", 2, 2);
        f3106c = r3;
        b r5 = new b("DAY_OF_MONTH", 3, 3);
        f3107d = r5;
        b r7 = new b("MONTH", 4, 4);
        f3108e = r7;
        b r9 = new b("DAY_OF_WEEK", 5, 5);
        f = r9;
        b r11 = new b("YEAR", 6, 6);
        g = r11;
        b r13 = new b("DAY_OF_YEAR", 7, 7);
        h = r13;
        j = new b[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    private b(String r1, int r2, int r3) {
        super(r1, r2);
        this.i = r3;
    }

    public int a() {
        return this.i;
    }
}
