package com.android.contacts.speeddial;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.ContactsUtils;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SpeedDialUtils {
    private static final String CONTACT_KEY_PREFIX = "contact_";
    private static final String NUMBER_KEY_PREFIX = "number_";

    public static class SpeedDialRecord {
        long contactId;
        String phoneNumber;

        public SpeedDialRecord(String r1, long r2) {
            this.phoneNumber = r1;
            this.contactId = r2;
        }
    }

    public SpeedDialUtils() {
    }

    public static void saveContact(Context r3, int r4, String r5, long r6) {
        if (r4 >= 2) goto L5;
        return;
    L5:
        if (r4 > 9) goto L10;
        SharedPreferences.Editor r7 = getPrefs(r3).edit();
        String r0 = NUMBER_KEY_PREFIX + r4;
        String r8 = CONTACT_KEY_PREFIX + r4;
        r7.putString(r0, r5);
        r7.putLong(r8, r6);
        r7.commit();
        return;
    }

    public static void saveStranger(Context r3, int r4, String r5) {
        if (r4 >= 2) goto L5;
        return;
    L5:
        if (r4 > 9) goto L10;
        SharedPreferences.Editor r6 = getPrefs(r3).edit();
        String r0 = NUMBER_KEY_PREFIX + r4;
        String r7 = CONTACT_KEY_PREFIX + r4;
        r6.putString(r0, r5);
        r6.remove(r7);
        r6.commit();
        return;
    }

    public static void deleteContactOrStranger(Context r3, int r4) {
        if (r4 >= 2) goto L5;
        return;
    L5:
        if (r4 > 9) goto L10;
        SharedPreferences.Editor r5 = getPrefs(r3).edit();
        String r0 = NUMBER_KEY_PREFIX + r4;
        String r6 = CONTACT_KEY_PREFIX + r4;
        r5.remove(r0);
        r5.remove(r6);
        r5.commit();
        return;
    }

    public static String getPhoneNumber(Context r3, int r4) {
        if (r4 >= 2) goto L5;
    L9:
        return null;
    L5:
        if (r4 > 9) goto L9;
        return getPrefs(r3).getString(NUMBER_KEY_PREFIX + r4, null);
    }

    public static long getContactId(Context r4, int r5) {
        if (r5 >= 2) goto L5;
    L9:
        return -1;
    L5:
        if (r5 > 9) goto L9;
        return getPrefs(r4).getLong(CONTACT_KEY_PREFIX + r5, -1);
    }

    public static void checkValidity(Context r8, int r9) {
        if (r9 >= 2) goto L5;
        return;
    L5:
        if (r9 > 9) goto L30;
        String r0 = getPhoneNumber(r8, r9);
        long r1 = getContactId(r8, r9);
        if (r0 != null) goto L10;
        return;
    L10:
        if (r1 == (-1)) goto L31;
        List<String> r3 = getPhoneNumbersFromContactId(r8, r1);
        if (r3.size() != 0) goto L15;
        saveStranger(r8, r9, r0);
        return;
    L15:
        int r4 = 0;
        String r5 = r3.get(0);
    L17:
        if (r4 >= r3.size()) goto L22;
        if (Objects.equal(ContactsUtils.formatNumber(r3.get(r4)), ContactsUtils.formatNumber(r0)) == true) goto L23;
        r4 = r4 + 1;
    L23:
        saveContact(r8, r9, r0, r1);
        return;
    L22:
        r0 = r5;
        goto L23
    L31:
        return;
    }

    public static long getContactIdFromPhoneNumber(Context r7, String r8) {
        Uri r2 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r8));
        Cursor r9 = null;
        r9 = r7.getContentResolver().query(r2, new String[]{"_id"}, null, null, null);     // Catch: Throwable -> L13
        if (r9 != null) goto L6;
    L9:
        long r0 = -1;
    L10:
        if (r9 == null) goto L12;
        r9.close();
    L12:
        return r0;
    L6:
        if (r9.moveToFirst() == false) goto L9;
        r0 = r9.getLong(0);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r9 == null) goto L16;
        r9.close();
    L16:
        throw th;
    }

    public static List<String> getPhoneNumbersFromContactId(Context r8, long r9) {
        ArrayList r0 = new ArrayList();
        if (r9 == (-1)) goto L27;
        String[] r6 = {String.valueOf(r9), "vnd.android.cursor.item/phone_v2"};
        Cursor r1 = null;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r1 == null) goto L27;
    L23:
        r1.close();
    L18:
        th = move-exception;
        if (r1 == null) goto L26;
        r1.close();
    L26:
        throw th;
    L7:
        if (ContactsContract.isProfileId(r9) == false) goto L9;
        Cursor r10 = r8.getContentResolver().query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), new String[]{"data1"}, "contact_id = ? AND mimetype = ?", r6, null);     // Catch: Throwable -> L18 Exception -> L20
    L10:
        r1 = r10;
        if (r1 != null) goto L13;
    L16:
        if (r1 == null) goto L27;
    L13:
        if (r1.moveToFirst() == false) goto L16;
    L14:
        r0.add(r1.getString(r1.getColumnIndex("data1")));     // Catch: Throwable -> L18 Exception -> L20
        if (r1.moveToNext() == true) goto L14;
    L9:
        r10 = r8.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"data1"}, "contact_id = ? AND mimetype = ?", r6, null);     // Catch: Throwable -> L18 Exception -> L20
    L27:
        return r0;
    }

    private static SharedPreferences getPrefs(Context r2) {
        return r2.getSharedPreferences("speeddial", 0);
    }
}
