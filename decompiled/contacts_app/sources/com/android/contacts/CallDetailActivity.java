package com.android.contacts;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.calllog.CallTypeHelper;
import com.android.contacts.calllog.ContactInfo;
import com.android.contacts.calllog.ContactInfoHelper;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.util.AsyncTaskExecutor;
import com.android.contacts.util.AsyncTaskExecutors;
import com.android.contacts.util.Constants;
import com.android.contacts.util.UiUtils;
import com.android.contacts.voicemail.VoicemailPlaybackFragment;
import com.android.contacts.voicemail.VoicemailStatusHelper;
import com.android.contacts.voicemail.VoicemailStatusHelperImpl;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class CallDetailActivity extends Activity implements ProximitySensorAware {
    static final String[] CALL_LOG_PROJECTION = null;
    static final int CALL_TYPE_COLUMN_INDEX = 3;
    static final int COUNTRY_ISO_COLUMN_INDEX = 4;
    static final int DATE_COLUMN_INDEX = 0;
    static final int DURATION_COLUMN_INDEX = 1;
    public static final String EXTRA_CALL_LOG_IDS = "EXTRA_CALL_LOG_IDS";
    public static final String EXTRA_VOICEMAIL_START_PLAYBACK = "EXTRA_VOICEMAIL_START_PLAYBACK";
    public static final String EXTRA_VOICEMAIL_URI = "EXTRA_VOICEMAIL_URI";
    static final int GEOCODED_LOCATION_COLUMN_INDEX = 5;
    static final int NUMBER_COLUMN_INDEX = 2;
    static final int NUMBER_PRESENTATION_COLUMN_INDEX = 6;
    private static final long PROXIMITY_BLANK_DELAY_MILLIS = 100;
    private static final long PROXIMITY_UNBLANK_DELAY_MILLIS = 500;
    private static final String TAG = "CallDetail";
    private CallDetailActivityQueryHandler mAsyncQueryHandler;
    private AsyncTaskExecutor mAsyncTaskExecutor;
    private CallTypeHelper mCallTypeHelper;
    private ImageView mContactBackgroundView;
    private ContactInfoHelper mContactInfoHelper;
    private ContactPhotoManager mContactPhotoManager;
    private String mDefaultCountryIso;
    private boolean mHasEditNumberBeforeCallOption;
    private boolean mHasRemoveFromCallLogOption;
    private boolean mHasTrashOption;
    private View mHeaderOverlayView;
    private TextView mHeaderTextView;
    LayoutInflater mInflater;
    private ImageButton mMainActionPushLayerView;
    private ImageView mMainActionView;
    private String mNumber;
    private PhoneCallDetailsHelper mPhoneCallDetailsHelper;
    private PhoneNumberHelper mPhoneNumberHelper;
    private int mPresentation;
    private final View.OnClickListener mPrimaryActionListener;
    private final ProximitySensorListener mProximitySensorListener;
    private ProximitySensorManager mProximitySensorManager;
    Resources mResources;
    private final View.OnClickListener mSecondaryActionListener;
    private TextView mStatusMessageAction;
    private TextView mStatusMessageText;
    private View mStatusMessageView;
    private VoicemailStatusHelper mVoicemailStatusHelper;

    private class ProximitySensorListener implements ProximitySensorManager.Listener {
        private final Runnable mBlankRunnable;
        private final Runnable mUnblankRunnable;
        final /* synthetic */ CallDetailActivity this$0;

        private ProximitySensorListener(CallDetailActivity r1) {
            this.this$0 = r1;
            this.mBlankRunnable = new AnonymousClass1(this);
            this.mUnblankRunnable = new AnonymousClass2(this);
        }

        /* synthetic */ ProximitySensorListener(CallDetailActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.contacts.ProximitySensorManager.Listener
        public synchronized void onNear() {
            monitor-enter(this);
            clearPendingRequests();     // Catch: Throwable -> L6
            postDelayed(this.mBlankRunnable, 100);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.android.contacts.ProximitySensorManager.Listener
        public synchronized void onFar() {
            monitor-enter(this);
            clearPendingRequests();     // Catch: Throwable -> L6
            postDelayed(this.mUnblankRunnable, 500);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void clearPendingRequests() {
            monitor-enter(this);
            View r0 = this.this$0.findViewById(R.id.blank);     // Catch: Throwable -> L6
            r0.removeCallbacks(this.mBlankRunnable);     // Catch: Throwable -> L6
            r0.removeCallbacks(this.mUnblankRunnable);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized void postDelayed(Runnable r3, long r4) {
            monitor-enter(this);
            this.this$0.findViewById(R.id.blank).postDelayed(r3, r4);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static final enum Tasks extends Enum<Tasks> {
        private static final /* synthetic */ Tasks[] $VALUES = null;
        public static final Tasks DELETE_VOICEMAIL_AND_FINISH = null;
        public static final Tasks MARK_VOICEMAIL_READ = null;
        public static final Tasks REMOVE_FROM_CALL_LOG_AND_FINISH = null;
        public static final Tasks UPDATE_PHONE_CALL_DETAILS = null;

        private static /* synthetic */ Tasks[] $values() {
            return new Tasks[]{MARK_VOICEMAIL_READ, DELETE_VOICEMAIL_AND_FINISH, REMOVE_FROM_CALL_LOG_AND_FINISH, UPDATE_PHONE_CALL_DETAILS};
        }

        private Tasks(String r1, int r2) {
            super(r1, r2);
        }

        public static Tasks valueOf(String r1) {
            return (Tasks) Enum.valueOf(Tasks.class, r1);
        }

        public static Tasks[] values() {
            return (Tasks[]) $VALUES.clone();
        }

        static {
            MARK_VOICEMAIL_READ = new Tasks("MARK_VOICEMAIL_READ", 0);
            DELETE_VOICEMAIL_AND_FINISH = new Tasks("DELETE_VOICEMAIL_AND_FINISH", 1);
            REMOVE_FROM_CALL_LOG_AND_FINISH = new Tasks("REMOVE_FROM_CALL_LOG_AND_FINISH", 2);
            UPDATE_PHONE_CALL_DETAILS = new Tasks("UPDATE_PHONE_CALL_DETAILS", 3);
            $VALUES = $values();
        }
    }

    static final class ViewEntry {
        public CharSequence label;
        public final String primaryDescription;
        public final Intent primaryIntent;
        public String secondaryDescription;
        public int secondaryIcon;
        public Intent secondaryIntent;
        public final String text;

        public ViewEntry(String r3, Intent r4, String r5) {
            this.label = null;
            this.secondaryIcon = 0;
            this.secondaryIntent = null;
            this.secondaryDescription = null;
            this.text = r3;
            this.primaryIntent = r4;
            this.primaryDescription = r5;
        }

        public void setSecondaryAction(int r1, Intent r2, String r3) {
            this.secondaryIcon = r1;
            this.secondaryIntent = r2;
            this.secondaryDescription = r3;
        }
    }

    public void com_android_contacts_CallDetailActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_CallDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public CallDetailActivity() {
        this.mNumber = null;
        this.mPresentation = 0;
        this.mProximitySensorListener = new ProximitySensorListener(this, null);
        this.mPrimaryActionListener = new AnonymousClass1(this);
        this.mSecondaryActionListener = new AnonymousClass2(this);
    }

    static /* synthetic */ PhoneCallDetails access$100(CallDetailActivity r0, Uri r1) {
        return r0.getPhoneCallDetailsForUri(r1);
    }

    static /* synthetic */ void access$1000(CallDetailActivity r0, ViewEntry r1) {
        r0.configureCallButton(r1);
    }

    static /* synthetic */ void access$1100(CallDetailActivity r0) {
        r0.disableCallButton();
    }

    static /* synthetic */ boolean access$1202(CallDetailActivity r0, boolean r1) {
        r0.mHasEditNumberBeforeCallOption = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1302(CallDetailActivity r0, boolean r1) {
        r0.mHasTrashOption = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1400(CallDetailActivity r0) {
        return r0.hasVoicemail();
    }

    static /* synthetic */ boolean access$1502(CallDetailActivity r0, boolean r1) {
        r0.mHasRemoveFromCallLogOption = r1;
        return r1;
    }

    static /* synthetic */ CallTypeHelper access$1600(CallDetailActivity r0) {
        return r0.mCallTypeHelper;
    }

    static /* synthetic */ void access$1700(CallDetailActivity r0, Uri r1) {
        r0.loadContactPhotos(r1);
    }

    static /* synthetic */ String access$200(CallDetailActivity r0) {
        return r0.mNumber;
    }

    static /* synthetic */ String access$202(CallDetailActivity r0, String r1) {
        r0.mNumber = r1;
        return r1;
    }

    static /* synthetic */ int access$300(CallDetailActivity r0) {
        return r0.mPresentation;
    }

    static /* synthetic */ int access$302(CallDetailActivity r0, int r1) {
        r0.mPresentation = r1;
        return r1;
    }

    static /* synthetic */ TextView access$400(CallDetailActivity r0) {
        return r0.mHeaderTextView;
    }

    static /* synthetic */ PhoneCallDetailsHelper access$500(CallDetailActivity r0) {
        return r0.mPhoneCallDetailsHelper;
    }

    static /* synthetic */ PhoneNumberHelper access$600(CallDetailActivity r0) {
        return r0.mPhoneNumberHelper;
    }

    static /* synthetic */ ImageView access$700(CallDetailActivity r0) {
        return r0.mMainActionView;
    }

    static /* synthetic */ ImageButton access$800(CallDetailActivity r0) {
        return r0.mMainActionPushLayerView;
    }

    static /* synthetic */ View access$900(CallDetailActivity r0) {
        return r0.mHeaderOverlayView;
    }

    static {
        CALL_LOG_PROJECTION = new String[]{"date", "duration", "number", "type", "countryiso", "geocoded_location", "presentation"};
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.call_detail);
        UiUtils.setWindowColorStatusBar(this);
        this.mAsyncTaskExecutor = AsyncTaskExecutors.createThreadPoolExecutor();
        this.mInflater = (LayoutInflater) getSystemService("layout_inflater");
        this.mResources = getResources();
        this.mCallTypeHelper = new CallTypeHelper(getResources());
        this.mPhoneNumberHelper = new PhoneNumberHelper(this.mResources);
        this.mPhoneCallDetailsHelper = new PhoneCallDetailsHelper(this.mResources, this.mCallTypeHelper, this.mPhoneNumberHelper, this);
        this.mVoicemailStatusHelper = new VoicemailStatusHelperImpl();
        this.mAsyncQueryHandler = new CallDetailActivityQueryHandler(this);
        this.mHeaderTextView = (TextView) findViewById(R.id.header_text);
        this.mHeaderOverlayView = findViewById(R.id.photo_text_bar);
        this.mStatusMessageView = findViewById(R.id.voicemail_status);
        this.mStatusMessageText = (TextView) findViewById(R.id.voicemail_status_message);
        this.mStatusMessageAction = (TextView) findViewById(R.id.voicemail_status_action);
        this.mMainActionView = (ImageView) findViewById(R.id.main_action);
        this.mMainActionPushLayerView = (ImageButton) findViewById(R.id.main_action_push_layer);
        this.mContactBackgroundView = (ImageView) findViewById(R.id.contact_background);
        this.mDefaultCountryIso = ContactsUtils.getCurrentCountryIso(this);
        this.mContactPhotoManager = ContactPhotoManager.getInstance(this);
        this.mProximitySensorManager = new ProximitySensorManager(this, this.mProximitySensorListener);
        this.mContactInfoHelper = new ContactInfoHelper(this, ContactsUtils.getCurrentCountryIso(this));
        configureActionBar();
        optionallyHandleVoicemail();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        updateData(getCallLogEntryUris());
    }

    private void optionallyHandleVoicemail() {
        View r1 = findViewById(R.id.voicemail_container);
        if (hasVoicemail() == false) goto L8;
        VoicemailPlaybackFragment r2 = new VoicemailPlaybackFragment();
        Bundle r3 = new Bundle();
        r3.putParcelable(EXTRA_VOICEMAIL_URI, getVoicemailUri());
        if (getIntent().getBooleanExtra(EXTRA_VOICEMAIL_START_PLAYBACK, false) == false) goto L7;
        r3.putBoolean(EXTRA_VOICEMAIL_START_PLAYBACK, true);
    L7:
        r2.setArguments(r3);
        r1.setVisibility(0);
        getFragmentManager().beginTransaction().add(R.id.voicemail_container, r2).commitAllowingStateLoss();
        this.mAsyncQueryHandler.startVoicemailStatusQuery(getVoicemailUri());
        markVoicemailAsRead(getVoicemailUri());
        return;
    L8:
        this.mStatusMessageView.setVisibility(8);
        r1.setVisibility(8);
    }

    private boolean hasVoicemail() {
        if (getVoicemailUri() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private Uri getVoicemailUri() {
        return (Uri) getIntent().getParcelableExtra(EXTRA_VOICEMAIL_URI);
    }

    private void markVoicemailAsRead(final Uri r4) {
        this.mAsyncTaskExecutor.submit(Tasks.MARK_VOICEMAIL_READ, new AnonymousClass3(this, r4), new Void[0]);
    }

    private Uri[] getCallLogEntryUris() {
        Uri r0 = getIntent().getData();
        int r1 = 0;
        if (r0 != null) goto L5;
        long[] r5 = getIntent().getLongArrayExtra(EXTRA_CALL_LOG_IDS);
        if (r5 != null) goto L10;
        return null;
    L10:
        Uri[] r2 = new Uri[r5.length];
    L12:
        if (r1 >= r5.length) goto L14;
        r2[r1] = ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, r5[r1]);
        r1 = r1 + 1;
        goto L12
    L14:
        return r2;
    L5:
        return new Uri[]{r0};
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r3, KeyEvent r4) {
        if (r3 != 5) goto L10;
        if (((TelephonyManager) getSystemService("phone")).getCallState() != 0) goto L10;
        startActivity(new Intent("android.intent.action.CALL_PRIVILEGED", Uri.fromParts(Constants.SCHEME_TEL, this.mNumber, null)));
        return true;
    L10:
        return super.onKeyDown(r3, r4);
    }

    private void updateData(final Uri... r4) {
        this.mAsyncTaskExecutor.submit(Tasks.UPDATE_PHONE_CALL_DETAILS, new C1UpdateContactDetailsTask(this, r4), new Void[0]);
    }

    private PhoneCallDetails getPhoneCallDetailsForUri(Uri r26) {
        Cursor r2 = getContentResolver().query(r26, CALL_LOG_PROJECTION, null, null, null);
        if (r2 == null) goto L24;
    L25:
        th = move-exception;
        if (r2 == null) goto L28;
        r2.close();
    L28:
        throw th;
    L5:
        if (r2.moveToFirst() == false) goto L24;
        String r4 = r2.getString(2);     // Catch: Throwable -> L25
        long r9 = r2.getLong(0);     // Catch: Throwable -> L25
        long r11 = r2.getLong(1);     // Catch: Throwable -> L25
        int r5 = r2.getInt(3);     // Catch: Throwable -> L25
        String r6 = r2.getString(4);     // Catch: Throwable -> L25
        String r7 = r2.getString(5);     // Catch: Throwable -> L25
        int r8 = r2.getInt(6);     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r6) == false) goto L10;
        r6 = this.mDefaultCountryIso;     // Catch: Throwable -> L25
    L10:
        if (PhoneNumberHelper.canPlaceCallsTo(r8) == true) goto L12;
    L14:
        ContactInfo r10 = null;
    L15:
        if (r10 != null) goto L18;
        CharSequence r0 = this.mPhoneNumberHelper.getDisplayNumber(r4, null, 1);     // Catch: Throwable -> L25
        int r21 = 1;
        Uri r18 = null;
        long r19 = -1;
        int r14 = 0;
        String r15 = "";
        Uri r1 = null;
        String r13 = r15;
    L19:
        PhoneCallDetails r22 = new PhoneCallDetails(r4, r0, r6, r7, new int[]{r5}, r9, r11, r13, r14, r15, r1, r18, r19, r21, "");     // Catch: Throwable -> L25
        if (r2 == null) goto L22;
        r2.close();
    L22:
        return r22;
    L18:
        String r3 = r10.formattedNumber;     // Catch: Throwable -> L25
        r13 = r10.name;     // Catch: Throwable -> L25
        r14 = r10.type;     // Catch: Throwable -> L25
        r15 = r10.label;     // Catch: Throwable -> L25
        Uri r12 = r10.photoUri;     // Catch: Throwable -> L25
        long r16 = r10.photoId;     // Catch: Throwable -> L25
        Uri r17 = r10.lookupUri;     // Catch: Throwable -> L25
        r19 = r16;
        r21 = r10.presentation;     // Catch: Throwable -> L25
        r1 = r17;
        r0 = r3;
        r18 = r12;
        goto L19
    L12:
        if (this.mPhoneNumberHelper.isVoicemailNumber(r4) == true) goto L14;
        r10 = this.mContactInfoHelper.lookupNumber(r4, r6);     // Catch: Throwable -> L25
    L24:
        throw new IllegalArgumentException("Cannot find content: " + r26);     // Catch: Throwable -> L25
    }

    private void loadContactPhotos(Uri r3) {
        this.mContactPhotoManager.loadPhoto(this.mContactBackgroundView, r3, true, true);
    }

    private void disableCallButton() {
        findViewById(R.id.call_and_sms).setVisibility(8);
    }

    private void configureCallButton(ViewEntry r8) {
        View r0 = findViewById(R.id.call_and_sms);
        r0.setVisibility(0);
        ImageView r2 = (ImageView) r0.findViewById(R.id.call_and_sms_icon);
        View r3 = r0.findViewById(R.id.call_and_sms_divider);
        TextView r4 = (TextView) r0.findViewById(R.id.call_and_sms_text);
        View r5 = r0.findViewById(R.id.call_and_sms_main_action);
        r5.setOnClickListener(this.mPrimaryActionListener);
        r5.setTag(r8);
        r5.setContentDescription(r8.primaryDescription);
        if (r8.secondaryIntent == null) goto L5;
        r2.setOnClickListener(this.mSecondaryActionListener);
        r2.setImageResource(r8.secondaryIcon);
        r2.setVisibility(0);
        r2.setTag(r8);
        r2.setContentDescription(r8.secondaryDescription);
        r3.setVisibility(0);
    L6:
        r4.setText(r8.text);
        TextView r7 = (TextView) r0.findViewById(R.id.call_and_sms_label);
        if (TextUtils.isEmpty(r8.label) == false) goto L9;
        r7.setVisibility(8);
        return;
    L9:
        r7.setText(r8.label);
        r7.setVisibility(0);
        return;
    L5:
        r2.setVisibility(8);
        r3.setVisibility(8);
        goto L6
    }

    protected void updateVoicemailStatusMessage(Cursor r4) {
        if (r4 != null) goto L6;
        this.mStatusMessageView.setVisibility(8);
        return;
    L6:
        final VoicemailStatusHelper.StatusMessage r5 = getStatusMessage(r4);
        if (r5 != null) goto L9;
    L19:
        this.mStatusMessageView.setVisibility(8);
        return;
    L9:
        if (r5.showInCallDetails() == false) goto L19;
        this.mStatusMessageView.setVisibility(0);
        this.mStatusMessageText.setText(r5.callDetailsMessageId);
        if (r5.actionMessageId == (-1)) goto L15;
        this.mStatusMessageAction.setText(r5.actionMessageId);
    L15:
        if (r5.actionUri == null) goto L17;
        this.mStatusMessageAction.setClickable(true);
        this.mStatusMessageAction.setOnClickListener(new AnonymousClass4(this, r5));
        return;
    L17:
        this.mStatusMessageAction.setClickable(false);
    }

    private VoicemailStatusHelper.StatusMessage getStatusMessage(Cursor r3) {
        List<VoicemailStatusHelper.StatusMessage> r2 = this.mVoicemailStatusHelper.getStatusMessages(r3);
        if (r2.size() != 0) goto L7;
        return null;
    L7:
        if (r2.size() <= 1) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, String.format("Expected 1, found (%d) num of status messages. Will use the first one.", new Object[]{Integer.valueOf(r2.size())}));
    L10:
        return r2.get(0);
    }

    private void configureActionBar() {
        ActionBar r1 = getActionBar();
        if (r1 == null) goto L6;
        r1.setDisplayOptions(6);
        return;
    }

    @Override // android.app.Activity
    protected void onPause() {
        disableProximitySensor(false);
        this.mProximitySensorListener.clearPendingRequests();
        super.onPause();
    }

    @Override // com.android.contacts.ProximitySensorAware
    public void enableProximitySensor() {
        this.mProximitySensorManager.enable();
    }

    @Override // com.android.contacts.ProximitySensorAware
    public void disableProximitySensor(boolean r1) {
        this.mProximitySensorManager.disable(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_CallDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CallDetailActivity r1) {
        r1.com_android_contacts_CallDetailActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
