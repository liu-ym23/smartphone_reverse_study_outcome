package y6;

import ab.t;
import ab.v;
import com.stepos.cloud.securedata.SdkException;
import com.stepos.cloud.securedata.SecureDataJson;
import com.stepos.cloud.securedata.internal.gateway.GatewayTimeApiResponse;
import ia.m;
import q7.k;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f11695a;

    /* renamed from: b, reason: collision with root package name */
    public final t f11696b;

    static {
        new f(null);
    }

    public i(String str, t tVar) {
        k.e(str, "gatewayBaseUrl");
        this.f11695a = str;
        this.f11696b = tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long access$parseTimestamp(i iVar, String str) throws SdkException {
        iVar.getClass();
        xa.c codec = SecureDataJson.INSTANCE.getCodec();
        codec.getClass();
        GatewayTimeApiResponse gatewayTimeApiResponse = (GatewayTimeApiResponse) codec.a(GatewayTimeApiResponse.INSTANCE.serializer(), str);
        Integer num = gatewayTimeApiResponse.f2707a;
        int iIntValue = (num == null && (num = gatewayTimeApiResponse.f2708b) == null) ? -1 : num.intValue();
        if (iIntValue == 200) {
            return gatewayTimeApiResponse.f2709c;
        }
        throw new SdkException(n.f.c(iIntValue, "Gateway time API error "), null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable a(i7.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof y6.g
            if (r0 == 0) goto L13
            r0 = r5
            y6.g r0 = (y6.g) r0
            int r1 = r0.f11693h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11693h = r1
            goto L18
        L13:
            y6.g r0 = new y6.g
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f11691f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f11693h
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            w7.e0.N(r5)     // Catch: java.lang.Throwable -> L47
            goto L3b
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            w7.e0.N(r5)
            r0.f11693h = r3     // Catch: java.lang.Throwable -> L47
            java.lang.Object r5 = r4.b(r0)     // Catch: java.lang.Throwable -> L47
            if (r5 != r1) goto L3b
            return r1
        L3b:
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Throwable -> L47
            long r4 = r5.longValue()     // Catch: java.lang.Throwable -> L47
            java.lang.Long r0 = new java.lang.Long     // Catch: java.lang.Throwable -> L47
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L47
            goto L4c
        L47:
            r4 = move-exception
            c7.l r0 = w7.e0.n(r4)
        L4c:
            java.lang.Throwable r4 = c7.m.a(r0)
            if (r4 != 0) goto L53
            goto L5c
        L53:
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = new java.lang.Long
            r0.<init>(r4)
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y6.i.a(i7.c):java.io.Serializable");
    }

    public final Object b(g7.d dVar) {
        m mVar = new m(1, ib.k.C(dVar));
        mVar.s();
        v vVar = new v();
        vVar.d(ga.k.O0(this.f11695a, '/') + "/time");
        vVar.c("GET", null);
        eb.i iVarB = this.f11696b.b(vVar.a());
        mVar.u(new h(iVarB));
        iVarB.f(new nb.f(19, mVar, this));
        Object objR = mVar.r();
        h7.a aVar = h7.a.f4212f;
        return objR;
    }
}
