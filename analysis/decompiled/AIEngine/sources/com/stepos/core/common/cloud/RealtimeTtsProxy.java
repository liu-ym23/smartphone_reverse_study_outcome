package com.stepos.core.common.cloud;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.tonyodev.fetch2core.server.FileRequest;
import gc.o;
import gc.q;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RealtimeTtsProxy {
    private static final String DEFAULT_MODEL = "stepaudio-2.5-tts";
    public static final RealtimeTtsProxy INSTANCE = new RealtimeTtsProxy();
    private static final String PROD_WS = "wss://realtime-proxy.stepaos.com/v1/realtime/audio";
    private static final String TAG = "RealtimeTtsProxy";
    private static final String TEST_WS = "wss://realtime-proxy.t-stepos.com/v1/realtime/audio";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.cloud.RealtimeTtsProxy", f = "RealtimeTtsProxy.kt", l = {60}, m = "headers")
    /* renamed from: com.stepos.core.common.cloud.RealtimeTtsProxy$headers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return RealtimeTtsProxy.this.headers(null, this);
        }
    }

    private RealtimeTtsProxy() {
    }

    private final String appPackage() {
        String packageName;
        Context contextAppContext$common_release = BffGatewayBootstrap.INSTANCE.appContext$common_release();
        if (contextAppContext$common_release == null || (packageName = contextAppContext$common_release.getPackageName()) == null || q.t0(packageName)) {
            return null;
        }
        return packageName;
    }

    private final String appendModelQuery(String str, String str2) {
        if (q.t0(str2)) {
            str2 = DEFAULT_MODEL;
        }
        return str + (q.m0(str, '?') ? '&' : '?') + "model=" + Uri.encode(str2);
    }

    private final String deviceId() {
        Object objA;
        Context contextAppContext$common_release = BffGatewayBootstrap.INSTANCE.appContext$common_release();
        if (contextAppContext$common_release == null) {
            return null;
        }
        try {
            objA = Settings.Secure.getString(contextAppContext$common_release.getContentResolver(), "android_id");
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

    private final Map<String, String> gatewayHeaders(String str, String str2) {
        Pair pair = new Pair(FileRequest.FIELD_AUTHORIZATION, ai.onnxruntime.a.k("Bearer ", str));
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        LinkedHashMap linkedHashMapF0 = kotlin.collections.b.f0(pair, new Pair(BffModelProxy.HEADER_TRACE_ID, o.i0(string, "-", "")));
        String strAppPackage = appPackage();
        if (strAppPackage != null) {
            linkedHashMapF0.put(BffModelProxy.HEADER_APP_PACKAGE, strAppPackage);
        }
        String strDeviceId = deviceId();
        if (strDeviceId != null) {
            linkedHashMapF0.put(BffModelProxy.HEADER_DEVICE_ID, strDeviceId);
        }
        if (str2 != null) {
            if (q.t0(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                linkedHashMapF0.put(BffModelProxy.HEADER_SCENE_TYPE, str2);
            }
        }
        return linkedHashMapF0;
    }

    public static /* synthetic */ Object headers$default(RealtimeTtsProxy realtimeTtsProxy, String str, qb.b bVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        return realtimeTtsProxy.headers(str, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object headers(java.lang.String r5, qb.b<? super com.stepos.core.common.cloud.AuthHeaderResult> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.common.cloud.RealtimeTtsProxy.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.common.cloud.RealtimeTtsProxy$headers$1 r0 = (com.stepos.core.common.cloud.RealtimeTtsProxy.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.common.cloud.RealtimeTtsProxy$headers$1 r0 = new com.stepos.core.common.cloud.RealtimeTtsProxy$headers$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.L$1
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r0.L$0
            com.stepos.core.common.cloud.RealtimeTtsProxy r4 = (com.stepos.core.common.cloud.RealtimeTtsProxy) r4
            kotlin.c.b(r6)
            goto L4c
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.c.b(r6)
            com.stepos.core.common.cloud.AccountTokenCache r6 = com.stepos.core.common.cloud.AccountTokenCache.INSTANCE
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.String r2 = "tts_ws"
            java.lang.Object r6 = r6.bearerTokenResult$common_release(r2, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            com.stepos.core.common.cloud.TokenResult r6 = (com.stepos.core.common.cloud.TokenResult) r6
            boolean r0 = r6 instanceof com.stepos.core.common.cloud.TokenResult.Ok
            if (r0 == 0) goto L62
            com.stepos.core.common.cloud.TokenResult$Ok r6 = (com.stepos.core.common.cloud.TokenResult.Ok) r6
            java.lang.String r6 = r6.getToken()
            com.stepos.core.common.cloud.AuthHeaderResult$Ready r0 = new com.stepos.core.common.cloud.AuthHeaderResult$Ready
            java.util.Map r4 = r4.gatewayHeaders(r6, r5)
            r0.<init>(r4)
            return r0
        L62:
            com.stepos.core.common.cloud.TokenResult$NotLoggedIn r4 = com.stepos.core.common.cloud.TokenResult.NotLoggedIn.INSTANCE
            boolean r4 = kotlin.jvm.internal.g.b(r6, r4)
            java.lang.String r5 = "RealtimeTtsProxy"
            if (r4 == 0) goto L76
            com.stepos.core.common.log.LogModule r4 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r6 = "headers: not logged in, return NotLoggedIn"
            com.stepos.core.common.log.AIEngineLogger.w(r4, r5, r6)
            com.stepos.core.common.cloud.AuthHeaderResult$NotLoggedIn r4 = com.stepos.core.common.cloud.AuthHeaderResult.NotLoggedIn.INSTANCE
            return r4
        L76:
            com.stepos.core.common.cloud.TokenResult$TransientFailure r4 = com.stepos.core.common.cloud.TokenResult.TransientFailure.INSTANCE
            boolean r4 = kotlin.jvm.internal.g.b(r6, r4)
            if (r4 == 0) goto L88
            com.stepos.core.common.log.LogModule r4 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r6 = "headers: token temporarily unavailable, return TransientFailure"
            com.stepos.core.common.log.AIEngineLogger.w(r4, r5, r6)
            com.stepos.core.common.cloud.AuthHeaderResult$TransientFailure r4 = com.stepos.core.common.cloud.AuthHeaderResult.TransientFailure.INSTANCE
            return r4
        L88:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.cloud.RealtimeTtsProxy.headers(java.lang.String, qb.b):java.lang.Object");
    }

    public final void invalidate() {
        AccountTokenCache.INSTANCE.invalidate("tts_ws_auth_failed");
    }

    public final boolean isLoggedIn() {
        return AccountLoginState.INSTANCE.isLoggedIn();
    }

    public final void prewarm(CoroutineScope scope) {
        kotlin.jvm.internal.g.f(scope, "scope");
        AccountTokenCache.INSTANCE.prewarm(scope);
    }

    public final Object refresh(qb.b<? super n> bVar) {
        Object objRefresh = AccountTokenCache.INSTANCE.refresh(bVar);
        return objRefresh == CoroutineSingletons.f10059a ? objRefresh : n.f10413a;
    }

    public final String wsEndpoint(String model) {
        kotlin.jvm.internal.g.f(model, "model");
        return appendModelQuery(BffGatewayBootstrap.INSTANCE.isTestEnv$common_release() ? TEST_WS : PROD_WS, model);
    }
}
