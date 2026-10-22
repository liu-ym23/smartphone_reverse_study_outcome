package com.android.contacts.model;

import android.content.ContentValues;
import android.content.Context;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.DateUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.android.collect.Lists;
import obric.api.ContactsContractSmt;

/* JADX INFO: loaded from: classes2.dex */
public class BytedanceAccountType extends BaseAccountType {
    public static final String ACCOUNT_TYPE = "com.bytedance";
    private static final String TAG = "BytedanceAccountType";

    @Override // com.android.contacts.model.AccountType
    public boolean areContactsWritable() {
        return true;
    }

    @Override // com.android.contacts.model.BaseAccountType, com.android.contacts.model.AccountType
    public boolean isGroupMembershipEditable() {
        return true;
    }

    public BytedanceAccountType(Context r2, String r3) {
        this.accountType = ACCOUNT_TYPE;
        this.resPackageName = null;
        this.summaryResPackageName = r3;
        addDataKindStructuredName(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindDisplayName(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindOrganization(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindNote(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindNickname(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindPhone(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindIm(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindEmail(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindGroupMembership(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindEvent(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindStructuredPostal(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindWebsite(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindPhoto(r2);     // Catch: AccountType.DefinitionException -> L8
        if (ContactsUtils.isCtaMode() == true) goto L6;
        addDataKindSipAddress(r2);     // Catch: AccountType.DefinitionException -> L8
    L6:
        addDataKindRelation(r2);     // Catch: AccountType.DefinitionException -> L8
        this.mIsInitialized = true;     // Catch: AccountType.DefinitionException -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Problem building account type !", e);
    }

    @Override // com.android.contacts.model.BaseAccountType
    protected DataKind addDataKindPhone(Context r5) throws AccountType.DefinitionException {
        DataKind r4 = super.addDataKindPhone(r5);
        r4.typeColumn = DBHelper.COL_DATA2;
        r4.typeList = Lists.newArrayList();
        r4.typeList.add(buildPhoneType(2));
        r4.typeList.add(buildPhoneType(3));
        r4.typeList.add(buildPhoneType(1));
        r4.typeList.add(buildPhoneType(12).setDisappearWhenUserAdd(true));
        r4.typeList.add(buildPhoneType(4).setSecondary(true));
        r4.typeList.add(buildPhoneType(5).setSecondary(true).setDisappearWhenUserAdd(true));
        r4.typeList.add(buildPhoneType(6).setSecondary(true).setDisappearWhenUserAdd(true));
        r4.typeList.add(buildPhoneType(7));
        r4.typeList.add(buildPhoneType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r4.fieldList = Lists.newArrayList();
        r4.fieldList.add(new AccountType.EditField("data1", R.string.common_phone, 3));
        return r4;
    }

    @Override // com.android.contacts.model.BaseAccountType
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

    private DataKind addDataKindRelation(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/relation", R.string.relationLabelsGroup, 160, true, R.layout.text_fields_editor_view));
        r6.actionHeader = new BaseAccountType.RelationActionInflater();
        r6.actionBody = new BaseAccountType.SimpleInflater("data1");
        r6.typeColumn = DBHelper.COL_DATA2;
        r6.typeList = Lists.newArrayList();
        r6.typeList.add(buildRelationType(10));
        r6.typeList.add(buildRelationType(7));
        r6.typeList.add(buildRelationType(12));
        r6.typeList.add(buildRelationType(6));
        r6.typeList.add(buildRelationType(ContactsContractSmt.get_RELATION_TYPE_WORK_MATE()));
        r6.typeList.add(buildRelationType(ContactsContractSmt.get_RELATION_TYPE_CLASS_MATE()));
        r6.typeList.add(buildRelationType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r6.typeList.add(buildRelationType(1).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildRelationType(2).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildRelationType(3).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildRelationType(4).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildRelationType(5).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildRelationType(8).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildRelationType(9).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildRelationType(11).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildRelationType(13).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildRelationType(14).setDisappearWhenUserAdd(true));
        r6.defaultValues = new ContentValues();
        r6.defaultValues.put(DBHelper.COL_DATA2, 14);
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.relationLabelsGroup, 8289));
        return r6;
    }

    private DataKind addDataKindEvent(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/contact_event", R.string.eventLabelsGroup, 150, true, R.layout.event_field_editor_view));
        r6.actionHeader = new BaseAccountType.EventActionInflater();
        r6.actionBody = new BaseAccountType.SimpleInflater("data1");
        r6.typeColumn = DBHelper.COL_DATA2;
        r6.typeList = Lists.newArrayList();
        r6.dateFormatWithoutYear = DateUtils.NO_YEAR_DATE_FORMAT;
        r6.dateFormatWithYear = DateUtils.FULL_DATE_FORMAT;
        r6.typeList.add(buildEventType(3, true).setSpecificMax(1));
        r6.typeList.add(buildEventType(4, true).setSpecificMax(1));
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
