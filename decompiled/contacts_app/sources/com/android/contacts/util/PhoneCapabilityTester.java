package com.android.contacts.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import com.android.contacts.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PhoneCapabilityTester {
    private static boolean sIsInitialized;
    private static boolean sIsPhone;
    private static boolean sIsSipPhone;

    public PhoneCapabilityTester() {
    }

    public static boolean isIntentRegistered(Context r1, Intent r2) {
        List<ResolveInfo> r3 = r1.getPackageManager().queryIntentActivities(r2, 65536);
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isPhone(Context r1) {
        if (sIsInitialized == true) goto L6;
        initialize(r1);
    L6:
        return sIsPhone;
    }

    private static void initialize(Context r1) {
        boolean r2 = new TelephonyManager(r1).isVoiceCapable();
        sIsPhone = r2;
        sIsSipPhone = r2;
        sIsInitialized = true;
    }

    public static boolean isSipPhone(Context r1) {
        if (sIsInitialized == true) goto L6;
        initialize(r1);
    L6:
        return sIsSipPhone;
    }

    public static boolean isSmsIntentRegistered(Context r4) {
        return isIntentRegistered(r4, new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", "", null)));
    }

    public static ComponentName getSmsComponent(Context r5) {
        String r0 = Telephony.Sms.getDefaultSmsPackage(r5);
        if (r0 == null) goto L11;
        Iterator<ResolveInfo> r6 = r5.getPackageManager().queryIntentActivities(new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", "", null)), 0).iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        ResolveInfo r2 = r6.next();
        if (r0.equals(r2.activityInfo.packageName) == false) goto L6;
        return new ComponentName(r0, r2.activityInfo.name);
    L11:
        return null;
    }

    public static boolean isCameraIntentRegistered(Context r2) {
        return isIntentRegistered(r2, new Intent("android.media.action.IMAGE_CAPTURE"));
    }

    public static boolean isUsingTwoPanes(Context r1) {
        return r1.getResources().getBoolean(R.bool.config_use_two_panes);
    }
}
