package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static void a(Activity r10) {
        String r11 = Utils.i().c("KEY_LOCALE");
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if ("VALUE_FOLLOW_SYSTEM".equals(r11) == false) goto L9;
        Locale r12 = Resources.getSystem().getConfiguration().locale;
        c(Utils.c(), r12);
        c(r10, r12);
        return;
    L9:
        String[] r13 = r11.split("\\$");
        if (r13.length == 2) goto L13;
        Log.e("LanguageUtils", "The string of " + r11 + " is not in the correct format.");
        return;
    L13:
        Locale r14 = new Locale(r13[0], r13[1]);
        c(Utils.c(), r14);
        c(r10, r14);
    }

    public static boolean b(CharSequence r10, CharSequence r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10 == null) goto L23;
        if (r11 == null) goto L23;
        int r12 = r10.length();
        if (r12 != r11.length()) goto L23;
        if ((r10 instanceof String) == true) goto L13;
    L16:
        int r13 = 0;
    L17:
        if (r13 >= r12) goto L22;
        if (r10.charAt(r13) != r11.charAt(r13)) goto L20;
        r13 = r13 + 1;
        goto L17
    L20:
        return false;
    L22:
        return true;
    L13:
        if ((r11 instanceof String) == false) goto L16;
        return r10.equals(r11);
    L23:
        return false;
    }

    public static void c(Context r10, Locale r11) {
        Resources r12 = r10.getResources();
        Configuration r13 = r12.getConfiguration();
        Locale r14 = r13.locale;
        if (b(r14.getLanguage(), r11.getLanguage()) == true) goto L5;
    L7:
        DisplayMetrics r15 = r12.getDisplayMetrics();
        r13.setLocale(r11);
        r10.createConfigurationContext(r13);
        r12.updateConfiguration(r13, r15);
        return;
    L5:
        if (b(r14.getCountry(), r11.getCountry()) == false) goto L7;
    }
}
