package r3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1666g;
import com.stepos.statsapp.v3.utils.CommonUtils;
import java.util.Locale;

/* renamed from: r3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5209c {

    /* renamed from: a, reason: collision with root package name */
    public static final C1666g f38761a = new C1666g(CommonUtils.TAG, "");

    public static String a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e10) {
            f38761a.c(CommonUtils.TAG, "Exception thrown when trying to get app version ".concat(e10.toString()));
            return "";
        }
    }

    public static String b(Locale locale) {
        if (s2.j.d()) {
            return locale.toLanguageTag();
        }
        StringBuilder sb2 = new StringBuilder(locale.getLanguage());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb2.append(O6.l.DATE_SEPARATOR);
            sb2.append(locale.getCountry());
        }
        if (!TextUtils.isEmpty(locale.getVariant())) {
            sb2.append(O6.l.DATE_SEPARATOR);
            sb2.append(locale.getVariant());
        }
        return sb2.toString();
    }
}
