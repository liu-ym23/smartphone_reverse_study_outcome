package com.android.contacts.preference;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DialpadPreferenceActivity extends PreferenceActivity {
    public void com_android_contacts_preference_DialpadPreferenceActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onStop() {
        com_android_contacts_preference_DialpadPreferenceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public DialpadPreferenceActivity() {
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle r4) {
        Intent r0 = getIntent();
        UiUtils.setWindowColorStatusBar(this);
        if (r0 == null) goto L5;
        String r2 = (String) null;
        r0.putExtra(":android:show_fragment", null);
        Bundle r3 = (Bundle) null;
        r0.putExtra(":android:show_fragment_args", null);
    L5:
        super.onCreate(r4);
        addPreferencesFromResource(R.xml.preference_dialpad_options);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_preference_DialpadPreferenceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DialpadPreferenceActivity r1) {
        r1.com_android_contacts_preference_DialpadPreferenceActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
