package O6;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.libpag.PAG;

/* loaded from: classes3.dex */
public class q {
    private static final String PAG_REPORT_TIME_KEY = "pag_report_time";
    private static final String PAG_VERSION_KEY = "last_pag_version";
    private static final String REPORTED = "Reported";
    private static final String TAG = " [PAGReporterPrevent] ";

    public static String a() {
        return new SimpleDateFormat("yyyy-MM").format(new Date());
    }

    public static String b() {
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
            String string = sharedPreferences.getString(PAG_VERSION_KEY, "");
            String string2 = sharedPreferences.getString(PAG_REPORT_TIME_KEY, "");
            String strA = a();
            if (strB.equals(string) && strA.equals(string2)) {
                e("not need update");
            } else {
                f(sharedPreferences);
            }
        } catch (Exception e10) {
            e("init error:" + e10);
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

    public static void e(String str) {
        Log.i(TAG, str);
    }

    public static void f(SharedPreferences sharedPreferences) {
        e("writeData");
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            e("sdkVersion is null");
            return;
        }
        String strA = a();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(PAG_VERSION_KEY, strB);
        editorEdit.putString(PAG_REPORT_TIME_KEY, strA);
        editorEdit.commit();
    }
}
