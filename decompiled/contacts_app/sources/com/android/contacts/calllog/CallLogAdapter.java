package com.android.contacts.calllog;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import com.GlobalProxyLancet;
import com.android.common.widget.GroupingListAdapter;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.PhoneCallDetailsHelper;
import com.android.contacts.R;
import com.android.contacts.calllog.blocked.BlockedCallAdapter;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.dialpad.NewDialpadFragment;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.list.HorizontalScrollListView;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.util.CallLogTimeRangeUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ExpirableCache;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.util.UriUtils;
import com.google.common.base.Objects;
import com.obric.oui.button.OButton;
import com.obric.oui.time.TimeStyle;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import com.obric.utils.NewContactsTraceLog;
import com.obric.utils.views.commonitemview.CallLogItemView;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;

/* JADX INFO: loaded from: classes.dex */
public class CallLogAdapter extends GroupingListAdapter implements Runnable, ViewTreeObserver.OnPreDrawListener, HorizontalScrollListView.ScrollStateListener, CallLogGroupBuilder.GroupCreator {
    private static final int CONTACT_INFO_CACHE_SIZE = 200;
    static boolean DEBUG = false;
    private static final int REDRAW = 1;
    private static final int START_PROCESSING_REQUESTS_DELAY_MILLIS = 1000;
    private static final int START_THREAD = 2;
    private final String TAG;
    private CallLogItemView closingSwipeItem;
    private Activity mActivity;
    private BlackListQueryHandler mBlHandler;
    private final CallFetcher mCallFetcher;
    private NewCallLogFragment mCallLogFragment;
    private final CallLogGroupBuilder mCallLogGroupBuilder;
    private final CallLogListItemHelper mCallLogViewsHelper;
    private Thread mCallerIdThread;
    private boolean mContactHasMoreNumbers;
    private ExpirableCache<NumberWithCountryIso, ContactInfo> mContactInfoCache;
    private final ContactInfoHelper mContactInfoHelper;
    private final ContactPhotoManager mContactPhotoManager;
    private final Context mContext;
    private int mDetailItemLayoutID;
    private NewDialpadFragment mDialpadFragment;
    private volatile boolean mDone;
    private boolean mFirst;
    public HorizontalScrollListView mHSListView;
    private Handler mHandler;
    private boolean mIsEditMode;
    private boolean mIsShowSingleContactCalls;
    private int mItemLayoutID;
    private HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private int mListScrollState;
    private boolean mLoading;
    private PhoneNumberHelper mPhoneNumberHelper;
    private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    private final View.OnClickListener mPrimaryActionListener;
    private volatile boolean mRequestProcessingDisabled;
    private final LinkedList<ContactInfoRequest> mRequests;
    private ArrayList<Long> mSelectedIds;
    private long mSwipedItemId;
    private CallLogItemView swipeItem;

    /* JADX INFO: renamed from: com.android.contacts.calllog.CallLogAdapter$15, reason: invalid class name */
    static /* synthetic */ class AnonymousClass15 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$utils$views$commonitemview$bean$SwipeItemButtonType = null;

        static {
            int[] r0 = new int[SwipeItemButtonType.values().length];
            $SwitchMap$com$obric$utils$views$commonitemview$bean$SwipeItemButtonType = r0;
            r0[SwipeItemButtonType.SWIPE_MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$obric$utils$views$commonitemview$bean$SwipeItemButtonType[SwipeItemButtonType.SWIPE_DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface CallFetcher {
        void fetchCalls();
    }

    private static final class ContactInfoRequest {
        public final ContactInfo callLogInfo;
        public final String countryIso;
        public final String number;

        public ContactInfoRequest(String r1, String r2, ContactInfo r3) {
            this.number = r1;
            this.countryIso = r2;
            this.callLogInfo = r3;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if ((r5 instanceof ContactInfoRequest) == true) goto L11;
            return false;
        L11:
            ContactInfoRequest r6 = (ContactInfoRequest) r5;
            if (TextUtils.equals(this.number, r6.number) == true) goto L15;
            return false;
        L15:
            if (TextUtils.equals(this.countryIso, r6.countryIso) == true) goto L18;
            return false;
        L18:
            if (Objects.equal(this.callLogInfo, r6.callLogInfo) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            ContactInfo r0 = this.callLogInfo;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r2 + 31) * 31;
            String r4 = this.countryIso;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.number;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }
    }

    private static final class NumberWithCountryIso {
        public final String countryIso;
        public final String number;

        public NumberWithCountryIso(String r1, String r2) {
            this.number = r1;
            this.countryIso = r2;
        }

        public boolean equals(Object r4) {
            if (r4 != null) goto L6;
            return false;
        L6:
            if ((r4 instanceof NumberWithCountryIso) == true) goto L8;
            return false;
        L8:
            NumberWithCountryIso r5 = (NumberWithCountryIso) r4;
            if (TextUtils.equals(this.number, r5.number) == true) goto L11;
            return false;
        L11:
            if (TextUtils.equals(this.countryIso, r5.countryIso) == false) goto L15;
            return true;
        L15:
            return false;
        }

        public int hashCode() {
            String r0 = this.number;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            String r3 = this.countryIso;
            if (r3 == null) goto L11;
            r1 = r3.hashCode();
        L11:
            return r2 ^ r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }
    }

    public class PrimaryActionListener implements View.OnClickListener {
        private Pair<Long, String>[] dateAndNumber;
        private boolean hasMarked;
        private PhoneCallDetails mDetails;
        private AsyncTask<Void, Void, Boolean> mHasRecordTask;
        private long mID;
        private long[] mIds;
        private boolean mIsSingleLine;
        private boolean mIsStranger;
        private String mName;
        private String mNumber;
        private CallLogItemView mViews;
        final /* synthetic */ CallLogAdapter this$0;

        public PrimaryActionListener(CallLogAdapter r3, long r4, CallLogItemView r6, int r7, int r8, Cursor r9, String r10) {
            this.this$0 = r3;
            long[] r1 = new long[1];
            this.mIds = r1;
            this.dateAndNumber = new Pair[1];
            this.mIsSingleLine = false;
            this.mID = r4;
            if (r8 != 0) goto L5;
            r1[0] = r4;
        L6:
            this.mViews = r6;
            this.mNumber = r10;
            this.dateAndNumber = r3.getDateAndNumber(r9, r7, r8);
            return;
        L5:
            this.mIds = r3.getCallDetailIds(r9, r7, r8);
            goto L6
        }

        public PrimaryActionListener(CallLogAdapter r11, long r12, CallLogItemView r14, int r15, int r16, Cursor r17, String r18, String r19, PhoneCallDetails r20, boolean r21, boolean r22, boolean r23) {
            this(r11, r12, r14, r15, r16, r17, r19);
            this.mName = r18;
            this.mDetails = r20;
            this.hasMarked = r22;
            this.mIsStranger = r21;
            this.mIsSingleLine = r23;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            int r1 = 0;
            if (CallLogAdapter.access$500(this.this$0) == true) goto L20;
            if (ContactsUtils.isJustClicked() == true) goto L39;
            IntentProvider r11 = (IntentProvider) this.mViews.getTag(R.id.call_log_item_click_intent_provider);
            if (r11 != null) goto L9;
            return;
        L9:
            if (CallLogAdapter.access$1300(this.this$0) == null) goto L12;
            CallLogAdapter.access$1300(this.this$0).setLastNumberDialed(this.mNumber);
        L12:
            if (DSUtils.isSimManualSelectMode() == true) goto L14;
            CallLogAdapter.access$300(this.this$0).startActivity(r11.getIntent(CallLogAdapter.access$300(this.this$0)));
            CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
            return;
        L14:
            if (r11.getIntent(CallLogAdapter.access$300(this.this$0)).getIntExtra(Constants.EXTRA_START_CALL_WITH_VIDEO_STATE, -1) != 3) goto L16;
            boolean r8 = true;
        L17:
            ContactsUtils.showSelectSimDialog(CallLogAdapter.access$300(this.this$0), this.mName, this.mNumber, 1, this.mIsStranger, r8);
            return;
        L16:
            r8 = false;
            goto L17
        L39:
            return;
        L20:
            if (CallLogAdapter.access$1400(this.this$0).contains(Long.valueOf(this.mIds[0])) == true) goto L28;
            long[] r12 = this.mIds;
            int r2 = r12.length;
        L22:
            if (r1 >= r2) goto L24;
            CallLogAdapter.access$1400(this.this$0).add(Long.valueOf(r12[r1]));
            r1 = r1 + 1;
            goto L22
        L24:
            CallLogItemView r13 = this.mViews;
            if (r13 == null) goto L35;
            r13.setChecked(true);
        L35:
            CallLogAdapter.access$800(this.this$0).refreshUI();
            return;
        L28:
            if (CallLogAdapter.access$1400(this.this$0).contains(Long.valueOf(this.mIds[0])) == false) goto L35;
            long[] r14 = this.mIds;
            int r0 = r14.length;
            int r3 = 0;
        L30:
            if (r3 >= r0) goto L32;
            CallLogAdapter.access$1400(this.this$0).remove(Long.valueOf(r14[r3]));
            r3 = r3 + 1;
            goto L30
        L32:
            CallLogItemView r15 = this.mViews;
            if (r15 == null) goto L35;
            r15.setChecked(false);
            goto L35
        }

        public String getNumber() {
            return this.mNumber;
        }

        public String getName() {
            return this.mName;
        }

        public long getId() {
            return this.mID;
        }

        public long[] getIds() {
            return this.mIds;
        }

        public boolean isStranger() {
            return this.mIsStranger;
        }

        public PhoneCallDetails getPhoneCallDetails() {
            return this.mDetails;
        }

        public void clickGoToDetail() {
            new SecondaryActionListener(this.this$0).onClick(this.mViews);
        }

        public boolean isHasMarked() {
            return this.hasMarked;
        }

        public boolean isSingleLine() {
            return this.mIsSingleLine;
        }
    }

    private interface QueryContactInfoCallback {
        void queryCompleted(boolean r1);
    }

    public class SecondaryActionListener implements View.OnClickListener {
        final /* synthetic */ CallLogAdapter this$0;

        public SecondaryActionListener(CallLogAdapter r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            if (CallLogAdapter.access$500(this.this$0) == false) goto L5;
            return;
        L5:
            IntentProvider r4 = (IntentProvider) r3.getTag(R.id.call_log_item_click_sec_intent_provider);
            if (r4 == null) goto L9;
            final Intent r5 = r4.getIntent(CallLogAdapter.access$300(this.this$0));
            new Thread(new AnonymousClass1(this, r5)).start();
            return;
        }
    }

    private void initOffset() {
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollCompleted(View r1) {
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollRestored(View r1) {
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrolling(int r1, View r2) {
    }

    static /* synthetic */ void access$000(CallLogAdapter r0) {
        r0.startRequestProcessing();
    }

    static /* synthetic */ void access$100(CallLogAdapter r0, String r1, String r2, ContactInfo r3, ContactInfo r4, QueryContactInfoCallback r5) {
        r0.handleContactInfo(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ CallLogItemView access$1000(CallLogAdapter r0) {
        return r0.closingSwipeItem;
    }

    static /* synthetic */ CallLogItemView access$1002(CallLogAdapter r0, CallLogItemView r1) {
        r0.closingSwipeItem = r1;
        return r1;
    }

    static /* synthetic */ CallLogItemView access$1100(CallLogAdapter r0) {
        return r0.swipeItem;
    }

    static /* synthetic */ CallLogItemView access$1102(CallLogAdapter r0, CallLogItemView r1) {
        r0.swipeItem = r1;
        return r1;
    }

    static /* synthetic */ long access$1200(CallLogAdapter r2) {
        return r2.mSwipedItemId;
    }

    static /* synthetic */ long access$1202(CallLogAdapter r0, long r1) {
        r0.mSwipedItemId = r1;
        return r1;
    }

    static /* synthetic */ NewDialpadFragment access$1300(CallLogAdapter r0) {
        return r0.mDialpadFragment;
    }

    static /* synthetic */ ArrayList access$1400(CallLogAdapter r0) {
        return r0.mSelectedIds;
    }

    static /* synthetic */ Activity access$1500(CallLogAdapter r0) {
        return r0.mActivity;
    }

    static /* synthetic */ Handler access$1600(CallLogAdapter r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$1700(CallLogAdapter r0) {
        r0.initBlHandlerIfNeed();
    }

    static /* synthetic */ BlackListQueryHandler access$1800(CallLogAdapter r0) {
        return r0.mBlHandler;
    }

    static /* synthetic */ CallLogGroupBuilder access$200(CallLogAdapter r0) {
        return r0.mCallLogGroupBuilder;
    }

    static /* synthetic */ Context access$300(CallLogAdapter r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$400(CallLogAdapter r0) {
        r0.hideSwipedViews();
    }

    static /* synthetic */ boolean access$500(CallLogAdapter r0) {
        return r0.mIsEditMode;
    }

    static /* synthetic */ boolean access$600(CallLogAdapter r0) {
        return r0.mIsShowSingleContactCalls;
    }

    static /* synthetic */ HorizontalScrollListView.ItemLongClickedListener access$700(CallLogAdapter r0) {
        return r0.mItemLongClickedListener;
    }

    static /* synthetic */ NewCallLogFragment access$800(CallLogAdapter r0) {
        return r0.mCallLogFragment;
    }

    static /* synthetic */ void access$900(CallLogAdapter r0, PrimaryActionListener r1) {
        r0.removeCallLog(r1);
    }

    public int getScrollState() {
        return this.mListScrollState;
    }

    public void setScrollState(int r2) {
        int r0 = this.mListScrollState;
        if (r0 == r2) goto L6;
        this.mListScrollState = r2;
        onScrollStateChanged(r0, r2);
        return;
    }

    private void onScrollStateChanged(int r5, int r6) {
        if (r5 != 2) goto L16;
        if (r6 != 0) goto L21;
        int r7 = this.mHSListView.getFirstVisiblePosition();
        int r8 = 0;
    L7:
        if (r8 >= this.mHSListView.getChildCount()) goto L22;
        Cursor r0 = (Cursor) getItem(r7 + r8);
        if (r0 == null) goto L15;
        ContactInfo r1 = getContactInfoFromCallLog(r0);
        if (PhoneNumberHelper.canPlaceCallsTo(r1.presentation) == false) goto L15;
        String r2 = r0.getString(5);
        enqueueRequest(r1.number, r2, r1, true);
    L15:
        r8 = r8 + 1;
        goto L7
    L22:
        return;
    L21:
        return;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (this.mFirst == false) goto L7;
        this.mHandler.sendEmptyMessageDelayed(2, 1000);
        this.mFirst = false;
        return true;
    L7:
        return true;
    }

    CallLogAdapter(Context r9, CallFetcher r10, ContactInfoHelper r11, NewCallLogFragment r12, boolean r13, boolean r14) {
        super(r9);
        this.TAG = "CallLogAdapter";
        this.mListScrollState = 0;
        this.mLoading = true;
        this.mCallerIdThread = null;
        this.mRequestProcessingDisabled = false;
        this.mIsEditMode = false;
        this.mSelectedIds = new ArrayList();
        this.mHandler = new AnonymousClass1(this);
        this.mPrimaryActionListener = new AnonymousClass5(this);
        this.mItemLongClickedListener = null;
        this.swipeItem = null;
        this.closingSwipeItem = null;
        this.mSwipedItemId = -1;
        this.mCallLogFragment = r12;
        this.mActivity = r12.getActivity();
        this.mContext = r9;
        this.mCallFetcher = r10;
        this.mContactInfoHelper = r11;
        this.mContactInfoCache = ExpirableCache.create(200);
        this.mRequests = new LinkedList();
        this.mPreDrawListener = null;
        Resources r15 = r9.getResources();
        CallTypeHelper r4 = new CallTypeHelper(r15);
        this.mContactPhotoManager = ContactPhotoManager.getInstance(r9);
        this.mPhoneNumberHelper = new PhoneNumberHelper(r15);
        this.mCallLogViewsHelper = new CallLogListItemHelper(new PhoneCallDetailsHelper(r15, r4, this.mPhoneNumberHelper, r9, r13), this.mPhoneNumberHelper, r15);
        this.mCallLogGroupBuilder = new CallLogGroupBuilder(this, r13, r9);
        this.mIsShowSingleContactCalls = r13;
        initOffset();
        initItemLayoutResource(ContactsUtils.isScaledFontApplied(r9));
        this.mContactHasMoreNumbers = r14;
    }

    public CallLogAdapter(Context r5, CallFetcher r6, ContactInfoHelper r7, NewDialpadFragment r8) {
        super(r5);
        this.TAG = "CallLogAdapter";
        this.mListScrollState = 0;
        this.mLoading = true;
        this.mCallerIdThread = null;
        this.mRequestProcessingDisabled = false;
        this.mIsEditMode = false;
        this.mSelectedIds = new ArrayList();
        this.mHandler = new AnonymousClass1(this);
        this.mPrimaryActionListener = new AnonymousClass5(this);
        this.mItemLongClickedListener = null;
        this.swipeItem = null;
        this.closingSwipeItem = null;
        this.mSwipedItemId = -1;
        this.mContext = r5;
        this.mActivity = r8.getActivity();
        this.mDialpadFragment = r8;
        this.mCallFetcher = r6;
        this.mContactInfoHelper = r7;
        this.mContactInfoCache = ExpirableCache.create(200);
        this.mRequests = new LinkedList();
        this.mPreDrawListener = null;
        Resources r9 = r5.getResources();
        CallTypeHelper r10 = new CallTypeHelper(r9);
        this.mContactPhotoManager = ContactPhotoManager.getInstance(r5);
        this.mPhoneNumberHelper = new PhoneNumberHelper(r9);
        this.mCallLogViewsHelper = new CallLogListItemHelper(new PhoneCallDetailsHelper(r9, r10, this.mPhoneNumberHelper, r5), this.mPhoneNumberHelper, r9);
        this.mCallLogGroupBuilder = new CallLogGroupBuilder(this, r5);
        initOffset();
        initItemLayoutResource(ContactsUtils.isScaledFontApplied(r5));
    }

    private void initItemLayoutResource(boolean r3) {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("CallLogAdapter", "initialize scaledFontApplied = " + r3);
    L5:
        this.mItemLayoutID = R.layout.call_log_list_item;
        this.mDetailItemLayoutID = R.layout.detail_call_log_list_item;
    }

    @Override // com.android.common.widget.GroupingListAdapter
    protected void onContentChanged() {
        onContentChangedByScene("call log cursor content changed");
    }

    public void onContentChangedByScene(String r4) {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("onContentChangedByScene", "onContentChangedByScene scene = " + r4);
    L5:
        NewContactsTraceLog.INSTANCE.onCallLogPageLog("CallLogAdapter onContentChangedByScene scene = " + r4);
        this.mCallFetcher.fetchCalls();
    }

    public void setLoading(boolean r1) {
        this.mLoading = r1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        if (this.mLoading == false) goto L7;
        return false;
    L7:
        return super.isEmpty();
    }

    private void startRequestProcessing() {
        if (this.mRequestProcessingDisabled == false) goto L5;
        return;
    L5:
        this.mDone = false;
        if (this.mCallerIdThread != null) goto L9;
        Thread r0 = new Thread(this, "CallLogContactLookup");
        this.mCallerIdThread = r0;
        r0.setPriority(1);
        this.mCallerIdThread.start();
        return;
    }

    public void stopRequestProcessing() {
        this.mHandler.removeMessages(2);
        this.mDone = true;
        Thread r0 = this.mCallerIdThread;
        if (r0 == null) goto L6;
        r0.interrupt();
        this.mCallerIdThread = null;
        return;
    }

    public void invalidateCache() {
        this.mContactInfoCache.expireAll();
        this.mPreDrawListener = null;
    }

    void enqueueRequest(String r3, String r4, ContactInfo r5, boolean r6) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (this.mListScrollState == 2) goto L27;
        ContactInfoRequest r0 = new ContactInfoRequest(r3, r4, r5);
        LinkedList<ContactInfoRequest> r7 = this.mRequests;
        monitor-enter(r7);
    L19:
        th = move-exception;
        throw th;
    L10:
        if (this.mRequests.contains(r0) == false) goto L12;
        this.mRequests.remove(r0);     // Catch: Throwable -> L19
    L12:
        this.mRequests.add(r0);     // Catch: Throwable -> L19
        this.mRequests.notifyAll();     // Catch: Throwable -> L19
        monitor-exit(r7);     // Catch: Throwable -> L19
        if (this.mFirst == false) goto L25;
        if (r6 == false) goto L26;
        startRequestProcessing();
        this.mFirst = false;
        return;
    L26:
        return;
    L25:
        return;
    }

    private void queryContactInfo(final String r10, final String r11, final ContactInfo r12, final QueryContactInfoCallback r13) {
        ContactInfo r5 = this.mContactInfoHelper.lookupNumber(r10, r11);
        if (DEBUG == false) goto L9;
        StringBuilder r0 = new StringBuilder("mContactInfoHelper.lookupNumber invoke complete : ");
        if (r5 != null) goto L7;
        String r2 = "contactInfo_lastest is null!";
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("QueryContactInfo", r0.append(r2).toString());
        goto L9
    L7:
        r2 = r5.number + " lookupUri : " + r5.lookupUri;
    L9:
        if (r5 != null) goto L11;
        final ContactInfo r3 = new ContactInfo();
        r3.number = r10;
        r3.formattedNumber = this.mContactInfoHelper.formatPhoneNumber(r10, null, r11);
        NumberInfosManager.getInstance().getBaseAndMarkInfos(r10, new AnonymousClass2(this, r3, r10, r11, r12, r13));
        return;
    L11:
        handleContactInfo(r10, r11, r12, r5, r13);
    }

    private void handleContactInfo(String r4, String r5, ContactInfo r6, ContactInfo r7, QueryContactInfoCallback r8) {
        NumberWithCountryIso r0 = new NumberWithCountryIso(r4, r5);
        boolean r1 = !r7.equals(this.mContactInfoCache.getPossiblyExpired(r0));
        this.mContactInfoCache.put(r0, r7);
        updateCallLogContactInfoCache(r4, r5, r7, r6);
        r8.queryCompleted(r1);
    }

    @Override // java.lang.Runnable
    public void run() {
        final boolean[] r1 = {false};
    L4:
        if (this.mDone == true) goto L27;
        LinkedList<ContactInfoRequest> r3 = this.mRequests;
        monitor-enter(r3);
        if (this.mRequests.isEmpty() == true) goto L11;
        ContactInfoRequest r4 = this.mRequests.removeLast();     // Catch: Throwable -> L24
    L19:
        monitor-exit(r3);     // Catch: Throwable -> L24
        if (this.mDone == true) goto L4;
        if (r4 == null) goto L4;
        queryContactInfo(r4.number, r4.countryIso, r4.callLogInfo, new AnonymousClass3(this, r1));
        goto L4
    L11:
        if (this.mListScrollState == 0) goto L13;
    L28:
        this.mRequests.wait(1000);     // Catch: InterruptedException -> L17 Throwable -> L24
    L18:
        r4 = null;
        goto L19
    L17:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L24
        goto L18
    L13:
        if (r1[0] == false) goto L28;
        r1[0] = false;     // Catch: Throwable -> L24
        this.mHandler.sendEmptyMessage(1);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.android.common.widget.GroupingListAdapter
    protected void addGroups(final Cursor r3) {
        Future r2 = ((ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR).submit(new AnonymousClass4(this, r3));
        r2.get(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("CallLogAdapter", "timeoutException: " + e.getMessage());
        r2.cancel(true);
    }

    @Override // com.android.common.widget.GroupingListAdapter
    protected View newStandAloneView(Context r1, ViewGroup r2) {
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("CallLogAdapter", "newStandAloneView");
    L6:
        return new CallLogItemView(r1, null);
    }

    @Override // com.android.common.widget.GroupingListAdapter
    protected void bindStandAloneView(View r2, Context r3, Cursor r4) {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("CallLogAdapter", "bindStandAloneView" + r4.getPosition());
    L5:
        bindView(r2, r4, 1);
    }

    @Override // com.android.common.widget.GroupingListAdapter
    protected View newChildView(Context r1, ViewGroup r2) {
        return new CallLogItemView(r1, null);
    }

    @Override // com.android.common.widget.GroupingListAdapter
    protected void bindChildView(View r2, Context r3, Cursor r4) {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("CallLogAdapter", "bindChildView" + r4.getPosition());
    L5:
        bindView(r2, r4, 1);
    }

    @Override // com.android.common.widget.GroupingListAdapter
    protected View newGroupView(Context r1, ViewGroup r2) {
        return new CallLogItemView(r1, null);
    }

    @Override // com.android.common.widget.GroupingListAdapter
    protected void bindGroupView(View r1, Context r2, Cursor r3, int r4, boolean r5) {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("CallLogAdapter", "bindGroupView" + r3.getPosition() + HanziToPinyin.Token.SEPARATOR + r4);
    L5:
        bindView(r1, r3, r4);
    }

    public void setIsEditMode(boolean r1) {
        this.mIsEditMode = r1;
    }

    public ArrayList<Long> getSelectedIds() {
        return this.mSelectedIds;
    }

    public boolean isChecked(int r3) {
        long r0 = getItemId(r3);
        return this.mSelectedIds.contains(Long.valueOf(r0));
    }

    public boolean setChecked(int r10, boolean r11) {
        if (getItemId(r10) >= 0) goto L5;
        return false;
    L5:
        Cursor r0 = getCursor();
        int r2 = r0.getPosition();
        int r12 = getEndPosition(r10);
        if (r2 <= r12) goto L8;
        return false;
    L8:
        boolean r3 = false;
    L9:
        if (r2 >= r12) goto L23;
        if (r0.moveToPosition(r2) == false) goto L22;
        long r4 = r0.getLong(0);
        if (r11 == true) goto L15;
    L18:
        if (r11 == true) goto L22;
        if (this.mSelectedIds.contains(Long.valueOf(r4)) == false) goto L22;
        this.mSelectedIds.remove(Long.valueOf(r4));
    L17:
        r3 = true;
        goto L22
    L15:
        if (this.mSelectedIds.contains(Long.valueOf(r4)) == true) goto L18;
        this.mSelectedIds.add(Long.valueOf(r4));
    L22:
        r2 = r2 + 1;
        goto L9
    L23:
        return r3;
    }

    private int getEndPosition(int r5) {
        int r6 = r5 + 1;
        if (r6 < getCount()) goto L7;
        return getCursor().getCount();
    L7:
        if (getItemId(r6) >= 0) goto L11;
        return 0;
    L11:
        return getCursor().getPosition();
    }

    public void clearHashSet() {
        this.mSelectedIds.clear();
        this.mCallLogFragment.refreshUI();
    }

    public void setItemLongClickedListener(HorizontalScrollListView.ItemLongClickedListener r1) {
        this.mItemLongClickedListener = r1;
    }

    private void bindView(View r42, final Cursor r43, int r44) {
        if (r42 != null) goto L5;
        View r0 = new CallLogItemView(this.mContext, null);
    L7:
        if (this.mPreDrawListener != null) goto L9;
        this.mFirst = true;
        this.mPreDrawListener = this;
        r0.getViewTreeObserver().addOnPreDrawListener(this);
    L9:
        final long r11 = r43.getLong(0);
        final CallLogItemView r10 = (CallLogItemView) r0;
        if (r11 == this.mSwipedItemId) goto L18;
        if (r10.isInSwipeAction() == false) goto L15;
        r10.swipeClose();
    L15:
        if (this.swipeItem != r10) goto L20;
        this.swipeItem = null;
    L20:
        String r1 = r43.getString(1);
        if (r1 != null) goto L23;
        r1 = "";
    L23:
        final String r9 = r1;
        final long r4 = r43.getLong(2);
        long r35 = r43.getLong(3);
        int r8 = r43.getInt(4);
        String r2 = r43.getString(5);
        String r37 = r43.getString(11);
        ContactInfo r3 = getContactInfoFromCallLog(r43);
        final String r38 = r43.getString(8);
        if (r8 != 4) goto L28;
        IntentProvider r5 = IntentProvider.getPlayVoicemailIntentProvider(r43.getLong(0), r43.getString(6));
    L26:
        IntentProvider r13 = r5;
    L43:
        IntentProvider r6 = IntentProvider.getCallDetailIntentProvider(this, r43.getPosition(), r11, r44, r37);
        r10.setTag(R.id.call_log_item_click_intent_provider, r13);
        r10.setTag(R.id.call_log_item_click_sec_intent_provider, r6);
        NumberWithCountryIso r7 = new NumberWithCountryIso(r9, r2);
        ExpirableCache.CachedValue<ContactInfo> r12 = this.mContactInfoCache.getCachedValue(r7);
        if (r12 != null) goto L46;
        ContactInfo r14 = null;
    L48:
        if (PhoneNumberHelper.canPlaceCallsTo(r3.presentation) == true) goto L50;
        ContactInfo r15 = ContactInfo.EMPTY;
    L63:
        if (DEBUG == false) goto L65;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("countryIso", "countryIso:" + r2);
    L65:
        int[] r21 = getCallTypes(r43, r44);
        final PhoneCallDetails r16 = new PhoneCallDetails(r9, r15.formattedNumber, r2, r43.getString(7), r21, r4, r35, r15.name, r15.type, r15.label, r15.lookupUri, r15.photoUri, r15.photoId, r43.getInt(17), r43.getString(30));
        r10.setPhoneDetail(r16, r8, r4, r9, r35, 0, this.mIsShowSingleContactCalls, this.mContactHasMoreNumbers);
        if (DSUtils.isMultiSimEnabled() == false) goto L72;
        boolean r17 = true;
        if (r43.getInt(27) != 1) goto L70;
        boolean r18 = true;
    L71:
        r16.subScription = CallLogQuery.getSubscription(r43);
        int r19 = DSUtils.getSimSlotId(this.mContext, r16.subScription, r43.getString(28));
        r16.simId = r19;
        r10.setPhoneSimStatus(r19, r18);
    L73:
        r10.setEditMode(this.mIsEditMode);
        if (this.mIsEditMode == false) goto L76;
        r10.setItemChecked(this.mSelectedIds.contains(Long.valueOf(r11)));
    L77:
        int r110 = r43.getPosition();
        Cursor r111 = getCursor();
        if (r37 != null) goto L80;
        boolean r112 = r17;
    L81:
        final PrimaryActionListener r20 = new PrimaryActionListener(this, r11, r10, r110, r44, r111, r38, r9, r16, r112, r15.hasMarked, this.mIsShowSingleContactCalls);
        r10.setTag(R.id.call_log_item_click_primary_action_listener, r20);
        if (this.mIsShowSingleContactCalls == true) goto L84;
        r10.setOnEndIconClickListener(new AnonymousClass6(this, r20));
    L84:
        r10.setOnSummaryClickListener(new AnonymousClass7(this, r4, r9, r38));
        r10.setOnClickListener(new AnonymousClass8(this, r4, r9, r38, r20, r10, r43, r11));
        r10.setEnableSwipe(!this.mIsEditMode);
        ArrayList r22 = new ArrayList();
        r22.add(SwipeItemButtonType.SWIPE_MESSAGE);
        r22.add(SwipeItemButtonType.SWIPE_DELETE);
        r10.setSwipeItemButtonView(r22, new AnonymousClass9(this, r16, r20));
        r10.addSwipeListener(new AnonymousClass10(this, r10, r11));
        if (TextUtils.isEmpty(r16.name) == true) goto L88;
        NewContactsTraceLog.INSTANCE.onCallLogPageLog("call log bindView name is not empty, callTime=" + CallLogTimeRangeUtil.getFormatTimeByStyle(r4, TimeStyle.FULL));
        return;
    L88:
        return;
    L80:
        r112 = false;
        goto L81
    L76:
        r10.setItemChecked(false);
        goto L77
    L70:
        r18 = false;
        goto L71
    L72:
        r17 = true;
        r10.setPhoneSimStatus(DSUtils.getDefaultCallSim(), false);
        goto L73
    L50:
        if (r12 != null) goto L53;
        this.mContactInfoCache.put(r7, ContactInfo.EMPTY);
        enqueueRequest(r9, r2, r3, true);
    L60:
        r15 = r3;
        goto L63
    L53:
        if (r12.isExpired() == false) goto L56;
        enqueueRequest(r9, r2, r3, false);
    L59:
        if (r14 == ContactInfo.EMPTY) goto L60;
        r15 = r14;
        goto L63
    L56:
        if (callLogInfoMatches(r3, r14) == true) goto L59;
        enqueueRequest(r9, r2, r3, false);
        goto L59
    L46:
        r14 = r12.getValue();
        goto L48
    L28:
        if (PhoneNumberHelper.canPlaceCallsTo(r3.presentation) == false) goto L42;
        boolean r23 = CallLogQuery.isVideoCall(r43);
        if (DSUtils.useDSFeature() == false) goto L36;
        int r113 = CallLogQuery.getSubscription(r43);
        String r114 = r43.getString(28);
        if (r37 != null) goto L34;
        boolean r24 = true;
    L35:
        r5 = IntentProvider.getReturnCallIntentProvider(r9, r113, r114, r24, r23);
        goto L26
    L34:
        r24 = false;
        goto L35
    L36:
        if (r23 == false) goto L38;
        r5 = IntentProvider.getReturnVideoCallIntentProvider(r9);
        goto L26
    L38:
        if (r37 != null) goto L40;
        boolean r25 = true;
    L41:
        r5 = IntentProvider.getReturnCallIntentProvider(r9, r25);
        goto L26
    L40:
        r25 = false;
        goto L41
    L42:
        r13 = null;
        goto L43
    L18:
        if (r10.isInSwipeAction() == false) goto L20;
        this.swipeItem = r10;
        goto L20
    L5:
        r0 = r42;
        goto L7
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        hideSwipedViews();
        super.notifyDataSetInvalidated();
    }

    private void hideSwipedViews() {
        CallLogItemView r0 = this.swipeItem;
        if (r0 == null) goto L5;
        this.closingSwipeItem = r0;
        r0.swipeClose();
        this.closingSwipeItem.setEnableSwipe(false);
        this.swipeItem = null;
    L5:
        this.mSwipedItemId = -1;
    }

    static {
        DEBUG = ContactsUtils.DEBUG;
    }

    public void closeSwipedViews() {
        hideSwipedViews();
    }

    public long[] getCallDetailIds(Cursor r5, int r6, int r7) {
        long[] r4 = new long[r7];
        if (r5.isClosed() == false) goto L5;
        return r4;
    L5:
        int r0 = r5.getPosition();
        r5.moveToPosition(r6);     // Catch: Throwable -> L12
        int r1 = 0;
    L7:
        if (r1 >= r7) goto L10;
        r4[r1] = r5.getLong(0);     // Catch: Throwable -> L12
        r5.moveToNext();     // Catch: Throwable -> L12
        r1 = r1 + 1;
        goto L7
    L10:
        r5.moveToPosition(r0);
        return r4;
    L12:
        th = move-exception;
        r5.moveToPosition(r0);
        throw th;
    }

    public Pair<Long, String>[] getDateAndNumber(Cursor r6, int r7, int r8) {
        Pair<Long, String>[] r5 = new Pair[r8];
        if (r6.isClosed() == false) goto L6;
        return null;
    L6:
        int r0 = r6.getPosition();
        r6.moveToPosition(r7);     // Catch: Throwable -> L13
        int r9 = 0;
    L8:
        if (r9 >= r8) goto L11;
        long r1 = r6.getLong(2);     // Catch: Throwable -> L13
        String r3 = r6.getString(1);     // Catch: Throwable -> L13
        r5[r9] = new Pair(Long.valueOf(r1), r3);     // Catch: Throwable -> L13
        r6.moveToNext();     // Catch: Throwable -> L13
        r9 = r9 + 1;
        goto L8
    L11:
        r6.moveToPosition(r0);
        return r5;
    L13:
        th = move-exception;
        r6.moveToPosition(r0);
        throw th;
    }

    private boolean isLastOfSection(Cursor r3) {
        if (r3.isLast() == false) goto L5;
        return true;
    L5:
        int r2 = r3.getInt(CallLogQuery.SECTION);
        if (r3.moveToNext() == true) goto L8;
        return true;
    L8:
        int r1 = r3.getInt(CallLogQuery.SECTION);
        r3.moveToPrevious();
        if (r2 != r1) goto L13;
        return false;
    L13:
        return true;
    }

    private boolean callLogInfoMatches(ContactInfo r2, ContactInfo r3) {
        if (TextUtils.equals(r2.name, r3.name) == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.type != r3.type) goto L9;
        if (TextUtils.equals(r2.label, r3.label) == false) goto L9;
        return true;
    }

    private void updateCallLogContactInfoCache(String r17, String r18, ContactInfo r19, ContactInfo r20) {
        ContentValues r3 = new ContentValues();
        StringBuilder r4 = new StringBuilder();
        ArrayList r5 = new ArrayList();
        if (r20 != null) goto L5;
        r3.put("name", r19.name);
        r3.put("numbertype", Integer.valueOf(r19.type));
        r3.put("numberlabel", r19.label);
        r3.put("geocoded_location", r19.location);
        r3.put(BlockedCallAdapter.KEY_LOOKUP_URI, UriUtils.uriToString(r19.lookupUri));
        r3.put("matched_number", r19.number);
        r3.put("normalized_number", r19.normalizedNumber);
        r3.put("photo_id", Long.valueOf(r19.photoId));
        r3.put("formatted_number", r19.formattedNumber);
    L33:
        boolean r1 = true;
    L34:
        if (r1 == true) goto L36;
        return;
    L36:
        r4.append("number =? AND ");
        r5.add(r17);
        if (TextUtils.isEmpty(r18) == false) goto L39;
        r4.append("countryiso IS NULL");
    L40:
        r4.append(" AND type IN (1, 7, 2, 3, 5)AND (");
        Iterator<String> r0 = r3.keySet().iterator();
        boolean r15 = true;
    L42:
        if (r0.hasNext() == false) goto L51;
        String r2 = r0.next();
        if (r15 == true) goto L46;
        r4.append(" OR ");
    L47:
        Object r6 = r3.get(r2);
        if (r6 == null) goto L49;
        r4.append(r2).append(" IS NULL OR ");
        r4.append(r2).append(" != ?");
        r5.add(r6.toString());
        goto L42
    L49:
        r4.append(r2).append(" IS NOT NULL");
        goto L42
    L46:
        r15 = false;
        goto L47
    L51:
        r4.append(")");
        this.mContext.getContentResolver().update(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, r3, r4.toString(), (String[]) r5.toArray(new String[0]));     // Catch: Exception -> L54
        return;
    L54:
        e = move-exception;
        if (ContactsUtils.DEBUG == false) goto L58;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("CallLogAdapter", "update call log failed, number = " + r17 + ", where = " + r4 + ", selectionArgs = " + r5, e);
    L59:
        e.printStackTrace();
        return;
    L58:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("CallLogAdapter", "update call log failed", e);
        goto L59
    L39:
        r4.append("countryiso =?");
        r5.add(r18);
        goto L40
    L5:
        if (TextUtils.equals(r19.name, r20.name) == true) goto L7;
        r3.put("name", r19.name);
        r1 = true;
    L9:
        if (r19.type == r20.type) goto L12;
        r3.put("numbertype", Integer.valueOf(r19.type));
        r1 = true;
    L12:
        if (TextUtils.equals(r19.label, r20.label) == true) goto L15;
        r3.put("numberlabel", r19.label);
        r1 = true;
    L15:
        if (TextUtils.equals(r19.location, r20.location) == true) goto L18;
        r3.put("geocoded_location", r19.location);
        r1 = true;
    L18:
        if (UriUtils.areEqual(r19.lookupUri, r20.lookupUri) == true) goto L21;
        r3.put(BlockedCallAdapter.KEY_LOOKUP_URI, UriUtils.uriToString(r19.lookupUri));
        r1 = true;
    L21:
        if (TextUtils.equals(r19.normalizedNumber, r20.normalizedNumber) == true) goto L24;
        r3.put("normalized_number", r19.normalizedNumber);
        r1 = true;
    L24:
        if (TextUtils.equals(r19.number, r20.number) == true) goto L27;
        r3.put("matched_number", r19.number);
        r1 = true;
    L27:
        if (r19.photoId == r20.photoId) goto L30;
        r3.put("photo_id", Long.valueOf(r19.photoId));
        r1 = true;
    L30:
        if (TextUtils.equals(r19.formattedNumber, r20.formattedNumber) == true) goto L34;
        r3.put("formatted_number", r19.formattedNumber);
        goto L33
    L7:
        r1 = false;
        goto L9
    }

    private ContactInfo getContactInfoFromCallLog(Cursor r5) {
        ContactInfo r4 = new ContactInfo();
        r4.lookupUri = UriUtils.parseUriOrNull(r5.getString(11));
        r4.name = r5.getString(8);
        String r0 = r5.getString(9);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        int r1 = 0;
    L6:
        r4.type = r1;
        String r2 = r5.getString(12);
        if (r2 != null) goto L9;
        r2 = r5.getString(1);
    L9:
        r4.number = r2;
        if (r4.number != null) goto L12;
        r4.number = "";
    L12:
        r4.label = r5.getString(10);
        r4.location = r5.getString(7);
        r4.normalizedNumber = r5.getString(13);
        r4.photoId = r5.getLong(14);
        r4.photoUri = null;
        r4.formattedNumber = r5.getString(15);
        r4.presentation = r5.getInt(17);     // Catch: Exception -> L15
    L16:
        return r4;
    L15:
        r4.presentation = 1;
        goto L16
    L5:
        r1 = Integer.parseInt(r0);
        goto L6
    }

    private int[] getCallTypes(Cursor r4, int r5) {
        int r3 = r4.getPosition();
        int[] r0 = new int[r5];
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r0[r1] = r4.getInt(4);
        r4.moveToNext();
        r1 = r1 + 1;
        goto L3
    L5:
        r4.moveToPosition(r3);
        return r0;
    }

    void disableRequestProcessingForTest() {
        this.mRequestProcessingDisabled = true;
    }

    void injectContactInfoForTest(String r2, String r3, ContactInfo r4) {
        NumberWithCountryIso r0 = new NumberWithCountryIso(r2, r3);
        this.mContactInfoCache.put(r0, r4);
    }

    @Override // com.android.common.widget.GroupingListAdapter, com.android.contacts.calllog.CallLogGroupBuilder.GroupCreator
    public void addGroup(int r1, int r2, boolean r3) {
        super.addGroup(r1, r2, r3);
    }

    public String getBetterNumberFromContacts(String r7, String r8) {
        NumberWithCountryIso r0 = new NumberWithCountryIso(r7, r8);
        ContactInfo r9 = this.mContactInfoCache.getPossiblyExpired(r0);
        if (r9 != null) goto L5;
    L7:
        String r10 = null;
        Cursor r6 = this.mContext.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, r7), PhoneQuery._PROJECTION, null, null, null);     // Catch: Exception -> L23
        if (r6 == null) goto L14;
        if (r6.moveToFirst() == false) goto L13;
        r10 = r6.getString(4);     // Catch: Exception -> L23
    L13:
        r6.close();     // Catch: Exception -> L23
    L14:
        String r11 = r10;
    L16:
        if (TextUtils.isEmpty(r11) == false) goto L18;
        return r7;
    L18:
        if (r11.startsWith("+") == true) goto L22;
        if (r11.length() > r7.length()) goto L22;
        return r7;
    L22:
        return r11;
    L5:
        if (r9 == ContactInfo.EMPTY) goto L7;
        r11 = r9.number;
        goto L16
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        hideSwipedViews();
        super.notifyDataSetChanged();
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("CallLogAdapter", "notifyDataSetChanged");
    L5:
        ContactDetailCacheManager.getInstance().refreshCache(this.mHSListView);
        NewCallLogFragment r0 = this.mCallLogFragment;
        if (r0 == null) goto L8;
        r0.dismissLongMenu();
    L8:
        NewDialpadFragment r2 = this.mDialpadFragment;
        if (r2 == null) goto L12;
        r2.dismissLongMenu();
        return;
    }

    @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
    public void onScrollStateChanged(View r1, int r2, int r3) {
        if (r2 != 0) goto L5;
        bindBackgroundItemButtons(r1);
        return;
    }

    private void initBlHandlerIfNeed() {
        if (this.mBlHandler != null) goto L6;
        this.mBlHandler = new BlackListQueryHandler(this.mContext);
        return;
    }

    public void removeFromBlackList(String r2) {
        initBlHandlerIfNeed();
        this.mBlHandler.doRemoveBlacklistAction(r2);
        this.mHSListView.restoreScrollState(true);
        ContactsApplication.showToast(R.string.toast_remove_blacklist_done, 0);
    }

    public void addNumberToBlackList(final PhoneCallDetails r3) {
        if (TextUtils.isEmpty(r3.number.toString().trim()) == false) goto L6;
        this.mHSListView.restoreScrollState(true);
        Toast.makeText(this.mContext, R.string.toast_no_support_blacklist, 0).show();
        return;
    L6:
        OAlertDialogUtils.showDefaultBlacklistConfirmationDialog(this.mContext, new AnonymousClass11(this, r3));
    }

    @Override // com.android.common.widget.GroupingListAdapter, android.widget.Adapter
    public long getItemId(int r3) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("CursorError", "getItemId position = " + r3);
        return super.getItemId(r3);
    }

    private View bindBackgroundItemButtons(final View r6) {
        View r0 = r6.findViewById(R.id.item_background);
        if (r0 != null) goto L6;
        r0 = ((ViewStub) r6.findViewById(R.id.item_background_stub)).inflate();
    L6:
        if ((r6 instanceof CallLogListItemViews) == false) goto L8;
        return null;
    L8:
        CallLogListItemViews r1 = (CallLogListItemViews) r6.findViewById(R.id.primary_action_view);
        if (r6.getTag() != null) goto L11;
    L15:
        return null;
    L11:
        if ((r6.getTag() instanceof PrimaryActionListener) == false) goto L15;
        final PrimaryActionListener r2 = (PrimaryActionListener) r6.getTag();
        final PhoneCallDetails r3 = r2.getPhoneCallDetails();
        ((OButton) r6.findViewById(R.id.umb_message)).setOnClickListener(new AnonymousClass12(this, r3));
        ((OButton) r6.findViewById(R.id.umb_delete)).setOnClickListener(new AnonymousClass13(this, r6, r2));
        return r0;
    }

    public void doRemoveCallLog(final View r3, final PrimaryActionListener r4) {
        HorizontalScrollListView r0 = this.mHSListView;
        if (r0 == null) goto L5;
        r0.playDeleteItemAnimation(new AnonymousClass14(this, r4, r3));
        return;
    L5:
        removeCallLog(r4);
        this.mHSListView.restoreScrollState(true);
    }

    private void removeCallLog(PrimaryActionListener r9) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("CallLogAdapter", "removeCallLog");
    L5:
        long[] r10 = r9.getIds();
        StringBuilder r0 = new StringBuilder("_id IN (");
        int r1 = r10.length;
        boolean r3 = true;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L12;
        long r5 = r10[r4];
        if (r3 == false) goto L10;
        r3 = false;
    L11:
        r0.append(r5);
        r4 = r4 + 1;
        goto L6
    L10:
        r0.append(SimContactsConstants.EMAIL_SEP);
        goto L11
    L12:
        r0.append(")");
        this.mContext.getContentResolver().delete(CallLog.Calls.CONTENT_URI, r0.toString(), null);
    }
}
