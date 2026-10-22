package com.android.contacts.vcard;

import android.accounts.Account;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class ImportRequest {
    public final Account account;
    public final byte[] data;
    public final String displayName;
    public final int entryCount;
    public final String estimatedCharset;
    public final int estimatedVCardType;
    public final Uri uri;
    public final int vcardVersion;

    public ImportRequest(Account r1, byte[] r2, Uri r3, String r4, int r5, String r6, int r7, int r8) {
        this.account = r1;
        this.data = r2;
        this.uri = r3;
        this.displayName = r4;
        this.estimatedVCardType = r5;
        this.estimatedCharset = r6;
        this.vcardVersion = r7;
        this.entryCount = r8;
    }
}
