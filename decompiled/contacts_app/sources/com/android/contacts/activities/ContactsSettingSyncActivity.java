package com.android.contacts.activities;

import android.app.Activity;
import android.os.Bundle;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.titlebar.OCTitleBar;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class ContactsSettingSyncActivity extends Activity {
    private OListItemSettings mBtnSina;

    public void com_android_contacts_activities_ContactsSettingSyncActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_activities_ContactsSettingSyncActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ContactsSettingSyncActivity() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r2) {
        super.onCreate(r2);
        setContentView(R.layout.contacts_setting_sync_aciticity);
        UiUtils.setWindowColorStatusBar(this);
        getWindow().setBackgroundDrawable(null);
        OListItemSettings r3 = (OListItemSettings) findViewById(R.id.btn_sina);
        this.mBtnSina = r3;
        r3.setOnClickListener(new AnonymousClass1(this));
        ((OCTitleBar) findViewById(R.id.otitlebar)).getMLeftActionBack().setOnClickListener(new AnonymousClass2(this));
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_ContactsSettingSyncActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ContactsSettingSyncActivity r1) {
        r1.com_android_contacts_activities_ContactsSettingSyncActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
