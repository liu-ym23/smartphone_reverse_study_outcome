package androidx.appcompat.widget;

import Z2.InterfaceC0126g;
import android.util.Log;
import android.view.View;
import androidx.work.Worker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.C0403a;
import com.google.android.gms.common.api.internal.C0407e;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.signin.internal.zak;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import k.C0661o;
import k.InterfaceC0659m;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import l1.C0760e;
import l1.InterfaceC0757b;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.C0895o;
import stepos.support.v7.widget.C0897q;
import stepos.support.v7.widget.StepOSRecyclerView;
import u0.C0936a;

/* renamed from: androidx.appcompat.widget.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0209k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3115a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3116b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3117c;

    public /* synthetic */ RunnableC0209k(int i4, Object obj, Object obj2) {
        this.f3115a = i4;
        this.f3117c = obj;
        this.f3116b = obj2;
    }

    private void a() {
        B0.r rVar;
        t0.r rVar2 = ((A0.c) this.f3117c).f29a.f15330g;
        String str = (String) this.f3116b;
        synchronized (rVar2.f15413k) {
            try {
                t0.P pC = rVar2.c(str);
                rVar = pC != null ? pC.f15366d : null;
            } finally {
            }
        }
        if (rVar == null || !rVar.c()) {
            return;
        }
        synchronized (((A0.c) this.f3117c).f31c) {
            ((A0.c) this.f3117c).f34f.put(B0.f.v(rVar), rVar);
            Object obj = this.f3117c;
            ((A0.c) this.f3117c).f35g.put(B0.f.v(rVar), x0.k.a(((A0.c) obj).f36h, rVar, ((E0.c) ((A0.c) obj).f30b).f401b, (A0.c) obj));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v43, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v46, types: [t0.P] */
    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0659m interfaceC0659m;
        IAccountAccessor iAccountAccessor;
        int i4 = 0;
        switch (this.f3115a) {
            case 0:
                C0217o c0217o = (C0217o) this.f3117c;
                C0661o c0661o = c0217o.f3128c;
                if (c0661o != null && (interfaceC0659m = c0661o.f13242e) != null) {
                    interfaceC0659m.n(c0661o);
                }
                View view = (View) c0217o.f3133h;
                if (view != null && view.getWindowToken() != null) {
                    C0205i c0205i = (C0205i) this.f3116b;
                    if (c0205i.b()) {
                        c0217o.f3144s = (C0205i) this.f3116b;
                    } else if (c0205i.f13312f != null) {
                        c0205i.d(0, 0, false, false);
                        c0217o.f3144s = (C0205i) this.f3116b;
                    }
                }
                c0217o.f3146u = null;
                return;
            case 1:
            case 2:
            case 11:
            default:
                C0897q c0897q = (C0897q) this.f3117c;
                L3.k kVar = c0897q.f15118c;
                L3.i iVar = kVar.f1284d;
                if (iVar != null) {
                    iVar.c(kVar);
                }
                View view2 = (View) c0897q.f15123h;
                if (view2 != null && view2.getWindowToken() != null && ((C0895o) this.f3116b).j()) {
                    c0897q.f15110A = (C0895o) this.f3116b;
                    c0897q.f15124i.setAlpha(0.2f);
                }
                c0897q.f15112C = null;
                return;
            case 3:
                try {
                    Method method = androidx.core.app.g.f3283b;
                    Object obj = this.f3117c;
                    if (method != null) {
                        method.invoke(this.f3116b, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        androidx.core.app.g.f3284c.invoke(this.f3116b, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e4) {
                    if (e4.getClass() == RuntimeException.class && e4.getMessage() != null && e4.getMessage().startsWith("Unable to stop")) {
                        throw e4;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            case 4:
                try {
                    InterfaceC0126g interfaceC0126g = (InterfaceC0126g) this.f3116b;
                    Result.Companion companion = Result.INSTANCE;
                    interfaceC0126g.resumeWith(Result.m22constructorimpl(((D1.a) this.f3117c).get()));
                    return;
                } catch (Throwable th2) {
                    Throwable cause = th2.getCause();
                    if (cause == null) {
                        cause = th2;
                    }
                    if (th2 instanceof CancellationException) {
                        ((InterfaceC0126g) this.f3116b).i(cause);
                        return;
                    }
                    InterfaceC0126g interfaceC0126g2 = (InterfaceC0126g) this.f3116b;
                    Result.Companion companion2 = Result.INSTANCE;
                    interfaceC0126g2.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(cause)));
                    return;
                }
            case 5:
                try {
                    ((Worker) this.f3117c).getClass();
                    throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
                } catch (Throwable th3) {
                    ((D0.j) this.f3116b).k(th3);
                    return;
                }
            case 6:
                if (((t0.P) this.f3117c).f15379q.f390a instanceof D0.a) {
                    return;
                }
                try {
                    ((D1.a) this.f3116b).get();
                    s0.t.d().a(t0.P.f15362s, "Starting work for " + ((t0.P) this.f3117c).f15366d.f169c);
                    Object obj2 = this.f3117c;
                    ((t0.P) obj2).f15379q.l(((t0.P) obj2).f15367e.startWork());
                    return;
                } catch (Throwable th4) {
                    ((t0.P) this.f3117c).f15379q.k(th4);
                    return;
                }
            case 7:
                ?? r02 = this.f3117c;
                try {
                    try {
                        s0.r rVar = (s0.r) ((t0.P) r02).f15379q.get();
                        if (rVar == null) {
                            s0.t.d().b(t0.P.f15362s, ((t0.P) r02).f15366d.f169c + " returned a null result. Treating it as a failure.");
                        } else {
                            s0.t.d().a(t0.P.f15362s, ((t0.P) r02).f15366d.f169c + " returned a " + rVar + ".");
                            ((t0.P) r02).f15369g = rVar;
                        }
                    } catch (Throwable th5) {
                        ((t0.P) r02).b();
                        throw th5;
                    }
                } catch (InterruptedException | ExecutionException e5) {
                    s0.t.d().c(t0.P.f15362s, ((String) this.f3116b) + " failed because it threw an exception/error", e5);
                } catch (CancellationException e6) {
                    s0.t tVarD = s0.t.d();
                    String str = t0.P.f15362s;
                    String str2 = ((String) this.f3116b) + " was cancelled";
                    if (tVarD.f14213a <= 4) {
                        Log.i(str, str2, e6);
                    }
                }
                r02 = (t0.P) r02;
                r02.b();
                return;
            case 8:
                s0.t.d().a(C0936a.f15449e, "Scheduling work " + ((B0.r) this.f3116b).f167a);
                ((C0936a) this.f3117c).f15450a.e((B0.r) this.f3116b);
                return;
            case 9:
                a();
                return;
            case 10:
                try {
                    ((Runnable) this.f3117c).run();
                    synchronized (((C0.o) this.f3116b).f312d) {
                        ((C0.o) this.f3116b).a();
                    }
                    return;
                } catch (Throwable th6) {
                    synchronized (((C0.o) this.f3116b).f312d) {
                        ((C0.o) this.f3116b).a();
                        throw th6;
                    }
                }
            case 12:
                Object obj3 = this.f3117c;
                com.google.android.gms.common.api.internal.s sVar = (com.google.android.gms.common.api.internal.s) obj3;
                com.google.android.gms.common.api.internal.q qVar = (com.google.android.gms.common.api.internal.q) ((C0407e) sVar.f9684f).f9650j.get((C0403a) sVar.f9681c);
                if (qVar == null) {
                    return;
                }
                Object obj4 = this.f3116b;
                if (((ConnectionResult) obj4).f9598b != 0) {
                    qVar.l((ConnectionResult) obj4, null);
                    return;
                }
                sVar.f9679a = true;
                if (((Z0.c) sVar.f9680b).g()) {
                    if (!sVar.f9679a || (iAccountAccessor = (IAccountAccessor) sVar.f9682d) == null) {
                        return;
                    }
                    ((Z0.c) sVar.f9680b).b(iAccountAccessor, (Set) sVar.f9683e);
                    return;
                }
                try {
                    Object obj5 = ((com.google.android.gms.common.api.internal.s) obj3).f9680b;
                    ((Z0.c) obj5).b(null, ((Z0.c) obj5).a());
                    return;
                } catch (SecurityException e7) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e7);
                    ((Z0.c) sVar.f9680b).c("Failed to get service from broker.");
                    qVar.l(new ConnectionResult(10), null);
                    return;
                }
            case 13:
                zact.zad((zact) this.f3117c, (zak) this.f3116b);
                return;
            case 14:
                ((com.google.android.gms.common.api.internal.l) this.f3117c).getClass();
                return;
            case 15:
                synchronized (((C0760e) this.f3117c).f13457b) {
                    try {
                        InterfaceC0757b interfaceC0757b = ((C0760e) this.f3117c).f13458c;
                        if (interfaceC0757b != null) {
                            interfaceC0757b.a((l1.h) this.f3116b);
                        }
                    } finally {
                    }
                }
                return;
            case 16:
                com.stepos.statsrpk.service.d dVar = (com.stepos.statsrpk.service.d) this.f3117c;
                String str3 = (String) this.f3116b;
                dVar.getClass();
                T2.d.a("a", "environmentChanged. changeName: " + str3);
                ArrayList arrayListD = dVar.f12381c.d();
                if ("CHANGE_NAME_NETWORKCONNECT".equals(str3)) {
                    Iterator it = arrayListD.iterator();
                    while (it.hasNext()) {
                        dVar.j((String) it.next());
                    }
                    return;
                } else {
                    if ("CHANGE_NAME_POWER".equals(str3)) {
                        Iterator it2 = arrayListD.iterator();
                        while (it2.hasNext()) {
                            dVar.j((String) it2.next());
                        }
                        return;
                    }
                    return;
                }
            case 17:
                ((InterfaceC0126g) this.f3117c).j((Z2.A) this.f3116b, Unit.INSTANCE);
                return;
            case 18:
                break;
            case 19:
                m3.j jVarB = ((m3.i) this.f3116b).b();
                if (jVarB == null) {
                    throw new IllegalStateException("No pending post available");
                }
                ((m3.e) this.f3117c).d(jVarB);
                return;
            case 20:
                ActionBarCoordinatorLayout.K((ActionBarCoordinatorLayout) this.f3117c, (StepOSRecyclerView) this.f3116b);
                return;
            case 21:
                View view3 = (View) this.f3116b;
                if (view3 == null || view3.getWindowToken() == null || !((C0897q) this.f3117c).f15111B.i()) {
                    return;
                }
                ((View) this.f3116b).setAlpha(0.2f);
                return;
        }
        while (true) {
            try {
                ((Runnable) this.f3116b).run();
            } catch (Throwable th7) {
                Z2.C.a(EmptyCoroutineContext.INSTANCE, th7);
            }
            d3.j jVar = (d3.j) this.f3117c;
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d3.j.f12459f;
            Runnable runnableE = jVar.e();
            if (runnableE == null) {
                return;
            }
            this.f3116b = runnableE;
            i4++;
            if (i4 >= 16 && jVar.f12460a.isDispatchNeeded(jVar)) {
                jVar.f12460a.dispatch(jVar, this);
                return;
            }
        }
    }

    public /* synthetic */ RunnableC0209k(Object obj, Object obj2, int i4) {
        this.f3115a = i4;
        this.f3116b = obj;
        this.f3117c = obj2;
    }

    public RunnableC0209k(m3.e eVar) {
        this.f3115a = 19;
        this.f3117c = eVar;
        this.f3116b = new m3.i();
    }
}
