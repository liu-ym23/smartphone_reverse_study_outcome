package com.android.contacts.speeddial;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.Constants;
import com.android.contacts.util.TitleBarUtil;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.common.base.Objects;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.privacy.PrivacyUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SpeedDialSettingActivity extends ContactsActivity implements View.OnClickListener {
    public static final String EXTRA_NUMBER = "extra_number";
    private static final int PICK_CONTACT_REQUEST = 9;
    private static final String TAG = "SpeedDialSettingActivity";
    private ImageView mDeleteIcon;
    private boolean mFromSettings;
    private MobileTextWatcher mMobileTextWatcher;
    private int mNumber;
    private EditText mPhoneNumberEditText;
    private AlertDialog mSelectNumberDialog;

    private final class PhoneNumberAdapter extends BaseAdapter {
        LayoutInflater mInflater;
        List<String> mPhoneNumbers;
        final /* synthetic */ SpeedDialSettingActivity this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public PhoneNumberAdapter(SpeedDialSettingActivity r1, List<String> r2) {
            this.this$0 = r1;
            this.mInflater = LayoutInflater.from(r1);
            this.mPhoneNumbers = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mPhoneNumbers.size();
        }

        @Override // android.widget.Adapter
        public String getItem(int r1) {
            return this.mPhoneNumbers.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
            r4 = this.mInflater.inflate(R.layout.phone_number_item, null, false);
        L4:
            ((TextView) r4.findViewById(R.id.phone_number)).setText(ContactsUtils.formatNumber(this.mPhoneNumbers.get(r3)));
            return r4;
        }
    }

    public void com_android_contacts_speeddial_SpeedDialSettingActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_speeddial_SpeedDialSettingActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_speeddial_SpeedDialSettingActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public SpeedDialSettingActivity() {
    }

    static /* synthetic */ void access$000(SpeedDialSettingActivity r0) {
        r0.saveSpeedDial();
    }

    static /* synthetic */ boolean access$100(SpeedDialSettingActivity r0) {
        return r0.mFromSettings;
    }

    static /* synthetic */ void access$200(SpeedDialSettingActivity r0) {
        r0.updateDeleteIconState();
    }

    static /* synthetic */ AlertDialog access$300(SpeedDialSettingActivity r0) {
        return r0.mSelectNumberDialog;
    }

    static /* synthetic */ void access$400(SpeedDialSettingActivity r0, long r1, String r3) {
        r0.setContactPhoneNum(r1, r3);
    }

    public void com_android_contacts_speeddial_SpeedDialSettingActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.activity_speed_dial_setting);
        UiUtils.setWindowColorStatusBar(this);
        Intent r4 = getIntent();
        if (r4 == null) goto L6;
        this.mNumber = r4.getIntExtra(EXTRA_NUMBER, -1);
    L6:
        if (this.mNumber != (-1)) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "None or invalid number, just finish!");
        finish();
    L8:
        setupViews();
    }

    private void setupViews() {
        if (getIntent() != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.mFromSettings = r0;
        OCTitleBar r1 = (OCTitleBar) findViewById(R.id.otitlebar);
        OButton r3 = getTransTitleBtn(TitleBarUtil.getLeftRes(this.mFromSettings), true, r1);
        OButton r4 = getTransTitleBtn(R.drawable.standard_icon_complete_selector, false, r1);
        if (this.mFromSettings == false) goto L11;
        r4.setVisibility(8);
    L12:
        r3.setOnClickListener(new AnonymousClass2(this));
        r1.setCenterText(String.valueOf(this.mNumber));
        ((TextView) findViewById(R.id.setting_speed_dial_hint_view)).setText(getString(R.string.setting_speed_dial_hint, new Object[]{Integer.valueOf(this.mNumber)}));
        this.mPhoneNumberEditText = (EditText) findViewById(R.id.edit_phone_num);
        final EditText r2 = this.mPhoneNumberEditText;
        MobileTextWatcher r5 = new AnonymousClass3(this, r2);
        this.mMobileTextWatcher = r5;
        this.mPhoneNumberEditText.addTextChangedListener(r5);
        findViewById(R.id.btn_icon_contact).setOnClickListener(this);
        ImageView r6 = (ImageView) findViewById(R.id.btn_icon_delete);
        this.mDeleteIcon = r6;
        r6.setOnClickListener(this);
        String r7 = SpeedDialUtils.getPhoneNumber(this, this.mNumber);
        long r8 = SpeedDialUtils.getContactId(this, this.mNumber);
        if (r7 == null) goto L18;
        setPhoneNumberNoNotify(r7);
        this.mPhoneNumberEditText.setSelection(r7.length());
        if (r8 == (-1)) goto L19;
        this.mPhoneNumberEditText.setTag(new SpeedDialUtils.SpeedDialRecord(r7, r8));
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r4.setOnClickListener(new AnonymousClass1(this));
        goto L12
    L5:
        if (getIntent().getBooleanExtra(Constants.EXTRA_FROM_SETTINGS, false) == false) goto L7;
        r0 = true;
        goto L8
    }

    private OButton getTransTitleBtn(int r2, boolean r3, OCTitleBar r4) {
        LinearLayout r0 = r4.mLeftContainer;
        if (r3 == true) goto L5;
        r0 = r4.mRightContainer;
    L5:
        OButton r5 = r4.createTransIconButton(this, r0);
        r5.setMIcon(getResources().getDrawable(r2));
        return r5;
    }

    private void updateDeleteIconState() {
        if (TextUtils.isEmpty(this.mPhoneNumberEditText.getText().toString()) == false) goto L5;
        this.mDeleteIcon.setVisibility(8);
        return;
    L5:
        this.mDeleteIcon.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        switch(r4.getId()) {
            case 2131362131: goto L6;
            case 2131362132: goto L5;
            default: goto L9;
        };
    L5:
        setPhoneNumberNoNotify("");
        return;
    L6:
        ActivityOptions r5 = ActivityOptions.makeCustomAnimation(this, R.anim.activity_slide_in_from_bottom, R.anim.activity_slide_do_nothing);
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 9, r5.toBundle());
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 == 9) goto L6;
        return;
    L6:
        if (r3 != (-1)) goto L9;
        finishContactPick(r4);
        return;
    }

    private void saveSpeedDial() {
        String r0 = this.mPhoneNumberEditText.getText().toString();
        SpeedDialUtils.SpeedDialRecord r1 = (SpeedDialUtils.SpeedDialRecord) this.mPhoneNumberEditText.getTag();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        SpeedDialUtils.deleteContactOrStranger(this, this.mNumber);
        return;
    L5:
        if (r1 != null) goto L7;
    L9:
        long r2 = SpeedDialUtils.getContactIdFromPhoneNumber(this, r0);
        if (r2 == (-1)) goto L12;
        SpeedDialUtils.saveContact(this, this.mNumber, r0, r2);
        return;
    L12:
        SpeedDialUtils.saveStranger(this, this.mNumber, r0);
        return;
    L7:
        if (Objects.equal(ContactsUtils.formatNumber(r0), ContactsUtils.formatNumber(r1.phoneNumber)) == false) goto L9;
        SpeedDialUtils.saveContact(this, this.mNumber, r1.phoneNumber, r1.contactId);
    }

    private void finishContactPick(Intent r5) {
        log("finishContactPick, data = " + r5);
        if (r5 == null) goto L13;
        Uri r6 = r5.getData();
        if (r6 == null) goto L14;
        long r0 = getContactIdFromUri(r6);
        List<String> r7 = SpeedDialUtils.getPhoneNumbersFromContactId(this, r0);
        if (r7.size() <= 1) goto L10;
        showSelectPhoneNumberDlg(r0, r7);
        return;
    L10:
        if (r7.size() != 1) goto L16;
        setContactPhoneNum(r0, r7.get(0));
        return;
    L16:
        return;
    L14:
        return;
    }

    private void showSelectPhoneNumberDlg(final long r3, List<String> r5) {
        final PhoneNumberAdapter r0 = new PhoneNumberAdapter(this, r5);
        ListView r6 = new ListView(this);
        r6.setAdapter(r0);
        r6.setOnItemClickListener(new AnonymousClass4(this, r0, r3));
        AlertDialog.Builder r4 = new AlertDialog.Builder(this);
        r4.setTitle(R.string.title_select_speed_dial_number);
        r4.setView(r6);
        r4.setNegativeButton(R.string.common_cancel, new AnonymousClass5(this));
        r4.setOnCancelListener(new AnonymousClass6(this));
        AlertDialog r7 = r4.create();
        this.mSelectNumberDialog = r7;
        r7.setCanceledOnTouchOutside(false);
        this.mSelectNumberDialog.show();
    }

    private void setContactPhoneNum(long r3, String r5) {
        if (r5 != null) goto L4;
        String r6 = "";
    L5:
        setPhoneNumberNoNotify(r6);
        this.mPhoneNumberEditText.setSelection(r6.length());
        this.mPhoneNumberEditText.setTag(new SpeedDialUtils.SpeedDialRecord(r6, r3));
        return;
    L4:
        r6 = ContactsUtils.formatNumber(r5);
        goto L5
    }

    private long getContactIdFromUri(Uri r4) {
        if (r4 == null) goto L7;
        String r0 = r4.getLastPathSegment();
        log("getContactIdFromUri, uri = " + r4 + ", id = " + r0);
        if (TextUtils.isEmpty(r0) == true) goto L12;
        return Long.parseLong(r0);
    L13:
        return -1;
    L12:
        return -1;
    L7:
        return -1;
    }

    private void setPhoneNumberNoNotify(String r3) {
        this.mPhoneNumberEditText.removeTextChangedListener(this.mMobileTextWatcher);
        this.mPhoneNumberEditText.setText(r3);
        this.mPhoneNumberEditText.addTextChangedListener(this.mMobileTextWatcher);
        if (this.mFromSettings == false) goto L5;
        saveSpeedDial();
    L5:
        updateDeleteIconState();
    }

    private void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_speeddial_SpeedDialSettingActivity_com_obric_privacyhook_PrivacyHook_onCreate(SpeedDialSettingActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        SpeedDialSettingActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_speeddial_SpeedDialSettingActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_speeddial_SpeedDialSettingActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SpeedDialSettingActivity r1) {
        com_android_contacts_speeddial_SpeedDialSettingActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_speeddial_SpeedDialSettingActivity_com_obric_privacyhook_PrivacyHook_onStop(SpeedDialSettingActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        SpeedDialSettingActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_speeddial_SpeedDialSettingActivity__onStop$___twin___();
    }
}
