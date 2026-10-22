package androidx.appcompat.app;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class p implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2668a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f2669b;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f2670c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2671d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayDeque f2672e;

    public p(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f2669b = executor;
        this.f2672e = new ArrayDeque();
        this.f2671d = new Object();
    }

    public final void a() {
        switch (this.f2668a) {
            case 0:
                synchronized (this.f2671d) {
                    try {
                        Runnable runnable = (Runnable) this.f2672e.poll();
                        this.f2670c = runnable;
                        if (runnable != null) {
                            this.f2669b.execute(runnable);
                        }
                    } finally {
                    }
                }
                return;
            default:
                synchronized (this.f2671d) {
                    try {
                        Object objPoll = this.f2672e.poll();
                        Runnable runnable2 = (Runnable) objPoll;
                        this.f2670c = runnable2;
                        if (objPoll != null) {
                            this.f2669b.execute(runnable2);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable command) {
        switch (this.f2668a) {
            case 0:
                synchronized (this.f2671d) {
                    try {
                        this.f2672e.add(new o(0, this, command));
                        if (this.f2670c == null) {
                            a();
                        }
                    } finally {
                    }
                }
                return;
            default:
                Intrinsics.checkNotNullParameter(command, "command");
                synchronized (this.f2671d) {
                    try {
                        this.f2672e.offer(new o(this, command));
                        if (this.f2670c == null) {
                            a();
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
