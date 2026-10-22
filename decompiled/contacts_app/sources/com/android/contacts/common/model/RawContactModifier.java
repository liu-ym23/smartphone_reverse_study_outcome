package com.android.contacts.common.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.GlobalProxyLancet;
import com.android.contacts.common.ContactsUtils;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.common.model.dataitem.DataKind;
import com.android.contacts.common.model.dataitem.PhoneDataItem;
import com.android.contacts.common.model.dataitem.StructuredNameDataItem;
import com.android.contacts.common.util.CommonDateUtils;
import com.android.contacts.common.util.DateUtils;
import com.android.contacts.common.util.NameConverter;
import com.android.contacts.obricsync.SyncContractKt;
import com.android.contacts.util.BytedanceContactContract;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class RawContactModifier {
    private static final String COLUMN_FOR_LABEL = "data3";
    private static final String COLUMN_FOR_TYPE = "data2";
    private static final boolean DEBUG = false;
    private static final int FREQUENCY_TOTAL = Integer.MIN_VALUE;
    private static final String TAG = "RawContactModifier";
    private static final int TYPE_CUSTOM = 0;
    private static final Set<String> sGenericMimeTypesWithTypeSupport = null;
    private static final Set<String> sGenericMimeTypesWithoutTypeSupport = null;

    public RawContactModifier() {
    }

    public static boolean canInsert(RawContactDelta r5, DataKind r6) {
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

    public static boolean hasValidTypes(RawContactDelta r8, DataKind r9) {
        if (hasEditTypes(r9) == true) goto L5;
        return true;
    L5:
        if (getValidTypes(r8, r9, null, true, null, true).size() > 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static ValuesDelta ensureKindExists(RawContactDelta r3, AccountType r4, String r5) {
        DataKind r6 = r4.getKindForMimetype(r5);
        if (r3.getMimeEntriesCount(r5, true) <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r6 == null) goto L14;
        if (r1 == true) goto L9;
        ValuesDelta r7 = insertChild(r3, r6);
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

    public static ArrayList<AccountType.EditType> getValidTypes(RawContactDelta r7, DataKind r8, AccountType.EditType r9, boolean r10, SparseIntArray r11, boolean r12) {
        ArrayList<AccountType.EditType> r0 = new ArrayList();
        if (hasEditTypes(r8) == true) goto L5;
        return r0;
    L5:
        if (r11 != null) goto L8;
        r11 = getTypeFrequencies(r7, r8);
    L8:
        if (r12 == false) goto L16;
        int r13 = r11.get(Integer.MIN_VALUE);
        if (r8.typeOverallMax == (-1)) goto L16;
        if (r13 < r8.typeOverallMax) goto L16;
        boolean r14 = false;
    L17:
        Iterator<AccountType.EditType> r15 = r8.typeList.iterator();
    L19:
        if (r15.hasNext() == false) goto L39;
        AccountType.EditType r3 = r15.next();
        if (r3.specificMax != (-1)) goto L24;
    L22:
        boolean r4 = true;
    L27:
        if (r10 == false) goto L30;
    L28:
        boolean r5 = true;
    L34:
        if (r3.equals(r9) == true) goto L38;
        if (r14 == false) goto L19;
        if (r4 == false) goto L19;
        if (r5 == false) goto L19;
    L38:
        r0.add(r3);
        goto L19
    L30:
        if (r3.secondary == false) goto L28;
        r5 = false;
        goto L34
    L24:
        if (r11.get(r3.rawValue) < r3.specificMax) goto L22;
        r4 = false;
        goto L27
    L39:
        return r0;
    L16:
        r14 = true;
        goto L17
    }

    private static SparseIntArray getTypeFrequencies(RawContactDelta r4, DataKind r5) {
        SparseIntArray r0 = new SparseIntArray();
        ArrayList<ValuesDelta> r6 = r4.getMimeEntries(r5.mimeType);
        if (r6 != null) goto L5;
        return r0;
    L5:
        Iterator<ValuesDelta> r7 = r6.iterator();
        int r1 = 0;
    L7:
        if (r7.hasNext() == false) goto L14;
        ValuesDelta r2 = r7.next();
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

    public static AccountType.EditType getCurrentType(ValuesDelta r1, DataKind r2) {
        Long r3 = r1.getAsLong(r2.typeColumn);
        if (r3 != null) goto L7;
        return null;
    L7:
        return getType(r2, r3.intValue());
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

    public static AccountType.EditType getBestValidType(RawContactDelta r8, DataKind r9, boolean r10, int r11) {
        if (r9 != null) goto L5;
    L23:
        return null;
    L5:
        if (r9.typeColumn == null) goto L23;
        SparseIntArray r1 = getTypeFrequencies(r8, r9);
        ArrayList<AccountType.EditType> r12 = getValidTypes(r8, r9, null, r10, r1, true);
        if (r12.size() != 0) goto L10;
        return null;
    L10:
        AccountType.EditType r13 = r12.get(r12.size() - 1);
        Iterator<AccountType.EditType> r14 = r12.iterator();
    L12:
        if (r14.hasNext() == false) goto L19;
        AccountType.EditType r0 = r14.next();
        int r2 = r1.get(r0.rawValue);
        if (r11 == r0.rawValue) goto L15;
        if (r2 <= 0) goto L12;
        r14.remove();
        goto L12
    L15:
        return r0;
    L19:
        if (r12.size() > 0) goto L21;
        return r13;
    L21:
        return r12.get(0);
    }

    public static ValuesDelta insertChild(RawContactDelta r2, DataKind r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        AccountType.EditType r0 = getBestValidType(r2, r3, false, Integer.MIN_VALUE);
        if (r0 != null) goto L9;
        r0 = getBestValidType(r2, r3, true, Integer.MIN_VALUE);
    L9:
        return insertChild(r2, r3, r0);
    }

    public static ValuesDelta insertChild(RawContactDelta r3, DataKind r4, AccountType.EditType r5) {
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
        ValuesDelta r6 = ValuesDelta.fromAfter(r0);
        r3.addEntry(r6);
        return r6;
    }

    public static void trimEmpty(RawContactDeltaList r4, AccountTypeManager r5) {
        Iterator<RawContactDelta> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        RawContactDelta r0 = r6.next();
        ValuesDelta r1 = r0.getValues();
        trimEmpty(r0, r5.getAccountType(r1.getAsString("account_type"), r1.getAsString("data_set")));
        goto L4
    }

    public static boolean hasChanges(RawContactDeltaList r1, AccountTypeManager r2) {
        return hasChanges(r1, r2, null);
    }

    public static boolean hasChanges(RawContactDeltaList r5, AccountTypeManager r6, Set<String> r7) {
        if (r5.isMarkedForSplitting() == false) goto L5;
    L15:
        return true;
    L5:
        if (r5.isMarkedForJoining() == true) goto L15;
        Iterator<RawContactDelta> r8 = r5.iterator();
    L9:
        if (r8.hasNext() == false) goto L13;
        RawContactDelta r0 = r8.next();
        ValuesDelta r2 = r0.getValues();
        if (hasChanges(r0, r6.getAccountType(r2.getAsString("account_type"), r2.getAsString("data_set")), r7) == false) goto L9;
        return true;
    L13:
        return false;
    }

    public static void trimEmpty(RawContactDelta r9, AccountType r10) {
        Iterator<DataKind> r11 = r10.getSortedDataKinds().iterator();
        boolean r1 = false;
    L4:
        if (r11.hasNext() == false) goto L32;
        DataKind r2 = r11.next();
        ArrayList<ValuesDelta> r3 = r9.getMimeEntries(r2.mimeType);
        if (r3 == null) goto L4;
        Iterator<ValuesDelta> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L4;
        ValuesDelta r5 = r4.next();
        if (r5.isInsert() == false) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L19;
        boolean r7 = TextUtils.equals("com.google", r9.getValues().getAsString("account_type"));
        if (TextUtils.equals("vnd.android.cursor.item/photo", r2.mimeType) == false) goto L24;
        if (r7 == false) goto L24;
        boolean r8 = true;
    L26:
        if (isEmpty(r5, r2) == false) goto L30;
        if (r8 == true) goto L30;
        r5.markDeleted();
    L30:
        if (r5.isFromTemplate() == true) goto L10;
    L24:
        r8 = false;
    L19:
        r1 = true;
        goto L10
    L14:
        if (r5.isUpdate() == true) goto L17;
        r6 = false;
        goto L18
    L32:
        if (r1 == true) goto L49;
        r9.markDeleted();
        return;
    }

    private static boolean hasChanges(RawContactDelta r6, AccountType r7, Set<String> r8) {
        Iterator<DataKind> r9 = r7.getSortedDataKinds().iterator();
    L4:
        if (r9.hasNext() == false) goto L28;
        DataKind r0 = r9.next();
        String r2 = r0.mimeType;
        if (r8 == null) goto L10;
        if (r8.contains(r2) == true) goto L4;
    L10:
        ArrayList<ValuesDelta> r3 = r6.getMimeEntries(r2);
        if (r3 == null) goto L4;
        Iterator<ValuesDelta> r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L4;
        ValuesDelta r5 = r4.next();
        if (r5.isInsert() == true) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == true) goto L27;
        if (r5.isUpdate() == true) goto L27;
        if (r5.isDelete() == false) goto L15;
    L27:
        return true;
    L19:
        if (isEmpty(r5, r0) == true) goto L21;
        r10 = true;
        goto L22
    L28:
        return false;
    }

    public static boolean isEmpty(ValuesDelta r3, DataKind r4) {
        if ("vnd.android.cursor.item/photo".equals(r4.mimeType) == false) goto L11;
        if (r3.isInsert() == true) goto L7;
        return false;
    L7:
        if (r3.getAsByteArray(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG) == null) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (r4.fieldList != null) goto L13;
        return true;
    L13:
        Iterator<AccountType.EditField> r5 = r4.fieldList.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        if (ContactsUtils.isGraphic(r3.getAsString(r5.next().column)) == false) goto L15;
        return false;
    L19:
        return true;
    }

    protected static boolean areEqual(ValuesDelta r3, ContentValues r4, DataKind r5) {
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

    public static void parseExtras(Context r6, AccountType r7, RawContactDelta r8, Bundle r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.size() == 0) goto L36;
        parseStructuredNameExtra(r6, r7, r8, r9);
        parseStructuredPostalExtra(r7, r8, r9);
        DataKind r10 = r7.getKindForMimetype("vnd.android.cursor.item/phone_v2");
        parseExtras(r8, r10, r9, "phone_type", "phone", "data1");
        parseExtras(r8, r10, r9, "secondary_phone_type", "secondary_phone", "data1");
        parseExtras(r8, r10, r9, "tertiary_phone_type", "tertiary_phone", "data1");
        DataKind r11 = r7.getKindForMimetype("vnd.android.cursor.item/email_v2");
        parseExtras(r8, r11, r9, "email_type", "email", "data1");
        parseExtras(r8, r11, r9, "secondary_email_type", "secondary_email", "data1");
        parseExtras(r8, r11, r9, "tertiary_email_type", "tertiary_email", "data1");
        DataKind r1 = r7.getKindForMimetype("vnd.android.cursor.item/im");
        fixupLegacyImType(r9);
        parseExtras(r8, r1, r9, "im_protocol", "im_handle", "data1");
        if (r9.containsKey(SyncContractKt.COLUMN_COMPANY) == false) goto L9;
    L12:
        boolean r0 = true;
    L13:
        DataKind r2 = r7.getKindForMimetype("vnd.android.cursor.item/organization");
        if (r0 == true) goto L16;
    L23:
        boolean r3 = r9.containsKey("notes");
        DataKind r4 = r7.getKindForMimetype("vnd.android.cursor.item/note");
        if (r3 == true) goto L26;
    L30:
        ArrayList r12 = r9.getParcelableArrayList("data");
        if (r12 == null) goto L35;
        parseValues(r8, r7, r12);
        return;
    L35:
        return;
    L26:
        if (canInsert(r8, r4) == false) goto L30;
        ValuesDelta r5 = insertChild(r8, r4);
        String r13 = r9.getString("notes");
        if (ContactsUtils.isGraphic(r13) == false) goto L30;
        r5.put("data1", r13);
        goto L30
    L16:
        if (canInsert(r8, r2) == false) goto L23;
        ValuesDelta r14 = insertChild(r8, r2);
        String r15 = r9.getString(SyncContractKt.COLUMN_COMPANY);
        if (ContactsUtils.isGraphic(r15) == false) goto L20;
        r14.put("data1", r15);
    L20:
        String r16 = r9.getString("job_title");
        if (ContactsUtils.isGraphic(r16) == false) goto L23;
        r14.put("data4", r16);
        goto L23
    L9:
        if (r9.containsKey("job_title") == true) goto L12;
        r0 = false;
        goto L13
    }

    private static void parseStructuredNameExtra(Context r11, AccountType r12, RawContactDelta r13, Bundle r14) {
        ensureKindExists(r13, r12, "vnd.android.cursor.item/name");
        ValuesDelta r15 = r13.getPrimaryEntry("vnd.android.cursor.item/name");
        String r1 = r14.getString("name");
        if (ContactsUtils.isGraphic(r1) == false) goto L24;
        DataKind r16 = r12.getKindForMimetype("vnd.android.cursor.item/name");
        if (r16.fieldList == null) goto L12;
        Iterator<AccountType.EditField> r17 = r16.fieldList.iterator();
    L8:
        if (r17.hasNext() == false) goto L12;
        if ("data1".equals(r17.next().column) == false) goto L8;
        boolean r18 = true;
    L13:
        if (r18 == false) goto L15;
        r15.put("data1", r1);
        goto L24
    L15:
        Cursor r4 = r11.getContentResolver().query(ContactsContract.AUTHORITY_URI.buildUpon().appendPath("complete_name").appendQueryParameter("data1", r1).build(), new String[]{"data4", "data2", "data5", "data3", "data6"}, null, null, null);
        if (r4 == null) goto L24;
    L21:
        th = move-exception;
        r4.close();
        throw th;
    L18:
        if (r4.moveToFirst() == false) goto L20;
        r15.put("data4", r4.getString(0));     // Catch: Throwable -> L21
        r15.put("data2", r4.getString(1));     // Catch: Throwable -> L21
        r15.put("data5", r4.getString(2));     // Catch: Throwable -> L21
        r15.put("data3", r4.getString(3));     // Catch: Throwable -> L21
        r15.put("data6", r4.getString(4));     // Catch: Throwable -> L21
    L20:
        r4.close();
    L12:
        r18 = false;
    L24:
        String r19 = r14.getString("phonetic_name");
        if (ContactsUtils.isGraphic(r19) == false) goto L33;
        StructuredNameDataItem r110 = NameConverter.parsePhoneticName(r19, null);
        r15.put("data9", r110.getPhoneticFamilyName());
        r15.put("data8", r110.getPhoneticMiddleName());
        r15.put("data7", r110.getPhoneticGivenName());
        return;
    }

    private static void parseStructuredPostalExtra(AccountType r7, RawContactDelta r8, Bundle r9) {
        DataKind r10 = r7.getKindForMimetype("vnd.android.cursor.item/postal-address_v2");
        ValuesDelta r11 = parseExtras(r8, r10, r9, "postal_type", "postal", "data1");
        if (r11 != null) goto L5;
        String r0 = null;
    L7:
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return;
    L9:
        if (r10.fieldList == null) goto L16;
        Iterator<AccountType.EditField> r12 = r10.fieldList.iterator();
    L12:
        if (r12.hasNext() == false) goto L16;
        if ("data1".equals(r12.next().column) == false) goto L12;
        boolean r13 = true;
    L17:
        if (r13 == true) goto L24;
        r11.put("data4", r0);
        r11.putNull("data1");
        return;
    L24:
        return;
    L16:
        r13 = false;
        goto L17
    L5:
        r0 = r11.getAsString("data1");
        goto L7
    }

    private static void parseValues(RawContactDelta r11, AccountType r12, ArrayList<ContentValues> r13) {
        Iterator<ContentValues> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L85;
        ContentValues r0 = r14.next();
        String r1 = r0.getAsString("mimetype");
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if ("vnd.android.cursor.item/name".equals(r1) == true) goto L4;
        if ("vnd.android.cursor.item/phone_v2".equals(r1) == false) goto L20;
        r0.remove(PhoneDataItem.KEY_FORMATTED_PHONE_NUMBER);
        Integer r3 = r0.getAsInteger("data2");
        if (r3 == null) goto L20;
        if (r3.intValue() != 0) goto L20;
        if (TextUtils.isEmpty(r0.getAsString("data3")) == false) goto L20;
        r0.put("data2", 2);
    L20:
        DataKind r2 = r12.getKindForMimetype(r1);
        if (r2 == null) goto L22;
        ValuesDelta r4 = ValuesDelta.fromAfter(r0);
        if (isEmpty(r4, r2) == true) goto L4;
        ArrayList<ValuesDelta> r5 = r11.getMimeEntries(r1);
        boolean r7 = false;
        boolean r8 = true;
        if (r2.typeOverallMax != 1) goto L62;
        if ("vnd.android.cursor.item/group_membership".equals(r1) == true) goto L62;
        if (r5 != null) goto L33;
    L49:
        if (r8 == false) goto L51;
        r8 = adjustType(r4, r5, r2);
    L51:
        if (r8 == true) goto L52;
        if ("vnd.android.cursor.item/note".equals(r1) == true) goto L55;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Will not override mimetype " + r1 + ". Ignoring: " + r0);
        goto L4
    L55:
        Iterator<ValuesDelta> r6 = r5.iterator();
    L57:
        if (r6.hasNext() == false) goto L4;
        ValuesDelta r9 = r6.next();
        if (isEmpty(r9, r2) == true) goto L57;
        r9.put("data1", r9.getAsString("data1") + "\n" + r0.getAsString("data1"));
        goto L4
    L52:
        r11.addEntry(r4);
        goto L4
    L33:
        if (r5.size() <= 0) goto L49;
        Iterator<ValuesDelta> r10 = r5.iterator();
    L36:
        if (r10.hasNext() == false) goto L42;
        ValuesDelta r15 = r10.next();
        if (r15.isDelete() == true) goto L36;
        if (isEmpty(r15, r2) == true) goto L36;
    L43:
        if (r7 == false) goto L48;
        Iterator<ValuesDelta> r16 = r5.iterator();
    L46:
        if (r16.hasNext() == false) goto L48;
        r16.next().markDeleted();
    L48:
        r8 = r7;
        goto L49
    L42:
        r7 = true;
    L62:
        if (r5 != null) goto L64;
    L74:
        int r17 = 0;
    L76:
        if (r2.typeOverallMax != (-1)) goto L78;
    L80:
        r7 = r8;
    L81:
        if (r7 == false) goto L83;
        r7 = adjustType(r4, r5, r2);
    L83:
        if (r7 == false) goto L4;
        r11.addEntry(r4);
        goto L4
    L78:
        if (r17 < r2.typeOverallMax) goto L80;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Mimetype allows at most " + r2.typeOverallMax + " entries. Ignoring: " + r0);
        goto L81
    L64:
        if (r5.size() <= 0) goto L74;
        Iterator<ValuesDelta> r18 = r5.iterator();
        r17 = 0;
    L67:
        if (r18.hasNext() == false) goto L76;
        ValuesDelta r19 = r18.next();
        if (r19.isDelete() == true) goto L67;
        if (areEqual(r19, r0, r2) == true) goto L72;
        r17 = r17 + 1;
        goto L67
    L72:
        r8 = false;
        goto L76
    L22:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Mimetype not supported for account type " + r12.getAccountTypeAndDataSet() + ". Ignoring: " + r0);
        goto L4
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Mimetype is required. Ignoring: " + r0);
        goto L4
    }

    private static boolean adjustType(ValuesDelta r6, ArrayList<ValuesDelta> r7, DataKind r8) {
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

    private static boolean isTypeAllowed(int r5, ArrayList<ValuesDelta> r6, DataKind r7) {
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

    private static int getEntryCountByType(ArrayList<ValuesDelta> r2, String r3, int r4) {
        int r0 = 0;
        if (r2 == null) goto L12;
        Iterator<ValuesDelta> r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L12;
        Integer r1 = r5.next().getAsInteger(r3);
        if (r1 == null) goto L6;
        if (r1.intValue() != r4) goto L6;
        r0 = r0 + 1;
    L12:
        return r0;
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

    public static ValuesDelta parseExtras(RawContactDelta r5, DataKind r6, Bundle r7, String r8, String r9, String r10) {
        CharSequence r11 = r7.getCharSequence(r9);
        if (r6 != null) goto L5;
        return null;
    L5:
        boolean r1 = canInsert(r5, r6);
        int r3 = 0;
        if (r11 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L24;
        if (r1 == false) goto L24;
        if (r7.containsKey(r8) == true) goto L18;
        r3 = Integer.MIN_VALUE;
    L18:
        AccountType.EditType r0 = getBestValidType(r5, r6, true, r7.getInt(r8, r3));
        ValuesDelta r12 = insertChild(r5, r6, r0);
        r12.put(r10, r11.toString());
        if (r0 != null) goto L21;
    L23:
        return r12;
    L21:
        if (r0.customColumn == null) goto L23;
        r12.put(r0.customColumn, r7.getString(r8));
    L24:
        return null;
    L8:
        if (TextUtils.isGraphic(r11) == false) goto L10;
        r4 = true;
        goto L11
    }

    static {
        sGenericMimeTypesWithTypeSupport = new HashSet(Arrays.asList(new String[]{"vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/im", "vnd.android.cursor.item/nickname", "vnd.android.cursor.item/website", "vnd.android.cursor.item/relation", "vnd.android.cursor.item/sip_address"}));
        sGenericMimeTypesWithoutTypeSupport = new HashSet(Arrays.asList(new String[]{"vnd.android.cursor.item/organization", "vnd.android.cursor.item/note", "vnd.android.cursor.item/photo", "vnd.android.cursor.item/group_membership"}));
    }

    public static void migrateStateForNewContact(Context r3, RawContactDelta r4, RawContactDelta r5, AccountType r6, AccountType r7) {
        if (r7 != r6) goto L20;
        Iterator<DataKind> r8 = r7.getSortedDataKinds().iterator();
    L6:
        if (r8.hasNext() == false) goto L48;
        DataKind r9 = r8.next();
        String r1 = r9.mimeType;
        if ("vnd.android.cursor.item/name".equals(r1) == true) goto L9;
        ArrayList<ValuesDelta> r10 = r4.getMimeEntries(r1);
        if (r10 == null) goto L6;
        if (r10.isEmpty() == true) goto L6;
        Iterator<ValuesDelta> r11 = r10.iterator();
    L16:
        if (r11.hasNext() == false) goto L6;
        ContentValues r2 = r11.next().getAfter();
        if (r2 == null) goto L16;
        r5.addEntry(ValuesDelta.fromAfter(r2));
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

    private static ArrayList<ValuesDelta> ensureEntryMaxSize(RawContactDelta r2, DataKind r3, ArrayList<ValuesDelta> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r5 = r3.typeOverallMax;
        if (r5 >= 0) goto L8;
        return r4;
    L8:
        if (r4.size() <= r5) goto L16;
        ArrayList<ValuesDelta> r6 = new ArrayList(r5);
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

    public static void migrateStructuredName(Context r16, RawContactDelta r17, RawContactDelta r18, DataKind r19) {
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
        StructuredNameDataItem r11 = NameConverter.parsePhoneticName(r0, null);
        r1.remove("#phoneticName");
        if (r6 == false) goto L37;
        r1.put("data9", r11.getPhoneticFamilyName());
    L38:
        if (r7 == false) goto L40;
        r1.put("data8", r11.getPhoneticMiddleName());
    L41:
        if (r8 == false) goto L43;
        r1.put("data7", r11.getPhoneticGivenName());
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
        r18.addEntry(ValuesDelta.fromAfter(r1));
        return;
    L44:
        if (r5 == false) goto L46;
        r1.put("#phoneticName", NameConverter.buildPhoneticName(r1.getAsString("data9"), r1.getAsString("data8"), r1.getAsString("data7")));
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

    public static void migratePostal(RawContactDelta r23, RawContactDelta r24, DataKind r25) {
        DataKind r1 = r25;
        ArrayList<ValuesDelta> r2 = ensureEntryMaxSize(r24, r1, r23.getMimeEntries("vnd.android.cursor.item/postal-address_v2"));
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isEmpty() == true) goto L78;
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
        Iterator<ValuesDelta> r10 = r2.iterator();
    L26:
        if (r10.hasNext() == false) goto L79;
        ContentValues r11 = r10.next().getAfter();
        if (r11 == null) goto L26;
        Integer r13 = r11.getAsInteger("data2");
        if (r9.contains(r13) == false) goto L33;
    L41:
        String r12 = r11.getAsString("data1");
        if (TextUtils.isEmpty(r12) == true) goto L48;
        if (r6 == true) goto L61;
        r11.remove("data1");
        if (r7 == false) goto L47;
        r11.put("data4", r12);
        goto L61
    L47:
        r11.put(r3, r12);
    L61:
        r10 = r10;
        int r21 = r4;
        boolean r19 = r6;
    L62:
        r24.addEntry(ValuesDelta.fromAfter(r11));
        r10 = r10;
        r1 = r25;
        r3 = r3;
        r9 = r9;
        r6 = r19;
        r4 = r21;
        goto L26
    L48:
        if (r6 == false) goto L61;
        if (Locale.JAPANESE.getLanguage().equals(Locale.getDefault().getLanguage()) == false) goto L52;
        String[] r14 = {r11.getAsString("data10"), r11.getAsString("data9"), r11.getAsString("data8"), r11.getAsString("data7"), r11.getAsString("data6"), r11.getAsString("data4"), r11.getAsString("data5")};
        r21 = 0;
    L53:
        StringBuilder r15 = new StringBuilder();
        int r16 = r14.length;
        int r17 = r21;
    L54:
        if (r17 >= r16) goto L60;
        int r18 = r16;
        String r20 = r14[r17];
        if (TextUtils.isEmpty(r20) == true) goto L59;
        r15.append(r20 + "\n");
    L59:
        r17 = r17 + 1;
        r16 = r18;
        r6 = r6;
        goto L54
    L60:
        r19 = r6;
        r11.put("data1", r15.toString());
        r11.remove("data5");
        r11.remove("data4");
        r11.remove("data6");
        r11.remove("data7");
        r11.remove("data8");
        r11.remove("data9");
        r11.remove("data10");
        goto L62
    L52:
        r21 = 0;
        r14 = new String[]{r11.getAsString("data5"), r11.getAsString("data4"), r11.getAsString("data6"), r11.getAsString("data7"), r11.getAsString("data8"), r11.getAsString("data9"), r11.getAsString("data10")};
        goto L53
    L33:
        if (r1.defaultValues == null) goto L35;
        int r110 = r1.defaultValues.getAsInteger("data2").intValue();
    L36:
        r11.put("data2", Integer.valueOf(r110));
        if (r13 == null) goto L41;
        if (r13.intValue() != 0) goto L41;
        r11.remove("data3");
        goto L41
    L35:
        r110 = r1.typeList.get(r4).rawValue;
        goto L36
    L79:
        return;
    L19:
        if (r1.typeList.isEmpty() == true) goto L24;
        Iterator<AccountType.EditType> r22 = r1.typeList.iterator();
    L22:
        if (r22.hasNext() == false) goto L24;
        r9.add(Integer.valueOf(r22.next().rawValue));
        goto L22
    }

    public static void migrateEvent(RawContactDelta r19, RawContactDelta r20, DataKind r21, Integer r22) {
        ArrayList<ValuesDelta> r2 = ensureEntryMaxSize(r20, r21, r19.getMimeEntries("vnd.android.cursor.item/contact_event"));
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isEmpty() == true) goto L48;
        SparseArray r3 = new SparseArray();
        Iterator<AccountType.EditType> r1 = r21.typeList.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        AccountType.EditType r4 = r1.next();
        r3.put(r4.rawValue, (AccountType.EventEditType) r4);
        goto L9
    L11:
        Iterator<ValuesDelta> r5 = r2.iterator();
        Integer r6 = r22;
    L13:
        if (r5.hasNext() == false) goto L49;
        ContentValues r7 = r5.next().getAfter();
        if (r7 == null) goto L13;
        String r8 = r7.getAsString("data1");
        Integer r9 = r7.getAsInteger("data2");
        if (r9 == null) goto L13;
        if (r3.indexOfKey(r9.intValue()) < 0) goto L13;
        if (TextUtils.isEmpty(r8) == true) goto L13;
        AccountType.EventEditType r10 = (AccountType.EventEditType) r3.get(r9.intValue());
        boolean r11 = false;
        ParsePosition r12 = new ParsePosition(0);
        Date r13 = CommonDateUtils.DATE_AND_TIME_FORMAT.parse(r8, r12);
        if (r13 != null) goto L26;
        r13 = CommonDateUtils.NO_YEAR_DATE_FORMAT.parse(r8, r12);
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
        r14.set(r6.intValue(), r14.get(2), r14.get(5), 8, 0, 0);
        r7.put("data1", CommonDateUtils.FULL_DATE_FORMAT.format(r14.getTime()));
    L34:
        r20.addEntry(ValuesDelta.fromAfter(r7));
        goto L13
    L49:
        return;
    }

    public static void migrateGenericWithoutTypeColumn(RawContactDelta r1, RawContactDelta r2, DataKind r3) {
        ArrayList<ValuesDelta> r4 = ensureEntryMaxSize(r2, r3, r1.getMimeEntries(r3.mimeType));
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L19;
        Iterator<ValuesDelta> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L20;
        ContentValues r6 = r5.next().getAfter();
        if (r6 == null) goto L9;
        r2.addEntry(ValuesDelta.fromAfter(r6));
        goto L9
    L20:
        return;
    }

    public static void migrateGenericWithTypeColumn(RawContactDelta r13, RawContactDelta r14, DataKind r15) {
        ArrayList<ValuesDelta> r16 = r13.getMimeEntries(r15.mimeType);
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
        SparseIntArray r4 = new SparseIntArray();
        if (r0 == null) goto L15;
        r3.add(r0);
        r4.put(r0.intValue(), -1);
    L15:
        if ("vnd.android.cursor.item/im".equals(r15.mimeType) == false) goto L17;
    L26:
        if (r0 != null) goto L28;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Default type isn't available for mimetype " + r15.mimeType);
    L28:
        int r17 = r15.typeOverallMax;
        SparseIntArray r6 = new SparseIntArray();
        Iterator<ValuesDelta> r18 = r16.iterator();
        int r8 = 0;
    L30:
        if (r18.hasNext() == false) goto L70;
        ValuesDelta r9 = r18.next();
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
        if (r11 == null) goto L55;
        int r19 = r4.get(r11.intValue(), 0);
        if (r19 < 0) goto L55;
        int r110 = r6.get(r11.intValue(), 0);
        if (r110 >= r19) goto L30;
        r6.put(r11.intValue(), r110 + 1);
    L55:
        r14.addEntry(ValuesDelta.fromAfter(r10));
        r8 = r8 + 1;
        goto L30
    L70:
        return;
    L17:
        if (r15.typeList == null) goto L26;
        if (r15.typeList.isEmpty() == true) goto L26;
        Iterator<AccountType.EditType> r7 = r15.typeList.iterator();
    L22:
        if (r7.hasNext() == false) goto L24;
        AccountType.EditType r20 = r7.next();
        r3.add(Integer.valueOf(r20.rawValue));
        r4.put(r20.rawValue, r20.specificMax);
        goto L22
    L24:
        if (r0 != null) goto L26;
        r0 = Integer.valueOf(r15.typeList.get(0).rawValue);
        goto L26
    L10:
        r0 = null;
        goto L11
    }
}
