package x9;

import ba.b;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.handler.IMessageHandler;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import s1.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements IMessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap f25848a;

    static {
        f25848a = new ConcurrentHashMap();
    }

    public a() {
    }

    public final boolean a(w9.a r10) {
        String r11 = r10.b();
        if (f25848a.containsKey(r11) == false) goto L9;
        long r12 = ((Long) f25848a.get(r11)).longValue();
        if ((System.currentTimeMillis() - r12) >= 10000) goto L8;
        return false;
    L8:
        f25848a.put(r11, Long.valueOf(System.currentTimeMillis()));
        return true;
    L9:
        f25848a.put(r11, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    public boolean b(w9.a r10) {
        if (b.b().d(r10.b()) == true) goto L5;
        return true;
    L5:
        if (NetworkUtils.l(v9.a.k().i()) == true) goto L10;
        ba.a.c("产物超过阈值，等待WiFi环境执行", r10);
        return false;
    L10:
        return true;
    }

    public boolean c(JSONObject r10, w9.a r11) {
        if (r10.optBoolean("wifiOnly", false) == true) goto L5;
    L8:
        return false;
    L5:
        if (NetworkUtils.l(v9.a.k().i()) == true) goto L8;
        da.b r12 = new da.b(0, false, r11.b(), null);
        r12.h(0);
        r12.i("4G环境下不执行指令");
        ca.a.d(r12);
        return true;
    }

    public abstract String d();

    public abstract boolean e(w9.a r10);

    public final void f(w9.a r10) {
        da.b r11 = new da.b(0, false, r10.b(), null);
        r11.h(3);
        r11.i("当前云控指令已被sdk禁用");
        ca.a.d(r11);
    }

    public boolean g() {
        if (v9.a.g() == null) goto L11;
        String[] r10 = v9.a.g();
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        if (d().equals(r10[r12]) == true) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public void h(String r10, HashMap r11, w9.a r12) {
        da.b r13 = new da.b(0, false, r12.b(), r11);
        r13.h(3);
        r13.i(r10);
        ca.a.d(r13);
    }

    @Override // com.monitor.cloudmessage.handler.IMessageHandler
    public synchronized boolean handleCloudMessage(w9.a r10) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (d().equals(r10.e()) == true) goto L39;
        monitor-exit(this);
        return false;
    L39:
    L18:
        e = move-exception;
        i(e.getMessage(), r10);     // Catch: Throwable -> L14
        return false;
    L16:
        e = move-exception;
        i(String.format("系统错误：%s", new Object[]{com.monitor.cloudmessage.utils.a.a(e)}), r10);     // Catch: Throwable -> L14
        return false;
    L9:
        if (g() == false) goto L21;
        f(r10);     // Catch: Throwable -> L14 Exception -> L16 CloudMessageException -> L18
        monitor-exit(this);
        return true;
    L21:
        if (a(r10) == true) goto L23;
    L27:
        c.b("cloudmessage", new String[]{"checkCmdInterval false: ignored for now."});     // Catch: Throwable -> L14 Exception -> L16 CloudMessageException -> L18
        monitor-exit(this);
        return false;
    L23:
        if (b(r10) == false) goto L27;
        c.b("cloudmessage", new String[]{"start handle message:" + r10});     // Catch: Throwable -> L14 Exception -> L16 CloudMessageException -> L18
        boolean r11 = e(r10);     // Catch: Throwable -> L14 Exception -> L16 CloudMessageException -> L18
        monitor-exit(this);
        return r11;
    }

    public void i(String r10, w9.a r11) {
        da.b r12 = new da.b(0, false, r11.b(), null);
        r12.h(3);
        r12.i(r10);
        ca.a.d(r12);
    }

    public void j(w9.a r10) {
        da.b r11 = new da.b(0, false, r10.b(), null);
        r11.h(2);
        ca.a.d(r11);
    }
}
