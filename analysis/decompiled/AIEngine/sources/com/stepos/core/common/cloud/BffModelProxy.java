package com.stepos.core.common.cloud;

import android.accounts.Account;
import android.content.Context;
import android.provider.Settings;
import gc.o;
import gc.q;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BffModelProxy {
    private static final String ASR_SSE_PATH = "/v1/audio/asr/sse";
    private static final String CLIENT_TYPE = "Android";
    private static final String FILE_QUERY_PATH = "/v1/audio/asr/file/query";
    private static final String FILE_SUBMIT_PATH = "/v1/audio/asr/file/submit";
    private static final String HEADER_APP_ID = "zy-app-id";
    public static final String HEADER_APP_PACKAGE = "zy-app-package";
    private static final String HEADER_AUDIO_DURATION_MS = "zy-audio-duration-ms";
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_CLIENT_TYPE = "zy-client-type";
    public static final String HEADER_DEVICE_ID = "zy-device-id";
    private static final String HEADER_NONCE = "zy-nonce";
    public static final String HEADER_SCENE_TYPE = "zy-scene-type";
    private static final String HEADER_SIGN = "zy-sign";
    private static final String HEADER_TIMESTAMP = "zy-timestamp";
    public static final String HEADER_TRACE_ID = "zy-trace-id";
    private static final String HEADER_USER_ID = "zy-user-id";
    public static final BffModelProxy INSTANCE = new BffModelProxy();
    private static final String PROD_BASE_URL = "https://biz-gw.stepaos.com/stepfun-proxy";
    private static final String SPEECH_PATH = "/v1/audio/speech";
    private static final String TEST_BASE_URL = "https://biz-gw.t-stepos.com/stepfun-proxy";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.cloud.BffModelProxy", f = "BffModelProxy.kt", l = {179}, m = "gatewayHeadersResult")
    /* renamed from: com.stepos.core.common.cloud.BffModelProxy$gatewayHeadersResult$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BffModelProxy.this.gatewayHeadersResult(null, null, 0L, this);
        }
    }

    private BffModelProxy() {
    }

    private final String baseUrl() {
        return BffGatewayBootstrap.INSTANCE.isTestEnv$common_release() ? TEST_BASE_URL : PROD_BASE_URL;
    }

    private final String deviceId(Context context) {
        Object objA;
        try {
            objA = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str = (String) objA;
        if (str == null || q.t0(str)) {
            return null;
        }
        return str;
    }

    public static /* synthetic */ Map gatewayHeaders$default(BffModelProxy bffModelProxy, String str, String str2, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            j10 = 0;
        }
        return bffModelProxy.gatewayHeaders(str, str2, j10);
    }

    public static /* synthetic */ Object gatewayHeadersResult$default(BffModelProxy bffModelProxy, String str, String str2, long j10, qb.b bVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i10 & 4) != 0) {
            j10 = 0;
        }
        return bffModelProxy.gatewayHeadersResult(str, str3, j10, bVar);
    }

    private final String userId(Context context) {
        String strA;
        if (context == null) {
            strA = null;
        } else {
            try {
                Account accountW = y.w(context);
                strA = accountW == null ? "" : accountW.name;
            } catch (Throwable th) {
                strA = kotlin.c.a(th);
            }
        }
        if (strA instanceof Result.Failure) {
            strA = null;
        }
        String str = (String) strA;
        if (str == null || q.t0(str)) {
            return null;
        }
        return str;
    }

    public final String asrSseUrl() {
        return a0.a.j(baseUrl(), ASR_SSE_PATH);
    }

    public final Object bearerToken(String str, qb.b<? super String> bVar) {
        return AccountTokenCache.INSTANCE.bearerToken(str, bVar);
    }

    public final Map<String, String> gatewayHeaders(String str, String str2, long j10) {
        BffGatewayBootstrap bffGatewayBootstrap = BffGatewayBootstrap.INSTANCE;
        Context contextAppContext$common_release = bffGatewayBootstrap.appContext$common_release();
        if (contextAppContext$common_release == null) {
            return kotlin.collections.b.d0();
        }
        String strAppId$common_release = bffGatewayBootstrap.appId$common_release();
        String strAppSecret$common_release = bffGatewayBootstrap.appSecret$common_release();
        if (q.t0(strAppId$common_release) || q.t0(strAppSecret$common_release)) {
            return kotlin.collections.b.d0();
        }
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        String strI0 = o.i0(string, "-", "");
        String strValueOf = String.valueOf(System.currentTimeMillis());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(HEADER_APP_ID, strAppId$common_release);
        linkedHashMap.put(HEADER_NONCE, strI0);
        linkedHashMap.put(HEADER_TIMESTAMP, strValueOf);
        linkedHashMap.put(HEADER_SIGN, GatewayAuthSigner.INSTANCE.sign(strAppId$common_release, strI0, strValueOf, strAppSecret$common_release));
        linkedHashMap.put(HEADER_CLIENT_TYPE, CLIENT_TYPE);
        String string2 = UUID.randomUUID().toString();
        kotlin.jvm.internal.g.e(string2, "toString(...)");
        linkedHashMap.put(HEADER_TRACE_ID, o.i0(string2, "-", ""));
        linkedHashMap.put(HEADER_APP_PACKAGE, contextAppContext$common_release.getPackageName());
        String strDeviceId = deviceId(contextAppContext$common_release);
        if (strDeviceId != null) {
            linkedHashMap.put(HEADER_DEVICE_ID, strDeviceId);
        }
        String strUserId = userId(contextAppContext$common_release);
        if (strUserId != null) {
            linkedHashMap.put(HEADER_USER_ID, strUserId);
        }
        if (str2 != null) {
            if (q.t0(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                linkedHashMap.put(HEADER_SCENE_TYPE, str2);
            }
        }
        Long lValueOf = Long.valueOf(j10);
        if (j10 <= 0) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            linkedHashMap.put(HEADER_AUDIO_DURATION_MS, String.valueOf(lValueOf.longValue()));
        }
        if (str != null) {
            if (q.t0(str)) {
                str = null;
            }
            if (str != null) {
                linkedHashMap.put("Authorization", "Bearer ".concat(str));
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object gatewayHeadersResult(java.lang.String r5, java.lang.String r6, long r7, qb.b<? super com.stepos.core.common.cloud.AuthHeaderResult> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.stepos.core.common.cloud.BffModelProxy.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.core.common.cloud.BffModelProxy$gatewayHeadersResult$1 r0 = (com.stepos.core.common.cloud.BffModelProxy.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.common.cloud.BffModelProxy$gatewayHeadersResult$1 r0 = new com.stepos.core.common.cloud.BffModelProxy$gatewayHeadersResult$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            long r7 = r0.J$0
            java.lang.Object r4 = r0.L$1
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r4 = r0.L$0
            com.stepos.core.common.cloud.BffModelProxy r4 = (com.stepos.core.common.cloud.BffModelProxy) r4
            kotlin.c.b(r9)
            goto L4e
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.c.b(r9)
            com.stepos.core.common.cloud.AccountTokenCache r9 = com.stepos.core.common.cloud.AccountTokenCache.INSTANCE
            r0.L$0 = r4
            r0.L$1 = r6
            r0.J$0 = r7
            r0.label = r3
            java.lang.Object r9 = r9.bearerTokenResult$common_release(r5, r0)
            if (r9 != r1) goto L4e
            return r1
        L4e:
            com.stepos.core.common.cloud.TokenResult r9 = (com.stepos.core.common.cloud.TokenResult) r9
            boolean r5 = r9 instanceof com.stepos.core.common.cloud.TokenResult.Ok
            if (r5 == 0) goto L64
            com.stepos.core.common.cloud.AuthHeaderResult$Ready r5 = new com.stepos.core.common.cloud.AuthHeaderResult$Ready
            com.stepos.core.common.cloud.TokenResult$Ok r9 = (com.stepos.core.common.cloud.TokenResult.Ok) r9
            java.lang.String r9 = r9.getToken()
            java.util.Map r4 = r4.gatewayHeaders(r9, r6, r7)
            r5.<init>(r4)
            return r5
        L64:
            com.stepos.core.common.cloud.TokenResult$NotLoggedIn r4 = com.stepos.core.common.cloud.TokenResult.NotLoggedIn.INSTANCE
            boolean r4 = kotlin.jvm.internal.g.b(r9, r4)
            if (r4 == 0) goto L6f
            com.stepos.core.common.cloud.AuthHeaderResult$NotLoggedIn r4 = com.stepos.core.common.cloud.AuthHeaderResult.NotLoggedIn.INSTANCE
            return r4
        L6f:
            com.stepos.core.common.cloud.TokenResult$TransientFailure r4 = com.stepos.core.common.cloud.TokenResult.TransientFailure.INSTANCE
            boolean r4 = kotlin.jvm.internal.g.b(r9, r4)
            if (r4 == 0) goto L7a
            com.stepos.core.common.cloud.AuthHeaderResult$TransientFailure r4 = com.stepos.core.common.cloud.AuthHeaderResult.TransientFailure.INSTANCE
            return r4
        L7a:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.cloud.BffModelProxy.gatewayHeadersResult(java.lang.String, java.lang.String, long, qb.b):java.lang.Object");
    }

    public final boolean isReady() {
        return BffGatewayBootstrap.INSTANCE.isReady();
    }

    public final String queryUrl() {
        return a0.a.j(baseUrl(), FILE_QUERY_PATH);
    }

    public final String speechUrl() {
        return a0.a.j(baseUrl(), SPEECH_PATH);
    }

    public final String submitUrl() {
        return a0.a.j(baseUrl(), FILE_SUBMIT_PATH);
    }
}
