package com.android.contacts;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.GlobalProxyLancet;
import com.android.contacts.activities.TransactionSafeActivity;
import com.android.contacts.preference.ContactsPreferences;
import com.android.contacts.test.InjectedServices;
import com.obric.privacy.PrivacyUtils;
import com.obric.utils.GlobalUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContactsActivity extends TransactionSafeActivity implements ContactSaveService.Listener {
    public static final String SAVE_COMPLETE = "com.android.contacts.SAVE_COMPLETE";
    private static final String TAG = "ContactsActivity";
    private int mBlacklistSoundId;
    private SoundPool mBlacklistSoundPool;
    private ContactsPreferences mContactsPrefs;
    private ContentResolver mContentResolver;
    protected int mDisplayOrder;
    private ContactsPreferences.ChangeListener mPreferencesChangeListener;
    private boolean mPreferencesChanged;
    protected int mSortOrder;

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_ContactsActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_ContactsActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_contacts_ContactsActivity_com_obric_privacyhook_PrivacyHook_onStop(this);
    }

    public ContactsActivity() {
        this.mPreferencesChanged = false;
        this.mDisplayOrder = -1;
        this.mSortOrder = -1;
        this.mPreferencesChangeListener = new AnonymousClass4(this);
    }

    static /* synthetic */ void access$000(ContactsActivity r0) {
        r0.initBlacklistSound();
    }

    static /* synthetic */ SoundPool access$100(ContactsActivity r0) {
        return r0.mBlacklistSoundPool;
    }

    static /* synthetic */ int access$200(ContactsActivity r0) {
        return r0.mBlacklistSoundId;
    }

    static /* synthetic */ boolean access$302(ContactsActivity r0, boolean r1) {
        r0.mPreferencesChanged = r1;
        return r1;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        if (this.mContentResolver != null) goto L11;
        InjectedServices r0 = ContactsApplication.getInjectedServices();
        if (r0 == null) goto L8;
        this.mContentResolver = r0.getContentResolver();
    L8:
        if (this.mContentResolver != null) goto L11;
        this.mContentResolver = super.getContentResolver();
    L11:
        return this.mContentResolver;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String r2, int r3) {
        InjectedServices r0 = ContactsApplication.getInjectedServices();
        if (r0 == null) goto L8;
        SharedPreferences r1 = r0.getSharedPreferences();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return super.getSharedPreferences(r2, r3);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r2) {
        Object r0 = super.getSystemService(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getApplicationContext().getSystemService(r2);
    }

    public void com_android_contacts_ContactsActivity__onCreate$___twin___(Bundle r2) {
        ContactSaveService.registerListener(this);
        super.onCreate(r2);
        new Handler().post(new AnonymousClass1(this));
        this.mContactsPrefs = new ContactsPreferences(this);
        loadPreferences();
        this.mContactsPrefs.registerChangeListener(this.mPreferencesChangeListener);
    }

    private boolean loadPreferences() {
        if (this.mDisplayOrder == this.mContactsPrefs.getDisplayOrder()) goto L5;
        this.mDisplayOrder = this.mContactsPrefs.getDisplayOrder();
        boolean r0 = true;
    L7:
        if (this.mSortOrder == this.mContactsPrefs.getSortOrder()) goto L10;
        this.mSortOrder = this.mContactsPrefs.getSortOrder();
        return true;
    L10:
        return r0;
    L5:
        r0 = false;
        goto L7
    }

    protected boolean isPreferencesChanged() {
        if (this.mPreferencesChanged == true) goto L5;
    L7:
        return false;
    L5:
        if (loadPreferences() == false) goto L7;
        return true;
    }

    public void com_android_contacts_ContactsActivity__onStop$___twin___() {
        super.onStop();
        Agent.getInstance().flush();
    }

    public void com_android_contacts_ContactsActivity__onDestroy$___twin___() {
        ContactsPreferences r0 = this.mContactsPrefs;
        if (r0 == null) goto L5;
        r0.unregisterChangeListener();
    L5:
        ContactSaveService.unregisterListener(this);
        super.onDestroy();
        destroyBlacklistSoundPool();
    }

    @Override // com.android.contacts.ContactSaveService.Listener
    public void onServiceCompleted(Intent r3) {
        if (r3 == null) goto L5;
        r3.putExtra(SAVE_COMPLETE, true);
        onNewIntent(r3);
        return;
    }

    public <T extends Fragment> T getFragment(int r3) {
        T r2 = (T) getFragmentManager().findFragmentById(r3);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("fragment 0x" + Integer.toHexString(r3) + " doesn't exist");
    }

    public <T extends View> T getView(int r3) {
        T r2 = (T) findViewById(r3);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("view 0x" + Integer.toHexString(r3) + " doesn't exist");
    }

    protected static void showFragment(FragmentTransaction r1, Fragment r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isHidden() == false) goto L8;
        r1.show(r2);
        return;
    }

    protected static void hideFragment(FragmentTransaction r1, Fragment r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isHidden() == true) goto L8;
        r1.hide(r2);
        return;
    }

    private void initBlacklistSound() {
        if (this.mBlacklistSoundPool != null) goto L6;
        SoundPool r0 = new SoundPool(10, 1, 5);
        this.mBlacklistSoundPool = r0;
        this.mBlacklistSoundId = r0.load(getApplicationContext(), R.raw.blacklist, 1);
        return;
    }

    public void playBlacklistSound(boolean r8) {
        SoundPool r0 = this.mBlacklistSoundPool;
        if (r0 == null) goto L9;
        int r9 = r0.play(this.mBlacklistSoundId, 1.0f, 1.0f, 0, 0, 1.0f);
        if (r9 != 0) goto L7;
        this.mBlacklistSoundPool.setOnLoadCompleteListener(new AnonymousClass2(this));
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "playBlacklistSound res = " + r9 + " ,id = " + this.mBlacklistSoundId);
        return;
    }

    private void destroyBlacklistSoundPool() {
        SoundPool r0 = this.mBlacklistSoundPool;
        if (r0 == null) goto L6;
        releaseSoundPoolInIOThread(r0);
        this.mBlacklistSoundPool = null;
        return;
    }

    private void releaseSoundPoolInIOThread(final SoundPool r3) {
        GlobalUtils.INSTANCE.execute(new AnonymousClass3(this, r3));
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_ContactsActivity_com_obric_privacyhook_PrivacyHook_onCreate(ContactsActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_ContactsActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_ContactsActivity_com_obric_privacyhook_PrivacyHook_onStop(ContactsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_ContactsActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_ContactsActivity_com_obric_privacyhook_PrivacyHook_onDestroy(ContactsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_ContactsActivity__onDestroy$___twin___();
    }
}
