package com.android.contacts.calllog;

import com.android.contacts.interactions.GroupDeletionDialogFragment;

/* JADX INFO: loaded from: classes.dex */
final class PhoneQuery {
    public static final int LABEL = 3;
    public static final int LOOKUP_KEY = 7;
    public static final int MATCHED_NUMBER = 4;
    public static final int NAME = 1;
    public static final int NORMALIZED_NUMBER = 5;
    public static final int PERSON_ID = 0;
    public static final int PHONE_TYPE = 2;
    public static final int PHOTO_ID = 6;
    public static final int PHOTO_URI = 8;
    public static final String[] _PROJECTION = null;

    PhoneQuery() {
    }

    static {
        _PROJECTION = new String[]{"_id", "display_name", "type", GroupDeletionDialogFragment.ARG_LABEL, "number", "normalized_number", "photo_id", "lookup", "photo_uri"};
    }
}
