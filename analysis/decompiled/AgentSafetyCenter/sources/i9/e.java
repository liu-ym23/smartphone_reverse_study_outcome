package i9;

import m8.k0;
import m8.l0;
import s8.d1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e extends yb.i implements xb.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5855m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i, Object obj, Class cls, String str, String str2, int i3, int i10, int i11) {
        super(i, obj, cls, str, str2, i3, i10);
        this.f5855m = i11;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5855m) {
            case 0:
                String str = (String) obj;
                String str2 = (String) obj2;
                str.getClass();
                str2.getClass();
                ((a) this.f16083f).getClass();
                return Integer.valueOf(a.a(str, str2));
            case 1:
                String str3 = (String) obj;
                String str4 = (String) obj2;
                str3.getClass();
                str4.getClass();
                ((a) this.f16083f).getClass();
                return Integer.valueOf(a.a(str3, str4));
            case 2:
                String str5 = (String) obj;
                String str6 = (String) obj2;
                str5.getClass();
                str6.getClass();
                ((a) this.f16083f).getClass();
                return Integer.valueOf(a.a(str5, str6));
            default:
                l0 l0Var = (l0) obj;
                int iIntValue = ((Number) obj2).intValue();
                l0Var.getClass();
                k0 k0Var = (k0) this.f16083f;
                k0Var.getClass();
                if (k0Var.v().f8277j != d1.f11540f) {
                    k0Var.f8431p = l0Var;
                } else {
                    l0 l0Var2 = k0Var.f8431p;
                    k0Var.f8431p = l0Var;
                    l0 l0Var3 = l0.f8440c;
                    if (l0Var != l0Var3 && ((l0Var2 == null || l0Var2 == l0Var3) && iIntValue >= 0)) {
                        k0Var.U(m8.a.a(k0Var.v(), false, null, null, null, 0, null, null, false, null, null, iIntValue, null, null, null, null, null, 0, null, false, null, false, null, null, false, 0, null, null, null, 1073740799));
                    }
                }
                return jb.v.f6774a;
        }
    }
}
