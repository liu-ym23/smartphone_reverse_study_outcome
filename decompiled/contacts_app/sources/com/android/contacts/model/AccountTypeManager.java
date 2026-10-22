package com.android.contacts.model;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AccountTypeManager {
    public static final String ACCOUNT_TYPE_SERVICE = "contactAccountTypes";
    static final String TAG = "AccountTypeManager";
    private static AccountTypeManager mAccountTypeManager;

    static {
    }

    public abstract AccountType getAccountType(AccountTypeWithDataSet r1);

    public abstract List<AccountType> getAccountTypes(boolean r1);

    public abstract List<AccountWithDataSet> getAccounts(boolean r1);

    public abstract List<AccountWithDataSet> getAccountsIncludeSIM(boolean r1);

    public abstract List<AccountWithDataSet> getGroupWritableAccounts();

    public abstract Map<AccountTypeWithDataSet, AccountType> getUsableInvitableAccountTypes();

    public boolean isSyncActive() {
        return false;
    }

    public AccountTypeManager() {
    }

    public static AccountTypeManager getInstance(Context r1) {
        if (mAccountTypeManager != null) goto L6;
        mAccountTypeManager = new AccountTypeManagerImpl(r1);
    L6:
        return mAccountTypeManager;
    }

    public final AccountType getAccountType(String r1, String r2) {
        return getAccountType(AccountTypeWithDataSet.get(r1, r2));
    }

    public final AccountType getAccountTypeForAccount(AccountWithDataSet r1) {
        return getAccountType(r1.getAccountTypeWithDataSet());
    }

    public DataKind getKindOrFallback(String r1, String r2, String r3) {
        AccountType r0 = getAccountType(r1, r2);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getKindForMimetype(r3);
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
