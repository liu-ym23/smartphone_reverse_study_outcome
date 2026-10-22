package com.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CronNicknames.java */
/* JADX INFO: loaded from: classes.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f3085a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f3086b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f3087c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f3088d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f3089e = null;
    public static final e f = null;
    public static final e g = null;
    public static final e h = null;
    private static final /* synthetic */ e[] i = null;

    private e(String r1, int r2) {
        super(r1, r2);
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(i.clone(), e[].class, "com.obric.aiagent.plugin");
    }

    static {
        e r0 = new e("YEARLY", 0);
        f3085a = r0;
        e r1 = new e("ANNUALLY", 1);
        f3086b = r1;
        e r3 = new e("MONTHLY", 2);
        f3087c = r3;
        e r5 = new e("WEEKLY", 3);
        f3088d = r5;
        e r7 = new e("DAILY", 4);
        f3089e = r7;
        e r9 = new e("MIDNIGHT", 5);
        f = r9;
        e r11 = new e("HOURLY", 6);
        g = r11;
        e r13 = new e("REBOOT", 7);
        h = r13;
        i = new e[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }
}
