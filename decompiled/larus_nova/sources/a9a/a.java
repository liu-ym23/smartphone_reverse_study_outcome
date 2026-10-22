package a9a;

import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import x8a.c;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f2301a = null;

    public a() {
    }

    public abstract String f();

    public abstract boolean g(z8a.a r100) throws Exception;

    static {
        f2301a = new ConcurrentHashMap();
    }

    public static boolean c(z8a.a r100) {
        String r101 = r100.f570967c;
        ConcurrentHashMap<String, Long> r102 = f2301a;
        if (r102.containsKey(r101) == false) goto L9;
        long r103 = r102.get(r101).longValue();
        if ((System.currentTimeMillis() - r103) >= 10000) goto L8;
        return false;
    L8:
        r102.put(r101, Long.valueOf(System.currentTimeMillis()));
        return true;
    L9:
        r102.put(r101, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    public static boolean d(z8a.a r100) {
        f9a.b r101 = f9a.b.C5874b.f475989a;
        String r102 = r100.f570967c;
        if (((HashMap) r101.f475987a).get(r102) != Boolean.TRUE) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
    L11:
        return true;
    L8:
        if (NetworkUtils.g(c.b().getContext()) == true) goto L11;
        f9a.a.a(r100.f570967c, "产物超过阈值，等待WiFi环境执行", 0, null);
        return false;
    L5:
        r103 = false;
        goto L6
    }

    @Override // a9a.b
    public final synchronized boolean b(z8a.a r100) {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L6:
        if (f().equals(r100.getType()) == true) goto L32;
        monitor-exit(this);
        return false;
    L32:
    L24:
        e = move-exception;
        h(e.getMessage(), r100);     // Catch: Throwable -> L28
        return false;
    L20:
        e = move-exception;
        StringWriter r101 = new StringWriter();     // Catch: Throwable -> L28
        e.printStackTrace(new PrintWriter(r101));     // Catch: Throwable -> L28
        h(String.format("系统错误：%s", new Object[]{r101.toString()}), r100);     // Catch: Throwable -> L28
        return false;
    L11:
        if (c(r100) == true) goto L13;
    L17:
        ps3.b.a(new String[]{"checkCmdInterval false: ignored for now."});     // Catch: Exception -> L20 CloudMessageException -> L24 Throwable -> L28
        monitor-exit(this);
        return false;
    L13:
        if (d(r100) == false) goto L17;
        ps3.b.a(new String[]{"start handle message:" + r100});     // Catch: Exception -> L20 CloudMessageException -> L24 Throwable -> L28
        boolean r102 = g(r100);     // Catch: Exception -> L20 CloudMessageException -> L24 Throwable -> L28
        monitor-exit(this);
        return r102;
    }

    public static boolean e(JSONObject r100, z8a.a r101) {
        if (r100.optBoolean("wifiOnly", false) == true) goto L5;
    L8:
        return false;
    L5:
        if (NetworkUtils.g(c.b().getContext()) == true) goto L8;
        i9a.b r102 = new i9a.b(r101.f570967c, null);
        r102.f488823d = 0;
        r102.f488824e = "4G环境下不执行指令";
        g9a.a.c(r102);
        return true;
    }

    public static void h(String r100, z8a.a r101) {
        i9a.b r102 = new i9a.b(r101.f570967c, null);
        r102.f488823d = 3;
        r102.f488824e = r100;
        g9a.a.c(r102);
    }
}
