package com.android.contacts.common;

/* JADX INFO: loaded from: classes.dex */
public final class GroupMetaData {
    private String mAccountName;
    private String mAccountType;
    private String mDataSet;
    private boolean mDefaultGroup;
    private boolean mFavorites;
    private long mGroupId;
    private String mTitle;

    public GroupMetaData(String r1, String r2, String r3, long r4, String r6, boolean r7, boolean r8) {
        this.mAccountName = r1;
        this.mAccountType = r2;
        this.mDataSet = r3;
        this.mGroupId = r4;
        this.mTitle = r6;
        this.mDefaultGroup = r7;
        this.mFavorites = r8;
    }

    public String getAccountName() {
        return this.mAccountName;
    }

    public String getAccountType() {
        return this.mAccountType;
    }

    public String getDataSet() {
        return this.mDataSet;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isDefaultGroup() {
        return this.mDefaultGroup;
    }

    public boolean isFavorites() {
        return this.mFavorites;
    }
}
