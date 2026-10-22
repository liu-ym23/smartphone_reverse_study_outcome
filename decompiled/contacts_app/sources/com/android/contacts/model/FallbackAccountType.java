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
public class FallbackAccountType extends BaseAccountType {
    private static final String TAG = "FallbackAccountType";

    @Override // com.android.contacts.model.AccountType
    public boolean areContactsWritable() {
        return true;
    }

    private FallbackAccountType(Context r2, String r3) {
        this.accountType = null;
        this.dataSet = null;
        this.titleRes = R.string.account_phone;
        this.iconRes = R.mipmap.ic_launcher_phone;
        this.resPackageName = r3;
        this.summaryResPackageName = r3;
        addDataKindStructuredName(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindDisplayName(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindNote(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindNickname(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindPhone(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindOrganization(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindIm(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindEmail(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindGroupMembership(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindEvent(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindStructuredPostal(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindWebsite(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindPhoto(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindCardId(r2);     // Catch: AccountType.DefinitionException -> L8
        addDataKindGender(r2);     // Catch: AccountType.DefinitionException -> L8
        if (ContactsUtils.isCtaMode() == true) goto L6;
        addDataKindSipAddress(r2);     // Catch: AccountType.DefinitionException -> L8
    L6:
        addDataKindRelation(r2);     // Catch: AccountType.DefinitionException -> L8
        this.mIsInitialized = true;     // Catch: AccountType.DefinitionException -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Problem building account type", e);
    }

    public FallbackAccountType(Context r2) {
        this(r2, null);
    }

    static AccountType createForTest(Context r1, String r2) {
        return new FallbackAccountType(r1, r2);
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
        r6.typeList.add(buildRelationType(ContactsContractSmt.get_RELATION_TYPE_WORK_MATE(), R.string.relation_type_work_mate));
        r6.typeList.add(buildRelationType(ContactsContractSmt.get_RELATION_TYPE_CLASS_MATE(), R.string.relation_type_class_mate));
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
