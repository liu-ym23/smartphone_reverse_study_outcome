package w6;

import com.stepos.cloud.securedata.http.SecureDataHttpClient;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final SecureDataHttpClient f10793a;

    static {
        new b(null);
    }

    public f(SecureDataHttpClient secureDataHttpClient) {
        this.f10793a = secureDataHttpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r5, java.lang.String r6, java.lang.String r7, i7.c r8) throws com.stepos.cloud.securedata.SdkException {
        /*
            r4 = this;
            boolean r0 = r8 instanceof w6.c
            if (r0 == 0) goto L13
            r0 = r8
            w6.c r0 = (w6.c) r0
            int r1 = r0.f10785h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10785h = r1
            goto L18
        L13:
            w6.c r0 = new w6.c
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f10783f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f10785h
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            w7.e0.N(r8)
            goto L5c
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            w7.e0.N(r8)
            com.stepos.cloud.securedata.SecureDataJson r8 = com.stepos.cloud.securedata.SecureDataJson.INSTANCE
            xa.c r8 = r8.getCodec()
            com.stepos.cloud.securedata.model.KeyExchangeRequest r2 = new com.stepos.cloud.securedata.model.KeyExchangeRequest
            r2.<init>(r5, r6, r7)
            r8.getClass()
            com.stepos.cloud.securedata.model.KeyExchangeRequest$Companion r5 = com.stepos.cloud.securedata.model.KeyExchangeRequest.INSTANCE
            sa.a r5 = r5.serializer()
            java.lang.String r5 = r8.b(r5, r2)
            s1.u r6 = new s1.u
            r7 = 12
            r6.<init>(r7)
            r0.f10785h = r3
            java.lang.String r7 = "/api/app/v1/key/exchange"
            java.lang.Object r8 = r4.b(r7, r5, r6, r0)
            if (r8 != r1) goto L5c
            return r1
        L5c:
            com.stepos.cloud.securedata.model.KeyExchangeApiResponse r8 = (com.stepos.cloud.securedata.model.KeyExchangeApiResponse) r8
            com.stepos.cloud.securedata.model.KeyExchangeData r4 = r8.f2712c
            r5 = 0
            if (r4 == 0) goto L82
            long r6 = r4.f2713a
            java.lang.Long r4 = new java.lang.Long
            r4.<init>(r6)
            long r6 = r4.longValue()
            r0 = 0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 <= 0) goto L75
            goto L76
        L75:
            r4 = r5
        L76:
            if (r4 == 0) goto L82
            long r4 = r4.longValue()
            java.lang.Long r6 = new java.lang.Long
            r6.<init>(r4)
            return r6
        L82:
            com.stepos.cloud.securedata.SdkException r4 = new com.stepos.cloud.securedata.SdkException
            java.lang.String r6 = "Response data.idKey is missing"
            r7 = 2
            r4.<init>(r6, r5, r7, r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.f.a(java.lang.String, java.lang.String, java.lang.String, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r5, java.lang.String r6, p7.k r7, g7.d r8) throws com.stepos.cloud.securedata.SdkException {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.f.b(java.lang.String, java.lang.String, p7.k, g7.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r5, java.lang.String r6, i7.c r7) throws com.stepos.cloud.securedata.SdkException {
        /*
            r4 = this;
            boolean r0 = r7 instanceof w6.e
            if (r0 == 0) goto L13
            r0 = r7
            w6.e r0 = (w6.e) r0
            int r1 = r0.f10792h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10792h = r1
            goto L18
        L13:
            w6.e r0 = new w6.e
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f10790f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f10792h
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            w7.e0.N(r7)
            goto L5c
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            w7.e0.N(r7)
            com.stepos.cloud.securedata.SecureDataJson r7 = com.stepos.cloud.securedata.SecureDataJson.INSTANCE
            xa.c r7 = r7.getCodec()
            com.stepos.cloud.securedata.model.PublicKeyRequest r2 = new com.stepos.cloud.securedata.model.PublicKeyRequest
            r2.<init>(r5, r6)
            r7.getClass()
            com.stepos.cloud.securedata.model.PublicKeyRequest$Companion r5 = com.stepos.cloud.securedata.model.PublicKeyRequest.INSTANCE
            sa.a r5 = r5.serializer()
            java.lang.String r5 = r7.b(r5, r2)
            s1.u r6 = new s1.u
            r7 = 11
            r6.<init>(r7)
            r0.f10792h = r3
            java.lang.String r7 = "/api/app/v1/key/public-key"
            java.lang.Object r7 = r4.b(r7, r5, r6, r0)
            if (r7 != r1) goto L5c
            return r1
        L5c:
            com.stepos.cloud.securedata.model.PublicKeyApiResponse r7 = (com.stepos.cloud.securedata.model.PublicKeyApiResponse) r7
            com.stepos.cloud.securedata.model.PublicKeyData r4 = r7.f2719c
            r5 = 0
            if (r4 == 0) goto L7b
            java.lang.String r4 = r4.f2720a
            if (r4 == 0) goto L7b
            boolean r6 = ga.k.t0(r4)
            if (r6 != 0) goto L6e
            goto L6f
        L6e:
            r4 = r5
        L6f:
            if (r4 == 0) goto L7b
            com.stepos.cloud.securedata.model.PublicKeyResponse r5 = new com.stepos.cloud.securedata.model.PublicKeyResponse
            int r6 = r7.f2717a
            java.lang.String r7 = r7.f2718b
            r5.<init>(r6, r7, r4)
            return r5
        L7b:
            com.stepos.cloud.securedata.SdkException r4 = new com.stepos.cloud.securedata.SdkException
            java.lang.String r6 = "Response data.publicKey is missing"
            r7 = 2
            r4.<init>(r6, r5, r7, r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.f.c(java.lang.String, java.lang.String, i7.c):java.lang.Object");
    }
}
