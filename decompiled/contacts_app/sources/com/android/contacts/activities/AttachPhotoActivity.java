package com.android.contacts.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.GlobalProxyLancet;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityDeltaList;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.util.ContactPhotoUtils;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class AttachPhotoActivity extends ContactsActivity {
    private static final String KEY_CONTACT_URI = "contact_uri";
    private static final String KEY_CROPPED_PHOTO_URI = "cropped_photo_uri";
    private static final String KEY_TEMP_PHOTO_URI = "temp_photo_uri";
    private static final int REQUEST_CROP_PHOTO = 2;
    private static final int REQUEST_PICK_CONTACT = 1;
    private static final String TAG = "AttachPhotoActivity";
    private static int mPhotoDim = 520;
    private Uri mContactUri;
    private Uri mCroppedPhotoUri;
    private Uri mTempPhotoUri;

    private interface Listener {
        void onContactLoaded(ContactLoader.Result r1);
    }

    static {
    }

    public void com_android_contacts_activities_AttachPhotoActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_contacts_activities_AttachPhotoActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_AttachPhotoActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public AttachPhotoActivity() {
    }

    static /* synthetic */ void access$000(AttachPhotoActivity r0, ContactLoader.Result r1) {
        r0.saveContact(r1);
    }

    public void com_android_contacts_activities_AttachPhotoActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        UiUtils.setWindowColorStatusBar(this);
        if (r2 == null) goto L9;
        String r0 = r2.getString(KEY_CONTACT_URI);
        if (r0 != null) goto L7;
        Uri r1 = null;
    L8:
        this.mContactUri = r1;
        this.mTempPhotoUri = Uri.parse(r2.getString(KEY_TEMP_PHOTO_URI));
        this.mCroppedPhotoUri = Uri.parse(r2.getString(KEY_CROPPED_PHOTO_URI));
        return;
    L7:
        r1 = Uri.parse(r0);
        goto L8
    L9:
        this.mTempPhotoUri = ContactPhotoUtils.generateTempImageUri(this);
        this.mCroppedPhotoUri = ContactPhotoUtils.generateTempCroppedImageUri(this);
        Intent r3 = new Intent("android.intent.action.PICK");
        r3.setType("vnd.android.cursor.dir/contact");
        r3.setFlags(3);
        startActivityForResult(r3, 1);
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        Uri r0 = this.mContactUri;
        if (r0 == null) goto L5;
        r3.putString(KEY_CONTACT_URI, r0.toString());
    L5:
        Uri r1 = this.mTempPhotoUri;
        if (r1 == null) goto L8;
        r3.putString(KEY_TEMP_PHOTO_URI, r1.toString());
    L8:
        Uri r2 = this.mCroppedPhotoUri;
        if (r2 == null) goto L12;
        r3.putString(KEY_CROPPED_PHOTO_URI, r2.toString());
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r6, int r7, Intent r8) {
        super.onActivityResult(r6, r7, r8);
        if (r6 != 1) goto L22;
        if (r7 == (-1)) goto L7;
        finish();
        return;
    L7:
        Intent r9 = getIntent();
        Uri r10 = r9.getData();
        if (r10 != null) goto L12;
        finish();
        return;
    L12:
        if (checkUriPermission(r10, Process.myPid(), Process.myUid(), 3) == (-1)) goto L14;
    L18:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onActivityResult");
        Intent r0 = new Intent("com.android.camera.action.CROP", r10);
        if (r9.getStringExtra("mimeType") == null) goto L21;
        r0.setDataAndType(r10, r9.getStringExtra("mimeType"));
    L21:
        ContactPhotoUtils.addPhotoPickerExtras(r0, this.mCroppedPhotoUri);
        ContactPhotoUtils.addCropExtras(r0, mPhotoDim);
        startActivityForResult(r0, 2);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onActivityResult: " + r0);
        this.mContactUri = r8.getData();
        return;
    L14:
        if (ContactPhotoUtils.savePhotoFromUriToUri(this, r10, this.mTempPhotoUri, false) == true) goto L17;
        finish();
        return;
    L17:
        r10 = this.mTempPhotoUri;
        goto L18
    L22:
        if (r6 != 2) goto L30;
        getContentResolver().delete(this.mTempPhotoUri, null, null);
        if (r7 == (-1)) goto L27;
        finish();
        return;
    L27:
        loadContact(this.mContactUri, new AnonymousClass1(this));
        return;
    }

    private void loadContact(Uri r2, final Listener r3) {
        ContactLoader r0 = new ContactLoader(this, r2);
        r0.registerListener(0, new AnonymousClass2(this, r3));
        r0.startLoading();
    }

    private void saveContact(ContactLoader.Result r12) {
        EntityDeltaList r2 = EntityDeltaList.fromIterator(r12.getEntities().iterator());
        EntityDelta r0 = r2.getFirstWritableRawContact(this);
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "no writable raw-contact found");
        return;
    L6:
        int r3 = ContactsUtils.getThumbnailSize(this);
        byte[] r4 = ContactPhotoUtils.compressBitmap(Bitmap.createScaledBitmap(ContactPhotoUtils.getBitmapFromUri(this, this.mCroppedPhotoUri), r3, r3, false));
        if (r4 != null) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "could not create scaled and compressed Bitmap");
        return;
    L12:
        EntityDelta.ValuesDelta r5 = EntityModifier.ensureKindExists(r0, r0.getRawContactAccountType(this), "vnd.android.cursor.item/photo");
        if (r5 != null) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "cannot attach photo to this account type");
        return;
    L16:
        r5.setPhoto(r4);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "all prerequisites met, about to save photo to contact");
        startService(ContactSaveService.createSaveContactIntent(this, r2, "", 0, r12.isUserProfile(), null, null, r0.getRawContactId().longValue(), this.mCroppedPhotoUri));
        finish();
        return;
    L18:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Could not find bitmap");
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_AttachPhotoActivity_com_obric_privacyhook_PrivacyHook_onCreate(AttachPhotoActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AttachPhotoActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_AttachPhotoActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_AttachPhotoActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AttachPhotoActivity r1) {
        com_android_contacts_activities_AttachPhotoActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_AttachPhotoActivity_com_obric_privacyhook_PrivacyHook_onStop(AttachPhotoActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AttachPhotoActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_AttachPhotoActivity__onStop$___twin___();
    }
}
