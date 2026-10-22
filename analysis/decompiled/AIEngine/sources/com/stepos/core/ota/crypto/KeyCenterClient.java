package com.stepos.core.ota.crypto;

import ai.onnxruntime.a;
import android.util.Base64;
import com.stepos.core.common.cloud.BffModelProxy;
import com.stepos.core.common.cloud.GatewayAuthSigner;
import com.stepos.core.common.cloud.d;
import com.stepos.core.common.net.HttpTransport;
import com.stepos.core.common.net.NetWorkManager;
import com.stepos.core.ota.domain.port.OtaLogger;
import d5.p;
import d5.q;
import gc.h;
import gc.o;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlin.text.Regex;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeyCenterClient {
    private static final int BIZ_OK_CODE = 200;
    private static final long DEFAULT_READ_MS = 10000;
    public static final String DEVICE_APP_ID = "model-device";
    public static final String FEK_APP_ID = "model-fek";
    public static final String FIELD_DEVICE_PROOF = "deviceProof";
    private static final int MAX_LOG_BODY = 4000;
    private static final String PATH_CHALLENGE = "/api/app/v1/key/device-pubkey/challenge";
    private static final String PATH_REGISTER = "/api/app/v1/key/device-pubkey/register";
    private static final String PATH_REWRAP = "/api/app/v1/key/rewrap";
    private static final long SLOW_READ_MS = 15000;
    private static final String TAG = "KeyCenterClient";
    private final OtaLogger log;
    private final HttpTransport transport;
    public static final Companion Companion = new Companion(null);
    private static final Regex TOKEN_REGEX = new Regex("\"token\"\\s*:\\s*\"([^\"]*)\"");

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class RegisterResult {
        private final String fingerprint;
        private final int keyEpoch;

        public RegisterResult(int i10, String fingerprint) {
            g.f(fingerprint, "fingerprint");
            this.keyEpoch = i10;
            this.fingerprint = fingerprint;
        }

        public static /* synthetic */ RegisterResult copy$default(RegisterResult registerResult, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = registerResult.keyEpoch;
            }
            if ((i11 & 2) != 0) {
                str = registerResult.fingerprint;
            }
            return registerResult.copy(i10, str);
        }

        public final int component1() {
            return this.keyEpoch;
        }

        public final String component2() {
            return this.fingerprint;
        }

        public final RegisterResult copy(int i10, String fingerprint) {
            g.f(fingerprint, "fingerprint");
            return new RegisterResult(i10, fingerprint);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RegisterResult)) {
                return false;
            }
            RegisterResult registerResult = (RegisterResult) obj;
            return this.keyEpoch == registerResult.keyEpoch && g.b(this.fingerprint, registerResult.fingerprint);
        }

        public final String getFingerprint() {
            return this.fingerprint;
        }

        public final int getKeyEpoch() {
            return this.keyEpoch;
        }

        public int hashCode() {
            return this.fingerprint.hashCode() + (Integer.hashCode(this.keyEpoch) * 31);
        }

        public String toString() {
            return "RegisterResult(keyEpoch=" + this.keyEpoch + ", fingerprint=" + this.fingerprint + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.crypto.KeyCenterClient", f = "KeyCenterClient.kt", l = {157}, m = "post")
    /* renamed from: com.stepos.core.ota.crypto.KeyCenterClient$post$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KeyCenterClient.this.post(null, null, 0L, this);
        }
    }

    public KeyCenterClient(OtaLogger log, HttpTransport transport) {
        g.f(log, "log");
        g.f(transport, "transport");
        this.log = log;
        this.transport = transport;
    }

    private final Map<String, String> gatewayHeaders(String str) {
        KeyCenterBootstrap keyCenterBootstrap = KeyCenterBootstrap.INSTANCE;
        String strAppId$ota_release = keyCenterBootstrap.appId$ota_release();
        String strHex32 = hex32();
        String strValueOf = String.valueOf(System.currentTimeMillis());
        return kotlin.collections.b.g0(new Pair("zy-app-id", strAppId$ota_release), new Pair("zy-nonce", strHex32), new Pair("zy-timestamp", strValueOf), new Pair("zy-sign", GatewayAuthSigner.INSTANCE.sign(strAppId$ota_release, strHex32, strValueOf, keyCenterBootstrap.appSecret$ota_release())), new Pair(BffModelProxy.HEADER_TRACE_ID, str));
    }

    private final String hex32() {
        String string = UUID.randomUUID().toString();
        g.e(string, "toString(...)");
        return o.i0(string, "-", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object post(java.lang.String r24, d5.q r25, long r26, qb.b<? super d5.q> r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.KeyCenterClient.post(java.lang.String, d5.q, long, qb.b):java.lang.Object");
    }

    public static /* synthetic */ Object post$default(KeyCenterClient keyCenterClient, String str, q qVar, long j10, b bVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 10000;
        }
        return keyCenterClient.post(str, qVar, j10, bVar);
    }

    private final String redact(String str) {
        return TOKEN_REGEX.e(str, new d(15));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence redact$lambda$17(h m6) {
        g.f(m6, "m");
        return a.g(m6.a().get(1).length(), "\"token\":\"<len=", ">\"");
    }

    /* renamed from: register-BWLJW6A$default, reason: not valid java name */
    public static /* synthetic */ Object m127registerBWLJW6A$default(KeyCenterClient keyCenterClient, String str, List list, String str2, b bVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        return keyCenterClient.m129registerBWLJW6A(str, list, str2, bVar);
    }

    private final byte[] requireB64Url(q qVar, String str, int i10) throws IOException {
        Object objA;
        String strRequireString = requireString(qVar, str);
        if (i10 > 0 && strRequireString.length() != i10) {
            StringBuilder sbF = h0.e.f("field '", str, "' length ", strRequireString.length(), ", contract says ");
            sbF.append(i10);
            throw new IOException(sbF.toString());
        }
        try {
            objA = Base64.decode(strRequireString, 11);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (Result.b(objA) != null) {
            throw new IOException(a.i("field '", strRequireString.length(), str, "' is not valid base64url (len=", ")"));
        }
        g.e(objA, "getOrElse(...)");
        return (byte[]) objA;
    }

    public static /* synthetic */ byte[] requireB64Url$default(KeyCenterClient keyCenterClient, q qVar, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return keyCenterClient.requireB64Url(qVar, str, i10);
    }

    private final int requireInt(q qVar, String str) throws IOException {
        d5.o oVarH = qVar.h(str);
        if (oVarH != null) {
            if (oVarH instanceof p) {
                oVarH = null;
            }
            if (oVarH != null) {
                return oVarH.b();
            }
        }
        throw new IOException(a0.a.k("response missing field '", str, "'"));
    }

    private final String requireString(q qVar, String str) throws IOException {
        String strF;
        d5.o oVarH = qVar.h(str);
        if (oVarH != null) {
            if (oVarH instanceof p) {
                oVarH = null;
            }
            if (oVarH != null && (strF = oVarH.f()) != null) {
                String str2 = gc.q.t0(strF) ? null : strF;
                if (str2 != null) {
                    return str2;
                }
            }
        }
        throw new IOException(a0.a.k("response missing field '", str, "'"));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* renamed from: challenge-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m128challengegIAlus(java.lang.String r10, qb.b<? super kotlin.Result<java.lang.String>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.core.ota.crypto.KeyCenterClient$challenge$1
            if (r0 == 0) goto L14
            r0 = r11
            com.stepos.core.ota.crypto.KeyCenterClient$challenge$1 r0 = (com.stepos.core.ota.crypto.KeyCenterClient$challenge$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.core.ota.crypto.KeyCenterClient$challenge$1 r0 = new com.stepos.core.ota.crypto.KeyCenterClient$challenge$1
            r0.<init>(r9, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r9 = r6.L$0
            com.stepos.core.ota.crypto.KeyCenterClient r9 = (com.stepos.core.ota.crypto.KeyCenterClient) r9
            kotlin.c.b(r11)     // Catch: java.lang.Throwable -> L71
            goto L68
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            kotlin.c.b(r11)
            d5.q r3 = new d5.q     // Catch: java.lang.Throwable -> L71
            r3.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.String r11 = "appId"
            java.lang.String r1 = "model-device"
            r3.g(r11, r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r11 = "deviceId"
            r3.g(r11, r10)     // Catch: java.lang.Throwable -> L71
            java.lang.String r10 = "token"
            com.stepos.core.ota.crypto.KeyCenterBootstrap r11 = com.stepos.core.ota.crypto.KeyCenterBootstrap.INSTANCE     // Catch: java.lang.Throwable -> L71
            java.lang.String r11 = r11.deviceAuthToken$ota_release()     // Catch: java.lang.Throwable -> L71
            r3.g(r10, r11)     // Catch: java.lang.Throwable -> L71
            r10 = r2
            java.lang.String r2 = "/api/app/v1/key/device-pubkey/challenge"
            r6.L$0 = r9     // Catch: java.lang.Throwable -> L71
            r6.label = r10     // Catch: java.lang.Throwable -> L71
            r4 = 0
            r7 = 4
            r8 = 0
            r1 = r9
            java.lang.Object r11 = post$default(r1, r2, r3, r4, r6, r7, r8)     // Catch: java.lang.Throwable -> L71
            if (r11 != r0) goto L67
            return r0
        L67:
            r9 = r1
        L68:
            d5.q r11 = (d5.q) r11     // Catch: java.lang.Throwable -> L71
            java.lang.String r10 = "challenge"
            java.lang.String r9 = r9.requireString(r11, r10)     // Catch: java.lang.Throwable -> L71
            return r9
        L71:
            r0 = move-exception
            r9 = r0
            kotlin.Result$Failure r9 = kotlin.c.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.KeyCenterClient.m128challengegIAlus(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* renamed from: register-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m129registerBWLJW6A(java.lang.String r8, java.util.List<java.lang.String> r9, java.lang.String r10, qb.b<? super kotlin.Result<com.stepos.core.ota.crypto.KeyCenterClient.RegisterResult>> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.stepos.core.ota.crypto.KeyCenterClient$register$1
            if (r0 == 0) goto L14
            r0 = r11
            com.stepos.core.ota.crypto.KeyCenterClient$register$1 r0 = (com.stepos.core.ota.crypto.KeyCenterClient$register$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.core.ota.crypto.KeyCenterClient$register$1 r0 = new com.stepos.core.ota.crypto.KeyCenterClient$register$1
            r0.<init>(r7, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r7 = r6.L$0
            com.stepos.core.ota.crypto.KeyCenterClient r7 = (com.stepos.core.ota.crypto.KeyCenterClient) r7
            kotlin.c.b(r11)     // Catch: java.lang.Throwable -> Lbf
            goto La3
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.c.b(r11)
            boolean r11 = r9.isEmpty()     // Catch: java.lang.Throwable -> Lbf
            if (r11 != 0) goto Lb7
            d5.q r3 = new d5.q     // Catch: java.lang.Throwable -> Lbf
            r3.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r11 = "appId"
            java.lang.String r1 = "model-device"
            r3.g(r11, r1)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r11 = "deviceId"
            r3.g(r11, r8)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r8 = "token"
            com.stepos.core.ota.crypto.KeyCenterBootstrap r11 = com.stepos.core.ota.crypto.KeyCenterBootstrap.INSTANCE     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r11 = r11.deviceAuthToken$ota_release()     // Catch: java.lang.Throwable -> Lbf
            r3.g(r8, r11)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r8 = "certChain"
            d5.l r11 = new d5.l     // Catch: java.lang.Throwable -> Lbf
            r11.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.util.Iterator r9 = r9.iterator()     // Catch: java.lang.Throwable -> Lbf
        L66:
            boolean r1 = r9.hasNext()     // Catch: java.lang.Throwable -> Lbf
            if (r1 == 0) goto L83
            java.lang.Object r1 = r9.next()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> Lbf
            java.util.ArrayList<d5.o> r4 = r11.f8381a     // Catch: java.lang.Throwable -> Lbf
            if (r1 != 0) goto L79
            d5.p r1 = d5.p.f8382a     // Catch: java.lang.Throwable -> Lbf
            goto L7f
        L79:
            d5.r r5 = new d5.r     // Catch: java.lang.Throwable -> Lbf
            r5.<init>(r1)     // Catch: java.lang.Throwable -> Lbf
            r1 = r5
        L7f:
            r4.add(r1)     // Catch: java.lang.Throwable -> Lbf
            goto L66
        L83:
            lb.n r9 = lb.n.f10413a     // Catch: java.lang.Throwable -> Lbf
            com.google.gson.internal.LinkedTreeMap<java.lang.String, d5.o> r9 = r3.f8383a     // Catch: java.lang.Throwable -> Lbf
            r9.put(r8, r11)     // Catch: java.lang.Throwable -> Lbf
            if (r10 == 0) goto L91
            java.lang.String r8 = "deviceProof"
            r3.g(r8, r10)     // Catch: java.lang.Throwable -> Lbf
        L91:
            r8 = r2
            java.lang.String r2 = "/api/app/v1/key/device-pubkey/register"
            r6.L$0 = r7     // Catch: java.lang.Throwable -> Lbf
            r6.label = r8     // Catch: java.lang.Throwable -> Lbf
            r4 = 15000(0x3a98, double:7.411E-320)
            r1 = r7
            java.lang.Object r11 = r1.post(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> Lbf
            if (r11 != r0) goto La2
            return r0
        La2:
            r7 = r1
        La3:
            d5.q r11 = (d5.q) r11     // Catch: java.lang.Throwable -> Lbf
            com.stepos.core.ota.crypto.KeyCenterClient$RegisterResult r8 = new com.stepos.core.ota.crypto.KeyCenterClient$RegisterResult     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r9 = "keyEpoch"
            int r9 = r7.requireInt(r11, r9)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r10 = "fingerprint"
            java.lang.String r7 = r7.requireString(r11, r10)     // Catch: java.lang.Throwable -> Lbf
            r8.<init>(r9, r7)     // Catch: java.lang.Throwable -> Lbf
            return r8
        Lb7:
            java.lang.String r7 = "empty cert chain"
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> Lbf
            r8.<init>(r7)     // Catch: java.lang.Throwable -> Lbf
            throw r8     // Catch: java.lang.Throwable -> Lbf
        Lbf:
            r0 = move-exception
            r7 = r0
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.KeyCenterClient.m129registerBWLJW6A(java.lang.String, java.util.List, java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* renamed from: rewrap-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m130rewrap0E7RQCE(java.lang.String r10, java.lang.String r11, qb.b<? super kotlin.Result<com.stepos.core.ota.crypto.FekEnvelopeCipher>> r12) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.KeyCenterClient.m130rewrap0E7RQCE(java.lang.String, java.lang.String, qb.b):java.lang.Object");
    }

    public /* synthetic */ KeyCenterClient(OtaLogger otaLogger, HttpTransport httpTransport, int i10, e eVar) {
        this(otaLogger, (i10 & 2) != 0 ? NetWorkManager.INSTANCE.getTransport() : httpTransport);
    }
}
