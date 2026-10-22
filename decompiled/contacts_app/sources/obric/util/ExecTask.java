package obric.util;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: tasks.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0001J\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lobric/util/ExecTask;", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "exec", "getHandler", "()Landroid/os/Handler;", "cancel", "", "execute", "runnable", "executeDelay", "delay", "", "run", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExecTask implements Runnable {
    private Runnable exec;
    private final Handler handler;

    /* JADX WARN: Multi-variable type inference failed */
    public ExecTask() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ExecTask(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.handler = r2;
    }

    public /* synthetic */ ExecTask(Handler r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new Handler(Looper.getMainLooper());
    L5:
        this(r1);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        monitor-enter(this);
        Runnable r0 = this.exec;     // Catch: Throwable -> L8
        this.exec = null;     // Catch: Throwable -> L8
        monitor-exit(this);
        if (r0 == null) goto L13;
        r0.run();
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void execute(Runnable r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "runnable");     // Catch: Throwable -> L6
        cancel();     // Catch: Throwable -> L6
        this.exec = r2;     // Catch: Throwable -> L6
        this.handler.post(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void executeDelay(Runnable r2, long r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "runnable");     // Catch: Throwable -> L6
        cancel();     // Catch: Throwable -> L6
        this.exec = r2;     // Catch: Throwable -> L6
        this.handler.postDelayed(this, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void cancel() {
        monitor-enter(this);
        this.exec = null;     // Catch: Throwable -> L7
        this.handler.removeCallbacks(this);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
