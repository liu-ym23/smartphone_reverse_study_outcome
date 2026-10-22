package com.android.contacts.list;

import com.android.common.widget.CompositeCursorAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryPartition extends CompositeCursorAdapter.Partition {
    public static final int STATUS_LOADED = 2;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_NOT_LOADED = 0;
    private long mDirectoryId;
    private String mDirectoryType;
    private String mDisplayName;
    private boolean mPhotoSupported;
    private boolean mPriorityDirectory;
    private int mStatus;

    public DirectoryPartition(boolean r1, boolean r2) {
        super(r1, r2);
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
}
