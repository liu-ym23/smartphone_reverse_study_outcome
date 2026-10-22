package d5;

import android.text.TextUtils;
import com.bytedance.framwork.core.sdklib.net.ILogSendImpl;
import com.bytedance.framwork.core.sdklib.net.ISendLog;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f19091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f19092b = null;

    static {
        f19091a = new ConcurrentHashMap();
        f19092b = new ConcurrentHashMap();
    }

    public static ISendLog a(String r10) {
        return (ISendLog) f19091a.get(r10);
    }

    public static ILogSendImpl b(String r10) {
        return (ILogSendImpl) f19092b.get(r10);
    }

    public static boolean c(String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return false;
    L7:
        return ((ILogSendImpl) f19092b.get(r10)).send(r11);
    }

    public static void d(String r10, ISendLog r11) {
        f19091a.put(r10, r11);
    }

    public static void e(String r10, ILogSendImpl r11) {
        f19092b.put(r10, r11);
    }
}
