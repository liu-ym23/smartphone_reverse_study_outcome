package androidx.compose.ui.graphics;

import i1.d1;
import i1.w0;
import kotlin.Metadata;
import m.x;
import n.f;
import n0.l;
import q7.k;
import r8.c;
import u0.c0;
import u0.d0;
import u0.f0;
import u0.m;
import u0.z;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerElement;", "Li1/w0;", "Lu0/d0;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class GraphicsLayerElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f758a;

    /* renamed from: b, reason: collision with root package name */
    public final long f759b;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f760c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f761d;

    /* renamed from: e, reason: collision with root package name */
    public final long f762e;

    /* renamed from: f, reason: collision with root package name */
    public final long f763f;

    public GraphicsLayerElement(float f10, long j2, c0 c0Var, boolean z4, long j4, long j10) {
        this.f758a = f10;
        this.f759b = j2;
        this.f760c = c0Var;
        this.f761d = z4;
        this.f762e = j4;
        this.f763f = j10;
    }

    @Override // i1.w0
    public final l d() {
        d0 d0Var = new d0();
        d0Var.f9895t = 1.0f;
        d0Var.f9896u = 1.0f;
        d0Var.f9897v = 1.0f;
        d0Var.f9898w = this.f758a;
        d0Var.f9899x = 8.0f;
        d0Var.f9900y = this.f759b;
        d0Var.f9901z = this.f760c;
        d0Var.A = this.f761d;
        d0Var.B = this.f762e;
        d0Var.C = this.f763f;
        d0Var.D = 3;
        d0Var.E = new c(8, d0Var);
        return d0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GraphicsLayerElement) {
            GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) obj;
            if (Float.compare(1.0f, 1.0f) == 0 && Float.compare(1.0f, 1.0f) == 0 && Float.compare(1.0f, 1.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(this.f758a, graphicsLayerElement.f758a) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(8.0f, 8.0f) == 0) {
                long j2 = graphicsLayerElement.f759b;
                int i2 = f0.f9907b;
                if (this.f759b == j2 && k.a(this.f760c, graphicsLayerElement.f760c) && this.f761d == graphicsLayerElement.f761d && m.c(this.f762e, graphicsLayerElement.f762e) && m.c(this.f763f, graphicsLayerElement.f763f)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        d0 d0Var = (d0) lVar;
        d0Var.f9895t = 1.0f;
        d0Var.f9896u = 1.0f;
        d0Var.f9897v = 1.0f;
        d0Var.f9898w = this.f758a;
        d0Var.f9899x = 8.0f;
        d0Var.f9900y = this.f759b;
        d0Var.f9901z = this.f760c;
        d0Var.A = this.f761d;
        d0Var.B = this.f762e;
        d0Var.C = this.f763f;
        d0Var.D = 3;
        d1 d1Var = i1.l.s(d0Var, 2).f4438u;
        if (d1Var != null) {
            d1Var.W0(d0Var.E, true);
        }
    }

    public final int hashCode() {
        int iD = x.d(8.0f, x.d(0.0f, x.d(0.0f, x.d(0.0f, x.d(this.f758a, x.d(0.0f, x.d(0.0f, x.d(1.0f, x.d(1.0f, Float.hashCode(1.0f) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31);
        int i2 = f0.f9907b;
        int iE = x.e((this.f760c.hashCode() + x.f(this.f759b, iD, 31)) * 31, 961, this.f761d);
        int i10 = m.f9917g;
        return f.b(3, f.b(0, x.f(this.f763f, x.f(this.f762e, iE, 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("GraphicsLayerElement(scaleX=1.0, scaleY=1.0, alpha=1.0, translationX=0.0, translationY=0.0, shadowElevation=");
        sb2.append(this.f758a);
        sb2.append(", rotationX=0.0, rotationY=0.0, rotationZ=0.0, cameraDistance=8.0, transformOrigin=");
        sb2.append((Object) f0.c(this.f759b));
        sb2.append(", shape=");
        sb2.append(this.f760c);
        sb2.append(", clip=");
        sb2.append(this.f761d);
        sb2.append(", renderEffect=null, ambientShadowColor=");
        x.u(this.f762e, sb2, ", spotShadowColor=");
        sb2.append((Object) m.i(this.f763f));
        sb2.append(", compositingStrategy=CompositingStrategy(value=0), blendMode=");
        sb2.append((Object) z.r(3));
        sb2.append(", colorFilter=null)");
        return sb2.toString();
    }
}
