package s8;

import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class p0 implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f11865c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ float f11866f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ float f11867g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ d2.l0 f11868h;

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean z10 = this.f11865c;
        float f5 = this.f11866f;
        float f10 = this.f11867g;
        d2.l0 l0Var = this.f11868h;
        w.t tVar = (w.t) obj;
        k0.s sVar = (k0.s) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        int i = 0;
        tVar.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= sVar.f(tVar) ? 4 : 2;
        }
        if (sVar.P(iIntValue & 1, (iIntValue & 19) != 18)) {
            List listF = z10 ? ac.a.F(0, 12, 23) : ac.a.F(0, 6, 12, 18, 23);
            ArrayList arrayList = new ArrayList(kb.m.m0(listF, 10));
            Iterator it = listF.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Number) it.next()).intValue();
                arrayList.add(new jb.g(Float.valueOf((iIntValue2 + 0.5f) / 24), Integer.valueOf(iIntValue2 != 0 ? iIntValue2 != 6 ? iIntValue2 != 12 ? iIntValue2 != 18 ? R.string.chart_today_x_end : R.string.chart_today_x_3 : R.string.chart_today_x_2 : R.string.chart_today_x_1 : R.string.chart_today_x_0)));
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                jb.g gVar = (jb.g) arrayList.get(i3);
                k0.s sVar2 = sVar;
                d2.l0 l0Var2 = l0Var;
                h0.t1.b(t2.a.o(((Number) gVar.f6760f).intValue(), sVar), androidx.compose.foundation.layout.c.h(androidx.compose.foundation.layout.b.d(tVar.f15047c.a(w0.j.f15113c, w0.b.f15094k), (tVar.a() * ((Number) gVar.f6759c).floatValue()) - f5, i), f10), 0L, 0L, null, 0L, n2.k.a(3), 0L, 2, false, 1, 0, l0Var2, sVar2, 0, 3504, 50684);
                tVar = tVar;
                l0Var = l0Var2;
                sVar = sVar2;
                i3++;
                arrayList = arrayList;
                i = i;
            }
        } else {
            sVar.S();
        }
        return jb.v.f6774a;
    }
}
