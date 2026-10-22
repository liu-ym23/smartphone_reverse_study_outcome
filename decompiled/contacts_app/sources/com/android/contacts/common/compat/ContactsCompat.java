package com.android.contacts.common.compat;

import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.common.ContactsUtils;

/* JADX INFO: loaded from: classes.dex */
public class ContactsCompat {
    private static final long ENTERPRISE_CONTACT_ID_BASE = 1000000000;
    private static final Uri ENTERPRISE_CONTENT_FILTER_URI = null;

    private ContactsCompat() {
    }

    static {
        ENTERPRISE_CONTENT_FILTER_URI = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, "filter_enterprise");
    }

    public static Uri getContentUri() {
        if (ContactsUtils.FLAG_N_FEATURE == false) goto L7;
        return ENTERPRISE_CONTENT_FILTER_URI;
    L7:
        return ContactsContract.Contacts.CONTENT_FILTER_URI;
    }

    public static boolean isEnterpriseContactId(long r2) {
        if (CompatUtils.isLollipopCompatible() == false) goto L7;
        return ContactsContract.Contacts.isEnterpriseContactId(r2);
    L7:
        if (r2 >= 1000000000) goto L9;
    L11:
        return false;
    L9:
        if (r2 >= 9223372034707292160L) goto L11;
        return true;
    }
}
