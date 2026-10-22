package com.android.contacts.setting;

import android.os.Bundle;
import com.android.contacts.BaseActivity;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes2.dex */
public class AbstractSettingActivity extends BaseActivity {
    private String mClassName;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_setting_AbstractSettingActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_setting_AbstractSettingActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_contacts_setting_AbstractSettingActivity_com_obric_privacyhook_PrivacyHook_onStop(this);
    }

    public AbstractSettingActivity() {
        this.mClassName = "";
    }

    public void com_android_contacts_setting_AbstractSettingActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mClassName = "AbstractSettingActivity";
        Agent.getInstance().onAttach(this.mClassName);
    }

    public void com_android_contacts_setting_AbstractSettingActivity__onStop$___twin___() {
        super.onStop();
        Agent.getInstance().flush();
    }

    public void com_android_contacts_setting_AbstractSettingActivity__onDestroy$___twin___() {
        super.onDestroy();
        Agent.getInstance().onDetach(this.mClassName);
        Agent.getInstance().flush();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_setting_AbstractSettingActivity_com_obric_privacyhook_PrivacyHook_onCreate(AbstractSettingActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AbstractSettingActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_setting_AbstractSettingActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_setting_AbstractSettingActivity_com_obric_privacyhook_PrivacyHook_onStop(AbstractSettingActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AbstractSettingActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_setting_AbstractSettingActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_setting_AbstractSettingActivity_com_obric_privacyhook_PrivacyHook_onDestroy(AbstractSettingActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AbstractSettingActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_setting_AbstractSettingActivity__onDestroy$___twin___();
    }
}
