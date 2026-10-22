package com.obric.account;

import android.app.Application;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Account.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0002\u0004\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\r"}, d2 = {"Lcom/obric/account/Account;", "", "()V", "bridge", "com/obric/account/Account$bridge$1", "Lcom/obric/account/Account$bridge$1;", "logger", "com/obric/account/Account$logger$1", "Lcom/obric/account/Account$logger$1;", "init", "", "app", "Landroid/app/Application;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Account {
    public static final Account INSTANCE = null;
    private static final Account$bridge$1 bridge = null;
    private static final Account$logger$1 logger = null;

    private Account() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.account.Account$logger$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.account.Account$bridge$1] */
    static {
        INSTANCE = new Account();
        logger = new Account$logger$1();
        bridge = new Account$bridge$1();
    }

    public final void init(Application r3) {
        Intrinsics.checkNotNullParameter(r3, "app");
        OAccount.INSTANCE.init(r3, logger, bridge);
    }
}
