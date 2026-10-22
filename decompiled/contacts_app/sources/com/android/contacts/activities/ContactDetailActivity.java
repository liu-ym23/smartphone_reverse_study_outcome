package com.android.contacts.activities;

import android.app.assist.AssistContent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CallLog;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.GlobalProxyLancet;
import com.android.contacts.CallDetailActivity;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsTelephonyUtil;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.R;
import com.android.contacts.calllog.CallLogGroupBuilder;
import com.android.contacts.calllog.CallLogQuery;
import com.android.contacts.calllog.CallLogQueryHandler;
import com.android.contacts.common.model.Contact;
import com.android.contacts.detail.ContactDetailFragment;
import com.android.contacts.detail.ContactDetailStrangerFragment;
import com.android.contacts.detail.ContactLoaderFragment;
import com.android.contacts.detail.FreeCallHelper;
import com.android.contacts.editor.ContactEditorCache;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.IntentUtils;
import com.android.contacts.util.UiUtils;
import com.android.contacts.util.UriUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.callsummary.model.aikernel.AISummary;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import com.obric.contactprovider.ObricCallRecordSummaryDeleteObserver;
import com.obric.contactsdk.loader.CallHistoryEntityUtilKt;
import com.obric.contactsdk.loader.ContactEntityUtilKt;
import com.obric.model.CallFeatureModel;
import com.obric.model.bean.CallFeatureBean;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactPageShowEvent;
import com.obric.ui.OFloatingTitleBarHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.MenuDialog;
import obric.app.MenuDialogListAdapter;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes.dex */
public class ContactDetailActivity extends ContactsActivity implements View.OnClickListener, CallLogQueryHandler.Listener, ContactsTelephonyUtil.VtCapabilityListener {
    public static final String CLOUD_CONTACT_CHECKED = "cloud_contact_checked";
    private static final String DETAIL_FRAGMENT_TAG = "detail";
    public static final String EXTRA_LAUNCH_FROM_SELF = "LAUNCH_FROM_SELF";
    public static final String EXTRA_NEED_LOGIN_SIMILING_ACCOUNT = "NEED_LOGIN_SIMILING_ACCOUNT";
    public static final String INTENT_KEY_FINISH_ACTIVITY_ON_UP_SELECTED = "finishActivityOnUpSelected";
    private static final String LOADER_FRAGMENT_TAG = "loader";
    private static final int REQUEST_CODE_DELETE_CONTACT = 11;
    private static final String STATE_BACK = "STATE_BACK";
    private static final String STATE_CANCEL = "STATE_CANCEL";
    private static final String STATE_CONTACTS = "STATE_CONTACTS";
    private static final String STATE_NONE = "STATE_NONE";
    private static final String STATE_STRANGER = "STATE_STRANGER";
    private static final String STRANGER_FRAGMENT_TAG = "stranger";
    private static final String TAG = "ContactDetailActivity";
    private String enter_from;
    private View mBtnEdit;
    private CallLogQueryHandler mCallLogGroupQueryHandler;
    private ContentObserver mCallLogObserver;
    private CallLogQueryHandler mCallLogQueryHandler;
    private CallLogGroupBuilder mCallLogUpdateGroupBuilder;
    private CallLogQueryHandler.Listener mCallLogUpdateQueryListener;
    private ContactLoader.Result mContactData;
    private final ContactDetailFragment.Listener mContactDetailFragmentListener;
    private Uri mContactUri;
    private ContactDetailFragment.Callback mDetailCallback;
    private ContactDetailFragment mDetailFragment;
    private boolean mDetailFragmentLoaded;
    private ContactDetailStrangerFragment mDetailStrangerFragment;
    private PhoneCallDetails[] mDetails;
    int mDummyResultType;
    boolean mEditRequested;
    private OFloatingTitleBarHolder mFloatingTitleBarHolder;
    private ContactFragmentsCallback mFragmentsCallback;
    private Handler mHandler;
    private long[] mIds;
    private int mInterceptType;
    private boolean mIsCallLogInit;
    private boolean mIsForegroundActivity;
    private boolean mIsHasContact;
    private boolean mIsUpdatingCallLog;
    private boolean mLaunchFromSelf;
    private ContactLoaderFragment mLoaderFragment;
    private final ContactLoaderFragment.ContactLoaderFragmentListener mLoaderFragmentListener;
    private Uri mLookupUri;
    private int mNeedLoginSimilingAccount;
    private ObricCallRecordSummaryDeleteObserver.RecordSummaryChangeListener mRecordChangeListener;
    boolean mShouldUpdateCallLog;
    private ContactDetailStrangerFragment.Callback mStrangerCallback;
    private final CallFeatureModel.CallFeatureModelListener summaryListener;

    /* JADX INFO: renamed from: com.android.contacts.activities.ContactDetailActivity$12, reason: invalid class name */
    public class AnonymousClass12 implements ContactDetailFragment.Listener {
        final /* synthetic */ ContactDetailActivity this$0;

        AnonymousClass12(ContactDetailActivity r1) {
            this.this$0 = r1;
        }

        @Override // com.android.contacts.detail.ContactDetailFragment.Listener
        public void onItemClicked(Intent r7) {
            if (r7 != null) goto L28;
            return;
        L28:
        L26:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactDetailActivity.TAG, "No activity found for intent: " + r7);
            Toast.makeText(this.this$0, R.string.quickcontact_missing_app, 0).show();
            return;
        L7:
            if (ContactsUtils.CAM_CARD_COMPANY_ACTION.equals(r7.getAction()) == false) goto L10;
            Agent.getInstance().onClick(ContactDetailActivity.TAG, Constants.ContactsTracker.EVENT_CONTACTS_COMPANY_QUERY_CLICK);     // Catch: ActivityNotFoundException -> L26
            ContactsUtils.launchCompanySearch(this.this$0, r7);     // Catch: ActivityNotFoundException -> L26
            return;
        L10:
            this.this$0.startActivity(r7);     // Catch: ActivityNotFoundException -> L26
            Uri r2 = r7.getData();     // Catch: ActivityNotFoundException -> L26
            if (r2 == null) goto L17;
            String r3 = r2.getScheme();     // Catch: ActivityNotFoundException -> L26
            if ("mailto".equals(r3) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            ComponentName r5 = r7.getComponent();     // Catch: ActivityNotFoundException -> L26
            if (r5 != null) goto L21;
        L23:
            if (r4 == false) goto L29;
            AnimationUtil.switchActivityAnimation(this.this$0, 1);     // Catch: ActivityNotFoundException -> L26
            return;
        L29:
            return;
        L21:
            if (GroupListActivity.class.getName().equals(r5.getClassName()) == false) goto L23;
            r4 = true;
            goto L23
        L15:
            if ("smsto".equals(r3) == true) goto L16;
        L17:
            r4 = false;
            goto L18
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.android.contacts.activities.ContactDetailActivity$12$1] */
        @Override // com.android.contacts.detail.ContactDetailFragment.Listener
        public void on3rdSocialItemClicked(final String r3, final List<Intent> r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (r4.size() <= 1) goto L9;
            new AnonymousClass1(this, r4, r3).execute(new List[]{r4});
            return;
        }

        @Override // com.android.contacts.detail.ContactDetailFragment.Listener
        public void onCreateRawContactRequested(ArrayList<ContentValues> r4, AccountWithDataSet r5) {
            Toast.makeText(this.this$0, R.string.toast_making_personal_copy, 1).show();
            Intent r6 = ContactSaveService.createNewRawContactIntent(this.this$0, r4, r5, ContactDetailActivity.class, "android.intent.action.VIEW");
            this.this$0.startService(r6);
        }
    }

    public class CheckIfRecordExistsTask extends AsyncTask<Pair, Void, String> {
        private WeakReference<Context> contextWeakReference;
        final /* synthetic */ ContactDetailActivity this$0;

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(String r1) {
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ String doInBackground(Pair[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(String r1) {
            onPostExecute2(r1);
        }

        public CheckIfRecordExistsTask(ContactDetailActivity r1, Context r2) {
            this.this$0 = r1;
            this.contextWeakReference = null;
            this.contextWeakReference = new WeakReference(r2);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected String doInBackground2(Pair... r7) {
            if (r7 != null) goto L5;
        L15:
            return null;
        L5:
            if (r7.length == 0) goto L15;
            WeakReference<Context> r1 = this.contextWeakReference;
            if (r1 == null) goto L15;
            if (r1.get() == null) goto L15;
            int r2 = 0;
        L13:
            if (r2 >= r7.length) goto L15;
            Pair r3 = r7[r2];
            ContactsUtils.checkIfRecordDeleted(this.contextWeakReference.get(), ((Long) r3.first).longValue(), (String) r3.second);
            r2 = r2 + 1;
            goto L13
        }
    }

    public interface FragmentKeyListener {
        boolean handleKeyDown(int r1);
    }

    public void com_android_contacts_activities_ContactDetailActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onPause(this);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent r1) {
        com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onProvideAssistContent(this, r1);
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_ContactDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @Override // com.android.contacts.calllog.CallLogQueryHandler.Listener
    public void onVoicemailStatusFetched(Cursor r1) {
    }

    public ContactDetailActivity() {
        this.mFragmentsCallback = new ContactFragmentsCallback(this);
        this.mHandler = new Handler();
        this.mInterceptType = 0;
        this.mLaunchFromSelf = false;
        this.mNeedLoginSimilingAccount = 0;
        this.mIsHasContact = false;
        this.mDummyResultType = 0;
        this.mEditRequested = false;
        this.mShouldUpdateCallLog = false;
        this.mIsForegroundActivity = false;
        this.mRecordChangeListener = new AnonymousClass1(this);
        this.mIsCallLogInit = false;
        this.mIsUpdatingCallLog = false;
        this.mCallLogUpdateQueryListener = new AnonymousClass7(this);
        final Handler r2 = new Handler();
        this.mCallLogObserver = new AnonymousClass8(this, r2);
        this.summaryListener = new AnonymousClass9(this);
        this.mDetailFragmentLoaded = false;
        this.mLoaderFragmentListener = new AnonymousClass11(this);
        this.mContactDetailFragmentListener = new AnonymousClass12(this);
        this.mStrangerCallback = new AnonymousClass15(this);
        this.mDetailCallback = new AnonymousClass16(this);
    }

    static /* synthetic */ Handler access$000(ContactDetailActivity r0) {
        return r0.mHandler;
    }

    static /* synthetic */ ContactLoaderFragment access$100(ContactDetailActivity r0) {
        return r0.mLoaderFragment;
    }

    static /* synthetic */ View access$1000(ContactDetailActivity r0) {
        return r0.mBtnEdit;
    }

    static /* synthetic */ void access$1100(ContactDetailActivity r0, Cursor r1) {
        r0.updateDetails(r1);
    }

    static /* synthetic */ PhoneCallDetails[] access$1200(ContactDetailActivity r0) {
        return r0.mDetails;
    }

    static /* synthetic */ PhoneCallDetails[] access$1202(ContactDetailActivity r0, PhoneCallDetails[] r1) {
        r0.mDetails = r1;
        return r1;
    }

    static /* synthetic */ void access$1300(ContactDetailActivity r0, List r1, boolean r2) {
        r0.startMakeFreeCall(r1, r2);
    }

    static /* synthetic */ void access$1400(ContactDetailActivity r0, List r1, boolean r2) {
        r0.showVolteCallDialog(r1, r2);
    }

    static /* synthetic */ void access$1500(ContactDetailActivity r0, String r1, boolean r2) {
        r0.callVideo(r1, r2);
    }

    static /* synthetic */ long[] access$1602(ContactDetailActivity r0, long[] r1) {
        r0.mIds = r1;
        return r1;
    }

    static /* synthetic */ OFloatingTitleBarHolder access$1700(ContactDetailActivity r0) {
        return r0.mFloatingTitleBarHolder;
    }

    static /* synthetic */ void access$1800(ContactDetailActivity r0, List r1, boolean r2) {
        r0.actuallyStartMakeFreeCall(r1, r2);
    }

    static /* synthetic */ ContactDetailFragment access$200(ContactDetailActivity r0) {
        return r0.mDetailFragment;
    }

    static /* synthetic */ ContactDetailStrangerFragment access$300(ContactDetailActivity r0) {
        return r0.mDetailStrangerFragment;
    }

    static /* synthetic */ boolean access$400(ContactDetailActivity r0) {
        return r0.mIsCallLogInit;
    }

    static /* synthetic */ boolean access$502(ContactDetailActivity r0, boolean r1) {
        r0.mIsUpdatingCallLog = r1;
        return r1;
    }

    static /* synthetic */ void access$600(ContactDetailActivity r0) {
        r0.updateCallLog();
    }

    static /* synthetic */ Uri access$700(ContactDetailActivity r0) {
        return r0.mLookupUri;
    }

    static /* synthetic */ Uri access$702(ContactDetailActivity r0, Uri r1) {
        r0.mLookupUri = r1;
        return r1;
    }

    static /* synthetic */ boolean access$800(ContactDetailActivity r0) {
        return r0.mLaunchFromSelf;
    }

    static /* synthetic */ void access$900(ContactDetailActivity r0, ContactLoader.Result r1) {
        r0.setContactData(r1);
    }

    public void com_android_contacts_activities_ContactDetailActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.contact_detail_activity);
        UiUtils.setWindowColorStatusBar(this);
        OFloatingTitleBarHolder r0 = new OFloatingTitleBarHolder((OFloatingTitleBar) findViewById(R.id.otitlebar));
        this.mFloatingTitleBarHolder = r0;
        View r8 = r0.addEndAction(STATE_CONTACTS, R.drawable.icon_edit, new AnonymousClass2(this));
        this.mBtnEdit = r8;
        r8.setContentDescription(getString(R.string.common_edit));
        this.mFloatingTitleBarHolder.addEndAction(STATE_CONTACTS, R.drawable.icon_menu_more, new AnonymousClass3(this)).setContentDescription(getString(R.string.more_btn));
        this.mFloatingTitleBarHolder.addStartAction("STATE_BACK", R.drawable.icon_back_22_22, new AnonymousClass4(this)).setContentDescription(getString(R.string.common_back));
        this.mFloatingTitleBarHolder.addStartAction("STATE_CANCEL", R.drawable.icon_cancel_22_22, new AnonymousClass5(this)).setContentDescription(getString(R.string.accessibility_btn_cancel));
        this.mFloatingTitleBarHolder.addEndAction(STATE_STRANGER, R.drawable.icon_menu_more, new AnonymousClass6(this)).setContentDescription(getString(R.string.more_btn));
        this.mFloatingTitleBarHolder.startButtonToState("STATE_BACK");
        initIntent(getIntent());
        ContactsApplication.getInstance().getTelephonyUtil().registerVtCapbilityListener(this);
        if (this.mShouldUpdateCallLog == false) goto L5;
        getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI, true, this.mCallLogObserver);
    L5:
        ObricCallRecordSummaryDeleteObserver.addRecordChangeListener(this.mRecordChangeListener);
    }

    private void ifFirstSaveContact() {
        Settings.System.putInt(getContentResolver(), CLOUD_CONTACT_CHECKED, 1);
    }

    private void updateCallLog() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "update call log");
        if (this.mCallLogGroupQueryHandler != null) goto L5;
        this.mCallLogGroupQueryHandler = new CallLogQueryHandler(getContentResolver(), this.mCallLogUpdateQueryListener);
    L5:
        this.mCallLogGroupQueryHandler.fetchAllCalls();
    }

    public void updateIds(Cursor r39) {
        if (r39 == null) goto L5;
        int r3 = 0;
        if (r39.getCount() > 0) goto L86;
        this.mIds = new long[0];
        this.mDetails = new PhoneCallDetails[0];
        if (isFinishing() == true) goto L84;
        notifyFragmentCallLogChanged();
    L84:
        r39.close();
        return;
    L86:
    L76:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L74
    L78:
        r39.close();
        return;
    L74:
        th = move-exception;
        r39.close();
        throw th;
    L11:
        if (this.mCallLogUpdateGroupBuilder != null) goto L13;
        this.mCallLogUpdateGroupBuilder = new CallLogGroupBuilder(null, null);     // Catch: Throwable -> L74 Exception -> L76
    L13:
        PhoneCallDetails[] r2 = this.mDetails;     // Catch: Throwable -> L74 Exception -> L76
        if (r2 != null) goto L16;
    L72:
        r39.close();
        return;
    L16:
        if (r2.length == 0) goto L72;
        long[] r4 = this.mIds;     // Catch: Throwable -> L74 Exception -> L76
        if (r4 != null) goto L21;
    L70:
        r39.close();
        return;
    L21:
        if (r4.length == 0) goto L70;
        int r5 = 1;
        PhoneCallDetails r6 = r2[r2.length - 1];     // Catch: Throwable -> L74 Exception -> L76
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L74 Exception -> L76
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L74 Exception -> L76
        PhoneCallDetails[] r9 = this.mDetails;     // Catch: Throwable -> L74 Exception -> L76
        int r10 = r9.length;     // Catch: Throwable -> L74 Exception -> L76
        long r11 = Long.MIN_VALUE;
        long r12 = Long.MAX_VALUE;
        int r13 = 0;
    L24:
        if (r13 >= r10) goto L26;
        long r14 = r9[r13].date;     // Catch: Throwable -> L74 Exception -> L76
        r11 = Math.max(r11, r14);     // Catch: Throwable -> L74 Exception -> L76
        r12 = Math.min(r12, r14);     // Catch: Throwable -> L74 Exception -> L76
        r13 = r13 + 1;     // Catch: Throwable -> L74 Exception -> L76
        goto L24
    L26:
        long r15 = r11;
    L28:
        if (r39.moveToNext() == false) goto L62;
        String r16 = r39.getString(r5);     // Catch: Throwable -> L74 Exception -> L76
        if (r16 == null) goto L62;
        long r17 = r39.getLong(r3);     // Catch: Throwable -> L74 Exception -> L76
        long r33 = r39.getLong(2);     // Catch: Throwable -> L74 Exception -> L76
        long r22 = r39.getLong(3);     // Catch: Throwable -> L74 Exception -> L76
        int r18 = r39.getInt(4);     // Catch: Throwable -> L74 Exception -> L76
        String r19 = r39.getString(7);     // Catch: Throwable -> L74 Exception -> L76
        ArrayList r35 = r8;
        String r20 = r39.getString(10);     // Catch: Throwable -> L74 Exception -> L76
        if (TextUtils.isEmpty(r19) == true) goto L35;
        String r26 = CallHistoryEntityUtilKt.filterAdministrativeDivision(r19);     // Catch: Throwable -> L74 Exception -> L76
    L36:
        PhoneCallDetails r21 = new PhoneCallDetails(r16, "", "", "", new int[]{r18}, r33, r22, "", -1, r26, UriUtils.parseUriOrNull(r39.getString(11)), null, -1, -1, ContactsUtils.checkIfRecordExists(this, r17, r39.getString(30)));     // Catch: Throwable -> L74 Exception -> L76
        if (DSUtils.isMultiSimEnabled() == false) goto L43;
        r21.simId = DSUtils.getSimSlotId(this, CallLogQuery.getSubscription(r39), r39.getString(28));     // Catch: Throwable -> L74 Exception -> L76
        if (r39.getInt(27) != 1) goto L41;
        boolean r23 = true;
    L42:
        r21.showSimId = r23;     // Catch: Throwable -> L74 Exception -> L76
        goto L43
    L41:
        r23 = false;
    L43:
        r21.blockedType = r39.getInt(29);     // Catch: Throwable -> L74 Exception -> L76
        r21.isVideoCall = CallLogQuery.isVideoCall(r39);     // Catch: Throwable -> L74 Exception -> L76
        boolean r24 = this.mCallLogUpdateGroupBuilder.isTheSameGroup(r6, r21);     // Catch: Throwable -> L74 Exception -> L76
        if (r33 >= r12) goto L46;
    L51:
        ArrayList r110 = r35;
        int r111 = 1;
    L53:
        if (r33 >= r11) goto L55;
    L56:
        if (r33 < r12) goto L61;
        if (r33 > r15) goto L61;
    L59:
        if (r24 == false) goto L61;
        r7.add(r21);     // Catch: Throwable -> L74 Exception -> L76
        r110.add(Long.valueOf(r17));     // Catch: Throwable -> L74 Exception -> L76
        r15 = r21.date;     // Catch: Throwable -> L74 Exception -> L76
    L61:
        r5 = r111;
        r8 = r110;
        r3 = 0;
        goto L28
    L55:
        if (r33 >= r15) goto L59;
    L46:
        if (r33 >= r15) goto L51;
        if (r33 < r11) goto L51;
        if (r24 == true) goto L51;
        r111 = 1;
        r7.remove(r7.size() - 1);     // Catch: Throwable -> L74 Exception -> L76
        r110 = r35;
        r110.remove(r35.size() - 1);     // Catch: Throwable -> L74 Exception -> L76
        r15 = r11;
        goto L53
    L35:
        r26 = r20;
    L62:
        ArrayList r112 = r8;
        PhoneCallDetails[] r25 = new PhoneCallDetails[r7.size()];     // Catch: Throwable -> L74 Exception -> L76
        long[] r27 = new long[r112.size()];     // Catch: Throwable -> L74 Exception -> L76
        int r28 = 0;
    L64:
        if (r28 >= r112.size()) goto L66;
        r27[r28] = ((Long) r112.get(r28)).longValue();     // Catch: Throwable -> L74 Exception -> L76
        r25[r28] = (PhoneCallDetails) r7.get(r28);     // Catch: Throwable -> L74 Exception -> L76
        r28 = r28 + 1;     // Catch: Throwable -> L74 Exception -> L76
        goto L64
    L66:
        this.mIds = r27;     // Catch: Throwable -> L74 Exception -> L76
        this.mDetails = r25;     // Catch: Throwable -> L74 Exception -> L76
        if (isFinishing() == true) goto L78;
        notifyFragmentCallLogChanged();     // Catch: Throwable -> L74 Exception -> L76
    L5:
        if (ContactsUtils.DEBUG == false) goto L97;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "update call log's cursor is null!!");
        return;
    }

    public void com_android_contacts_activities_ContactDetailActivity__onResume$___twin___() {
        super.onResume();
        this.mIsForegroundActivity = true;
        CallFeatureModel.INSTANCE.addCallFeatureModelListener(this.summaryListener);
        notifyFragmentCallLogChanged();
        if (this.mShouldUpdateCallLog == false) goto L5;
        updateCallLog();
    L5:
        EventTrackerManager.INSTANCE.track(new ContactPageShowEvent(this.enter_from, TAG, "", ""));
    }

    public void com_android_contacts_activities_ContactDetailActivity__onPause$___twin___() {
        super.onPause();
        this.mIsForegroundActivity = false;
        CallFeatureModel.INSTANCE.removeCallFeatureModelListener(this.summaryListener);
    }

    public void com_android_contacts_activities_ContactDetailActivity__finish$___twin___() {
        super.finish();
        if (this.mLaunchFromSelf == true) goto L6;
        overridePendingTransition(0, R.anim.activity_slide_out_to_bottom);
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mIsForegroundActivity == true) goto L5;
        return;
    L5:
        if (ContactsUtils.DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onBackPressed");
    L7:
        super.onBackPressed();
    }

    public void com_android_contacts_activities_ContactDetailActivity__onNewIntent$___twin___(Intent r1) {
        super.onNewIntent(r1);
        setIntent(r1);
        initIntent(r1);
    }

    private void initIntent(Intent r6) {
        if (r6 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "return for null intent");
        return;
    L6:
        this.mLookupUri = r6.getData();
        this.mLaunchFromSelf = IntentUtils.getBooleanExtra(r6, EXTRA_LAUNCH_FROM_SELF, false);
        this.mNeedLoginSimilingAccount = IntentUtils.getIntExtra(r6, EXTRA_NEED_LOGIN_SIMILING_ACCOUNT, 1);
        this.enter_from = r6.getStringExtra("enter_from");
        Uri r1 = this.mLookupUri;
        if (r1 != null) goto L9;
    L12:
        this.mIsHasContact = false;
        Uri r2 = this.mLookupUri;
        if (r2 == null) goto L17;
        Contact r3 = com.android.contacts.common.model.ContactLoader.parseEncodedContactEntity(r2);
        if (r3 == null) goto L17;
        r6.putExtra(ContactsUtils.EXTRA_PHONE_NUMBERS, r3.getDisplayName());
    L17:
        updateTitleBar(this.mIsHasContact);
        this.mInterceptType = r6.getIntExtra(ContactsUtils.EXTRA_INTERCEPT_TYPE, 0);
        this.mIds = r6.getLongArrayExtra(CallDetailActivity.EXTRA_CALL_LOG_IDS);
        if (this.mInterceptType <= 0) goto L20;
        boolean r4 = true;
    L21:
        beginLoadFragment(this.mIsHasContact);
        if (r4 == false) goto L24;
        preLoadBlockedCallLogDetails(this.mIds);
    L32:
        if (this.mNeedLoginSimilingAccount != 0) goto L35;
        ifFirstSaveContact();
    L35:
        if (this.mIsHasContact == true) goto L37;
    L54:
        this.mDummyResultType = 0;
        return;
    L37:
        if (ContactEditorCache.getInstance().getResult() == null) goto L51;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "dummy is not null.");
        Uri r7 = ContactEditorCache.getInstance().getLookupUri();
        if (r7 != null) goto L41;
    L43:
        if (r7 == null) goto L45;
    L47:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "stale cache detected, clearing and loading from provider");
        ContactEditorCache.getInstance().clear();
        ContactLoaderFragment r8 = this.mLoaderFragment;
        if (r8 == null) goto L58;
        r8.loadUri(this.mLookupUri);
        return;
    L58:
        return;
    L45:
        if (isDummyLookupUri(this.mLookupUri) == false) goto L47;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "use unsaved dummy");
        this.mDummyResultType = 1;
        ContactEditorCache.getInstance().setListener(new AnonymousClass10(this));
        return;
    L41:
        if (r7.equals(this.mLookupUri) == false) goto L43;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "use saved dummy");
        this.mDummyResultType = 2;
        return;
    L51:
        ContactLoaderFragment r9 = this.mLoaderFragment;
        if (r9 == null) goto L54;
        r9.loadUri(this.mLookupUri);
        goto L54
    L24:
        preLoadCallLogDetails(this.mIds);
        if (this.mIds == null) goto L27;
        CallLogQueryHandler r10 = new CallLogQueryHandler(getContentResolver(), this);
        this.mCallLogQueryHandler = r10;
        r10.fetchCallsByIds(this.mIds);
        this.mShouldUpdateCallLog = true;
        goto L32
    L27:
        String r11 = r6.getStringExtra("phone");
        if (TextUtils.isEmpty(r11) == true) goto L30;
        CallLogQueryHandler r5 = new CallLogQueryHandler(getContentResolver(), this);
        this.mCallLogQueryHandler = r5;
        r5.fetchCallsByNumber(r11);
    L30:
        this.mShouldUpdateCallLog = false;
        goto L32
    L20:
        r4 = false;
        goto L21
    L9:
        if (r1.getLastPathSegment().equals("encoded") == true) goto L12;
        this.mIsHasContact = true;
        goto L17
    }

    private boolean isDummyLookupUri(Uri r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        List<String> r0 = r4.getPathSegments();
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.size() >= 4) goto L10;
        return false;
    L10:
        if (r0.get(2).startsWith(Constants.DUMMY_LOOKUP_KEY_PREFIX) == true) goto L12;
        return false;
    L12:
        if (String.valueOf(0).equals(r4.getLastPathSegment()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private void preLoadCallLogDetails(long[] r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.length == 0) goto L13;
        int r1 = 4;
        if (r3.length > 4) goto L10;
        r1 = r3.length;
    L10:
        long[] r4 = Arrays.copyOf(r3, r1);
        this.mDetails = ContactDetailCacheManager.getInstance().getPhoneCallDetails(r4);
        return;
    }

    private void preLoadBlockedCallLogDetails(long[] r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.length == 0) goto L13;
        int r1 = 4;
        if (r3.length > 4) goto L10;
        r1 = r3.length;
    L10:
        long[] r4 = Arrays.copyOf(r3, r1);
        this.mDetails = ContactDetailCacheManager.getInstance().getBlockedCallDetails(r4);
        return;
    }

    private void updateTitleBar(boolean r2) {
        OTextView r0 = this.mFloatingTitleBarHolder.getCenterTitleView();
        if (r2 == false) goto L7;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        this.mFloatingTitleBarHolder.endButtonToState(STATE_CONTACTS);
    L11:
        if (this.mLaunchFromSelf == true) goto L14;
        this.mFloatingTitleBarHolder.startButtonToState("STATE_CANCEL");
        return;
    L14:
        return;
    L7:
        if (r0 == null) goto L9;
        r0.setVisibility(8);
    L9:
        this.mFloatingTitleBarHolder.endButtonToState(STATE_STRANGER);
        goto L11
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.mCallLogQueryHandler == null) goto L15;
        long[] r0 = this.mIds;
        if (r0 == null) goto L10;
        if (this.mIsUpdatingCallLog == true) goto L10;
        checkRecord(r0, this.mDetails);
        return;
    L10:
        if (getIntent() == null) goto L17;
        String r1 = getIntent().getStringExtra("phone");
        if (TextUtils.isEmpty(r1) == true) goto L18;
        this.mCallLogQueryHandler.fetchCallsByNumber(r1);
        return;
    L18:
        return;
    L17:
        return;
    }

    private void checkRecord(long[] r7, PhoneCallDetails[] r8) {
        if (r7.length <= 0) goto L28;
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.length <= 0) goto L30;
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L9:
        if (r2 >= r7.length) goto L19;
        if (r2 >= r8.length) goto L19;
        PhoneCallDetails r3 = r8[r2];
        if (r3 == null) goto L17;
        if (TextUtils.isEmpty(r3.recordUri) == true) goto L17;
        r0.add(new Pair(Long.valueOf(r7[r2]), r8[r2].recordUri));
    L17:
        r2 = r2 + 1;
    L19:
        if (r0.size() > 0) goto L21;
        return;
    L21:
        new CheckIfRecordExistsTask(this, this).execute((Pair[]) r0.toArray(new Pair[0]));
        return;
    L30:
        return;
    }

    private void beginLoadFragment(boolean r1) {
        if (r1 == false) goto L4;
        this.mDetailFragmentLoaded = false;
        startDetailFragment();
        startLoaderFragment();
        return;
    L4:
        startStrangerFragment();
    }

    private void startLoaderFragment() {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "startLoaderFragment");
    L5:
        preLoadFragment("ContactLoaderFragment");
        ContactLoaderFragment r0 = (ContactLoaderFragment) getSupportFragmentManager().findFragmentByTag(LOADER_FRAGMENT_TAG);
        this.mLoaderFragment = r0;
        if (r0 != null) goto L9;
        FragmentTransaction r2 = getSupportFragmentManager().beginTransaction();
        r2.add(new ContactLoaderFragment(), LOADER_FRAGMENT_TAG);
        r2.commit();
        return;
    }

    private void startDetailFragment() {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "startDetailFragment");
    L5:
        preLoadFragment(ContactDetailFragment.TAG);
        ContactDetailFragment r0 = (ContactDetailFragment) getSupportFragmentManager().findFragmentByTag("detail");
        this.mDetailFragment = r0;
        if (r0 != null) goto L8;
        this.mDetailFragment = new ContactDetailFragment();
    L8:
        this.mDetailFragment.setListener(this.mContactDetailFragmentListener);
        this.mDetailFragment.setFragmentsCallback(this.mFragmentsCallback);
        this.mDetailFragment.setCallback(this.mDetailCallback);
        FragmentTransaction r1 = getSupportFragmentManager().beginTransaction();
        r1.replace(R.id.contact_detail_container, this.mDetailFragment, "detail");
        r1.commitAllowingStateLoss();
        getSupportFragmentManager().executePendingTransactions();
    }

    private void startStrangerFragment() {
        preLoadFragment("ContactDetailStrangerFragment");
        ContactDetailStrangerFragment r0 = (ContactDetailStrangerFragment) getSupportFragmentManager().findFragmentByTag(STRANGER_FRAGMENT_TAG);
        this.mDetailStrangerFragment = r0;
        if (r0 != null) goto L5;
        this.mDetailStrangerFragment = new ContactDetailStrangerFragment();
        boolean r1 = false;
    L6:
        this.mDetailStrangerFragment.setCallback(this.mStrangerCallback);
        if (r1 == true) goto L10;
        FragmentTransaction r2 = getSupportFragmentManager().beginTransaction();
        r2.replace(R.id.contact_detail_container, this.mDetailStrangerFragment, STRANGER_FRAGMENT_TAG);
        r2.commitAllowingStateLoss();
        getSupportFragmentManager().executePendingTransactions();
        return;
    L10:
        return;
    L5:
        r1 = true;
        goto L6
    }

    private void preLoadFragment(String r3) {
        if (isDestroyed() == true) goto L5;
        return;
    L5:
        if (ContactsUtils.DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Activity is finish, so return. And " + r3 + " not attached.");
    L7:
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment r3) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onAttachFragment: " + r3.getClass().getName());
    L6:
        if ((r3 instanceof ContactLoaderFragment) == false) goto L30;
        if (this.mDetailFragmentLoaded == true) goto L13;
        ContactDetailFragment r0 = this.mDetailFragment;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.isAdded() == true) goto L13;
        return;
    L13:
        ContactLoaderFragment r4 = (ContactLoaderFragment) r3;
        this.mLoaderFragment = r4;
        r4.setListener(this.mLoaderFragmentListener);
        if (getIntent().getBooleanExtra(EXTRA_LAUNCH_FROM_SELF, false) == false) goto L16;
        this.mContactData = ContactDetailCacheManager.getInstance().getResult(this.mLookupUri);
    L16:
        ContactLoader.Result r5 = this.mContactData;
        if (r5 == null) goto L19;
        this.mLoaderFragment.preLoadSuccess(r5);
        return;
    L19:
        if (this.mDummyResultType == 0) goto L27;
        ContactLoader.Result r6 = ContactEditorCache.getInstance().getResult();
        if (ContactEditorCache.getInstance().getRingtone() == null) goto L23;
        String r1 = ContactEditorCache.getInstance().getRingtone().toSafeString();
    L24:
        r6.mCustomRingtone = r1;
        this.mLoaderFragment.preLoadSuccess(r6);
        if (this.mDummyResultType != 2) goto L35;
        this.mDummyResultType = 0;
        ContactEditorCache.getInstance().clear();
        return;
    L35:
        return;
    L23:
        r1 = null;
        goto L24
    L27:
        this.mLoaderFragment.loadUri(this.mLookupUri);
        return;
    L30:
        if ((r3 instanceof ContactDetailFragment) == false) goto L39;
        this.mDetailFragmentLoaded = true;
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (this.mIsHasContact == false) goto L11;
        ContactLoaderFragment r0 = this.mLoaderFragment;
        if (r0 == null) goto L11;
        if (r0.handleKeyDown(r2) == false) goto L11;
        return true;
    L11:
        return super.onKeyDown(r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r3, int r4, Intent r5) {
        if (r3 == 11) goto L5;
    L14:
        super.onActivityResult(r3, r4, r5);
        return;
    L5:
        if (r4 != (-1)) goto L14;
        if (r5 == null) goto L14;
        if (r5.getBooleanExtra("deleted", false) == false) goto L14;
        if (ContactsUtils.DEBUG == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "contact deleted, finish detail activity");
    L12:
        finish();
    }

    private void setContactData(ContactLoader.Result r2) {
        this.mContactData = r2;
        Uri r0 = this.mContactUri;
        Uri r3 = r2.getLookupUri();
        this.mContactUri = r3;
        boolean r4 = !UriUtils.areEqual(r0, r3);
        ContactDetailFragment r1 = this.mDetailFragment;
        if (r1 == null) goto L8;
        if (r4 == false) goto L6;
        r1.resetAdapter();
    L6:
        this.mDetailFragment.setData(this.mContactUri, this.mContactData);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.contacts.activities.ContactDetailActivity$13] */
    @Override // com.android.contacts.calllog.CallLogQueryHandler.Listener
    public void onCallsFetched(final Cursor r2) {
        new AnonymousClass13(this, r2).start();
    }

    private void updateDetails(Cursor r28) {
        if (r28 == null) goto L29;
        PhoneCallDetails[] r2 = new PhoneCallDetails[r28.getCount()];
    L26:
        th = move-exception;
        r28.close();
        throw th;
    L6:
        if (r28.moveToFirst() == false) goto L25;
        int r4 = 0;
    L8:
        String r6 = r28.getString(1);     // Catch: Throwable -> L26
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        String r8 = r6;
        long r7 = r28.getLong(0);     // Catch: Throwable -> L26
        long r13 = r28.getLong(2);     // Catch: Throwable -> L26
        long r15 = r28.getLong(3);     // Catch: Throwable -> L26
        int r9 = r28.getInt(4);     // Catch: Throwable -> L26
        String r10 = r28.getString(7);     // Catch: Throwable -> L26
        String r11 = r28.getString(10);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r10) == true) goto L14;
        String r19 = CallHistoryEntityUtilKt.filterAdministrativeDivision(r10);     // Catch: Throwable -> L26
    L15:
        r2[r4] = new PhoneCallDetails(r8, "", "", "", new int[]{r9}, r13, r15, "", -1, r19, UriUtils.parseUriOrNull(r28.getString(11)), null, -1, -1, ContactsUtils.checkIfRecordExists(this, r7, r28.getString(30)));     // Catch: Throwable -> L26
        if (DSUtils.isMultiSimEnabled() == false) goto L22;
        r2[r4].simId = DSUtils.getSimSlotId(this, CallLogQuery.getSubscription(r28), r28.getString(28));     // Catch: Throwable -> L26
        PhoneCallDetails r12 = r2[r4];     // Catch: Throwable -> L26
        if (r28.getInt(27) != 1) goto L20;
        boolean r14 = true;
    L21:
        r12.showSimId = r14;     // Catch: Throwable -> L26
        goto L22
    L20:
        r14 = false;
    L22:
        r2[r4].blockedType = r28.getInt(29);     // Catch: Throwable -> L26
        r2[r4].isVideoCall = CallLogQuery.isVideoCall(r28);     // Catch: Throwable -> L26
        r4 = r4 + 1;     // Catch: Throwable -> L26
        if (r28.moveToNext() == true) goto L8;
        this.mIsCallLogInit = true;     // Catch: Throwable -> L26
        goto L25
    L14:
        r19 = r11;
    L25:
        r28.close();
        this.mDetails = r2;
        this.mHandler.post(new AnonymousClass14(this));
        return;
    }

    public void notifyFragmentCallLogChanged() {
        ContactDetailFragment r0 = this.mDetailFragment;
        if (r0 == null) goto L5;
        r0.refreshCallLog();
    L5:
        ContactDetailStrangerFragment r1 = this.mDetailStrangerFragment;
        if (r1 == null) goto L9;
        r1.refreshCallLog();
        return;
    }

    private void startMakeFreeCall(List<String> r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        boolean r1 = true;
        if (ContactsUtils.isFeaturePhoneMode() == false) goto L8;
        ContactsApplication.showToast(ContactsUtils.getFeaturePhoneModeHintId(), 1);
        return;
    L8:
        int r0 = ContactsUtils.getNetworkType(this);
        if (Settings.Global.getInt(getContentResolver(), "only_allow_wifi_for_voip_call", 1) == 1) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L15;
        if (r0 != 0) goto L15;
        showRequireMobileDataDialog(r5, r6);
        return;
    L15:
        actuallyStartMakeFreeCall(r5, r6);
    }

    private void showRequireMobileDataDialog(final List<String> r3, final boolean r4) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(this);
        r0.setMessage(R.string.dialog_msg_require_mobile_data);
        r0.setPositiveButton(android.R.string.ok, new AnonymousClass17(this, r3, r4));
        r0.setNegativeButton(android.R.string.cancel, null);
        r0.show();
    }

    private void actuallyStartMakeFreeCall(List<String> r4, boolean r5) {
        if (r4.size() != 1) goto L9;
        if (r5 == true) goto L9;
        if (TextUtils.isEmpty(r4.get(0)) == false) goto L8;
        return;
    L8:
        startActivity(FreeCallHelper.getFreeCallIntent(r4.get(0)));
        return;
    L9:
        ArrayList r6 = new ArrayList(r4.size());
        Iterator<String> r0 = r4.iterator();
    L11:
        if (r0.hasNext() == false) goto L13;
        final String r1 = r0.next();
        r6.add(new AnonymousClass18(this, r1));
        goto L11
    L13:
        MenuDialog r2 = new MenuDialog(this);
        r2.setTitle(R.string.free_call_dialog_title);
        r2.setAdapter(new MenuDialogListAdapter(this, r4, r6));
        r2.show();
    }

    private void showVolteCallDialog(List<String> r5, final boolean r6) {
        if (r5.size() == 1) goto L5;
        ArrayList r0 = new ArrayList(r5.size());
        Iterator<String> r1 = r5.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        final String r2 = r1.next();
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r0.add(new AnonymousClass19(this, r2, r6));
        goto L9
    L13:
        OInsetSheet r7 = new OInsetSheet(this);
        r7.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        r7.setHeaderView(getStartHeaderView(r7, R.string.volte_call_dialog_title));
        r7.setContainerView(getStartContentView(r5, r0));
        r7.setFooterView(null);
        r7.show();
        return;
    L5:
        if (TextUtils.isEmpty(r5.get(0)) == true) goto L20;
        callVideo(r5.get(0), r6);
        return;
    }

    private void callVideo(String r7, boolean r8) {
        Intent r0 = DSUtils.getSelectSimDialogIntentIfNeeded(this, null, r7, r8, true);
        if (r0 == null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "callVideo show select sim dialog, isStranger=" + r8);
        startActivity(r0);
        return;
    L7:
        if (DSUtils.isSimManualSelectMode() == true) goto L9;
        startActivity(ContactsIntentUtils.newDialVoltePhoneIntent(r7));
        return;
    L9:
        if (ContactsUtils.isSingleSimVtCapable() == false) goto L11;
        startActivity(DSUtils.getCallIntent(this, r7, ContactsUtils.getSingleVtCapableSimCardId(), r8, true));
        return;
    L11:
        ContactsUtils.showSelectSimDialog(this, null, r7, 1, r8, true);
    }

    private View getStartContentView(List<String> r10, List<View.OnClickListener> r11) {
        LinearLayout r0 = new LinearLayout(this);
        r0.setOrientation(1);
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(this, 5.0d));
        int r3 = Math.min(r10.size(), r11.size());
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        OButton r6 = (OButton) LayoutInflater.from(this).inflate(R.layout.sheet_button_left_center_black, null);
        r6.setText(r10.get(r5));
        r6.setOnClickListener(r11.get(r5));
        r6.setWidth(ContactsUtils.dipTopx(this, 296.0d));
        r6.setHeight(ContactsUtils.dipTopx(this, 56.0d));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        r7.gravity = 17;
        r7.bottomMargin = ContactsUtils.dipTopx(this, 5.0d);
        r0.addView(r6, r7);
        r5 = r5 + 1;
        goto L3
    L5:
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(this, 15.0d));
        return r0;
    }

    private View getStartHeaderView(final OInsetSheet r3, int r4) {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(this);
        r0.setShowLeftBack(false);
        r0.setTitleText(getString(r4));
        OButton r5 = r0.createNeutralButton(this, r0.mRightContainer);
        r5.setButtonSourceBitmap(R.drawable.o_ic_close);
        r5.setOnClickListener(new AnonymousClass20(this, r3));
        return r0;
    }

    public void com_android_contacts_activities_ContactDetailActivity__onDestroy$___twin___() {
        ContactsApplication.getInstance().getTelephonyUtil().unRegisterVtCapbilityListener(this);
        getContentResolver().unregisterContentObserver(this.mCallLogObserver);
        ObricCallRecordSummaryDeleteObserver.removeRecordChangeListener(this.mRecordChangeListener);
        super.onDestroy();
    }

    @Override // com.android.contacts.ContactsTelephonyUtil.VtCapabilityListener
    public void onVtCapabilityChanged(int r1, boolean r2) {
        this.mHandler.post(new AnonymousClass21(this));
    }

    public void com_android_contacts_activities_ContactDetailActivity__onProvideAssistContent$___twin___(AssistContent r1) {
        super.onProvideAssistContent(r1);
        provideData(r1);
    }

    public void provideData(AssistContent r23) {
        String r3 = TAG;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onProvideAssistContent: ContactDetailActivity call ");
        ContactLoader.Result r2 = this.mContactData;
        if (r2 == null) goto L10;
        Long r4 = Long.valueOf(r2.mNameRawContactId);
        if (this.mContactData.mIsUserProfile == false) goto L7;
        ArrayList r5 = new ArrayList();
        r5.add(Long.valueOf(this.mContactData.mNameRawContactId));
        r4 = Long.valueOf(ContactEntityUtilKt.getProfileContactsId(this, r5));
    L7:
        ContactEntity r6 = ContactEntityUtilKt.queryContactById(getContentResolver(), r4.longValue(), this.mContactData.mIsUserProfile, !this.mContactData.mIsUserProfile);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onProvideAssistContent: raw id " + this.mContactData.mNameRawContactId + " contact id " + r4 + " profile: " + this.mContactData.mIsUserProfile);
        ArrayList r7 = new ArrayList();
        if (r6 == null) goto L11;
        r7.add(r6);
    L11:
        PhoneCallDetails[] r8 = this.mDetails;
        if (r8 != null) goto L14;
    L37:
        ArrayList<AppEntity> r0 = new ArrayList();
        if (r7 == null) goto L40;
        r0 = new ArrayList(r7);
    L40:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onProvideAssistContent: Contacts size = " + r0.size());
        EntityProvider.INSTANCE.donateOnScreenData(r23, r0);
        return;
    L14:
        if (r8.length <= 0) goto L37;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onProvideAssistContent: mDetails size = " + this.mDetails.length);
        ArrayList<AppEntity> r9 = new ArrayList();
        PhoneCallDetails[] r15 = this.mDetails;
        int r14 = r15.length;
        int r13 = 0;
    L16:
        if (r13 >= r14) goto L36;
        PhoneCallDetails r12 = r15[r13];
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r3, "onProvideAssistContent: inner detail");
        if (r12 == null) goto L34;
        List<String> r17 = updatePhoneNumberType(Collections.singletonList(r12.number.toString()), r7);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r3, "onProvideAssistContent number");
        String r10 = CallHistoryEntityUtilKt.getCallLogIdByTimestamp(this, r12.date);
        CallTypeEnum r18 = CallHistoryEntityUtilKt.callTypeToDesc(r12.callTypes[0], r12.duration);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r3, "onProvideAssistContent: CallLog type ");
        if (r18 == null) goto L34;
        if (r10 == null) goto L34;
        ArrayList<AppEntity> r19 = r9;
        int r11 = r13;
        CallHistoryEntity r16 = new CallHistoryEntity(r10, r12.date, r12.date, r17, r7, r18, (int) r12.duration);
        CharSequence r20 = r12.numberLabel;
        if (r20 == null) goto L25;
        r16.setCarriers(Collections.singletonList(r20.toString()));
    L25:
        CallFeatureBean r21 = CallFeatureModel.INSTANCE.getCallFeature(r12.date, r12.number.toString());
        if (r21 == null) goto L33;
        String r22 = r21.getSummary().getSummaryStr();
        String r24 = r21.getSummary().getTitle();
        if (AISummary.INSTANCE.isLocalSuccess(this, r21.getSummary()) == true) goto L30;
        r22 = null;
    L30:
        r16.setHasTranscript(!TextUtils.isEmpty(r22));
        r16.setTranscript(r22);
        r16.setTodoList(r21.getSummary().getTodoListStr());
        if (TextUtils.isEmpty(r24) == true) goto L33;
        r16.setTranscriptTitle(r24);
    L33:
        ArrayList<AppEntity> r25 = r19;
        r25.add(r16);
    L35:
        r13 = r11 + 1;
        r9 = r25;
        r3 = r3;
        r15 = r15;
        r14 = r14;
    L34:
        r25 = r9;
        r11 = r13;
        goto L35
    L36:
        EntityProvider.INSTANCE.donateOnScreenData(r23, r9);
        return;
    L10:
        r7 = null;
        goto L11
    }

    private List<String> updatePhoneNumberType(List<String> r4, List<ContactEntity> r5) {
        if (r4 != null) goto L4;
    L17:
        return r4;
    L4:
        if (r4.size() == 0) goto L17;
        int r0 = 0;
        if (r5 != null) goto L9;
    L11:
        ContactEntity r6 = null;
    L12:
        ArrayList r1 = new ArrayList();
    L14:
        if (r0 >= r4.size()) goto L16;
        r1.add(CallHistoryEntityUtilKt.formatNumber(this, r4.get(r0), r6));
        r0 = r0 + 1;
        goto L14
    L16:
        return r1;
    L9:
        if (r5.size() <= 0) goto L11;
        r6 = r5.get(0);
        goto L12
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onCreate(ContactDetailActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_ContactDetailActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_ContactDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ContactDetailActivity r1) {
        com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onResume(ContactDetailActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_activities_ContactDetailActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public static void com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onPause(ContactDetailActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r2.com_android_contacts_activities_ContactDetailActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onStop(ContactDetailActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_ContactDetailActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onDestroy(ContactDetailActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_activities_ContactDetailActivity__onDestroy$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_finish(ContactDetailActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_activities_ContactDetailActivity__finish$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onNewIntent")
    public static void com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(ContactDetailActivity r2, Intent r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r3);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_ContactDetailActivity__onNewIntent$___twin___(r3);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onProvideAssistContent")
    public static void com_android_contacts_activities_ContactDetailActivity_com_obric_privacyhook_PrivacyHook_onProvideAssistContent(ContactDetailActivity r2, AssistContent r3) {
        Intrinsics.checkNotNullParameter(r3, "outContent");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superOnProvideAssistContent(r3);
        return;
    L6:
        r2.com_android_contacts_activities_ContactDetailActivity__onProvideAssistContent$___twin___(r3);
    }
}
