package com.android.contacts.model;

import android.content.ContentValues;
import android.content.Context;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.editor.LabeledEditorView;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.DateUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.android.collect.Lists;

/* JADX INFO: loaded from: classes2.dex */
public class ExchangeAccountType extends BaseAccountType {
    public static final String ACCOUNT_TYPE = "com.android.exchange";
    private static final String TAG = "ExchangeAccountType";

    @Override // com.android.contacts.model.AccountType
    public boolean areContactsWritable() {
        return true;
    }

    @Override // com.android.contacts.model.BaseAccountType, com.android.contacts.model.AccountType
    public boolean isGroupMembershipEditable() {
        return true;
    }

    public ExchangeAccountType(Context r2, String r3) {
        this.accountType = ACCOUNT_TYPE;
        this.resPackageName = null;
        this.summaryResPackageName = r3;
        addDataKindStructuredName(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindDisplayName(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindOrganization(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindNote(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindNickname(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindPhone(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindEmail(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindStructuredPostal(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindIm(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindPhoto(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindEvent(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindWebsite(r2);     // Catch: AccountType.DefinitionException -> L5
        addDataKindGroupMembership(r2);     // Catch: AccountType.DefinitionException -> L5
        this.mIsInitialized = true;     // Catch: AccountType.DefinitionException -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Problem building account type", e);
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindStructuredName(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/name", R.string.full_name, -1, true, R.layout.structured_name_editor_view));
        r6.actionHeader = new BaseAccountType.SimpleInflater(R.string.full_name);
        r6.actionBody = new BaseAccountType.SimpleInflater("data1");
        r6.typeOverallMax = 1;
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.full_name, 8289).setShortForm(true));
        r6.fieldList.add(new AccountType.EditField("data4", R.string.name_prefix, 8289).setOptional(true).setLongForm(true));
        r6.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289).setLongForm(true));
        r6.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setLongForm(true));
        r6.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289).setLongForm(true));
        return r6;
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindDisplayName(Context r15) throws AccountType.DefinitionException {
        DataKind r14 = addKind(new DataKind("#displayName", R.string.full_name, -1, true, R.layout.text_fields_editor_view));
        boolean r16 = r15.getResources().getBoolean(R.bool.config_editor_field_order_primary);
        r14.typeOverallMax = 1;
        r14.fieldList = Lists.newArrayList();
        r14.fieldList.add(new AccountType.EditField("data1", R.string.full_name, 8289).setShortForm(true));
        r14.fieldList.add(new AccountType.EditField("data4", R.string.name_prefix, 8289).setOptional(true).setLongForm(true));
        if (r16 == true) goto L5;
        r14.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289).setLongForm(true));
        r14.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193));
        r14.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setOptional(true).setLongForm(true));
        r14.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289).setLongForm(true));
        r14.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193));
    L6:
        r14.fieldList.add(new AccountType.EditField("data6", R.string.name_suffix, 8289).setOptional(true).setLongForm(true));
        return r14;
    L5:
        r14.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289).setLongForm(true));
        r14.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193));
        r14.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setOptional(true).setLongForm(true));
        r14.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289).setLongForm(true));
        r14.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193));
        goto L6
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindPhoneticName(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("#phoneticName", R.string.name_phonetic, -1, true, R.layout.phonetic_name_editor_view));
        r6.actionHeader = new BaseAccountType.SimpleInflater(R.string.full_name);
        r6.actionBody = new BaseAccountType.SimpleInflater("data1");
        r6.typeOverallMax = 1;
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193));
        r6.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193));
        return r6;
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindNickname(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindNickname(r5);
        r4.typeOverallMax = 1;
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.nicknameLabelsGroup, 8289));
        return r4;
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindPhone(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindPhone(r5);
        r4.typeColumn = DBHelper.COL_DATA2;
        r4.typeList = Lists.newArrayList();
        r4.typeList.add(buildPhoneType(2));
        r4.typeList.add(buildPhoneType(3));
        r4.typeList.add(buildPhoneType(1));
        r4.typeList.add(buildPhoneType(12));
        r4.typeList.add(buildPhoneType(4).setSecondary(true));
        r4.typeList.add(buildPhoneType(5).setSecondary(true));
        r4.typeList.add(buildPhoneType(6).setSecondary(true));
        r4.typeList.add(buildPhoneType(7));
        r4.typeList.add(buildPhoneType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r4.typeList.add(buildPhoneType(9).setSecondary(true).setDisappearWhenUserAdd(true));
        r4.typeList.add(buildPhoneType(10).setSecondary(true).setDisappearWhenUserAdd(true));
        r4.typeList.add(buildPhoneType(20).setSecondary(true).setDisappearWhenUserAdd(true));
        r4.typeList.add(buildPhoneType(14).setSecondary(true).setDisappearWhenUserAdd(true));
        r4.typeList.add(buildPhoneType(19).setSecondary(true).setDisappearWhenUserAdd(true));
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.common_phone, 3));
        return r4;
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindEmail(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindEmail(r5);
        r4.typeOverallMax = 3;
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.email, 33));
        return r4;
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindStructuredPostal(Context r1) throws AccountType.DefinitionException {
        return super.addDataKindStructuredPostal(r1);
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindIm(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindIm(r5);
        r4.typeOverallMax = 3;
        r4.defaultValues = new ContentValues();
        r4.defaultValues.put(DBHelper.COL_DATA2, 3);
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.imLabelsGroup, 33));
        return r4;
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindOrganization(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindOrganization(r5);
        r4.typeOverallMax = 1;
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.common_company, LabeledEditorView.INPUT_TYPE_CUSTOM));
        r4.fieldList.add(new AccountType.EditField("data4", R.string.ghostData_title, LabeledEditorView.INPUT_TYPE_CUSTOM));
        return r4;
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindPhoto(Context r4) throws AccountType.DefinitionException {
        DataKind r3 = super.addDataKindPhoto(r4);
        r3.typeOverallMax = 1;
        r3.fieldList = Lists.newArrayList();
        r3.fieldList.add(new AccountType.EditField(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, -1, -1));
        return r3;
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindNote(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindNote(r5);
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.common_notes, 16385));
        return r4;
    }

    protected DataKind addDataKindEvent(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/contact_event", R.string.eventLabelsGroup, 150, true, R.layout.event_field_editor_view));
        r6.actionHeader = new BaseAccountType.EventActionInflater();
        r6.actionBody = new BaseAccountType.SimpleInflater("data1");
        r6.typeOverallMax = 1;
        r6.typeColumn = DBHelper.COL_DATA2;
        r6.typeList = Lists.newArrayList();
        r6.typeList.add(buildEventType(3, true).setSpecificMax(1));
        r6.dateFormatWithYear = DateUtils.DATE_AND_TIME_FORMAT;
        r6.dateFormatWithoutYear = DateUtils.NO_YEAR_DATE_FORMAT;
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.eventLabelsGroup, 1));
        return r6;
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindWebsite(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindWebsite(r5);
        r4.typeOverallMax = 1;
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.websiteLabelsGroup, 17));
        return r4;
    }
}
