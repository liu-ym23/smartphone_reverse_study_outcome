package ai4;

import android.app.ApplicationExitInfo;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.r;
import com.bytedance.crash.s;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.util.p;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IApmAgent;
import com.optimize.statistics.FrescoMonitorConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f3775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PolarisFileWrapper f3776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static PolarisFileWrapper f3777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static PolarisFileWrapper f3778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<r> f3779g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<s> f3780h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f3781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f3782j;

    static {
        f3779g = new ConcurrentLinkedQueue();
        f3780h = new ConcurrentLinkedQueue();
        f3781i = false;
        f3782j = false;
    }

    public static void a(com.bytedance.crash.monitor.a r210, ApplicationExitInfo r211) {
        HashMap r100 = new HashMap();
        b r101 = new b();
        r101.f3739a = r211.getProcessName();
        r101.f3740b = r211.getTimestamp();
        r101.f3741c = r211.getPid();
        r101.f3744f = r211.getImportance();
        int r102 = r211.getReason();
        boolean r103 = d.f3751a;
        switch(r102) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            case 14: goto L5;
            default: goto L4;
        };
    L4:
        String r104 = "UNKNOWN";
    L19:
        r101.f3742d = r104;
        r101.f3743e = r211.getStatus();
        r101.f3748j = r211.getPss();
        r101.f3749k = r211.getRss();
        r101.f3745g = (r211.getPss() / 1024) + "M";
        r101.f3746h = (r211.getRss() / 1024) + "M";
        r101.f3747i = r211.getDescription();
        Object r105 = g.a(r211, new Object[0]);     // Catch: Exception -> L24 Throwable -> L80
    L25:
        r101.f3750l = d.d(((Integer) r105).intValue());     // Catch: Throwable -> L80
    L29:
        long[] r106 = {0};
        new PolarisFileWrapper(f3777e, r101.f3739a.replace(".", "_").replace(":", "-")).listFiles(new k(r101, r106));     // Catch: Throwable -> L32
    L33:
        long r110 = r106[0];
        if (r110 == 0) goto L100;
        StringBuilder r107 = new StringBuilder();
        r107.append(r101.f3742d);
        r107.append("\npid:");
        r107.append(r101.f3741c);
        r107.append(" process:");
        r107.append(r101.f3739a);
        r107.append(" alive_time:");
        r107.append(r101.f3740b - r110);
        r107.append(" last_alive_time:");
        r107.append(r101.f3740b - r110);
        r107.append("\n#exitInfo\n");
        if (Build.VERSION.SDK_INT < 24) goto L39;
        r107.append(new SimpleDateFormat().format(new Date(r101.f3740b)));
        r107.append("\n");
    L39:
        r107.append("importance=");
        r107.append(r101.f3744f);
        r107.append("\nsub_reason=");
        r107.append(r101.f3750l);
        r107.append("\nstatus=");
        r107.append(r101.f3743e);
        r107.append("\ndescription=");
        r107.append(r101.f3747i);
        r107.append("\npss=");
        r107.append(r101.f3745g);
        r107.append("\nreason=");
        r107.append(r101.f3742d);
        r107.append("\nprocess=");
        r107.append(r101.f3739a);
        r107.append("\nrss=");
        r107.append(r101.f3746h);
        r107.append("\n");
        String r108 = r107.toString();
        r100.put("exit_reason", r101.f3742d);
        r100.put("exit_sub_reason", r101.f3750l);
        r100.put("exit_description", r101.f3747i);
        r100.put("exit_status", String.valueOf(r101.f3743e));
        r100.put("exit_pss", d.c(r101.f3748j));
        r100.put("exit_rss", d.c(r101.f3749k));
        r100.put("importance", String.valueOf(r101.f3744f));
        r100.put("has_exit_info", "true");
        if (((String) r100.get("exit_reason")).equals("not obtained") == false) goto L42;
    L45:
        boolean r109 = true;
    L46:
        if (r109 == true) goto L90;
        long r111 = r106[0];
        HashMap r112 = new HashMap();
        r112.put("exit_status", String.valueOf(r101.f3743e));
        r112.put("exit_pss", d.c(r101.f3748j));
        r112.put("exit_rss", d.c(r101.f3749k));
        r112.put("has_exit_info", "true");
        r112.put("exit_reason", r101.f3742d);
        r112.put("exit_sub_reason", r101.f3750l);
        HashMap r113 = new HashMap(r112);
        JSONObject r114 = new JSONObject();
        r114.put("event_type", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);     // Catch: Throwable -> L78
        r114.put("crash_time", r101.f3740b);     // Catch: Throwable -> L78
        r114.put(FrescoMonitorConst.LOG_TYPE, "PROCESS_DIED");     // Catch: Throwable -> L78
        r114.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L78
        r114.put("message", "PROCESS_DIED");     // Catch: Throwable -> L78
        r114.put("crash_thread_name", "UNKNOW");     // Catch: Throwable -> L78
        r114.put("crash_md5", com.bytedance.crash.util.d.a(r108));     // Catch: Throwable -> L78
        r114.put("process_name", r101.f3739a);     // Catch: Throwable -> L78
        r114.put("app_start_time", r111);     // Catch: Throwable -> L78
        r114.put("exception_type", 1);     // Catch: Throwable -> L78
        r114.put("pid", r101.f3741c);     // Catch: Throwable -> L78
        r114.put("class_ref", "Native");     // Catch: Throwable -> L78
        r114.put(com.alipay.sdk.m.p.e.f25671s, "Native");     // Catch: Throwable -> L78
        r114.put("is_core", 1);     // Catch: Throwable -> L78
        r114.put("line_num", -1);     // Catch: Throwable -> L78
        r114.put("ensure_type", "EnsureNotReachHere");     // Catch: Throwable -> L78
        r114.put("stack", r108);     // Catch: Throwable -> L78
        r114.put("has_dump", "true");     // Catch: Throwable -> L78
        r114.put("java_data", "DiedProcess.unknownReason: App was killed, please see logcat.\n");     // Catch: Throwable -> L78
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L77
        Iterator r116 = r112.entrySet().iterator();     // Catch: Throwable -> L77
    L55:
        if (r116.hasNext() == false) goto L58;
        Map.Entry r117 = (Map.Entry) r116.next();     // Catch: Throwable -> L77
        r115.put((String) r117.getKey(), r117.getValue());     // Catch: Throwable -> L77
        goto L55
    L58:
        if (com.bytedance.crash.util.j.g(r115) == true) goto L60;
        r114.put("custom", r115);     // Catch: Throwable -> L77
    L60:
        b.a(r114, r113);     // Catch: Throwable -> L78
    L85:
        PolarisFileWrapper r118 = new PolarisFileWrapper(f3778f, "custom_data");     // Catch: Throwable -> L74
        r118.mkdirs();     // Catch: Throwable -> L74
        PolarisFileWrapper r119 = new PolarisFileWrapper(r118, r101.f3740b + "_" + r101.f3741c);     // Catch: Throwable -> L74
        if (r119.exists() == true) goto L64;
        r119.mkdirs();     // Catch: Throwable -> L74
    L64:
        b(r119, r100, r101, r106[0]);     // Catch: Throwable -> L74
        c(r119, r100);     // Catch: Throwable -> L74
        d(r119, r100);     // Catch: Throwable -> L74
        wg4.a.b(r211.getProcessName(), 0, r211.getTimestamp(), CrashType.NATIVE_CUSTOMIZE);     // Catch: Throwable -> L67
        r100.put("has_alog", "true");     // Catch: Throwable -> L67
    L69:
        b.a(r114, r100);     // Catch: Throwable -> L74
        boolean r120 = e(r210, r101.f3740b, r114, r119);     // Catch: Throwable -> L74
        if (r120 == false) goto L72;
        p.e("upload success:" + r120);     // Catch: Throwable -> L74
        com.bytedance.crash.util.g.e(r119);     // Catch: Throwable -> L74
    L72:
        com.bytedance.crash.util.g.e(r119);     // Catch: Throwable -> L74
        return;
    L67:
        th = move-exception;
        th.toString();     // Catch: Throwable -> L74
        boolean r121 = zg4.i.f572087c;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        th.toString();
        boolean r122 = zg4.i.f572087c;
        return;
    L90:
        IApmAgent r123 = (IApmAgent) ServiceManager.getService(IApmAgent.class);     // Catch: Throwable -> L79
        JSONObject r124 = new JSONObject();     // Catch: Throwable -> L79
        if (r123 == null) goto L99;
        r124.put("reason", r100.get("exit_reason"));     // Catch: Throwable -> L79
        r123.monitorEvent("app_exit", r124, null, null);     // Catch: Throwable -> L79
        return;
    L99:
        return;
    L103:
        return;
    L42:
        if (((String) r100.get("exit_reason")).equals("USER REQUESTED") == true) goto L45;
        r109 = false;
        goto L46
    L100:
        return;
    L24:
        Objects.toString(r211);     // Catch: Throwable -> L80
        boolean r125 = zg4.i.f572087c;     // Catch: Throwable -> L80
        r105 = null;
    L28:
        r101.f3750l = "UNKNOWN";
        goto L29
    L5:
        r104 = "FREEZER";
        goto L19
    L6:
        r104 = "OTHER KILLS BY SYSTEM";
        goto L19
    L7:
        r104 = "DEPENDENCY DIED";
        goto L19
    L8:
        r104 = "USER STOPPED";
        goto L19
    L9:
        r104 = "USER REQUESTED";
        goto L19
    L10:
        r104 = "EXCESSIVE RESOURCE USAGE";
        goto L19
    L11:
        r104 = "PERMISSION CHANGE";
        goto L19
    L12:
        r104 = "INITIALIZATION FAILURE";
        goto L19
    L13:
        r104 = "ANR";
        goto L19
    L14:
        r104 = "APP CRASH(NATIVE)";
        goto L19
    L15:
        r104 = "APP CRASH(EXCEPTION)";
        goto L19
    L16:
        r104 = "LOW_MEMORY";
        goto L19
    L17:
        r104 = "SIGNALED";
        goto L19
    L18:
        r104 = "EXIT_SELF";
        goto L19
    }

    public static void c(PolarisFileWrapper r100, Map r101) {
        boolean r102 = true;
        NativeBridge.l(r100.getAbsolutePath(), true);     // Catch: Throwable -> L23
    L26:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100, "logcat.txt");     // Catch: Throwable -> L12
        if (r103.exists() == true) goto L7;
    L11:
        r102 = false;
        goto L13
    L7:
        if (r103.isDirectory() == true) goto L11;
        if (r103.length() < 50) goto L11;
    L13:
        if (r102 == false) goto L30;
        String r104 = com.bytedance.crash.util.h.c(new PolarisFileWrapper(r100, "logcat.txt"));     // Catch: Throwable -> L20
        f3773a = r104;     // Catch: Throwable -> L20
        if (r104.isEmpty() == false) goto L17;
        return;
    L17:
        if (f3773a.length() <= 10) goto L32;
        ((HashMap) r101).put("has_logcat", "true");     // Catch: Throwable -> L20
        return;
    L32:
        return;
    L20:
        th = move-exception;
        th.toString();
        boolean r105 = zg4.i.f572087c;
        return;
    }

    public static void d(PolarisFileWrapper r100, Map r101) {
        NativeBridge.m(r100.getAbsolutePath());     // Catch: IOException -> L15
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, "os_memory.txt");     // Catch: IOException -> L15
        if (r102.exists() == true) goto L6;
    L13:
        ((HashMap) r101).put("has_os_memory", "false");     // Catch: IOException -> L15
        return;
    L6:
        if (r102.length() <= 10) goto L13;
        String r103 = com.bytedance.crash.util.h.c(r102);     // Catch: IOException -> L15
        if (r103 == null) goto L13;
        if (r103.contains("kB") == false) goto L13;
        ((HashMap) r101).put("has_os_memory", "true");     // Catch: IOException -> L15
        return;
    L15:
        e = move-exception;
        e.toString();
        boolean r104 = zg4.i.f572087c;
    }

    public static void b(PolarisFileWrapper r100, Map r101, b r102, long r103) {
        boolean r104 = bi4.e.f19135b;     // Catch: Throwable -> L29
        PolarisFileWrapper r105 = bi4.e.b(r102.f3739a, r103);     // Catch: Throwable -> L29
        if (r105 != null) goto L6;
    L27:
        ((HashMap) r101).put("has_process_track", "false");     // Catch: Throwable -> L29
        return;
    L6:
        if (r105.exists() == false) goto L27;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r100, "process_track.txt");     // Catch: Throwable -> L29
        BufferedReader r107 = null;
        String r108 = null;
        com.bytedance.crash.util.h.a(r105, r106, true);     // Catch: Throwable -> L24
        HashMap r109 = (HashMap) r101;     // Catch: Throwable -> L24
        r109.put("has_process_track", "true");     // Catch: Throwable -> L24
        BufferedReader r110 = new BufferedReader(new PolarisFileReaderWrapper(r106));     // Catch: Throwable -> L24
    L32:
        String r111 = r110.readLine();     // Catch: Throwable -> L22
        if (r111 == null) goto L15;
        if (r111.contains("onResume") == false) goto L32;
        r108 = r111;
        goto L32
    L15:
        if (r108 == null) goto L21;
        String[] r112 = r108.split(" ", 3);     // Catch: Throwable -> L22
        if (r112.length <= 1) goto L21;
        String r113 = r112[1];     // Catch: Throwable -> L22
        int r114 = r113.indexOf(".onResume");     // Catch: Throwable -> L22
        if (r114 <= 0) goto L21;
        r109.put("scene", r113.substring(0, r114));     // Catch: Throwable -> L22
    L21:
        com.bytedance.crash.util.i.a(r110);     // Catch: Throwable -> L29
        return;
    L22:
        th = th;
        r107 = r110;
    L25:
        com.bytedance.crash.util.i.a(r107);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L24:
        th = th;
    L29:
        th = move-exception;
        ch4.c.a("dumpActivityInfo", th);
    }

    public static boolean e(com.bytedance.crash.monitor.a r100, long r101, JSONObject r102, PolarisFileWrapper r103) {
        JSONObject r104 = Header.b(r100, r101, CrashType.NATIVE_CUSTOMIZE, Process.myPid()).f203195a;     // Catch: Exception -> L8
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L8
        JSONArray r106 = new JSONArray();     // Catch: Exception -> L8
        r106.put(r102);     // Catch: Exception -> L8
        r105.put("data", r106);     // Catch: Exception -> L8
        r105.put("header", r104);     // Catch: Exception -> L8
        if (f3773a == null) goto L6;
        JSONArray r107 = new JSONArray();     // Catch: Exception -> L8
        r107.put(f3773a);     // Catch: Exception -> L8
        r105.put("logcat", r107);     // Catch: Exception -> L8
    L6:
        String r108 = com.bytedance.crash.upload.n.d(zg4.g.f572072l.f572078f, r104);     // Catch: Exception -> L8
        String r109 = r105.toString();     // Catch: Exception -> L8
        ArrayList r110 = new ArrayList();     // Catch: Exception -> L8
        r110.add(new File[]{r103}[0]);     // Catch: Exception -> L8
        return CrashUploader.g("ensure_zip", r108, r109, r110).a();
    L8:
        return false;
    }
}
