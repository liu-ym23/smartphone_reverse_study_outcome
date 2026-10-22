package com.android.contacts.calllog;

import android.net.Uri;
import android.text.TextUtils;
import com.android.contacts.util.UriUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ContactInfo {
    public static ContactInfo EMPTY;
    public long date;
    public String formattedNumber;
    public boolean hasMarked;
    public String label;
    public String location;
    public Uri lookupUri;
    public String name;
    public String normalizedNumber;
    public String number;
    public int numberMainMarkClassify;
    public long photoId;
    public Uri photoUri;
    public int presentation;
    public int type;

    public ContactInfo() {
        this.type = 0;
        this.numberMainMarkClassify = 0;
    }

    static {
        EMPTY = new ContactInfo();
    }

    public int hashCode() {
        Uri r0 = this.lookupUri;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r2 + 31) * 31;
        String r4 = this.name;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L9;
        return false;
    L9:
        if (getClass() == r7.getClass()) goto L11;
        return false;
    L11:
        ContactInfo r8 = (ContactInfo) r7;
        if (UriUtils.areEqual(this.lookupUri, r8.lookupUri) == true) goto L15;
        return false;
    L15:
        if (TextUtils.equals(this.name, r8.name) == true) goto L18;
        return false;
    L18:
        if (this.type == r8.type) goto L21;
        return false;
    L21:
        if (TextUtils.equals(this.label, r8.label) == true) goto L24;
        return false;
    L24:
        if (TextUtils.equals(this.number, r8.number) == true) goto L27;
        return false;
    L27:
        if (TextUtils.equals(this.formattedNumber, r8.formattedNumber) == true) goto L30;
        return false;
    L30:
        if (TextUtils.equals(this.normalizedNumber, r8.normalizedNumber) == true) goto L33;
        return false;
    L33:
        if (this.photoId == r8.photoId) goto L36;
        return false;
    L36:
        if (UriUtils.areEqual(this.photoUri, r8.photoUri) == true) goto L39;
        return false;
    L39:
        if (this.hasMarked == r8.hasMarked) goto L42;
        return false;
    L42:
        if (TextUtils.equals(this.location, r8.location) == true) goto L44;
        return false;
    L44:
        return true;
    }
}
