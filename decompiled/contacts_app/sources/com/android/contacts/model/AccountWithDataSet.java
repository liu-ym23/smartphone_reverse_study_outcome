package com.android.contacts.model;

import android.accounts.Account;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class AccountWithDataSet extends Account {
    private static final String ARRAY_STRINGIFY_SEPARATOR = "\u0002";
    private static final Pattern ARRAY_STRINGIFY_SEPARATOR_PAT = null;
    public static final Parcelable.Creator<AccountWithDataSet> CREATOR = null;
    private static final String[] ID_PROJECTION = null;
    private static final Uri RAW_CONTACTS_URI_LIMIT_1 = null;
    private static final String STRINGIFY_SEPARATOR = "\u0001";
    private static final Pattern STRINGIFY_SEPARATOR_PAT = null;
    public final String dataSet;
    private final AccountTypeWithDataSet mAccountTypeWithDataSet;

    static {
        STRINGIFY_SEPARATOR_PAT = Pattern.compile(Pattern.quote(STRINGIFY_SEPARATOR));
        ARRAY_STRINGIFY_SEPARATOR_PAT = Pattern.compile(Pattern.quote(ARRAY_STRINGIFY_SEPARATOR));
        ID_PROJECTION = new String[]{"_id"};
        RAW_CONTACTS_URI_LIMIT_1 = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("limit", "1").build();
        CREATOR = new AnonymousClass1();
    }

    public AccountWithDataSet(String r1, String r2, String r3) {
        super(r1, r2);
        this.dataSet = r3;
        this.mAccountTypeWithDataSet = AccountTypeWithDataSet.get(r2, r3);
    }

    public AccountWithDataSet(Parcel r2) {
        super(r2);
        String r3 = r2.readString();
        this.dataSet = r3;
        this.mAccountTypeWithDataSet = AccountTypeWithDataSet.get(this.type, r3);
    }

    @Override // android.accounts.Account, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeString(this.dataSet);
    }

    public AccountTypeWithDataSet getAccountTypeWithDataSet() {
        return this.mAccountTypeWithDataSet;
    }

    public boolean hasData(Context r11) {
        if (TextUtils.isEmpty(this.dataSet) == false) goto L5;
        String[] r0 = {this.type, this.name};
        String r10 = "account_type = ? AND account_name = ? AND data_set IS NULL";
    L6:
        Cursor r12 = r11.getContentResolver().query(RAW_CONTACTS_URI_LIMIT_1, ID_PROJECTION, r10, r0, null);
        if (r12 != null) goto L15;
        return false;
    L15:
        boolean r13 = r12.moveToFirst();     // Catch: Throwable -> L12
        r12.close();
        return r13;
    L12:
        th = move-exception;
        r12.close();
        throw th;
    L5:
        r0 = new String[]{this.type, this.name, this.dataSet};
        r10 = "account_type = ? AND account_name = ? AND data_set = ?";
        goto L6
    }

    @Override // android.accounts.Account
    public boolean equals(Object r2) {
        if ((r2 instanceof AccountWithDataSet) == true) goto L5;
    L9:
        return false;
    L5:
        if (super.equals(r2) == false) goto L9;
        if (Objects.equal(((AccountWithDataSet) r2).dataSet, this.dataSet) == false) goto L9;
        return true;
    }

    @Override // android.accounts.Account
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        String r1 = this.dataSet;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    @Override // android.accounts.Account
    public String toString() {
        return "AccountWithDataSet {name=" + this.name + ", type=" + this.type + ", dataSet=" + this.dataSet + "}";
    }

    private static StringBuilder addStringified(StringBuilder r2, AccountWithDataSet r3) {
        r2.append(r3.name);
        r2.append(STRINGIFY_SEPARATOR);
        r2.append(r3.type);
        r2.append(STRINGIFY_SEPARATOR);
        if (TextUtils.isEmpty(r3.dataSet) == true) goto L5;
        r2.append(r3.dataSet);
    L5:
        return r2;
    }

    public String stringify() {
        return addStringified(new StringBuilder(), this).toString();
    }

    public static AccountWithDataSet unstringify(String r5) {
        String[] r0 = STRINGIFY_SEPARATOR_PAT.split(r5, 3);
        if (r0.length < 3) goto L11;
        String r1 = r0[0];
        String r2 = r0[1];
        if (TextUtils.isEmpty(r0[2]) == false) goto L7;
        String r3 = null;
    L9:
        return new AccountWithDataSet(r1, r2, r3);
    L7:
        r3 = r0[2];
        goto L9
    L11:
        throw new IllegalArgumentException("Invalid string " + r5);
    }

    public static String stringifyList(List<AccountWithDataSet> r3) {
        StringBuilder r0 = new StringBuilder();
        Iterator<AccountWithDataSet> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        AccountWithDataSet r1 = r4.next();
        if (r0.length() <= 0) goto L8;
        r0.append(ARRAY_STRINGIFY_SEPARATOR);
    L8:
        addStringified(r0, r1);
        goto L4
    L10:
        return r0.toString();
    }

    public static List<AccountWithDataSet> unstringifyList(String r3) {
        ArrayList r0 = Lists.newArrayList();
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return r0;
    L5:
        String[] r4 = ARRAY_STRINGIFY_SEPARATOR_PAT.split(r3);
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L9;
        r0.add(unstringify(r4[r1]));
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }
}
