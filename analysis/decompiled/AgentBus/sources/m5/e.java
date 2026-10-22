package m5;

import a4.u;
import com.stepos.account.oauth.OAuthConstants;
import java.util.Set;
import w7.e0;

/* loaded from: classes.dex */
public final class e extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6393f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6394g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h f6395h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(h hVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f6393f = i2;
        this.f6395h = hVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6393f) {
            case 0:
                e eVar = new e(this.f6395h, dVar, 0);
                eVar.f6394g = obj;
                return eVar;
            default:
                e eVar2 = new e(this.f6395h, dVar, 1);
                eVar2.f6394g = obj;
                return eVar2;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f6393f) {
            case 0:
                e eVar = (e) create((k5.i) obj, (g7.d) obj2);
                c7.r rVar = c7.r.f1986a;
                eVar.invokeSuspend(rVar);
                return rVar;
            default:
                e eVar2 = (e) create((k5.m) obj, (g7.d) obj2);
                c7.r rVar2 = c7.r.f1986a;
                eVar2.invokeSuspend(rVar2);
                return rVar2;
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        a aVar;
        int i2 = this.f6393f;
        c7.r rVar = c7.r.f1986a;
        h hVar = this.f6395h;
        switch (i2) {
            case 0:
                h7.a aVar2 = h7.a.f4212f;
                e0.N(obj);
                k5.i iVar = (k5.i) this.f6394g;
                long j2 = iVar.f5632d;
                Set setX0 = d7.n.x0(new String[]{"OFFLINE", "DOWN"});
                k5.j jVar = iVar.f5631c;
                hVar.b(new b(j2, "connection.state", setX0.contains(jVar.name()) ? a.WARN : a.INFO, d7.e0.U(new c7.j("conn", iVar.f5629a), new c7.j("from", iVar.f5630b.name()), new c7.j("to", jVar.name()))));
                return rVar;
            default:
                h7.a aVar3 = h7.a.f4212f;
                e0.N(obj);
                k5.m mVar = (k5.m) this.f6394g;
                int i10 = f.$EnumSwitchMapping$0[mVar.f5635c.ordinal()];
                if (i10 == 1) {
                    aVar = a.INFO;
                } else if (i10 == 2) {
                    aVar = a.WARN;
                } else {
                    if (i10 != 3 && i10 != 4) {
                        throw new u();
                    }
                    aVar = a.ERROR;
                }
                hVar.b(new b(mVar.f5637e, "error.report", aVar, d7.e0.W(mVar.f5636d, d7.e0.U(new c7.j("code", mVar.f5633a), new c7.j(OAuthConstants.FACTOR_RESULT_MESSAGE, mVar.f5634b)))));
                return rVar;
        }
    }
}
