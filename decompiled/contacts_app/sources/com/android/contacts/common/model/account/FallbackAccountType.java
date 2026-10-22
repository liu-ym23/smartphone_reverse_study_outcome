package com.android.contacts.common.model.account;

import android.content.Context;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;

/* JADX INFO: loaded from: classes.dex */
public class FallbackAccountType extends BaseAccountType {
    private static final String TAG = "FallbackAccountType";

    @Override // com.android.contacts.common.model.account.AccountType
    public boolean areContactsWritable() {
        return true;
    }

    private FallbackAccountType(Context r2, String r3) {
        this.accountType = null;
        this.dataSet = null;
        this.titleRes = R.string.account_phone;
        this.iconRes = R.drawable.unknown_source;
        this.resourcePackageName = r3;
        this.syncAdapterPackageName = r3;
        addDataKindStructuredName(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindDisplayName(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindPhoneticName(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindNickname(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindPhone(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindEmail(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindStructuredPostal(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindIm(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindOrganization(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindPhoto(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindNote(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindWebsite(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindSipAddress(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindGroupMembership(r2);     // Catch: AccountType.DefinitionException -> L5
        this.mIsInitialized = true;     // Catch: AccountType.DefinitionException -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Problem building account type", e);
    }

    public FallbackAccountType(Context r2) {
        this(r2, null);
    }

    static AccountType createWithPackageNameForTest(Context r1, String r2) {
        return new FallbackAccountType(r1, r2);
    }
}
