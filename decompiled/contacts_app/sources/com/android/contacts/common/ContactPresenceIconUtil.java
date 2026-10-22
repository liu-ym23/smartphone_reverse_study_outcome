package com.android.contacts.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;

/* JADX INFO: loaded from: classes.dex */
public class ContactPresenceIconUtil {
    public ContactPresenceIconUtil() {
    }

    public static Drawable getPresenceIcon(Context r1, int r2) {
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L15;
        if (r2 == 4) goto L15;
        if (r2 == 5) goto L15;
        return null;
    L15:
        return r1.getResources().getDrawable(ContactsContract.StatusUpdates.getPresenceIconResourceId(r2));
    }
}
