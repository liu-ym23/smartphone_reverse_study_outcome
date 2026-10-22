package androidx.room;

import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1508c;

    /* renamed from: f, reason: collision with root package name */
    public Object f1509f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayDeque f1510g;

    /* renamed from: h, reason: collision with root package name */
    public Runnable f1511h;
    public Executor i;

    public /* synthetic */ b0(int i) {
        this.f1508c = i;
    }

    public final void a() {
        switch (this.f1508c) {
            case 0:
                synchronized (this.f1509f) {
                    Object objPoll = this.f1510g.poll();
                    Runnable runnable = (Runnable) objPoll;
                    this.f1511h = runnable;
                    if (objPoll != null) {
                        this.i.execute(runnable);
                    }
                }
                return;
            case 1:
                synchronized (this.f1509f) {
                    try {
                        Runnable runnable2 = (Runnable) this.f1510g.poll();
                        this.f1511h = runnable2;
                        if (runnable2 != null) {
                            ((h.p) this.i).execute(runnable2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                Runnable runnable3 = (Runnable) this.f1510g.poll();
                this.f1511h = runnable3;
                if (runnable3 != null) {
                    ((ExecutorService) this.i).execute(runnable3);
                    return;
                }
                return;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f1508c) {
            case 0:
                runnable.getClass();
                synchronized (this.f1509f) {
                    ArrayDeque arrayDeque = this.f1510g;
                    a0 a0Var = new a0(0);
                    a0Var.f1506f = runnable;
                    a0Var.f1507g = this;
                    VarHandle.storeStoreFence();
                    arrayDeque.offer(a0Var);
                    if (this.f1511h == null) {
                        a();
                    }
                }
                return;
            case 1:
                synchronized (this.f1509f) {
                    try {
                        ArrayDeque arrayDeque2 = this.f1510g;
                        a0 a0Var2 = new a0(2);
                        a0Var2.f1507g = this;
                        a0Var2.f1506f = runnable;
                        VarHandle.storeStoreFence();
                        arrayDeque2.add(a0Var2);
                        if (this.f1511h == null) {
                            a();
                        }
                    } finally {
                    }
                }
                return;
            default:
                synchronized (this.f1509f) {
                    try {
                        ArrayDeque arrayDeque3 = this.f1510g;
                        com.stepos.statsrpk.service.d dVar = new com.stepos.statsrpk.service.d(11);
                        dVar.f2885f = this;
                        dVar.f2886g = runnable;
                        VarHandle.storeStoreFence();
                        arrayDeque3.add(dVar);
                        if (this.f1511h == null) {
                            a();
                        }
                    } finally {
                    }
                }
                return;
        }
    }
}
