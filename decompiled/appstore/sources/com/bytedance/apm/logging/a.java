package com.bytedance.apm.logging;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static MethodLog.LogImp f6519a;

    static {
        f6519a = MethodLog.f6518a;
    }

    public static void a(String r10, String r11, Object... r12) {
        MethodLog.LogImp r13 = f6519a;
        if (r13 == null) goto L6;
        r13.e(r10, r11, r12);
        return;
    }

    public static void b(String r10, String r11, Object... r12) {
        MethodLog.LogImp r13 = f6519a;
        if (r13 == null) goto L6;
        r13.i(r10, r11, r12);
        return;
    }

    public static void c(String r10, String r11, Object... r12) {
        MethodLog.LogImp r13 = f6519a;
        if (r13 == null) goto L6;
        r13.w(r10, r11, r12);
        return;
    }
}
