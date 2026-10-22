package com.stepos.core.common.cloud;

import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CtaGateManager;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AccountTokenCache {
    private static final long SOFT_TTL_MS = 240000;
    private static final long STALE_SERVE_MAX_MS = 21600000;
    private static final String TAG = "AccountTokenCache";
    private static volatile long cachedAtMs;
    private static volatile String cachedBearer;
    public static final AccountTokenCache INSTANCE = new AccountTokenCache();
    private static final Mutex tokenMutex = MutexKt.Mutex$default(false, 1, null);
    private static final CoroutineScope bgScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    private static final AtomicBoolean revalidating = new AtomicBoolean(false);
    private static final AtomicInteger tokenEpoch = new AtomicInteger(0);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.cloud.AccountTokenCache", f = "AccountTokenCache.kt", l = {82}, m = "bearerToken")
    /* renamed from: com.stepos.core.common.cloud.AccountTokenCache$bearerToken$1, reason: invalid class name */
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
            return AccountTokenCache.this.bearerToken(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.cloud.AccountTokenCache$maybeRevalidate$1", f = "AccountTokenCache.kt", l = {132}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.common.cloud.AccountTokenCache$maybeRevalidate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03681 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        public C03681(qb.b<? super C03681> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C03681(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            try {
                try {
                    if (i10 == 0) {
                        kotlin.c.b(obj);
                        AccountTokenCache accountTokenCache = AccountTokenCache.INSTANCE;
                        this.label = 1;
                        if (accountTokenCache.revalidateNow(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.c.b(obj);
                    }
                } catch (Exception e10) {
                    AIEngineLogger.w(LogModule.ABILITY, AccountTokenCache.TAG, "[AccountToken] background revalidate failed: " + e10.getMessage());
                }
                return n.f10413a;
            } finally {
                AccountTokenCache.revalidating.set(false);
            }
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C03681) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.cloud.AccountTokenCache$prewarm$1", f = "AccountTokenCache.kt", l = {177}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.common.cloud.AccountTokenCache$prewarm$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03691 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C03691(qb.b<? super C03691> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C03691 c03691 = new C03691(bVar);
            c03691.L$0 = obj;
            return c03691;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    AccountTokenCache accountTokenCache = AccountTokenCache.INSTANCE;
                    this.label = 1;
                    obj = accountTokenCache.bearerToken("prewarm", this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.c.b(obj);
                }
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C03691) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.cloud.AccountTokenCache", f = "AccountTokenCache.kt", l = {242, 156}, m = "revalidateNow")
    /* renamed from: com.stepos.core.common.cloud.AccountTokenCache$revalidateNow$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03701 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03701(qb.b<? super C03701> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AccountTokenCache.this.revalidateNow(this);
        }
    }

    private AccountTokenCache() {
    }

    private final long ageSec() {
        return (SystemClock.elapsedRealtime() - cachedAtMs) / 1000;
    }

    public static /* synthetic */ Object bearerToken$default(AccountTokenCache accountTokenCache, String str, qb.b bVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "?";
        }
        return accountTokenCache.bearerToken(str, bVar);
    }

    public static /* synthetic */ Object bearerTokenResult$common_release$default(AccountTokenCache accountTokenCache, String str, qb.b bVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "?";
        }
        return accountTokenCache.bearerTokenResult$common_release(str, bVar);
    }

    private final String cachedServeable() {
        String str = cachedBearer;
        if (str != null && SystemClock.elapsedRealtime() - cachedAtMs < STALE_SERVE_MAX_MS) {
            return str;
        }
        return null;
    }

    private final boolean ctaAllowsFetch(String str) {
        if (CtaGateManager.INSTANCE.isGranted()) {
            return true;
        }
        AIEngineLogger.i(LogModule.ABILITY, TAG, "[AccountToken] " + str + " skipped: CTA not granted");
        return false;
    }

    private final void maybeRevalidate(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - cachedAtMs;
        if (jElapsedRealtime >= SOFT_TTL_MS && revalidating.compareAndSet(false, true)) {
            AIEngineLogger.i(LogModule.ABILITY, TAG, a0.a.h("[AccountToken] stale (age=", jElapsedRealtime / 1000, "s) → background revalidate caller=", str));
            BuildersKt__Builders_commonKt.launch$default(bgScope, null, null, new C03681(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x0031, B:39:0x00a3, B:41:0x00a9, B:46:0x00f1, B:42:0x00b1, B:44:0x00b9, B:45:0x00dc), top: B:51:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b1 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x0031, B:39:0x00a3, B:41:0x00a9, B:46:0x00f1, B:42:0x00b1, B:44:0x00b9, B:45:0x00dc), top: B:51:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object revalidateNow(qb.b<? super lb.n> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.cloud.AccountTokenCache.revalidateNow(qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object bearerToken(java.lang.String r5, qb.b<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.common.cloud.AccountTokenCache.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.common.cloud.AccountTokenCache$bearerToken$1 r0 = (com.stepos.core.common.cloud.AccountTokenCache.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.common.cloud.AccountTokenCache$bearerToken$1 r0 = new com.stepos.core.common.cloud.AccountTokenCache$bearerToken$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r6)
            goto L3b
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.c.b(r6)
            r0.label = r3
            java.lang.Object r6 = r4.bearerTokenResult$common_release(r5, r0)
            if (r6 != r1) goto L3b
            return r1
        L3b:
            boolean r4 = r6 instanceof com.stepos.core.common.cloud.TokenResult.Ok
            r5 = 0
            if (r4 == 0) goto L43
            com.stepos.core.common.cloud.TokenResult$Ok r6 = (com.stepos.core.common.cloud.TokenResult.Ok) r6
            goto L44
        L43:
            r6 = r5
        L44:
            if (r6 == 0) goto L4b
            java.lang.String r4 = r6.getToken()
            return r4
        L4b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.cloud.AccountTokenCache.bearerToken(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0106, code lost:
    
        if (r14 == r4) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object bearerTokenResult$common_release(java.lang.String r13, qb.b<? super com.stepos.core.common.cloud.TokenResult> r14) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.cloud.AccountTokenCache.bearerTokenResult$common_release(java.lang.String, qb.b):java.lang.Object");
    }

    public final void invalidate(String reason) {
        kotlin.jvm.internal.g.f(reason, "reason");
        boolean z = cachedBearer != null;
        cachedBearer = null;
        cachedAtMs = 0L;
        tokenEpoch.incrementAndGet();
        AIEngineLogger.i(LogModule.ABILITY, TAG, "[AccountToken] invalidate reason=" + reason + " hadToken=" + z);
    }

    public final void prewarm(CoroutineScope scope) {
        kotlin.jvm.internal.g.f(scope, "scope");
        if (ctaAllowsFetch("prewarm")) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C03691(null), 3, null);
        }
    }

    public final Object refresh(qb.b<? super n> bVar) {
        invalidate("refresh");
        Object objBearerToken = bearerToken("refresh", bVar);
        return objBearerToken == CoroutineSingletons.f10059a ? objBearerToken : n.f10413a;
    }
}
