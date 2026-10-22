package l8;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.libpag.PAG;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {
    public static String a() {
        try {
            return PAG.SDKVersion();
        } catch (UnsatisfiedLinkError unused) {
            return null;
        }
    }

    public static void b(Context context) throws ClassNotFoundException {
        c("init");
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pag_reporter", 0);
            if (sharedPreferences == null) {
                c("prefs null");
                return;
            }
            try {
                Class.forName("org.libpag.PAG");
                String strA = a();
                if (TextUtils.isEmpty(strA)) {
                    c("sdkVersion is null");
                    return;
                }
                String string = sharedPreferences.getString("last_pag_version", "");
                String string2 = sharedPreferences.getString("pag_report_time", "");
                String str = new SimpleDateFormat("yyyy-MM").format(new Date());
                if (strA.equals(string) && str.equals(string2)) {
                    c("not need update");
                    return;
                }
                c("writeData");
                String strA2 = a();
                if (TextUtils.isEmpty(strA2)) {
                    c("sdkVersion is null");
                    return;
                }
                String str2 = new SimpleDateFormat("yyyy-MM").format(new Date());
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("last_pag_version", strA2);
                editorEdit.putString("pag_report_time", str2);
                editorEdit.commit();
            } catch (ClassNotFoundException unused) {
                c("not find org.libpag.PAG class ");
            }
        } catch (Exception e10) {
            c("init error:" + e10);
        }
    }

    public static void c(String str) {
        Log.i(" [PAGReporterPrevent] ", str);
    }
}
