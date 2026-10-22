package o;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import b0.b1;
import b0.o1;

/* loaded from: classes.dex */
public final class g implements t0 {

    /* renamed from: f, reason: collision with root package name */
    public t0.b f7048f;

    /* renamed from: g, reason: collision with root package name */
    public final y f7049g;

    /* renamed from: h, reason: collision with root package name */
    public final o1 f7050h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f7051i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7052j;

    /* renamed from: k, reason: collision with root package name */
    public long f7053k;

    /* renamed from: l, reason: collision with root package name */
    public c1.k f7054l;

    /* renamed from: m, reason: collision with root package name */
    public final n0.m f7055m;

    public g(Context context, r0 r0Var) {
        y yVar = new y(context, u0.z.o(r0Var.f7123a));
        this.f7049g = yVar;
        b1 b1Var = b1.f1108h;
        c7.r rVar = c7.r.f1986a;
        this.f7050h = new o1(rVar, b1Var);
        this.f7051i = true;
        this.f7053k = 0L;
        a5.b bVar = new a5.b(this, null, 19);
        c1.f fVar = c1.t.f1840a;
        this.f7055m = new SuspendPointerInputElement(rVar, null, new c1.s(bVar), 6).c(Build.VERSION.SDK_INT >= 31 ? new x(this, yVar) : new x(this, yVar, r0Var));
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0167, code lost:
    
        if (r4 == r6) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // o.t0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r18, p.x0 r20, g7.d r21) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.g.a(long, p.x0, g7.d):java.lang.Object");
    }

    @Override // o.t0
    public final boolean b() {
        y yVar = this.f7049g;
        EdgeEffect edgeEffect = yVar.f7150d;
        h hVar = h.f7056a;
        if (edgeEffect != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? hVar.b(edgeEffect) : 0.0f) != 0.0f) {
                return true;
            }
        }
        EdgeEffect edgeEffect2 = yVar.f7151e;
        if (edgeEffect2 != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? hVar.b(edgeEffect2) : 0.0f) != 0.0f) {
                return true;
            }
        }
        EdgeEffect edgeEffect3 = yVar.f7152f;
        if (edgeEffect3 != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? hVar.b(edgeEffect3) : 0.0f) != 0.0f) {
                return true;
            }
        }
        EdgeEffect edgeEffect4 = yVar.f7153g;
        if (edgeEffect4 != null) {
            return (Build.VERSION.SDK_INT >= 31 ? hVar.b(edgeEffect4) : 0.0f) != 0.0f;
        }
        return false;
    }

    @Override // o.t0
    public final n0.m c() {
        return this.f7055m;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0149 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014d  */
    @Override // o.t0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long d(long r18, int r20, c1.w r21) {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.g.d(long, int, c1.w):long");
    }

    public final void e() {
        boolean zIsFinished;
        y yVar = this.f7049g;
        EdgeEffect edgeEffect = yVar.f7150d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = edgeEffect.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = yVar.f7151e;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished = edgeEffect2.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect3 = yVar.f7152f;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished = edgeEffect3.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect4 = yVar.f7153g;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished = edgeEffect4.isFinished() || zIsFinished;
        }
        if (zIsFinished) {
            g();
        }
    }

    public final long f() {
        t0.b bVar = this.f7048f;
        long jR = bVar != null ? bVar.f9654a : nb.i.r(this.f7053k);
        return n7.b.b(t0.b.d(jR) / t0.e.d(this.f7053k), t0.b.e(jR) / t0.e.b(this.f7053k));
    }

    public final void g() {
        if (this.f7051i) {
            this.f7050h.setValue(c7.r.f1986a);
        }
    }

    public final float h(long j2) {
        float fD = t0.b.d(f());
        float fE = t0.b.e(j2) / t0.e.b(this.f7053k);
        EdgeEffect edgeEffectB = this.f7049g.b();
        float fC = -fE;
        float f10 = 1 - fD;
        int i2 = Build.VERSION.SDK_INT;
        h hVar = h.f7056a;
        if (i2 >= 31) {
            fC = hVar.c(edgeEffectB, fC, f10);
        } else {
            edgeEffectB.onPull(fC, f10);
        }
        return (i2 >= 31 ? hVar.b(edgeEffectB) : 0.0f) == 0.0f ? t0.e.b(this.f7053k) * (-fC) : t0.b.e(j2);
    }

    public final float i(long j2) {
        float fE = t0.b.e(f());
        float fD = t0.b.d(j2) / t0.e.d(this.f7053k);
        EdgeEffect edgeEffectC = this.f7049g.c();
        float f10 = 1 - fE;
        int i2 = Build.VERSION.SDK_INT;
        h hVar = h.f7056a;
        if (i2 >= 31) {
            fD = hVar.c(edgeEffectC, fD, f10);
        } else {
            edgeEffectC.onPull(fD, f10);
        }
        return (i2 >= 31 ? hVar.b(edgeEffectC) : 0.0f) == 0.0f ? t0.e.d(this.f7053k) * fD : t0.b.d(j2);
    }

    public final float j(long j2) {
        float fE = t0.b.e(f());
        float fD = t0.b.d(j2) / t0.e.d(this.f7053k);
        EdgeEffect edgeEffectD = this.f7049g.d();
        float fC = -fD;
        int i2 = Build.VERSION.SDK_INT;
        h hVar = h.f7056a;
        if (i2 >= 31) {
            fC = hVar.c(edgeEffectD, fC, fE);
        } else {
            edgeEffectD.onPull(fC, fE);
        }
        return (i2 >= 31 ? hVar.b(edgeEffectD) : 0.0f) == 0.0f ? t0.e.d(this.f7053k) * (-fC) : t0.b.d(j2);
    }

    public final float k(long j2) {
        float fD = t0.b.d(f());
        float fE = t0.b.e(j2) / t0.e.b(this.f7053k);
        EdgeEffect edgeEffectE = this.f7049g.e();
        int i2 = Build.VERSION.SDK_INT;
        h hVar = h.f7056a;
        if (i2 >= 31) {
            fE = hVar.c(edgeEffectE, fE, fD);
        } else {
            edgeEffectE.onPull(fE, fD);
        }
        return (i2 >= 31 ? hVar.b(edgeEffectE) : 0.0f) == 0.0f ? t0.e.b(this.f7053k) * fE : t0.b.e(j2);
    }

    public final void l(long j2) {
        boolean zA = t0.e.a(this.f7053k, 0L);
        boolean zA2 = t0.e.a(j2, this.f7053k);
        this.f7053k = j2;
        if (!zA2) {
            long jA = ib.k.a(s7.a.U(t0.e.d(j2)), s7.a.U(t0.e.b(j2)));
            y yVar = this.f7049g;
            yVar.f7149c = jA;
            EdgeEffect edgeEffect = yVar.f7150d;
            if (edgeEffect != null) {
                edgeEffect.setSize((int) (jA >> 32), (int) (jA & 4294967295L));
            }
            EdgeEffect edgeEffect2 = yVar.f7151e;
            if (edgeEffect2 != null) {
                edgeEffect2.setSize((int) (jA >> 32), (int) (jA & 4294967295L));
            }
            EdgeEffect edgeEffect3 = yVar.f7152f;
            if (edgeEffect3 != null) {
                edgeEffect3.setSize((int) (jA & 4294967295L), (int) (jA >> 32));
            }
            EdgeEffect edgeEffect4 = yVar.f7153g;
            if (edgeEffect4 != null) {
                edgeEffect4.setSize((int) (jA & 4294967295L), (int) (jA >> 32));
            }
            EdgeEffect edgeEffect5 = yVar.f7154h;
            if (edgeEffect5 != null) {
                edgeEffect5.setSize((int) (jA >> 32), (int) (jA & 4294967295L));
            }
            EdgeEffect edgeEffect6 = yVar.f7155i;
            if (edgeEffect6 != null) {
                edgeEffect6.setSize((int) (jA >> 32), (int) (jA & 4294967295L));
            }
            EdgeEffect edgeEffect7 = yVar.f7156j;
            if (edgeEffect7 != null) {
                edgeEffect7.setSize((int) (jA & 4294967295L), (int) (jA >> 32));
            }
            EdgeEffect edgeEffect8 = yVar.f7157k;
            if (edgeEffect8 != null) {
                edgeEffect8.setSize((int) (jA & 4294967295L), (int) (jA >> 32));
            }
        }
        if (zA || zA2) {
            return;
        }
        g();
        e();
    }
}
