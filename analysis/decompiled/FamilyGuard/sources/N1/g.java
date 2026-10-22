package N1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.libpag.BuildConfig;
import org.libpag.PAG;

/* loaded from: classes.dex */
public class g {
    private static String a() {
        return new SimpleDateFormat("yyyy-MM").format(new Date());
    }

    private static String b() {
        try {
            return PAG.SDKVersion();
        } catch (UnsatisfiedLinkError unused) {
            return null;
        }
    }

    public static void c(Context context) {
        e("init");
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pag_reporter", 0);
            if (sharedPreferences == null) {
                e("prefs null");
                return;
            }
            if (!d("org.libpag.PAG")) {
                e("not find org.libpag.PAG class ");
                return;
            }
            String strB = b();
            if (TextUtils.isEmpty(strB)) {
                e("sdkVersion is null");
                return;
            }
            String string = sharedPreferences.getString("last_pag_version", BuildConfig.FLAVOR);
            String string2 = sharedPreferences.getString("pag_report_time", BuildConfig.FLAVOR);
            String strA = a();
            if (strB.equals(string) && strA.equals(string2)) {
                e("not need update");
            } else {
                f(sharedPreferences);
            }
        } catch (Exception e6) {
            e("init error:" + e6);
        }
    }

    public static boolean d(String str) throws ClassNotFoundException {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static void e(String str) {
        Log.i(" [PAGReporterPrevent] ", str);
    }

    private static void f(SharedPreferences sharedPreferences) {
        e("writeData");
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            e("sdkVersion is null");
            return;
        }
        String strA = a();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("last_pag_version", strB);
        editorEdit.putString("pag_report_time", strA);
        editorEdit.commit();
    }
}
