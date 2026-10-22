package com.android.server.accounts;

import android.accounts.Account;
import android.accounts.IAccountManagerResponse;
import android.content.ComponentName;

/* JADX INFO: loaded from: classes.dex */
public interface IZswAccountManagerService {

    public interface IZswSessionInner {
        void resetTempWhiteListAccountPackage();

        void setTempWhiteListAccountPackage(ComponentName r1);
    }

    void removeAccountAsUser(AccountManagerService.UserAccounts r1, IAccountManagerResponse r2, Account r3, boolean r4, int r5, int r6);
}
