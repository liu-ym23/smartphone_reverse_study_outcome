package com.obric.matrix.platform.sdk.ones.safecushion;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: LaunchCrashCatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "SafeModeCrashHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f33710b;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.safecushion.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LaunchCrashCatcher.kt */
    static final class C0912a extends p implements d.h.a.b<StackTraceElement, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0912a f33711a = null;

        static {
            f33711a = new C0912a();
        }

        C0912a() {
            super(1);
        }

        public final CharSequence a(StackTraceElement r2) {
            String r1 = r2.toString();
            o.c(r1, "it.toString()");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(StackTraceElement r3) {
            return a((StackTraceElement) ZeusTransformUtils.preCheckCast(r3, StackTraceElement.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f33709a = new a();
    }

    private a() {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r2, Throwable r3) {
        o.e(r2, "t");
        o.e(r3, "e");
        a(r2, r3);
    }

    private final void a(Thread r3, Throwable r4) {
        d.f33728a.a("StartUp", a(r4), r3);
        Thread.UncaughtExceptionHandler r2 = f33710b;
        if (r2 == null) goto L6;
        r2.uncaughtException(r3, r4);
        return;
    }

    public final boolean a(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        Toast.makeText(r6, (CharSequence) ZeusTransformUtils.preCheckCast("修复后进程重启，依旧抓到了崩溃\n没办法了，现在引导去商店升级应用版本", CharSequence.class, "com.obric.aiagent.plugin"), 0).show();     // Catch: Exception -> L5
        Intent r2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + c.f33723a.a().a().a()));     // Catch: Exception -> L5
        r2.setFlags(268435456);     // Catch: Exception -> L5
        ZeusTransformUtils.startActivity(r6, r2, "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private final String a(Throwable r12) {
        String r11 = r12.getLocalizedMessage();
    L4:
        if (r12.getCause() == null) goto L6;
        r12 = r12.getCause();
        o.a(r12);
        goto L4
    L6:
        StringBuilder r13 = new StringBuilder().append(r11).append('\n');
        StackTraceElement[] r14 = r12.getStackTrace();
        o.c(r14, "throwable.stackTrace");
        return r13.append(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(i.c((Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.aiagent.plugin"), 3), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(C0912a.f33711a, d.h.a.b.class, "com.obric.aiagent.plugin"), 30, null)).toString();
    }
}
