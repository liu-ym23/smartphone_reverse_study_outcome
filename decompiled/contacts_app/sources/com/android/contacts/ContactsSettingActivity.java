package com.android.contacts;

import android.app.ActivityOptions;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.GlobalProxyLancet;
import com.android.contacts.activities.ContactsSettingIEActivity;
import com.android.contacts.setting.AbstractSettingActivity;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.window.permission.WebViewActivity;
import com.obric.privacy.PrivacyUtils;
import com.obric.ui.dialog.OUIDialogHelper;
import com.obric.ui.dialog.action.ActionButtonStyle;
import com.obric.ui.dialog.action.ActionDialogItemData;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class ContactsSettingActivity extends AbstractSettingActivity {
    private static final int EMERGENCY_CONTACT_LOADER_ID = 7;
    public static final String INTENT_PARAMS_IS_CLICK_EMERGENCY = "is_emergency_click";
    private static final int REQUEST_CODE_PICK_EMERGENCY_CONTACT = 31;
    private final String TAG;
    private OActionDialog dialog;
    private OCardListItem mBtnAccountFilterOptions;
    private OCardListItem mBtnApplicationPermissionDescription;
    private OCardListItem mBtnApplicationPermissionManagement;
    private OCardListItem mBtnContactsRecycleBin;
    private OCardListItem mBtnEmergencyContact;
    private OCardListItem mBtnIE;
    private OCardListItem mBtnJoinContacts;
    private OCardListItem mBtnMemoryStatus;
    private OCardListItem mBtnOnlyDisplayHasNumContacts;
    private OCardListItem mBtnPersonalInformationCollectionInventory;
    private OCardListItem mBtnPrivacyPolicy;
    private OCardListItem mBtnSortAndDisplayOptions;
    private OCardListItem mBtnSync;
    private Uri mEmergencyPhoneUri;
    private boolean mIsEmergencyPhoneExist;
    private OSwitch mOSwitch;

    private class MyLoaderCallbacks implements LoaderManager.LoaderCallbacks<Cursor> {
        final /* synthetic */ ContactsSettingActivity this$0;

        @Override // android.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<Cursor> r1) {
        }

        private MyLoaderCallbacks(ContactsSettingActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MyLoaderCallbacks(ContactsSettingActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
            onLoadFinished2(r1, r2);
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public Loader<Cursor> onCreateLoader(int r8, Bundle r9) {
            Uri r2 = ContactsUtils.getEmergencyContactPhoneUri(this.this$0);
            return new CursorLoader(this.this$0, r2, new String[]{"display_name", "data1"}, null, null, null);
        }

        /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
        public void onLoadFinished2(Loader<Cursor> r3, Cursor r4) {
            if (r4 != null) goto L5;
        L13:
            ContactsSettingActivity r5 = this.this$0;
            ContactsSettingActivity.access$700(r5, r5.getString(R.string.no_contacts));
            ContactsSettingActivity.access$802(this.this$0, false);
            return;
        L5:
            if (r4.moveToFirst() == false) goto L13;
            String r6 = r4.getString(0);
            String r7 = r4.getString(1);
            if (TextUtils.isEmpty(r6) == true) goto L10;
            ContactsSettingActivity.access$700(this.this$0, r6);
        L12:
            ContactsUtils.setEmergencyContactInfos(this.this$0, r6, r7);
            ContactsSettingActivity.access$802(this.this$0, true);
            return;
        L10:
            if (TextUtils.isEmpty(r7) == true) goto L12;
            ContactsSettingActivity.access$700(this.this$0, r7);
            goto L12
        }
    }

    public void com_android_contacts_ContactsSettingActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_android_contacts_ContactsSettingActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // com.android.contacts.setting.AbstractSettingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_ContactsSettingActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_ContactsSettingActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_contacts_ContactsSettingActivity_com_obric_privacyhook_PrivacyHook_onStart(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.setting.AbstractSettingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_ContactsSettingActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ContactsSettingActivity() {
        this.TAG = "ContactsSettingActivity";
        this.mIsEmergencyPhoneExist = false;
    }

    static /* synthetic */ void access$000(ContactsSettingActivity r0) {
        r0.startImportOrExportActivity();
    }

    static /* synthetic */ OSwitch access$100(ContactsSettingActivity r0) {
        return r0.mOSwitch;
    }

    static /* synthetic */ void access$200(ContactsSettingActivity r0) {
        r0.handleEmergencyContact();
    }

    static /* synthetic */ void access$300(ContactsSettingActivity r0, String r1, String r2) {
        r0.startSettingsPrivacyWebViewActivity(r1, r2);
    }

    static /* synthetic */ void access$500(ContactsSettingActivity r0) {
        r0.pickEmergencyContact();
    }

    static /* synthetic */ OActionDialog access$600(ContactsSettingActivity r0) {
        return r0.dialog;
    }

    static /* synthetic */ void access$700(ContactsSettingActivity r0, String r1) {
        r0.updateEmergencyContact(r1);
    }

    static /* synthetic */ boolean access$802(ContactsSettingActivity r0, boolean r1) {
        r0.mIsEmergencyPhoneExist = r1;
        return r1;
    }

    public void com_android_contacts_ContactsSettingActivity__onCreate$___twin___(Bundle r3) {
        if (r3 != null) goto L4;
        TransitionAnimHelper.overrideEnterAnim(this, TransitionAnimStyle.Standard);
    L4:
        super.onCreate(r3);
        setContentView(R.layout.contacts_setting_activity);
        UiUtils.setWindowColorStatusBar(this);
        getWindow().setBackgroundDrawable(null);
        configTitle();
        OCardListItem r4 = (OCardListItem) findViewById(R.id.btn_sina);
        this.mBtnSync = r4;
        r4.setOnContentClickListener(new AnonymousClass1(this));
        OCardListItem r5 = (OCardListItem) findViewById(R.id.btn_ie);
        this.mBtnIE = r5;
        r5.setOnContentClickListener(new AnonymousClass2(this));
        OCardListItem r6 = (OCardListItem) findViewById(R.id.btn_only_display_has_num_contacts);
        this.mBtnOnlyDisplayHasNumContacts = r6;
        OSwitch r7 = r6.getEndSwitch();
        this.mOSwitch = r7;
        r7.setOnCheckedChangeListener(new AnonymousClass3(this));
        this.mBtnOnlyDisplayHasNumContacts.setOnContentClickListener(new AnonymousClass4(this));
        OCardListItem r8 = (OCardListItem) findViewById(R.id.btn_sort_and_display_options);
        this.mBtnSortAndDisplayOptions = r8;
        r8.setOnContentClickListener(new AnonymousClass5(this));
        OCardListItem r9 = (OCardListItem) findViewById(R.id.btn_account_filter_options);
        this.mBtnAccountFilterOptions = r9;
        r9.setOnContentClickListener(new AnonymousClass6(this));
        OCardListItem r10 = (OCardListItem) findViewById(R.id.btn_join_contacts);
        this.mBtnJoinContacts = r10;
        r10.setOnContentClickListener(new AnonymousClass7(this));
        if (ContactsUtils.FEATURE_CMCC == false) goto L7;
        OCardListItem r11 = (OCardListItem) findViewById(R.id.btn_memory_status);
        this.mBtnMemoryStatus = r11;
        r11.setVisibility(0);
        this.mBtnMemoryStatus.setOnContentClickListener(new AnonymousClass8(this));
    L7:
        OCardListItem r12 = (OCardListItem) findViewById(R.id.btn_emergency_contact);
        this.mBtnEmergencyContact = r12;
        r12.setOnContentClickListener(new AnonymousClass9(this));
        OCardListItem r13 = (OCardListItem) findViewById(R.id.btn_contacts_recycle_bin);
        this.mBtnContactsRecycleBin = r13;
        r13.setOnContentClickListener(new AnonymousClass10(this));
        OCardListItem r14 = (OCardListItem) findViewById(R.id.btn_privacy_policy);
        this.mBtnPrivacyPolicy = r14;
        r14.setOnContentClickListener(new AnonymousClass11(this));
        OCardListItem r15 = (OCardListItem) findViewById(R.id.btn_personal_information_collection_inventory);
        this.mBtnPersonalInformationCollectionInventory = r15;
        r15.setOnContentClickListener(new AnonymousClass12(this));
        this.mBtnPersonalInformationCollectionInventory.setVisibility(8);
        OCardListItem r16 = (OCardListItem) findViewById(R.id.btn_application_permission_management);
        this.mBtnApplicationPermissionManagement = r16;
        r16.setOnContentClickListener(new AnonymousClass13(this));
        OCardListItem r17 = (OCardListItem) findViewById(R.id.btn_application_permission_description);
        this.mBtnApplicationPermissionDescription = r17;
        r17.setOnContentClickListener(new AnonymousClass14(this));
        this.mBtnApplicationPermissionDescription.setVisibility(8);
    }

    private void configTitle() {
        ((OFloatingTitleBar) findViewById(R.id.otitlebar)).addStartAction(R.drawable.icon_back_22_22, -1, new AnonymousClass15(this));
    }

    public void com_android_contacts_ContactsSettingActivity__onStart$___twin___() {
        super.onStart();
        boolean r0 = ContactsUtils.contactsWithPhoneOnly(this);
        this.mOSwitch.setChecked(r0);
    }

    public void com_android_contacts_ContactsSettingActivity__onResume$___twin___() {
        super.onResume();
        Uri r0 = ContactsUtils.getEmergencyContactPhoneUri(this);
        this.mEmergencyPhoneUri = r0;
        if (r0 == null) goto L5;
        getLoaderManager().restartLoader(7, null, new MyLoaderCallbacks(this, null));
        return;
    L5:
        getLoaderManager().destroyLoader(7);
    }

    private void startImportOrExportActivity() {
        Intent r0 = new Intent(this, ContactsSettingIEActivity.class);
        r0.putExtra(Constants.EXTRA_FROM_SETTINGS, true);
        startActivity(r0);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r1) {
        super.startActivity(r1);
        AnimationUtil.switchActivityAnimation(this, 5);
    }

    private void startSettingsPrivacyWebViewActivity(String r2, String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == true) goto L9;
        WebViewActivity.open(this, r3, r2);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r3 == (-1)) goto L6;
        return;
    L6:
        if (r2 != 31) goto L14;
        ContactsUtils.setEmergencyContactPhoneUri(this, r4.getData());
        Uri r5 = ContactsUtils.getEmergencyContactPhoneUri(this);
        this.mEmergencyPhoneUri = r5;
        if (r5 == null) goto L11;
        getLoaderManager().restartLoader(7, null, new MyLoaderCallbacks(this, null));
        return;
    L11:
        getLoaderManager().destroyLoader(7);
        return;
    }

    private void pickEmergencyContact() {
        ActivityOptions r0 = ActivityOptions.makeCustomAnimation(this, R.anim.activity_slide_in_from_bottom, R.anim.activity_slide_do_nothing);
        Intent r1 = new Intent();
        r1.setAction("android.intent.action.PICK");
        r1.setType("vnd.android.cursor.dir/phone_v2");
        r1.putExtra(INTENT_PARAMS_IS_CLICK_EMERGENCY, true);
        startActivityForResult(r1, 31, r0.toBundle());
    }

    private void handleEmergencyContact() {
        if (this.mIsEmergencyPhoneExist == true) goto L5;
        pickEmergencyContact();
        return;
    L5:
        ArrayList r0 = new ArrayList();
        r0.add(new ActionDialogItemData(getString(R.string.btn_pick_emergency_contact), ActionButtonStyle.Neutral, new AnonymousClass16(this)));
        r0.add(new ActionDialogItemData(getString(R.string.btn_clear_emergency_contact), ActionButtonStyle.Neutral, new AnonymousClass17(this)));
        r0.add(new ActionDialogItemData(getString(R.string.common_cancel), ActionButtonStyle.Neutral, new AnonymousClass18(this)));
        OActionDialog r1 = OUIDialogHelper.getActionDialog(this, getString(R.string.title_set_emergency_contact), "", r0, true);
        this.dialog = r1;
        r1.setCanceledOnTouchOutside(true);
        this.dialog.show();
    }

    private void updateEmergencyContact(String r1) {
        OCardListItem r0 = this.mBtnEmergencyContact;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ContactsSettingActivity", "updateEmergencyContact: mBtnEmergencyContact is null");
        return;
    L6:
        r0.setEndDetailText(r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r4) {
        View r0 = findViewById(R.id.list_container);
        if (r0 == null) goto L6;
        r0.setPadding(0, 0, 0, r4 + ContactsUtils.dipTopx(this, 16.0d));
        return;
    }

    public void com_android_contacts_ContactsSettingActivity__finish$___twin___() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_ContactsSettingActivity_com_obric_privacyhook_PrivacyHook_onCreate(ContactsSettingActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsSettingActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_ContactsSettingActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_ContactsSettingActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ContactsSettingActivity r1) {
        com_android_contacts_ContactsSettingActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStart")
    public static void com_android_contacts_ContactsSettingActivity_com_obric_privacyhook_PrivacyHook_onStart(ContactsSettingActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsSettingActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r2.com_android_contacts_ContactsSettingActivity__onStart$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_ContactsSettingActivity_com_obric_privacyhook_PrivacyHook_onResume(ContactsSettingActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsSettingActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_ContactsSettingActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_ContactsSettingActivity_com_obric_privacyhook_PrivacyHook_onStop(ContactsSettingActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsSettingActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_ContactsSettingActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_ContactsSettingActivity_com_obric_privacyhook_PrivacyHook_finish(ContactsSettingActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsSettingActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_ContactsSettingActivity__finish$___twin___();
    }
}
