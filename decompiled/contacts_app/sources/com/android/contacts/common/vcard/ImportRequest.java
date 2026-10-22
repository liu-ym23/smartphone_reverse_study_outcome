package com.android.contacts.common.vcard;

import android.accounts.Account;
import android.net.Uri;
import com.android.contacts.common.model.account.AccountWithDataSet;

/* JADX INFO: loaded from: classes.dex */
public class ImportRequest {
    public final Account account;
    public final byte[] data;
    public final String displayName;
    public final int entryCount;
    public final String estimatedCharset;
    public final int estimatedVCardType;
    public final Uri uri;
    public final int vcardVersion;

    public ImportRequest(AccountWithDataSet r1, byte[] r2, Uri r3, String r4, int r5, String r6, int r7, int r8) {
        if (r1 == null) goto L5;
        Account r9 = r1.getAccountOrNull();
    L6:
        this.account = r9;
        this.data = r2;
        this.uri = r3;
        this.displayName = r4;
        this.estimatedVCardType = r5;
        this.estimatedCharset = r6;
        this.vcardVersion = r7;
        this.entryCount = r8;
        return;
    L5:
        r9 = null;
        goto L6
    }
}
