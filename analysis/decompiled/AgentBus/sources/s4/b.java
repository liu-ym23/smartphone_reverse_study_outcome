package s4;

import android.content.Context;
import c7.r;
import d5.e;
import d5.m;
import d5.n;
import d5.o;
import i7.c;
import ia.d0;
import ia.f1;
import ia.g1;
import ia.n0;
import ia.w1;
import ia.x1;
import java.util.concurrent.CancellationException;
import k5.t;
import la.e0;
import la.f0;
import la.j;
import la.j0;
import la.k0;
import la.s0;
import la.u0;
import na.d;
import q7.k;
import t4.g;

/* loaded from: classes.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f9486a;

    /* renamed from: b, reason: collision with root package name */
    public final t f9487b;

    /* renamed from: c, reason: collision with root package name */
    public final m f9488c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9489d;

    /* renamed from: e, reason: collision with root package name */
    public final d5.t f9490e;

    /* renamed from: f, reason: collision with root package name */
    public final d f9491f;

    /* renamed from: g, reason: collision with root package name */
    public final u0 f9492g;

    /* renamed from: h, reason: collision with root package name */
    public final f0 f9493h;

    /* renamed from: i, reason: collision with root package name */
    public final j0 f9494i;

    /* renamed from: j, reason: collision with root package name */
    public final e0 f9495j;

    /* renamed from: k, reason: collision with root package name */
    public final g f9496k;

    public b(Context context, t tVar) {
        k.e(context, "context");
        k.e(tVar, "logger");
        this.f9486a = "zeroclaw";
        this.f9487b = tVar;
        this.f9488c = m.GATEWAY;
        this.f9489d = "zeroclaw";
        this.f9490e = d5.t.CLOUD;
        x1 x1VarC = d0.c();
        pa.e eVar = n0.f4982a;
        d dVarB = d0.b(f1.plus(x1VarC, pa.d.f8556h));
        this.f9491f = dVarB;
        u0 u0VarC = k0.c(n.f2894c);
        this.f9492g = u0VarC;
        this.f9493h = new f0(u0VarC);
        j0 j0VarB = k0.b(0, 256, 5);
        this.f9494i = j0VarB;
        this.f9495j = new e0(j0VarB);
        this.f9496k = new g(context, dVarB, new t4.e(j0VarB), tVar, "com.stepos.stepclaw");
    }

    @Override // d5.e
    public final j a() {
        return this.f9495j;
    }

    @Override // d5.e
    public final Object b(c cVar) {
        g gVar = this.f9496k;
        w1 w1Var = gVar.f9744h;
        if (w1Var != null) {
            f1.cancel$default((g1) w1Var, (CancellationException) null, 1, (Object) null);
        }
        gVar.f9744h = null;
        if (gVar.f9746j) {
            try {
                gVar.f9741e.unbindService(gVar.f9747k);
            } catch (Throwable th) {
                w7.e0.n(th);
            }
            gVar.f9746j = false;
        }
        u0 u0Var = gVar.f9742f;
        u0Var.getClass();
        u0Var.g(null, t4.c.f9733a);
        d0.e(this.f9491f, null);
        u0 u0Var2 = this.f9492g;
        u0Var2.getClass();
        u0Var2.g(null, o.f2895a);
        return r.f1986a;
    }

    @Override // d5.e
    public final d5.t c() {
        return this.f9490e;
    }

    @Override // d5.e
    public final boolean d() {
        return d5.d.getAcceptsBusinessRpc(this);
    }

    @Override // d5.e
    public final String e() {
        return d5.d.getClientId(this);
    }

    @Override // d5.e
    public final m f() {
        return this.f9488c;
    }

    @Override // d5.e
    public final String g() {
        return this.f9489d;
    }

    @Override // d5.e
    public final String getId() {
        return this.f9486a;
    }

    @Override // d5.e
    public final s0 h() {
        return this.f9493h;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c2  */
    @Override // d5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(c5.b r14, i7.c r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.b.i(c5.b, i7.c):java.lang.Object");
    }
}
