package com.stepos.policy.sdk.util;

import Y8.t;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJQ\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2$\u0010\u0013\u001a \b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR$\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyAppSecretResolver;", "", "<init>", "()V", "", "appId", "fetchFromServer", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "initSecret", "LY8/t;", "reset", "(Ljava/lang/String;)V", "callerSecret", "resolveForSign", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "shouldBlock", "Lkotlin/Function2;", "Le9/c;", "fetchRemote", "resolveForSign$policysdk_release", "(Ljava/lang/String;Ljava/lang/String;ZLp9/p;Le9/c;)Ljava/lang/Object;", "<set-?>", "fallbackSecret", "Ljava/lang/String;", "getFallbackSecret", "()Ljava/lang/String;", "memorySecret", "getMemorySecret", "remoteFetched", "Z", "getRemoteFetched", "()Z", "Leb/a;", "mutex", "Leb/a;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicyAppSecretResolver {
    public static final PolicyAppSecretResolver INSTANCE = new PolicyAppSecretResolver();
    private static volatile String fallbackSecret = "";
    private static volatile String memorySecret = "";
    private static final InterfaceC4021a mutex = eb.f.b(false, 1, null);
    private static volatile boolean remoteFetched;

    @InterfaceC4112d(c = "com.stepos.policy.sdk.util.PolicyAppSecretResolver", f = "PolicyAppSecretResolver.kt", l = {84}, m = "fetchFromServer")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.util.PolicyAppSecretResolver$fetchFromServer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolicyAppSecretResolver.this.fetchFromServer(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @InterfaceC4112d(c = "com.stepos.policy.sdk.util.PolicyAppSecretResolver$resolveForSign$2", f = "PolicyAppSecretResolver.kt", l = {42}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.util.PolicyAppSecretResolver$resolveForSign$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<String, InterfaceC4014c<? super String>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            String str = (String) this.L$0;
            PolicyAppSecretResolver policyAppSecretResolver = PolicyAppSecretResolver.INSTANCE;
            this.label = 1;
            Object objFetchFromServer = policyAppSecretResolver.fetchFromServer(str, this);
            return objFetchFromServer == objG ? objG : objFetchFromServer;
        }

        @Override // p9.p
        public final Object invoke(String str, InterfaceC4014c<? super String> interfaceC4014c) {
            return ((AnonymousClass2) create(str, interfaceC4014c)).invokeSuspend(t.f7040a);
        }
    }

    @InterfaceC4112d(c = "com.stepos.policy.sdk.util.PolicyAppSecretResolver", f = "PolicyAppSecretResolver.kt", l = {126, 67}, m = "resolveForSign$policysdk_release")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.stepos.policy.sdk.util.PolicyAppSecretResolver$resolveForSign$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(interfaceC4014c);
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
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchFromServer(java.lang.String r6, e9.InterfaceC4014c<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicyAppSecretResolver.fetchFromServer(java.lang.String, e9.c):java.lang.Object");
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

    public final void reset(String initSecret) {
        if (initSecret == null) {
            initSecret = "";
        }
        fallbackSecret = initSecret;
        memorySecret = initSecret;
        remoteFetched = false;
    }

    public final Object resolveForSign(String str, String str2, InterfaceC4014c<? super String> interfaceC4014c) {
        return resolveForSign$policysdk_release(str, str2, PolicySdkNetworkGate.shouldBlock(), new AnonymousClass2(null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00d0 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x0031, B:51:0x00c0, B:53:0x00c4, B:56:0x00cb, B:57:0x00d0, B:59:0x00d6), top: B:66:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d6 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x0031, B:51:0x00c0, B:53:0x00c4, B:56:0x00cb, B:57:0x00d0, B:59:0x00d6), top: B:66:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveForSign$policysdk_release(java.lang.String r7, java.lang.String r8, boolean r9, p9.p<? super java.lang.String, ? super e9.InterfaceC4014c<? super java.lang.String>, ? extends java.lang.Object> r10, e9.InterfaceC4014c<? super java.lang.String> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.PolicyAppSecretResolver.resolveForSign$policysdk_release(java.lang.String, java.lang.String, boolean, p9.p, e9.c):java.lang.Object");
    }
}
