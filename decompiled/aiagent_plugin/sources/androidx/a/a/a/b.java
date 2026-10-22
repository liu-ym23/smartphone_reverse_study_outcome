package androidx.a.a.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: DefaultTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f94a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f95b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Handler f96c;

    /* JADX INFO: compiled from: DefaultTaskExecutor.java */
    private static class a {
        public static Handler a(Looper r0) {
            return Handler.createAsync(r0);
        }
    }

    public b() {
        this.f94a = new Object();
        this.f95b = Executors.newFixedThreadPool(4, new AnonymousClass1(this));
    }

    @Override // androidx.a.a.a.c
    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        this.f95b.execute(r4);
    }

    @Override // androidx.a.a.a.c
    public void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.f96c != null) goto L14;
        Object r0 = this.f94a;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f96c != null) goto L9;
        this.f96c = a(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L14:
        this.f96c.post(r4);
    }

    @Override // androidx.a.a.a.c
    public boolean c() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    private static Handler a(Looper r7) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return a.a(r7);
    L7:
        if (Build.VERSION.SDK_INT < 17) goto L13;
        return (Handler) ZeusTransformUtils.preCheckCast(Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r7, null, true}), Handler.class, "com.obric.aiagent.plugin");
    L11:
        return new Handler(r7);
    L13:
        return new Handler(r7);
    }
}
