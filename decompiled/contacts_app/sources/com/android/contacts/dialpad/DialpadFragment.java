package com.android.contacts.dialpad;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DialerKeyListener;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.util.NameAvatarController;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.SpecialCharSequenceMgr;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.calllog.CallLogAdapter;
import com.android.contacts.calllog.CallLogListItemViews;
import com.android.contacts.calllog.CallLogNotificationsService;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.forcetouch.ForceTouchController;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.list.HorizontalScrollListView;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.recommend.BaseFlowAdapter;
import com.android.contacts.recommend.FlowAdapter;
import com.android.contacts.recommend.RecommendDataLoader;
import com.android.contacts.recommend.RecommendUtil;
import com.android.contacts.speeddial.SpeedDialSettingActivity;
import com.android.contacts.speeddial.SpeedDialUtils;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.AvatarImageHelper;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactBadgeUtil;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.ImportantResource;
import com.android.contacts.util.NumberMarkResource;
import com.android.contacts.util.OreoApiUtils;
import com.android.contacts.util.PhoneNumberFormatter;
import com.android.contacts.util.ProductUtils;
import com.android.contacts.util.TelecomUtil;
import com.android.contacts.util.UiUtils;
import com.android.contacts.widget.CopyTextViewKt;
import com.android.contacts.widget.DialpadContainer;
import com.android.contacts.widget.PopMenu;
import com.android.contacts.widget.PopMenuItem;
import com.android.contacts.widget.SimSwitchView;
import com.android.contacts.widget.ViewUtilsKt;
import com.android.internal.telephony.ITelephony;
import com.android.phone.common.CallLogAsync;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.google.common.collect.Lists;
import com.obric.anim.ContactsTransitionKt;
import com.obric.anim.OEAAnimKt;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.settings.SettingsProviderHelper;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import com.obric.utils.VibratorHelper;
import com.obric.utils.views.DismissibleClickableView;
import com.obricOld.contacts.menus.LongMenuHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import obric.api.TelephonySmt;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(since = "废弃不再使用，请关注 NewDialpadFragment")
public class DialpadFragment extends AbstractFragment implements View.OnClickListener, View.OnLongClickListener, View.OnKeyListener, DialtactsActivity.ViewPagerVisibilityListener, AdapterView.OnItemClickListener, TextWatcher, PopupMenu.OnMenuItemClickListener, AbsListView.OnScrollListener, View.OnTouchListener, RecommendDataLoader.OnRecommendDataLoadListener, AvatarImageHelper.OnAvatarTextFontChangeListener, CallLogAdapter.CallFetcher, DialtactsActivity.PageEnableListener, DialtactsActivity.ReleaseResourceListener, DialtactsActivity.onBackPressListener, DSUtils.DSFatureStatusListener, DialtactsActivity.OnDBDataChangeListener {
    static final String ADD_CALL_MODE_KEY = "add_call_mode";
    private static final boolean DEBUG = false;
    private static final int DELAY_UPDATE_TRANSITION = 900;
    private static final int DIAL_TONE_STREAM_TYPE = 1;
    private static final String EMPTY_NUMBER = "";
    static final String EXTRA_SEND_EMPTY_FLASH = "com.android.phone.extra.SEND_EMPTY_FLASH";
    private static final int INPUT_TEXT_TIME_OUT = 11;
    private static final String KEY_CLASSIFY = "classify";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_DIGITS = "digits";
    private static final int LONG_CLICK_DELAY = 500;
    private static final int MESSAGE_CLICK_ONE = 3;
    private static final int MESSAGE_CLICK_POUND = 2;
    private static final int MESSAGE_CLICK_STAR = 1;
    private static final int MESSAGE_CLICK_ZERO = 0;
    private static final int MESSAGE_SPEED_DIAL = 4;
    private static final int MESSAGE_UPDATE_TRANSITION = 10;
    private static final int MSG_QUERY_PUBLIC_NUMBER = 200;
    private static final int MSG_REFRESH_OPTION_FRAME = 201;
    private static final int MSG_UPDATE_FLOW_ADAPTER = 1000;
    private static final int SET_T9_ADAPTER_UNLIMITIED = 13;
    private static final int SHOW_MIRAGE_HIDE_ANIMATION = 12;
    public static final String SP_KEY_SHOULD_SHOW_TUTORIAL_POPUP = "should_show_tutorial_popup";
    private static final boolean SUPPORT_SAVE_DIGITS = false;
    private static final boolean SUPPORT_TEN_MINUTES_CLEAR_DIGITS = false;
    private static final String TAG = "DialpadFragment";
    private static final long TEN_MINUTES = 600000;
    private static final long TIME_DELAED_AFTER_NUMBER_FORMAT = 400;
    private static final int TONE_LENGTH_MS = 150;
    private static final int TONE_RELATIVE_VOLUME = 56;
    private static int sDigitEmptyTextSize = 0;
    private static int sDigitFrameMaxHeight = 0;
    private static int sDigitFrameMinHeight = 0;
    private static int sDigitTextSizeHint = 0;
    private static boolean sIsTooLate = false;
    private static DialpadFragment sPreloadMe;
    private static final LongMenuHelper.MenuType[] sT9CalllogMenuItems = null;
    private static final LongMenuHelper.MenuType[] sT9ContactMenuItems = null;
    private final String DIALPAD_LEFT_MODE;
    private final String DIALPAD_NUMBER;
    private final String DIALPAD_NUMBER_UPDATE_TIME;
    private boolean isFillDigits;
    private boolean isShowLeft;
    private boolean isT9on;
    private FlowAdapter mAdapter;
    private AudioManager mAudioManager;
    private View mBGView;
    private OButton mBtnAddClassic;
    private OButton mBtnAddLeft;
    private OButton mBtnAddRight;
    private LinearLayout mBtnAddToContact;
    private OButton mBtnChangeModeLeft;
    private OButton mBtnChangeModeRight;
    private LinearLayout mBtnSendMessage;
    CallLogAsync mCallLog;
    private View mClassicDialpad;
    private ContentObserver mContactsObserver;
    private FragmentActivity mContext;
    private int mCurrentDialpadLayoutID;
    private View mCurrentDialpadPanel;
    private boolean mDTMFToneEnabled;
    private View mDelete;
    private View mDeleteClassic;
    private OAlertDialog mDialog;
    private View mDialpad;
    private TextView mDialpadDarkLeft;
    private TextView mDialpadDarkRight;
    private Map<Integer, View> mDialpadLayoutCache;
    private DialpadOptionAdapter mDialpadOptionAdapter;
    private View mDialpadUnusualLeft;
    private View mDialpadUnusualRight;
    private View mDialpadUsual;
    private FrameLayout mDigitFrame;
    private DigitsEditText mDigits;
    private DismissibleClickableView mDismissibleClickableView;
    private View mEmptyView;
    private boolean mFirstLoad;
    private boolean mFirstUseAfterColdLaunch;
    private ForceTouchController mForceTouchController;
    private View mFragmentView;
    private Handler mHandler;
    private boolean mIgnoreChange;
    ImportantResource mImportantResource;
    private boolean mInMissCallsPage;
    private boolean mIsDialpadLeftMode;
    private volatile boolean mIsLoadingCalls;
    private boolean mIsResetLayout;
    private boolean mIsShowDialpad;
    private HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private KeyTask mKeyTask;
    private KeyguardManager mKeyguardManager;
    private String mLastNumberDialed;
    private QuickContactListView mListView;
    private ObjectAnimator mListViewAlphaAnimator;
    private Handler mLongClickHandler;
    private boolean mNeedReloadData;
    private Intent mOldIntent;
    private View mOpenCallSummaryView;
    private ArrayList<DialpadOptionItem> mOptionItems;
    private PhoneStateListener mPhoneStateListener1;
    private PhoneStateListener mPhoneStateListener2;
    private ContactPhotoManager mPhotoLoader;
    private SharedPreferences mPrefs;
    private PreferencesCallback mPrefsCallback;
    private String mProhibitedPhoneNumberRegexp;
    private boolean mProviderIsNormal;
    private RecommendDataLoader mRecommendDataLoader;
    private int mRegisIndex;
    ArrayList<ContactItem> mResults;
    Thread mSearchContactsThread;
    private Function0 mShowClipPopupWindowRunnable;
    private PopMenu mSimSelectPopMenu;
    private T9Search.T9Adapter mT9Adapter;
    private T9Search.Listener mT9Listener;
    T9Search.T9SearchResult mT9Result;
    private final String mT9SearchThreadName;
    String mTempStr;
    private List<BaseFlowAdapter.FlowEntry> mTmpDataList;
    private ToneGenerator mToneGenerator;
    private Object mToneGeneratorLock;
    private View mTouchpad;
    private boolean mVisibilityChanged;
    ExecutorService pool;
    private T9Search sT9Search;

    /* JADX INFO: renamed from: com.android.contacts.dialpad.DialpadFragment$32, reason: invalid class name */
    static /* synthetic */ class AnonymousClass32 {
        static final /* synthetic */ int[] $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType = null;

        static {
            int[] r0 = new int[LongMenuHelper.MenuType.values().length];
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType = r0;
            r0[LongMenuHelper.MenuType.MENU_DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[LongMenuHelper.MenuType.MENU_BLACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class ErrorDialogFragment extends DialogFragment {
        private static final String ARG_MESSAGE_RES_ID = "argMessageResId";
        private static final String ARG_TITLE_RES_ID = "argTitleResId";
        private Integer mMessageResId;
        private int mTitleResId;

        public ErrorDialogFragment() {
        }

        public static ErrorDialogFragment newInstance(int r1) {
            return newInstanceInter(r1, null);
        }

        public static ErrorDialogFragment newInstance(int r0, int r1) {
            return newInstanceInter(r0, Integer.valueOf(r1));
        }

        private static ErrorDialogFragment newInstanceInter(int r3, Integer r4) {
            ErrorDialogFragment r0 = new ErrorDialogFragment();
            Bundle r1 = new Bundle();
            r1.putInt(ARG_TITLE_RES_ID, r3);
            if (r4 == null) goto L5;
            r1.putInt(ARG_MESSAGE_RES_ID, r4.intValue());
        L5:
            r0.setArguments(r1);
            return r0;
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r2) {
            super.onCreate(r2);
            this.mTitleResId = getArguments().getInt(ARG_TITLE_RES_ID);
            if (getArguments().containsKey(ARG_MESSAGE_RES_ID) == false) goto L6;
            this.mMessageResId = Integer.valueOf(getArguments().getInt(ARG_MESSAGE_RES_ID));
            return;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r4) {
            AlertDialog.Builder r5 = new AlertDialog.Builder(getActivity());
            r5.setTitle(this.mTitleResId).setPositiveButton(R.string.ok, new AnonymousClass1(this));
            Integer r3 = this.mMessageResId;
            if (r3 == null) goto L6;
            r5.setMessage(r3.intValue());
        L6:
            return r5.create();
        }
    }

    private class KeyTask {
        private boolean mCancelled;
        private int mKeyCode;
        private int mPlayTone;
        final /* synthetic */ DialpadFragment this$0;

        private KeyTask(DialpadFragment r1) {
            this.this$0 = r1;
            this.mPlayTone = -1;
            this.mKeyCode = -1;
            this.mCancelled = false;
        }

        /* synthetic */ KeyTask(DialpadFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$3300(KeyTask r0, View r1, float r2, float r3, int r4, int r5) {
            r0.executeForDown(r1, r2, r3, r4, r5);
        }

        static /* synthetic */ void access$3400(KeyTask r0, View r1, float r2, float r3) {
            r0.executeForMove(r1, r2, r3);
        }

        static /* synthetic */ void access$3500(KeyTask r0, View r1, int r2) {
            r0.executeForUpOrCancel(r1, r2);
        }

        static /* synthetic */ void access$3700(KeyTask r0) {
            r0.cancel();
        }

        private Rect getSysGestureInsets() {
            return DialtactsActivity.sSysGestureInsets;
        }

        private void executeForDown(View r1, float r2, float r3, int r4, int r5) {
            this.mPlayTone = r4;
            this.mKeyCode = r5;
            this.mCancelled = false;
        }

        private void executeForMove(View r2, float r3, float r4) {
            if (this.mCancelled == false) goto L5;
            return;
        L5:
            if (DialpadFragment.access$4800(r3, r4, r2) == true) goto L9;
            cancel();
            return;
        }

        private void executeForUpOrCancel(View r1, int r2) {
            if (r2 == 1) goto L5;
        L7:
            this.mCancelled = false;
            this.mPlayTone = -1;
            this.mKeyCode = -1;
            return;
        L5:
            if (this.mCancelled == true) goto L7;
            execute();
            goto L7
        }

        private void execute() {
            int r0 = this.mPlayTone;
            if (r0 <= (-1)) goto L5;
            this.this$0.playTone(r0);
        L5:
            int r1 = this.mKeyCode;
            if (r1 <= (-1)) goto L9;
            DialpadFragment.access$3800(this.this$0, r1);
            return;
        }

        private void cancel() {
            this.mCancelled = true;
        }
    }

    public interface Listener {
        void onSearchButtonPressed();
    }

    private String getDialpadNumber() {
        return "";
    }

    private boolean isDialpadNumberTimeOut() {
        return false;
    }

    private void updateOnEntry() {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    public DialpadFragment() {
        this.mDialpadOptionAdapter = null;
        this.mInMissCallsPage = false;
        this.mEmptyView = null;
        this.mFragmentView = null;
        this.mOpenCallSummaryView = null;
        this.mTmpDataList = null;
        this.mT9Listener = new AnonymousClass2(this);
        this.mToneGeneratorLock = new Object();
        this.mDialpadLayoutCache = new HashMap();
        this.isShowLeft = true;
        this.mT9SearchThreadName = "SearchContactsThread";
        this.DIALPAD_LEFT_MODE = "pref_last_dialpad_left_mode";
        this.DIALPAD_NUMBER = "dialpad_number";
        this.DIALPAD_NUMBER_UPDATE_TIME = "dialpad_number_update_time";
        this.mIsDialpadLeftMode = false;
        this.mImportantResource = null;
        this.mIsResetLayout = false;
        this.mKeyTask = new KeyTask(this, null);
        this.mSearchContactsThread = new Thread(new AnonymousClass3(this), "SearchContactsThread");
        this.mSimSelectPopMenu = new PopMenu();
        final Looper r4 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass4(this, r4);
        this.mCallLog = new CallLogAsync();
        this.mLastNumberDialed = "";
        this.mTempStr = "";
        this.mIsLoadingCalls = false;
        this.mFirstLoad = true;
        this.mNeedReloadData = false;
        this.mFirstUseAfterColdLaunch = true;
        this.mRegisIndex = 0;
        this.mIgnoreChange = false;
        this.mPhoneStateListener1 = new AnonymousClass20(this);
        this.mPhoneStateListener2 = new AnonymousClass21(this);
        this.mResults = new ArrayList();
        this.mVisibilityChanged = false;
        this.isT9on = false;
        final Looper r3 = Looper.getMainLooper();
        this.mLongClickHandler = new AnonymousClass27(this, r3);
        this.mIsShowDialpad = true;
        this.mShowClipPopupWindowRunnable = null;
        this.mItemLongClickedListener = new AnonymousClass31(this);
        this.mProviderIsNormal = true;
    }

    static /* synthetic */ boolean access$000() {
        return DEBUG;
    }

    static /* synthetic */ boolean access$100(DialpadFragment r0) {
        return r0.mIsLoadingCalls;
    }

    static /* synthetic */ QuickContactListView access$1000(DialpadFragment r0) {
        return r0.mListView;
    }

    static /* synthetic */ T9Search.T9Adapter access$1100(DialpadFragment r0) {
        return r0.mT9Adapter;
    }

    static /* synthetic */ void access$1200(DialpadFragment r0, boolean r1) {
        r0.updateListViewConfig(r1);
    }

    static /* synthetic */ ForceTouchController access$1300(DialpadFragment r0) {
        return r0.mForceTouchController;
    }

    static /* synthetic */ void access$1400(DialpadFragment r0) {
        r0.showListViewWithAnimIfNeed();
    }

    static /* synthetic */ void access$1500(DialpadFragment r0) {
        r0.showListViewWithoutAnimIfNeed();
    }

    static /* synthetic */ void access$1600(DialpadFragment r0) {
        r0.beginRefreshOptionFrame();
    }

    static /* synthetic */ void access$1700(DialpadFragment r0, Object r1) {
        r0.refreshOptionFrame(r1);
    }

    static /* synthetic */ ObjectAnimator access$1800(DialpadFragment r0) {
        return r0.mListViewAlphaAnimator;
    }

    static /* synthetic */ void access$1900(DialpadFragment r0) {
        r0.updateOnEntry();
    }

    static /* synthetic */ List access$200(DialpadFragment r0) {
        return r0.mTmpDataList;
    }

    static /* synthetic */ DigitsEditText access$2000(DialpadFragment r0) {
        return r0.mDigits;
    }

    static /* synthetic */ void access$2100(DialpadFragment r0) {
        r0.dismissCallSummaryView();
    }

    static /* synthetic */ T9Search access$2200(DialpadFragment r0) {
        return r0.sT9Search;
    }

    static /* synthetic */ void access$2300(DialpadFragment r0) {
        r0.refreshData();
    }

    static /* synthetic */ boolean access$2402(DialpadFragment r0, boolean r1) {
        r0.mIsResetLayout = r1;
        return r1;
    }

    static /* synthetic */ boolean access$2500(DialpadFragment r0) {
        return r0.isFillDigits;
    }

    static /* synthetic */ boolean access$2600(DialpadFragment r0) {
        return r0.isDialpadNumberTimeOut();
    }

    static /* synthetic */ boolean access$2702(DialpadFragment r0, boolean r1) {
        r0.mIgnoreChange = r1;
        return r1;
    }

    static /* synthetic */ Object access$2800(DialpadFragment r0) {
        return r0.mToneGeneratorLock;
    }

    static /* synthetic */ ToneGenerator access$2900(DialpadFragment r0) {
        return r0.mToneGenerator;
    }

    static /* synthetic */ ToneGenerator access$2902(DialpadFragment r0, ToneGenerator r1) {
        r0.mToneGenerator = r1;
        return r1;
    }

    static /* synthetic */ void access$300(String r0) {
        log(r0);
    }

    static /* synthetic */ View access$3000(DialpadFragment r0) {
        return r0.mBGView;
    }

    static /* synthetic */ String access$3102(DialpadFragment r0, String r1) {
        r0.mLastNumberDialed = r1;
        return r1;
    }

    static /* synthetic */ void access$3200(DialpadFragment r0) {
        r0.updateDialAndDeleteButtonEnabledState();
    }

    static /* synthetic */ KeyTask access$3600(DialpadFragment r0) {
        return r0.mKeyTask;
    }

    static /* synthetic */ void access$3800(DialpadFragment r0, int r1) {
        r0.keyPressed(r1);
    }

    static /* synthetic */ void access$3900(DialpadFragment r0, int r1) {
        r0.callSpeedNumber(r1);
    }

    static /* synthetic */ void access$400(DialpadFragment r0, List r1) {
        r0.updateCallLogList(r1);
    }

    static /* synthetic */ void access$4000(DialpadFragment r0, String r1) {
        r0.showClipPopupWindow(r1);
    }

    static /* synthetic */ View access$4100(DialpadFragment r0) {
        return r0.mClassicDialpad;
    }

    static /* synthetic */ FragmentActivity access$4200(DialpadFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ DismissibleClickableView access$4300(DialpadFragment r0) {
        return r0.mDismissibleClickableView;
    }

    static /* synthetic */ LongMenuHelper.MenuType[] access$4400() {
        return sT9CalllogMenuItems;
    }

    static /* synthetic */ LongMenuHelper.MenuType[] access$4500() {
        return sT9ContactMenuItems;
    }

    static /* synthetic */ LongMenuHelper access$4600(DialpadFragment r0) {
        return r0.mLongMenuHelper;
    }

    static /* synthetic */ LongMenuHelper access$4700(DialpadFragment r0) {
        return r0.mLongMenuHelper;
    }

    static /* synthetic */ boolean access$4800(float r0, float r1, View r2) {
        return assertPointInView(r0, r1, r2);
    }

    static /* synthetic */ Handler access$500(DialpadFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ boolean access$600(DialpadFragment r0) {
        return r0.isDigitsEmpty();
    }

    static /* synthetic */ void access$700(DialpadFragment r0) {
        r0.sendMessageToSearch();
    }

    static /* synthetic */ boolean access$900(DialpadFragment r0) {
        return r0.mVisibilityChanged;
    }

    public static void preload() {
        if (sIsTooLate == false) goto L6;
        return;
    L6:
        if (sPreloadMe != null) goto L9;
        sPreloadMe = new DialpadFragment();
        return;
    }

    public static DialpadFragment getPreload() {
        DialpadFragment r0 = sPreloadMe;
        sPreloadMe = null;
        sIsTooLate = true;
        return r0;
    }

    private void preloadRecommendData() {
        final String r1 = "PreloadRecommendData";
        new AnonymousClass1(this, r1).start();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        setObserverToWork(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mHandler.removeMessages(10);
        setDailpadLeftMode(this.mIsDialpadLeftMode);
        DigitsEditText r0 = this.mDigits;
        if (r0 != null) goto L5;
    L7:
        setObserverToWork(false);
        this.mIsLoadingCalls = false;
        this.mNeedReloadData = true;
        this.mRecommendDataLoader.stopLoadRecommendData("Dialpad");
        dismissLongMenu();
        return;
    L5:
        if (r0.isCursorVisible() == false) goto L7;
        this.mDigits.setCursorVisible(false);
        goto L7
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        DSUtils.unregisterDSFeatureStatusListener(this);
    L5:
        DigitsEditText r0 = this.mDigits;
        if (r0 == null) goto L8;
        r0.removeTextChangedListener(this);
        this.mDigits.destroy();
    L8:
        T9Search r1 = this.sT9Search;
        if (r1 == null) goto L11;
        r1.setPrefsCallback(null);
        this.sT9Search.setRegisterLocaleChange(false);
    L11:
        AvatarImageHelper.getIntance().removeAvatarTextFontChangeListener(this);
        this.mRecommendDataLoader.destroy();
        this.mRecommendDataLoader = null;
    }

    static {
        sT9ContactMenuItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_PHONE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_STAR, LongMenuHelper.MenuType.MENU_WECHAT};
        sT9CalllogMenuItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_PHONE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_BLACK, LongMenuHelper.MenuType.MENU_DELETE};
        DEBUG = ContactsUtils.DEBUG;
    }

    private void showListViewWithAnimIfNeed() {
        if (this.mListView.getAlpha() > 0.0f) goto L6;
        this.mListViewAlphaAnimator.start();
        return;
    }

    private void showListViewWithoutAnimIfNeed() {
        if (this.mListView.getAlpha() > 0.0f) goto L6;
        this.mListView.setAlpha(1.0f);
        return;
    }

    private void hideListView() {
        this.mListView.setAlpha(0.0f);
    }

    private void sendMessageToSearch() {
        if (this.mHandler.hasMessages(com.android.contacts.R.id.msg_search) == false) goto L5;
        this.mHandler.removeMessages(com.android.contacts.R.id.msg_search);
    L5:
        this.mHandler.sendEmptyMessage(com.android.contacts.R.id.msg_search);
    }

    private void beginRefreshOptionFrame() {
        if (this.mOptionItems != null) goto L7;
        this.mOptionItems = new ArrayList();
        DialpadOptionItem r0 = new DialpadOptionItem();
        r0.icon = this.mContext.getDrawable(com.android.contacts.R.drawable.icon_item_add_contact);
        r0.describe = this.mContext.getString(com.android.contacts.R.string.t9_add_to_contacts);
        this.mOptionItems.add(r0);
        DialpadOptionItem r1 = new DialpadOptionItem();
        r1.icon = this.mContext.getDrawable(com.android.contacts.R.drawable.icon_item_send_message);
        r1.describe = this.mContext.getString(com.android.contacts.R.string.common_send_sms);
        this.mOptionItems.add(r1);
        if (ContactsUtils.FEATURE_CMCC == false) goto L7;
        DialpadOptionItem r2 = new DialpadOptionItem();
        r2.type = 3;
        r2.icon = this.mContext.getDrawable(com.android.contacts.R.drawable.icon_item_volte_call);
        r2.describe = this.mContext.getString(com.android.contacts.R.string.detail_action_volte);
        this.mOptionItems.add(r2);
    L7:
        String r3 = this.mDigits.getText().toString();
        if ((this.mListView.getAdapter() instanceof DialpadOptionAdapter) == true) goto L10;
        Message r4 = Message.obtain(this.mHandler, 201, r3);
        this.mHandler.removeMessages(201);
        this.mHandler.sendMessageDelayed(r4, 100);
        int r5 = 300;
    L11:
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.startsWith(ContactsUtils.CHAR_POUND) == false) goto L15;
        return;
    L15:
        if (r3.startsWith(ContactsUtils.CHAR_STAR) == false) goto L17;
        return;
    L17:
        if (r3.length() >= 3) goto L19;
        return;
    L19:
        if (ContactsUtils.isFeatureDomestic() == false) goto L26;
        queryPublicNumbers(r3, r5);
        return;
    L26:
        return;
    L10:
        showListViewWithoutAnimIfNeed();
        r5 = 0;
        goto L11
    }

    private void queryPublicNumbers(String r2, final int r3) {
        NumberInfosManager.NumberInfosListenerAdatper r0 = new AnonymousClass5(this, r3);
        NumberInfosManager.getInstance().getBaseAndMarkOfflineAsync(r2, r0);
    }

    private void refreshOptionFrame(Object r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L7;
        return;
    L7:
        if ((r9 instanceof String) == false) goto L10;
        String r10 = (String) r9;
        String r0 = null;
        int r3 = 0;
    L16:
        if (this.mOptionItems.size() != ((ContactsUtils.FEATURE_CMCC ? 1 : 0) + 3)) goto L19;
        this.mOptionItems.remove(0);
    L19:
        if (TextUtils.isEmpty(r0) == true) goto L25;
        DialpadOptionItem r4 = new DialpadOptionItem();
        r4.type = 1;
        if (r3 <= 0) goto L23;
        FragmentActivity r5 = this.mContext;
        Bitmap r6 = NameAvatarController.getCircleBitmap(AvatarImageHelper.getAvatarBitmap(NumberMarkResource.getInstance(this.mContext).getResource(r3), ContactsUtils.dipTopx(r5, r5.getResources().getDimensionPixelSize(com.android.contacts.R.dimen.listview_photo_width))), false);
        r4.drawbleRes = r3;
    L24:
        r4.icon = new BitmapDrawable(this.mContext.getResources(), r6);
        r4.describe = r0;
        r4.detail = r10;
        this.mOptionItems.add(0, r4);
        goto L25
    L23:
        r6 = ContactBadgeUtil.loadDefaultAvatarPhoto(this.mContext, true, false);
    L25:
        T9Search.T9SearchResult r11 = this.mT9Result;
        if (r11 != null) goto L28;
    L32:
        ArrayList r12 = new ArrayList(this.mOptionItems);
        DialpadOptionAdapter r1 = this.mDialpadOptionAdapter;
        if (r1 != null) goto L35;
        this.mDialpadOptionAdapter = new DialpadOptionAdapter(this.mContext, r12);
    L36:
        ListAdapter r13 = this.mListView.getAdapter();
        updateListViewConfig(false);
        if ((r13 instanceof DialpadOptionAdapter) == false) goto L41;
        DialpadOptionAdapter r2 = this.mDialpadOptionAdapter;
        if (r13 != r2) goto L41;
        r2.notifyDataSetChanged();
        return;
    L41:
        this.mListView.setAdapter(this.mDialpadOptionAdapter);
        this.mListView.setScrollEnabled(false);
        this.mForceTouchController.setAdapter(null);
        showListViewWithAnimIfNeed();
        return;
    L35:
        r1.setList(r12);
        goto L36
    L28:
        if (r11.getResults() == null) goto L32;
        if (this.mT9Result.getResults().size() <= 0) goto L32;
        return;
    L10:
        if ((r9 instanceof NumberInfosManager.NumberInfos) == false) goto L44;
        NumberInfosManager.NumberInfos r14 = (NumberInfosManager.NumberInfos) r9;
        r0 = r14.getMark();
        if (TextUtils.isEmpty(r0) == false) goto L14;
        r0 = r14.getName();
    L14:
        r14.getClassifyString();
        r3 = r14.getClassifyDrawableRes();
        r10 = r14.getNumber();
        goto L16
    }

    private void setEmptyView() {
        if (this.mEmptyView != null) goto L6;
        this.mEmptyView = this.mFragmentView.findViewById(R.id.empty);
    L6:
        if (this.mListView.getEmptyView() != null) goto L9;
        this.mListView.setEmptyView(this.mEmptyView);
    L9:
        if (this.mIsPcMode == false) goto L12;
        View r0 = this.mFragmentView.findViewById(com.android.contacts.R.id.black_view);
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) r0.getLayoutParams();
        r1.topMargin = this.mContext.getResources().getDimensionPixelSize(com.android.contacts.R.dimen.dialpad_empty_margin_top_tnt);
        r0.setLayoutParams(r1);
        return;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        updateDigitView(!TextUtils.isEmpty(r1));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r4) {
        if (r4.length() <= 0) goto L6;
        dismissCallSummaryView();
    L6:
        if (this.mIgnoreChange == false) goto L9;
        return;
    L9:
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L12;
        return;
    L12:
        if (SpecialCharSequenceMgr.handleChars(getActivity(), r4.toString(), this.mDigits) == false) goto L14;
        this.mDigits.getText().clear();
    L14:
        int r0 = this.mDigits.length();
        if (r0 != this.mDigits.getSelectionStart()) goto L20;
        if (r0 != this.mDigits.getSelectionEnd()) goto L20;
        this.mDigits.setCursorVisible(false);
    L20:
        if (isDigitsEmpty() == false) goto L23;
        new Handler().post(new AnonymousClass6(this));
        this.mTempStr = "";
    L25:
        this.mDigits.adjustPaddingAndTextSize(r4.toString());
        updateDialAndDeleteButtonEnabledState();
        updateYellowPageState();
        updateSimSwitchViewState(true);
        return;
    L23:
        if (this.mTempStr.equals(this.mDigits.getText().toString().trim()) == true) goto L25;
        this.mTempStr = this.mDigits.getText().toString().trim();
        sendMessageToSearch();
        goto L25
    }

    private void refreshInputTextTimeout(String r3) {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L6;
        r0.removeMessages(11);
        Handler r2 = this.mHandler;
        r2.sendMessageDelayed(r2.obtainMessage(11, r3), 600000);
        return;
    }

    private void removeInputTextTimeout() {
        Handler r1 = this.mHandler;
        if (r1 == null) goto L6;
        r1.removeMessages(11);
        return;
    }

    public void setPrefsCallback(PreferencesCallback r1) {
        this.mPrefsCallback = r1;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.mContext = getActivity();
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.pool = Executors.newSingleThreadExecutor();
        ContactPhotoManager r4 = ContactPhotoManager.getInstance(getActivity());
        this.mPhotoLoader = r4;
        r4.preloadPhotosInBackground();
        T9Search r5 = T9Search.getInstance(getActivity());
        this.sT9Search = r5;
        r5.setPrefsCallback(this.mPrefsCallback);
        this.sT9Search.setRegisterLocaleChange(true);
        this.mRecommendDataLoader = new RecommendDataLoader(this.mContext, this);
        AvatarImageHelper.getIntance().addAvatarTextFontChangeListener(this);
        startCallsQuery();
        this.mIsLoadingCalls = true;
        preloadRecommendData();
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService("keyguard");
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        setHasOptionsMenu(true);
        this.mProhibitedPhoneNumberRegexp = this.mContext.getString(com.android.contacts.R.string.config_prohibited_phone_number_regexp);
        queryLastOutgoingCall();
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        DSUtils.registerDSFeatureStatusListener(this);
    L5:
        setupLongMenu();
        initFrequentRes();
    }

    private void initFrequentRes() {
        Resources r1 = this.mContext.getResources();
        int r0 = r1.getDimensionPixelSize(com.android.contacts.R.dimen.digit_frame_max_height);
        sDigitFrameMaxHeight = r0;
        sDigitFrameMinHeight = r0;
        sDigitTextSizeHint = r1.getDimensionPixelSize(com.android.contacts.R.dimen.digit_edittext_hint);
        sDigitEmptyTextSize = r1.getDimensionPixelSize(com.android.contacts.R.dimen.digit_empty_text_size);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mImportantResource = ImportantResource.getInstance(this.mContext);
        this.mFragmentView = r3.inflate(com.android.contacts.R.layout.dialpad_fragment, r4, false);
        r4.setClipChildren(false);
        r4.setClipToPadding(false);
        QuickContactListView r6 = (QuickContactListView) this.mFragmentView.findViewById(com.android.contacts.R.id.list);
        this.mListView = r6;
        r6.setOnScrollListener(this);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setItemLongClickedListener(this.mItemLongClickedListener);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.mListView, "alpha", new float[]{0.0f, 1.0f});
        this.mListViewAlphaAnimator = r7;
        r7.setDuration(200);
        this.mListViewAlphaAnimator.addListener(new AnonymousClass7(this));
        ForceTouchController r8 = new ForceTouchController(this.mListView, this.mContext);
        this.mForceTouchController = r8;
        this.mListView.setOnTouchListener(r8);
        View r9 = this.mFragmentView.findViewById(com.android.contacts.R.id.bg_container);
        this.mBGView = r9;
        r9.setOnClickListener(new AnonymousClass8(this));
        this.mDigitFrame = (FrameLayout) this.mFragmentView.findViewById(com.android.contacts.R.id.digits_frame);
        DigitsEditText r10 = (DigitsEditText) this.mFragmentView.findViewById(com.android.contacts.R.id.digits);
        this.mDigits = r10;
        CopyTextViewKt.copyPasteActionMode(r10);
        this.mDigits.setFilters(new InputFilter[]{new AnonymousClass9(this)});
        this.mDigits.setKeyListener(DialerKeyListener.getInstance());
        this.mDigits.setOnClickListener(this);
        this.mDigits.setOnKeyListener(this);
        this.mDigits.setOnLongClickListener(this);
        this.mDigits.addTextChangedListener(this);
        updateDigitView(false);
        this.mDigits.setAccessibilityDelegate(new AnonymousClass10(this));
        PhoneNumberFormatter.setPhoneNumberFormattingTextWatcher(getActivity(), this.mDigits);
        this.mDigits.setCursorVisible(false);
        View r11 = this.mFragmentView.findViewById(com.android.contacts.R.id.touchpad);
        this.mTouchpad = r11;
        r11.setOnTouchListener(this);
        if (DEBUG == false) goto L5;
        DisplayMetrics r12 = this.mContext.getResources().getDisplayMetrics();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "The size of fake menu buttons (in pixel): " + (r12.widthPixels / (r12.widthPixels / ((int) (r12.density * 56.0f)))));
    L5:
        initDialpadMode();
        this.sT9Search.setCallback(this.mT9Listener);
        View r13 = ((ViewStub) this.mFragmentView.findViewById(com.android.contacts.R.id.open_call_summary_view)).inflate();
        this.mOpenCallSummaryView = r13;
        r13.setVisibility(8);
        ((ImageView) this.mOpenCallSummaryView.findViewById(com.android.contacts.R.id.iv_info)).setImageDrawable(this.mContext.getDrawable(com.android.contacts.R.drawable.ic_o));
        ((OButton) this.mOpenCallSummaryView.findViewById(com.android.contacts.R.id.call_summary_coach)).setMIcon(this.mContext.getDrawable(com.android.contacts.R.drawable.o_ic_close));
        this.mOpenCallSummaryView.findViewById(com.android.contacts.R.id.okButton).setOnClickListener(new AnonymousClass11(this));
        this.mOpenCallSummaryView.findViewById(com.android.contacts.R.id.call_summary_coach).setOnClickListener(new AnonymousClass12(this));
        OUIConstraintLayout r14 = (OUIConstraintLayout) this.mOpenCallSummaryView.findViewById(com.android.contacts.R.id.call_intelligent_dialog_fragment);
        if (r14 == null) goto L8;
        r14.setChangeAlphaWhenPress(false);
    L8:
        this.mOpenCallSummaryView.setOnClickListener(null);
        return this.mFragmentView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.sT9Search.setCallback(null);
    }

    private void dismissCallSummaryView() {
        if (this.mPrefs.getBoolean("should_show_tutorial_popup", true) == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Change SP_KEY_SHOULD_SHOW_TUTORIAL_POPUP to false");
        this.mPrefs.edit().putBoolean("should_show_tutorial_popup", false).apply();
    L5:
        View r3 = this.mOpenCallSummaryView;
        if (r3 == null) goto L9;
        r3.setVisibility(8);
        return;
    }

    @Override // com.android.contacts.util.AvatarImageHelper.OnAvatarTextFontChangeListener
    public void onAvatarTextFontChanged() {
        this.mHandler.sendEmptyMessage(1000);
    }

    private void registerObserver() {
        if (this.mContactsObserver != null) goto L6;
        final Handler r1 = new Handler();
        this.mContactsObserver = new AnonymousClass13(this, r1);
        this.mContext.getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, this.mContactsObserver);
        return;
    }

    private void unregisterObserver() {
        if (this.mContactsObserver == null) goto L6;
        this.mContext.getContentResolver().unregisterContentObserver(this.mContactsObserver);
        this.mContactsObserver = null;
        return;
    }

    private void setObserverToWork(boolean r2) {
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        registerObserver();
        return;
    L7:
        unregisterObserver();
    }

    @Override // com.android.contacts.activities.DialtactsActivity.OnDBDataChangeListener
    public void onDBDataChanged() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "call log db changed.");
        this.mTmpDataList = null;
        refreshData();
    }

    @Override // com.android.contacts.recommend.RecommendDataLoader.OnRecommendDataLoadListener
    public void onRecommendDataLoaded(List<BaseFlowAdapter.FlowEntry> r3) {
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L5;
        return;
    L5:
        this.mIsLoadingCalls = false;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "On recommend data loaded.");
        updateCallLogList(r3);
    }

    private void updateCallLogList(List<BaseFlowAdapter.FlowEntry> r3) {
        this.mTmpDataList = r3;
        if (this.mAdapter != null) goto L5;
        return;
    L5:
        ContactsUtils.updateDateAndTimeFormat();
        this.mAdapter.setLoading(false);
        this.mAdapter.setData(r3);
        if (r3 != null) goto L8;
    L9:
        setEmptyView();
    L11:
        if (this.mIsLoadingCalls == true) goto L13;
        RecommendUtil.saveRecommendDataToFile(this.mContext, r3);
    L13:
        StringBuilder r0 = new StringBuilder("show recommend data: ");
        if (r3 != null) goto L16;
        Integer r4 = null;
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r0.append(r4).append(", ").append(this.mListView.getAlpha()).toString());
        return;
    L16:
        r4 = Integer.valueOf(r3.size());
        goto L17
    L8:
        if (r3.isEmpty() == false) goto L11;
        goto L9
    }

    private void refreshData() {
        if (this.mProviderIsNormal == true) goto L5;
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "cant refresh data: " + this.mProviderIsNormal);
        return;
    L5:
        if (this.mAdapter == null) goto L15;
        startCallsQuery();
        this.mHandler.sendEmptyMessageDelayed(10, 900);
        if (this.mIsLoadingCalls == false) goto L17;
        List<BaseFlowAdapter.FlowEntry> r0 = this.mTmpDataList;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.isEmpty() == true) goto L19;
        updateCallLogList(this.mTmpDataList);
        return;
    L19:
        return;
    }

    public boolean isSyncActive() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        return false;
    L7:
        return AccountTypeManager.getInstance(r0).isSyncActive();
    }

    private boolean fillDigitsIfNecessary() {
        Intent r0 = getActivity().getIntent();
        boolean r2 = false;
        if (r0 == this.mOldIntent) goto L18;
        String r1 = r0.getAction();
        if ("android.intent.action.DIAL".equals(r1) == false) goto L7;
    L10:
        Uri r3 = r0.getData();
        if (r3 != null) goto L13;
    L17:
        this.mOldIntent = r0;
        goto L18
    L13:
        if (Constants.SCHEME_TEL.equals(r3.getScheme()) == false) goto L17;
        String r4 = r3.getSchemeSpecificPart();
        if (TextUtils.isEmpty(r4) == true) goto L17;
        r2 = true;
        updateDigitView(true);
        hideListView();
        setFormattedDigits(r4, null);
        sendMessageToSearch();
        goto L17
    L7:
        if ("com.android.phone.action.TOUCH_DIALER".equals(r1) == true) goto L10;
        if ("android.intent.action.VIEW".equals(r1) == false) goto L17;
    L18:
        return r2;
    }

    private void setFormattedDigits(String r4, String r5) {
        String r6 = ContactsUtils.formatNumber(r4);
        if (TextUtils.isEmpty(r6) == true) goto L10;
        this.mDigits.dropLastNumber();
        Editable r7 = this.mDigits.getText();
        int r0 = r7.length();
        if (this.mFirstUseAfterColdLaunch == true) goto L8;
        r6 = r6.replaceAll(HanziToPinyin.Token.SEPARATOR, "");
    L8:
        r7.replace(0, r0, r6);
        this.mIsResetLayout = false;
        afterTextChanged(r7);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        ContactsUtils.getCurrentCountryIso(getActivity());
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setScrollEnabled(true);
        this.mListView.setAutoClose(false);
        updateListViewConfig(true);
        this.mListView.setItemsCanFocus(false);
        this.mForceTouchController.setAdapter(this.mAdapter);
    }

    private void updateListViewConfig(boolean r5) {
        QuickContactListView r0 = this.mListView;
        if (r5 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setDivider(new ColorDrawable(r2));
        this.mListView.setDividerHeight(this.mContext.getResources().getDimensionPixelSize(com.android.contacts.R.dimen.divider_height));
        QuickContactListView r1 = this.mListView;
        if (r5 == false) goto L9;
        Drawable r4 = null;
    L10:
        r1.setOverscrollHeader(r4);
        return;
    L9:
        r4 = this.mContext.getDrawable(com.android.contacts.R.drawable.header_line);
        goto L10
    L5:
        r2 = this.mContext.getColor(com.android.contacts.R.color.divider_color);
        goto L6
    }

    private CallLogListItemViews getCallLogListItemView(View r1) {
        if ((r1 instanceof CallLogListItemViews) == false) goto L7;
        return (CallLogListItemViews) r1;
    L7:
        return (CallLogListItemViews) r1.findViewById(com.android.contacts.R.id.primary_action_view);
    }

    private void setupClassicKeypad(View r6) {
        ((ImageView) r6.findViewById(com.android.contacts.R.id.one_classic)).setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_1));
        r6.findViewById(com.android.contacts.R.id.one_frame).setOnTouchListener(this);
        r6.findViewById(com.android.contacts.R.id.one_frame).setOnClickListener(this);
        ((ImageView) r6.findViewById(com.android.contacts.R.id.four_classic)).setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_4));
        r6.findViewById(com.android.contacts.R.id.four_frame).setOnTouchListener(this);
        r6.findViewById(com.android.contacts.R.id.four_frame).setOnClickListener(this);
        ((ImageView) r6.findViewById(com.android.contacts.R.id.seven_classic)).setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_7));
        r6.findViewById(com.android.contacts.R.id.seven_frame).setOnTouchListener(this);
        r6.findViewById(com.android.contacts.R.id.seven_frame).setOnClickListener(this);
        String r0 = getActivity().getString(com.android.contacts.R.string.accessibility_dial_button);
        OButton r1 = (OButton) r6.findViewById(com.android.contacts.R.id.call_classic);
        if (r1 == null) goto L5;
        r1.setMIcon(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_call));
        r1.setOnClickListener(this);
        r1.setContentDescription(r0);
        r1.setOnTouchListener(this);
    L5:
        ((ImageView) r6.findViewById(com.android.contacts.R.id.two_classic)).setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_2));
        r6.findViewById(com.android.contacts.R.id.two_frame).setOnTouchListener(this);
        r6.findViewById(com.android.contacts.R.id.two_frame).setOnClickListener(this);
        ((ImageView) r6.findViewById(com.android.contacts.R.id.five_classic)).setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_5));
        r6.findViewById(com.android.contacts.R.id.five_frame).setOnTouchListener(this);
        r6.findViewById(com.android.contacts.R.id.five_frame).setOnClickListener(this);
        ((ImageView) r6.findViewById(com.android.contacts.R.id.eight_classic)).setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_8));
        r6.findViewById(com.android.contacts.R.id.eight_frame).setOnTouchListener(this);
        r6.findViewById(com.android.contacts.R.id.eight_frame).setOnClickListener(this);
        ImageView r2 = (ImageView) r6.findViewById(com.android.contacts.R.id.zero_classic);
        if (r2 == null) goto L8;
        r2.setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_0));
        r6.findViewById(com.android.contacts.R.id.zero_frame).setOnTouchListener(this);
        r6.findViewById(com.android.contacts.R.id.zero_frame).setOnClickListener(this);
        r6.findViewById(com.android.contacts.R.id.zero_frame).setHapticFeedbackEnabled(false);
    L8:
        ((ImageView) r6.findViewById(com.android.contacts.R.id.three_classic)).setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_3));
        r6.findViewById(com.android.contacts.R.id.three_frame).setOnTouchListener(this);
        r6.findViewById(com.android.contacts.R.id.three_frame).setOnClickListener(this);
        ((ImageView) r6.findViewById(com.android.contacts.R.id.six_classic)).setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_6));
        r6.findViewById(com.android.contacts.R.id.six_frame).setOnTouchListener(this);
        r6.findViewById(com.android.contacts.R.id.six_frame).setOnClickListener(this);
        ((ImageView) r6.findViewById(com.android.contacts.R.id.nine_classic)).setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_9));
        r6.findViewById(com.android.contacts.R.id.nine_frame).setOnTouchListener(this);
        r6.findViewById(com.android.contacts.R.id.nine_frame).setOnClickListener(this);
        OButton r3 = (OButton) r6.findViewById(com.android.contacts.R.id.delete_classic);
        r3.setMIcon(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_delete_left));
        r3.setOnClickListener(this);
        r3.setOnLongClickListener(this);
        r3.setHapticFeedbackEnabled(false);
        r3.setOnTouchListener(this);
        OButton r4 = (OButton) r6.findViewById(com.android.contacts.R.id.star_classic);
        if (r4 == null) goto L11;
        r4.setMIcon(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_asterisk));
        r4.setOnTouchListener(this);
        r4.setOnClickListener(this);
        r4.setHapticFeedbackEnabled(false);
    L11:
        OButton r5 = (OButton) r6.findViewById(com.android.contacts.R.id.pound_classic);
        r5.setMIcon(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_poundsign));
        r5.setOnTouchListener(this);
        r5.setOnClickListener(this);
        r5.setHapticFeedbackEnabled(false);
        OButton r7 = (OButton) r6.findViewById(com.android.contacts.R.id.add_classic);
        if (r7 == null) goto L14;
        this.mBtnAddClassic = r7;
        r7.setOnClickListener(this);
        this.mBtnAddClassic.setOnTouchListener(this);
    L14:
        View r8 = this.mFragmentView.findViewById(com.android.contacts.R.id.delete_classic);
        this.mDeleteClassic = r8;
        if (r8 == null) goto L17;
        r8.setContentDescription(getActivity().getString(com.android.contacts.R.string.common_delete_button));
        this.mDeleteClassic.setOnTouchListener(this);
    L17:
        traversalChildAndSetDelegateIfNecessary(r6);
        View r9 = r6.findViewById(com.android.contacts.R.id.dialpad_classic_layout);
        if ((r9 instanceof DialpadContainer) == false) goto L21;
        ((DialpadContainer) r9).setOnHide(new DialpadFragment$$ExternalSyntheticLambda3(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$setupClassicKeypad$0$com-android-contacts-dialpad-DialpadFragment, reason: not valid java name */
    /* synthetic */ Unit m173x2d87858b() {
        disappearDialpad();
        return null;
    }

    private void initDialpadMode() {
        ViewStub r0 = (ViewStub) this.mFragmentView.findViewById(com.android.contacts.R.id.dialpad_panel_stub);
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "init isSimManualSelectMode = " + DSUtils.isSimManualSelectMode());
    L5:
        r0.setLayoutResource(com.android.contacts.R.layout.dialpad_classic_panel);
        View r1 = r0.inflate();
        this.mClassicDialpad = r1;
        setupClassicKeypad(r1);
        this.mCurrentDialpadPanel = this.mClassicDialpad;
        this.mCurrentDialpadLayoutID = com.android.contacts.R.layout.dialpad_classic_panel;
    }

    private void updateDialpadMode() {
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L5;
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "update isSimManualSelectMode = " + DSUtils.isSimManualSelectMode());
        int r0 = this.mCurrentDialpadLayoutID;
        int r2 = com.android.contacts.R.layout.dialpad_classic_panel;
        if (r0 != com.android.contacts.R.layout.dialpad_classic_panel) goto L9;
        r2 = 0;
    L9:
        if (r2 == 0) goto L12;
        View r1 = replaceCurrentDialpadPanel(r2);
        this.mCurrentDialpadPanel = r1;
        this.mClassicDialpad = r1;
        this.mCurrentDialpadLayoutID = r2;
        setupClassicKeypad(r1);
        return;
    L12:
        if (this.mImportantResource.getDrawableCount() == 0) goto L14;
        return;
    L14:
        if (ContactsUtils.DEBUG == false) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "biu biu --->> reload class pad data" + this.mClassicDialpad);
    L16:
        View r3 = this.mCurrentDialpadPanel;
        if (r3 == null) goto L22;
        setupClassicKeypad(r3);
        return;
    }

    private View replaceCurrentDialpadPanel(int r5) {
        ViewGroup r0 = (ViewGroup) this.mCurrentDialpadPanel.getParent();
        int r1 = r0.indexOfChild(this.mCurrentDialpadPanel);
        r0.removeView(this.mCurrentDialpadPanel);
        View r2 = this.mDialpadLayoutCache.get(Integer.valueOf(r5));
        if (r2 != null) goto L5;
        r2 = this.mContext.getLayoutInflater().inflate(r5, r0, false);
        this.mDialpadLayoutCache.put(Integer.valueOf(r5), r2);
    L5:
        resetDialpad(r2);
        r0.addView(r2, r1);
        return r2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mIsPcMode == false) goto L10;
        if (this.mVisibilityChanged == false) goto L10;
        if (ProductUtils.isSupportDialInExtDisplay() == true) goto L10;
        this.mHandler.postDelayed(new AnonymousClass14(this), 300);
    L10:
        if (DSUtils.isMultiSimEnabled() == false) goto L13;
        DSUtils.registerCallStateChangeListener(this.mPhoneStateListener1);
        DSUtils.registerCallStateChangeListener(this.mPhoneStateListener2);
        onDSFeatureStatusChanged();
    L13:
        if (this.sT9Search == null) goto L15;
        this.mHandler.postDelayed(new AnonymousClass15(this), 500);
    L15:
        boolean r0 = fillDigitsIfNecessary();
        this.isFillDigits = r0;
        boolean r5 = true;
        if (this.mIsResetLayout == false) goto L18;
        new Handler().postDelayed(new AnonymousClass16(this), 300);
    L27:
        StringBuilder r1 = new StringBuilder("registToneGeneratorLock-");
        int r2 = this.mRegisIndex;
        this.mRegisIndex = r2 + 1;
        final String r3 = r1.append(r2).toString();
        new AnonymousClass18(this, r3).start();
        if (this.mDigits.length() == 0) goto L30;
        sendMessageToSearch();
    L30:
        updateDialpadMode();
        updateDialAndDeleteButtonEnabledState();
        updateYellowPageState();
        updateSimSwitchViewState(false);
        this.mFirstUseAfterColdLaunch = false;
        if (this.mDigits.length() != 0) goto L34;
        if (r5 == false) goto L34;
        tryToShowOpenCallSummaryView();
    L34:
        Function0 r4 = this.mShowClipPopupWindowRunnable;
        if (r4 == null) goto L38;
        r4.invoke();
        this.mShowClipPopupWindowRunnable = null;
        return;
    L38:
        return;
    L18:
        if (r0 == true) goto L27;
        final String r6 = getDialpadNumber();
        if (this.mDigits.isStateNumber() == false) goto L27;
        if (TextUtils.isEmpty(r6) == true) goto L27;
        updateDigitView(true);
        if ((this.mListView.getAdapter() instanceof FlowAdapter) == false) goto L26;
        hideListView();
    L26:
        this.mHandler.postDelayed(new AnonymousClass17(this, r6), TIME_DELAED_AFTER_NUMBER_FORMAT);
        r5 = false;
        goto L27
    }

    public void setLastNumberDialed(String r1) {
        this.mLastNumberDialed = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        T9Search r0 = this.sT9Search;
        if (r0 == null) goto L5;
        r0.setRegisterContentObserverChange(false);
    L5:
        final String r1 = "unregistToneGeneratorLock-" + this.mRegisIndex;
        new AnonymousClass19(this, r1).start();
        if (this.mIsResetLayout == false) goto L9;
        setDialpadNumber(null, 0);
    L11:
        QuickContactListView r2 = this.mListView;
        if (r2 == null) goto L14;
        r2.hideQuickContact();
    L14:
        setDailpadLeftMode(this.mIsDialpadLeftMode);
        if (DSUtils.isMultiSimEnabled() == false) goto L17;
        DSUtils.unregisterCallStateChangeListener(this.mPhoneStateListener1);
        DSUtils.unregisterCallStateChangeListener(this.mPhoneStateListener2);
    L17:
        ((SimSwitchView) this.mFragmentView.findViewById(com.android.contacts.R.id.switch_sim)).dismissPopupWindow();
        return;
    L9:
        if (this.mDigits.isStateNumber() == false) goto L11;
        setDialpadNumber(this.mDigits.getText().toString(), System.currentTimeMillis());
        goto L11
    }

    public void startCallsQuery() {
        StringBuilder r0 = new StringBuilder("start call query: isloading=").append(this.mIsLoadingCalls).append(", mFirstLoad=").append(this.mFirstLoad).append(", mNeedReloadData=").append(this.mNeedReloadData).append(", ");
        List<BaseFlowAdapter.FlowEntry> r1 = this.mTmpDataList;
        if (r1 != null) goto L5;
        Integer r2 = null;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r0.append(r2).toString());
        if (this.mIsLoadingCalls == false) goto L9;
        return;
    L9:
        FragmentActivity r3 = this.mContext;
        if (r3 != null) goto L12;
    L27:
        log("Activity destroyed, stop calls query here.");
        return;
    L12:
        if (r3.isDestroyed() == true) goto L27;
        if (this.mTmpDataList != null) goto L17;
    L22:
        this.mFirstLoad = false;
        FlowAdapter r4 = this.mAdapter;
        if (r4 == null) goto L25;
        r4.setLoading(true);
    L25:
        this.mRecommendDataLoader.loadRecommendData(true);
        return;
    L17:
        if (this.mFirstLoad == true) goto L22;
        this.mHandler.post(new AnonymousClass22(this));
        if (this.mNeedReloadData == true) goto L21;
        return;
    L21:
        this.mNeedReloadData = false;
        goto L22
    L5:
        r2 = Integer.valueOf(r1.size());
        goto L6
    }

    private void removeMissedCallNotifications() {
        new Thread(new AnonymousClass23(this)).start();
    }

    private void updateVoicemailNotifications() {
        if (getActivity() == null) goto L6;
        Intent r0 = new Intent(getActivity(), CallLogNotificationsService.class);
        r0.setAction(CallLogNotificationsService.ACTION_UPDATE_NOTIFICATIONS);
        getActivity().startService(r0);
        return;
    }

    public void searchContacts() {
        Editable r0 = this.mDigits.getText();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() < 0) goto L40;
        String r1 = this.mDigits.getText().toString();     // Catch: Exception -> L9
    L12:
        if (TextUtils.isEmpty(r1) == false) goto L14;
        int r2 = 0;
    L15:
        if (r2 <= 0) goto L26;
        T9Search r3 = this.sT9Search;
        if (r3 == null) goto L34;
        T9Search.T9SearchResult r4 = r3.search(r1);
        this.mT9Result = r4;
        if (r4 != null) goto L21;
        this.mHandler.sendEmptyMessage(com.android.contacts.R.id.msg_setoptionframe_visible);
        return;
    L21:
        if (this.mT9Adapter != null) goto L23;
        T9Search.T9Adapter r5 = this.sT9Search.getT9Adapter(this.mContext, r4.getResults());
        this.mT9Adapter = r5;
        r5.setQuickContactListener(this.mListView);
        this.mT9Adapter.setListView(this.mListView);
        this.mHandler.sendEmptyMessage(com.android.contacts.R.id.msg_set_t9adapter);
        return;
    L23:
        this.mHandler.sendEmptyMessage(com.android.contacts.R.id.msg_addresult_to_t9adapter);
        return;
    L34:
        return;
    L26:
        if (this.mT9Adapter != null) goto L28;
        return;
    L28:
        if (this.isT9on == false) goto L39;
        this.mHandler.sendEmptyMessage(com.android.contacts.R.id.msg_reset_dialpad);
        return;
    L39:
        return;
    L14:
        r2 = r1.length();
    L9:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L12
    }

    private boolean dialOnTap() {
        return PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("t9_dial_onclick", false);
    }

    private boolean isDialpadLeftMode() {
        if (Settings.Global.getInt(getActivity().getContentResolver(), "contacts_dialpad_left_mode", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setDailpadLeftMode(boolean r2) {
        Settings.Global.putInt(getActivity().getContentResolver(), "contacts_dialpad_left_mode", r2 ? 1 : 0);
    }

    private void setDialpadNumber(String r1, long r2) {
        SharedPreferences.Editor r0 = this.mPrefs.edit();
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r1 = "";
    L5:
        r0.putString("dialpad_number", r1);
        r0.apply();
    }

    private boolean getLastOneHandModeLeft() {
        return this.mPrefs.getBoolean("pref_last_dialpad_left_mode", false);
    }

    private void setLastOneHandModeLeft(boolean r2) {
        SharedPreferences.Editor r1 = this.mPrefs.edit();
        r1.putBoolean("pref_last_dialpad_left_mode", r2);
        r1.apply();
    }

    private void keyPressed(int r5) {
        this.mDigits.dropLastNumber();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "keyPressed: " + r5 + SimContactsConstants.EMAIL_SEP + this.mDigits.getText());
        if (r5 != 67) goto L5;
    L7:
        if (r5 == 67) goto L9;
    L13:
        this.mDigits.onKeyDown(r5, new KeyEvent(0, r5));
        return;
    L9:
        if (isDigitsEmpty() == true) goto L13;
        if (this.mDigits.getText().length() != 1) goto L13;
        setDigitHint(false);
        hideListView();
        goto L13
    L5:
        if (isDigitsEmpty() == false) goto L7;
        updateDigitView(true);
        hideListView();
        goto L13
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r1, int r2, KeyEvent r3) {
        if (r1.getId() == com.android.contacts.R.id.digits) goto L6;
        return false;
    L6:
        if (r2 != 66) goto L9;
        dialButtonPressed();
        return true;
    L9:
        sendMessageToSearch();
        return false;
    }

    private void updateUsualDialPadPadding(boolean r5) {
        int r0 = ContactsUtils.dipTopx(getContext(), 20.0d);
        int r1 = ContactsUtils.dipTopx(getContext(), 8.0d);
        if (r5 == false) goto L5;
        View r6 = this.mDialpadUsual;
        r6.setPadding(r0, r6.getPaddingTop(), r1, this.mDialpadUsual.getPaddingBottom());
        View r7 = this.mDialpadUnusualRight;
        r7.setPadding(r7.getPaddingLeft(), this.mDialpadUnusualRight.getPaddingTop(), r0, this.mDialpadUnusualRight.getPaddingBottom());
        return;
    L5:
        View r8 = this.mDialpadUsual;
        r8.setPadding(r1, r8.getPaddingTop(), r0, this.mDialpadUsual.getPaddingBottom());
        View r9 = this.mDialpadUnusualLeft;
        r9.setPadding(r0, r9.getPaddingTop(), this.mDialpadUnusualLeft.getPaddingRight(), this.mDialpadUnusualLeft.getPaddingBottom());
    }

    private void updateUsualDialPadBackground(boolean r2) {
        if (r2 == false) goto L4;
        this.mDialpadUsual.setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_table_bg_left));
        return;
    L4:
        this.mDialpadUsual.setBackground(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_table_bg_right));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        switch(r2.getId()) {
            case 2131361949: goto L18;
            case 2131361952: goto L15;
            case 2131362193: goto L13;
            case 2131362469: goto L11;
            case 2131362472: goto L11;
            case 2131362526: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        int r3 = this.mDigits.length();
        DigitsEditText r0 = this.mDigits;
        if (r3 == 0) goto L8;
        boolean r4 = true;
    L9:
        r0.setCursorVisible(r4);
        showDialpad();
        return;
    L8:
        r4 = false;
        goto L9
    L11:
        keyPressed(67);
        return;
    L13:
        dialButtonPressed();
        return;
    L15:
        goToAddContact();
        return;
    L18:
        if (isDigitsEmpty() == true) goto L20;
        goToAddContact();
        return;
    L20:
        disappearDialpad();
    }

    private void goToAddContact() {
        if (isDigitsEmpty() == false) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L9;
        Intent r0 = ContactsIntentUtils.getAddToContactIntent(this.mDigits.getText(), "call_log_add");
        AnimationUtil.startActivityWithAnimExtra(getActivity(), r0, 1, 2);
        return;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r6) {
        Editable r0 = this.mDigits.getText();
        int r7 = r6.getId();
        boolean r2 = true;
        if (r7 == com.android.contacts.R.id.delete) goto L16;
        if (r7 == com.android.contacts.R.id.delete_classic) goto L16;
        if (r7 == com.android.contacts.R.id.digits) goto L9;
        return false;
    L9:
        int r8 = this.mDigits.length();
        DigitsEditText r5 = this.mDigits;
        if (r8 != 0) goto L13;
        r2 = false;
    L13:
        r5.setCursorVisible(r2);
        return false;
    L16:
        if (DEBUG == false) goto L21;
        if (r0 == null) goto L19;
        String r9 = r0.toString();
    L20:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onLongClick with delete key , with digits:" + r9);
        goto L21
    L19:
        r9 = "";
    L21:
        this.mDigits.setCursorVisible(false);
        if (isDigitsEmpty() == true) goto L24;
        setDigitHint(false);
        hideListView();
    L24:
        if (r0 == null) goto L26;
        r0.clear();
    L26:
        return true;
    }

    private void updateDigitView(boolean r5) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mDigitFrame.getLayoutParams();
        int r1 = 0;
        if (r5 == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        int r2 = sDigitFrameMaxHeight;
    L13:
        if (r0.height == r2) goto L15;
        r0.height = r2;
        this.mDigitFrame.setLayoutParams(r0);
    L15:
        setDigitHint(false);
        if (r6 == true) goto L19;
        r1 = 8;
    L19:
        View r3 = this.mBGView;
        if (r3 != null) goto L22;
        return;
    L22:
        if (r3.getVisibility() == r1) goto L31;
        if (r6 == false) goto L25;
        String r7 = "show";
    L27:
        if (OEAAnimKt.animTransit((ViewGroup) this.mBGView, r7, new AnonymousClass24(this)) == false) goto L32;
        this.mBGView.setVisibility(r1);
        return;
    L32:
        return;
    L25:
        r7 = "hide";
        goto L27
    L31:
        return;
    L11:
        r2 = sDigitFrameMinHeight;
        goto L13
    L5:
        if (this.mDigits.isTailNumber() == true) goto L8;
        r6 = false;
        goto L9
    }

    private void setDigitHint(boolean r8) {
        if (r8 == false) goto L4;
        SpannableString r9 = new SpannableString(getText(com.android.contacts.R.string.digit_input_hint));
        r9.setSpan(new TextAppearanceSpan(null, 0, sDigitTextSizeHint, null, null), 0, r9.length(), 18);
        this.mDigits.setHint(r9);
        return;
    L4:
        this.mDigits.setHint(null);
    }

    public void resetDialpad() {
        updateDigitView(false);
        View r1 = this.mDelete;
        if (r1 == null) goto L5;
        r1.setPressed(false);
    L5:
        View r2 = this.mDeleteClassic;
        if (r2 == null) goto L8;
        r2.setPressed(false);
    L8:
        updateListViewConfig(true);
        if ((this.mListView.getAdapter() instanceof FlowAdapter) == false) goto L11;
        this.mAdapter.notifyDataSetChanged();
    L12:
        this.mListView.setAutoClose(false);
        this.mListView.restoreScrollState(false);
        showListViewWithoutAnimIfNeed();
        if (this.mListView.getVisibility() != 8) goto L15;
        this.mListView.setVisibility(0);
    L15:
        dismissLongMenu();
        return;
    L11:
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setScrollEnabled(true);
        this.mForceTouchController.setAdapter(this.mAdapter);
        goto L12
    }

    public void callVoicemail() {
        if (ContactsUtils.isNoSim(this.mContext) == false) goto L7;
        ContactsApplication.showToast(com.android.contacts.R.string.no_sim_voice_mail_toast, 1);
        return;
    L7:
        if (DSUtils.useDSFeature() == false) goto L10;
        FragmentActivity r0 = this.mContext;
        ContactsUtils.showSelectSimDialog(r0, r0.getString(com.android.contacts.R.string.common_voice_mail), null, 3);
    L14:
        this.mDigits.getText().clear();
        return;
    L10:
        if (TextUtils.isEmpty(ContactsUtils.getVoiceNumber()) == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "callVoicemail but voicemail number is empty");
        showMissingVoicemailErrorDialog(DSUtils.getDefaultCallSim());
        return;
    L13:
        DSUtils.callVoicemail(this.mContext, -1);
        goto L14
    }

    private void showMissingVoicemailErrorDialog(final int r3) {
        dismissPendingDialogs();
        OAlertDialog r4 = (OAlertDialog) new OAlertDialogBuilder(this.mContext).title(com.android.contacts.R.string.no_vm_number).message(com.android.contacts.R.string.no_vm_number_msg).negativeButton(com.android.contacts.R.string.no_vm_negative_btn, new DialpadFragment$$ExternalSyntheticLambda0(this, r3)).positiveButton(com.android.contacts.R.string.no_vm_positive_btn, new DialpadFragment$$ExternalSyntheticLambda1(this)).onCancel(new DialpadFragment$$ExternalSyntheticLambda2(this)).build();
        this.mDialog = r4;
        r4.show();
    }

    /* JADX INFO: renamed from: lambda$showMissingVoicemailErrorDialog$1$com-android-contacts-dialpad-DialpadFragment, reason: not valid java name */
    /* synthetic */ void m174x6a21ccdd(int r1, DialogInterface r2, int r3) {
        addVoiceMailNumberPanel(r1);
    }

    /* JADX INFO: renamed from: lambda$showMissingVoicemailErrorDialog$2$com-android-contacts-dialpad-DialpadFragment, reason: not valid java name */
    /* synthetic */ void m175x23995a7c(DialogInterface r1, int r2) {
        onDialogDismissed();
    }

    /* JADX INFO: renamed from: lambda$showMissingVoicemailErrorDialog$3$com-android-contacts-dialpad-DialpadFragment, reason: not valid java name */
    /* synthetic */ void m176xdd10e81b(DialogInterface r1) {
        onDialogDismissed();
    }

    private void onDialogDismissed() {
        this.mDialog = null;
    }

    public void dismissPendingDialogs() {
        OAlertDialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.mDialog = null;
        return;
    }

    private void addVoiceMailNumberPanel(int r4) {
        log("show vm setting");
        Intent r0 = new Intent("com.android.phone.CallFeaturesSetting.ADD_VOICEMAIL");
        r0.setClassName(TelephonySmt.DEFAULT_NOTIFICATION_PACKAGE_NAME, "com.bytedanceos.phone.settings.settings.VoiceMailSetting");
        r0.putExtra("slot", r4);
        startActivity(r0);
    }

    private void processDialButtonPressed(int r7) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("Contacts", "dialpad pressed. " + isDigitsEmpty());
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_CALL_BUTTON);
        this.mDigits.dropLastNumber();
        if (isDigitsEmpty() == true) goto L5;
        String r0 = this.mDigits.getText().toString();
        this.mLastNumberDialed = r0;
        if (ContactsUtils.isJustClicked() == false) goto L16;
    L35:
        AnimationUtil.switchActivityAnimation(getActivity(), 0);
        return;
    L16:
        if (r0 == null) goto L28;
        if (TextUtils.isEmpty(this.mProhibitedPhoneNumberRegexp) == true) goto L28;
        if (r0.matches(this.mProhibitedPhoneNumberRegexp) == false) goto L28;
        if (SystemProperties.getInt("persist.radio.otaspdial", 0) == 1) goto L28;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "The phone number is prohibited explicitly by a rule.");
        if (getActivity() == null) goto L26;
        ErrorDialogFragment.newInstance(com.android.contacts.R.string.dialog_phone_call_prohibited_title).show(getParentFragmentManager(), "phone_prohibited_dialog");
    L26:
        this.mDigits.getText().clear();
    L28:
        if (r7 == (-1)) goto L30;
        Intent r8 = DSUtils.getCallIntent(this.mContext, r0, r7, true);
    L32:
        if ((getActivity() instanceof DialtactsActivity) == false) goto L34;
        r8.putExtra("com.android.phone.CALL_ORIGIN", "com.android.contacts.activities.DialtactsActivity");
    L34:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("Contacts", "start call!");
        startActivity(r8);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
        this.mIsResetLayout = true;
        goto L35
    L30:
        r8 = ContactsIntentUtils.newDialNumberIntent(r0, true);
        goto L32
    L5:
        if (phoneIsCdma() == false) goto L10;
        if (isPhoneInUse() == false) goto L10;
        startActivity(newFlashIntent());
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
        return;
    L10:
        if (TextUtils.isEmpty(this.mLastNumberDialed) == true) goto L12;
        this.mDigits.setText(this.mLastNumberDialed.replaceAll("[- ()]", ""));
        DigitsEditText r9 = this.mDigits;
        r9.setSelection(r9.getText().length());
        sendMessageToSearch();
        return;
    L12:
        playTone(26);
    }

    public void dialButtonPressed() {
        int r1 = -1;
        if (DSUtils.isSimManualSelectMode() == false) goto L19;
        if (isDigitsEmpty() == false) goto L8;
        processDialButtonPressed(-1);
        return;
    L8:
        View r0 = this.mCurrentDialpadPanel;
        if (r0 != null) goto L12;
        r0 = this.mClassicDialpad;
    L12:
        if (r0 != null) goto L14;
        return;
    L14:
        View r2 = ViewUtilsKt.findView(r0, new int[]{com.android.contacts.R.id.dialpad_classic_layout, com.android.contacts.R.id.call_classic});
        if (r2 == null) goto L17;
        r0 = r2;
    L17:
        final ArrayList r3 = Lists.newArrayList(new PopMenuItem[]{new PopMenuItem(0, com.android.contacts.R.drawable.sim_1_icon, DSUtils.getOperatorNameBySimSlotId(0), DSUtils.getSimNumber(r0.getContext(), 0)), new PopMenuItem(1, com.android.contacts.R.drawable.sim_2_icon, DSUtils.getOperatorNameBySimSlotId(1), DSUtils.getSimNumber(r0.getContext(), 1))});
        this.mSimSelectPopMenu.setWidth(OUnitExtensionKt.dp2px(BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND));
        this.mSimSelectPopMenu.show(r0, r3, new DialpadFragment$$ExternalSyntheticLambda4(this, r3));
        return;
    L19:
        if (DSUtils.useDSFeature() == false) goto L21;
        r1 = ((SimSwitchView) this.mFragmentView.findViewById(com.android.contacts.R.id.switch_sim)).getCurrentSim();
    L21:
        processDialButtonPressed(r1);
    }

    /* JADX INFO: renamed from: lambda$dialButtonPressed$4$com-android-contacts-dialpad-DialpadFragment, reason: not valid java name */
    /* synthetic */ Unit m172x8f428c8a(List r1, Integer r2) {
        processDialButtonPressed(((PopMenuItem) r1.get(r2.intValue())).getId());
        return null;
    }

    public void dialButtonPressed(int r1) {
        processDialButtonPressed(r1);
    }

    void playTone(final int r5) {
        if (ContactsUtils.USER_LOG_ON == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Dialpad playTone: tone=" + r5 + ", mDTMFToneEnabled=" + this.mDTMFToneEnabled);
    L5:
        boolean r3 = true;
        if (Settings.System.getInt(this.mContext.getContentResolver(), "dtmf_tone", 1) == 1) goto L9;
        r3 = false;
    L9:
        this.mDTMFToneEnabled = r3;
        if (r3 == true) goto L13;
        return;
    L13:
        if (ContactsUtils.USER_LOG_ON == false) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "playTone got ringer mode 2");
    L15:
        Object r1 = this.mToneGeneratorLock;
        monitor-enter(r1);
    L30:
        th = move-exception;
        throw th;
    L18:
        if (this.mToneGenerator != null) goto L23;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "playTone: mToneGenerator == null, tone: " + r5);     // Catch: Throwable -> L30
        monitor-exit(r1);     // Catch: Throwable -> L30
        return;
    L23:
        if (ContactsUtils.USER_LOG_ON == false) goto L25;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "playTone start...");     // Catch: Throwable -> L30
    L25:
        Executors.newSingleThreadExecutor().execute(new AnonymousClass25(this, r5));     // Catch: Throwable -> L30
        if (ContactsUtils.USER_LOG_ON == false) goto L28;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "playTone done...");     // Catch: Throwable -> L30
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L30
    }

    private void dialClickedNumber(String r3, boolean r4) {
        if (DSUtils.isSimManualSelectMode() == false) goto L6;
        ContactsUtils.showSelectSimDialog(this.mContext, null, r3, 1, r4);
        return;
    L6:
        if (DSUtils.useDSFeature() == false) goto L8;
        SimSwitchView r5 = (SimSwitchView) this.mFragmentView.findViewById(com.android.contacts.R.id.switch_sim);
        Intent r6 = DSUtils.getCallIntent(this.mContext, r3, r5.getCurrentSim());
    L9:
        startActivity(r6);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
        AnimationUtil.switchActivityAnimation(getActivity(), 0);
        return;
    L8:
        r6 = ContactsIntentUtils.newDialNumberIntent(r3, r4);
        goto L9
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r3, View r4, int r5, long r6) {
        if ((this.mListView.getAdapter() instanceof T9Search.T9Adapter) == false) goto L11;
        ContactItem r7 = this.mT9Adapter.getItem(r5);
        this.mLastNumberDialed = r7.number;
        if (r7.id <= 0) goto L7;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_CALL_SEARCH_RESULT_CONTACT);
    L8:
        dialClickedNumber(this.mLastNumberDialed, !r7.hasname);
        this.mIsResetLayout = true;
        return;
    L7:
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_CALL_SEARCH_RESULT_CALL_LOG);
        goto L8
    L11:
        if ((this.mListView.getAdapter() instanceof DialpadOptionAdapter) == false) goto L31;
        Editable r8 = this.mDigits.getText();
        if (TextUtils.isEmpty(r8) == false) goto L15;
        return;
    L15:
        int r9 = this.mListView.getAdapter().getCount() - r5;
        if (ContactsUtils.FEATURE_CMCC == false) goto L18;
        r9 = r9 - 1;
    L18:
        if (r9 == 0) goto L28;
        if (r9 != 1) goto L21;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_SEND_MMS);
        startActivity(ContactsIntentUtils.getSendMessageIntent(r8));
        AnimationUtil.switchActivityAnimation(getActivity(), 1);
        return;
    L21:
        if (r9 != 2) goto L23;
        AnimationUtil.startActivityWithAnimExtra(getActivity(), ContactsIntentUtils.getAddToContactIntent(r8, "dialpad"), 1, 2);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
        return;
    L23:
        if (r9 != 3) goto L42;
        dialClickedNumber(r8.toString(), true);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
        this.mIsResetLayout = true;
        return;
    L42:
        return;
    L28:
        startActivity(ContactsIntentUtils.newDialVoltePhoneIntent("" + r8));
        AnimationUtil.switchActivityAnimation(getActivity(), 1);
        return;
    L31:
        if ((this.mListView.getAdapter() instanceof CallLogAdapter) == false) goto L43;
        Object r10 = r4.getTag();
        if ((r10 instanceof View.OnClickListener) == false) goto L37;
        View.OnClickListener r11 = (View.OnClickListener) r10;
        CallLogListItemViews r12 = getCallLogListItemView(r4);
        if (r12 == null) goto L37;
        r11.onClick(r12.primaryActionView);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
    L37:
        this.mIsResetLayout = true;
        return;
    }

    private boolean phoneIsCdma() {
        ITelephony r0 = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));     // Catch: RemoteException -> L9
        if (r0 == null) goto L14;
        if (r0.getActivePhoneType() != 2) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "phone.getActivePhoneType() failed", e);
        return false;
    }

    private boolean isPhoneInUse() {
        if (getContext() != null) goto L5;
    L7:
        return false;
    L5:
        if (TelecomUtil.isInManagedCall(getContext()) == false) goto L7;
        return true;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem r1) {
        return onOptionsItemSelected(r1);
    }

    private void updateDialString(String r5) {
        int r0 = this.mDigits.getSelectionStart();
        int r1 = this.mDigits.getSelectionEnd();
        int r2 = Math.min(r0, r1);
        int r3 = Math.max(r0, r1);
        Editable r4 = this.mDigits.getText();
        if (r2 == (-1)) goto L7;
        if (r2 != r3) goto L6;
        r4.replace(r2, r2, r5);
        return;
    L6:
        r4.replace(r2, r3, r5);
        this.mDigits.setSelection(r2 + 1);
        return;
    L7:
        int r6 = this.mDigits.length();
        r4.replace(r6, r6, r5);
    }

    private void updateDialAndDeleteButtonEnabledState() {
        boolean r0 = !isDigitsEmpty();
        View r1 = this.mDelete;
        if (r1 == null) goto L5;
        r1.setEnabled(r0);
    L5:
        View r2 = this.mDeleteClassic;
        if (r2 == null) goto L9;
        r2.setEnabled(r0);
        return;
    }

    private void updateYellowPageState() {
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L5;
        return;
    L5:
        boolean r0 = isDigitsEmpty();
        OButton r1 = this.mBtnAddClassic;
        if (r1 == null) goto L11;
        if (r0 == true) goto L9;
        r1.setMIcon(this.mContext.getDrawable(com.android.contacts.R.drawable.o_dial_btn_add));
        this.mBtnAddClassic.setMImageTintColorId(0);
        this.mBtnAddClassic.setContentDescription(this.mContext.getString(com.android.contacts.R.string.accessibility_dialpad_add));
        return;
    L9:
        r1.setMIcon(this.mContext.getDrawable(com.android.contacts.R.drawable.ic_dialpad_icon));
        this.mBtnAddClassic.setContentDescription("");
        return;
    }

    private void updateSimSwitchViewState(boolean r4) {
        if (UiUtils.isUiFinishing(getActivity()) == false) goto L5;
        return;
    L5:
        boolean r5 = isDigitsEmpty();
        SimSwitchView r0 = (SimSwitchView) this.mFragmentView.findViewById(com.android.contacts.R.id.switch_sim);
        OButton r1 = (OButton) this.mFragmentView.findViewById(com.android.contacts.R.id.add_or_yellow_page_btn);
        r1.setOnClickListener(this);
        r1.setOnTouchListener(this);
        r1.setVisibility(8);
        if (DSUtils.useDSFeature() == false) goto L16;
        if (r5 == true) goto L16;
        if (DSUtils.isSimManualSelectMode() == true) goto L16;
        if (r0.getVisibility() == 0) goto L14;
        r0.setCurrentSim(getDefaultSimSlotId());
        r0.setVisibility(0);
        return;
    L14:
        if (DSUtils.getCallingSim(getContext()) < 0) goto L19;
        r0.setCurrentSim(getDefaultSimSlotId());
        return;
    L19:
        return;
    L16:
        r0.setVisibility(8);
    }

    private boolean isDigitsEmpty() {
        if (this.mDigits.getText().length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void queryLastOutgoingCall() {
        this.mLastNumberDialed = "";
        CallLogAsync.GetLastOutgoingCallArgs r0 = new CallLogAsync.GetLastOutgoingCallArgs(getActivity(), new AnonymousClass26(this));
        this.mCallLog.getLastOutgoingCall(r0);
    }

    private Intent newFlashIntent() {
        Intent r2 = ContactsIntentUtils.newDialNumberIntent("");
        r2.putExtra("com.android.phone.extra.SEND_EMPTY_FLASH", true);
        return r2;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ViewPagerVisibilityListener
    public void onVisibilityChanged(boolean r3) {
        if (this.mVisibilityChanged == r3) goto L36;
        T9Search r0 = this.sT9Search;
        if (r0 == null) goto L8;
        r0.setRegisterContentObserverChange(r3);
    L8:
        if (r3 == true) goto L20;
        this.pool.shutdown();
        QuickContactListView r1 = this.mListView;
        if (r1 != null) goto L12;
    L14:
        DigitsEditText r2 = this.mDigits;
        if (r2 != null) goto L17;
    L19:
        dismissLongMenu();
    L21:
        if (r3 == false) goto L31;
        if (isResumed() == false) goto L31;
        refreshData();
        T9Search r4 = this.sT9Search;
        if (r4 == null) goto L31;
        r4.refresh();     // Catch: InterruptedException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L31:
        if (this.mIsPcMode == false) goto L36;
        if (r3 == false) goto L36;
        if (ProductUtils.isSupportDialInExtDisplay() == true) goto L36;
        ContactsApplication.showToast(com.android.contacts.R.string.revone_dial_function, 0);
        goto L36
    L17:
        if (r2.isCursorVisible() == false) goto L19;
        this.mDigits.setCursorVisible(false);
        goto L19
    L12:
        if (r1.isShowQuickContact() == false) goto L14;
        this.mListView.hideQuickContact();
        goto L14
    L20:
        this.pool = Executors.newSingleThreadExecutor();
    L36:
        this.mVisibilityChanged = r3;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r2, int r3) {
        if (this.isT9on == true) goto L8;
        if (r3 != 1) goto L8;
        disappearDialpad();
    L8:
        if ((this.mListView.getAdapter() instanceof T9Search.T9Adapter) == false) goto L10;
        ((T9Search.T9Adapter) this.mListView.getAdapter()).setListViewScrollState(r3);
    L10:
        if (r3 != 0) goto L12;
        this.mPhotoLoader.resume();
        ContactDetailCacheManager.getInstance().refreshCache(r2);
        return;
    L12:
        this.mPhotoLoader.pause();
    }

    private static boolean assertPointInView(float r4, float r5, View r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        int r1 = r6.getHeight();
        int r7 = r6.getWidth();
        if (r4 >= 0.0f) goto L8;
        return false;
    L8:
        if (r4 <= r7) goto L10;
        return false;
    L10:
        if (r5 >= 0.0f) goto L12;
        return false;
    L12:
        if (r5 > r1) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r14, MotionEvent r15) {
        int r0 = r15.getActionMasked();
        if (r0 == 0) goto L25;
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L8;
        if (r0 == 3) goto L9;
    L83:
        return false;
    L8:
        float r1 = r15.getX();
        float r16 = r15.getY();
        KeyTask.access$3400(this.mKeyTask, r14, r1, r16);
    L9:
        KeyTask.access$3500(this.mKeyTask, r14, r0);
        if (this.mLongClickHandler.hasMessages(0) == false) goto L13;
        this.mLongClickHandler.removeMessages(0);
    L13:
        if (this.mLongClickHandler.hasMessages(2) == false) goto L16;
        this.mLongClickHandler.removeMessages(2);
    L16:
        if (this.mLongClickHandler.hasMessages(1) == false) goto L19;
        this.mLongClickHandler.removeMessages(1);
    L19:
        if (this.mLongClickHandler.hasMessages(3) == false) goto L22;
        this.mLongClickHandler.removeMessages(3);
    L22:
        if (this.mLongClickHandler.hasMessages(4) == false) goto L83;
        this.mLongClickHandler.removeMessages(4);
        goto L83
    L25:
        if (this.isT9on == false) goto L27;
        showDialpad();
        goto L83
    L27:
        float r7 = r15.getX();
        float r8 = r15.getY();
        switch(r14.getId()) {
            case 2131362586: goto L79;
            case 2131362654: goto L75;
            case 2131362684: goto L71;
            case 2131363150: goto L67;
            case 2131363222: goto L59;
            case 2131363310: goto L55;
            case 2131363573: goto L51;
            case 2131363603: goto L47;
            case 2131363647: goto L43;
            case 2131363789: goto L39;
            case 2131363912: goto L35;
            case 2131364005: goto L31;
            default: goto L82;
        };
    L82:
        showVibrator();
        goto L83
    L31:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 0, 7);
        this.mLongClickHandler.sendEmptyMessageDelayed(0, 500);
        goto L82
    L35:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 2, 9);
        sendSpeedDialMessage(r14.getId());
        goto L82
    L39:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 3, 10);
        sendSpeedDialMessage(r14.getId());
        goto L82
    L43:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 10, 17);
        this.mLongClickHandler.sendEmptyMessageDelayed(1, 500);
        goto L82
    L47:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 6, 13);
        sendSpeedDialMessage(r14.getId());
        goto L82
    L51:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 7, 14);
        sendSpeedDialMessage(r14.getId());
        goto L82
    L55:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 11, 18);
        this.mLongClickHandler.sendEmptyMessageDelayed(2, 500);
        goto L82
    L59:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 1, 8);
        if (isDigitsEmpty() == false) goto L64;
    L65:
        this.mLongClickHandler.sendEmptyMessageDelayed(3, 500);
        goto L82
    L64:
        if (TextUtils.equals(this.mDigits.getText(), "1") == false) goto L82;
    L67:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 9, 16);
        sendSpeedDialMessage(r14.getId());
        goto L82
    L71:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 4, 11);
        sendSpeedDialMessage(r14.getId());
        goto L82
    L75:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 5, 12);
        sendSpeedDialMessage(r14.getId());
        goto L82
    L79:
        if (assertPointInView(r7, r8, r14) == false) goto L82;
        KeyTask.access$3300(this.mKeyTask, r14, r7, r8, 8, 15);
        sendSpeedDialMessage(r14.getId());
        goto L82
    }

    private void sendSpeedDialMessage(int r4) {
        if (ContactsUtils.FEATURE_CMCC == true) goto L6;
        return;
    L6:
        switch(r4) {
            case 2131362584: goto L15;
            case 2131362585: goto L15;
            case 2131362586: goto L15;
            case 2131362653: goto L14;
            case 2131362654: goto L14;
            case 2131362682: goto L13;
            case 2131362683: goto L13;
            case 2131362684: goto L13;
            case 2131363149: goto L12;
            case 2131363150: goto L12;
            case 2131363572: goto L11;
            case 2131363573: goto L11;
            case 2131363602: goto L10;
            case 2131363603: goto L10;
            case 2131363788: goto L9;
            case 2131363789: goto L9;
            case 2131363911: goto L8;
            case 2131363912: goto L8;
            default: goto L7;
        };
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid click for speed dial.");
        int r5 = -1;
    L17:
        if (isDigitsEmpty() == false) goto L19;
    L20:
        Message r0 = this.mLongClickHandler.obtainMessage(4);
        r0.obj = Integer.valueOf(r5);
        this.mLongClickHandler.sendMessageDelayed(r0, 500);
        return;
    L19:
        if (TextUtils.equals(this.mDigits.getText(), String.valueOf(r5)) == true) goto L20;
        return;
    L8:
        r5 = 2;
        goto L17
    L9:
        r5 = 3;
        goto L17
    L10:
        r5 = 6;
        goto L17
    L11:
        r5 = 7;
        goto L17
    L12:
        r5 = 9;
        goto L17
    L13:
        r5 = 4;
        goto L17
    L14:
        r5 = 5;
        goto L17
    L15:
        r5 = 8;
        goto L17
    }

    private void callSpeedNumber(int r2) {
        SpeedDialUtils.checkValidity(getActivity(), r2);
        String r0 = SpeedDialUtils.getPhoneNumber(getActivity(), r2);
        if (r0 != null) goto L5;
        showNoSpeedNumberDialog(r2);
        return;
    L5:
        dialClickedNumber(r0, true);
        this.mIsResetLayout = true;
    }

    private void showNoSpeedNumberDialog(int r4) {
        Intent r0 = new Intent(getActivity(), SpeedDialSettingActivity.class);
        r0.putExtra(SpeedDialSettingActivity.EXTRA_NUMBER, r4);
        AnimationUtil.startActivityWithAnimExtra(getActivity(), r0, 1, 2);
    }

    public void showDialpad() {
        if (this.mIsShowDialpad == false) goto L5;
        return;
    L5:
        this.mIsShowDialpad = true;
        this.isT9on = false;
        View r2 = this.mFragmentView;
        if (r2 == null) goto L14;
        View r3 = this.mTouchpad;
        if (r3 == null) goto L15;
        View r4 = this.mClassicDialpad;
        if (r4 == null) goto L16;
        ContactsTransitionKt.toggleDialpad((ViewGroup) r2, r4, r3, true, null);
        this.mTouchpad.setVisibility(8);
        this.mClassicDialpad.setVisibility(0);
        return;
    L16:
        return;
    L15:
        return;
    }

    public void showDialpadWithTextDialog(final String r6) {
        if (this.mIsShowDialpad == false) goto L6;
        showClipPopupWindow(r6);
        return;
    L6:
        this.mIsShowDialpad = true;
        this.isT9on = false;
        if (this.mFragmentView != null) goto L9;
        return;
    L9:
        if (this.mTouchpad != null) goto L11;
        return;
    L11:
        if (this.mClassicDialpad == null) goto L17;
        Function0 r2 = new AnonymousClass28(this, r6);
        ContactsTransitionKt.toggleDialpad((ViewGroup) this.mFragmentView, this.mClassicDialpad, this.mTouchpad, true, r2);
        this.mTouchpad.setVisibility(8);
        this.mClassicDialpad.setVisibility(0);
        return;
    }

    private void showClipPopupWindow(final String r4) {
        if (this.mContext != null) goto L6;
        this.mShowClipPopupWindowRunnable = new AnonymousClass29(this, r4);
        return;
    L6:
        this.mShowClipPopupWindowRunnable = null;
        DigitsEditText r0 = this.mDigits;
        if (r0 != null) goto L9;
    L12:
        final ViewGroup r1 = (ViewGroup) this.mContext.findViewById(R.id.content);
        DismissibleClickableView r2 = this.mDismissibleClickableView;
        if (r2 != null) goto L16;
        this.mDismissibleClickableView = new DismissibleClickableView(this.mContext);
    L18:
        this.mClassicDialpad.post(new AnonymousClass30(this, r1, r4));
        return;
    L16:
        if (r1.indexOfChild(r2) == (-1)) goto L18;
        this.mDismissibleClickableView.dismiss();
        goto L18
    L9:
        if (TextUtils.isEmpty(r0.getText().toString()) == true) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "showClipPopupWindow: text is not empty");
    }

    public void dismissClipPopupWindow() {
        DismissibleClickableView r0 = this.mDismissibleClickableView;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    @Override // com.android.contacts.AbstractFragment, com.obricOld.contacts.menus.LongMenuHelper.OnMenuItemClickedListener
    public boolean onMenuItemClicked(LongMenuHelper.MenuType r3, View r4, Object r5) {
        ListAdapter r2 = this.mListView.getAdapter();
        if ((r2 instanceof T9Search.T9Adapter) == true) goto L5;
    L16:
        return false;
    L5:
        if ((r5 instanceof ContactItem) == false) goto L16;
        T9Search.T9Adapter r6 = (T9Search.T9Adapter) r2;
        ContactItem r7 = (ContactItem) r5;
        int r8 = AnonymousClass32.$SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[r3.ordinal()];
        if (r8 != 1) goto L10;
        r6.doRemoveCallLog(r7);
        return true;
    L10:
        if (r8 == 2) goto L12;
        return false;
    L12:
        r6.numberIntoBlackList(r7);
        return true;
    }

    private void showDialpadWithOutAnimation() {
        if (this.mIsShowDialpad == false) goto L5;
        return;
    L5:
        resetDialpad(this.mDialpad);
        resetDialpad(this.mClassicDialpad);
    }

    private void resetDialpad(View r2) {
        View r0 = this.mFragmentView;
        if (r0 == null) goto L6;
        OEAAnimKt.cancelTransit((ViewGroup) r0);
    L6:
        if (r2 == null) goto L8;
        r2.setVisibility(0);
    L8:
        this.mIsShowDialpad = true;
        this.isT9on = false;
    }

    public void disappearDialpad() {
        this.mDigits.setCursorVisible(false);
        KeyTask r0 = this.mKeyTask;
        if (r0 == null) goto L6;
        KeyTask.access$3700(r0);
    L6:
        if (this.mIsShowDialpad == true) goto L8;
        return;
    L8:
        this.isT9on = true;
        this.mIsShowDialpad = false;
        View r1 = this.mFragmentView;
        if (r1 == null) goto L17;
        View r2 = this.mTouchpad;
        if (r2 == null) goto L18;
        View r3 = this.mClassicDialpad;
        if (r3 == null) goto L19;
        ContactsTransitionKt.toggleDialpad((ViewGroup) r1, r3, r2, false, null);
        this.mTouchpad.setVisibility(0);
        this.mClassicDialpad.setVisibility(8);
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // com.android.contacts.calllog.CallLogAdapter.CallFetcher
    public void fetchCalls() {
        this.mRecommendDataLoader.loadRecommendData(true);
    }

    @Override // com.android.contacts.activities.DialtactsActivity.PageEnableListener
    public void setEnable(boolean r3, boolean r4) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEnable visible:" + r3 + "; mProviderIsNormal:" + this.mProviderIsNormal);
    L5:
        this.mProviderIsNormal = r3;
        if (r3 == false) goto L10;
        if (r4 == false) goto L11;
        refreshData();
        return;
    L11:
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ReleaseResourceListener
    public void release() {
        if (this.mVisibilityChanged == false) goto L5;
        return;
    L5:
        if (this.mDigits.length() != 0) goto L11;
        T9Search.T9Adapter r0 = this.mT9Adapter;
        if (r0 == null) goto L12;
        r0.setItems(null);
        this.mT9Adapter = null;
        return;
    L12:
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.onBackPressListener
    public boolean backToTopState() {
        QuickContactListView r0 = this.mListView;
        if (r0 != null) goto L5;
    L7:
        return true;
    L5:
        if (r0.isShowQuickContact() == false) goto L7;
        this.mListView.hideQuickContact();
        return false;
    }

    private int getDefaultSimSlotId() {
        int r0 = DSUtils.getCallingSim(getContext());
        if (r0 < 0) goto L6;
        return r0;
    L6:
        return DSUtils.getDefaultCallSim();
    }

    @Override // com.android.contacts.DSUtils.DSFatureStatusListener
    public void onDSFeatureStatusChanged() {
        updateDialpadMode();
        updateSimSwitchViewState(false);
        updateYellowPageState();
        FlowAdapter r1 = this.mAdapter;
        if (r1 == null) goto L6;
        r1.notifyDataSetChanged();
        return;
    }

    private void traversalChildAndSetDelegateIfNecessary(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((r3 instanceof ViewGroup) == false) goto L16;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = 0;
    L7:
        if (r0 >= r4.getChildCount()) goto L17;
        View r1 = r4.getChildAt(r0);
        if (r1 == null) goto L11;
        assertAccessInfoDelegateSet(r1);
        traversalChildAndSetDelegateIfNecessary(r1);
    L11:
        r0 = r0 + 1;
        goto L7
    L17:
        return;
    }

    private void assertAccessInfoDelegateSet(View r1) {
        switch(Integer.valueOf(r1.getId()).intValue()) {
            case 2131362584: goto L5;
            case 2131362585: goto L5;
            case 2131362586: goto L5;
            case 2131362653: goto L5;
            case 2131362654: goto L5;
            case 2131362682: goto L5;
            case 2131362683: goto L5;
            case 2131362684: goto L5;
            case 2131363149: goto L5;
            case 2131363150: goto L5;
            case 2131363221: goto L5;
            case 2131363222: goto L5;
            case 2131363310: goto L5;
            case 2131363572: goto L5;
            case 2131363573: goto L5;
            case 2131363602: goto L5;
            case 2131363603: goto L5;
            case 2131363647: goto L5;
            case 2131363788: goto L5;
            case 2131363789: goto L5;
            case 2131363911: goto L5;
            case 2131363912: goto L5;
            case 2131364004: goto L5;
            case 2131364005: goto L5;
            default: goto L7;
        };
    L5:
        OreoApiUtils.setViewAccessbilityDelegateForTouch(r1);
        return;
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }

    public void showVibrator() {
        if (this.mIsPcMode == true) goto L6;
        VibratorHelper.INSTANCE.dial(this.mContext);
        return;
    }

    private void tryToShowOpenCallSummaryView() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "try to show open call summary view start");
        boolean r4 = true;
        boolean r2 = this.mPrefs.getBoolean("should_show_tutorial_popup", true);
        if (r2 == false) goto L8;
        if (SettingsProviderHelper.INSTANCE.isAutoIntelligentEnabled(getContext(), false) == false) goto L8;
        this.mPrefs.edit().putBoolean("should_show_tutorial_popup", false).commit();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Change SP_KEY_SHOULD_SHOW_TUTORIAL_POPUP to false");
        r2 = false;
    L8:
        if (this.mOpenCallSummaryView.getVisibility() == 0) goto L11;
        r4 = false;
    L11:
        if (r2 == false) goto L14;
        if (r4 == true) goto L14;
        this.mOpenCallSummaryView.setVisibility(0);
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "try to show open call summary view start");
        return;
    L14:
        if (r2 == true) goto L17;
        if (r4 == false) goto L17;
        this.mOpenCallSummaryView.setVisibility(8);
        goto L17
    }
}
