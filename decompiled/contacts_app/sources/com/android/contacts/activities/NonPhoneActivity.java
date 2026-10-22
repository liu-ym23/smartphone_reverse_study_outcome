package com.android.contacts.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.contacts.ContactsActivity;
import com.android.contacts.dialpad.NewDialpadFragment;
import com.android.contacts.util.Constants;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class NonPhoneActivity extends ContactsActivity {
    public void com_android_contacts_activities_NonPhoneActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_NonPhoneActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_NonPhoneActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public NonPhoneActivity() {
    }

    public void com_android_contacts_activities_NonPhoneActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        UiUtils.setWindowColorStatusBar(this);
        mayResolveInCallIntent();
        String r6 = getPhoneNumber();
        if (TextUtils.isEmpty(r6) == false) goto L6;
        finish();
        return;
    L6:
        Intent r0 = getIntent();
        if (r0 != null) goto L9;
    L11:
        String r1 = "android.intent.action.DIAL";
    L12:
        Intent r2 = new Intent(this, DialtactsActivity.class);
        r2.setAction(r1);
        Bundle r3 = null;
        r2.setData(Uri.fromParts(Constants.SCHEME_TEL, r6, null));
        if (r0 == null) goto L15;
        r3 = r0.getExtras();
    L15:
        if (r3 == null) goto L17;
        r2.putExtras(r3);
    L17:
        startActivity(r2);
        finish();
        return;
    L9:
        if (r0.getAction() == null) goto L11;
        r1 = r0.getAction();
        goto L12
    }

    private void mayResolveInCallIntent() {
        if (getIntent() != null) goto L5;
        return;
    L5:
        if (getIntent().getExtras() == null) goto L16;
        Bundle r0 = getIntent().getExtras();
        if (r0.getBoolean("launched_by_incall", false) == true) goto L10;
        return;
    L10:
        if (r0.getBoolean(NewDialpadFragment.ADD_CALL_MODE_KEY, false) == false) goto L15;
        Intent r1 = new Intent(this, DialtactsActivity.class);
        r1.putExtras(r0);
        startActivity(r1);
        finish();
        return;
    L15:
        return;
    }

    private String getPhoneNumber() {
        if (getIntent() != null) goto L5;
        return null;
    L5:
        Uri r3 = getIntent().getData();
        if (r3 != null) goto L9;
        return null;
    L9:
        if (Constants.SCHEME_TEL.equals(r3.getScheme()) == true) goto L12;
        return null;
    L12:
        return r3.getSchemeSpecificPart();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_NonPhoneActivity_com_obric_privacyhook_PrivacyHook_onCreate(NonPhoneActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        NonPhoneActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_NonPhoneActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_NonPhoneActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(NonPhoneActivity r1) {
        com_android_contacts_activities_NonPhoneActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_NonPhoneActivity_com_obric_privacyhook_PrivacyHook_onStop(NonPhoneActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        NonPhoneActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_NonPhoneActivity__onStop$___twin___();
    }
}
