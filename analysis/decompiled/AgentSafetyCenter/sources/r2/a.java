package r2;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import n3.m1;
import n3.r0;
import n3.t0;
import p5.u;
import s1.v0;
import u1.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends r0 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10366f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f10367g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(ViewGroup viewGroup, int i) {
        super(1);
        this.f10366f = i;
        this.f10367g = viewGroup;
    }

    @Override // n3.r0
    public final m1 h(m1 m1Var, List list) {
        switch (this.f10366f) {
            case 0:
                return ((q) this.f10367g).f(m1Var);
            default:
                s2.j jVar = (s2.j) this.f10367g;
                if (jVar.f11351p) {
                    return m1Var;
                }
                View childAt = jVar.getChildAt(0);
                int iMax = Math.max(0, childAt.getLeft());
                int iMax2 = Math.max(0, childAt.getTop());
                int iMax3 = Math.max(0, jVar.getWidth() - childAt.getRight());
                int iMax4 = Math.max(0, jVar.getHeight() - childAt.getBottom());
                return (iMax == 0 && iMax2 == 0 && iMax3 == 0 && iMax4 == 0) ? m1Var : m1Var.f8737a.r(iMax, iMax2, iMax3, iMax4);
        }
    }

    @Override // n3.r0
    public final u i(t0 t0Var, u uVar) {
        switch (this.f10366f) {
            case 0:
                s sVar = ((q) this.f10367g).C.H.f13743c;
                if (!sVar.R.f15126r) {
                    return uVar;
                }
                long jH = td.h.H(sVar.D(0L));
                int i = (int) (jH >> 32);
                if (i < 0) {
                    i = 0;
                }
                int i3 = (int) (jH & 4294967295L);
                if (i3 < 0) {
                    i3 = 0;
                }
                long jL = v0.i(sVar).l();
                int i10 = (int) (jL >> 32);
                int i11 = (int) (jL & 4294967295L);
                long j10 = sVar.f11279g;
                long jH2 = td.h.H(sVar.D((Float.floatToRawIntBits((int) (j10 >> 32)) << 32) | (Float.floatToRawIntBits((int) (j10 & 4294967295L)) & 4294967295L)));
                int i12 = i10 - ((int) (jH2 >> 32));
                if (i12 < 0) {
                    i12 = 0;
                }
                int i13 = i11 - ((int) (jH2 & 4294967295L));
                int i14 = i13 >= 0 ? i13 : 0;
                return (i == 0 && i3 == 0 && i12 == 0 && i14 == 0) ? uVar : new u(7, h.e((f3.b) uVar.f9807f, i, i3, i12, i14), h.e((f3.b) uVar.f9808g, i, i3, i12, i14));
            default:
                s2.j jVar = (s2.j) this.f10367g;
                if (jVar.f11351p) {
                    return uVar;
                }
                View childAt = jVar.getChildAt(0);
                int iMax = Math.max(0, childAt.getLeft());
                int iMax2 = Math.max(0, childAt.getTop());
                int iMax3 = Math.max(0, jVar.getWidth() - childAt.getRight());
                int iMax4 = Math.max(0, jVar.getHeight() - childAt.getBottom());
                if (iMax == 0 && iMax2 == 0 && iMax3 == 0 && iMax4 == 0) {
                    return uVar;
                }
                f3.b bVarA = f3.b.a(iMax, iMax2, iMax3, iMax4);
                int i15 = bVarA.f3900a;
                f3.b bVar = (f3.b) uVar.f9807f;
                int i16 = bVarA.f3901b;
                int i17 = bVarA.f3902c;
                int i18 = bVarA.f3903d;
                return new u(7, m1.e(bVar, i15, i16, i17, i18), m1.e((f3.b) uVar.f9808g, i15, i16, i17, i18));
        }
    }
}
