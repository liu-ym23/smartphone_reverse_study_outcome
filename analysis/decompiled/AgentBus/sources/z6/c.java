package z6;

import com.stepos.cloud.securedata.model.KeyExchangeData;
import eb.p;
import q7.k;
import wa.i;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements wa.c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f11825a;
    private static final ua.d descriptor;

    static {
        c cVar = new c();
        f11825a = cVar;
        i iVar = new i("com.stepos.cloud.securedata.model.KeyExchangeData", cVar, 1);
        iVar.k("idKey", false);
        descriptor = iVar;
    }

    @Override // sa.a
    public final ua.d a() {
        return descriptor;
    }

    @Override // wa.c
    public final sa.a[] b() {
        return new sa.a[]{wa.e.f10967a};
    }

    @Override // sa.a
    public Object deserialize(va.b bVar) throws Throwable {
        k.e(bVar, "decoder");
        ua.d dVar = descriptor;
        p pVarA = bVar.a(dVar);
        long jI = 0;
        boolean z4 = true;
        int i2 = 0;
        while (z4) {
            int iG = pVarA.g(dVar);
            if (iG == -1) {
                z4 = false;
            } else {
                if (iG != 0) {
                    throw new sa.d(iG);
                }
                jI = pVarA.i(dVar, 0);
                i2 = 1;
            }
        }
        pVarA.l(dVar);
        return new KeyExchangeData(i2, jI, null);
    }

    @Override // sa.a
    public void serialize(va.c cVar, Object obj) {
        KeyExchangeData keyExchangeData = (KeyExchangeData) obj;
        k.e(cVar, "encoder");
        k.e(keyExchangeData, "value");
        ua.d dVar = descriptor;
        va.a aVarA = cVar.a(dVar);
        KeyExchangeData.write$Self$sdk_release(keyExchangeData, aVarA, dVar);
        aVarA.d(dVar);
    }
}
