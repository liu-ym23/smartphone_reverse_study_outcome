package androidx.core.app;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: AppLocalesStorageHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1075a = null;

    static {
        f1075a = new Object();
    }

    public static String a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        Object r0 = f1075a;
        monitor-enter(r0);
        String r1 = "";
        FileInputStream r2 = r9.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: FileNotFoundException -> L37 Throwable -> L39
        XmlPullParser r3 = Xml.newPullParser();     // Catch: Throwable -> L23 Throwable -> L25
        r3.setInput(r2, "UTF-8");     // Catch: Throwable -> L23 Throwable -> L25
        int r4 = r3.getDepth();     // Catch: Throwable -> L23 Throwable -> L25
    L7:
        int r5 = r3.next();     // Catch: Throwable -> L23 Throwable -> L25
        if (r5 == 1) goto L20;
        if (r5 == 3) goto L12;
    L13:
        if (r5 == 3) goto L7;
        if (r5 == 4) goto L7;
        if (r3.getName().equals("locales") == false) goto L7;
        r1 = r3.getAttributeValue(null, "application_locales");     // Catch: Throwable -> L23 Throwable -> L25
    L12:
        if (r3.getDepth() > r4) goto L13;
    L20:
        if (r2 == null) goto L29;
    L51:
        r2.close();     // Catch: IOException -> L42 Throwable -> L39
    L29:
        if (r1.isEmpty() == false) goto L32;
        r9.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L39
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L39
        return r1;
    L25:
        a("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L23
        if (r2 == null) goto L29;
    L23:
        th = move-exception;
        if (r2 != null) goto L49;
    L36:
        throw th;     // Catch: Throwable -> L39
    L49:
        r2.close();     // Catch: IOException -> L43 Throwable -> L39
        goto L36
    L39:
        th = move-exception;
        throw th;
    L38:
        return "";
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
