package ja;

import android.os.Handler;
import android.os.Looper;
import b0.b2;
import g7.l;
import ia.g1;
import ia.j0;
import ia.m;
import ia.n0;
import ia.p0;
import ia.s1;
import ia.x;
import ia.z;
import java.util.concurrent.CancellationException;
import na.o;
import q7.k;

/* loaded from: classes.dex */
public final class d extends x implements j0 {

    /* renamed from: h, reason: collision with root package name */
    public final Handler f5421h;

    /* renamed from: i, reason: collision with root package name */
    public final String f5422i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f5423j;

    /* renamed from: k, reason: collision with root package name */
    public final d f5424k;

    public d(Handler handler, String str, boolean z4) {
        this.f5421h = handler;
        this.f5422i = str;
        this.f5423j = z4;
        this.f5424k = z4 ? this : new d(handler, str, true);
    }

    @Override // ia.j0
    public final p0 C(long j2, final Runnable runnable, l lVar) {
        if (j2 > 4611686018427387903L) {
            j2 = 4611686018427387903L;
        }
        if (this.f5421h.postDelayed(runnable, j2)) {
            return new p0() { // from class: ja.c
                @Override // ia.p0
                public final void a() {
                    this.f5419f.f5421h.removeCallbacks(runnable);
                }
            };
        }
        U(lVar, runnable);
        return s1.f5001f;
    }

    @Override // ia.x
    public final void R(l lVar, Runnable runnable) {
        if (this.f5421h.post(runnable)) {
            return;
        }
        U(lVar, runnable);
    }

    @Override // ia.x
    public final boolean S(l lVar) {
        return (this.f5423j && k.a(Looper.myLooper(), this.f5421h.getLooper())) ? false : true;
    }

    public final void U(l lVar, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        g1 g1Var = (g1) lVar.o(z.f5027g);
        if (g1Var != null) {
            g1Var.d(cancellationException);
        }
        pa.e eVar = n0.f4982a;
        pa.d.f8556h.R(lVar, runnable);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f5421h == this.f5421h && dVar.f5423j == this.f5423j;
    }

    public final int hashCode() {
        return (this.f5423j ? 1231 : 1237) ^ System.identityHashCode(this.f5421h);
    }

    @Override // ia.j0
    public final void k(long j2, m mVar) {
        c.b bVar = new c.b(3, mVar, this);
        if (j2 > 4611686018427387903L) {
            j2 = 4611686018427387903L;
        }
        if (this.f5421h.postDelayed(bVar, j2)) {
            mVar.u(new b2(3, this, bVar));
        } else {
            U(mVar.f4975j, bVar);
        }
    }

    @Override // ia.x
    public final String toString() {
        d dVar;
        String str;
        pa.e eVar = n0.f4982a;
        d dVar2 = o.f6923a;
        if (this == dVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                dVar = dVar2.f5424k;
            } catch (UnsupportedOperationException unused) {
                dVar = null;
            }
            str = this == dVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f5422i;
        if (string == null) {
            string = this.f5421h.toString();
        }
        return this.f5423j ? a1.a.i(string, ".immediate") : string;
    }

    public d(Handler handler) {
        this(handler, null, false);
    }
}
