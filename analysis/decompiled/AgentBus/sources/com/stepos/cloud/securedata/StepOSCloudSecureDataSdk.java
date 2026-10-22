package com.stepos.cloud.securedata;

import a4.u;
import android.content.Context;
import android.provider.Settings;
import b.a;
import b.g;
import c7.r;
import com.stepos.account.oauth.BuildConfig;
import com.stepos.cloud.securedata.http.SecureDataHttpClient;
import ia.d0;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Metadata;
import p7.k;
import ra.b;
import ra.d;
import w6.f;
import w6.j;
import w6.l;
import w6.m;
import w6.o;
import w6.p;
import w6.x;
import w6.y;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001AJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\rJ\r\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\rJ\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u000fJ\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u0019J%\u0010\u001e\u001a\u00020\u001d2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0002H\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010%\u001a\u00020\u0004H\u0000¢\u0006\u0004\b#\u0010$J\u0010\u0010'\u001a\u00020&H\u0086@¢\u0006\u0004\b'\u0010(J*\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020\tH\u0086@¢\u0006\u0004\b'\u0010,J\u0010\u0010.\u001a\u00020-H\u0086@¢\u0006\u0004\b.\u0010(J \u0010.\u001a\u00020-2\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\t¢\u0006\u0004\b0\u0010\u000fJ\u001a\u00101\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b1\u00102J\"\u00105\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00172\b\b\u0002\u00104\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b5\u0010/J.\u00108\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00172\b\b\u0002\u00104\u001a\u00020\u00172\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0017H\u0086@¢\u0006\u0004\b8\u00109J4\u0010=\u001a\u00028\u0000\"\u0004\b\u0000\u0010:2\u001c\u0010<\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bH\u0086@¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u000b¢\u0006\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcom/stepos/cloud/securedata/StepOSCloudSecureDataSdk;", "", "Landroid/content/Context;", "context", "Lcom/stepos/cloud/securedata/SdkConfig;", "config", "Lcom/stepos/cloud/securedata/InitResult;", "init", "(Landroid/content/Context;Lcom/stepos/cloud/securedata/SdkConfig;Lg7/d;)Ljava/lang/Object;", "", "enabled", "Lc7/r;", "setHttpLoggingEnabled", "(Z)V", "isHttpLoggingEnabled", "()Z", "setCryptoLoggingEnabled", "isCryptoLoggingEnabled", "setFullLogValuesEnabled", "isFullLogValuesEnabled", "Lcom/stepos/cloud/securedata/SecureDataEnvironment;", "getEnvironment", "()Lcom/stepos/cloud/securedata/SecureDataEnvironment;", "", "getApiBaseUrl", "()Ljava/lang/String;", "getNetEnv", "Lkotlin/Function1;", "externalLogger", "Lcom/stepos/cloud/securedata/http/SecureDataHttpClient;", "createHttpClient", "(Lp7/k;)Lcom/stepos/cloud/securedata/http/SecureDataHttpClient;", "requireContext$sdk_release", "()Landroid/content/Context;", "requireContext", "requireConfig$sdk_release", "()Lcom/stepos/cloud/securedata/SdkConfig;", "requireConfig", "Lcom/stepos/cloud/securedata/model/PublicKeyResponse;", "getPublicKey", "(Lg7/d;)Ljava/lang/Object;", "appId", "deviceId", "forceRefresh", "(Ljava/lang/String;Ljava/lang/String;ZLg7/d;)Ljava/lang/Object;", "Lcom/stepos/cloud/securedata/SessionInfo;", "exchangeSessionKey", "(Ljava/lang/String;Ljava/lang/String;Lg7/d;)Ljava/lang/Object;", "hasActiveSession", "clearPublicKeyCache", "(Ljava/lang/String;Lg7/d;)Ljava/lang/Object;", "plainText", "requestId", "encrypt", "encryptedBase64", "userId", "decrypt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lg7/d;)Ljava/lang/Object;", "T", "Lg7/d;", "block", "withSecureDataContext", "(Lp7/k;Lg7/d;)Ljava/lang/Object;", BuildConfig.BUILD_TYPE, "()V", "a/a", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StepOSCloudSecureDataSdk {
    public static final StepOSCloudSecureDataSdk INSTANCE = new StepOSCloudSecureDataSdk();

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f2694a = a.f1049f;

    /* renamed from: b, reason: collision with root package name */
    public static final b f2695b = new d();

    /* renamed from: c, reason: collision with root package name */
    public static Context f2696c;

    /* renamed from: d, reason: collision with root package name */
    public static SdkConfig f2697d;

    /* renamed from: e, reason: collision with root package name */
    public static p f2698e;

    /* renamed from: f, reason: collision with root package name */
    public static SecureDataHttpClient f2699f;

    /* renamed from: g, reason: collision with root package name */
    public static j f2700g;

    /* renamed from: h, reason: collision with root package name */
    public static x f2701h;

    public static String c() {
        return "REQ-" + UUID.randomUUID();
    }

    public static /* synthetic */ Object clearPublicKeyCache$default(StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk, String str, g7.d dVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stepOSCloudSecureDataSdk.requireConfig$sdk_release().getAppId();
        }
        return stepOSCloudSecureDataSdk.clearPublicKeyCache(str, dVar);
    }

    public static /* synthetic */ SecureDataHttpClient createHttpClient$default(StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk, k kVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kVar = null;
        }
        return stepOSCloudSecureDataSdk.createHttpClient(kVar);
    }

    public static byte[] d() throws SdkException {
        byte[] bArrCopyOf;
        SdkConfig sdkConfig = f2697d;
        if (sdkConfig == null) {
            q7.k.j("config");
            throw null;
        }
        w6.a aVar = w6.a.f10781a;
        String appId = sdkConfig.getAppId();
        String deviceId = sdkConfig.getDeviceId();
        q7.k.e(appId, "appId");
        q7.k.e(deviceId, "deviceId");
        synchronized (aVar) {
            y yVar = w6.a.f10782b;
            if (yVar != null && q7.k.a(yVar.f10854a, appId) && q7.k.a(yVar.f10855b, deviceId)) {
                byte[] bArr = yVar.f10856c;
                bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                q7.k.d(bArrCopyOf, "copyOf(...)");
            }
            bArrCopyOf = null;
        }
        if (bArrCopyOf != null) {
            return bArrCopyOf;
        }
        throw new SdkException(m.x.x("DeviceSK not available for appId=", sdkConfig.getAppId(), ", deviceId=", sdkConfig.getDeviceId(), ". Call init() first or re-init after changing appId/deviceId."), null, 2, null);
    }

    public static /* synthetic */ Object decrypt$default(StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk, String str, String str2, String str3, g7.d dVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            stepOSCloudSecureDataSdk.getClass();
            str2 = c();
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        return stepOSCloudSecureDataSdk.decrypt(str, str2, str3, dVar);
    }

    public static long e() throws SdkException {
        SdkConfig sdkConfig = f2697d;
        if (sdkConfig == null) {
            q7.k.j("config");
            throw null;
        }
        String appId = sdkConfig.getAppId();
        String deviceId = sdkConfig.getDeviceId();
        q7.k.e(appId, "appId");
        q7.k.e(deviceId, "deviceId");
        y yVar = w6.a.f10782b;
        Long lValueOf = (yVar != null && q7.k.a(yVar.f10854a, appId) && q7.k.a(yVar.f10855b, deviceId)) ? Long.valueOf(yVar.f10858e) : null;
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        throw new SdkException(m.x.x("idKey not available for appId=", sdkConfig.getAppId(), ", deviceId=", sdkConfig.getDeviceId(), ". Call init() first or exchangeSessionKey() to obtain idKey."), null, 2, null);
    }

    public static /* synthetic */ Object encrypt$default(StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk, String str, String str2, g7.d dVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            stepOSCloudSecureDataSdk.getClass();
            str2 = c();
        }
        return stepOSCloudSecureDataSdk.encrypt(str, str2, dVar);
    }

    public static /* synthetic */ Object getPublicKey$default(StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk, String str, String str2, boolean z4, g7.d dVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z4 = false;
        }
        return stepOSCloudSecureDataSdk.getPublicKey(str, str2, z4, dVar);
    }

    public final void a(Context context, SdkConfig sdkConfig) {
        synchronized (this) {
            try {
                int iOrdinal = f2694a.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        throw new SdkException("SDK initialization is in progress, wait for init() to complete.", null, 2, null);
                    }
                    if (iOrdinal != 2) {
                        throw new u();
                    }
                    INSTANCE.getClass();
                    w6.a.f10781a.a();
                    o.f10813a.b();
                    f2694a = a.f1049f;
                }
                Context applicationContext = context.getApplicationContext();
                f2696c = applicationContext;
                if (applicationContext == null) {
                    q7.k.j("appContext");
                    throw null;
                }
                f2698e = n7.a.x(applicationContext);
                f2697d = sdkConfig;
                o oVar = o.f10813a;
                oVar.b();
                p pVar = f2698e;
                if (pVar == null) {
                    q7.k.j("runtimeConfig");
                    throw null;
                }
                f2699f = o.createHttpClient$default(oVar, pVar, null, 2, null);
                Context context2 = f2696c;
                if (context2 == null) {
                    q7.k.j("appContext");
                    throw null;
                }
                f2700g = new j(context2);
                SecureDataHttpClient secureDataHttpClient = f2699f;
                if (secureDataHttpClient == null) {
                    q7.k.j("httpClient");
                    throw null;
                }
                f fVar = new f(secureDataHttpClient);
                j jVar = f2700g;
                if (jVar == null) {
                    q7.k.j("publicKeyStore");
                    throw null;
                }
                p pVar2 = f2698e;
                if (pVar2 == null) {
                    q7.k.j("runtimeConfig");
                    throw null;
                }
                f2701h = new x(fVar, jVar, pVar2.f10815a);
                f2694a = a.f1050g;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(g7.d r8) throws java.lang.Exception {
        /*
            r7 = this;
            boolean r0 = r8 instanceof b.i
            if (r0 == 0) goto L13
            r0 = r8
            b.i r0 = (b.i) r0
            int r1 = r0.f1090i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1090i = r1
            goto L18
        L13:
            b.i r0 = new b.i
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f1088g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f1090i
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            com.stepos.cloud.securedata.StepOSCloudSecureDataSdk r7 = r0.f1087f
            w7.e0.N(r8)     // Catch: java.lang.Exception -> L29
            goto L4b
        L29:
            r8 = move-exception
            goto L57
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            w7.e0.N(r8)
            pa.d r8 = w6.l.f10809a     // Catch: java.lang.Exception -> L29
            b.j r2 = new b.j     // Catch: java.lang.Exception -> L29
            r4 = 2
            r5 = 0
            r6 = 0
            r2.<init>(r4, r6, r5)     // Catch: java.lang.Exception -> L29
            r0.f1087f = r7     // Catch: java.lang.Exception -> L29
            r0.f1090i = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r8 = ia.d0.B(r8, r2, r0)     // Catch: java.lang.Exception -> L29
            if (r8 != r1) goto L4b
            return r1
        L4b:
            com.stepos.cloud.securedata.InitResult r8 = (com.stepos.cloud.securedata.InitResult) r8     // Catch: java.lang.Exception -> L29
            monitor-enter(r7)     // Catch: java.lang.Exception -> L29
            b.a r0 = b.a.f1051h     // Catch: java.lang.Throwable -> L54
            com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.f2694a = r0     // Catch: java.lang.Throwable -> L54
            monitor-exit(r7)     // Catch: java.lang.Exception -> L29
            return r8
        L54:
            r8 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Exception -> L29
            throw r8     // Catch: java.lang.Exception -> L29
        L57:
            r7.a()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.b(g7.d):java.lang.Object");
    }

    public final Object clearPublicKeyCache(String str, g7.d dVar) throws SdkException {
        Object objWithSecureDataContext = withSecureDataContext(new b.b(str, null, 0), dVar);
        return objWithSecureDataContext == h7.a.f4212f ? objWithSecureDataContext : r.f1986a;
    }

    public final SecureDataHttpClient createHttpClient(k externalLogger) throws SdkException {
        b();
        if (externalLogger == null) {
            SecureDataHttpClient secureDataHttpClient = f2699f;
            if (secureDataHttpClient != null) {
                return secureDataHttpClient;
            }
            q7.k.j("httpClient");
            throw null;
        }
        p pVar = f2698e;
        if (pVar != null) {
            return o.f10813a.a(pVar, externalLogger);
        }
        q7.k.j("runtimeConfig");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decrypt(java.lang.String r7, java.lang.String r8, java.lang.String r9, g7.d r10) throws javax.crypto.BadPaddingException, com.stepos.cloud.securedata.SdkException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r6 = this;
            boolean r0 = r10 instanceof b.c
            if (r0 == 0) goto L13
            r0 = r10
            b.c r0 = (b.c) r0
            int r1 = r0.f1062l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1062l = r1
            goto L18
        L13:
            b.c r0 = new b.c
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.f1060j
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f1062l
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.String r9 = r0.f1059i
            java.lang.String r8 = r0.f1058h
            java.lang.String r7 = r0.f1057g
            com.stepos.cloud.securedata.StepOSCloudSecureDataSdk r6 = r0.f1056f
            w7.e0.N(r10)
        L2e:
            r2 = r7
            r3 = r8
            r4 = r9
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            w7.e0.N(r10)
            r0.f1056f = r6
            r0.f1057g = r7
            r0.f1058h = r8
            r0.f1059i = r9
            r0.f1062l = r3
            java.lang.Object r10 = r6.a(r0)
            if (r10 != r1) goto L2e
            return r1
        L4e:
            r6.getClass()
            byte[] r5 = d()
            long r0 = e()
            java.lang.String r6 = "value"
            q7.k.e(r2, r6)
            com.stepos.cloud.securedata.SecureDataLogSanitizer r6 = com.stepos.cloud.securedata.SecureDataLogSanitizer.INSTANCE
            r7 = 64
            java.lang.String r6 = r6.previewValue(r2, r7)
            if (r4 == 0) goto L76
            boolean r7 = ga.k.t0(r4)
            if (r7 == 0) goto L6f
            goto L76
        L6f:
            java.lang.String r7 = ", userId="
            java.lang.String r7 = r7.concat(r4)
            goto L78
        L76:
            java.lang.String r7 = ""
        L78:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "[decrypt:before] requestId="
            r8.<init>(r9)
            r8.append(r3)
            java.lang.String r9 = ", keyId="
            r8.append(r9)
            r8.append(r0)
            java.lang.String r9 = ", ciphertext="
            r8.append(r9)
            r8.append(r6)
            r8.append(r7)
            java.lang.String r6 = r8.toString()
            w6.m.a(r6)
            java.lang.String r6 = x6.a.b(r0, r2, r3, r4, r5)
            r7 = 2
            r8 = 0
            w6.m r9 = w6.m.f10810a
            r10 = 0
            java.lang.String r7 = w6.m.previewValue$default(r9, r6, r10, r7, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "[decrypt:after] requestId="
            r8.<init>(r9)
            r8.append(r3)
            java.lang.String r9 = ", plainText="
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            w6.m.a(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.decrypt(java.lang.String, java.lang.String, java.lang.String, g7.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object encrypt(java.lang.String r9, java.lang.String r10, g7.d r11) throws javax.crypto.BadPaddingException, com.stepos.cloud.securedata.SdkException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.encrypt(java.lang.String, java.lang.String, g7.d):java.lang.Object");
    }

    public final Object exchangeSessionKey(g7.d dVar) {
        return exchangeSessionKey(requireConfig$sdk_release().getAppId(), requireConfig$sdk_release().getDeviceId(), dVar);
    }

    public final void f() {
        synchronized (this) {
            try {
                Context context = f2696c;
                if (context == null) {
                    q7.k.j("appContext");
                    throw null;
                }
                f2698e = n7.a.x(context);
                o oVar = o.f10813a;
                oVar.b();
                p pVar = f2698e;
                if (pVar == null) {
                    q7.k.j("runtimeConfig");
                    throw null;
                }
                f2699f = o.createHttpClient$default(oVar, pVar, null, 2, null);
                if (f2700g == null) {
                    Context context2 = f2696c;
                    if (context2 == null) {
                        q7.k.j("appContext");
                        throw null;
                    }
                    f2700g = new j(context2);
                }
                SecureDataHttpClient secureDataHttpClient = f2699f;
                if (secureDataHttpClient == null) {
                    q7.k.j("httpClient");
                    throw null;
                }
                f fVar = new f(secureDataHttpClient);
                j jVar = f2700g;
                if (jVar == null) {
                    q7.k.j("publicKeyStore");
                    throw null;
                }
                p pVar2 = f2698e;
                if (pVar2 == null) {
                    q7.k.j("runtimeConfig");
                    throw null;
                }
                f2701h = new x(fVar, jVar, pVar2.f10815a);
                f2694a = a.f1050g;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String getApiBaseUrl() throws SdkException {
        b();
        p pVar = f2698e;
        if (pVar != null) {
            return pVar.f10816b;
        }
        q7.k.j("runtimeConfig");
        throw null;
    }

    public final SecureDataEnvironment getEnvironment() throws SdkException {
        b();
        p pVar = f2698e;
        if (pVar != null) {
            return pVar.f10815a;
        }
        q7.k.j("runtimeConfig");
        throw null;
    }

    public final String getNetEnv() throws SdkException {
        b();
        Context context = f2696c;
        if (context == null) {
            q7.k.j("appContext");
            throw null;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "net_env");
            String string2 = string != null ? ga.k.N0(string).toString() : null;
            return string2 == null ? "" : string2;
        } catch (Exception unused) {
            return "";
        }
    }

    public final Object getPublicKey(g7.d dVar) {
        return getPublicKey$default(this, requireConfig$sdk_release().getAppId(), requireConfig$sdk_release().getDeviceId(), false, dVar, 4, null);
    }

    public final boolean hasActiveSession() {
        if (f2694a != a.f1051h) {
            return false;
        }
        SdkConfig sdkConfig = f2697d;
        if (sdkConfig == null) {
            q7.k.j("config");
            throw null;
        }
        String appId = sdkConfig.getAppId();
        SdkConfig sdkConfig2 = f2697d;
        if (sdkConfig2 == null) {
            q7.k.j("config");
            throw null;
        }
        String deviceId = sdkConfig2.getDeviceId();
        q7.k.e(appId, "appId");
        q7.k.e(deviceId, "deviceId");
        y yVar = w6.a.f10782b;
        return yVar != null && q7.k.a(yVar.f10854a, appId) && q7.k.a(yVar.f10855b, deviceId) && yVar.f10858e > 0 && !ga.k.t0(yVar.f10857d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        if (r5 == r8) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object init(android.content.Context r6, com.stepos.cloud.securedata.SdkConfig r7, g7.d r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof b.h
            if (r0 == 0) goto L13
            r0 = r8
            b.h r0 = (b.h) r0
            int r1 = r0.f1086k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1086k = r1
            goto L18
        L13:
            b.h r0 = new b.h
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r5 = r0.f1084i
            h7.a r8 = h7.a.f4212f
            int r1 = r0.f1086k
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L45
            if (r1 == r3) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r6 = r0.f1081f
            ra.b r6 = (ra.b) r6
            w7.e0.N(r5)     // Catch: java.lang.Throwable -> L2f
            goto L71
        L2f:
            r5 = move-exception
            goto L79
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ra.b r6 = r0.f1083h
            com.stepos.cloud.securedata.SdkConfig r7 = r0.f1082g
            java.lang.Object r1 = r0.f1081f
            android.content.Context r1 = (android.content.Context) r1
            w7.e0.N(r5)
            goto L5d
        L45:
            w7.e0.N(r5)
            ra.b r5 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.f2695b
            r0.f1081f = r6
            r0.f1082g = r7
            r0.f1083h = r5
            r0.f1086k = r3
            ra.d r5 = (ra.d) r5
            java.lang.Object r1 = r5.c(r0, r4)
            if (r1 != r8) goto L5b
            goto L70
        L5b:
            r1 = r6
            r6 = r5
        L5d:
            com.stepos.cloud.securedata.StepOSCloudSecureDataSdk r5 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.INSTANCE     // Catch: java.lang.Throwable -> L2f
            r5.a(r1, r7)     // Catch: java.lang.Throwable -> L2f
            r0.f1081f = r6     // Catch: java.lang.Throwable -> L2f
            r0.f1082g = r4     // Catch: java.lang.Throwable -> L2f
            r0.f1083h = r4     // Catch: java.lang.Throwable -> L2f
            r0.f1086k = r2     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r5 = r5.b(r0)     // Catch: java.lang.Throwable -> L2f
            if (r5 != r8) goto L71
        L70:
            return r8
        L71:
            com.stepos.cloud.securedata.InitResult r5 = (com.stepos.cloud.securedata.InitResult) r5     // Catch: java.lang.Throwable -> L2f
            ra.d r6 = (ra.d) r6
            r6.e(r4)
            return r5
        L79:
            ra.d r6 = (ra.d) r6
            r6.e(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.init(android.content.Context, com.stepos.cloud.securedata.SdkConfig, g7.d):java.lang.Object");
    }

    public final boolean isCryptoLoggingEnabled() {
        return m.f10812c;
    }

    public final boolean isFullLogValuesEnabled() {
        return SecureDataLogSanitizer.INSTANCE.getFullValueLoggingEnabled();
    }

    public final boolean isHttpLoggingEnabled() {
        return m.f10811b;
    }

    public final void release() {
        synchronized (this) {
            a aVar = f2694a;
            a aVar2 = a.f1049f;
            if (aVar == aVar2) {
                return;
            }
            INSTANCE.getClass();
            w6.a.f10781a.a();
            o.f10813a.b();
            f2694a = aVar2;
        }
    }

    public final SdkConfig requireConfig$sdk_release() throws SdkException {
        b();
        SdkConfig sdkConfig = f2697d;
        if (sdkConfig != null) {
            return sdkConfig;
        }
        q7.k.j("config");
        throw null;
    }

    public final Context requireContext$sdk_release() throws SdkException {
        b();
        Context context = f2696c;
        if (context != null) {
            return context;
        }
        q7.k.j("appContext");
        throw null;
    }

    public final void setCryptoLoggingEnabled(boolean enabled) {
        m.f10812c = enabled;
    }

    public final void setFullLogValuesEnabled(boolean enabled) {
        SecureDataLogSanitizer.INSTANCE.setFullValueLoggingEnabled(enabled);
    }

    public final void setHttpLoggingEnabled(boolean enabled) {
        m.f10811b = enabled;
    }

    public final <T> Object withSecureDataContext(k kVar, g7.d dVar) throws SdkException {
        b();
        return d0.B(l.f10809a, new b.k(kVar, null, 0), dVar);
    }

    public final Object exchangeSessionKey(String str, String str2, g7.d dVar) {
        return withSecureDataContext(new b.f(str, str2, null), dVar);
    }

    public final Object getPublicKey(String str, String str2, boolean z4, g7.d dVar) {
        return withSecureDataContext(new g(str, str2, z4, null), dVar);
    }

    public static void b() throws SdkException {
        int iOrdinal = f2694a.ordinal();
        if (iOrdinal == 0) {
            throw new SdkException("StepOSCloudSecureDataSdk.init(context, config) must be called first.", null, 2, null);
        }
        if (iOrdinal == 1) {
            throw new SdkException("SDK initialization is in progress, wait for init() to complete.", null, 2, null);
        }
        if (iOrdinal != 2) {
            throw new u();
        }
    }

    public final void a() {
        synchronized (this) {
            INSTANCE.getClass();
            w6.a.f10781a.a();
            o.f10813a.b();
            f2694a = a.f1049f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x009e, code lost:
    
        if (r8 == r2) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.stepos.cloud.securedata.StepOSCloudSecureDataSdk] */
    /* JADX WARN: Type inference failed for: r7v9, types: [ra.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(g7.d r8) throws ia.k0 {
        /*
            r7 = this;
            c7.r r0 = c7.r.f1986a
            boolean r1 = r8 instanceof b.e
            if (r1 == 0) goto L15
            r1 = r8
            b.e r1 = (b.e) r1
            int r2 = r1.f1072i
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f1072i = r2
            goto L1a
        L15:
            b.e r1 = new b.e
            r1.<init>(r7, r8)
        L1a:
            java.lang.Object r8 = r1.f1070g
            h7.a r2 = h7.a.f4212f
            int r3 = r1.f1072i
            r4 = 1
            r5 = 2
            r6 = 0
            if (r3 == 0) goto L41
            if (r3 == r4) goto L3b
            if (r3 != r5) goto L33
            ra.b r7 = r1.f1069f
            w7.e0.N(r8)     // Catch: java.lang.Throwable -> L30
            goto La1
        L30:
            r8 = move-exception
            goto Lb1
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            ra.b r7 = r1.f1069f
            w7.e0.N(r8)
            goto L60
        L41:
            w7.e0.N(r8)
            b.a r8 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.f2694a
            b.a r3 = b.a.f1051h
            if (r8 != r3) goto L51
            boolean r7 = r7.hasActiveSession()
            if (r7 == 0) goto L51
            return r0
        L51:
            ra.b r7 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.f2695b
            r1.f1069f = r7
            r1.f1072i = r4
            ra.d r7 = (ra.d) r7
            java.lang.Object r8 = r7.c(r1, r6)
            if (r8 != r2) goto L60
            goto La0
        L60:
            b.a r8 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.f2694a     // Catch: java.lang.Throwable -> L30
            b.a r3 = b.a.f1051h     // Catch: java.lang.Throwable -> L30
            if (r8 != r3) goto L74
            com.stepos.cloud.securedata.StepOSCloudSecureDataSdk r8 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.INSTANCE     // Catch: java.lang.Throwable -> L30
            boolean r8 = r8.hasActiveSession()     // Catch: java.lang.Throwable -> L30
            if (r8 == 0) goto L74
            ra.d r7 = (ra.d) r7
            r7.e(r6)
            return r0
        L74:
            android.content.Context r8 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.f2696c     // Catch: java.lang.Throwable -> L30
            if (r8 == 0) goto La9
            com.stepos.cloud.securedata.SdkConfig r8 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.f2697d     // Catch: java.lang.Throwable -> L30
            if (r8 == 0) goto La9
            b.a r8 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.f2694a     // Catch: java.lang.Throwable -> L30
            int r8 = r8.ordinal()     // Catch: java.lang.Throwable -> L30
            if (r8 == 0) goto L8f
            if (r8 == r4) goto L94
            if (r8 != r5) goto L89
            goto L94
        L89:
            a4.u r8 = new a4.u     // Catch: java.lang.Throwable -> L30
            r8.<init>()     // Catch: java.lang.Throwable -> L30
            throw r8     // Catch: java.lang.Throwable -> L30
        L8f:
            com.stepos.cloud.securedata.StepOSCloudSecureDataSdk r8 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.INSTANCE     // Catch: java.lang.Throwable -> L30
            r8.f()     // Catch: java.lang.Throwable -> L30
        L94:
            com.stepos.cloud.securedata.StepOSCloudSecureDataSdk r8 = com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.INSTANCE     // Catch: java.lang.Throwable -> L30
            r1.f1069f = r7     // Catch: java.lang.Throwable -> L30
            r1.f1072i = r5     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = r8.b(r1)     // Catch: java.lang.Throwable -> L30
            if (r8 != r2) goto La1
        La0:
            return r2
        La1:
            com.stepos.cloud.securedata.InitResult r8 = (com.stepos.cloud.securedata.InitResult) r8     // Catch: java.lang.Throwable -> L30
            ra.d r7 = (ra.d) r7
            r7.e(r6)
            return r0
        La9:
            com.stepos.cloud.securedata.SdkException r8 = new com.stepos.cloud.securedata.SdkException     // Catch: java.lang.Throwable -> L30
            java.lang.String r0 = "StepOSCloudSecureDataSdk.init(context, config) must be called first."
            r8.<init>(r0, r6, r5, r6)     // Catch: java.lang.Throwable -> L30
            throw r8     // Catch: java.lang.Throwable -> L30
        Lb1:
            ra.d r7 = (ra.d) r7
            r7.e(r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.cloud.securedata.StepOSCloudSecureDataSdk.a(g7.d):java.lang.Object");
    }
}
