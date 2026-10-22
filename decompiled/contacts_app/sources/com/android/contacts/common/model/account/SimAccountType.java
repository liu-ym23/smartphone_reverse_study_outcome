package com.android.contacts.common.model.account;

import android.content.Context;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.model.dataitem.DataKind;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.common.collect.Lists;

/* JADX INFO: loaded from: classes.dex */
public class SimAccountType extends BaseAccountType {
    public static final String ACCOUNT_TYPE = "com.android.sim";
    public static final int FLAGS_PERSON_NAME = 8289;
    protected static final int FLAGS_PHONE = 3;
    public static final int FLAGS_PHONETIC = 193;
    private static final String TAG = "SimContactsType";
    private static Context mContext;

    @Override // com.android.contacts.common.model.account.AccountType
    public boolean areContactsWritable() {
        return true;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType, com.android.contacts.common.model.account.AccountType
    public boolean isGroupMembershipEditable() {
        return false;
    }

    public SimAccountType(Context r2, String r3) {
        this.accountType = "com.android.sim";
        this.resourcePackageName = r3;
        this.syncAdapterPackageName = r3;
        mContext = r2;
        addDataKindStructuredName(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindDisplayName(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindPhone(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindEmail(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindPhoto(r2);     // Catch: AccountType.DefinitionException -> L5
        this.mIsInitialized = true;     // Catch: AccountType.DefinitionException -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Problem building account type", e);
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindStructuredName(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindStructuredName(r5);
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.full_name, 8289));
        return r4;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindPhone(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindPhone(r5);
        r4.typeOverallMax = 2;
        r4.typeColumn = DBHelper.COL_DATA2;
        r4.typeList = Lists.newArrayList();
        r4.typeList.add(buildPhoneType(2));
        r4.typeList.add(buildPhoneType(1));
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.common_phone, 3));
        return r4;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindEmail(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindEmail(r5);
        r4.typeOverallMax = 1;
        r4.typeColumn = DBHelper.COL_DATA2;
        r4.typeList = Lists.newArrayList();
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.email, 33));
        return r4;
    }
}
