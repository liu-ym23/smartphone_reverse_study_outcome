package d1;

import android.graphics.Paint;
import android.graphics.Shader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h0 extends f0 {

    /* renamed from: b, reason: collision with root package name */
    public a2.i f2994b;

    /* renamed from: c, reason: collision with root package name */
    public long f2995c = 9205357640488583168L;

    @Override // d1.f0
    public final void g(float f5, long j10, f fVar) {
        Paint paint = (Paint) fVar.f2968b;
        a2.i iVar = this.f2994b;
        if (iVar == null || !c1.e.b(this.f2995c, j10)) {
            if (c1.e.f(j10)) {
                this.f2994b = null;
                this.f2995c = 9205357640488583168L;
                iVar = null;
            } else {
                iVar = this.f2994b;
                if (iVar == null) {
                    iVar = new a2.i(5);
                    this.f2994b = iVar;
                }
                iVar.f49f = x(j10);
                this.f2994b = iVar;
                this.f2995c = j10;
            }
        }
        long jB = f0.b(paint.getColor());
        long j11 = p.f3019b;
        if (!p.d(jB, j11)) {
            fVar.e(j11);
        }
        if (!yb.k.a((Shader) fVar.f2969c, iVar != null ? (Shader) iVar.f49f : null)) {
            fVar.g(iVar != null ? (Shader) iVar.f49f : null);
        }
        if (paint.getAlpha() / 255.0f == f5) {
            return;
        }
        fVar.c(f5);
    }

    public abstract Shader x(long j10);
}
