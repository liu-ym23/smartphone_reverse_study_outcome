package com.android.contacts.common.model;

import android.content.Context;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.common.model.account.AccountTypeWithDataSet;
import com.android.contacts.common.model.account.AccountWithDataSet;
import com.android.contacts.common.model.dataitem.DataKind;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class AccountTypeManager {
    public static final int FLAG_ALL_ACCOUNTS = 0;
    public static final int FLAG_ALL_ACCOUNTS_WITHOUT_LOCAL = 2;
    public static final int FLAG_ALL_ACCOUNTS_WITHOUT_SIM = 1;
    static final String TAG = "AccountTypeManager";
    private static AccountTypeManager mAccountTypeManager;
    private static final Object mInitializationLock = null;

    public abstract AccountType getAccountType(AccountTypeWithDataSet r1);

    public abstract List<AccountType> getAccountTypes(boolean r1);

    public abstract List<AccountWithDataSet> getAccounts(boolean r1);

    public abstract List<AccountWithDataSet> getAccounts(boolean r1, int r2);

    public abstract List<AccountWithDataSet> getGroupWritableAccounts();

    public abstract Map<AccountTypeWithDataSet, AccountType> getUsableInvitableAccountTypes();

    public AccountTypeManager() {
    }

    static {
        mInitializationLock = new Object();
    }

    public static AccountTypeManager getInstance(Context r2) {
        Object r0 = mInitializationLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mAccountTypeManager != null) goto L7;
        mAccountTypeManager = new AccountTypeManagerImpl(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        AccountTypeManager r3 = mAccountTypeManager;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    }

    public static void setInstanceForTest(AccountTypeManager r1) {
        Object r0 = mInitializationLock;
        monitor-enter(r0);
        mAccountTypeManager = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final AccountType getAccountType(String r1, String r2) {
        return getAccountType(AccountTypeWithDataSet.get(r1, r2));
    }

    public final AccountType getAccountTypeForAccount(AccountWithDataSet r1) {
        if (r1 == null) goto L6;
        return getAccountType(r1.getAccountTypeWithDataSet());
    L6:
        return getAccountType(null, null);
    }

    public DataKind getKindOrFallback(AccountType r1, String r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.getKindForMimetype(r2);
    }

    public boolean contains(AccountWithDataSet r2, boolean r3) {
        Iterator<AccountWithDataSet> r1 = getAccounts(false).iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r2.equals(r1.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
