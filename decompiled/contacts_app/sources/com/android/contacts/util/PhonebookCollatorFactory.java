package com.android.contacts.util;

import java.text.Collator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class PhonebookCollatorFactory {
    public PhonebookCollatorFactory() {
    }

    public static final Collator getCollator() {
        Locale r0 = Locale.getDefault();
        String r1 = r0.toString();
        if ("ja".equals(r1) == false) goto L5;
    L6:
        r0 = new Locale("ja@collation=phonebook");
    L8:
        return Collator.getInstance(r0);
    L5:
        if ("ja_JP".equals(r1) == false) goto L8;
        goto L6
    }
}
