package n2;

import android.app.Application;
import com.bytedance.apm.constant.CommonKey;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Properties f22378a;

    public static String a() {
        return String.valueOf(b(CommonKey.KEY_RELEASE_BUILD));
    }

    public static Object b(String r10) {
        c();
        Properties r11 = f22378a;     // Catch: Exception -> L9
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.containsKey(r10) == false) goto L13;
        return f22378a.get(r10);
    L13:
        return null;
    L14:
        return null;
    }

    public static void c() {
        Application r10 = r3.a.b();
        if (f22378a != null) goto L15;
        f22378a = new Properties();
        InputStream r11 = r10.getApplicationContext().getAssets().open("slardar.properties");     // Catch: Throwable -> L8
        f22378a.load(r11);     // Catch: Throwable -> L16
    L7:
        r3.d.a(r11);
        return;
    L21:
        f22378a = null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r3.d.a(r11);
        throw th;
    L8:
        r11 = null;
        goto L21
    }
}
