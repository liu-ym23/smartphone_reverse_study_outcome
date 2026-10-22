package com.android.contacts.common.util;

import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UriUtils {
    private UriUtils() {
    }

    public static boolean areEqual(Uri r0, Uri r1) {
        if (r0 != null) goto L6;
        if (r1 != null) goto L6;
        return true;
    L6:
        if (r0 == null) goto L11;
        if (r1 != null) goto L10;
        return false;
    L10:
        return r0.equals(r1);
    L11:
        return false;
    }

    public static Uri parseUriOrNull(String r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return Uri.parse(r0);
    }

    public static String uriToString(Uri r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.toString();
    }

    public static boolean isEncodedContactUri(Uri r1) {
        if (r1 != null) goto L5;
        return false;
    L5:
        String r2 = r1.getLastPathSegment();
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.equals("encoded");
    }

    public static Uri nullForNonContactsUri(Uri r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ("com.android.contacts".equals(r3.getAuthority()) == false) goto L9;
        return r3;
    L9:
        return null;
    }

    public static String getLookupKeyFromUri(Uri r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (isEncodedContactUri(r3) == true) goto L12;
        List<String> r4 = r3.getPathSegments();
        if (r4.size() >= 3) goto L10;
        return null;
    L10:
        return Uri.encode(r4.get(2));
    L12:
        return null;
    }
}
