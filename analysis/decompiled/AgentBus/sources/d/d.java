package d;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import b0.k0;
import b0.l0;
import b0.x0;
import j1.o0;
import j1.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import n.a0;
import n.b1;
import n.d0;
import n.t0;
import n.u0;
import o2.i;
import o2.m;
import q7.k;
import w5.s;
import w7.e0;

/* loaded from: classes.dex */
public final class d implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2734a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2735b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2736c;

    public /* synthetic */ d(int i2, Object obj, Object obj2) {
        this.f2734a = i2;
        this.f2735b = obj;
        this.f2736c = obj2;
    }

    @Override // b0.k0
    public final void a() throws Exception {
        boolean zIsTerminated;
        int i2 = this.f2734a;
        Object obj = this.f2736c;
        Object obj2 = this.f2735b;
        switch (i2) {
            case 0:
                e.b bVar = (e.b) obj2;
                f fVar = (f) obj;
                if (bVar.f3040a != null) {
                    fVar.f2739b.e();
                    return;
                }
                if (bVar.f3041b == null) {
                    throw new IllegalStateException("Unreachable");
                }
                x0 x0Var = fVar.f2738a;
                ArrayList arrayList = (ArrayList) x0Var.f1414a;
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) x0Var.f1416c;
                Iterator it = copyOnWriteArrayList.iterator();
                k.d(it, "iterator(...)");
                while (it.hasNext()) {
                    AutoCloseable autoCloseable = (AutoCloseable) it.next();
                    if (autoCloseable instanceof AutoCloseable) {
                        autoCloseable.close();
                    } else if (autoCloseable instanceof ExecutorService) {
                        ExecutorService executorService = (ExecutorService) autoCloseable;
                        if (executorService != ForkJoinPool.commonPool() && !(zIsTerminated = executorService.isTerminated())) {
                            executorService.shutdown();
                            boolean z4 = false;
                            while (!zIsTerminated) {
                                try {
                                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                                } catch (InterruptedException unused) {
                                    if (!z4) {
                                        executorService.shutdownNow();
                                        z4 = true;
                                    }
                                }
                            }
                            if (z4) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    } else {
                        if (!(autoCloseable instanceof TypedArray)) {
                            throw new IllegalArgumentException();
                        }
                        ((TypedArray) autoCloseable).recycle();
                    }
                }
                copyOnWriteArrayList.clear();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((c.k) it2.next()).e();
                }
                arrayList.clear();
                return;
            case 1:
                ((Context) obj2).getApplicationContext().unregisterComponentCallbacks((o0) obj);
                return;
            case 2:
                ((Context) obj2).getApplicationContext().unregisterComponentCallbacks((p0) obj);
                return;
            case 3:
                ((d0) obj2).f6596a.i((a0) obj);
                return;
            case 4:
                ((b1) obj2).f6555j.remove((b1) obj);
                return;
            case 5:
                b1 b1Var = (b1) obj2;
                t0 t0Var = (t0) ((u0) obj).f6739b.getValue();
                if (t0Var != null) {
                    b1Var.f6554i.remove(t0Var.f6732f);
                    return;
                }
                return;
            case 6:
                r.p0 p0Var = (r.p0) obj2;
                View view = (View) obj;
                int i10 = p0Var.f8927s - 1;
                p0Var.f8927s = i10;
                if (i10 == 0) {
                    int i11 = m.f7237a;
                    i.a(view, null);
                    view.setWindowInsetsAnimationCallback(null);
                    view.removeOnAttachStateChangeListener(p0Var.f8928t);
                    return;
                }
                return;
            default:
                try {
                    ((c.i) obj2).unbindService((s) obj);
                    return;
                } catch (Throwable th) {
                    e0.n(th);
                    return;
                }
        }
    }

    public d(l0 l0Var, c.i iVar, s sVar) {
        this.f2734a = 7;
        this.f2735b = iVar;
        this.f2736c = sVar;
    }
}
