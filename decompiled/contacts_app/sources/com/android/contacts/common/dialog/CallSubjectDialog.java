package com.android.contacts.common.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.common.ContactPhotoManager;
import com.android.contacts.common.R;
import com.android.contacts.common.compat.CompatUtils;
import com.android.contacts.common.compat.PhoneAccountSdkCompat;
import com.android.contacts.common.util.UriUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class CallSubjectDialog extends Activity {
    public static final String ARG_CONTACT_URI = "CONTACT_URI";
    public static final String ARG_DISPLAY_NUMBER = "DISPLAY_NUMBER";
    public static final String ARG_IS_BUSINESS = "IS_BUSINESS";
    public static final String ARG_NAME_OR_NUMBER = "NAME_OR_NUMBER";
    public static final String ARG_NUMBER = "NUMBER";
    public static final String ARG_NUMBER_LABEL = "NUMBER_LABEL";
    public static final String ARG_PHONE_ACCOUNT_HANDLE = "PHONE_ACCOUNT_HANDLE";
    public static final String ARG_PHOTO_ID = "PHOTO_ID";
    public static final String ARG_PHOTO_URI = "PHOTO_URI";
    private static final int CALL_SUBJECT_HISTORY_SIZE = 5;
    private static final int CALL_SUBJECT_LIMIT = 16;
    public static final String PREF_KEY_SUBJECT_HISTORY_COUNT = "subject_history_count";
    public static final String PREF_KEY_SUBJECT_HISTORY_ITEM = "subject_history_item";
    private static final int REQUEST_SUBJECT = 1001;
    private static final String TAG = "CallSubjectDialog";
    private int mAnimationDuration;
    private View.OnClickListener mBackgroundListener;
    private View mBackgroundView;
    private final View.OnClickListener mCallSubjectClickListener;
    private EditText mCallSubjectView;
    private TextView mCharacterLimitView;
    private QuickContactBadge mContactPhoto;
    private Uri mContactUri;
    private View mDialogView;
    private String mDisplayNumber;
    private View mHistoryButton;
    private final View.OnClickListener mHistoryOnClickListener;
    private boolean mIsBusiness;
    private AdapterView.OnItemClickListener mItemClickListener;
    private int mLimit;
    private Charset mMessageEncoding;
    private String mNameOrNumber;
    private TextView mNameView;
    private String mNumber;
    private String mNumberLabel;
    private TextView mNumberView;
    private PhoneAccountHandle mPhoneAccountHandle;
    private long mPhotoID;
    private int mPhotoSize;
    private Uri mPhotoUri;
    private SharedPreferences mPrefs;
    private View mSendAndCallButton;
    private final View.OnClickListener mSendAndCallOnClickListener;
    private List<String> mSubjectHistory;
    private ListView mSubjectList;
    private final TextWatcher mTextWatcher;

    public void com_android_contacts_common_dialog_CallSubjectDialog__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_dialog_CallSubjectDialog_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public CallSubjectDialog() {
        this.mLimit = 16;
        this.mTextWatcher = new AnonymousClass1(this);
        this.mBackgroundListener = new AnonymousClass2(this);
        this.mHistoryOnClickListener = new AnonymousClass3(this);
        this.mSendAndCallOnClickListener = new AnonymousClass4(this);
        this.mCallSubjectClickListener = new AnonymousClass5(this);
        this.mItemClickListener = new AnonymousClass6(this);
    }

    static /* synthetic */ void access$000(CallSubjectDialog r0) {
        r0.updateCharacterLimit();
    }

    static /* synthetic */ EditText access$100(CallSubjectDialog r0) {
        return r0.mCallSubjectView;
    }

    static /* synthetic */ ListView access$200(CallSubjectDialog r0) {
        return r0.mSubjectList;
    }

    static /* synthetic */ void access$300(CallSubjectDialog r0, boolean r1) {
        r0.showCallHistory(r1);
    }

    static /* synthetic */ String access$400(CallSubjectDialog r0) {
        return r0.mNumber;
    }

    static /* synthetic */ PhoneAccountHandle access$500(CallSubjectDialog r0) {
        return r0.mPhoneAccountHandle;
    }

    static /* synthetic */ List access$600(CallSubjectDialog r0) {
        return r0.mSubjectHistory;
    }

    static /* synthetic */ void access$700(CallSubjectDialog r0, List r1) {
        r0.saveSubjectHistory(r1);
    }

    static /* synthetic */ View access$800(CallSubjectDialog r0) {
        return r0.mDialogView;
    }

    static /* synthetic */ int access$900(CallSubjectDialog r0) {
        return r0.mAnimationDuration;
    }

    public static void start(Activity r11, String r12) {
        start(r11, -1, null, null, r12, false, r12, null, null, null);
    }

    public static void start(Activity r2, long r3, Uri r5, Uri r6, String r7, boolean r8, String r9, String r10, String r11, PhoneAccountHandle r12) {
        Bundle r0 = new Bundle();
        r0.putLong(ARG_PHOTO_ID, r3);
        r0.putParcelable(ARG_PHOTO_URI, r5);
        r0.putParcelable(ARG_CONTACT_URI, r6);
        r0.putString(ARG_NAME_OR_NUMBER, r7);
        r0.putBoolean(ARG_IS_BUSINESS, r8);
        r0.putString(ARG_NUMBER, r9);
        r0.putString(ARG_DISPLAY_NUMBER, r10);
        r0.putString(ARG_NUMBER_LABEL, r11);
        r0.putParcelable(ARG_PHONE_ACCOUNT_HANDLE, r12);
        start(r2, r0);
    }

    public static void start(Activity r2, Bundle r3) {
        Intent r0 = new Intent(r2, CallSubjectDialog.class);
        r0.putExtras(r3);
        r2.startActivity(r0);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.mAnimationDuration = getResources().getInteger(R.integer.call_subject_animation_duration);
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        this.mPhotoSize = getResources().getDimensionPixelSize(R.dimen.call_subject_dialog_contact_photo_size);
        readArguments();
        loadConfiguration();
        this.mSubjectHistory = loadSubjectHistory(this.mPrefs);
        setContentView(R.layout.dialog_call_subject);
        getWindow().setLayout(-1, -1);
        View r5 = findViewById(R.id.call_subject_dialog);
        this.mBackgroundView = r5;
        r5.setOnClickListener(this.mBackgroundListener);
        this.mDialogView = findViewById(R.id.dialog_view);
        this.mContactPhoto = (QuickContactBadge) findViewById(R.id.contact_photo);
        this.mNameView = (TextView) findViewById(R.id.name);
        this.mNumberView = (TextView) findViewById(R.id.number);
        EditText r6 = (EditText) findViewById(R.id.call_subject);
        this.mCallSubjectView = r6;
        r6.addTextChangedListener(this.mTextWatcher);
        this.mCallSubjectView.setOnClickListener(this.mCallSubjectClickListener);
        int r1 = 0;
        this.mCallSubjectView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.mLimit)});
        this.mCharacterLimitView = (TextView) findViewById(R.id.character_limit);
        View r7 = findViewById(R.id.history_button);
        this.mHistoryButton = r7;
        r7.setOnClickListener(this.mHistoryOnClickListener);
        View r8 = this.mHistoryButton;
        if (this.mSubjectHistory.isEmpty() == false) goto L5;
        r1 = 8;
    L5:
        r8.setVisibility(r1);
        View r9 = findViewById(R.id.send_and_call_button);
        this.mSendAndCallButton = r9;
        r9.setOnClickListener(this.mSendAndCallOnClickListener);
        ListView r10 = (ListView) findViewById(R.id.subject_list);
        this.mSubjectList = r10;
        r10.setOnItemClickListener(this.mItemClickListener);
        this.mSubjectList.setVisibility(8);
        updateContactInfo();
        updateCharacterLimit();
    }

    private void updateContactInfo() {
        Uri r4 = this.mContactUri;
        if (r4 == null) goto L5;
        setPhoto(this.mPhotoID, this.mPhotoUri, r4, this.mNameOrNumber, this.mIsBusiness);
    L6:
        this.mNameView.setText(this.mNameOrNumber);
        if (TextUtils.isEmpty(this.mNumberLabel) == false) goto L9;
    L11:
        this.mNumberView.setVisibility(8);
        this.mNumberView.setText(null);
        return;
    L9:
        if (TextUtils.isEmpty(this.mDisplayNumber) == true) goto L11;
        this.mNumberView.setVisibility(0);
        this.mNumberView.setText(getString(R.string.call_subject_type_and_number, new Object[]{this.mNumberLabel, this.mDisplayNumber}));
        return;
    L5:
        this.mContactPhoto.setVisibility(8);
        goto L6
    }

    private void readArguments() {
        Bundle r0 = getIntent().getExtras();
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Arguments cannot be null.");
        return;
    L6:
        this.mPhotoID = r0.getLong(ARG_PHOTO_ID);
        this.mPhotoUri = (Uri) r0.getParcelable(ARG_PHOTO_URI);
        this.mContactUri = (Uri) r0.getParcelable(ARG_CONTACT_URI);
        this.mNameOrNumber = r0.getString(ARG_NAME_OR_NUMBER);
        this.mIsBusiness = r0.getBoolean(ARG_IS_BUSINESS);
        this.mNumber = r0.getString(ARG_NUMBER);
        this.mDisplayNumber = r0.getString(ARG_DISPLAY_NUMBER);
        this.mNumberLabel = r0.getString(ARG_NUMBER_LABEL);
        this.mPhoneAccountHandle = (PhoneAccountHandle) r0.getParcelable(ARG_PHONE_ACCOUNT_HANDLE);
    }

    private void updateCharacterLimit() {
        String r0 = this.mCallSubjectView.getText().toString();
        Charset r1 = this.mMessageEncoding;
        if (r1 == null) goto L5;
        int r2 = r0.getBytes(r1).length;
    L6:
        this.mCharacterLimitView.setText(getString(R.string.call_subject_limit, new Object[]{Integer.valueOf(r2), Integer.valueOf(this.mLimit)}));
        if (r2 < this.mLimit) goto L9;
        this.mCharacterLimitView.setTextColor(getResources().getColor(R.color.call_subject_limit_exceeded));
        return;
    L9:
        this.mCharacterLimitView.setTextColor(getResources().getColor(R.color.dialtacts_secondary_text_color));
        return;
    L5:
        r2 = r0.length();
        goto L6
    }

    private void setPhoto(long r10, Uri r12, Uri r13, String r14, boolean r15) {
        this.mContactPhoto.assignContactUri(r13);
        String r1 = null;
        if (CompatUtils.isLollipopCompatible() == false) goto L6;
        this.mContactPhoto.setOverlay(null);
    L6:
        if (r15 == false) goto L8;
        int r16 = 2;
    L9:
        if (r13 == null) goto L11;
        r1 = UriUtils.getLookupKeyFromUri(r13);
    L11:
        ContactPhotoManager.DefaultImageRequest r8 = new ContactPhotoManager.DefaultImageRequest(r14, r1, r16, true);
        if (r10 != 0) goto L15;
        if (r12 == null) goto L15;
        ContactPhotoManager.getInstance(this).loadPhoto(this.mContactPhoto, r12, this.mPhotoSize, false, true, r8);
        return;
    L15:
        ContactPhotoManager.getInstance(this).loadThumbnail(this.mContactPhoto, r10, false, true, r8);
        return;
    L8:
        r16 = 1;
        goto L9
    }

    public static List<String> loadSubjectHistory(SharedPreferences r5) {
        int r1 = 0;
        int r0 = r5.getInt(PREF_KEY_SUBJECT_HISTORY_COUNT, 0);
        ArrayList r2 = new ArrayList(r0);
    L3:
        if (r1 >= r0) goto L8;
        String r3 = r5.getString(PREF_KEY_SUBJECT_HISTORY_ITEM + r1, null);
        if (TextUtils.isEmpty(r3) == true) goto L7;
        r2.add(r3);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    private void saveSubjectHistory(List<String> r5) {
    L2:
        int r2 = 0;
        if (r5.size() <= 5) goto L5;
        r5.remove(0);
        goto L2
    L5:
        SharedPreferences.Editor r4 = this.mPrefs.edit();
        Iterator<String> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        String r0 = r6.next();
        if (TextUtils.isEmpty(r0) == true) goto L7;
        r4.putString(PREF_KEY_SUBJECT_HISTORY_ITEM + r2, r0);
        r2 = r2 + 1;
        goto L7
    L11:
        r4.putInt(PREF_KEY_SUBJECT_HISTORY_COUNT, r2);
        r4.apply();
    }

    public void hideSoftKeyboard(Context r1, View r2) {
        InputMethodManager r0 = (InputMethodManager) r1.getSystemService("input_method");
        if (r0 == null) goto L6;
        r0.hideSoftInputFromWindow(r2.getWindowToken(), 2);
        return;
    }

    private void showCallHistory(final boolean r5) {
        if (r5 == false) goto L6;
        if (this.mSubjectList.getVisibility() != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
    L10:
        final int r1 = this.mDialogView.getBottom();
        if (r5 == false) goto L13;
        ArrayAdapter r0 = new ArrayAdapter(this, R.layout.call_subject_history_list_item, this.mSubjectHistory);
        this.mSubjectList.setAdapter(r0);
        this.mSubjectList.setVisibility(0);
    L14:
        final ViewTreeObserver r2 = this.mBackgroundView.getViewTreeObserver();
        r2.addOnPreDrawListener(new AnonymousClass7(this, r2, r1, r5));
        return;
    L13:
        this.mSubjectList.setVisibility(8);
        goto L14
    L8:
        if (this.mSubjectList.getVisibility() != 8) goto L10;
    }

    private void loadConfiguration() {
        if (this.mPhoneAccountHandle != null) goto L5;
        return;
    L5:
        PhoneAccount r0 = ((TelecomManager) getSystemService("telecom")).getPhoneAccount(this.mPhoneAccountHandle);
        if (r0 != null) goto L8;
        return;
    L8:
        Bundle r1 = PhoneAccountSdkCompat.getExtras(r0);
        if (r1 != null) goto L11;
        return;
    L11:
        this.mLimit = r1.getInt(PhoneAccountSdkCompat.EXTRA_CALL_SUBJECT_MAX_LENGTH, this.mLimit);
        String r2 = r1.getString(PhoneAccountSdkCompat.EXTRA_CALL_SUBJECT_CHARACTER_ENCODING);
        if (TextUtils.isEmpty(r2) == false) goto L18;
        this.mMessageEncoding = null;
        return;
    L18:
        this.mMessageEncoding = Charset.forName(r2);     // Catch: UnsupportedCharsetException -> L15
        return;
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Invalid charset: " + r2);
        this.mMessageEncoding = null;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_dialog_CallSubjectDialog_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CallSubjectDialog r1) {
        r1.com_android_contacts_common_dialog_CallSubjectDialog__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
