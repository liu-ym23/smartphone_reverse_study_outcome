package com.lynx.markdown.b;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UIThreadUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Handler f13877a;

    public b() {
    }

    private static Handler a() {
        if (f13877a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13877a != null) goto L9;
        f13877a = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f13877a;
    }

    public static void a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        a().post(r3);
    }

    public static void a(Runnable r2, Object r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        a().postAtTime(r5, r3, r4);
    }

    public static void a(Runnable r2, Object r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        a().removeCallbacks(r4, r3);
    }
}
