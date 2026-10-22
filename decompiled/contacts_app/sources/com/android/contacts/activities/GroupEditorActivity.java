package com.android.contacts.activities;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.WindowManager;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.group.GroupEditorFragment;
import com.android.contacts.util.DialogManager;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class GroupEditorActivity extends ContactsActivity implements DialogManager.DialogShowingViewActivity {
    public static final String ACTION_ADD_MEMBER_COMPLETED = "addMemberCompleted";
    public static final String ACTION_REMOVE_MEMBER_COMPLETED = "removeMemberCompleted";
    public static final String ACTION_SAVE_COMPLETED = "groupSaveCompleted";
    private static final String TAG = "GroupEditorActivity";
    private DialogManager mDialogManager;
    private GroupEditorFragment mFragment;
    private final GroupEditorFragment.Listener mFragmentListener;

    public void com_android_contacts_activities_GroupEditorActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_android_contacts_activities_GroupEditorActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_contacts_activities_GroupEditorActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        com_android_contacts_activities_GroupEditorActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_GroupEditorActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public GroupEditorActivity() {
        this.mDialogManager = new DialogManager(this);
        this.mFragmentListener = new AnonymousClass1(this);
    }

    public void com_android_contacts_activities_GroupEditorActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        String r0 = getIntent().getAction();
        if (ACTION_SAVE_COMPLETED.equals(r0) == false) goto L6;
        finish();
        return;
    L6:
        requestWindowFeature(1);
        Uri r2 = null;
        if (getResources().getBoolean(R.bool.config_group_editor_top_aligned) == false) goto L9;
        WindowManager.LayoutParams r1 = getWindow().getAttributes();
        r1.y = ContactsUtils.getScreenHeight(this) / 4;
        r1.gravity = 49;
        setContentView(LayoutInflater.from(this).inflate(R.layout.group_editor_activity, null), r1);
    L10:
        UiUtils.setWindowColorStatusBar(this);
        GroupEditorFragment r3 = (GroupEditorFragment) getSupportFragmentManager().findFragmentById(R.id.group_editor_fragment);
        this.mFragment = r3;
        r3.setListener(this.mFragmentListener);
        if (r6 == null) goto L13;
        return;
    L13:
        if ("android.intent.action.EDIT".equals(r0) == false) goto L15;
        r2 = getIntent().getData();
    L15:
        this.mFragment.load(r0, r2, getIntent().getExtras());
        return;
    L9:
        setContentView(R.layout.group_editor_activity);
        goto L10
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r2, Bundle r3) {
        if (DialogManager.isManagedId(r2) == true) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Unknown dialog requested, id: " + r2 + ", args: " + r3);
        return null;
    L5:
        return this.mDialogManager.onCreateDialog(r2, r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mFragment.save(0) == true) goto L6;
        super.onBackPressed();
        return;
    }

    public void com_android_contacts_activities_GroupEditorActivity__onNewIntent$___twin___(Intent r3) {
        super.onNewIntent(r3);
        if (this.mFragment != null) goto L6;
        return;
    L6:
        if (ACTION_SAVE_COMPLETED.equals(r3.getAction()) == false) goto L9;
        this.mFragment.onSaveCompleted(true, r3.getIntExtra("saveMode", 0), r3.getData());
        return;
    }

    public void com_android_contacts_activities_GroupEditorActivity__finish$___twin___() {
        super.finish();
    }

    @Override // com.android.contacts.util.DialogManager.DialogShowingViewActivity
    public DialogManager getDialogManager() {
        return this.mDialogManager;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_GroupEditorActivity_com_obric_privacyhook_PrivacyHook_onCreate(GroupEditorActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        GroupEditorActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_GroupEditorActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_GroupEditorActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(GroupEditorActivity r1) {
        com_android_contacts_activities_GroupEditorActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_GroupEditorActivity_com_obric_privacyhook_PrivacyHook_onStop(GroupEditorActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        GroupEditorActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_GroupEditorActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_activities_GroupEditorActivity_com_obric_privacyhook_PrivacyHook_finish(GroupEditorActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        GroupEditorActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_activities_GroupEditorActivity__finish$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onNewIntent")
    public static void com_android_contacts_activities_GroupEditorActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(GroupEditorActivity r2, Intent r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        GroupEditorActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r3);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_GroupEditorActivity__onNewIntent$___twin___(r3);
    }
}
