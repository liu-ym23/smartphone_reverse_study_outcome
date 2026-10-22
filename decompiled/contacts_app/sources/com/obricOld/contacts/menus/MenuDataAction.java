package com.obricOld.contacts.menus;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.calllog.CallLogAdapter;
import com.android.contacts.calllog.IntentProvider;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.calllog.v2.CallLogItem;
import com.android.contacts.dialpad.ContactItem;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.PhoneCapabilityTester;

/* JADX INFO: loaded from: classes4.dex */
class MenuDataAction extends ActionAdapter {
    private Intent mAlternateIntent;
    private long mContactId;
    private String mData;
    private long mDataId;
    private Intent mIntent;
    private boolean mIsBlacked;
    private boolean mIsMarked;
    private boolean mIsStarred;
    public String mMimeType;
    private Object mRawData;
    private Intent mStarIntent;

    public MenuDataAction() {
    }

    public void setDataAction(Context r4, String r5, long r6, ContentValues r8, Object r9) {
        this.mMimeType = r5;
        this.mContactId = r6;
        this.mDataId = r8.getAsLong("_id").longValue();
        this.mRawData = r9;
        if ("vnd.android.cursor.item/phone_v2".equals(r5) == true) goto L5;
    L24:
        Intent r3 = this.mIntent;
        if (r3 == null) goto L28;
        r3.setFlags(335544320);
        return;
    L28:
        return;
    L5:
        if (PhoneCapabilityTester.isPhone(r4) == false) goto L24;
        String r7 = r8.getAsString("data1");
        String r10 = r8.getAsString(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG);
        boolean r0 = false;
        if (TextUtils.isEmpty(r10) == false) goto L9;
        int r11 = 0;
    L11:
        if (TextUtils.isEmpty(r7) == true) goto L24;
        if (DSUtils.useDSFeature() == false) goto L15;
        Intent r12 = DSUtils.getCallIntent(r4, r7, -1);
    L16:
        this.mIntent = r12;
        String[] r1 = {r7};
        if (r11 == 1) goto L19;
        boolean r2 = true;
    L20:
        this.mStarIntent = ContactSaveService.createSetPhoneStarredIntent(r4, r6, r1, r2);
        if (r11 != 1) goto L23;
        r0 = true;
    L23:
        this.mIsStarred = r0;
        this.mData = ContactsUtils.formatNumber(r7);
        this.mAlternateIntent = ContactsIntentUtils.getSendMessageIntent(r7);
        goto L24
    L19:
        r2 = false;
        goto L20
    L15:
        r12 = ContactsIntentUtils.newDialNumberIntent(r7);
        goto L16
    L9:
        r11 = Integer.valueOf(r10).intValue();
        goto L11
    }

    public void setDataAction(Context r3, String r4, CallLogAdapter.PrimaryActionListener r5, boolean r6) {
        this.mRawData = r5;
        this.mIsBlacked = r6;
        int r7 = r5.getPhoneCallDetails().presentation;
        if ("vnd.android.cursor.item/phone_v2".equals(r4) == true) goto L5;
    L17:
        Intent r2 = this.mIntent;
        if (r2 == null) goto L21;
        r2.setFlags(335544320);
        return;
    L21:
        return;
    L5:
        if (PhoneNumberHelper.canPlaceCallsTo(r7) == false) goto L17;
        this.mData = r5.getNumber();
        PhoneCallDetails r8 = r5.getPhoneCallDetails();
        int r9 = r8.simId;
        if (r8.contactUri != null) goto L9;
        boolean r10 = true;
    L10:
        boolean r0 = r8.isVideoCall;
        if (DSUtils.useDSFeature() == false) goto L13;
        IntentProvider r11 = IntentProvider.getReturnCallIntentProvider(this.mData, r8.subScription, String.valueOf(r9), r10, r0);
    L16:
        this.mIntent = r11.getIntent(r3);
        this.mAlternateIntent = ContactsIntentUtils.getSendMessageIntent(this.mData);
        goto L17
    L13:
        if (r0 == false) goto L15;
        r11 = IntentProvider.getReturnVideoCallIntentProvider(this.mData);
        goto L16
    L15:
        r11 = IntentProvider.getReturnCallIntentProvider(this.mData, r10);
        goto L16
    L9:
        r10 = false;
        goto L10
    }

    public void setDataAction(Context r5, String r6, ContactItem r7, boolean r8) {
        this.mRawData = r7;
        if (r7.getLookupUri() != null) goto L5;
        this.mIsBlacked = r8;
    L7:
        if ("vnd.android.cursor.item/phone_v2".equals(r6) == true) goto L9;
    L20:
        Intent r4 = this.mIntent;
        if (r4 == null) goto L24;
        r4.setFlags(335544320);
        return;
    L24:
        return;
    L9:
        if (PhoneCapabilityTester.isPhone(r5) == false) goto L20;
        String r9 = r7.getNumber();
        if (TextUtils.isEmpty(r9) == true) goto L20;
        if (DSUtils.useDSFeature() == false) goto L15;
        Intent r0 = DSUtils.getCallIntent(r5, r9, -1);
    L16:
        this.mIntent = r0;
        if (r7.getLookupUri() == null) goto L19;
        this.mStarIntent = ContactSaveService.createSetPhoneStarredIntent(r5, this.mContactId, new String[]{r9}, true ^ r8);
    L19:
        this.mData = ContactsUtils.formatNumber(r9);
        this.mAlternateIntent = ContactsIntentUtils.getSendMessageIntent(r9);
        goto L20
    L15:
        r0 = ContactsIntentUtils.newDialNumberIntent(r9);
        goto L16
    L5:
        this.mIsStarred = r8;
        this.mContactId = r7.getContactId();
        goto L7
    }

    public void setDataAction(Object r1) {
        this.mRawData = r1;
    }

    public void setDataAction(Context r2, String r3, CallLogItem r4) {
        this.mRawData = r4;
        if ("vnd.android.cursor.item/phone_v2".equals(r3) == true) goto L5;
    L13:
        Intent r1 = this.mIntent;
        if (r1 == null) goto L17;
        r1.setFlags(335544320);
        return;
    L17:
        return;
    L5:
        if (PhoneCapabilityTester.isPhone(r2) == false) goto L13;
        String r5 = r4.getNumber();
        if (TextUtils.isEmpty(r5) == true) goto L13;
        if (DSUtils.useDSFeature() == false) goto L11;
        Intent r6 = DSUtils.getCallIntent(r2, r5, -1);
    L12:
        this.mIntent = r6;
        this.mData = ContactsUtils.formatNumber(r5);
        this.mAlternateIntent = ContactsIntentUtils.getSendMessageIntent(r5);
        goto L13
    L11:
        r6 = ContactsIntentUtils.newDialNumberIntent(r5);
        goto L12
    }

    @Override // com.obricOld.contacts.menus.ActionAdapter, com.android.contacts.bytedanceosquickcontact.Action
    public String getData() {
        return this.mData;
    }

    @Override // com.obricOld.contacts.menus.ActionAdapter, com.android.contacts.bytedanceosquickcontact.Action
    public Intent getIntent() {
        return this.mIntent;
    }

    @Override // com.obricOld.contacts.menus.ActionAdapter, com.android.contacts.bytedanceosquickcontact.Action
    public Intent getAlternateIntent() {
        return this.mAlternateIntent;
    }

    @Override // com.obricOld.contacts.menus.ActionAdapter, com.android.contacts.bytedanceosquickcontact.Action
    public String getMimeType() {
        return this.mMimeType;
    }

    @Override // com.obricOld.contacts.menus.ActionAdapter, com.android.contacts.bytedanceosquickcontact.Action
    public Intent getStarIntent() {
        return this.mStarIntent;
    }

    @Override // com.obricOld.contacts.menus.ActionAdapter, com.android.contacts.bytedanceosquickcontact.Action
    public long getDataId() {
        return this.mDataId;
    }

    @Override // com.obricOld.contacts.menus.ActionAdapter, com.android.contacts.bytedanceosquickcontact.Action
    public Boolean isStarred() {
        return Boolean.valueOf(this.mIsStarred);
    }

    public boolean isBlacked() {
        return this.mIsBlacked;
    }

    public Object getRawData() {
        return this.mRawData;
    }

    public boolean isMarked() {
        return this.mIsMarked;
    }

    public void setIsMarked(boolean r1) {
        this.mIsMarked = r1;
    }

    public void setIsBlacked(boolean r1) {
        this.mIsBlacked = r1;
    }
}
