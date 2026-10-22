package b5a;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f17792a;

    public c() {
    }

    public static void a(Runnable r100) {
        if (f17792a == null) goto L5;
    L14:
        f17792a.post(r100);
        return;
    L5:
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f17792a != null) goto L9;
        f17792a = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
        goto L14
    }
}
