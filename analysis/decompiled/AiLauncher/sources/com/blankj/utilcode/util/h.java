package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* loaded from: classes.dex */
public class h {
    public static void a(Activity activity) {
        String strC = r.l().c("KEY_LOCALE");
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        Locale localeB = "VALUE_FOLLOW_SYSTEM".equals(strC) ? b(Resources.getSystem().getConfiguration()) : e(strC);
        if (localeB == null) {
            return;
        }
        g(activity, localeB);
        g(p.a(), localeB);
    }

    public static Locale b(Configuration configuration) {
        return configuration.getLocales().get(0);
    }

    public static boolean c(String str) {
        int i10 = 0;
        for (char c10 : str.toCharArray()) {
            if (c10 == '$') {
                if (i10 >= 1) {
                    return false;
                }
                i10++;
            }
        }
        return i10 == 1;
    }

    public static void d(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }

    public static Locale e(String str) {
        Locale localeF = f(str);
        if (localeF == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            r.l().f("KEY_LOCALE");
        }
        return localeF;
    }

    public static Locale f(String str) {
        if (!c(str)) {
            return null;
        }
        try {
            int iIndexOf = str.indexOf("$");
            return new Locale(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void g(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        d(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
