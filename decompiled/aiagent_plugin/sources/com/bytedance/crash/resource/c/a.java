package com.bytedance.crash.resource.c;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.k;
import com.bytedance.crash.o.r;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeHeapTrackAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.crash.resource.b {
    private static a n;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private b m;

    /* JADX INFO: renamed from: com.bytedance.crash.resource.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativeHeapTrackAdapter.java */
    static class C0174a extends com.bytedance.crash.resource.b.a {
        public C0174a(com.bytedance.crash.monitor.a r1, File r2) {
            super(r1, r2);
        }

        private void b(File r18, com.bytedance.crash.resource.b.C0172b r19) {
            File r0 = new File(r18, "ht_so_list.txt");
            JSONArray r1 = new JSONArray();
            String[] r2 = j.c(r0.getAbsolutePath()).split("\n");     // Catch: Throwable -> L12
            int r3 = r2.length;     // Catch: Throwable -> L12
            int r4 = 0;
        L4:
            if (r4 >= r3) goto L10;
            String[] r5 = r2[r4].split("\\s+");     // Catch: Throwable -> L12
            if (r5.length < 6) goto L9;
            JSONObject r6 = new JSONObject();     // Catch: Throwable -> L12
            long r7 = Long.parseLong(r5[1]);     // Catch: Throwable -> L12
            long r9 = Long.parseLong(r5[2]);     // Catch: Throwable -> L12
            long r11 = Long.parseLong(r5[3]);     // Catch: Throwable -> L12
            long r13 = Long.parseLong(r5[4]);     // Catch: Throwable -> L12
            r6.put("so_name", r5[5]);     // Catch: Throwable -> L12
            r6.put("vm_size", Long.parseLong(r5[1]));     // Catch: Throwable -> L12
            long r10 = r9 + r11;     // Catch: Throwable -> L12
            r6.put("rss", r10);     // Catch: Throwable -> L12
            r6.put("avg_vm", r7 / r13);     // Catch: Throwable -> L12
            r6.put("avg_rss", r10 / r13);     // Catch: Throwable -> L12
            r1.put(r6);     // Catch: Throwable -> L12
        L9:
            r4 = r4 + 1;     // Catch: Throwable -> L12
            r3 = r3;
            goto L4
        L10:
            r19.j.put("leak_so_list", r1);     // Catch: Throwable -> L12
            return;
        }

        private void c(File r4, com.bytedance.crash.resource.b.C0172b r5) {
            File r3 = new File(r4, "process_track.txt");     // Catch: Throwable -> L26
            Map<String, String> r6 = r5.i;     // Catch: Throwable -> L26
            if (r3.exists() == false) goto L24;
            BufferedReader r7 = null;
            String r8 = null;
            r6.put("has_process_track", "true");     // Catch: Throwable -> L21
            BufferedReader r0 = new BufferedReader(new FileReader(r3));     // Catch: Throwable -> L21
        L30:
            String r9 = r0.readLine();     // Catch: Throwable -> L19
            if (r9 == null) goto L12;
            if (r9.contains("onResume") == false) goto L30;
            r8 = r9;
            goto L30
        L12:
            if (r8 == null) goto L18;
            String[] r10 = r8.split(" ", 3);     // Catch: Throwable -> L19
            if (r10.length <= 1) goto L18;
            String r11 = r10[1];     // Catch: Throwable -> L19
            int r12 = r11.indexOf(".onResume");     // Catch: Throwable -> L19
            if (r12 <= 0) goto L18;
            r6.put(DBHelper.BATTERY_COL_SCENE, r11.substring(0, r12));     // Catch: Throwable -> L19
        L18:
            k.a(r0);     // Catch: Throwable -> L26
            return;
        L19:
            th = th;
            r7 = r0;
        L22:
            k.a(r7);     // Catch: Throwable -> L26
            throw th;     // Catch: Throwable -> L26
        L21:
            th = th;
            goto L22
        L24:
            r6.put("has_process_track", "false");     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            com.bytedance.crash.c.b.c("parseProcessTrack", th);
        }

        @Override // com.bytedance.crash.resource.b.a
        public boolean a(File r21, com.bytedance.crash.resource.b.C0172b r22) {
            boolean r6 = false;
            if (r21 != null) goto L6;
            r.c("NativeHeapTracker: ", "parseReport dir is null");
            return false;
        L6:
            b(r21, r22);
            c(r21, r22);
            String r0 = "";
            JSONArray r7 = j.b(new File(r21, "tombstone.txt").getAbsolutePath());     // Catch: Throwable -> L102 IOException -> L104
            if (r7 != null) goto L10;
            return false;
        L10:
            int r8 = a(r7, 0, "pid:");     // Catch: Throwable -> L102 IOException -> L104
            if (r8 >= 0) goto L13;
            return false;
        L13:
            String r9 = null;
            String[] r10 = r7.optString(r8, null).trim().split("\\s");     // Catch: Throwable -> L102 IOException -> L104
            int r11 = 0;
        L14:
            int r13 = 1;
            if (r11 >= r10.length) goto L26;
            String r12 = r10[r11];     // Catch: Throwable -> L102 IOException -> L104
            if ("pid:".equals(r12) == false) goto L20;
            int r14 = r11 + 1;     // Catch: Throwable -> L102 IOException -> L104
            r22.f = Long.decode(r10[r14].substring(0, r10[r14].length() - 1)).longValue();     // Catch: Throwable -> L102 IOException -> L104
        L25:
            r11 = r11 + 1;     // Catch: Throwable -> L102 IOException -> L104
            goto L14
        L20:
            if ("tid:".equals(r12) == false) goto L23;
            int r15 = r11 + 1;     // Catch: Throwable -> L102 IOException -> L104
            r22.g = Long.decode(r10[r15].substring(0, r10[r15].length() - 1)).longValue();     // Catch: Throwable -> L102 IOException -> L104
            goto L25
        L23:
            if ("name:".equals(r12) == false) goto L25;
            int r16 = r11 + 1;     // Catch: Throwable -> L102 IOException -> L104
            r22.f7707c = r10[r16].substring(0, r10[r16].length() - 1);     // Catch: Throwable -> L102 IOException -> L104
            goto L25
        L26:
            r22.f7709e = r10[r10.length - 2];     // Catch: Throwable -> L102 IOException -> L104
            StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L102 IOException -> L104
            int r17 = a(r7, r8 + 1, "Signal ");     // Catch: Throwable -> L102 IOException -> L104
            if (r17 >= 0) goto L29;
            return false;
        L29:
            String r18 = r7.optString(r17, null);     // Catch: Throwable -> L102 IOException -> L104
            r5.append(r18).append('\n');     // Catch: Throwable -> L102 IOException -> L104
            if (r18.startsWith("Signal 6(SIGABRT)") == false) goto L36;
            Matcher r19 = Pattern.compile("Code -\\d+\\(([^\\)]+)\\)").matcher(r18);     // Catch: Throwable -> L106
            if (r19.find() == false) goto L36;
            r0 = r19.group(1);     // Catch: Throwable -> L106
        L36:
            int r20 = a(r7, r17 + 1, "Abort message:");     // Catch: Throwable -> L102 IOException -> L104
            if (r20 >= 0) goto L39;
            return false;
        L39:
            r22.f7708d = r7.optString(r20, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L102 IOException -> L104
            r5.append(r22.f7708d).append('\n');     // Catch: Throwable -> L102 IOException -> L104
        L60:
            String r3 = null;
            String r110 = null;
            String r111 = null;
        L61:
            String r112 = r111;
        L62:
            String r113 = r112;
        L63:
            String r2 = null;
        L65:
            int r23 = a(r7, r20 + 1, "backtrace:");     // Catch: Throwable -> L102 IOException -> L104
            if (r23 >= 0) goto L68;
            return false;
        L68:
            int r24 = r23 + 1;     // Catch: Throwable -> L102 IOException -> L104
        L69:
            if (r24 >= r7.length()) goto L75;
            String r114 = r7.optString(r24, null);     // Catch: Throwable -> L102 IOException -> L104
        L101:
            return false;
        L100:
            return false;
        L73:
            if (r114.startsWith("    #") == false) goto L75;
            r5.append(r114.trim()).append('\n');     // Catch: Throwable -> L100 IOException -> L101
            r24 = r24 + 1;     // Catch: Throwable -> L100 IOException -> L101
            r6 = false;
        L75:
            r22.f7706b = r5.toString();     // Catch: Throwable -> L100 IOException -> L101
            int r25 = a(r7, r24, "build id:");     // Catch: Throwable -> L100 IOException -> L101
            if (r25 <= 0) goto L97;
            int r26 = r25 + 1;     // Catch: Throwable -> L100 IOException -> L101
        L79:
            if (r26 >= r7.length()) goto L97;
            String r27 = r7.optString(r26, r9);     // Catch: Throwable -> L100 IOException -> L101
            if (r27.startsWith("    /") == false) goto L96;
            String[] r28 = r27.trim().split("\\s");     // Catch: Throwable -> L100 IOException -> L101
            if (r28.length < 3) goto L96;
        L122:
            r22.h.put(new JSONObject().put("lib_name", r28[0].substring(r28[0].lastIndexOf(47) + r13)).put("lib_uuid", a(r28[r28.length - r13].substring(0, r28[r28.length - r13].length() - r13))));     // Catch: Throwable -> L100 IOException -> L101
            goto L96
        L144:
            return false;
        L141:
            return false;
        L145:
            return false;
        L142:
            return false;
        L96:
            r26 = r26 + 1;     // Catch: Throwable -> L100 IOException -> L101
            r9 = null;
            r13 = 1;
        L97:
            r22.i.put("native_oom_lib", r110);     // Catch: Throwable -> L100 IOException -> L101
            r22.i.put("native_oom_size", r111);     // Catch: Throwable -> L100 IOException -> L101
            r22.i.put("native_oom_mem", r112);     // Catch: Throwable -> L100 IOException -> L101
            r22.i.put("native_oom_thread", r113);     // Catch: Throwable -> L100 IOException -> L101
            r22.i.put("native_oom_thread_size", r3);     // Catch: Throwable -> L100 IOException -> L101
            r22.i.put("native_oom_thread_mem", r2);     // Catch: Throwable -> L100 IOException -> L101
            r22.i.put("native_oom_sigcode", r0);     // Catch: Throwable -> L100 IOException -> L101
            return true;
        L42:
            if (r22.f7708d.startsWith("abort message:") == false) goto L59;
            Matcher r4 = Pattern.compile("abort message: (\\S+):(\\d+)MB\\((\\d+)MB (\\d+)MB\\), (\\S+)\\(\\d+\\):(\\d+)MB\\((\\d+)MB (\\d+)MB\\)").matcher(r22.f7708d);     // Catch: Throwable -> L60
            if (r4.find() == false) goto L59;
            r110 = r4.group(1);     // Catch: Throwable -> L60
            r111 = a(Long.decode(r4.group(2)).longValue());     // Catch: Throwable -> L58
            r112 = a(Long.decode(r4.group(3)).longValue() + Long.decode(r4.group(4)).longValue());     // Catch: Throwable -> L57
            r113 = r4.group(5);     // Catch: Throwable -> L56
            r3 = a(Long.decode(r4.group(6)).longValue());     // Catch: Throwable -> L55
            r2 = a(Long.decode(r4.group(7)).longValue() + Long.decode(r4.group(8)).longValue());     // Catch: Throwable -> L107
        L55:
            r3 = null;
        L56:
            r3 = null;
            r113 = null;
        L57:
            r3 = null;
            r112 = null;
        L58:
            r3 = null;
            r111 = null;
        L59:
            r2 = null;
            r3 = null;
            r110 = null;
            r111 = null;
            r112 = null;
            r113 = null;
        L105:
            return r6;
        L103:
            return r6;
        }

        @Override // com.bytedance.crash.resource.b.a
        public void a(Map<String, String> r5, com.bytedance.crash.resource.b.C0172b r6) {
            Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            super.a(r7, r6);
            String r0 = "true";
            r7.put("has_dump", "true");
            if (com.bytedance.crash.general.a.c() == false) goto L5;
            String r4 = "true";
        L6:
            r7.put("is_root", r4);
            if (r6.f7706b.isEmpty() == false) goto L10;
            r0 = "false";
        L10:
            r7.put("has_native_oom", r0);
            r7.put("native_oom_app", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName());
            r7.put("ht_allocator_type", NativeBridge.n());
            return;
        L5:
            r4 = "false";
            goto L6
        }
    }

    static {
    }

    public a() {
        this.i = false;
        this.j = false;
        this.k = true;
    }

    static /* synthetic */ int a(a r0) {
        return r0.h;
    }

    static /* synthetic */ int a(a r0, int r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ boolean b(a r0) {
        return r0.l;
    }

    static /* synthetic */ b c(a r0) {
        return r0.m;
    }

    static /* synthetic */ boolean d(a r0) {
        return r0.k;
    }

    static /* synthetic */ String e(a r0) {
        return r0.i();
    }

    static /* synthetic */ void f(a r0) {
        r0.k();
    }

    static /* synthetic */ void g(a r0) {
        r0.l();
    }

    static /* synthetic */ void h(a r0) {
        r0.m();
    }

    static /* synthetic */ com.bytedance.crash.resource.f.a i(a r0) {
        return r0.f7695e;
    }

    public static a f() {
        if (n != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (n != null) goto L9;
        n = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return n;
    }

    public static void a(b r1) {
        a r0 = f();
        r0.m = r1;
        r0.a(r1);
    }

    @Override // com.bytedance.crash.resource.b
    public boolean d() {
        this.h = 0;
        this.l = false;
        return true;
    }

    private String i() {
        switch(this.h) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return "[STATE_UNKNOWN]";
    L5:
        return "[STATE_EXIT]";
    L6:
        return "[STATE_TRACING]";
    L7:
        return "[STATE_WAIT]";
    L8:
        return "[STATE_TRACK]";
    L9:
        return "[STATE_OBSERV]";
    L10:
        return "[STATE_PREPARE]";
    L11:
        return "[STATE_INIT]";
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.crash.resource.c.a$1] */
    @Override // com.bytedance.crash.resource.b
    public void b() {
        if (this.i == false) goto L7;
        r.b("NativeHeapTracker: ", "execute() Already running!");
        return;
    L7:
        if (this.h == 0) goto L10;
        r.c("NativeHeapTracker: ", "execute() Invalide state " + i());
        return;
    L10:
        this.i = true;
        if (j() == 0) goto L13;
        return;
    L13:
        this.h = 1;
        if (this.j == false) goto L16;
        NativeResourceMonitor.b(1);
    L16:
        final String r1 = "NativeHeapTracker";
        new AnonymousClass1(this, r1).start();
    }

    private int j() {
        if (this.k == false) goto L5;
        r.b("NativeHeapTracker: ", "initNative");
    L5:
        int r3 = NativeResourceMonitor.a(0);
        if (r3 == 0) goto L8;
        r.b("NativeHeapTracker: ", "initNative failed ret:" + r3);
    L8:
        return r3;
    }

    private void k() {
        if (this.k == false) goto L5;
        r.b("NativeHeapTracker: ", "trackNative");
    L5:
        int r2 = NativeResourceMonitor.a(1);
        if (r2 == 0) goto L9;
        r.b("NativeHeapTracker: ", "trackNative ret=" + r2);
        this.l = true;
        return;
    }

    private void l() {
        if (this.k == false) goto L5;
        r.b("NativeHeapTracker: ", "waitNative");
    L5:
        int r0 = NativeResourceMonitor.a(2);
        if (r0 == 0) goto L9;
        r.b("NativeHeapTracker: ", "waitNative ret=" + r0);
        this.l = true;
        return;
    }

    public void g() {
        if (this.k == false) goto L5;
        r.b("NativeHeapTracker: ", "dumpNative");
    L5:
        int r0 = NativeResourceMonitor.a(3);
        if (r0 == 0) goto L8;
        r.b("NativeHeapTracker: ", "dumpNative ret=" + r0);
        this.l = true;
        return;
    L8:
        NativeResourceMonitor.b(this.f7692b);
        a(this.f7692b);
    }

    private static void a(String r5) {
        File r0 = com.bytedance.crash.tracker.b.a().c();     // Catch: Throwable -> L10
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.exists() == true) goto L7;
        return;
    L7:
        if (r0.length() <= 128) goto L17;
        j.b(r0, new File(r5, "process_track.txt"));     // Catch: Throwable -> L10
        return;
    L17:
        return;
    L10:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpActivityInfo", th);
    }

    public boolean h() {
        if (this.k == false) goto L5;
        r.b("NativeHeapTracker: ", "trying stopNative");
    L5:
        int r3 = NativeResourceMonitor.a(5);
        if (r3 == 0) goto L8;
        r.b("NativeHeapTracker: ", "stopNative ret =" + r3);
    L8:
        if (r3 != 0) goto L10;
        return true;
    L10:
        return false;
    }

    private void m() {
        if (this.k == false) goto L5;
        r.b("NativeHeapTracker: ", "exitNative");
    L5:
        int r0 = NativeResourceMonitor.a(4);
        if (r0 == 0) goto L9;
        r.b("NativeHeapTracker: ", "exitNative ret=" + r0);
        this.l = true;
        return;
    }

    public static void a(com.bytedance.crash.monitor.a r2) {
        new C0174a(r2, com.bytedance.crash.resource.f.b.b()).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r.c("NativeHeapTracker: ", "upload exception:" + th);
    }
}
