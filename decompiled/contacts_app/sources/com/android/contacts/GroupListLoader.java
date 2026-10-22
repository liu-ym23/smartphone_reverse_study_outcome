package com.android.contacts;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;
import android.provider.ContactsContract;

/* JADX INFO: loaded from: classes.dex */
public final class GroupListLoader extends CursorLoader {
    public static final int ACCOUNT_NAME = 0;
    public static final int ACCOUNT_TYPE = 1;
    public static final String[] COLUMNS = null;
    public static final int DATA_SET = 2;
    public static final int GROUP_ID = 3;
    public static final int GROUP_IS_READ_ONLY = 6;
    private static final Uri GROUP_LIST_URI = null;
    public static final int MEMBER_COUNT = 5;
    public static final int TITLE = 4;

    static {
        COLUMNS = new String[]{"account_name", "account_type", "data_set", "_id", "title", "summ_count", "group_is_read_only"};
        GROUP_LIST_URI = ContactsContract.Groups.CONTENT_SUMMARY_URI;
    }

    public GroupListLoader(Context r8) {
        super(r8, GROUP_LIST_URI, COLUMNS, "account_type NOT NULL AND account_name NOT NULL AND auto_add=0 AND favorites=0 AND deleted=0", null, "account_type, account_name, data_set, title COLLATE LOCALIZED ASC");
    }
}
