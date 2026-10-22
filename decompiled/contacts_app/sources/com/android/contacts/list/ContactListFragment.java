package com.android.contacts.list;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.Vibrator;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.provider.Telephony;
import android.security.bytedance.guard.BDSettingsEvent;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.room.FtsOptions;
import bytedanceos.app.voiceassistant.ContactStruct;
import bytedanceos.app.voiceassistant.IVoiceAssistantCallback;
import bytedanceos.app.voiceassistant.IVoiceAssistantService;
import bytedanceos.app.voiceassistant.ParcelableObject;
import bytedanceos.util.NameAvatarController;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsSettingActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PinnedHeaderList.HeadersListView;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.TrackOptUtils;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.activities.GroupBrowserActivity;
import com.android.contacts.bytedanceosquickcontact.QuickContactExpandableListView;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.calllog.blocked.BlockedCallAdapter;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.SimContactsOperation;
import com.android.contacts.dialpad.search.T9SearchLocaleUtils;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.editor.ContactEditorUtils;
import com.android.contacts.editor.SelectAccountDialogFragment;
import com.android.contacts.forcetouch.ForceTouchController;
import com.android.contacts.group.GroupBrowseListFragment;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.BytedanceAccountType;
import com.android.contacts.numberassistant.MarkInfoUtil;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.recommend.BaseFlowAdapter;
import com.android.contacts.recommend.FlowAdapter;
import com.android.contacts.recommend.RecommendDataLoader;
import com.android.contacts.search.anim.SearchSwitchAnimHelper;
import com.android.contacts.setting.ImportExportFragment;
import com.android.contacts.util.AccountSelectionMenuDialog;
import com.android.contacts.util.AccountSelectionUtil;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.AsyncImageLoader;
import com.android.contacts.util.AvatarImageHelper;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.MemoryCardUtil;
import com.android.contacts.util.MenuItem;
import com.android.contacts.util.NameSortComparator;
import com.android.contacts.util.OSheetUtils;
import com.android.contacts.util.ProductUtils;
import com.android.contacts.util.SearchUtils;
import com.android.contacts.util.ShareContactByText;
import com.android.contacts.util.SidebarDragHelper;
import com.android.contacts.vcard.ImportSimContacts;
import com.android.contacts.widget.AvatarImageView;
import com.android.contacts.widget.ProgressDialog;
import com.android.contacts.widget.SelectAllState;
import com.android.contacts.widget.ViewUtilsKt;
import com.android.vcard.VCardConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.android.collect.Lists;
import com.obric.anim.ListAnimator;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntity;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.search.InAppSearchClient;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.privacy.PermissionUtils;
import com.obric.privacy.PrivacyConstantsKt;
import com.obric.utils.OAutoSecurityGuardUtils;
import com.obricOld.contacts.menus.LongMenuHelper;
import com.obricOld.recognition.VoiceSearchResultAdapter;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import kotlin.Unit;
import obric.app.tracker.Agent;
import obric.util.NavigationBarHelper;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(since = "废弃不再使用，请关注 NewContactListFragment")
public class ContactListFragment extends AbstractFragment implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnFocusChangeListener, IContactSearchBarView, DialtactsActivity.ViewPagerVisibilityListener, AbsListView.OnScrollListener, ExpandableListView.OnChildClickListener, SelectAccountDialogFragment.Listener, DialtactsActivity.PageEnableListener, DialtactsActivity.ReleaseResourceListener, DialtactsActivity.onBackPressListener, IBinder.DeathRecipient, AvatarImageHelper.OnAvatarTextFontChangeListener, ContactListFilterController.ContactListFilterListener, RecommendDataLoader.OnRecommendDataLoadListener, DialtactsActivity.OnDBDataChangeListener {
    private static String ACCOUNTS_FILTERS_PARAM = null;
    public static final int ACCOUNT_NAME = 16;
    public static final int ACCOUNT_TYPE = 15;
    private static final String CACHE_FILE_NAME = "contactslist.par";
    private static final byte CACHE_VERSION = 2;
    private static final Uri CALLLOG_COUNT_URI = null;
    private static final boolean CHECKED_CORRECT_INFO = false;
    private static final int CHECK_CUR_LOCATION_REFRESHED = 1007;
    public static final int CONTACTDELETED = 3;
    public static final int CONTACTSAVED = 1;
    private static final Uri CONTACTS_STATISTICS = null;
    private static final Uri CONTACTS_WITH_COMPANY_URI = null;
    public static final int CONTACTUPDATA = 2;
    private static final String CONTACT_CITY_QUERY = "has_phone_number >0 ";
    private static final String CONTACT_EXCLUDE_SIM_ACCOUNT_QUERY = "account_type <> 'com.android.sim'";
    private static final String[] CONTACT_FREQUENCE_PROJECTION = null;
    private static final String CONTACT_FREQUENCE_SELECTION = "lookup_uri not null";
    private static final String CONTACT_QUERY = null;
    private static final String CONTACT_SEARCH_SORT = "sort_key";
    private static final String CONTACT_SORT = "sort_key";
    private static final int DEFAULT_IMPORT_SHEET_SELECT = 0;
    private static final String EXTRA_KEY_GROUP_URI = "groups.groupUri";
    private static final int H24r = 86400000;
    private static final String KEY_RES_ID = "resourceId";
    private static final int LETTER_NEW_SYMBOL = 2;
    private static final int LETTER_NORMAL = 0;
    private static final int LETTER_PROFILE = 1;
    private static final int LETTER_PROFILE_NEW = 2;
    private static final int LETTER_PROFILE_SYMBOL = 1;
    private static final int MAX_LAST_INSERT_COUNT = 3;
    private static final int MSG_SET_RECOMMEND_DATA = 1009;
    private static final int MSG_TRIGGER_LOAD = 1008;
    private static String MULTI_ACCOUNTS_FLAG = null;
    private static final int NOTIFY_DATA_SET_CHANGE_BY_SORT_MODE = 1001;
    private static final int NOTIFY_LONG_WAIT_TIP = 1003;
    private static final int NOTIFY_REFRESH_BCR_COUNT = 1006;
    private static final int NOTIFY_SET_SEARCH_RESULT = 1004;
    private static String NO_ACCOUNTS_SELECTION = null;
    public static final int PHONE_CONTACT_ID = 1;
    public static final int PHONE_DISPLAY_NAME = 8;
    public static final int PHONE_ID = 12;
    private static final String PHONE_ID_SELECTION = "mimetype = ? ";
    private static final String[] PHONE_ID_SELECTION_ARGS = null;
    public static final int PHONE_IS_SUPER_PRIMARY = 2;
    public static final int PHONE_LABEL = 4;
    public static final int PHONE_LOCATION_NAME = 13;
    public static final int PHONE_LOCATION_NAME_PINYIN = 14;
    public static final int PHONE_LOOKUP_KEY = 9;
    public static final int PHONE_NORMALIZED_NUMBER = 6;
    public static final int PHONE_NUMBER = 0;
    public static final int PHONE_PHONEBOOK_LABEL = 11;
    public static final int PHONE_PHOTO_ID = 10;
    public static final int PHONE_RAW_CONTACT_ID = 7;
    public static final int PHONE_SORT_KEY_PRIMARY = 5;
    public static final int PHONE_TYPE = 3;
    private static final Uri PROFILE_QUERY_URI = null;
    private static final int REFRESH_VISIBLE_LIST_ITEMS = 1005;
    private static final int REQUEST_DELETE_CONTACT = 21;
    private static final int REQUEST_GET_BCR_CONTACTS = 22;
    private static final int SHOW_BUTTON_EDIT_MODE = 2;
    private static final int SHOW_BUTTON_NORMAL_MODE = 1;
    private static final String TAG = "ContactListFragment";
    private static final int TEN_METERS = 10;
    private static final int TEN_SECONDS = 10000;
    private static final int TOUCH_STATE_NUMS = 5;
    private static final int TWO_MINUTES = 120000;
    private static final int WAVE_COVER_DELAY_MILLIS = 150;
    private static final LongMenuHelper.MenuType[] sLongMenuItems = null;
    private static ContactListFragment sPerLoadMe;
    static boolean sVoiceEnabled;
    private final boolean DEBUG;
    private final int TIME_NEED_TO_TIP;
    private LinearLayout contactTitleBarCenterView;
    private Map<Long, SamContact> curContactsMap;
    private LinearLayout groupTitleBarCenterView;
    private String importFlag;
    private String mAccountsFilterQueryParameter;
    private FragmentActivity mActivity;
    private ContactsListSortByAddedTimeAdapter mAddedTimesAdapter;
    private boolean mAllContactsSelected;
    private AsyncImageLoader mAsyncImageLoader;
    private ContactsListSortByBCRAdapter mBCRAdapter;
    private ContentObserver mBcrDataObserver;
    private BlacklistChangeListener mBlacklistChangeListener;
    private boolean mBlacklistHasChanged;
    private BlacklistManager mBlacklistManager;
    private BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private OButton mBtnContactLeft;
    private OButton mBtnContactMenu;
    private OButton mBtnContactRightDelete;
    private OButton mBtnGroupLeft;
    private OButton mBtnGroupMenu;
    private OButton mBtnGroupRightDelete;
    private OButton mBtnImportContacts;
    private OButton mBtnOpenCamera;
    private ImageButton mBtnVoiceSearchContacts;
    private List<BaseFlowAdapter.FlowEntry> mCachedRecommendData;
    private IVoiceAssistantCallback mCallback;
    private volatile boolean mCancelRecognizeByTooShortTime;
    private ExpandAdapterForLocation mCityAdapter;
    private boolean mCityChanged;
    private QuickContactExpandableListView mCityListView;
    private FrameLayout mCityListViewFrame;
    private HashMap<String, String> mCityPinYinMap;
    private AlertDialog mCloseVoiceDialog;
    private boolean mCollapseAllGroup;
    private ExpandAdapterForCompany mCompanyAdapter;
    private RelativeLayout mContactBody;
    private ContactListFilterController mContactListFilterController;
    private HeadersListView mContactListView;
    private SelectAllState mContactSelectAllBtn;
    ContactsContent mContactsContent;
    private RelativeLayout mContactsEmptyView;
    private ViewStub mContactsEmptyViewStub;
    private View mContactsFragment;
    private RelativeLayout mContactsFrameView;
    private HashSet<Long> mContactsIdBCR;
    private HashSet<Long> mContactsIdForLocation;
    private HashSet<Long> mContactsIdList;
    private HashSet<Long> mContactsIdSIM1;
    private HashSet<Long> mContactsIdSIM2;
    private ListAnimator mContactsListAnimator;
    private ContactsSelectionListener mContactsSelectionListener;
    private RelativeLayout mContactsTipEmptyView;
    private ViewStub mContactsTipEmptyViewStub;
    private Context mContext;
    private View mCover;
    private Animation.AnimationListener mCoverAnimationTracker;
    private boolean mCoverDismiss;
    private boolean mDataIsReady;
    private DecelerateInterpolator mDecelerateInterpolator;
    private OActionSheet mDeleteSheet;
    private long mDuration;
    private ViewGroup mEmptyResultDialog;
    private OPageStatus mEmptyView;
    private HashMap<Long, Integer> mExpandGroups;
    private HorizontalScrollExpandableListView.ItemLongClickedListener mExpandableListItemLongClickedListener;
    private FlowAdapter mFlowAdapter;
    private ForceTouchController mForceTouchController;
    private ContactFragmentsCallback mFragmentsCallback;
    private boolean mFrequentContacts;
    private GroupBrowseListFragment mGroupBrowseListFragment;
    private ViewStub mGroupBrowseStub;
    private ExpandableListView.OnGroupCollapseListener mGroupCollapseListener;
    private ExpandableListView.OnGroupExpandListener mGroupExpandListener;
    private View mGroupFlipperView;
    private SelectAllState mGroupSelectAllBtn;
    public Handler mHandler;
    private boolean mHasOccupied;
    private boolean mHasQuickBar;
    private boolean mHasResult;
    private DSUtils.IccStateListener mIccStateListener;
    private int mImportSimId;
    private List<InAppSearchEntity> mInAppSearchResultList;
    private SearchThread mInAppSearchThread;
    private boolean mInContacts;
    private boolean mIntentsSearch;
    private List<InAppSearchEntity> mIntentsSearchResultList;
    private boolean mIsClickBtnAddContact;
    private boolean mIsDeletingContacts;
    private boolean mIsEdit;
    private boolean mIsHasPhoneNum;
    private boolean mIsNavigationShown;
    private boolean mIsPreloading;
    private boolean mIsSearch;
    private boolean mIsSearchAnimationing;
    private boolean mIsShowGroup;
    private HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private boolean mKeepSearchState;
    private long mLastStartTime;
    private boolean mLazyLoadFirstStart;
    private String mLetter;
    private Bitmap[][] mLetterProfileBitmaps;
    private Bitmap[][] mLetterProfileNewBitmaps;
    private Bitmap[] mLetterProfileSelectedBitmaps;
    private Bitmap[] mLetterProfileSelectedNewBitmaps;
    private LocationManager mLocationManager;
    private boolean mLocationRegistered;
    private int mMayDeletedPosition;
    int mModeState;
    private int mNavigationBarHeight;
    private boolean mNoContactsSelected;
    private ContactsListSortByNameAdapter mNorAdapter;
    private OTabSegmentedLayout mOContactTabSegmentedLayout;
    private OCTitleBar mOContactTitleBar;
    private OTabSegmentedLayout mOGroupTabSegmentedLayout;
    private OCTitleBar mOGroupTitleBar;
    private OIconButtonFloating mOSearchRightButton;
    private OCTitleBar mOSearchTitlebarView;
    private OSearchBar mOSearchbar;
    private AlertDialog mOccupiedDialog;
    private ArrayList<SamContact> mOldContactAddedTimeItems;
    private ArrayList<SamContact> mOldContactCityItems;
    private ArrayList<SamContact> mOldContactTimesItems;
    private ArrayList<SamContact> mOldContacts;
    private ArrayList<SamContact> mOldContactsBCRItems;
    private ArrayList<SamContact> mOldContactsCompanyItems;
    private ArrayList<SamContact> mOldContactsPhoneItems;
    private ArrayList<SamContact> mOldContactsSim1Items;
    private ArrayList<SamContact> mOldContactsSim2Items;
    private Point mOutSize;
    private ContactsListSortByNameAdapter mPhoneContactsAdapter;
    private HashSet<Long> mPhoneContactsIdList;
    private ContactPhotoManager mPhotoManager;
    private ExecutorService mPool;
    private PreferencesCallback mPrefsCallback;
    private IContactSearchBarPresenter mPresenter;
    private boolean mProviderIsNormal;
    private SearchThread mProviderSearchThread;
    private OIndexScrollbar.QBListener mQBListener;
    private OIndexScrollbar mQuickBar;
    private int mQuickBarState;
    private RecommendDataLoader mRecommendDataLoader;
    private OPageStatus mRecommendEmptyView;
    private Runnable mRefreshProfileRunnable;
    private boolean mResetContactListView;
    private Runnable mScrollIdle;
    private ForceTouchController mSearchController;
    private TextView mSearchEmptyView;
    private String mSearchKey;
    private Map<Long, List<String>> mSearchKeyList;
    private ViewGroup mSearchOptionBar;
    private SearchResultAdapter mSearchResultAdapter;
    private ViewGroup mSearchResultDialog;
    private QuickContactListView mSearchResultList;
    private RelativeLayout mSearchResultView;
    private SearchSwitchAnimHelper mSearchSwitchANimHelper;
    private Uri mSelectedGroupUri;
    private SelectionSet<Long> mSelectedSet;
    private ShowResultThread mShowResultThread;
    private SidebarDragHelper mSidebarDragHelper;
    private ContactsListSortBySimAdapter mSimAdapter;
    private SlideListView.Listener mSlideListener;
    private ExpandListView.SlideListener mSlideListenerForExpandable;
    private int mSortMode;
    private Runnable mStartRecord;
    private boolean mStartedRecongnize;
    private long mStartedRecongnizeTime;
    private OIndexScrollbar.SurnameListener mSurnameListener;
    private Runnable mTimeoutThread;
    private ContactsListSortByTimesAdapter mTimesAdapter;
    private SlideListView.TouchMonitorListener mTouchMonitorListener;
    private ExpandListView.TouchMonitorListener mTouchMonitorListenerForExpandable;
    private Vibrator mVibrator;
    private boolean mVisible;
    private final VoiceServiceConnection mVoiceAssistantServiceConnection;
    private ContactsListBaseAdapter.VoiceBtnCallBack mVoiceBtnCallBack;
    IVoiceAssistantService mVoiceInterface;
    private boolean mVoiceSearchConnected;
    private Runnable mVoiceUiRunnable;
    private boolean mWaitingScrollIdle;
    private View mWave;
    private final LocationListener mlistener;
    private TextView primaryHint;
    private TextView secondaryHint;
    private RelativeLayout voiceSearchContainer;

    /* JADX INFO: renamed from: com.android.contacts.list.ContactListFragment$62, reason: invalid class name */
    public class AnonymousClass62 extends IVoiceAssistantCallback.Stub {
        final /* synthetic */ ContactListFragment this$0;

        public void onBuffer(byte[] r1) throws RemoteException {
        }

        public void onPartialResult(String r1) throws RemoteException {
        }

        public void onRecordEnd() throws RemoteException {
        }

        public void onRecordStart() throws RemoteException {
        }

        public void onResultRecived(String r1, int r2, boolean r3) throws RemoteException {
        }

        public void onVolumeUpdate(int r1) throws RemoteException {
        }

        AnonymousClass62(ContactListFragment r1) {
            this.this$0 = r1;
        }

        public void onLocalResult(ParcelableObject r3, boolean r4) throws RemoteException {
            if (ContactsUtils.DEBUG == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "+showResult+++++++  reco:" + ContactListFragment.access$7200(this.this$0));
        L6:
            if (this.this$0.mVoiceInterface != null) goto L8;
            return;
        L8:
            if (ContactListFragment.access$9200(this.this$0) == false) goto L10;
            return;
        L10:
            if (ContactListFragment.access$7200(this.this$0) == true) goto L12;
            if (r4 == true) goto L12;
            return;
        L12:
            List r5 = r3.getContacts();
            if (ContactListFragment.access$15200(this.this$0) == null) goto L15;
            this.this$0.mHandler.removeCallbacks(ContactListFragment.access$15200(this.this$0));
        L15:
            ContactListFragment.access$15202(this.this$0, new ShowResultThread(this.this$0, r5));
            this.this$0.mHandler.post(ContactListFragment.access$15200(this.this$0));
        }

        public void onError(int r2, int r3, boolean r4) {
            if (ContactsUtils.DEBUG == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "+recordError+++++++ isToast " + r4);
        L6:
            if (r3 == 1) goto L8;
            return;
        L8:
            if (ContactListFragment.access$15200(this.this$0) == null) goto L10;
            this.this$0.mHandler.removeCallbacks(ContactListFragment.access$15200(this.this$0));
        L10:
            if (r4 == false) goto L12;
            this.this$0.mHandler.post(new AnonymousClass1(this));
            return;
        L12:
            ContactListFragment.access$9202(this.this$0, true);
            this.this$0.mHandler.post(new AnonymousClass2(this));
        }

        public void showDialog(Context r3) {
            AlertDialog.Builder r0 = new AlertDialog.Builder(r3, 5);
            r0.setTitle(R.string.record_warning_dialog_title);
            r0.setMessage(R.string.record_warning_dialog_message);
            r0.setPositiveButton(R.string.common_ok, new AnonymousClass3(this));
            r0.setOnDismissListener(new AnonymousClass4(this));
            if (ContactListFragment.access$15300(this.this$0) != null) goto L5;
        L7:
            ContactListFragment.access$15302(this.this$0, r0.show());
            return;
        L5:
            if (ContactListFragment.access$15300(this.this$0).isShowing() == false) goto L7;
            ContactListFragment.access$15300(this.this$0).dismiss();
            goto L7
        }
    }

    public class AddedTimeSortComparator implements Comparator<SamContact> {
        NameSortComparator mNameSortComparator;
        final /* synthetic */ ContactListFragment this$0;

        public AddedTimeSortComparator(ContactListFragment r1) {
            this.this$0 = r1;
            this.mNameSortComparator = new NameSortComparator();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SamContact r1, SamContact r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(SamContact r2, SamContact r3) {
            if (TextUtils.isEmpty(r3.addedTime) == false) goto L8;
            if (TextUtils.isEmpty(r2.addedTime) == true) goto L8;
            return -1;
        L8:
            if (TextUtils.isEmpty(r3.addedTime) == true) goto L13;
            if (TextUtils.isEmpty(r2.addedTime) == false) goto L13;
            return 1;
        L13:
            if (TextUtils.isEmpty(r3.addedTime) == false) goto L18;
            if (TextUtils.isEmpty(r2.addedTime) == false) goto L18;
            return this.mNameSortComparator.compare2(r2, r3);
        L18:
            return r3.addedTime.compareToIgnoreCase(r2.addedTime);
        }
    }

    public class BlacklistChangeListener implements BlacklistManager.OnBlacklistChangeListener {
        final /* synthetic */ ContactListFragment this$0;

        public BlacklistChangeListener(ContactListFragment r1) {
            this.this$0 = r1;
        }

        @Override // com.android.contacts.BlacklistManager.OnBlacklistChangeListener
        public void onBlacklistChanged() {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "onBlacklistChanged");
            ContactListFragment.access$11002(this.this$0, true);
            if (ContactListFragment.access$200(this.this$0) != null) goto L5;
            return;
        L5:
            if (ContactListFragment.access$500(this.this$0) == null) goto L16;
            ContactListFragment.access$200(this.this$0).notifyDataSetChanged();
            int r0 = ContactListFragment.access$500(this.this$0).getFirstVisiblePosition();
            int r2 = 0;
            View r1 = ContactListFragment.access$500(this.this$0).getChildAt(0);
            if (r1 == null) goto L10;
            r2 = r1.getTop();
        L10:
            ContactListFragment.access$500(this.this$0).setAdapter(ContactListFragment.access$200(this.this$0));
            if (r0 < 0) goto L13;
            ContactListFragment.access$500(this.this$0).setSelectionFromTop(r0, r2);
        L13:
            ContactListFragment.access$500(this.this$0).setOnScrollStateChangeListener(ContactListFragment.access$200(this.this$0));
            return;
        }
    }

    public class CityNameSortComparator extends ExpandableSortComparator {
        String mUnknownLocation;
        final /* synthetic */ ContactListFragment this$0;

        @Override // com.android.contacts.list.ContactListFragment.ExpandableSortComparator, java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SamContact r1, SamContact r2) {
            return compare(r1, r2);
        }

        public CityNameSortComparator(ContactListFragment r1) {
            this.this$0 = r1;
            super(r1);
            this.mUnknownLocation = ContactsUtils.getUnknownLocationLabel();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.contacts.list.ContactListFragment.ExpandableSortComparator
        public int compare(SamContact r5, SamContact r6) {
            int r1 = 1;
            if (TextUtils.isEmpty(r5.headerData) == false) goto L5;
        L9:
            int r0 = 1;
        L11:
            if (TextUtils.isEmpty(r6.headerData) == false) goto L13;
        L17:
            int r2 = r0 - r1;
            if (r2 != 0) goto L20;
            r2 = (this.mUnknownLocation.equals(r5.headerData) ? 1 : 0) - (this.mUnknownLocation.equals(r6.headerData) ? 1 : 0);
        L20:
            if (r2 == 0) goto L22;
            return r2;
        L22:
            return super.compare(r5, r6);
        L13:
            if (r6.headerData.length() <= 0) goto L17;
            if (T9SearchLocaleUtils.isChinese(r6.headerData.charAt(0)) == false) goto L17;
            r1 = 0;
            goto L17
        L5:
            if (r5.headerData.length() <= 0) goto L9;
            if (T9SearchLocaleUtils.isChinese(r5.headerData.charAt(0)) == false) goto L9;
            r0 = 0;
            goto L11
        }
    }

    public static class CompanySortComparator implements Comparator<ArrayList<SamContact>> {
        public CompanySortComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ArrayList<SamContact> r1, ArrayList<SamContact> r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ArrayList<SamContact> r6, ArrayList<SamContact> r7) {
            SamContact r8 = r6.get(0);
            SamContact r9 = r7.get(0);
            boolean r0 = TextUtils.isEmpty(r8.headerData);
            boolean r1 = TextUtils.isEmpty(r9.headerData);
            if (r0 == true) goto L28;
            if (r1 == true) goto L28;
            String r5 = r8.headerSortSection;
            String r2 = r9.headerSortSection;
            boolean r10 = ContactsUtils.CHAR_POUND.equals(r5);
            boolean r3 = ContactsUtils.CHAR_POUND.equals(r2);
            String r4 = r8.headerSortData;
            String r11 = r9.headerSortData;
            if (r10 == false) goto L20;
            if (r3 == false) goto L20;
            String r12 = r8.headerData;
            String r13 = r9.headerData;
            boolean r14 = ContactsUtils.isPhoneNumber(r12);
            boolean r15 = ContactsUtils.isPhoneNumber(r13);
            if (r14 == false) goto L14;
            if (r15 == false) goto L14;
            return r12.compareTo(r13);
        L14:
            if (r14 == false) goto L17;
            if (r15 == true) goto L17;
            return 1;
        L17:
            if (r14 == true) goto L27;
            if (r15 == false) goto L27;
            return -1;
        L27:
            return r4.compareToIgnoreCase(r11);
        L20:
            if (r10 == false) goto L23;
            if (r3 == true) goto L23;
            return 1;
        L23:
            if (r10 == true) goto L27;
            if (r3 == false) goto L27;
            return -1;
        L28:
            if (r0 == false) goto L31;
            if (r1 == true) goto L31;
            return 1;
        L31:
            if (r0 == true) goto L34;
            if (r1 == false) goto L34;
            return -1;
        L34:
            return 0;
        }
    }

    private static class ContactQuery {
        public static final int CONTACT_ACCOUNT_NAME = 11;
        public static final int CONTACT_ACCOUNT_TYPE = 10;
        public static final int CONTACT_DISPLAY_NAME = 1;
        public static final int CONTACT_HAS_PHONE_NUMEBER = 8;
        public static final int CONTACT_ID = 0;
        public static final int CONTACT_LOOKUP_KEY = 6;
        public static final int CONTACT_NAME_RAW_CONTACT_ID = 7;
        public static final int CONTACT_PHONEBOOK_LABEL = 9;
        public static final int CONTACT_PHOTO_ID = 3;
        public static final int CONTACT_PHOTO_URI = 4;
        private static final String[] CONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE = null;
        private static final String[] CONTACT_PROJECTION_ALTERNATIVE_PRIMARY = null;
        private static final String[] CONTACT_PROJECTION_PRIMARY_ALTERNATIVE = null;
        private static final String[] CONTACT_PROJECTION_PRIMARY_PRIMARY = null;
        public static final int CONTACT_SORT_KEY = 5;
        public static final int CONTACT_TIME_CONTACTED = 2;

        private ContactQuery() {
        }

        static /* synthetic */ String[] access$5300() {
            return CONTACT_PROJECTION_PRIMARY_PRIMARY;
        }

        static /* synthetic */ String[] access$5400() {
            return CONTACT_PROJECTION_PRIMARY_ALTERNATIVE;
        }

        static /* synthetic */ String[] access$5500() {
            return CONTACT_PROJECTION_ALTERNATIVE_PRIMARY;
        }

        static /* synthetic */ String[] access$5600() {
            return CONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE;
        }

        static {
            CONTACT_PROJECTION_PRIMARY_PRIMARY = new String[]{"_id", "display_name", "times_contacted", "photo_id", "photo_thumb_uri", PickerFragment.CONTACT_SORT_CNAME, "lookup", "name_raw_contact_id", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_ALTERNATIVE, "account_type", "account_name"};
            CONTACT_PROJECTION_PRIMARY_ALTERNATIVE = new String[]{"_id", "display_name", "times_contacted", "photo_id", "photo_thumb_uri", "sort_key_alt", "lookup", "name_raw_contact_id", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_ALTERNATIVE, "account_type", "account_name"};
            CONTACT_PROJECTION_ALTERNATIVE_PRIMARY = new String[]{"_id", "display_name_alt", "times_contacted", "photo_id", "photo_thumb_uri", PickerFragment.CONTACT_SORT_CNAME, "lookup", "name_raw_contact_id", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY, "account_type", "account_name"};
            CONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE = new String[]{"_id", "display_name_alt", "times_contacted", "photo_id", "photo_thumb_uri", "sort_key_alt", "lookup", "name_raw_contact_id", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY, "account_type", "account_name"};
        }
    }

    public static class ContactedTimesSortComparator implements Comparator<SamContact> {
        NameSortComparator mNameSortComparator;

        public ContactedTimesSortComparator() {
            this.mNameSortComparator = new NameSortComparator();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SamContact r1, SamContact r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(SamContact r3, SamContact r4) {
            int r0 = Integer.compare(r4.timesContacted, r3.timesContacted);
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return this.mNameSortComparator.compare2(r3, r4);
        }
    }

    class ContactsContent extends ContentObserver {
        final /* synthetic */ ContactListFragment this$0;

        public ContactsContent(ContactListFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2) {
            ContactListFragment.access$14100(this.this$0);
            if (this.this$0.isSearch() == false) goto L5;
            ContactListFragment.access$14200(this.this$0);
        L5:
            ContactListFragment.access$14300(this.this$0);
            if (ContactListFragment.access$14400(this.this$0) == true) goto L8;
            return;
        L8:
            ContactListFragment.access$1900(this.this$0).refreshCache();
            if (ContactListFragment.access$14500(this.this$0) == true) goto L12;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactListFragment.TAG, "Database changes but query is already in progress.");
            return;
        L12:
            ContactListFragment.access$14502(this.this$0, false);
            if (ContactListFragment.access$14600(this.this$0) == false) goto L15;
            return;
        L15:
            ContactListFragment r1 = this.this$0;
            ContactListFragment.access$100(r1, ContactListFragment.access$9900(r1), true);
        }
    }

    private static class ContactsWithCompany {
        public static final int ACCOUNT_NAME = 8;
        public static final int ACCOUNT_TYPE = 7;
        private static String[] COLUMNS = null;
        public static final int COMPANY = 6;
        public static final int DISPLAY_NAME = 1;
        public static final int LOOKUP_KEY = 3;
        public static final int NAME_RAW_CONTACT_ID = 5;
        public static final int PHONE_PHONEBOOK_LABEL = 9;
        public static final int PHOTO_ID = 4;
        public static final int SORT_KEY_PRIMARY = 2;
        public static final int _ID = 0;

        private ContactsWithCompany() {
        }

        static {
            COLUMNS = new String[]{"_id", "display_name", PickerFragment.CONTACT_SORT_CNAME, "lookup", "photo_id", "name_raw_contact_id", "data1", "account_type", "account_name", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
        }

        public static String[] getProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            COLUMNS[1] = "display_name_alt";
        L6:
            if (r4 != 2) goto L8;
            COLUMNS[2] = "sort_key_alt";
        L10:
            return COLUMNS;
        L8:
            COLUMNS[2] = PickerFragment.CONTACT_SORT_CNAME;
            goto L10
        L5:
            COLUMNS[1] = "display_name";
            goto L6
        }
    }

    private class DeleteContactsTask extends AsyncTask<long[], Void, Void> {
        private static final long DELAY_TIME = 1000;
        private Context context;
        private boolean dismiss;
        private Handler handler;
        private boolean mIsContactsEmpty;
        private ProgressDialog progressDialog;
        final /* synthetic */ ContactListFragment this$0;

        static /* synthetic */ boolean access$16200(DeleteContactsTask r0) {
            return r0.dismiss;
        }

        static /* synthetic */ ProgressDialog access$16300(DeleteContactsTask r0) {
            return r0.progressDialog;
        }

        static /* synthetic */ ProgressDialog access$16302(DeleteContactsTask r0, ProgressDialog r1) {
            r0.progressDialog = r1;
            return r1;
        }

        static /* synthetic */ Context access$16400(DeleteContactsTask r0) {
            return r0.context;
        }

        static /* synthetic */ boolean access$16500(DeleteContactsTask r0) {
            return r0.mIsContactsEmpty;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(long[][] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        public DeleteContactsTask(ContactListFragment r1, Context r2, boolean r3) {
            this.this$0 = r1;
            this.dismiss = false;
            this.context = r2;
            this.mIsContactsEmpty = r3;
            this.handler = new Handler(Looper.getMainLooper());
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.dismiss = false;
            ContactListFragment.access$14602(this.this$0, true);
            this.handler.post(new AnonymousClass1(this));
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(long[]... r8) {
            int r0 = 0;
            long[] r9 = r8[0];
            int r1 = r9.length;
            ArrayList r2 = new ArrayList(r1);
            int r3 = r9.length;
        L3:
            if (r0 >= r3) goto L5;
            long r4 = r9[r0];
            r2.add(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, r4));
            r0 = r0 + 1;
            goto L3
        L5:
            ArrayList r10 = new ArrayList(r1);
            Iterator r5 = r2.iterator();
        L7:
            if (r5.hasNext() == false) goto L14;
            Uri r6 = (Uri) r5.next();
            MemoryCardUtil.deleteCardWithContactUri(ContactListFragment.access$9400(this.this$0), r6);
            SimContactsOperation r7 = new SimContactsOperation(ContactListFragment.access$9400(this.this$0));
            long r11 = ContentUris.parseId(r6);
            int r12 = SimContactsOperation.getSimSubscription(r11);
            if (r12 != (-1)) goto L11;
            r10.add(ContentProviderOperation.newDelete(r6).build());
            goto L7
        L11:
            if (r7.delete(SimContactsOperation.getSimAccountValues(r11), r12) <= 0) goto L7;
            r10.add(ContentProviderOperation.newDelete(r6).build());
            goto L7
        L14:
            ArrayList r13 = new ArrayList();
            ArrayList r14 = new ArrayList();
            Iterator r15 = r10.iterator();
        L16:
            if (r15.hasNext() == false) goto L21;
            Uri r16 = ((ContentProviderOperation) r15.next()).getUri();
            Uri r17 = ContactsContract.Contacts.getLookupUri(this.context.getContentResolver(), r16);
            if (r17 == null) goto L16;
            r13.add(r17.toString());
            r14.add(ContactSaveService.getDisplayNameFromLookupUri(this.context.getContentResolver(), r17));
            goto L16
        L21:
            ContactSaveService.sendDeleteContactsBroadCast(ContactListFragment.access$9400(this.this$0), r13, r14);
            TrackOptUtils.trackDeleteOperation("li", String.valueOf(r10.size()));
            ContactsUtils.runApplyBatch(ContactListFragment.access$9400(this.this$0).getContentResolver(), "com.android.contacts", r10);
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r1) {
            completed();
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            completed();
        }

        private void completed() {
            ContactListFragment.access$14602(this.this$0, false);
            this.dismiss = true;
            ProgressDialog r3 = this.progressDialog;     // Catch: Throwable -> L10 IllegalArgumentException -> L12
            if (r3 != null) goto L6;
        L8:
            UIUtils.setViewVisibility(ContactListFragment.access$11900(this.this$0), 0);     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        L14:
            this.progressDialog = null;
            ContactListFragment r1 = this.this$0;
            ContactListFragment.access$100(r1, ContactListFragment.access$9900(r1), true);
            if (ContactListFragment.access$11400(this.this$0) != null) goto L17;
            return;
        L17:
            if ((ContactListFragment.access$11400(this.this$0) instanceof DialtactsActivity) == false) goto L26;
            ((DialtactsActivity) ContactListFragment.access$11400(this.this$0)).notifyDBDataChanged();
            return;
        L26:
            return;
        L6:
            if (r3.isShowing() == false) goto L8;
            this.progressDialog.dismiss();     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        L12:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            this.progressDialog = null;
            throw th;
        }
    }

    public class ExpandableSortComparator implements Comparator<SamContact> {
        NameSortComparator mNameSortComparator;
        final /* synthetic */ ContactListFragment this$0;

        public ExpandableSortComparator(ContactListFragment r1) {
            this.this$0 = r1;
            this.mNameSortComparator = new NameSortComparator();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SamContact r1, SamContact r2) {
            return compare(r1, r2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        public int compare(SamContact r3, SamContact r4) {
            int r0 = r3.headerSectionData.compareTo(r4.headerSectionData);
            if (r0 != 0) goto L5;
            r0 = r3.headerSortData.compareToIgnoreCase(r4.headerSortData);
        L5:
            if (r0 == 0) goto L7;
            return r0;
        L7:
            return this.mNameSortComparator.compare2(r3, r4);
        }
    }

    public interface Listener {
        void onContactSelected(Uri r1, Rect r2);
    }

    private class LocationToken {
        private static final String AUTONOMOUS_REGION = "自治区";
        private static final char CITY = 24066;
        private static final String HUIZU_AUTONOMOUS_REGION = "回族自治区";
        private static final char PROVINCE = 30465;
        private static final String WEIWUER_AUTONOMOUS_REGION = "维吾尔自治区";
        private static final String ZHUANGZU_AUTONOMOUS_REGION = "壮族自治区";
        public String LiteProvinceCityPinyin;
        public String city;
        public String fullProvinceCityPinyin;
        public String province;
        public String sortCityPinyin;
        final /* synthetic */ ContactListFragment this$0;

        public LocationToken(ContactListFragment r1, String r2, String r3) {
            this.this$0 = r1;
            this.province = r2;
            this.city = r3;
            this.fullProvinceCityPinyin = r2 + r3;
            this.LiteProvinceCityPinyin = "";
            this.sortCityPinyin = "";
        }

        public boolean removeProvinceCityCharacter() {
            this.LiteProvinceCityPinyin = "";
            if (TextUtils.isEmpty(this.province) == false) goto L5;
            boolean r1 = false;
        L38:
            if (TextUtils.isEmpty(this.city) == true) goto L49;
            if (this.city.endsWith(String.valueOf(24066)) == false) goto L49;
            if (this.city.length() <= 1) goto L49;
            String r2 = this.city;
            String r3 = r2.substring(0, r2.length() - 1);
            if (TextUtils.isEmpty(r3) == false) goto L46;
            return true;
        L46:
            if (NameAvatarController.hasChinese(r3) == false) goto L51;
            this.LiteProvinceCityPinyin += ContactListFragment.access$15900(this.this$0, r3).toUpperCase().replace(HanziToPinyin.Token.SEPARATOR, "");
            return true;
        L51:
            return true;
        L49:
            return r1;
        L5:
            if (this.province.endsWith(String.valueOf(30465)) == false) goto L10;
            if (this.province.length() <= 1) goto L10;
            String r4 = this.province;
            String r5 = r4.substring(0, r4.length() - 1);
        L31:
            if (TextUtils.isEmpty(r5) == false) goto L33;
        L35:
            r1 = true;
            goto L38
        L33:
            if (NameAvatarController.hasChinese(r5) == false) goto L35;
            this.LiteProvinceCityPinyin += ContactListFragment.access$15900(this.this$0, r5).toUpperCase().replace(HanziToPinyin.Token.SEPARATOR, "");
        L10:
            if (this.province.endsWith("壮族自治区") == false) goto L15;
            if (this.province.length() <= 5) goto L15;
            String r6 = this.province;
            r5 = r6.substring(0, r6.length() - 5);
        L15:
            if (this.province.endsWith("回族自治区") == false) goto L20;
            if (this.province.length() <= 5) goto L20;
            String r7 = this.province;
            r5 = r7.substring(0, r7.length() - 5);
        L20:
            if (this.province.endsWith("维吾尔自治区") == false) goto L25;
            if (this.province.length() <= 6) goto L25;
            String r8 = this.province;
            r5 = r8.substring(0, r8.length() - 6);
        L25:
            if (this.province.endsWith("自治区") == true) goto L27;
        L29:
            r5 = null;
            goto L31
        L27:
            if (this.province.length() <= 3) goto L29;
            String r9 = this.province;
            r5 = r9.substring(0, r9.length() - 3);
            goto L31
        }

        public String toString() {
            return "province:" + this.province + " city:" + this.city + " sortCityPinyin:" + this.sortCityPinyin + " LiteProvinceCityPinyin:" + this.LiteProvinceCityPinyin;
        }
    }

    private class NumberAdapter extends BaseAdapter {
        private List<String> list;
        final /* synthetic */ ContactListFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public NumberAdapter(ContactListFragment r1, List<String> r2) {
            this.this$0 = r1;
            this.list = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> r0 = this.list;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            List<String> r0 = this.list;
            if (r0 == null) goto L6;
            return r0.get(r1);
        L6:
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
            r4 = LayoutInflater.from(ContactListFragment.access$9400(this.this$0)).inflate(R.layout.custom_spinner_dropdown_item, r5, false);
        L4:
            ((CheckedTextView) r4.findViewById(R.id.custom_text1)).setText(this.list.get(r3));
            return r4;
        }
    }

    private class OnGroupActionListener implements GroupBrowseListFragment.OnGroupBrowserActionListener {
        final /* synthetic */ ContactListFragment this$0;

        private OnGroupActionListener(ContactListFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OnGroupActionListener(ContactListFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onViewGroupAction(Uri r4) {
            Intent r0 = new Intent(ContactListFragment.access$11400(this.this$0), GroupBrowserActivity.class);
            r0.setData(r4);
            ContactListFragment.access$11400(this.this$0).startActivity(r0);
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onChooseGroup(int r5) {
            if (ContactListFragment.access$12600(this.this$0) == null) goto L10;
            BottomDeleteLayoutListener r0 = ContactListFragment.access$12600(this.this$0);
            if (r5 <= 0) goto L7;
            boolean r3 = true;
        L8:
            r0.setBottomBtnEnable(r3);
            goto L10
        L7:
            r3 = false;
        L10:
            if (ContactListFragment.access$12400(this.this$0) != null) goto L12;
        L21:
            ContactListFragment.access$12500(this.this$0).setTitleText(this.this$0.getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r5)}));
            return;
        L12:
            if (ContactListFragment.access$12400(this.this$0).getAdapter() == null) goto L21;
            if (ContactListFragment.access$12300(this.this$0) == null) goto L21;
            int r1 = ContactListFragment.access$12400(this.this$0).getAdapter().getGroupList().size() - ContactListFragment.access$12400(this.this$0).getAdapter().getReadOnlyItemSize();
            SelectAllState r4 = ContactListFragment.access$12300(this.this$0);
            if (r5 <= 0) goto L19;
            if (r1 != r5) goto L19;
            boolean r2 = true;
        L20:
            r4.setSelectAll(r2);
        L19:
            r2 = false;
            goto L20
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onGroupDelete() {
            ContactListFragment.access$15400(this.this$0, false);
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void setCanEdit(boolean r7) {
            if (r7 == true) goto L7;
            ContactListFragment.access$12400(this.this$0).setGroupEdit(false);
            ContactListFragment r0 = this.this$0;
            ContactListFragment.access$15502(r0, ContactListFragment.access$15600(r0, R.drawable.standard_icon_multi_select_selector, true, ContactListFragment.access$12500(r0), ContactListFragment.access$15500(this.this$0)));
            if (ContactListFragment.access$15500(this.this$0) == null) goto L6;
            ContactListFragment.access$15500(this.this$0).setContentDescription("选择");
            ContactListFragment.access$15500(this.this$0).setOnClickListener(new AnonymousClass1(this));
        L6:
            ContactListFragment.access$15700(this.this$0).setVisibility(8);
            ContactListFragment.access$15800(this.this$0).setVisibility(0);
        L7:
            ContactListFragment.access$15500(this.this$0).setEnabled(r7);
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onDataBinded() {
            if (ProductUtils.isOpenTalkBack(this.this$0.getActivity()) == true) goto L5;
            return;
        L5:
            if (ContactListFragment.access$10500(this.this$0) == null) goto L9;
            ContactListFragment.access$10500(this.this$0).setCurrentTab(1);
            return;
        }
    }

    private static class PhoneQuery {
        private static final String[] PHONE_PROJECTION = null;

        private PhoneQuery() {
        }

        static {
            PHONE_PROJECTION = new String[]{"data1", "contact_id", "is_super_primary", DBHelper.COL_DATA2, DBHelper.COL_DATA3, PickerFragment.CONTACT_SORT_CNAME, "data4", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "display_name", "lookup", "photo_id", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY, "_id", BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME, BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN, "account_type", "account_name"};
        }

        public static String[] getProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            PHONE_PROJECTION[8] = "display_name_alt";
        L7:
            if (r4 != 2) goto L9;
            PHONE_PROJECTION[5] = "sort_key_alt";
        L11:
            return PHONE_PROJECTION;
        L9:
            PHONE_PROJECTION[5] = PickerFragment.CONTACT_SORT_CNAME;
            goto L11
        L5:
            PHONE_PROJECTION[8] = "display_name";
            goto L7
        }
    }

    private class SearchThread extends Thread {
        private boolean isInAppSearch;
        private List<InAppSearchEntity> mInAppSearchResultList;
        private boolean mIsTrue;
        private int mListSortMode;
        private String mSearchKey;
        protected Uri mSearchUri;
        private long searchDurationMs;
        private int searchErrorCode;
        private String searchErrorMsg;
        private boolean searchSuccess;
        private String searchType;
        final /* synthetic */ ContactListFragment this$0;

        static /* synthetic */ List access$13000(SearchThread r0) {
            return r0.mInAppSearchResultList;
        }

        static /* synthetic */ Map access$13100(SearchThread r0, List r1) {
            return r0.updateInAppSearchArray(r1);
        }

        static /* synthetic */ long access$13202(SearchThread r0, long r1) {
            r0.searchDurationMs = r1;
            return r1;
        }

        static /* synthetic */ boolean access$13302(SearchThread r0, boolean r1) {
            r0.searchSuccess = r1;
            return r1;
        }

        static /* synthetic */ String access$13400(SearchThread r0) {
            return r0.mSearchKey;
        }

        static /* synthetic */ int access$13502(SearchThread r0, int r1) {
            r0.searchErrorCode = r1;
            return r1;
        }

        static /* synthetic */ String access$13602(SearchThread r0, String r1) {
            r0.searchErrorMsg = r1;
            return r1;
        }

        public SearchThread(ContactListFragment r1, Uri r2, String r3, int r4, List<InAppSearchEntity> r5, boolean r6) {
            this.this$0 = r1;
            this.mIsTrue = true;
            this.mSearchUri = r2;
            this.mSearchKey = r3;
            this.mListSortMode = r4;
            this.mInAppSearchResultList = r5;
            this.isInAppSearch = r6;
        }

        public void setTrue(boolean r1) {
            this.mIsTrue = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.mIsTrue == true) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactListFragment.TAG, "mSearchThread isInterrupted");
            return;
        L6:
            Map<Long, SamContact> r0 = search();
            if (this.mIsTrue == false) goto L10;
            this.this$0.mHandler.removeMessages(1004);
            Message r1 = new Message();
            r1.what = 1004;
            r1.obj = r0;
            this.this$0.mHandler.sendMessage(r1);
            SearchUtils.saveSearchState(r0.keySet().size(), this.isInAppSearch, this.searchSuccess, this.searchDurationMs, this.searchErrorMsg, this.searchErrorCode, this.mSearchKey, -1);
            return;
        }

        private Map<Long, SamContact> search() {
            HashMap r0 = new HashMap();
            if (this.isInAppSearch == true) goto L5;
            r0.putAll(getProviderSearchResult(this.mInAppSearchResultList));
        L6:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "search_message: search final search contactsMap =  " + r0.size() + " isInAppSearch = " + this.isInAppSearch);
            return r0;
        L5:
            r0.putAll(getInAppSearchResult());
            goto L6
        }

        private Map<Long, SamContact> getInAppSearchResult() {
            final CountDownLatch r1 = new CountDownLatch(1);
            final HashMap r2 = new HashMap();
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "search_message: searchUseInAppSearch normal search contactsMap =  " + r2.size());
            SearchUtils.startSearchWithTimeOutInCurThread(this.this$0.getContext(), new InAppSearchRequest(this.mSearchKey, 0, true, false, 5), 10000, ContactListFragment.TAG, new AnonymousClass1(this, r2, r1));     // Catch: Throwable -> L5
            r1.await();     // Catch: Throwable -> L5
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "search_message: searchUseInAppSearch final search contactsMap =  " + r2.size());     // Catch: Throwable -> L5
            return r2;
        L5:
            th = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactListFragment.TAG, "search_message: searchUseInAppSearch", th);
            return r2;
        }

        private Map<Long, SamContact> getProviderSearchResult(List<InAppSearchEntity> r18) {
            Map<Long, SamContact> r2 = updateInAppSearchArray(r18);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "search_message: getProviderSearchResult contactsMap =  " + r2.size() + " in = " + r18);
            long r6 = System.currentTimeMillis();
            if (this.mSearchUri == null) goto L70;
            String r3 = ContactListFragment.access$13700();
            if (ContactsUtils.FEATURE_SIM_PHONEBOOK == false) goto L19;
            int r4 = this.mListSortMode;
            if (r4 != 32) goto L9;
            r3 = "account_type = 'com.android.sim' and account_name = '" + MoreContactUtils.getSimAccountName(0) + "'";
            goto L19
        L9:
            if (r4 != 64) goto L11;
            r3 = "account_type = 'com.android.sim' and account_name = '" + MoreContactUtils.getSimAccountName(1) + "'";
            goto L19
        L11:
            if (r4 == 256) goto L14;
            r3 = ContactListFragment.access$13700();
            goto L19
        L14:
            if (ContactListFragment.access$13800(this.this$0) == false) goto L16;
            r3 = "has_phone_number >0  and account_type <> 'com.android.sim'";
            goto L19
        L16:
            r3 = ContactListFragment.CONTACT_EXCLUDE_SIM_ACCOUNT_QUERY;
        L19:
            String r14 = r3;
            Cursor r5 = null;
            r5 = this.this$0.getActivity().getContentResolver().query(this.mSearchUri, ContactListFragment.access$13900(this.this$0), r14, null, PickerFragment.CONTACT_SORT_CNAME);     // Catch: Throwable -> L61 Exception -> L63
            if (r5 != null) goto L23;
        L58:
            this.searchSuccess = true;     // Catch: Throwable -> L61 Exception -> L63
            if (r5 == null) goto L70;
        L66:
            r5.close();
            goto L70
        L23:
            if (r5.moveToFirst() == false) goto L58;
            String r0 = this.mSearchKey.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "");     // Catch: Throwable -> L61 Exception -> L63
        L25:
            SamContact r8 = new SamContact(0);     // Catch: Throwable -> L61 Exception -> L63
            r8.contactId = r5.getLong(0);     // Catch: Throwable -> L61 Exception -> L63
            String r11 = r5.getString(1);     // Catch: Throwable -> L61 Exception -> L63
            r8.name = ContactsUtils.getContactName(this.this$0.getActivity(), r11);     // Catch: Throwable -> L61 Exception -> L63
            if (TextUtils.isEmpty(r11) == true) goto L28;
            boolean r12 = true;
        L29:
            r8.hasname = r12;     // Catch: Throwable -> L61 Exception -> L63
            r8.LookKey = r5.getString(6);     // Catch: Throwable -> L61 Exception -> L63
            r8.photoId = r5.getLong(3);     // Catch: Throwable -> L61 Exception -> L63
            r8.raw_contactid = r5.getLong(7);     // Catch: Throwable -> L61 Exception -> L63
            FragmentActivity r13 = this.this$0.getActivity();     // Catch: Throwable -> L61 Exception -> L63
            if (r13 == null) goto L56;
            HashMap<Long, ArrayList<DialtactsActivity.DataItem>> r15 = ((DialtactsActivity) r13).getBriefContactList();     // Catch: Throwable -> L61 Exception -> L63
            if (r15 == null) goto L33;
            if (r15.isEmpty() == true) goto L56;
            if (r15.containsKey(Long.valueOf(r8.contactId)) == false) goto L56;
            ArrayList<DialtactsActivity.DataItem> r16 = r15.get(Long.valueOf(r8.contactId));     // Catch: Throwable -> L61 Exception -> L63
            if (r16 != null) goto L43;
        L52:
            if (r16 == null) goto L56;
            if (r16.size() != 1) goto L56;
            r8.number = r16.get(0).number;     // Catch: Throwable -> L61 Exception -> L63
            goto L56
        L43:
            if (r16.size() <= 1) goto L52;
            r8.number = r16.get(0).number;     // Catch: Throwable -> L61 Exception -> L63
            Iterator<DialtactsActivity.DataItem> r17 = r16.iterator();     // Catch: Throwable -> L61 Exception -> L63
        L46:
            if (r17.hasNext() == false) goto L56;
            DialtactsActivity.DataItem r19 = r17.next();     // Catch: Throwable -> L61 Exception -> L63
            if (r19.number == null) goto L46;
            if (PhoneNumberUtils.normalizeNumber(r19.number).contains(r0) == false) goto L46;
            r8.number = r19.number;     // Catch: Throwable -> L61 Exception -> L63
            goto L56
        L33:
            if (r5 == null) goto L35;
            r5.close();
        L35:
            return r2;
        L56:
            r8.sortkey = r5.getString(5);     // Catch: Throwable -> L61 Exception -> L63
            r8.section = ContactsUtils.getContactSection(r8.sortkey);     // Catch: Throwable -> L61 Exception -> L63
            r2.put(Long.valueOf(r8.contactId), r8);     // Catch: Throwable -> L61 Exception -> L63
            if (r5.moveToNext() == true) goto L25;
        L28:
            r12 = false;
        L63:
            e = move-exception;
            this.searchSuccess = false;     // Catch: Throwable -> L61
            this.searchErrorMsg = e.toString();     // Catch: Throwable -> L61
            this.searchErrorCode = -1;     // Catch: Throwable -> L61
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactListFragment.TAG, "search_message: searchWithoutInAppSearch", e);     // Catch: Throwable -> L61
            if (r5 == null) goto L70;
        L61:
            th = move-exception;
            if (r5 == null) goto L69;
            r5.close();
        L69:
            throw th;
        L70:
            this.searchDurationMs = System.currentTimeMillis() - r6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "search_message: getProviderSearchResult contactsMap =  " + r2.size());
            return r2;
        }

        private Map<Long, SamContact> updateInAppSearchArray(List<InAppSearchEntity> r13) {
            HashMap r0 = new HashMap();
            if (r13 != null) goto L5;
        L29:
            return r0;
        L5:
            if (r13.isEmpty() == true) goto L29;
            ContactListFragment r1 = this.this$0;
            ArrayList r2 = ContactListFragment.access$14000(r1, ContactListFragment.access$9900(r1), false);
            if (r2 == null) goto L29;
            if (r2.isEmpty() == true) goto L29;
            int r3 = 0;
        L14:
            if (r3 >= r13.size()) goto L29;
            ContactEntity r4 = (ContactEntity) r13.get(r3).getAppEntity();
            if (r4 == null) goto L28;
            long r5 = Long.parseLong(r4.getId());
            int r7 = 0;
        L20:
            if (r7 >= r2.size()) goto L28;
            SamContact r8 = (SamContact) r2.get(r7);
            if (r8 == null) goto L27;
            if (r8.contactId != r5) goto L27;
            SamContact r9 = new SamContact(r8.getType());
            r9.contactId = r5;
            String r10 = r4.getName();
            r9.name = ContactsUtils.getContactName(this.this$0.getActivity(), r10);
            r9.hasname = !TextUtils.isEmpty(r10);
            r9.LookKey = r8.LookKey;
            r9.photoId = r8.photoId;
            r9.raw_contactid = r8.raw_contactid;
            r9.number = SearchUtils.getPhoneNumberBySearch(r13.get(r3), r4.getTelephones());
            r9.sortkey = r8.sortkey;
            r9.section = ContactsUtils.getContactSection(r9.sortkey);
            r0.put(Long.valueOf(r5), r9);
        L27:
            r7 = r7 + 1;
        L28:
            r3 = r3 + 1;
            goto L14
        }
    }

    private final class SelectionSet<T> extends HashSet<T> {
        final /* synthetic */ ContactListFragment this$0;

        private SelectionSet(ContactListFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SelectionSet(ContactListFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(T r2) {
            boolean r3 = super.add(r2);
            if (r3 == false) goto L5;
            ContactListFragment.access$800(this.this$0, size());
        L5:
            return r3;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            boolean r3 = super.remove(r2);
            if (r3 == false) goto L5;
            ContactListFragment.access$800(this.this$0, size());
        L5:
            return r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends T> r2) {
            boolean r3 = super.addAll(r2);
            if (r3 == false) goto L5;
            ContactListFragment.access$800(this.this$0, size());
        L5:
            return r3;
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r2) {
            boolean r3 = super.removeAll(r2);
            if (r3 == false) goto L5;
            ContactListFragment.access$800(this.this$0, size());
        L5:
            return r3;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            super.clear();
            ContactListFragment.access$800(this.this$0, size());
        }
    }

    private class ShowResultThread implements Runnable {
        private List<ContactStruct> mContactlist;
        final /* synthetic */ ContactListFragment this$0;

        public ShowResultThread(ContactListFragment r1, List<ContactStruct> r2) {
            this.this$0 = r1;
            this.mContactlist = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.getActivity() != null) goto L5;
            return;
        L5:
            if (this.this$0.getActivity().isFinishing() == false) goto L8;
            return;
        L8:
            if (ContactsUtils.DEBUG == false) goto L10;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "searchResult size  " + this.mContactlist.size());
        L10:
            LinkedHashMap<Long, LinkedHashSet<ContactStruct>> r0 = new LinkedHashMap();
            ArrayList<ContactStruct> r1 = new ArrayList();
            ArrayList<Long> r2 = new ArrayList();
            int r3 = this.mContactlist.size();
            if (r3 != 1) goto L13;
            LinkedHashSet<ContactStruct> r6 = new LinkedHashSet();
            r6.add(this.mContactlist.get(0));
            r0.put(Long.valueOf(this.mContactlist.get(0).contactId), r6);
            r2.add(Long.valueOf(this.mContactlist.get(0).contactId));
            r1.add(this.mContactlist.get(0));
        L47:
            VoiceSearchResultAdapter r7 = new VoiceSearchResultAdapter(this.this$0.getActivity());
            r7.setList(r0, r1, r2);
            AnimationUtil.stopRecordWithAnimation(ContactListFragment.access$6500(this.this$0));
            if (ContactListFragment.access$6100(this.this$0) == false) goto L50;
            return;
        L50:
            if (ContactListFragment.access$7200(this.this$0) == true) goto L53;
            return;
        L53:
            if (r3 != 0) goto L55;
            AnimationUtil.showCoverWithAnimation(ContactListFragment.access$6800(this.this$0), null);
            AnimationUtil.showResultDialogWithAnim(ContactListFragment.access$6000(this.this$0));
        L56:
            ContactListFragment.access$7202(this.this$0, false);
            return;
        L55:
            ContactListFragment.access$9102(this.this$0, true);
            ((ListView) ContactListFragment.access$5900(this.this$0).findViewById(R.id.result_list_view)).setAdapter(r7);
            AnimationUtil.showCoverWithAnimation(ContactListFragment.access$6800(this.this$0), null);
            AnimationUtil.showResultDialogWithAnim(ContactListFragment.access$5900(this.this$0));
            goto L56
        L13:
            int r8 = 0;
        L14:
            if (r8 >= r3) goto L43;
            ContactStruct r9 = this.mContactlist.get(r8);
            if (r8 != 0) goto L21;
            LinkedHashSet<ContactStruct> r10 = new LinkedHashSet();
            r10.add(r9);
            r0.put(Long.valueOf(r9.contactId), r10);
            if (r1.contains(r9) == true) goto L42;
            r1.add(r9);
        L42:
            r8 = r8 + 1;
            goto L14
        L21:
            if (r8 != (r3 - 1)) goto L29;
            if (r9.contactId != this.mContactlist.get(r8 - 1).contactId) goto L25;
            LinkedHashSet<ContactStruct> r11 = r0.get(Long.valueOf(r9.contactId));
            r11.add(r9);
            r0.put(Long.valueOf(r9.contactId), r11);
            goto L42
        L25:
            LinkedHashSet<ContactStruct> r12 = new LinkedHashSet();
            r12.add(r9);
            r0.put(Long.valueOf(r9.contactId), r12);
            if (r1.contains(r9) == true) goto L42;
            r1.add(r9);
            goto L42
        L29:
            if (r9.contactId != this.mContactlist.get(r8 - 1).contactId) goto L31;
        L36:
            LinkedHashSet<ContactStruct> r13 = r0.get(Long.valueOf(r9.contactId));
            if (r13 != null) goto L41;
            r13 = new LinkedHashSet();
            if (r1.contains(r9) == true) goto L41;
            r1.add(r9);
        L41:
            r13.add(r9);
            r0.put(Long.valueOf(r9.contactId), r13);
            goto L42
        L31:
            if (r9.contactId == this.mContactlist.get(r8 + 1).contactId) goto L36;
            LinkedHashSet<ContactStruct> r14 = new LinkedHashSet();
            r14.add(r9);
            r0.put(Long.valueOf(r9.contactId), r14);
            if (r1.contains(r9) == true) goto L42;
            r1.add(r9);
            goto L42
        L43:
            Iterator<Long> r15 = r0.keySet().iterator();
        L45:
            if (r15.hasNext() == false) goto L47;
            r2.add(r15.next());
            goto L45
        }
    }

    class VoiceServiceConnection implements ServiceConnection {
        private IBinder mService;
        final /* synthetic */ ContactListFragment this$0;

        VoiceServiceConnection(ContactListFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r2, IBinder r3) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "mVoiceAssistantServiceConnection is binder");
            this.mService = r3;
            ContactListFragment r4 = this.this$0;
            r4.mVoiceInterface = IVoiceAssistantService.Stub.asInterface(r3);
            if (r3 == null) goto L6;
            r3.linkToDeath(this.this$0, 0);     // Catch: RemoteException -> L10
        L10:
            e = move-exception;
            e.printStackTrace();
            return;
        L6:
            if (this.this$0.mVoiceInterface == null) goto L8;
            this.this$0.mVoiceInterface.registerCallback(ContactListFragment.access$15000(this.this$0), ContactListFragment.access$9400(this.this$0).getPackageName());     // Catch: RemoteException -> L10
        L8:
            ContactListFragment.access$15102(this.this$0, true);     // Catch: RemoteException -> L10
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
            clear();
        }

        public void clear() {
            if (this.this$0.mVoiceInterface != null) goto L13;
        L9:
            ContactListFragment.access$15102(this.this$0, false);
            return;
        L13:
            IBinder r0 = this.mService;     // Catch: Exception -> L11
            if (r0 == null) goto L15;
            r0.unlinkToDeath(this.this$0, 0);     // Catch: Exception -> L11
        L15:
            this.this$0.mVoiceInterface.unregisterCallback(ContactListFragment.access$15000(this.this$0));     // Catch: Exception -> L12
        L8:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactListFragment.TAG, "mVoiceAssistantServiceConnection is binder onServiceDisconnected");
            this.this$0.mVoiceInterface = null;
            goto L9
        }
    }

    public static /* synthetic */ ArrayList $r8$lambda$E2McIAGPWBO62AkYPcfatUmDGDA() {
        return new ArrayList();
    }

    public void groupSaveCompleted() {
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountSelectorCancelled() {
    }

    public void onBackPressed() {
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View r1, boolean r2) {
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void onModeWillChangeIView() {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    public ContactListFragment() {
        this.mOutSize = new Point();
        this.mIsHasPhoneNum = false;
        this.mContactsEmptyView = null;
        this.mContactsTipEmptyView = null;
        this.mContactsEmptyViewStub = null;
        this.mContactsTipEmptyViewStub = null;
        this.mIsShowGroup = false;
        this.mIsSearch = false;
        this.mIsSearchAnimationing = false;
        this.mHasQuickBar = false;
        this.mHasResult = false;
        this.mStartedRecongnize = false;
        this.mIsNavigationShown = false;
        this.mStartedRecongnizeTime = 0;
        this.mHasOccupied = false;
        this.mCoverDismiss = false;
        this.mDuration = 200;
        this.mCancelRecognizeByTooShortTime = false;
        this.mKeepSearchState = false;
        this.mImportSimId = 0;
        this.mMayDeletedPosition = -1;
        this.mBlacklistHasChanged = false;
        this.mWaitingScrollIdle = false;
        this.mNoContactsSelected = false;
        this.mLazyLoadFirstStart = true;
        this.mFrequentContacts = false;
        final Looper r4 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r4);
        this.mEmptyView = null;
        this.primaryHint = null;
        this.secondaryHint = null;
        this.mInContacts = true;
        this.mNorAdapter = null;
        this.mAddedTimesAdapter = null;
        this.mTimesAdapter = null;
        this.mPhoneContactsAdapter = null;
        this.mSimAdapter = null;
        this.mBCRAdapter = null;
        this.mLetter = "m";
        this.mSearchResultAdapter = null;
        this.DEBUG = false;
        this.mPool = Executors.newSingleThreadExecutor();
        this.mContactBody = null;
        this.mCollapseAllGroup = false;
        this.mResetContactListView = false;
        this.mQuickBarState = 1;
        this.mIsClickBtnAddContact = false;
        this.mIsEdit = false;
        this.mSelectedSet = new SelectionSet(this, null);
        this.mContactsIdList = new HashSet();
        this.mContactsIdSIM1 = new HashSet();
        this.mContactsIdSIM2 = new HashSet();
        this.mPhoneContactsIdList = new HashSet();
        this.mContactsIdBCR = new HashSet();
        this.mContactsIdForLocation = new HashSet();
        this.mContactsContent = null;
        this.voiceSearchContainer = null;
        this.mVoiceUiRunnable = new AnonymousClass14(this);
        this.mCoverAnimationTracker = new AnonymousClass17(this);
        this.mStartRecord = new AnonymousClass18(this);
        this.mTimeoutThread = new AnonymousClass19(this);
        this.mQBListener = new AnonymousClass20(this);
        this.mVoiceBtnCallBack = new AnonymousClass21(this);
        this.mSurnameListener = new AnonymousClass23(this);
        this.mSlideListener = new AnonymousClass24(this);
        this.mSlideListenerForExpandable = new AnonymousClass25(this);
        this.mTouchMonitorListener = new AnonymousClass26(this);
        this.mItemLongClickedListener = new AnonymousClass27(this);
        this.mExpandableListItemLongClickedListener = new AnonymousClass28(this);
        this.mTouchMonitorListenerForExpandable = new AnonymousClass29(this);
        this.mIccStateListener = new AnonymousClass36(this);
        this.mRefreshProfileRunnable = new AnonymousClass37(this);
        this.mIsPreloading = false;
        this.TIME_NEED_TO_TIP = 200;
        this.mCityPinYinMap = new HashMap();
        this.mContactsListAnimator = new ListAnimator(new int[]{R.id.photo_frame, R.id.name, R.id.divider}, new int[]{R.id.sim_id_icon}, new int[]{R.id.checkBoxFrame});
        this.importFlag = null;
        this.mScrollIdle = new AnonymousClass58(this);
        this.mModeState = 0;
        this.mSortMode = 0;
        this.mLocationRegistered = false;
        this.curContactsMap = new HashMap();
        this.mProviderSearchThread = null;
        this.mInAppSearchThread = null;
        this.mSearchKey = null;
        this.mInAppSearchResultList = new ArrayList();
        this.mSearchKeyList = new HashMap();
        this.mIntentsSearch = false;
        this.mIntentsSearchResultList = new ArrayList();
        this.mDataIsReady = false;
        this.mCityChanged = false;
        this.mVisible = false;
        this.mVoiceSearchConnected = false;
        this.mVoiceAssistantServiceConnection = new VoiceServiceConnection(this);
        this.mCallback = new AnonymousClass62(this);
        this.mProviderIsNormal = true;
        this.mlistener = new AnonymousClass63(this);
        this.mContactsSelectionListener = new AnonymousClass64(this);
        this.mExpandGroups = new HashMap();
        this.mGroupExpandListener = new AnonymousClass65(this);
        this.mGroupCollapseListener = new AnonymousClass66(this);
        this.mIsDeletingContacts = false;
    }

    static /* synthetic */ boolean access$000(ContactListFragment r0) {
        return r0.mFrequentContacts;
    }

    static /* synthetic */ void access$100(ContactListFragment r0, int r1, boolean r2) {
        r0.triggerLoad(r1, r2);
    }

    static /* synthetic */ void access$1000(ContactListFragment r0, boolean r1, boolean r2) {
        r0.processEditContacts(r1, r2);
    }

    static /* synthetic */ boolean access$10000(ContactListFragment r0, AdapterView r1, View r2, int r3, int r4, SamContact r5) {
        return r0.handleContactEvent(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ void access$10200(ContactListFragment r0) {
        r0.onEditGroupClicked();
    }

    static /* synthetic */ void access$10300(ContactListFragment r0) {
        r0.onAddGroupClicked();
    }

    static /* synthetic */ void access$10400(ContactListFragment r0) {
        r0.onCancelEditGroupClicked();
    }

    static /* synthetic */ OTabSegmentedLayout access$10500(ContactListFragment r0) {
        return r0.mOGroupTabSegmentedLayout;
    }

    static /* synthetic */ ArrayList access$10600(ContactListFragment r0) {
        return r0.mOldContacts;
    }

    static /* synthetic */ ArrayList access$10602(ContactListFragment r0, ArrayList r1) {
        r0.mOldContacts = r1;
        return r1;
    }

    static /* synthetic */ Runnable access$10700(ContactListFragment r0) {
        return r0.mRefreshProfileRunnable;
    }

    static /* synthetic */ void access$10800(ContactListFragment r0, Context r1, int r2, ArrayList r3) {
        r0.setProfileData(r1, r2, r3);
    }

    static /* synthetic */ void access$10900(ContactListFragment r0, ArrayList r1, int r2) {
        r0.notifyDataSetChangedBySortMode(r1, r2);
    }

    static /* synthetic */ void access$1100(ContactListFragment r0) {
        r0.hideWaitTipView();
    }

    static /* synthetic */ boolean access$11002(ContactListFragment r0, boolean r1) {
        r0.mBlacklistHasChanged = r1;
        return r1;
    }

    static /* synthetic */ void access$11100(ContactListFragment r0) {
        r0.inflateVoiceButton();
    }

    static /* synthetic */ void access$11200(ContactListFragment r0) {
        r0.refreshBcrCount();
    }

    static /* synthetic */ void access$11300(ContactListFragment r0, Uri r1, ArrayList r2, boolean r3) {
        r0.startDetailActivity(r1, r2, r3);
    }

    static /* synthetic */ FragmentActivity access$11400(ContactListFragment r0) {
        return r0.mActivity;
    }

    static /* synthetic */ void access$11500(ContactListFragment r0, Uri r1, ArrayList r2, boolean r3, boolean r4) {
        r0.startDetailActivity(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$11600(ContactListFragment r0) {
        r0.doRemoveAction();
    }

    static /* synthetic */ OActionSheet access$11700(ContactListFragment r0) {
        return r0.mDeleteSheet;
    }

    static /* synthetic */ ContactFragmentsCallback access$11800(ContactListFragment r0) {
        return r0.mFragmentsCallback;
    }

    static /* synthetic */ OPageStatus access$11900(ContactListFragment r0) {
        return r0.mEmptyView;
    }

    static /* synthetic */ void access$1200(ContactListFragment r0, boolean r1, int r2) {
        r0.updateListViewConfig(r1, r2);
    }

    static /* synthetic */ void access$12000(ContactListFragment r0, boolean r1) {
        r0.deleteContacts(r1);
    }

    static /* synthetic */ SelectAllState access$12100(ContactListFragment r0) {
        return r0.mContactSelectAllBtn;
    }

    static /* synthetic */ void access$12200(ContactListFragment r0, boolean r1) {
        r0.contactsSelectAll(r1);
    }

    static /* synthetic */ SelectAllState access$12300(ContactListFragment r0) {
        return r0.mGroupSelectAllBtn;
    }

    static /* synthetic */ GroupBrowseListFragment access$12400(ContactListFragment r0) {
        return r0.mGroupBrowseListFragment;
    }

    static /* synthetic */ OCTitleBar access$12500(ContactListFragment r0) {
        return r0.mOGroupTitleBar;
    }

    static /* synthetic */ BottomDeleteLayoutListener access$12600(ContactListFragment r0) {
        return r0.mBottomDeleteLayoutListener;
    }

    static /* synthetic */ void access$12700(ContactListFragment r0, String r1) {
        r0.doImportContactsAction(r1);
    }

    static /* synthetic */ int access$12802(ContactListFragment r0, int r1) {
        r0.mImportSimId = r1;
        return r1;
    }

    static /* synthetic */ boolean access$12900(ContactListFragment r0, int r1) {
        return r0.importContactsInEmpty(r1);
    }

    static /* synthetic */ boolean access$1300(ContactListFragment r0) {
        return r0.mHasQuickBar;
    }

    static /* synthetic */ boolean access$1302(ContactListFragment r0, boolean r1) {
        r0.mHasQuickBar = r1;
        return r1;
    }

    static /* synthetic */ String access$13700() {
        return CONTACT_QUERY;
    }

    static /* synthetic */ boolean access$13800(ContactListFragment r0) {
        return r0.mIsHasPhoneNum;
    }

    static /* synthetic */ String[] access$13900(ContactListFragment r0) {
        return r0.getContactProjection();
    }

    static /* synthetic */ int access$1400(ContactListFragment r0) {
        return r0.mQuickBarState;
    }

    static /* synthetic */ ArrayList access$14000(ContactListFragment r0, int r1, boolean r2) {
        return r0.getListDataBySortMode(r1, r2);
    }

    static /* synthetic */ void access$14100(ContactListFragment r0) {
        r0.clearRecommendCache();
    }

    static /* synthetic */ void access$14200(ContactListFragment r0) {
        r0.requerySearchOrRecommendIfNeed();
    }

    static /* synthetic */ void access$14300(ContactListFragment r0) {
        r0.clearModeState();
    }

    static /* synthetic */ boolean access$14400(ContactListFragment r0) {
        return r0.mProviderIsNormal;
    }

    static /* synthetic */ boolean access$14500(ContactListFragment r0) {
        return r0.mDataIsReady;
    }

    static /* synthetic */ boolean access$14502(ContactListFragment r0, boolean r1) {
        r0.mDataIsReady = r1;
        return r1;
    }

    static /* synthetic */ boolean access$14600(ContactListFragment r0) {
        return r0.mIsDeletingContacts;
    }

    static /* synthetic */ boolean access$14602(ContactListFragment r0, boolean r1) {
        r0.mIsDeletingContacts = r1;
        return r1;
    }

    static /* synthetic */ void access$14700(ContactListFragment r0, int r1, boolean r2) {
        r0.initData(r1, r2);
    }

    static /* synthetic */ ContactListFilterController access$14800(ContactListFragment r0) {
        return r0.mContactListFilterController;
    }

    static /* synthetic */ String access$14900() {
        return NO_ACCOUNTS_SELECTION;
    }

    static /* synthetic */ void access$1500(ContactListFragment r0, int r1) {
        r0.initLetter(r1);
    }

    static /* synthetic */ IVoiceAssistantCallback access$15000(ContactListFragment r0) {
        return r0.mCallback;
    }

    static /* synthetic */ boolean access$15102(ContactListFragment r0, boolean r1) {
        r0.mVoiceSearchConnected = r1;
        return r1;
    }

    static /* synthetic */ ShowResultThread access$15200(ContactListFragment r0) {
        return r0.mShowResultThread;
    }

    static /* synthetic */ ShowResultThread access$15202(ContactListFragment r0, ShowResultThread r1) {
        r0.mShowResultThread = r1;
        return r1;
    }

    static /* synthetic */ AlertDialog access$15300(ContactListFragment r0) {
        return r0.mOccupiedDialog;
    }

    static /* synthetic */ AlertDialog access$15302(ContactListFragment r0, AlertDialog r1) {
        r0.mOccupiedDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$15400(ContactListFragment r0, boolean r1) {
        r0.setGroupEditState(r1);
    }

    static /* synthetic */ OButton access$15500(ContactListFragment r0) {
        return r0.mBtnGroupLeft;
    }

    static /* synthetic */ OButton access$15502(ContactListFragment r0, OButton r1) {
        r0.mBtnGroupLeft = r1;
        return r1;
    }

    static /* synthetic */ OButton access$15600(ContactListFragment r0, int r1, boolean r2, OCTitleBar r3, OButton r4) {
        return r0.getTitleBtn(r1, r2, r3, r4);
    }

    static /* synthetic */ OButton access$15700(ContactListFragment r0) {
        return r0.mBtnGroupRightDelete;
    }

    static /* synthetic */ OButton access$15800(ContactListFragment r0) {
        return r0.mBtnGroupMenu;
    }

    static /* synthetic */ String access$15900(ContactListFragment r0, String r1) {
        return r0.getPinYinCityName(r1);
    }

    static /* synthetic */ boolean access$1600(ContactListFragment r0) {
        return r0.mIsSearch;
    }

    static /* synthetic */ HashMap access$16000(ContactListFragment r0) {
        return r0.mExpandGroups;
    }

    static /* synthetic */ void access$16100(ContactListFragment r0, boolean r1, boolean r2, boolean r3, boolean r4) {
        r0.processEditContacts(r1, r2, r3, r4);
    }

    static /* synthetic */ OIndexScrollbar access$1700(ContactListFragment r0) {
        return r0.mQuickBar;
    }

    static /* synthetic */ void access$1800(ContactListFragment r0) {
        r0.hideCityListView();
    }

    static /* synthetic */ ContactPhotoManager access$1900(ContactListFragment r0) {
        return r0.mPhotoManager;
    }

    static /* synthetic */ ContactsListSortByNameAdapter access$200(ContactListFragment r0) {
        return r0.mNorAdapter;
    }

    static /* synthetic */ AsyncImageLoader access$2000(ContactListFragment r0) {
        return r0.getAsyncImageLoader();
    }

    static /* synthetic */ ContactsListSortByNameAdapter access$202(ContactListFragment r0, ContactsListSortByNameAdapter r1) {
        r0.mNorAdapter = r1;
        return r1;
    }

    static /* synthetic */ ContactsSelectionListener access$2100(ContactListFragment r0) {
        return r0.mContactsSelectionListener;
    }

    static /* synthetic */ ContactsListBaseAdapter.VoiceBtnCallBack access$2200(ContactListFragment r0) {
        return r0.mVoiceBtnCallBack;
    }

    static /* synthetic */ void access$2300(ContactListFragment r0, ListView r1) {
        r0.setEmptyView(r1);
    }

    static /* synthetic */ boolean access$2400(ContactListFragment r0) {
        return r0.mVisible;
    }

    static /* synthetic */ void access$2500(ContactListFragment r0, SamContact r1) {
        r0.refreshProfileDetailCache(r1);
    }

    static /* synthetic */ ForceTouchController access$2600(ContactListFragment r0) {
        return r0.mForceTouchController;
    }

    static /* synthetic */ FrameLayout access$2700(ContactListFragment r0) {
        return r0.mCityListViewFrame;
    }

    static /* synthetic */ ExpandAdapterForLocation access$2800(ContactListFragment r0) {
        return r0.mCityAdapter;
    }

    static /* synthetic */ ExpandAdapterForLocation access$2802(ContactListFragment r0, ExpandAdapterForLocation r1) {
        r0.mCityAdapter = r1;
        return r1;
    }

    static /* synthetic */ RelativeLayout access$2900(ContactListFragment r0) {
        return r0.mContactsEmptyView;
    }

    static /* synthetic */ FlowAdapter access$300(ContactListFragment r0) {
        return r0.mFlowAdapter;
    }

    static /* synthetic */ QuickContactExpandableListView access$3000(ContactListFragment r0) {
        return r0.mCityListView;
    }

    static /* synthetic */ FlowAdapter access$302(ContactListFragment r0, FlowAdapter r1) {
        r0.mFlowAdapter = r1;
        return r1;
    }

    static /* synthetic */ void access$3100(ContactListFragment r0, ExpandableListAdapter r1) {
        r0.processGroupExpandableState(r1);
    }

    static /* synthetic */ ContactsListSortByTimesAdapter access$3200(ContactListFragment r0) {
        return r0.mTimesAdapter;
    }

    static /* synthetic */ ContactsListSortByTimesAdapter access$3202(ContactListFragment r0, ContactsListSortByTimesAdapter r1) {
        r0.mTimesAdapter = r1;
        return r1;
    }

    static /* synthetic */ ContactsListSortByAddedTimeAdapter access$3300(ContactListFragment r0) {
        return r0.mAddedTimesAdapter;
    }

    static /* synthetic */ ContactsListSortByAddedTimeAdapter access$3302(ContactListFragment r0, ContactsListSortByAddedTimeAdapter r1) {
        r0.mAddedTimesAdapter = r1;
        return r1;
    }

    static /* synthetic */ ExpandAdapterForCompany access$3400(ContactListFragment r0) {
        return r0.mCompanyAdapter;
    }

    static /* synthetic */ ExpandAdapterForCompany access$3402(ContactListFragment r0, ExpandAdapterForCompany r1) {
        r0.mCompanyAdapter = r1;
        return r1;
    }

    static /* synthetic */ ContactsListSortByNameAdapter access$3500(ContactListFragment r0) {
        return r0.mPhoneContactsAdapter;
    }

    static /* synthetic */ ContactsListSortByNameAdapter access$3502(ContactListFragment r0, ContactsListSortByNameAdapter r1) {
        r0.mPhoneContactsAdapter = r1;
        return r1;
    }

    static /* synthetic */ ContactsListSortBySimAdapter access$3600(ContactListFragment r0) {
        return r0.mSimAdapter;
    }

    static /* synthetic */ ContactsListSortBySimAdapter access$3602(ContactListFragment r0, ContactsListSortBySimAdapter r1) {
        r0.mSimAdapter = r1;
        return r1;
    }

    static /* synthetic */ ContactsListSortByBCRAdapter access$3700(ContactListFragment r0) {
        return r0.mBCRAdapter;
    }

    static /* synthetic */ ContactsListSortByBCRAdapter access$3702(ContactListFragment r0, ContactsListSortByBCRAdapter r1) {
        r0.mBCRAdapter = r1;
        return r1;
    }

    static /* synthetic */ void access$3800(ContactListFragment r0) {
        r0.resetSearchBar();
    }

    static /* synthetic */ boolean access$3900(ContactListFragment r0) {
        return r0.mResetContactListView;
    }

    static /* synthetic */ boolean access$3902(ContactListFragment r0, boolean r1) {
        r0.mResetContactListView = r1;
        return r1;
    }

    static /* synthetic */ View access$400(ContactListFragment r0) {
        return r0.mContactsFragment;
    }

    static /* synthetic */ void access$4000(ContactListFragment r0) {
        r0.showWaitTipView();
    }

    static /* synthetic */ ArrayList access$4100(ContactListFragment r0, Map r1) {
        return r0.getSearchMergeList(r1);
    }

    static /* synthetic */ QuickContactListView access$4200(ContactListFragment r0) {
        return r0.mSearchResultList;
    }

    static /* synthetic */ SearchResultAdapter access$4300(ContactListFragment r0) {
        return r0.mSearchResultAdapter;
    }

    static /* synthetic */ Map access$4400(ContactListFragment r0) {
        return r0.mSearchKeyList;
    }

    static /* synthetic */ Map access$4402(ContactListFragment r0, Map r1) {
        r0.mSearchKeyList = r1;
        return r1;
    }

    static /* synthetic */ String access$4500(ContactListFragment r0) {
        return r0.mSearchKey;
    }

    static /* synthetic */ TextView access$4600(ContactListFragment r0) {
        return r0.mSearchEmptyView;
    }

    static /* synthetic */ OPageStatus access$4700(ContactListFragment r0) {
        return r0.mRecommendEmptyView;
    }

    static /* synthetic */ ForceTouchController access$4800(ContactListFragment r0) {
        return r0.mSearchController;
    }

    static /* synthetic */ void access$4900(ContactListFragment r0) {
        r0.refreshVisibleListItems();
    }

    static /* synthetic */ HeadersListView access$500(ContactListFragment r0) {
        return r0.mContactListView;
    }

    static /* synthetic */ OCTitleBar access$5000(ContactListFragment r0) {
        return r0.mOSearchTitlebarView;
    }

    static /* synthetic */ IContactSearchBarPresenter access$5100(ContactListFragment r0) {
        return r0.getPresenter();
    }

    static /* synthetic */ void access$5200(ContactListFragment r0) {
        r0.showImportContactsInEmptyDialog();
    }

    static /* synthetic */ Vibrator access$5800(ContactListFragment r0) {
        return r0.mVibrator;
    }

    static /* synthetic */ ViewGroup access$5900(ContactListFragment r0) {
        return r0.mSearchResultDialog;
    }

    static /* synthetic */ boolean access$600(ContactListFragment r0) {
        return r0.mIsEdit;
    }

    static /* synthetic */ ViewGroup access$6000(ContactListFragment r0) {
        return r0.mEmptyResultDialog;
    }

    static /* synthetic */ boolean access$6100(ContactListFragment r0) {
        return r0.mCoverDismiss;
    }

    static /* synthetic */ boolean access$6102(ContactListFragment r0, boolean r1) {
        r0.mCoverDismiss = r1;
        return r1;
    }

    static /* synthetic */ Runnable access$6200(ContactListFragment r0) {
        return r0.mStartRecord;
    }

    static /* synthetic */ long access$6300(ContactListFragment r2) {
        return r2.mLastStartTime;
    }

    static /* synthetic */ long access$6302(ContactListFragment r0, long r1) {
        r0.mLastStartTime = r1;
        return r1;
    }

    static /* synthetic */ Runnable access$6400(ContactListFragment r0) {
        return r0.mVoiceUiRunnable;
    }

    static /* synthetic */ View access$6500(ContactListFragment r0) {
        return r0.mWave;
    }

    static /* synthetic */ void access$6600(ContactListFragment r0) {
        r0.dismissCloseVoiceDialog();
    }

    static /* synthetic */ AlertDialog access$6700(ContactListFragment r0) {
        return r0.mCloseVoiceDialog;
    }

    static /* synthetic */ View access$6800(ContactListFragment r0) {
        return r0.mCover;
    }

    static /* synthetic */ void access$6900(ContactListFragment r0, boolean r1) {
        r0.stopRecord(r1);
    }

    static /* synthetic */ SelectionSet access$700(ContactListFragment r0) {
        return r0.mSelectedSet;
    }

    static /* synthetic */ Runnable access$7000(ContactListFragment r0) {
        return r0.mTimeoutThread;
    }

    static /* synthetic */ void access$7100(ContactListFragment r0) {
        r0.dismissWave();
    }

    static /* synthetic */ boolean access$7200(ContactListFragment r0) {
        return r0.mStartedRecongnize;
    }

    static /* synthetic */ boolean access$7202(ContactListFragment r0, boolean r1) {
        r0.mStartedRecongnize = r1;
        return r1;
    }

    static /* synthetic */ boolean access$7300(ContactListFragment r0) {
        return r0.isResultDialogShown();
    }

    static /* synthetic */ void access$7400(ContactListFragment r0, View r1, MotionEvent r2) {
        r0.handleActionMove(r1, r2);
    }

    static /* synthetic */ void access$7500(ContactListFragment r0) {
        r0.onEditContactClicked();
    }

    static /* synthetic */ void access$7600(ContactListFragment r0) {
        r0.onAddNewContactClicked();
    }

    static /* synthetic */ void access$7700(ContactListFragment r0) {
        r0.onSettingsTitleClick();
    }

    static /* synthetic */ void access$7800(ContactListFragment r0) {
        r0.onCancelEditContactClicked();
    }

    static /* synthetic */ void access$7900(ContactListFragment r0) {
        r0.cancelSearch();
    }

    static /* synthetic */ void access$800(ContactListFragment r0, int r1) {
        r0.refreshOptionBar(r1);
    }

    static /* synthetic */ OTabSegmentedLayout access$8000(ContactListFragment r0) {
        return r0.mOContactTabSegmentedLayout;
    }

    static /* synthetic */ void access$8100(ContactListFragment r0) {
        r0.onTabAllClicked();
    }

    static /* synthetic */ void access$8200(ContactListFragment r0) {
        r0.onTabGroupClicked();
    }

    static /* synthetic */ RelativeLayout access$8300(ContactListFragment r0) {
        return r0.mSearchResultView;
    }

    static /* synthetic */ boolean access$8400(ContactListFragment r0) {
        return r0.mIsNavigationShown;
    }

    static /* synthetic */ boolean access$8402(ContactListFragment r0, boolean r1) {
        r0.mIsNavigationShown = r1;
        return r1;
    }

    static /* synthetic */ Point access$8500(ContactListFragment r0) {
        return r0.mOutSize;
    }

    static /* synthetic */ RelativeLayout access$8600(ContactListFragment r0) {
        return r0.mContactsFrameView;
    }

    static /* synthetic */ int access$8700(ContactListFragment r0) {
        return r0.mNavigationBarHeight;
    }

    static /* synthetic */ Animation.AnimationListener access$8800(ContactListFragment r0) {
        return r0.mCoverAnimationTracker;
    }

    static /* synthetic */ ImageButton access$8900(ContactListFragment r0) {
        return r0.mBtnVoiceSearchContacts;
    }

    static /* synthetic */ OButton access$900(ContactListFragment r0) {
        return r0.mBtnContactLeft;
    }

    static /* synthetic */ boolean access$9000(ContactListFragment r0) {
        return r0.mCancelRecognizeByTooShortTime;
    }

    static /* synthetic */ boolean access$9002(ContactListFragment r0, boolean r1) {
        r0.mCancelRecognizeByTooShortTime = r1;
        return r1;
    }

    static /* synthetic */ boolean access$9100(ContactListFragment r0) {
        return r0.mHasResult;
    }

    static /* synthetic */ boolean access$9102(ContactListFragment r0, boolean r1) {
        r0.mHasResult = r1;
        return r1;
    }

    static /* synthetic */ boolean access$9200(ContactListFragment r0) {
        return r0.mHasOccupied;
    }

    static /* synthetic */ boolean access$9202(ContactListFragment r0, boolean r1) {
        r0.mHasOccupied = r1;
        return r1;
    }

    static /* synthetic */ long access$9302(ContactListFragment r0, long r1) {
        r0.mStartedRecongnizeTime = r1;
        return r1;
    }

    static /* synthetic */ Context access$9400(ContactListFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ String access$9502(ContactListFragment r0, String r1) {
        r0.mLetter = r1;
        return r1;
    }

    static /* synthetic */ void access$9600(ContactListFragment r0) {
        r0.hideVoiceSearchBtn();
    }

    static /* synthetic */ void access$9700(ContactListFragment r0) {
        r0.showVoiceSearchBtn();
    }

    static /* synthetic */ void access$9800(ContactListFragment r0, long r1) {
        r0.showVoiceSearchBtnDelayed(r1);
    }

    static /* synthetic */ int access$9900(ContactListFragment r0) {
        return r0.mSortMode;
    }

    static {
        if (SystemProperties.getInt("ro.voice_assistant_enable", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        sVoiceEnabled = r0;
        sLongMenuItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_PHONE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_STAR, LongMenuHelper.MenuType.MENU_WECHAT};
        PROFILE_QUERY_URI = Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data");
        CONTACTS_STATISTICS = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "contacts_statistics");
        NO_ACCOUNTS_SELECTION = "account_name IS NULL";
        MULTI_ACCOUNTS_FLAG = "multi_accouts_flag";
        ACCOUNTS_FILTERS_PARAM = "account_filters";
        PHONE_ID_SELECTION_ARGS = new String[]{"vnd.android.cursor.item/phone_v2"};
        CONTACT_QUERY = null;
        sPerLoadMe = null;
        CONTACTS_WITH_COMPANY_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "contacts_with_company");
        CALLLOG_COUNT_URI = Uri.withAppendedPath(CallLog.CONTENT_URI, "calls/count_group_by_lookup_uri");
        CONTACT_FREQUENCE_PROJECTION = new String[]{"count(*) as count", BlockedCallAdapter.KEY_LOOKUP_URI};
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setFragmentsCallback(ContactFragmentsCallback r1) {
        this.mFragmentsCallback = r1;
    }

    private void setEmptyView(ListView r7) {
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (this.mContactsEmptyView != null) goto L8;
    L9:
        this.mContactsEmptyViewStub.inflate();
        this.mContactsEmptyView = (RelativeLayout) this.mContactsFragment.findViewById(R.id.contacts_empty);
        OPageStatus r0 = (OPageStatus) this.mContactsFragment.findViewById(R.id.black_view);
        this.mEmptyView = r0;
        r0.setTitle(this.mContext.getString(R.string.no_contacts_list));
        this.primaryHint = this.mEmptyView.getTitleView();
        this.mEmptyView.setMessage(this.mContext.getString(R.string.business_card_hint));
        OTextView r1 = this.mEmptyView.getMessageView();
        this.secondaryHint = r1;
        r1.setVisibility(8);
        this.mEmptyView.showButton(true);
        OButton r2 = this.mEmptyView.getButton();
        this.mBtnImportContacts = r2;
        r2.setText(R.string.common_import_contacts);
        this.mBtnImportContacts.setOnClickListener(new AnonymousClass2(this));
        OButton r3 = OButton.Companion.createNeutralButton(this.mContext, this.mEmptyView);
        this.mBtnOpenCamera = r3;
        r3.setText(R.string.open_camera);
        this.mBtnOpenCamera.setOnClickListener(new AnonymousClass3(this));
    L10:
        int r4 = this.mSortMode;
        if (r4 != 32) goto L13;
    L29:
        this.primaryHint.setText(getString(R.string.no_contacts_list));
        this.secondaryHint.setVisibility(8);
        this.mBtnImportContacts.setVisibility(8);
        this.mBtnOpenCamera.setVisibility(8);
    L30:
        View r5 = r7.getEmptyView();
        RelativeLayout r6 = this.mContactsEmptyView;
        if (r5 == r6) goto L33;
        r7.setEmptyView(r6);
    L33:
        ImageButton r8 = this.mBtnVoiceSearchContacts;
        if (r8 == null) goto L37;
        r8.setVisibility(8);
        return;
    L37:
        return;
    L13:
        if (r4 == 64) goto L29;
        if (r4 != 128) goto L19;
        this.primaryHint.setText(getString(R.string.no_contacts_from_bcr));
        this.secondaryHint.setVisibility(0);
        this.secondaryHint.setText(getString(R.string.business_card_hint));
        this.mBtnImportContacts.setVisibility(8);
        this.mBtnOpenCamera.setVisibility(0);
        goto L30
    L19:
        if (ContactsUtils.DEBUG == false) goto L21;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEmptyView mAllContactsSelected = " + this.mAllContactsSelected);
    L21:
        this.primaryHint.setText(getString(R.string.contacts_empty));
        this.secondaryHint.setVisibility(0);
        if (this.mAllContactsSelected == false) goto L27;
        this.secondaryHint.setVisibility(8);
        this.mBtnImportContacts.setVisibility(0);
        LinearLayout.LayoutParams r9 = (LinearLayout.LayoutParams) this.mBtnImportContacts.getLayoutParams();
        if (r9 == null) goto L26;
        r9.topMargin = ContactsUtils.dipTopx(getActivity(), 20.0d);
    L26:
        this.mBtnImportContacts.setLayoutParams(r9);
    L28:
        this.mBtnOpenCamera.setVisibility(8);
        goto L30
    L27:
        this.secondaryHint.setText(getString(R.string.contacts_empty_secondary_filter_contacts));
        this.mBtnImportContacts.setVisibility(8);
        goto L28
    L8:
        if (this.mEmptyView != null) goto L10;
        goto L9
    }

    private void showWaitTipView() {
        if (this.mContactsTipEmptyView != null) goto L5;
        this.mContactsTipEmptyViewStub.inflate();
        this.mContactsTipEmptyView = (RelativeLayout) this.mContactsFragment.findViewById(R.id.contacts_tip_empty);
    L5:
        this.mContactsTipEmptyView.setVisibility(0);
    }

    private void hideWaitTipView() {
        RelativeLayout r0 = this.mContactsTipEmptyView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L10;
        this.mContactsTipEmptyView.setVisibility(8);
        return;
    }

    private void updateListViewConfig(boolean r1, int r2) {
        if (r1 == true) goto L4;
        return;
    L4:
        if (this.mSearchResultList != null) goto L6;
        return;
    L6:
        if (getHost() != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.mSearchKey) == false) goto L11;
        this.mSearchResultList.setDividerHeight(0);
        return;
    L11:
        this.mSearchResultList.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.divider_height));
    }

    private void hideCityListView() {
        FrameLayout r0 = this.mCityListViewFrame;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        RelativeLayout r2 = this.mContactsEmptyView;
        if (r2 == null) goto L9;
        r2.setVisibility(8);
        return;
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public OSearchBar getSearchBar() {
        return this.mOSearchbar;
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public OIconButtonFloating getSearchRightButton() {
        return this.mOSearchRightButton;
    }

    private IContactSearchBarPresenter getPresenter() {
        if (this.mPresenter != null) goto L6;
        ContactSearchBarPresenter r0 = new ContactSearchBarPresenter();
        this.mPresenter = r0;
        r0.attachView(this, getActivity(), getActivity());
    L6:
        return this.mPresenter;
    }

    public void setPrefsCallback(PreferencesCallback r1) {
        this.mPrefsCallback = r1;
    }

    private String[] getContactProjection() {
        PreferencesCallback r0 = this.mPrefsCallback;
        if (r0 == null) goto L20;
        int r1 = r0.getDisplayOrder();
        int r4 = this.mPrefsCallback.getSortOrder();
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getContactProjection: displayOrder=" + r1 + ", sortOrder=" + r4);
        if (r1 != 1) goto L15;
        if (r4 != 1) goto L14;
        return ContactQuery.access$5300();
    L14:
        return ContactQuery.access$5400();
    L15:
        if (r4 != 1) goto L19;
        return ContactQuery.access$5500();
    L19:
        return ContactQuery.access$5600();
    L20:
        r1 = Settings.System.getInt(this.mContext.getContentResolver(), "android.contacts.DISPLAY_ORDER");     // Catch: Exception -> L7
        r4 = Settings.System.getInt(this.mContext.getContentResolver(), "android.contacts.SORT_ORDER");     // Catch: Exception -> L7
    L7:
        r4 = 1;
        r1 = 1;
        goto L8
    }

    public void onPreferencesChanged() {
        triggerLoad(this.mSortMode, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r2) {
        super.onAttach(r2);
        this.mActivity = getActivity();
        this.mContext = r2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        initAnimation();
        this.mIsHasPhoneNum = ContactsUtils.contactsWithPhoneOnly(getActivity());
        this.mNavigationBarHeight = NavigationBarHelper.getNavigationBarHeight(this.mActivity);
        return inflateAndSetupView(r2, r3, r4, R.layout.contact_city_fragment);
    }

    private void inflateVoiceButton() {
        ViewStub r0 = (ViewStub) this.mContactsFragment.findViewById(R.id.stub_voice_button);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.inflate();
        RelativeLayout r1 = (RelativeLayout) this.mContactsFragment.findViewById(R.id.voice_search_container);
        this.voiceSearchContainer = r1;
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) r1.getLayoutParams();
        int r3 = ContactsUtils.getScreenWidth(this.mActivity);
        int r4 = r3 / 5;
        int r5 = r3 / 4;
        r2.leftMargin = (((r3 - (r4 * 4)) / 2) + r4) - ((r5 - r4) / 2);
        r2.width = r5;
        this.voiceSearchContainer.setLayoutParams(r2);
        ImageButton r6 = (ImageButton) this.mContactsFragment.findViewById(R.id.voice_search);
        this.mBtnVoiceSearchContacts = r6;
        r6.setHapticFeedbackEnabled(true);
        ((ViewStub) this.mContactsFragment.findViewById(R.id.stub_controller_layout)).inflate();
        this.mSearchResultDialog = (ViewGroup) this.mContactsFragment.findViewById(R.id.controller_layout);
        ((ViewStub) this.mContactsFragment.findViewById(R.id.stub_empty_layout)).inflate();
        this.mEmptyResultDialog = (ViewGroup) this.mContactsFragment.findViewById(R.id.empty_layout);
        View r7 = this.mContactsFragment.findViewById(R.id.cover);
        this.mCover = r7;
        r7.setOnClickListener(this);
        this.mWave = this.mContactsFragment.findViewById(R.id.wave);
        this.mBtnVoiceSearchContacts.setOnTouchListener(new AnonymousClass4(this));
        initCloseVoiceDialog(this.mContext);
        showVoiceSearchBtn();
    }

    protected View inflateAndSetupView(LayoutInflater r6, ViewGroup r7, Bundle r8, int r9) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "inflateAndSetupView start");
        getActivity().getWindowManager().getDefaultDisplay().getSize(this.mOutSize);
        this.mContactsFragment = r6.inflate(r9, r7, false);
        if (r8 == null) goto L5;
        this.mSelectedGroupUri = (Uri) r8.getParcelable(EXTRA_KEY_GROUP_URI);
    L5:
        this.mSortMode = 1;
        OCTitleBar r10 = (OCTitleBar) this.mContactsFragment.findViewById(R.id.sct_contact_otitlebar);
        this.mOContactTitleBar = r10;
        OButton r11 = getTitleBtn(R.drawable.standard_icon_multi_select_selector, true, r10, this.mBtnContactLeft);
        this.mBtnContactLeft = r11;
        if (r11 == null) goto L8;
        r11.setContentDescription("选择");
        this.mBtnContactLeft.setOnClickListener(new AnonymousClass5(this));
    L8:
        this.mContactSelectAllBtn = null;
        OButton r12 = getTitleBtn(R.drawable.icon_menu_more, false, this.mOContactTitleBar, this.mBtnContactMenu);
        this.mBtnContactMenu = r12;
        if (r12 == null) goto L11;
        r12.setContentDescription(getString(R.string.more_btn));
        final ArrayList r13 = new ArrayList();
        r13.add(new MenuItem(getString(R.string.menu_newContact), 0, 0, new AnonymousClass6(this)));
        r13.add(new MenuItem(getString(R.string.common_settings), 0, 0, new AnonymousClass7(this)));
        this.mBtnContactMenu.setOnClickListener(new AnonymousClass8(this, r13));
    L11:
        OButton r14 = this.mOContactTitleBar.createNeutralButton(getContext(), this.mOContactTitleBar.mRightContainer);
        this.mBtnContactRightDelete = r14;
        r14.setText(R.string.common_cancel);
        this.mBtnContactRightDelete.setVisibility(8);
        this.mBtnContactRightDelete.setContentDescription(getString(R.string.select_all));
        this.mBtnContactRightDelete.setOnClickListener(new AnonymousClass9(this));
        this.mSearchOptionBar = (ViewGroup) this.mContactsFragment.findViewById(R.id.search_or_option_bar);
        this.mOSearchTitlebarView.setClipChildren(false);
        this.mOSearchTitlebarView.setClipToPadding(false);
        ViewGroup r15 = (ViewGroup) this.mOSearchTitlebarView.getChildAt(0);
        r15.setClipChildren(false);
        r15.setClipToPadding(false);
        this.mOSearchTitlebarView.mCenterContainer.setClipChildren(false);
        this.mOSearchTitlebarView.mCenterContainer.setClipToPadding(false);
        this.mOSearchRightButton.setOnClickListener(new AnonymousClass10(this));
        this.mOSearchRightButton.setVisibility(8);
        OSearchBar r16 = new OSearchBar(this.mContext);
        this.mOSearchbar = r16;
        r16.getInputView().setHint(this.mContext.getString(R.string.contact_list_search_hint));
        this.mOSearchTitlebarView.mCenterContainer.setPadding(ContactsUtils.dipTopx(this.mContext, 5.0d), 0, ContactsUtils.dipTopx(this.mContext, 5.0d), 0);
        this.mOSearchTitlebarView.mCenterContainer.addView(this.mOSearchbar);
        this.mOSearchbar.setContentDescription("搜索");
        HeadersListView r17 = (HeadersListView) this.mContactsFragment.findViewById(R.id.main_list);
        this.mContactListView = r17;
        r17.setVisibility(0);
        this.mContactListView.setSlideListener(this.mSlideListener);
        this.mContactListView.setTouchMonitorListener(this.mTouchMonitorListener);
        this.mContactListView.setItemLongClickedListener(this.mItemLongClickedListener);
        this.mContactsEmptyViewStub = (ViewStub) this.mContactsFragment.findViewById(R.id.listview_emptyview_stub);
        this.mContactsTipEmptyViewStub = (ViewStub) this.mContactsFragment.findViewById(R.id.listview_tip_emptyview_stub);
        this.mContactBody = (RelativeLayout) this.mContactsFragment.findViewById(R.id.contacts_body);
        this.mGroupBrowseStub = (ViewStub) this.mContactsFragment.findViewById(R.id.group_browse_stub);
        this.mContactsFrameView = (RelativeLayout) this.mContactsFragment.findViewById(R.id.contacts_frame_view);
        String[] r18 = {getString(R.string.tab_all), getString(R.string.common_groups)};
        LinearLayout r19 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.content_title_segmentedlayout, null, false);
        this.contactTitleBarCenterView = r19;
        OTabSegmentedLayout r20 = (OTabSegmentedLayout) r19.findViewById(R.id.tab_layout_title);
        this.mOContactTabSegmentedLayout = r20;
        r20.setTabTitleAndDrawable(r18, null);
        ViewUtilsKt.setOnTabSelectListenerWithNotify(this.mOContactTabSegmentedLayout, new AnonymousClass11(this));
        this.mOContactTitleBar.mFixedCenterContainer.addView(this.contactTitleBarCenterView);
        this.mPhotoManager = ContactPhotoManager.getInstance(this.mContext);
        this.mContactListView.setOnScrollListener(this);
        this.mContactListView.setOnItemClickListener(this);
        this.mForceTouchController = new ForceTouchController(this.mContactListView, getActivity());
        this.mContactBody.setVisibility(0);
        OIndexScrollbar r21 = (OIndexScrollbar) this.mContactsFragment.findViewById(R.id.main_quickcontactbar);
        this.mQuickBar = r21;
        r21.setQBListener(this.mQBListener);
        this.mQuickBar.setSurnameListener(this.mSurnameListener);
        this.mQuickBar.setOnTouchListener(new AnonymousClass12(this));
        this.mQuickBar.setContentDescription(this.mLetter);
        this.mContactListView.setCompareHasAddedTime(true);
        this.mContactListView.setQuickBar(this.mQuickBar);
        init();
        if (this.mOldContacts != null) goto L14;
    L18:
        this.mContactsFrameView.setOnSystemUiVisibilityChangeListener(new AnonymousClass13(this));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "inflateAndSetupView end");
        return this.mContactsFragment;
    L14:
        if (1 != this.mSortMode) goto L18;
        if (this.mHandler.hasMessages(1001) == true) goto L18;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "inflateAndSetupView notifyDataSetChangedBySortMode");
        notifyDataSetChangedBySortMode(this.mOldContacts, 1);
        goto L18
    }

    private OButton getTitleBtn(int r3, boolean r4, OCTitleBar r5, OButton r6) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (this.mContext == null) goto L18;
        LinearLayout r0 = r5.mLeftContainer;
        if (r4 == true) goto L9;
        r0 = r5.mRightContainer;
    L9:
        if (r6 == null) goto L14;
        if (r0 == null) goto L14;
        if (r0.indexOfChild(r6) == (-1)) goto L14;
        r0.removeView(r6);
    L14:
        OButton r7 = r5.createTransIconButton(this.mContext, r0);
        r7.setMIcon(this.mContext.getDrawable(r3));
        return r7;
    L18:
        return null;
    }

    private void contactsSelectAll(boolean r3) {
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L5;
        r0.hideLetterGrid();
    L5:
        if (r3 == false) goto L22;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_SELECT_ALL_CONTACTS);
        int r4 = this.mSortMode;
        if (r4 != 2) goto L10;
        this.mSelectedSet.addAll(this.mContactsIdForLocation);
    L23:
        refreshAdapter(true);
        return;
    L10:
        if (r4 != 32) goto L13;
        this.mSelectedSet.addAll(this.mContactsIdSIM1);
        goto L23
    L13:
        if (r4 != 64) goto L16;
        this.mSelectedSet.addAll(this.mContactsIdSIM2);
        goto L23
    L16:
        if (r4 != 128) goto L19;
        this.mSelectedSet.addAll(this.mContactsIdBCR);
        goto L23
    L19:
        if (r4 != 256) goto L21;
        this.mSelectedSet.addAll(this.mPhoneContactsIdList);
        goto L23
    L21:
        this.mSelectedSet.addAll(this.mContactsIdList);
        goto L23
    L22:
        this.mSelectedSet.clear();
        goto L23
    }

    private boolean isOutSideVoiceButton(View r3, MotionEvent r4) {
        float r2 = r4.getX();
        float r5 = r4.getY();
        if (r2 > (r3.getLeft() - 50)) goto L5;
    L14:
        return true;
    L5:
        if (r2 >= (r3.getRight() + 50)) goto L14;
        if (r5 <= (r3.getTop() - 50)) goto L14;
        if (r5 >= (r3.getBottom() + 50)) goto L14;
        return false;
    }

    private void handleActionMove(View r3, MotionEvent r4) {
        if (isOutSideVoiceButton(r3, r4) == false) goto L11;
        ImageButton r5 = this.mBtnVoiceSearchContacts;
        if (r5 == null) goto L12;
        r5.setEnabled(false);
        this.mBtnVoiceSearchContacts.setPressed(false);
        if (isResultDialogShown() == true) goto L9;
        AnimationUtil.stopRecordWithAnimation(this.mWave);
        dismissWave();
        this.mHandler.removeCallbacks(this.mVoiceUiRunnable);
        dismissCover();
        stopRecord(true);
        this.mHandler.removeCallbacks(this.mStartRecord);
        this.mHandler.removeCallbacks(this.mShowResultThread);
        this.mHandler.removeCallbacks(this.mTimeoutThread);
    L9:
        this.mHandler.postDelayed(new AnonymousClass15(this), 100);
        return;
    L12:
        return;
    }

    private void stopRecord(boolean r9) {
        IVoiceAssistantService r4 = this.mVoiceInterface;     // Catch: Throwable -> L11 RemoteException -> L17
        if (r4 == null) goto L9;
        r4.stopRecongnize(r9);     // Catch: Throwable -> L11 RemoteException -> L17
        if (r9 == false) goto L9;
        this.mStartedRecongnize = false;     // Catch: Throwable -> L11 RemoteException -> L17
    L9:
        if ((System.currentTimeMillis() - this.mStartedRecongnizeTime) <= 150) goto L19;
    L20:
        this.mCancelRecognizeByTooShortTime = false;
        return;
    L19:
        this.mCancelRecognizeByTooShortTime = true;
        dismissWave();
        dismissCover();
        resetRecognizeByTooShortTime();
        return;
    L11:
        th = move-exception;
        if ((System.currentTimeMillis() - this.mStartedRecongnizeTime) > 150) goto L15;
        this.mCancelRecognizeByTooShortTime = true;
        dismissWave();
        dismissCover();
        resetRecognizeByTooShortTime();
    L16:
        throw th;
    L15:
        this.mCancelRecognizeByTooShortTime = false;
    L18:
        if ((System.currentTimeMillis() - this.mStartedRecongnizeTime) > 150) goto L20;
        goto L19
    }

    private void resetRecognizeByTooShortTime() {
        TimerTask r0 = new AnonymousClass16(this);
        new Timer().schedule(r0, 200);
    }

    private void dismissWave() {
        View r0 = this.mWave;
        if (r0 == null) goto L6;
        AnimationUtil.cancelAnimation(r0);
        this.mWave.clearAnimation();
        this.mWave.setVisibility(8);
        return;
    }

    private void dismissCover() {
        View r0 = this.mCover;
        if (r0 == null) goto L6;
        AnimationUtil.cancelAnimation(r0);
        this.mCover.clearAnimation();
        this.mCover.setVisibility(8);
        this.mCoverDismiss = true;
        return;
    }

    private boolean isResultDialogShown() {
        ViewGroup r0 = this.mSearchResultDialog;
        if (r0 != null) goto L5;
    L6:
        ViewGroup r1 = this.mEmptyResultDialog;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.getVisibility() != 0) goto L11;
    L10:
        return true;
    L5:
        if (r0.getVisibility() == 0) goto L10;
        goto L6
    }

    private boolean isSearchBarPopupShowing() {
        return getPresenter().isPopupWindowShowing();
    }

    private void showVoiceSearchBtn() {
        if (this.mBtnVoiceSearchContacts != null) goto L6;
        return;
    L6:
        if (isResumed() == true) goto L8;
        return;
    L8:
        if (this.mIsEdit == false) goto L10;
        return;
    L10:
        if (this.mIsSearch == true) goto L35;
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 != null) goto L14;
    L15:
        RelativeLayout r1 = this.mContactsEmptyView;
        if (r1 == null) goto L20;
        if (r1.getVisibility() != 0) goto L20;
        return;
    L20:
        if (isSearchBarPopupShowing() == false) goto L22;
        return;
    L22:
        if (this.mSortMode != 1) goto L26;
        if (ContactsUtils.isOnlyIncludeProfile(this.mOldContacts) == false) goto L26;
        return;
    L26:
        if (isContactsListViewStateIdle() == true) goto L28;
        return;
    L28:
        if (getTargetListView() != null) goto L30;
        return;
    L30:
        if (getTargetListView().getCount() <= 0) goto L42;
        this.mBtnVoiceSearchContacts.setEnabled(true);
        AnimationUtil.showVoiceBtnWithAnimation(this.mBtnVoiceSearchContacts);
        return;
    L42:
        return;
    L14:
        if (r0.isLetterGridHide() == true) goto L15;
        return;
    }

    private void hideVoiceSearchBtn() {
        this.mHandler.removeCallbacks(this.mScrollIdle);
        ImageButton r0 = this.mBtnVoiceSearchContacts;
        if (r0 == null) goto L6;
        r0.setEnabled(false);
        AnimationUtil.hideVoiceBtnWithAnimation(this.mBtnVoiceSearchContacts);
        return;
    }

    private void showVoiceSearchBtnDelayed(long r3) {
        new Handler().postDelayed(new AnonymousClass22(this), r3);
    }

    private boolean isContactsListViewStateIdle() {
        ListView r2 = getTargetListView();
        if (r2 != null) goto L6;
        return true;
    L6:
        if ((r2 instanceof HorizontalScrollListView) == false) goto L10;
        return ((HorizontalScrollListView) r2).isStateIdle();
    L10:
        if ((r2 instanceof HorizontalScrollExpandableListView) == true) goto L12;
        return true;
    L12:
        return ((HorizontalScrollExpandableListView) r2).isStateIdle();
    }

    private boolean handleContactEvent(AdapterView<?> r14, View r15, int r16, int r17, SamContact r18) {
        if (r15 == null) goto L32;
        if (r18 == null) goto L32;
        Bitmap r6 = null;
        if (r14.getId() == R.id.city_list) goto L9;
        Uri r3 = getContactUri(r18);
        ContactDetailCacheManager.getInstance().loadResultData(r3);
        ContactLoader.Result r4 = ContactDetailCacheManager.getInstance().getResult(r3);
    L11:
        if (this.mSidebarDragHelper.isSidebarShowing(r15) == true) goto L14;
        this.mLongMenuHelper.setMenuItemDatas(r15, R.id.item_foreground, r18, r16, r17, sLongMenuItems);
        this.mLongMenuHelper.show();
        return true;
    L14:
        String r5 = ShareContactByText.toShareText(this.mContext, r4);
        if (r4 != null) goto L17;
    L23:
        AvatarImageView r7 = (AvatarImageView) r15.findViewById(R.id.photo);
        if (r7 != null) goto L26;
    L30:
        this.mSidebarDragHelper.dragContact(r15, getContactUri(r18), r6, false);
        return true;
    L26:
        if (r7.getPhotoID() <= 0) goto L30;
        if (r7.getDrawable() == null) goto L30;
        r6 = ((BitmapDrawable) r7.getDrawable()).getBitmap();
        goto L30
    L17:
        if (TextUtils.isEmpty(r5) == true) goto L23;
        byte[] r8 = r4.getPhotoBinaryData();
        if (r8 == null) goto L21;
        this.mSidebarDragHelper.dragContact(r15, r5, BitmapFactory.decodeByteArray(r8, 0, r8.length));
    L22:
        return true;
    L21:
        this.mSidebarDragHelper.dragContact(r15, r5);
        goto L22
    L9:
        r4 = null;
    L32:
        return false;
    }

    private void refreshVisibleListItems() {
        int r0 = this.mSortMode;
        if (r0 != 1) goto L5;
    L38:
        HeadersListView r1 = this.mContactListView;
        if (r1 == null) goto L62;
        int r2 = r1.getFirstVisiblePosition();
        int r3 = this.mContactListView.getLastVisiblePosition();
        int r4 = r2;
    L42:
        if (r4 > r3) goto L64;
        View r5 = this.mContactListView.getChildAt(r4 - r2);
        if (r5 == null) goto L46;
        OCheckBox r6 = (OCheckBox) r5.findViewById(R.id.checkBox);
    L47:
        if (r6 == null) goto L50;
        long r7 = this.mContactListView.getAdapter().getItemId(r4);
        r6.setChecked(this.mSelectedSet.contains(Long.valueOf(r7)));
    L50:
        r4 = r4 + 1;
        goto L42
    L46:
        r6 = null;
        goto L47
    L64:
        return;
    L62:
        return;
    L5:
        if (r0 != 2) goto L7;
    L21:
        QuickContactExpandableListView r8 = this.mCityListView;
        if (r8 == null) goto L61;
        int r9 = r8.getFirstVisiblePosition();
        int r10 = this.mCityListView.getLastVisiblePosition();
        int r11 = r9;
    L25:
        if (r11 > r10) goto L63;
        View r12 = this.mCityListView.getChildAt(r11 - r9);
        if (r12 == null) goto L37;
        OCheckBox r13 = (OCheckBox) r12.findViewById(R.id.checkBox);
        if (r13 == null) goto L37;
        ExpandableListAdapter r14 = this.mCityListView.getExpandableListAdapter();
        long r15 = this.mCityListView.getExpandableListPosition(r11);
        int r16 = QuickContactExpandableListView.getPackedPositionGroup(r15);
        int r17 = QuickContactExpandableListView.getPackedPositionChild(r15);
        if (r16 == (-1)) goto L37;
        if (r17 == (-1)) goto L37;
        SamContact r18 = (SamContact) r14.getChild(r16, r17);
        r13.setChecked(this.mSelectedSet.contains(Long.valueOf(r18.contactId)));
    L37:
        r11 = r11 + 1;
        goto L25
    L63:
        return;
    L61:
        return;
    L7:
        if (r0 == 4) goto L38;
        if (r0 == 8) goto L38;
        if (r0 == 16) goto L21;
        if (r0 == 32) goto L38;
        if (r0 == 64) goto L38;
        if (r0 == 128) goto L38;
        if (r0 == 256) goto L38;
    }

    public ContactPhotoManager getPhotoManager() {
        return this.mPhotoManager;
    }

    private void onTabAllClicked() {
        recoveryFromGroupEdit();
        setObserverToWork(true);
        switchTopTabToContact();
        triggerLoad(this.mSortMode, true);
        View r1 = this.mGroupFlipperView;
        if (r1 == null) goto L5;
        r1.setVisibility(8);
    L5:
        this.mContactBody.setVisibility(0);
        getPresenter().requestSeachViewFocus();
        this.mIsShowGroup = false;
        this.mInContacts = true;
        Agent.getInstance().onAttach(TAG);
        showVoiceSearchBtn();
    }

    private void onTabGroupClicked() {
        if (this.mIsSearch == false) goto L5;
        return;
    L5:
        if (getPresenter().isPlayingSearchAnimation() == false) goto L8;
        return;
    L8:
        if (this.mGroupFlipperView != null) goto L10;
        initGroupView();
        GroupBrowseListFragment r0 = (GroupBrowseListFragment) getChildFragmentManager().findFragmentById(R.id.groupbrowseview);
        this.mGroupBrowseListFragment = r0;
        r0.setListener(new OnGroupActionListener(this, null));
        this.mGroupBrowseListFragment.setFragmentsCallback(this.mFragmentsCallback);
    L10:
        this.mGroupFlipperView.setVisibility(0);
        this.mContactBody.setVisibility(8);
        setObserverToWork(false);
        switchTopTabToGroup();
        this.mIsShowGroup = true;
        this.mInContacts = false;
        if (this.mContactListView.isShowQuickContact() == false) goto L14;
        this.mContactListView.hideQuickContact();
    L14:
        if (this.mIsEdit == false) goto L16;
        processEditContacts(false, true);
    L16:
        resetSearchBar();
        this.mQuickBar.hideLetterGrid();
        Agent.getInstance().onAttach("GroupBrowseListFragment");
    }

    public void initGroupView() {
        this.mGroupBrowseStub.inflate();
        OCTitleBar r0 = (OCTitleBar) this.mContactsFragment.findViewById(R.id.sct_group_otitlebar);
        this.mOGroupTitleBar = r0;
        OButton r1 = getTitleBtn(R.drawable.standard_icon_multi_select_selector, true, r0, this.mBtnGroupLeft);
        this.mBtnGroupLeft = r1;
        if (r1 == null) goto L5;
        r1.setContentDescription("选择");
        this.mBtnGroupLeft.setOnClickListener(new AnonymousClass30(this));
    L5:
        OButton r2 = getTitleBtn(R.drawable.icon_menu_more, false, this.mOGroupTitleBar, this.mBtnGroupMenu);
        this.mBtnGroupMenu = r2;
        if (r2 == null) goto L8;
        r2.setContentDescription(getString(R.string.more_btn));
        final ArrayList r3 = new ArrayList();
        r3.add(new MenuItem(getString(R.string.menu_newGroup), 0, 0, new AnonymousClass31(this)));
        r3.add(new MenuItem(getString(R.string.common_settings), 0, 0, new AnonymousClass32(this)));
        this.mBtnGroupMenu.setOnClickListener(new AnonymousClass33(this, r3));
    L8:
        OButton r4 = this.mOGroupTitleBar.createNeutralButton(getContext(), this.mOGroupTitleBar.mRightContainer);
        this.mBtnGroupRightDelete = r4;
        r4.setVisibility(8);
        this.mBtnGroupRightDelete.setText(R.string.common_cancel);
        this.mBtnGroupRightDelete.setContentDescription(getString(R.string.common_cancel));
        this.mBtnGroupRightDelete.setOnClickListener(new AnonymousClass34(this));
        String[] r5 = {getString(R.string.tab_all), getString(R.string.common_groups)};
        LinearLayout r6 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.content_title_segmentedlayout, null, false);
        this.groupTitleBarCenterView = r6;
        OTabSegmentedLayout r7 = (OTabSegmentedLayout) r6.findViewById(R.id.tab_layout_title);
        this.mOGroupTabSegmentedLayout = r7;
        r7.setTabTitleAndDrawable(r5, null);
        this.mOGroupTitleBar.mFixedCenterContainer.addView(this.groupTitleBarCenterView);
        this.mGroupFlipperView = this.mContactsFragment.findViewById(R.id.groupview);
        this.mOGroupTabSegmentedLayout.setCurrentTab(1);
        ViewUtilsKt.setOnTabSelectListenerWithNotify(this.mOGroupTabSegmentedLayout, new AnonymousClass35(this));
    }

    private void switchTopTabToContact() {
        if (this.mIsSearch == false) goto L5;
        return;
    L5:
        this.mOContactTitleBar.setVisibility(0);
        OCTitleBar r0 = this.mOGroupTitleBar;
        if (r0 == null) goto L8;
        r0.setVisibility(8);
    L8:
        this.mOContactTabSegmentedLayout.setCurrentTab(0);
    }

    private void switchTopTabToGroup() {
        if (this.mOGroupTitleBar != null) goto L5;
        return;
    L5:
        this.mOContactTitleBar.setVisibility(8);
        this.mOGroupTitleBar.setVisibility(0);
        this.mOGroupTabSegmentedLayout.setCurrentTab(1);
    }

    public boolean isShowGroup() {
        return this.mIsShowGroup;
    }

    private boolean isShowQuickContact() {
        HeadersListView r0 = this.mContactListView;
        if (r0 != null) goto L6;
    L7:
        QuickContactExpandableListView r1 = this.mCityListView;
        if (r1 != null) goto L11;
    L13:
        return false;
    L11:
        if (r1.isShowQuickContact() == false) goto L13;
    L14:
        return true;
    L6:
        if (r0.isShowQuickContact() == true) goto L14;
        goto L7
    }

    public boolean isSearch() {
        return this.mIsSearch;
    }

    private boolean isSearchAnimationing() {
        return this.mIsSearchAnimationing;
    }

    private void cancelSearch() {
        getPresenter().cancelSearch();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putParcelable(EXTRA_KEY_GROUP_URI, this.mSelectedGroupUri);
    }

    private HashMap<Long, String> getLastInsertContact(Context r11) {
        HashMap<Long, String> r10 = new HashMap();
        Uri.Builder r0 = ContactsContract.Data.CONTENT_URI.buildUpon();
        r0.appendQueryParameter("limit", String.valueOf(3));
        Cursor r12 = r11.getContentResolver().query(r0.build(), new String[]{"contact_id", "data1"}, " mimetype=? and data15 >= ?", new String[]{"vnd.android.cursor.item/added_time", String.valueOf(System.currentTimeMillis() - 86400000)}, "data1 desc");
        if (r12 != null) goto L16;
    L13:
        if (r12 == null) goto L15;
        r12.close();
    L15:
        return r10;
    L16:
    L9:
        th = move-exception;
        if (r12 == null) goto L12;
        r12.close();
    L12:
        throw th;
    L5:
        if (r12.moveToFirst() == false) goto L13;
    L6:
        r10.put(Long.valueOf(r12.getLong(0)), r12.getString(1));     // Catch: Throwable -> L9
        if (r12.moveToNext() == true) goto L6;
        goto L13
    }

    private int getAll(Context r12, ArrayList<SamContact> r13, ArrayList<SamContact> r14) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getAll: start");
        r13.clear();
        r14.clear();
        HashSet<Long> r0 = new HashSet();
        HashMap<Long, String> r2 = getLastInsertContact(r12);
        if (this.mIsHasPhoneNum == false) goto L5;
        String r3 = CONTACT_CITY_QUERY;
    L6:
        Uri r4 = ContactsContract.Contacts.CONTENT_URI;
        if (this.mNoContactsSelected == false) goto L9;
        r3 = NO_ACCOUNTS_SELECTION;
    L10:
        String r8 = r3;
        String[] r7 = getContactProjection();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getAll queryUri=" + r4 + ", proj=" + Arrays.toString(r7) + ", selection=" + r8);
        Cursor r5 = r12.getContentResolver().query(r4, r7, r8, null, PickerFragment.CONTACT_SORT_CNAME);     // Catch: Exception -> L13
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getAll after queryUri=" + r4);
        int r6 = 0;
        if (r5 != null) goto L50;
    L46:
        this.mContactsIdList = r0;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getAll: end ids: " + r0);
        return r6;
    L50:
        this.mDataIsReady = true;     // Catch: Throwable -> L42
        int r9 = 0;
    L19:
        if (r5.moveToNext() == false) goto L39;
        SamContact r10 = new SamContact(0);     // Catch: Throwable -> L42
        r10.contactId = r5.getLong(0);     // Catch: Throwable -> L42
        r0.add(Long.valueOf(r10.contactId));     // Catch: Throwable -> L42
        String r11 = r5.getString(1);     // Catch: Throwable -> L42
        r10.name = ContactsUtils.getContactName(r12, r11);     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r11) == true) goto L24;
        boolean r15 = true;
    L25:
        r10.hasname = r15;     // Catch: Throwable -> L42
        r10.sortkey = r5.getString(5);     // Catch: Throwable -> L42
        r10.phoneBookLabel = r5.getString(9);     // Catch: Throwable -> L42
        r10.section = ContactsUtils.getContactSection(r10.sortkey, r10.phoneBookLabel);     // Catch: Throwable -> L42
        r10.LookKey = r5.getString(6);     // Catch: Throwable -> L42
        r10.photoId = r5.getLong(3);     // Catch: Throwable -> L42
        r10.raw_contactid = r5.getLong(7);     // Catch: Throwable -> L42
        r10.accountType = r5.getString(10);     // Catch: Throwable -> L42
        r10.accountName = r5.getString(11);     // Catch: Throwable -> L42
        if (r5.getCount() >= 30) goto L28;
    L34:
        SamContact r16 = ContactsUtils.generateIfFamilyNameNeedPolyphone(r10);     // Catch: Throwable -> L42
        if (r16 == null) goto L37;
        r13.add(r16);     // Catch: Throwable -> L42
        r9 = r9 + 1;     // Catch: Throwable -> L42
    L37:
        r13.add(r10);     // Catch: Throwable -> L42
        goto L19
    L28:
        if (r14.size() >= 3) goto L34;
        if (r2.size() <= 0) goto L34;
        if (r2.containsKey(Long.valueOf(r10.contactId)) == false) goto L34;
        SamContact r17 = r10.getCopy();     // Catch: Throwable -> L42
        r17.section = r12.getString(R.string.latest_contact);     // Catch: Throwable -> L42
        r17.addedTime = r2.remove(Long.valueOf(r17.contactId));     // Catch: Throwable -> L42
        r17.hasAddedTime = true;     // Catch: Throwable -> L42
        r14.add(r17);     // Catch: Throwable -> L42
        goto L34
    L24:
        r15 = false;
        goto L25
    L39:
        if (r5 == null) goto L41;
        r5.close();
    L41:
        r6 = r9;
    L42:
        th = move-exception;
        if (r5 == null) goto L45;
        r5.close();
    L45:
        throw th;
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getAll error:" + e);
        r5 = null;
        goto L15
    L9:
        r4 = appendAccountsFilterQueryParameter(r4);
        goto L10
    L5:
        r3 = CONTACT_QUERY;
        goto L6
    }

    private void setContactsListFooter(Context r8, ArrayList<SamContact> r9, int r10) {
        if (r9.size() == 0) goto L5;
        String r0 = null;
        boolean r3 = false;
    L10:
        if (r9.size() == 1) goto L12;
    L19:
        if (r3 == true) goto L21;
    L23:
        HashMap r1 = new HashMap();
        setContactsStatistics(r8, r1);
        SamContact r7 = new SamContact(2);
        r7.section = r9.get(r9.size() - 1).section;
        r7.count = r9.size() - r10;
        r7.statisticMap = r1;
        r9.add(r7);
        return;
    L21:
        if (ContactsUtils.isBytedanceFeatureVersion_3_0_Enabled() == false) goto L23;
        SamContact r11 = new SamContact(3);
        r11.section = r0;
        r9.add(r11);
        return;
    L12:
        if (ContactsUtils.isBytedanceFeatureVersion_3_0_Enabled() == false) goto L19;
        SamContact r2 = r9.get(0);
        if (ContactsUtils.DEBUG == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Judge unique contact: " + r2.raw_contactid);
    L17:
        if (ContactsUtils.isBytedanceServiceContact(r8, r2.raw_contactid) == false) goto L19;
        r0 = r9.get(r9.size() - 1).section;
        r3 = true;
        goto L19
    L5:
        if (ContactsUtils.isBytedanceFeatureVersion_3_0_Enabled() == true) goto L7;
        return;
    L7:
        r0 = r8.getResources().getString(R.string.common_i);
        r3 = true;
        goto L10
    }

    private void setContactsStatistics(Context r12, Map<String, Integer> r13) {
        AccountTypeManager r0 = AccountTypeManager.getInstance(this.mContext);
        HashMap r1 = new HashMap();
        Set<ContactListFilter> r2 = this.mContactListFilterController.getFilters();
        if (r2 != null) goto L16;
        List<AccountWithDataSet> r3 = r0.getAccounts(false);
        if (r3 != null) goto L7;
    L12:
        if (r3 != null) goto L14;
    L20:
        Uri r4 = CONTACTS_STATISTICS;
        if (this.mIsHasPhoneNum == false) goto L23;
        r4 = r4.buildUpon().appendQueryParameter("has_phone_number", "true").build();
    L23:
        Cursor r5 = r12.getContentResolver().query(r4, null, null, null, null);
        if (r5 == null) goto L47;
    L50:
        if (r5.moveToNext() == false) goto L42;
        Pair r6 = Pair.create(r5.getString(0), r5.getString(1));     // Catch: Throwable -> L43
        int r7 = r5.getInt(2);     // Catch: Throwable -> L43
        if (r1.containsKey(r6) == false) goto L50;
        if (r7 <= 0) goto L50;
        AccountType r8 = (AccountType) r1.get(r6);     // Catch: Throwable -> L43
        if (ContactsUtils.LOCAL_ACCOUNT_TYPE.equals(r6.first) == false) goto L34;
        String r9 = r12.getResources().getString(R.string.local_bytedance_contact);     // Catch: Throwable -> L43
    L38:
        if (r13.get(r9) == null) goto L40;
        r7 = r7 + r13.get(r9).intValue();     // Catch: Throwable -> L43
    L40:
        r13.put(r9, Integer.valueOf(r7));     // Catch: Throwable -> L43
        goto L50
    L34:
        if ("com.android.sim".equals(r6.first) == false) goto L36;
        r9 = ContactsUtils.getAccountName(this.mContext, (String) r6.first, (String) r6.second);     // Catch: Throwable -> L43
        goto L38
    L36:
        r9 = (String) r8.getDisplayLabel(r12);     // Catch: Throwable -> L43
        goto L38
    L42:
        r5.close();
    L43:
        th = move-exception;
        r5.close();
        throw th;
    L47:
        if (ContactsUtils.DEBUG == false) goto L61;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Contacts statistics: " + r13);
        return;
    L61:
        return;
    L14:
        if (r3.size() != 0) goto L20;
        ContactListFilter r10 = ContactListFilter.createAccountFilter(ContactsUtils.LOCAL_ACCOUNT_TYPE, "default", null);
        r1.put(Pair.create(r10.accountType, r10.accountName), r0.getAccountType(r10.accountType, r10.dataSet));
        goto L20
    L7:
        if (r3.size() <= 0) goto L12;
        Iterator<AccountWithDataSet> r11 = r3.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        AccountWithDataSet r14 = r11.next();
        r1.put(Pair.create(r14.type, r14.name), r0.getAccountTypeForAccount(r14));
        goto L10
    L16:
        Iterator<ContactListFilter> r15 = r2.iterator();
    L18:
        if (r15.hasNext() == false) goto L20;
        ContactListFilter r16 = r15.next();
        r1.put(Pair.create(r16.accountType, r16.accountName), r0.getAccountType(r16.accountType, r16.dataSet));
        goto L18
    }

    private void setProfileData(Context r9, int r10, ArrayList<SamContact> r11) {
        boolean r0 = true;
        if (r10 == 1) goto L6;
        return;
    L6:
        if (ContactsUtils.isBytedanceFeatureVersion_3_0_Enabled() == false) goto L8;
    L10:
        Cursor r12 = null;
        r12 = r9.getContentResolver().query(PROFILE_QUERY_URI, new String[]{GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "display_name", "photo_id", "data1", "mimetype"}, null, null, null);     // Catch: Throwable -> L57
        SamContact r1 = new SamContact(1);     // Catch: Throwable -> L57
        r1.section = r9.getResources().getString(R.string.common_i);     // Catch: Throwable -> L57
        if (r12 != null) goto L14;
    L32:
        r1.name = r9.getResources().getString(R.string.profile_display_name);     // Catch: Throwable -> L57
        r1.contactId = -1;     // Catch: Throwable -> L57
        if (DSUtils.isMultiSimEnabled() == true) goto L35;
        r1.number = getProfileNumber(r9);     // Catch: Throwable -> L57
        r1.normalized_number = ContactsUtils.formatNumber(r1.number);     // Catch: Throwable -> L57
    L53:
        r11.add(0, r1);     // Catch: Throwable -> L57
        if (r12 == null) goto L65;
        r12.close();
        return;
    L65:
        return;
    L35:
        String r8 = r9.getString(R.string.unknown_number);     // Catch: Throwable -> L57
        String r3 = DSUtils.getSimNumber(r9, 0);     // Catch: Throwable -> L57
        String r13 = DSUtils.getSimNumber(r9, 1);     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r3) == false) goto L38;
    L40:
        boolean r4 = false;
    L42:
        if (TextUtils.isEmpty(r13) == false) goto L44;
    L46:
        r0 = false;
    L47:
        if (r4 == false) goto L51;
        r1.number = r3;     // Catch: Throwable -> L57
        if (r0 == false) goto L53;
        r1.normalized_number = r13;     // Catch: Throwable -> L57
        goto L53
    L51:
        if (r0 == false) goto L53;
        r1.number = r13;     // Catch: Throwable -> L57
        goto L53
    L44:
        if (TextUtils.equals(r8, r13) == true) goto L46;
    L38:
        if (TextUtils.equals(r8, r3) == true) goto L40;
        r4 = true;
        goto L42
    L14:
        if (r12.moveToFirst() == false) goto L32;
        r1.name = ContactsUtils.getContactName(r9, r12.getString(1));     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r12.getString(1)) == false) goto L19;
        r0 = false;
    L19:
        r1.hasname = r0;     // Catch: Throwable -> L57
        r1.contactId = r12.getLong(0);     // Catch: Throwable -> L57
        r1.photoId = r12.getLong(2);     // Catch: Throwable -> L57
    L21:
        if ("vnd.android.cursor.item/phone_v2".equals(r12.getString(4)) == false) goto L30;
        String r14 = r12.getString(3);     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r14) == true) goto L30;
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r1.number) == false) goto L27;
        String r2 = "";
    L28:
        r1.number = r15.append(r2).append(r14).toString();     // Catch: Throwable -> L57
        goto L30
    L27:
        r2 = r1.number + SimContactsConstants.ANR_SEP;     // Catch: Throwable -> L57
    L30:
        if (r12.moveToNext() == true) goto L21;
    L57:
        th = move-exception;
        if (r12 == null) goto L60;
        r12.close();
    L60:
        throw th;
    L8:
        if (r11.size() != 0) goto L10;
    }

    private void notifyDataSetChangedBySortMode(ArrayList<SamContact> r3, int r4) {
        this.mHandler.removeMessages(1001);
        Message r0 = new Message();
        r0.what = 1001;
        r0.obj = r3;
        r0.arg1 = r4;
        this.mHandler.sendMessage(r0);
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        SearchUtils.reportSearchEventAndClear();
        super.onDestroy();
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        DSUtils.unregisterIccStateListener(this.mIccStateListener);
    L5:
        unregisterBcrDataObserver();
        AvatarImageHelper.getIntance().removeAvatarTextFontChangeListener(this);
        ContactListFilterController r0 = this.mContactListFilterController;
        if (r0 == null) goto L8;
        r0.removeListener(this);
    L8:
        SearchResultAdapter r1 = this.mSearchResultAdapter;
        if (r1 == null) goto L11;
        r1.destory();
    L11:
        IContactSearchBarPresenter r2 = this.mPresenter;
        if (r2 == null) goto L14;
        r2.detachView();
    L14:
        this.mRecommendDataLoader.destroy();
        this.mRecommendDataLoader = null;
        InAppSearchClient.INSTANCE.stop();
        BlacklistChangeListener r3 = this.mBlacklistChangeListener;
        if (r3 == null) goto L21;
        BlacklistManager r4 = this.mBlacklistManager;
        if (r4 == null) goto L19;
        r4.removeOnBlacklistChangeListener(r3);
    L19:
        this.mBlacklistChangeListener = null;
        return;
    }

    private String getProfileNumber(Context r1) {
        String r0 = ((TelephonyManager) r1.getSystemService("phone")).getLine1Number();
        if (ContactsUtils.isFeatureUSEnabled() == false) goto L5;
        return r0;
    L5:
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return r0;
    L7:
        if (r0.startsWith("+86") == true) goto L9;
        return r0;
    L9:
        return r0.substring(3).trim();
    }

    private void init() {
        Thread r0 = new Thread(new AnonymousClass38(this));
        this.mPool.submit(r0);
    }

    private void initData(int r7, boolean r8) {
        ArrayList<SamContact> r9 = getListDataBySortMode(r7, r8);     // Catch: Throwable -> L36
        if (this.mIsEdit == true) goto L6;
    L34:
        this.mDataIsReady = true;
        notifyDataSetChangedBySortMode(r9, r7);
        return;
    L6:
        if (this.mSelectedSet.size() <= 0) goto L34;
        Iterator<Long> r1 = this.mSelectedSet.iterator();     // Catch: Throwable -> L36
    L8:
        if (r1.hasNext() == false) goto L34;
        long r2 = r1.next().longValue();     // Catch: Throwable -> L36
        if (r7 != 32) goto L16;
        if (this.mContactsIdSIM1.contains(Long.valueOf(r2)) == true) goto L16;
        r1.remove();     // Catch: Throwable -> L36
    L16:
        if (r7 != 64) goto L21;
        if (this.mContactsIdSIM2.contains(Long.valueOf(r2)) == true) goto L21;
        r1.remove();     // Catch: Throwable -> L36
    L21:
        if (r7 != 128) goto L26;
        if (this.mContactsIdBCR.contains(Long.valueOf(r2)) == true) goto L26;
        r1.remove();     // Catch: Throwable -> L36
    L26:
        if (r7 != 256) goto L31;
        if (this.mPhoneContactsIdList.contains(Long.valueOf(r2)) == true) goto L31;
        r1.remove();     // Catch: Throwable -> L36
    L31:
        if (this.mContactsIdList.contains(Long.valueOf(r2)) == true) goto L8;
        r1.remove();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        this.mDataIsReady = true;
        throw th;
    }

    public static synchronized void preload(Context r2) {
        monitor-enter(ContactListFragment.class);
        ContactListFragment r1 = new ContactListFragment();     // Catch: Throwable -> L7
        sPerLoadMe = r1;     // Catch: Throwable -> L7
        r1.setContactListFilterController(ContactListFilterController.getInstance(r2));     // Catch: Throwable -> L7
        sPerLoadMe.preloadContactsData();     // Catch: Throwable -> L7
        monitor-exit(ContactListFragment.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized ContactListFragment getPreload() {
        monitor-enter(ContactListFragment.class);
        ContactListFragment r1 = sPerLoadMe;     // Catch: Throwable -> L7
        sPerLoadMe = null;     // Catch: Throwable -> L7
        monitor-exit(ContactListFragment.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void preloadContactsData() {
        this.mIsPreloading = true;
        this.mIsHasPhoneNum = ContactsUtils.contactsWithPhoneOnly(ContactsApplication.getInstance());
        ArrayList<SamContact> r1 = new ArrayList();
        boolean r2 = loadContactsFromFile(CACHE_FILE_NAME, r1);
        if (this.mOldContacts != null) goto L9;
        this.mOldContacts = r1;
        if (r2 == false) goto L7;
        int r3 = 2;
    L8:
        this.mQuickBarState = r3;
        notifyDataSetChangedBySortMode(r1, 1);
        goto L9
    L7:
        r3 = 1;
    L9:
        this.mIsPreloading = false;
    }

    private void saveContactsToFile(final ArrayList<SamContact> r3, final String r4, final boolean r5) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "saveContactsToFile: " + r3.size());
    L5:
        Thread r0 = new Thread(new AnonymousClass39(this, r3, r4, r5));
        r0.setPriority(10);
        r0.start();
    }

    private boolean loadContactsFromFile(String r8, ArrayList<SamContact> r9) {
        Parcel r3 = Parcel.obtain();
        boolean r4 = false;
        FileInputStream r10 = ContactsApplication.getInstance().getApplicationContext().openFileInput(r8);     // Catch: Throwable -> L35
        int r5 = r10.available();     // Catch: Throwable -> L28
        ContactsUtils.debugLogD(TAG, "file size: " + r5);     // Catch: Throwable -> L28
        byte[] r2 = new byte[r5];     // Catch: Throwable -> L28
        int r6 = r10.read(r2);     // Catch: Throwable -> L28
        ContactsUtils.debugLogD(TAG, "readed size: " + r6);     // Catch: Throwable -> L28
        r3.unmarshall(r2, 0, r6);     // Catch: Throwable -> L28
        r3.setDataPosition(0);     // Catch: Throwable -> L28
        if (r3.readByte() == 2) goto L13;
        ContactsUtils.debugLogD(TAG, "version not match 2 : " + r6);     // Catch: Throwable -> L28
        if (r10 == null) goto L9;
        r10.close();     // Catch: Throwable -> L35
    L9:
        if (r3 == null) goto L11;
        r3.recycle();
    L11:
        return false;
    L13:
        if (r3.readByte() <= 0) goto L15;
        r4 = true;
    L15:
        int r0 = r3.readInt();     // Catch: Throwable -> L28
    L17:
        if (r3.dataAvail() <= 0) goto L22;
        SamContact r7 = SamContact.CREATOR.createFromParcel(r3);     // Catch: Throwable -> L28
        if (r7 == null) goto L22;
        r9.add(r7);     // Catch: Throwable -> L28
    L22:
        if (r9.size() <= 0) goto L24;
        r9.get(r9.size() - 1).count = r0;     // Catch: Throwable -> L28
    L24:
        if (r10 == null) goto L26;
        r10.close();     // Catch: Throwable -> L35
    L26:
        if (r3 == null) goto L41;
    L27:
        r3.recycle();
    L41:
        ContactsUtils.debugLogD(TAG, "loadContactsFromFile: " + r9.size());
        return r4;
    L28:
        th = move-exception;
        if (r10 != null) goto L47;
    L34:
        throw th;     // Catch: Throwable -> L35
    L47:
        r10.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
    L43:
        th = move-exception;
        if (r3 == null) goto L46;
        r3.recycle();
    L46:
        throw th;
    L37:
        if (ContactsUtils.DEBUG == false) goto L39;
        th.printStackTrace();     // Catch: Throwable -> L43
    L39:
        if (r3 == null) goto L41;
        goto L41
    }

    private boolean loadContactsSortByName(ArrayList<SamContact> r7) {
        ArrayList<SamContact> r2 = new ArrayList();
        Context r3 = getActivity();     // Catch: Exception -> L12
        if (r3 != null) goto L6;
        r3 = ContactsApplication.getInstance().getApplicationContext();     // Catch: Exception -> L12
    L6:
        int r4 = getAll(r3, r7, r2);     // Catch: Exception -> L12
        Collections.sort(r7, new NameSortComparator());     // Catch: Exception -> L12
        setContactsListFooter(r3, r7, r4);     // Catch: Exception -> L12
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "loadContactsSortByName after setContactsListFooter " + r4);     // Catch: Exception -> L12
        boolean r5 = false;
        if (r2.size() <= 0) goto L9;
        Collections.sort(r2, new AddedTimeSortComparator(this));     // Catch: Exception -> L12
        r7.addAll(0, r2);     // Catch: Exception -> L12
        r5 = true;
    L9:
        setProfileData(r3, 1, r7);     // Catch: Exception -> L12
        saveContactsToFile(r7, CACHE_FILE_NAME, r5);     // Catch: Exception -> L12
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "loadContactsSortByName: end");
        return r5;
    L12:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "loadContactsSortByName error:" + e);
        throw e;
    }

    private ArrayList<SamContact> getListDataBySortMode(int r5, boolean r6) {
        ArrayList<SamContact> r0 = new ArrayList();
        int r1 = 2;
        if (r5 == 1) goto L69;
        if (r5 == 2) goto L63;
        if (r5 == 4) goto L57;
        if (r5 == 8) goto L51;
        if (r5 == 16) goto L45;
        if (r5 == 32) goto L39;
        if (r5 == 64) goto L33;
        if (r5 == 128) goto L27;
        if (r5 == 256) goto L21;
        return r0;
    L21:
        if (dataIsReady(r5) == false) goto L25;
        if (r6 == true) goto L25;
        return this.mOldContactsPhoneItems;
    L25:
        ArrayList<SamContact> r2 = getPhoneContacts();
        this.mQuickBarState = 0;
        Collections.sort(r2, new ExpandableSortComparator(this));
        setModeState(r5, true);
        this.mOldContactsPhoneItems = r2;
        return r2;
    L27:
        if (dataIsReady(r5) == false) goto L31;
        if (r6 == true) goto L31;
        return this.mOldContactsBCRItems;
    L31:
        ArrayList<SamContact> r3 = getBusinessCardContacts();
        this.mQuickBarState = 0;
        Collections.sort(r3, new ExpandableSortComparator(this));
        setModeState(r5, true);
        this.mOldContactsBCRItems = r3;
        return r3;
    L33:
        if (dataIsReady(r5) == false) goto L37;
        if (r6 == true) goto L37;
        return this.mOldContactsSim2Items;
    L37:
        ArrayList<SamContact> r4 = getSimContacts(1);
        Collections.sort(r4, new ExpandableSortComparator(this));
        setModeState(r5, true);
        this.mOldContactsSim2Items = r4;
        return r4;
    L39:
        if (dataIsReady(r5) == false) goto L43;
        if (r6 == true) goto L43;
        return this.mOldContactsSim1Items;
    L43:
        ArrayList<SamContact> r7 = getSimContacts(0);
        Collections.sort(r7, new ExpandableSortComparator(this));
        setModeState(r5, true);
        this.mOldContactsSim1Items = r7;
        return r7;
    L45:
        if (dataIsReady(r5) == false) goto L49;
        if (r6 == true) goto L49;
        return this.mOldContactsCompanyItems;
    L49:
        ArrayList<SamContact> r8 = getAllContactsWithCompany();
        Collections.sort(r8, new ExpandableSortComparator(this));
        setModeState(r5, true);
        this.mOldContactsCompanyItems = r8;
        return r8;
    L51:
        if (dataIsReady(r5) == false) goto L55;
        if (r6 == true) goto L55;
        return this.mOldContactAddedTimeItems;
    L55:
        ArrayList<SamContact> r9 = getAddedTimeContacts();
        Collections.sort(r9, new AddedTimeSortComparator(this));
        setModeState(r5, true);
        this.mOldContactAddedTimeItems = r9;
        return r9;
    L57:
        if (dataIsReady(r5) == false) goto L61;
        if (r6 == true) goto L61;
        return this.mOldContactTimesItems;
    L61:
        ArrayList<SamContact> r10 = getContactsTimes();
        Collections.sort(r10, new ContactedTimesSortComparator());
        setModeState(r5, true);
        this.mOldContactTimesItems = r10;
        return r10;
    L63:
        if (dataIsReady(r5) == false) goto L67;
        if (r6 == true) goto L67;
        return this.mOldContactCityItems;
    L67:
        ContactsUtils.setCpuBoost(1000);
        ArrayList<SamContact> r11 = getAllCityContacts();
        Collections.sort(r11, new CityNameSortComparator(this));
        setModeState(r5, true);
        this.mOldContactCityItems = r11;
        return r11;
    L69:
        if (dataIsReady(r5) == false) goto L74;
        if (r6 == true) goto L74;
        return this.mOldContacts;
    L74:
        if (loadContactsSortByName(r0) == true) goto L77;
        r1 = 1;
    L77:
        this.mQuickBarState = r1;
        setModeState(r5, true);
        this.mOldContacts = r0;
        return r0;
    }

    private String getPinYinCityName(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return "";
    L5:
        if (this.mCityPinYinMap.containsKey(r4) == true) goto L10;
        String r1 = ContactsUtils.getPinyinName(r4).toUpperCase().replace(HanziToPinyin.Token.SEPARATOR, "");
        this.mCityPinYinMap.put(r4, r1);
        return r1;
    L10:
        return this.mCityPinYinMap.get(r4);
    }

    private void sendWaitTipMessage(int r3) {
        this.mHandler.removeMessages(1003);
        Message r0 = new Message();
        r0.what = 1003;
        r0.arg1 = r3;
        this.mHandler.sendMessage(r0);
    }

    private ArrayList<SamContact> getAllCityContacts() {
        HashSet<Long> r1 = new HashSet();
        long r2 = System.currentTimeMillis();
        ArrayList<SamContact> r4 = new ArrayList();
        Uri r7 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0)).build().buildUpon().appendQueryParameter("remove_duplicate_entries", "true").build();
        int r5 = this.mPrefsCallback.getDisplayOrder();
        int r6 = this.mPrefsCallback.getSortOrder();
        String[] r8 = PHONE_ID_SELECTION_ARGS;
        int r12 = 0;
        if (this.mNoContactsSelected == false) goto L6;
        String[] r10 = null;
        String r9 = NO_ACCOUNTS_SELECTION;
    L16:
        Cursor r11 = this.mActivity.getContentResolver().query(r7, PhoneQuery.getProjection(r5, r6), r9, r10, "contact_id, data12");
        int r13 = 1;
        this.mDataIsReady = true;
        ArrayList r14 = new ArrayList();
        String r15 = ContactsUtils.getUnknownLocationLabel();
        long r16 = -1;
        int r17 = 0;
    L18:
        if (r11.moveToNext() == false) goto L53;
        if (r17 != 0) goto L28;
        ArrayList<SamContact> r18 = this.mOldContactCityItems;
        if (r18 == null) goto L26;
        if (r18.size() != 0) goto L28;
    L26:
        if ((System.currentTimeMillis() - r2) <= 200) goto L28;
        sendWaitTipMessage(2);
        r17 = r13;
    L28:
        long r19 = r11.getLong(r13);
        String r110 = r11.getString(r12);
        String r111 = r11.getString(13);
        long r112 = r11.getLong(12);
        if (r19 != r16) goto L30;
        SamContact r20 = r4.get(r4.size() - 1);
        long r22 = r2;
        if (TextUtils.equals(r20.headerData, r111) == false) goto L35;
        r20.numbersMap.put(Long.valueOf(r112), r110);
        r2 = r22;
        r13 = 1;
        r12 = 0;
    L35:
        if (ContactsUtils.isExistInList(r14, r110) == false) goto L37;
        r13 = 1;
        r12 = 0;
    L52:
        r2 = r22;
        goto L18
    L37:
        SamContact r3 = new SamContact(0);
        r3.number = r110;
        r3.numbersMap = new HashMap();
        r3.numbersMap.put(Long.valueOf(r112), r110);
        r3.contactId = r19;
        r1.add(Long.valueOf(r3.contactId));
        r3.phoneId = r11.getLong(12);
        if (r11.getInt(2) <= 0) goto L40;
        boolean r21 = true;
    L41:
        r3.isSuperPrimary = r21;
        r3.labelType = r11.getInt(3);
        r3.label = r11.getString(4);
        r3.groupType = ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.mActivity.getResources(), r3.labelType, r3.label);
        r3.name = ContactsUtils.getContactName(this.mActivity, r11.getString(8));
        r3.sortkey = r11.getString(5);
        r3.phoneBookLabel = r11.getString(11);
        r3.section = ContactsUtils.getContactSection(r3.sortkey, r3.phoneBookLabel);
        r3.accountType = r11.getString(15);
        r3.accountName = r11.getString(16);
        r3.normalized_number = r11.getString(6);
        r13 = 1;
        r3.hasname = !TextUtils.isEmpty(r3.name);
        r3.LookKey = r11.getString(9);
        r3.photoId = r11.getLong(10);
        if (ContactsUtils.isUnknownLocation(r111) == false) goto L44;
        r3.headerData = r15;
        r3.headerSortData = "WEIZHIDIDIAN";
    L46:
        if (TextUtils.isEmpty(r3.headerSortData) == true) goto L50;
        r12 = 0;
        char r23 = r3.headerSortData.charAt(0);
        if (Character.isLetter(r23) == false) goto L51;
        r3.headerSectionData = String.valueOf(r23).toUpperCase();
    L51:
        r4.add(r3);
        goto L52
    L50:
        r12 = 0;
        goto L51
    L44:
        r3.headerData = r111;
        r3.headerSortData = r11.getString(14);
        goto L46
    L40:
        r21 = false;
        goto L41
    L30:
        r14.clear();
        r22 = r2;
        r16 = r19;
        goto L35
    L53:
        r11.close();
        this.mContactsIdForLocation = r1;
        return r4;
    L6:
        if (TextUtils.isEmpty(this.mAccountsFilterQueryParameter) == true) goto L15;
        List<AccountWithDataSet> r24 = AccountWithDataSet.unstringifyList(this.mAccountsFilterQueryParameter);
        ArrayList r25 = new ArrayList();
        Iterator<AccountWithDataSet> r26 = r24.iterator();
        String r113 = "";
    L9:
        if (r26.hasNext() == false) goto L14;
        AccountWithDataSet r114 = r26.next();
        if (r113.length() == 0) goto L13;
        r113 = r113 + " OR ";
    L13:
        r113 = r113 + "(account_name = ? AND account_type = ?)";
        r25.add(r114.name);
        r25.add(r114.type);
        goto L9
    L14:
        String[] r27 = (String[]) r25.toArray(new String[r25.size()]);
        r9 = "mimetype = ?  AND (" + r113 + ")";
        String[] r115 = PHONE_ID_SELECTION_ARGS;
        String[] r116 = new String[r115.length + r27.length];
        System.arraycopy(r115, 0, r116, 0, r115.length);
        System.arraycopy(r27, 0, r116, r115.length, r27.length);
        r10 = r116;
        goto L16
    L15:
        r9 = PHONE_ID_SELECTION;
        r10 = r8;
        goto L16
    }

    private ArrayList<SamContact> getAllContactsWithCompany() {
        HashSet<Long> r0 = new HashSet();
        ArrayList<SamContact> r1 = new ArrayList();
        Cursor r2 = this.mActivity.getContentResolver().query(CONTACTS_WITH_COMPANY_URI, ContactsWithCompany.getProjection(this.mPrefsCallback.getDisplayOrder(), this.mPrefsCallback.getSortOrder()), null, null, null, null);
        if (r2 != null) goto L23;
        return r1;
    L23:
        if (r2.moveToNext() == false) goto L18;
        SamContact r3 = new SamContact(0);     // Catch: Throwable -> L20
        r3.contactId = r2.getLong(0);     // Catch: Throwable -> L20
        r0.add(Long.valueOf(r3.contactId));     // Catch: Throwable -> L20
        boolean r5 = true;
        String r6 = r2.getString(1);     // Catch: Throwable -> L20
        r3.name = ContactsUtils.getContactName(this.mActivity, r6);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r6) == false) goto L11;
        r5 = false;
    L11:
        r3.hasname = r5;     // Catch: Throwable -> L20
        r3.sortkey = r2.getString(2);     // Catch: Throwable -> L20
        r3.phoneBookLabel = r2.getString(9);     // Catch: Throwable -> L20
        r3.section = ContactsUtils.getContactSection(r3.sortkey, r3.sortkey);     // Catch: Throwable -> L20
        r3.LookKey = r2.getString(3);     // Catch: Throwable -> L20
        r3.photoId = r2.getLong(4);     // Catch: Throwable -> L20
        r3.raw_contactid = r2.getLong(5);     // Catch: Throwable -> L20
        r3.accountType = r2.getString(7);     // Catch: Throwable -> L20
        r3.accountName = r2.getString(8);     // Catch: Throwable -> L20
        r3.headerData = r2.getString(6);     // Catch: Throwable -> L20
        r3.headerSortData = ContactsUtils.getPinyinName(r3.headerData);     // Catch: Throwable -> L20
        r3.headerSortSection = ContactsUtils.CHAR_POUND;     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r3.headerSortData) == true) goto L16;
        char r4 = r3.headerSortData.charAt(0);     // Catch: Throwable -> L20
        r3.headerSectionData = String.valueOf(r4).toUpperCase();     // Catch: Throwable -> L20
        if (Character.isLetter(r4) == false) goto L16;
        r3.headerSortSection = String.valueOf(r4);     // Catch: Throwable -> L20
    L16:
        r1.add(r3);     // Catch: Throwable -> L20
        goto L23
    L18:
        r2.close();
        this.mContactsIdList = r0;
        return r1;
    L20:
        th = move-exception;
        r2.close();
        throw th;
    }

    private ArrayList<SamContact> getPhoneContacts() {
        HashSet<Long> r0 = new HashSet();
        ArrayList<SamContact> r1 = new ArrayList();
        Uri r3 = ContactsContract.Contacts.CONTENT_URI;
        if (this.mIsHasPhoneNum == false) goto L5;
        String r2 = "has_phone_number >0  and account_type <> 'com.android.sim'";
    L6:
        Cursor r4 = this.mContext.getContentResolver().query(r3, getContactProjection(), r2, null, PickerFragment.CONTACT_SORT_CNAME);
    L19:
    L16:
        th = move-exception;
        r4.close();
        throw th;
    L8:
        if (r4.moveToNext() == false) goto L14;
        boolean r5 = false;
        SamContact r6 = new SamContact(0);     // Catch: Throwable -> L16
        r6.contactId = r4.getLong(0);     // Catch: Throwable -> L16
        r0.add(Long.valueOf(r6.contactId));     // Catch: Throwable -> L16
        String r7 = r4.getString(1);     // Catch: Throwable -> L16
        r6.name = ContactsUtils.getContactName(this.mActivity, r7);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r7) == true) goto L12;
        r5 = true;
    L12:
        r6.hasname = r5;     // Catch: Throwable -> L16
        r6.sortkey = r4.getString(5);     // Catch: Throwable -> L16
        r6.phoneBookLabel = r4.getString(9);     // Catch: Throwable -> L16
        r6.section = ContactsUtils.getContactSection(r6.sortkey, r6.phoneBookLabel);     // Catch: Throwable -> L16
        r6.LookKey = r4.getString(6);     // Catch: Throwable -> L16
        r6.photoId = r4.getLong(3);     // Catch: Throwable -> L16
        r6.raw_contactid = r4.getLong(7);     // Catch: Throwable -> L16
        r6.accountType = r4.getString(10);     // Catch: Throwable -> L16
        r6.accountName = r4.getString(11);     // Catch: Throwable -> L16
        r1.add(r6);     // Catch: Throwable -> L16
        goto L19
    L14:
        r4.close();
        this.mPhoneContactsIdList = r0;
        return r1;
    L5:
        r2 = CONTACT_EXCLUDE_SIM_ACCOUNT_QUERY;
        goto L6
    }

    private ArrayList<SamContact> getSimContacts(int r10) {
        HashSet<Long> r0 = new HashSet();
        ArrayList<SamContact> r1 = new ArrayList();
        Cursor r2 = this.mContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, "account_type = 'com.android.sim' and account_name = '" + MoreContactUtils.getSimAccountName(r10) + "'", null, null);
    L20:
        boolean r4 = true;
        if (r2.moveToNext() == false) goto L11;
        SamContact r3 = new SamContact(0);     // Catch: Throwable -> L17
        r3.contactId = r2.getLong(r2.getColumnIndex("_id"));     // Catch: Throwable -> L17
        r0.add(Long.valueOf(r3.contactId));     // Catch: Throwable -> L17
        String r6 = r2.getString(r2.getColumnIndex("display_name"));     // Catch: Throwable -> L17
        r3.name = ContactsUtils.getContactName(this.mActivity, r6);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r6) == false) goto L9;
        r4 = false;
    L9:
        r3.hasname = r4;     // Catch: Throwable -> L17
        r3.sortkey = r2.getString(r2.getColumnIndex(PickerFragment.CONTACT_SORT_CNAME));     // Catch: Throwable -> L17
        r3.section = ContactsUtils.getContactSection(r3.sortkey);     // Catch: Throwable -> L17
        r3.LookKey = r2.getString(r2.getColumnIndex("lookup"));     // Catch: Throwable -> L17
        r3.photoId = r2.getLong(r2.getColumnIndex("photo_id"));     // Catch: Throwable -> L17
        r3.raw_contactid = r2.getLong(r2.getColumnIndex("name_raw_contact_id"));     // Catch: Throwable -> L17
        r3.accountType = r2.getString(r2.getColumnIndex("account_type"));     // Catch: Throwable -> L17
        r3.accountName = r2.getString(r2.getColumnIndex("account_name"));     // Catch: Throwable -> L17
        r1.add(r3);     // Catch: Throwable -> L17
        goto L20
    L11:
        r2.close();
        if (r10 != 0) goto L14;
        this.mContactsIdSIM1 = r0;
    L16:
        return r1;
    L14:
        if (r10 != 1) goto L16;
        this.mContactsIdSIM2 = r0;
    L17:
        th = move-exception;
        r2.close();
        throw th;
    }

    private ArrayList<SamContact> getBusinessCardContacts() {
        HashSet<Long> r0 = new HashSet();
        ArrayList<SamContact> r1 = new ArrayList();
        Uri r2 = ContactsContract.Contacts.CONTENT_URI;
        if (this.mNoContactsSelected == false) goto L5;
        String r3 = NO_ACCOUNTS_SELECTION;
    L6:
        Cursor r4 = this.mActivity.getContentResolver().query(r2, getContactProjection(), r3, null, null);
        this.mDataIsReady = true;
        if (r4 != null) goto L9;
    L12:
        Cursor r5 = this.mActivity.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id"}, "mimetype='vnd.android.cursor.item/added_time' AND data4='1'", null, null);
        ArrayList r6 = new ArrayList();
        if (r5 != null) goto L29;
    L22:
        Iterator<SamContact> r7 = r1.iterator();
    L24:
        if (r7.hasNext() == false) goto L28;
        SamContact r8 = r7.next();
        if (r6.contains(Long.valueOf(r8.contactId)) == true) goto L24;
        this.mContactsIdBCR.remove(Long.valueOf(r8.contactId));
        r7.remove();
        goto L24
    L28:
        return r1;
    L29:
    L19:
        th = move-exception;
        r5.close();
        throw th;
    L15:
        if (r5.moveToFirst() == false) goto L18;
    L16:
        r6.add(Long.valueOf(r5.getLong(0)));     // Catch: Throwable -> L19
        if (r5.moveToNext() == true) goto L16;
    L18:
        r5.close();
    L9:
        if (r4.moveToNext() == false) goto L11;
        SamContact r9 = new SamContact(0);
        long r10 = r4.getLong(0);
        String r11 = r4.getString(1);
        r9.name = ContactsUtils.getContactName(this.mActivity, r11);
        r9.sortkey = r4.getString(5);
        r9.phoneBookLabel = r4.getString(9);
        r9.section = ContactsUtils.getContactSection(r9.sortkey, r9.phoneBookLabel);
        r9.LookKey = r4.getString(6);
        r9.photoId = r4.getLong(3);
        r9.contactId = r10;
        r0.add(Long.valueOf(r9.contactId));
        r9.hasname = !TextUtils.isEmpty(r11);
        r9.raw_contactid = r4.getLong(7);
        r9.headerData = getResources().getString(R.string.contacts_list_sortbyaddedtime_label);
        r9.accountType = r4.getString(10);
        r9.accountName = r4.getString(11);
        r1.add(r9);
        goto L9
    L11:
        this.mContactsIdBCR = r0;
        r4.close();
        goto L12
    L5:
        r2 = appendAccountsFilterQueryParameter(r2);
        r3 = null;
        goto L6
    }

    public ArrayList<ArrayList<SamContact>> initCompanyExpandableData(ArrayList<SamContact> r6) {
        ArrayList<SamContact> r5 = new ArrayList();
        ArrayList<ArrayList<SamContact>> r0 = new ArrayList();
        Iterator<SamContact> r7 = r6.iterator();
        String r1 = null;
        boolean r2 = true;
    L4:
        if (r7.hasNext() == false) goto L22;
        SamContact r3 = r7.next();
        if (r2 == false) goto L14;
        if (TextUtils.isEmpty(r1) == false) goto L12;
        if (TextUtils.isEmpty(r3.headerData) == false) goto L12;
        r5.add(r3);
        r0.add(r5);
        r2 = false;
    L12:
        r2 = false;
    L14:
        if (TextUtils.equals(r1, r3.headerData) == true) goto L21;
        if (TextUtils.isEmpty(r1) == false) goto L20;
        if (TextUtils.isEmpty(r3.headerData) == true) goto L21;
    L20:
        r1 = r3.headerData;
        r5 = new ArrayList();
        r5.add(r3);
        r0.add(r5);
    L21:
        r5.add(r3);
        goto L4
    L22:
        Collections.sort(r0, new CompanySortComparator());
        return r0;
    }

    public boolean initCity(ArrayList<SamContact> r8, ArrayList<ArrayList<SamContact>> r9, boolean r10) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "send CHECK_CUR_LOCATION_REFRESHED");
    L5:
        this.mHandler.sendEmptyMessageDelayed(1007, 200);
        if (ContactsUtils.DEBUG == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "initCity curCitySortName:null; language:" + Locale.getDefault().getLanguage());
    L8:
        ArrayList<SamContact> r11 = new ArrayList();
        Iterator<SamContact> r12 = r8.iterator();
        String r0 = null;
    L10:
        if (r12.hasNext() == false) goto L18;
        SamContact r2 = r12.next();
        if (r2.headerSortData.equals(r0) == true) goto L13;
        String r13 = r2.headerSortData;
        ArrayList<SamContact> r1 = new ArrayList();
        r1.add(r2);
        if (ContactsUtils.DEBUG == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "initCity contact.citysortname:" + r2.headerSortData);
    L17:
        r1.get(0).headerData = r1.get(0).headerData.replace(getString(R.string.current_city_describe), "");
        r9.add(r1);
        r0 = r13;
        r11 = r1;
        goto L10
    L13:
        r11.add(r2);
        goto L10
    L18:
        return true;
    }

    private boolean isCurrentCity(String r4, LocationToken r5) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "isCurrentCity citySortName:" + r4 + "; locationSortName:" + r5);
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L25;
        if (r5 != null) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r5.city) == true) goto L32;
        boolean r3 = r5.sortCityPinyin.startsWith(r4);
        if (r3 == true) goto L27;
        String r1 = Locale.getDefault().getLanguage();
        if ("zh".equals(r1) == false) goto L22;
        if (r5.removeProvinceCityCharacter() == true) goto L18;
        return r3;
    L18:
        if (ContactsUtils.DEBUG == false) goto L29;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "isCurrentCity targetLocation:" + r5 + " ---- citySortName:" + r4);
    L29:
        return r5.LiteProvinceCityPinyin.contentEquals(r4);
    L22:
        if ("en".equals(r1) == true) goto L24;
        return r3;
    L24:
        return r5.fullProvinceCityPinyin.equalsIgnoreCase(r4);
    L27:
        return r3;
    L32:
        return false;
    L25:
        return false;
    }

    private ArrayList<SamContact> getContactsTimes() {
        HashSet<Long> r0 = new HashSet();
        HashMap<Long, Integer> r1 = getContactFrequence();
        ArrayList<SamContact> r2 = new ArrayList();
        if (this.mIsHasPhoneNum == false) goto L5;
        String r3 = CONTACT_CITY_QUERY;
    L6:
        Uri r4 = ContactsContract.Contacts.CONTENT_URI;
        if (this.mNoContactsSelected == false) goto L9;
        r3 = NO_ACCOUNTS_SELECTION;
    L10:
        ContentResolver r5 = this.mActivity.getContentResolver();
        Cursor r6 = r5.query(r4, getContactProjection(), r3, null, PickerFragment.CONTACT_SORT_CNAME);
        this.mDataIsReady = true;
    L12:
        if (r6.moveToNext() == false) goto L18;
        int r7 = 0;
        SamContact r8 = new SamContact(0);
        r8.contactId = r6.getLong(0);
        r0.add(Long.valueOf(r8.contactId));
        String r9 = r6.getString(1);
        r8.name = ContactsUtils.getContactName(getActivity(), r9);
        r8.hasname = !TextUtils.isEmpty(r9);
        r8.sortkey = r6.getString(5);
        r8.phoneBookLabel = r6.getString(9);
        r8.section = ContactsUtils.getContactSection(r8.sortkey, r8.phoneBookLabel);
        r8.LookKey = r6.getString(6);
        r8.photoId = r6.getLong(3);
        r8.raw_contactid = r6.getLong(7);
        r8.timesContacted = r6.getInt(2);
        r8.accountType = r6.getString(10);
        r8.accountName = r6.getString(11);
        Integer r10 = r1.get(Long.valueOf(r8.contactId));
        if (r10 == null) goto L17;
        r7 = r10.intValue();
    L17:
        r8.timesContacted = r7;
        r8.headerData = getResources().getString(R.string.contacts_list_sortbytimes_label);
        r2.add(r8);
        goto L12
    L18:
        r6.close();
        this.mContactsIdList = r0;
        return r2;
    L9:
        r4 = appendAccountsFilterQueryParameter(r4);
        goto L10
    L5:
        r3 = CONTACT_QUERY;
        goto L6
    }

    private HashMap<Long, Integer> getContactFrequence() {
        HashMap<Long, Integer> r1 = new HashMap();
        Cursor r2 = this.mActivity.getContentResolver().query(CALLLOG_COUNT_URI, CONTACT_FREQUENCE_PROJECTION, CONTACT_FREQUENCE_SELECTION, null, "date DESC LIMIT 500");
        if (r2 != null) goto L63;
    L17:
        if (r2 == null) goto L19;
        r2.close();
    L19:
        HashMap r3 = new HashMap();
        Cursor r5 = this.mActivity.getContentResolver().query(Uri.parse("content://mms-sms/canonical-addresses"), null, null, null, null);
        if (r5 != null) goto L22;
    L29:
        HashMap r6 = new HashMap();
        if (Constants.ANDROID60 == false) goto L32;
        Uri r10 = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter(FtsOptions.TOKENIZER_SIMPLE, "true").build();
    L33:
        Cursor r11 = this.mActivity.getContentResolver().query(r10, new String[]{"recipient_ids", "message_count"}, "type_cs = 0", null, null);
        if (r11 != null) goto L36;
    L45:
        Cursor r0 = this.mActivity.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "data1"}, "mimetype = 'vnd.android.cursor.item/phone_v2'", null, null);
        if (r0 != null) goto L48;
    L62:
        return r1;
    L48:
        if (r0.moveToNext() == false) goto L61;
        long r12 = r0.getLong(0);
        StringBuilder r4 = new StringBuilder(r0.getString(1).replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", ""));
        if (r4.toString().length() < 7) goto L52;
        String r7 = r4.reverse().substring(0, 7);
    L54:
        if (r6.containsKey(r7) == false) goto L56;
        int r8 = ((Integer) r6.get(r7)).intValue();
    L58:
        if (r1.containsKey(Long.valueOf(r12)) == true) goto L59;
        r1.put(Long.valueOf(r12), Integer.valueOf(r8));
        goto L48
    L59:
        r1.put(Long.valueOf(r12), Integer.valueOf(r8 + r1.get(Long.valueOf(r12)).intValue()));
        goto L48
    L56:
        r8 = 0;
        goto L58
    L52:
        r7 = r4.toString();
        goto L54
    L61:
        r0.close();
    L36:
        if (r11.moveToNext() == false) goto L44;
        String r13 = r11.getString(0);
        int r14 = r11.getInt(1);
        String[] r15 = r13.split(HanziToPinyin.Token.SEPARATOR);
        int r16 = r14 / r15.length;
        int r17 = r15.length;
        int r18 = 0;
    L38:
        if (r18 >= r17) goto L36;
        String r19 = (String) r3.get(Long.valueOf(r15[r18]));
        if (r6.containsKey(r19) == false) goto L42;
        r6.put(r19, Integer.valueOf(((Integer) r6.get(r19)).intValue() + r16));
    L43:
        r18 = r18 + 1;
        goto L38
    L42:
        r6.put(r19, Integer.valueOf(r16));
        goto L43
    L44:
        r11.close();
        goto L45
    L32:
        r10 = Uri.parse("content://mms-sms/threads");
    L22:
        if (r5.moveToNext() == false) goto L28;
        long r110 = r5.getLong(0);
        StringBuilder r111 = new StringBuilder(r5.getString(1).replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", ""));
        Long r112 = Long.valueOf(r110);
        if (r111.toString().length() < 7) goto L26;
        String r113 = r111.reverse().substring(0, 7);
    L27:
        r3.put(r112, r113);
        goto L22
    L26:
        r113 = r111.toString();
        goto L27
    L28:
        r5.close();
        goto L29
    L63:
    L9:
        th = move-exception;
        if (r2 == null) goto L82;
        r2.close();     // Catch: Throwable -> L14
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L82:
        throw th;
    L5:
        if (r2.moveToFirst() == false) goto L17;
    L6:
        r1.put(Long.valueOf(ContentUris.parseId(Uri.parse(r2.getString(1)))), Integer.valueOf(r2.getInt(0)));     // Catch: Throwable -> L9
        if (r2.moveToNext() == true) goto L6;
        goto L17
    }

    private ArrayList<SamContact> getAddedTimeContacts() {
        HashSet<Long> r0 = new HashSet();
        ArrayList<SamContact> r1 = new ArrayList();
        if (this.mIsHasPhoneNum == false) goto L5;
        String r2 = CONTACT_CITY_QUERY;
    L6:
        Uri r3 = ContactsContract.Contacts.CONTENT_URI;
        if (this.mNoContactsSelected == false) goto L9;
        r2 = NO_ACCOUNTS_SELECTION;
    L10:
        ContentResolver r4 = this.mActivity.getContentResolver();
        Cursor r5 = r4.query(r3, getContactProjection(), r2, null, PickerFragment.CONTACT_SORT_CNAME);
        this.mDataIsReady = true;
    L12:
        if (r5.moveToNext() == false) goto L14;
        SamContact r6 = new SamContact(0);
        long r7 = r5.getLong(0);
        String r8 = r5.getString(1);
        r6.name = ContactsUtils.getContactName(getActivity(), r8);
        r6.sortkey = r5.getString(5);
        r6.phoneBookLabel = r5.getString(9);
        r6.section = ContactsUtils.getContactSection(r6.sortkey, r6.phoneBookLabel);
        r6.LookKey = r5.getString(6);
        r6.photoId = r5.getLong(3);
        r6.contactId = r7;
        r0.add(Long.valueOf(r6.contactId));
        r6.hasname = !TextUtils.isEmpty(r8);
        r6.raw_contactid = r5.getLong(7);
        r6.headerData = getResources().getString(R.string.contacts_list_sortbyaddedtime_label);
        r6.accountType = r5.getString(10);
        r6.accountName = r5.getString(11);
        r1.add(r6);
        goto L12
    L14:
        this.mContactsIdList = r0;
        r5.close();
        Cursor r12 = this.mActivity.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "data1"}, " mimetype='vnd.android.cursor.item/added_time'", null, null);
        HashMap r9 = new HashMap();
        if (r12 != null) goto L34;
    L24:
        Iterator<SamContact> r13 = r1.iterator();
    L26:
        if (r13.hasNext() == false) goto L33;
        SamContact r10 = r13.next();
        if (r9.size() == 0) goto L33;
        if (r9.containsKey(Long.valueOf(r10.contactId)) == false) goto L26;
        r10.addedTime = (String) r9.remove(Long.valueOf(r10.contactId));
    L33:
        return r1;
    L34:
    L21:
        th = move-exception;
        r12.close();
        throw th;
    L17:
        if (r12.moveToFirst() == false) goto L20;
    L18:
        r9.put(Long.valueOf(r12.getLong(0)), r12.getString(1));     // Catch: Throwable -> L21
        if (r12.moveToNext() == true) goto L18;
    L20:
        r12.close();
        goto L24
    L9:
        r3 = appendAccountsFilterQueryParameter(r3);
        goto L10
    L5:
        r2 = CONTACT_QUERY;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        setObserverToWork(true);
        initStart();
        if (ContactsUtils.isVoiceSearchEnabled() == false) goto L9;
        Intent r1 = new Intent(ContactsUtils.LAUNCH_RECONGNIZE_SERVICE);
        r1.setPackage(ContactsUtils.VOICE_ASSISTANT_PACKAGE);
        if (ContactsUtils.DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "bindService ");
    L7:
        ContactsApplication.getInstance().bindService(r1, this.mVoiceAssistantServiceConnection, 1);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        InAppSearchClient.INSTANCE.prepareSearch();
        refreshBcrCount();
        this.mBlacklistManager.clearCache();
        this.mBlacklistManager.resume();
        boolean r0 = ContactsUtils.isVoiceSearchEnabled();
        if (r0 == false) goto L7;
        RelativeLayout r1 = this.voiceSearchContainer;
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        ImageButton r2 = this.mBtnVoiceSearchContacts;
        if (r2 != null) goto L11;
        if (r0 == false) goto L11;
        this.mHandler.postDelayed(new AnonymousClass40(this), 400);
    L14:
        ContactDetailCacheManager.getInstance().cacheView(this.mContext);
        Intent r3 = this.mActivity.getIntent();
        String r4 = r3.getAction();
        if (DialtactsActivity.ADD_CONTACTS.equals(r4) == false) goto L18;
        r3.setAction(null);
        startCreateNewContactActivity();
    L18:
        if (DialtactsActivity.SEARCH_CONTACTS.equals(r4) == false) goto L21;
        r3.setAction(null);
        getPresenter().startSearch();
    L21:
        if (DialtactsActivity.FREQUENT_CONTACTS.equals(r4) == false) goto L23;
        r3.setAction(null);
        this.mFrequentContacts = true;
        getPresenter().switchSortMode(4);
    L23:
        GroupBrowseListFragment r5 = this.mGroupBrowseListFragment;
        if (r5 != null) goto L26;
        return;
    L26:
        if (r5.isEdit() == false) goto L30;
        setGroupEditState(true);
        return;
    L30:
        return;
    L11:
        if (r2 == null) goto L14;
        if (r0 == true) goto L14;
        r2.setVisibility(8);
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        BottomDeleteLayoutListener r0 = this.mBottomDeleteLayoutListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isBottomBarVisible() == false) goto L9;
        processEditContacts(false, true);
        return;
    }

    private void initStart() {
        this.mKeepSearchState = false;
        if (this.mContactBody != null) goto L5;
        this.mContactBody = (RelativeLayout) this.mContactsFragment.findViewById(R.id.contacts_body);
    L5:
        this.mIsHasPhoneNum = ContactsUtils.contactsWithPhoneOnly(getActivity());
        if (this.mLazyLoadFirstStart == false) goto L8;
        Handler r1 = this.mHandler;
        r1.sendMessageDelayed(r1.obtainMessage(1008, this.mSortMode, 1), 500);
        this.mLazyLoadFirstStart = false;
    L10:
        if (this.mContactBody.getVisibility() != 0) goto L12;
        getPresenter().requestSeachViewFocus();
        switchTopTabToContact();
    L14:
        if (this.mIsSearch == false) goto L17;
        requerySearchOrRecommendIfNeed();
        return;
    L17:
        return;
    L12:
        switchTopTabToGroup();
        goto L14
    L8:
        triggerLoad(this.mSortMode, true);
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        hideQuickContact();
        setObserverToWork(false);
        if (this.mIsClickBtnAddContact == false) goto L5;
        hideSoftKeyboard();
        this.mIsClickBtnAddContact = false;
    L5:
        OActionSheet r1 = this.mDeleteSheet;
        if (r1 != null) goto L8;
    L10:
        PermissionUtils.dismissPermissionGuideDialog();
        if (this.mIsEdit == false) goto L13;
        processEditContacts(false, false);
    L13:
        GroupBrowseListFragment r2 = this.mGroupBrowseListFragment;
        if (r2 == null) goto L16;
        r2.setGroupEdit(false);
        setGroupEditState(false);
    L16:
        this.mHandler.removeCallbacks(this.mShowResultThread);
        this.mHandler.removeCallbacks(this.mTimeoutThread);
        ViewGroup r3 = this.mSearchResultDialog;
        if (r3 == null) goto L24;
        ListView r4 = (ListView) r3.findViewById(R.id.result_list_view);
        if (r4 != null) goto L21;
    L23:
        AnimationUtil.cancelAnimation(this.mSearchResultDialog);
        this.mSearchResultDialog.clearAnimation();
        this.mSearchResultDialog.setVisibility(8);
        goto L24
    L21:
        if (r4.getAdapter() == null) goto L23;
        ((VoiceSearchResultAdapter) r4.getAdapter()).dismissShareDialog();
    L24:
        ViewGroup r5 = this.mEmptyResultDialog;
        if (r5 == null) goto L27;
        AnimationUtil.cancelAnimation(r5);
        this.mEmptyResultDialog.clearAnimation();
        this.mEmptyResultDialog.setVisibility(8);
    L27:
        View r6 = this.mCover;
        if (r6 == null) goto L30;
        AnimationUtil.cancelAnimation(r6);
        this.mCover.clearAnimation();
        this.mCover.setVisibility(8);
    L30:
        dismissWave();
        ImageButton r7 = this.mBtnVoiceSearchContacts;
        if (r7 == null) goto L33;
        r7.setVisibility(8);
    L33:
        dismissCloseVoiceDialog();
        if (ContactsUtils.isVoiceSearchEnabled() == true) goto L36;
    L38:
        this.mRecommendDataLoader.stopLoadRecommendData("ConactsList");
        clearRecommendCache();
        this.mStartedRecongnize = false;
        dismissLongMenu();
        return;
    L36:
        if (this.mVoiceSearchConnected == false) goto L38;
        this.mVoiceAssistantServiceConnection.clear();     // Catch: Exception -> L40
        ContactsApplication.getInstance().unbindService(this.mVoiceAssistantServiceConnection);     // Catch: Exception -> L40
        goto L38
    L8:
        if (r1.isShowing() == false) goto L10;
        this.mDeleteSheet.dismiss();
        goto L10
    }

    private void clearRecommendCache() {
        if (this.mCachedRecommendData == null) goto L6;
        this.mCachedRecommendData = null;
        return;
    }

    private void setObserverToWork(boolean r2) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        registerObserver();
        clearModeState();
        return;
    L7:
        unregisterObserver();
    }

    private void registerObserver() {
        if (this.mContactsContent != null) goto L6;
        this.mContactsContent = new ContactsContent(this, new Handler());
        getActivity().getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, this.mContactsContent);
        return;
    }

    private void unregisterObserver() {
        if (this.mContactsContent == null) goto L6;
        getActivity().getContentResolver().unregisterContentObserver(this.mContactsContent);
        this.mContactsContent = null;
        return;
    }

    private void registerBcrDataObserver() {
        if (this.mBcrDataObserver != null) goto L6;
        final Handler r1 = new Handler();
        this.mBcrDataObserver = new AnonymousClass41(this, r1);
        getActivity().getContentResolver().registerContentObserver(ContactsContract.Data.CONTENT_URI, true, this.mBcrDataObserver);
        return;
    }

    private void unregisterBcrDataObserver() {
        if (this.mBcrDataObserver == null) goto L6;
        getActivity().getContentResolver().unregisterContentObserver(this.mBcrDataObserver);
        this.mBcrDataObserver = null;
        return;
    }

    private void hideQuickContact() {
        HeadersListView r0 = this.mContactListView;
        if (r0 == null) goto L5;
        r0.hideQuickContact();
    L5:
        QuickContactExpandableListView r1 = this.mCityListView;
        if (r1 == null) goto L8;
        r1.hideQuickContact();
    L8:
        QuickContactListView r2 = this.mSearchResultList;
        if (r2 == null) goto L12;
        r2.hideQuickContact();
        return;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.mLocationManager = (LocationManager) getActivity().getSystemService(BatteryTypeInf.BATTERY_LOC_API);
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        DSUtils.registerIccStateListener(this.mIccStateListener);
    L5:
        registerBcrDataObserver();
        this.mVibrator = (Vibrator) getActivity().getSystemService("vibrator");
        AvatarImageHelper.getIntance().addAvatarTextFontChangeListener(this);
        this.mBlacklistManager = BlacklistManager.getInstances(getActivity());
        ContactListFilterController r3 = ContactListFilterController.getInstance(getActivity());
        this.mContactListFilterController = r3;
        r3.checkFilterValidity(false);
        setAccountFilterQuerySelection();
        this.mContactListFilterController.addListener(this);
        this.mSidebarDragHelper = SidebarDragHelper.getInstance(getActivity());
        this.mRecommendDataLoader = new RecommendDataLoader(getActivity(), this);
        setupLongMenu();
        if (this.mBlacklistChangeListener != null) goto L9;
        BlacklistChangeListener r4 = new BlacklistChangeListener(this);
        this.mBlacklistChangeListener = r4;
        this.mBlacklistManager.addOnBlacklistChangeListener(r4);
        return;
    }

    public Uri getContactUri(SamContact r5) {
        if (r5.contactId > 0) goto L7;
        return null;
    L7:
        return ContactsContract.Contacts.getLookupUri(r5.contactId, r5.LookKey);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r6, View r7, int r8, long r9) {
        if (ContactsUtils.isJustClicked() == true) goto L5;
    L7:
        int r10 = r6.getId();
        if (r10 != R.id.main_list) goto L10;
        hideSoftKeyboard();
        if (this.mQuickBar.isLetterGridHidden() == false) goto L26;
        long r11 = 0;
    L27:
        this.mQuickBar.hideLetterGrid();
        int r4 = this.mSortMode;
        if (r4 == 1) goto L93;
        if (r4 == 4) goto L85;
        if (r4 == 8) goto L77;
        if (r4 == 32) goto L69;
        if (r4 == 64) goto L61;
        if (r4 == 128) goto L51;
        if (r4 == 256) goto L43;
        return;
    L43:
        if (this.mIsEdit == false) goto L45;
        processSelectOnItemClicked(r9, r8);
        return;
    L45:
        ContactsListSortByNameAdapter r12 = this.mPhoneContactsAdapter;
        if (r12 != null) goto L48;
        return;
    L48:
        if (r12.getCount() <= 0) goto L117;
        ArrayList r13 = (ArrayList) null;
        startDetailActivity(getContactUri(this.mPhoneContactsAdapter.getList().get(r8)), null, true);
        return;
    L117:
        return;
    L51:
        if (this.mIsEdit == false) goto L53;
        processSelectOnItemClicked(r9, r8);
        return;
    L53:
        ContactsListSortByBCRAdapter r14 = this.mBCRAdapter;
        if (r14 != null) goto L56;
        return;
    L56:
        if (r14.getCount() <= 0) goto L121;
        SamContact r15 = this.mBCRAdapter.getItem(r8);
        if (r15 == null) goto L122;
        ArrayList r16 = (ArrayList) null;
        startDetailActivity(getContactUri(r15), null, true);
        return;
    L122:
        return;
    L121:
        return;
    L61:
        if (this.mIsEdit == false) goto L63;
        processSelectOnItemClicked(r9, r8);
        return;
    L63:
        ContactsListSortBySimAdapter r17 = this.mSimAdapter;
        if (r17 != null) goto L66;
        return;
    L66:
        if (r17.getCount() <= 0) goto L126;
        ArrayList r18 = (ArrayList) null;
        startDetailActivity(getContactUri(this.mSimAdapter.getList().get(r8)), null, true);
        return;
    L126:
        return;
    L69:
        if (this.mIsEdit == false) goto L71;
        processSelectOnItemClicked(r9, r8);
        return;
    L71:
        ContactsListSortBySimAdapter r19 = this.mSimAdapter;
        if (r19 != null) goto L74;
        return;
    L74:
        if (r19.getCount() <= 0) goto L130;
        ArrayList r20 = (ArrayList) null;
        startDetailActivity(getContactUri(this.mSimAdapter.getList().get(r8)), null, true);
        return;
    L130:
        return;
    L77:
        if (this.mIsEdit == false) goto L79;
        processSelectOnItemClicked(r9, r8);
        return;
    L79:
        ContactsListSortByAddedTimeAdapter r21 = this.mAddedTimesAdapter;
        if (r21 != null) goto L82;
        return;
    L82:
        if (r21.getCount() <= 0) goto L134;
        ArrayList r22 = (ArrayList) null;
        startDetailActivity(getContactUri(this.mAddedTimesAdapter.getList().get(r8)), null, true);
        return;
    L134:
        return;
    L85:
        if (this.mIsEdit == false) goto L87;
        processSelectOnItemClicked(r9, r8);
        return;
    L87:
        ContactsListSortByTimesAdapter r23 = this.mTimesAdapter;
        if (r23 != null) goto L90;
        return;
    L90:
        if (r23.getCount() <= 0) goto L138;
        ArrayList r24 = (ArrayList) null;
        startDetailActivity(getContactUri(this.mTimesAdapter.getList().get(r8)), null, true);
        return;
    L138:
        return;
    L93:
        if (this.mIsEdit == false) goto L95;
        processSelectOnItemClicked(r9, r8);
        return;
    L95:
        ContactsListSortByNameAdapter r25 = this.mNorAdapter;
        if (r25 != null) goto L98;
        return;
    L98:
        if (r25.getCount() <= 0) goto L146;
        ContactsUtils.setCpuBoost(1000);
        SamContact r26 = this.mNorAdapter.getList().get(r8);
        if (1 != r26.getType()) goto L104;
        startProfileDetail(r26, r11);
        return;
    L104:
        if (3 == r26.getType()) goto L147;
        this.mMayDeletedPosition = r8;
        final Uri r27 = getContactUri(r26);
        if (r11 <= 0) goto L109;
        this.mHandler.postDelayed(new AnonymousClass42(this, r27), r11);
        return;
    L109:
        ArrayList r28 = (ArrayList) null;
        startDetailActivity(r27, null, true);
        return;
    L147:
        return;
    L146:
        return;
    L26:
        r11 = 100;
        goto L27
    L10:
        if (r10 == R.id.search_listview) goto L13;
        return;
    L13:
        if (this.mSearchResultAdapter != null) goto L15;
        return;
    L15:
        if (this.mSearchResultList.getAdapter() != this.mSearchResultAdapter) goto L112;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_SEARCH_RESULT_ITEM);
        SearchUtils.updateSearchClickAction(r8);
        SearchUtils.reportSearchEventAndClear();
        this.mKeepSearchState = true;
        hideSoftKeyboard();
        SamContact r29 = this.mSearchResultAdapter.getItem(r8);
        if (r29 != null) goto L20;
        return;
    L20:
        if (1 != r29.getType()) goto L22;
        startProfileDetail(r29, 0);
        return;
    L22:
        ArrayList r30 = (ArrayList) null;
        startDetailActivity(getContactUri(r29), null, true);
        return;
    L112:
        return;
    L5:
        if (this.mIsEdit == true) goto L7;
    }

    private void startProfileDetail(SamContact r5, long r6) {
        if (r5.contactId != (-1)) goto L21;
        final Intent r0 = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        r0.setPackage("com.android.contacts");
        r0.putExtra(ContactEditorFragment.INTENT_EXTRA_NEW_LOCAL_PROFILE, true);
        if (DSUtils.isMultiSimEnabled() == false) goto L15;
        if (TextUtils.isEmpty(r5.number) == true) goto L12;
        r0.putExtra("phone", ContactsUtils.formatNumber(r5.number));
        if (TextUtils.isEmpty(r5.normalized_number) == true) goto L20;
        r0.putExtra("secondary_phone", ContactsUtils.formatNumber(r5.normalized_number));
    L20:
        this.mHandler.postDelayed(new AnonymousClass43(this, r0), r6);
        return;
    L12:
        if (TextUtils.isEmpty(r5.normalized_number) == true) goto L20;
        r0.putExtra("phone", ContactsUtils.formatNumber(r5.normalized_number));
        goto L20
    L15:
        if (TextUtils.isEmpty(r5.normalized_number) == true) goto L18;
        r0.putExtra("phone", r5.normalized_number);
        goto L20
    L18:
        if (TextUtils.isEmpty(r5.number) == true) goto L20;
        r0.putExtra("phone", r5.number);
        goto L20
    L21:
        final Uri r7 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), r5.contactId);
        this.mHandler.postDelayed(new AnonymousClass44(this, r7), r6);
    }

    public void removeItemFromList(Uri r4) {
        int r0 = this.mMayDeletedPosition;
        ContactsListSortByNameAdapter r1 = this.mNorAdapter;
        if (r1 == null) goto L15;
        ArrayList<SamContact> r2 = r1.getList();
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.size() <= r0) goto L17;
        if (r0 < 0) goto L18;
        Uri r3 = getContactUri(r2.get(r0));
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.equals(r3) == false) goto L20;
        r2.remove(r0);
        this.mNorAdapter.notifyDataSetChanged();
        return;
    L20:
        return;
    L18:
        return;
    L17:
        return;
    }

    private void processSelectOnItemClicked(long r3, int r5) {
        if (ContactsContract.isProfileId(r3) == false) goto L5;
        return;
    L5:
        HeadersListView r0 = this.mContactListView;
        OCheckBox r6 = (OCheckBox) r0.getChildAt(r5 - r0.getFirstVisiblePosition()).findViewById(R.id.checkBox);
        if (r6 != null) goto L9;
        return;
    L9:
        if (this.mSelectedSet.contains(Long.valueOf(r3)) == false) goto L11;
        this.mSelectedSet.remove(Long.valueOf(r3));
        r6.setChecked(false);
        return;
    L11:
        this.mSelectedSet.add(Long.valueOf(r3));
        r6.setChecked(true);
    }

    private void hideSoftKeyboard() {
        InputMethodManager r0 = (InputMethodManager) this.mActivity.getSystemService("input_method");
        if (this.mInContacts == false) goto L5;
        r0.hideSoftInputFromWindow(this.mContactListView.getWindowToken(), 0);
        return;
    L5:
        QuickContactListView r3 = this.mSearchResultList;
        if (r3 == null) goto L10;
        r0.hideSoftInputFromWindow(r3.getWindowToken(), 0);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        int r3 = r2.getId();
        if (r3 != R.id.btn_import_contacts_in_footer) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "import contacts btn clicked");
        if (ContactsUtils.isJustClicked() == true) goto L16;
        showImportContactsInEmptyDialog();
        return;
    L16:
        return;
    L8:
        if (r3 != R.id.cover) goto L17;
        this.mCoverDismiss = true;
        this.mHandler.removeCallbacks(this.mTimeoutThread);
        this.mHandler.removeCallbacks(this.mShowResultThread);
        AnimationUtil.hideResultDialogWithAnim(this.mSearchResultDialog);
        AnimationUtil.hideResultDialogWithAnim(this.mEmptyResultDialog);
        AnimationUtil.hideCoverWithAnimation(this.mCover);
        return;
    }

    private void onDeleteGroupClicked() {
        this.mGroupBrowseListFragment.deleteCheckedGroups();
    }

    private void onCancelEditGroupClicked() {
        this.mGroupBrowseListFragment.setGroupEdit(false);
        setGroupEditState(false);
        showVoiceSearchBtn();
        SelectAllState r0 = this.mGroupSelectAllBtn;
        if (r0 == null) goto L5;
        r0.setSelectAll(false);
    L5:
        BottomDeleteLayoutListener r2 = this.mBottomDeleteLayoutListener;
        if (r2 == null) goto L9;
        r2.setBottomBtnEnable(false);
        return;
    }

    private void onAddGroupClicked() {
        if (ContactsUtils.isJustClicked() == true) goto L6;
        this.mGroupBrowseListFragment.createNewGroupWithAccountDisambiguation();
        return;
    }

    private void onEditGroupClicked() {
        setGroupEditState(true);
        this.mGroupBrowseListFragment.setGroupEdit(true);
    }

    private void onCancelEditContactClicked() {
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L5;
        r0.hideLetterGrid();
    L5:
        this.contactTitleBarCenterView.setVisibility(0);
        this.mOContactTitleBar.getMTitleView().setVisibility(8);
        processEditContacts(false, true);
    }

    private void onDeleteContactClicked() {
        if (ContactsUtils.isJustClicked() == true) goto L6;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_DELETE_CONTACTS);
        showDeleteContactsDialog();
        return;
    }

    private void onEditContactClicked() {
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L6;
        r0.hideLetterGrid();
    L6:
        if (getPresenter().isInSearchMode() == false) goto L8;
        return;
    L8:
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_EDIT_ALL_CONTACTS);
        processEditContacts(true, true);
    }

    private void onSettingsTitleClick() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        startActivity(new Intent(getActivity(), ContactsSettingActivity.class));
    }

    private void onAddNewContactClicked() {
        if (ContactsUtils.isJustClicked() == true) goto L6;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_NEW_CONTACT);
        this.mIsClickBtnAddContact = true;
        ContactsUtils.setCpuBoost(1000);
        startCreateNewContactActivity();
        return;
    }

    private void processEditContacts(boolean r3, boolean r4) {
        ContactsListSortByNameAdapter r0 = this.mNorAdapter;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        processEditContacts(r3, r4, false, r1);
        return;
    L5:
        if (r0.getCount() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private void processEditContacts(boolean r11, boolean r12, boolean r13, boolean r14) {
        this.mIsEdit = r11;
        getPresenter().setSearchEnable(!this.mIsEdit);
        ListView r5 = getTargetListView();
        if (r5 != null) goto L6;
        return;
    L6:
        if ((r5 instanceof HorizontalScrollListView) == false) goto L12;
        HorizontalScrollListView r0 = (HorizontalScrollListView) r5;
        if (r11 == false) goto L10;
        r0.restoreScrollState(false);
    L10:
        r0.setScrollEnabled(!r11);
    L17:
        long[] r7 = new long[this.mSelectedSet.size()];
        Iterator<Long> r1 = this.mSelectedSet.iterator();
        int r3 = 0;
    L19:
        if (r1.hasNext() == false) goto L21;
        r7[r3] = r1.next().longValue();
        r3 = r3 + 1;
        goto L19
    L21:
        if (r12 == false) goto L23;
        performAnimationForEdit(r11, r5, r13, r7, r14);
    L24:
        if (r11 == false) goto L26;
        setButtonVisibility(2);
        refreshOptionBar(0);
        this.mSearchOptionBar.setVisibility(8);
        this.mBottomDeleteLayoutListener.setLayoutVisible(true);
    L27:
        getPresenter().freezeSearchView(r11);
        return;
    L26:
        setButtonVisibility(1);
        this.mSelectedSet.clear();
        this.mSearchOptionBar.setVisibility(0);
        this.mBottomDeleteLayoutListener.setLayoutVisible(false);
        goto L27
    L23:
        notPerformAnimationForEdit(r11, r5);
        goto L24
    L12:
        if ((r5 instanceof HorizontalScrollExpandableListView) == false) goto L17;
        HorizontalScrollExpandableListView r2 = (HorizontalScrollExpandableListView) r5;
        if (r11 == false) goto L16;
        r2.restoreScrollState(false);
    L16:
        r2.setScrollEnabled(!r11);
        goto L17
    }

    private ListView getTargetListView() {
        int r0 = this.mSortMode;
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L23;
        if (r0 == 4) goto L25;
        if (r0 == 8) goto L25;
        if (r0 == 16) goto L23;
        if (r0 == 32) goto L25;
        if (r0 == 64) goto L25;
        if (r0 == 128) goto L25;
        if (r0 == 256) goto L25;
        return null;
    L23:
        return this.mCityListView;
    L25:
        return this.mContactListView;
    }

    private void notPerformAnimationForEdit(boolean r2, ListView r3) {
        if (r2 == false) goto L4;
        this.mBottomDeleteLayoutListener.setLayoutVisible(true);
    L5:
        refreshAdapter(r2);
        return;
    L4:
        this.mBottomDeleteLayoutListener.setLayoutVisible(false);
        goto L5
    }

    private void performAnimationForEdit(boolean r4, ListView r5, boolean r6, long[] r7, boolean r8) {
        refreshAdapter(r4);
        RelativeLayout r0 = this.mContactBody;
        if (r0 == null) goto L9;
        ViewGroup r1 = this.mSearchOptionBar;
        if (r1 == null) goto L9;
        if (r4 == false) goto L8;
        this.mContactsListAnimator.startEdit(r0, r5, r1);
        goto L9
    L8:
        this.mContactsListAnimator.finishEdit(r0, r5, r1);
    L9:
        onAnimationEnd(r4, r5, r6, r7, r8);
    }

    private void onAnimationEnd(boolean r3, ListView r4, boolean r5, long[] r6, boolean r7) {
        if (this.mOSearchTitlebarView == null) goto L5;
        getPresenter().setLayerType(0, null);
    L5:
        BottomDeleteLayoutListener r8 = this.mBottomDeleteLayoutListener;
        if (r8 == null) goto L8;
        r8.startTransition(r3);
        this.mBottomDeleteLayoutListener.setLayoutVisible(r3);
    L8:
        if (r5 == false) goto L11;
        new DeleteContactsTask(this, this.mContext, r7).execute(new long[][]{r6});
        return;
    }

    private void refreshAdapter(boolean r3) {
        int r0 = this.mSortMode;
        if (r0 != 1) goto L5;
        ContactsListSortByNameAdapter r1 = this.mNorAdapter;
        if (r1 == null) goto L52;
        r1.setEdit(r3);
        this.mNorAdapter.notifyDataSetChanged();
    L52:
        this.mContactListView.setSlideEnable(r3);
        return;
    L5:
        if (r0 != 2) goto L7;
        ExpandAdapterForLocation r2 = this.mCityAdapter;
        if (r2 == null) goto L48;
        r2.setEdit(r3);
        this.mCityAdapter.notifyDataSetChanged();
    L48:
        this.mCityListView.setSlideEnable(r3);
        return;
    L7:
        if (r0 != 4) goto L9;
        ContactsListSortByTimesAdapter r4 = this.mTimesAdapter;
        if (r4 == null) goto L44;
        r4.setEdit(r3);
        this.mTimesAdapter.notifyDataSetChanged();
    L44:
        this.mContactListView.setSlideEnable(r3);
        return;
    L9:
        if (r0 != 8) goto L11;
        ContactsListSortByAddedTimeAdapter r5 = this.mAddedTimesAdapter;
        if (r5 == null) goto L40;
        r5.setEdit(r3);
        this.mAddedTimesAdapter.notifyDataSetChanged();
    L40:
        this.mContactListView.setSlideEnable(r3);
        return;
    L11:
        if (r0 != 16) goto L13;
        ExpandAdapterForCompany r6 = this.mCompanyAdapter;
        if (r6 == null) goto L36;
        r6.setEdit(r3);
        this.mCompanyAdapter.notifyDataSetChanged();
    L36:
        this.mCityListView.setSlideEnable(r3);
        return;
    L13:
        if (r0 != 32) goto L15;
    L29:
        ContactsListSortBySimAdapter r7 = this.mSimAdapter;
        if (r7 == null) goto L32;
        r7.setEdit(r3);
        this.mSimAdapter.notifyDataSetChanged();
    L32:
        this.mContactListView.setSlideEnable(r3);
        return;
    L15:
        if (r0 == 64) goto L29;
        if (r0 != 128) goto L19;
        ContactsListSortByBCRAdapter r8 = this.mBCRAdapter;
        if (r8 == null) goto L28;
        r8.setEdit(r3);
        this.mBCRAdapter.notifyDataSetChanged();
    L28:
        this.mContactListView.setSlideEnable(r3);
        return;
    L19:
        if (r0 != 256) goto L61;
        ContactsListSortByNameAdapter r9 = this.mPhoneContactsAdapter;
        if (r9 == null) goto L24;
        r9.setEdit(r3);
        this.mPhoneContactsAdapter.notifyDataSetChanged();
    L24:
        this.mContactListView.setSlideEnable(r3);
        return;
    }

    private boolean isEmpty() {
        int r0 = this.mSortMode;
        if (r0 != 1) goto L5;
        ArrayList<SamContact> r1 = this.mOldContacts;
        if (r1 == null) goto L76;
        if (r1.size() == 0) goto L76;
        if (ContactsUtils.isOnlyIncludeProfile(this.mOldContacts) == true) goto L76;
        return false;
    L76:
        return true;
    L5:
        if (r0 != 2) goto L7;
        ArrayList<SamContact> r4 = this.mOldContactCityItems;
        if (r4 == null) goto L68;
        if (r4.size() == 0) goto L68;
        return false;
    L68:
        return true;
    L7:
        if (r0 != 4) goto L9;
        ArrayList<SamContact> r5 = this.mOldContactTimesItems;
        if (r5 == null) goto L62;
        if (r5.size() == 0) goto L62;
        return false;
    L62:
        return true;
    L9:
        if (r0 != 8) goto L11;
        ArrayList<SamContact> r6 = this.mOldContactAddedTimeItems;
        if (r6 == null) goto L56;
        if (r6.size() == 0) goto L56;
        return false;
    L56:
        return true;
    L11:
        if (r0 != 16) goto L13;
        ArrayList<SamContact> r7 = this.mOldContactsCompanyItems;
        if (r7 == null) goto L50;
        if (r7.size() == 0) goto L50;
        return false;
    L50:
        return true;
    L13:
        if (r0 != 32) goto L15;
        ArrayList<SamContact> r8 = this.mOldContactsSim1Items;
        if (r8 == null) goto L44;
        if (r8.size() == 0) goto L44;
        return false;
    L44:
        return true;
    L15:
        if (r0 != 64) goto L17;
        ArrayList<SamContact> r9 = this.mOldContactsSim2Items;
        if (r9 == null) goto L38;
        if (r9.size() == 0) goto L38;
        return false;
    L38:
        return true;
    L17:
        if (r0 != 128) goto L19;
        ArrayList<SamContact> r10 = this.mOldContactsBCRItems;
        if (r10 == null) goto L32;
        if (r10.size() == 0) goto L32;
        return false;
    L32:
        return true;
    L19:
        if (r0 == 256) goto L21;
        return false;
    L21:
        ArrayList<SamContact> r11 = this.mOldContactsPhoneItems;
        if (r11 == null) goto L26;
        if (r11.size() == 0) goto L26;
        return false;
    L26:
        return true;
    }

    private void refreshOptionBar(int r8) {
        int r0 = this.mSortMode;
        boolean r2 = true;
        if (r0 != 1) goto L5;
    L25:
        int r1 = this.mContactsIdList.size();
    L26:
        String r4 = getResources().getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r8)});
        if (this.mIsEdit == false) goto L32;
        if (this.contactTitleBarCenterView == null) goto L32;
        this.mOContactTitleBar.setTitleText(r4);
        this.contactTitleBarCenterView.setVisibility(8);
    L32:
        if (this.mIsEdit == false) goto L40;
        SelectAllState r3 = this.mContactSelectAllBtn;
        if (r3 == null) goto L40;
        if (r8 != r1) goto L37;
        boolean r5 = true;
    L38:
        r3.setSelectAll(r5);
        goto L40
    L37:
        r5 = false;
    L40:
        if (this.mIsEdit == false) goto L48;
        BottomDeleteLayoutListener r7 = this.mBottomDeleteLayoutListener;
        if (r7 == null) goto L49;
        if (r8 != 0) goto L46;
        r2 = false;
    L46:
        r7.setBottomBtnEnable(r2);
        return;
    L49:
        return;
    L48:
        return;
    L5:
        if (r0 != 2) goto L7;
        r1 = this.mContactsIdForLocation.size();
        goto L26
    L7:
        if (r0 == 4) goto L25;
        if (r0 == 8) goto L25;
        if (r0 == 16) goto L25;
        if (r0 != 32) goto L14;
        r1 = this.mContactsIdSIM1.size();
        goto L26
    L14:
        if (r0 != 64) goto L16;
        r1 = this.mContactsIdSIM2.size();
        goto L26
    L16:
        if (r0 != 128) goto L18;
        r1 = this.mContactsIdBCR.size();
        goto L26
    L18:
        if (r0 == 256) goto L20;
        r1 = 0;
        goto L26
    L20:
        r1 = this.mPhoneContactsIdList.size();
        goto L26
    }

    private void showDeleteContactsDialog() {
        final int r0 = BDSettingsEvent.EVENT_TYPE_CONTACT_DELETE.getType();
        String r4 = getString(R.string.sheet_title_remove_number);
        OActionSheet r1 = OSheetUtils.getActionSheet(getContext(), OInsetSheet.PanelWidth.NARROW_WIDTH, r4, null, getString(R.string.btn_confirm_delete), OSheetUtils.ContentViewStyle.RED, new AnonymousClass45(this, r0), new AnonymousClass46(this, r0));
        this.mDeleteSheet = r1;
        r1.show();
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(getContext(), r0, true, false);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ContactsDeleteDialog show");
        this.mDeleteSheet.setOnCancelListener(new AnonymousClass47(this, r0));
        this.mDeleteSheet.getWindow().addFlags(1024);
    }

    private View getDeleteContactsContentView() {
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(1);
        r0.setPadding(0, ContactsUtils.dipTopx(getContext(), 5.0d), 0, ContactsUtils.dipTopx(getContext(), 15.0d));
        OButton r1 = (OButton) LayoutInflater.from(getContext()).inflate(R.layout.sheet_button_center_red, null);
        r1.setText(R.string.btn_confirm_delete);
        r1.setOnClickListener(new AnonymousClass48(this));
        r1.setWidth(ContactsUtils.dipTopx(getContext(), 296.0d));
        r1.setHeight(ContactsUtils.dipTopx(getContext(), 56.0d));
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        r4.gravity = 17;
        r4.bottomMargin = ContactsUtils.dipTopx(getContext(), 5.0d);
        r0.addView(r1, r4);
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(getContext(), 15.0d));
        return r0;
    }

    private View getDeleteContactsHeaderView() {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(getContext());
        r0.setShowLeftBack(false);
        r0.setTitleText(getResources().getString(R.string.sheet_title_remove_number));
        OButton r1 = r0.createNeutralButton(getContext(), r0.mRightContainer);
        r1.setContentDescription("关闭");
        r1.setButtonSourceBitmap(R.drawable.o_ic_close);
        r1.setOnClickListener(new AnonymousClass49(this));
        return r0;
    }

    private void doRemoveAction() {
        if (this.mSelectedSet.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = this.mSortMode;
        if (r0 != 2) goto L8;
    L65:
        doRemoveActionForExpandable();
        return;
    L8:
        if (r0 == 16) goto L65;
        boolean r1 = true;
        if (r0 != 1) goto L13;
        ArrayList r2 = (ArrayList) this.mOldContacts.clone();
        ContactsListBaseAdapter r3 = this.mNorAdapter;
    L33:
        final ContactsListBaseAdapter r7 = r3;
        HashSet<String> r4 = new HashSet();
        ArrayList<Integer> r9 = new ArrayList();
        ArrayList<Integer> r10 = new ArrayList();
        Iterator r5 = r2.iterator();
        int r6 = 0;
    L35:
        if (r5.hasNext() == false) goto L45;
        SamContact r8 = (SamContact) r5.next();
        if (this.mSelectedSet.contains(Long.valueOf(r8.contactId)) == false) goto L42;
        r9.add(Integer.valueOf(r6));
        if (r4.contains(r8.section) == true) goto L41;
        r4.add(r8.section);
    L41:
        r5.remove();
    L43:
        r6 = r6 + 1;
        goto L35
    L42:
        r10.add(Integer.valueOf(r6));
        goto L43
    L45:
        if (this.mSortMode != 1) goto L54;
        Iterator r11 = r2.iterator();
    L48:
        if (r11.hasNext() == false) goto L52;
        if (((SamContact) r11.next()).getType() != 0) goto L48;
        r1 = false;
    L52:
        if (r1 == false) goto L54;
        r2.clear();
    L54:
        HashSet r12 = new HashSet();
        Iterator<String> r13 = r4.iterator();
    L56:
        if (r13.hasNext() == false) goto L63;
        String r14 = r13.next();
        Iterator r15 = r2.iterator();
    L59:
        if (r15.hasNext() == false) goto L56;
        if (TextUtils.equals(((SamContact) r15.next()).section, r14) == false) goto L59;
        r12.add(r14);
        goto L59
    L63:
        r4.removeAll(r12);
        this.mContactListView.setDeletedHeaderSections(r4);
        final HeadersListView r16 = this.mContactListView;
        final boolean r17 = true;
        final ArrayList r18 = r2;
        new AnonymousClass50(this, r16, r17, r7, r18).setResultListSize(r2.size()).setDeletedHeaderSection(r4).start(r9, r10);
        return;
    L13:
        if (r0 != 4) goto L15;
        r2 = (ArrayList) this.mOldContactTimesItems.clone();
        r3 = this.mTimesAdapter;
        goto L33
    L15:
        if (r0 != 8) goto L17;
        r2 = (ArrayList) this.mOldContactAddedTimeItems.clone();
        r3 = this.mAddedTimesAdapter;
        goto L33
    L17:
        if (r0 != 32) goto L19;
        r2 = (ArrayList) this.mOldContactsSim1Items.clone();
        r3 = this.mSimAdapter;
        goto L33
    L19:
        if (r0 != 64) goto L21;
        r2 = (ArrayList) this.mOldContactsSim2Items.clone();
        r3 = this.mSimAdapter;
        goto L33
    L21:
        if (r0 != 128) goto L23;
        r2 = (ArrayList) this.mOldContactsBCRItems.clone();
        r3 = this.mBCRAdapter;
        goto L33
    L23:
        if (r0 != 256) goto L26;
        r2 = (ArrayList) this.mOldContactsPhoneItems.clone();
        r3 = this.mPhoneContactsAdapter;
        goto L33
    L26:
        throw new IllegalArgumentException("sort mode is illegal!");
    }

    private void doRemoveActionForExpandable() {
        if (2 != this.mSortMode) goto L5;
        ArrayList<SamContact> r0 = (ArrayList) this.mOldContactCityItems.clone();
        ExpandAdapter r2 = this.mCityAdapter;
    L6:
        final ExpandAdapter r6 = r2;
        ArrayList<Integer> r8 = new ArrayList();
        ArrayList<Integer> r9 = new ArrayList();
        int r3 = r6.getGroupCount();
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r4 >= r3) goto L25;
        if (isGroupAllSelected(r4, r6) == false) goto L11;
        r8.add(Integer.valueOf(r5));
    L12:
        r5 = r5 + 1;
        if (this.mCityListView.isGroupExpanded(r4) == false) goto L24;
        int r7 = r6.getChildrenCount(r4);
        int r10 = 0;
    L16:
        if (r10 >= r7) goto L24;
        SamContact r11 = r6.getChild(r4, r10);
        if (r11 != null) goto L20;
    L22:
        r9.add(Integer.valueOf(r5));
    L23:
        r5 = r5 + 1;
        r10 = r10 + 1;
        goto L16
    L20:
        if (this.mSelectedSet.contains(Long.valueOf(r11.contactId)) == false) goto L22;
        r8.add(Integer.valueOf(r5));
    L24:
        r4 = r4 + 1;
        goto L7
    L11:
        r9.add(Integer.valueOf(r5));
        goto L12
    L25:
        Iterator<SamContact> r12 = r0.iterator();
    L27:
        if (r12.hasNext() == false) goto L32;
        if (this.mSelectedSet.contains(Long.valueOf(r12.next().contactId)) == false) goto L27;
        r12.remove();
        goto L27
    L32:
        if (2 != this.mSortMode) goto L34;
        ArrayList<ArrayList<SamContact>> r1 = new ArrayList();
        initCity(r0, r1, true);
    L35:
        final ArrayList<ArrayList<SamContact>> r13 = r1;
        final QuickContactExpandableListView r14 = this.mCityListView;
        final boolean r15 = false;
        new AnonymousClass51(this, r14, r15, r6, r13).setResultListSize(r0.size()).start(r8, r9);
        return;
    L34:
        r1 = initCompanyExpandableData(r0);
        goto L35
    L5:
        r0 = (ArrayList) this.mOldContactsCompanyItems.clone();
        r2 = this.mCompanyAdapter;
        goto L6
    }

    private boolean isGroupAllSelected(int r8, ExpandAdapter r9) {
        int r0 = r9.getChildrenCount(r8);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        SamContact r3 = r9.getChild(r8, r2);
        if (r3 == null) goto L9;
        if (this.mSelectedSet.contains(Long.valueOf(r3.contactId)) == true) goto L9;
        return false;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return true;
    }

    private void setButtonVisibility(int r6) {
        if (r6 != 1) goto L5;
        this.mBtnContactRightDelete.setVisibility(8);
        this.mBtnContactMenu.setVisibility(0);
        this.mBottomDeleteLayoutListener.setLayoutVisible(false);
        this.mOContactTitleBar.mLeftContainer.removeAllViews();
        if (this.mOContactTitleBar.mLeftContainer.indexOfChild(this.mBtnContactLeft) == (-1)) goto L17;
        this.mOContactTitleBar.mLeftContainer.removeView(this.mBtnContactLeft);
    L17:
        OButton r7 = getTitleBtn(R.drawable.standard_icon_multi_select_selector, true, this.mOContactTitleBar, this.mBtnContactLeft);
        this.mBtnContactLeft = r7;
        if (r7 == null) goto L20;
        r7.setContentDescription("选择");
        this.mBtnContactLeft.setOnClickListener(new AnonymousClass52(this));
    L20:
        this.mContactSelectAllBtn = null;
        showVoiceSearchBtn();
        this.contactTitleBarCenterView.setVisibility(0);
        this.mOContactTitleBar.getMTitleView().setVisibility(8);
        return;
    L5:
        if (r6 != 2) goto L23;
        this.mBtnContactRightDelete.setVisibility(0);
        this.mBtnContactMenu.setVisibility(8);
        this.mBottomDeleteLayoutListener.setLayoutVisible(true);
        this.mOContactTitleBar.mLeftContainer.removeAllViews();
        if (this.mOContactTitleBar.mLeftContainer.indexOfChild(this.mBtnContactLeft) == (-1)) goto L10;
        this.mOContactTitleBar.mLeftContainer.removeView(this.mBtnContactLeft);
    L10:
        OButton r8 = this.mOContactTitleBar.createNeutralButton(getContext(), this.mOContactTitleBar.mLeftContainer);
        this.mBtnContactLeft = r8;
        r8.setText(R.string.select_all);
        if (this.mBtnContactLeft == null) goto L13;
        this.mContactSelectAllBtn = new SelectAllState(this.mBtnContactLeft);
        this.mBtnContactLeft.setContentDescription(getString(R.string.select_all));
        this.mBtnContactLeft.setOnClickListener(new AnonymousClass53(this));
    L13:
        hideVoiceSearchBtn();
        return;
    }

    private void setGroupEditState(boolean r6) {
        BottomDeleteLayoutListener r0 = this.mBottomDeleteLayoutListener;
        if (r0 == null) goto L6;
        r0.startTransition(r6);
    L6:
        if (r6 == false) goto L17;
        this.mBottomDeleteLayoutListener.setLayoutVisible(true);
        if (this.mOGroupTitleBar.mLeftContainer.getChildCount() < 1) goto L10;
        this.mOGroupTitleBar.mLeftContainer.removeAllViews();
    L10:
        BottomDeleteLayoutListener r7 = this.mBottomDeleteLayoutListener;
        if (r7 == null) goto L13;
        r7.setBottomBtnEnable(false);
    L13:
        OButton r8 = this.mOGroupTitleBar.createNeutralButton(getContext(), this.mOGroupTitleBar.mLeftContainer);
        this.mBtnGroupLeft = r8;
        if (r8 == null) goto L16;
        this.mGroupSelectAllBtn = new SelectAllState(this.mBtnGroupLeft);
        this.mBtnGroupLeft.setText(R.string.select_all);
        this.mBtnGroupLeft.setContentDescription(getString(R.string.select_all));
        this.mBtnGroupLeft.setOnClickListener(new AnonymousClass54(this));
    L16:
        this.mBtnGroupRightDelete.setVisibility(0);
        this.mBtnGroupMenu.setVisibility(8);
        updateBtnGroupRightDeleteStatus(true);
        this.mOGroupTitleBar.setTitleText(getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(this.mGroupBrowseListFragment.getAdapter().getCheckedGroupIds().size())}));
        this.groupTitleBarCenterView.setVisibility(8);
        return;
    L17:
        this.mBottomDeleteLayoutListener.setLayoutVisible(false);
        OButton r9 = getTitleBtn(R.drawable.standard_icon_multi_select_selector, true, this.mOGroupTitleBar, this.mBtnGroupLeft);
        this.mBtnGroupLeft = r9;
        if (r9 == null) goto L20;
        r9.setContentDescription("选择");
        this.mBtnGroupLeft.setOnClickListener(new AnonymousClass55(this));
    L20:
        this.mGroupSelectAllBtn = null;
        this.mBtnGroupRightDelete.setVisibility(8);
        this.mBtnGroupMenu.setVisibility(0);
        updateBtnGroupRightDeleteStatus(false);
        this.mOGroupTitleBar.getMTitleView().setVisibility(8);
        this.groupTitleBarCenterView.setVisibility(0);
    }

    private void updateBtnGroupRightDeleteStatus(boolean r6) {
        boolean r0 = false;
        if (r6 == false) goto L19;
        GroupBrowseListFragment r7 = this.mGroupBrowseListFragment;
        if (r7 != null) goto L7;
        return;
    L7:
        if (r7.getAdapter() == null) goto L24;
        int r8 = this.mGroupBrowseListFragment.getAdapter().getCount();
        int r1 = this.mGroupBrowseListFragment.getAdapter().getReadOnlyItemSize();
        SelectAllState r2 = this.mGroupSelectAllBtn;
        if (r2 == null) goto L15;
        TextView r3 = r2.getBtn();
        if (r8 == r1) goto L13;
        boolean r4 = true;
    L14:
        r3.setEnabled(r4);
        goto L15
    L13:
        r4 = false;
    L15:
        BottomDeleteLayoutListener r5 = this.mBottomDeleteLayoutListener;
        if (r8 == r1) goto L18;
        r0 = true;
    L18:
        r5.setBottomBtnEnable(r0);
        return;
    L24:
        return;
    L19:
        SelectAllState r9 = this.mGroupSelectAllBtn;
        if (r9 == null) goto L26;
        r9.setSelectAll(false);
        return;
    }

    private void showImportContactsInEmptyDialog() {
        ArrayList r0 = new ArrayList();
        if (ContactsUtils.isBytedanceCloudExist() == false) goto L5;
        r0.add(getString(R.string.import_from_cloud));
    L5:
        r0.add(getString(R.string.import_from_sdcard));
        if (ContactsUtils.getExternalSdcardExportDirectoryPath() == null) goto L8;
        r0.add(getString(R.string.import_from_external_sdcard));
    L8:
        r0.add(getString(R.string.import_from_sim));
        r0.add(getString(R.string.import_from_other_phone));
        final String[] r1 = (String[]) r0.toArray(new String[r0.size()]);
        this.importFlag = getString(R.string.import_from_cloud);
        ArrayList r7 = new ArrayList();
        final int r2 = 0;
    L10:
        if (r2 >= r1.length) goto L12;
        r7.add(new AnonymousClass56(this, r1, r2));
        r2 = r2 + 1;
        goto L10
    L12:
        OSheetUtils.getOSheet(this.mContext, OInsetSheet.PanelWidth.NARROW_WIDTH, getString(R.string.common_import_contacts), null, (ArrayList) Arrays.stream(r1).collect(Collectors.toCollection(new ContactListFragment$$ExternalSyntheticLambda2())), r7, OSheetUtils.ContentViewStyle.BLACK, null, null, true, true).show();
    }

    private void doImportContactsAction(String r3) {
        if (getString(R.string.import_from_cloud).equals(r3) == false) goto L6;
        AnimationUtil.startActivity(this.mContext, ContactsIntentUtils.getBytedanceCloudLoginIntent());
        return;
    L6:
        if (getString(R.string.import_from_third_part_accout).equals(r3) == false) goto L9;
        ArrayList<String> r4 = new ArrayList();
        r4.add(BytedanceAccountType.ACCOUNT_TYPE);
        startActivity(ContactEditorUtils.getInstance(this.mContext).createAddWritableAccountIntent(r4));
        return;
    L9:
        if (getString(R.string.import_from_sdcard).equals(r3) == false) goto L12;
        AccountSelectionUtil.doImport(getActivity(), R.id.btn_import_from_sdcard, null);
        return;
    L12:
        if (getString(R.string.import_from_external_sdcard).equals(r3) == false) goto L15;
        AccountSelectionUtil.doImport(getActivity(), R.id.btn_import_from_external_sdcard, null);
        return;
    L15:
        if (getString(R.string.import_from_sim).equals(r3) == false) goto L30;
        if (DSUtils.isMultiSimEnabled() == true) goto L19;
        importContactsInEmpty(R.id.btn_import_from_sim);
        return;
    L19:
        if (DSUtils.isAllSimsEnable() == false) goto L22;
        showSimSelectDialog(R.id.btn_import_from_sim);
        return;
    L22:
        if (DSUtils.isSim1Enalbe() == false) goto L25;
        this.mImportSimId = 0;
    L27:
        importContactsInEmpty(R.id.btn_import_from_sim);
        return;
    L25:
        if (DSUtils.isSim2Eanble() == false) goto L27;
        this.mImportSimId = 1;
        goto L27
    L30:
        if (getString(R.string.import_from_other_phone).equals(r3) == false) goto L40;
        Intent r5 = new Intent();
        r5.setClassName(ContactsUtils.IMPORT_OTHER_PHONE_PACKAGE_NAME, ContactsUtils.IMPORT_OTHER_PHONE_ACTIVITY_NAME);
        r5.setAction("android.intent.action.MAIN");
        r5.setFlags(MarkInfoUtil.MARK_CLASSIFY_ZTE_BLACKLIST);
        getActivity().startActivity(r5);
        AnimationUtil.switchActivityAnimation(getActivity(), 5);
        return;
    }

    private void showSimSelectDialog(final int r5) {
        AccountSelectionMenuDialog r0 = new AccountSelectionMenuDialog(this.mContext);
        r0.setTitle(this.mContext.getString(R.string.sim_select_dialog_title));
        ImportExportFragment r2 = new ImportExportFragment();
        Objects.requireNonNull(r2);
        r0.setAdapter(new ImportExportFragment.SimSelectAdapter(r2, this.mContext, this), new AnonymousClass57(this, r5));
        r0.show();
    }

    private boolean importContactsInEmpty(int r3) {
        doImportInEmpty(getActivity(), r3, null);
        return true;
    }

    private void doImportInEmpty(Context r2, int r3, AccountWithDataSet r4) {
        if (r3 == R.id.btn_import_from_sim) goto L5;
        AccountSelectionUtil.doImport(getActivity(), R.id.btn_import_from_sdcard, r4);
        return;
    L5:
        if (ContactsUtils.isNoSim(getActivity()) == false) goto L8;
        Toast.makeText(getActivity(), R.string.toast_no_sim, 0).show();
        return;
    L8:
        Intent r5 = new Intent(getActivity(), ImportSimContacts.class);
        r5.putExtra(ImportSimContacts.EXTRA_ACCOUNT, r4);
        if (DSUtils.isMultiSimEnabled() == false) goto L11;
        r5.putExtra(DSUtils.SUBSCRIPTION_KEY, this.mImportSimId);
    L11:
        startActivity(r5);
    }

    private void startCreateNewContactActivity() {
        Intent r0 = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        r0.setPackage("com.android.contacts");
        r0.putExtra("scan_barcode", true);
        startActivityAndForwardResult(r0);
    }

    public void startActivityAndForwardResult(Intent r4) {
        ActivityOptions r0 = ActivityOptions.makeCustomAnimation(getActivity(), R.anim.activity_slide_in_from_bottom, R.anim.activity_slide_do_nothing);
        r4.setFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        Bundle r1 = getActivity().getIntent().getExtras();
        if (r1 == null) goto L5;
        r4.putExtras(r1);
    L5:
        startActivity(r4, r0.toBundle());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r3, int r4) {
        if (r4 == 2) goto L17;
        if (r4 == 1) goto L17;
        this.mWaitingScrollIdle = false;
        if (this.mQuickBar.isPerformingAnim() == true) goto L9;
        this.mPhotoManager.resume();
    L9:
        this.mBlacklistManager.resume();
        int r5 = this.mSortMode;
        if (r5 != 1) goto L12;
    L15:
        ContactDetailCacheManager.getInstance().refreshCache(r3);
    L16:
        this.mHandler.removeCallbacks(this.mScrollIdle);
        this.mHandler.postDelayed(this.mScrollIdle, 150);
        return;
    L12:
        if (r5 == 8) goto L15;
        if (r5 != 4) goto L16;
    L17:
        this.mHandler.removeCallbacks(this.mScrollIdle);
        hideSoftKeyboard();
        this.mWaitingScrollIdle = true;
        this.mPhotoManager.pause();
        if (this.mIsEdit == false) goto L20;
    L22:
        this.mBlacklistManager.pause();
        return;
    L20:
        if (this.mIsSearch == true) goto L22;
        hideVoiceSearchBtn();
        goto L22
    }

    private boolean dataIsReady(int r1) {
        if ((this.mModeState & r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void setModeState(int r1, boolean r2) {
        if (r2 == false) goto L4;
        this.mModeState = r1 | this.mModeState;
        return;
    L4:
        int r3 = this.mModeState;
        this.mModeState = (~r1) & r3;
    }

    private void clearModeState() {
        this.mModeState = 0;
    }

    private void resetSearchBar() {
        if (this.mOSearchTitlebarView != null) goto L5;
        return;
    L5:
        if (isSearch() == false) goto L7;
        cancelSearch();
    L7:
        getPresenter().returnToSortByName();
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void onPopupDismissIView() {
        showVoiceSearchBtnDelayed(100);
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public boolean onModeChangeIView(int r3) {
        if (isResumed() == true) goto L6;
        return false;
    L6:
        if (checkPermission(r3) == true) goto L8;
        return false;
    L8:
        onModeChanged(r3);
        return true;
    }

    private void onModeChanged(int r4) {
        if (r4 == 2) goto L7;
        if (r4 == 16) goto L7;
    L12:
        int r2 = this.mSortMode;
        if (r2 != 2) goto L16;
        if (r2 == r4) goto L16;
        this.mResetContactListView = true;
    L16:
        this.mContactListView.restoreScrollState(false);
        this.mSortMode = r4;
        triggerLoad(r4, false);
        showVoiceSearchBtnDelayed(100);
        return;
    L7:
        if (this.mSortMode == r4) goto L12;
        if (this.mCityListViewFrame != null) goto L11;
        initCityListView();
    L11:
        this.mCollapseAllGroup = true;
        goto L12
    }

    private boolean checkPermission(int r4) {
        if (r4 == 4) goto L5;
        return true;
    L5:
        return PermissionUtils.checkPermission(this, 11, (String[]) PrivacyConstantsKt.PERMS_FOR_SMS.toArray(new String[0]), getString(R.string.permission_guide_sms_msg), null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int r1, String[] r2, int[] r3) {
        if (r1 != 11) goto L8;
        PermissionUtils.setPermsUserSet(getContext(), r1);
        if (PermissionUtils.granted(r3) == false) goto L9;
        this.mPresenter.setSortMode(4);
        onModeChanged(4);
        return;
    L9:
        return;
    }

    private void initCityListView() {
        ViewStub r0 = (ViewStub) this.mContactsFragment.findViewById(R.id.contact_stub_city_list);
        if (r0 == null) goto L6;
        View r1 = r0.inflate();
        this.mCityListViewFrame = (FrameLayout) r1.findViewById(R.id.city_list_frame);
        QuickContactExpandableListView r2 = (QuickContactExpandableListView) r1.findViewById(R.id.city_list);
        this.mCityListView = r2;
        r2.setOnScrollListener(this);
        this.mCityListView.setOnGroupExpandListener(this.mGroupExpandListener);
        this.mCityListView.setOnGroupCollapseListener(this.mGroupCollapseListener);
        this.mCityListView.setItemLongClickedListener(this.mExpandableListItemLongClickedListener);
        this.mCityListView.setOnChildClickListener(this);
        this.mCityListView.setSlideListener(this.mSlideListenerForExpandable);
        this.mCityListView.setTouchMonitorListener(this.mTouchMonitorListenerForExpandable);
        return;
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void setSoftKeyboardHideIView() {
        hideSoftKeyboard();
    }

    private void initAnimation() {
        AnimationSet r1 = new AnimationSet(true);
        TranslateAnimation r12 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, 0.0f, 0, 0.0f);
        AnimationSet r3 = new AnimationSet(true);
        TranslateAnimation r4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, 0.0f, 0, 0.0f);
        AnimationSet r5 = new AnimationSet(true);
        TranslateAnimation r6 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, 0.0f, 0, 0.0f);
        AlphaAnimation r7 = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet r10 = new AnimationSet(true);
        TranslateAnimation r11 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, 0.0f, 0, 0.0f);
        AlphaAnimation r13 = new AlphaAnimation(1.0f, 0.0f);
        r1.addAnimation(r12);
        r1.setDuration(this.mDuration);
        r1.setFillAfter(true);
        r3.addAnimation(r4);
        r3.setDuration(this.mDuration);
        r5.addAnimation(r6);
        r5.addAnimation(r7);
        r5.setDuration(this.mDuration);
        r10.addAnimation(r11);
        r10.addAnimation(r13);
        r10.setDuration(this.mDuration);
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void onSearchAnimationStartIView() {
        this.mFragmentsCallback.coverVeil();
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void startContactAnimationIView() {
        hideVoiceSearchBtn();
        if (this.mSearchResultView != null) goto L5;
        initSearchViews();
        this.mSearchResultView.setAlpha(0.0f);
    L5:
        ContactsUtils.setAnimatorScale(this.mActivity);
        this.mSearchResultView.setVisibility(0);
        enterSearch();
    }

    private SearchSwitchAnimHelper getSearchAnimHelper() {
        if (this.mSearchSwitchANimHelper != null) goto L6;
        this.mOSearchRightButton.measure(0, 0);
        int r0 = this.mOSearchRightButton.getMeasuredWidth();
        int r2 = this.mOSearchbar.getWidth();
        SearchSwitchAnimHelper r3 = new SearchSwitchAnimHelper();
        OSearchBar r4 = this.mOSearchbar;
        this.mSearchSwitchANimHelper = r3.setSearchBox(r4, r2, r2 - r0, -this.mOContactTitleBar.getHeight()).setCancelButton(this.mOSearchRightButton, true).setSearchPageContainer(this.mContactBody).setSearchResultContainer(this.mSearchResultView).addSearchBoxParentContent(this.mOContactTitleBar, false).addSearchBoxParentContent(this.mContactListView, false);
    L6:
        return this.mSearchSwitchANimHelper;
    }

    private void enterSearch() {
        this.mIsSearch = true;
        this.mIsSearchAnimationing = true;
        this.mContactListView.invalidate();
        getSearchAnimHelper().playEnterAnim(new ContactListFragment$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$enterSearch$0$com-android-contacts-list-ContactListFragment, reason: not valid java name */
    /* synthetic */ Unit m196x8e7465ba(Boolean r2) {
        this.mIsSearchAnimationing = false;
        this.mFragmentsCallback.liftVeil();
        if (r2.booleanValue() == false) goto L6;
        this.mOContactTitleBar.setVisibility(4);
    L6:
        return Unit.INSTANCE;
    }

    private void exitSearch() {
        this.mIsSearch = false;
        this.mOContactTitleBar.setVisibility(0);
        getSearchAnimHelper().playExitAnim(new ContactListFragment$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$exitSearch$1$com-android-contacts-list-ContactListFragment, reason: not valid java name */
    /* synthetic */ Unit m197x4ad88c1b(Boolean r1) {
        searchAnimationEnd();
        SearchUtils.reportSearchEventAndClear();
        return Unit.INSTANCE;
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void cancelSearchWithoutAnimation() {
        this.mOSearchbar.refreshDrawableState();
        ContactsUtils.setAnimatorScale(this.mActivity);
        stopSearch();
        this.mSearchKey = null;
        this.mContactsFrameView.setY(0.0f);
        this.mIsSearch = false;
        this.mOContactTitleBar.setVisibility(0);
        searchAnimationEnd();
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void endContactAnimationIView() {
        this.mOSearchbar.refreshDrawableState();
        ContactsUtils.setAnimatorScale(this.mActivity);
        stopSearch();
        this.mSearchKey = null;
        exitSearch();
    }

    private void searchAnimationEnd() {
        getPresenter().setCursorVisible(false);
        if (this.mSearchResultView == null) goto L5;
        this.mSearchResultList.setEmptyView(null);
        this.mSearchResultView.setVisibility(4);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultList.setVisibility(8);
    L5:
        showVoiceSearchBtn();
        this.mFragmentsCallback.liftVeil();
    }

    private void stopSearch() {
        SearchThread r0 = this.mProviderSearchThread;
        if (r0 == null) goto L5;
        r0.setTrue(false);
        this.mProviderSearchThread = null;
    L5:
        SearchThread r1 = this.mInAppSearchThread;
        if (r1 == null) goto L8;
        r1.setTrue(false);
        this.mInAppSearchThread = null;
    L8:
        this.curContactsMap.clear();
        this.mInAppSearchResultList.clear();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "search_message: stopSearch call mProviderSearchThread  " + this.mProviderSearchThread + " mInAppSearchResultList size = " + this.mInAppSearchResultList.size());
    }

    private ArrayList<SamContact> getSearchMergeList(Map<Long, SamContact> r5) {
        ArrayList<SamContact> r0 = new ArrayList();
        if (r5 == null) goto L5;
        this.curContactsMap.putAll(r5);
    L5:
        Iterator<Long> r6 = this.curContactsMap.keySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        long r1 = r6.next().longValue();
        r0.add(this.curContactsMap.get(Long.valueOf(r1)));
        goto L7
    L9:
        r0.sort(new NameSortComparator());
        return r0;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.OnDBDataChangeListener
    public void onDBDataChanged() {
        clearRecommendCache();
        requerySearchOrRecommendIfNeed();
    }

    @Override // com.android.contacts.recommend.RecommendDataLoader.OnRecommendDataLoadListener
    public void onRecommendDataLoaded(List<BaseFlowAdapter.FlowEntry> r3) {
        this.mCachedRecommendData = r3;
        this.mHandler.removeMessages(1009);
        Message.obtain(this.mHandler, 1009, r3).sendToTarget();
    }

    private void requerySearchOrRecommendIfNeed() {
        if (TextUtils.isEmpty(this.mSearchKey) == true) goto L5;
        onQueryTextChangeIView(this.mSearchKey);
        return;
    L5:
        List<BaseFlowAdapter.FlowEntry> r0 = this.mCachedRecommendData;
        if (r0 == null) goto L8;
        onRecommendDataLoaded(r0);
        return;
    L8:
        this.mRecommendDataLoader.loadRecommendData(false);
        OPageStatus r2 = this.mRecommendEmptyView;
        if (r2 == null) goto L14;
        r2.setVisibility(8);
        return;
    }

    private void initSearchViews() {
        ViewStub r0 = (ViewStub) this.mContactsFragment.findViewById(R.id.contact_stub_search);
        if (r0 == null) goto L6;
        View r1 = r0.inflate();
        this.mSearchResultView = (RelativeLayout) r1.findViewById(R.id.seachresultview);
        QuickContactListView r2 = (QuickContactListView) r1.findViewById(R.id.search_listview);
        this.mSearchResultList = r2;
        r2.setOnScrollListener(this);
        this.mSearchResultList.setOnItemClickListener(this);
        SearchResultAdapter r3 = new SearchResultAdapter(getActivity(), null, null, null);
        this.mSearchResultAdapter = r3;
        r3.setQuickContactListener(this.mSearchResultList);
        this.mSearchResultList.setAdapter(this.mSearchResultAdapter);
        this.mSearchResultList.setItemLongClickedListener(this.mItemLongClickedListener);
        ForceTouchController r4 = new ForceTouchController(this.mSearchResultList, getActivity());
        this.mSearchController = r4;
        this.mSearchResultList.setOnTouchListener(r4);
        TextView r5 = (TextView) r1.findViewById(R.id.search_empty_view);
        this.mSearchEmptyView = r5;
        r5.setOnClickListener(new AnonymousClass59(this));
        OPageStatus r6 = (OPageStatus) r1.findViewById(R.id.contacts_list_empty_view);
        this.mRecommendEmptyView = r6;
        r6.setTitle(getString(R.string.recommend_contact_empty));
        this.mRecommendEmptyView.setMessage(getString(R.string.recommend_contact_empty_secondary));
        return;
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void onQueryTextChangeIView(String r9) {
        this.mSearchKey = r9;
        stopSearch();
        if (TextUtils.isEmpty(r9) == false) goto L17;
        InAppSearchClient.INSTANCE.stop();
        if (isResumed() == false) goto L7;
        requerySearchOrRecommendIfNeed();
    L13:
        SearchResultAdapter r8 = this.mSearchResultAdapter;
        if (r8 == null) goto L25;
        r8.setList(null, null);
        return;
    L25:
        return;
    L7:
        FlowAdapter r10 = this.mFlowAdapter;
        if (r10 == null) goto L10;
        r10.setData(null);
    L10:
        QuickContactListView r11 = this.mSearchResultList;
        if (r11 == null) goto L13;
        r11.setVisibility(8);
        this.mSearchEmptyView.setVisibility(8);
        goto L13
    L17:
        if (this.mProviderSearchThread != null) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "search_message: onQueryTextChangeIView intentsSearch = " + this.mIntentsSearch + " call size = " + this.mInAppSearchResultList.size() + " searchKey = " + this.mSearchKey + " ,sortMode = " + this.mSortMode);
        this.mInAppSearchResultList = new ArrayList(this.mIntentsSearchResultList);
        this.mSearchKeyList.clear();
        this.mSearchKeyList = SearchUtils.getSearchKeyMap(this.mInAppSearchResultList);
        SearchThread r12 = new SearchThread(this, Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(this.mSearchKey)), this.mSearchKey, this.mSortMode, this.mInAppSearchResultList, false);
        this.mProviderSearchThread = r12;
        r12.start();
    L20:
        if (this.mIntentsSearch == false) goto L22;
        return;
    L22:
        if (this.mInAppSearchThread != null) goto L28;
        SearchThread r13 = new SearchThread(this, Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(this.mSearchKey)), this.mSearchKey, this.mSortMode, new ArrayList(), true);
        this.mInAppSearchThread = r13;
        r13.start();
        return;
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void hideQuickContactViewIView() {
        hideQuickContact();
        hideVoiceSearchBtn();
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void recoverQuickBarIView() {
        this.mQuickBar.hideLetterGrid();
    }

    private void triggerLoad(int r2, boolean r3) {
        triggerLoad(r2, r3, false);
    }

    private void triggerLoad(final int r3, final boolean r4, boolean r5) {
        if (getActivity() != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getActivity is null, it's maybe relaunch.");
        return;
    L7:
        if (this.mProviderIsNormal == true) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Provider status is not normal");
        return;
    L10:
        this.mCityChanged = r5;
        Thread r6 = new Thread(new AnonymousClass60(this, r3, r4), "contactInitLoad");
        this.mPool.submit(r6);
    }

    private void refreshBcrCount() {
        new Thread(new AnonymousClass61(this)).start();
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ViewPagerVisibilityListener
    public void onVisibilityChanged(boolean r5) {
        if (this.mVisible == r5) goto L61;
        boolean r0 = true;
        if (r5 == false) goto L7;
        setObserverToWork(true);
        if (this.mOSearchTitlebarView == null) goto L44;
        getPresenter().requestSeachViewFocus();
    L44:
        boolean r1 = ContactsUtils.isVoiceSearchEnabled();
        if (r1 == false) goto L49;
        RelativeLayout r3 = this.voiceSearchContainer;
        if (r3 == null) goto L49;
        r3.setVisibility(0);
        showVoiceSearchBtn();
    L54:
        if (this.mBlacklistHasChanged == false) goto L61;
        if (this.mContactsContent == null) goto L61;
        BlacklistManager r2 = this.mBlacklistManager;
        if (r2 == null) goto L60;
        r2.clearCache();
    L60:
        this.mContactsContent.onChange(false);
        this.mBlacklistHasChanged = false;
    L49:
        if (r1 == true) goto L54;
        RelativeLayout r4 = this.voiceSearchContainer;
        if (r4 == null) goto L54;
        r4.setVisibility(8);
        goto L54
    L7:
        if (this.mIsEdit == false) goto L15;
        BottomDeleteLayoutListener r6 = this.mBottomDeleteLayoutListener;
        if (r6 != null) goto L11;
    L13:
        r0 = false;
    L14:
        processEditContacts(false, r0);
        goto L15
    L11:
        if (r6.isBottomBarVisible() == false) goto L13;
    L15:
        setObserverToWork(false);
        HeadersListView r7 = this.mContactListView;
        if (r7 != null) goto L18;
    L20:
        QuickContactExpandableListView r8 = this.mCityListView;
        if (r8 != null) goto L23;
    L25:
        OIndexScrollbar r9 = this.mQuickBar;
        if (r9 == null) goto L28;
        r9.hideLetterGrid();
    L28:
        resetSearchBar();
        recoveryFromGroupEdit();
        ViewGroup r10 = this.mSearchResultDialog;
        if (r10 == null) goto L31;
        r10.setVisibility(8);
    L31:
        ViewGroup r11 = this.mEmptyResultDialog;
        if (r11 == null) goto L34;
        r11.setVisibility(8);
    L34:
        View r12 = this.mCover;
        if (r12 == null) goto L37;
        r12.setVisibility(8);
    L37:
        ImageButton r13 = this.mBtnVoiceSearchContacts;
        if (r13 == null) goto L40;
        r13.setVisibility(8);
    L40:
        dismissLongMenu();
        goto L61
    L23:
        if (r8.isShowQuickContact() == false) goto L25;
        this.mCityListView.hideQuickContact();
        goto L25
    L18:
        if (r7.isShowQuickContact() == false) goto L20;
        this.mContactListView.hideQuickContact();
    L61:
        this.mVisible = r5;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.mVoiceSearchConnected = false;
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView r3, View r4, int r5, int r6, long r7) {
        ExpandAdapter r8 = (ExpandAdapter) this.mCityListView.getExpandableListAdapter();
        ArrayList<String> r9 = null;
        if ((r8 instanceof ExpandAdapterForLocation) == false) goto L6;
        SamContact r10 = this.mCityAdapter.getChild(r5, r6);
    L10:
        if (r10 != null) goto L13;
        return false;
    L13:
        if (this.mIsEdit == false) goto L22;
        OCheckBox r11 = (OCheckBox) r4.findViewById(R.id.checkBox);
        if (r11 != null) goto L18;
        return false;
    L18:
        if (this.mSelectedSet.contains(Long.valueOf(r10.contactId)) == false) goto L20;
        this.mSelectedSet.remove(Long.valueOf(r10.contactId));
        r11.setChecked(false);
    L21:
        return true;
    L20:
        this.mSelectedSet.add(Long.valueOf(r10.contactId));
        r11.setChecked(true);
        goto L21
    L22:
        Uri r12 = getContactUri(r10);
        if (r10.numbersMap == null) goto L25;
        Collection<String> r13 = r10.numbersMap.values();
        r9 = new ArrayList(r13.size());
        r9.addAll(r13);
    L25:
        startDetailActivity(r12, r9, false);
        return true;
    L6:
        if ((r8 instanceof ExpandAdapterForCompany) == false) goto L8;
        r10 = this.mCompanyAdapter.getChild(r5, r6);
        goto L10
    L8:
        r10 = null;
        goto L10
    }

    private AsyncImageLoader getAsyncImageLoader() {
        FragmentActivity r0 = getActivity();
        if (this.mAsyncImageLoader != null) goto L7;
        if (r0 == null) goto L7;
        this.mAsyncImageLoader = AsyncImageLoader.getInstances(r0);
    L7:
        return this.mAsyncImageLoader;
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountChosen(AccountWithDataSet r3, Bundle r4) {
        doImportInEmpty(getActivity(), r4.getInt(KEY_RES_ID), r3);
    }

    @Override // com.android.contacts.activities.DialtactsActivity.PageEnableListener
    public void setEnable(boolean r3, boolean r4) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEnable visible:" + r3 + "; mProviderIsNormal:" + this.mProviderIsNormal);
    L5:
        this.mProviderIsNormal = r3;
        if (r3 == true) goto L8;
        return;
    L8:
        if (isResumed() == false) goto L13;
        if (r4 == false) goto L14;
        triggerLoad(this.mSortMode, true);
        return;
    L14:
        return;
    }

    private Location getLocation() {
        Location r2 = null;
        this.mLocationManager.removeUpdates(this.mlistener);     // Catch: Exception -> L17
        if (this.mLocationManager.isProviderEnabled("gps") == false) goto L14;
        Location r0 = requestUpdatesFromProvider("gps");     // Catch: Exception -> L17
        Location r3 = requestUpdatesFromProvider("network");     // Catch: Exception -> L17
        if (r0 == null) goto L9;
        if (r3 == null) goto L9;
        r2 = getBetterLocation(r0, r3);     // Catch: Exception -> L17
    L20:
    L19:
        return r2;
    L9:
        if (r0 == null) goto L11;
        r2 = r0;
        goto L20
    L11:
        if (r3 == null) goto L20;
        r2 = r3;
        goto L20
    L14:
        if (ContactsUtils.DEBUG == false) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getLocation fail, gps is disable.");     // Catch: Exception -> L17
    L17:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getLocation e:" + e);
        goto L19
    }

    private Location requestUpdatesFromProvider(String r8) {
        if (this.mLocationManager.isProviderEnabled(r8) == false) goto L5;
        this.mLocationManager.requestLocationUpdates(r8, 10000, 10.0f, this.mlistener);
        return this.mLocationManager.getLastKnownLocation(r8);
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "get provider is failure." + r8);
        return null;
    }

    protected Location getBetterLocation(Location r9, Location r10) {
        if (r10 != null) goto L4;
        return r9;
    L4:
        long r0 = r9.getTime() - r10.getTime();
        boolean r3 = true;
        if (r0 <= 120000) goto L7;
        boolean r2 = true;
    L9:
        if (r0 >= (-120000)) goto L11;
        boolean r5 = true;
    L13:
        if (r0 <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r2 == false) goto L18;
        return r9;
    L18:
        if (r5 == false) goto L20;
        return r10;
    L20:
        int r4 = (int) (r9.getAccuracy() - r10.getAccuracy());
        if (r4 <= 0) goto L23;
        boolean r6 = true;
    L24:
        if (r4 >= 0) goto L26;
        boolean r7 = true;
    L28:
        if (r4 > 200) goto L31;
        r3 = false;
    L31:
        boolean r8 = isSameProvider(r9.getProvider(), r10.getProvider());
        if (r7 == false) goto L34;
        return r9;
    L34:
        if (r1 == false) goto L37;
        if (r6 == true) goto L37;
        return r9;
    L37:
        if (r1 == false) goto L41;
        if (r3 == true) goto L41;
        if (r8 == false) goto L41;
        return r9;
    L41:
        return r10;
    L26:
        r7 = false;
        goto L28
    L23:
        r6 = false;
        goto L24
    L15:
        r1 = false;
        goto L16
    L11:
        r5 = false;
        goto L13
    L7:
        r2 = false;
        goto L9
    }

    private boolean isSameProvider(String r1, String r2) {
        if (r1 != null) goto L8;
        if (r2 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r1.equals(r2);
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ReleaseResourceListener
    public void release() {
        if (this.mVisible == true) goto L51;
        this.mQuickBar.setVisibility(8);
        clearModeState();
        this.mContactListView.setAdapter(null);
        if (this.mCityListView == null) goto L7;
        ExpandAdapter r0 = new ExpandAdapter(getActivity(), null, this.mPhotoManager, this.mCityListView);
        this.mCityListView.setAdapter(r0);
    L7:
        ContactsListSortByNameAdapter r1 = this.mNorAdapter;
        if (r1 == null) goto L12;
        r1.setList(null);
        this.mNorAdapter = null;
        ArrayList<SamContact> r2 = this.mOldContacts;
        if (r2 == null) goto L12;
        r2.clear();
        this.mOldContacts = null;
    L12:
        ExpandAdapterForLocation r3 = this.mCityAdapter;
        if (r3 == null) goto L17;
        r3.setData(null);
        this.mCityAdapter = null;
        ArrayList<SamContact> r4 = this.mOldContactCityItems;
        if (r4 == null) goto L17;
        r4.clear();
        this.mOldContactCityItems = null;
    L17:
        ExpandAdapterForCompany r5 = this.mCompanyAdapter;
        if (r5 == null) goto L22;
        r5.setData(null);
        this.mCompanyAdapter = null;
        ArrayList<SamContact> r6 = this.mOldContactsCompanyItems;
        if (r6 == null) goto L22;
        r6.clear();
        this.mOldContactsCompanyItems = null;
    L22:
        ContactsListSortByTimesAdapter r7 = this.mTimesAdapter;
        if (r7 == null) goto L27;
        r7.setList(null);
        this.mTimesAdapter = null;
        ArrayList<SamContact> r8 = this.mOldContactTimesItems;
        if (r8 == null) goto L27;
        r8.clear();
        this.mOldContactTimesItems = null;
    L27:
        ContactsListSortByAddedTimeAdapter r9 = this.mAddedTimesAdapter;
        if (r9 == null) goto L32;
        r9.setList(null);
        this.mAddedTimesAdapter = null;
        ArrayList<SamContact> r10 = this.mOldContactAddedTimeItems;
        if (r10 == null) goto L32;
        r10.clear();
        this.mOldContactAddedTimeItems = null;
    L32:
        ContactsListSortByNameAdapter r11 = this.mPhoneContactsAdapter;
        if (r11 == null) goto L37;
        r11.setList(null);
        this.mPhoneContactsAdapter = null;
        ArrayList<SamContact> r12 = this.mOldContactsPhoneItems;
        if (r12 == null) goto L37;
        r12.clear();
        this.mOldContactsPhoneItems = null;
    L37:
        ContactsListSortBySimAdapter r13 = this.mSimAdapter;
        if (r13 == null) goto L45;
        r13.setList(null);
        this.mSimAdapter = null;
        ArrayList<SamContact> r14 = this.mOldContactsSim1Items;
        if (r14 == null) goto L42;
        r14.clear();
        this.mOldContactsSim1Items = null;
    L42:
        ArrayList<SamContact> r15 = this.mOldContactsSim2Items;
        if (r15 == null) goto L45;
        r15.clear();
        this.mOldContactsSim2Items = null;
    L45:
        FlowAdapter r16 = this.mFlowAdapter;
        if (r16 == null) goto L52;
        r16.setData(null);
        this.mFlowAdapter = null;
        List<BaseFlowAdapter.FlowEntry> r17 = this.mCachedRecommendData;
        if (r17 == null) goto L53;
        r17.clear();
        this.mCachedRecommendData = null;
        return;
    L53:
        return;
    L52:
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.onBackPressListener
    public boolean backToTopState() {
        ViewGroup r0 = this.mSearchResultDialog;
        boolean r2 = true;
        if (r0 != null) goto L5;
    L8:
        ViewGroup r1 = this.mEmptyResultDialog;
        if (r1 != null) goto L11;
    L13:
        OIndexScrollbar r3 = this.mQuickBar;
        if (r3 == null) goto L19;
        if (r3.isLetterGridShown() == false) goto L19;
        this.mQuickBar.hideLetterGrid();
    L7:
        r2 = false;
    L36:
        if (recoveryFromGroupEdit() == false) goto L39;
        return false;
    L39:
        return r2;
    L19:
        if (isShowQuickContact() == false) goto L22;
        hideQuickContact();
        goto L7
    L22:
        if (isSearch() == false) goto L27;
        if (isSearchAnimationing() == true) goto L27;
        cancelSearch();
    L27:
        if (this.mIsEdit == false) goto L36;
        if (this.mContactListView.isSelecting() == true) goto L7;
        QuickContactExpandableListView r4 = this.mCityListView;
        if (r4 != null) goto L33;
    L34:
        processEditContacts(false, true);
        goto L7
    L33:
        if (r4.isSelecting() == true) goto L7;
    L11:
        if (r1.getVisibility() != 0) goto L13;
        AnimationUtil.hideResultDialogWithAnim(this.mEmptyResultDialog);
        AnimationUtil.hideCoverWithAnimation(this.mCover);
        this.mCoverDismiss = true;
        goto L7
    L5:
        if (r0.getVisibility() != 0) goto L8;
        AnimationUtil.hideResultDialogWithAnim(this.mSearchResultDialog);
        AnimationUtil.hideCoverWithAnimation(this.mCover);
        this.mCoverDismiss = true;
        goto L7
    }

    private boolean recoveryFromGroupEdit() {
        GroupBrowseListFragment r0 = this.mGroupBrowseListFragment;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.isEdit() == false) goto L11;
        if (this.mGroupBrowseListFragment.isSelecting() == true) goto L12;
        this.mGroupBrowseListFragment.setGroupEdit(false);
        setGroupEditState(false);
        return true;
    L12:
        return true;
    }

    private void startDetailActivity(Uri r2, ArrayList<String> r3, boolean r4) {
        startDetailActivity(r2, r3, r4, false);
    }

    private void startDetailActivity(Uri r2, ArrayList<String> r3, boolean r4, boolean r5) {
        if (r4 == false) goto L4;
        ContactDetailCacheManager.getInstance().loadResultData(r2);
    L4:
        Intent r6 = ContactsIntentUtils.launchContactDetailIntent(this.mActivity, r2, true);
        if (r3 == null) goto L10;
        if (r3.isEmpty() == true) goto L10;
        r6.putStringArrayListExtra(ContactsUtils.EXTRA_PHONE_NUMBERS_HIGHLIGHT, r3);
    L10:
        if (this.mIsSearch == false) goto L12;
        String r7 = Constants.ContactsTracker.SUFFIX_FROM_LIST_SEARCH_RESULT_ITEM;
    L26:
        if (TextUtils.isEmpty(r7) == true) goto L28;
        r6.putExtra(Constants.ContactsTracker.EXTRA_SOURCE_FOR_TRACKER, r7);
    L28:
        if (r5 == false) goto L30;
        startActivity(r6);
    L31:
        AnimationUtil.switchActivityAnimation(this.mActivity, 5);
        return;
    L30:
        startActivityForResult(r6, 21);
        goto L31
    L12:
        int r8 = this.mSortMode;
        if (r8 != 1) goto L15;
        r7 = Constants.ContactsTracker.FROM_SORT_BY_NAME;
        goto L26
    L15:
        if (r8 != 2) goto L17;
        r7 = Constants.ContactsTracker.FROM_SORT_BY_LOCATION;
        goto L26
    L17:
        if (r8 != 4) goto L19;
        r7 = Constants.ContactsTracker.FROM_SORT_BY_FREQUENCY;
        goto L26
    L19:
        if (r8 == 8) goto L21;
        r7 = null;
        goto L26
    L21:
        r7 = Constants.ContactsTracker.FROM_SORT_BY_DATE;
        goto L26
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (r3 == (-1)) goto L6;
        return;
    L6:
        if (r2 == 21) goto L12;
        if (r2 != 22) goto L20;
        r4.setAction("android.intent.action.INSERT");
        r4.setClass(getActivity(), ContactEditorActivity.class);
        startActivity(r4);
        return;
    L20:
        return;
    L12:
        if (isAdded() == false) goto L18;
        Uri r5 = r4.getData();
        if (r5 == null) goto L19;
        removeItemFromList(r5);
        return;
    L19:
        return;
    }

    private void refreshProfileDetailCache(SamContact r5) {
        if (r5.contactId != (-1)) goto L5;
        return;
    L5:
        Uri r6 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), r5.contactId);
        ContactDetailCacheManager.getInstance().initProfileCache(this.mActivity, r6);
    }

    public void setKeepSearchState(boolean r1) {
        this.mKeepSearchState = r1;
    }

    private void processGroupExpandableState(ExpandableListAdapter r7) {
        if (this.mCollapseAllGroup == false) goto L10;
        int r0 = 0;
    L6:
        if (r0 >= r7.getGroupCount()) goto L8;
        this.mCityListView.collapseGroup(r0);
        r0 = r0 + 1;
        goto L6
    L8:
        this.mExpandGroups.clear();
        this.mCollapseAllGroup = false;
        return;
    L10:
        int r1 = 0;
    L12:
        if (r1 >= r7.getGroupCount()) goto L18;
        long r2 = r7.getGroupId(r1);
        if (this.mExpandGroups.containsKey(Long.valueOf(r2)) == false) goto L16;
        this.mCityListView.expandGroup(r1);
        this.mExpandGroups.put(Long.valueOf(r2), 1);
    L17:
        r1 = r1 + 1;
        goto L12
    L16:
        this.mCityListView.collapseGroup(r1);
        goto L17
    L18:
        ArrayList r8 = new ArrayList();
        Iterator<Long> r3 = this.mExpandGroups.keySet().iterator();
    L20:
        if (r3.hasNext() == false) goto L25;
        long r4 = r3.next().longValue();
        if (this.mExpandGroups.get(Long.valueOf(r4)).intValue() == 0) goto L23;
        this.mExpandGroups.put(Long.valueOf(r4), 0);
        goto L20
    L23:
        r8.add(Long.valueOf(r4));
        goto L20
    L25:
        Iterator r9 = r8.iterator();
    L27:
        if (r9.hasNext() == false) goto L29;
        this.mExpandGroups.remove(Long.valueOf(((Long) r9.next()).longValue()));
        goto L27
    }

    private void deleteContacts(final boolean r3) {
        this.mHandler.post(new AnonymousClass67(this, r3));
    }

    private void initLetter(int r7) {
        if (r7 != 0) goto L4;
        this.mQuickBar.initLetters();
        return;
    L4:
        if (r7 == 1) goto L15;
        if (r7 == 2) goto L8;
        return;
    L8:
        if (this.mLetterProfileNewBitmaps != null) goto L11;
        Bitmap[][] r8 = (Bitmap[][]) Array.newInstance(Bitmap.class, new int[]{1, 3});
        this.mLetterProfileNewBitmaps = r8;
        r8[0][0] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
        this.mLetterProfileNewBitmaps[0][1] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
        this.mLetterProfileNewBitmaps[0][2] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
    L11:
        if (this.mLetterProfileSelectedNewBitmaps != null) goto L13;
        this.mLetterProfileSelectedNewBitmaps = new Bitmap[]{BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_user_avatar_big)};
    L13:
        this.mQuickBar.initSpecialIcons(new int[]{1}, this.mLetterProfileNewBitmaps);
        this.mQuickBar.initSpecialSelectedIcons(this.mLetterProfileSelectedNewBitmaps);
        return;
    L15:
        if (this.mLetterProfileBitmaps != null) goto L18;
        Bitmap[][] r9 = (Bitmap[][]) Array.newInstance(Bitmap.class, new int[]{1, 3});
        this.mLetterProfileBitmaps = r9;
        r9[0][0] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
        this.mLetterProfileBitmaps[0][1] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
        this.mLetterProfileBitmaps[0][2] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
    L18:
        if (this.mLetterProfileSelectedBitmaps != null) goto L20;
        this.mLetterProfileSelectedBitmaps = new Bitmap[]{BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_user_avatar_big)};
    L20:
        this.mQuickBar.initSpecialIcons(new int[]{1}, this.mLetterProfileBitmaps);
        this.mQuickBar.initSpecialSelectedIcons(this.mLetterProfileSelectedBitmaps);
    }

    @Override // com.android.contacts.util.AvatarImageHelper.OnAvatarTextFontChangeListener
    public void onAvatarTextFontChanged() {
        this.mHandler.sendEmptyMessage(R.id.msg_loadedphotos);
    }

    private void initCloseVoiceDialog(Context r3) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(r3, 5);
        r0.setTitle(R.string.common_prompt);
        r0.setMessage(R.string.close_voice_dialog_message);
        r0.setPositiveButton(R.string.common_ok, new AnonymousClass68(this));
        this.mCloseVoiceDialog = r0.create();
    }

    private void dismissCloseVoiceDialog() {
        AlertDialog r0 = this.mCloseVoiceDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mCloseVoiceDialog.dismiss();
        return;
    }

    @Override // com.android.contacts.list.ContactListFilterController.ContactListFilterListener
    public void onContactListFilterChanged() {
        setAccountFilterQuerySelection();
    }

    public void setContactListFilterController(ContactListFilterController r1) {
        this.mContactListFilterController = r1;
    }

    private void setAccountFilterQuerySelection() {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setAccountFilterQuerySelection");
    L5:
        ContactListFilterController r0 = this.mContactListFilterController;
        boolean r1 = true;
        boolean r2 = false;
        if (r0 == null) goto L24;
        Set<ContactListFilter> r3 = r0.getFilters();
        if (r3 == null) goto L24;
        if (r3.size() == 0) goto L25;
        ArrayList r4 = Lists.newArrayList();
        Iterator<ContactListFilter> r5 = r3.iterator();
    L14:
        if (r5.hasNext() == false) goto L19;
        ContactListFilter r6 = r5.next();
        if ("com.android.sim".equals(r6.accountType) == true) goto L17;
        r4.add(new AccountWithDataSet(r6.accountName, r6.accountType, r6.dataSet));
        goto L14
    L17:
        r4.add(new AccountWithDataSet(r6.accountName, r6.accountType, null));
        r4.add(new AccountWithDataSet(r6.accountName, r6.accountType, SimContactsConstants.SIM_NAME));
        r4.add(new AccountWithDataSet(r6.accountName, r6.accountType, "USIM"));
        goto L14
    L19:
        this.mAccountsFilterQueryParameter = AccountWithDataSet.stringifyList(r4);
        List<AccountWithDataSet> r7 = AccountTypeManager.getInstance(this.mContext).getAccounts(false);
        if (r7 == null) goto L24;
        if (r7.size() <= r3.size()) goto L24;
        r1 = false;
    L25:
        this.mNoContactsSelected = r1;
        this.mAllContactsSelected = r2;
        return;
    L24:
        r2 = true;
        r1 = false;
        goto L25
    }

    private Uri appendAccountsFilterQueryParameter(Uri r3) {
        if (TextUtils.isEmpty(this.mAccountsFilterQueryParameter) == true) goto L6;
        Uri.Builder r4 = r3.buildUpon();
        r4.appendQueryParameter(MULTI_ACCOUNTS_FLAG, "true");
        r4.appendQueryParameter(ACCOUNTS_FILTERS_PARAM, this.mAccountsFilterQueryParameter);
        return r4.build();
    L6:
        return r3;
    }

    public List<Long> getCurrentVisibleContact() {
        if (this.mContactListView.getChildCount() > 0) goto L5;
        return null;
    L5:
        int r0 = this.mSortMode;
        if (r0 != 1) goto L8;
    L15:
        ArrayList r1 = new ArrayList(getListVisibleList());
    L16:
        if (r1 != null) goto L18;
    L20:
        return null;
    L18:
        if (r1.size() <= 0) goto L20;
        return r1;
    L8:
        if (r0 != 2) goto L10;
        r1 = new ArrayList(getGroupListVisibleList());
        goto L16
    L10:
        if (r0 == 4) goto L15;
        if (r0 == 8) goto L15;
        r1 = null;
        goto L16
    }

    private List<Long> getListVisibleList() {
        ArrayList r1 = new ArrayList();
        int r2 = this.mContactListView.getAdapter().getCount();
        int r3 = this.mContactListView.getFirstVisiblePosition();
        int r4 = this.mContactListView.getLastVisiblePosition();
        int r5 = r3;
    L3:
        if (r5 > r4) goto L26;
        if (r5 < r2) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "getListVisibleList IndexOutOfBounds i = " + r5 + " ,count = " + r2);
    L7:
        r2 = r2;
        r3 = r3;
        r4 = r4;
        int r6 = r5;
    L25:
        r5 = r6 + 1;
        r4 = r4;
        r2 = r2;
        r3 = r3;
        goto L3
    L8:
        View r7 = this.mContactListView.getChildAt(r5 - r3);
        if (r7 == null) goto L7;
        long r8 = this.mContactListView.getAdapter().getItemId(r5);
        int r10 = this.mContactListView.getHeight();
        int r11 = r7.getTop();
        int r9 = r7.getBottom();
        if (r11 >= 0) goto L14;
        double r12 = (((double) (r11 + 180)) * 1.0d) / (((double) 180) * 1.0d);
    L15:
        if (r9 <= r10) goto L18;
        r12 = (((double) (180 - (r9 - r10))) * 1.0d) / (((double) 180) * 1.0d);
    L18:
        if (r8 > 0) goto L20;
    L24:
        r6 = r5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onProvideAssistContent: getCurrentVisibleContact id = " + r8 + " height = " + r10 + " itemTop = " + r11 + " itemBottom = " + r9 + " position = " + r6);
        goto L25
    L20:
        if (r1.contains(Long.valueOf(r8)) == true) goto L24;
        if (r12 <= 0.5d) goto L24;
        r1.add(Long.valueOf(r8));
        goto L24
    L14:
        r12 = 1.0d;
        goto L15
    L26:
        return r1;
    }

    private List<Long> getGroupListVisibleList() {
        ArrayList r1 = new ArrayList();
        int r2 = this.mCityListView.getFirstVisiblePosition();
        int r3 = this.mCityListView.getLastVisiblePosition();
        int r4 = r2;
    L3:
        if (r4 > r3) goto L27;
        View r5 = this.mCityListView.getChildAt(r4 - r2);
        if (r5 == null) goto L25;
        ExpandableListAdapter r6 = this.mCityListView.getExpandableListAdapter();
        long r7 = this.mCityListView.getExpandableListPosition(r4);
        int r9 = QuickContactExpandableListView.getPackedPositionGroup(r7);
        int r8 = QuickContactExpandableListView.getPackedPositionChild(r7);
        if (r9 == (-1)) goto L25;
        if (r8 == (-1)) goto L25;
        long r10 = ((SamContact) r6.getChild(r9, r8)).contactId;
        int r11 = this.mContactListView.getHeight();
        int r12 = r5.getMeasuredHeight();
        int r13 = r5.getTop() - ContactsUtils.dipTopx(getContext(), 45.0d);
        int r14 = r5.getBottom();
        if (r13 >= 0) goto L14;
        double r15 = (((double) (r12 + r13)) * 1.0d) / (((double) r12) * 1.0d);
    L15:
        if (r14 <= r11) goto L18;
        r15 = (((double) (r12 - (r14 - r11))) * 1.0d) / (((double) r12) * 1.0d);
    L18:
        if (r10 > 0) goto L20;
    L24:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onProvideAssistContent: getGroupListVisibleList id = " + r10 + " height = " + r11 + " itemTop = " + r13 + " itemBottom = " + r14 + " position = " + r4);
    L26:
        r4 = r4 + 1;
        r2 = r2;
        r3 = r3;
        goto L3
    L20:
        if (r1.contains(Long.valueOf(r10)) == true) goto L24;
        if (r15 <= 0.5d) goto L24;
        r1.add(Long.valueOf(r10));
        goto L24
    L14:
        r15 = 1.0d;
    L25:
        r2 = r2;
        r3 = r3;
        goto L26
    L27:
        return r1;
    }

    public void setBottomDeleteLayoutListener(BottomDeleteLayoutListener r1) {
        this.mBottomDeleteLayoutListener = r1;
    }

    public void onClickDelete() {
        if (this.mIsShowGroup == false) goto L5;
        onDeleteGroupClicked();
        return;
    L5:
        onDeleteContactClicked();
    }
}
