package com.android.contacts.common.preference;

import android.R;
import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class ContactsPreferenceActivity extends PreferenceActivity {
    private static final String TAG_ABOUT_CONTACTS = "about_contacts";

    public void com_android_contacts_common_preference_ContactsPreferenceActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onStop() {
        com_android_contacts_common_preference_ContactsPreferenceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ContactsPreferenceActivity() {
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        ActionBar r0 = getActionBar();
        if (r0 == null) goto L5;
        r0.setDisplayOptions(4, 4);
    L5:
        if (r3 != null) goto L8;
        getFragmentManager().beginTransaction().replace(R.id.content, new DisplayOptionsPreferenceFragment()).commit();
        setActivityTitle(com.android.contacts.common.R.string.common_settings);
        return;
    L8:
        if (((AboutPreferenceFragment) getFragmentManager().findFragmentByTag(TAG_ABOUT_CONTACTS)) != null) goto L10;
        int r4 = com.android.contacts.common.R.string.common_settings;
    L11:
        setActivityTitle(r4);
        return;
    L10:
        r4 = com.android.contacts.common.R.string.setting_about;
        goto L11
    }

    public void showAboutFragment() {
        getFragmentManager().beginTransaction().replace(R.id.content, new AboutPreferenceFragment(), TAG_ABOUT_CONTACTS).addToBackStack(null).commit();
        setActivityTitle(com.android.contacts.common.R.string.setting_about);
    }

    public static boolean isEmpty(Context r2) {
        if (r2.getResources().getBoolean(com.android.contacts.common.R.bool.config_sort_order_user_changeable) == false) goto L5;
    L9:
        return false;
    L5:
        if (r2.getResources().getBoolean(com.android.contacts.common.R.bool.config_display_order_user_changeable) == true) goto L9;
        if (r2.getResources().getBoolean(com.android.contacts.common.R.bool.config_default_account_user_changeable) == true) goto L9;
        return true;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r2) {
        if (r2.getItemId() != 16908332) goto L6;
        onBackPressed();
        return true;
    L6:
        return false;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() <= 0) goto L5;
        setActivityTitle(com.android.contacts.common.R.string.common_settings);
        getFragmentManager().popBackStack();
        return;
    L5:
        super.onBackPressed();
    }

    private void setActivityTitle(int r1) {
        ActionBar r0 = getActionBar();
        if (r0 == null) goto L6;
        r0.setTitle(r1);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_preference_ContactsPreferenceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ContactsPreferenceActivity r1) {
        r1.com_android_contacts_common_preference_ContactsPreferenceActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
