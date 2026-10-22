package com.android.contacts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.GlobalProxyLancet;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.calllog.CallLogAdapter;
import com.android.contacts.calllog.NewCallLogFragment;
import com.android.contacts.list.BottomDeleteLayoutListener;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.IntentUtils;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.oui.button.OButtonFloating;
import com.obric.privacy.PrivacyUtils;
import com.obric.utils.views.ObricBottomDeleteBarView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class ContactCalllogsActivity extends ContactsActivity {
    public static final String ACTION_VIEW = "com.android.actavites.ContactCalllogs.actionview";
    public static final String EXTRA_CONTACT_HAS_MORE_NUMBERS = "contactHasMoreNumbers";
    public static final String EXTRA_HAS_CALL_LOG = "hasCallLog";
    public static final String SELECTION_KEY = "lookupuri";
    public static final String SELECTION_RESULT = "reslut";
    private static final String TAG = "ContactCalllogsActivity";
    private ObricBottomDeleteBarView mBottomDeleteBar;
    private OButtonFloating mBottomDeleteBarBtn;
    private BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private NewCallLogFragment mCallLogFragment;
    private ContactFragmentsCallback mFragmentsCallback;
    private int mHourFormatFlag;
    private View mVeilView;

    public void com_android_contacts_activities_ContactCalllogsActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_android_contacts_activities_ContactCalllogsActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_ContactCalllogsActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_activities_ContactCalllogsActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_contacts_activities_ContactCalllogsActivity_com_obric_privacyhook_PrivacyHook_onStart(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_ContactCalllogsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ContactCalllogsActivity() {
        this.mFragmentsCallback = new ContactFragmentsCallback(this);
        this.mBottomDeleteLayoutListener = new AnonymousClass1(this);
        this.mHourFormatFlag = 0;
    }

    static /* synthetic */ ObricBottomDeleteBarView access$000(ContactCalllogsActivity r0) {
        return r0.mBottomDeleteBar;
    }

    static /* synthetic */ OButtonFloating access$100(ContactCalllogsActivity r0) {
        return r0.mBottomDeleteBarBtn;
    }

    static /* synthetic */ void access$200(ContactCalllogsActivity r0) {
        r0.clickBottomDeleteBar();
    }

    public void com_android_contacts_activities_ContactCalllogsActivity__onDestroy$___twin___() {
        super.onDestroy();
        NewCallLogFragment r0 = this.mCallLogFragment;
        if (r0 == null) goto L6;
        r0.stopRequestProcessing();
        return;
    }

    public void com_android_contacts_activities_ContactCalllogsActivity__onCreate$___twin___(Bundle r6) {
        TransitionAnimHelper.overrideEnterAnim(this, TransitionAnimStyle.Standard);
        super.onCreate(r6);
        Bundle r7 = getIntent().getExtras();
        if (r7 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "no extras in intent");
        finish();
        return;
    L6:
        setContentView(R.layout.contact_calllogs_activity);
        UiUtils.setWindowColorStatusBar(this);
        getWindow().setBackgroundDrawable(null);
        View r0 = findViewById(R.id.veil);
        this.mVeilView = r0;
        this.mFragmentsCallback.setVeilView(r0);
        ObricBottomDeleteBarView r1 = (ObricBottomDeleteBarView) findViewById(R.id.bottom_delete_bar);
        this.mBottomDeleteBar = r1;
        OButtonFloating r2 = r1.getDeleteBtn();
        this.mBottomDeleteBarBtn = r2;
        r2.setEnabled(false);
        this.mBottomDeleteBarBtn.setOnClickListener(new AnonymousClass2(this));
        ArrayList<String> r3 = IntentUtils.getStringArrayList(r7, SELECTION_RESULT);
        boolean r4 = r7.getBoolean(EXTRA_HAS_CALL_LOG, true);
        boolean r5 = r7.getBoolean(EXTRA_CONTACT_HAS_MORE_NUMBERS, false);
        NewCallLogFragment r8 = new NewCallLogFragment(r7.getString(SELECTION_KEY), r3, r4, r5);
        this.mCallLogFragment = r8;
        r8.setFragmentsCallback(this.mFragmentsCallback);
        this.mCallLogFragment.setBottomDeleteLayoutListener(this.mBottomDeleteLayoutListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.calllog_frame, this.mCallLogFragment).commit();
    }

    private void clickBottomDeleteBar() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "clickBottomDeleteBar#click");
        NewCallLogFragment r0 = this.mCallLogFragment;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isVisible() == false) goto L9;
        this.mCallLogFragment.showDeleteCallLogDialog();
        return;
    }

    public void viewRecords(View r2) {
        Intent r0 = ContactsUtils.getViewRecordIntent((String) r2.getTag());
        if (r0 != null) goto L5;
        return;
    L5:
        r2.getContext().startActivity(r0);
        AnimationUtil.switchActivityAnimation(this, 1);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment r2) {
        super.onAttachFragment(r2);
        if ((r2 instanceof NewCallLogFragment) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "onAttachFragment not a CallLogFragment");
        return;
    L6:
        NewCallLogFragment r3 = (NewCallLogFragment) r2;
        this.mCallLogFragment = r3;
        r3.onVisibilityChanged(true);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mCallLogFragment.backToTopState() == true) goto L5;
        return;
    L5:
        super.onBackPressed();
    }

    public void com_android_contacts_activities_ContactCalllogsActivity__onStart$___twin___() {
        super.onStart();
        if (DateFormat.is24HourFormat(this) == false) goto L5;
        int r0 = 1;
    L7:
        if (this.mHourFormatFlag == r0) goto L12;
        this.mHourFormatFlag = r0;
        ContactsUtils.updateDateAndTimeFormat();
        CallLogAdapter r2 = this.mCallLogFragment.getCallLogAdapter();
        if (r2 == null) goto L13;
        r2.notifyDataSetChanged();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = 2;
        goto L7
    }

    public void com_android_contacts_activities_ContactCalllogsActivity__finish$___twin___() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_ContactCalllogsActivity_com_obric_privacyhook_PrivacyHook_onCreate(ContactCalllogsActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactCalllogsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_ContactCalllogsActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_ContactCalllogsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ContactCalllogsActivity r1) {
        com_android_contacts_activities_ContactCalllogsActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStart")
    public static void com_android_contacts_activities_ContactCalllogsActivity_com_obric_privacyhook_PrivacyHook_onStart(ContactCalllogsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactCalllogsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r2.com_android_contacts_activities_ContactCalllogsActivity__onStart$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_ContactCalllogsActivity_com_obric_privacyhook_PrivacyHook_onStop(ContactCalllogsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactCalllogsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_ContactCalllogsActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_activities_ContactCalllogsActivity_com_obric_privacyhook_PrivacyHook_onDestroy(ContactCalllogsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactCalllogsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_activities_ContactCalllogsActivity__onDestroy$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_activities_ContactCalllogsActivity_com_obric_privacyhook_PrivacyHook_finish(ContactCalllogsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactCalllogsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_activities_ContactCalllogsActivity__finish$___twin___();
    }
}
