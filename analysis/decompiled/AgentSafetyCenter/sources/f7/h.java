package f7;

import android.graphics.RectF;
import t.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends c1 {

    /* renamed from: a, reason: collision with root package name */
    public int f3952a;

    @Override // t.c1
    public final float i(Object obj) {
        float[] fArr = ((i) obj).E;
        if (fArr != null) {
            return fArr[this.f3952a];
        }
        return 0.0f;
    }

    @Override // t.c1
    public final void m(float f5, Object obj) {
        float fA;
        i iVar = (i) obj;
        float[] fArr = iVar.E;
        if (fArr != null) {
            int i = this.f3952a;
            if (fArr[i] != f5) {
                fArr[i] = f5;
                b.b bVar = iVar.G;
                if (bVar != null) {
                    o oVar = iVar.f3969v;
                    if (fArr != null) {
                        fA = (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
                    } else {
                        RectF rectFD = iVar.d();
                        m mVar = iVar.f3954f.f3936a;
                        oVar.getClass();
                        fA = (((iVar.f3954f.f3936a.f3993h.a(rectFD) + mVar.f3990e.a(rectFD)) - iVar.f3954f.f3936a.f3992g.a(rectFD)) - iVar.f3954f.f3936a.f3991f.a(rectFD)) / 2.0f;
                    }
                    u6.c cVar = (u6.c) bVar.f1685f;
                    int i3 = (int) (fA * 0.11f);
                    if (cVar.f14125z != i3) {
                        cVar.f14125z = i3;
                        cVar.i();
                        cVar.invalidate();
                    }
                }
                iVar.invalidateSelf();
            }
        }
    }
}
