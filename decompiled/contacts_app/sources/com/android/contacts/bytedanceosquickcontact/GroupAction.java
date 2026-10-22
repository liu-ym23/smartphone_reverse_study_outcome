package com.android.contacts.bytedanceosquickcontact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.list.ContactBaseData;

/* JADX INFO: loaded from: classes.dex */
public class GroupAction extends ContactBaseData implements Action {
    public static final int TYPE_BTN_NEW_GROUP = 1;
    public static final int TYPE_GROUP_CONTENT = 2;
    private String mAccountName;
    private String mAccountType;
    private long mDataId;
    private String mGroupTitle;
    private boolean mIsCheckedAfterChice;
    private boolean mIsCheckedBeforeChoice;
    private long mRawGroupId;
    private int mType;

    /* JADX INFO: renamed from: collapseWith, reason: avoid collision after fix types in other method */
    public boolean collapseWith2(Action r1) {
        return false;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Intent getAlternateIntent() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public CharSequence getBody() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Uri getDataUri() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Intent getIntent() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public String getMimeType() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Intent getStarIntent() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public CharSequence getSubtitle() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public void setDataAction(Context r1, String r2, long r3, Cursor r5) {
    }

    /* JADX INFO: renamed from: shouldCollapseWith, reason: avoid collision after fix types in other method */
    public boolean shouldCollapseWith2(Action r1) {
        return false;
    }

    @Override // com.android.contacts.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean collapseWith(Action r1) {
        return collapseWith2(r1);
    }

    @Override // com.android.contacts.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean shouldCollapseWith(Action r1) {
        return shouldCollapseWith2(r1);
    }

    public GroupAction(Context r3, int r4, long r5, String r7, String r8, String r9, boolean r10, long r11) {
        this.mIsCheckedBeforeChoice = false;
        this.mIsCheckedAfterChice = false;
        this.mDataId = -1;
        this.mType = r4;
        this.mRawGroupId = r5;
        if (r4 != 2) goto L5;
        this.mGroupTitle = r7;
    L6:
        this.name = this.mGroupTitle;
        this.hasname = !TextUtils.isEmpty(this.name);
        this.sortkey = ContactsUtils.getPinyinChineseName(this.name);
        this.section = ContactsUtils.getContactSection(this.sortkey);
        this.mAccountName = r8;
        this.mAccountType = r9;
        this.mIsCheckedBeforeChoice = r10;
        this.mIsCheckedAfterChice = r10;
        this.mDataId = r11;
        return;
    L5:
        this.mGroupTitle = r3.getResources().getString(R.string.dialog_btn_addto_newgroup);
        goto L6
    }

    public void setCheck(boolean r1) {
        this.mIsCheckedAfterChice = r1;
    }

    public boolean isChecked() {
        return this.mIsCheckedAfterChice;
    }

    public boolean isAdd2Group() {
        if (this.mIsCheckedBeforeChoice == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsCheckedAfterChice == false) goto L7;
        return true;
    }

    public boolean isRemove() {
        if (this.mIsCheckedBeforeChoice == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsCheckedAfterChice == true) goto L7;
        return true;
    }

    public int getType() {
        return this.mType;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public long getRawGroupId() {
        return this.mRawGroupId;
    }

    public String getAccountName() {
        return this.mAccountName;
    }

    public String AccountType() {
        return this.mAccountType;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public long getDataId() {
        return this.mDataId;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Boolean isStarred() {
        return false;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public String getData() {
        return this.mGroupTitle;
    }
}
