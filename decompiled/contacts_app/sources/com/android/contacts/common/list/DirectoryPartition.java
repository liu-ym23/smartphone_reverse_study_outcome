package com.android.contacts.common.list;

import com.android.common.widget.CompositeCursorAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class DirectoryPartition extends CompositeCursorAdapter.Partition {
    public static final int RESULT_LIMIT_DEFAULT = -1;
    public static final int STATUS_LOADED = 2;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_NOT_LOADED = 0;
    private String mContentUri;
    private long mDirectoryId;
    private String mDirectoryType;
    private String mDisplayName;
    private boolean mDisplayNumber;
    private String mLabel;
    private boolean mPhotoSupported;
    private boolean mPriorityDirectory;
    private int mResultLimit;
    private int mStatus;

    public DirectoryPartition(boolean r1, boolean r2) {
        super(r1, r2);
        this.mResultLimit = -1;
        this.mDisplayNumber = true;
    }

    public long getDirectoryId() {
        return this.mDirectoryId;
    }

    public void setDirectoryId(long r1) {
        this.mDirectoryId = r1;
    }

    public String getDirectoryType() {
        return this.mDirectoryType;
    }

    public void setDirectoryType(String r1) {
        this.mDirectoryType = r1;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public void setDisplayName(String r1) {
        this.mDisplayName = r1;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int r1) {
        this.mStatus = r1;
    }

    public boolean isLoading() {
        int r1 = this.mStatus;
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public boolean isPriorityDirectory() {
        return this.mPriorityDirectory;
    }

    public void setPriorityDirectory(boolean r1) {
        this.mPriorityDirectory = r1;
    }

    public boolean isPhotoSupported() {
        return this.mPhotoSupported;
    }

    public void setPhotoSupported(boolean r1) {
        this.mPhotoSupported = r1;
    }

    public int getResultLimit() {
        return this.mResultLimit;
    }

    public void setResultLimit(int r1) {
        this.mResultLimit = r1;
    }

    public String getContentUri() {
        return this.mContentUri;
    }

    public void setContentUri(String r1) {
        this.mContentUri = r1;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setLabel(String r1) {
        this.mLabel = r1;
    }

    public String toString() {
        return "DirectoryPartition{mDirectoryId=" + this.mDirectoryId + ", mContentUri='" + this.mContentUri + "', mDirectoryType='" + this.mDirectoryType + "', mDisplayName='" + this.mDisplayName + "', mStatus=" + this.mStatus + ", mPriorityDirectory=" + this.mPriorityDirectory + ", mPhotoSupported=" + this.mPhotoSupported + ", mResultLimit=" + this.mResultLimit + ", mLabel='" + this.mLabel + "'}";
    }

    public boolean isDisplayNumber() {
        return this.mDisplayNumber;
    }

    public void setDisplayNumber(boolean r1) {
        this.mDisplayNumber = r1;
    }
}
