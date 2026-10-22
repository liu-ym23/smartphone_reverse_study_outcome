package com.android.contacts.common.model.account;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Objects;

/* JADX INFO: loaded from: classes.dex */
public class AccountTypeWithDataSet {
    private static final String[] ID_PROJECTION = null;
    private static final Uri RAW_CONTACTS_URI_LIMIT_1 = null;
    public final String accountType;
    public final String dataSet;

    static {
        ID_PROJECTION = new String[]{"_id"};
        RAW_CONTACTS_URI_LIMIT_1 = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("limit", "1").build();
    }

    private AccountTypeWithDataSet(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        r3 = null;
    L5:
        this.accountType = r3;
        if (TextUtils.isEmpty(r4) == false) goto L8;
        r4 = null;
    L8:
        this.dataSet = r4;
    }

    public static AccountTypeWithDataSet get(String r1, String r2) {
        return new AccountTypeWithDataSet(r1, r2);
    }

    public boolean hasData(Context r10) {
        if (TextUtils.isEmpty(this.dataSet) == false) goto L5;
        String[] r0 = {this.accountType};
        String r9 = "account_type = ? AND data_set IS NULL";
    L6:
        Cursor r11 = r10.getContentResolver().query(RAW_CONTACTS_URI_LIMIT_1, ID_PROJECTION, r9, r0, null);
        if (r11 != null) goto L15;
        return false;
    L15:
        boolean r12 = r11.moveToFirst();     // Catch: Throwable -> L12
        r11.close();
        return r12;
    L12:
        th = move-exception;
        r11.close();
        throw th;
    L5:
        r0 = new String[]{this.accountType, this.dataSet};
        r9 = "account_type = ? AND data_set = ?";
        goto L6
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof AccountTypeWithDataSet) == true) goto L5;
        return false;
    L5:
        AccountTypeWithDataSet r5 = (AccountTypeWithDataSet) r4;
        if (Objects.equal(this.accountType, r5.accountType) == true) goto L8;
        return false;
    L8:
        if (Objects.equal(this.dataSet, r5.dataSet) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.accountType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        String r3 = this.dataSet;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r2 ^ r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "[" + this.accountType + LibrarianImpl.Constants.SEPARATOR + this.dataSet + "]";
    }
}
