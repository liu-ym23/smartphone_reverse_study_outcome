package com.android.contacts.common.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.common.model.dataitem.StructuredNameDataItem;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class NameConverter {
    public static final String[] STRUCTURED_NAME_FIELDS = null;

    public NameConverter() {
    }

    static {
        STRUCTURED_NAME_FIELDS = new String[]{"data4", DBHelper.COL_DATA2, "data5", DBHelper.COL_DATA3, "data6"};
    }

    public static String structuredNameToDisplayName(Context r6, Map<String, String> r7) {
        Uri.Builder r0 = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("complete_name");
        String[] r1 = STRUCTURED_NAME_FIELDS;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        String r4 = r1[r3];
        if (r7.containsKey(r4) == false) goto L7;
        appendQueryParameter(r0, r4, r7.get(r4));
    L7:
        r3 = r3 + 1;
        goto L3
    L9:
        return fetchDisplayName(r6, r0.build());
    }

    public static String structuredNameToDisplayName(Context r6, ContentValues r7) {
        Uri.Builder r0 = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("complete_name");
        String[] r1 = STRUCTURED_NAME_FIELDS;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        String r4 = r1[r3];
        if (r7.containsKey(r4) == false) goto L7;
        appendQueryParameter(r0, r4, r7.getAsString(r4));
    L7:
        r3 = r3 + 1;
        goto L3
    L9:
        return fetchDisplayName(r6, r0.build());
    }

    private static String fetchDisplayName(Context r6, Uri r7) {
        Cursor r8 = r6.getContentResolver().query(r7, new String[]{"data1"}, null, null, null);
        String r9 = null;
        if (r8 != null) goto L12;
    L11:
        return r9;
    L12:
    L8:
        th = move-exception;
        r8.close();
        throw th;
    L5:
        if (r8.moveToFirst() == false) goto L7;
        r9 = r8.getString(0);     // Catch: Throwable -> L8
    L7:
        r8.close();
        goto L11
    }

    public static Map<String, String> displayNameToStructuredName(Context r9, String r10) {
        TreeMap r0 = new TreeMap();
        Uri.Builder r1 = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("complete_name");
        appendQueryParameter(r1, "data1", r10);
        Cursor r11 = r9.getContentResolver().query(r1.build(), STRUCTURED_NAME_FIELDS, null, null, null);
        if (r11 != null) goto L16;
    L15:
        return r0;
    L16:
    L12:
        th = move-exception;
        r11.close();
        throw th;
    L5:
        if (r11.moveToFirst() == false) goto L11;
        int r12 = 0;
    L7:
        String[] r2 = STRUCTURED_NAME_FIELDS;     // Catch: Throwable -> L12
        if (r12 >= r2.length) goto L11;
        r0.put(r2[r12], r11.getString(r12));     // Catch: Throwable -> L12
        r12 = r12 + 1;
    L11:
        r11.close();
        goto L15
    }

    public static ContentValues displayNameToStructuredName(Context r2, String r3, ContentValues r4) {
        if (r4 != null) goto L4;
        r4 = new ContentValues();
    L4:
        Map<String, String> r5 = displayNameToStructuredName(r2, r3);
        Iterator<String> r6 = r5.keySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        String r0 = r6.next();
        r4.put(r0, r5.get(r0));
        goto L6
    L8:
        return r4;
    }

    private static void appendQueryParameter(Uri.Builder r1, String r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r1.appendQueryParameter(r2, r3);
        return;
    }

    public static StructuredNameDataItem parsePhoneticName(String r7, StructuredNameDataItem r8) {
        String r1 = null;
        if (TextUtils.isEmpty(r7) == true) goto L13;
        String[] r9 = r7.split(HanziToPinyin.Token.SEPARATOR, 3);
        int r0 = r9.length;
        if (r0 != 1) goto L7;
        String r2 = null;
        r1 = r9[0];
        String r10 = null;
    L14:
        if (r8 != null) goto L16;
        r8 = new StructuredNameDataItem();
    L16:
        r8.setPhoneticFamilyName(r1);
        r8.setPhoneticMiddleName(r2);
        r8.setPhoneticGivenName(r10);
        return r8;
    L7:
        if (r0 == 2) goto L11;
        if (r0 != 3) goto L13;
        r1 = r9[0];
        r2 = r9[1];
        r10 = r9[2];
        goto L14
    L11:
        String r3 = r9[0];
        r10 = r9[1];
        r1 = r3;
        r2 = null;
    L13:
        r10 = null;
        r2 = null;
        goto L14
    }

    public static String buildPhoneticName(String r3, String r4, String r5) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
    L11:
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(r3) == true) goto L15;
        r0.append(r3.trim()).append(' ');
    L15:
        if (TextUtils.isEmpty(r4) == true) goto L18;
        r0.append(r4.trim()).append(' ');
    L18:
        if (TextUtils.isEmpty(r5) == true) goto L20;
        r0.append(r5.trim()).append(' ');
    L20:
        r0.setLength(r0.length() - 1);
        return r0.toString();
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L11;
        if (TextUtils.isEmpty(r5) == false) goto L11;
        return null;
    }
}
