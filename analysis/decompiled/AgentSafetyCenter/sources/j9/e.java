package j9;

import com.stepos.agentsafetycenter.MainActivity;
import d1.g0;
import k0.c1;
import k8.d0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6659c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ c1 f6660f;

    public /* synthetic */ e(int i) {
        this.f6659c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f6659c;
        jb.v vVar = jb.v.f6774a;
        c1 c1Var = this.f6660f;
        switch (i) {
            case 0:
                Boolean bool = (Boolean) obj;
                bool.getClass();
                c1Var.setValue(bool);
                return vVar;
            case 1:
                g0 g0Var = (g0) obj;
                int i3 = MainActivity.f2491h;
                g0Var.getClass();
                g0Var.b(((d0) c1Var.getValue()) instanceof k8.x ? 1.0f : 0.0f);
                return vVar;
            case 2:
                int iIntValue = ((Integer) obj).intValue();
                Integer num = (Integer) c1Var.getValue();
                return Boolean.valueOf(num != null && num.intValue() == iIntValue);
            default:
                c1.c cVar = (c1.c) obj;
                cVar.getClass();
                c1.c cVar2 = (c1.c) c1Var.getValue();
                if (cVar2 == null || Math.abs(cVar2.f2167a - cVar.f2167a) > 0.5f || Math.abs(cVar2.f2168b - cVar.f2168b) > 0.5f || Math.abs(cVar2.f2169c - cVar.f2169c) > 0.5f || Math.abs(cVar2.f2170d - cVar.f2170d) > 0.5f) {
                    c1Var.setValue(cVar);
                }
                return vVar;
        }
    }
}
