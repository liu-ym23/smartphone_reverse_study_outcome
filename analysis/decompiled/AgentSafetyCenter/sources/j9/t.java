package j9;

import com.stepos.agentsafetycenter.MainActivity;
import h0.b1;
import java.lang.invoke.VarHandle;
import k0.c1;
import k0.y0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6717c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ c1 f6718f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ c1 f6719g;

    public /* synthetic */ t(int i) {
        this.f6717c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f6717c;
        y0 y0Var = k0.m.f6974a;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                this.f6718f.setValue((String) obj);
                this.f6719g.setValue((Float) obj2);
                break;
            case 1:
                c1 c1Var = this.f6718f;
                c1 c1Var2 = this.f6719g;
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i3 = MainActivity.f2491h;
                if (!sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    sVar.S();
                    break;
                } else {
                    Object objM = sVar.M();
                    Object obj3 = objM;
                    if (objM == y0Var) {
                        e9.i iVar = new e9.i(3);
                        iVar.f3663f = c1Var;
                        iVar.f3664g = c1Var2;
                        VarHandle.storeStoreFence();
                        sVar.i0(iVar);
                        obj3 = iVar;
                    }
                    b1.e((xb.a) obj3, null, false, null, null, null, k8.e.f7292b, sVar, 805306374, 510);
                    break;
                }
            default:
                c1 c1Var3 = this.f6718f;
                c1 c1Var4 = this.f6719g;
                k0.s sVar2 = (k0.s) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                int i10 = MainActivity.f2491h;
                if (!sVar2.P(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    sVar2.S();
                    break;
                } else {
                    Object objM2 = sVar2.M();
                    Object obj4 = objM2;
                    if (objM2 == y0Var) {
                        e9.i iVar2 = new e9.i(4);
                        iVar2.f3663f = c1Var3;
                        iVar2.f3664g = c1Var4;
                        VarHandle.storeStoreFence();
                        sVar2.i0(iVar2);
                        obj4 = iVar2;
                    }
                    b1.e((xb.a) obj4, null, false, null, null, null, k8.e.f7296f, sVar2, 805306374, 510);
                    break;
                }
        }
        return vVar;
    }
}
