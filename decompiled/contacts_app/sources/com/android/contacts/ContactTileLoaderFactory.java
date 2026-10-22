package com.android.contacts;

import android.content.Context;
import android.content.CursorLoader;
import android.provider.ContactsContract;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public final class ContactTileLoaderFactory {
    private static final String[] COLUMNS = null;
    private static final String[] COLUMNS_PHONE_ONLY = null;
    public static final int CONTACT_ID = 0;
    public static final int CONTACT_PRESENCE = 5;
    public static final int CONTACT_STATUS = 6;
    public static final int DISPLAY_NAME = 1;
    public static final int LOOKUP_KEY = 4;
    public static final int PHONE_NUMBER = 5;
    public static final int PHONE_NUMBER_LABEL = 7;
    public static final int PHONE_NUMBER_TYPE = 6;
    public static final int PHOTO_URI = 3;
    public static final int STARRED = 2;

    public ContactTileLoaderFactory() {
    }

    static {
        COLUMNS = new String[]{"_id", "display_name", ContactSaveService.EXTRA_STARRED_FLAG, "photo_uri", "lookup", "contact_presence", "contact_status"};
        COLUMNS_PHONE_ONLY = new String[]{"_id", "display_name", ContactSaveService.EXTRA_STARRED_FLAG, "photo_uri", "lookup", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3};
    }

    public static CursorLoader createStrequentLoader(Context r8) {
        return new CursorLoader(r8, ContactsContract.Contacts.CONTENT_STREQUENT_URI, COLUMNS, null, null, null);
    }

    public static CursorLoader createStrequentPhoneOnlyLoader(Context r8) {
        return new CursorLoader(r8, ContactsContract.Contacts.CONTENT_STREQUENT_URI.buildUpon().appendQueryParameter("strequent_phone_only", "true").build(), COLUMNS_PHONE_ONLY, null, null, null);
    }

    public static CursorLoader createStarredLoader(Context r8) {
        return new CursorLoader(r8, ContactsContract.Contacts.CONTENT_URI, COLUMNS, "starred=?", new String[]{"1"}, "display_name ASC");
    }

    public static CursorLoader createFrequentLoader(Context r8) {
        return new CursorLoader(r8, ContactsContract.Contacts.CONTENT_FREQUENT_URI, COLUMNS, "starred=?", new String[]{"0"}, null);
    }
}
