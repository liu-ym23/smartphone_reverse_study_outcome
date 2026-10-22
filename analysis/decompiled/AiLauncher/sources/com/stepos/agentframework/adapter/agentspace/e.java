package com.stepos.agentframework.adapter.agentspace;

import La.H;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/agentspace/e;", "", "<init>", "()V", "", "c", "()Ljava/lang/String;", "f", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroid/content/Context;", "context", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Ljava/lang/String;", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)J", Const.INTENT_KEY_UMID, "Landroid/content/pm/PackageInfo;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)Landroid/content/pm/PackageInfo;", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class e {
    public static final e INSTANCE = new e();

    public final long a(Context context) {
        p.i(context, "context");
        try {
            return g(context).getLongVersionCode();
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 1L;
        }
    }

    public final String b(Context context) {
        p.i(context, "context");
        try {
            String str = g(context).versionName;
            String str2 = null;
            String string = str != null ? H.D1(str).toString() : null;
            if (string != null) {
                if (string.length() > 0) {
                    str2 = string;
                }
            }
            return str2 == null ? "1.0.0" : str2;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "1.0.0";
        }
    }

    public final String c() {
        String str = Build.BRAND;
        String str2 = null;
        String string = str != null ? H.D1(str).toString() : null;
        if (string != null && string.length() > 0) {
            str2 = string;
        }
        return str2 == null ? "unknown" : str2;
    }

    @SuppressLint({"HardwareIds"})
    public final String d(Context context) {
        p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        try {
            String strB = K7.c.b(applicationContext);
            String string = strB != null ? H.D1(strB).toString() : null;
            if (string == null || string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                return string;
            }
            String string2 = Settings.Secure.getString(applicationContext.getContentResolver(), "android_id");
            String string3 = string2 != null ? H.D1(string2).toString() : null;
            return string3 == null ? "" : string3;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public final String e() {
        Locale locale = LocaleList.getDefault().get(0);
        p.f(locale);
        String language = locale.getLanguage();
        String str = null;
        String string = language != null ? H.D1(language).toString() : null;
        if (string != null && string.length() > 0) {
            str = string;
        }
        return str == null ? "zh" : str;
    }

    public final String f() {
        String str = Build.MODEL;
        String str2 = null;
        String string = str != null ? H.D1(str).toString() : null;
        if (string != null && string.length() > 0) {
            str2 = string;
        }
        return str2 == null ? "unknown" : str2;
    }

    public final PackageInfo g(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        p.h(packageInfo, "getPackageInfo(...)");
        return packageInfo;
    }

    public final String h() {
        String str = Build.VERSION.RELEASE;
        String str2 = null;
        String string = str != null ? H.D1(str).toString() : null;
        if (string != null && string.length() > 0) {
            str2 = string;
        }
        return str2 == null ? "unknown" : str2;
    }
}
