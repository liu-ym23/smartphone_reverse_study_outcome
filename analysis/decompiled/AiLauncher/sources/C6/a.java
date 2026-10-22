package C6;

import La.D;
import La.H;
import O6.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m6.C4904a;
import p6.InterfaceC5058b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"LC6/a;", "", "<init>", "()V", "", "c", "()Ljava/lang/String;", "f", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroid/content/Context;", "context", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Ljava/lang/String;", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)J", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroid/content/pm/PackageInfo;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)Landroid/content/pm/PackageInfo;", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();

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
            String string = Settings.Secure.getString(applicationContext.getContentResolver(), "android_id");
            String str = null;
            String string2 = string != null ? H.D1(string).toString() : null;
            if (string2 != null && string2.length() > 0 && !p.d(string2, "9774d56d682e549c")) {
                str = string2;
            }
            if (str != null) {
                return str;
            }
            p.f(applicationContext);
            return h(applicationContext);
        } catch (Exception e10) {
            e10.printStackTrace();
            p.f(applicationContext);
            return this.h(applicationContext);
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

    public final String h(Context context) {
        C4904a c4904a = C4904a.INSTANCE;
        String strA = InterfaceC5058b.a(c4904a.b(context), "KEY_UUID_TOKEN", null, 2, null);
        if (strA.length() != 0) {
            return strA;
        }
        String string = UUID.randomUUID().toString();
        p.h(string, "toString(...)");
        String strT = D.T(string, l.DATE_SEPARATOR, "", false, 4, null);
        c4904a.b(context).putString("KEY_UUID_TOKEN", strT);
        return strT;
    }

    public final String i() {
        String str = Build.VERSION.RELEASE;
        String str2 = null;
        String string = str != null ? H.D1(str).toString() : null;
        if (string != null && string.length() > 0) {
            str2 = string;
        }
        return str2 == null ? "unknown" : str2;
    }
}
