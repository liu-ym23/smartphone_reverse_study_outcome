package com.android.contacts.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import com.GlobalProxyLancet;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class OreoApiUtils {
    private static final String TAG = "OreoApiUtils";

    public OreoApiUtils() {
    }

    public static void sendDialerSpecialCode(Context r1, String r2) {
        ((TelephonyManager) r1.getSystemService(TelephonyManager.class)).sendDialerSpecialCode(r2);
    }

    public static boolean isDefaultDialer(Context r2) {
        TelecomManager r0 = (TelecomManager) r2.getSystemService("telecom");
        boolean r3 = TextUtils.equals(r2.getPackageName(), r0.getDefaultDialerPackage());
        if (r3 == true) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "System Dialer is not currently set to be default dialer");
    L5:
        return r3;
    }

    public static void createContactShortcut(Context r6, Intent r7) {
        ShortcutManager r0 = (ShortcutManager) r6.getSystemService(ShortcutManager.class);
        Bitmap r1 = (Bitmap) r7.getExtra("android.intent.extra.shortcut.ICON");
        Intent r2 = (Intent) r7.getExtra("android.intent.extra.shortcut.INTENT");
        String r3 = r2.getData().toString();
        if (r7.getExtra("android.intent.extra.shortcut.NAME") != null) goto L5;
        String r8 = r6.getResources().getString(R.string.unknown);
    L6:
        r0.requestPinShortcut(new ShortcutInfo.Builder(r6, r3).setIntent(r2).setIcon(Icon.createWithBitmap(r1)).setShortLabel(r8).build(), null);
        return;
    L5:
        r8 = r7.getExtra("android.intent.extra.shortcut.NAME").toString();
        goto L6
    }

    public static void setViewAccessbilityDelegateForTouch(View r1) {
        r1.setAccessibilityDelegate(new AnonymousClass1());
    }
}
