package com.android.contacts.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import androidx.fragment.app.Fragment;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsActivity;
import com.android.contacts.R;
import com.android.contacts.list.JoinContactListFragment;
import com.android.contacts.util.IntentUtils;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class JoinContactActivity extends ContactsActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener, View.OnFocusChangeListener {
    public static final String EXTRA_TARGET_CONTACT_ID = "com.android.contacts.action.CONTACT_ID";
    public static final String JOIN_CONTACT = "com.android.contacts.action.JOIN_CONTACT";
    private static final String KEY_TARGET_CONTACT_ID = "targetContactId";
    private static final String TAG = "JoinContactActivity";
    private JoinContactListFragment mListFragment;
    private SearchView mSearchView;
    private long mTargetContactId;

    public void com_android_contacts_activities_JoinContactActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_JoinContactActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String r1) {
        return false;
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_JoinContactActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public JoinContactActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment r2) {
        if ((r2 instanceof JoinContactListFragment) == false) goto L6;
        this.mListFragment = (JoinContactListFragment) r2;
        setupActionListener();
        return;
    }

    public void com_android_contacts_activities_JoinContactActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        Intent r7 = getIntent();
        long r3 = IntentUtils.getLongExtra(r7, "com.android.contacts.action.CONTACT_ID", -1);
        this.mTargetContactId = r3;
        if (r3 != (-1)) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Intent " + r7.getAction() + " is missing required extra: com.android.contacts.action.CONTACT_ID");
        setResult(0);
        finish();
        return;
    L6:
        setContentView(R.layout.join_contact_picker);
        UiUtils.setWindowColorStatusBar(this);
        setTitle(R.string.common_merge_contacts);
        if (this.mListFragment != null) goto L9;
        this.mListFragment = new JoinContactListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.list_container, this.mListFragment).commitAllowingStateLoss();
    L9:
        prepareSearchViewAndActionBar();
    }

    private void setupActionListener() {
        this.mListFragment.setTargetContactId(this.mTargetContactId);
        this.mListFragment.setOnContactPickerActionListener(new AnonymousClass1(this));
    }

    private void prepareSearchViewAndActionBar() {
        ActionBar r0 = getActionBar();
        if (r0 == null) goto L8;
        View r3 = findViewById(R.id.search_view);
        if (r3 == null) goto L7;
        r3.setVisibility(8);
    L7:
        View r4 = LayoutInflater.from(r0.getThemedContext()).inflate(R.layout.custom_action_bar, null);
        SearchView r2 = (SearchView) r4.findViewById(R.id.search_view);
        this.mSearchView = r2;
        r2.setIconifiedByDefault(true);
        this.mSearchView.setQueryHint(getString(R.string.hint_findContacts));
        this.mSearchView.setIconified(false);
        this.mSearchView.setOnQueryTextListener(this);
        this.mSearchView.setOnCloseListener(this);
        this.mSearchView.setOnQueryTextFocusChangeListener(this);
        r0.setCustomView(r4, new ActionBar.LayoutParams(-1, -2));
        r0.setDisplayShowCustomEnabled(true);
        r0.setDisplayShowHomeEnabled(true);
        r0.setDisplayHomeAsUpEnabled(true);
    L9:
        this.mSearchView.clearFocus();
        return;
    L8:
        SearchView r1 = (SearchView) findViewById(R.id.search_view);
        this.mSearchView = r1;
        r1.setQueryHint(getString(R.string.hint_findContacts));
        this.mSearchView.setOnQueryTextListener(this);
        this.mSearchView.setOnQueryTextFocusChangeListener(this);
        goto L9
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String r2) {
        this.mListFragment.setQueryString(r2, true);
        return false;
    }

    @Override // android.widget.SearchView.OnCloseListener
    public boolean onClose() {
        if (TextUtils.isEmpty(this.mSearchView.getQuery()) == true) goto L5;
        this.mSearchView.setQuery(null, true);
    L5:
        return true;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View r2, boolean r3) {
        if (r2.getId() != R.id.search_view) goto L9;
        if (r3 == false) goto L8;
        showInputMethod(this.mSearchView.findFocus());
        return;
    L8:
        return;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r3) {
        if (r3.getItemId() != 16908332) goto L5;
        setResult(0);
        finish();
        return true;
    L5:
        return super.onOptionsItemSelected(r3);
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r4) {
        super.onSaveInstanceState(r4);
        r4.putLong(KEY_TARGET_CONTACT_ID, this.mTargetContactId);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle r3) {
        super.onRestoreInstanceState(r3);
        this.mTargetContactId = r3.getLong(KEY_TARGET_CONTACT_ID);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 == 1) goto L5;
        return;
    L5:
        if (r3 != (-1)) goto L9;
        this.mListFragment.onPickerResult(r4);
        return;
    }

    private void showInputMethod(View r2) {
        InputMethodManager r1 = (InputMethodManager) getSystemService("input_method");
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.showSoftInput(r2, 0) == true) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed to show soft input method.");
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_JoinContactActivity_com_obric_privacyhook_PrivacyHook_onCreate(JoinContactActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        JoinContactActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_JoinContactActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_JoinContactActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(JoinContactActivity r1) {
        com_android_contacts_activities_JoinContactActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_JoinContactActivity_com_obric_privacyhook_PrivacyHook_onStop(JoinContactActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        JoinContactActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_JoinContactActivity__onStop$___twin___();
    }
}
