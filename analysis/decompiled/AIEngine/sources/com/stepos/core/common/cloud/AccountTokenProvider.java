package com.stepos.core.common.cloud;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.stepos.core.common.cloud.TokenResult;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import gc.q;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CancellableContinuationImpl;
import lb.n;
import mb.y;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AccountTokenProvider {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "AccountTokenProvider";
    private final Context appContext;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public AccountTokenProvider(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        this.appContext = context.getApplicationContext();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.stepos.core.common.cloud.AccountTokenProvider$fetch$2$listener$1] */
    public final Object fetch(qb.b<? super TokenResult> bVar) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar), 1);
        cancellableContinuationImpl.initCancellability();
        final x5.b bVar2 = new x5.b(this.appContext);
        Context context = bVar2.f13743a;
        if (context == null || y.w(context) == null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "AccountTokenProvider: not logged in, return NotLoggedIn");
            cancellableContinuationImpl.resumeWith(TokenResult.NotLoggedIn.INSTANCE);
        } else {
            ?? r22 = new x5.c() { // from class: com.stepos.core.common.cloud.AccountTokenProvider$fetch$2$listener$1
                @Override // x5.c
                public void onError(int i10, String str, String str2) {
                    AIEngineLogger.w(LogModule.ABILITY, AccountTokenProvider.TAG, "AccountTokenProvider: onError code=" + i10 + " → TransientFailure");
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(TokenResult.TransientFailure.INSTANCE);
                    }
                }

                @Override // x5.c
                public void onHandleIntent(Intent intent) {
                    AIEngineLogger.w(LogModule.ABILITY, AccountTokenProvider.TAG, "AccountTokenProvider: needs interactive login, return NotLoggedIn");
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(TokenResult.NotLoggedIn.INSTANCE);
                    }
                }

                @Override // x5.c
                public void onSuccess(String str, String str2) {
                    if (str == null || q.t0(str)) {
                        AIEngineLogger.w(LogModule.ABILITY, AccountTokenProvider.TAG, "AccountTokenProvider: onSuccess but token blank → TransientFailure");
                        if (cancellableContinuationImpl.isActive()) {
                            cancellableContinuationImpl.resumeWith(TokenResult.TransientFailure.INSTANCE);
                            return;
                        }
                        return;
                    }
                    AIEngineLogger.i(LogModule.ABILITY, AccountTokenProvider.TAG, "AccountTokenProvider: token acquired len=" + str.length());
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(new TokenResult.Ok(str));
                    }
                }
            };
            cancellableContinuationImpl.invokeOnCancellation(new l<Throwable, n>() { // from class: com.stepos.core.common.cloud.AccountTokenProvider$fetch$2$1
                @Override // zb.l
                public /* bridge */ /* synthetic */ n invoke(Throwable th) {
                    invoke2(th);
                    return n.f10413a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    try {
                        bVar2.c();
                        n nVar = n.f10413a;
                    } catch (Throwable th2) {
                        kotlin.c.a(th2);
                    }
                }
            });
            AccountManager accountManager = AccountManager.get(bVar2.f13743a);
            Account accountW = y.w(bVar2.f13743a);
            if (accountW == null) {
                accountW = new Account("unknown", "com.stepos.account");
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("invalidateToken", true);
            bVar2.f13746d = false;
            bundle.putBoolean("retry", false);
            AccountManagerFuture<Bundle> authToken = accountManager.getAuthToken(accountW, bVar2.f13744b, bundle, (Activity) null, new x5.a(bVar2, r22), (Handler) null);
            synchronized (bVar2.f13745c) {
                bVar2.f13745c.add(authToken);
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        return result;
    }
}
