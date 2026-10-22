package os.teatracker;

import android.content.Context;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: TeaUtil.java */
/* JADX INFO: loaded from: classes5.dex */
public class h {
    static boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return true;
    }

    public static String a(String r8) {
        Method r2 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class});     // Catch: Throwable -> L5
        r2.setAccessible(true);     // Catch: Throwable -> L5
        return (String) ZeusTransformUtils.preCheckCast(r2.invoke(null, new Object[]{r8}), String.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        a(e.f40691b, "getProperty failed!", e);
        return null;
    }

    public static boolean a() {
        if ("userdebug".equals(a("ro.build.type")) == false) goto L5;
        return true;
    L5:
        return "1".equals(a("persist.sys.tealog.enable"));
    }

    static JSONObject a(JSONObject r4) {
        if (r4 == null) goto L14;
        return new JSONObject(r4.toString());
    L5:
        String r0 = e.f40691b;
        StringBuilder r1 = new StringBuilder().append("Failed to copy Tea json obj");
        if (e.f40690a == false) goto L8;
        String r5 = " from " + r4;
    L9:
        a(r0, r1.append(r5).toString());
        return null;
    L8:
        r5 = ".";
        goto L9
    L14:
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
