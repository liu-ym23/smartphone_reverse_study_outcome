package com.stepos.policy.sdk.util;

import V3.o;
import V3.v;
import a4.C0428b;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import i4.p;
import kotlin.coroutines.jvm.internal.l;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class PolicyAppSecretResolver {
    public static final PolicyAppSecretResolver INSTANCE = new PolicyAppSecretResolver();
    private static volatile String fallbackSecret = BuildConfig.FLAVOR;
    private static volatile String memorySecret = BuildConfig.FLAVOR;
    private static final B4.a mutex = B4.c.b(false, 1, null);
    private static volatile boolean remoteFetched;

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.util.PolicyAppSecretResolver", f = "PolicyAppSecretResolver.kt", l = {84}, m = "fetchFromServer")
    /* renamed from: com.stepos.policy.sdk.util.PolicyAppSecretResolver$fetchFromServer$1, reason: invalid class name */
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Z3.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolicyAppSecretResolver.this.fetchFromServer(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.util.PolicyAppSecretResolver$resolveForSign$2", f = "PolicyAppSecretResolver.kt", l = {PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.util.PolicyAppSecretResolver$resolveForSign$2, reason: invalid class name */
    static final class AnonymousClass2 extends l implements p<String, Z3.e<? super String>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Z3.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(eVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = C0428b.e();
            int i5 = this.label;
            if (i5 != 0) {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o.b(obj);
                return obj;
            }
            o.b(obj);
            String str = (String) this.L$0;
            PolicyAppSecretResolver policyAppSecretResolver = PolicyAppSecretResolver.INSTANCE;
            this.label = 1;
            Object objFetchFromServer = policyAppSecretResolver.fetchFromServer(str, this);
            return objFetchFromServer == objE ? objE : objFetchFromServer;
        }

        @Override // i4.p
        public final Object invoke(String str, Z3.e<? super String> eVar) {
            return ((AnonymousClass2) create(str, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.util.PolicyAppSecretResolver", f = "PolicyAppSecretResolver.kt", l = {126, 67}, m = "resolveForSign$policysdk_release")
    /* renamed from: com.stepos.policy.sdk.util.PolicyAppSecretResolver$resolveForSign$3, reason: invalid class name */
    static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Z3.e<? super AnonymousClass3> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolicyAppSecretResolver.this.resolveForSign$policysdk_release(null, null, false, null, this);
        }
    }

    private PolicyAppSecretResolver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchFromServer(java.lang.String r6, Z3.e<? super java.lang.String> r7) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicyAppSecretResolver.fetchFromServer(java.lang.String, Z3.e):java.lang.Object");
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
            str = BuildConfig.FLAVOR;
        }
        fallbackSecret = str;
        memorySecret = str;
        remoteFetched = false;
    }

    public final Object resolveForSign(String str, String str2, Z3.e<? super String> eVar) {
        return resolveForSign$policysdk_release(str, str2, PolicySdkNetworkGate.shouldBlock(), new AnonymousClass2(null), eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00d0 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x0031, B:51:0x00c0, B:53:0x00c4, B:56:0x00cb, B:57:0x00d0, B:59:0x00d6), top: B:66:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d6 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x0031, B:51:0x00c0, B:53:0x00c4, B:56:0x00cb, B:57:0x00d0, B:59:0x00d6), top: B:66:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveForSign$policysdk_release(java.lang.String r7, java.lang.String r8, boolean r9, i4.p<? super java.lang.String, ? super Z3.e<? super java.lang.String>, ? extends java.lang.Object> r10, Z3.e<? super java.lang.String> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicyAppSecretResolver.resolveForSign$policysdk_release(java.lang.String, java.lang.String, boolean, i4.p, Z3.e):java.lang.Object");
    }
}
