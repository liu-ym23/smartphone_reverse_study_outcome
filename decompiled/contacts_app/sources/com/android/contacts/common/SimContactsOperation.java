package com.android.contacts.common;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.group.GroupSelectionActivity;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class SimContactsOperation {
    private static final int CONTACT_COLUMN_ACCOUNT_NAME = 2;
    private static final int CONTACT_COLUMN_ACCOUNT_TYPE = 3;
    private static final int CONTACT_COLUMN_CONTACT_ID = 1;
    private static final int CONTACT_COLUMN_DATA = 4;
    private static final int CONTACT_COLUMN_DATA_MIMETYPE = 6;
    private static final int CONTACT_COLUMN_DATA_TYPE = 5;
    private static final int CONTACT_COLUMN_RAW_ID = 0;
    public static final String[] CONTACT_PROJECTION = null;
    private static final boolean DBG = true;
    private static final int DELETE_TOKEN = 3;
    private static final int INSERT_TOKEN = 1;
    private static final int QUERY_TOKEN = 0;
    private static final String TAG = "SimContactsOperation";
    private static final int UPDATE_TOKEN = 2;
    private static Context mContext;
    private ContentResolver mResolver;
    private ContentValues mValues;

    static {
        CONTACT_PROJECTION = new String[]{GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "contact_id", "account_name", "account_type", "data1", DBHelper.COL_DATA2, "mimetype"};
    }

    public SimContactsOperation(Context r2) {
        this.mValues = new ContentValues();
        Context r3 = r2.getApplicationContext();
        mContext = r3;
        this.mResolver = r3.getContentResolver();
    }

    public Uri insert(ContentValues r7, int r8) {
        Uri r9 = getContentUri(r8);
        if (r9 != null) goto L6;
        return null;
    L6:
        String r1 = r7.getAsString("number");
        String r3 = r7.getAsString(SimContactsConstants.STR_ANRS);
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r3 = r3.replaceAll("[^0123456789PWN\\,\\;\\*\\#\\+\\:]", "");
    L9:
        String r5 = r7.getAsString(SimContactsConstants.STR_EMAILS);
        r7.put("number", PhoneNumberUtils.stripSeparators(r1));
        r7.put(SimContactsConstants.STR_ANRS, r3);
        r7.put(SimContactsConstants.STR_EMAILS, r5);
        return this.mResolver.insert(r9, r7);
    }

    public int update(ContentValues r9, int r10) {
        Uri r11 = getContentUri(r10);
        if (r11 != null) goto L6;
        return 0;
    L6:
        String r1 = r9.getAsString("number");
        String r3 = r9.getAsString(SimContactsConstants.STR_NEW_NUMBER);
        String r5 = r9.getAsString(SimContactsConstants.STR_ANRS);
        String r7 = r9.getAsString(SimContactsConstants.STR_NEW_ANRS);
        r9.put("number", PhoneNumberUtils.stripSeparators(r1));
        r9.put(SimContactsConstants.STR_NEW_NUMBER, PhoneNumberUtils.stripSeparators(r3));
        if (TextUtils.isEmpty(r5) == true) goto L10;
        r5 = r5.replaceAll("[^0123456789PWN\\,\\;\\*\\#\\+\\:]", "");
    L10:
        if (TextUtils.isEmpty(r7) == true) goto L12;
        r7 = r7.replaceAll("[^0123456789PWN\\,\\;\\*\\#\\+\\:]", "");
    L12:
        r9.put(SimContactsConstants.STR_ANRS, r5);
        r9.put(SimContactsConstants.STR_NEW_ANRS, r7);
        return this.mResolver.update(r11, r9, null, null);
    }

    public int delete(ContentValues r8, int r9) {
        Uri r10 = getContentUri(r9);
        if (r10 != null) goto L6;
        return 0;
    L6:
        StringBuilder r0 = new StringBuilder();
        String r1 = r8.getAsString(SimContactsConstants.STR_TAG);
        String r2 = r8.getAsString("number");
        String r3 = r8.getAsString(SimContactsConstants.STR_EMAILS);
        String r11 = r8.getAsString(SimContactsConstants.STR_ANRS);
        if (r2 == null) goto L9;
        String r4 = PhoneNumberUtils.stripSeparators(r2);
    L10:
        if (r11 == null) goto L13;
        r11 = r11.replaceAll("[^0123456789PWN\\,\\;\\*\\#\\+\\:]", "");
    L13:
        if (TextUtils.isEmpty(r1) == true) goto L16;
        r0.append("tag='");
        r0.append(r1);
        r0.append("'");
    L16:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        r0.append(" AND number='");
        r0.append(r4);
        r0.append("'");
    L19:
        if (TextUtils.isEmpty(r3) == true) goto L22;
        r0.append(" AND emails='");
        r0.append(r3);
        r0.append("'");
    L22:
        if (TextUtils.isEmpty(r11) == true) goto L25;
        r0.append(" AND anrs='");
        r0.append(r11);
        r0.append("'");
    L25:
        return this.mResolver.delete(r10, r0.toString(), null);
    L9:
        r4 = null;
        goto L10
    }

    private Uri getContentUri(int r3) {
        SubscriptionInfo r2 = SubscriptionManager.from(mContext).getActiveSubscriptionInfoForSimSlotIndex(r3);     // Catch: SecurityException -> L5
    L7:
        if (r2 != null) goto L9;
        return null;
    L9:
        return Uri.parse(SimContactsConstants.SIM_SUB_URI + r2.getSubscriptionId());
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SecurityException thrown, lack permission for getActiveSubscriptionInfoList", e);
        r2 = null;
        goto L7
    }

    private static Cursor setupContactCursor(long r8) {
        if (r8 > 0) goto L5;
        return null;
    L5:
        ContentResolver r2 = mContext.getContentResolver();
        Uri r3 = Uri.withAppendedPath(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, r8), "entities");
        Cursor r9 = r2.query(r3, CONTACT_PROJECTION, null, null, null);     // Catch: Exception -> L14 Throwable -> L17
        if (r9 != null) goto L9;
    L11:
        if (r9 == null) goto L13;
        r9.close();
    L13:
        return null;
    L9:
        if (r9.moveToFirst() == false) goto L11;
        return r9;
    L14:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, e.getMessage());     // Catch: Throwable -> L17
    L16:
        return null;
    }

    public static ContentValues getSimAccountValues(long r10) {
        ContentValues r1 = new ContentValues();
        Cursor r11 = setupContactCursor(r10);
        StringBuilder r12 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();
        if (r11 != null) goto L54;
        r1.clear();
        return r1;
    L54:
    L46:
        th = move-exception;
        r11.close();
        throw th;
    L48:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));     // Catch: Throwable -> L46
    L50:
        r11.close();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getSimAccountValue: " + r1.toString());
        return r1;
    L8:
        if (r11.getCount() != 0) goto L10;
    L43:
        r11.close();     // Catch: Throwable -> L46 Exception -> L48
        r11.close();
        return r1;
    L10:
        if (r11.moveToFirst() == false) goto L43;
    L12:
        String r4 = r11.getString(3);     // Catch: Throwable -> L46 Exception -> L48
        String r5 = r11.getString(2);     // Catch: Throwable -> L46 Exception -> L48
        String r6 = r11.getString(6);     // Catch: Throwable -> L46 Exception -> L48
        String r7 = r11.getString(4);     // Catch: Throwable -> L46 Exception -> L48
        String r8 = r11.getString(5);     // Catch: Throwable -> L46 Exception -> L48
        r1.put("account_type", r4);     // Catch: Throwable -> L46 Exception -> L48
        r1.put("account_name", r5);     // Catch: Throwable -> L46 Exception -> L48
        if (TextUtils.isEmpty(r7) == false) goto L16;
    L36:
        if (r11.moveToNext() == true) goto L12;
        if (TextUtils.isEmpty(r12.toString()) == true) goto L41;
        r1.put(SimContactsConstants.STR_ANRS, r12.toString());     // Catch: Throwable -> L46 Exception -> L48
    L41:
        if (TextUtils.isEmpty(r2.toString()) == true) goto L50;
        r1.put(SimContactsConstants.STR_EMAILS, r2.toString());     // Catch: Throwable -> L46 Exception -> L48
        goto L50
    L16:
        if ("com.android.sim".equals(r4) == false) goto L36;
        if (r6.equals("vnd.android.cursor.item/name") == false) goto L21;
        r1.put(SimContactsConstants.STR_TAG, r7);     // Catch: Throwable -> L46 Exception -> L48
        goto L36
    L21:
        if (r6.equals("vnd.android.cursor.item/phone_v2") == false) goto L30;
        if (Integer.parseInt(r8) != 2) goto L26;
        r1.put("number", r7);     // Catch: Throwable -> L46 Exception -> L48
        goto L36
    L26:
        if (TextUtils.isEmpty(r12.toString()) == true) goto L28;
        r12.append(SimContactsConstants.ANR_SEP);     // Catch: Throwable -> L46 Exception -> L48
    L28:
        r12.append(r7);     // Catch: Throwable -> L46 Exception -> L48
        goto L36
    L30:
        if (r6.equals("vnd.android.cursor.item/email_v2") == false) goto L36;
        if (TextUtils.isEmpty(r2.toString()) == true) goto L34;
        r2.append(SimContactsConstants.EMAIL_SEP);     // Catch: Throwable -> L46 Exception -> L48
    L34:
        r2.append(r7);     // Catch: Throwable -> L46 Exception -> L48
        goto L36
    }

    public static int getSimSubscription(long r3) {
        Cursor r4 = setupContactCursor(r3);
        int r5 = -1;
        if (r4 != null) goto L5;
    L18:
        if (r4 == null) goto L20;
        r4.close();
    L20:
        return -1;
    L5:
        if (r4.getCount() == 0) goto L18;
        String r0 = r4.getString(r4.getColumnIndex("account_name"));
        String r1 = r4.getString(r4.getColumnIndex("account_type"));
        if (r1 == null) goto L16;
        if (r0 == null) goto L16;
        if ("com.android.sim".equals(r1) == false) goto L14;
        r5 = MoreContactUtils.getSubscription(r1, r0);
    L14:
        r4.close();
        return r5;
    L16:
        r4.close();
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.database.Cursor] */
    private static String getContactItems(long r8, String r10, String r11) {
        StringBuilder r0 = new StringBuilder();
        ?? r9 = "data";
        Cursor r12 = mContext.getContentResolver().query(Uri.withAppendedPath(ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r8), "data"), null, "mimetype=?", new String[]{r10}, null);     // Catch: Throwable -> L26 Exception -> L28
        if (r12 != null) goto L39;
    L21:
        if (r12 == null) goto L23;
        r12.close();     // Catch: Exception -> L19 Throwable -> L35
    L23:
        if (r12 == null) goto L25;
        r12.close();
    L25:
        return null;
    L39:
    L19:
        Exception e = e;
    L30:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, e.getMessage());     // Catch: Throwable -> L35
        if (r12 == null) goto L34;
    L32:
        r12.close();
    L34:
        return r0.toString();
    L6:
        if (r12.getCount() == 0) goto L21;
        r12.moveToPosition(-1);     // Catch: Exception -> L19 Throwable -> L35
    L10:
        if (r12.moveToNext() == false) goto L17;
        if (TextUtils.isEmpty(r0.toString()) == true) goto L14;
        r0.append(SimContactsConstants.EMAIL_SEP);     // Catch: Exception -> L19 Throwable -> L35
    L14:
        String r13 = r12.getString(r12.getColumnIndex(r11));     // Catch: Exception -> L19 Throwable -> L35
        if (TextUtils.isEmpty(r13) == true) goto L10;
        r0.append(r13);     // Catch: Exception -> L19 Throwable -> L35
        goto L10
    L17:
        if (r12 == null) goto L34;
    L35:
        Throwable th = th;
    L36:
        if (r9 == 0) goto L38;
        r9.close();
    L38:
        throw th;
    L28:
        e = move-exception;
        r12 = null;
        e = e;
    L26:
        th = move-exception;
        r9 = 0;
        th = th;
        goto L36
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.database.Cursor] */
    private static String getContactPhoneNumber(long r8, String r10, String r11, String r12) {
        StringBuilder r0 = new StringBuilder();
        ?? r9 = "data";
        Cursor r13 = mContext.getContentResolver().query(Uri.withAppendedPath(ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r8), "data"), null, "mimetype=? AND data2=?", new String[]{r10, r11}, null);     // Catch: Throwable -> L24 Exception -> L26
        if (r13 != null) goto L38;
    L19:
        if (r13 == null) goto L21;
        r13.close();     // Catch: Exception -> L17 Throwable -> L33
    L21:
        if (r13 == null) goto L23;
        r13.close();
    L23:
        return null;
    L38:
    L17:
        Exception e = e;
    L28:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, e.getMessage());     // Catch: Throwable -> L33
        if (r13 == null) goto L32;
    L30:
        r13.close();
    L32:
        return r0.toString();
    L6:
        if (r13.getCount() == 0) goto L19;
        r13.moveToPosition(-1);     // Catch: Exception -> L17 Throwable -> L33
    L10:
        if (r13.moveToNext() == false) goto L15;
        if (TextUtils.isEmpty(r0.toString()) == true) goto L14;
        r0.append(SimContactsConstants.ANR_SEP);     // Catch: Exception -> L17 Throwable -> L33
    L14:
        r0.append(r13.getString(r13.getColumnIndex(r12)));     // Catch: Exception -> L17 Throwable -> L33
        goto L10
    L15:
        if (r13 == null) goto L32;
    L33:
        Throwable th = th;
    L34:
        if (r9 == 0) goto L36;
        r9.close();
    L36:
        throw th;
    L26:
        e = move-exception;
        r13 = null;
        e = e;
    L24:
        th = move-exception;
        r9 = 0;
        th = th;
        goto L34
    }
}
