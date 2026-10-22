package i1;

import android.graphics.Path;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends c0 {

    /* renamed from: b, reason: collision with root package name */
    public d1.f0 f5682b;

    /* renamed from: c, reason: collision with root package name */
    public float f5683c;

    /* renamed from: d, reason: collision with root package name */
    public List f5684d;

    /* renamed from: e, reason: collision with root package name */
    public float f5685e;

    /* renamed from: f, reason: collision with root package name */
    public float f5686f;

    /* renamed from: g, reason: collision with root package name */
    public d1.f0 f5687g;

    /* renamed from: h, reason: collision with root package name */
    public int f5688h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public float f5689j;

    /* renamed from: k, reason: collision with root package name */
    public float f5690k;

    /* renamed from: l, reason: collision with root package name */
    public float f5691l;

    /* renamed from: m, reason: collision with root package name */
    public float f5692m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5693n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5694o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5695p;

    /* renamed from: q, reason: collision with root package name */
    public f1.g f5696q;

    /* renamed from: r, reason: collision with root package name */
    public d1.h f5697r;

    /* renamed from: s, reason: collision with root package name */
    public d1.h f5698s;

    /* renamed from: t, reason: collision with root package name */
    public Object f5699t;

    @Override // i1.c0
    public final void a(f1.d dVar) {
        f1.g gVar;
        if (this.f5693n) {
            b.d(this.f5684d, this.f5697r);
            e();
        } else if (this.f5695p) {
            e();
        }
        this.f5693n = false;
        this.f5695p = false;
        d1.f0 f0Var = this.f5682b;
        if (f0Var != null) {
            f1.d.x(dVar, this.f5698s, f0Var, this.f5683c, null, 56);
        }
        d1.f0 f0Var2 = this.f5687g;
        if (f0Var2 != null) {
            f1.g gVar2 = this.f5696q;
            if (this.f5694o || gVar2 == null) {
                f1.g gVar3 = new f1.g(this.f5686f, this.f5689j, this.f5688h, this.i, null, 16);
                this.f5696q = gVar3;
                this.f5694o = false;
                gVar = gVar3;
            } else {
                gVar = gVar2;
            }
            f1.d.x(dVar, this.f5698s, f0Var2, this.f5685e, gVar, 48);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, jb.d] */
    public final void e() {
        ?? r02 = this.f5699t;
        d1.h hVar = this.f5697r;
        if (this.f5690k == 0.0f && this.f5691l == 1.0f) {
            this.f5698s = hVar;
            return;
        }
        if (yb.k.a(this.f5698s, hVar)) {
            this.f5698s = d1.k.a();
        } else {
            Path.FillType fillType = this.f5698s.f2990a.getFillType();
            Path.FillType fillType2 = Path.FillType.EVEN_ODD;
            boolean z10 = fillType == fillType2;
            this.f5698s.f2990a.rewind();
            Path path = this.f5698s.f2990a;
            if (!z10) {
                fillType2 = Path.FillType.WINDING;
            }
            path.setFillType(fillType2);
        }
        ((d1.j) r02.getValue()).f3001a.setPath(hVar != null ? hVar.f2990a : null, false);
        float length = ((d1.j) r02.getValue()).f3001a.getLength();
        float f5 = this.f5690k;
        float f10 = this.f5692m;
        float f11 = ((f5 + f10) % 1.0f) * length;
        float f12 = ((this.f5691l + f10) % 1.0f) * length;
        if (f11 <= f12) {
            ((d1.j) r02.getValue()).a(f11, f12, this.f5698s);
        } else {
            ((d1.j) r02.getValue()).a(f11, length, this.f5698s);
            ((d1.j) r02.getValue()).a(0.0f, f12, this.f5698s);
        }
    }

    public final String toString() {
        return this.f5697r.toString();
    }
}
