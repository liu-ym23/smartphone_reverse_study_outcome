package com.android.contacts.group;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.GroupListLoader;
import com.android.contacts.R;
import com.android.contacts.activities.GroupEditorActivity;
import com.android.contacts.interactions.GroupDeletionDialogFragment;
import com.android.contacts.list.ContactsListBaseAdapter;
import com.android.contacts.list.SlideListView;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.NameSortComparator;
import com.android.contacts.widget.AutoScrollListView;
import com.android.vcard.VCardConfig;
import com.obric.account.LocalAccountContactsUtils;
import com.obric.anim.ListAnimator;
import com.obric.oui.status.OPageStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import obric.api.ContactsContractSmt;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes2.dex */
public class GroupBrowseListFragment extends AbstractFragment implements View.OnFocusChangeListener, View.OnTouchListener {
    private static final String EXTRA_KEY_GROUP_URI = "groups.groupUri";
    private static final String GROUP_DELETION_DIALOG_TAG = "groupDeletionDialog";
    private static final int NOTIFY_LOAD_GROUP = 4001;
    private static final int SUBACTIVITY_ACCOUNT_FILTER = 6;
    private static final int SUBACTIVITY_EDIT_CONTACT = 3;
    private static final int SUBACTIVITY_EDIT_GROUP = 5;
    private static final int SUBACTIVITY_NEW_CONTACT = 2;
    private static final int SUBACTIVITY_NEW_GROUP = 4;
    private static final String TAG = "GroupBrowseListFragment";
    private GroupBrowseListAdapter mAdapter;
    private LoadGroupHandler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    private Activity mContext;
    private LinearLayout mEmptyView;
    private ContactFragmentsCallback mFragmentsCallback;
    private GroupDeletionDialogFragment mGroupDeletionDialogFragment;
    private ListAnimator mGroupListAnimator;
    private ContentObserver mGroupObserver;
    private Handler mHandler;
    private boolean mIsEdit;
    private AutoScrollListView mListView;
    private OnGroupBrowserActionListener mListener;
    private boolean mPressDeleteButton;
    private View mRootView;
    private Runnable mScrollIdle;
    private Uri mSelectedGroupUri;
    private boolean mSelectionToScreenRequested;
    private boolean mSelectionVisible;
    private SlideListView.Listener mSlideListener;
    private int mVerticalScrollbarPosition;
    private ContactsListBaseAdapter.VoiceBtnCallBack mVoiceBtnCallBack;

    private class LoadGroupHandler extends Handler {
        final /* synthetic */ GroupBrowseListFragment this$0;

        public LoadGroupHandler(GroupBrowseListFragment r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            if (r3.what != 4001) goto L6;
            GroupBrowseListFragment r0 = this.this$0;
            GroupBrowseListFragment.access$100(r0, GroupBrowseListFragment.access$000(r0));
        L6:
            super.handleMessage(r3);
        }
    }

    private class OnClickDeleteListener implements GroupDeletionDialogFragment.OnClickDeleteListener {
        final /* synthetic */ GroupBrowseListFragment this$0;

        private OnClickDeleteListener(GroupBrowseListFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OnClickDeleteListener(GroupBrowseListFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.contacts.interactions.GroupDeletionDialogFragment.OnClickDeleteListener
        public void onClick() {
            GroupBrowseListFragment.access$1400(this.this$0);
        }
    }

    public interface OnGroupBrowserActionListener {
        void onChooseGroup(int r1);

        void onDataBinded();

        void onGroupDelete();

        void onViewGroupAction(Uri r1);

        void setCanEdit(boolean r1);
    }

    private class OnGroupRenameListener implements GroupBrowseListAdapter.OnGroupActionListener {
        final /* synthetic */ GroupBrowseListFragment this$0;

        private OnGroupRenameListener(GroupBrowseListFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OnGroupRenameListener(GroupBrowseListFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.contacts.group.GroupBrowseListAdapter.OnGroupActionListener
        public void groupRename(Uri r4) {
            Intent r0 = new Intent(this.this$0.getActivity(), GroupEditorActivity.class);
            r0.setData(r4);
            r0.setAction("android.intent.action.EDIT");
            this.this$0.startActivityForResult(r0, 5);
        }

        @Override // com.android.contacts.group.GroupBrowseListAdapter.OnGroupActionListener
        public void onViewGroupAction(Uri r1) {
            GroupBrowseListFragment.access$900(this.this$0).onViewGroupAction(r1);
        }

        @Override // com.android.contacts.group.GroupBrowseListAdapter.OnGroupActionListener
        public void onChooseGroup(int r1) {
            GroupBrowseListFragment.access$900(this.this$0).onChooseGroup(r1);
        }
    }

    public static class UngroupedContactsModel {
        public String mAccountName;
        public String mAccountType;
        public boolean mIsAdded;
        public int mUngroupedCount;

        public UngroupedContactsModel(String r2, String r3, int r4) {
            this.mIsAdded = false;
            this.mAccountName = r2;
            this.mAccountType = r3;
            this.mUngroupedCount = r4;
        }

        public String toString() {
            return "UngroupedContactsModel{mAccountName='" + this.mAccountName + "', mAccountType='" + this.mAccountType + "', mUngroupedCount=" + this.mUngroupedCount + '}';
        }

        public static UngroupedContactsModel getModel(List<UngroupedContactsModel> r3, String r4, String r5) {
            if (TextUtils.isEmpty(r4) == false) goto L5;
        L17:
            return null;
        L5:
            if (TextUtils.isEmpty(r5) == true) goto L17;
            int r0 = 0;
        L9:
            if (r0 >= r3.size()) goto L17;
            if (r3.get(r0).mAccountName.equals(r4) == false) goto L16;
            if (r3.get(r0).mAccountType.equals(r5) == false) goto L16;
            return r3.get(r0);
        L16:
            r0 = r0 + 1;
            goto L9
        }

        public static List<UngroupedContactsModel> getUnAddedModel(List<UngroupedContactsModel> r3) {
            ArrayList r0 = new ArrayList();
            int r1 = 0;
        L4:
            if (r1 >= r3.size()) goto L9;
            if (r3.get(r1).mIsAdded == true) goto L8;
            r0.add(r3.get(r1));
        L8:
            r1 = r1 + 1;
            goto L4
        L9:
            return r0;
        }
    }

    private void setGroupListItemPhoto() {
    }

    static /* synthetic */ Activity access$000(GroupBrowseListFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$100(GroupBrowseListFragment r0, Context r1) {
        r0.loadGroups(r1);
    }

    static /* synthetic */ LoadGroupHandler access$1000(GroupBrowseListFragment r0) {
        return r0.mBackgroundHandler;
    }

    static /* synthetic */ void access$1100(GroupBrowseListFragment r0, ArrayList r1) {
        r0.bindGroupList(r1);
    }

    static /* synthetic */ void access$1400(GroupBrowseListFragment r0) {
        r0.doRemoveAction();
    }

    static /* synthetic */ ContactFragmentsCallback access$1500(GroupBrowseListFragment r0) {
        return r0.mFragmentsCallback;
    }

    static /* synthetic */ boolean access$1602(GroupBrowseListFragment r0, boolean r1) {
        r0.mPressDeleteButton = r1;
        return r1;
    }

    static /* synthetic */ Runnable access$200(GroupBrowseListFragment r0) {
        return r0.mScrollIdle;
    }

    static /* synthetic */ Handler access$300(GroupBrowseListFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ boolean access$400(GroupBrowseListFragment r0) {
        return r0.mIsEdit;
    }

    static /* synthetic */ void access$500(GroupBrowseListFragment r0) {
        r0.hideVoiceSearchBtn();
    }

    static /* synthetic */ GroupBrowseListAdapter access$600(GroupBrowseListFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ AutoScrollListView access$700(GroupBrowseListFragment r0) {
        return r0.mListView;
    }

    static /* synthetic */ void access$800(GroupBrowseListFragment r0, Uri r1) {
        r0.viewGroup(r1);
    }

    static /* synthetic */ OnGroupBrowserActionListener access$900(GroupBrowseListFragment r0) {
        return r0.mListener;
    }

    public void setFragmentsCallback(ContactFragmentsCallback r1) {
        this.mFragmentsCallback = r1;
    }

    public GroupBrowseListFragment() {
        this.mVerticalScrollbarPosition = 2;
        this.mIsEdit = false;
        this.mHandler = new Handler();
        this.mScrollIdle = new AnonymousClass3(this);
        this.mVoiceBtnCallBack = new AnonymousClass4(this);
        this.mSlideListener = new AnonymousClass5(this);
        final Handler r3 = this.mHandler;
        this.mGroupObserver = new AnonymousClass6(this, r3);
        this.mPressDeleteButton = false;
        this.mGroupListAnimator = new ListAnimator(new int[]{R.id.title_container, R.id.common_item_center_layout}, new int[]{R.id.group_list_edit, R.id.count_frame}, new int[]{R.id.custom_start_container});
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        if (r4 == null) goto L7;
        Uri r5 = (Uri) r4.getParcelable(EXTRA_KEY_GROUP_URI);
        this.mSelectedGroupUri = r5;
        if (r5 == null) goto L7;
        this.mSelectionToScreenRequested = true;
    L7:
        View r6 = r2.inflate(R.layout.group_browse_list_fragment, null);
        this.mRootView = r6;
        LinearLayout r7 = (LinearLayout) r6.findViewById(R.id.empty);
        this.mEmptyView = r7;
        OPageStatus r8 = (OPageStatus) r7.findViewById(R.id.black_view);
        r8.setTitle(getString(R.string.noGroups_bytedance));
        r8.setMessage(getString(R.string.no_group_hint));
        GroupBrowseListAdapter r9 = new GroupBrowseListAdapter(this.mContext);
        this.mAdapter = r9;
        r9.setSelectionVisible(this.mSelectionVisible);
        this.mAdapter.setSelectedGroup(this.mSelectedGroupUri);
        AutoScrollListView r10 = (AutoScrollListView) this.mRootView.findViewById(R.id.list);
        this.mListView = r10;
        r10.setOnFocusChangeListener(this);
        this.mListView.setTextFilterEnabled(true);
        this.mListView.setOnTouchListener(this);
        this.mListView.setSlideListener(this.mSlideListener);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnScrollListener(new AnonymousClass1(this));
        this.mListView.setChoiceMode(1);
        this.mListView.setScrollEnabled(false);
        this.mListView.setOnItemClickListener(new AnonymousClass2(this));
        HandlerThread r11 = new HandlerThread("Load Group Worker");
        this.mBackgroundThread = r11;
        r11.start();
        this.mBackgroundHandler = new LoadGroupHandler(this, this.mBackgroundThread.getLooper());
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mHandler.removeCallbacksAndMessages(null);
        LoadGroupHandler r0 = this.mBackgroundHandler;
        if (r0 == null) goto L5;
        r0.removeMessages(4001);
        this.mBackgroundHandler = null;
    L5:
        HandlerThread r1 = this.mBackgroundThread;
        if (r1 == null) goto L9;
        r1.quitSafely();
        this.mBackgroundThread = null;
        return;
    }

    public void showVoiceSearchBtn() {
        View r0 = getActivity().findViewById(R.id.voice_search);
        if (r0 != null) goto L6;
        return;
    L6:
        if (isResumed() == true) goto L8;
        return;
    L8:
        if (this.mIsEdit == false) goto L10;
        return;
    L10:
        if (ContactsUtils.hasContacts() == false) goto L15;
        r0.setEnabled(true);
        AnimationUtil.showVoiceBtnWithAnimation(r0);
        return;
    }

    private void hideVoiceSearchBtn() {
        this.mHandler.removeCallbacks(this.mScrollIdle);
        Activity r2 = this.mContext;
        if (r2 == null) goto L8;
        View r3 = r2.findViewById(R.id.voice_search);
        if (r3 == null) goto L9;
        r3.setEnabled(false);
        AnimationUtil.hideVoiceBtnWithAnimation(r3);
        return;
    L9:
        return;
    }

    public void setVerticalScrollbarPosition(int r2) {
        if (this.mVerticalScrollbarPosition == r2) goto L6;
        this.mVerticalScrollbarPosition = r2;
        configureVerticalScrollbar();
        return;
    }

    private void configureVerticalScrollbar() {
        this.mListView.setVerticalScrollbarPosition(this.mVerticalScrollbarPosition);
        this.mListView.setScrollBarStyle(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        int r3 = 0;
        if (this.mVerticalScrollbarPosition != 1) goto L5;
        r3 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.list_visible_scrollbar_padding);
        int r0 = 0;
    L6:
        AutoScrollListView r1 = this.mListView;
        r1.setPadding(r3, r1.getPaddingTop(), r0, this.mListView.getPaddingBottom());
        return;
    L5:
        r0 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.list_visible_scrollbar_padding);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.mContext = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mContext = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mBackgroundHandler.sendEmptyMessage(4001);
        this.mContext.getContentResolver().registerContentObserver(ContactsContract.Groups.CONTENT_SUMMARY_URI, true, this.mGroupObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mContext.getContentResolver().unregisterContentObserver(this.mGroupObserver);
    }

    private List<UngroupedContactsModel> getUngroupedContactsModels(Context r8) {
        Cursor r9 = r8.getContentResolver().query(ContactsContract.AUTHORITY_URI.buildUpon().appendPath("ungrouped_contacts_summary").build(), null, null, null, null);
        if (ContactsUtils.DEBUG == false) goto L7;
        if (r9 == null) goto L6;
        logD("search account ungrouped count success ! size is " + r9.getCount());
        ContactsUtils.dumpCursor(r9, TAG);
        goto L7
    L6:
        logD("search account ungrouped count is null !");
    L7:
        ArrayList r7 = new ArrayList();
        if (r9 != null) goto L23;
    L22:
        return r7;
    L23:
    L19:
        th = move-exception;
        r9.close();
        throw th;
    L10:
        if (r9.moveToFirst() == false) goto L18;
    L11:
        String r0 = r9.getString(0);     // Catch: Throwable -> L19
        String r1 = r9.getString(1);     // Catch: Throwable -> L19
        int r2 = r9.getInt(2);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r0) == true) goto L17;
        if (TextUtils.isEmpty(r1) == true) goto L17;
        r7.add(new UngroupedContactsModel(r0, r1, r2));     // Catch: Throwable -> L19
    L17:
        if (r9.moveToNext() == true) goto L11;
    L18:
        r9.close();
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.android.contacts.group.GroupBrowseListFragment] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v3 */
    private void loadGroups(Context r23) {
        if (r23 != null) goto L5;
        return;
    L5:
        List<UngroupedContactsModel> r8 = getUngroupedContactsModels(r23);
        Cursor r9 = r23.getContentResolver().query(ContactsContract.Groups.CONTENT_SUMMARY_URI.buildUpon().appendQueryParameter("count_contact", "true").build(), GroupListLoader.COLUMNS, "account_type NOT NULL AND account_name NOT NULL AND auto_add=0 AND favorites=0 AND deleted=0", null, "account_type, account_name, data_set, title COLLATE LOCALIZED ASC");
        StringBuilder r1 = new StringBuilder("loadGroups, group cursor size is ");
        int r10 = 0;
        if (r9 != null) goto L8;
        int r2 = 0;
    L9:
        logD(r1.append(r2).toString());
        final ArrayList r11 = new ArrayList();
        if (r9 != null) goto L52;
    L38:
        List<UngroupedContactsModel> r3 = UngroupedContactsModel.getUnAddedModel(r8);
        if (r3.size() <= 0) goto L44;
        int r4 = 0;
    L42:
        if (r4 >= r3.size()) goto L44;
        r11.add(buildUngroupedGroupItem(r23, r3.get(r4)));
        r4 = r4 + 1;
    L44:
        logD("start print allGroupListItems :");
    L46:
        if (r10 >= r11.size()) goto L49;
        GroupListItem r5 = (GroupListItem) r11.get(r10);
        logD(r5.getTitle() + HanziToPinyin.Token.SEPARATOR + r5.getGroupId() + HanziToPinyin.Token.SEPARATOR + r5.getMemberCount() + HanziToPinyin.Token.SEPARATOR + r5.getAccountName() + HanziToPinyin.Token.SEPARATOR + r5.getAccountType());
        r10 = r10 + 1;
        goto L46
    L49:
        if (isAdded() == false) goto L57;
        this.mHandler.post(new AnonymousClass7(this, r11));
        return;
    L57:
        return;
    L52:
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L35
        if (r9.moveToFirst() == false) goto L34;
        ArrayList r12 = r6;
        Object r7 = "";
        ?? r13 = r7;
        ?? r14 = r7;
    L14:
        ?? r15 = r9.getString(0);     // Catch: Throwable -> L35
        ?? r16 = r9.getString(1);     // Catch: Throwable -> L35
        GroupListItem r17 = new GroupListItem(r15, r16, r9.getString(2), r9.getLong(3), r9.getString(4), r9.getInt(5), r9.getInt(6));     // Catch: Throwable -> L35
        if (r15.equals(r14) == true) goto L17;
    L20:
        Collections.sort(r12, new NameSortComparator());     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r14) == true) goto L26;
        if (TextUtils.isEmpty(r13) == true) goto L26;
        addUngroupedGroupItem(r23, r12, r8, r14, r13);     // Catch: Throwable -> L35
    L26:
        r11.addAll(r12);     // Catch: Throwable -> L35
        r12 = new ArrayList();     // Catch: Throwable -> L35
        ?? r18 = r16;
        ?? r19 = r15;
    L27:
        r12.add(r17);     // Catch: Throwable -> L35
        if (r9.moveToNext() == false) goto L30;
        r13 = r18;
        r14 = r19;
        goto L14
    L30:
        if (r12.size() <= 0) goto L34;
        String r20 = ((GroupListItem) r12.get(0)).getAccountName();     // Catch: Throwable -> L35
        String r21 = ((GroupListItem) r12.get(0)).getAccountType();     // Catch: Throwable -> L35
        Collections.sort(r12, new NameSortComparator());     // Catch: Throwable -> L35
        addUngroupedGroupItem(r23, r12, r8, r20, r21);     // Catch: Throwable -> L35
        r11.addAll(r12);     // Catch: Throwable -> L35
        goto L34
    L17:
        if (r16.equals(r13) == false) goto L20;
        r17 = r17;
        r18 = r16;
        r19 = r15;
    L34:
        r9.close();
    L35:
        th = move-exception;
        r9.close();
        throw th;
    L8:
        r2 = r9.getCount();
        goto L9
    }

    private void addUngroupedGroupItem(Context r1, List<GroupListItem> r2, List<UngroupedContactsModel> r3, String r4, String r5) {
        UngroupedContactsModel r6 = UngroupedContactsModel.getModel(r3, r4, r5);
        if (r6 == null) goto L5;
        logD("prepare add ungrouped item : " + r6);
        r2.add(buildUngroupedGroupItem(r1, r6));
        return;
    L5:
        StringBuilder r7 = new StringBuilder("can't find account info with : ");
        if (TextUtils.isEmpty(r4) == false) goto L8;
        r4 = "null";
    L8:
        StringBuilder r8 = r7.append(r4).append("__");
        if (TextUtils.isEmpty(r5) == false) goto L11;
        r5 = "null";
    L11:
        logD(r8.append(r5).toString());
    }

    private GroupListItem buildUngroupedGroupItem(Context r10, UngroupedContactsModel r11) {
        GroupListItem r9 = new GroupListItem(r11.mAccountName, r11.mAccountType, "", 0, "", r11.mUngroupedCount, 1);
        r9.setIsUngrouped(true, r10.getResources().getString(R.string.contact_group_name_ungrouped));
        r11.mIsAdded = true;
        return r9;
    }

    private void logD(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }

    private void bindGroupList(ArrayList<GroupListItem> r4) {
        this.mAdapter.setList(r4);
        if (r4 != null) goto L5;
    L24:
        OnGroupBrowserActionListener r5 = this.mListener;
        if (r5 == null) goto L27;
        r5.setCanEdit(false);
    L27:
        this.mListView.setEmptyView(this.mEmptyView);
        this.mListView.post(new AnonymousClass8(this));
        return;
    L5:
        if (r4.size() == 0) goto L24;
        boolean r2 = true;
        if (r4.size() == 1) goto L10;
    L12:
        OnGroupBrowserActionListener r6 = this.mListener;
        if (r6 == null) goto L15;
        r6.setCanEdit(r2);
    L15:
        this.mAdapter.setOnGroupRenameClickListener(new OnGroupRenameListener(this, null));
        if (this.mSelectionToScreenRequested == false) goto L18;
        this.mSelectionToScreenRequested = false;
        requestSelectionToScreen();
    L18:
        Uri r7 = this.mAdapter.getSelectedGroup();
        this.mSelectedGroupUri = r7;
        if (this.mSelectionVisible == false) goto L22;
        if (r7 == null) goto L22;
        viewGroup(r7);
    L22:
        this.mListView.post(new AnonymousClass9(this));
        return;
    L10:
        if (r4.get(0).isUngrouped() == false) goto L12;
        r2 = false;
        goto L12
    }

    public void setListener(OnGroupBrowserActionListener r1) {
        this.mListener = r1;
    }

    public void setSelectionVisible(boolean r1) {
        this.mSelectionVisible = r1;
        GroupBrowseListAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.setSelectionVisible(r1);
        return;
    }

    private void setSelectedGroup(Uri r2) {
        this.mSelectedGroupUri = r2;
        this.mAdapter.setSelectedGroup(r2);
        this.mListView.invalidateViews();
    }

    private void viewGroup(Uri r1) {
        setSelectedGroup(r1);
        OnGroupBrowserActionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onViewGroupAction(r1);
        return;
    }

    public void setSelectedUri(Uri r1) {
        viewGroup(r1);
        this.mSelectionToScreenRequested = true;
    }

    protected void requestSelectionToScreen() {
        if (this.mSelectionVisible == true) goto L5;
        return;
    L5:
        int r0 = this.mAdapter.getSelectedGroupPosition();
        if (r0 == (-1)) goto L9;
        this.mListView.requestPositionToScreen(r0, true);
        return;
    }

    private void hideSoftKeyboard() {
        Activity r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        ((InputMethodManager) r0.getSystemService("input_method")).hideSoftInputFromWindow(this.mListView.getWindowToken(), 0);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View r2, boolean r3) {
        if (r2 != this.mListView) goto L7;
        if (r3 == false) goto L8;
        hideSoftKeyboard();
        return;
    L8:
        return;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        if (r1 != this.mListView) goto L7;
        hideSoftKeyboard();
        return false;
    L7:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putParcelable(EXTRA_KEY_GROUP_URI, this.mSelectedGroupUri);
    }

    public void createNewGroupWithAccountDisambiguation() {
        createNewGroup(LocalAccountContactsUtils.getLocalAccountContacts(null));
    }

    private void createNewGroup(AccountWithDataSet r4) {
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_NEW_GROUP);
        Intent r0 = new Intent(getActivity(), GroupEditorActivity.class);
        r0.setAction("android.intent.action.INSERT");
        r0.putExtra(ContactsContractSmt.get_INSERT_ACCOUNT(), r4);
        r0.putExtra(ContactsContractSmt.get_INSERT_DATA_SET(), r4.dataSet);
        startActivityForResult(r0, 4);
    }

    public void setGroupEdit(boolean r2) {
        GroupDeletionDialogFragment r0 = this.mGroupDeletionDialogFragment;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.mGroupDeletionDialogFragment = null;
    L6:
        if (this.mAdapter.isGroupEdit() == r2) goto L9;
        this.mListView.setSlideEnable(r2);
        onBtnEditAnimation(r2);
        this.mIsEdit = r2;
        return;
    }

    public GroupBrowseListAdapter getAdapter() {
        return this.mAdapter;
    }

    public void deleteCheckedGroups() {
        int r0 = this.mAdapter.getCheckedGroupIds().size();
        if (r0 <= 0) goto L10;
        long[] r1 = new long[r0];
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L7;
        r1[r3] = this.mAdapter.getCheckedGroupIds().get(r3).longValue();
        r3 = r3 + 1;
        goto L5
    L7:
        String r2 = this.mAdapter.getLastSelectedGroupName();
        Bundle r4 = new Bundle();
        r4.putLongArray("groupId", r1);
        r4.putString(GroupDeletionDialogFragment.ARG_LABEL, r2);
        r4.putBoolean(GroupDeletionDialogFragment.ARG_SHOULD_END_ACTIVITY, false);
        GroupDeletionDialogFragment r5 = new GroupDeletionDialogFragment();
        this.mGroupDeletionDialogFragment = r5;
        r5.setOnClickDeleteListener(new OnClickDeleteListener(this, null));
        this.mGroupDeletionDialogFragment.setArguments(r4);
        this.mGroupDeletionDialogFragment.show(getParentFragmentManager(), GROUP_DELETION_DIALOG_TAG);
        return;
    }

    private void doRemoveAction() {
        ArrayList<Integer> r0 = new ArrayList();
        ArrayList<Integer> r1 = new ArrayList();
        HashSet<String> r2 = new HashSet();
        final ArrayList r3 = (ArrayList) this.mAdapter.getGroupList().clone();
        HashSet r4 = new HashSet(this.mAdapter.getCheckedGroupIds());
        Iterator r5 = r3.iterator();
        HashMap r6 = new HashMap();
        int r7 = 0;
    L4:
        if (r5.hasNext() == false) goto L13;
        GroupListItem r8 = (GroupListItem) r5.next();
        if (r4.contains(Long.valueOf(r8.getGroupId())) == false) goto L11;
        r0.add(Integer.valueOf(r7));
        AccountWithDataSet r9 = r8.getAccountWithDataSet();
        if (r6.get(r9) != null) goto L10;
        r6.put(r9, getGroupHeaderByAccount(r9));
    L10:
        r2.add((String) r6.get(r9));
        r5.remove();
    L12:
        r7 = r7 + 1;
        goto L4
    L11:
        r1.add(Integer.valueOf(r7));
        goto L12
    L13:
        HashSet r10 = new HashSet();
        Iterator<String> r11 = r2.iterator();
    L15:
        if (r11.hasNext() == false) goto L25;
        String r12 = r11.next();
        Iterator r13 = r3.iterator();
    L18:
        if (r13.hasNext() == false) goto L15;
        AccountWithDataSet r14 = ((GroupListItem) r13.next()).getAccountWithDataSet();
        if (r6.get(r14) != null) goto L23;
        r6.put(r14, getGroupHeaderByAccount(r14));
    L23:
        if (TextUtils.equals((CharSequence) r6.get(r14), r12) == false) goto L18;
        r10.add(r12);
        goto L18
    L25:
        r2.removeAll(r10);
        final AutoScrollListView r15 = this.mListView;
        final boolean r16 = true;
        new AnonymousClass10(this, r15, r16, r3).setResultListSize(r3.size()).setDeletedHeaderSection(r2).start(r0, r1);
    }

    private String getGroupHeaderByAccount(AccountWithDataSet r6) {
        String r0 = r6.type;
        String r1 = r6.name;
        String r7 = r6.dataSet;
        AccountTypeManager r2 = AccountTypeManager.getInstance(this.mContext);
        if (r2.getAccounts(true) == null) goto L5;
        int r4 = r2.getAccounts(true).size();
    L6:
        if (r4 <= 1) goto L12;
        AccountType r8 = r2.getAccountType(r0, r7);
        if (LocalAccountContactsUtils.isLocalAccount(r1, r0) == false) goto L14;
        return this.mContext.getString(R.string.local_group) + " - " + r8.getDisplayLabel(this.mContext);
    L14:
        return r8.getDisplayLabel(this.mContext) + " - " + ContactsUtils.getAccountName(this.mContext, r0, r1);
    L12:
        return ContactsUtils.getGroupName(this.mContext, r0, r1);
    L5:
        r4 = 0;
        goto L6
    }

    private void onBtnEditAnimation(boolean r3) {
        if (this.mListView.getChildCount() != 0) goto L6;
        this.mPressDeleteButton = false;
        deleteGroups();
        this.mAdapter.setGroupEdit(r3);
        return;
    L6:
        if (r3 == false) goto L8;
        this.mGroupListAnimator.startEdit(this.mListView);
    L9:
        editAnimatorFinished(r3);
        return;
    L8:
        this.mGroupListAnimator.finishEdit(this.mListView);
        goto L9
    }

    private void editAnimatorFinished(boolean r2) {
        if (this.mPressDeleteButton == false) goto L5;
        this.mPressDeleteButton = false;
        deleteGroups();
    L5:
        if (r2 == false) goto L7;
        hideVoiceSearchBtn();
    L8:
        this.mAdapter.setGroupEdit(r2);
        return;
    L7:
        showVoiceSearchBtn();
        goto L8
    }

    private void deleteGroups() {
        ArrayList<Long> r0 = this.mAdapter.getCheckedGroupIds();
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        if (r2 <= 0) goto L13;
        long[] r3 = new long[r2];
    L8:
        if (r1 >= r2) goto L10;
        r3[r1] = r0.get(r1).longValue();
        r1 = r1 + 1;
        goto L8
    L10:
        Activity r6 = this.mContext;
        r6.startService(ContactSaveService.createGroupDeletionIntent(r6, r3));
        r0.clear();
        return;
    L13:
        return;
    L5:
        r2 = r0.size();
        goto L6
    }

    public boolean isEdit() {
        return this.mIsEdit;
    }

    public boolean isSelecting() {
        return this.mListView.isSelecting();
    }
}
