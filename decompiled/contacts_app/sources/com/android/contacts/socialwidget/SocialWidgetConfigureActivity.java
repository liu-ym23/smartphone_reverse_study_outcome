package com.android.contacts.socialwidget;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SocialWidgetConfigureActivity extends Activity {
    public void com_android_contacts_socialwidget_SocialWidgetConfigureActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_socialwidget_SocialWidgetConfigureActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public SocialWidgetConfigureActivity() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        setResult(0);
        Intent r0 = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        r0.setFlags(603979776);
        startActivityForResult(r0, 0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        if (r4 != (-1)) goto L9;
        Bundle r6 = getIntent().getExtras();
        if (r6 == null) goto L8;
        int r7 = r6.getInt("appWidgetId", 0);
        SocialWidgetSettings.getInstance().setContactUri(this, r7, r5.getData());
        SocialWidgetProvider.loadWidgetData(this, AppWidgetManager.getInstance(this), r7, true);
        Intent r8 = new Intent();
        r8.putExtra("appWidgetId", r7);
        setResult(-1, r8);
        goto L9
    L8:
        throw new IllegalStateException("Intent extras are null");
    L9:
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_socialwidget_SocialWidgetConfigureActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SocialWidgetConfigureActivity r1) {
        r1.com_android_contacts_socialwidget_SocialWidgetConfigureActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
