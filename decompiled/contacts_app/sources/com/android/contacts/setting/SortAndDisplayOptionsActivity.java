package com.android.contacts.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.android.contacts.R;
import com.android.contacts.preference.ContactsPreferences;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.TitleBarUtil;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SortAndDisplayOptionsActivity extends AbstractSettingActivity implements View.OnClickListener {
    private OCardListItem mBtnDisplayOptions;
    private OTextView mBtnDisplayOptionsEndText;
    private OCardListItem mBtnSortOptions;
    private OTextView mBtnSortOptionsEndText;
    private int mDisplayOrder;
    private ContactsPreferences.ChangeListener mOnChangeListener;
    private ContactsPreferences mPrefs;
    private int mSortOrder;

    public void com_android_contacts_setting_SortAndDisplayOptionsActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    @Override // com.android.contacts.setting.AbstractSettingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_setting_SortAndDisplayOptionsActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.setting.AbstractSettingActivity, com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_setting_SortAndDisplayOptionsActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.setting.AbstractSettingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_setting_SortAndDisplayOptionsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public SortAndDisplayOptionsActivity() {
        this.mDisplayOrder = -1;
        this.mSortOrder = -1;
        this.mOnChangeListener = new AnonymousClass4(this);
    }

    static /* synthetic */ void access$000(SortAndDisplayOptionsActivity r0) {
        r0.bindData();
    }

    public void com_android_contacts_setting_SortAndDisplayOptionsActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.sort_and_display_options);
        UiUtils.setWindowColorStatusBar(this);
        configTitle();
        OCardListItem r6 = (OCardListItem) findViewById(R.id.btn_sort_options);
        this.mBtnSortOptions = r6;
        r6.setCardType(0);
        this.mBtnSortOptions.setCardPosition(1);
        this.mBtnSortOptions.setTitle(getString(R.string.setting_sort_options));
        this.mBtnSortOptions.setDefaultCustomEndView(3);
        this.mBtnSortOptions.setDefaultTailIcon(0);
        this.mBtnSortOptions.showCustomEnd(true);
        this.mBtnSortOptions.showTailIcon(true);
        this.mBtnSortOptions.setOnContentClickListener(new AnonymousClass1(this));
        OCardListItem r7 = (OCardListItem) findViewById(R.id.btn_display_options);
        this.mBtnDisplayOptions = r7;
        r7.setCardType(0);
        this.mBtnDisplayOptions.setCardPosition(3);
        this.mBtnDisplayOptions.setTitle(getString(R.string.setting_display_options));
        this.mBtnDisplayOptions.setDefaultCustomEndView(3);
        this.mBtnDisplayOptions.setDefaultTailIcon(0);
        this.mBtnDisplayOptions.showCustomEnd(true);
        this.mBtnDisplayOptions.showTailIcon(true);
        this.mBtnDisplayOptions.setOnContentClickListener(new AnonymousClass2(this));
        this.mBtnDisplayOptionsEndText = this.mBtnDisplayOptions.getEndDetail();
        this.mBtnSortOptionsEndText = this.mBtnSortOptions.getEndDetail();
        ContactsPreferences r8 = new ContactsPreferences(this);
        this.mPrefs = r8;
        r8.registerChangeListener(this.mOnChangeListener);
        bindData();
    }

    private void configTitle() {
        Intent r0 = getIntent();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        ((OFloatingTitleBar) findViewById(R.id.otitle_bar)).addStartAction(TitleBarUtil.getLeftRes(r1), -1, new AnonymousClass3(this));
        return;
    L5:
        if (r0.getBooleanExtra(Constants.EXTRA_FROM_SETTINGS, false) == false) goto L7;
        r1 = true;
        goto L7
    }

    private void bindData() {
        if (this.mDisplayOrder == this.mPrefs.getDisplayOrder()) goto L11;
        int r0 = this.mPrefs.getDisplayOrder();
        this.mDisplayOrder = r0;
        OTextView r1 = this.mBtnDisplayOptionsEndText;
        if (r1 == null) goto L11;
        if (r0 != 1) goto L8;
        String r2 = getString(R.string.setting_display_option_given_name);
    L9:
        r1.setText(r2);
        goto L11
    L8:
        r2 = getString(R.string.setting_display_option_family_name);
    L11:
        if (this.mSortOrder == this.mPrefs.getSortOrder()) goto L19;
        int r3 = this.mPrefs.getSortOrder();
        this.mSortOrder = r3;
        OTextView r4 = this.mBtnSortOptionsEndText;
        if (r4 == null) goto L20;
        if (r3 != 1) goto L16;
        String r5 = getString(R.string.setting_sort_option_given_name);
    L17:
        r4.setText(r5);
        return;
    L16:
        r5 = getString(R.string.setting_sort_option_family_name);
        goto L17
    L20:
        return;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r1) {
        super.startActivity(r1);
        AnimationUtil.switchActivityAnimation(this, 5);
    }

    public void com_android_contacts_setting_SortAndDisplayOptionsActivity__onDestroy$___twin___() {
        super.onDestroy();
        this.mPrefs.unregisterChangeListener();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_setting_SortAndDisplayOptionsActivity_com_obric_privacyhook_PrivacyHook_onCreate(SortAndDisplayOptionsActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        SortAndDisplayOptionsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_setting_SortAndDisplayOptionsActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_setting_SortAndDisplayOptionsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SortAndDisplayOptionsActivity r1) {
        com_android_contacts_setting_SortAndDisplayOptionsActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_setting_SortAndDisplayOptionsActivity_com_obric_privacyhook_PrivacyHook_onStop(SortAndDisplayOptionsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        SortAndDisplayOptionsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_setting_SortAndDisplayOptionsActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_setting_SortAndDisplayOptionsActivity_com_obric_privacyhook_PrivacyHook_onDestroy(SortAndDisplayOptionsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        SortAndDisplayOptionsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_setting_SortAndDisplayOptionsActivity__onDestroy$___twin___();
    }
}
