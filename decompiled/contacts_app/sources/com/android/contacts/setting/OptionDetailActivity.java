package com.android.contacts.setting;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ScrollView;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class OptionDetailActivity extends AbstractSettingActivity {
    public static final String ACTION_DISPLAY_OPTION = "com.bytedanceos.contacts.action.DISPLAY_OPTION";
    public static final String ACTION_SORT_OPTION = "com.bytedanceos.contacts.action.SORT_OPTION";
    private String mAction;
    private ScrollView mContent;
    private FragmentManager mFragmentManager;

    public void com_android_contacts_setting_OptionDetailActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.setting.AbstractSettingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_setting_OptionDetailActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.setting.AbstractSettingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_setting_OptionDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public OptionDetailActivity() {
    }

    public void com_android_contacts_setting_OptionDetailActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.option_detail_layout);
        UiUtils.setWindowColorStatusBar(this);
        this.mAction = getIntent().getAction();
        OFloatingTitleBar r5 = (OFloatingTitleBar) findViewById(R.id.otitle_bar);
        r5.addStartAction(R.drawable.icon_back_22_22, -1, new AnonymousClass1(this));
        if (ACTION_SORT_OPTION.equals(this.mAction) == false) goto L5;
        r5.setCenterTitle(getString(R.string.setting_sort_options));
        setTitle(getResources().getString(R.string.setting_sort_options));
    L6:
        this.mContent = (ScrollView) findViewById(R.id.content);
        this.mFragmentManager = getFragmentManager();
        configFragment();
        return;
    L5:
        r5.setCenterTitle(getString(R.string.setting_display_options));
        setTitle(getResources().getString(R.string.setting_display_options));
        goto L6
    }

    private void configFragment() {
        this.mContent.removeAllViews();
        if (ACTION_SORT_OPTION.equals(this.mAction) == false) goto L5;
        FragmentTransaction r0 = this.mFragmentManager.beginTransaction();
        r0.replace(R.id.content, new SortOrderFragment());
        r0.commitAllowingStateLoss();
        this.mFragmentManager.executePendingTransactions();
        return;
    L5:
        FragmentTransaction r1 = this.mFragmentManager.beginTransaction();
        r1.replace(R.id.content, new DisplayOrderFragment());
        r1.commitAllowingStateLoss();
        this.mFragmentManager.executePendingTransactions();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_setting_OptionDetailActivity_com_obric_privacyhook_PrivacyHook_onCreate(OptionDetailActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        OptionDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_setting_OptionDetailActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_setting_OptionDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(OptionDetailActivity r1) {
        com_android_contacts_setting_OptionDetailActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_setting_OptionDetailActivity_com_obric_privacyhook_PrivacyHook_onStop(OptionDetailActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        OptionDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_setting_OptionDetailActivity__onStop$___twin___();
    }
}
