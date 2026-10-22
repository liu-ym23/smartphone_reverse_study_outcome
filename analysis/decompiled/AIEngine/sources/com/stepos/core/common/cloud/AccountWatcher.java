package com.stepos.core.common.cloud;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CtaGateManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AccountWatcher {
    private static final String TAG = "AccountWatcher";
    public static final AccountWatcher INSTANCE = new AccountWatcher();
    private static final AtomicBoolean registered = new AtomicBoolean(false);
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.cloud.AccountWatcher$onAccountsChanged$1", f = "AccountWatcher.kt", l = {80}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.common.cloud.AccountWatcher$onAccountsChanged$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            try {
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            if (i10 == 0) {
                kotlin.c.b(obj);
                if (!AccountLoginState.INSTANCE.refreshAndGet()) {
                    AIEngineLogger.i(LogModule.ABILITY, AccountWatcher.TAG, "accounts changed: logged out → invalidate token cache");
                    AccountTokenCache.INSTANCE.invalidate("account_logout");
                    return n.f10413a;
                }
                if (!CtaGateManager.INSTANCE.isGranted()) {
                    AIEngineLogger.i(LogModule.ABILITY, AccountWatcher.TAG, "accounts changed: logged in but CTA not granted → skip token refresh");
                    return n.f10413a;
                }
                AIEngineLogger.i(LogModule.ABILITY, AccountWatcher.TAG, "accounts changed: logged in → refresh token cache");
                AccountTokenCache accountTokenCache = AccountTokenCache.INSTANCE;
                this.label = 1;
                if (accountTokenCache.refresh(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            n nVar = n.f10413a;
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.common.cloud.AccountWatcher$register$1", f = "AccountWatcher.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.common.cloud.AccountWatcher$register$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03711 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ Context $app;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03711(Context context, qb.b<? super C03711> bVar) {
            super(2, bVar);
            this.$app = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1$lambda$0(Account[] accountArr) {
            AccountWatcher.INSTANCE.onAccountsChanged();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C03711 c03711 = new C03711(this.$app, bVar);
            c03711.L$0 = obj;
            return c03711;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                AccountManager.get(this.$app).addOnAccountsUpdatedListener(new a(), null, true);
                AIEngineLogger.i(LogModule.ABILITY, AccountWatcher.TAG, "registered account update listener cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AccountWatcher.registered.set(false);
                ai.onnxruntime.a.w("register failed: ", thB.getMessage(), LogModule.ABILITY, AccountWatcher.TAG);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C03711) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private AccountWatcher() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAccountsChanged() {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
    }

    public final void register(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        if (registered.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C03711(context.getApplicationContext(), null), 3, null);
        }
    }
}
