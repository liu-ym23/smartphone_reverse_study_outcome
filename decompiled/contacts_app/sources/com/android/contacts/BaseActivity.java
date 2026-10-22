package com.android.contacts;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.GlobalProxyLancet;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.UiUtils;
import com.obric.appintents.IntentPrivacyHelper;
import com.obric.immersive.Immersive;
import com.obric.immersive.ImmersiveCallback;
import com.obric.legacy.DestroyObservable;
import com.obric.oui.toast.OToast;
import com.obric.privacy.PrivacyUtils;
import com.obric.privacyhook.LifeHookActivity;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.api.IntentSmt;

/* JADX INFO: loaded from: classes.dex */
public class BaseActivity extends LifeHookActivity implements ImmersiveCallback {
    private static final int ANIMATION_LENGTH_LIMIT = 2;
    private static final int EMERGENCY_CONTACT_LOADER_ID = 7;
    public static final String EXTRA_ACTIVITY_NOT_FOUND_TEXT = "extra_activity_not_found_text";
    private static final String TAG = "BaseActivity";
    private DestroyObservable mDestroyObservable;
    private Immersive mImmersive;
    private boolean mPrivacyOk;

    /* JADX INFO: renamed from: com.android.contacts.BaseActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class EmergencyContactUpdateCallbacks implements LoaderManager.LoaderCallbacks<Cursor> {
        final /* synthetic */ BaseActivity this$0;

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<Cursor> r1) {
        }

        private EmergencyContactUpdateCallbacks(BaseActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EmergencyContactUpdateCallbacks(BaseActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
            onLoadFinished2(r1, r2);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader<Cursor> onCreateLoader(int r8, Bundle r9) {
            Uri r2 = ContactsUtils.getEmergencyContactPhoneUri(this.this$0.getBaseContext());
            return new CursorLoader(this.this$0.getBaseContext(), r2, new String[]{"display_name", "data1"}, null, null, null);
        }

        /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
        public void onLoadFinished2(Loader<Cursor> r2, Cursor r3) {
            if (r3 != null) goto L4;
        L6:
            ContactsUtils.setEmergencyContactInfos(this.this$0.getBaseContext(), null, null);
            return;
        L4:
            if (r3.moveToFirst() == false) goto L6;
            String r4 = r3.getString(0);
            String r5 = r3.getString(1);
            ContactsUtils.setEmergencyContactInfos(this.this$0.getBaseContext(), r4, r5);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_contacts_BaseActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_BaseActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_BaseActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    public BaseActivity() {
        this.mPrivacyOk = PrivacyUtils.hasBasePermissionAndAgree(ContactsApplication.getInstance());
        this.mImmersive = new Immersive(this);
        this.mDestroyObservable = new DestroyObservable(this);
    }

    @Override // com.obric.privacyhook.LifeHookActivity
    public boolean isPrivacyOk() {
        return PrivacyUtils.hasBasePermissionAndAgree(ContactsApplication.getInstance());
    }

    public void com_android_contacts_BaseActivity__onResume$___twin___() {
        super.onResume();
        if (ContactsUtils.getEmergencyContactPhoneUri(this) == null) goto L5;
        LoaderManager.getInstance(this).restartLoader(7, null, new EmergencyContactUpdateCallbacks(this, null));
        return;
    L5:
        LoaderManager.getInstance(this).destroyLoader(7);
    }

    @Override // com.obric.privacyhook.LifeHookActivity
    public void onCreateWhenPrivacyNotOk(Bundle r3) {
        super.onCreateWhenPrivacyNotOk(r3);
        UiUtils.setWindowColorStatusBar(this);
        Intent r4 = getIntent();
        PrivacyUtils.grantUriPermission(this, r4);
        PrivacyUtils.updateActionResult(r4.getBooleanExtra(IntentPrivacyHelper.INTENT_ACTION_OPEN_CONTACTS_MAIN_PAGE_EXTRA, false));
        final Context r0 = getApplicationContext();
        final Intent r1 = new Intent(r4);
        r1.addFlags(268435456);
        PrivacyUtils.startBasePermissionApplyIfNeeded(this, new BaseActivity$$ExternalSyntheticLambda0(r0, r1));
        finish();
    }

    static /* synthetic */ void lambda$onCreateWhenPrivacyNotOk$0(Context r2, Intent r3) {
        PrivacyUtils.startPrivacyFlowHomeWithoutAnimation(r2, r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        String r4 = r3.getAction();
        PrivacyUtils.startDialtactsActivity(r2);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "onCreateWhenPrivacyNotOk: action = " + r4, th);
    }

    @Override // com.obric.privacyhook.LifeHookActivity
    public void onNewIntentWhenPrivacyNotOk(Intent r1) {
        super.onNewIntentWhenPrivacyNotOk(r1);
    }

    public void com_android_contacts_BaseActivity__finish$___twin___() {
        super.finish();
        if (getIntent() == null) goto L11;
        int[] r0 = getIntent().getIntArrayExtra(IntentSmt.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID());
        if (r0 != null) goto L7;
    L9:
        AnimationUtil.switchActivityAnimation(this, 3);
        return;
    L7:
        if (r0.length != 2) goto L9;
        overridePendingTransition(r0[0], r0[1]);
        return;
    }

    public void com_android_contacts_BaseActivity__onDestroy$___twin___() {
        super.onDestroy();
        this.mDestroyObservable.onDestroy();
    }

    public DestroyObservable getDestroyObservable() {
        return this.mDestroyObservable;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r4, int r5, Bundle r6) {
        if (shouldInterceptActivity(r4) == false) goto L23;
        return;
    L23:
        super.startActivityForResult(r4, r5, r6);     // Catch: Throwable -> L7
        return;
    L7:
        e = move-exception;
        if ((e instanceof ActivityNotFoundException) == false) goto L16;
        if (r4 == null) goto L16;
        if ("com.intsig.camcard.ACTION_SEARCH_COMPANY".equals(r4.getAction()) == false) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "rethrow exception for camcard.");
        throw ((ActivityNotFoundException) e);
    L16:
        String r1 = getString(R.string.quickcontact_missing_app);
        if (r4 == null) goto L21;
        r1 = r4.getStringExtra(EXTRA_ACTIVITY_NOT_FOUND_TEXT);
        if (TextUtils.isEmpty(r1) == false) goto L21;
        r1 = getString(R.string.quickcontact_missing_app);
    L21:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "No activity found for intent: " + r4, e);
        OToast.Companion.show(this, r1, 80);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(Fragment r2, Intent r3, int r4, Bundle r5) {
        if (shouldInterceptActivity(r3) == false) goto L9;
        return;
    L9:
        super.startActivityFromFragment(r2, r3, r4, r5);     // Catch: ActivityNotFoundException -> L7
        return;
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "No activity found for intent: " + r3);
        Toast.makeText(this, R.string.quickcontact_missing_app, 0).show();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender r2, int r3, Intent r4, int r5, int r6, int r7, Bundle r8) throws IntentSender.SendIntentException {
        if (shouldInterceptActivity(r4) == false) goto L5;
        return;
    L5:
        super.startIntentSenderForResult(r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r4, Bundle r5) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (shouldInterceptActivity(r4[r1]) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return;
    L8:
        super.startActivities(r4, r5);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent r2, int r3, Bundle r4) {
        if (shouldInterceptActivity(r2) == false) goto L7;
        return false;
    L7:
        return super.startActivityIfNeeded(r2, r3, r4);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent r2, Bundle r3) {
        if (shouldInterceptActivity(r2) == false) goto L7;
        return false;
    L7:
        return super.startNextMatchingActivity(r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(Fragment r2, Intent r3, int r4) {
        if (shouldInterceptActivity(r3) == false) goto L5;
        return;
    L5:
        super.startActivityFromFragment(r2, r3, r4);
    }

    protected boolean shouldInterceptActivity(Intent r3) {
        if (ContactsUtils.isFeaturePhoneMode() == false) goto L5;
        boolean r2 = !ContactsUtils.inPowerSaveWhiteList(this, r3);
    L6:
        if (r2 == false) goto L8;
        ContactsApplication.showToast(ContactsUtils.getFeaturePhoneModeHintId(), 1);
    L8:
        return r2;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.obric.immersive.ImmersiveCallback
    public Immersive getImmersive() {
        return this.mImmersive;
    }

    @Override // com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
        ImmersiveCallback.DefaultImpls.onStatusBarHeightChanged(this, r1);
    }

    @Override // com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
        ImmersiveCallback.DefaultImpls.onNavigationBarHeightChanged(this, r1);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_BaseActivity_com_obric_privacyhook_PrivacyHook_onResume(BaseActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        BaseActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_BaseActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_BaseActivity_com_obric_privacyhook_PrivacyHook_onDestroy(BaseActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        BaseActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_BaseActivity__onDestroy$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_BaseActivity_com_obric_privacyhook_PrivacyHook_finish(BaseActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        BaseActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_BaseActivity__finish$___twin___();
    }
}
