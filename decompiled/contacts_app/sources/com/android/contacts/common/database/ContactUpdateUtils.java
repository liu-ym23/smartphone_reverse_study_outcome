package com.android.contacts.common.database;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public class ContactUpdateUtils {
    private static final String TAG = "ContactUpdateUtils";

    static {
    }

    public ContactUpdateUtils() {
    }

    public static void setSuperPrimary(Context r4, long r5) {
        if (r5 != (-1)) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for setSuperPrimary request");
        return;
    L6:
        ContentValues r0 = new ContentValues(2);
        r0.put("is_super_primary", 1);
        r0.put("is_primary", 1);
        r4.getContentResolver().update(ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r5), r0, null, null);
    }
}
