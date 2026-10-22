package K;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import java.util.UUID;
import s0.C0852j;

/* loaded from: classes.dex */
public final class i0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f972a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f973b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f974c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f975d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f976e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f977f;

    public /* synthetic */ i0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i4) {
        this.f972a = i4;
        this.f977f = obj;
        this.f973b = obj2;
        this.f974c = obj3;
        this.f975d = obj4;
        this.f976e = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f972a) {
            case 0:
                k0.h0((View) this.f973b, (B0.e) this.f975d);
                ((ValueAnimator) this.f976e).start();
                return;
            default:
                try {
                    if (!(((D0.j) this.f973b).f390a instanceof D0.a)) {
                        String string = ((UUID) this.f974c).toString();
                        B0.r rVarI = ((C0.u) this.f977f).f324c.i(string);
                        if (rVarI == null || rVarI.f168b.a()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        ((t0.r) ((C0.u) this.f977f).f323b).h(string, (C0852j) this.f975d);
                        ((Context) this.f976e).startService(A0.c.a((Context) this.f976e, B0.f.v(rVarI), (C0852j) this.f975d));
                    }
                    ((D0.j) this.f973b).j(null);
                    return;
                } catch (Throwable th) {
                    ((D0.j) this.f973b).k(th);
                    return;
                }
        }
    }
}
