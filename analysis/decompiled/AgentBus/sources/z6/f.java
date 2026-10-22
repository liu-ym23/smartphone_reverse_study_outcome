package z6;

import com.stepos.cloud.securedata.model.PublicKeyData;
import eb.p;
import q7.k;
import wa.i;
import wa.m;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements wa.c {

    /* renamed from: a, reason: collision with root package name */
    public static final f f11828a;
    private static final ua.d descriptor;

    static {
        f fVar = new f();
        f11828a = fVar;
        i iVar = new i("com.stepos.cloud.securedata.model.PublicKeyData", fVar, 1);
        iVar.k("publicKey", false);
        descriptor = iVar;
    }

    @Override // sa.a
    public final ua.d a() {
        return descriptor;
    }

    @Override // wa.c
    public final sa.a[] b() {
        return new sa.a[]{m.f10990a};
    }

    @Override // sa.a
    public Object deserialize(va.b bVar) throws Throwable {
        k.e(bVar, "decoder");
        ua.d dVar = descriptor;
        p pVarA = bVar.a(dVar);
        boolean z4 = true;
        int i2 = 0;
        String strK = null;
        while (z4) {
            int iG = pVarA.g(dVar);
            if (iG == -1) {
                z4 = false;
            } else {
                if (iG != 0) {
                    throw new sa.d(iG);
                }
                strK = pVarA.k(dVar, 0);
                i2 = 1;
            }
        }
        pVarA.l(dVar);
        return new PublicKeyData(i2, strK, null);
    }

    @Override // sa.a
    public void serialize(va.c cVar, Object obj) {
        PublicKeyData publicKeyData = (PublicKeyData) obj;
        k.e(cVar, "encoder");
        k.e(publicKeyData, "value");
        ua.d dVar = descriptor;
        va.a aVarA = cVar.a(dVar);
        ((f3.b) aVarA).k(dVar, 0, publicKeyData.f2720a);
        aVarA.d(dVar);
    }
}
