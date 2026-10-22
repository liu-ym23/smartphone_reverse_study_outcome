package com.android.contacts;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.contacts.interactions.PhoneNumberInteraction;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class CallContactActivity extends ContactsActivity implements DialogInterface.OnDismissListener {
    public void com_android_contacts_CallContactActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_CallContactActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_CallContactActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public CallContactActivity() {
    }

    public void com_android_contacts_CallContactActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        UiUtils.setWindowColorStatusBar(this);
        Uri r0 = getIntent().getData();
        if (r0 != null) goto L5;
        finish();
    L5:
        if (r3 == null) goto L7;
        return;
    L7:
        UiUtils.setWindowColorStatusBar(this);
        if ("vnd.android.cursor.item/contact".equals(getContentResolver().getType(r0)) == false) goto L10;
        PhoneNumberInteraction.startInteractionForPhoneCall(this, r0);
        return;
    L10:
        startActivity(new Intent("android.intent.action.CALL_PRIVILEGED", r0));
        finish();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        if (isChangingConfigurations() == true) goto L6;
        finish();
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_CallContactActivity_com_obric_privacyhook_PrivacyHook_onCreate(CallContactActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallContactActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_CallContactActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_CallContactActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CallContactActivity r1) {
        com_android_contacts_CallContactActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_CallContactActivity_com_obric_privacyhook_PrivacyHook_onStop(CallContactActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallContactActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_CallContactActivity__onStop$___twin___();
    }
}
