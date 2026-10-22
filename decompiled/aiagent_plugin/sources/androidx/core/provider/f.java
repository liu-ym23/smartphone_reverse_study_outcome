package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SelfDestructiveThread.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f1330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f1331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1332d;

    void a(Runnable r5) {
        ((Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin")).run();
        Object r6 = this.f1329a;
        monitor-enter(r6);
        this.f1331c.removeMessages(0);     // Catch: Throwable -> L7
        Handler r0 = this.f1331c;     // Catch: Throwable -> L7
        r0.sendMessageDelayed(r0.obtainMessage(0), this.f1332d);     // Catch: Throwable -> L7
        monitor-exit(r6);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void a() {
        Object r0 = this.f1329a;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f1331c.hasMessages(1) == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.f1330b.quit();     // Catch: Throwable -> L11
        this.f1330b = null;     // Catch: Throwable -> L11
        this.f1331c = null;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }
}
