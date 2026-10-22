package com.android.contacts.common.model.account;

import android.content.ContentValues;
import android.content.Context;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.model.dataitem.DataKind;
import com.android.contacts.common.util.CommonDateUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.common.collect.Lists;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class SamsungAccountType extends BaseAccountType {
    private static final String ACCOUNT_TYPE_SAMSUNG = "com.osp.app.signin";
    private static final String TAG = "KnownExternalAccountType";

    @Override // com.android.contacts.common.model.account.AccountType
    public boolean areContactsWritable() {
        return true;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType, com.android.contacts.common.model.account.AccountType
    public boolean isGroupMembershipEditable() {
        return true;
    }

    public SamsungAccountType(Context r1, String r2, String r3) {
        this.accountType = r3;
        this.resourcePackageName = null;
        this.syncAdapterPackageName = r2;
        addDataKindStructuredName(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindDisplayName(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindPhoneticName(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindNickname(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindPhone(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindEmail(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindStructuredPostal(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindIm(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindOrganization(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindPhoto(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindNote(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindWebsite(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindGroupMembership(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindRelation(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindEvent(r1);     // Catch: AccountType.DefinitionException -> L5
        this.mIsInitialized = true;     // Catch: AccountType.DefinitionException -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Problem building account type", e);
    }

    public static boolean isSamsungAccountType(Context r1, String r2, String r3) {
        if (ACCOUNT_TYPE_SAMSUNG.equals(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (ExternalAccountType.hasContactsXml(r1, r3) == true) goto L7;
        return true;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindStructuredPostal(Context r10) throws AccountType.DefinitionException {
        DataKind r9 = super.addDataKindStructuredPostal(r10);
        boolean r11 = Locale.JAPANESE.getLanguage().equals(Locale.getDefault().getLanguage());
        r9.typeColumn = DBHelper.COL_DATA2;
        r9.typeList = Lists.newArrayList();
        r9.typeList.add(buildPostalType(2).setSpecificMax(1));
        r9.typeList.add(buildPostalType(1).setSpecificMax(1));
        r9.typeList.add(buildPostalType(3).setSpecificMax(1));
        r9.fieldList = Lists.newArrayList();
        if (r11 == false) goto L5;
        r9.fieldList.add(new AccountType.EditField("data10", R.string.postal_country, 139377).setOptional(true));
        r9.fieldList.add(new AccountType.EditField("data9", R.string.postal_postcode, 139377));
        r9.fieldList.add(new AccountType.EditField("data8", R.string.postal_region, 139377));
        r9.fieldList.add(new AccountType.EditField("data7", R.string.postal_city, 139377));
        r9.fieldList.add(new AccountType.EditField("data4", R.string.postal_street, 139377));
    L6:
        return r9;
    L5:
        r9.fieldList.add(new AccountType.EditField("data4", R.string.postal_street, 139377));
        r9.fieldList.add(new AccountType.EditField("data7", R.string.postal_city, 139377));
        r9.fieldList.add(new AccountType.EditField("data8", R.string.postal_region, 139377));
        r9.fieldList.add(new AccountType.EditField("data9", R.string.postal_postcode, 139377));
        r9.fieldList.add(new AccountType.EditField("data10", R.string.postal_country, 139377).setOptional(true));
        goto L6
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindPhone(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindPhone(r5);
        r4.typeColumn = DBHelper.COL_DATA2;
        r4.typeList = Lists.newArrayList();
        r4.typeList.add(buildPhoneType(2));
        r4.typeList.add(buildPhoneType(1));
        r4.typeList.add(buildPhoneType(3));
        r4.typeList.add(buildPhoneType(12));
        r4.typeList.add(buildPhoneType(4).setSecondary(true));
        r4.typeList.add(buildPhoneType(5).setSecondary(true));
        r4.typeList.add(buildPhoneType(6).setSecondary(true));
        r4.typeList.add(buildPhoneType(14).setSecondary(true));
        r4.typeList.add(buildPhoneType(7));
        r4.typeList.add(buildPhoneType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.common_phone, 3));
        return r4;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindEmail(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindEmail(r5);
        r4.typeColumn = DBHelper.COL_DATA2;
        r4.typeList = Lists.newArrayList();
        r4.typeList.add(buildEmailType(1));
        r4.typeList.add(buildEmailType(2));
        r4.typeList.add(buildEmailType(3));
        r4.typeList.add(buildEmailType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.email, 33));
        return r4;
    }

    private DataKind addDataKindRelation(Context r6) throws AccountType.DefinitionException {
        DataKind r5 = addKind(new DataKind("vnd.android.cursor.item/relation", R.string.relationLabelsGroup, 160, true));
        r5.actionHeader = new BaseAccountType.RelationActionInflater();
        r5.actionBody = new BaseAccountType.SimpleInflater("data1");
        r5.typeColumn = DBHelper.COL_DATA2;
        r5.typeList = Lists.newArrayList();
        r5.typeList.add(buildRelationType(1));
        r5.typeList.add(buildRelationType(2));
        r5.typeList.add(buildRelationType(3));
        r5.typeList.add(buildRelationType(4));
        r5.typeList.add(buildRelationType(5));
        r5.typeList.add(buildRelationType(6));
        r5.typeList.add(buildRelationType(7));
        r5.typeList.add(buildRelationType(8));
        r5.typeList.add(buildRelationType(9));
        r5.typeList.add(buildRelationType(10));
        r5.typeList.add(buildRelationType(11));
        r5.typeList.add(buildRelationType(12));
        r5.typeList.add(buildRelationType(13));
        r5.typeList.add(buildRelationType(14));
        r5.typeList.add(buildRelationType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r5.defaultValues = new ContentValues();
        r5.defaultValues.put(DBHelper.COL_DATA2, 14);
        r5.fieldList = Lists.newArrayList();
        r5.fieldList.add(new AccountType.EditField("data1", R.string.relationLabelsGroup, 8289));
        return r5;
    }

    private DataKind addDataKindEvent(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/contact_event", R.string.eventLabelsGroup, 150, true));
        r6.actionHeader = new BaseAccountType.EventActionInflater();
        r6.actionBody = new BaseAccountType.SimpleInflater("data1");
        r6.typeColumn = DBHelper.COL_DATA2;
        r6.typeList = Lists.newArrayList();
        r6.dateFormatWithoutYear = CommonDateUtils.NO_YEAR_DATE_FORMAT;
        r6.dateFormatWithYear = CommonDateUtils.FULL_DATE_FORMAT;
        r6.typeList.add(buildEventType(3, true).setSpecificMax(1));
        r6.typeList.add(buildEventType(1, false));
        r6.typeList.add(buildEventType(2, false));
        r6.typeList.add(buildEventType(0, false).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r6.defaultValues = new ContentValues();
        r6.defaultValues.put(DBHelper.COL_DATA2, 3);
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.eventLabelsGroup, 1));
        return r6;
    }
}
