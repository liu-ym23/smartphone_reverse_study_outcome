package com.android.contacts.quickcontact;

import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.WebAddress;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.common.CallUtil;
import com.android.contacts.common.ContactsUtils;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.common.model.dataitem.DataItem;
import com.android.contacts.common.model.dataitem.DataKind;
import com.android.contacts.common.model.dataitem.EmailDataItem;
import com.android.contacts.common.model.dataitem.ImDataItem;
import com.android.contacts.common.model.dataitem.PhoneDataItem;
import com.android.contacts.common.model.dataitem.SipAddressDataItem;
import com.android.contacts.common.model.dataitem.StructuredPostalDataItem;
import com.android.contacts.common.model.dataitem.WebsiteDataItem;
import com.android.contacts.util.Constants;
import com.android.contacts.util.PhoneCapabilityTester;
import com.android.contacts.util.StructuredPostalUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class DataAction implements Action {
    private static final String TAG = "DataAction";
    private int mAlternateIconDescriptionRes;
    private int mAlternateIconRes;
    private Intent mAlternateIntent;
    private CharSequence mBody;
    private final Context mContext;
    private long mDataId;
    private Uri mDataUri;
    private Intent mIntent;
    private boolean mIsPrimary;
    private final DataKind mKind;
    private final String mMimeType;
    private int mPresence;
    private CharSequence mSubtitle;

    /* JADX INFO: renamed from: collapseWith, reason: avoid collision after fix types in other method */
    public boolean collapseWith2(Action r1) {
        return true;
    }

    @Override // com.android.contacts.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean collapseWith(Action r1) {
        return collapseWith2(r1);
    }

    @Override // com.android.contacts.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean shouldCollapseWith(Action r1) {
        return shouldCollapseWith2(r1);
    }

    public DataAction(Context r11, DataItem r12, DataKind r13) {
        this.mPresence = -1;
        this.mContext = r11;
        this.mKind = r13;
        this.mMimeType = r12.getMimeType();
        this.mSubtitle = "";
        if (r12.hasKindTypeColumn(r13) == false) goto L13;
        int r1 = r12.getKindTypeColumn(r13);
        Iterator<AccountType.EditType> r2 = r13.typeList.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        AccountType.EditType r3 = r2.next();
        if (r3.rawValue != r1) goto L6;
        if (r3.customColumn != null) goto L12;
        this.mSubtitle = r11.getString(r3.labelRes);
        goto L13
    L12:
        this.mSubtitle = r12.getContentValues().getAsString(r3.customColumn);
    L13:
        this.mIsPrimary = r12.isSuperPrimary();
        this.mBody = r12.buildDataStringForDisplay(r11, r13);
        this.mDataId = r12.getId();
        this.mDataUri = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, this.mDataId);
        boolean r4 = PhoneCapabilityTester.isPhone(this.mContext);
        ComponentName r5 = PhoneCapabilityTester.getSmsComponent(this.mContext);
        boolean r6 = false;
        if (r5 == null) goto L16;
        boolean r7 = true;
    L17:
        Intent r9 = null;
        if ((r12 instanceof PhoneDataItem) == false) goto L36;
        if (PhoneCapabilityTester.isPhone(this.mContext) == false) goto L90;
        String r14 = ((PhoneDataItem) r12).getNumber();
        if (TextUtils.isEmpty(r14) == true) goto L90;
        if (r4 == false) goto L25;
        Intent r0 = CallUtil.getCallIntent(r14);
    L26:
        if (r7 == false) goto L28;
        Intent r8 = new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", r14, null));
        r8.setComponent(r5);
        r9 = r8;
    L28:
        if (r4 == false) goto L31;
        if (r7 == false) goto L31;
        this.mIntent = r0;
        this.mAlternateIntent = r9;
        this.mAlternateIconRes = r13.iconAltRes;
        this.mAlternateIconDescriptionRes = r13.iconAltDescriptionRes;
    L31:
        if (r4 == false) goto L33;
        this.mIntent = r0;
        goto L90
    L33:
        if (r7 == false) goto L90;
        this.mIntent = r9;
        goto L90
    L25:
        r0 = null;
    L90:
        if (this.mIntent != null) goto L92;
        Intent r15 = new Intent("android.intent.action.VIEW");
        this.mIntent = r15;
        r15.setDataAndType(this.mDataUri, r12.getMimeType());
    L92:
        this.mIntent.addFlags(524288);
        return;
    L36:
        if ((r12 instanceof SipAddressDataItem) == false) goto L43;
        if (PhoneCapabilityTester.isSipPhone(this.mContext) == false) goto L90;
        String r16 = ((SipAddressDataItem) r12).getSipAddress();
        if (TextUtils.isEmpty(r16) == true) goto L90;
        this.mIntent = CallUtil.getCallIntent(Uri.fromParts(Constants.SCHEME_SIP, r16, null));
        goto L90
    L43:
        if ((r12 instanceof EmailDataItem) == false) goto L48;
        String r17 = ((EmailDataItem) r12).getData();
        if (TextUtils.isEmpty(r17) == true) goto L90;
        this.mIntent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", r17, null));
        goto L90
    L48:
        if ((r12 instanceof WebsiteDataItem) == false) goto L53;
        String r18 = ((WebsiteDataItem) r12).getUrl();
        if (TextUtils.isEmpty(r18) == true) goto L90;
        this.mIntent = new Intent("android.intent.action.VIEW", Uri.parse(new WebAddress(r18).toString()));
        goto L90
    L53:
        if ((r12 instanceof ImDataItem) == false) goto L85;
        ImDataItem r19 = (ImDataItem) r12;
        boolean r10 = r19.isCreatedFromEmail();
        if (r10 == true) goto L59;
        if (r19.isProtocolValid() == false) goto L90;
    L59:
        if (r10 == false) goto L61;
        int r20 = 5;
    L62:
        if (r10 == false) goto L64;
        this.mSubtitle = ContactsContract.CommonDataKinds.Im.getProtocolLabel(r11.getResources(), 5, null);
        this.mDataUri = null;
    L64:
        String r110 = r19.getCustomProtocol();
        String r21 = r19.getData();
        if (r20 == (-1)) goto L68;
        r110 = ContactsUtils.lookupProviderNameFromId(r20);
    L68:
        if (TextUtils.isEmpty(r110) == true) goto L90;
        if (TextUtils.isEmpty(r21) == true) goto L90;
        this.mIntent = new Intent("android.intent.action.SENDTO", new Uri.Builder().scheme("imto").authority(r110.toLowerCase()).appendPath(r21).build());
        int r111 = r19.getChatCapability();
        if ((r111 & 4) == 0) goto L74;
        boolean r112 = true;
    L76:
        if ((r111 & 1) == 0) goto L78;
        r6 = true;
    L78:
        if (r112 == true) goto L80;
        if (r6 == false) goto L90;
    L80:
        this.mAlternateIntent = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r21 + "?call"));
        if (r112 == false) goto L83;
        this.mAlternateIconRes = R.drawable.sym_action_videochat_holo_light;
        this.mAlternateIconDescriptionRes = R.string.video_chat;
        goto L90
    L83:
        this.mAlternateIconRes = R.drawable.sym_action_audiochat_holo_light;
        this.mAlternateIconDescriptionRes = R.string.audio_chat;
        goto L90
    L74:
        r112 = false;
        goto L76
    L61:
        r20 = r19.getProtocol().intValue();
        goto L62
    L85:
        if ((r12 instanceof StructuredPostalDataItem) == false) goto L90;
        String r113 = ((StructuredPostalDataItem) r12).getFormattedAddress();
        if (TextUtils.isEmpty(r113) == true) goto L90;
        this.mIntent = StructuredPostalUtils.getViewPostalAddressIntent(r113);
        goto L90
    L16:
        r7 = false;
        goto L17
    }

    @Override // com.android.contacts.quickcontact.Action
    public int getPresence() {
        return this.mPresence;
    }

    public void setPresence(int r1) {
        this.mPresence = r1;
    }

    @Override // com.android.contacts.quickcontact.Action
    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    @Override // com.android.contacts.quickcontact.Action
    public CharSequence getBody() {
        return this.mBody;
    }

    @Override // com.android.contacts.quickcontact.Action
    public String getMimeType() {
        return this.mMimeType;
    }

    @Override // com.android.contacts.quickcontact.Action
    public Uri getDataUri() {
        return this.mDataUri;
    }

    @Override // com.android.contacts.quickcontact.Action
    public long getDataId() {
        return this.mDataId;
    }

    @Override // com.android.contacts.quickcontact.Action
    public Boolean isPrimary() {
        return Boolean.valueOf(this.mIsPrimary);
    }

    @Override // com.android.contacts.quickcontact.Action
    public Drawable getAlternateIcon() {
        if (this.mAlternateIconRes != 0) goto L5;
        return null;
    L5:
        String r0 = this.mKind.resourcePackageName;
        if (r0 != null) goto L10;
        return this.mContext.getResources().getDrawable(this.mAlternateIconRes);
    L10:
        return this.mContext.getPackageManager().getDrawable(r0, this.mAlternateIconRes, null);
    }

    @Override // com.android.contacts.quickcontact.Action
    public String getAlternateIconDescription() {
        if (this.mAlternateIconDescriptionRes != 0) goto L7;
        return null;
    L7:
        return this.mContext.getResources().getString(this.mAlternateIconDescriptionRes);
    }

    @Override // com.android.contacts.quickcontact.Action
    public Intent getIntent() {
        return this.mIntent;
    }

    @Override // com.android.contacts.quickcontact.Action
    public Intent getAlternateIntent() {
        return this.mAlternateIntent;
    }

    /* JADX INFO: renamed from: shouldCollapseWith, reason: avoid collision after fix types in other method */
    public boolean shouldCollapseWith2(Action r6) {
        if (r6 != null) goto L6;
        return false;
    L6:
        if ((r6 instanceof DataAction) == true) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "t must be DataAction");
        return false;
    L9:
        DataAction r7 = (DataAction) r6;
        if (MoreContactUtils.shouldCollapse(this.mMimeType, this.mBody, r7.mMimeType, r7.mBody) == true) goto L13;
        return false;
    L13:
        if (TextUtils.equals(this.mMimeType, r7.mMimeType) == true) goto L15;
    L19:
        return false;
    L15:
        if (ContactsUtils.areIntentActionEqual(this.mIntent, r7.mIntent) == false) goto L19;
        return true;
    }
}
