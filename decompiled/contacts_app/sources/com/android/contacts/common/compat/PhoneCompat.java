package com.android.contacts.common.compat;

import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.common.ContactsUtils;

/* JADX INFO: loaded from: classes.dex */
public class PhoneCompat {
    private static final Uri ENTERPRISE_CONTENT_FILTER_URI = null;

    public PhoneCompat() {
    }

    static {
        ENTERPRISE_CONTENT_FILTER_URI = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, "filter_enterprise");
    }

    public static Uri getContentFilterUri() {
        if (ContactsUtils.FLAG_N_FEATURE == false) goto L7;
        return ENTERPRISE_CONTENT_FILTER_URI;
    L7:
        return ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI;
    }
}
