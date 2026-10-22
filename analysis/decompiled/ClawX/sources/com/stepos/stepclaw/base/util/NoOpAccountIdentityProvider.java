package com.stepos.stepclaw.base.util;

import android.app.Application;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/stepclaw/base/util/NoOpAccountIdentityProvider;", "Lcom/stepos/stepclaw/base/util/AccountIdentityProvider;", "<init>", "()V", "Landroid/app/Application;", "app", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getOAID", "(Landroid/app/Application;)Ljava/lang/String;", "getLocalAccountId", "()Ljava/lang/String;", "Lkotlin/Function0;", "Lb5/a0;", "listener", "addAccountsUpdatedListener", "(Lp5/a;)V", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
final class NoOpAccountIdentityProvider implements AccountIdentityProvider {
    @Override // com.stepos.stepclaw.base.util.AccountIdentityProvider
    public void addAccountsUpdatedListener(p5.a listener) {
        p.e(listener, "listener");
    }

    @Override // com.stepos.stepclaw.base.util.AccountIdentityProvider
    public String getLocalAccountId() {
        return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    }

    @Override // com.stepos.stepclaw.base.util.AccountIdentityProvider
    public String getOAID(Application app) {
        p.e(app, "app");
        return "unknown";
    }
}
