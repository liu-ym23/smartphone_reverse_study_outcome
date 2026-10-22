package com.android.contacts.bytedanceosquickcontact;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.PhoneCapabilityTester;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class DataAction implements Action, Parcelable {
    public static final Parcelable.Creator<DataAction> CREATOR = null;
    private Intent mAlternateIntent;
    private CharSequence mBody;
    private String mData;
    private long mDataId;
    private Uri mDataUri;
    private Intent mIntent;
    private boolean mIsStarred;
    private String mMimeType;
    private long mRawGroupId;
    private Intent mStarIntent;
    private CharSequence mSubtitle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static /* synthetic */ String access$002(DataAction r0, String r1) {
        r0.mMimeType = r1;
        return r1;
    }

    static /* synthetic */ String access$1002(DataAction r0, String r1) {
        r0.mData = r1;
        return r1;
    }

    static /* synthetic */ boolean access$102(DataAction r0, boolean r1) {
        r0.mIsStarred = r1;
        return r1;
    }

    static /* synthetic */ CharSequence access$202(DataAction r0, CharSequence r1) {
        r0.mBody = r1;
        return r1;
    }

    static /* synthetic */ CharSequence access$302(DataAction r0, CharSequence r1) {
        r0.mSubtitle = r1;
        return r1;
    }

    static /* synthetic */ Intent access$402(DataAction r0, Intent r1) {
        r0.mIntent = r1;
        return r1;
    }

    static /* synthetic */ Intent access$502(DataAction r0, Intent r1) {
        r0.mAlternateIntent = r1;
        return r1;
    }

    static /* synthetic */ Intent access$602(DataAction r0, Intent r1) {
        r0.mStarIntent = r1;
        return r1;
    }

    static /* synthetic */ Uri access$702(DataAction r0, Uri r1) {
        r0.mDataUri = r1;
        return r1;
    }

    static /* synthetic */ long access$802(DataAction r0, long r1) {
        r0.mDataId = r1;
        return r1;
    }

    static /* synthetic */ long access$902(DataAction r0, long r1) {
        r0.mRawGroupId = r1;
        return r1;
    }

    @Override // com.android.contacts.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean collapseWith(Action r1) {
        return collapseWith2(r1);
    }

    @Override // com.android.contacts.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean shouldCollapseWith(Action r1) {
        return shouldCollapseWith2(r1);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public DataAction() {
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public void setDataAction(Context r7, String r8, long r9, Cursor r11) {
        this.mMimeType = r8;
        this.mSubtitle = "";
        this.mDataId = r9;
        this.mDataUri = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r9);
        if ("vnd.android.cursor.item/phone_v2".equals(r8) == false) goto L22;
        if (PhoneCapabilityTester.isPhone(r7) == false) goto L33;
        String r10 = getAsString(r11, "data1");
        String r12 = getAsString(r11, BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG);
        boolean r1 = false;
        if (TextUtils.isEmpty(r12) == false) goto L9;
        int r13 = 0;
    L11:
        if (TextUtils.isEmpty(r10) == true) goto L33;
        if (r11 == null) goto L33;
        Intent r0 = ContactsIntentUtils.newDialNumberIntent(r10);
        long r2 = r11.getLong(18);
        String[] r4 = {r10};
        if (r13 == 1) goto L16;
        boolean r5 = true;
    L17:
        Intent r14 = ContactSaveService.createSetPhoneStarredIntent(r7, r2, r4, r5);
        if (r13 != 1) goto L20;
        r1 = true;
    L20:
        this.mIsStarred = r1;
        this.mData = ContactsUtils.formatNumber(r10);
        this.mIntent = r0;
        this.mAlternateIntent = ContactsIntentUtils.getSendMessageIntent(r10);
        this.mStarIntent = r14;
        goto L33
    L16:
        r5 = false;
        goto L17
    L9:
        r13 = Integer.valueOf(r12).intValue();
    L33:
        if (this.mIntent != null) goto L35;
        Intent r15 = new Intent("android.intent.action.VIEW");
        this.mIntent = r15;
        r15.setDataAndType(this.mDataUri, r8);
    L35:
        this.mIntent.setFlags(335544320);
        return;
    L22:
        if ("vnd.android.cursor.item/photo".equals(r8) == false) goto L30;
        if (r9 != 0) goto L27;
        this.mIntent = ContactsIntentUtils.getTakePickIntent(new File(ContactEditorFragment.getPhotoFileName(r7)));
        this.mData = String.valueOf(R.string.take_photo);
        goto L33
    L27:
        if (r9 != 1) goto L33;
        this.mIntent = ContactsIntentUtils.getPhotoPickIntent();
        this.mData = String.valueOf(R.string.pick_photo);
        goto L33
    L30:
        if ("vnd.android.cursor.item/group_membership".equals(r8) == false) goto L33;
        this.mRawGroupId = getAsInt(r11, "data1");
        goto L33
    }

    private static String getAsString(Cursor r0, String r1) {
        if (r0 != null) goto L4;
        return "";
    L4:
        return r0.getString(r0.getColumnIndex(r1));
    }

    private static int getAsInt(Cursor r0, String r1) {
        return r0.getInt(r0.getColumnIndex(r1));
    }

    private boolean isProtocolValid(Cursor r3) {
        int r2 = r3.getColumnIndex("data5");
        if (r3.isNull(r2) == false) goto L9;
        return false;
    L9:
        Integer.valueOf(r3.getString(r2));     // Catch: NumberFormatException -> L8
        return true;
    L8:
        return false;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public CharSequence getBody() {
        return this.mBody;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public String getMimeType() {
        return this.mMimeType;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public String getData() {
        return this.mData;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Uri getDataUri() {
        return this.mDataUri;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public long getDataId() {
        return this.mDataId;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public long getRawGroupId() {
        return this.mRawGroupId;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Intent getIntent() {
        return this.mIntent;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Intent getAlternateIntent() {
        return this.mAlternateIntent;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Intent getStarIntent() {
        return this.mStarIntent;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Boolean isStarred() {
        return Boolean.valueOf(this.mIsStarred);
    }

    /* JADX INFO: renamed from: collapseWith, reason: avoid collision after fix types in other method */
    public boolean collapseWith2(Action r1) {
        if (shouldCollapseWith2(r1) == true) goto L6;
        return false;
    L6:
        return true;
    }

    /* JADX INFO: renamed from: shouldCollapseWith, reason: avoid collision after fix types in other method */
    public boolean shouldCollapseWith2(Action r6) {
        if (r6 != null) goto L6;
        return false;
    L6:
        if ((r6 instanceof DataAction) == true) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("DataAction", "t must be DataAction");
        return false;
    L9:
        DataAction r7 = (DataAction) r6;
        if (ContactsUtils.shouldCollapse(this.mMimeType, this.mBody, r7.mMimeType, r7.mBody) == true) goto L13;
        return false;
    L13:
        if (TextUtils.equals(this.mMimeType, r7.mMimeType) == true) goto L15;
    L19:
        return false;
    L15:
        if (ContactsIntentUtils.areIntentActionEqual(this.mIntent, r7.mIntent) == false) goto L19;
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.mMimeType);
        r3.writeValue(Boolean.valueOf(this.mIsStarred));
        r3.writeValue(this.mBody);
        r3.writeValue(this.mSubtitle);
        r3.writeValue(this.mIntent);
        r3.writeValue(this.mAlternateIntent);
        r3.writeValue(this.mStarIntent);
        r3.writeValue(this.mDataUri);
        r3.writeLong(this.mDataId);
        r3.writeLong(this.mRawGroupId);
        r3.writeString(this.mData);
    }
}
