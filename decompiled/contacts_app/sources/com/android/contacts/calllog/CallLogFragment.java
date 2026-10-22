package com.android.contacts.calllog;

import android.app.KeyguardManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.CallLog;
import android.security.bytedance.guard.BDSettingsEvent;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.Observer;
import bytedanceos.util.MultiSimAdapter;
import com.GlobalProxyLancet;
import com.android.common.io.MoreCloseables;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.activities.NumberMarkActivity;
import com.android.contacts.calllog.blocked.repo.BlockedDataRequester;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.forcetouch.ForceTouchController;
import com.android.contacts.list.BottomDeleteLayoutListener;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.list.HorizontalScrollListView;
import com.android.contacts.list.SlideListView;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.MenuItem;
import com.android.contacts.util.MenuUtilsKt;
import com.android.contacts.util.OSheetUtils;
import com.android.contacts.voicemail.VoicemailStatusHelper;
import com.android.contacts.voicemail.VoicemailStatusHelperImpl;
import com.android.contacts.widget.SelectAllState;
import com.bytedance.common.utility.UIUtils;
import com.obric.anim.ListAnimator;
import com.obric.immersive.Immersive;
import com.obric.model.CallFeatureModel;
import com.obric.notification.NotificationHelper;
import com.obric.oui.button.OButton;
import com.obric.oui.popover.OPopover;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import com.obric.oui.titlebar.optimize.OCTitleBarExtKt;
import com.obric.utils.ClipboardReader;
import com.obric.utils.NewContactsTraceLog;
import com.obric.utils.OAutoSecurityGuardUtils;
import com.obric.utils.ObriceRecordSummaryUtils;
import com.obricOld.contacts.menus.LongMenuHelper;
import com.ss.android.http.legacy.protocol.HTTP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import obric.app.tracker.Agent;
import obric.widget.ButtonTabGroup;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(since = "废弃不再使用，请关注 NewCallLogFragment")
public class CallLogFragment extends ListFragment implements DialtactsActivity.ViewPagerVisibilityListener, CallLogQueryHandler.Listener, CallLogAdapter.CallFetcher, View.OnClickListener, LongMenuHelper.OnMenuItemClickedListener, DialtactsActivity.PageEnableListener, AbsListView.OnScrollListener, DialtactsActivity.onBackPressListener, DSUtils.DSFatureStatusListener, ButtonTabGroup.OnButtonGroupItemClickListener {
    private static final int DELAY_UPDATE_TRANSITION = 900;
    private static final boolean FEATURE_CMCC_CU = false;
    private static final int MESSAGE_UPDATE_TRANSITION = 10;
    private static final int REQUEST_CODE_GET_NUMBER_MARK = 1009;
    private static final int START_QUERY_CALLLOG = 1000;
    private static final String SUB_TAG_ALL = "CALL_LOG_ALL";
    private static final String SUB_TAG_SINGLE = "CALL_LOG_SINGLE";
    private static final int TAB_INDEX_ALL = 0;
    private static final int TAB_INDEX_SIM1_OR_MISSED = 1;
    private static final int TAB_INDEX_SIM2 = 2;
    private static final String TAG = "CallLogFragment";
    private static final LongMenuHelper.MenuType[] sLongMenuItemsContacts = null;
    private static final LongMenuHelper.MenuType[] sLongMenuItemsStranger = null;
    private OPageStatus blankView;
    private CallLogAdapter mAdapter;
    private BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private OButton mBtnBack;
    private OButton mBtnCancel;
    private OButton mBtnEdit;
    private OButton mBtnMenu;
    private OButton mBtnSelectedAllView;
    private CallLogQueryHandler mCallLogQueryHandler;
    private final ListAnimator mCalllogAnimator;
    private LinearLayout mContactTitleBarCenterView;
    private int mCurTabIndex;
    private OActionSheet mDeleteConfirmDialog;
    private View mEmptyView;
    private ViewStub mEmptyViewStub;
    private ForceTouchController mForceTouchController;
    private ContactFragmentsCallback mFragmentsCallback;
    private Handler mHandler;
    private AsyncTask<Void, Void, Boolean> mHasRecordTask;
    private int mHeaderHeight;
    private boolean mInMissCallsPage;
    private boolean mInitHasCallLog;
    private boolean mIsDeletingCallLogs;
    private boolean mIsEditMode;
    private boolean mIsShowSingleContactCalls;
    private HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private KeyguardManager mKeyguardManager;
    private LongMenuHelper mLongMenuHelper;
    private Observer<Integer> mNavigationBarObserver;
    private OTabSegmentedLayout mOALLTabSegmentedLayout;
    private OCTitleBar mOTitleBar;
    private boolean mPendingClearMissedCall;
    private boolean mProviderIsNormal;
    private List<String> mResult;
    private SelectAllState mSelectedAll;
    private String mSelection;
    private int mSimId;
    private SlideListView mSlideListView;
    private SlideListView.Listener mSlideListener;
    private boolean mVisibilityChanged;
    private boolean mVoicemailSourcesAvailable;
    private VoicemailStatusHelper mVoicemailStatusHelper;
    private TextView secondaryHintTextView;
    private final CallFeatureModel.CallFeatureModelListener summaryListener;

    /* JADX INFO: renamed from: com.android.contacts.calllog.CallLogFragment$22, reason: invalid class name */
    static /* synthetic */ class AnonymousClass22 {
        static final /* synthetic */ int[] $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType = null;

        static {
            int[] r0 = new int[LongMenuHelper.MenuType.values().length];
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType = r0;
            r0[LongMenuHelper.MenuType.MENU_DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[LongMenuHelper.MenuType.MENU_BLACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[LongMenuHelper.MenuType.MENU_COPY_NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[LongMenuHelper.MenuType.MENU_FLAG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[LongMenuHelper.MenuType.MENU_CREATE_CONTACTS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private class DeleteCallLogTask extends AsyncTask<ArrayList<Long>, Void, Void> {
        private ContentResolver mResolver;
        final /* synthetic */ CallLogFragment this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(ArrayList<Long>[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        public DeleteCallLogTask(CallLogFragment r1, ContentResolver r2) {
            this.this$0 = r1;
            this.mResolver = r2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(ArrayList<Long>... r7) {
            ArrayList<Long> r8 = r7[0];
            if (r8 != null) goto L5;
        L16:
            return null;
        L5:
            if (r8.isEmpty() == true) goto L16;
            StringBuilder r2 = new StringBuilder("_id IN (");
            Iterator<Long> r9 = r8.iterator();
            boolean r3 = true;
        L9:
            if (r9.hasNext() == false) goto L15;
            Long r4 = r9.next();
            if (r3 == false) goto L13;
            r3 = false;
        L14:
            r2.append(r4);
            goto L9
        L13:
            r2.append(", ");
            goto L14
        L15:
            r2.append(")");
            this.mResolver.delete(CallLog.Calls.CONTENT_URI, r2.toString(), null);
            goto L16
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r2) {
            if (CallLogFragment.access$300(this.this$0) == null) goto L5;
            CallLogFragment.access$300(this.this$0).clearHashSet();
        L5:
            CallLogFragment.access$1402(this.this$0, false);
            CallLogFragment.access$1700(this.this$0, true);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    static /* synthetic */ SlideListView access$000(CallLogFragment r0) {
        return r0.mSlideListView;
    }

    static /* synthetic */ boolean access$100(CallLogFragment r0) {
        return r0.mIsShowSingleContactCalls;
    }

    static /* synthetic */ void access$1000(CallLogFragment r0, OPopover r1) {
        r0.tryShowBlockedCallRedBadge(r1);
    }

    static /* synthetic */ void access$1100(CallLogFragment r0) {
        r0.doRemoveAction();
    }

    static /* synthetic */ OActionSheet access$1200(CallLogFragment r0) {
        return r0.mDeleteConfirmDialog;
    }

    static /* synthetic */ Boolean access$1300(CallLogFragment r0, ArrayList r1) {
        return r0.hasRecord(r1);
    }

    static /* synthetic */ boolean access$1402(CallLogFragment r0, boolean r1) {
        r0.mIsDeletingCallLogs = r1;
        return r1;
    }

    static /* synthetic */ ContactFragmentsCallback access$1500(CallLogFragment r0) {
        return r0.mFragmentsCallback;
    }

    static /* synthetic */ void access$1600(CallLogFragment r0, boolean r1) {
        r0.setEmptyViews(r1);
    }

    static /* synthetic */ void access$1700(CallLogFragment r0, boolean r1) {
        r0.endEditMode(r1);
    }

    static /* synthetic */ Handler access$1800(CallLogFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$1900(CallLogFragment r0) {
        r0.updateOnEntry();
    }

    static /* synthetic */ CallLogListItemViews access$200(CallLogFragment r0, View r1) {
        return r0.getCallLogListItemView(r1);
    }

    static /* synthetic */ CallLogAdapter access$300(CallLogFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ SelectAllState access$400(CallLogFragment r0) {
        return r0.mSelectedAll;
    }

    static /* synthetic */ BottomDeleteLayoutListener access$500(CallLogFragment r0) {
        return r0.mBottomDeleteLayoutListener;
    }

    static /* synthetic */ LongMenuHelper.MenuType[] access$600() {
        return sLongMenuItemsStranger;
    }

    static /* synthetic */ LongMenuHelper access$700(CallLogFragment r0) {
        return r0.mLongMenuHelper;
    }

    static /* synthetic */ LongMenuHelper.MenuType[] access$800() {
        return sLongMenuItemsContacts;
    }

    static /* synthetic */ void access$900(CallLogFragment r0, String r1) {
        r0.refreshData(r1);
    }

    static {
        if (ContactsUtils.FEATURE_CMCC == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        FEATURE_CMCC_CU = r0;
        sLongMenuItemsStranger = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_COPY_NUMBER, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_LINE, LongMenuHelper.MenuType.MENU_CREATE_CONTACTS, LongMenuHelper.MenuType.MENU_FLAG, LongMenuHelper.MenuType.MENU_BLACK, LongMenuHelper.MenuType.MENU_DELETE};
        sLongMenuItemsContacts = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_COPY_NUMBER, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_LINE, LongMenuHelper.MenuType.MENU_BLACK, LongMenuHelper.MenuType.MENU_DELETE};
        return;
    L5:
        if (ContactsUtils.FEATURE_CU == true) goto L8;
        r0 = false;
        goto L9
    }

    public void setFragmentsCallback(ContactFragmentsCallback r1) {
        this.mFragmentsCallback = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        Agent r4 = Agent.getInstance();
        if (this.mIsShowSingleContactCalls == false) goto L5;
        String r0 = SUB_TAG_SINGLE;
    L6:
        r4.onAttach(TAG, r0);
        this.mCallLogQueryHandler = new CallLogQueryHandler(getActivity().getContentResolver(), this);
        this.mKeyguardManager = (KeyguardManager) getActivity().getSystemService("keyguard");
        if (DSUtils.isMultiSimEnabled() == false) goto L13;
        DSUtils.registerDSFeatureStatusListener(this);
        if (DSUtils.sShouldUpdateShowSimIcon == false) goto L13;
        if (DSUtils.useDSFeature() == false) goto L13;
        this.mCallLogQueryHandler.updateShowSimId();
        DSUtils.sShouldUpdateShowSimIcon = false;
    L13:
        this.mLongMenuHelper = new LongMenuHelper(getActivity(), this);
        return;
    L5:
        r0 = SUB_TAG_ALL;
        goto L6
    }

    public CallLogFragment() {
        this.mAdapter = null;
        this.mVoicemailSourcesAvailable = false;
        this.mInMissCallsPage = false;
        this.mIsEditMode = false;
        this.mIsShowSingleContactCalls = false;
        this.mInitHasCallLog = true;
        this.mEmptyViewStub = null;
        this.mEmptyView = null;
        this.mSimId = -1;
        this.mPendingClearMissedCall = false;
        this.mCurTabIndex = 0;
        this.mNavigationBarObserver = new AnonymousClass1(this);
        this.mSlideListener = new AnonymousClass3(this);
        this.mItemLongClickedListener = new AnonymousClass6(this);
        this.mIsDeletingCallLogs = false;
        this.mCalllogAnimator = new ListAnimator(new int[]{R.id.name, R.id.call_info_container, R.id.call_count_and_date}, new int[]{R.id.ic_call, R.id.secondary_action_icon}, new int[]{R.id.checkBoxStub});
        this.summaryListener = new AnonymousClass19(this);
        this.mVisibilityChanged = false;
        this.mHandler = new AnonymousClass21(this);
        this.mProviderIsNormal = true;
        this.mIsShowSingleContactCalls = false;
    }

    public CallLogFragment(String r7, List<String> r8, boolean r9, boolean r10) {
        this.mAdapter = null;
        this.mVoicemailSourcesAvailable = false;
        this.mInMissCallsPage = false;
        this.mIsEditMode = false;
        this.mIsShowSingleContactCalls = false;
        this.mInitHasCallLog = true;
        this.mEmptyViewStub = null;
        this.mEmptyView = null;
        this.mSimId = -1;
        this.mPendingClearMissedCall = false;
        this.mCurTabIndex = 0;
        this.mNavigationBarObserver = new AnonymousClass1(this);
        this.mSlideListener = new AnonymousClass3(this);
        this.mItemLongClickedListener = new AnonymousClass6(this);
        this.mIsDeletingCallLogs = false;
        this.mCalllogAnimator = new ListAnimator(new int[]{R.id.name, R.id.call_info_container, R.id.call_count_and_date}, new int[]{R.id.ic_call, R.id.secondary_action_icon}, new int[]{R.id.checkBoxStub});
        this.summaryListener = new AnonymousClass19(this);
        this.mVisibilityChanged = false;
        this.mHandler = new AnonymousClass21(this);
        this.mProviderIsNormal = true;
        this.mSelection = r7;
        this.mResult = r8;
        this.mIsShowSingleContactCalls = true;
        this.mInitHasCallLog = r10;
    }

    public CallLogAdapter getCallLogAdapter() {
        return this.mAdapter;
    }

    @Override // com.android.contacts.calllog.CallLogQueryHandler.Listener
    public void onCallsFetched(Cursor r4) {
        if (getActivity() != null) goto L5;
    L24:
        MoreCloseables.closeQuietly(r4);
        return;
    L5:
        if (getActivity().isFinishing() == true) goto L24;
        if (ContactsUtils.DEBUG == false) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onCallsFetched cursor count:" + r4.getCount());
    L11:
        if (this.mAdapter != null) goto L13;
        ContactsUtils.getCurrentCountryIso(getActivity());
    L13:
        ContactsUtils.updateDateAndTimeFormat();
        if (this.mSlideListView.getAdapter() != null) goto L16;
        this.mSlideListView.setAdapter(this.mAdapter);
        this.mForceTouchController.setAdapter(this.mAdapter);
        this.mSlideListView.setAutoClose(false);
        this.mAdapter.mHSListView = this.mSlideListView;
        this.mSlideListView.setOnItemClickListener(new AnonymousClass2(this));
        this.mSlideListView.setOnScrollStateChangeListener(this.mAdapter);
    L16:
        this.mAdapter.setLoading(false);
        this.mAdapter.changeCursor(r4);
        if (r4.getCount() != 0) goto L20;
        setEmptyViews(this.mIsShowSingleContactCalls);
    L20:
        if (this.mAdapter.isEmpty() == false) goto L22;
        endEditMode(true);
    L22:
        refreshUI();
    }

    private CallLogListItemViews getCallLogListItemView(View r1) {
        if ((r1 instanceof CallLogListItemViews) == false) goto L7;
        return (CallLogListItemViews) r1;
    L7:
        return (CallLogListItemViews) r1.getTag(R.id.primary_action_view);
    }

    @Override // com.android.contacts.calllog.CallLogQueryHandler.Listener
    public void onVoicemailStatusFetched(Cursor r2) {
        if (getActivity() != null) goto L5;
    L13:
        MoreCloseables.closeQuietly(r2);
        return;
    L5:
        if (getActivity().isFinishing() == true) goto L13;
        updateVoicemailStatusMessage(r2);
        if (this.mVoicemailStatusHelper.getNumberActivityVoicemailSources(r2) == 0) goto L10;
        boolean r0 = true;
    L11:
        setVoicemailSourcesAvailable(r0);
        MoreCloseables.closeQuietly(r2);
        return;
    L10:
        r0 = false;
        goto L11
    }

    private void setVoicemailSourcesAvailable(boolean r2) {
        if (this.mVoicemailSourcesAvailable != r2) goto L5;
        return;
    L5:
        this.mVoicemailSourcesAvailable = r2;
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        int r0 = 0;
        if (this.mIsShowSingleContactCalls == false) goto L5;
        View r9 = r6.inflate(R.layout.contact_detail_calllog_fragment, r7, false);
    L6:
        this.mVoicemailStatusHelper = new VoicemailStatusHelperImpl();
        this.mOTitleBar = (OCTitleBar) r9.findViewById(R.id.otitlebar);
        if (this.mIsShowSingleContactCalls == false) goto L9;
        OButton r10 = getNeutralTitleBtn(R.drawable.icon_cancel_22_22, true);
        this.mBtnBack = r10;
        r10.setContentDescription(getString(R.string.common_back));
        this.mBtnBack.setOnClickListener(this);
    L16:
        OButton r11 = getTitleBtn(R.drawable.standard_icon_multi_select_selector, !this.mIsShowSingleContactCalls);
        this.mBtnEdit = r11;
        r11.setContentDescription(getString(R.string.common_edit));
        this.mBtnEdit.setOnClickListener(this);
        OButton r12 = getTitleBtn(R.drawable.icon_menu_more, false);
        this.mBtnMenu = r12;
        r12.setContentDescription(getString(R.string.more_btn));
        this.mBtnMenu.setOnClickListener(this);
        OButton r13 = this.mBtnMenu;
        if (this.mIsShowSingleContactCalls == false) goto L19;
        r0 = 8;
    L19:
        r13.setVisibility(r0);
        OButton r14 = OCTitleBarExtKt.createNeutralButton(this.mOTitleBar, getContext());
        this.mBtnCancel = r14;
        r14.setText(R.string.common_cancel);
        this.mBtnCancel.setContentDescription(getString(R.string.accessibility_btn_cancel));
        this.mBtnCancel.setOnClickListener(this);
        this.mOTitleBar.addRightView(this.mBtnCancel);
        this.mBtnSelectedAllView = OCTitleBarExtKt.createNeutralButton(this.mOTitleBar, getContext());
        this.mSelectedAll = new SelectAllState(this.mBtnSelectedAllView);
        this.mBtnSelectedAllView.setText(R.string.select_all);
        this.mOTitleBar.addLeftView(this.mBtnSelectedAllView);
        this.mBtnSelectedAllView.setContentDescription(getString(R.string.select_all));
        this.mBtnSelectedAllView.setOnClickListener(new AnonymousClass5(this));
        this.mEmptyViewStub = (ViewStub) r9.findViewById(R.id.listview_emptyview_stub);
        return r9;
    L9:
        String[] r15 = {getString(R.string.tab_all), getString(R.string.tab_missed_calls), getString(R.string.tab_missed_calls)};
        boolean r1 = FEATURE_CMCC_CU;
        if (r1 == false) goto L12;
        List r16 = Arrays.asList(r15);
    L13:
        LinearLayout r2 = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.content_title_segmentedlayout, null, false);
        this.mContactTitleBarCenterView = r2;
        OTabSegmentedLayout r3 = (OTabSegmentedLayout) r2.findViewById(R.id.tab_layout_title);
        this.mOALLTabSegmentedLayout = r3;
        r3.setTabTitleAndDrawable((String[]) r16.stream().toArray(new CallLogFragment$$ExternalSyntheticLambda0()), null);
        this.mOALLTabSegmentedLayout.setOnTabSelectListener(new AnonymousClass4(this));
        this.mOTitleBar.setCenterView(this.mContactTitleBarCenterView);
        this.mOALLTabSegmentedLayout.getTabList().get(0).setContentDescription(getString(R.string.accessibility_tab_all_description));
        this.mOALLTabSegmentedLayout.getTabList().get(0).setContentDescription(getString(R.string.accessibility_tab_all_description));
        this.mCurTabIndex = 0;
        this.mOALLTabSegmentedLayout.setCurrentTab(0);
        this.mHeaderHeight = getActivity().getResources().getDimensionPixelSize(R.dimen.calllog_edit_header_height);
        if (r1 == false) goto L16;
        updateCallLogFilter(getActivity());
        goto L16
    L12:
        r16 = Arrays.asList(r15).subList(0, 2);
        goto L13
    L5:
        r9 = r6.inflate(R.layout.call_log_fragment, r7, false);
        goto L6
    }

    static /* synthetic */ String[] lambda$onCreateView$0(int r0) {
        return new String[r0];
    }

    public void setBottomDeleteLayoutListener(BottomDeleteLayoutListener r1) {
        this.mBottomDeleteLayoutListener = r1;
    }

    private OButton getTitleBtn(int r3, boolean r4) {
        OButton r0 = OCTitleBarExtKt.createTransIconButton(this.mOTitleBar, getContext());
        r0.setMIcon(getResources().getDrawable(r3));
        if (r4 == false) goto L5;
        this.mOTitleBar.addLeftView(r0);
    L6:
        return r0;
    L5:
        this.mOTitleBar.addRightView(r0);
        goto L6
    }

    private OButton getNeutralTitleBtn(int r3, boolean r4) {
        OButton r0 = OCTitleBarExtKt.createNeutralButton(this.mOTitleBar, getContext());
        r0.setMIcon(getResources().getDrawable(r3));
        if (r4 == false) goto L5;
        this.mOTitleBar.addLeftView(r0);
    L6:
        return r0;
    L5:
        this.mOTitleBar.addRightView(r0);
        goto L6
    }

    public void clickTitleBar(int r5) {
        if (r5 != this.mCurTabIndex) goto L5;
        return;
    L5:
        this.mCurTabIndex = r5;
        this.mOALLTabSegmentedLayout.setCurrentTab(r5);
        if (r5 != 0) goto L8;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_ALL_CALL_LOG);
        if (isInMissCallsPage() == false) goto L48;
        setInMissCallsPage(false);
        this.mOALLTabSegmentedLayout.getTabList().get(0).setContentDescription(getString(R.string.accessibility_tab_all_description));
        this.mOALLTabSegmentedLayout.getTabList().get(0).setContentDescription(getString(R.string.accessibility_tab_all_description));
        if (FEATURE_CMCC_CU == false) goto L44;
        this.mSimId = -1;
    L44:
        CallLogAdapter r6 = this.mAdapter;
        if (r6 == null) goto L47;
        r6.clearHashSet();
    L47:
        this.mSlideListView.restoreScrollState(false);
    L48:
        CallLogAdapter r4 = this.mAdapter;
        if (r4 == null) goto L56;
        r4.onContentChangedByScene("call log click title bar in TAB_INDEX_ALL");
        return;
    L56:
        return;
    L8:
        if (r5 != 1) goto L10;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_MISSED_CALL_LOG);
        if (isInMissCallsPage() == true) goto L26;
    L27:
        setInMissCallsPage(true);
        this.mOALLTabSegmentedLayout.getTabList().get(1).setContentDescription(getString(R.string.accessibility_tab_all_unselected));
        this.mOALLTabSegmentedLayout.getTabList().get(1).setContentDescription(getString(R.string.accessibility_tab_missed_description));
        if (FEATURE_CMCC_CU == true) goto L30;
    L32:
        CallLogAdapter r7 = this.mAdapter;
        if (r7 == null) goto L35;
        r7.clearHashSet();
    L35:
        this.mSlideListView.restoreScrollState(false);
    L36:
        CallLogAdapter r8 = this.mAdapter;
        if (r8 == null) goto L54;
        r8.onContentChangedByScene("call log click title bar in TAB_INDEX_SIM1_OR_MISSED");
        return;
    L54:
        return;
    L30:
        if (DSUtils.useDSFeature() == false) goto L32;
        this.mSimId = 0;
        goto L32
    L26:
        if (this.mSimId == 0) goto L36;
    L10:
        if (r5 == 2) goto L13;
        return;
    L13:
        if (isInMissCallsPage() == true) goto L15;
    L16:
        setInMissCallsPage(true);
        this.mSimId = 1;
        CallLogAdapter r9 = this.mAdapter;
        if (r9 == null) goto L19;
        r9.clearHashSet();
    L19:
        this.mSlideListView.restoreScrollState(false);
    L20:
        CallLogAdapter r10 = this.mAdapter;
        if (r10 == null) goto L52;
        r10.onContentChangedByScene("call log click title bar in TAB_INDEX_SIM2");
        return;
    L52:
        return;
    L15:
        if (this.mSimId == 1) goto L20;
        goto L16
    }

    private void updateCallLogFilter(Context r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (DSUtils.useDSFeature() == false) goto L7;
        this.mOALLTabSegmentedLayout.getTabList().get(1).setVisibility(0);
        return;
    L7:
        this.mOALLTabSegmentedLayout.getTabList().get(1).setVisibility(8);
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        SlideListView r5 = (SlideListView) getListView();
        this.mSlideListView = r5;
        r5.setSlideListener(this.mSlideListener);
        this.mSlideListView.setOnScrollListener(this);
        this.mSlideListView.setScrollEnabled(!this.mIsShowSingleContactCalls);
        this.mSlideListView.setItemLongClickedListener(this.mItemLongClickedListener);
        ForceTouchController r6 = new ForceTouchController(this.mSlideListView, getActivity());
        this.mForceTouchController = r6;
        this.mSlideListView.setOnTouchListener(r6);
        if (this.mIsShowSingleContactCalls == true) goto L5;
    L7:
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().observeForever(this.mNavigationBarObserver);
        return;
    L5:
        if (this.mInitHasCallLog == true) goto L7;
        setEmptyViews(true);
        goto L7
    }

    @Override // androidx.fragment.app.ListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().removeObserver(this.mNavigationBarObserver);
    }

    private void setEmptyViews(boolean r4) {
        String r0 = getString(R.string.call_log_empty_secondary);
        if (this.mEmptyView != null) goto L5;
        View r1 = this.mEmptyViewStub.inflate();
        this.mEmptyView = r1;
        OPageStatus r2 = (OPageStatus) r1.findViewById(R.id.black_view);
        this.blankView = r2;
        r2.setTitle(getString(R.string.call_log_empty));
        this.blankView.setMessage(r0);
        this.secondaryHintTextView = this.blankView.getMessageView();
    L5:
        if (r4 == false) goto L7;
        r0 = getString(R.string.single_recentCalls_empty_secondary);
    L7:
        this.secondaryHintTextView.setText(r0);
        this.mSlideListView.setEmptyView(this.mEmptyView);
    }

    void dismissLongMenu() {
        LongMenuHelper r0 = this.mLongMenuHelper;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mLongMenuHelper.dismiss();
        return;
    }

    @Override // com.obricOld.contacts.menus.LongMenuHelper.OnMenuItemClickedListener
    public boolean onMenuItemClicked(LongMenuHelper.MenuType r3, View r4, Object r5) {
        if (this.mAdapter != null) goto L5;
        return false;
    L5:
        if ((r5 instanceof CallLogAdapter.PrimaryActionListener) == false) goto L35;
        CallLogAdapter.PrimaryActionListener r6 = (CallLogAdapter.PrimaryActionListener) r5;
        getActivity();
        int r0 = AnonymousClass22.$SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[r3.ordinal()];
        if (r0 != 1) goto L9;
        this.mAdapter.doRemoveCallLog(r4, r6);
        return true;
    L9:
        if (r0 == 2) goto L27;
        if (r0 != 3) goto L13;
        String[] r7 = {HTTP.PLAIN_TEXT_TYPE, ClipboardReader.FORBIDDEN_CLIPBOARD_TYPE_CALL_LOG};
        ClipData.Item r8 = new ClipData.Item(r6.getNumber());
        ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(new ClipData("number", r7, r8));
        return true;
    L13:
        if (r0 == 4) goto L20;
        if (r0 != 5) goto L36;
        r6.clickGoToDetail();
        return true;
    L36:
        return false;
    L20:
        if (r6.isHasMarked() == false) goto L22;
        unMarkNumber(r6.getNumber());
    L23:
        return true;
    L22:
        markNumber(r6);
        goto L23
    L27:
        if (r3.isHighLight == false) goto L29;
        this.mAdapter.removeFromBlackList(r6.getNumber());
    L30:
        return true;
    L29:
        this.mAdapter.addNumberToBlackList(r6.getPhoneCallDetails());
        goto L30
    L35:
        return false;
    }

    private void markNumber(CallLogAdapter.PrimaryActionListener r5) {
        boolean r0 = r5.isHasMarked();
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L6;
        Intent r2 = new Intent(r1, NumberMarkActivity.class);
        r2.putExtra(NumberMarkActivity.EXTRA_PARAM_MARKED, r0);
        r2.putExtra(NumberMarkActivity.EXTRA_PARAM_NUMBER, r5.getNumber());
        startActivityForResult(r2, 1009);
        AnimationUtil.switchActivityAnimation(r1, 1);
        return;
    }

    private void unMarkNumber(String r3) {
        NumberInfosManager.getInstance().clearMarkInfoAsync(r3, new AnonymousClass7(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r3, int r4, Intent r5) {
        if (r4 == (-1)) goto L5;
        return;
    L5:
        if (r3 != 1009) goto L17;
        if (r5 == null) goto L20;
        int r6 = r5.getIntExtra("position", -1);
        NumberInfosManager.NumberInfosListenerAdatper r7 = new AnonymousClass8(this);
        String r0 = r5.getStringExtra(NumberMarkActivity.EXTRA_PARAM_NUMBER);
        if (NumberInfosManager.Classify.isValidIndex(r6) == false) goto L11;
        NumberInfosManager.getInstance().setMarkInfoAsync(r0, r6, r7);
        return;
    L11:
        String r8 = r5.getStringExtra("flag");
        if (TextUtils.isEmpty(r8) == true) goto L14;
        NumberInfosManager.getInstance().setCustomMarkInfoAsync(r0, r8, r7);
        return;
    L14:
        NumberInfosManager.getInstance().clearMarkInfoAsync(r0, new AnonymousClass9(this));
        return;
    L20:
        return;
    }

    @Override // obric.widget.ButtonTabGroup.OnButtonGroupItemClickListener
    public void onButtonGroupItemClick(View r4, int r5) {
        if (r5 != this.mCurTabIndex) goto L5;
        return;
    L5:
        this.mCurTabIndex = r5;
        if (r5 != 0) goto L8;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_ALL_CALL_LOG);
        if (isInMissCallsPage() == false) goto L48;
        setInMissCallsPage(false);
        if (FEATURE_CMCC_CU == false) goto L44;
        this.mSimId = -1;
    L44:
        CallLogAdapter r6 = this.mAdapter;
        if (r6 == null) goto L47;
        r6.clearHashSet();
    L47:
        this.mSlideListView.restoreScrollState(false);
    L48:
        CallLogAdapter r3 = this.mAdapter;
        if (r3 == null) goto L56;
        r3.onContentChangedByScene("call log onButtonGroupItemClick in TAB_INDEX_ALL");
        return;
    L56:
        return;
    L8:
        if (r5 != 1) goto L10;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_MISSED_CALL_LOG);
        if (isInMissCallsPage() == true) goto L26;
    L27:
        setInMissCallsPage(true);
        if (FEATURE_CMCC_CU == true) goto L30;
    L32:
        CallLogAdapter r7 = this.mAdapter;
        if (r7 == null) goto L35;
        r7.clearHashSet();
    L35:
        this.mSlideListView.restoreScrollState(false);
    L36:
        CallLogAdapter r8 = this.mAdapter;
        if (r8 == null) goto L54;
        r8.onContentChangedByScene("call log onButtonGroupItemClick in TAB_INDEX_SIM1_OR_MISSED");
        return;
    L54:
        return;
    L30:
        if (DSUtils.useDSFeature() == false) goto L32;
        this.mSimId = 0;
        goto L32
    L26:
        if (this.mSimId == 0) goto L36;
    L10:
        if (r5 == 2) goto L13;
        return;
    L13:
        if (isInMissCallsPage() == true) goto L15;
    L16:
        setInMissCallsPage(true);
        this.mSimId = 1;
        CallLogAdapter r9 = this.mAdapter;
        if (r9 == null) goto L19;
        r9.clearHashSet();
    L19:
        this.mSlideListView.restoreScrollState(false);
    L20:
        CallLogAdapter r10 = this.mAdapter;
        if (r10 == null) goto L52;
        r10.onContentChangedByScene("call log onButtonGroupItemClick in TAB_INDEX_SIM2");
        return;
    L52:
        return;
    L15:
        if (this.mSimId == 1) goto L20;
        goto L16
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r9) {
        if (r9 != this.mBtnEdit) goto L6;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_EDIT_CALL_LOG);
        startEditMode();
        return;
    L6:
        if (r9 != this.mBtnCancel) goto L13;
        if (isEditMode() == true) goto L10;
        return;
    L10:
        if (this.mIsDeletingCallLogs == true) goto L24;
        endEditMode(true);
        return;
    L24:
        return;
    L13:
        if (r9 != this.mBtnBack) goto L16;
        getActivity().finish();
        return;
    L16:
        if (r9 == this.mBtnMenu) goto L18;
        return;
    L18:
        if (getActivity() != null) goto L20;
        return;
    L20:
        ArrayList r0 = new ArrayList();
        final boolean[] r1 = {false};
        r0.add(new MenuItem(getString(R.string.blocked_call_log_title), 0, 0, new AnonymousClass10(this, r1)));
        r0.add(new MenuItem(getString(R.string.common_settings), 0, 0, new AnonymousClass11(this)));
        final OPopover r10 = MenuUtilsKt.show(getActivity(), r9, r0);
        BlockedDataRequester.INSTANCE.queryBlockedCallAddStatusWithCallback(getActivity().getContentResolver(), new AnonymousClass12(this, r10, r1));
    }

    private void tryShowBlockedCallRedBadge(OPopover r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ViewGroup r1 = (ViewGroup) r2.getPopoverView().findViewById(R.id.popover_container);
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getChildCount() > 0) goto L10;
        return;
    L10:
        View r3 = r1.getChildAt(0);
        if (r3 != null) goto L13;
        return;
    L13:
        ImageView r4 = (ImageView) r3.findViewById(R.id.iv_popover_tail_image);
        if (r4 != null) goto L16;
        return;
    L16:
        UIUtils.setViewVisibility(r4, 0);
        r4.setImageResource(R.drawable.ic_red_badge_inset_4);
    }

    public static boolean hasMultiSimInDevice() {
        if (MultiSimAdapter.isMultiSimEnabled() == true) goto L5;
        return false;
    L5:
        if (MultiSimAdapter.hasIccCard(0) == true) goto L7;
        return false;
    L7:
        if (MultiSimAdapter.hasIccCard(1) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public void showDeleteConfirmDialog(boolean r9) {
        if (r9 == true) goto L4;
        int r10 = R.string.dialog_title_delete_call_log_no_record;
    L5:
        String r2 = getString(r10);
        final int r11 = BDSettingsEvent.EVENT_TYPE_CALL_LOGS_DELETE.getType();
        OActionSheet r0 = OSheetUtils.getActionSheet(getContext(), OInsetSheet.PanelWidth.NARROW_WIDTH, r2, null, getString(R.string.btn_confirm_delete), OSheetUtils.ContentViewStyle.RED, new AnonymousClass13(this, r11), new AnonymousClass14(this, r11));
        this.mDeleteConfirmDialog = r0;
        r0.setOnCancelListener(new AnonymousClass15(this, r11));
        this.mDeleteConfirmDialog.show();
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(getContext(), r11, true, false);
        return;
    L4:
        r10 = R.string.dialog_title_delete_call_log;
        goto L5
    }

    public void showDeleteCallLogDialog() {
        checkHasRecord(new AnonymousClass16(this));
    }

    private void checkHasRecord(final Function1<Boolean, Void> r3) {
        AsyncTask<Void, Void, Boolean> r0 = this.mHasRecordTask;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        CallLogAdapter r1 = this.mAdapter;
        if (r1 != null) goto L8;
    L12:
        r3.invoke(false);
        return;
    L8:
        if (r1.getSelectedIds().size() <= 0) goto L12;
        AsyncTask<Void, Void, Boolean> r2 = new AnonymousClass17(this, r3);
        this.mHasRecordTask = r2;
        r2.execute(new Void[0]);
    }

    private Boolean hasRecord(ArrayList<Long> r10) {
        if (r10 != null) goto L5;
    L34:
        return false;
    L5:
        if (r10.size() <= 0) goto L34;
        String r5 = "_id IN (" + TextUtils.join(SimContactsConstants.EMAIL_SEP, r10) + ")";
        Cursor r11 = getActivity().getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date"}, r5, null, null);
        int r1 = r11.getColumnIndex("number");     // Catch: Throwable -> L27
        int r2 = r11.getColumnIndex("date");     // Catch: Throwable -> L27
        if (r1 == (-1)) goto L23;
        if (r2 == (-1)) goto L23;
    L13:
        if (r11.moveToNext() == false) goto L20;
        if (ObriceRecordSummaryUtils.recordFileNotExists(getActivity(), Long.valueOf(r11.getLong(r2)), r11.getString(r1)) == true) goto L13;
        if (r11 == null) goto L19;
        r11.close();
    L19:
        return true;
    L20:
        if (r11 == null) goto L22;
        r11.close();
    L22:
        return false;
    L23:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Calls table does not contain required columns");     // Catch: Throwable -> L27
        if (r11 == null) goto L26;
        r11.close();
    L26:
        return false;
    L27:
        th = move-exception;
        if (r11 != null) goto L35;
    L33:
        throw th;
    L35:
        r11.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);
        goto L33
    }

    private void doRemoveAction() {
        HashSet r0 = new HashSet(this.mAdapter.getSelectedIds());
        ArrayList<Integer> r1 = new ArrayList();
        ArrayList<Integer> r2 = new ArrayList();
        Cursor r3 = this.mAdapter.getCursor();
        if (r3 != null) goto L5;
        return;
    L5:
        int r4 = this.mAdapter.getCount();
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L12;
        if (r0.contains(Long.valueOf(this.mAdapter.getItemId(r6))) == false) goto L10;
        r1.add(Integer.valueOf(r6));
    L11:
        r6 = r6 + 1;
        goto L6
    L10:
        r2.add(Integer.valueOf(r6));
        goto L11
    L12:
        final MatrixCursor r5 = new MatrixCursor(r3.getColumnNames());
        if (r3.moveToFirst() == false) goto L23;
    L14:
        ArrayList r7 = new ArrayList();
        int r8 = r3.getColumnCount();
        if (r0.contains(Long.valueOf(r3.getLong(r3.getColumnIndex("_id")))) == true) goto L22;
        int r9 = 0;
    L18:
        if (r9 >= r8) goto L20;
        r7.add(getCursorValue(r3, r9));
        r9 = r9 + 1;
        goto L18
    L20:
        r5.addRow(r7);
    L22:
        if (r3.moveToNext() == true) goto L14;
    L23:
        final SlideListView r10 = this.mSlideListView;
        new AnonymousClass18(this, r10, r5).setResultListSize(r5.getCount()).start(r1, r2);
    }

    private Object getCursorValue(Cursor r2, int r3) {
        int r1 = r2.getType(r3);
        if (r1 != 0) goto L5;
        return null;
    L5:
        if (r1 == 1) goto L21;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L17;
        if (r1 != 4) goto L15;
        return r2.getBlob(r3);
    L15:
        throw new IllegalStateException("Invalid or unhandled data type");
    L17:
        return r2.getString(r3);
    L19:
        return Float.valueOf(r2.getFloat(r3));
    L21:
        return Long.valueOf(r2.getLong(r3));
    }

    private void startEditAnimation() {
        CallLogAdapter r0 = this.mAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mSlideListView == null) goto L10;
        r0.setIsEditMode(true);
        this.mAdapter.notifyDataSetChanged();
        this.mCalllogAnimator.startEdit(this.mSlideListView);
        return;
    }

    public void endEditAnimation() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        CallLogAdapter r0 = this.mAdapter;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.mSlideListView == null) goto L13;
        r0.setIsEditMode(false);
        this.mAdapter.notifyDataSetChanged();
        this.mCalllogAnimator.finishEdit(this.mSlideListView);
        return;
    }

    private void endEditWithoutAnimation() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        CallLogAdapter r0 = this.mAdapter;
        if (r0 == null) goto L9;
        r0.setIsEditMode(false);
        this.mAdapter.notifyDataSetChanged();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ContactsUtils.fatchVoiceMailNumber();
        int r1 = 8;
        if (this.mIsEditMode == true) goto L5;
        this.mBtnCancel.setVisibility(8);
        this.mBtnSelectedAllView.setVisibility(8);
        this.mBtnEdit.setVisibility(0);
    L6:
        OButton r0 = this.mBtnMenu;
        if (this.mIsShowSingleContactCalls == true) goto L10;
        r1 = 0;
    L10:
        r0.setVisibility(r1);
        if (this.mIsShowSingleContactCalls == false) goto L13;
        refreshData("CallLogFragment onResume");
        refreshUI();
    L13:
        CallFeatureModel.INSTANCE.addCallFeatureModelListener(this.summaryListener);
        Context r4 = getContext();
        if (r4 == null) goto L17;
        NotificationHelper.INSTANCE.cancelAllRecordNotification(r4);
        return;
    L17:
        return;
    L5:
        this.mBtnCancel.setVisibility(0);
        this.mBtnSelectedAllView.setVisibility(0);
        this.mBtnEdit.setVisibility(8);
        goto L6
    }

    private void setInMissCallsPage(boolean r1) {
        this.mInMissCallsPage = r1;
    }

    public boolean isInMissCallsPage() {
        return this.mInMissCallsPage;
    }

    private void updateVoicemailStatusMessage(Cursor r1) {
        VoicemailStatusHelper.StatusMessage r0 = this.mVoicemailStatusHelper.getStatusMessages(r1).get(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        stopRequestProcessing();
        SlideListView r0 = this.mSlideListView;
        if (r0 == null) goto L6;
        r0.hideQuickContact();
    L6:
        if (this.mPendingClearMissedCall == false) goto L12;
        KeyguardManager r1 = this.mKeyguardManager;
        if (r1 == null) goto L12;
        if (r1.inKeyguardRestrictedInputMode() == true) goto L12;
        this.mPendingClearMissedCall = false;
        this.mCallLogQueryHandler.markNewCallsAsOld();
        this.mCallLogQueryHandler.markMissedCallsAsRead();
        removeMissedCallNotifications();
        updateVoicemailNotifications();
    L12:
        CallFeatureModel.INSTANCE.removeCallFeatureModelListener(this.summaryListener);
    }

    public void stopRequestProcessing() {
        CallLogAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.stopRequestProcessing();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mVisibilityChanged == false) goto L5;
        updateOnExit();
    L5:
        this.mHandler.removeMessages(10);
        if (this.mIsEditMode == false) goto L12;
        endEditMode(false);
        OActionSheet r0 = this.mDeleteConfirmDialog;
        if (r0 == null) goto L12;
        if (r0.isShowing() == false) goto L12;
        this.mDeleteConfirmDialog.dismiss();
    L12:
        dismissLongMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Agent r0 = Agent.getInstance();
        if (this.mIsShowSingleContactCalls == false) goto L5;
        String r1 = SUB_TAG_SINGLE;
    L6:
        r0.onDetach(TAG, r1);
        Agent.getInstance().flush();
        if (DSUtils.isMultiSimEnabled() == false) goto L9;
        DSUtils.unregisterDSFeatureStatusListener(this);
    L9:
        CallLogAdapter r2 = this.mAdapter;
        if (r2 == null) goto L13;
        r2.stopRequestProcessing();
        this.mAdapter.changeCursor(null);
        return;
    L13:
        return;
    L5:
        r1 = SUB_TAG_ALL;
        goto L6
    }

    @Override // com.android.contacts.calllog.CallLogAdapter.CallFetcher
    public void fetchCalls() {
        if (this.mInMissCallsPage == true) goto L9;
        if (this.mIsShowSingleContactCalls == false) goto L7;
        this.mCallLogQueryHandler.fetchContactCalls(this.mSelection, this.mResult);
        return;
    L7:
        this.mCallLogQueryHandler.fetchAllCalls();
        return;
    L9:
        if (FEATURE_CMCC_CU == true) goto L11;
    L17:
        this.mCallLogQueryHandler.fetchMissCalls();
        return;
    L11:
        if (DSUtils.useDSFeature() == false) goto L17;
        int r0 = this.mSimId;
        if (r0 != 0) goto L15;
    L16:
        this.mCallLogQueryHandler.fetchSimCalls(r0);
        return;
    L15:
        if (1 == r0) goto L16;
    }

    public void startCallsQuery(String r4) {
        CallLogAdapter r0 = this.mAdapter;
        if (r0 == null) goto L5;
        r0.setLoading(true);
    L5:
        NewContactsTraceLog.INSTANCE.onCallLogPageLog("CallLogFragment startCallsQuery scene:" + r4);
        fetchCalls();
    }

    private void startVoicemailStatusQuery() {
        this.mCallLogQueryHandler.fetchVoicemailStatus();
    }

    public void startEditMode() {
        if (this.mIsEditMode == true) goto L18;
        this.mSlideListView.setSlideEnable(true);
        if (this.mIsShowSingleContactCalls == true) goto L7;
        this.mSlideListView.restoreScrollState(false);
        this.mSlideListView.setScrollEnabled(false);
    L7:
        this.mIsEditMode = true;
        this.mBtnCancel.setVisibility(0);
        this.mBtnSelectedAllView.setVisibility(0);
        if (this.mIsShowSingleContactCalls == false) goto L10;
        this.mBtnBack.setVisibility(8);
    L10:
        this.mBtnEdit.setVisibility(8);
        this.mBtnMenu.setVisibility(8);
        CallLogAdapter r0 = this.mAdapter;
        if (r0 == null) goto L13;
        r0.setIsEditMode(true);
    L13:
        startEditAnimation();
        BottomDeleteLayoutListener r1 = this.mBottomDeleteLayoutListener;
        if (r1 == null) goto L16;
        r1.startTransition(true);
    L16:
        refreshUI();
        return;
    }

    private boolean isEditMode() {
        return this.mIsEditMode;
    }

    private void endEditMode(boolean r5) {
        if (this.mIsEditMode == true) goto L5;
        return;
    L5:
        this.mIsEditMode = false;
        this.mSlideListView.setSlideEnable(false);
        if (this.mIsShowSingleContactCalls == false) goto L8;
        this.mBtnBack.setVisibility(0);
    L9:
        int r2 = 8;
        this.mBtnCancel.setVisibility(8);
        this.mBtnSelectedAllView.setVisibility(8);
        this.mBtnEdit.setVisibility(0);
        OButton r1 = this.mBtnMenu;
        if (this.mIsShowSingleContactCalls == true) goto L13;
        r2 = 0;
    L13:
        r1.setVisibility(r2);
        CallLogAdapter r3 = this.mAdapter;
        if (r3 == null) goto L16;
        r3.clearHashSet();
    L16:
        if (r5 == false) goto L20;
        endEditAnimation();
        BottomDeleteLayoutListener r6 = this.mBottomDeleteLayoutListener;
        if (r6 == null) goto L24;
        r6.startTransition(false);
    L24:
        CallLogAdapter r7 = this.mAdapter;
        if (r7 == null) goto L27;
        r7.clearHashSet();
    L27:
        refreshUI();
        return;
    L20:
        CallLogAdapter r8 = this.mAdapter;
        if (r8 == null) goto L23;
        r8.setIsEditMode(false);
    L23:
        endEditWithoutAnimation();
        goto L24
    L8:
        this.mSlideListView.setScrollEnabled(true);
        goto L9
    }

    public void refreshUI() {
        boolean r1 = true;
        if (this.mIsEditMode == false) goto L27;
        CallLogAdapter r0 = this.mAdapter;
        if (r0 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        BottomDeleteLayoutListener r3 = this.mBottomDeleteLayoutListener;
        if (r3 == null) goto L13;
        r3.setLayoutVisible(true);
        this.mBottomDeleteLayoutListener.setBottomBtnEnable(r2);
    L13:
        CallLogAdapter r4 = this.mAdapter;
        if (r4 == null) goto L16;
        int r5 = r4.getSelectedIds().size();
    L17:
        this.mOTitleBar.setTitleText(getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r5)}));
        CallLogAdapter r6 = this.mAdapter;
        if (r6 != null) goto L20;
    L22:
        int r7 = 0;
    L23:
        if (r5 == r7) goto L26;
        r1 = false;
    L26:
        this.mSelectedAll.setSelectAll(r1);
        return;
    L20:
        if (r6.getCursor() == null) goto L22;
        r7 = this.mAdapter.getCursor().getCount();
        goto L23
    L16:
        r5 = 0;
        goto L17
    L7:
        if (r0.getSelectedIds().size() <= 0) goto L9;
        r2 = true;
        goto L10
    L27:
        CallLogAdapter r8 = this.mAdapter;
        if (r8 != null) goto L30;
    L32:
        r1 = false;
    L33:
        this.mBtnEdit.setEnabled(r1);
        BottomDeleteLayoutListener r9 = this.mBottomDeleteLayoutListener;
        if (r9 == null) goto L37;
        r9.setLayoutVisible(false);
    L37:
        if (this.mIsShowSingleContactCalls == true) goto L39;
        this.mOTitleBar.setCenterView(this.mContactTitleBarCenterView);
        return;
    L39:
        this.mOTitleBar.setTitleText(getString(R.string.common_call_log));
        return;
    L30:
        if (r8.isEmpty() == true) goto L32;
        goto L32
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ViewPagerVisibilityListener
    public void onVisibilityChanged(boolean r2) {
        if (this.mVisibilityChanged == r2) goto L10;
        if (r2 == false) goto L7;
        refreshData("CallLogFragment onVisibilityChanged visible");
        goto L10
    L7:
        if (this.mIsEditMode == false) goto L9;
        endEditMode(false);
    L9:
        updateOnExit();
        dismissLongMenu();
    L10:
        this.mVisibilityChanged = r2;
    }

    private void refreshData(String r4) {
        if (this.mProviderIsNormal == true) goto L5;
        return;
    L5:
        CallLogAdapter r0 = this.mAdapter;
        if (r0 == null) goto L8;
        r0.invalidateCache();
    L8:
        Message r1 = Message.obtain();
        r1.what = 1000;
        r1.obj = r4;
        this.mHandler.sendMessageDelayed(r1, 100);
        this.mHandler.sendEmptyMessageDelayed(10, 900);
    }

    private void removeMissedCallNotifications() {
        new Thread(new AnonymousClass20(this)).start();
    }

    private void updateOnExit() {
        CallLogAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.stopRequestProcessing();
        return;
    }

    private void updateOnEntry() {
        updateOnTransition(false);
    }

    private void updateOnTransition(boolean r2) {
        if (this.mCallLogQueryHandler != null) goto L5;
        return;
    L5:
        KeyguardManager r0 = this.mKeyguardManager;
        if (r0 != null) goto L8;
    L13:
        this.mPendingClearMissedCall = true;
        return;
    L8:
        if (r0.inKeyguardRestrictedInputMode() == true) goto L13;
        this.mCallLogQueryHandler.markNewCallsAsOld();
        if (r2 == true) goto L12;
        this.mCallLogQueryHandler.markMissedCallsAsRead();
    L12:
        removeMissedCallNotifications();
        updateVoicemailNotifications();
    }

    private void updateVoicemailNotifications() {
        if (getActivity() == null) goto L10;
        if (getActivity().isDestroyed() == true) goto L10;
        Intent r0 = new Intent(getActivity(), CallLogNotificationsService.class);
        r0.setAction(CallLogNotificationsService.ACTION_UPDATE_NOTIFICATIONS);
        getActivity().startService(r0);
        return;
    L10:
        if (getActivity() != null) goto L12;
        String r3 = "get activity is null";
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failure to updateVoicemailNotifications, getActivity is:".concat(r3));
        return;
    L12:
        r3 = "activity is destroyed";
        goto L13
    }

    @Override // com.android.contacts.activities.DialtactsActivity.PageEnableListener
    public void setEnable(boolean r2, boolean r3) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEnable visible:" + r2 + "; mProviderIsNormal:" + this.mProviderIsNormal);
    L5:
        this.mProviderIsNormal = r2;
        if (r2 == false) goto L9;
        refreshData("CallLogFragment setEnable visible:" + r2);
        return;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r2, int r3) {
        if (r3 == 0) goto L4;
        ContactsUtils.setCpuBoost(4000);
    L5:
        CallLogAdapter r4 = this.mAdapter;
        if (r4 == null) goto L9;
        r4.setScrollState(r3);
    L9:
        if (r3 == 1) goto L11;
        return;
    L11:
        if ((getActivity() instanceof DialtactsActivity) == false) goto L15;
        ((DialtactsActivity) getActivity()).hideDialpad();
        return;
    L15:
        return;
    L4:
        ContactsUtils.releaseCpuBoost();
        ContactDetailCacheManager.getInstance().refreshCache(this.mSlideListView);
        goto L5
    }

    @Override // com.android.contacts.activities.DialtactsActivity.onBackPressListener
    public boolean backToTopState() {
        if (isEditMode() == true) goto L5;
        return true;
    L5:
        if (this.mSlideListView.isSelecting() == false) goto L7;
        return false;
    L7:
        endEditMode(true);
        return false;
    }

    @Override // com.android.contacts.DSUtils.DSFatureStatusListener
    public void onDSFeatureStatusChanged() {
        if (DSUtils.useDSFeature() == false) goto L8;
        CallLogQueryHandler r0 = this.mCallLogQueryHandler;
        if (r0 == null) goto L8;
        r0.updateShowSimId();
    L8:
        if (FEATURE_CMCC_CU == true) goto L10;
    L12:
        CallLogAdapter r1 = this.mAdapter;
        if (r1 == null) goto L16;
        r1.notifyDataSetChanged();
        return;
    L16:
        return;
    L10:
        if (this.mIsShowSingleContactCalls == true) goto L12;
        updateCallLogFilter(getActivity());
        goto L12
    }

    public List<Long> getCurrentVisibleContact() {
        CallLogAdapter r0 = this.mAdapter;
        if (r0 != null) goto L5;
        return null;
    L5:
        Cursor r1 = r0.getCursor();
        if (r1 != null) goto L8;
        return null;
    L8:
        Map<Integer, Integer> r2 = updatePositionIdMap(r1);
        int r3 = this.mSlideListView.getFirstVisiblePosition();
        int r4 = this.mSlideListView.getLastVisiblePosition();
        ArrayList r5 = new ArrayList();
    L9:
        if (r3 > r4) goto L27;
        if (r3 > r1.getCount()) goto L26;
        if (r2.get(Integer.valueOf(r3)) != null) goto L16;
        int r6 = r3;
    L17:
        boolean r7 = r1.moveToPosition(r6);
        if (r3 != r4) goto L20;
        double r8 = 0.6d;
    L21:
        if (r7 == false) goto L26;
        int r9 = r1.getColumnIndex("_id");
        boolean r10 = hasItemVisible(r3, r8);
        if (r9 == (-1)) goto L26;
        if (r10 == false) goto L26;
        r5.add(Long.valueOf(r1.getLong(r9)));
        goto L26
    L20:
        r8 = 0.65d;
        goto L21
    L16:
        r6 = r2.get(Integer.valueOf(r3)).intValue();
    L26:
        r3 = r3 + 1;
        goto L9
    L27:
        return r5;
    }

    private boolean hasItemVisible(int r10, double r11) {
        View r12 = this.mSlideListView.getChildAt(r10);
        if (r12 != null) goto L5;
        return false;
    L5:
        int r9 = this.mSlideListView.getHeight();
        int r1 = r12.getMeasuredHeight();
        int r2 = r12.getTop();
        int r13 = r12.getBottom();
        if (r2 >= 0) goto L8;
        double r5 = (((double) (r2 + r1)) * 1.0d) / (((double) r1) * 1.0d);
    L9:
        if (r13 <= r9) goto L12;
        r5 = (((double) (r1 - (r13 - r9))) * 1.0d) / (((double) r1) * 1.0d);
    L12:
        if (r5 <= r11) goto L15;
        return true;
    L15:
        return false;
    L8:
        r5 = 1.0d;
        goto L9
    }

    private Map<Integer, Integer> updatePositionIdMapMin(Cursor r17) {
        HashMap r2 = new HashMap();
        if (r17 != null) goto L5;
        return r2;
    L5:
        int r5 = 1;
        if (r17.getCount() != 1) goto L10;
        r2.put(0, 0);
        return r2;
    L10:
        if (r17.moveToPosition(0) == true) goto L12;
        return r2;
    L12:
        String r3 = r17.getString(1);
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        int r7 = 4;
        int r8 = r17.getInt(4);
        long r10 = r17.getLong(2);
        Calendar r12 = Calendar.getInstance();
        r12.setTimeInMillis(r10);
        Calendar r11 = Calendar.getInstance();
        int r13 = 0;
        int r14 = 0;
    L17:
        if (r17.moveToNext() == false) goto L48;
        String r15 = r17.getString(r5);
        if (r15 != null) goto L21;
        r15 = "";
    L21:
        int r16 = r17.getInt(r7);
        long r4 = r17.getLong(2);
        r11.setTimeInMillis(r4);
        if (equalNumbers(r3, r15) == true) goto L25;
    L23:
        int r6 = 0;
        int r9 = 1;
    L41:
        if (r6 == 0) goto L43;
        r14 = r14 + 1;
    L44:
        r12.setTimeInMillis(r4);
        if (r17.isLast() == false) goto L47;
        r2.put(Integer.valueOf(r13), Integer.valueOf(r14));
    L47:
        r5 = r9;
        r3 = r15;
        r8 = r16;
        r7 = 4;
        goto L17
    L43:
        r2.put(Integer.valueOf(r13), Integer.valueOf(r14));
        r14 = r14 + 1;
        r13 = r13 + 1;
        goto L44
    L25:
        if (isSameDay(r12, r11) == false) goto L23;
        if (r8 == r7) goto L38;
        if (r8 == 3) goto L38;
        r9 = 1;
        if (r16 == 7) goto L37;
        if (r16 == 1) goto L37;
        if (r16 == 2) goto L37;
    L36:
        r6 = 0;
    L37:
        r6 = r9;
    L38:
        r9 = 1;
        if (r16 != 3) goto L36;
    L48:
        return r2;
    }

    private Map<Integer, Integer> updatePositionIdMap(Cursor r18) {
        HashMap r2 = new HashMap();
        if (r18 != null) goto L5;
        return r2;
    L5:
        int r5 = 1;
        if (r18.getCount() != 1) goto L10;
        r2.put(0, 0);
        return r2;
    L10:
        if (r18.moveToPosition(0) == true) goto L12;
        return r2;
    L12:
        String r3 = r18.getString(1);
        String r6 = "";
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        int r8 = r18.getInt(4);
        long r10 = r18.getLong(2);
        Calendar r12 = Calendar.getInstance();
        r12.setTimeInMillis(r10);
        Calendar r11 = Calendar.getInstance();
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L17:
        if (r18.moveToNext() == false) goto L48;
        String r16 = r18.getString(r5);
        if (r16 != null) goto L21;
        r16 = r6;
    L21:
        int r4 = r18.getInt(4);
        String r17 = r6;
        long r7 = r18.getLong(2);
        r11.setTimeInMillis(r7);
        if (equalNumbers(r3, r16) == true) goto L25;
    L23:
        int r9 = 0;
        int r19 = 1;
    L41:
        if (r9 == 0) goto L43;
        int r20 = Math.min(r15, r14);
        r14 = r14 + 1;
        r15 = r20;
    L44:
        r12.setTimeInMillis(r7);
        if (r18.isLast() == false) goto L47;
        r2.put(Integer.valueOf(r13), Integer.valueOf(r15));
    L47:
        r5 = r19;
        r3 = r16;
        r6 = r17;
        r8 = r4;
        goto L17
    L43:
        r2.put(Integer.valueOf(r13), Integer.valueOf(r15));
        r14 = r14 + 1;
        r13 = r13 + 1;
        r15 = r14;
        goto L44
    L25:
        if (isSameDay(r12, r11) == false) goto L23;
        if (r8 == 4) goto L38;
        if (r8 == 3) goto L38;
        r19 = 1;
        if (r4 == 7) goto L37;
        if (r4 == 1) goto L37;
        if (r4 == 2) goto L37;
    L36:
        r9 = 0;
    L37:
        r9 = r19;
    L38:
        r19 = 1;
        if (r4 != 3) goto L36;
    L48:
        return r2;
    }

    private boolean isSameDay(Calendar r3, Calendar r4) {
        if (r3.get(1) == r4.get(1)) goto L5;
        return false;
    L5:
        if (r3.get(2) == r4.get(2)) goto L7;
        return false;
    L7:
        if (r3.get(6) != r4.get(6)) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean equalNumbers(String r2, String r3) {
        if (PhoneNumberUtils.isUriNumber(r2) == true) goto L18;
        if (PhoneNumberUtils.isUriNumber(r3) == true) goto L18;
        if (TextUtils.isEmpty(r2) == true) goto L16;
        if (TextUtils.isEmpty(r3) == true) goto L16;
        boolean r1 = r2.equals(r3);
        if (r1 == false) goto L14;
        return r1;
    L14:
        return PhoneNumberUtils.compare(r2, r3, false);
    L16:
        return PhoneNumberUtils.compare(r2, r3, false);
    L18:
        return compareSipAddresses(r2, r3);
    }

    private boolean compareSipAddresses(String r6, String r7) {
        if (r6 == null) goto L19;
        if (r7 == null) goto L19;
        int r0 = r6.indexOf(64);
        String r1 = "";
        if (r0 == (-1)) goto L8;
        String r4 = r6.substring(0, r0);
        String r2 = r6.substring(r0);
        r6 = r4;
    L9:
        int r5 = r7.indexOf(64);
        if (r5 == (-1)) goto L13;
        String r3 = r7.substring(0, r5);
        String r8 = r7.substring(r5);
        r7 = r3;
        r1 = r8;
    L13:
        if (r6.equals(r7) == true) goto L15;
        return false;
    L15:
        if (r2.equalsIgnoreCase(r1) == false) goto L21;
        return true;
    L21:
        return false;
    L8:
        r2 = "";
    L19:
        return TextUtils.equals(r6, r7);
    }
}
