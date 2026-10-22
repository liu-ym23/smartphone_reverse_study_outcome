package com.android.contacts.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.R;
import com.android.contacts.activities.ContactDetailActivity;
import com.android.contacts.activities.ContactSelectionActivity;
import com.android.contacts.model.AccountType;
import com.android.contacts.obricsync.SyncContractKt;
import java.io.File;
import java.util.List;
import obric.api.IntentSmt;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsIntentUtils {
    public static final int RECHARGE_ENTRANCE_CALLLOG = 2;
    public static final int RECHARGE_ENTRANCE_CONTACTLIST = 3;
    public static final int RECHARGE_ENTRANCE_DETAIL = 6;
    private static String TAG = "ContactsIntentUtils";

    static {
    }

    public ContactsIntentUtils() {
    }

    public static Intent getSendMessageIntent(CharSequence r2) {
        if (r2 != null) goto L4;
        String r3 = "";
    L5:
        Intent r0 = new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", r3, null));
        r0.putExtra(IntentSmt.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), new int[]{0, R.anim.slide_down_out});
        return r0;
    L4:
        r3 = r2.toString();
        goto L5
    }

    public static Intent getAddToContactIntent(CharSequence r2, String r3) {
        Intent r0 = new Intent(ContactSelectionActivity.ACTION_BYTEDANCE_INSERT_OR_EDIT);
        r0.putExtra("phone", r2.toString());
        if (r3 == null) goto L5;
        r0.putExtra("enter_from", r3);
    L5:
        return r0;
    }

    public static Intent getCropImageIntent(Uri r4) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getCropImageIntent: " + r4);
        Intent r0 = new Intent("com.android.camera.action.CROP");
        r0.setPackage(Constants.PACKAGE_NAME_GALLERY);
        r0.setDataAndType(r4, "image/*");
        r0.putExtra("crop", "true");
        r0.putExtra("aspectX", 1);
        r0.putExtra("aspectY", 1);
        r0.putExtra("outputX", Constants.BYTEDANCEOS_DISPLAY_PHOTO_DIM);
        r0.putExtra("outputY", Constants.BYTEDANCEOS_DISPLAY_PHOTO_DIM);
        r0.putExtra("scaleUpIfNeeded", true);
        r0.putExtra("return-data", true);
        r0.putExtra("noFaceDetection", true);
        r0.putExtra(IntentSmt.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), new int[]{0, R.anim.slide_down_out});
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getCropImageIntent: " + r0);
        return r0;
    }

    public static Intent getPhotoPickIntent() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getPhotoPickIntent");
        Intent r0 = new Intent("android.intent.action.PICK", null);
        r0.setType("image/*");
        r0.putExtra("crop", "true");
        r0.putExtra("aspectX", 1);
        r0.putExtra("aspectY", 1);
        r0.putExtra("outputX", Constants.BYTEDANCEOS_DISPLAY_PHOTO_DIM);
        r0.putExtra("outputY", Constants.BYTEDANCEOS_DISPLAY_PHOTO_DIM);
        r0.putExtra("scaleUpIfNeeded", true);
        r0.putExtra("return-data", true);
        r0.putExtra("noFaceDetection", true);
        r0.putExtra(IntentSmt.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), new int[]{0, R.anim.slide_down_out});
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getPhotoPickIntent intent:" + r0);
        return r0;
    }

    public static Intent getTakePickIntent(File r2) {
        Intent r0 = new Intent("android.media.action.IMAGE_CAPTURE");
        r0.putExtra("output", Uri.fromFile(r2));
        r0.setPackage(Constants.PACKAGE_NAME_CAMARA);
        return r0;
    }

    public static Intent getBytedanceCloudLoginIntent() {
        Intent r0 = new Intent();
        r0.setClassName(Constants.CLOUDSYNC_PACKAGE_NAME, "com.bytedanceos.accounts.AccountsActivity");
        r0.putExtra("bytedance_origin_app_tag", "register_login");
        return r0;
    }

    public static Intent getInvitableIntent(AccountType r2, Uri r3) {
        String r0 = r2.resPackageName;
        String r4 = r2.getInviteContactActivityClassName();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L11;
        Intent r1 = new Intent();
        r1.setClassName(r0, r4);
        r1.setAction("com.android.contacts.action.INVITE_CONTACT");
        r1.setData(r3);
        return r1;
    L11:
        return null;
    }

    public static Intent newDialNumberIntent(String r1) {
        return newDialNumberIntent(r1, false);
    }

    public static Intent newDialNumberIntent(String r3, boolean r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Uri r5 = Uri.fromParts(Constants.SCHEME_TEL, r3.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", ""), null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("Contacts", "call : " + r5.toSafeString() + ", isStranger : " + r4);
        Intent r0 = new Intent("android.intent.action.CALL_PRIVILEGED", r5);
        r0.putExtra("isStranger", r4);
        r0.setPackage(Constants.PHONE_PACKAGE_NAME);
        r0.addFlags(268435456);
        return r0;
    }

    public static Intent newDialVoltePhoneIntent(String r2) {
        Uri r3 = Uri.fromParts(Constants.SCHEME_TEL, r2.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", ""), null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("Contacts", "call : " + r3.toSafeString());
        Intent r0 = new Intent("android.intent.action.CALL_PRIVILEGED", r3);
        r0.putExtra(Constants.EXTRA_START_CALL_WITH_VIDEO_STATE, 3);
        r0.setPackage(Constants.PHONE_PACKAGE_NAME);
        return r0;
    }

    public static Intent launchContactDetailIntent(Context r1, Uri r2, boolean r3) {
        Intent r4 = new Intent("android.intent.action.VIEW");
        r4.setData(r2);
        r4.setPackage("com.android.contacts");
        r4.putExtra(ContactDetailActivity.EXTRA_LAUNCH_FROM_SELF, r3);
        return r4;
    }

    public static Intent launchContactDetailIntent(Context r0, Uri r1, boolean r2, String r3) {
        Intent r4 = launchContactDetailIntent(r0, r1, r2);
        if (r3 == null) goto L5;
        r4.putExtra("enter_from", r3);
    L5:
        return r4;
    }

    public static final boolean areIntentActionEqual(Intent r0, Intent r1) {
        if (r0 != r1) goto L5;
        return true;
    L5:
        if (r0 == null) goto L10;
        if (r1 != null) goto L9;
        return false;
    L9:
        return TextUtils.equals(r0.getAction(), r1.getAction());
    L10:
        return false;
    }

    public static Intent getSendGroupMessageIntent(String r2) {
        Intent r0 = new Intent("android.intent.action.VIEW");
        r0.putExtra(SyncContractKt.COLUMN_ADDRESS, r2);
        r0.setType("vnd.android-dir/mms-sms");
        r0.putExtra(IntentSmt.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), new int[]{0, R.anim.slide_down_out});
        return r0;
    }

    public static boolean canResolveIntent(Intent r2) {
        List<ResolveInfo> r3 = ContactsApplication.getInstance().getPackageManager().queryIntentActivities(r2, 0);
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }
}
