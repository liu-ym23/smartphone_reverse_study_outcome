package com.android.contacts;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.loader.content.CursorLoader;

/* JADX INFO: loaded from: classes.dex */
public final class GroupMetaDataLoader extends CursorLoader {
    public static final int ACCOUNT_NAME = 0;
    public static final int ACCOUNT_TYPE = 1;
    public static final int AUTO_ADD = 5;
    private static final String[] COLUMNS = null;
    public static final int DATA_SET = 2;
    public static final int DELETED = 8;
    public static final int FAVORITES = 6;
    public static final int GROUP_ID = 3;
    public static final int IS_READ_ONLY = 7;
    public static final int TITLE = 4;

    static {
        COLUMNS = new String[]{"account_name", "account_type", "data_set", "_id", "title", "auto_add", "favorites", "group_is_read_only", "deleted"};
    }

    public GroupMetaDataLoader(Context r8, Uri r9) {
        super(r8, ensureIsGroupUri(r9), COLUMNS, "account_type NOT NULL  AND account_name NOT NULL", null, null);
    }

    private static Uri ensureIsGroupUri(Uri r3) {
        if (r3 == null) goto L9;
        if (r3.toString().startsWith(ContactsContract.Groups.CONTENT_URI.toString()) == false) goto L7;
        return r3;
    L7:
        throw new IllegalArgumentException("Invalid group Uri: " + r3);
    L9:
        throw new IllegalArgumentException("Uri must not be null");
    }
}
