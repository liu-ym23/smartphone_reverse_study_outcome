package y6;

import com.stepos.cloud.securedata.internal.gateway.GatewayTimeApiResponse;
import eb.p;
import n7.m;
import q7.k;
import wa.l;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements wa.c {

    /* renamed from: a, reason: collision with root package name */
    public static final e f11690a;
    private static final ua.d descriptor;

    static {
        e eVar = new e();
        f11690a = eVar;
        wa.i iVar = new wa.i("com.stepos.cloud.securedata.internal.gateway.GatewayTimeApiResponse", eVar, 3);
        iVar.k("code", true);
        iVar.k("status", true);
        iVar.k("data", false);
        descriptor = iVar;
    }

    @Override // sa.a
    public final ua.d a() {
        return descriptor;
    }

    @Override // wa.c
    public final sa.a[] b() {
        wa.d dVar = wa.d.f10965a;
        return new sa.a[]{m.w(dVar), m.w(dVar), wa.e.f10967a};
    }

    @Override // sa.a
    public Object deserialize(va.b bVar) throws Throwable {
        k.e(bVar, "decoder");
        ua.d dVar = descriptor;
        p pVarA = bVar.a(dVar);
        int i2 = 0;
        Integer num = null;
        Integer num2 = null;
        long jI = 0;
        boolean z4 = true;
        while (z4) {
            int iG = pVarA.g(dVar);
            if (iG == -1) {
                z4 = false;
            } else if (iG == 0) {
                num = (Integer) pVarA.j(dVar, 0, wa.d.f10965a, num);
                i2 |= 1;
            } else if (iG == 1) {
                num2 = (Integer) pVarA.j(dVar, 1, wa.d.f10965a, num2);
                i2 |= 2;
            } else {
                if (iG != 2) {
                    throw new sa.d(iG);
                }
                jI = pVarA.i(dVar, 2);
                i2 |= 4;
            }
        }
        pVarA.l(dVar);
        return new GatewayTimeApiResponse(i2, num, num2, jI, (l) null);
    }

    @Override // sa.a
    public void serialize(va.c cVar, Object obj) {
        GatewayTimeApiResponse gatewayTimeApiResponse = (GatewayTimeApiResponse) obj;
        k.e(cVar, "encoder");
        k.e(gatewayTimeApiResponse, "value");
        ua.d dVar = descriptor;
        va.a aVarA = cVar.a(dVar);
        GatewayTimeApiResponse.write$Self$sdk_release(gatewayTimeApiResponse, aVarA, dVar);
        aVarA.d(dVar);
    }
}
