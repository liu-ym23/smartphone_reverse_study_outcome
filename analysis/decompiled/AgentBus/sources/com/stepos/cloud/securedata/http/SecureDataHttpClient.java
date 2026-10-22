package com.stepos.cloud.securedata.http;

import ab.n;
import ab.r;
import ab.t;
import ab.w;
import android.util.Log;
import b0.e;
import com.stepos.account.oauth.OAuthConstants;
import com.stepos.cloud.securedata.SecureDataLogSanitizer;
import i5.l;
import ia.m;
import java.util.regex.Pattern;
import kotlin.Metadata;
import p7.k;
import q7.f;
import w6.p;
import w7.e0;
import y6.a;
import y6.d;
import y6.i;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/cloud/securedata/http/SecureDataHttpClient;", "", "Lw6/p;", "runtimeConfig", "Lab/t;", "okHttpClient", "Lkotlin/Function1;", "", "Lc7/r;", "externalLogger", "<init>", "(Lw6/p;Lab/t;Lp7/k;)V", "path", "body", "post", "(Ljava/lang/String;Ljava/lang/String;Lg7/d;)Ljava/lang/Object;", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SecureDataHttpClient {

    /* renamed from: e, reason: collision with root package name */
    public static final r f2702e;

    /* renamed from: a, reason: collision with root package name */
    public final p f2703a;

    /* renamed from: b, reason: collision with root package name */
    public final t f2704b;

    /* renamed from: c, reason: collision with root package name */
    public final k f2705c;

    /* renamed from: d, reason: collision with root package name */
    public final d f2706d;

    static {
        Pattern pattern = r.f597c;
        f2702e = e0.x("application/json");
    }

    public SecureDataHttpClient(p pVar, t tVar, k kVar) {
        q7.k.e(pVar, "runtimeConfig");
        q7.k.e(tVar, "okHttpClient");
        this.f2703a = pVar;
        this.f2704b = tVar;
        this.f2705c = kVar;
        a aVar = pVar.f10817c;
        this.f2706d = new d(aVar, new i(aVar.f11678a, tVar));
    }

    public static final Object access$execute(SecureDataHttpClient secureDataHttpClient, w wVar, String str, g7.d dVar) {
        secureDataHttpClient.getClass();
        m mVar = new m(1, ib.k.C(dVar));
        mVar.s();
        secureDataHttpClient.a(wVar, str);
        eb.i iVarB = secureDataHttpClient.f2704b.b(wVar);
        mVar.u(new e(secureDataHttpClient, wVar, iVarB, 1));
        iVarB.f(new l(secureDataHttpClient, wVar, mVar, 21));
        Object objR = mVar.r();
        h7.a aVar = h7.a.f4212f;
        return objR;
    }

    public static final void access$logError(SecureDataHttpClient secureDataHttpClient, String str, Throwable th) {
        secureDataHttpClient.getClass();
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (w6.m.f10811b) {
            if (th == null) {
                Log.e("StepOSCloudSecureDataSdk", str);
            } else {
                Log.e("StepOSCloudSecureDataSdk", str, th);
            }
        }
        k kVar = secureDataHttpClient.f2705c;
        if (kVar != null) {
            kVar.invoke(str);
        }
    }

    public static void logError$default(SecureDataHttpClient secureDataHttpClient, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        secureDataHttpClient.getClass();
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (w6.m.f10811b) {
            if (th == null) {
                Log.e("StepOSCloudSecureDataSdk", str);
            } else {
                Log.e("StepOSCloudSecureDataSdk", str, th);
            }
        }
        k kVar = secureDataHttpClient.f2705c;
        if (kVar != null) {
            kVar.invoke(str);
        }
    }

    public final void a(String str) {
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (w6.m.f10811b) {
            Log.d("StepOSCloudSecureDataSdk", str);
        }
        k kVar = this.f2705c;
        if (kVar != null) {
            kVar.invoke(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object post(java.lang.String r6, java.lang.String r7, g7.d r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof s3.b
            if (r0 == 0) goto L13
            r0 = r8
            s3.b r0 = (s3.b) r0
            int r1 = r0.f9482j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9482j = r1
            goto L18
        L13:
            s3.b r0 = new s3.b
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f9480h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f9482j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            w7.e0.N(r8)
            return r8
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            java.lang.String r7 = r0.f9479g
            com.stepos.cloud.securedata.http.SecureDataHttpClient r5 = r0.f9478f
            w7.e0.N(r8)
            goto L4a
        L3a:
            w7.e0.N(r8)
            r0.f9478f = r5
            r0.f9479g = r7
            r0.f9482j = r4
            java.lang.Object r8 = r5.a(r6, r7, r0)
            if (r8 != r1) goto L4a
            goto L86
        L4a:
            ab.w r8 = (ab.w) r8
            r6 = 0
            r0.f9478f = r6
            r0.f9479g = r6
            r0.f9482j = r3
            r5.getClass()
            ia.m r6 = new ia.m
            g7.d r0 = ib.k.C(r0)
            r6.<init>(r4, r0)
            r6.s()
            access$logRequest(r5, r8, r7)
            ab.t r7 = access$getOkHttpClient$p(r5)
            eb.i r7 = r7.b(r8)
            b0.e r0 = new b0.e
            r2 = 1
            r0.<init>(r5, r8, r7, r2)
            r6.u(r0)
            i5.l r0 = new i5.l
            r2 = 21
            r0.<init>(r5, r8, r6, r2)
            r7.f(r0)
            java.lang.Object r5 = r6.r()
            if (r5 != r1) goto L87
        L86:
            return r1
        L87:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.cloud.securedata.http.SecureDataHttpClient.post(java.lang.String, java.lang.String, g7.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r8, java.lang.String r9, g7.d r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof s3.a
            if (r0 == 0) goto L13
            r0 = r10
            s3.a r0 = (s3.a) r0
            int r1 = r0.f9477h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9477h = r1
            goto L18
        L13:
            s3.a r0 = new s3.a
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f9475f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f9477h
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            w7.e0.N(r10)
            goto L8c
        L27:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2f:
            w7.e0.N(r10)
            ab.v r10 = new ab.v
            r10.<init>()
            w6.p r2 = r7.f2703a
            java.lang.String r4 = "runtimeConfig"
            q7.k.e(r2, r4)
            java.lang.String r4 = "path"
            q7.k.e(r8, r4)
            java.lang.String r4 = "/"
            r5 = 0
            boolean r6 = ga.r.g0(r8, r4, r5)
            if (r6 == 0) goto L4d
            goto L51
        L4d:
            java.lang.String r8 = r4.concat(r8)
        L51:
            java.lang.String r2 = r2.f10816b
            char[] r4 = new char[r3]
            r6 = 47
            r4[r5] = r6
            java.lang.String r2 = ga.k.O0(r2, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            r10.d(r8)
            ab.r r8 = com.stepos.cloud.securedata.http.SecureDataHttpClient.f2702e
            ab.x r8 = ib.c.s(r9, r8)
            java.lang.String r9 = "POST"
            r10.c(r9, r8)
            java.lang.String r8 = "Content-Type"
            java.lang.String r9 = "application/json"
            r10.b(r8, r9)
            y6.d r7 = r7.f2706d
            r0.f9477h = r3
            java.lang.Object r10 = r7.a(r10, r0)
            if (r10 != r1) goto L8c
            return r1
        L8c:
            ab.v r10 = (ab.v) r10
            ab.w r7 = r10.a()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.cloud.securedata.http.SecureDataHttpClient.a(java.lang.String, java.lang.String, g7.d):java.lang.Object");
    }

    public /* synthetic */ SecureDataHttpClient(p pVar, t tVar, k kVar, int i2, f fVar) {
        this(pVar, tVar, (i2 & 4) != 0 ? null : kVar);
    }

    public final void a(w wVar, int i2, String str) {
        a("<-- " + i2 + " " + wVar.f662b + " " + wVar.f661a);
        q7.k.e(str, "body");
        String strSanitizeJsonBody = SecureDataLogSanitizer.INSTANCE.sanitizeJsonBody(str);
        StringBuilder sb2 = new StringBuilder("<-- Body: ");
        sb2.append(strSanitizeJsonBody);
        a(sb2.toString());
    }

    public final void a(w wVar, String str) {
        a("--> " + wVar.f662b + " " + wVar.f661a);
        a("--> Content-Type: application/json");
        n nVar = wVar.f663c;
        String strA = nVar.a("zy-app-id");
        if (strA != null) {
            a("--> zy-app-id: ".concat(strA));
        }
        String strA2 = nVar.a("zy-nonce");
        if (strA2 != null) {
            a("--> zy-nonce: " + SecureDataLogSanitizer.INSTANCE.previewValue(strA2, 16));
        }
        String strA3 = nVar.a("zy-timestamp");
        if (strA3 != null) {
            a("--> zy-timestamp: ".concat(strA3));
        }
        String strA4 = nVar.a("zy-sign");
        if (strA4 != null) {
            a("--> zy-sign: " + SecureDataLogSanitizer.INSTANCE.previewValue(strA4, 16));
        }
        q7.k.e(str, "body");
        a("--> Body: " + SecureDataLogSanitizer.INSTANCE.sanitizeJsonBody(str));
    }
}
