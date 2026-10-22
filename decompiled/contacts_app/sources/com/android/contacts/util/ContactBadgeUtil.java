package com.android.contacts.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class ContactBadgeUtil {
    private static final String TAG = "ContactBadgeUtil";
    private static Bitmap defaultBitmap_false_false;
    private static Bitmap defaultBitmap_false_true;
    private static Bitmap defaultBitmap_true_false;
    private static Bitmap defaultBitmap_true_true;

    static {
    }

    public ContactBadgeUtil() {
    }

    public static CharSequence getSocialDate(StreamItemEntry r8, Context r9) {
        CharSequence r0 = android.text.format.DateUtils.getRelativeTimeSpanString(Long.valueOf(r8.getTimestamp()).longValue(), System.currentTimeMillis(), 60000, 262144);
        String r1 = r8.getLabelRes();
        String r10 = r8.getResPackage();
        if (r1 != null) goto L5;
    L18:
        Object r11 = null;
    L20:
        if (r0 == null) goto L23;
        if (r11 == null) goto L23;
        return r9.getString(R.string.contact_status_update_attribution_with_date, new Object[]{r0, r11});
    L23:
        if (r0 != null) goto L26;
        if (r11 == null) goto L26;
        return r9.getString(R.string.contact_status_update_attribution, new Object[]{r11});
    L26:
        if (r0 == null) goto L29;
        return r0;
    L29:
        return null;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        Resources r3 = r9.getResources();
        String r5 = "android";
    L13:
        if (r3 == null) goto L18;
        int r6 = r3.getIdentifier(r1, "string", r5);
        if (r6 != 0) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Contact status update resource not found: " + r1 + " in " + r10);
        goto L18
    L17:
        r11 = r3.getString(r6);
        goto L20
    L7:
        PackageManager r4 = r9.getPackageManager();
        if (r4 != null) goto L30;
        r3 = null;
    L11:
        r5 = r10;
        goto L13
    L30:
        r3 = r4.getResourcesForApplication(r10);     // Catch: PackageManager.NameNotFoundException -> L12
    L12:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Contact status update resource package not found: " + r10);
        r5 = r10;
        r3 = null;
        goto L13
    }

    public static Bitmap loadDefaultAvatarPhoto(Context r1, boolean r2, boolean r3) {
        if (r2 == false) goto L10;
        if (r3 == false) goto L10;
        Bitmap r0 = defaultBitmap_true_true;
        if (r0 != null) goto L7;
    L8:
        defaultBitmap_true_true = BitmapFactory.decodeResource(r1.getResources(), ContactPhotoManager.getDefaultAvatarResId(r2, r3));
    L33:
        return defaultBitmap_true_true;
    L7:
        if (r0.isRecycled() == false) goto L33;
    L10:
        if (r2 == false) goto L18;
        if (r3 == true) goto L18;
        Bitmap r4 = defaultBitmap_true_false;
        if (r4 != null) goto L15;
    L16:
        defaultBitmap_true_false = BitmapFactory.decodeResource(r1.getResources(), ContactPhotoManager.getDefaultAvatarResId(r2, r3));
    L34:
        return defaultBitmap_true_false;
    L15:
        if (r4.isRecycled() == false) goto L34;
    L18:
        if (r2 == true) goto L26;
        if (r3 == false) goto L26;
        Bitmap r5 = defaultBitmap_false_true;
        if (r5 != null) goto L23;
    L24:
        defaultBitmap_false_true = BitmapFactory.decodeResource(r1.getResources(), ContactPhotoManager.getDefaultAvatarResId(r2, r3));
    L35:
        return defaultBitmap_false_true;
    L23:
        if (r5.isRecycled() == false) goto L35;
    L26:
        Bitmap r6 = defaultBitmap_false_false;
        if (r6 != null) goto L29;
    L30:
        defaultBitmap_false_false = BitmapFactory.decodeResource(r1.getResources(), ContactPhotoManager.getDefaultAvatarResId(r2, r3));
    L32:
        return defaultBitmap_false_false;
    L29:
        if (r6.isRecycled() == false) goto L32;
        goto L30
    }
}
