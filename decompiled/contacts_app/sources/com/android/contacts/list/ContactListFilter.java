package com.android.contacts.list;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;
import com.google.android.collect.Sets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class ContactListFilter implements Comparable<ContactListFilter>, Parcelable {
    public static final Parcelable.Creator<ContactListFilter> CREATOR = null;
    public static final int FILTER_TYPE_ACCOUNT = 0;
    public static final int FILTER_TYPE_ALL_ACCOUNTS = -2;
    public static final int FILTER_TYPE_CUSTOM = -3;
    public static final int FILTER_TYPE_DEFAULT = -1;
    private static final int FILTER_TYPE_GROUP = 1;
    public static final int FILTER_TYPE_SINGLE_CONTACT = -6;
    public static final int FILTER_TYPE_STARRED = -4;
    public static final int FILTER_TYPE_WITH_PHONE_NUMBERS_ONLY = -5;
    private static final String KEY_ACCOUNT_NAME = "filter.accountName";
    private static final String KEY_ACCOUNT_TYPE = "filter.accountType";
    private static final String KEY_AVAILABLE_ACCOUNTS = "available.accounts";
    private static final String KEY_DATA_SET = "filter.dataSet";
    private static final String KEY_FILTER_ACCOUNTS = "filter.accounts";
    private static final String KEY_FILTER_TYPE = "filter.type";
    private static final String VALUE_NO_ACCOUNTS = "no_accounts";
    public final String accountName;
    public final String accountType;
    public final String dataSet;
    public final int filterType;
    private String mId;

    public static final String filterTypeToString(int r0) {
        switch(r0) {
            case -6: goto L17;
            case -5: goto L15;
            case -4: goto L13;
            case -3: goto L11;
            case -2: goto L9;
            case -1: goto L7;
            case 0: goto L5;
            default: goto L3;
        };
    L3:
        return "(unknown)";
    L5:
        return "FILTER_TYPE_ACCOUNT";
    L7:
        return "FILTER_TYPE_DEFAULT";
    L9:
        return "FILTER_TYPE_ALL_ACCOUNTS";
    L11:
        return "FILTER_TYPE_CUSTOM";
    L13:
        return "FILTER_TYPE_STARRED";
    L15:
        return "FILTER_TYPE_WITH_PHONE_NUMBERS_ONLY";
    L17:
        return "FILTER_TYPE_SINGLE_CONTACT";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ContactListFilter r1) {
        return compareTo2(r1);
    }

    public ContactListFilter(int r1, String r2, String r3, String r4) {
        this.filterType = r1;
        this.accountType = r2;
        this.accountName = r3;
        this.dataSet = r4;
    }

    public static ContactListFilter createFilterWithType(int r2) {
        return new ContactListFilter(r2, null, null, null);
    }

    public static ContactListFilter createAccountFilter(String r2, String r3, String r4) {
        return new ContactListFilter(0, r2, r3, r4);
    }

    public boolean isValidationRequired() {
        if (this.filterType != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        switch(this.filterType) {
            case -6: goto L22;
            case -5: goto L20;
            case -4: goto L18;
            case -3: goto L16;
            case -2: goto L14;
            case -1: goto L12;
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r0 = new StringBuilder("account: ").append(this.accountType);
        if (this.dataSet == null) goto L9;
        String r1 = LibrarianImpl.Constants.SEPARATOR + this.dataSet;
    L11:
        return r0.append(r1).append(HanziToPinyin.Token.SEPARATOR).append(this.accountName).toString();
    L9:
        r1 = "";
        goto L11
    L12:
        return "default";
    L14:
        return "all_accounts";
    L16:
        return "custom";
    L18:
        return ContactSaveService.EXTRA_STARRED_FLAG;
    L20:
        return "with_phones";
    L22:
        return "single";
    L5:
        return super.toString();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ContactListFilter r3) {
        int r0 = this.accountName.compareTo(r3.accountName);
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = this.accountType.compareTo(r3.accountType);
        if (r1 == 0) goto L9;
        return r1;
    L9:
        return this.filterType - r3.filterType;
    }

    public int hashCode() {
        int r0 = this.filterType;
        String r1 = this.accountType;
        if (r1 == null) goto L5;
        r0 = (((r0 * 31) + r1.hashCode()) * 31) + this.accountName.hashCode();
    L5:
        String r2 = this.dataSet;
        if (r2 != null) goto L8;
        return r0;
    L8:
        return (r0 * 31) + r2.hashCode();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactListFilter) == true) goto L8;
        return false;
    L8:
        ContactListFilter r6 = (ContactListFilter) r5;
        if (this.filterType == r6.filterType) goto L11;
    L18:
        return false;
    L11:
        if (TextUtils.equals(this.accountName, r6.accountName) == false) goto L18;
        if (TextUtils.equals(this.accountType, r6.accountType) == false) goto L18;
        if (TextUtils.equals(this.dataSet, r6.dataSet) == false) goto L18;
        return true;
    }

    public static void storeToPreferences(SharedPreferences r6, Set<ContactListFilter> r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        Iterator<ContactListFilter> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L15;
        ContactListFilter r1 = r8.next();
        if (r1.filterType != 0) goto L6;
        String r3 = r1.accountName;
        String r4 = r1.accountType;
        if ("com.android.sim".equals(r4) == false) goto L13;
        String r2 = null;
    L14:
        r0.add(new AccountWithDataSet(r3, r4, r2));
        goto L6
    L13:
        r2 = r1.dataSet;
        goto L14
    L15:
        SharedPreferences.Editor r9 = r6.edit();
        if (r0.size() != 0) goto L18;
        String r10 = VALUE_NO_ACCOUNTS;
    L19:
        r9.putString(KEY_FILTER_ACCOUNTS, r10).apply();
        return;
    L18:
        r10 = AccountWithDataSet.stringifyList(r0);
        goto L19
    }

    public static Set<ContactListFilter> restoreDefaultPreferences(SharedPreferences r0) {
        return restoreFromPreferences(r0);
    }

    private static Set<ContactListFilter> restoreFromPreferences(SharedPreferences r7) {
        String r8 = r7.getString(KEY_FILTER_ACCOUNTS, null);
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r8.equals(VALUE_NO_ACCOUNTS) == true) goto L8;
        List<AccountWithDataSet> r9 = AccountWithDataSet.unstringifyList(r8);     // Catch: Exception -> L24
        if (r9 == null) goto L26;
        HashSet r0 = Sets.newHashSet();     // Catch: Exception -> L24
        Iterator<AccountWithDataSet> r10 = r9.iterator();     // Catch: Exception -> L24
    L12:
        if (r10.hasNext() == false) goto L23;
        AccountWithDataSet r2 = r10.next();     // Catch: Exception -> L24
        if (TextUtils.equals(r2.type, ContactsUtils.OLD_LOCAL_ACCOUNT_TYPE) == true) goto L16;
        String r3 = r2.type;     // Catch: Exception -> L24
        String r4 = r2.name;     // Catch: Exception -> L24
        if ("com.android.sim".equals(r2.type) == false) goto L20;
        String r5 = null;
    L21:
        r0.add(createAccountFilter(r3, r4, r5));     // Catch: Exception -> L24
        goto L12
    L20:
        r5 = r2.dataSet;     // Catch: Exception -> L24
        goto L21
    L16:
        AccountWithDataSet r6 = new AccountWithDataSet("default", ContactsUtils.LOCAL_ACCOUNT_TYPE, null);     // Catch: Exception -> L24
        r0.add(createAccountFilter(r6.type, r6.name, r6.dataSet));     // Catch: Exception -> L24
        goto L12
    L23:
        return r0;
    L26:
        return null;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L8:
        return Sets.newHashSet();
    }

    public static void storeAvailableAccountsToPreferences(Context r5, List<AccountWithDataSet> r6) {
        ArrayList r0 = new ArrayList();
        Iterator<AccountWithDataSet> r7 = r6.iterator();
    L3:
        String r2 = null;
        if (r7.hasNext() == false) goto L9;
        AccountWithDataSet r1 = r7.next();
        if ("com.android.sim".equals(r1.type) == true) goto L7;
        r0.add(r1);
        goto L3
    L7:
        r0.add(new AccountWithDataSet(r1.name, r1.type, null));
        goto L3
    L9:
        SharedPreferences.Editor r8 = PreferenceManager.getDefaultSharedPreferences(r5).edit();
        if (r0.size() == 0) goto L13;
        r2 = AccountWithDataSet.stringifyList(r0);
    L13:
        r8.putString(KEY_AVAILABLE_ACCOUNTS, r2).apply();
    }

    public static List<AccountWithDataSet> restoreAvailableAccountsFromPreferences(Context r2) {
        String r3 = PreferenceManager.getDefaultSharedPreferences(r2).getString(KEY_AVAILABLE_ACCOUNTS, null);
        if (r3 != null) goto L10;
        return null;
    L10:
        return AccountWithDataSet.unstringifyList(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.filterType);
        r1.writeString(this.accountName);
        r1.writeString(this.accountType);
        r1.writeString(this.dataSet);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String getId() {
        if (this.mId != null) goto L15;
        StringBuilder r0 = new StringBuilder();
        r0.append(this.filterType);
        if (this.accountType == null) goto L8;
        r0.append('-').append(this.accountType);
    L8:
        if (this.dataSet == null) goto L11;
        r0.append('/').append(this.dataSet);
    L11:
        if (this.accountName == null) goto L13;
        r0.append('-').append(this.accountName.replace('-', '_'));
    L13:
        this.mId = r0.toString();
    L15:
        return this.mId;
    }

    public Uri.Builder addAccountQueryParameterToUrl(Uri.Builder r3) {
        if (this.filterType != 0) goto L9;
        r3.appendQueryParameter("account_name", this.accountName);
        r3.appendQueryParameter("account_type", this.accountType);
        if (TextUtils.isEmpty(this.dataSet) == true) goto L7;
        r3.appendQueryParameter("data_set", this.dataSet);
    L7:
        return r3;
    L9:
        throw new IllegalStateException("filterType must be FILTER_TYPE_ACCOUNT");
    }

    public String toDebugString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[filter type: " + this.filterType + " (" + filterTypeToString(this.filterType) + ")");
        if (this.filterType != 0) goto L6;
        r0.append(", accountType: " + this.accountType).append(", accountName: " + this.accountName).append(", dataSet: " + this.dataSet);
    L6:
        return r0.toString();
    }
}
