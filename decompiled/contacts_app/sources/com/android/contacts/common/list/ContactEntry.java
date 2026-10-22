package com.android.contacts.common.list;

import android.accounts.Account;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class ContactEntry {
    public static final ContactEntry BLANK_ENTRY = null;
    private static final int UNSET_DISPLAY_ORDER_PREFERENCE = -1;
    public Account account;
    public long id;
    public boolean isDefaultNumber;
    public boolean isFavorite;
    public String lookupKey;
    public Uri lookupUri;
    public String nameAlternative;
    public int nameDisplayOrder;
    public String namePrimary;
    public String phoneLabel;
    public String phoneNumber;
    public Uri photoUri;
    public int pinned;
    public Drawable presenceIcon;
    public String status;

    public ContactEntry() {
        this.nameDisplayOrder = -1;
        this.pinned = 0;
        this.isFavorite = false;
        this.isDefaultNumber = false;
    }

    static {
        BLANK_ENTRY = new ContactEntry();
    }

    public String getPreferredDisplayName() {
        int r0 = this.nameDisplayOrder;
        if (r0 == (-1)) goto L12;
        if (r0 == 1) goto L12;
        if (TextUtils.isEmpty(this.nameAlternative) == true) goto L12;
        return this.nameAlternative;
    L12:
        return this.namePrimary;
    }
}
