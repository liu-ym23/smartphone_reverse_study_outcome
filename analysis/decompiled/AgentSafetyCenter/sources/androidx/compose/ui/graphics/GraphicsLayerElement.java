package androidx.compose.ui.graphics;

import a2.m;
import d1.f0;
import d1.j0;
import d1.k0;
import d1.m0;
import d1.p;
import s.f;
import u1.g1;
import u1.y0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class GraphicsLayerElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public float f955c;

    /* renamed from: f, reason: collision with root package name */
    public float f956f;

    /* renamed from: g, reason: collision with root package name */
    public float f957g;

    /* renamed from: h, reason: collision with root package name */
    public float f958h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public long f959j;

    /* renamed from: k, reason: collision with root package name */
    public j0 f960k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f961l;

    /* renamed from: m, reason: collision with root package name */
    public long f962m;

    /* renamed from: n, reason: collision with root package name */
    public long f963n;

    /* renamed from: o, reason: collision with root package name */
    public int f964o;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) obj;
        return Float.compare(this.f955c, graphicsLayerElement.f955c) == 0 && Float.compare(this.f956f, graphicsLayerElement.f956f) == 0 && Float.compare(this.f957g, graphicsLayerElement.f957g) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(this.f958h, graphicsLayerElement.f958h) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(this.i, graphicsLayerElement.i) == 0 && m0.b(this.f959j, graphicsLayerElement.f959j) && k.a(this.f960k, graphicsLayerElement.f960k) && this.f961l == graphicsLayerElement.f961l && p.d(this.f962m, graphicsLayerElement.f962m) && p.d(this.f963n, graphicsLayerElement.f963n) && this.f964o == graphicsLayerElement.f964o;
    }

    @Override // u1.y0
    public final l g() {
        float f5 = this.f955c;
        float f10 = this.f956f;
        float f11 = this.f957g;
        float f12 = this.f958h;
        float f13 = this.i;
        long j10 = this.f959j;
        j0 j0Var = this.f960k;
        boolean z10 = this.f961l;
        long j11 = this.f962m;
        long j12 = this.f963n;
        int i = this.f964o;
        k0 k0Var = new k0();
        k0Var.f3002s = f5;
        k0Var.f3003t = f10;
        k0Var.f3004u = f11;
        k0Var.f3005v = f12;
        k0Var.f3006w = f13;
        k0Var.f3007x = j10;
        k0Var.f3008y = j0Var;
        k0Var.f3009z = z10;
        k0Var.A = j11;
        k0Var.B = j12;
        k0Var.C = i;
        k0Var.D = new m(k0Var, 2);
        return k0Var;
    }

    public final int hashCode() {
        int iG = k0.a.g(k0.a.g(k0.a.g(k0.a.g(k0.a.g(k0.a.g(k0.a.g(k0.a.g(k0.a.g(Float.hashCode(this.f955c) * 31, this.f956f, 31), this.f957g, 31), 0.0f, 31), 0.0f, 31), this.f958h, 31), 0.0f, 31), 0.0f, 31), 0.0f, 31), this.i, 31);
        long j10 = this.f959j;
        int i = m0.f3016c;
        int iH = k0.a.h((this.f960k.hashCode() + k0.a.i(j10, iG, 31)) * 31, 961, this.f961l);
        long j11 = this.f962m;
        int i3 = p.f3025h;
        return f.b(this.f964o, f.b(0, k0.a.i(this.f963n, k0.a.i(j11, iH, 31), 31), 31), 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        k0 k0Var = (k0) lVar;
        k0Var.f3002s = this.f955c;
        k0Var.f3003t = this.f956f;
        k0Var.f3004u = this.f957g;
        k0Var.f3005v = this.f958h;
        k0Var.f3006w = this.i;
        k0Var.f3007x = this.f959j;
        k0Var.f3008y = this.f960k;
        k0Var.f3009z = this.f961l;
        k0Var.A = this.f962m;
        k0Var.B = this.f963n;
        k0Var.C = this.f964o;
        g1 g1Var = u1.f.s(k0Var, 2).f13811t;
        if (g1Var != null) {
            g1Var.b1(k0Var.D, true);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("GraphicsLayerElement(scaleX=");
        sb2.append(this.f955c);
        sb2.append(", scaleY=");
        sb2.append(this.f956f);
        sb2.append(", alpha=");
        sb2.append(this.f957g);
        sb2.append(", translationX=0.0, translationY=0.0, shadowElevation=");
        sb2.append(this.f958h);
        sb2.append(", rotationX=0.0, rotationY=0.0, rotationZ=0.0, cameraDistance=");
        sb2.append(this.i);
        sb2.append(", transformOrigin=");
        sb2.append((Object) m0.c(this.f959j));
        sb2.append(", shape=");
        sb2.append(this.f960k);
        sb2.append(", clip=");
        sb2.append(this.f961l);
        sb2.append(", renderEffect=null, ambientShadowColor=");
        k0.a.z(this.f962m, sb2, ", spotShadowColor=");
        k0.a.z(this.f963n, sb2, ", compositingStrategy=CompositingStrategy(value=0), blendMode=");
        sb2.append((Object) f0.u(this.f964o));
        sb2.append(", colorFilter=null)");
        return sb2.toString();
    }
}
