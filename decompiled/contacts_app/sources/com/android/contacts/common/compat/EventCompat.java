package com.android.contacts.common.compat;

import android.content.res.Resources;
import android.provider.ContactsContract;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class EventCompat {
    private EventCompat() {
    }

    public static CharSequence getTypeLabel(Resources r1, int r2, CharSequence r3) {
        if (CompatUtils.isLollipopCompatible() == false) goto L7;
        return ContactsContract.CommonDataKinds.Event.getTypeLabel(r1, r2, r3);
    L7:
        return getTypeLabelInternal(r1, r2, r3);
    }

    private static CharSequence getTypeLabelInternal(Resources r1, int r2, CharSequence r3) {
        if (r2 != 0) goto L7;
        if (TextUtils.isEmpty(r3) == true) goto L7;
        return r3;
    L7:
        return r1.getText(ContactsContract.CommonDataKinds.Event.getTypeResource(Integer.valueOf(r2)));
    }
}
