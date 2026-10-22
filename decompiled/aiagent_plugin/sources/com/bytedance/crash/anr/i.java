package com.bytedance.crash.anr;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.dumper.m;
import com.bytedance.crash.o.l;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnrTraceParser.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<c> f7236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f7238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f7239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f7240e;
    private final a f;
    private final File g;

    /* JADX INFO: compiled from: AnrTraceParser.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f7243c;

        public a() {
            this.f7241a = false;
            this.f7242b = false;
            this.f7243c = null;
        }

        public boolean a(String r4) {
            if (r4.startsWith("Dump cost time:") == false) goto L9;
            this.f7241a = true;
            int r0 = r4.indexOf(58);
            if (r0 == (-1)) goto L7;
            this.f7243c = b(r4.substring(r0 + 1).trim());
        L7:
            return true;
        L9:
            if (r4.startsWith("Dump crash") == false) goto L12;
            this.f7242b = true;
            return true;
        L12:
            return false;
        }

        private static String b(String r4) {
            long r0 = Long.parseLong(r4);     // Catch: Throwable -> L68
            if (r0 > 50) goto L7;
            return "0~50ms";
        L7:
            if (r0 > 100) goto L11;
            return "50~100ms";
        L11:
            if (r0 > 150) goto L15;
            return "100~150ms";
        L15:
            if (r0 > 200) goto L19;
            return "150~200ms";
        L19:
            if (r0 > 300) goto L23;
            return "200~300ms";
        L23:
            if (r0 > 400) goto L27;
            return "300~400ms";
        L27:
            if (r0 > 500) goto L31;
            return "400~500ms";
        L31:
            if (r0 > 700) goto L35;
            return "500~700ms";
        L35:
            if (r0 > 1000) goto L39;
            return "700~1000ms";
        L39:
            if (r0 > 1500) goto L43;
            return "1000~1500ms";
        L43:
            if (r0 > 2000) goto L47;
            return "1500~2000ms";
        L47:
            if (r0 > WsConstants.EXIT_DELAY_TIME) goto L51;
            return "2000~3000ms";
        L51:
            if (r0 > 4000) goto L55;
            return "3000~4000ms";
        L55:
            if (r0 > 5000) goto L59;
            return "4000~5000ms";
        L59:
            if (r0 > 7000) goto L63;
            return "5000~7000ms";
        L63:
            if (r0 > 10000) goto L66;
            return "7000~10000ms";
        L66:
            return "> 10000ms";
        L68:
            return OProtocolTextEffectTextView.EffectNameNone;
        }
    }

    /* JADX INFO: compiled from: AnrTraceParser.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f7247d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f7248e;
        private String f;

        public b() {
            this.f7247d = "Free memory ";
            this.f7248e = "Total memory ";
            this.f = "Max memory ";
        }

        public boolean a(String r7) {
            if (r7.startsWith(this.f7247d) == false) goto L9;
            long r2 = a(this.f7247d.length(), r7);
            if (r2 <= 0) goto L7;
            this.f7245b = r2;
        L7:
            return true;
        L9:
            if (r7.startsWith(this.f7248e) == false) goto L13;
            this.f7246c = a(this.f7248e.length(), r7);
            return true;
        L13:
            if (r7.startsWith(this.f) == false) goto L16;
            this.f7244a = a(this.f.length(), r7);
            return true;
        L16:
            return false;
        }

        private long a(int r3, String r4) {
            int r2 = 0;
        L4:
            if (r3 >= r4.length()) goto L11;
            char r0 = r4.charAt(r3);
            if (r0 < '0') goto L11;
            if (r0 > '9') goto L11;
            r2 = (r2 * 10) + (r0 - '0');
            r3 = r3 + 1;
        L11:
            return (r2 * 1024) * 1024;
        }
    }

    /* JADX INFO: compiled from: AnrTraceParser.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        JSONArray f7249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        HashMap<String, JSONArray> f7250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f7251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f7252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f7253e;
        private long f;
        private long g;
        private long h;
        private long i;
        private long j;
        private int k;
        private int l;
        private int m;
        private int n;
        private int o;
        private boolean p;
        private boolean q;
        private final ArrayList<String> r;

        static /* synthetic */ String a(c r0) {
            return r0.e();
        }

        static /* synthetic */ boolean b(c r0) {
            return r0.q;
        }

        static /* synthetic */ int c(c r0) {
            return r0.m;
        }

        static /* synthetic */ String d(c r0) {
            return r0.f7251c;
        }

        static /* synthetic */ long e(c r2) {
            return r2.i;
        }

        static /* synthetic */ long f(c r2) {
            return r2.j;
        }

        static /* synthetic */ String g(c r0) {
            return r0.f7253e;
        }

        static /* synthetic */ boolean h(c r0) {
            return r0.p;
        }

        static /* synthetic */ ArrayList i(c r0) {
            return r0.r;
        }

        static /* synthetic */ boolean j(c r0) {
            return r0.f();
        }

        static /* synthetic */ int k(c r0) {
            return r0.l;
        }

        c(ArrayList<String> r2, HashMap<String, JSONArray> r3) {
            this.f7249a = null;
            this.f7250b = null;
            this.r = r2;
            this.f7250b = r3;
        }

        long a() {
            return this.i;
        }

        long b() {
            return this.j;
        }

        boolean c() {
            if (this.f7253e.equals("TimedWaiting") == false) goto L5;
        L10:
            return true;
        L5:
            if (this.f7253e.equals("Waiting") == true) goto L10;
            if (this.f7253e.equals("Blocked") == true) goto L10;
            return false;
        }

        boolean d() {
            if (this.f7253e.equals("Native") == false) goto L20;
            int r0 = this.o;
        L6:
            if (r0 >= this.r.size()) goto L29;
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.r.get(r0), String.class, "com.obric.aiagent.plugin");
            if (r1.startsWith("  at") == true) goto L10;
            if (r1.startsWith("  native: #") == false) goto L19;
            if (r1.contains("__futex_wait_ex") == true) goto L28;
            if (r1.startsWith("talkWithDriver") == false) goto L19;
            return true;
        L28:
            return true;
        L19:
            r0 = r0 + 1;
            goto L6
        L10:
            return r1.contains("BinderProxy.transactNative");
        L29:
            return false;
        L20:
            return false;
        }

        private String e() {
            StringBuilder r0 = new StringBuilder();
            Iterator<String> r4 = this.r.iterator();
        L4:
            if (r4.hasNext() == false) goto L7;
            r0.append((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin")).append('\n');
            goto L4
        L7:
            return r0.toString();
        }

        private boolean a(String r6) {
            Pattern r0 = Pattern.compile("^\"(.*)\"(?: daemon)? prio=-?\\d+ (.*)$");
            Pattern r1 = Pattern.compile("tid=(\\d+) ([a-zA-Z]+)$");
            Matcher r7 = r0.matcher(r6);
            if (r7.find() == true) goto L5;
        L16:
            return false;
        L5:
            if (r7.groupCount() != 2) goto L16;
            this.f7251c = r7.group(1);
            String r8 = r7.group(2);
            Matcher r2 = r1.matcher(r8);
            if (r2.find() == false) goto L13;
            if (r2.groupCount() != 2) goto L13;
            this.k = Integer.parseInt(r2.group(1));
            this.f7253e = r2.group(2);
            this.p = true;
        L15:
            return true;
        L13:
            if ("(not attached)".equals(r8) == false) goto L16;
            this.p = false;
            goto L15
        }

        private boolean b(String r1) {
            return r1.startsWith("  | group=");
        }

        private boolean c(String r4) {
            Matcher r5 = Pattern.compile("^  \\| sysTid=(\\d+) nice=(-?)(\\d+) .*$").matcher(r4);
            if (r5.find() == true) goto L5;
            return false;
        L5:
            if (r5.groupCount() != 3) goto L16;
            this.l = Integer.parseInt(r5.group(1));
            this.m = Integer.parseInt(r5.group(3));
            if ("-".equals(r5.group(2)) == false) goto L10;
            this.m *= -1;
        L10:
            HashMap<String, JSONArray> r1 = this.f7250b;
            if (r1 == null) goto L13;
            this.f7249a = (JSONArray) ZeusTransformUtils.preCheckCast(r1.get(r5.group(1)), JSONArray.class, "com.obric.aiagent.plugin");
        L13:
            return true;
        L16:
            return false;
        }

        private boolean d(String r7) {
            Matcher r8 = Pattern.compile("^  \\| state=([A-Z?]) schedstat=\\((.*)\\) utm=(\\d+) stm=(\\d+) core=(\\d+) HZ=\\d+$").matcher(r7);
            if (r8.find() == true) goto L5;
        L13:
            return false;
        L5:
            if (r8.groupCount() != 5) goto L13;
            this.f7252d = r8.group(1);
            this.i = Long.parseLong(r8.group(3));
            this.j = Long.parseLong(r8.group(4));
            this.n = Integer.parseInt(r8.group(5));
            String r9 = r8.group(2);
            if (r9 == null) goto L12;
            String[] r10 = r9.trim().split(" ");
            if (r10.length != 3) goto L12;
            this.f = Long.parseLong(r10[0]);
            this.g = Long.parseLong(r10[1]);
            this.h = Long.parseLong(r10[2]);
        L12:
            return true;
        }

        private boolean e(String r1) {
            return r1.startsWith("  | stack=");
        }

        private boolean f(String r1) {
            return r1.startsWith("  | held mutexes=");
        }

        private int a(ArrayList<String> r5, int r6) {
            if (r6 < r5.size()) goto L5;
            return 0;
        L5:
            String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get(r6), String.class, "com.obric.aiagent.plugin");
            if (this.f7249a != null) goto L8;
            return 0;
        L8:
            if (r7.contains("Unwind failed for thread") == false) goto L21;
            this.q = true;
            this.r.remove(r6);     // Catch: Throwable -> L16
            int r8 = 0;
        L12:
            if (r8 >= this.f7249a.length()) goto L14;
            this.r.add(r6, this.f7249a.getString(r8));     // Catch: Throwable -> L16
            r8 = r8 + 1;     // Catch: Throwable -> L16
            r6 = r6 + 1;     // Catch: Throwable -> L16
            goto L12
        L14:
            return this.f7249a.length();
        L22:
            return 0;
        L21:
            return 0;
        }

        private boolean f() {
            if (this.r.size() > 5) goto L6;
            return false;
        L6:
            if (a((String) ZeusTransformUtils.preCheckCast(this.r.get(0), String.class, "com.obric.aiagent.plugin")) == true) goto L9;
            return false;
        L9:
            if (this.p == false) goto L13;
            int r4 = 2;
            if (b((String) ZeusTransformUtils.preCheckCast(this.r.get(1), String.class, "com.obric.aiagent.plugin")) == true) goto L14;
            return false;
        L14:
            int r5 = r4 + 1;
            if (c((String) ZeusTransformUtils.preCheckCast(this.r.get(r4), String.class, "com.obric.aiagent.plugin")) == true) goto L17;
            return false;
        L17:
            int r6 = r5 + 1;
            if (d((String) ZeusTransformUtils.preCheckCast(this.r.get(r5), String.class, "com.obric.aiagent.plugin")) == true) goto L21;
            return false;
        L21:
            if (this.p == false) goto L27;
            int r7 = r6 + 1;
            if (e((String) ZeusTransformUtils.preCheckCast(this.r.get(r6), String.class, "com.obric.aiagent.plugin")) == true) goto L25;
            return false;
        L25:
            r6 = r7;
        L27:
            if (this.p == true) goto L29;
        L31:
            this.o = r6 + a(this.r, r6);
            return true;
        L29:
            if (f((String) ZeusTransformUtils.preCheckCast(this.r.get(r6), String.class, "com.obric.aiagent.plugin")) == false) goto L31;
            r6 = r6 + 1;
            goto L31
        L13:
            r4 = 1;
            goto L14
        }
    }

    static File a(File r2) {
        return new File(r2, "trace.txt");
    }

    i(File r6, int r7) {
        ArrayList<c> r0 = new ArrayList();
        this.g = new File(r6, "trace_by_child.txt");
        a r1 = new a();
        b r2 = new b();
        c r8 = a(r6, r7, r0, r2, r1);
        int r3 = r0.size();
        if (r8 == null) goto L5;
        int r4 = 1;
    L6:
        this.f7237b = r3 + r4;
        this.f7238c = r8;
        this.f7236a = r0;
        this.f7240e = r2;
        this.f = r1;
        this.f7239d = r6;
        return;
    L5:
        r4 = 0;
        goto L6
    }

    boolean a() {
        if (this.f7238c == null) goto L5;
        return true;
    L5:
        return false;
    }

    String b() {
        c r0 = this.f7238c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return c.a(r0);
    }

    private static HashMap<String, JSONArray> b(File r4) {
        BufferedReader r0 = null;
        JSONArray r1 = null;
        if (r4 != null) goto L5;
    L26:
        return null;
    L5:
        if (r4.exists() == false) goto L26;
        HashMap<String, JSONArray> r2 = new HashMap();
        BufferedReader r3 = new BufferedReader(new FileReader(r4));     // Catch: Throwable -> L27
    L28:
        String r5 = r3.readLine();     // Catch: Throwable -> L23
        if (r5 == null) goto L22;
        if (TextUtils.isEmpty(r5) == true) goto L28;
        if (r5.contains("sysTid") == true) goto L16;
        if (r1 == null) goto L28;
        String r6 = r5.trim();     // Catch: Throwable -> L23
        if (r6.startsWith("#") == false) goto L28;
        r1.put(r6);     // Catch: Throwable -> L23
        goto L28
    L16:
        String r7 = r5.substring(r5.indexOf(61) + 1);     // Catch: Throwable -> L23
        r1 = new JSONArray();     // Catch: Throwable -> L23
        r1.put("backtrace: \n");     // Catch: Throwable -> L23
        r2.put(r7, r1);     // Catch: Throwable -> L23
        goto L28
    L22:
        com.bytedance.crash.o.i.a(r3);
    L25:
        return r2;
    L23:
        r0 = r3;
    L24:
        com.bytedance.crash.o.i.a(r0);
        goto L25
    }

    void a(JSONObject r6) {
        l.a(r6, "all_thread_stacks", i());
        l.a(r6, "main_thread_cpu_tick", Long.valueOf(d() + c()));
        com.bytedance.crash.dumper.b.a(r6, a(this.f7239d));
        if (r6.optJSONObject("app_memory_info") == null) goto L6;
        return;
    L6:
        if (this.f7240e.f7244a <= 0) goto L13;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L9
        r6.put("app_memory_info", r1);     // Catch: Throwable -> L9
        r1.put("max_memory", this.f7240e.f7244a);     // Catch: Throwable -> L9
        r1.put("free_memory", this.f7240e.f7245b);     // Catch: Throwable -> L9
        r1.put("total_memory", this.f7240e.f7246c);     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    void a(JSONObject r18, JSONObject r19) {
        if (this.f7236a.isEmpty() == true) goto L5;
        l.a(r19, "anr_replace_mainstack", "OnlyJavaStack");
    L5:
        c r3 = this.f7238c;
        boolean r4 = false;
        if (r3 == null) goto L8;
        boolean r2 = c.b(r3);
        int r5 = c.c(this.f7238c);
    L9:
        long[] r6 = {0, 0, 0};
        Iterator<c> r7 = this.f7236a.iterator();
        String r8 = SensitiveType.UNKNOWN;
        int r10 = 0;
        String r9 = SensitiveType.UNKNOWN;
        String r11 = r9;
    L11:
        if (r7.hasNext() == false) goto L29;
        c r12 = (c) ZeusTransformUtils.preCheckCast(r7.next(), c.class, "com.obric.aiagent.plugin");
        if ("RenderThread".equals(c.d(r12)) == false) goto L16;
        l.a(r19, "anr_renderthread_nice", Integer.valueOf(c.c(r12)));
    L20:
        r2 = r2 | c.b(r12);
        if (c.e(r12) <= r6[0]) goto L24;
        r6[0] = c.e(r12);
        r8 = c.d(r12);
    L24:
        if (c.f(r12) <= r6[1]) goto L27;
        r6[1] = c.f(r12);
        r9 = c.d(r12);
    L27:
        if ((c.e(r12) + c.f(r12)) <= r6[2]) goto L11;
        r6[2] = c.e(r12) + c.f(r12);
        r11 = c.d(r12);
        goto L11
    L16:
        if (c.c(r12) >= r5) goto L20;
        if (c.c(r12) > (-16)) goto L20;
        r10 = r10 + 1;
        goto L20
    L29:
        l.a(r19, "anr_trace_has_mainstack", Boolean.valueOf(a()));
        l.a(r19, "anr_trace_cost_time", this.f.f7243c);
        l.a(r19, "anr_trace_crash", Boolean.valueOf(this.f.f7242b));
        if (this.f.f7241a == true) goto L32;
    L36:
        l.a(r19, "anr_trace_done", Boolean.valueOf(r4));
        l.a(r19, "anr_trace_thread_count", m.a(this.f7236a.size() + 1));
        l.a(r19, "max_utm_thread", r8);
        l.a(r19, "max_stm_thread", r9);
        l.a(r19, "max_utm_stm_thread", r11);
        l.a(r19, "anr_backup_native_stack", Boolean.valueOf(r2));
        l.a(r19, "anr_subthread_count_nice<=-16", Integer.valueOf(r10));
        l.a(r19, "npth_is_wait_for_gc", Boolean.valueOf(h()));
        com.bytedance.crash.entity.b.a(r19, r18);
        File r13 = this.g;
        if (r13 != null) goto L39;
    L46:
        l.a(r19, "anr_dump_async", "false");
        return;
    L39:
        if (r13.exists() == false) goto L46;
        if (this.g.length() <= 1024) goto L44;
        l.a(r19, "anr_dump_async", "success");
    L45:
        this.g.delete();
        return;
    L44:
        l.a(r19, "anr_dump_async", "fail");
        goto L45
    L32:
        if (this.f7238c == null) goto L36;
        if (this.f7236a.isEmpty() == true) goto L36;
        r4 = true;
        goto L36
    L8:
        r5 = -10;
        r2 = false;
        goto L9
    }

    long c() {
        c r2 = this.f7238c;
        if (r2 != null) goto L5;
        return -1;
    L5:
        return r2.a();
    }

    long d() {
        c r2 = this.f7238c;
        if (r2 != null) goto L5;
        return -1;
    L5:
        return r2.b();
    }

    boolean e() {
        c r0 = this.f7238c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c() == false) goto L7;
        return true;
    }

    boolean f() {
        c r0 = this.f7238c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d() == false) goto L7;
        return true;
    }

    boolean g() {
        c r1 = this.f7238c;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if ("WaitingPerformingGc".equals(c.g(r1)) == false) goto L7;
        return true;
    }

    boolean h() {
        c r0 = this.f7238c;
        if (r0 != null) goto L5;
    L7:
        Iterator<c> r8 = this.f7236a.iterator();
        int r3 = 0;
        int r4 = 0;
    L9:
        if (r8.hasNext() == false) goto L17;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r8.next(), c.class, "com.obric.aiagent.plugin");
        if (c.h(r5) == false) goto L9;
        if ("WaitingForGcToComplete".equals(c.g(r5)) == false) goto L15;
        r3 = r3 + 1;
    L15:
        r4 = r4 + 1;
        goto L9
    L17:
        if (r3 < 5) goto L19;
        return true;
    L19:
        if ((r3 * 4) <= r4) goto L22;
        return true;
    L22:
        return false;
    L5:
        if ("WaitingForGcToComplete".equals(c.g(r0)) == false) goto L7;
        return true;
    }

    private JSONObject i() {
        JSONArray r0 = new JSONArray();
        Iterator<c> r1 = this.f7236a.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.aiagent.plugin");
        JSONArray r3 = new JSONArray();
        JSONObject r4 = new JSONObject();
        int r5 = 1;
    L18:
        if (r5 >= c.i(r2).size()) goto L9;
        r3.put(c.i(r2).get(r5));     // Catch: JSONException -> L14
        r5 = r5 + 1;     // Catch: JSONException -> L14
        goto L18
    L9:
        r4.put("thread_name", c.i(r2).get(0));     // Catch: JSONException -> L14
        r4.put("thread_stack", r3);     // Catch: JSONException -> L14
        r0.put(r4);     // Catch: JSONException -> L14
        goto L4
    L11:
        JSONObject r6 = new JSONObject();
        r6.put("thread_stacks", r0);     // Catch: JSONException -> L15
        r6.put("thread_all_count", this.f7237b);     // Catch: JSONException -> L15
    L13:
        return r6;
    }

    public static c a(File r5, int r6, ArrayList<c> r7, b r8, a r9) {
        File r0 = a(r5);
        c r2 = null;
        if (r0.exists() == true) goto L5;
    L42:
        return r2;
    L5:
        if (r0.isDirectory() == true) goto L42;
        HashMap<String, JSONArray> r10 = b(new File(r5, "trace_by_child.txt"));
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream(r0)));
    L47:
        String r3 = r1.readLine();     // Catch: Throwable -> L43
        if (r3 == null) goto L41;
        if (r3.isEmpty() == true) goto L47;
        if (r9 == null) goto L19;
        if (r9.a(r3) == true) goto L47;
    L19:
        if (r8 == null) goto L24;
        if (r8.a(r3) == true) goto L47;
    L24:
        if (r3.charAt(0) != '\"') goto L47;
        if (r3.contains(" prio=") == false) goto L47;
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L43
        r4.add(r3);     // Catch: Throwable -> L43
    L29:
        String r11 = r1.readLine();     // Catch: Throwable -> L43
        if (r11 == null) goto L34;
        if (r11.startsWith("  ") == false) goto L34;
        r4.add(r11);     // Catch: Throwable -> L43
    L34:
        c r12 = new c(r4, r10);     // Catch: Throwable -> L43
        if (c.j(r12) == false) goto L47;
        if (c.k(r12) == r6) goto L38;
        r7.add(r12);     // Catch: Throwable -> L43
        goto L47
    L38:
        r2 = r12;
    L41:
        com.bytedance.crash.o.i.a(r1);
        goto L42
    }
}
