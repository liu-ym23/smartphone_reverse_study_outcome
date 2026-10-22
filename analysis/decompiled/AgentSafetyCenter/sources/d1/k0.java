package d1;

import u1.o0;
import u1.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends w0.l implements u1.w, v1 {
    public long A;
    public long B;
    public int C;
    public a2.m D;

    /* renamed from: s, reason: collision with root package name */
    public float f3002s;

    /* renamed from: t, reason: collision with root package name */
    public float f3003t;

    /* renamed from: u, reason: collision with root package name */
    public float f3004u;

    /* renamed from: v, reason: collision with root package name */
    public float f3005v;

    /* renamed from: w, reason: collision with root package name */
    public float f3006w;

    /* renamed from: x, reason: collision with root package name */
    public long f3007x;

    /* renamed from: y, reason: collision with root package name */
    public j0 f3008y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3009z;

    @Override // u1.w
    public final s1.g0 f(o0 o0Var, s1.e0 e0Var, long j10) {
        s1.o0 o0VarQ = e0Var.q(j10);
        return o0Var.Y(o0VarQ.f11277c, o0VarQ.f11278f, kb.t.f7405c, new b0.n(4, o0VarQ, this));
    }

    @Override // u1.v1
    public final boolean g() {
        return false;
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SimpleGraphicsLayerModifier(scaleX=");
        sb2.append(this.f3002s);
        sb2.append(", scaleY=");
        sb2.append(this.f3003t);
        sb2.append(", alpha = ");
        sb2.append(this.f3004u);
        sb2.append(", translationX=0.0, translationY=0.0, shadowElevation=");
        sb2.append(this.f3005v);
        sb2.append(", rotationX=0.0, rotationY=0.0, rotationZ=0.0, cameraDistance=");
        sb2.append(this.f3006w);
        sb2.append(", transformOrigin=");
        sb2.append((Object) m0.c(this.f3007x));
        sb2.append(", shape=");
        sb2.append(this.f3008y);
        sb2.append(", clip=");
        sb2.append(this.f3009z);
        sb2.append(", renderEffect=null, ambientShadowColor=");
        k0.a.z(this.A, sb2, ", spotShadowColor=");
        k0.a.z(this.B, sb2, ", compositingStrategy=CompositingStrategy(value=0), blendMode=");
        sb2.append((Object) f0.u(this.C));
        sb2.append(", colorFilter=null)");
        return sb2.toString();
    }

    @Override // u1.v1
    public final void f0(a2.k kVar) {
    }
}
