package b5;

import android.text.TextUtils;
import com.bytedance.framwork.core.sdklib.config.IMonitorConfigure;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IMonitorConfigure f5932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap f5933b;

    static {
        f5932a = new a();
        ConcurrentHashMap r10 = new ConcurrentHashMap();
        f5933b = r10;
        r10.put("default", f5932a);
    }

    public static boolean a(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        if (f5933b.get(r10) == null) goto L9;
        return ((IMonitorConfigure) f5933b.get(r10)).getRemoveSwitch();
    L9:
        return f5932a.getRemoveSwitch();
    }

    public static int b(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        if (f5933b.get(r10) == null) goto L9;
        return ((IMonitorConfigure) f5933b.get(r10)).reportCount();
    L9:
        return f5932a.reportCount();
    }

    public static int c(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L9:
        int r11 = f5932a.reportFailRepeatBaseTime();
    L8:
        return r11 * 1000;
    L5:
        if (f5933b.get(r10) == null) goto L9;
        r11 = ((IMonitorConfigure) f5933b.get(r10)).reportFailRepeatBaseTime();
        goto L8
    }

    public static int d(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        if (f5933b.get(r10) == null) goto L9;
        return ((IMonitorConfigure) f5933b.get(r10)).reportFailRepeatCount();
    L9:
        return f5932a.reportFailRepeatCount();
    }

    public static int e(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        if (f5933b.get(r10) == null) goto L9;
        return ((IMonitorConfigure) f5933b.get(r10)).reportInterval();
    L9:
        return f5932a.reportInterval();
    }

    public static JSONObject f(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        if (f5933b.get(r10) == null) goto L9;
        return ((IMonitorConfigure) f5933b.get(r10)).reportJsonHeaderInfo();
    L9:
        return f5932a.reportJsonHeaderInfo();
    }

    public static List g(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        if (f5933b.get(r10) == null) goto L9;
        return ((IMonitorConfigure) f5933b.get(r10)).reportUrl(r11);
    L9:
        return f5932a.reportUrl(r11);
    }

    public static long h(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        if (f5933b.get(r10) == null) goto L9;
        return ((IMonitorConfigure) f5933b.get(r10)).stopMoreChannelInterval();
    L9:
        return f5932a.stopMoreChannelInterval();
    }

    public static void i(String r10, IMonitorConfigure r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        f5933b.put(r10, r11);
    }
}
