package com.android.contacts.activities;

import android.app.Fragment;
import android.os.Bundle;
import com.android.contacts.ContactsActivity;
import com.android.contacts.R;
import com.android.contacts.list.JoinContactListFragment;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class PickContactActivity extends ContactsActivity {
    public static final String EXTRA_TARGET_CONTACT_ID = "com.android.contacts.action.CONTACT_ID";
    public static final String JOIN_CONTACT = "com.android.contacts.action.JOIN_CONTACT";
    private static final String KEY_TARGET_CONTACT_ID = "targetContactId";
    private static final String TAG = "JoinContactActivity";
    private JoinContactListFragment mListFragment;
    private long mTargetContactId;

    public void com_android_contacts_activities_PickContactActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment r1) {
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_PickContactActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_PickContactActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public PickContactActivity() {
    }

    public void com_android_contacts_activities_PickContactActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setContentView(R.layout.join_contact_picker);
        UiUtils.setWindowColorStatusBar(this);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_PickContactActivity_com_obric_privacyhook_PrivacyHook_onCreate(PickContactActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        PickContactActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_PickContactActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_PickContactActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PickContactActivity r1) {
        com_android_contacts_activities_PickContactActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_PickContactActivity_com_obric_privacyhook_PrivacyHook_onStop(PickContactActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        PickContactActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_PickContactActivity__onStop$___twin___();
    }
}
