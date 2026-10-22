package com.android.contacts;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.MenuDialog;

/* JADX INFO: loaded from: classes.dex */
public class WarnNotDefaultDialerAppActivity extends Activity {
    public void com_android_contacts_WarnNotDefaultDialerAppActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_WarnNotDefaultDialerAppActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public WarnNotDefaultDialerAppActivity() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        showExitAppDialog();
    }

    private void showExitAppDialog() {
        MenuDialog r0 = new MenuDialog(this);
        r0.setTitle(R.string.not_default_dialer_app_text);
        r0.setNegativeButton(new AnonymousClass1(this));
        r0.setPositiveButton(R.string.modify_default_dialer_app, new AnonymousClass2(this));
        r0.setCancelable(false);
        r0.show();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_WarnNotDefaultDialerAppActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(WarnNotDefaultDialerAppActivity r1) {
        r1.com_android_contacts_WarnNotDefaultDialerAppActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
