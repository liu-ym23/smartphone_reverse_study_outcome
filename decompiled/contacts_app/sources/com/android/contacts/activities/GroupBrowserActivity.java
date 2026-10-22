package com.android.contacts.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.contacts.ContactsActivity;
import com.android.contacts.R;
import com.android.contacts.group.GroupDetailFragment;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class GroupBrowserActivity extends ContactsActivity {
    private static final String TAG = "GroupBrowserActivity";

    public void com_android_contacts_activities_GroupBrowserActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_GroupBrowserActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        com_android_contacts_activities_GroupBrowserActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_GroupBrowserActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public GroupBrowserActivity() {
    }

    static /* synthetic */ int access$000(GroupBrowserActivity r0) {
        return r0.mDisplayOrder;
    }

    static /* synthetic */ int access$100(GroupBrowserActivity r0) {
        return r0.mSortOrder;
    }

    public void com_android_contacts_activities_GroupBrowserActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        configureContentView(true, r2);
        UiUtils.setWindowColorStatusBar(this);
    }

    public void com_android_contacts_activities_GroupBrowserActivity__onNewIntent$___twin___(Intent r3) {
        super.onNewIntent(r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getBooleanExtra(ContactsActivity.SAVE_COMPLETE, false) == true) goto L7;
        return;
    L7:
        if (GroupEditorActivity.ACTION_SAVE_COMPLETED.equals(r3.getAction()) == false) goto L14;
        GroupDetailFragment r2 = getGroupDetailFragment();
        if (r2 == null) goto L15;
        r2.groupSaveCompleted();
        return;
    L15:
        return;
    }

    private void configureContentView(boolean r2, Bundle r3) {
        if (r2 == false) goto L9;
        setContentView(R.layout.group_browser_activity);
        Uri r4 = getIntent().getData();
        if (r4 != null) goto L7;
        finish();
        return;
    L7:
        GroupDetailFragment r5 = getGroupDetailFragment();
        r5.setPrefsCallback(new AnonymousClass1(this));
        r5.loadGroup(r4);
        return;
    }

    private GroupDetailFragment getGroupDetailFragment() {
        return (GroupDetailFragment) getSupportFragmentManager().findFragmentById(R.id.list_fragment);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_GroupBrowserActivity_com_obric_privacyhook_PrivacyHook_onCreate(GroupBrowserActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        GroupBrowserActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_GroupBrowserActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_GroupBrowserActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(GroupBrowserActivity r1) {
        com_android_contacts_activities_GroupBrowserActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_GroupBrowserActivity_com_obric_privacyhook_PrivacyHook_onStop(GroupBrowserActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        GroupBrowserActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_GroupBrowserActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onNewIntent")
    public static void com_android_contacts_activities_GroupBrowserActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(GroupBrowserActivity r2, Intent r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        GroupBrowserActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r3);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_GroupBrowserActivity__onNewIntent$___twin___(r3);
    }
}
