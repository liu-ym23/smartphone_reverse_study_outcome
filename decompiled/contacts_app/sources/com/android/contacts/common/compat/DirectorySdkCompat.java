package com.android.contacts.common.compat;

import android.net.Uri;
import android.provider.ContactsContract;

/* JADX INFO: loaded from: classes.dex */
public class DirectorySdkCompat {
    public static final Uri ENTERPRISE_CONTENT_URI = null;
    public static final long ENTERPRISE_LOCAL_DEFAULT = 1000000000;
    public static final long ENTERPRISE_LOCAL_INVISIBLE = 1000000001;
    private static final String TAG = "DirectorySdkCompat";

    public DirectorySdkCompat() {
    }

    static {
        ENTERPRISE_CONTENT_URI = ContactsContract.Directory.ENTERPRISE_CONTENT_URI;
    }

    public static boolean isRemoteDirectoryId(long r1) {
        if (CompatUtils.isNCompatible() == true) goto L7;
        return false;
    L7:
        return ContactsContract.Directory.isRemoteDirectoryId(r1);
    }

    public static boolean isEnterpriseDirectoryId(long r1) {
        if (CompatUtils.isNCompatible() == true) goto L7;
        return false;
    L7:
        return ContactsContract.Directory.isEnterpriseDirectoryId(r1);
    }
}
