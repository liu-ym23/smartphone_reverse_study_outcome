package com.bytedance.crash.n;

import android.app.ApplicationExitInfo;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.h;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.u;
import com.bytedance.crash.upload.o;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashAccessibilityMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7613a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f7614b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static File f7615c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static File f7616d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f7617e = false;
    private static Map<String, List<a>> f;
    private static List<ApplicationExitInfo> g;

    /* JADX INFO: renamed from: com.bytedance.crash.n.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: CrashAccessibilityMonitor.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7618a = null;

        static {
            int[] r0 = new int[CrashType.values().length];
            f7618a = r0;
            r0[CrashType.ANR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f7618a[CrashType.NATIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f7618a[CrashType.JAVA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: compiled from: CrashAccessibilityMonitor.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CrashType f7620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f7621c;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        f = new HashMap();
    }

    public static void a(boolean r0) {
        f7614b = r0;
    }

    public static void a() {
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L46
        Iterator<ApplicationExitInfo> r1 = g.iterator();     // Catch: Throwable -> L46
    L4:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L31;
        ApplicationExitInfo r2 = (ApplicationExitInfo) ZeusTransformUtils.preCheckCast(r1.next(), ApplicationExitInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        if (r2.getReason() == 6) goto L13;
        if (r2.getReason() == 4) goto L13;
        if (r2.getReason() != 5) goto L4;
    L13:
        List r5 = (List) ZeusTransformUtils.preCheckCast(f.get(r2.getProcessName()), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        if (r5 == null) goto L15;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L46
    L18:
        if (r6.hasNext() == false) goto L28;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        long r8 = r2.getTimestamp() - r7.f7621c;     // Catch: Throwable -> L46
        if (a(r2.getReason()).getName().equals(r7.f7620b.getName()) == false) goto L18;
        if (r2.getPid() != r7.f7619a) goto L18;
        if (r8 <= 0) goto L18;
        if (r8 >= OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS) goto L18;
    L29:
        if (r3 == true) goto L4;
        r0.add(r2);     // Catch: Throwable -> L46
        goto L4
    L28:
        r3 = false;
        goto L29
    L15:
        r0.add(r2);     // Catch: Throwable -> L46
        goto L4
    L31:
        f();     // Catch: Throwable -> L46
        Iterator r4 = r0.iterator();     // Catch: Throwable -> L46
    L32:
        if (r4.hasNext() == false) goto L84;
        ApplicationExitInfo r9 = (ApplicationExitInfo) ZeusTransformUtils.preCheckCast(r4.next(), ApplicationExitInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        int r10 = AnonymousClass1.f7618a[a(r9.getReason()).ordinal()];     // Catch: Throwable -> L46
        if (r10 != 1) goto L37;
        c(r9);     // Catch: Throwable -> L46
        goto L32
    L37:
        if (r10 != 2) goto L39;
        a(r9);     // Catch: Throwable -> L46
        goto L32
    L39:
        if (r10 != 3) goto L32;
        b(r9);     // Catch: Throwable -> L46
        goto L32
    L84:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(CrashType r3, String r4, int r5, long r6) {
        List<ApplicationExitInfo> r0 = g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() == 0) goto L22;
        List<a> r1 = null;
        a r2 = new a(0 == true ? 1 : 0);     // Catch: Throwable -> L18
        if (r3 != CrashType.LAUNCH) goto L10;
        r2.f7620b = CrashType.JAVA;     // Catch: Throwable -> L18
    L11:
        r2.f7619a = r5;     // Catch: Throwable -> L18
        r2.f7621c = r6;     // Catch: Throwable -> L18
        if (f.containsKey(r4) == false) goto L14;
        r1 = (List) ZeusTransformUtils.preCheckCast(f.get(r4), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
    L14:
        if (r1 != null) goto L16;
        r1 = new ArrayList();     // Catch: Throwable -> L18
        f.put(r4, r1);     // Catch: Throwable -> L18
    L16:
        r1.add(r2);     // Catch: Throwable -> L18
        return;
    L10:
        r2.f7620b = r3;     // Catch: Throwable -> L18
    L23:
        return;
    }

    public static void b() {
        if (g() == true) goto L6;
        return;
    L6:
        if (f7613a == false) goto L8;
        return;
    L8:
        f7613a = true;
        c();
        if (new File(f7615c, "lastReasonTime").exists() == true) goto L12;
        f();
        return;
    L12:
        List<ApplicationExitInfo> r0 = c.b();
        if (r0 != null) goto L15;
        return;
    L15:
        g = new ArrayList();
        long r1 = e();
        Iterator<ApplicationExitInfo> r2 = r0.iterator();
    L17:
        if (r2.hasNext() == false) goto L22;
        ApplicationExitInfo r3 = (ApplicationExitInfo) ZeusTransformUtils.preCheckCast(r2.next(), ApplicationExitInfo.class, "com.obric.aiagent.plugin");
        if (r3.getTimestamp() < r1) goto L22;
        g.add(r3);
    L22:
        f();
    }

    private static long e() {
        c();
        File r0 = new File(f7615c, "lastReasonTime");
        if (r0.exists() == true) goto L8;
    L6:
        return -1;
    L8:
        return a(j.d(r0), -1);
    }

    private static void f() {
        File r0 = new File(f7615c, "lastReasonTime");
        j.a(r0, String.valueOf(System.currentTimeMillis()), false);     // Catch: Throwable -> L5
        return;
    }

    private static void a(ApplicationExitInfo r8) {
        if (c.a() == true) goto L5;
        return;
    L5:
        Header r0 = Header.a(h.a(), r8.getTimestamp(), CrashType.NATIVE, r8.getPid());
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        l.a(r1, "header", r0.b());
        r1.put("filters", r2);     // Catch: Throwable -> L33
    L7:
        l.a(r1, "is_native_crash", 1);
        l.a(r1, "crash_time", Long.valueOf(r8.getTimestamp()));
        String r5 = "true";
        l.a(r1, "has_dump", "true");
        l.a(r1, "jiffy", Long.valueOf(com.bytedance.crash.general.a.b()));
        l.a(r1, "data", "Signal 111(CRASH_FROM_EXIT)\n\n");
        l.a(r2, "sdk_version", com.bytedance.crash.config.g.f7298a);
        if (NativeBridge.g() == false) goto L10;
        Object r3 = "true";
    L11:
        l.a(r2, "is_64_runtime", r3);
        String r4 = r0.b().optString(HardwareInfo.KEY_HW_CPU_ABI);
        if (TextUtils.isEmpty(r4) == true) goto L15;
        boolean r6 = r4.contains("64");
        l.a(r2, "is_x86_devices", Boolean.valueOf(r4.contains("86")));
        l.a(r2, "is_64_devices", Boolean.valueOf(r6));
    L15:
        if (com.bytedance.crash.general.a.c() == false) goto L17;
        Object r7 = "true";
    L18:
        l.a(r2, "is_root", r7);
        l.a(r2, RomInfo.KEY_ROM_KERNEL_VERSION, r0.b().optString(RomInfo.KEY_ROM_KERNEL_VERSION));
        l.a(r2, "is_hm_os", String.valueOf(u.a()));
        if (com.bytedance.crash.general.a.c() == true) goto L22;
        r5 = "false";
    L22:
        l.a(r2, "is_root", r5);
        l.a(r2, "exit_reason", String.valueOf(r8.getReason()));
        l.a(r2, "exit_status", String.valueOf(r8.getStatus()));
        l.a(r2, "crash_from", "app_exit_history");
        l.a(r2, "description", String.valueOf(r8.getDescription()));
        l.a(r2, "importance", String.valueOf(r8.getImportance()));
        l.a(r2, "pss", String.valueOf(r8.getPss()));
        l.a(r2, "rss", String.valueOf(r8.getRss()));
        JSONObject r9 = new JSONObject();
        r1.put(MonitorConstants.CUSTOM, r9);     // Catch: Throwable -> L34
    L24:
        l.a(r9, "app_info_description", r8.toString());
        String r10 = null;
        r10 = a(r8.getTraceInputStream());     // Catch: Throwable -> L35
    L27:
        if (TextUtils.isEmpty(r10) == false) goto L29;
    L31:
        String r11 = o.a(CrashType.NATIVE, r0.b());
        ArrayList r12 = new ArrayList();
        r12.add(f7615c);
        com.bytedance.crash.upload.b.a(CrashType.NATIVE.getName(), r11, r1.toString(), r12);
        return;
    L29:
        if (r10.contains("failed to read status response from tombstoned:") == true) goto L31;
        l.a(r9, "native_crash_trace", r10);
        goto L31
    L17:
        r7 = "false";
        goto L18
    L10:
        r3 = "false";
        goto L11
    }

    private static void b(ApplicationExitInfo r9) {
        if (c.a() == true) goto L5;
        return;
    L5:
        Header r0 = Header.a(h.a(), r9.getTimestamp(), CrashType.JAVA, r9.getPid());
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        l.a(r1, "header", r0.b());
        r1.put("filters", r2);     // Catch: Throwable -> L37
    L7:
        String r3 = null;
        r3 = a(r9.getTraceInputStream());     // Catch: Throwable -> L38
    L9:
        String r5 = "at ApplicationExit InvalidStack.NoStackAvailable(Invalid.java:1).\n";
        if (TextUtils.isEmpty(r3) == false) goto L12;
    L13:
        r3 = "at ApplicationExit InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    L14:
        l.a(r1, "isJava", 1);
        l.a(r1, "crash_time", Long.valueOf(r9.getTimestamp()));
        String r6 = "true";
        l.a(r1, "has_dump", "true");
        l.a(r1, "jiffy", Long.valueOf(com.bytedance.crash.general.a.b()));
        if (TextUtils.isEmpty(r3) == true) goto L18;
        r5 = r3;
    L18:
        l.a(r1, "data", r5);
        l.a(r2, "sdk_version", com.bytedance.crash.config.g.f7298a);
        if (NativeBridge.g() == false) goto L21;
        Object r4 = "true";
    L22:
        l.a(r2, "is_64_runtime", r4);
        String r7 = r0.b().optString(HardwareInfo.KEY_HW_CPU_ABI);
        if (TextUtils.isEmpty(r7) == true) goto L26;
        boolean r8 = r7.contains("64");
        l.a(r2, "is_x86_devices", Boolean.valueOf(r7.contains("86")));
        l.a(r2, "is_64_devices", Boolean.valueOf(r8));
    L26:
        if (com.bytedance.crash.general.a.c() == false) goto L28;
        Object r10 = "true";
    L29:
        l.a(r2, "is_root", r10);
        l.a(r2, RomInfo.KEY_ROM_KERNEL_VERSION, r0.b().optString(RomInfo.KEY_ROM_KERNEL_VERSION));
        l.a(r2, "is_hm_os", String.valueOf(u.a()));
        if (com.bytedance.crash.general.a.c() == true) goto L33;
        r6 = "false";
    L33:
        l.a(r2, "is_root", r6);
        l.a(r2, "exit_reason", String.valueOf(r9.getReason()));
        l.a(r2, "exit_status", String.valueOf(r9.getStatus()));
        l.a(r2, "crash_from", "app_exit_history");
        l.a(r2, "description", String.valueOf(r9.getDescription()));
        l.a(r2, "importance", String.valueOf(r9.getImportance()));
        l.a(r2, "pss", String.valueOf(r9.getPss()));
        l.a(r2, "rss", String.valueOf(r9.getRss()));
        JSONObject r11 = new JSONObject();
        r1.put(MonitorConstants.CUSTOM, r11);     // Catch: Throwable -> L39
    L35:
        l.a(r11, "app_info_description", r9.toString());
        String r12 = o.a(CrashType.JAVA, r0.b());
        ArrayList r13 = new ArrayList();
        r13.add(f7615c);
        com.bytedance.crash.upload.b.a(CrashType.JAVA.getName(), r12, r1.toString(), r13);
        return;
    L28:
        r10 = "false";
        goto L29
    L21:
        r4 = "false";
        goto L22
    L12:
        if (r3.contains("failed to read status response from tombstoned:") == false) goto L14;
        goto L13
    }

    private static void c(ApplicationExitInfo r15) {
        if (c.a() == true) goto L5;
        return;
    L5:
        Header r0 = Header.a(h.a(), r15.getTimestamp(), CrashType.ANR, r15.getPid());
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        l.a(r1, "header", r0.b());
        r1.put("filters", r2);     // Catch: Throwable -> L61
    L7:
        l.a(r1, "is_anr", 1);
        l.a(r1, "crash_time", Long.valueOf(r15.getTimestamp()));
        String r5 = "true";
        l.a(r1, "has_dump", "true");
        String r4 = r15.getDescription();
        if (TextUtils.isEmpty(r4) == false) goto L10;
        r4 = "invalid";
    L10:
        l.a(r1, "anr_info", r4);
        l.a(r1, "app_start_time", Long.valueOf(r15.getTimestamp()));
        l.a(r1, "jiffy", Long.valueOf(com.bytedance.crash.general.a.b()));
        JSONObject r6 = new JSONObject();
        l.a(r6, "thread_number", 1);
        l.a(r6, "mainStackFromTrace", "at ApplicationExit InvalidStack.NoStackAvailable(Invalid.java:1).\n");
        l.a(r6, "pid", Integer.valueOf(r15.getPid()));
        l.a(r6, "package", r15.getProcessName());
        l.a(r6, "invalid", false);
        l.a(r6, "is_new_stack", 10);
        l.a(r6, "not_current", 1);
        l.a(r6, "is_remote_process", 0);
        l.a(r1, "data", r6.toString());
        l.a(r2, "sdk_version", com.bytedance.crash.config.g.f7298a);
        if (NativeBridge.g() == false) goto L13;
        Object r7 = "true";
    L14:
        l.a(r2, "is_64_runtime", r7);
        String r8 = r0.b().optString(HardwareInfo.KEY_HW_CPU_ABI);
        if (TextUtils.isEmpty(r8) == true) goto L18;
        boolean r9 = r8.contains("64");
        l.a(r2, "is_x86_devices", Boolean.valueOf(r8.contains("86")));
        l.a(r2, "is_64_devices", Boolean.valueOf(r9));
    L18:
        if (com.bytedance.crash.general.a.c() == true) goto L21;
        r5 = "false";
    L21:
        l.a(r2, "is_root", r5);
        l.a(r2, RomInfo.KEY_ROM_KERNEL_VERSION, r0.b().optString(RomInfo.KEY_ROM_KERNEL_VERSION));
        l.a(r2, "is_hm_os", String.valueOf(u.a()));
        l.a(r2, "exit_reason", String.valueOf(r15.getReason()));
        l.a(r2, "exit_status", String.valueOf(r15.getStatus()));
        l.a(r2, "crash_from", "app_exit_history");
        l.a(r2, "description", String.valueOf(r15.getDescription()));
        l.a(r2, "importance", String.valueOf(r15.getImportance()));
        l.a(r2, "pss", String.valueOf(r15.getPss()));
        l.a(r2, "rss", String.valueOf(r15.getRss()));
        JSONObject r10 = new JSONObject();
        r1.put(MonitorConstants.CUSTOM, r10);     // Catch: Throwable -> L62
    L23:
        String r11 = r15.getDescription();
        if (r11 == null) goto L55;
        l.a(r2, "description", r11);
        l.a(r10, "description", r11);
        if (r11.contains("bg anr") == false) goto L28;
        l.a(r1, "is_background", true);
    L30:
        if (r11.contains("Input dispatching timed out") == false) goto L40;
        l.a(r2, "anr_reason", "Input dispatching timed out");
        int r12 = r11.indexOf("Activity");
        int r13 = r12;
    L32:
        if (r13 <= 0) goto L37;
        if ('/' == r11.charAt(r13)) goto L37;
        r13 = r13 - 1;
    L37:
        if (r12 == r13) goto L55;
        String r3 = r11.substring(r13 + 1, r12) + "Activity";
        l.a(r2, "last_resume_activity", r3);
        l.a(r2, "anr_tag", r3);
        goto L55
    L40:
        if (r11.contains("executing service") == false) goto L50;
        l.a(r2, "anr_reason", "executing service");
        int r14 = r11.indexOf("Service");
        int r16 = r14;
    L42:
        if (r16 <= 0) goto L47;
        if ('/' == r11.charAt(r16)) goto L47;
        r16 = r16 - 1;
    L47:
        if (r14 == r16) goto L55;
        l.a(r2, "anr_tag", r11.substring(r16 + 1, r14) + "Service");
        goto L55
    L50:
        if (r11.contains("Broadcast of Intent") == false) goto L55;
        l.a(r2, "anr_reason", "Broadcast of Intent");
        int r17 = r11.indexOf("{");
        int r18 = r11.indexOf("}");
        if (r17 == (-1)) goto L55;
        if (r18 == (-1)) goto L55;
        l.a(r2, "anr_tag", r11.substring(r17 + 1, r18).trim());
        goto L55
    L28:
        l.a(r1, "is_background", false);
    L55:
        l.a(r10, "importance", String.valueOf(r15.getImportance()));
        l.a(r10, "pss", String.valueOf(r15.getPss()));
        l.a(r10, "rss", String.valueOf(r15.getRss()));
        l.a(r10, "app_info_description", r15.toString());
        String r19 = null;
        r19 = a(r15.getTraceInputStream());     // Catch: Throwable -> L63
    L57:
        if (r19 == null) goto L59;
        l.a(r10, "anr_trace_description", r19);
    L59:
        String r110 = o.a(CrashType.ANR, r0.b());
        ArrayList r20 = new ArrayList();
        r20.add(f7615c);
        com.bytedance.crash.upload.b.a(CrashType.ANR.getName(), r110, r1.toString(), r20);
        return;
    L13:
        r7 = "false";
        goto L14
    }

    public static void c() {
        if (g() == true) goto L6;
        return;
    L6:
        if (f7617e == false) goto L8;
        return;
    L8:
        f7617e = true;
        if (f7615c != null) goto L12;
        f7615c = new File(i.d(), "crash_exit_history");
    L12:
        if (f7615c.exists() == true) goto L15;
        f7615c.mkdirs();
    L15:
        if (f7616d != null) goto L18;
        f7616d = new File(f7615c, "history_crash_list");
    L18:
        if (f7616d.exists() == true) goto L21;
        f7616d.mkdirs();
        return;
    }

    public static String d() {
        c();
        File r0 = f7616d;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getAbsolutePath();
    }

    public static String a(InputStream r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        BufferedInputStream r1 = null;
        BufferedInputStream r2 = new BufferedInputStream(r8);     // Catch: Throwable -> L23
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L16
        byte[] r4 = new byte[8192];     // Catch: Throwable -> L16
    L8:
        int r6 = r2.read(r4, 0, 8192);     // Catch: Throwable -> L16
        if (r6 <= 0) goto L10;
        r3.append(new String(r4, 0, r6));     // Catch: Throwable -> L16
        goto L8
    L10:
        String r0 = r3.toString();     // Catch: Throwable -> L16
        r8.close();     // Catch: Throwable -> L21
    L32:
        r2.close();     // Catch: Throwable -> L22
    L13:
        return r0;
    L16:
        r1 = r2;
    L30:
        r8.close();     // Catch: Throwable -> L24
    L18:
        if (r1 != null) goto L34;
    L20:
        return "";
    L34:
        r1.close();     // Catch: Throwable -> L25
        goto L20
    }

    private static boolean g() {
        if (f7614b == true) goto L5;
        return false;
    L5:
        return c.a();
    }

    public static long a(String r0, long r1) {
        return Long.decode(r0).longValue();
    L4:
        return r1;
    }

    private static CrashType a(int r1) {
        if (r1 != 6) goto L7;
        return CrashType.ANR;
    L7:
        if (r1 != 5) goto L11;
        return CrashType.NATIVE;
    L11:
        if (r1 != 4) goto L15;
        return CrashType.JAVA;
    L15:
        return CrashType.UNKNOWN;
    }
}
