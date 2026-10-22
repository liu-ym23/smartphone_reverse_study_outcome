package z6;

import com.stepos.cloud.securedata.model.PublicKeyApiResponse;
import com.stepos.cloud.securedata.model.PublicKeyData;
import eb.p;
import q7.k;
import wa.i;
import wa.l;
import wa.m;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements wa.c {

    /* renamed from: a, reason: collision with root package name */
    public static final e f11827a;
    private static final ua.d descriptor;

    static {
        e eVar = new e();
        f11827a = eVar;
        i iVar = new i("com.stepos.cloud.securedata.model.PublicKeyApiResponse", eVar, 3);
        iVar.k("code", false);
        iVar.k("msg", false);
        iVar.k("data", true);
        descriptor = iVar;
    }

    @Override // sa.a
    public final ua.d a() {
        return descriptor;
    }

    @Override // wa.c
    public final sa.a[] b() {
        return new sa.a[]{wa.d.f10965a, m.f10990a, n7.m.w(f.f11828a)};
    }

    @Override // sa.a
    public Object deserialize(va.b bVar) throws Throwable {
        k.e(bVar, "decoder");
        ua.d dVar = descriptor;
        p pVarA = bVar.a(dVar);
        int i2 = 0;
        int iH = 0;
        String strK = null;
        PublicKeyData publicKeyData = null;
        boolean z4 = true;
        while (z4) {
            int iG = pVarA.g(dVar);
            if (iG == -1) {
                z4 = false;
            } else if (iG == 0) {
                iH = pVarA.h(dVar, 0);
                i2 |= 1;
            } else if (iG == 1) {
                strK = pVarA.k(dVar, 1);
                i2 |= 2;
            } else {
                if (iG != 2) {
                    throw new sa.d(iG);
                }
                publicKeyData = (PublicKeyData) pVarA.j(dVar, 2, f.f11828a, publicKeyData);
                i2 |= 4;
            }
        }
        pVarA.l(dVar);
        return new PublicKeyApiResponse(i2, iH, strK, publicKeyData, (l) null);
    }

    @Override // sa.a
    public void serialize(va.c cVar, Object obj) {
        PublicKeyApiResponse publicKeyApiResponse = (PublicKeyApiResponse) obj;
        k.e(cVar, "encoder");
        k.e(publicKeyApiResponse, "value");
        ua.d dVar = descriptor;
        va.a aVarA = cVar.a(dVar);
        PublicKeyApiResponse.write$Self$sdk_release(publicKeyApiResponse, aVarA, dVar);
        aVarA.d(dVar);
    }
}
