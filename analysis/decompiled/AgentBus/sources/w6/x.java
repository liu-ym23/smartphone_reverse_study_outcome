package w6;

import com.stepos.cloud.securedata.SecureDataEnvironment;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final f f10851a;

    /* renamed from: b, reason: collision with root package name */
    public final j f10852b;

    /* renamed from: c, reason: collision with root package name */
    public final SecureDataEnvironment f10853c;

    static {
        new q(null);
    }

    public x(f fVar, j jVar, SecureDataEnvironment secureDataEnvironment) {
        this.f10851a = fVar;
        this.f10852b = jVar;
        this.f10853c = secureDataEnvironment;
    }

    public static /* synthetic */ Object ensureEncryptedAesKey$default(x xVar, String str, String str2, String str3, boolean z4, boolean z10, g7.d dVar, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z10 = false;
        }
        return xVar.a(str, str2, str3, z4, z10, dVar);
    }

    public static /* synthetic */ Object getPublicKey$default(x xVar, String str, String str2, boolean z4, g7.d dVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z4 = false;
        }
        return xVar.d(str, str2, z4, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Enum a(java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13, boolean r14, g7.d r15) throws javax.crypto.NoSuchPaddingException, com.stepos.cloud.securedata.SdkException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.x.a(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, g7.d):java.lang.Enum");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r9, java.lang.String r10, i7.c r11) throws com.stepos.cloud.securedata.SdkException {
        /*
            r8 = this;
            boolean r0 = r11 instanceof w6.s
            if (r0 == 0) goto L14
            r0 = r11
            w6.s r0 = (w6.s) r0
            int r1 = r0.f10830k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f10830k = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            w6.s r0 = new w6.s
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r7.f10828i
            h7.a r0 = h7.a.f4212f
            int r1 = r7.f10830k
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L48
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            java.lang.String r8 = r7.f10826g
            java.lang.Object r9 = r7.f10825f
            java.lang.String r9 = (java.lang.String) r9
            w7.e0.N(r11)
            goto L76
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            java.lang.String r10 = r7.f10827h
            java.lang.String r9 = r7.f10826g
            java.lang.Object r8 = r7.f10825f
            w6.x r8 = (w6.x) r8
            w7.e0.N(r11)
        L45:
            r1 = r8
            r3 = r10
            goto L5a
        L48:
            w7.e0.N(r11)
            r7.f10825f = r8
            r7.f10826g = r9
            r7.f10827h = r10
            r7.f10830k = r3
            java.io.Serializable r11 = r8.f(r9, r10, r7)
            if (r11 != r0) goto L45
            goto L73
        L5a:
            c7.j r11 = (c7.j) r11
            java.lang.Object r8 = r11.f1973f
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
            r7.f10825f = r9
            r7.f10826g = r3
            r8 = 0
            r7.f10827h = r8
            r7.f10830k = r2
            r5 = 1
            r6 = 1
            r2 = r9
            java.lang.Enum r8 = r1.a(r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto L74
        L73:
            return r0
        L74:
            r9 = r2
            r8 = r3
        L76:
            com.stepos.cloud.securedata.SessionInfo r10 = new com.stepos.cloud.securedata.SessionInfo
            r10.<init>(r9, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.x.b(java.lang.String, java.lang.String, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r11, java.lang.String r12, g7.d r13) throws com.stepos.cloud.securedata.SdkException {
        /*
            r10 = this;
            boolean r0 = r13 instanceof w6.t
            if (r0 == 0) goto L13
            r0 = r13
            w6.t r0 = (w6.t) r0
            int r1 = r0.f10835j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10835j = r1
            goto L18
        L13:
            w6.t r0 = new w6.t
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f10833h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f10835j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r10 = r0.f10831f
            com.stepos.cloud.securedata.model.PublicKeyResponse r10 = (com.stepos.cloud.securedata.model.PublicKeyResponse) r10
            w7.e0.N(r13)
            goto L80
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            java.lang.String r11 = r0.f10832g
            java.lang.Object r10 = r0.f10831f
            w6.x r10 = (w6.x) r10
            w7.e0.N(r13)
        L3f:
            r7 = r11
            goto L53
        L41:
            w7.e0.N(r13)
            r0.f10831f = r10
            r0.f10832g = r11
            r0.f10835j = r4
            w6.f r13 = r10.f10851a
            java.lang.Object r13 = r13.c(r11, r12, r0)
            if (r13 != r1) goto L3f
            goto L7e
        L53:
            r11 = r13
            com.stepos.cloud.securedata.model.PublicKeyResponse r11 = (com.stepos.cloud.securedata.model.PublicKeyResponse) r11
            w6.j r5 = r10.f10852b
            com.stepos.cloud.securedata.SecureDataEnvironment r6 = r10.f10853c
            java.lang.String r8 = r11.getPublicKey()
            r0.f10831f = r11
            r10 = 0
            r0.f10832g = r10
            r0.f10835j = r3
            s2.f r12 = r5.f10806a
            w6.i r4 = new w6.i
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            w2.c r13 = new w2.c
            r2 = 1
            r13.<init>(r4, r10, r2)
            java.lang.Object r10 = r12.h(r13, r0)
            if (r10 != r1) goto L7a
            goto L7c
        L7a:
            c7.r r10 = c7.r.f1986a
        L7c:
            if (r10 != r1) goto L7f
        L7e:
            return r1
        L7f:
            r10 = r11
        L80:
            java.lang.String r10 = r10.getPublicKey()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.x.c(java.lang.String, java.lang.String, g7.d):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r9 == r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        if (r9 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r6, java.lang.String r7, boolean r8, g7.d r9) throws com.stepos.cloud.securedata.SdkException {
        /*
            r5 = this;
            boolean r0 = r9 instanceof w6.u
            if (r0 == 0) goto L13
            r0 = r9
            w6.u r0 = (w6.u) r0
            int r1 = r0.f10838h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10838h = r1
            goto L18
        L13:
            w6.u r0 = new w6.u
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f10836f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f10838h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            w7.e0.N(r9)
            goto L55
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            w7.e0.N(r9)
            goto L44
        L36:
            w7.e0.N(r9)
            if (r8 == 0) goto L4c
            r0.f10838h = r4
            java.lang.Object r9 = r5.c(r6, r7, r0)
            if (r9 != r1) goto L44
            goto L54
        L44:
            com.stepos.cloud.securedata.KeySource r5 = com.stepos.cloud.securedata.KeySource.GENERATED
            c7.j r6 = new c7.j
            r6.<init>(r9, r5)
            goto L58
        L4c:
            r0.f10838h = r3
            java.io.Serializable r9 = r5.f(r6, r7, r0)
            if (r9 != r1) goto L55
        L54:
            return r1
        L55:
            r6 = r9
            c7.j r6 = (c7.j) r6
        L58:
            java.lang.Object r5 = r6.f1973f
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r6.f1974g
            com.stepos.cloud.securedata.KeySource r6 = (com.stepos.cloud.securedata.KeySource) r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "getPublicKey source="
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "message"
            q7.k.e(r6, r7)
            boolean r7 = w6.m.f10811b
            if (r7 == 0) goto L7c
            java.lang.String r7 = "StepOSCloudSecureDataSdk"
            android.util.Log.d(r7, r6)
        L7c:
            com.stepos.cloud.securedata.model.PublicKeyResponse r6 = new com.stepos.cloud.securedata.model.PublicKeyResponse
            r7 = 200(0xc8, float:2.8E-43)
            java.lang.String r8 = "success"
            r6.<init>(r7, r8, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.x.d(java.lang.String, java.lang.String, boolean, g7.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r11, java.lang.String r12, i7.c r13) throws com.stepos.cloud.securedata.SdkException {
        /*
            r10 = this;
            boolean r0 = r13 instanceof w6.v
            if (r0 == 0) goto L14
            r0 = r13
            w6.v r0 = (w6.v) r0
            int r1 = r0.f10844k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f10844k = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            w6.v r0 = new w6.v
            r0.<init>(r10, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r7.f10842i
            h7.a r0 = h7.a.f4212f
            int r1 = r7.f10844k
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L4f
            if (r1 == r3) goto L3e
            if (r1 != r2) goto L36
            java.lang.Object r10 = r7.f10841h
            com.stepos.cloud.securedata.KeySource r10 = (com.stepos.cloud.securedata.KeySource) r10
            java.lang.String r11 = r7.f10840g
            java.lang.Object r12 = r7.f10839f
            java.lang.String r12 = (java.lang.String) r12
            w7.e0.N(r13)
            goto L83
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            java.lang.Object r10 = r7.f10841h
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r11 = r7.f10840g
            java.lang.Object r10 = r7.f10839f
            w6.x r10 = (w6.x) r10
            w7.e0.N(r13)
        L4c:
            r1 = r10
            r3 = r12
            goto L61
        L4f:
            w7.e0.N(r13)
            r7.f10839f = r10
            r7.f10840g = r11
            r7.f10841h = r12
            r7.f10844k = r3
            java.io.Serializable r13 = r10.f(r11, r12, r7)
            if (r13 != r0) goto L4c
            goto L80
        L61:
            c7.j r13 = (c7.j) r13
            java.lang.Object r10 = r13.f1973f
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r10 = r13.f1974g
            com.stepos.cloud.securedata.KeySource r10 = (com.stepos.cloud.securedata.KeySource) r10
            r7.f10839f = r11
            r7.f10840g = r3
            r7.f10841h = r10
            r7.f10844k = r2
            r8 = 16
            r9 = 0
            r5 = 1
            r6 = 0
            r2 = r11
            java.lang.Object r13 = ensureEncryptedAesKey$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r13 != r0) goto L81
        L80:
            return r0
        L81:
            r12 = r2
            r11 = r3
        L83:
            com.stepos.cloud.securedata.KeySource r13 = (com.stepos.cloud.securedata.KeySource) r13
            com.stepos.cloud.securedata.InitResult r0 = new com.stepos.cloud.securedata.InitResult
            r0.<init>(r10, r13, r12, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.x.e(java.lang.String, java.lang.String, i7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cd, code lost:
    
        if (r12 == r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable f(java.lang.String r10, java.lang.String r11, g7.d r12) throws com.stepos.cloud.securedata.SdkException {
        /*
            r9 = this;
            boolean r0 = r12 instanceof w6.w
            if (r0 == 0) goto L13
            r0 = r12
            w6.w r0 = (w6.w) r0
            int r1 = r0.f10850k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10850k = r1
            goto L18
        L13:
            w6.w r0 = new w6.w
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.f10848i
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f10850k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L33
            if (r2 != r3) goto L2b
            w7.e0.N(r12)
            goto Ld0
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            java.lang.String r11 = r0.f10847h
            java.lang.String r10 = r0.f10846g
            w6.x r9 = r0.f10845f
            w7.e0.N(r12)
            goto L64
        L3d:
            w7.e0.N(r12)
            w6.j r12 = r9.f10852b
            com.stepos.cloud.securedata.SecureDataEnvironment r2 = r9.f10853c
            r0.f10845f = r9
            r0.f10846g = r10
            r0.f10847h = r11
            r0.f10850k = r4
            w2.d r2 = w6.j.a(r2, r10)
            s2.f r12 = r12.f10806a
            la.j r12 = r12.E()
            nb.f r4 = new nb.f
            r5 = 12
            r4.<init>(r5, r12, r2)
            java.lang.Object r12 = la.k0.j(r4, r0)
            if (r12 != r1) goto L64
            goto Lcf
        L64:
            java.lang.String r12 = (java.lang.String) r12
            r2 = 0
            if (r12 == 0) goto L70
            boolean r4 = ga.k.t0(r12)
            if (r4 != 0) goto L70
            goto L71
        L70:
            r12 = r2
        L71:
            java.lang.String r4 = "StepOSCloudSecureDataSdk"
            java.lang.String r5 = "message"
            java.lang.String r6 = ", appId="
            if (r12 == 0) goto La1
            com.stepos.cloud.securedata.SecureDataEnvironment r9 = r9.f10853c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "publicKey loaded from DataStore, env="
            r11.<init>(r0)
            r11.append(r9)
            r11.append(r6)
            r11.append(r10)
            java.lang.String r9 = r11.toString()
            q7.k.e(r9, r5)
            boolean r10 = w6.m.f10811b
            if (r10 == 0) goto L99
            android.util.Log.d(r4, r9)
        L99:
            com.stepos.cloud.securedata.KeySource r9 = com.stepos.cloud.securedata.KeySource.CACHE
            c7.j r10 = new c7.j
            r10.<init>(r12, r9)
            return r10
        La1:
            com.stepos.cloud.securedata.SecureDataEnvironment r12 = r9.f10853c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "publicKey missing in DataStore, fetching from network, env="
            r7.<init>(r8)
            r7.append(r12)
            r7.append(r6)
            r7.append(r10)
            java.lang.String r12 = r7.toString()
            q7.k.e(r12, r5)
            boolean r5 = w6.m.f10811b
            if (r5 == 0) goto Lc1
            android.util.Log.d(r4, r12)
        Lc1:
            r0.f10845f = r2
            r0.f10846g = r2
            r0.f10847h = r2
            r0.f10850k = r3
            java.lang.Object r12 = r9.c(r10, r11, r0)
            if (r12 != r1) goto Ld0
        Lcf:
            return r1
        Ld0:
            com.stepos.cloud.securedata.KeySource r9 = com.stepos.cloud.securedata.KeySource.GENERATED
            c7.j r10 = new c7.j
            r10.<init>(r12, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.x.f(java.lang.String, java.lang.String, g7.d):java.io.Serializable");
    }
}
