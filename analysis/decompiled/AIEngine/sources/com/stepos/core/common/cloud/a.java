package com.stepos.core.common.cloud;

import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import com.stepos.core.common.cloud.AccountWatcher;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements OnAccountsUpdateListener {
    @Override // android.accounts.OnAccountsUpdateListener
    public final void onAccountsUpdated(Account[] accountArr) {
        AccountWatcher.C03711.invokeSuspend$lambda$1$lambda$0(accountArr);
    }
}
