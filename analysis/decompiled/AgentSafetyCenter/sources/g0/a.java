package g0;

import android.view.ViewGroup;
import java.util.LinkedHashMap;
import k0.a2;
import k0.c1;
import k0.k1;
import t.o0;
import u1.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements a2, n, o0 {

    /* renamed from: c, reason: collision with root package name */
    public boolean f4123c;

    /* renamed from: f, reason: collision with root package name */
    public ed.e f4124f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4125g;

    /* renamed from: h, reason: collision with root package name */
    public float f4126h;
    public c1 i;

    /* renamed from: j, reason: collision with root package name */
    public c1 f4127j;

    /* renamed from: k, reason: collision with root package name */
    public ViewGroup f4128k;

    /* renamed from: l, reason: collision with root package name */
    public m f4129l;

    /* renamed from: m, reason: collision with root package name */
    public k1 f4130m;

    /* renamed from: n, reason: collision with root package name */
    public k1 f4131n;

    /* renamed from: o, reason: collision with root package name */
    public long f4132o;

    /* renamed from: p, reason: collision with root package name */
    public int f4133p;

    /* renamed from: q, reason: collision with root package name */
    public ad.l f4134q;

    @Override // g0.n
    public final void D() {
        this.f4130m.setValue(null);
    }

    @Override // k0.a2
    public final void a() {
        m mVar = this.f4129l;
        if (mVar != null) {
            D();
            p5.l lVar = mVar.f4170h;
            o oVar = (o) ((LinkedHashMap) lVar.f9738c).get(this);
            if (oVar != null) {
                oVar.c();
                LinkedHashMap linkedHashMap = (LinkedHashMap) lVar.f9738c;
                o oVar2 = (o) linkedHashMap.get(this);
                if (oVar2 != null) {
                }
                linkedHashMap.remove(this);
                mVar.f4169g.add(oVar);
            }
        }
    }

    @Override // k0.a2
    public final void b() {
        m mVar = this.f4129l;
        if (mVar != null) {
            D();
            p5.l lVar = mVar.f4170h;
            o oVar = (o) ((LinkedHashMap) lVar.f9738c).get(this);
            if (oVar != null) {
                oVar.c();
                LinkedHashMap linkedHashMap = (LinkedHashMap) lVar.f9738c;
                o oVar2 = (o) linkedHashMap.get(this);
                if (oVar2 != null) {
                }
                linkedHashMap.remove(this);
                mVar.f4169g.add(oVar);
            }
        }
    }

    @Override // t.o0
    public final void e(i0 i0Var) {
        f1.b bVar = i0Var.f13838c;
        this.f4132o = bVar.e();
        float f5 = this.f4126h;
        this.f4133p = Float.isNaN(f5) ? ac.a.Q(l.a(i0Var, this.f4125g, bVar.e())) : bVar.e0(f5);
        long j10 = ((d1.p) this.i.getValue()).f3026a;
        float f10 = ((g) this.f4127j.getValue()).f4145d;
        i0Var.b();
        this.f4124f.b(i0Var, Float.isNaN(f5) ? l.a(i0Var, this.f4123c, bVar.e()) : i0Var.X(f5), j10);
        d1.o oVarY = bVar.f3859f.y();
        ((Boolean) this.f4131n.getValue()).booleanValue();
        o oVar = (o) this.f4130m.getValue();
        if (oVar != null) {
            oVar.e(bVar.e(), j10, f10);
            oVar.draw(d1.b.a(oVarY));
        }
    }

    @Override // k0.a2
    public final void c() {
    }
}
