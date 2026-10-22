package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConfigurationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: compiled from: ConfigurationCompat.java */
    static class a {
        static void a(Configuration r1, i r2) {
            if (r2.b() == true) goto L6;
            r1.setLocale(r2.a(0));
            return;
        }
    }

    /* JADX INFO: compiled from: ConfigurationCompat.java */
    static class b {
        static LocaleList a(Configuration r0) {
            return r0.getLocales();
        }

        static void a(Configuration r2, i r3) {
            r2.setLocales((LocaleList) ZeusTransformUtils.preCheckCast(r3.a(), LocaleList.class, "com.obric.aiagent.plugin"));
        }
    }

    public static void a(Configuration r2, i r3) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        b.a(r2, r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L10;
        a.a(r2, r3);
        return;
    }
}
