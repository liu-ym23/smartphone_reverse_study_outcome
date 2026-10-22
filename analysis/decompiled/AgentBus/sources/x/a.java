package x;

import android.view.ViewGroup;
import b0.f1;
import b0.k2;
import b0.o1;
import java.util.LinkedHashMap;
import o.h0;

/* loaded from: classes.dex */
public final class a implements k2, m, h0 {

    /* renamed from: f, reason: collision with root package name */
    public final c1.o f10992f;

    /* renamed from: i, reason: collision with root package name */
    public final f1 f10995i;

    /* renamed from: j, reason: collision with root package name */
    public final f1 f10996j;

    /* renamed from: k, reason: collision with root package name */
    public final ViewGroup f10997k;

    /* renamed from: l, reason: collision with root package name */
    public l f10998l;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10993g = true;

    /* renamed from: h, reason: collision with root package name */
    public final float f10994h = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public final o1 f10999m = b0.b.n(null);

    /* renamed from: n, reason: collision with root package name */
    public final o1 f11000n = b0.b.n(Boolean.TRUE);

    /* renamed from: o, reason: collision with root package name */
    public long f11001o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f11002p = -1;

    /* renamed from: q, reason: collision with root package name */
    public final t9.h f11003q = new t9.h(12, this);

    public a(f1 f1Var, f1 f1Var2, ViewGroup viewGroup) {
        this.f10992f = new c1.o(true, new t9.h(14, f1Var2));
        this.f10995i = f1Var;
        this.f10996j = f1Var2;
        this.f10997k = viewGroup;
    }

    @Override // x.m
    public final void P() {
        this.f10999m.setValue(null);
    }

    @Override // b0.k2
    public final void c() {
    }

    @Override // o.h0
    public final void e(i1.h0 h0Var) {
        w0.b bVar = h0Var.f4489f;
        this.f11001o = bVar.d();
        float f10 = this.f10994h;
        this.f11002p = Float.isNaN(f10) ? s7.a.U(k.a(h0Var, this.f10993g, bVar.d())) : bVar.y(f10);
        long j2 = ((u0.m) this.f10995i.getValue()).f9918a;
        float f11 = ((f) this.f10996j.getValue()).f11009d;
        h0Var.a();
        this.f10992f.b(h0Var, Float.isNaN(f10) ? k.a(h0Var, true, bVar.d()) : h0Var.o(f10), j2);
        u0.l lVarA = bVar.f10630g.a();
        ((Boolean) this.f11000n.getValue()).booleanValue();
        n nVar = (n) this.f10999m.getValue();
        if (nVar != null) {
            nVar.e(bVar.d(), j2, f11);
            nVar.draw(u0.b.a(lVarA));
        }
    }

    @Override // b0.k2
    public final void f() {
        l lVar = this.f10998l;
        if (lVar != null) {
            P();
            nb.f fVar = lVar.f11035i;
            n nVar = (n) ((LinkedHashMap) fVar.f6947g).get(this);
            if (nVar != null) {
                nVar.c();
                LinkedHashMap linkedHashMap = (LinkedHashMap) fVar.f6947g;
                n nVar2 = (n) linkedHashMap.get(this);
                if (nVar2 != null) {
                }
                linkedHashMap.remove(this);
                lVar.f11034h.add(nVar);
            }
        }
    }

    @Override // b0.k2
    public final void h() {
        l lVar = this.f10998l;
        if (lVar != null) {
            P();
            nb.f fVar = lVar.f11035i;
            n nVar = (n) ((LinkedHashMap) fVar.f6947g).get(this);
            if (nVar != null) {
                nVar.c();
                LinkedHashMap linkedHashMap = (LinkedHashMap) fVar.f6947g;
                n nVar2 = (n) linkedHashMap.get(this);
                if (nVar2 != null) {
                }
                linkedHashMap.remove(this);
                lVar.f11034h.add(nVar);
            }
        }
    }
}
