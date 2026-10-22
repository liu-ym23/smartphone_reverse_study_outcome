package com.android.contacts.common.model.account;

import android.content.ContentValues;
import android.content.Context;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.model.dataitem.DataKind;
import com.android.contacts.common.util.CommonDateUtils;
import com.android.contacts.editor.LabeledEditorView;
import com.android.contacts.util.BytedanceContactContract;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.common.collect.Lists;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ExchangeAccountType extends BaseAccountType {
    private static final String ACCOUNT_TYPE_AOSP = "com.android.exchange";
    private static final String ACCOUNT_TYPE_GOOGLE_1 = "com.google.android.exchange";
    private static final String ACCOUNT_TYPE_GOOGLE_2 = "com.google.android.gm.exchange";
    private static final String TAG = "ExchangeAccountType";

    @Override // com.android.contacts.common.model.account.AccountType
    public boolean areContactsWritable() {
        return true;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType, com.android.contacts.common.model.account.AccountType
    public boolean isGroupMembershipEditable() {
        return true;
    }

    public ExchangeAccountType(Context r1, String r2, String r3) {
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
        addDataKindEvent(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindWebsite(r1);     // Catch: AccountType.DefinitionException -> L5
        addDataKindGroupMembership(r1);     // Catch: AccountType.DefinitionException -> L5
        this.mIsInitialized = true;     // Catch: AccountType.DefinitionException -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Problem building account type", e);
    }

    public static boolean isExchangeType(String r1) {
        if ("com.android.exchange".equals(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if (ACCOUNT_TYPE_GOOGLE_1.equals(r1) == true) goto L10;
        if (ACCOUNT_TYPE_GOOGLE_2.equals(r1) == true) goto L10;
        return false;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindStructuredName(Context r6) throws AccountType.DefinitionException {
        DataKind r5 = addKind(new DataKind("vnd.android.cursor.item/name", R.string.full_name, -1, true));
        r5.actionHeader = new BaseAccountType.SimpleInflater(R.string.full_name);
        r5.actionBody = new BaseAccountType.SimpleInflater("data1");
        r5.typeOverallMax = 1;
        r5.fieldList = Lists.newArrayList();
        r5.fieldList.add(new AccountType.EditField("data4", R.string.name_prefix, 8289).setOptional(true));
        r5.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289));
        r5.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289));
        r5.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289));
        r5.fieldList.add(new AccountType.EditField("data6", R.string.name_suffix, 8289));
        r5.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193));
        r5.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193));
        return r5;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindDisplayName(Context r8) throws AccountType.DefinitionException {
        DataKind r7 = addKind(new DataKind("#displayName", R.string.full_name, -1, true));
        boolean r9 = r8.getResources().getBoolean(R.bool.config_editor_field_order_primary);
        r7.typeOverallMax = 1;
        r7.fieldList = Lists.newArrayList();
        r7.fieldList.add(new AccountType.EditField("data4", R.string.name_prefix, 8289).setOptional(true));
        if (r9 == true) goto L5;
        r7.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289));
        r7.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setOptional(true));
        r7.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289));
    L6:
        r7.fieldList.add(new AccountType.EditField("data6", R.string.name_suffix, 8289).setOptional(true));
        return r7;
    L5:
        r7.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289));
        r7.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setOptional(true));
        r7.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289));
        goto L6
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindPhoneticName(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = addKind(new DataKind("#phoneticName", R.string.name_phonetic, -1, true));
        r4.actionHeader = new BaseAccountType.SimpleInflater(R.string.full_name);
        r4.actionBody = new BaseAccountType.SimpleInflater("data1");
        r4.typeOverallMax = 1;
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193));
        r4.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193));
        return r4;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindNickname(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindNickname(r5);
        r4.typeOverallMax = 1;
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.nicknameLabelsGroup, 8289));
        return r4;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindPhone(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindPhone(r5);
        r4.typeColumn = DBHelper.COL_DATA2;
        r4.typeList = Lists.newArrayList();
        r4.typeList.add(buildPhoneType(2).setSpecificMax(1));
        r4.typeList.add(buildPhoneType(1).setSpecificMax(2));
        r4.typeList.add(buildPhoneType(3).setSpecificMax(2));
        r4.typeList.add(buildPhoneType(4).setSecondary(true).setSpecificMax(1));
        r4.typeList.add(buildPhoneType(5).setSecondary(true).setSpecificMax(1));
        r4.typeList.add(buildPhoneType(6).setSecondary(true).setSpecificMax(1));
        r4.typeList.add(buildPhoneType(9).setSecondary(true).setSpecificMax(1));
        r4.typeList.add(buildPhoneType(10).setSecondary(true).setSpecificMax(1));
        r4.typeList.add(buildPhoneType(20).setSecondary(true).setSpecificMax(1));
        r4.typeList.add(buildPhoneType(14).setSecondary(true).setSpecificMax(1));
        r4.typeList.add(buildPhoneType(19).setSecondary(true).setSpecificMax(1));
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.common_phone, 3));
        return r4;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindEmail(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindEmail(r5);
        r4.typeOverallMax = 3;
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.email, 33));
        return r4;
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
    protected DataKind addDataKindIm(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindIm(r5);
        r4.typeOverallMax = 3;
        r4.defaultValues = new ContentValues();
        r4.defaultValues.put(DBHelper.COL_DATA2, 3);
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.imLabelsGroup, 33));
        return r4;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindOrganization(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindOrganization(r5);
        r4.typeOverallMax = 1;
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.common_company, LabeledEditorView.INPUT_TYPE_CUSTOM));
        r4.fieldList.add(new AccountType.EditField("data4", R.string.ghostData_title, LabeledEditorView.INPUT_TYPE_CUSTOM));
        return r4;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindPhoto(Context r4) throws AccountType.DefinitionException {
        DataKind r3 = super.addDataKindPhoto(r4);
        r3.typeOverallMax = 1;
        r3.fieldList = Lists.newArrayList();
        r3.fieldList.add(new AccountType.EditField(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, -1, -1));
        return r3;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindNote(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindNote(r5);
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.common_notes, 147457));
        return r4;
    }

    protected DataKind addDataKindEvent(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = addKind(new DataKind("vnd.android.cursor.item/contact_event", R.string.eventLabelsGroup, 120, true));
        r4.actionHeader = new BaseAccountType.EventActionInflater();
        r4.actionBody = new BaseAccountType.SimpleInflater("data1");
        r4.typeOverallMax = 1;
        r4.typeColumn = DBHelper.COL_DATA2;
        r4.typeList = Lists.newArrayList();
        r4.typeList.add(buildEventType(3, false).setSpecificMax(1));
        r4.dateFormatWithYear = CommonDateUtils.DATE_AND_TIME_FORMAT;
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.eventLabelsGroup, 1));
        return r4;
    }

    @Override // com.android.contacts.common.model.account.BaseAccountType
    protected DataKind addDataKindWebsite(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindWebsite(r5);
        r4.typeOverallMax = 1;
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.websiteLabelsGroup, 17));
        return r4;
    }
}
