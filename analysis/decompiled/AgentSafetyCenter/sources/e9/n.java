package e9;

import android.content.Context;
import androidx.compose.foundation.layout.FillElement;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.List;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ xb.a f3689c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ c1 f3690f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ x.r f3691g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ List f3692h;
    public /* synthetic */ kc.t i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ h f3693j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ String f3694k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Context f3695l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ String f3696m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ c1 f3697n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ c1 f3698o;

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        xb.a aVar = this.f3689c;
        c1 c1Var = this.f3690f;
        x.r rVar = this.f3691g;
        List list = this.f3692h;
        kc.t tVar = this.i;
        h hVar = this.f3693j;
        String str = this.f3694k;
        Context context = this.f3695l;
        String str2 = this.f3696m;
        c1 c1Var2 = this.f3697n;
        c1 c1Var3 = this.f3698o;
        k0.s sVar = (k0.s) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
            String strO = t2.a.o(R.string.operate_phone_title, sVar);
            FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
            long j10 = j9.b0.f6633a;
            q qVar = new q();
            qVar.f3707c = c1Var;
            qVar.f3708f = rVar;
            qVar.f3709g = list;
            qVar.f3710h = tVar;
            qVar.i = hVar;
            qVar.f3711j = str;
            qVar.f3712k = context;
            qVar.f3713l = str2;
            qVar.f3714m = c1Var2;
            qVar.f3715n = c1Var3;
            VarHandle.storeStoreFence();
            l9.a.d(strO, aVar, fillElement, j10, false, null, null, s0.h.d(1551699363, qVar, sVar), sVar, 12586368, 112);
        } else {
            sVar.S();
        }
        return jb.v.f6774a;
    }
}
