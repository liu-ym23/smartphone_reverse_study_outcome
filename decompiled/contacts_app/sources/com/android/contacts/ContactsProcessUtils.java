package com.android.contacts;

/* JADX INFO: loaded from: classes.dex */
public final class ContactsProcessUtils {
    private ContactsProcessUtils() {
    }

    public static boolean isMainProcess(String r0, String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.equals(r0) == false) goto L6;
        return true;
    }
}
