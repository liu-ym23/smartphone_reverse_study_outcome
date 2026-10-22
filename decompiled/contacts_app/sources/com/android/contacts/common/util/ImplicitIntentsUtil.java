package com.android.contacts.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ImplicitIntentsUtil {
    public ImplicitIntentsUtil() {
    }

    public static void startActivityInAppIfPossible(Context r1, Intent r2) {
        Intent r0 = getIntentInAppIfExists(r1, r2);
        if (r0 == null) goto L5;
        r1.startActivity(r0);
        return;
    L5:
        r1.startActivity(r2);
    }

    public static void startActivityInApp(Context r1, Intent r2) {
        r2.setPackage(r1.getPackageName());
        r1.startActivity(r2);
    }

    public static void startActivityOutsideApp(Context r2, Intent r3) {
        if (Build.TYPE.equals("eng") == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L15:
        r2.startActivity(r3);
        return;
    L11:
        if (getIntentInAppIfExists(r2, r3) == null) goto L15;
        throw new AssertionError("startActivityOutsideApp() was called for an intent that can be handled inside the app");
    L5:
        if (Build.TYPE.equals("userdebug") == true) goto L8;
        r0 = false;
        goto L9
    }

    public static Intent composeQuickContactIntent(Uri r2, int r3) {
        Intent r0 = new Intent("android.provider.action.QUICK_CONTACT");
        r0.setData(r2);
        r0.putExtra("android.provider.extra.MODE", r3);
        r0.addFlags(67108864);
        return r0;
    }

    public static Intent getIntentForAddingAccount() {
        Intent r0 = new Intent("android.settings.ADD_ACCOUNT_SETTINGS");
        r0.setFlags(524288);
        r0.putExtra("authorities", new String[]{"com.android.contacts"});
        return r0;
    }

    private static Intent getIntentInAppIfExists(Context r4, Intent r5) {
        Intent r1 = new Intent(r5);     // Catch: Exception -> L14
        r1.setPackage(r4.getPackageName());     // Catch: Exception -> L14
        List<ResolveInfo> r6 = r4.getPackageManager().queryIntentActivities(r1, 65536);     // Catch: Exception -> L14
        if (r6 == null) goto L13;
        if (r6.size() == 0) goto L13;
        if (r6.get(0).activityInfo != null) goto L10;
    L12:
        return r1;
    L10:
        if (TextUtils.isEmpty(r6.get(0).activityInfo.name) == true) goto L12;
        r1.setClassName(r4.getPackageName(), r6.get(0).activityInfo.name);     // Catch: Exception -> L14
    L13:
        return null;
    }
}
