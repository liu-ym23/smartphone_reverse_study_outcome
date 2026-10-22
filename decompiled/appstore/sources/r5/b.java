package r5;

import com.bytedance.platform.godzilla.anr.monitor.ITaskCostTimeCallback;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f23764b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITaskCostTimeCallback f23765a;

    public b() {
    }

    public static b b() {
        if (f23764b != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23764b != null) goto L11;
        f23764b = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f23764b;
    }

    public ITaskCostTimeCallback a() {
        return this.f23765a;
    }
}
