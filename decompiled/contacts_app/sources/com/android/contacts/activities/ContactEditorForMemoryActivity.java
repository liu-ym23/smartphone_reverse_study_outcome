package com.android.contacts.activities;

import android.content.ComponentName;
import android.os.Bundle;
import android.view.WindowManager;
import com.GlobalProxyLancet;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class ContactEditorForMemoryActivity extends ContactEditorActivity {
    private static final String TAG = "ContactEditorForMemoryActivity";

    public void com_android_contacts_activities_ContactEditorForMemoryActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.activities.ContactEditorActivity, com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_contacts_activities_ContactEditorForMemoryActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_ContactEditorForMemoryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ContactEditorForMemoryActivity() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, " ContactEditorForMemoryActivity construct");
    }

    public void com_android_contacts_activities_ContactEditorForMemoryActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        UiUtils.setWindowColorStatusBar(this);
        getIntent().setComponent(new ComponentName(this, ContactEditorForMemoryActivity.class));
        int r7 = getWindowManager().getCurrentWindowMetrics().getBounds().height();
        WindowManager.LayoutParams r0 = getWindow().getAttributes();
        r0.gravity = 80;
        r0.width = -1;
        r0.height = (int) (((double) r7) * 0.9d);
        getWindow().setAttributes(r0);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_ContactEditorForMemoryActivity_com_obric_privacyhook_PrivacyHook_onCreate(ContactEditorForMemoryActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorForMemoryActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_ContactEditorForMemoryActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_ContactEditorForMemoryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ContactEditorForMemoryActivity r1) {
        com_android_contacts_activities_ContactEditorForMemoryActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_ContactEditorForMemoryActivity_com_obric_privacyhook_PrivacyHook_onStop(ContactEditorForMemoryActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorForMemoryActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_ContactEditorForMemoryActivity__onStop$___twin___();
    }
}
