package com.android.contacts.common.model;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.android.contacts.common.GroupMetaData;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.common.util.DataStatus;
import com.android.contacts.util.BytedanceContactContract;
import com.android.internal.telephony.IccCardConstants;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Contact {
    private final String mAltDisplayName;
    private final String mCustomRingtone;
    private String mDirectoryAccountName;
    private String mDirectoryAccountType;
    private String mDirectoryDisplayName;
    private int mDirectoryExportSupport;
    private final long mDirectoryId;
    private String mDirectoryType;
    private final String mDisplayName;
    private final int mDisplayNameSource;
    private final Exception mException;
    private ImmutableList<GroupMetaData> mGroups;
    private final long mId;
    private ImmutableList<AccountType> mInvitableAccountTypes;
    private final boolean mIsUserProfile;
    private final String mLookupKey;
    private final Uri mLookupUri;
    private final long mNameRawContactId;
    private final String mPhoneticName;
    private byte[] mPhotoBinaryData;
    private final long mPhotoId;
    private final String mPhotoUri;
    private final Integer mPresence;
    private ImmutableList<RawContact> mRawContacts;
    private final Uri mRequestedUri;
    private final boolean mSendToVoicemail;
    private final boolean mStarred;
    private final Status mStatus;
    private ImmutableMap<Long, DataStatus> mStatuses;
    private byte[] mThumbnailPhotoBinaryData;
    private final Uri mUri;

    private static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ERROR = null;
        public static final Status LOADED = null;
        public static final Status NOT_FOUND = null;

        private static /* synthetic */ Status[] $values() {
            return new Status[]{LOADED, ERROR, NOT_FOUND};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r1) {
            return (Status) Enum.valueOf(Status.class, r1);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        static {
            LOADED = new Status(IccCardConstants.INTENT_VALUE_ICC_LOADED, 0);
            ERROR = new Status("ERROR", 1);
            NOT_FOUND = new Status("NOT_FOUND", 2);
            $VALUES = $values();
        }
    }

    private Contact(Uri r2, Status r3, Exception r4) {
        if (r3 != Status.ERROR) goto L8;
        if (r4 != null) goto L8;
        throw new IllegalArgumentException("ERROR result must have exception");
    L8:
        this.mStatus = r3;
        this.mException = r4;
        this.mRequestedUri = r2;
        this.mLookupUri = null;
        this.mUri = null;
        this.mDirectoryId = -1;
        this.mLookupKey = null;
        this.mId = -1;
        this.mRawContacts = null;
        this.mStatuses = null;
        this.mNameRawContactId = -1;
        this.mDisplayNameSource = 0;
        this.mPhotoId = -1;
        this.mPhotoUri = null;
        this.mDisplayName = null;
        this.mAltDisplayName = null;
        this.mPhoneticName = null;
        this.mStarred = false;
        this.mPresence = null;
        this.mInvitableAccountTypes = null;
        this.mSendToVoicemail = false;
        this.mCustomRingtone = null;
        this.mIsUserProfile = false;
    }

    public static Contact forError(Uri r2, Exception r3) {
        return new Contact(r2, Status.ERROR, r3);
    }

    public static Contact forNotFound(Uri r3) {
        return new Contact(r3, Status.NOT_FOUND, null);
    }

    public Contact(Uri r5, Uri r6, Uri r7, long r8, String r10, long r11, long r13, int r15, long r16, String r18, String r19, String r20, String r21, boolean r22, Integer r23, boolean r24, String r25, boolean r26) {
        this.mStatus = Status.LOADED;
        this.mException = null;
        this.mRequestedUri = r5;
        this.mLookupUri = r7;
        this.mUri = r6;
        this.mDirectoryId = r8;
        this.mLookupKey = r10;
        this.mId = r11;
        this.mRawContacts = null;
        this.mStatuses = null;
        this.mNameRawContactId = r13;
        this.mDisplayNameSource = r15;
        this.mPhotoId = r16;
        this.mPhotoUri = r18;
        this.mDisplayName = r19;
        this.mAltDisplayName = r20;
        this.mPhoneticName = r21;
        this.mStarred = r22;
        this.mPresence = r23;
        this.mInvitableAccountTypes = null;
        this.mSendToVoicemail = r24;
        this.mCustomRingtone = r25;
        this.mIsUserProfile = r26;
    }

    public Contact(Uri r3, Contact r4) {
        this.mRequestedUri = r3;
        this.mStatus = r4.mStatus;
        this.mException = r4.mException;
        this.mLookupUri = r4.mLookupUri;
        this.mUri = r4.mUri;
        this.mDirectoryId = r4.mDirectoryId;
        this.mLookupKey = r4.mLookupKey;
        this.mId = r4.mId;
        this.mNameRawContactId = r4.mNameRawContactId;
        this.mDisplayNameSource = r4.mDisplayNameSource;
        this.mPhotoId = r4.mPhotoId;
        this.mPhotoUri = r4.mPhotoUri;
        this.mDisplayName = r4.mDisplayName;
        this.mAltDisplayName = r4.mAltDisplayName;
        this.mPhoneticName = r4.mPhoneticName;
        this.mStarred = r4.mStarred;
        this.mPresence = r4.mPresence;
        this.mRawContacts = r4.mRawContacts;
        this.mStatuses = r4.mStatuses;
        this.mInvitableAccountTypes = r4.mInvitableAccountTypes;
        this.mDirectoryDisplayName = r4.mDirectoryDisplayName;
        this.mDirectoryType = r4.mDirectoryType;
        this.mDirectoryAccountType = r4.mDirectoryAccountType;
        this.mDirectoryAccountName = r4.mDirectoryAccountName;
        this.mDirectoryExportSupport = r4.mDirectoryExportSupport;
        this.mGroups = r4.mGroups;
        this.mPhotoBinaryData = r4.mPhotoBinaryData;
        this.mSendToVoicemail = r4.mSendToVoicemail;
        this.mCustomRingtone = r4.mCustomRingtone;
        this.mIsUserProfile = r4.mIsUserProfile;
    }

    public void setDirectoryMetaData(String r1, String r2, String r3, String r4, int r5) {
        this.mDirectoryDisplayName = r1;
        this.mDirectoryType = r2;
        this.mDirectoryAccountType = r3;
        this.mDirectoryAccountName = r4;
        this.mDirectoryExportSupport = r5;
    }

    void setPhotoBinaryData(byte[] r1) {
        this.mPhotoBinaryData = r1;
    }

    void setThumbnailPhotoBinaryData(byte[] r1) {
        this.mThumbnailPhotoBinaryData = r1;
    }

    public Uri getLookupUri() {
        return this.mLookupUri;
    }

    public String getLookupKey() {
        return this.mLookupKey;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public Uri getRequestedUri() {
        return this.mRequestedUri;
    }

    public RawContactDeltaList createRawContactDeltaList() {
        return RawContactDeltaList.fromIterator(getRawContacts().iterator());
    }

    public long getId() {
        return this.mId;
    }

    public boolean isError() {
        if (this.mStatus != Status.ERROR) goto L5;
        return true;
    L5:
        return false;
    }

    public Exception getException() {
        return this.mException;
    }

    public boolean isNotFound() {
        if (this.mStatus != Status.NOT_FOUND) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLoaded() {
        if (this.mStatus != Status.LOADED) goto L5;
        return true;
    L5:
        return false;
    }

    public long getNameRawContactId() {
        return this.mNameRawContactId;
    }

    public int getDisplayNameSource() {
        return this.mDisplayNameSource;
    }

    public boolean isDisplayNameFromOrganization() {
        if (30 != this.mDisplayNameSource) goto L5;
        return true;
    L5:
        return false;
    }

    public long getPhotoId() {
        return this.mPhotoId;
    }

    public String getPhotoUri() {
        return this.mPhotoUri;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public String getAltDisplayName() {
        return this.mAltDisplayName;
    }

    public String getPhoneticName() {
        return this.mPhoneticName;
    }

    public boolean getStarred() {
        return this.mStarred;
    }

    public Integer getPresence() {
        return this.mPresence;
    }

    public ImmutableList<AccountType> getInvitableAccountTypes() {
        return this.mInvitableAccountTypes;
    }

    public ImmutableList<RawContact> getRawContacts() {
        return this.mRawContacts;
    }

    public ImmutableMap<Long, DataStatus> getStatuses() {
        return this.mStatuses;
    }

    public long getDirectoryId() {
        return this.mDirectoryId;
    }

    public boolean isDirectoryEntry() {
        long r0 = this.mDirectoryId;
        if (r0 != (-1)) goto L5;
    L9:
        return false;
    L5:
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L9;
        return true;
    }

    public boolean isWritableContact(Context r3) {
        if (getFirstWritableRawContactId(r3) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public long getFirstWritableRawContactId(Context r5) {
        if (isDirectoryEntry() == false) goto L5;
        return -1;
    L5:
        UnmodifiableIterator<RawContact> r4 = getRawContacts().iterator();
    L7:
        if (r4.hasNext() == false) goto L14;
        RawContact r0 = r4.next();
        AccountType r3 = r0.getAccountType(r5);
        if (r3 == null) goto L7;
        if (r3.areContactsWritable() == false) goto L7;
        return r0.getId().longValue();
    L14:
        return -1;
    }

    public int getDirectoryExportSupport() {
        return this.mDirectoryExportSupport;
    }

    public String getDirectoryDisplayName() {
        return this.mDirectoryDisplayName;
    }

    public String getDirectoryType() {
        return this.mDirectoryType;
    }

    public String getDirectoryAccountType() {
        return this.mDirectoryAccountType;
    }

    public String getDirectoryAccountName() {
        return this.mDirectoryAccountName;
    }

    public byte[] getPhotoBinaryData() {
        return this.mPhotoBinaryData;
    }

    public byte[] getThumbnailPhotoBinaryData() {
        return this.mThumbnailPhotoBinaryData;
    }

    public ArrayList<ContentValues> getContentValues() {
        if (this.mRawContacts.size() != 1) goto L11;
        ArrayList<ContentValues> r0 = this.mRawContacts.get(0).getContentValues();
        if (this.mPhotoId == 0) goto L7;
    L9:
        return r0;
    L7:
        if (this.mPhotoBinaryData == null) goto L9;
        ContentValues r1 = new ContentValues();
        r1.put("mimetype", "vnd.android.cursor.item/photo");
        r1.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, this.mPhotoBinaryData);
        r0.add(r1);
        goto L9
    L11:
        throw new IllegalStateException("Cannot extract content values from an aggregated contact");
    }

    public ImmutableList<GroupMetaData> getGroupMetaData() {
        return this.mGroups;
    }

    public boolean isSendToVoicemail() {
        return this.mSendToVoicemail;
    }

    public String getCustomRingtone() {
        return this.mCustomRingtone;
    }

    public boolean isUserProfile() {
        return this.mIsUserProfile;
    }

    public String toString() {
        return "{requested=" + this.mRequestedUri + ",lookupkey=" + this.mLookupKey + ",uri=" + this.mUri + ",status=" + this.mStatus + "}";
    }

    void setRawContacts(ImmutableList<RawContact> r1) {
        this.mRawContacts = r1;
    }

    void setStatuses(ImmutableMap<Long, DataStatus> r1) {
        this.mStatuses = r1;
    }

    void setInvitableAccountTypes(ImmutableList<AccountType> r1) {
        this.mInvitableAccountTypes = r1;
    }

    void setGroupMetaData(ImmutableList<GroupMetaData> r1) {
        this.mGroups = r1;
    }
}
