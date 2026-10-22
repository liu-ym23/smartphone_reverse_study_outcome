package com.android.contacts.pick;

import android.app.Activity;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PinnedHeaderList.HeadersListView;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.list.OnContactPickerActionListener;
import com.android.contacts.list.OnDataPickerActionListener;
import com.android.contacts.list.SamContact;
import com.android.contacts.list.ShortcutIntentBuilder;
import com.android.contacts.list.SlideListView;
import com.android.contacts.search.anim.SearchSwitchAnimHelper;
import com.android.contacts.util.BytedanceApi;
import com.bytedance.common.utility.UIUtils;
import com.obric.immersive.Immersive;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.forms.OEditText;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.ui.OFloatingTitleBarHolder;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import obric.util.NavigationBarHelper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PickerFragment extends AbstractFragment implements View.OnClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnTouchListener, View.OnFocusChangeListener, IPickerSearchBarView, ShortcutIntentBuilder.OnShortcutIntentCreatedListener {
    public static final String CONTACT_SORT_CNAME = "sort_key";
    private static final int NOTIFY_DATA_CHANGE = 1000;
    private static final int REFRESH_VISIBLE_LIST_ITEMS = 1001;
    public static final String STATE_ADD = "STATE_ADD";
    public static final String STATE_BACK = "STATE_BACK";
    public static final String STATE_CANCEL = "STATE_CANCEL";
    public static final String STATE_DONE = "STATE_DONE";
    public static final String STATE_NONE = "STATE_NONE";
    public static final String STATE_SEND = "STATE_SEND";
    private static String TAG = "PickerFragment";
    public static final int TITLE_BAR_BLUE_STYLE = 2131952329;
    public static final int TITLE_BAR_DEFAULT_STYLE = 2131952335;
    private String TAG_LIST;
    public final int TOKEN_SEARCH_CONTACT;
    public final int TOKEN_SEARCH_CONTACTS;
    public final int TOKEN_SEARCH_EMAIL;
    public final int TOKEN_SEARCH_PHONE;
    private final String TRACKER_TAG;
    protected Activity mActivity;
    protected View mBtnLeftBack;
    protected View mBtnLeftCancel;
    protected View mBtnRightAdd;
    protected View mBtnRightDone;
    protected View mBtnRightSendToDesk;
    public SlideListView mCalllogListView;
    private RelativeLayout mContactBody;
    public OnContactPickerActionListener mContactPickerListener;
    public String mContactQueryWhere;
    public ArrayList<SamContact> mContacts;
    public ContactsContent mContactsContent;
    private boolean mDestoryed;
    private View mEmptyView;
    protected int mEmptyViewRes;
    private LinearLayout mEmptyViewRoot;
    public Bundle mExtras;
    protected OFloatingTitleBarHolder mFloatingTitleBarHolder;
    private Handler mHandler;
    private boolean mInContacts;
    private boolean mLegacyCompatibility;
    private LinearLayout mListContainer;
    public HeadersListView mListView;
    private MultiSlideCheckListener mMultiSlideCheckListener;
    private Observer<Integer> mNavigationBarObserver;
    public OIconButtonFloating mOSearchRightBtn;
    public LinearLayout mOSearchTitleBar;
    private Point mOutSize;
    public ContactPhotoManager mPhotoManager;
    private View mPickerFragment;
    public OnDataPickerActionListener mPickerListener;
    private SlideListView.Listener mPickerSlideCheckListener;
    private ExecutorService mPool;
    private PreferencesCallback mPreferencesCallback;
    private IPickerSearchBarPresenter mPresenter;
    private OIndexScrollbar.QBListener mQBListener;
    protected OIndexScrollbar mQuickBar;
    public TextView mSeachResultBG;
    private RelativeLayout mSeachResultView;
    public TextView mSearchEmptyView;
    public SlideListView mSearchResultListView;
    private SearchSwitchAnimHelper mSearchSwitchANimHelper;
    public OSearchBar mSearchbarView;
    private OIndexScrollbar.SurnameListener mSurnameListener;
    public OFloatingTitleBar mTitleBar;
    protected String mTitleBarLeftStatus;
    protected String mTitleBarRightStatus;
    private SlideListView.TouchMonitorListener mTouchMonitorListener;
    private boolean misInSearchMode;
    OEditText oSearchEditor;

    class ContactsContent extends ContentObserver {
        final /* synthetic */ PickerFragment this$0;

        public ContactsContent(PickerFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            super.onChange(r1);
            if (this.this$0.getActivity() != null) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(PickerFragment.access$300(), "Result null from the getActivity, Maybe it relaunch.");
            return;
        L6:
            this.this$0.triggerLoad();
        }
    }

    public interface MultiSlideCheckListener {
        boolean isSlideChecked(SlideListView r1, int r2);

        void setSlideChecked(SlideListView r1, int r2, boolean r3);
    }

    static {
    }

    public abstract ArrayList<SamContact> getContacts();

    protected int getEmptyDrawable() {
        return R.drawable.emptyview_contacts_image;
    }

    public abstract ArrayList<Long> getSelectedIds();

    public abstract void hideUselessView();

    protected boolean isSearchInPlaceEnabled() {
        return false;
    }

    public abstract void notifyData();

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View r1, boolean r2) {
    }

    public void onPreferencesChanged() {
    }

    public void onQueryTextChangeIView(String r1) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    protected void onSearchCanceledInPlace() {
    }

    @Override // com.android.contacts.list.ShortcutIntentBuilder.OnShortcutIntentCreatedListener
    public void onShortcutIntentCreated(Uri r1, Intent r2) {
    }

    protected abstract void onTitleBarBtnClick(View r1);

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        return false;
    }

    public abstract void refreshVisibleListItems();

    public abstract void setSearchString(Uri r1, String r2);

    public abstract void setTitleLabel();

    public void updateTitleLabel(int r1) {
    }

    public boolean useSelfUpdateTitleBarStatus() {
        return false;
    }

    public PickerFragment() {
        this.TRACKER_TAG = "PickerFragment";
        this.mBtnLeftCancel = null;
        this.mBtnLeftBack = null;
        this.mBtnRightDone = null;
        this.mBtnRightSendToDesk = null;
        this.mBtnRightAdd = null;
        this.mTitleBarLeftStatus = "STATE_NONE";
        this.mTitleBarRightStatus = "STATE_NONE";
        this.mActivity = null;
        this.mInContacts = true;
        this.mEmptyView = null;
        this.mEmptyViewRoot = null;
        this.mEmptyViewRes = -1;
        this.misInSearchMode = false;
        this.TAG_LIST = "TAG_LIST";
        this.mContactQueryWhere = null;
        this.mContactBody = null;
        this.mListContainer = null;
        this.mOutSize = new Point();
        this.TOKEN_SEARCH_PHONE = 1001;
        this.TOKEN_SEARCH_EMAIL = 1002;
        this.TOKEN_SEARCH_CONTACT = 1003;
        this.TOKEN_SEARCH_CONTACTS = 1004;
        this.mNavigationBarObserver = new AnonymousClass1(this);
        this.mPickerSlideCheckListener = new AnonymousClass2(this);
        this.mQBListener = new AnonymousClass8(this);
        this.mSurnameListener = new AnonymousClass9(this);
        this.mTouchMonitorListener = new AnonymousClass10(this);
        this.mPool = Executors.newSingleThreadExecutor();
        this.mHandler = new AnonymousClass12(this);
    }

    static /* synthetic */ MultiSlideCheckListener access$000(PickerFragment r0) {
        return r0.mMultiSlideCheckListener;
    }

    static /* synthetic */ IPickerSearchBarPresenter access$100(PickerFragment r0) {
        return r0.getPresenter();
    }

    static /* synthetic */ Handler access$200(PickerFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ String access$300() {
        return TAG;
    }

    static /* synthetic */ boolean access$400(PickerFragment r0) {
        return r0.mDestoryed;
    }

    public void setPrefsCallback(PreferencesCallback r1) {
        this.mPreferencesCallback = r1;
    }

    protected int getSortOrder() {
        return this.mPreferencesCallback.getSortOrder();
    }

    protected int getDisplayOrder() {
        return this.mPreferencesCallback.getDisplayOrder();
    }

    protected void updateTitleBarStatus(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r3 = "STATE_NONE";
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r4 = "STATE_NONE";
    L9:
        if (this.mTitleBarLeftStatus.equals(r3) == true) goto L11;
    L13:
        this.mTitleBarLeftStatus = r3;
        this.mTitleBarRightStatus = r4;
        this.mFloatingTitleBarHolder.startButtonToState(r3);
        this.mFloatingTitleBarHolder.endButtonToState(this.mTitleBarRightStatus);
        if (this.mTitleBarRightStatus.equals(STATE_DONE) == true) goto L16;
        this.mTitleBar.setEndButtonGroupStyle(2131952335);
        return;
    L16:
        this.mTitleBar.setEndButtonGroupStyle(2131952329);
        return;
    L11:
        if (this.mTitleBarRightStatus.equals(r4) == false) goto L13;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.mActivity = r1;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        initPresenter();
    }

    protected void initPresenter() {
        PickerSearchBarPresenter r0 = new PickerSearchBarPresenter();
        this.mPresenter = r0;
        r0.attachView(this, getActivity());
    }

    private IPickerSearchBarPresenter getPresenter() {
        if (this.mPresenter != null) goto L6;
        PickerSearchBarPresenter r0 = new PickerSearchBarPresenter();
        this.mPresenter = r0;
        r0.attachView(this, getActivity());
    L6:
        return this.mPresenter;
    }

    @Override // com.android.contacts.pick.IPickerSearchBarView
    public OSearchBar getSearchBar() {
        return this.mSearchbarView;
    }

    public View inflateAndSetupView(LayoutInflater r4, ViewGroup r5, Bundle r6, int r7) {
        getActivity().getWindowManager().getDefaultDisplay().getSize(this.mOutSize);
        this.mPickerFragment = r4.inflate(r7, r5, false);
        updateTitleBarView();
        setTitleLabel();
        LinearLayout r8 = (LinearLayout) this.mPickerFragment.findViewById(R.id.search_container);
        this.mOSearchTitleBar = r8;
        r8.setOnClickListener(null);
        OIconButtonFloating r9 = (OIconButtonFloating) this.mPickerFragment.findViewById(R.id.search_field_button);
        this.mOSearchRightBtn = r9;
        r9.setVisibility(8);
        this.mOSearchRightBtn.setOnClickListener(new AnonymousClass3(this));
        this.mSearchbarView = (OSearchBar) this.mPickerFragment.findViewById(R.id.search_field_bar);
        ContactsUtils.dipTopx(getContext(), 5.0d);
        OEditText r10 = this.mSearchbarView.getInputView();
        this.oSearchEditor = r10;
        r10.setSingleLine(true);
        this.oSearchEditor.setSaveEnabled(false);
        this.oSearchEditor.setImeOptions(6);
        this.oSearchEditor.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        this.oSearchEditor.setOnFocusChangeListener(new AnonymousClass4(this));
        this.mSeachResultView = (RelativeLayout) this.mPickerFragment.findViewById(R.id.seachresultview);
        SlideListView r11 = (SlideListView) this.mPickerFragment.findViewById(R.id.search_listview);
        this.mSearchResultListView = r11;
        r11.setOnItemClickListener(this);
        this.mSearchResultListView.setOnScrollListener(this);
        this.mSearchResultListView.setSlideListener(this.mPickerSlideCheckListener);
        this.mSearchResultListView.setScrollEnabled(false);
        this.mSearchResultListView.setDivider(null);
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(this.mSearchResultListView);
        TextView r12 = (TextView) this.mPickerFragment.findViewById(R.id.search_empty_view);
        this.mSearchEmptyView = r12;
        r12.setOnClickListener(new AnonymousClass5(this));
        TextView r13 = (TextView) this.mPickerFragment.findViewById(R.id.sv_background);
        this.mSeachResultBG = r13;
        r13.setOnClickListener(new AnonymousClass6(this));
        this.misInSearchMode = false;
        HeadersListView r14 = (HeadersListView) this.mPickerFragment.findViewById(R.id.main_list);
        this.mListView = r14;
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(r14);
        this.mListView.setScrollEnabled(false);
        this.mListView.setTouchMonitorListener(this.mTouchMonitorListener);
        SlideListView r15 = (SlideListView) this.mPickerFragment.findViewById(R.id.list);
        this.mCalllogListView = r15;
        r15.setOnItemClickListener(this);
        this.mCalllogListView.setSlideListener(this.mPickerSlideCheckListener);
        this.mEmptyViewRoot = (LinearLayout) this.mPickerFragment.findViewById(R.id.listview_pick_emptyview);
        this.mEmptyViewRes = R.layout.contact_pick_emptyview_stub;
        this.mContactBody = (RelativeLayout) this.mPickerFragment.findViewById(R.id.contacts_body);
        this.mListContainer = (LinearLayout) this.mPickerFragment.findViewById(R.id.list_container);
        OIndexScrollbar r16 = (OIndexScrollbar) this.mPickerFragment.findViewById(R.id.main_quickcontactbar);
        this.mQuickBar = r16;
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(r16);
        this.mPhotoManager = ContactPhotoManager.getInstance(this.mActivity);
        this.mQuickBar.setQBListener(this.mQBListener);
        this.mQuickBar.setSurnameListener(this.mSurnameListener);
        this.mQuickBar.setOnTouchListener(new AnonymousClass7(this));
        this.mListView.setOnScrollListener(this);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setSlideListener(this.mPickerSlideCheckListener);
        this.mListView.setTag(this.TAG_LIST);
        this.mListView.setQuickBar(this.mQuickBar);
        this.mContactsContent = new ContactsContent(this, new Handler());
        TextView r17 = (TextView) this.mPickerFragment.findViewById(R.id.option_title_bottom);
        if (r17 == null) goto L5;
        BytedanceApi.setMaxTextSize(r17, getResources().getDimension(R.dimen.option_title_text_size));
    L5:
        this.mDestoryed = false;
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().observeForever(this.mNavigationBarObserver);
        if (isSearchInPlaceEnabled() == false) goto L16;
        TextView r18 = this.mSearchEmptyView;
        if (r18 == null) goto L16;
        if (this.mEmptyViewRoot == null) goto L16;
        ViewGroup r19 = (ViewGroup) r18.getParent();
        if (r19 == null) goto L14;
        r19.removeView(this.mSearchEmptyView);
    L14:
        this.mEmptyViewRoot.addView(this.mSearchEmptyView, -1, -1);
        this.mSearchEmptyView.setVisibility(8);
        this.mListView.setOnTouchListener(new PickerFragment$$ExternalSyntheticLambda1(this));
    L16:
        return this.mPickerFragment;
    }

    /* JADX INFO: renamed from: lambda$inflateAndSetupView$0$com-android-contacts-pick-PickerFragment, reason: not valid java name */
    /* synthetic */ boolean m221x58a8f33d(View r1, MotionEvent r2) {
        if (r2.getActionMasked() != 0) goto L7;
        hideSoftKeyboard();
        return false;
    L7:
        return false;
    }

    private void updateTitleBarView() {
        this.mTitleBar = (OFloatingTitleBar) this.mPickerFragment.findViewById(R.id.otitlebar);
        OFloatingTitleBarHolder r0 = new OFloatingTitleBarHolder(this.mTitleBar);
        this.mFloatingTitleBarHolder = r0;
        this.mBtnRightSendToDesk = r0.addEndAction(STATE_SEND, getString(R.string.send_to_the_desktop), this);
        this.mBtnRightDone = this.mFloatingTitleBarHolder.addEndAction(STATE_DONE, R.drawable.standard_icon_complete_selector_22_white, this);
        this.mBtnRightAdd = this.mFloatingTitleBarHolder.addEndAction(STATE_ADD, R.drawable.standard_icon_common_add_selector, this);
        this.mBtnLeftCancel = this.mFloatingTitleBarHolder.addStartAction("STATE_CANCEL", R.drawable.icon_cancel_22_22, this);
        this.mBtnLeftBack = this.mFloatingTitleBarHolder.addStartAction(STATE_BACK, R.drawable.icon_back_22_22, this);
        if (useSelfUpdateTitleBarStatus() == true) goto L6;
        updateTitleBarStatus("STATE_CANCEL", STATE_DONE);
        return;
    }

    public void onClick(View r1) {
        onTitleBarBtnClick(r1);
    }

    public void showKeyboard(View r2) {
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(r2, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        hideUselessView();
    }

    public void setEmptyView(ListView r5) {
        if (this.mEmptyView != null) goto L5;
        View r0 = ((LayoutInflater) this.mActivity.getSystemService("layout_inflater")).inflate(this.mEmptyViewRes, this.mEmptyViewRoot, false);
        this.mEmptyView = r0;
        OPageStatus r1 = (OPageStatus) r0.findViewById(R.id.black_view);
        r1.setTitle(getEmptyTitle());
        r1.setMessage(getEmptyMessage());
        this.mEmptyViewRoot.addView(this.mEmptyView, -1, -1);
    L5:
        r5.setEmptyView(this.mEmptyView);
    }

    protected String getEmptyTitle() {
        return getString(R.string.recentCalls_empty);
    }

    protected String getEmptyMessage() {
        return getString(R.string.recentCalls_empty_secondary);
    }

    public void setMultiSlideCheckListener(MultiSlideCheckListener r1) {
        this.mMultiSlideCheckListener = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isSearch() == false) goto L10;
        OIconButtonFloating r0 = this.mOSearchRightBtn;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getVisibility() == 0) goto L12;
        this.mOSearchRightBtn.setVisibility(0);
        return;
    L12:
        return;
    }

    public void hideSoftKeyboard() {
        InputMethodManager r0 = (InputMethodManager) this.mActivity.getSystemService("input_method");
        if (this.mInContacts == false) goto L6;
        r0.hideSoftInputFromWindow(this.mListView.getWindowToken(), 0);
    L6:
        if (this.misInSearchMode == false) goto L9;
        r0.hideSoftInputFromWindow(this.mSearchResultListView.getWindowToken(), 0);
        return;
    }

    public void setOnPhoneNumberPickerActionListener(OnDataPickerActionListener r1) {
        this.mPickerListener = r1;
    }

    public void setContactPickerActionListener(OnContactPickerActionListener r1) {
        this.mContactPickerListener = r1;
    }

    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        hideSoftKeyboard();
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L6;
        r0.hideLetterGrid();
        return;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r2, int r3) {
        if (r3 != 2) goto L5;
        this.mQuickBar.hideLetterGrid();
    L5:
        if (r3 != 2) goto L7;
    L12:
        this.mPhotoManager.pause();
        hideSoftKeyboard();
        return;
    L7:
        if (r3 == 1) goto L12;
        if (this.mQuickBar.isPerformingAnim() == true) goto L14;
        this.mPhotoManager.resume();
        return;
    }

    @Override // com.android.contacts.pick.IPickerSearchBarView
    public void setSoftKeyboardHideIView() {
        hideSoftKeyboard();
    }

    @Override // com.android.contacts.pick.IPickerSearchBarView
    public void startContactAnimationIView() {
        ContactsUtils.setAnimatorScale(this.mActivity);
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L8;
        if (r0.isLetterGridShow() == false) goto L8;
        this.mQuickBar.hideLetterGrid();
    L8:
        if (isSearchInPlaceEnabled() == false) goto L11;
        enterSearchNoAnim();
        return;
    L11:
        this.mSeachResultView.setVisibility(0);
        this.mSeachResultBG.setVisibility(0);
        enterSearch();
    }

    private SearchSwitchAnimHelper getSearchAnimHelper() {
        if (this.mSearchSwitchANimHelper != null) goto L6;
        this.mOSearchRightBtn.measure(0, 0);
        int r0 = ContactsUtils.dipTopx(getContext(), 8.0d);
        int r2 = this.mOSearchRightBtn.getMeasuredWidth();
        int r3 = this.mSearchbarView.getWidth();
        int r4 = (r3 - r2) - r0;
        int r1 = (int) UIUtils.dip2Px(this.mActivity, 16.0f);
        this.mSearchSwitchANimHelper = new SearchSwitchAnimHelper().setSearchBox(this.mSearchbarView, r3, r4, (-this.mTitleBar.getHeight()) + r1).setCancelButton(this.mOSearchRightBtn, true).setSearchPageContainer(this.mContactBody).setSearchResultContainer(this.mSeachResultView).addSearchBoxParentContent(this.mTitleBar, true).addSearchBoxParentContent(this.mListContainer, false);
    L6:
        return this.mSearchSwitchANimHelper;
    }

    private void enterSearch() {
        this.misInSearchMode = true;
        getPresenter().setCursorVisible(true);
        this.mListView.invalidate();
        getSearchAnimHelper().playEnterAnim(new PickerFragment$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ Unit lambda$enterSearch$1(Boolean r0) {
        return Unit.INSTANCE;
    }

    private void enterSearchNoAnim() {
        this.misInSearchMode = true;
        getPresenter().setCursorVisible(true);
    }

    private void exitSearch() {
        getSearchAnimHelper().playExitAnim(new PickerFragment$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$exitSearch$2$com-android-contacts-pick-PickerFragment, reason: not valid java name */
    /* synthetic */ Unit m220lambda$exitSearch$2$comandroidcontactspickPickerFragment(Boolean r3) {
        ArrayList<SamContact> r4 = this.mContacts;
        if (r4 != null) goto L5;
    L7:
        PickerAdapter r5 = (PickerAdapter) this.mListView.getAdapter();
        if (r5 == null) goto L10;
        r5.refreshCopiedContacts(true);
    L10:
        this.mSearchResultListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultListView.setVisibility(8);
        this.mSeachResultBG.setVisibility(8);
        this.misInSearchMode = false;
        getPresenter().setCursorVisible(false);
        return Unit.INSTANCE;
    L5:
        if (r4.size() < 30) goto L7;
        this.mQuickBar.setVisibility(0);
        goto L7
    }

    @Override // com.android.contacts.pick.IPickerSearchBarView
    public void endContactAnimationIView() {
        ContactsUtils.setAnimatorScale(this.mActivity);
        this.mTitleBar.setVisibility(0);
        if (isSearchInPlaceEnabled() == false) goto L6;
        this.misInSearchMode = false;
        getPresenter().setCursorVisible(false);
        onSearchCanceledInPlace();
        return;
    L6:
        exitSearch();
    }

    public void setBundle(Bundle r1) {
        this.mExtras = r1;
    }

    public boolean isLegacyCompatibilityMode() {
        return this.mLegacyCompatibility;
    }

    public void setLegacyCompatibilityMode(boolean r1) {
        this.mLegacyCompatibility = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.mContactsContent == null) goto L5;
        this.mActivity.getContentResolver().unregisterContentObserver(this.mContactsContent);
    L5:
        IPickerSearchBarPresenter r0 = this.mPresenter;
        if (r0 == null) goto L8;
        r0.detachView();
    L8:
        this.mDestoryed = true;
        this.mHandler.removeMessages(1001);
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().removeObserver(this.mNavigationBarObserver);
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mPool.shutdownNow();
    }

    public void triggerLoad() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        Thread r0 = new Thread(new AnonymousClass11(this));
        this.mPool.submit(r0);
    }

    public boolean isSearch() {
        return this.misInSearchMode;
    }

    public void cancelSearch(boolean r2) {
        if (r2 == false) goto L4;
    L12:
        getPresenter().cancelSearch();
        return;
    L4:
        if (isSearchInPlaceEnabled() == true) goto L12;
        OIconButtonFloating r3 = this.mOSearchRightBtn;
        if (r3 != null) goto L9;
    L11:
        getPresenter().cancelSearchWithoutAnimation();
        return;
    L9:
        if (r3.getVisibility() == 8) goto L11;
        this.mOSearchRightBtn.setVisibility(8);
        goto L11
    }

    public boolean back() {
        if (this.misInSearchMode == false) goto L15;
        if (isSearchInPlaceEnabled() == false) goto L11;
        if (this.oSearchEditor.getText().length() <= 0) goto L9;
        cancelSearch(true);
        goto L11
    L9:
        return false;
    L11:
        if (this.mSearchResultListView.isSelecting() == true) goto L13;
        cancelSearch(true);
    L13:
        return true;
    L15:
        if (this.mListView.isSelecting() == false) goto L17;
    L20:
        return true;
    L17:
        if (this.mCalllogListView.isSelecting() == true) goto L20;
        return false;
    }

    protected void postRefreshVisibleListItems() {
        if (this.mHandler.hasMessages(1001) == true) goto L6;
        this.mHandler.sendEmptyMessageDelayed(1001, 100);
        return;
    }
}
