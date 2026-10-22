package androidx.room;

import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/room/A;", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "Ljava/lang/Runnable;", "command", "LY8/t;", "execute", "(Ljava/lang/Runnable;)V", "c", "()V", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/Executor;", "Ljava/util/ArrayDeque;", Const.INTENT_KEY_PKGNAME, "Ljava/util/ArrayDeque;", "tasks", "Ljava/lang/Runnable;", "active", "", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "syncLock", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class A implements Executor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Executor executor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ArrayDeque<Runnable> tasks;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Runnable active;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Object syncLock;

    public A(Executor executor) {
        kotlin.jvm.internal.p.i(executor, "executor");
        this.executor = executor;
        this.tasks = new ArrayDeque<>();
        this.syncLock = new Object();
    }

    public static final void b(Runnable runnable, A a10) {
        try {
            runnable.run();
        } finally {
            a10.c();
        }
    }

    public final void c() {
        synchronized (this.syncLock) {
            try {
                Runnable runnablePoll = this.tasks.poll();
                Runnable runnable = runnablePoll;
                this.active = runnable;
                if (runnablePoll != null) {
                    this.executor.execute(runnable);
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable command) {
        kotlin.jvm.internal.p.i(command, "command");
        synchronized (this.syncLock) {
            try {
                this.tasks.offer(new Runnable() { // from class: androidx.room.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        A.b(command, this);
                    }
                });
                if (this.active == null) {
                    c();
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
