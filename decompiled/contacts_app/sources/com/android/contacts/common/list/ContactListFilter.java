package com.android.contacts.common.list;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.contacts.ContactSaveService;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes.dex */
public final class ContactListFilter implements Comparable<ContactListFilter>, Parcelable {
    public static final Parcelable.Creator<ContactListFilter> CREATOR = null;
    public static final int FILTER_TYPE_ACCOUNT = 0;
    public static final int FILTER_TYPE_ALL_ACCOUNTS = -2;
    public static final int FILTER_TYPE_ALL_WITHOUT_SIM = 2;
    public static final int FILTER_TYPE_CAN_SAVE_EMAIL = -7;
    public static final int FILTER_TYPE_CUSTOM = -3;
    public static final int FILTER_TYPE_DEFAULT = -1;
    private static final int FILTER_TYPE_GROUP = 1;
    public static final int FILTER_TYPE_SINGLE_CONTACT = -6;
    public static final int FILTER_TYPE_STARRED = -4;
    public static final int FILTER_TYPE_WITH_PHONE_NUMBERS_ONLY = -5;
    private static final String KEY_ACCOUNT_NAME = "filter.accountName";
    private static final String KEY_ACCOUNT_TYPE = "filter.accountType";
    private static final String KEY_DATA_SET = "filter.dataSet";
    private static final String KEY_FILTER_TYPE = "filter.type";
    public final String accountName;
    public final String accountType;
    public final String dataSet;
    public final int filterType;
    public final Drawable icon;
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

    public ContactListFilter(int r1, String r2, String r3, String r4, Drawable r5) {
        this.filterType = r1;
        this.accountType = r2;
        this.accountName = r3;
        this.dataSet = r4;
        this.icon = r5;
    }

    public static ContactListFilter createFilterWithType(int r7) {
        return new ContactListFilter(r7, null, null, null, null);
    }

    public static ContactListFilter createAccountFilter(String r7, String r8, String r9, Drawable r10) {
        return new ContactListFilter(0, r7, r8, r9, r10);
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

    public static void storeToPreferences(SharedPreferences r3, ContactListFilter r4) {
        if (r4 != null) goto L4;
    L6:
        SharedPreferences.Editor r5 = r3.edit();
        if (r4 != null) goto L9;
        int r0 = -1;
    L10:
        SharedPreferences.Editor r6 = r5.putInt(KEY_FILTER_TYPE, r0);
        String r1 = null;
        if (r4 != null) goto L13;
        String r2 = null;
    L14:
        SharedPreferences.Editor r7 = r6.putString(KEY_ACCOUNT_NAME, r2);
        if (r4 != null) goto L17;
        String r8 = null;
    L18:
        SharedPreferences.Editor r9 = r7.putString(KEY_ACCOUNT_TYPE, r8);
        if (r4 == null) goto L22;
        r1 = r4.dataSet;
    L22:
        r9.putString(KEY_DATA_SET, r1).apply();
        return;
    L17:
        r8 = r4.accountType;
        goto L18
    L13:
        r2 = r4.accountName;
        goto L14
    L9:
        r0 = r4.filterType;
        goto L10
    L4:
        if (r4.filterType != (-6)) goto L6;
    }

    public static ContactListFilter restoreDefaultPreferences(SharedPreferences r3) {
        ContactListFilter r4 = restoreFromPreferences(r3);
        if (r4 != null) goto L5;
        r4 = createFilterWithType(-2);
    L5:
        int r1 = r4.filterType;
        if (r1 == 1) goto L10;
        if (r1 == (-6)) goto L10;
        return r4;
    L10:
        return createFilterWithType(-2);
    }

    private static ContactListFilter restoreFromPreferences(SharedPreferences r8) {
        int r3 = r8.getInt(KEY_FILTER_TYPE, -1);
        if (r3 != (-1)) goto L5;
        return null;
    L5:
        String r5 = r8.getString(KEY_ACCOUNT_NAME, null);
        return new ContactListFilter(r3, r8.getString(KEY_ACCOUNT_TYPE, null), r5, r8.getString(KEY_DATA_SET, null), null);
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
        if (this.filterType != 0) goto L5;
        r0.append(", accountType: " + this.accountType).append(", accountName: " + this.accountName).append(", dataSet: " + this.dataSet);
    L5:
        r0.append(", icon: " + this.icon + "]");
        return r0.toString();
    }
}
