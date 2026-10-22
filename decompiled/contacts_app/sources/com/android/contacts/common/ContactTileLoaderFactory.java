package com.android.contacts.common;

import android.content.Context;
import android.content.CursorLoader;
import android.provider.ContactsContract;
import com.android.contacts.ContactSaveService;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public final class ContactTileLoaderFactory {
    public static final int ACCOUNT_NAME = 6;
    public static final int ACCOUNT_TYPE = 5;
    private static final String[] COLUMNS = null;
    public static final String[] COLUMNS_PHONE_ONLY = null;
    public static final int CONTACT_ID = 0;
    public static final int CONTACT_ID_FOR_DATA = 12;
    public static final int CONTACT_PRESENCE = 7;
    public static final int CONTACT_STATUS = 8;
    public static final int DISPLAY_NAME = 1;
    public static final int DISPLAY_NAME_ALTERNATIVE = 13;
    public static final int IS_DEFAULT_NUMBER = 10;
    public static final int LOOKUP_KEY = 4;
    public static final int PHONE_NUMBER = 7;
    public static final int PHONE_NUMBER_LABEL = 9;
    public static final int PHONE_NUMBER_TYPE = 8;
    public static final int PHOTO_URI = 3;
    public static final int PINNED = 11;
    public static final int STARRED = 2;
    private static final String STARRED_ORDER = "display_name COLLATE NOCASE ASC";

    public ContactTileLoaderFactory() {
    }

    static {
        COLUMNS = new String[]{"_id", "display_name", ContactSaveService.EXTRA_STARRED_FLAG, "photo_uri", "lookup", "account_type", "account_name", "contact_presence", "contact_status"};
        COLUMNS_PHONE_ONLY = new String[]{"_id", "display_name", ContactSaveService.EXTRA_STARRED_FLAG, "photo_uri", "lookup", "account_type", "account_name", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "is_super_primary", "pinned", "contact_id", "display_name_alt"};
    }

    public static CursorLoader createStrequentLoader(Context r8) {
        return new CursorLoader(r8, ContactsContract.Contacts.CONTENT_STREQUENT_URI, COLUMNS, null, null, STARRED_ORDER);
    }

    public static CursorLoader createStrequentPhoneOnlyLoader(Context r8) {
        return new CursorLoader(r8, ContactsContract.Contacts.CONTENT_STREQUENT_URI.buildUpon().appendQueryParameter("strequent_phone_only", "true").build(), COLUMNS_PHONE_ONLY, null, null, null);
    }

    public static CursorLoader createStarredLoader(Context r8) {
        return new CursorLoader(r8, ContactsContract.Contacts.CONTENT_URI, COLUMNS, "starred=?", new String[]{"1"}, STARRED_ORDER);
    }

    public static CursorLoader createFrequentLoader(Context r8) {
        return new CursorLoader(r8, ContactsContract.Contacts.CONTENT_FREQUENT_URI, COLUMNS, "starred=?", new String[]{"0"}, null);
    }
}
