package com.android.contacts.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.editor.EventFieldEditorView;
import com.android.contacts.editor.PhoneticNameEditorView;
import com.android.contacts.obricsync.SyncContractKt;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactTypeLabelUtils;
import com.android.contacts.util.DateUtils;
import com.android.contacts.util.NameConverter;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import obric.api.ContactsContractSmt;

/* JADX INFO: loaded from: classes2.dex */
public class EntityModifier {
    private static final String COLUMN_FOR_LABEL = "data3";
    private static final String COLUMN_FOR_TYPE = "data2";
    private static final boolean DEBUG = false;
    private static final int FREQUENCY_TOTAL = Integer.MIN_VALUE;
    private static final String TAG = "EntityModifier";
    private static final int TYPE_CUSTOM = 0;
    private static final Set<String> sGenericMimeTypesWithTypeSupport = null;
    private static final Set<String> sGenericMimeTypesWithoutTypeSupport = null;

    public EntityModifier() {
    }

    public static boolean canInsert(EntityDelta r5, DataKind r6) {
        int r0 = r5.getMimeEntriesCount(r6.mimeType, true);
        boolean r7 = hasValidTypes(r5, r6);
        if (r6.typeOverallMax != (-1)) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r7 == false) goto L13;
        if (r8 == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0 < r6.typeOverallMax) goto L8;
        r8 = false;
        goto L9
    }

    public static boolean hasValidTypes(EntityDelta r2, DataKind r3) {
        if (hasEditTypes(r3) == true) goto L5;
        return true;
    L5:
        if (getValidTypes(r2, r3).size() > 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static EntityDelta.ValuesDelta ensureKindExists(EntityDelta r3, AccountType r4, String r5) {
        DataKind r6 = r4.getKindForMimetype(r5);
        if (r3.getMimeEntriesCount(r5, true) <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r6 == null) goto L14;
        if (r1 == true) goto L9;
        EntityDelta.ValuesDelta r7 = insertChild(r3, r6);
        if (r6.mimeType.equals("vnd.android.cursor.item/photo") == false) goto L13;
        r7.setFromTemplate(true);
    L13:
        return r7;
    L9:
        return r3.getMimeEntries(r5).get(0);
    L14:
        return null;
    L5:
        r1 = false;
        goto L6
    }

    public static ArrayList<AccountType.EditType> getValidTypes(EntityDelta r2, DataKind r3) {
        return getValidTypes(r2, r3, null, true, null);
    }

    public static ArrayList<AccountType.EditType> getValidTypes(EntityDelta r2, DataKind r3, AccountType.EditType r4) {
        return getValidTypes(r2, r3, r4, true, null);
    }

    private static ArrayList<AccountType.EditType> getValidTypes(EntityDelta r8, DataKind r9, AccountType.EditType r10, boolean r11, SparseIntArray r12) {
        ArrayList<AccountType.EditType> r0 = new ArrayList();
        if (hasEditTypes(r9) == true) goto L5;
        return r0;
    L5:
        if (r12 != null) goto L7;
        r12 = getTypeFrequencies(r8, r9);
    L7:
        int r13 = r12.get(Integer.MIN_VALUE);
        Iterator<AccountType.EditType> r1 = r9.typeList.iterator();
    L9:
        if (r1.hasNext() == false) goto L35;
        AccountType.EditType r2 = r1.next();
        boolean r5 = false;
        if (r9.typeOverallMax != (-1)) goto L14;
    L12:
        boolean r3 = true;
    L18:
        if (r2.specificMax != (-1)) goto L21;
    L19:
        boolean r4 = true;
    L24:
        if (r11 == false) goto L27;
    L25:
        r5 = true;
    L30:
        if (r2.equals(r10) == true) goto L34;
        if (r3 == false) goto L9;
        if (r4 == false) goto L9;
        if (r5 == false) goto L9;
    L34:
        r0.add(r2);
        goto L9
    L27:
        if (r2.secondary == true) goto L30;
    L21:
        if (r12.get(r2.rawValue) < r2.specificMax) goto L19;
        r4 = false;
        goto L24
    L14:
        if (r13 <= r9.typeOverallMax) goto L12;
        r3 = false;
        goto L18
    L35:
        return r0;
    }

    private static SparseIntArray getTypeFrequencies(EntityDelta r4, DataKind r5) {
        SparseIntArray r0 = new SparseIntArray();
        ArrayList<EntityDelta.ValuesDelta> r6 = r4.getMimeEntries(r5.mimeType);
        if (r6 != null) goto L5;
        return r0;
    L5:
        Iterator<EntityDelta.ValuesDelta> r7 = r6.iterator();
        int r1 = 0;
    L7:
        if (r7.hasNext() == false) goto L14;
        EntityDelta.ValuesDelta r2 = r7.next();
        if (r2.isVisible() == false) goto L7;
        r1 = r1 + 1;
        AccountType.EditType r3 = getCurrentType(r2, r5);
        if (r3 == null) goto L7;
        int r8 = r0.get(r3.rawValue);
        r0.put(r3.rawValue, r8 + 1);
        goto L7
    L14:
        r0.put(Integer.MIN_VALUE, r1);
        return r0;
    }

    public static boolean hasEditTypes(DataKind r1) {
        if (r1.typeList != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.typeList.size() <= 0) goto L7;
        return true;
    }

    public static AccountType.EditType getCurrentType(EntityDelta.ValuesDelta r1, DataKind r2) {
        Long r3 = r1.getAsLong(r2.typeColumn);
        if (r3 == null) goto L5;
        AccountType.EditType r4 = getType(r2, r3.intValue());
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return guessBestValidTypeFromKind(r2);
    L5:
        r4 = null;
        goto L6
    }

    public static AccountType.EditType guessBestValidTypeFromKind(DataKind r6) {
        if (hasEditTypes(r6) == true) goto L5;
        return null;
    L5:
        int r2 = 7;
        if (TextUtils.equals(r6.mimeType, "vnd.android.cursor.item/phone_v2") == true) goto L30;
        int r4 = 3;
        if (TextUtils.equals(r6.mimeType, "vnd.android.cursor.item/email_v2") == false) goto L12;
    L10:
        r2 = r4;
        goto L30
    L12:
        if (TextUtils.equals(r6.mimeType, "vnd.android.cursor.item/im") == true) goto L10;
        if (TextUtils.equals(r6.mimeType, "vnd.android.cursor.item/postal-address_v2") == true) goto L10;
        r4 = 2;
        if (TextUtils.equals(r6.mimeType, "vnd.android.cursor.item/organization") == true) goto L10;
        if (TextUtils.equals(r6.mimeType, "vnd.android.cursor.item/website") == true) goto L30;
        if (TextUtils.equals(r6.mimeType, "vnd.android.cursor.item/relation") == false) goto L27;
        r2 = 6;
        goto L30
    L27:
        if (TextUtils.equals(r6.mimeType, "vnd.android.cursor.item/contact_event") == true) goto L10;
        r2 = 0;
    L30:
        Iterator<AccountType.EditType> r0 = r6.typeList.iterator();
    L32:
        if (r0.hasNext() == false) goto L37;
        AccountType.EditType r5 = r0.next();
        if (r2 != r5.rawValue) goto L32;
        return r5;
    L37:
        if (r6.typeList.size() > 0) goto L39;
        return null;
    L39:
        return r6.typeList.get(0);
    }

    public static int guessBestValidLabelResourceFromMimeType(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return -1;
    L6:
        if (TextUtils.equals(r3, "vnd.android.cursor.item/phone_v2") == false) goto L9;
        return ContactTypeLabelUtils.getPhoneTypeLabelResource(7);
    L9:
        if (TextUtils.equals(r3, "vnd.android.cursor.item/email_v2") == false) goto L12;
        return ContactTypeLabelUtils.getEmailTypeLabelResource(3);
    L12:
        if (TextUtils.equals(r3, "vnd.android.cursor.item/im") == false) goto L15;
        return ContactsContract.CommonDataKinds.Im.getTypeLabelResource(3);
    L15:
        if (TextUtils.equals(r3, "vnd.android.cursor.item/postal-address_v2") == false) goto L18;
        return ContactTypeLabelUtils.getPostalTypeLabelResource(3);
    L18:
        if (TextUtils.equals(r3, "vnd.android.cursor.item/organization") == false) goto L21;
        return ContactsContract.CommonDataKinds.Organization.getTypeLabelResource(2);
    L21:
        if (TextUtils.equals(r3, "vnd.android.cursor.item/website") == false) goto L24;
        return -1;
    L24:
        if (TextUtils.equals(r3, "vnd.android.cursor.item/relation") == false) goto L27;
        return ContactTypeLabelUtils.getRelationTypeLabelResource(6);
    L27:
        if (TextUtils.equals(r3, "vnd.android.cursor.item/contact_event") == true) goto L29;
        return -1;
    L29:
        return ContactsUtils.getEventTypeResource(2);
    }

    public static AccountType.EditType getCurrentType(ContentValues r2, DataKind r3) {
        if (r3.typeColumn != null) goto L5;
        return null;
    L5:
        Integer r4 = r2.getAsInteger(r3.typeColumn);
        if (r4 != null) goto L9;
        return null;
    L9:
        return getType(r3, r4.intValue());
    }

    public static AccountType.EditType getCurrentType(Cursor r3, DataKind r4) {
        if (r4.typeColumn != null) goto L5;
        return null;
    L5:
        int r0 = r3.getColumnIndex(r4.typeColumn);
        if (r0 != (-1)) goto L9;
        return null;
    L9:
        return getType(r4, r3.getInt(r0));
    }

    public static AccountType.EditType getType(DataKind r2, int r3) {
        Iterator<AccountType.EditType> r4 = r2.typeList.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        AccountType.EditType r0 = r4.next();
        if (r0.rawValue != r3) goto L4;
        return r0;
    L8:
        return null;
    }

    public static int getTypePrecedence(DataKind r2, int r3) {
        int r0 = 0;
    L4:
        if (r0 >= r2.typeList.size()) goto L9;
        if (r2.typeList.get(r0).rawValue == r3) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return Integer.MAX_VALUE;
    }

    public static AccountType.EditType getBestValidType(EntityDelta r1, DataKind r2, boolean r3, int r4) {
        return getBestValidType(r1, r2, r3, r4, false);
    }

    public static AccountType.EditType getBestValidType(EntityDelta r4, DataKind r5, boolean r6, int r7, boolean r8) {
        if (r5 != null) goto L5;
    L52:
        return null;
    L5:
        if (r5.typeColumn == null) goto L52;
        SparseIntArray r1 = getTypeFrequencies(r4, r5);
        ArrayList<AccountType.EditType> r9 = getValidTypes(r4, r5, null, r6, r1);
        if (r9.size() != 0) goto L10;
        return null;
    L10:
        if (r8 == false) goto L18;
        Iterator<AccountType.EditType> r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L18;
        if (r10.next().disappearWhenUserAdd == false) goto L13;
        r10.remove();
    L18:
        if (r9.size() <= 0) goto L52;
        AccountType.EditType r11 = r9.get(r9.size() - 1);
        Iterator<AccountType.EditType> r12 = r9.iterator();
    L21:
        if (r12.hasNext() == false) goto L28;
        AccountType.EditType r0 = r12.next();
        int r2 = r1.get(r0.rawValue);
        if (r7 == r0.rawValue) goto L24;
        if (r2 <= 0) goto L21;
        r12.remove();
        goto L21
    L24:
        return r0;
    L28:
        if (r9.size() <= 0) goto L51;
        int r13 = 0;
        AccountType.EditType r14 = r9.get(0);
        if (TextUtils.equals(r5.mimeType, "vnd.android.cursor.item/phone_v2") == true) goto L48;
        if (TextUtils.equals(r5.mimeType, "vnd.android.cursor.item/email_v2") == true) goto L48;
        if (TextUtils.equals(r5.mimeType, "vnd.android.cursor.item/im") == true) goto L48;
        if (TextUtils.equals(r5.mimeType, "vnd.android.cursor.item/postal-address_v2") == true) goto L48;
        if (TextUtils.equals(r5.mimeType, "vnd.android.cursor.item/organization") == true) goto L48;
        if (TextUtils.equals(r5.mimeType, "vnd.android.cursor.item/website") == true) goto L48;
        if (TextUtils.equals(r5.mimeType, "vnd.android.cursor.item/relation") == true) goto L48;
        if (TextUtils.equals(r5.mimeType, "vnd.android.cursor.item/contact_event") == true) goto L48;
        r13 = -1;
    L48:
        if (r14.rawValue != r13) goto L50;
        return r11;
    L50:
        return r14;
    L51:
        return r11;
    }

    public static EntityDelta.ValuesDelta insertChild(EntityDelta r7, DataKind r8) {
        AccountType r0 = r7.getRawContactAccountType(ContactsApplication.getInstance().getApplicationContext());
        if (r8 != null) goto L5;
    L28:
        AccountType.EditType r3 = null;
    L30:
        if (r3 != null) goto L32;
        r3 = getBestValidType(r7, r8, false, Integer.MIN_VALUE, true);
    L32:
        if (r3 != null) goto L35;
        r3 = getBestValidType(r7, r8, true, Integer.MIN_VALUE, true);
    L35:
        return insertChild(r7, r8, r3);
    L5:
        if (TextUtils.equals(r8.mimeType, "vnd.android.cursor.item/phone_v2") == false) goto L28;
        Iterator<AccountType.EditType> r2 = r8.typeList.iterator();
    L8:
        if (r2.hasNext() == false) goto L28;
        r3 = r2.next();
        if (r0 == null) goto L8;
        if ("com.android.sim".equals(r0.accountType) == false) goto L8;
        if (SimContactsConstants.SIM_NAME.equals(r0.dataSet) == true) goto L16;
        if ("USIM".equals(r0.dataSet) == false) goto L8;
        if (r7.getMimeEntriesCount(r8.mimeType, true) > 0) goto L23;
        if (r3.rawValue != 2) goto L8;
    L23:
        if (r3.rawValue != 1) goto L8;
    L16:
        if (r3.rawValue != 2) goto L8;
        goto L30
    }

    public static EntityDelta.ValuesDelta insertChild(EntityDelta r3, DataKind r4, AccountType.EditType r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ContentValues r0 = new ContentValues();
        r0.put("mimetype", r4.mimeType);
        if (r4.defaultValues == null) goto L9;
        r0.putAll(r4.defaultValues);
    L9:
        if (r4.typeColumn == null) goto L12;
        if (r5 == null) goto L12;
        r0.put(r4.typeColumn, Integer.valueOf(r5.rawValue));
    L12:
        EntityDelta.ValuesDelta r6 = EntityDelta.ValuesDelta.fromAfter(r0);
        r3.addEntry(r6);
        return r6;
    }

    public static void trimEmpty(EntityDeltaList r4, AccountTypeManager r5) {
        Iterator<EntityDelta> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        EntityDelta r0 = r6.next();
        EntityDelta.ValuesDelta r1 = r0.getValues();
        trimEmpty(r0, r5.getAccountType(r1.getAsString("account_type"), r1.getAsString("data_set")));
        goto L4
    }

    public static boolean hasChanges(EntityDeltaList r5, AccountTypeManager r6) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.isMarkedForSplitting() == false) goto L6;
    L13:
        return true;
    L6:
        if (r5.isMarkedForJoining() == true) goto L13;
        Iterator<EntityDelta> r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L19;
        EntityDelta r0 = r7.next();
        EntityDelta.ValuesDelta r2 = r0.getValues();
        if (hasChanges(r0, r6.getAccountType(r2.getAsString("account_type"), r2.getAsString("data_set"))) == false) goto L10;
    L19:
        return false;
    }

    public static void trimEmpty(EntityDelta r9, AccountType r10) {
        Iterator<DataKind> r11 = r10.getSortedDataKinds().iterator();
        boolean r1 = false;
    L4:
        if (r11.hasNext() == false) goto L36;
        DataKind r2 = r11.next();
        ArrayList<EntityDelta.ValuesDelta> r3 = r9.getMimeEntries(r2.mimeType);
        if (r3 == null) goto L4;
        Iterator<EntityDelta.ValuesDelta> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L4;
        EntityDelta.ValuesDelta r5 = r4.next();
        if (r5.isInsert() == false) goto L14;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L21;
        boolean r7 = TextUtils.equals("com.google", r9.getValues().getAsString("account_type"));
        if (TextUtils.equals("vnd.android.cursor.item/photo", r2.mimeType) == false) goto L26;
        if (r7 == false) goto L26;
        boolean r8 = true;
    L28:
        if (r5.isDelete() == false) goto L30;
    L31:
        if (r8 == true) goto L34;
        r5.markDeleted();
    L34:
        if (r5.isFromTemplate() == true) goto L10;
    L30:
        if (isEmpty(r5, r2) == false) goto L34;
    L26:
        r8 = false;
    L21:
        r1 = true;
        goto L10
    L14:
        if (r5.isUpdate() == true) goto L19;
        if (r5.isDelete() == true) goto L19;
        r6 = false;
        goto L20
    L36:
        if (r1 == true) goto L53;
        r9.markDeleted();
        return;
    }

    public static boolean hasChanges(EntityDelta r6, AccountType r7) {
        Iterator<DataKind> r8 = r7.getSortedDataKinds().iterator();
    L4:
        if (r8.hasNext() == false) goto L23;
        DataKind r0 = r8.next();
        ArrayList<EntityDelta.ValuesDelta> r2 = r6.getMimeEntries(r0.mimeType);
        if (r2 == null) goto L4;
        Iterator<EntityDelta.ValuesDelta> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L4;
        EntityDelta.ValuesDelta r4 = r3.next();
        if (r4.isInsert() == true) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == true) goto L22;
        if (r4.isUpdate() == true) goto L22;
        if (r4.isDelete() == false) goto L10;
    L22:
        return true;
    L14:
        if (isEmpty(r4, r0) == true) goto L16;
        r5 = true;
        goto L17
    L23:
        return false;
    }

    public static void revertChanges(EntityDelta r4, AccountType r5) {
        Iterator<DataKind> r6 = r5.getSortedDataKinds().iterator();
    L4:
        if (r6.hasNext() == false) goto L25;
        DataKind r0 = r6.next();
        ArrayList<EntityDelta.ValuesDelta> r1 = r4.getMimeEntries(r0.mimeType);
        if (r1 == null) goto L4;
        Iterator<EntityDelta.ValuesDelta> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L4;
        EntityDelta.ValuesDelta r3 = r2.next();
        if (r3.isInsert() == true) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == true) goto L18;
        if (r3.isUpdate() == true) goto L21;
        if (r3.isDelete() == false) goto L10;
        r3.revertRemove();
        goto L10
    L21:
        r3.revertUpdate();
        goto L10
    L18:
        r3.revertInsert();
        goto L10
    L14:
        if (isEmpty(r3, r0) == true) goto L16;
        r7 = true;
        goto L17
    }

    public static boolean isEmpty(EntityDelta.ValuesDelta r5, DataKind r6) {
        if ("vnd.android.cursor.item/photo".equals(r6.mimeType) == false) goto L12;
        if (r5.isInsert() == false) goto L10;
        if (r5.getAsByteArray(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG) != null) goto L10;
        return true;
    L10:
        return false;
    L12:
        if ("vnd.android.cursor.item/gender".equals(r6.mimeType) == false) goto L22;
        Integer r7 = r5.getAsInteger("data1");
        if (r7 != null) goto L17;
        return false;
    L17:
        if (r7.intValue() != 0) goto L20;
        return true;
    L20:
        return false;
    L22:
        if ("vnd.android.cursor.item/card_id".equals(r6.mimeType) == false) goto L35;
        if (r5.getAsString("data1") == null) goto L28;
        if (r5.getAsString("data1").isEmpty() == true) goto L28;
    L33:
        return false;
    L28:
        if (r5.getAsLong("data3") != null) goto L30;
        return true;
    L30:
        if (r5.getAsLong("data3").longValue() != (-1)) goto L33;
        return true;
    L35:
        if (r6.fieldList != null) goto L37;
        return true;
    L37:
        Iterator<AccountType.EditField> r8 = r6.fieldList.iterator();
    L39:
        if (r8.hasNext() == false) goto L43;
        if (ContactsUtils.isGraphic(r5.getAsString(r8.next().column)) == false) goto L39;
        return false;
    L43:
        return true;
    }

    protected static boolean areEqual(EntityDelta.ValuesDelta r3, ContentValues r4, DataKind r5) {
        if (r5.fieldList != null) goto L5;
        return false;
    L5:
        Iterator<AccountType.EditField> r6 = r5.fieldList.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        AccountType.EditField r0 = r6.next();
        if (TextUtils.equals(r3.getAsString(r0.column), r4.getAsString(r0.column)) == true) goto L7;
        return false;
    L11:
        return true;
    }

    public static void parseExtras(Context r9, AccountType r10, EntityDelta r11, Bundle r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.size() == 0) goto L52;
        parseStructuredNameExtra(r9, r10, r11, r12);
        parseStructuredPostalExtra(r10, r11, r12);
        DataKind r13 = r10.getKindForMimetype("vnd.android.cursor.item/phone_v2");
        parseExtras(r11, r13, r12, "phone_type", "phone", "data1");
        parseExtras(r11, r13, r12, "secondary_phone_type", "secondary_phone", "data1");
        parseExtras(r11, r13, r12, "tertiary_phone_type", "tertiary_phone", "data1");
        DataKind r0 = r10.getKindForMimetype("vnd.android.cursor.item/email_v2");
        parseExtras(r11, r0, r12, "email_type", "email", "data1");
        parseExtras(r11, r0, r12, "secondary_email_type", "secondary_email", "data1");
        parseExtras(r11, r0, r12, "tertiary_email_type", "tertiary_email", "data1");
        DataKind r2 = r10.getKindForMimetype("vnd.android.cursor.item/im");
        fixupLegacyImType(r12);
        parseExtras(r11, r2, r12, "im_protocol", "im_handle", "data1");
        if (r12.containsKey(SyncContractKt.COLUMN_COMPANY) == false) goto L9;
    L12:
        boolean r1 = true;
    L13:
        DataKind r4 = r10.getKindForMimetype("vnd.android.cursor.item/organization");
        if (r1 == true) goto L16;
    L23:
        boolean r3 = r12.containsKey("notes");
        DataKind r5 = r10.getKindForMimetype("vnd.android.cursor.item/note");
        if (r3 == true) goto L26;
    L30:
        boolean r6 = r12.containsKey(ContactsContractSmt.get_INSERT_WEBSITE());
        DataKind r7 = r10.getKindForMimetype("vnd.android.cursor.item/website");
        if (r6 == true) goto L33;
    L39:
        DataKind r8 = r10.getKindForMimetype("vnd.android.cursor.item/card_id");
        Map r14 = (Map) r12.getSerializable("cardsInfo");
        if (r14 == null) goto L45;
        Iterator r15 = r14.keySet().iterator();
    L43:
        if (r15.hasNext() == false) goto L45;
        String r16 = (String) r15.next();
        Integer r17 = (Integer) r14.get(r16);
        Bundle r18 = new Bundle();
        r18.putString("cardId", r16);
        r18.putInt("cardId_type", r17.intValue());
        parseExtras(r11, r8, r18, "cardId_type", "cardId", "data1");
    L45:
        r10.getKindForMimetype("vnd.android.cursor.item/gender");
        parseExtras(r11, r13, r12, "gender_type", SyncContractKt.COLUMN_GENDER, "data1");
        ArrayList r19 = r12.getParcelableArrayList("data");
        if (r19 == null) goto L51;
        parseValues(r11, r10, r19);
        return;
    L51:
        return;
    L33:
        if (canInsert(r11, r7) == false) goto L39;
        EntityDelta.ValuesDelta r20 = insertChild(r11, r7);
        String r21 = r12.getString(ContactsContractSmt.get_INSERT_WEBSITE());
        if (ContactsUtils.isGraphic(r21) == false) goto L39;
        r20.put("data1", r21);
        if (r12.size() != 1) goto L39;
        r20.setTextBoldAndBlue(true);
        goto L39
    L26:
        if (canInsert(r11, r5) == false) goto L30;
        EntityDelta.ValuesDelta r22 = insertChild(r11, r5);
        String r23 = r12.getString("notes");
        if (ContactsUtils.isGraphic(r23) == false) goto L30;
        r22.put("data1", r23);
        goto L30
    L16:
        if (canInsert(r11, r4) == false) goto L23;
        EntityDelta.ValuesDelta r24 = insertChild(r11, r4);
        String r25 = r12.getString(SyncContractKt.COLUMN_COMPANY);
        if (ContactsUtils.isGraphic(r25) == false) goto L20;
        r24.put("data1", r25);
    L20:
        String r26 = r12.getString("job_title");
        if (ContactsUtils.isGraphic(r26) == false) goto L23;
        r24.put("data4", r26);
        goto L23
    L9:
        if (r12.containsKey("job_title") == true) goto L12;
        r1 = false;
        goto L13
    }

    private static void parseStructuredNameExtra(Context r11, AccountType r12, EntityDelta r13, Bundle r14) {
        ensureKindExists(r13, r12, "vnd.android.cursor.item/name");
        EntityDelta.ValuesDelta r15 = r13.getPrimaryEntry("vnd.android.cursor.item/name");
        if (r15 != null) goto L5;
    L7:
        String r1 = r14.getString("name");
        if (ContactsUtils.isGraphic(r1) == false) goto L29;
        DataKind r16 = r12.getKindForMimetype("vnd.android.cursor.item/name");
        if (r16.fieldList == null) goto L17;
        Iterator<AccountType.EditField> r17 = r16.fieldList.iterator();
    L13:
        if (r17.hasNext() == false) goto L17;
        if ("data1".equals(r17.next().column) == false) goto L13;
        boolean r18 = true;
    L19:
        if (r18 == false) goto L21;
        r15.put("data1", r1);
        r15.put("data3", r1);
        goto L29
    L21:
        Cursor r4 = r11.getContentResolver().query(ContactsContract.AUTHORITY_URI.buildUpon().appendPath("complete_name").appendQueryParameter("data1", r1).build(), new String[]{"data4", "data2", "data5", "data3", "data6"}, null, null, null);
    L26:
        th = move-exception;
        r4.close();
        throw th;
    L23:
        if (r4.moveToFirst() == false) goto L25;
        r15.put("data4", r4.getString(0));     // Catch: Throwable -> L26
        r15.put("data2", r4.getString(1));     // Catch: Throwable -> L26
        r15.put("data5", r4.getString(2));     // Catch: Throwable -> L26
        r15.put("data3", r4.getString(3));     // Catch: Throwable -> L26
        r15.put("data6", r4.getString(4));     // Catch: Throwable -> L26
    L25:
        r4.close();
    L17:
        r18 = false;
    L29:
        String r19 = r14.getString("phonetic_name");
        if (ContactsUtils.isGraphic(r19) == false) goto L38;
        r15.put("data7", r19);
        return;
    L38:
        return;
    L5:
        if (r15.beforeExists() == false) goto L7;
    }

    private static void parseStructuredPostalExtra(AccountType r7, EntityDelta r8, Bundle r9) {
        DataKind r10 = r7.getKindForMimetype("vnd.android.cursor.item/postal-address_v2");
        EntityDelta.ValuesDelta r11 = parseExtras(r8, r10, r9, "postal_type", "postal", "data1");
        if (r11 == null) goto L8;
        if (r11.beforeExists() == false) goto L8;
        return;
    L8:
        if (r11 != null) goto L10;
        String r0 = null;
    L12:
        if (TextUtils.isEmpty(r0) == false) goto L14;
        return;
    L14:
        if (r10.fieldList == null) goto L21;
        Iterator<AccountType.EditField> r12 = r10.fieldList.iterator();
    L17:
        if (r12.hasNext() == false) goto L21;
        if ("data1".equals(r12.next().column) == false) goto L17;
        boolean r13 = true;
    L22:
        if (r13 == true) goto L29;
        r11.put("data4", r0);
        r11.putNull("data1");
        return;
    L29:
        return;
    L21:
        r13 = false;
        goto L22
    L10:
        r0 = r11.getAsString("data1");
        goto L12
    }

    private static void parseValues(EntityDelta r12, AccountType r13, ArrayList<ContentValues> r14) {
        Iterator<ContentValues> r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L78;
        ContentValues r0 = r15.next();
        String r1 = r0.getAsString("mimetype");
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if ("vnd.android.cursor.item/name".equals(r1) == true) goto L4;
        DataKind r2 = r13.getKindForMimetype(r1);
        if (r2 == null) goto L13;
        EntityDelta.ValuesDelta r5 = EntityDelta.ValuesDelta.fromAfter(r0);
        if (isEmpty(r5, r2) == true) goto L4;
        ArrayList<EntityDelta.ValuesDelta> r6 = r12.getMimeEntries(r1);
        boolean r8 = false;
        boolean r9 = true;
        if (r2.typeOverallMax != 1) goto L53;
        if ("vnd.android.cursor.item/group_membership".equals(r1) == true) goto L53;
        if (r6 != null) goto L24;
    L40:
        if (r9 == false) goto L42;
        r9 = adjustType(r5, r6, r2);
    L42:
        if (r9 == true) goto L43;
        if ("vnd.android.cursor.item/note".equals(r1) == true) goto L46;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Will not override mimetype " + r1 + ". Ignoring: " + r0);
        goto L4
    L46:
        Iterator<EntityDelta.ValuesDelta> r3 = r6.iterator();
    L48:
        if (r3.hasNext() == false) goto L4;
        EntityDelta.ValuesDelta r4 = r3.next();
        if (isEmpty(r4, r2) == true) goto L48;
        r4.put("data1", r4.getAsString("data1") + "\n" + r0.getAsString("data1"));
        goto L4
    L43:
        r12.addEntry(r5);
        goto L4
    L24:
        if (r6.size() <= 0) goto L40;
        Iterator<EntityDelta.ValuesDelta> r7 = r6.iterator();
    L27:
        if (r7.hasNext() == false) goto L33;
        EntityDelta.ValuesDelta r10 = r7.next();
        if (r10.isDelete() == true) goto L27;
        if (isEmpty(r10, r2) == true) goto L27;
    L34:
        if (r8 == false) goto L39;
        Iterator<EntityDelta.ValuesDelta> r11 = r6.iterator();
    L37:
        if (r11.hasNext() == false) goto L39;
        r11.next().markDeleted();
    L39:
        r9 = r8;
        goto L40
    L33:
        r8 = true;
    L53:
        if (r6 != null) goto L55;
    L67:
        int r16 = 0;
    L69:
        if (r2.typeOverallMax != (-1)) goto L71;
    L73:
        r8 = r9;
    L74:
        if (r8 == false) goto L76;
        r8 = adjustType(r5, r6, r2);
    L76:
        if (r8 == false) goto L4;
        r12.addEntry(r5);
        goto L4
    L71:
        if (r16 < r2.typeOverallMax) goto L73;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Mimetype allows at most " + r2.typeOverallMax + " entries. Ignoring: " + r0);
        goto L74
    L55:
        if (r6.size() <= 0) goto L67;
        Iterator<EntityDelta.ValuesDelta> r17 = r6.iterator();
        r16 = 0;
    L58:
        if (r17.hasNext() == false) goto L69;
        EntityDelta.ValuesDelta r18 = r17.next();
        if (r18.isDelete() == true) goto L58;
        if (areEqual(r18, r0, r2) == true) goto L64;
    L66:
        r16 = r16 + 1;
        goto L58
    L64:
        if ("vnd.android.cursor.item/contact_event".equals(r1) == true) goto L66;
        r9 = false;
        goto L69
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Mimetype not supported for account type " + r13.getAccountTypeAndDataSet() + ". Ignoring: " + r0);
        goto L4
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Mimetype is required. Ignoring: " + r0);
        goto L4
    }

    private static boolean adjustType(EntityDelta.ValuesDelta r6, ArrayList<EntityDelta.ValuesDelta> r7, DataKind r8) {
        if (r8.typeColumn != null) goto L5;
    L25:
        return true;
    L5:
        if (r8.typeList == null) goto L25;
        if (r8.typeList.size() == 0) goto L25;
        Integer r0 = r6.getAsInteger(r8.typeColumn);
        if (r0 == null) goto L12;
        int r1 = r0.intValue();
    L14:
        if (isTypeAllowed(r1, r7, r8) == false) goto L17;
        r6.put(r8.typeColumn, r1);
        return true;
    L17:
        int r2 = r8.typeList.size();
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L24;
        AccountType.EditType r4 = r8.typeList.get(r3);
        if (isTypeAllowed(r4.rawValue, r7, r8) == true) goto L21;
        r3 = r3 + 1;
        goto L18
    L21:
        r6.put(r8.typeColumn, r4.rawValue);
        return true;
    L24:
        return false;
    L12:
        r1 = r8.typeList.get(0).rawValue;
        goto L14
    }

    private static boolean isTypeAllowed(int r5, ArrayList<EntityDelta.ValuesDelta> r6, DataKind r7) {
        int r0 = r7.typeList.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        AccountType.EditType r3 = r7.typeList.get(r2);
        if (r3.rawValue == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        int r1 = r3.specificMax;
    L9:
        if (r1 != 0) goto L12;
        return false;
    L12:
        if (r1 != (-1)) goto L15;
        return true;
    L15:
        if (getEntryCountByType(r6, r7.typeColumn, r5) < r1) goto L17;
        return false;
    L17:
        return true;
    L8:
        r1 = 0;
        goto L9
    }

    private static int getEntryCountByType(ArrayList<EntityDelta.ValuesDelta> r4, String r5, int r6) {
        int r0 = 0;
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r1 = r4.size();
        int r2 = 0;
    L6:
        if (r0 >= r1) goto L13;
        Integer r3 = r4.get(r0).getAsInteger(r5);
        if (r3 == null) goto L12;
        if (r3.intValue() != r6) goto L12;
        r2 = r2 + 1;
    L12:
        r0 = r0 + 1;
        goto L6
    L13:
        return r2;
    }

    private static void fixupLegacyImType(Bundle r3) {
        String r1 = r3.getString("im_protocol");
        if (r1 != null) goto L12;
        return;
    L12:
        Object r2 = Contacts.ContactMethods.decodeImProtocol(r1);     // Catch: IllegalArgumentException -> L10
        if ((r2 instanceof Integer) == false) goto L8;
        r3.putInt("im_protocol", ((Integer) r2).intValue());     // Catch: IllegalArgumentException -> L10
    L11:
        return;
    L8:
        r3.putString("im_protocol", (String) r2);     // Catch: IllegalArgumentException -> L10
    }

    public static EntityDelta.ValuesDelta parseExtras(EntityDelta r8, DataKind r9, Bundle r10, String r11, String r12, String r13) {
        CharSequence r14 = r10.getCharSequence(r12);
        AccountType.EditType r0 = null;
        if (r9 != null) goto L5;
        return null;
    L5:
        boolean r1 = canInsert(r8, r9);
        int r2 = 0;
        if (r14 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L42;
        if (r1 == false) goto L42;
        boolean r3 = r10.containsKey(r11);
        if (r3 == true) goto L18;
        r2 = Integer.MIN_VALUE;
    L18:
        int r5 = r10.getInt(r11, r2);
        if (r9 != null) goto L21;
    L28:
        if (r0 != null) goto L32;
        if (r3 == true) goto L31;
        r0 = getBestValidType(r8, r9, true, r5, true);
        goto L32
    L31:
        r0 = getBestValidType(r8, r9, true, r5);
    L32:
        EntityDelta.ValuesDelta r15 = insertChild(r8, r9, r0);
        r15.put(r13, r14.toString());
        if (r10.size() != 1) goto L35;
    L36:
        r15.setTextBoldAndBlue(true);
    L37:
        if (r0 != null) goto L39;
    L41:
        return r15;
    L39:
        if (r0.customColumn == null) goto L41;
        r15.put(r0.customColumn, r10.getString(r11));
        goto L41
    L35:
        if (r10.containsKey(ContactEditorFragment.EXTRA_ADD_STRANGE_NUMBER) == false) goto L37;
    L21:
        if (TextUtils.equals(r9.mimeType, "vnd.android.cursor.item/phone_v2") == false) goto L28;
        Iterator<AccountType.EditType> r6 = r9.typeList.iterator();
    L24:
        if (r6.hasNext() == false) goto L28;
        AccountType.EditType r7 = r6.next();
        if (r7.rawValue != 2) goto L24;
        r0 = r7;
    L42:
        return null;
    L8:
        if (TextUtils.isGraphic(r14) == false) goto L10;
        r4 = true;
        goto L11
    }

    static {
        sGenericMimeTypesWithTypeSupport = new HashSet(Arrays.asList(new String[]{"vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/im", "vnd.android.cursor.item/nickname", "vnd.android.cursor.item/website", "vnd.android.cursor.item/relation", "vnd.android.cursor.item/sip_address"}));
        sGenericMimeTypesWithoutTypeSupport = new HashSet(Arrays.asList(new String[]{"vnd.android.cursor.item/organization", "vnd.android.cursor.item/note", "vnd.android.cursor.item/photo", "vnd.android.cursor.item/group_membership"}));
    }

    public static void migrateStateForNewContact(Context r3, EntityDelta r4, EntityDelta r5, AccountType r6, AccountType r7) {
        if (r7 != r6) goto L20;
        Iterator<DataKind> r8 = r7.getSortedDataKinds().iterator();
    L6:
        if (r8.hasNext() == false) goto L48;
        DataKind r9 = r8.next();
        String r1 = r9.mimeType;
        if ("vnd.android.cursor.item/name".equals(r1) == true) goto L9;
        ArrayList<EntityDelta.ValuesDelta> r10 = r4.getMimeEntries(r1);
        if (r10 == null) goto L6;
        if (r10.isEmpty() == true) goto L6;
        Iterator<EntityDelta.ValuesDelta> r11 = r10.iterator();
    L16:
        if (r11.hasNext() == false) goto L6;
        ContentValues r2 = r11.next().getAfter();
        if (r2 == null) goto L16;
        r5.addEntry(EntityDelta.ValuesDelta.fromAfter(r2));
        goto L16
    L9:
        migrateStructuredName(r3, r4, r5, r9);
        goto L6
    L48:
        return;
    L20:
        Iterator<DataKind> r12 = r7.getSortedDataKinds().iterator();
    L22:
        if (r12.hasNext() == false) goto L85;
        DataKind r13 = r12.next();
        if (r13.editable == false) goto L22;
        String r14 = r13.mimeType;
        if ("#displayName".equals(r14) == true) goto L22;
        if ("#phoneticName".equals(r14) == true) goto L22;
        if ("vnd.android.cursor.item/name".equals(r14) == true) goto L33;
        if ("vnd.android.cursor.item/postal-address_v2".equals(r14) == true) goto L36;
        if ("vnd.android.cursor.item/contact_event".equals(r14) == true) goto L39;
        if (sGenericMimeTypesWithoutTypeSupport.contains(r14) == true) goto L42;
        if (sGenericMimeTypesWithTypeSupport.contains(r14) == false) goto L47;
        migrateGenericWithTypeColumn(r4, r5, r13);
        goto L22
    L47:
        throw new IllegalStateException("Unexpected editable mime-type: " + r14);
    L42:
        migrateGenericWithoutTypeColumn(r4, r5, r13);
        goto L22
    L39:
        migrateEvent(r4, r5, r13, null);
        goto L22
    L36:
        migratePostal(r4, r5, r13);
        goto L22
    L33:
        migrateStructuredName(r3, r4, r5, r13);
        goto L22
    }

    private static ArrayList<EntityDelta.ValuesDelta> ensureEntryMaxSize(EntityDelta r2, DataKind r3, ArrayList<EntityDelta.ValuesDelta> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r5 = r3.typeOverallMax;
        if (r5 >= 0) goto L8;
        return r4;
    L8:
        if (r4.size() <= r5) goto L16;
        ArrayList<EntityDelta.ValuesDelta> r6 = new ArrayList(r5);
        int r0 = 0;
    L10:
        if (r0 >= r5) goto L13;
        r6.add(r4.get(r0));
        r0 = r0 + 1;
        goto L10
    L13:
        return r6;
    L16:
        return r4;
    }

    public static void migrateStructuredName(Context r16, EntityDelta r17, EntityDelta r18, DataKind r19) {
        ContentValues r1 = r17.getPrimaryEntry("vnd.android.cursor.item/name").getAfter();
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator<AccountType.EditField> r2 = r19.fieldList.iterator();
        int r3 = 0;
        boolean r4 = false;
        boolean r5 = false;
        boolean r6 = false;
        boolean r7 = false;
        boolean r8 = false;
    L7:
        if (r2.hasNext() == false) goto L23;
        AccountType.EditField r9 = r2.next();
        if ("data1".equals(r9.column) == false) goto L12;
        r4 = true;
    L12:
        if ("#phoneticName".equals(r9.column) == false) goto L15;
        r5 = true;
    L15:
        if ("data9".equals(r9.column) == false) goto L18;
        r6 = true;
    L18:
        if ("data8".equals(r9.column) == false) goto L21;
        r7 = true;
    L21:
        if ("data7".equals(r9.column) == false) goto L7;
        r8 = true;
        goto L7
    L23:
        String r10 = r1.getAsString("data1");
        if (TextUtils.isEmpty(r10) == true) goto L27;
        if (r4 == true) goto L31;
        NameConverter.displayNameToStructuredName(r16, r10, r1);
        r1.remove("data1");
    L31:
        String r0 = r1.getAsString("#phoneticName");
        if (TextUtils.isEmpty(r0) == true) goto L44;
        if (r5 == true) goto L52;
        ContentValues r11 = PhoneticNameEditorView.parsePhoneticName(r0, null);
        r1.remove("#phoneticName");
        if (r6 == false) goto L37;
        r1.put("data9", r11.getAsString("data9"));
    L38:
        if (r7 == false) goto L40;
        r1.put("data8", r11.getAsString("data8"));
    L41:
        if (r8 == false) goto L43;
        r1.put("data7", r11.getAsString("data7"));
        goto L52
    L43:
        r1.remove("data7");
        goto L52
    L40:
        r1.remove("data8");
        goto L41
    L37:
        r1.remove("data9");
    L52:
        r18.addEntry(EntityDelta.ValuesDelta.fromAfter(r1));
        return;
    L44:
        if (r5 == false) goto L46;
        r1.put("#phoneticName", PhoneticNameEditorView.buildPhoneticName(r1.getAsString("data9"), r1.getAsString("data8"), r1.getAsString("data7")));
    L46:
        if (r6 == true) goto L48;
        r1.remove("data9");
    L48:
        if (r7 == true) goto L50;
        r1.remove("data8");
    L50:
        if (r8 == true) goto L52;
        r1.remove("data7");
        goto L52
    L27:
        if (r4 == false) goto L31;
        r1.put("data1", NameConverter.structuredNameToDisplayName(r16, r1));
        String[] r12 = NameConverter.STRUCTURED_NAME_FIELDS;
        int r13 = r12.length;
    L29:
        if (r3 >= r13) goto L31;
        r1.remove(r12[r3]);
        r3 = r3 + 1;
        goto L29
    }

    public static void migratePostal(EntityDelta r23, EntityDelta r24, DataKind r25) {
        DataKind r1 = r25;
        ArrayList<EntityDelta.ValuesDelta> r2 = ensureEntryMaxSize(r24, r1, r23.getMimeEntries("vnd.android.cursor.item/postal-address_v2"));
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isEmpty() == true) goto L83;
        int r4 = 0;
        String r3 = r1.fieldList.get(0).column;
        Iterator<AccountType.EditField> r5 = r1.fieldList.iterator();
        boolean r6 = false;
        boolean r7 = false;
    L9:
        if (r5.hasNext() == false) goto L16;
        AccountType.EditField r8 = r5.next();
        if ("data1".equals(r8.column) == false) goto L14;
        r6 = true;
    L14:
        if ("data4".equals(r8.column) == false) goto L9;
        r7 = true;
        goto L9
    L16:
        HashSet r9 = new HashSet();
        if (r1.typeList != null) goto L19;
    L24:
        Iterator<EntityDelta.ValuesDelta> r10 = r2.iterator();
    L26:
        if (r10.hasNext() == false) goto L84;
        ContentValues r11 = r10.next().getAfter();
        if (r11 == null) goto L26;
        Integer r13 = r11.getAsInteger("data2");
        if (r9.contains(r13) == false) goto L33;
    L46:
        String r12 = r11.getAsString("data1");
        if (TextUtils.isEmpty(r12) == true) goto L53;
        if (r6 == true) goto L66;
        r11.remove("data1");
        if (r7 == false) goto L52;
        r11.put("data4", r12);
        goto L66
    L52:
        r11.put(r3, r12);
    L66:
        r10 = r10;
        int r21 = r4;
        boolean r19 = r6;
    L67:
        r24.addEntry(EntityDelta.ValuesDelta.fromAfter(r11));
        r10 = r10;
        r1 = r25;
        r3 = r3;
        r9 = r9;
        r6 = r19;
        r4 = r21;
        goto L26
    L53:
        if (r6 == false) goto L66;
        if (Locale.JAPANESE.getLanguage().equals(Locale.getDefault().getLanguage()) == false) goto L57;
        String[] r14 = {r11.getAsString("data10"), r11.getAsString("data9"), r11.getAsString("data8"), r11.getAsString("data7"), r11.getAsString("data6"), r11.getAsString("data4"), r11.getAsString("data5")};
        r21 = 0;
    L58:
        StringBuilder r15 = new StringBuilder();
        int r16 = r14.length;
        int r17 = r21;
    L59:
        if (r17 >= r16) goto L65;
        int r18 = r16;
        String r20 = r14[r17];
        if (TextUtils.isEmpty(r20) == true) goto L64;
        r15.append(r20 + "\n");
    L64:
        r17 = r17 + 1;
        r16 = r18;
        r6 = r6;
        goto L59
    L65:
        r19 = r6;
        r11.put("data1", r15.toString());
        r11.remove("data5");
        r11.remove("data4");
        r11.remove("data6");
        r11.remove("data7");
        r11.remove("data8");
        r11.remove("data9");
        r11.remove("data10");
        goto L67
    L57:
        r21 = 0;
        r14 = new String[]{r11.getAsString("data5"), r11.getAsString("data4"), r11.getAsString("data6"), r11.getAsString("data7"), r11.getAsString("data8"), r11.getAsString("data9"), r11.getAsString("data10")};
        goto L58
    L33:
        if (r1.defaultValues == null) goto L36;
        r11.put("data2", Integer.valueOf(r1.defaultValues.getAsInteger("data2").intValue()));
    L42:
        if (r13 == null) goto L46;
        if (r13.intValue() != 0) goto L46;
        r11.remove("data3");
        goto L46
    L36:
        if (r1.typeList == null) goto L42;
        if (r1.typeList.size() <= 0) goto L42;
        if (r1.typeList.get(r4) == null) goto L42;
        r11.put("data2", Integer.valueOf(r1.typeList.get(r4).rawValue));
        goto L42
    L84:
        return;
    L19:
        if (r1.typeList.isEmpty() == true) goto L24;
        Iterator<AccountType.EditType> r22 = r1.typeList.iterator();
    L22:
        if (r22.hasNext() == false) goto L24;
        r9.add(Integer.valueOf(r22.next().rawValue));
        goto L22
    }

    public static void migrateEvent(EntityDelta r19, EntityDelta r20, DataKind r21, Integer r22) {
        ArrayList<EntityDelta.ValuesDelta> r2 = ensureEntryMaxSize(r20, r21, r19.getMimeEntries("vnd.android.cursor.item/contact_event"));
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isEmpty() == true) goto L48;
        HashMap r3 = new HashMap();
        Iterator<AccountType.EditType> r1 = r21.typeList.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        AccountType.EditType r4 = r1.next();
        r3.put(Integer.valueOf(r4.rawValue), (AccountType.EventEditType) r4);
        goto L9
    L11:
        Iterator<EntityDelta.ValuesDelta> r5 = r2.iterator();
        Integer r6 = r22;
    L13:
        if (r5.hasNext() == false) goto L49;
        ContentValues r7 = r5.next().getAfter();
        if (r7 == null) goto L13;
        String r8 = r7.getAsString("data1");
        Integer r9 = r7.getAsInteger("data2");
        if (r9 == null) goto L13;
        if (r3.containsKey(r9) == false) goto L13;
        if (TextUtils.isEmpty(r8) == true) goto L13;
        AccountType.EventEditType r10 = (AccountType.EventEditType) r3.get(r9);
        boolean r11 = false;
        ParsePosition r12 = new ParsePosition(0);
        Date r13 = DateUtils.DATE_AND_TIME_FORMAT.parse(r8, r12);
        if (r13 != null) goto L26;
        r13 = DateUtils.NO_YEAR_DATE_FORMAT.parse(r8, r12);
        r11 = true;
    L26:
        if (r13 == null) goto L34;
        if (r11 == false) goto L34;
        if (r10.isYearOptional() == true) goto L34;
        Calendar r14 = Calendar.getInstance(DateUtils.UTC_TIMEZONE, Locale.US);
        if (r6 != null) goto L33;
        r6 = Integer.valueOf(r14.get(1));
    L33:
        r14.setTime(r13);
        r14.set(r6.intValue(), r14.get(2), r14.get(5), EventFieldEditorView.getDefaultHourForBirthday(), 0, 0);
        r7.put("data1", DateUtils.FULL_DATE_FORMAT.format(r14.getTime()));
    L34:
        r20.addEntry(EntityDelta.ValuesDelta.fromAfter(r7));
        goto L13
    L49:
        return;
    }

    public static void migrateGenericWithoutTypeColumn(EntityDelta r1, EntityDelta r2, DataKind r3) {
        ArrayList<EntityDelta.ValuesDelta> r4 = ensureEntryMaxSize(r2, r3, r1.getMimeEntries(r3.mimeType));
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L19;
        Iterator<EntityDelta.ValuesDelta> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L20;
        ContentValues r6 = r5.next().getAfter();
        if (r6 == null) goto L9;
        r2.addEntry(EntityDelta.ValuesDelta.fromAfter(r6));
        goto L9
    L20:
        return;
    }

    public static void migrateGenericWithTypeColumn(EntityDelta r13, EntityDelta r14, DataKind r15) {
        ArrayList<EntityDelta.ValuesDelta> r16 = r13.getMimeEntries(r15.mimeType);
        if (r16 != null) goto L5;
        return;
    L5:
        if (r16.isEmpty() == false) goto L8;
        return;
    L8:
        if (r15.defaultValues == null) goto L10;
        Integer r0 = r15.defaultValues.getAsInteger("data2");
    L11:
        HashSet r3 = new HashSet();
        HashMap r4 = new HashMap();
        if (r0 == null) goto L15;
        r3.add(r0);
        r4.put(r0, -1);
    L15:
        if ("vnd.android.cursor.item/im".equals(r15.mimeType) == false) goto L17;
    L26:
        if (r0 != null) goto L28;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Default type isn't available for mimetype " + r15.mimeType);
    L28:
        int r17 = r15.typeOverallMax;
        HashMap r6 = new HashMap();
        Iterator<EntityDelta.ValuesDelta> r18 = r16.iterator();
        int r8 = 0;
    L30:
        if (r18.hasNext() == false) goto L76;
        EntityDelta.ValuesDelta r9 = r18.next();
        if (r17 == (-1)) goto L35;
        if (r8 < r17) goto L35;
        return;
    L35:
        ContentValues r10 = r9.getAfter();
        if (r10 == null) goto L30;
        Integer r11 = r9.getAsInteger("data2");
        if (r3.contains(r11) == true) goto L48;
        if (r0 == null) goto L47;
        Integer r12 = Integer.valueOf(r0.intValue());
        r10.put("data2", Integer.valueOf(r0.intValue()));
        if (r11 != null) goto L44;
    L46:
        r11 = r12;
        goto L48
    L44:
        if (r11.intValue() != 0) goto L46;
        r10.remove("data3");
        goto L46
    L47:
        r10.remove("data2");
        r11 = null;
    L48:
        if (r11 == null) goto L61;
        if (r4.containsKey(r11) == false) goto L52;
        int r19 = ((Integer) r4.get(r11)).intValue();
    L53:
        if (r19 < 0) goto L61;
        if (r6.get(r11) == null) goto L57;
        int r110 = ((Integer) r6.get(r11)).intValue();
    L58:
        if (r110 >= r19) goto L30;
        r6.put(r11, Integer.valueOf(r110 + 1));
        goto L61
    L57:
        r110 = 0;
        goto L58
    L52:
        r19 = 0;
    L61:
        r14.addEntry(EntityDelta.ValuesDelta.fromAfter(r10));
        r8 = r8 + 1;
        goto L30
    L76:
        return;
    L17:
        if (r15.typeList == null) goto L26;
        if (r15.typeList.isEmpty() == true) goto L26;
        Iterator<AccountType.EditType> r7 = r15.typeList.iterator();
    L22:
        if (r7.hasNext() == false) goto L24;
        AccountType.EditType r20 = r7.next();
        r3.add(Integer.valueOf(r20.rawValue));
        r4.put(Integer.valueOf(r20.rawValue), Integer.valueOf(r20.specificMax));
        goto L22
    L24:
        if (r0 != null) goto L26;
        r0 = Integer.valueOf(r15.typeList.get(0).rawValue);
        goto L26
    L10:
        r0 = null;
        goto L11
    }

    public static void addInsertValuesForRef(EntityDeltaList r7, EntityDelta r8, AccountTypeManager r9) {
        ArrayList<EntityDelta.ValuesDelta> r10 = r8.getInsertValues();
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<EntityDelta> r11 = r7.iterator();
    L7:
        if (r11.hasNext() == false) goto L33;
        EntityDelta r0 = r11.next();
        EntityDelta.ValuesDelta r1 = r0.getValues();
        String r2 = r1.getAsString("account_type");
        if (Constants.LOCAL_MIXED_ACCOUNT_TYPE.equals(r2) == true) goto L7;
        AccountType r3 = r9.getAccountType(r2, r1.getAsString("data_set"));
        if (r3.areContactsWritable() == false) goto L7;
        Iterator<EntityDelta.ValuesDelta> r4 = r10.iterator();
    L16:
        if (r4.hasNext() == false) goto L7;
        EntityDelta.ValuesDelta r5 = r4.next();
        String r6 = r5.getMimetype();
        DataKind r12 = r3.getKindForMimetype(r6);
        if (r12 == null) goto L16;
        if (isEmpty(r5, r12) == true) goto L16;
        if ("vnd.android.cursor.item/contact_event".equals(r6) == false) goto L32;
        if (r5.getAsInteger("data2").intValue() != 4) goto L32;
        if ((r3 instanceof BytedanceAccountType) == true) goto L32;
        if (ContactsUtils.LOCAL_ACCOUNT_TYPE.equals(r2) == false) goto L16;
    L32:
        r0.addEntry(r5);
        goto L16
    }
}
