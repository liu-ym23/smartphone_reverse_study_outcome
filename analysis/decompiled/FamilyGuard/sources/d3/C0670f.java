package d3;

import android.content.Context;
import android.content.SharedPreferences;
import f3.C0720b;
import g3.C0742e;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.libpag.BuildConfig;

/* renamed from: d3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0670f {
    public static boolean a(Context context) {
        C0720b c0720b = new C0720b(context, "com.stepos.statsapp.v3.request_feq_restrict");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH");
        String strM = c0720b.m("date", BuildConfig.FLAVOR);
        String str = simpleDateFormat.format(new Date());
        if (!strM.equals(str)) {
            SharedPreferences.Editor editorH = c0720b.h();
            editorH.putString("date", str);
            editorH.putLong("current_request", 1L);
            editorH.commit();
            C0742e.c("RequestFreqRestrict", "isAllow true");
            return true;
        }
        long jL = c0720b.l("current_request", 0L);
        if (jL > 10) {
            C0742e.c("RequestFreqRestrict", "isAllow false");
            return false;
        }
        c0720b.d("current_request", jL + 1);
        C0742e.c("RequestFreqRestrict", "isAllow true");
        return true;
    }
}
