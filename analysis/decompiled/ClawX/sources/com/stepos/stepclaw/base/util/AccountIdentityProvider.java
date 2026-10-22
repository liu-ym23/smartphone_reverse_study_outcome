package com.stepos.stepclaw.base.util;

import android.app.Application;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/base/util/AccountIdentityProvider;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/app/Application;", "app", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getOAID", "(Landroid/app/Application;)Ljava/lang/String;", "getLocalAccountId", "()Ljava/lang/String;", "Lkotlin/Function0;", "Lb5/a0;", "listener", "addAccountsUpdatedListener", "(Lp5/a;)V", "Companion", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface AccountIdentityProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/stepclaw/base/util/AccountIdentityProvider$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lcom/stepos/stepclaw/base/util/AccountIdentityProvider;", "get", "()Lcom/stepos/stepclaw/base/util/AccountIdentityProvider;", ConfigIpcContract.KEY_PROVIDER, "Lb5/a0;", ExtensionCallContract.OP_INSTALL, "(Lcom/stepos/stepclaw/base/util/AccountIdentityProvider;)V", "instance", "Lcom/stepos/stepclaw/base/util/AccountIdentityProvider;", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static volatile AccountIdentityProvider instance = new MzAccountIdentityProvider();

        private Companion() {
        }

        public final AccountIdentityProvider get() {
            return instance;
        }

        public final void install(AccountIdentityProvider provider) {
            p.e(provider, "provider");
            instance = provider;
        }
    }

    void addAccountsUpdatedListener(p5.a listener);

    String getLocalAccountId();

    String getOAID(Application app);
}
