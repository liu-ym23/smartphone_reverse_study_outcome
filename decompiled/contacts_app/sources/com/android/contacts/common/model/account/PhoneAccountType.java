package com.android.contacts.common.model.account;

import android.content.Context;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public class PhoneAccountType extends BaseAccountType {
    public static final String ACCOUNT_TYPE = "com.android.localphone";
    public static final int FLAGS_PERSON_NAME = 8289;
    protected static final int FLAGS_PHONE = 3;
    private static final String TAG = "PhoneAccountType";

    @Override // com.android.contacts.common.model.account.AccountType
    public boolean areContactsWritable() {
        return true;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType, com.android.contacts.common.model.account.AccountType
    public boolean isGroupMembershipEditable() {
        return true;
    }

    public PhoneAccountType(Context r2, String r3) {
        this.accountType = "com.android.localphone";
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
        addDataKindGroupMembership(r2);     // Catch: AccountType.DefinitionException -> L5
        this.mIsInitialized = true;     // Catch: AccountType.DefinitionException -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Problem building account type", e);
    }
}
