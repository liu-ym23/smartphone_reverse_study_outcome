package com.android.contacts.group;

import com.android.contacts.ContactsUtils;
import com.android.contacts.list.ContactBaseData;
import com.android.contacts.model.AccountWithDataSet;

/* JADX INFO: loaded from: classes2.dex */
public final class GroupListItem extends ContactBaseData {
    public static final long DEFAULT_GROUP_ID = -1;
    public static final String DEFAULT_TITLE = "未分组联系人";
    public static final String URI_KEY_ACCOUNT_NAME = "URI_KEY_ACCOUNT_NAME";
    public static final String URI_KEY_ACCOUNT_TYPE = "URI_KEY_ACCOUNT_TYPE";
    public static final String URI_KEY_IS_UNGROUPED = "URI_KEY_IS_UNGROUPED";
    private String mAccountName;
    private final String mAccountType;
    private final String mDataSet;
    private long mGroupId;
    private final int mGroupIsReadOnly;
    private boolean mIsUngrouped;
    private final int mMemberCount;

    public GroupListItem(String r2, String r3, String r4, long r5, String r7, int r8, int r9) {
        this.mIsUngrouped = false;
        this.mAccountName = r2;
        this.mAccountType = r3;
        this.mDataSet = r4;
        this.mGroupId = r5;
        this.name = r7;
        this.sortkey = ContactsUtils.getPinyinChineseName(this.name);
        this.section = ContactsUtils.getContactSection(this.sortkey);
        this.hasname = true;
        this.mMemberCount = r8;
        this.mGroupIsReadOnly = r9;
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
        return this.name;
    }

    public int getMemberCount() {
        return this.mMemberCount;
    }

    public boolean getGroupIsReadOnly() {
        if (this.mGroupIsReadOnly == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isUngrouped() {
        return this.mIsUngrouped;
    }

    public void setIsUngrouped(boolean r3, String r4) {
        this.mIsUngrouped = r3;
        this.mGroupId = -1;
        this.name = r4;
    }

    public AccountWithDataSet getAccountWithDataSet() {
        return new AccountWithDataSet(this.mAccountName, this.mAccountType, this.mDataSet);
    }
}
