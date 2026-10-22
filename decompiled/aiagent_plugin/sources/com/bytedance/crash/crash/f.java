package com.bytedance.crash.crash;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.h;
import com.bytedance.crash.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: compiled from: NativeCrashHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f7332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f7333b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f7334d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f7335c;

    f(Context r3, a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f7335c = r4;
        NativeBridge.a();
        NativeBridge.a(r5, r4.a());
    }

    public static void a(boolean r0) {
        f7333b = r0;
    }

    public static void b(boolean r0) {
        f7332a = r0;
    }

    void a(long r9, int r11) {
        if (r9 <= 0) goto L5;
        a(r9);
    L5:
        this.f7335c.a(r9, f7334d, f7332a, f7333b, r11);
        if (r9 <= 0) goto L11;
        File r10 = this.f7335c.a();
        com.bytedance.crash.e.b.a(r10);
        String r12 = NativeBridge.h(r10.getAbsolutePath());
        if (TextUtils.isEmpty(r12) == true) goto L12;
        a(r12);
        return;
    L12:
        return;
    }

    private void a(long r4) {
        com.bytedance.crash.monitor.a r3 = h.a();     // Catch: Throwable -> L13
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<t> r5 = r3.n().e(CrashType.NATIVE).iterator();     // Catch: Throwable -> L13
    L7:
        if (r5.hasNext() == false) goto L21;
        t r0 = (t) ZeusTransformUtils.preCheckCast(r5.next(), t.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r0.a(CrashType.NATIVE, r4);     // Catch: Throwable -> L12
        goto L7
    L21:
        return;
    }

    private void a(String r5) {
        Iterator<com.bytedance.crash.monitor.d> r0 = h.d().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((com.bytedance.crash.monitor.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.crash.monitor.d.class, "com.obric.aiagent.plugin"), r5);
        goto L4
    }

    private void a(com.bytedance.crash.monitor.d r3, String r4) {
        if (r3 == null) goto L9;
        Iterator<ICrashCallback> r2 = r3.n().c(CrashType.NATIVE).iterator();
    L5:
        if (r2.hasNext() == false) goto L16;
        ICrashCallback r5 = (ICrashCallback) ZeusTransformUtils.preCheckCast(r2.next(), ICrashCallback.class, "com.obric.aiagent.plugin");
        r5.onCrash(CrashType.NATIVE, r4, null);     // Catch: Throwable -> L10
        goto L5
    L16:
        return;
    }
}
