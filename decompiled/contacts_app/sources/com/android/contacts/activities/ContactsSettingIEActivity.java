package com.android.contacts.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.android.contacts.R;
import com.android.contacts.setting.AbstractSettingActivity;
import com.android.contacts.setting.ImportExportFragment;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.IntentUtils;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class ContactsSettingIEActivity extends AbstractSettingActivity {
    private ImportExportFragment ieFragment;

    public void com_android_contacts_activities_ContactsSettingIEActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.setting.AbstractSettingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_ContactsSettingIEActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_activities_ContactsSettingIEActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.setting.AbstractSettingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_ContactsSettingIEActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ContactsSettingIEActivity() {
    }

    public void com_android_contacts_activities_ContactsSettingIEActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.contacts_setting_ie_aciticity);
        UiUtils.setWindowColorStatusBar(this);
        getWindow().setBackgroundDrawable(null);
        FragmentTransaction r4 = getSupportFragmentManager().beginTransaction();
        ImportExportFragment r0 = new ImportExportFragment();
        this.ieFragment = r0;
        r4.add(R.id.view, r0);
        r4.commit();
        if (IntentUtils.getBooleanExtra(getIntent(), "start_from_notification", false) == false) goto L6;
        AnimationUtil.switchActivityAnimation(this, 4);
        return;
    }

    public void com_android_contacts_activities_ContactsSettingIEActivity__onResume$___twin___() {
        super.onResume();
        Intent r0 = getIntent();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getIntExtra("fromFlag", 0);
        boolean r2 = r0.getBooleanExtra(Constants.EXTRA_FROM_SETTINGS, false);
        ImportExportFragment r4 = this.ieFragment;
        if (r4 != null) goto L8;
        return;
    L8:
        if (r1 == 1) goto L10;
        if (r2 == false) goto L10;
        return;
    L10:
        r4.resetBackText();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_ContactsSettingIEActivity_com_obric_privacyhook_PrivacyHook_onCreate(ContactsSettingIEActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsSettingIEActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_ContactsSettingIEActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_ContactsSettingIEActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ContactsSettingIEActivity r1) {
        com_android_contacts_activities_ContactsSettingIEActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_activities_ContactsSettingIEActivity_com_obric_privacyhook_PrivacyHook_onResume(ContactsSettingIEActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsSettingIEActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_activities_ContactsSettingIEActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_ContactsSettingIEActivity_com_obric_privacyhook_PrivacyHook_onStop(ContactsSettingIEActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsSettingIEActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_ContactsSettingIEActivity__onStop$___twin___();
    }
}
