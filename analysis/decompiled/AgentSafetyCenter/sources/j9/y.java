package j9;

import java.lang.invoke.VarHandle;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class y implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ yb.u f6732c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ c1 f6733f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ o1.w f6734g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ float f6735h;
    public /* synthetic */ c1 i;

    @Override // xb.l
    public final Object invoke(Object obj) {
        yb.u uVar = this.f6732c;
        c1 c1Var = this.f6733f;
        o1.w wVar = this.f6734g;
        float f5 = this.f6735h;
        c1 c1Var2 = this.i;
        o1.s sVar = (o1.s) obj;
        sVar.a();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (sVar.f9073c & 4294967295L));
        x xVar = new x(1);
        xVar.f6730f = uVar;
        xVar.f6731g = c1Var;
        VarHandle.storeStoreFence();
        a0.a(wVar, f5, c1Var2, fIntBitsToFloat, xVar);
        return jb.v.f6774a;
    }
}
