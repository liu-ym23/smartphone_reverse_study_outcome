package z6;

import com.stepos.cloud.securedata.model.KeyExchangeRequest;
import eb.p;
import q7.k;
import wa.i;
import wa.m;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements wa.c {

    /* renamed from: a, reason: collision with root package name */
    public static final d f11826a;
    private static final ua.d descriptor;

    static {
        d dVar = new d();
        f11826a = dVar;
        i iVar = new i("com.stepos.cloud.securedata.model.KeyExchangeRequest", dVar, 3);
        iVar.k("appId", false);
        iVar.k("deviceId", false);
        iVar.k("encryptedAesKey", false);
        descriptor = iVar;
    }

    @Override // sa.a
    public final ua.d a() {
        return descriptor;
    }

    @Override // wa.c
    public final sa.a[] b() {
        m mVar = m.f10990a;
        return new sa.a[]{mVar, mVar, mVar};
    }

    @Override // sa.a
    public Object deserialize(va.b bVar) throws Throwable {
        k.e(bVar, "decoder");
        ua.d dVar = descriptor;
        p pVarA = bVar.a(dVar);
        int i2 = 0;
        String strK = null;
        String strK2 = null;
        String strK3 = null;
        boolean z4 = true;
        while (z4) {
            int iG = pVarA.g(dVar);
            if (iG == -1) {
                z4 = false;
            } else if (iG == 0) {
                strK = pVarA.k(dVar, 0);
                i2 |= 1;
            } else if (iG == 1) {
                strK2 = pVarA.k(dVar, 1);
                i2 |= 2;
            } else {
                if (iG != 2) {
                    throw new sa.d(iG);
                }
                strK3 = pVarA.k(dVar, 2);
                i2 |= 4;
            }
        }
        pVarA.l(dVar);
        return new KeyExchangeRequest(i2, strK, strK2, strK3, null);
    }

    @Override // sa.a
    public void serialize(va.c cVar, Object obj) {
        KeyExchangeRequest keyExchangeRequest = (KeyExchangeRequest) obj;
        k.e(cVar, "encoder");
        k.e(keyExchangeRequest, "value");
        ua.d dVar = descriptor;
        va.a aVarA = cVar.a(dVar);
        KeyExchangeRequest.write$Self$sdk_release(keyExchangeRequest, aVarA, dVar);
        aVarA.d(dVar);
    }
}
