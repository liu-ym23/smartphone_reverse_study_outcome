package com.obric.aiagent.utils.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: SystemInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f22312a = null;

    static {
        f22312a = new c();
    }

    private c() {
    }

    public final String a() {
        return a(this, "ro.build.type", null, 2, null);
    }

    public static /* synthetic */ String a(c r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = "";
    L6:
        return r0.a(r1, r2);
    }

    public final String a(String r8, String r9) {
        o.e(r8, "key");
        o.e(r9, "defaultValue");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        c r7 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Class r10 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r11 = r10.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r10, new Object[]{r8, r9});     // Catch: Throwable -> L5
        o.a(r11, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L5
        Object r12 = n.f((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L7:
        Object r13 = r9;
        if (n.b(r12) == true) goto L12;
        r13 = r12;
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r14 = n.f38560a;
        r12 = n.f(d.o.a(th));
        goto L7
    }

    public final void b(String r7, String r8) {
        o.e(r7, "key");
        o.e(r8, "value");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        c r6 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Class r9 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r10 = n.f(r9.getMethod("set", new Class[]{String.class, String.class}).invoke(r9, new Object[]{r7, r8}));     // Catch: Throwable -> L5
    L7:
        Throwable r11 = n.c(r10);
        if (r11 == null) goto L13;
        r11.printStackTrace();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r12 = n.f38560a;
        r10 = n.f(d.o.a(th));
        goto L7
    }
}
