package u0;

import i1.l0;
import i1.m0;
import i1.s1;

/* loaded from: classes.dex */
public final class d0 extends n0.l implements i1.v, s1 {
    public boolean A;
    public long B;
    public long C;
    public int D;
    public r8.c E;

    /* renamed from: t, reason: collision with root package name */
    public float f9895t;

    /* renamed from: u, reason: collision with root package name */
    public float f9896u;

    /* renamed from: v, reason: collision with root package name */
    public float f9897v;

    /* renamed from: w, reason: collision with root package name */
    public float f9898w;

    /* renamed from: x, reason: collision with root package name */
    public float f9899x;

    /* renamed from: y, reason: collision with root package name */
    public long f9900y;

    /* renamed from: z, reason: collision with root package name */
    public c0 f9901z;

    @Override // i1.v
    public final l0 G(m0 m0Var, g1.o oVar, long j2) {
        g1.s sVarB = oVar.b(j2);
        return m0Var.l0(sVarB.f3756f, sVarB.f3757g, d7.a0.f2944f, new g1.y(26, sVarB, this));
    }

    @Override // n0.l
    public final boolean a0() {
        return false;
    }

    @Override // i1.s1
    public final boolean g() {
        return false;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SimpleGraphicsLayerModifier(scaleX=");
        sb2.append(this.f9895t);
        sb2.append(", scaleY=");
        sb2.append(this.f9896u);
        sb2.append(", alpha = ");
        sb2.append(this.f9897v);
        sb2.append(", translationX=0.0, translationY=0.0, shadowElevation=");
        sb2.append(this.f9898w);
        sb2.append(", rotationX=0.0, rotationY=0.0, rotationZ=0.0, cameraDistance=");
        sb2.append(this.f9899x);
        sb2.append(", transformOrigin=");
        sb2.append((Object) f0.c(this.f9900y));
        sb2.append(", shape=");
        sb2.append(this.f9901z);
        sb2.append(", clip=");
        sb2.append(this.A);
        sb2.append(", renderEffect=null, ambientShadowColor=");
        m.x.u(this.B, sb2, ", spotShadowColor=");
        m.x.u(this.C, sb2, ", compositingStrategy=CompositingStrategy(value=0), blendMode=");
        sb2.append((Object) z.r(this.D));
        sb2.append(", colorFilter=null)");
        return sb2.toString();
    }

    @Override // i1.s1
    public final void u(p1.i iVar) {
    }
}
