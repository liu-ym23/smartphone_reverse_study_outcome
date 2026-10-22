package com.stepos.stepclaw.base.util;

import a4.b;
import a6.f0;
import a6.h1;
import a6.i0;
import a6.r0;
import a6.x1;
import android.app.Application;
import b5.a0;
import b7.c;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import h6.d;
import h6.e;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/stepclaw/base/util/StepAccount;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getLocalAccountId", "()Ljava/lang/String;", "getOAID", "Landroid/app/Application;", "app", "Lb5/a0;", "init", "(Landroid/app/Application;)V", "TAG", "Ljava/lang/String;", "application", "Landroid/app/Application;", "cachedOAID", "cachedLocalAccountId", "La6/f0;", "scope", "La6/f0;", "Lcom/stepos/stepclaw/base/util/AccountIdentityProvider;", "getIdentityProvider", "()Lcom/stepos/stepclaw/base/util/AccountIdentityProvider;", "identityProvider", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StepAccount {
    private static final String TAG = "StepAccount";
    private static Application application;
    private static final f0 scope;
    public static final StepAccount INSTANCE = new StepAccount();
    private static volatile String cachedOAID = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    private static volatile String cachedLocalAccountId = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;

    static {
        x1 x1VarC = i0.c();
        e eVar = r0.f210a;
        scope = i0.b(h.I(x1VarC, d.f3059c));
    }

    private StepAccount() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccountIdentityProvider getIdentityProvider() {
        return AccountIdentityProvider.INSTANCE.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h1 init$lambda$0() {
        f0 f0Var = scope;
        e eVar = r0.f210a;
        return i0.q(f0Var, d.f3059c, new StepAccount$init$updateLocalAccountId$1$1(null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 init$lambda$1(p5.a aVar) {
        aVar.invoke();
        return a0.f883a;
    }

    public final String getLocalAccountId() {
        return cachedLocalAccountId;
    }

    public final String getOAID() {
        return cachedOAID;
    }

    public final void init(Application app) {
        p.e(app, "app");
        cachedOAID = getIdentityProvider().getOAID(app);
        ALog.i$default(TAG, f.d("OAID: [", cachedOAID, "]"), null, 4, null);
        try {
            b bVar = new b(5);
            init$lambda$0();
            getIdentityProvider().addAccountsUpdatedListener(new c(7, bVar));
        } catch (Exception e9) {
            ALog.e$default(TAG, e9.toString(), null, 4, null);
        }
    }
}
