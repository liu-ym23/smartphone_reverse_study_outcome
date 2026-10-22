package ai4;

import android.app.ApplicationExitInfo;
import com.bytedance.crash.r;
import com.bytedance.crash.s;
import com.bytedance.crash.util.p;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<ApplicationExitInfo> f3766b = null;

    static {
        f3766b = new ArrayList();
    }

    public static void a() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(n.f3778f, "exit_info");
        if (r100.exists() == true) goto L5;
        return;
    L5:
        String[] r101 = r100.list();
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = 50;
        if (r101.length <= 50) goto L14;
        Arrays.sort(r101);
    L12:
        if (r102 >= r101.length) goto L16;
        com.bytedance.crash.util.h.b(new PolarisFileWrapper(r100, r101[r102]));
        r102 = r102 + 1;
        goto L12
    L16:
        return;
    }

    public static List<ApplicationExitInfo> b() {
        if (f3765a == true) goto L5;
        f3765a = true;
        if (d.a() == true) goto L75;
        return null;
    L75:
        List<ApplicationExitInfo> r100 = d.b();     // Catch: Throwable -> L17
        if (r100 != null) goto L13;
        a();
        return null;
    L13:
        PolarisFileWrapper r101 = new PolarisFileWrapper(n.f3778f, "lastReasonTime");     // Catch: Throwable -> L17
        if (r101.exists() == true) goto L81;
    L19:
        long r102 = -1;
    L20:
        Iterator<ApplicationExitInfo> r103 = r100.iterator();     // Catch: Throwable -> L17
    L22:
        if (r103.hasNext() == false) goto L34;
        ApplicationExitInfo r104 = r103.next();     // Catch: Throwable -> L17
        if (r104.getTimestamp() < r102) goto L34;
        ((ArrayList) f3766b).add(r104);     // Catch: Throwable -> L17
        Iterator<r> r105 = n.f3779g.iterator();     // Catch: Throwable -> L57
    L29:
        if (r105.hasNext() == false) goto L22;
        r105.next().a(r104);     // Catch: Throwable -> L58
    L34:
        if (((ArrayList) f3766b).size() != 0) goto L79;
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L17
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L17
        IApmAgent r108 = (IApmAgent) ServiceManager.getService(IApmAgent.class);     // Catch: Throwable -> L59
        if (r108 == null) goto L79;
        r106.put("reason", "1");     // Catch: Throwable -> L59
        r107.put("time", r102);     // Catch: Throwable -> L59
        r108.monitorEvent("app_exit", r106, null, null);     // Catch: Throwable -> L59
    L79:
        Iterator<s> r109 = n.f3780h.iterator();     // Catch: Throwable -> L61
    L41:
        if (r109.hasNext() == false) goto L45;
        r109.next().a();     // Catch: Throwable -> L60
    L45:
        PolarisFileWrapper r110 = new PolarisFileWrapper(n.f3778f, "lastReasonTime");     // Catch: Throwable -> L17
        com.bytedance.crash.util.h.h(r110, String.valueOf(System.currentTimeMillis()), false);     // Catch: Throwable -> L62
    L52:
        a();
        return f3766b;
    L81:
        r102 = Long.decode(com.bytedance.crash.util.h.c(r101)).longValue();
    L17:
        th = move-exception;
        fh4.f r111 = com.bytedance.crash.monitor.j.c();     // Catch: Throwable -> L54
        if (r111.d("core_exception_monitor", null) == false) goto L51;
        p.e("reportThrowable：isDrop:");     // Catch: Throwable -> L54
    L72:
        goto L52
    L51:
        r111.g(null, null, th, "core_exception_monitor");     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        a();
        throw th;
    L5:
        return f3766b;
    }
}
