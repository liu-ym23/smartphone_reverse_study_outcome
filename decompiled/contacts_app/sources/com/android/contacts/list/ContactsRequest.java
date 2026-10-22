package com.android.contacts.list;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsRequest implements Parcelable {
    public static final int ACTION_ALL_CONTACTS = 15;
    public static final int ACTION_BYTEDANCE_INSERT_OR_EDIT = 117;
    public static final int ACTION_CONTACTS_WITH_PHONES = 17;
    public static final int ACTION_CREATE_SHORTCUT_CALL = 120;
    public static final int ACTION_CREATE_SHORTCUT_CONTACT = 110;
    public static final int ACTION_CREATE_SHORTCUT_SMS = 130;
    public static final int ACTION_DEFAULT = 10;
    public static final int ACTION_FREQUENT = 40;
    public static final int ACTION_GROUP = 20;
    public static final int ACTION_INSERT_OR_EDIT_CONTACT = 80;
    public static final int ACTION_PICK_CALLLOG_NUM = 151;
    public static final int ACTION_PICK_CONTACT = 60;
    public static final int ACTION_PICK_EMAIL = 105;
    public static final int ACTION_PICK_MULTIPLE_CALLLOG_NUMS = 150;
    public static final int ACTION_PICK_MULTIPLE_CONTACTS = 61;
    public static final int ACTION_PICK_MULTIPLE_EMAILS = 101;
    public static final int ACTION_PICK_MULTIPLE_EMAILS_EXCEPT_SELECTED = 102;
    public static final int ACTION_PICK_MULTIPLE_PHONES = 96;
    public static final int ACTION_PICK_MULTIPLE_RAWCONTACTS = 62;
    public static final int ACTION_PICK_OR_CREATE_CONTACT = 70;
    public static final int ACTION_PICK_PHONE = 90;
    public static final int ACTION_PICK_PHONE_NUMS = 95;
    public static final int ACTION_PICK_POSTAL = 100;
    public static final int ACTION_PICK_UNFAVORITE_NUMS = 65;
    public static final int ACTION_STARRED = 30;
    public static final int ACTION_STREQUENT = 50;
    public static final int ACTION_VIEW_CONTACT = 140;
    public static Parcelable.Creator<ContactsRequest> CREATOR;
    private int mActionCode;
    private Uri mContactUri;
    private boolean mDirectorySearchEnabled;
    private boolean mIncludeProfile;
    private boolean mLegacyCompatibilityMode;
    private String mQueryString;
    private Intent mRedirectIntent;
    private boolean mSearchMode;
    private CharSequence mTitle;
    private boolean mValid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ContactsRequest() {
        this.mValid = true;
        this.mActionCode = 10;
        this.mDirectorySearchEnabled = true;
    }

    static /* synthetic */ boolean access$002(ContactsRequest r0, boolean r1) {
        r0.mValid = r1;
        return r1;
    }

    static /* synthetic */ int access$102(ContactsRequest r0, int r1) {
        r0.mActionCode = r1;
        return r1;
    }

    static /* synthetic */ Intent access$202(ContactsRequest r0, Intent r1) {
        r0.mRedirectIntent = r1;
        return r1;
    }

    static /* synthetic */ CharSequence access$302(ContactsRequest r0, CharSequence r1) {
        r0.mTitle = r1;
        return r1;
    }

    static /* synthetic */ boolean access$402(ContactsRequest r0, boolean r1) {
        r0.mSearchMode = r1;
        return r1;
    }

    static /* synthetic */ String access$502(ContactsRequest r0, String r1) {
        r0.mQueryString = r1;
        return r1;
    }

    static /* synthetic */ boolean access$602(ContactsRequest r0, boolean r1) {
        r0.mIncludeProfile = r1;
        return r1;
    }

    static /* synthetic */ boolean access$702(ContactsRequest r0, boolean r1) {
        r0.mLegacyCompatibilityMode = r1;
        return r1;
    }

    static /* synthetic */ boolean access$802(ContactsRequest r0, boolean r1) {
        r0.mDirectorySearchEnabled = r1;
        return r1;
    }

    static /* synthetic */ Uri access$902(ContactsRequest r0, Uri r1) {
        r0.mContactUri = r1;
        return r1;
    }

    public String toString() {
        return "{ContactsRequest:mValid=" + this.mValid + " mActionCode=" + this.mActionCode + " mRedirectIntent=" + this.mRedirectIntent + " mTitle=" + this.mTitle + " mSearchMode=" + this.mSearchMode + " mQueryString=" + this.mQueryString + " mIncludeProfile=" + this.mIncludeProfile + " mLegacyCompatibilityMode=" + this.mLegacyCompatibilityMode + " mDirectorySearchEnabled=" + this.mDirectorySearchEnabled + " mContactUri=" + this.mContactUri + "}";
    }

    public void copyFrom(ContactsRequest r2) {
        this.mValid = r2.mValid;
        this.mActionCode = r2.mActionCode;
        this.mRedirectIntent = r2.mRedirectIntent;
        this.mTitle = r2.mTitle;
        this.mSearchMode = r2.mSearchMode;
        this.mQueryString = r2.mQueryString;
        this.mIncludeProfile = r2.mIncludeProfile;
        this.mLegacyCompatibilityMode = r2.mLegacyCompatibilityMode;
        this.mDirectorySearchEnabled = r2.mDirectorySearchEnabled;
        this.mContactUri = r2.mContactUri;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(this.mValid ? 1 : 0);
        r2.writeInt(this.mActionCode);
        r2.writeParcelable(this.mRedirectIntent, 0);
        r2.writeCharSequence(this.mTitle);
        r2.writeInt(this.mSearchMode ? 1 : 0);
        r2.writeString(this.mQueryString);
        r2.writeInt(this.mIncludeProfile ? 1 : 0);
        r2.writeInt(this.mLegacyCompatibilityMode ? 1 : 0);
        r2.writeInt(this.mDirectorySearchEnabled ? 1 : 0);
        r2.writeParcelable(this.mContactUri, 0);
    }

    public boolean isValid() {
        return this.mValid;
    }

    public void setValid(boolean r1) {
        this.mValid = r1;
    }

    public Intent getRedirectIntent() {
        return this.mRedirectIntent;
    }

    public void setRedirectIntent(Intent r1) {
        this.mRedirectIntent = r1;
    }

    public void setActivityTitle(CharSequence r1) {
        this.mTitle = r1;
    }

    public CharSequence getActivityTitle() {
        return this.mTitle;
    }

    public int getActionCode() {
        return this.mActionCode;
    }

    public void setActionCode(int r1) {
        this.mActionCode = r1;
    }

    public boolean isSearchMode() {
        return this.mSearchMode;
    }

    public void setSearchMode(boolean r1) {
        this.mSearchMode = r1;
    }

    public String getQueryString() {
        return this.mQueryString;
    }

    public void setQueryString(String r1) {
        this.mQueryString = r1;
    }

    public boolean shouldIncludeProfile() {
        return this.mIncludeProfile;
    }

    public void setIncludeProfile(boolean r1) {
        this.mIncludeProfile = r1;
    }

    public boolean isLegacyCompatibilityMode() {
        return this.mLegacyCompatibilityMode;
    }

    public void setLegacyCompatibilityMode(boolean r1) {
        this.mLegacyCompatibilityMode = r1;
    }

    public boolean isDirectorySearchEnabled() {
        return this.mDirectorySearchEnabled;
    }

    public void setDirectorySearchEnabled(boolean r1) {
        this.mDirectorySearchEnabled = r1;
    }

    public Uri getContactUri() {
        return this.mContactUri;
    }

    public void setContactUri(Uri r1) {
        this.mContactUri = r1;
    }
}
