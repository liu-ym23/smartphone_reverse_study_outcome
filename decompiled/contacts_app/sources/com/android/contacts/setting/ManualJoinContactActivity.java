package com.android.contacts.setting;

import android.os.Bundle;
import com.android.contacts.ContactsActivity;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ManualJoinContactActivity extends ContactsActivity {
    private static final String TAG = "ManualJoinContactActivity";
    private ManualJoinContactFragment mListFragment;
    private PreferencesCallback mPreferencesCallback;

    public void com_android_contacts_setting_ManualJoinContactActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_setting_ManualJoinContactActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_setting_ManualJoinContactActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ManualJoinContactActivity() {
        this.mPreferencesCallback = new AnonymousClass1(this);
    }

    static /* synthetic */ int access$000(ManualJoinContactActivity r0) {
        return r0.mDisplayOrder;
    }

    static /* synthetic */ int access$100(ManualJoinContactActivity r0) {
        return r0.mSortOrder;
    }

    public void com_android_contacts_setting_ManualJoinContactActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.manual_join_contact_activity);
        UiUtils.setWindowColorStatusBar(this);
        if (this.mListFragment != null) goto L6;
        this.mListFragment = new ManualJoinContactFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.list_container, this.mListFragment).commitAllowingStateLoss();
        this.mListFragment.setPrefsCallback(this.mPreferencesCallback);
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_setting_ManualJoinContactActivity_com_obric_privacyhook_PrivacyHook_onCreate(ManualJoinContactActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ManualJoinContactActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_setting_ManualJoinContactActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_setting_ManualJoinContactActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ManualJoinContactActivity r1) {
        com_android_contacts_setting_ManualJoinContactActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_setting_ManualJoinContactActivity_com_obric_privacyhook_PrivacyHook_onStop(ManualJoinContactActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ManualJoinContactActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_setting_ManualJoinContactActivity__onStop$___twin___();
    }
}
