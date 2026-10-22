package z6;

import com.stepos.cloud.securedata.model.PublicKeyRequest;
import eb.p;
import q7.k;
import wa.i;
import wa.m;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements wa.c {

    /* renamed from: a, reason: collision with root package name */
    public static final g f11829a;
    private static final ua.d descriptor;

    static {
        g gVar = new g();
        f11829a = gVar;
        i iVar = new i("com.stepos.cloud.securedata.model.PublicKeyRequest", gVar, 2);
        iVar.k("appId", false);
        iVar.k("deviceId", false);
        descriptor = iVar;
    }

    @Override // sa.a
    public final ua.d a() {
        return descriptor;
    }

    @Override // wa.c
    public final sa.a[] b() {
        m mVar = m.f10990a;
        return new sa.a[]{mVar, mVar};
    }

    @Override // sa.a
    public Object deserialize(va.b bVar) throws Throwable {
        k.e(bVar, "decoder");
        ua.d dVar = descriptor;
        p pVarA = bVar.a(dVar);
        boolean z4 = true;
        int i2 = 0;
        String strK = null;
        String strK2 = null;
        while (z4) {
            int iG = pVarA.g(dVar);
            if (iG == -1) {
                z4 = false;
            } else if (iG == 0) {
                strK = pVarA.k(dVar, 0);
                i2 |= 1;
            } else {
                if (iG != 1) {
                    throw new sa.d(iG);
                }
                strK2 = pVarA.k(dVar, 1);
                i2 |= 2;
            }
        }
        pVarA.l(dVar);
        return new PublicKeyRequest(i2, strK, strK2, null);
    }

    @Override // sa.a
    public void serialize(va.c cVar, Object obj) {
        PublicKeyRequest publicKeyRequest = (PublicKeyRequest) obj;
        k.e(cVar, "encoder");
        k.e(publicKeyRequest, "value");
        ua.d dVar = descriptor;
        va.a aVarA = cVar.a(dVar);
        PublicKeyRequest.write$Self$sdk_release(publicKeyRequest, aVarA, dVar);
        aVarA.d(dVar);
    }
}
