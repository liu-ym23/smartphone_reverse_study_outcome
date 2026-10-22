package com.android.contacts.common.compat;

import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.common.ContactsUtils;

/* JADX INFO: loaded from: classes.dex */
public class DirectoryCompat {
    public DirectoryCompat() {
    }

    public static Uri getContentUri() {
        if (ContactsUtils.FLAG_N_FEATURE == false) goto L7;
        return DirectorySdkCompat.ENTERPRISE_CONTENT_URI;
    L7:
        return ContactsContract.Directory.CONTENT_URI;
    }

    public static boolean isInvisibleDirectory(long r5) {
        if (ContactsUtils.FLAG_N_FEATURE == false) goto L12;
        if (r5 != 1) goto L7;
        return true;
    L7:
        if (r5 != DirectorySdkCompat.ENTERPRISE_LOCAL_INVISIBLE) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (r5 != 1) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isRemoteDirectoryId(long r2) {
        if (ContactsUtils.FLAG_N_FEATURE == false) goto L7;
        return DirectorySdkCompat.isRemoteDirectoryId(r2);
    L7:
        if (r2 != 0) goto L9;
    L11:
        return false;
    L9:
        if (r2 == 1) goto L11;
        return true;
    }

    public static boolean isEnterpriseDirectoryId(long r1) {
        if (ContactsUtils.FLAG_N_FEATURE == true) goto L7;
        return false;
    L7:
        return DirectorySdkCompat.isEnterpriseDirectoryId(r1);
    }
}
