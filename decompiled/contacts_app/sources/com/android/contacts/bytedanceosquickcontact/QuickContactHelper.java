package com.android.contacts.bytedanceosquickcontact;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Toast;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.NotifyingAsyncQueryHandler;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.oui.button.OButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class QuickContactHelper implements View.OnClickListener {
    private static final int HANDLER_ID_DATA = 1;
    private String mAccountName;
    private String mAccountType;
    private ActionMultiMap mActions;
    private int[] mBackgroundButtonIds;
    private List<View.OnClickListener> mBackgroundButtonListeners;
    private long mContactId;
    private Context mContext;
    private long mDataId;
    private Uri mDataUri;
    private HashMap<String, Action> mDefaultsMap;
    private ArrayList<Action> mFavoriteActions;
    private NotifyingAsyncQueryHandler mHandler;
    private boolean mIsAddedTimeContact;
    private boolean mIsInitViews;
    private boolean mIsProfile;
    private Uri mLookupUri;
    private ArrayList<Action> mPhoneActions;
    private ContactPhotoManager mPhotoManager;
    private Set<Long> mPreferDataIds;
    private final NotifyingAsyncQueryHandler.AsyncQueryListener mQueryListener;
    private QuickContactChildLayout mQuickContactChildLayout;
    private QuickContactHandle mQuickContactHandle;
    private QuickContactListener mQuickContactListener;
    private long mRawContactId;
    private String mTrackerTag;
    private ArrayList<Action> mUnFavoriteActions;

    public interface DataQuery {
        public static final int ACCOUNT_NAME = 17;
        public static final int ACCOUNT_TYPE = 1;
        public static final int CHAT_CAPABILITY = 11;
        public static final int CONTACT_ID = 18;
        public static final int DATA_SET = 2;
        public static final int DISPLAY_NAME = 4;
        public static final int IS_PRIMARY = 14;
        public static final int IS_SUPER_PRIMARY = 15;
        public static final int MIMETYPE = 13;
        public static final int PRESENCE = 10;
        public static final String[] PROJECTION = null;
        public static final int RAW_CONTACT_ID = 16;
        public static final int RES_PACKAGE = 12;
        public static final int STARRED = 3;
        public static final int STATUS = 5;
        public static final int STATUS_ICON = 7;
        public static final int STATUS_LABEL = 8;
        public static final int STATUS_RES_PACKAGE = 6;
        public static final int STATUS_TIMESTAMP = 9;
        public static final int _ID = 0;

        static {
            PROJECTION = new String[]{"_id", "account_type", "data_set", ContactSaveService.EXTRA_STARRED_FLAG, "display_name", "status", "status_res_package", "status_icon", "status_label", "status_ts", "mode", "chat_capability", "res_package", "mimetype", "is_primary", "is_super_primary", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "account_name", "contact_id", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME, BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN, "data14", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG};
        }
    }

    private boolean isPhoneAction(int r1) {
        if (r1 != R.id.umb_phone) goto L5;
    L14:
        return true;
    L5:
        if (r1 == R.id.umb_phone_1) goto L14;
        if (r1 == R.id.umb_phone_2) goto L14;
        if (r1 == R.id.umb_message) goto L14;
        if (r1 == R.id.umb_star) goto L14;
        return false;
    }

    static /* synthetic */ void access$000(QuickContactHelper r0, Cursor r1) {
        r0.bindCursor(r1);
    }

    static /* synthetic */ void access$100(QuickContactHelper r0) {
        r0.initPhotoData();
    }

    static /* synthetic */ boolean access$1000(QuickContactHelper r0) {
        return r0.mIsProfile;
    }

    static /* synthetic */ int access$1100(QuickContactHelper r0, ArrayList r1, ArrayList r2) {
        return r0.getRawContacts(r1, r2);
    }

    static /* synthetic */ long access$1200(QuickContactHelper r2) {
        return r2.mRawContactId;
    }

    static /* synthetic */ String access$1300(QuickContactHelper r0) {
        return r0.mAccountName;
    }

    static /* synthetic */ String access$1400(QuickContactHelper r0) {
        return r0.mAccountType;
    }

    static /* synthetic */ void access$1500(QuickContactHelper r0, long r1, String r3, String r4, String r5) {
        r0.selectGroup(r1, r3, r4, r5);
    }

    static /* synthetic */ Context access$1600(QuickContactHelper r0) {
        return r0.mContext;
    }

    static /* synthetic */ ArrayList access$200(QuickContactHelper r0) {
        return r0.mPhoneActions;
    }

    static /* synthetic */ ArrayList access$202(QuickContactHelper r0, ArrayList r1) {
        r0.mPhoneActions = r1;
        return r1;
    }

    static /* synthetic */ ActionMultiMap access$300(QuickContactHelper r0) {
        return r0.mActions;
    }

    static /* synthetic */ ArrayList access$400(QuickContactHelper r0, ArrayList r1) {
        return r0.getPhoneList(r1);
    }

    static /* synthetic */ void access$500(QuickContactHelper r0, boolean r1) {
        r0.setFavoriteChecked(r1);
    }

    static /* synthetic */ long access$600(QuickContactHelper r2) {
        return r2.mDataId;
    }

    static /* synthetic */ long access$700(QuickContactHelper r2) {
        return r2.mContactId;
    }

    static /* synthetic */ QuickContactListener access$800(QuickContactHelper r0) {
        return r0.mQuickContactListener;
    }

    static /* synthetic */ boolean access$900(QuickContactHelper r0) {
        return r0.mIsAddedTimeContact;
    }

    public QuickContactHelper(Context r3, QuickContactChildLayout r4, ContactPhotoManager r5, QuickContactListener r6, long r7, String r9, boolean r10) {
        this.mIsInitViews = false;
        this.mDataId = -1;
        this.mDataUri = null;
        this.mIsAddedTimeContact = false;
        this.mDefaultsMap = new HashMap();
        this.mActions = new ActionMultiMap();
        this.mBackgroundButtonIds = new int[]{R.id.umb_phone, R.id.umb_phone_1, R.id.umb_phone_2, R.id.umb_message, R.id.umb_star, R.id.umb_group, R.id.umb_avatar};
        this.mBackgroundButtonListeners = new ArrayList(7);
        this.mQueryListener = new AnonymousClass1(this);
        init(r3, r4, r5, r6, r7);
        if (this.mIsProfile == true) goto L5;
        Uri r8 = ContactsContract.Contacts.getLookupUri(r7, r9);
    L6:
        this.mLookupUri = r8;
        return;
    L5:
        r8 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), r7);
        goto L6
    }

    public QuickContactHelper(Context r3, QuickContactChildLayout r4, ContactPhotoManager r5, QuickContactListener r6, long r7, Uri r9, boolean r10, boolean r11) {
        this.mIsInitViews = false;
        this.mDataId = -1;
        this.mDataUri = null;
        this.mIsAddedTimeContact = false;
        this.mDefaultsMap = new HashMap();
        this.mActions = new ActionMultiMap();
        this.mBackgroundButtonIds = new int[]{R.id.umb_phone, R.id.umb_phone_1, R.id.umb_phone_2, R.id.umb_message, R.id.umb_star, R.id.umb_group, R.id.umb_avatar};
        this.mBackgroundButtonListeners = new ArrayList(7);
        this.mQueryListener = new AnonymousClass1(this);
        init(r3, r4, r5, r6, r7);
        this.mLookupUri = r9;
    }

    public QuickContactHelper(QuickContactHelper r9, Context r10, QuickContactChildLayout r11, ContactPhotoManager r12, QuickContactListener r13, long r14, String r16, boolean r17) {
        this.mIsInitViews = false;
        this.mDataId = -1;
        this.mDataUri = null;
        this.mIsAddedTimeContact = false;
        this.mDefaultsMap = new HashMap();
        this.mActions = new ActionMultiMap();
        this.mBackgroundButtonIds = new int[]{R.id.umb_phone, R.id.umb_phone_1, R.id.umb_phone_2, R.id.umb_message, R.id.umb_star, R.id.umb_group, R.id.umb_avatar};
        this.mBackgroundButtonListeners = new ArrayList(7);
        this.mQueryListener = new AnonymousClass1(this);
        this.mPhoneActions = getPhoneList(r9.getPhoneActions());
        this.mUnFavoriteActions = r9.getUnFavoriteActions();
        this.mFavoriteActions = r9.getFavoriteActions();
        this.mActions = r9.getActionMultiMap();
        this.mRawContactId = r9.mRawContactId;
        this.mAccountName = r9.mAccountName;
        this.mAccountType = r9.mAccountType;
        init(r10, r11, r12, r13, r14);
        if (this.mIsProfile == true) goto L5;
        Uri r0 = ContactsContract.Contacts.getLookupUri(r14, r16);
    L6:
        this.mLookupUri = r0;
        showCache();
        return;
    L5:
        r0 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), r14);
        goto L6
    }

    public QuickContactHelper(QuickContactHelper r9, Activity r10, QuickContactChildLayout r11, ContactPhotoManager r12, QuickContactListener r13, long r14, Uri r16, boolean r17, boolean r18) {
        this.mIsInitViews = false;
        this.mDataId = -1;
        this.mDataUri = null;
        this.mIsAddedTimeContact = false;
        this.mDefaultsMap = new HashMap();
        this.mActions = new ActionMultiMap();
        this.mBackgroundButtonIds = new int[]{R.id.umb_phone, R.id.umb_phone_1, R.id.umb_phone_2, R.id.umb_message, R.id.umb_star, R.id.umb_group, R.id.umb_avatar};
        this.mBackgroundButtonListeners = new ArrayList(7);
        this.mQueryListener = new AnonymousClass1(this);
        this.mPhoneActions = getPhoneList(r9.getPhoneActions());
        this.mUnFavoriteActions = r9.getUnFavoriteActions();
        this.mFavoriteActions = r9.getFavoriteActions();
        this.mActions = r9.getActionMultiMap();
        this.mRawContactId = r9.mRawContactId;
        this.mAccountName = r9.mAccountName;
        this.mAccountType = r9.mAccountType;
        init(r10, r11, r12, r13, r14);
        this.mLookupUri = r16;
        showCache();
    }

    public void init(Context r4, QuickContactChildLayout r5, ContactPhotoManager r6, QuickContactListener r7, long r8) {
        this.mContext = r4;
        this.mHandler = new NotifyingAsyncQueryHandler(this.mContext, this.mQueryListener);
        this.mPhotoManager = r6;
        this.mQuickContactChildLayout = r5;
        this.mQuickContactListener = r7;
        this.mIsProfile = ContactsContract.isProfileId(r8);
        this.mContactId = r8;
        int r9 = 0;
    L4:
        if (r9 >= this.mBackgroundButtonIds.length) goto L6;
        this.mBackgroundButtonListeners.add(this);
        r9 = r9 + 1;
        goto L4
    L6:
        this.mQuickContactHandle = new QuickContactHandle(r4);
    }

    public void setTrackerTag(String r1) {
        this.mTrackerTag = r1;
    }

    public ArrayList<Action> getPhoneActions() {
        return this.mPhoneActions;
    }

    public ArrayList<Action> getUnFavoriteActions() {
        return this.mUnFavoriteActions;
    }

    public ArrayList<Action> getFavoriteActions() {
        return this.mFavoriteActions;
    }

    public ActionMultiMap getActionMultiMap() {
        return this.mActions;
    }

    public void setBackgroundButtonOnClickListener(int r2, View.OnClickListener r3) {
        int r4 = Arrays.binarySearch(this.mBackgroundButtonIds, r2);
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (r4 >= this.mBackgroundButtonIds.length) goto L9;
        this.mBackgroundButtonListeners.set(r4, r3);
        return;
    }

    private ArrayList<Action> getPhoneList(ArrayList<Action> r8) {
        ArrayList<Action> r7 = new ArrayList();
        if (r8 == null) goto L17;
        int r1 = 0;
    L6:
        if (r1 >= r8.size()) goto L17;
        String r2 = r8.get(r1).getData();
        int r3 = r1 + 1;
        boolean r5 = false;
        int r4 = r3;
    L9:
        if (r4 >= r8.size()) goto L14;
        if (PhoneNumberUtils.compare(r2, r8.get(r4).getData()) == false) goto L13;
        r5 = true;
    L13:
        r4 = r4 + 1;
        goto L9
    L14:
        if (r5 == true) goto L16;
        r7.add(r8.get(r1));
    L16:
        r1 = r3;
    L17:
        return r7;
    }

    public void initQuickBtnStar(ArrayList<Action> r5) {
        this.mUnFavoriteActions = new ArrayList();
        this.mFavoriteActions = new ArrayList();
        boolean r0 = false;
        int r1 = 0;
    L4:
        if (r1 >= r5.size()) goto L11;
        Action r2 = r5.get(r1);
        if (r2.isStarred().booleanValue() == false) goto L8;
        this.mFavoriteActions.add(r2);
    L9:
        r1 = r1 + 1;
        goto L4
    L8:
        this.mUnFavoriteActions.add(r2);
        goto L9
    L11:
        if (r5.isEmpty() == false) goto L13;
    L15:
        setFavoriteChecked(r0);
        return;
    L13:
        if (this.mFavoriteActions.size() != r5.size()) goto L15;
        r0 = true;
        goto L15
    }

    private void setFavoriteChecked(boolean r3) {
        OButton r0 = (OButton) ((View) this.mQuickContactChildLayout.getParent().getParent()).findViewById(R.id.umb_star);
        if (r0 == null) goto L8;
        if (r3 == false) goto L6;
        r0.setMIcon(this.mContext.getDrawable(R.drawable.scroll_right_favorite_selected_selector));
        r0.setContentDescription(this.mContext.getResources().getString(R.string.common_remove_from_favorites));
        return;
    L6:
        r0.setMIcon(this.mContext.getDrawable(R.drawable.scroll_right_favorite_selector));
        r0.setContentDescription(this.mContext.getResources().getString(R.string.common_favorites));
        return;
    }

    public void setDataId(long r1) {
        this.mDataId = r1;
    }

    public void setPreferDataIds(Set<Long> r1) {
        this.mPreferDataIds = r1;
    }

    public void setHasAddedTime(boolean r1) {
        this.mIsAddedTimeContact = r1;
    }

    private void initViews() {
        int r0 = 0;
    L4:
        if (r0 >= this.mQuickContactChildLayout.getButtonCount()) goto L6;
        this.mQuickContactChildLayout.getButtonAt(r0).setOnClickListener(this);
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        int r0 = 0;
        int r1 = -1;
        switch(r3.getId()) {
            case 2131363920: goto L28;
            case 2131363924: goto L25;
            case 2131363926: goto L21;
            case 2131363929: goto L17;
            case 2131363930: goto L13;
            case 2131363931: goto L12;
            case 2131363934: goto L6;
            default: goto L35;
        };
    L12:
        r0 = -1;
    L13:
        if ((-1) != r0) goto L15;
        r1 = 1;
        goto L17
    L15:
        r1 = r0;
        goto L17
    L28:
        sendWechatMessage();
        return;
    L35:
        return;
    L6:
        if (this.mQuickContactChildLayout.isAnimationing() == false) goto L9;
        return;
    L9:
        if (this.mIsProfile == false) goto L11;
        Toast.makeText(this.mContext.getApplicationContext(), R.string.unabletostarred, 0).show();
        return;
    L11:
        starClicked();
        return;
    L17:
        if (this.mQuickContactChildLayout.isAnimationing() == false) goto L19;
        return;
    L19:
        this.mQuickContactHandle.placeCallActions(this.mPhoneActions, r1, this.mTrackerTag);
        return;
    L21:
        if (this.mQuickContactChildLayout.isAnimationing() == false) goto L23;
        return;
    L23:
        this.mQuickContactHandle.placeMmsActions(this.mPhoneActions);
        return;
    L25:
        if (this.mQuickContactChildLayout.isAnimationing() == false) goto L27;
        return;
    L27:
        this.mQuickContactChildLayout.post(new AnonymousClass2(this));
    }

    public void starClicked() {
        QuickContactHandle.Callback r0 = new AnonymousClass3(this);
        this.mQuickContactHandle.placeStarActions(this.mPhoneActions, r0);
    }

    private void sendWechatMessage() {
        ArrayList<Action> r0 = this.mActions.get("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() == 0) goto L10;
        this.mQuickContactHandle.placeWechatActions(r0.get(0));
        return;
    }

    private int getRawContacts(ArrayList<String> r13, ArrayList<View.OnClickListener> r14) {
        Cursor r7 = this.mContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id", "account_name", "account_type"}, "contact_id =? AND deleted != 1", new String[]{String.valueOf(this.mContactId)}, null);
        if (r7 != null) goto L13;
        return 0;
    L13:
        int r10 = r7.getCount();     // Catch: Throwable -> L9
        if (r7.moveToFirst() == false) goto L8;
    L6:
        final long r3 = r7.getLong(0);     // Catch: Throwable -> L9
        final String r5 = r7.getString(1);     // Catch: Throwable -> L9
        final String r6 = r7.getString(2);     // Catch: Throwable -> L9
        r13.add(ContactsUtils.getGroupName(this.mContext, r6, r5));     // Catch: Throwable -> L9
        r14.add(new AnonymousClass4(this, r3, r5, r6));     // Catch: Throwable -> L9
        if (r7.moveToNext() == true) goto L6;
    L8:
        r7.close();
        return r10;
    L9:
        th = move-exception;
        r7.close();
        throw th;
    }

    private void selectGroup(long r4, String r6, String r7, String r8) {
        Intent r0 = new Intent(this.mContext, GroupSelectionActivity.class);
        r0.putExtra(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
        r0.putExtra("account_name", r6);
        r0.putExtra("account_type", r7);
        r0.putExtra(GroupSelectionActivity.EXTRA_ACCOUNT_DATA_SET, r8);
        startActivity(r0);
        AnimationUtil.switchActivityAnimation((Activity) this.mContext, 1);
    }

    private synchronized void PhotoClicked() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mQuickContactListener.isShowQuickContact() == false) goto L6;
    L10:
        monitor-exit(this);
        return;
    L6:
        if (this.mQuickContactChildLayout.isAnimationing() == true) goto L10;
        if (this.mLookupUri == null) goto L10;
        show();     // Catch: Throwable -> L12
        goto L10
    }

    private void showCache() {
        QuickContactListener r0 = this.mQuickContactListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowQuickContact() == true) goto L16;
        QuickContactChildLayout r1 = this.mQuickContactChildLayout;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isAnimationing() == true) goto L18;
        ArrayList<Action> r2 = this.mPhoneActions;
        if (r2 == null) goto L13;
        initQuickBtnStar(r2);
    L13:
        this.mQuickContactListener.setQuickContactHelperCache(this);
        return;
    L18:
        return;
    }

    private void startActivity(Intent r2) {
        this.mContext.startActivity(r2);
        AnimationUtil.switchActivityAnimation((Activity) this.mContext, 1);
    }

    private void show() {
        if (this.mIsProfile == false) goto L5;
        this.mDataUri = Uri.withAppendedPath(ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), this.mContactId), "data");
    L6:
        this.mHandler.cancelOperation(1);
        long r2 = this.mDataId;
        if (r2 == (-1)) goto L9;
        String[] r8 = {String.valueOf(r2), "vnd.android.cursor.item/group_membership", "vnd.android.cursor.item/name", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile"};
        String r7 = "_id =? OR mimetype =? OR mimetype =? OR mimetype =? ";
    L10:
        Cursor r0 = ContactDetailCacheManager.getInstance().getSubCursorForQuickContact(this.mLookupUri);
        if (r0 != null) goto L13;
    L15:
        this.mHandler.startQuery(1, this.mLookupUri, this.mDataUri, DataQuery.PROJECTION, r7, r8, null);
        return;
    L13:
        if (r0.getCount() <= 0) goto L15;
        this.mQueryListener.onQueryComplete(1, this.mLookupUri, r0);
        goto L15
    L9:
        r7 = null;
        r8 = null;
        goto L10
    L5:
        this.mDataUri = Uri.withAppendedPath(this.mLookupUri, "data");
        goto L6
    }

    private void bindCursor(Cursor r14) {
        this.mActions.clear();
        HashMap r0 = new HashMap();
        if (r14 != null) goto L5;
        return;
    L5:
        if (r14.moveToFirst() == false) goto L43;
        ResolveCache r1 = ResolveCache.getInstance(this.mContext);
        this.mRawContactId = r14.getLong(16);
        this.mContactId = r14.getLong(18);
        this.mAccountName = r14.getString(17);
        this.mAccountType = r14.getString(1);
    L7:
        String r3 = r14.getString(13);
        if (this.mDataId == (-1)) goto L17;
        if ("vnd.android.cursor.item/phone_v2".equals(r3) == false) goto L12;
    L21:
        boolean r11 = false;
        long r7 = r14.getLong(0);
        DataAction r12 = new DataAction();
        r12.setDataAction(this.mContext, r3, r7, r14);
        if ("vnd.android.cursor.item/phone_v2".equals(r3) == false) goto L34;
        String r4 = r12.getData();
        Iterator r5 = r0.keySet().iterator();
    L25:
        if (r5.hasNext() == false) goto L29;
        String r6 = (String) r5.next();
        if (PhoneNumberUtils.compare(r6, r4) == false) goto L25;
        r11 = true;
        r4 = r6;
    L29:
        if (r11 == true) goto L31;
        r0.put(r4, r12.isStarred());
        goto L34
    L31:
        if (((Boolean) r0.get(r4)).booleanValue() == true) goto L36;
        removeUnstarredAction(r12, r4);
    L36:
        if (r14.moveToNext() == true) goto L7;
        return;
    L34:
        considerAdd(r12, r1);
        goto L36
    L12:
        if ("vnd.android.cursor.item/group_membership".equals(r3) == true) goto L21;
        if ("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile".equals(r3) == true) goto L21;
    L17:
        if ("vnd.android.cursor.item/phone_v2".equals(r3) == true) goto L21;
        if ("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile".equals(r3) == true) goto L21;
    }

    private View bindBackgroundItemButtons(View r6) {
        View r0 = r6.findViewById(R.id.item_background);
        if (r0 != null) goto L5;
        r0 = ((ViewStub) r6.findViewById(R.id.item_background_stub)).inflate();
    L5:
        int r7 = this.mBackgroundButtonIds.length;
        int r2 = 0;
    L6:
        if (r2 >= r7) goto L22;
        View r3 = r0.findViewById(this.mBackgroundButtonIds[r2]);
        if (r3 == null) goto L21;
        View.OnClickListener r4 = this.mBackgroundButtonListeners.get(r2);
        if (r4 == null) goto L13;
        r3.setOnClickListener(r4);
    L13:
        if (isPhoneAction(this.mBackgroundButtonIds[r2]) == false) goto L21;
        ArrayList<Action> r5 = this.mPhoneActions;
        if (r5 != null) goto L17;
    L19:
        boolean r8 = false;
    L20:
        r3.setEnabled(r8);
        goto L21
    L17:
        if (r5.isEmpty() == true) goto L19;
        r8 = true;
    L21:
        r2 = r2 + 1;
        goto L6
    L22:
        return r0;
    }

    private void removeUnstarredAction(Action r3, String r4) {
        ArrayList<Action> r2 = this.mActions.get("vnd.android.cursor.item/phone_v2");
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.size() <= 0) goto L22;
        int r5 = r2.size() - 1;
    L7:
        if (r5 < 0) goto L24;
        Action r0 = r2.get(r5);
        if (r0 == null) goto L15;
        if (r0.getData() == null) goto L15;
        if (r0.getData().equals(r4) == false) goto L15;
        r2.remove(r5);
        return;
    L15:
        r5 = r5 - 1;
        goto L7
    L24:
        return;
    }

    private void initPhotoData() {
        ResolveCache r0 = ResolveCache.getInstance(this.mContext);
        DataAction r7 = new DataAction();
        r7.setDataAction(this.mContext, "vnd.android.cursor.item/photo", 0, null);
        considerAdd(r7, r0);
        DataAction r1 = new DataAction();
        r1.setDataAction(this.mContext, "vnd.android.cursor.item/photo", 1, null);
        considerAdd(r1, r0);
    }

    private boolean considerAdd(Action r6, ResolveCache r7) {
        int r1 = 0;
        if (r6.getMimeType().equals("vnd.android.cursor.item/group_membership") == true) goto L13;
        if (r6.getMimeType().equals("vnd.android.cursor.item/photo") == true) goto L13;
        if ("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile".equals(r6.getMimeType()) == true) goto L13;
        if (r7.hasResolve(r6) == true) goto L13;
        return false;
    L13:
        if ("vnd.android.cursor.item/phone_v2".equals(r6.getMimeType()) == false) goto L24;
        ArrayList<Action> r8 = this.mActions.get(r6.getMimeType());
        if (r8 == null) goto L24;
        int r2 = 0;
    L18:
        if (r1 >= r8.size()) goto L23;
        if (PhoneNumberUtils.compare(r8.get(r1).getData(), r6.getData()) == false) goto L22;
        r2 = 1;
    L22:
        r1 = r1 + 1;
        goto L18
    L23:
        r1 = r2;
    L24:
        if (r1 != 0) goto L26;
        this.mActions.put(r6.getMimeType(), r6);
    L26:
        return true;
    }

    public void beforeHorizontalScrollOpen() {
        PhotoClicked();
    }
}
