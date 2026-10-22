package com.android.contacts.util;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
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
}
