package com.stepos.policy.sdk.util;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyAppSecretResolver {
    public static final PolicyAppSecretResolver INSTANCE = new PolicyAppSecretResolver();
    private static volatile String fallbackSecret = "";
    private static volatile String memorySecret = "";
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, null);
    private static volatile boolean remoteFetched;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.util.PolicyAppSecretResolver", f = "PolicyAppSecretResolver.kt", l = {84}, m = "fetchFromServer")
    /* renamed from: com.stepos.policy.sdk.util.PolicyAppSecretResolver$fetchFromServer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolicyAppSecretResolver.this.fetchFromServer(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.util.PolicyAppSecretResolver$resolveForSign$2", f = "PolicyAppSecretResolver.kt", l = {42}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.util.PolicyAppSecretResolver$resolveForSign$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<String, qb.b<? super String>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                return obj;
            }
            kotlin.c.b(obj);
            String str = (String) this.L$0;
            PolicyAppSecretResolver policyAppSecretResolver = PolicyAppSecretResolver.INSTANCE;
            this.label = 1;
            Object objFetchFromServer = policyAppSecretResolver.fetchFromServer(str, this);
            return objFetchFromServer == coroutineSingletons ? coroutineSingletons : objFetchFromServer;
        }

        @Override // zb.p
        public final Object invoke(String str, qb.b<? super String> bVar) {
            return ((AnonymousClass2) create(str, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.util.PolicyAppSecretResolver", f = "PolicyAppSecretResolver.kt", l = {126, 67}, m = "resolveForSign$policysdk_release")
    /* renamed from: com.stepos.policy.sdk.util.PolicyAppSecretResolver$resolveForSign$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(qb.b<? super AnonymousClass3> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolicyAppSecretResolver.this.resolveForSign$policysdk_release(null, null, false, null, this);
        }
    }

    private PolicyAppSecretResolver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchFromServer(java.lang.String r8, qb.b<? super java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicyAppSecretResolver.fetchFromServer(java.lang.String, qb.b):java.lang.Object");
    }

    public final String getFallbackSecret() {
        return fallbackSecret;
    }

    public final String getMemorySecret() {
        return memorySecret;
    }

    public final boolean getRemoteFetched() {
        return remoteFetched;
    }

    public final void reset(String str) {
        if (str == null) {
            str = "";
        }
        fallbackSecret = str;
        memorySecret = str;
        remoteFetched = false;
    }

    public final Object resolveForSign(String str, String str2, qb.b<? super String> bVar) {
        return resolveForSign$policysdk_release(str, str2, PolicySdkNetworkGate.shouldBlock(), new AnonymousClass2(null), bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:13:0x002f, B:51:0x00be, B:53:0x00c2, B:56:0x00c9, B:57:0x00ce, B:59:0x00d4), top: B:66:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d4 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #0 {all -> 0x0034, blocks: (B:13:0x002f, B:51:0x00be, B:53:0x00c2, B:56:0x00c9, B:57:0x00ce, B:59:0x00d4), top: B:66:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveForSign$policysdk_release(java.lang.String r7, java.lang.String r8, boolean r9, zb.p<? super java.lang.String, ? super qb.b<? super java.lang.String>, ? extends java.lang.Object> r10, qb.b<? super java.lang.String> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicyAppSecretResolver.resolveForSign$policysdk_release(java.lang.String, java.lang.String, boolean, zb.p, qb.b):java.lang.Object");
    }
}
