package com.android.contacts.detail;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Entity;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.net.WebAddress;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.GlobalProxyLancet;
import com.android.contacts.Collapser;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.GroupMetaData;
import com.android.contacts.R;
import com.android.contacts.activities.GroupListActivity;
import com.android.contacts.common.model.dataitem.GenderDataItem;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.lunar.LunarCalendar;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.CamCardSearchParam;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.DataStatus;
import com.android.contacts.util.DateUtils;
import com.android.contacts.util.MemoryCardUtil;
import com.android.contacts.util.NameSortComparator;
import com.android.contacts.util.PhoneCapabilityTester;
import com.android.contacts.util.StructuredPostalUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import obric.api.IntentSmt;

/* JADX INFO: loaded from: classes.dex */
public class ContactDetailBuildEntryTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "ContactDetailBuildEntryTask";
    private static final boolean isDebug = false;
    private final Function1<ContactDetailBuildEntryTask, Void> mCallback;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mCamCardCompanyEntries;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mCardIdEntries;
    private final ContactLoader.Result mContactData;
    private final Activity mContext;
    private final Set<String> mCurrentPhoneNumber;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mEmailEntries;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mEventEntries;
    private final HashSet<String> mFavoriteNumberList;
    private final ContactDetailFragment mFragment;
    private final boolean mFreeCallAvailable;
    private final ArrayList<String> mFreeCallNumberList;
    private boolean mFromBCR;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mGenderEntries;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mGroupEntries;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mImEntries;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mNicknameEntries;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mNoteEntries;
    private final Map<AccountType, List<ContactDetailFragment.DetailViewEntry>> mOtherEntriesMap;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mPhoneEntries;
    private final ArrayList<String> mPhoneNumberList;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mPostalEntries;
    private Uri mPrimaryPhoneUri;
    private final ArrayList<Long> mRawContactIds;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mRelationEntries;
    private final LongSparseArray<Long> mRowContactIdMap;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mSipEntries;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mSmsEntries;
    private final ArrayList<ContactDetailFragment.DetailViewEntry> mWebsiteEntries;

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
        return doInBackground2(r1);
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
        onPostExecute2(r1);
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onProgressUpdate(Void[] r1) {
        onProgressUpdate2(r1);
    }

    static {
        isDebug = ContactsUtils.DEBUG;
    }

    public ContactDetailBuildEntryTask(Activity r2, ContactDetailFragment r3, ContactLoader.Result r4, boolean r5, Function1<ContactDetailBuildEntryTask, Void> r6) {
        this.mRawContactIds = new ArrayList();
        this.mPhoneEntries = new ArrayList();
        this.mSmsEntries = new ArrayList();
        this.mEmailEntries = new ArrayList();
        this.mPostalEntries = new ArrayList();
        this.mImEntries = new ArrayList();
        this.mNicknameEntries = new ArrayList();
        this.mGroupEntries = new ArrayList();
        this.mRelationEntries = new ArrayList();
        this.mNoteEntries = new ArrayList();
        this.mCamCardCompanyEntries = new ArrayList();
        this.mWebsiteEntries = new ArrayList();
        this.mSipEntries = new ArrayList();
        this.mEventEntries = new ArrayList();
        this.mGenderEntries = new ArrayList();
        this.mCardIdEntries = new ArrayList();
        this.mOtherEntriesMap = new HashMap();
        this.mPhoneNumberList = new ArrayList();
        this.mFreeCallNumberList = new ArrayList();
        this.mRowContactIdMap = new LongSparseArray();
        this.mFavoriteNumberList = new HashSet();
        this.mCurrentPhoneNumber = new HashSet();
        this.mPrimaryPhoneUri = null;
        this.mContext = r2;
        this.mFragment = r3;
        this.mContactData = r4;
        this.mFreeCallAvailable = r5;
        this.mCallback = r6;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Void doInBackground2(Void... r2) {
        buildEntries();     // Catch: Exception -> L4
        return null;
    L4:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "buildEntries error, ex=" + e);
        return null;
    }

    /* JADX INFO: renamed from: onProgressUpdate, reason: avoid collision after fix types in other method */
    protected void onProgressUpdate2(Void... r1) {
        super.onProgressUpdate(r1);
        Function1<ContactDetailBuildEntryTask, Void> r2 = this.mCallback;
        if (r2 == null) goto L6;
        r2.invoke(this);
        return;
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(Void r1) {
        super.onPostExecute(r1);
        Function1<ContactDetailBuildEntryTask, Void> r2 = this.mCallback;
        if (r2 == null) goto L6;
        r2.invoke(this);
        return;
    }

    private void buildEntries() {
        this.mPhoneNumberList.clear();
        this.mFreeCallNumberList.clear();
        boolean r1 = PhoneCapabilityTester.isPhone(this.mContext);
        boolean r2 = PhoneCapabilityTester.isSmsIntentRegistered(this.mContext);
        this.mPhoneEntries.clear();
        this.mNoteEntries.clear();
        this.mRawContactIds.clear();
        this.mPrimaryPhoneUri = null;
        this.mFavoriteNumberList.clear();
        AccountTypeManager r4 = AccountTypeManager.getInstance(this.mContext);
        ArrayList<ContactDetailFragment.GroupNameWithID> r5 = new ArrayList();
        CamCardSearchParam r6 = new CamCardSearchParam();
        this.mCurrentPhoneNumber.clear();
        Iterator<Entity> r7 = this.mContactData.getEntities().iterator();
    L3:
        String r9 = "mimetype";
        if (r7.hasNext() == false) goto L237;
        Entity r8 = r7.next();
        if (isCancelled() == true) goto L237;
        ContentValues r11 = r8.getEntityValues();
        String r12 = r11.getAsString("account_type");
        String r13 = r11.getAsString("data_set");
        String r14 = "_id";
        long r15 = r11.getAsLong("_id").longValue();
        if (this.mRawContactIds.contains(Long.valueOf(r15)) == true) goto L11;
        this.mRawContactIds.add(Long.valueOf(r15));
    L11:
        AccountType r3 = r4.getAccountType(r12, r13);
        Iterator<Entity.NamedContentValues> r10 = r8.getSubValues().iterator();
    L13:
        if (r10.hasNext() == false) goto L3;
        ContentValues r16 = r10.next().values;
        r7 = r7;
        r16.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r15));
        long r17 = r16.getAsLong(r14).longValue();
        r10 = r10;
        String r18 = r16.getAsString(r9);
        if (r18 == null) goto L13;
        String r28 = r14;
        String r29 = r9;
        this.mRowContactIdMap.put(r17, Long.valueOf(r15));
        if ("vnd.android.cursor.item/group_membership".equals(r18) == true) goto L19;
        DataKind r19 = r4.getKindOrFallback(r12, r13, r18);
        ArrayList<ContactDetailFragment.GroupNameWithID> r30 = r5;
        AccountType r31 = r3;
        long r32 = r15;
        if (r18.equals("vnd.android.cursor.item/added_time") == true) goto L25;
        if (r19 == null) goto L34;
        ContactDetailFragment.DetailViewEntry r20 = ContactDetailFragment.DetailViewEntry.fromValues(this.mContext, r18, r19, r17, r16, this.mContactData.isDirectoryEntry(), this.mContactData.getDirectoryId());
        boolean r110 = isDebug;
        if (r110 == false) goto L39;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "entry.data : " + r20.data);
    L39:
        boolean r21 = !TextUtils.isEmpty(r20.data);
        Integer r22 = r16.getAsInteger("is_super_primary");
        if (r22 != null) goto L42;
    L44:
        boolean r23 = false;
    L46:
        if ("vnd.android.cursor.item/name".equals(r18) == false) goto L50;
    L47:
        boolean r34 = r1;
    L48:
        r3 = r31;
    L235:
        r14 = r28;
        r9 = r29;
        r5 = r30;
        r15 = r32;
        r1 = r34;
        goto L13
    L50:
        if ("vnd.android.cursor.item/phone_v2".equals(r18) == false) goto L95;
        if (r21 == false) goto L95;
        this.mCurrentPhoneNumber.add(r20.data);
        if ("1".equals(r16.getAsString(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG)) == false) goto L57;
        r20.setStarred(true);
        String r24 = ContactsUtils.formatNumber(r16.getAsString("data1"));
        if (this.mFavoriteNumberList.contains(r24) == true) goto L58;
        this.mFavoriteNumberList.add(r24);
    L58:
        if (r1 == true) goto L60;
        Intent r25 = null;
    L64:
        if (r2 == false) goto L66;
        Intent r26 = ContactsIntentUtils.getSendMessageIntent(r20.data);
    L67:
        if (r1 == false) goto L70;
        if (r2 == false) goto L70;
        r20.intent = r25;
        r20.intent.setPackage(Constants.PHONE_PACKAGE_NAME);
        r20.secondaryIntent = r26;
        r20.secondaryActionIcon = r19.iconAltRes;
        r20.secondaryActionDescription = r19.iconAltDescriptionRes;
    L75:
        if (r23 == false) goto L77;
        this.mPrimaryPhoneUri = r20.uri;
    L77:
        r20.isPrimary = r23;
        this.mPhoneEntries.add(r20);
        if (this.mPhoneNumberList.contains(r20.data) == true) goto L81;
        this.mPhoneNumberList.add(r20.data);
    L81:
        if (this.mFreeCallAvailable == false) goto L90;
        if (TextUtils.isEmpty(r20.data) == true) goto L90;
        if (FreeCallHelper.getMe().isSupportFreeCall(r20.data) == false) goto L90;
        if (this.mFreeCallNumberList.contains(r20.data) == true) goto L90;
        this.mFreeCallNumberList.add(r20.data);
    L90:
        if (TextUtils.isEmpty(r6.getPhone()) == false) goto L93;
        r6.setPhone(r20.data);
    L93:
        if (TextUtils.isEmpty(r16.getAsString(BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME)) == false) goto L47;
        this.mFragment.updateLocationInfo(r16);
    L70:
        if (r1 == false) goto L72;
        r20.intent = r25;
        r20.intent.setPackage(Constants.PHONE_PACKAGE_NAME);
        goto L75
    L72:
        if (r2 == false) goto L74;
        r20.intent = r26;
        goto L75
    L74:
        r20.intent = null;
        goto L75
    L66:
        r26 = null;
        goto L67
    L60:
        if (DSUtils.useDSFeature() == false) goto L62;
        r25 = DSUtils.getCallIntentByDefault(this.mContext, r20.data);
        goto L64
    L62:
        r25 = ContactsIntentUtils.newDialNumberIntent(r20.data);
        goto L64
    L57:
        r20.setStarred(false);
    L95:
        r34 = r1;
        if ("vnd.android.cursor.item/email_v2".equals(r18) == false) goto L105;
        if (r21 == false) goto L105;
        Intent r27 = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", r20.data, null));
        r27.putExtra(IntentSmt.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), new int[]{0, R.anim.slide_down_out});
        r20.intent = r27;
        r20.isPrimary = r23;
        this.mEmailEntries.add(r20);
        DataStatus r33 = this.mContactData.getStatuses().get(Long.valueOf(r20.id));
        if (r33 == null) goto L102;
        ContactDetailFragment.DetailViewEntry r35 = ContactDetailFragment.DetailViewEntry.fromValues(this.mContext, "vnd.android.cursor.item/im", r4.getKindOrFallback(r12, r13, "vnd.android.cursor.item/im"), r17, r16, this.mContactData.isDirectoryEntry(), this.mContactData.getDirectoryId());
        ContactDetailFragment.buildImActions(this.mContext, r35, r16);
        r35.applyStatus(r33, false);
        this.mImEntries.add(r35);
    L102:
        if (TextUtils.isEmpty(r6.getEmail()) == false) goto L48;
        r6.setEmail(r20.data);
    L105:
        if ("vnd.android.cursor.item/postal-address_v2".equals(r18) == false) goto L112;
        if (r21 == false) goto L112;
        r20.maxLines = 2;
        r20.intent = StructuredPostalUtils.getViewPostalAddressIntent(r20.data);
        if (r110 == false) goto L110;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("entry.data", "entry.data:" + r20.data);
    L110:
        this.mPostalEntries.add(r20);
    L112:
        if ("vnd.android.cursor.item/im".equals(r18) == false) goto L119;
        if (r21 == false) goto L119;
        DataStatus r36 = this.mContactData.getStatuses().get(Long.valueOf(r20.id));
        if (r36 == null) goto L117;
        r20.applyStatus(r36, false);
    L117:
        this.mImEntries.add(r20);
    L119:
        if ("vnd.android.cursor.item/organization".equals(r18) == false) goto L126;
        if (TextUtils.isEmpty(r6.getCompany()) == false) goto L48;
        r6.setCompany(r16.getAsString("data1"));
        String r37 = r16.getAsString("data4");
        if (TextUtils.isEmpty(r37) == true) goto L48;
        r6.setJobTitle(r37);
        goto L48
    L126:
        if ("vnd.android.cursor.item/nickname".equals(r18) == false) goto L140;
        if (r21 == false) goto L140;
        if (this.mContactData.getNameRawContactId() != r32) goto L131;
        boolean r38 = true;
    L132:
        if (r38 == true) goto L134;
    L136:
        boolean r111 = false;
    L137:
        if (r111 == true) goto L48;
        r20.uri = null;
        this.mNicknameEntries.add(r20);
        goto L48
    L134:
        if (this.mContactData.getDisplayNameSource() != 35) goto L136;
        r111 = true;
        goto L137
    L131:
        r38 = false;
    L140:
        if ("vnd.android.cursor.item/note".equals(r18) == false) goto L144;
        if (r21 == false) goto L144;
        r20.uri = null;
        r20.maxLines = 100;
        r20.isNote = true;
        this.mNoteEntries.add(r20);
    L144:
        if ("vnd.android.cursor.item/website".equals(r18) == false) goto L152;
        if (r21 == false) goto L152;
        r20.uri = null;
        r20.maxLines = 1;
        r20.intent = new Intent("android.intent.action.VIEW", Uri.parse(new WebAddress(r20.data).toString()));     // Catch: ParseException -> L149
    L150:
        this.mWebsiteEntries.add(r20);
    L149:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Couldn't parse website: " + r20.data);
    L152:
        if ("vnd.android.cursor.item/sip_address".equals(r18) == false) goto L156;
        if (r21 == false) goto L156;
        r20.uri = null;
        r20.maxLines = 1;
        this.mSipEntries.add(r20);
    L156:
        if ("vnd.android.cursor.item/contact_event".equals(r18) == false) goto L170;
        if (r21 == false) goto L170;
        if (4 == r20.type) goto L161;
    L165:
        r20.data = DateUtils.formatDate(this.mContext, r20.data);
    L166:
        r20.uri = null;
        if (r20.typeString.equals("added time") == true) goto L48;
        this.mEventEntries.add(r20);
        goto L48
    L161:
        if (EntityModifier.hasEditTypes(r19) == false) goto L165;
        if (r19.typeList.contains(new AccountType.EditType(r20.type, -1)) == false) goto L165;
        r20.data = LunarCalendar.getLunarDisplayStringFromLunarDateString(r20.data);
    L170:
        if ("vnd.android.cursor.item/relation".equals(r18) == false) goto L174;
        if (r21 == false) goto L174;
        this.mRelationEntries.add(r20);
    L174:
        if ("vnd.android.cursor.item/card_id".equals(r18) == false) goto L188;
        if (r19.actionBody == null) goto L182;
        CharSequence r39 = r19.actionBody.inflateUsing(this.mContext, r16);
        if (r39 != null) goto L180;
        String r40 = null;
    L181:
        r20.data = r40;
        goto L182
    L180:
        r40 = r39.toString();
    L182:
        this.mCardIdEntries.add(r20);
        Long r41 = r16.getAsLong(DBHelper.COL_DATA3);
        int r42 = r16.getAsInteger(DBHelper.COL_DATA2).intValue();
        if (r41 == null) goto L48;
        if (r41.longValue() == (-1)) goto L48;
        r20.secondaryIntent = MemoryCardUtil.getCardInfoIntent(r41, r42);
        goto L48
    L188:
        if ("vnd.android.cursor.item/gender".equals(r18) == false) goto L198;
        if (r21 == false) goto L198;
        if (r19.actionBody == null) goto L195;
        CharSequence r43 = r19.actionBody.inflateUsing(this.mContext, r16);
        if (r43 == null) goto L195;
        int r44 = Integer.parseInt(r43.toString());
        r20.data = this.mContext.getString(GenderDataItem.getTypeLabelResource(r44));
    L196:
        if (r44 == 0) goto L48;
        this.mGenderEntries.add(r20);
    L195:
        r44 = 0;
    L198:
        r20.intent = new Intent("android.intent.action.VIEW");
        r20.intent.setDataAndType(r20.uri, r20.mimetype);
        if (r19.actionBody == null) goto L205;
        CharSequence r45 = r19.actionBody.inflateUsing(this.mContext, r16);
        if (r45 != null) goto L203;
        String r46 = null;
    L204:
        r20.data = r46;
        goto L205
    L203:
        r46 = r45.toString();
    L205:
        if (r18 != null) goto L207;
    L209:
        if (r18 == null) goto L214;
        if (r18.startsWith(ContactsUtils.QQ_MIMETYPE) == false) goto L214;
        r20.typeString = ContactsContract.CommonDataKinds.Im.getProtocolLabel(this.mContext.getResources(), 4, null).toString();
    L214:
        if (r18 == null) goto L216;
        r18.startsWith(ContactsUtils.WHATSAPP_MINTYPE);
    L216:
        if (r18 != null) goto L218;
    L220:
        if (r18 != null) goto L222;
    L224:
        if (r18 != null) goto L226;
    L229:
        if (TextUtils.isEmpty(r20.data) == true) goto L234;
        r3 = r31;
        if (this.mOtherEntriesMap.containsKey(r3) == false) goto L233;
        this.mOtherEntriesMap.get(r3).add(r20);
        goto L235
    L233:
        ArrayList r47 = new ArrayList();
        r47.add(r20);
        this.mOtherEntriesMap.put(r3, r47);
        goto L235
    L234:
        r3 = r31;
        goto L235
    L226:
        if (r18.startsWith(ContactsUtils.WHATSAPP_MINTYPE_VIDEO_CALL) == false) goto L229;
        r20.data = this.mContext.getString(R.string.common_start_video_call);
        goto L229
    L222:
        if (r18.startsWith(ContactsUtils.WHATSAPP_MINTYPE_VOIP_CALL) == false) goto L224;
        r20.data = this.mContext.getString(R.string.whatsapp_voip_call);
        goto L229
    L218:
        if (r18.startsWith(ContactsUtils.WHATSAPP_MINTYPE_PROFILE) == false) goto L220;
        r20.data = this.mContext.getString(R.string.whatsapp_message);
        goto L229
    L207:
        if (r18.startsWith(ContactsUtils.WECHAT_MIMETYPE_PREFIX) == false) goto L209;
        r20.typeString = ContactsContract.CommonDataKinds.Im.getProtocolLabel(this.mContext.getResources(), 100, null).toString();
        goto L209
    L42:
        if (r22.intValue() == 0) goto L44;
        r23 = true;
    L34:
        r14 = r28;
        r9 = r29;
        r5 = r30;
        r3 = r31;
        r15 = r32;
        goto L13
    L25:
        String r48 = r16.getAsString("data4");
        if (TextUtils.isEmpty(r48) == false) goto L28;
    L30:
        int r49 = 0;
    L31:
        if (r49 != 1) goto L34;
        this.mFromBCR = true;
        goto L34
    L28:
        if (TextUtils.isDigitsOnly(r48) == false) goto L30;
        r49 = Integer.parseInt(r48);
        goto L31
    L19:
        Long r50 = r16.getAsLong("data1");
        if (r50 == null) goto L22;
        handleGroupMembership(r5, this.mContactData.getGroupMetaData(), r50.longValue());
    L22:
        r14 = r28;
        r9 = r29;
    L237:
        ArrayList<ContactDetailFragment.GroupNameWithID> r310 = r5;
        String r210 = "mimetype";
        if (r310.isEmpty() == true) goto L249;
        Collections.sort(r310, new NameSortComparator());
        int r51 = r310.size();
        ArrayList r52 = new ArrayList();
        int r53 = 0;
    L240:
        if (r53 >= r51) goto L249;
        ContactDetailFragment.DetailViewEntry r54 = new ContactDetailFragment.DetailViewEntry();
        String r55 = r210;
        r54.mimetype = r55;
        if (r53 != 0) goto L244;
        r54.typeString = this.mContext.getString(R.string.common_groups);
    L244:
        r54.kind = this.mContext.getString(R.string.common_groups);
        ContactDetailFragment.GroupNameWithID r56 = r310.get(r53);
        if (r56 == null) goto L248;
        r54.data = r56.gname;
        r54.maxLines = 10;
        r52.add(r54.data);
        Intent r57 = new Intent(this.mContext, GroupListActivity.class);
        r57.putExtra(GroupListActivity.EXTAR_GROUP_LIST, r52);
        r54.intent = r57;
        this.mGroupEntries.add(r54);
    L248:
        r53 = r53 + 1;
        r210 = r55;
    L249:
        publishProgress(new Void[0]);
        Collapser.collapseList(this.mPhoneEntries);
        Collapser.collapseList(this.mSmsEntries);
        Collapser.collapseList(this.mEmailEntries);
        Collapser.collapseList(this.mPostalEntries);
        Collapser.collapseList(this.mImEntries);
        Collapser.collapseList(this.mNicknameEntries);
        Collapser.collapseList(this.mWebsiteEntries);
        Collapser.collapseList(this.mRelationEntries);
        Collapser.collapseList(this.mEventEntries);
        Collapser.collapseList(this.mSipEntries);
        Collapser.collapseList(this.mGenderEntries);
        Collapser.collapseList(this.mCardIdEntries);
    }

    private void handleGroupMembership(ArrayList<ContactDetailFragment.GroupNameWithID> r4, List<GroupMetaData> r5, long r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        ArrayList r3 = new ArrayList();
        Iterator<ContactDetailFragment.GroupNameWithID> r0 = r4.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r3.add(r0.next().gname);
        goto L6
    L8:
        Iterator<GroupMetaData> r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L31;
        GroupMetaData r1 = r7.next();
        if (r1.getGroupId() != r6) goto L10;
        if (r1.isDefaultGroup() == false) goto L16;
        return;
    L16:
        if (r1.isFavorites() == true) goto L28;
        String r8 = r1.getTitle();
        if (TextUtils.isEmpty(r8) == false) goto L20;
        return;
    L20:
        if (r3.contains(r8) == true) goto L30;
        r4.add(new ContactDetailFragment.GroupNameWithID(r6, r8));
        return;
    L30:
        return;
    L28:
        return;
    }

    private void addCamCardViewEntry(CamCardSearchParam r4) {
        if (TextUtils.isEmpty(r4.getCompany()) == true) goto L11;
        ContactLoader.Result r0 = this.mContactData;
        if (r0 == null) goto L9;
        String r1 = r0.getDisplayName();
        if (TextUtils.isEmpty(r1) == true) goto L9;
        r4.setName(r1);
    L9:
        ContactDetailFragment.DetailViewEntry r2 = new ContactDetailFragment.DetailViewEntry();
        r2.mimetype = ContactsUtils.CAM_CARD_COMPANY_MIMETYPE;
        r2.kind = this.mContext.getString(R.string.common_company);
        r2.typeString = this.mContext.getString(R.string.common_company);
        r2.data = r4.getCompany();
        r2.intent = new Intent(ContactsUtils.CAM_CARD_COMPANY_ACTION);
        r2.intent.putExtra(ContactsUtils.CAM_CARD_COMPANY_PARAM, r4);
        r2.maxLines = 2;
        this.mCamCardCompanyEntries.add(r2);
        return;
    }

    public ArrayList<Long> getRawContactIds() {
        return this.mRawContactIds;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getPhoneEntries() {
        return this.mPhoneEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getSmsEntries() {
        return this.mSmsEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getEmailEntries() {
        return this.mEmailEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getPostalEntries() {
        return this.mPostalEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getImEntries() {
        return this.mImEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getNicknameEntries() {
        return this.mNicknameEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getGroupEntries() {
        return this.mGroupEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getRelationEntries() {
        return this.mRelationEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getNoteEntries() {
        return this.mNoteEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getCamCardCompanyEntries() {
        return this.mCamCardCompanyEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getWebsiteEntries() {
        return this.mWebsiteEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getSipEntries() {
        return this.mSipEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getEventEntries() {
        return this.mEventEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getGenderEntries() {
        return this.mGenderEntries;
    }

    public ArrayList<ContactDetailFragment.DetailViewEntry> getCardIdEntries() {
        return this.mCardIdEntries;
    }

    public Map<AccountType, List<ContactDetailFragment.DetailViewEntry>> getOtherEntriesMap() {
        return this.mOtherEntriesMap;
    }

    public ArrayList<String> getPhoneNumberList() {
        return this.mPhoneNumberList;
    }

    public ArrayList<String> getFreeCallNumberList() {
        return this.mFreeCallNumberList;
    }

    public LongSparseArray<Long> getRowContactIdMap() {
        return this.mRowContactIdMap;
    }

    public HashSet<String> getFavoriteNumberList() {
        return this.mFavoriteNumberList;
    }

    public Set<String> getCurrentPhoneNumber() {
        return this.mCurrentPhoneNumber;
    }

    public Uri getPrimaryPhoneUri() {
        return this.mPrimaryPhoneUri;
    }

    public boolean isFromBCR() {
        return this.mFromBCR;
    }
}
