package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.text.TextUtils;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.r;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnrInfoParser.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f7192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f7193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    a f7194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f7195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f7196e;
    private String f;
    private int g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l;
    private final float[] m;

    /* JADX INFO: compiled from: AnrInfoParser.java */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f7198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f7199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f7200d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f7201e;
        long f;
        long g;
        String h;
        String i;
        boolean j;
        boolean k;
        double l;
        double m;
        double n;
        double o;
        double p;
        double q;
        ArrayList<c> r;
        double s;
        double t;
        double u;
        double v;
        double w;
        ArrayList<Double> x;
        final /* synthetic */ d y;

        a(d r2, String r3, int[] r4) {
            this.y = r2;
            this.r = new ArrayList();
            this.x = new ArrayList();
            this.f7197a = r3;
            boolean r5 = false;
            this.f7198b = r4[0];
            this.f7199c = r4[1];
            this.f7200d = r4[2];
            this.f7201e = r4[3];
            if (b() == true) goto L5;
        L7:
            this.k = r5;
            return;
        L5:
            if (c() == false) goto L7;
            r5 = true;
            goto L7
        }

        long a() {
            long r0 = 0;
            long r1 = com.bytedance.crash.o.d.a(this.h);     // Catch: Throwable -> L9
            if (this.j == false) goto L7;
            r0 = r1 + this.f;     // Catch: Throwable -> L9
        L10:
            goto L8
        L7:
            r0 = r1 - this.f;
        L8:
            return r0;
        }

        boolean b() {
            b r1 = new b(this.f7197a.substring(this.f7198b, this.f7199c));
            String r0 = r1.a("CPU usage from ", "ms");
            if (r0 != null) goto L5;
            return false;
        L5:
            String r2 = r1.a(" to ", "ms");
            if (r2 != null) goto L8;
            return false;
        L8:
            String r4 = r1.a(" ", " ");
            if (r4 != null) goto L11;
            return false;
        L11:
            String r5 = r1.a("(", " t");
            if (r5 != null) goto L14;
            return false;
        L14:
            String r3 = r1.a("o ", ")");
            if (r3 != null) goto L21;
            return false;
        L21:
            this.f = Long.parseLong(r0);     // Catch: Throwable -> L20
            this.g = Long.parseLong(r2);     // Catch: Throwable -> L20
            this.j = "ago".equals(r4);     // Catch: Throwable -> L20
            this.h = r5;     // Catch: Throwable -> L20
            this.i = r3;     // Catch: Throwable -> L20
            return true;
        L20:
            return false;
        }

        boolean c() {
            b r1 = new b(this.f7197a.substring(this.f7200d, this.f7201e));
            String r0 = r1.a(null, "% TOTAL:");
            if (r0 != null) goto L5;
            return false;
        L5:
            String r4 = r1.a(" ", "% user");
            if (r4 == null) goto L8;
            r1.b(2);
        L8:
            String r6 = r1.a(" ", "% kernel");
            if (r6 == null) goto L11;
            r1.b(2);
        L11:
            String r7 = r1.a(" ", "% iowait");
            if (r7 == null) goto L14;
            r1.b(2);
        L14:
            String r8 = r1.a(" ", "% irq");
            if (r8 == null) goto L17;
            r1.b(2);
        L17:
            String r3 = r1.a(" ", "% softirq");
            if (r3 != null) goto L44;
            r1.b(2);
        L44:
            this.l = Double.parseDouble(r0);     // Catch: Throwable -> L43
            double r2 = 0.0d;
            if (r4 != null) goto L23;
            double r5 = 0.0d;
        L24:
            this.m = r5;     // Catch: Throwable -> L43
            if (r6 != null) goto L27;
            double r9 = 0.0d;
        L28:
            this.n = r9;     // Catch: Throwable -> L43
            if (r7 != null) goto L31;
            double r10 = 0.0d;
        L32:
            this.o = r10;     // Catch: Throwable -> L43
            if (r8 != null) goto L35;
            double r11 = 0.0d;
        L36:
            this.p = r11;     // Catch: Throwable -> L43
            if (r3 == null) goto L40;
            r2 = Double.parseDouble(r3);     // Catch: Throwable -> L43
        L40:
            this.q = r2;     // Catch: Throwable -> L43
            return true;
        L35:
            r11 = Double.parseDouble(r8);     // Catch: Throwable -> L43
            goto L36
        L31:
            r10 = Double.parseDouble(r7);     // Catch: Throwable -> L43
            goto L32
        L27:
            r9 = Double.parseDouble(r6);     // Catch: Throwable -> L43
            goto L28
        L23:
            r5 = Double.parseDouble(r4);     // Catch: Throwable -> L43
        L43:
            return false;
        }

        void d() {
            int r0 = this.f7199c + 1;
        L4:
            if (r0 >= this.f7200d) goto L20;
            int r1 = this.f7197a.indexOf("\n", r0);
            if (r1 < 0) goto L32;
            if ((r1 - r0) > 4) goto L10;
        L11:
            c r2 = null;
            r2 = a(this.f7197a, r0, r1);     // Catch: Throwable -> L21
        L13:
            if (r2 == null) goto L4;
            if (r2.f7205b < 1.0d) goto L33;
            this.r.add(r2);
        L19:
            r0 = r1 + 1;
            goto L4
        L33:
            return;
        L10:
            if (this.f7197a.charAt(r0 + 2) == ' ') goto L19;
        L32:
            return;
        }

        c e() {
            if (this.r.size() != 0) goto L7;
            return null;
        L7:
            return (c) ZeusTransformUtils.preCheckCast(this.r.get(0), c.class, "com.obric.aiagent.plugin");
        }

        c f() {
            Iterator<c> r0 = this.r.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");
            if (r1.g != d.a(this.y)) goto L4;
            return r1;
        L8:
            return null;
        }

        void a(JSONObject r5) {
            r5.put("kswapd", this.s);     // Catch: Throwable -> L10
            r5.put("mmcqd", this.t);     // Catch: Throwable -> L10
            r5.put("kwork", this.u);     // Catch: Throwable -> L10
            r5.put("system_server", this.v);     // Catch: Throwable -> L10
            r5.put("lmkd", this.w);     // Catch: Throwable -> L10
            if (this.x.isEmpty() == true) goto L14;
            JSONArray r0 = new JSONArray();     // Catch: Throwable -> L10
            Iterator<Double> r4 = this.x.iterator();     // Catch: Throwable -> L10
        L6:
            if (r4.hasNext() == false) goto L8;
            r0.put((Double) ZeusTransformUtils.preCheckCast(r4.next(), Double.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
            goto L6
        L8:
            r5.put("dex2oat", r0);     // Catch: Throwable -> L10
            return;
        L14:
            return;
        }

        void a(JSONObject r6, JSONObject r7) {
            l.a(r6, "cpu_total", Double.valueOf(this.l));
            l.a(r6, "cpu_user", Double.valueOf(this.m));
            l.a(r6, "cpu_kernel", Double.valueOf(this.n));
            l.a(r6, "cpu_iowait", Double.valueOf(this.o));
            l.a(r6, "cpu_irq", Double.valueOf(this.p));
            l.a(r6, "cpu_softirq", Double.valueOf(this.q));
            c r0 = e();
            if (r0 == null) goto L5;
            l.a(r7, "top_cpu_process_name", r0.f7204a);
        L5:
            c r8 = f();
            if (r8 == null) goto L15;
            l.a(r6, "cpu_app_total", Double.valueOf(r8.f7205b));
            l.a(r6, "cpu_app_user", Double.valueOf(r8.f7206c));
            l.a(r6, "cpu_app_kernel", Double.valueOf(r8.f7207d));
            l.a(r6, "minor_rate", Long.valueOf(r8.f7208e));
            l.a(r6, "major_rate", Long.valueOf(r8.f));
        L15:
            r6.put("cpu_kswapd", this.s);     // Catch: Throwable -> L14
            r6.put("cpu_mmcqd", this.t);     // Catch: Throwable -> L14
            r6.put("cpu_kwork", this.u);     // Catch: Throwable -> L14
            r6.put("cpu_system_server", this.v);     // Catch: Throwable -> L14
            r6.put("cpu_lmkd", this.w);     // Catch: Throwable -> L14
            float r9 = 0.0f;
            Iterator<Double> r5 = this.x.iterator();     // Catch: Throwable -> L14
        L10:
            if (r5.hasNext() == false) goto L12;
            r9 = (float) (((double) r9) + ((Double) ZeusTransformUtils.preCheckCast(r5.next(), Double.class, "com.obric.aiagent.plugin")).doubleValue());     // Catch: Throwable -> L14
            goto L10
        L12:
            r6.put("cpu_dex2oat", r9);     // Catch: Throwable -> L14
            return;
        }

        void a(JSONObject r5, boolean r6) {
            if (r6 == false) goto L4;
            String r0 = "user";
        L37:
            r5.put(r0, this.m);     // Catch: Throwable -> L36
            if (r6 == false) goto L8;
            String r1 = "sys";
        L9:
            r5.put(r1, this.n);     // Catch: Throwable -> L36
            if (r6 == false) goto L12;
            String r2 = "iowait";
        L13:
            r5.put(r2, this.o);     // Catch: Throwable -> L36
            if (r6 == false) goto L16;
            String r3 = "irq";
        L17:
            r5.put(r3, this.p);     // Catch: Throwable -> L36
            if (r6 == false) goto L20;
            String r4 = "softirq";
        L21:
            r5.put(r4, this.q);     // Catch: Throwable -> L36
            c r7 = f();     // Catch: Throwable -> L36
            if (r7 == null) goto L31;
            if (r6 == false) goto L25;
            String r8 = "minor";
        L26:
            r5.put(r8, r7.f7208e);     // Catch: Throwable -> L36
            if (r6 == false) goto L29;
            String r9 = "major";
        L30:
            r5.put(r9, r7.f);     // Catch: Throwable -> L36
            goto L31
        L29:
            r9 = "major2";
            goto L30
        L25:
            r8 = "minor2";
        L31:
            if (r6 == false) goto L33;
            String r10 = "before_cpu_list";
        L34:
            r5.put(r10, g());     // Catch: Throwable -> L36
            return;
        L33:
            r10 = "after_cpu_list";
            goto L34
        L20:
            r4 = "softirq2";
            goto L21
        L16:
            r3 = "irq2";
            goto L17
        L12:
            r2 = "iowait2";
            goto L13
        L8:
            r1 = "sys2";
        L39:
            return;
        L4:
            r0 = "user2";
            goto L37
        }

        JSONObject g() {
            JSONObject r0 = new JSONObject();
            Iterator<c> r6 = this.r.iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            c r1 = (c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.aiagent.plugin");
            l.a(r0, String.valueOf(r1.g), l.a(l.a(new JSONObject(), "process_name", r1.f7204a), MonitorConstants.CPU, Double.valueOf(r1.f7205b)));
            goto L4
        L6:
            return r0;
        }

        c a(String r6, int r7, int r8) {
            int r9 = r7 + 2;
            int r0 = r6.indexOf(37, r9);
            c r1 = null;
            if (r0 < 0) goto L36;
            if (r0 > r8) goto L36;
            double r2 = Double.parseDouble(r6.substring(r9, r0));
            int r3 = r0 + 2;
            int r10 = r6.indexOf(47, r3);
            if (r10 < 0) goto L36;
            if (r10 > r8) goto L36;
            int r4 = Integer.parseInt(r6.substring(r3, r10));
            int r11 = r10 + 1;
            int r5 = r6.indexOf(": ", r11);
            if (r5 < 0) goto L36;
            if (r5 > r8) goto L36;
            r1 = new c(r4, r6.substring(r11, r5), r2);
            if (r4 != d.a(this.y)) goto L36;
            int r12 = r5 + 2;
            int r13 = r6.indexOf("% user + ", r12);
            if (r13 < 0) goto L36;
            if (r13 > r8) goto L36;
            r1.f7206c = Double.parseDouble(r6.substring(r12, r13));
            int r14 = r13 + 9;
            int r15 = r6.indexOf("% kernel", r14);
            if (r15 < 0) goto L36;
            if (r15 > r8) goto L36;
            r1.f7207d = Double.parseDouble(r6.substring(r14, r15));
            int r16 = r6.indexOf("faults: ", r15);
            if (r16 < 0) goto L36;
            if (r16 > r8) goto L36;
            int r17 = r16 + 8;
            int r18 = r6.indexOf(" minor", r17);
            if (r18 <= 0) goto L32;
            if (r18 >= r8) goto L32;
            r1.f7208e = Long.parseLong(r6.substring(r17, r18));
            r17 = r18 + 7;
        L32:
            int r19 = r6.indexOf(" major", r17);
            if (r19 <= 0) goto L36;
            if (r19 >= r8) goto L36;
            r1.f = Long.parseLong(r6.substring(r17, r19));
        L36:
            return r1;
        }

        void h() {
            Iterator<c> r0 = this.r.iterator();
        L4:
            if (r0.hasNext() == false) goto L23;
            c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");
            String r2 = r1.f7204a;
            double r3 = r1.f7205b;
            if (r2.contains("kworker") == true) goto L7;
            if (r2.contains("kswapd") == true) goto L10;
            if (r2.contains("mmcqd") == true) goto L13;
            if (r2.contains("system_server") == true) goto L16;
            if (r2.contains("lmkd") == true) goto L19;
            if (r2.contains("dex2oat") == false) goto L4;
            this.x.add(Double.valueOf(r3));
            goto L4
        L19:
            this.w += r3;
            goto L4
        L16:
            this.v += r3;
            goto L4
        L13:
            this.t += r3;
            goto L4
        L10:
            this.s += r3;
            goto L4
        L7:
            this.u += r3;
            goto L4
        }
    }

    /* JADX INFO: compiled from: AnrInfoParser.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f7203b;

        b(String r1) {
            this.f7202a = r1;
            this.f7203b = 0;
        }

        void a(int r1) {
            this.f7203b = r1;
        }

        int a() {
            return this.f7203b;
        }

        void b(int r2) {
            this.f7203b += r2;
        }

        String a(String r4, String r5) {
            int r0 = this.f7203b;
            if (r4 == null) goto L8;
            int r2 = this.f7202a.indexOf(r4, r0);
            if (r2 >= 0) goto L7;
            return null;
        L7:
            this.f7203b = r2 + r4.length();
        L8:
            if (r5 == null) goto L14;
            int r6 = this.f7202a.indexOf(r5, this.f7203b);
            if (r6 >= 0) goto L13;
            this.f7203b = r0;
            return null;
        L13:
            String r1 = this.f7202a.substring(this.f7203b, r6);
            this.f7203b = r6 + r5.length();
            return r1;
        L14:
            String r3 = this.f7202a.substring(this.f7203b);
            this.f7203b = this.f7202a.length() - 1;
            return r3;
        }
    }

    /* JADX INFO: compiled from: AnrInfoParser.java */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f7205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double f7206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double f7207d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f7208e;
        long f;
        int g;

        c(int r1, String r2, double r3) {
            this.g = r1;
            this.f7204a = r2;
            this.f7205b = r3;
        }
    }

    static String a() {
        return "anr_info.txt";
    }

    static /* synthetic */ int a(d r0) {
        return r0.g;
    }

    public d(String r2) {
        this.m = new float[]{-1.0f, -1.0f, -1.0f};
        this.f7195d = r2;
        this.f7196e = false;
        a(r2);
    }

    public d(File r5) {
        this.m = new float[]{-1.0f, -1.0f, -1.0f};
        String r0 = com.bytedance.crash.o.i.d(new File(r5, "anr_info.txt"));
        if (r0 != null) goto L5;
    L17:
        this.f7195d = r0;
        this.f7196e = !new File(r5, "from_external_flag").exists();
        return;
    L5:
        if (r0.isEmpty() == true) goto L17;
        if (r0.equals("silent anr no anr info") == false) goto L10;
        this.i = "silent anr";
    L16:
        this.j = h();
        goto L17
    L10:
        if (r0.equals("close anr_info report") == false) goto L12;
        this.i = "Not report anrInfo";
        goto L16
    L12:
        int r1 = a(r0);
        if (r1 >= 0) goto L15;
        r.c("NPTH", "Anr Info Parse Error:" + r1);
    L15:
        this.i = g();
        goto L16
    }

    static String a(ActivityManager.ProcessErrorStateInfo r3) {
        return "|------------- processErrorStateInfo--------------|\ncondition: " + r3.condition + "\nprocessName: " + r3.processName + "\npid: " + r3.pid + "\nuid: " + r3.uid + "\ntag: " + r3.tag + "\nshortMsg : " + r3.shortMsg + "\nlongMsg : " + r3.longMsg + "\n-----------------------end----------------------------";
    }

    private static boolean a(String r0, String r1) {
        if (r0 == null) goto L5;
        if (r1 == null) goto L5;
        return r0.equals(r1);
    L5:
        if (r0 != null) goto L8;
        if (r1 != null) goto L8;
        return true;
    L8:
        return false;
    }

    static boolean a(ActivityManager.ProcessErrorStateInfo r2, ActivityManager.ProcessErrorStateInfo r3) {
        if (r2.condition == r3.condition) goto L5;
    L17:
        return false;
    L5:
        if (r2.pid != r3.pid) goto L17;
        if (r2.uid != r3.uid) goto L17;
        if (a(r2.processName, r3.processName) == false) goto L17;
        if (a(r2.tag, r3.tag) == false) goto L17;
        if (a(r2.shortMsg, r3.shortMsg) == false) goto L17;
        if (a(r2.longMsg, r3.longMsg) == false) goto L17;
        return true;
    }

    String b() {
        return this.f7195d;
    }

    boolean c() {
        return !TextUtils.isEmpty(this.f7195d);
    }

    void a(JSONObject r8) {
        long r0 = e();
        long r3 = r8.optLong("crash_time");
        if (r0 > 0) goto L5;
    L7:
        l.a(r8, "anr_info", b());
        e(r8);
        c(r8);
        return;
    L5:
        if (r0 >= r3) goto L7;
        l.a(r8, "crash_time", Long.valueOf(r0));
        goto L7
    }

    int d() {
        return this.g;
    }

    long e() {
        a r2 = this.f7194c;
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.a();
    }

    int a(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return -1;
    L5:
        if (r9.startsWith("|------------- processErrorStateInfo--------------|\n") == true) goto L7;
        return -1;
    L7:
        if (r9.endsWith("-----------------------end----------------------------") == false) goto L102;
        b r1 = new b(r9);     // Catch: Throwable -> L83
        r1.a(52);     // Catch: Throwable -> L83
        if (r1.a("condition: ", "\n") != null) goto L13;
        return -2;
    L13:
        String r2 = r1.a("processName: ", "\n");     // Catch: Throwable -> L83
        if (r2 != null) goto L17;
        return -3;
    L17:
        this.f = r2;     // Catch: Throwable -> L83
        String r3 = r1.a("pid: ", "\n");     // Catch: Throwable -> L83
        if (r3 != null) goto L88;
        return -4;
    L88:
        this.g = Integer.parseInt(r3);     // Catch: Throwable -> L81
        if (r1.a("uid: ", "\n") != null) goto L26;
        return -6;
    L26:
        String r4 = r1.a("tag: ", "\n");     // Catch: Throwable -> L83
        if (r4 != null) goto L30;
        return -7;
    L30:
        this.j = r4;     // Catch: Throwable -> L83
        int r5 = r9.indexOf("shortMsg : ", r1.a());     // Catch: Throwable -> L83
        if (r5 >= 0) goto L34;
        return -8;
    L34:
        int r6 = r5 + 11;     // Catch: Throwable -> L83
        int r7 = r9.indexOf(10, r6);     // Catch: Throwable -> L83
        if (r7 >= 0) goto L38;
        return -9;
    L38:
        int r8 = r9.indexOf("longMsg : ", r7);     // Catch: Throwable -> L83
        if (r8 >= 0) goto L42;
        return -10;
    L42:
        this.k = r8 + 10;     // Catch: Throwable -> L83
        this.h = r9.substring(r6, r8 - 1);     // Catch: Throwable -> L83
        int r10 = r9.length() - 54;     // Catch: Throwable -> L83
        this.l = r10;     // Catch: Throwable -> L83
        if (r10 == 0) goto L71;
        int r11 = this.k;     // Catch: Throwable -> L83
    L46:
        if (r11 >= this.l) goto L61;
        int r12 = r9.indexOf("\n", r11);     // Catch: Throwable -> L83
        if (r12 < 0) goto L61;
        int[] r13 = a(r9, r11);     // Catch: Throwable -> L83
        if (r13 != null) goto L51;
        r11 = r12 + 1;     // Catch: Throwable -> L83
        goto L46
    L51:
        a r14 = new a(this, r9, r13);     // Catch: Throwable -> L83
        if (r14.k == true) goto L54;
    L59:
        r11 = r13[3] + 1;     // Catch: Throwable -> L83
        goto L46
    L54:
        if (this.f7192a != null) goto L57;
        this.f7192a = r14;     // Catch: Throwable -> L83
        r14.d();     // Catch: Throwable -> L83
        goto L59
    L57:
        if (this.f7193b != null) goto L59;
        this.f7193b = r14;     // Catch: Throwable -> L83
        r14.d();     // Catch: Throwable -> L83
    L61:
        a r15 = this.f7192a;     // Catch: Throwable -> L83
        this.f7194c = r15;     // Catch: Throwable -> L83
        if (this.f7193b != null) goto L64;
    L68:
        a r16 = this.f7194c;     // Catch: Throwable -> L83
        if (r16 == null) goto L71;
        r16.h();     // Catch: Throwable -> L83
        goto L71
    L64:
        if (r15.j == false) goto L68;
        if (Math.abs(this.f7194c.f + this.f7194c.g) <= Math.abs(this.f7193b.f + this.f7193b.g)) goto L68;
        this.f7194c = this.f7193b;     // Catch: Throwable -> L83
    L71:
        String r17 = r1.a("Load: ", "\n");     // Catch: Throwable -> L83
        if (r17 == null) goto L80;
        String[] r18 = r17.split("/");     // Catch: Throwable -> L83
        if (this.m.length != r18.length) goto L80;
        int r19 = 0;
    L76:
        if (r19 >= r18.length) goto L80;
        this.m[r19] = c(r18[r19].trim()).floatValue();     // Catch: Throwable -> L83
        r19 = r19 + 1;
    L80:
        return 0;
    L81:
        return -5;
    L83:
        th = move-exception;
        com.bytedance.crash.c.b.b("NPTH_ANR_ERROR", th);
        return -11;
    L102:
        return -1;
    }

    private static Float c(String r0) {
        return Float.valueOf(r0);
    L5:
        return Float.valueOf(-1.0f);
    }

    private static String a(float r10) {
        if (r10 >= 0.0f) goto L7;
        return "invalid";
    L7:
        if (r10 <= 100.0f) goto L11;
        return "> 100";
    L11:
        return new String[]{"0~10", "10~20", "20~30", "30~40", "40~50", "50~60", "60~70", "70~80", "80~90", "90~100"}[((int) r10) / 10];
    }

    private static String b(float r21) {
        if (r21 >= 0.0f) goto L6;
        return "invalid";
    L6:
        float[] r1 = {2000.0f, 3000.0f, 4000.0f, 5000.0f, 10000.0f, 20000.0f, 30000.0f, 40000.0f, 50000.0f, 60000.0f, 70000.0f, 80000.0f, 90000.0f, 100000.0f, 150000.0f, 200000.0f, 300000.0f, 400000.0f, 500000.0f};
        String[] r2 = {"0~2k", "2k~3k", "3k~4k", "4k~5k", "5k~1w", "1w~2w", "2w~3w", "3w~4w", "4w~5w", "5w~6w", "7w~8w", "8w~9w", "9w~10w", "10w~15w", "15w~20w", "20w~30w", "30w~40w", "40w~50w", "> 50w"};
        int r3 = 0;
    L7:
        if (r3 >= 19) goto L14;
        if (r21 <= r1[r3]) goto L11;
        r3 = r3 + 1;
        goto L7
    L11:
        return r2[r3];
    L14:
        return r2[18];
    }

    c a(a r2) {
        if (r2.r.size() != 0) goto L7;
        return null;
    L7:
        return (c) ZeusTransformUtils.preCheckCast(r2.r.get(0), c.class, "com.obric.aiagent.plugin");
    }

    c b(a r4) {
        Iterator<c> r5 = r4.r.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r5.next(), c.class, "com.obric.aiagent.plugin");
        if (r0.g != this.g) goto L4;
        return r0;
    L8:
        return null;
    }

    public void b(JSONObject r14) {
        r14.put("anr_tag", this.j);     // Catch: Throwable -> L37
        r14.put("anr_reason", this.i);     // Catch: Throwable -> L37
        r14.put("is_current_process", this.f7196e);     // Catch: Throwable -> L37
        r14.put("input_timeout_type", f());     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(this.f7195d) == false) goto L6;
    L8:
        r14.put("has_anrinfo", "false");     // Catch: Throwable -> L37
    L9:
        a r1 = this.f7192a;     // Catch: Throwable -> L37
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        r14.put("anr_has_ago", String.valueOf(r2));     // Catch: Throwable -> L37
        if (this.f7192a == null) goto L18;
        boolean r3 = true;
    L19:
        r14.put("success_end_anrinfo", String.valueOf(r3));     // Catch: Throwable -> L37
        r14.put("anr_cpu_load_1", a(this.m[0]));     // Catch: Throwable -> L37
        r14.put("anr_cpu_load_5", a(this.m[1]));     // Catch: Throwable -> L37
        r14.put("anr_cpu_load_15", a(this.m[2]));     // Catch: Throwable -> L37
        a r0 = this.f7192a;     // Catch: Throwable -> L37
        if (r0 == null) goto L29;
        r14.put("anr_cpu_total", a((float) r0.l));     // Catch: Throwable -> L37
        r14.put("anr_cpu_user", a((float) this.f7192a.m));     // Catch: Throwable -> L37
        r14.put("anr_cpu_kernel", a((float) this.f7192a.n));     // Catch: Throwable -> L37
        r14.put("anr_cpu_iowait", a((float) this.f7192a.o));     // Catch: Throwable -> L37
        c r4 = b(this.f7192a);     // Catch: Throwable -> L37
        if (r4 == null) goto L25;
        r14.put("anr_app_cpu_total", a((float) r4.f7205b));     // Catch: Throwable -> L37
        r14.put("anr_app_cpu_user", a((float) r4.f7206c));     // Catch: Throwable -> L37
        r14.put("anr_app_cpu_kernel", a((float) r4.f7207d));     // Catch: Throwable -> L37
        r14.put("anr_faults_minor", b(r4.f7208e));     // Catch: Throwable -> L37
        r14.put("anr_faults_major", b(r4.f));     // Catch: Throwable -> L37
    L25:
        c r13 = a(this.f7192a);     // Catch: Throwable -> L37
        if (r13 == null) goto L41;
        r14.put("anr_top_cpu_process", r13.f7204a);     // Catch: Throwable -> L37
        return;
    L41:
        return;
    L29:
        if (this.f7193b == null) goto L43;
        r14.put("anr_cpu_total", a((float) r0.l));     // Catch: Throwable -> L37
        r14.put("anr_cpu_user", a((float) this.f7192a.m));     // Catch: Throwable -> L37
        r14.put("anr_cpu_kernel", a((float) this.f7192a.n));     // Catch: Throwable -> L37
        r14.put("anr_cpu_iowait", a((float) this.f7192a.o));     // Catch: Throwable -> L37
        c r5 = b(this.f7193b);     // Catch: Throwable -> L37
        if (r5 == null) goto L33;
        r14.put("anr_app_cpu_total", a((float) r5.f7205b));     // Catch: Throwable -> L37
        r14.put("anr_app_cpu_user", a((float) r5.f7206c));     // Catch: Throwable -> L37
        r14.put("anr_app_cpu_kernel", a((float) r5.f7207d));     // Catch: Throwable -> L37
        r14.put("anr_faults_minor", b(r5.f7208e));     // Catch: Throwable -> L37
        r14.put("anr_faults_major", b(r5.f));     // Catch: Throwable -> L37
    L33:
        c r15 = a(this.f7192a);     // Catch: Throwable -> L37
        if (r15 == null) goto L44;
        r14.put("anr_top_cpu_process", r15.f7204a);     // Catch: Throwable -> L37
        return;
    L44:
        return;
    L43:
        return;
    L18:
        r3 = false;
        goto L19
    L12:
        if (r1.j == false) goto L14;
        r2 = true;
        goto L15
    L6:
        if (this.f7195d.equals("silent anr no anr info") == true) goto L8;
        r14.put("has_anrinfo", "true");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r.b(th);
    }

    public void c(JSONObject r11) {
        JSONObject r0 = l.a(r11, "features_str");
        JSONObject r1 = l.a(r11, "features_num");
        a r10 = this.f7194c;
        if (r10 == null) goto L5;
        r10.a(r1, r0);
    L5:
        JSONObject r12 = r11.optJSONObject("app_memory_info");
        if (r12 == null) goto L10;
        long r2 = r12.optLong("max_memory");
        long r4 = r12.optLong("free_memory");
        long r6 = r12.optLong("total_memory");
        if (r2 <= 0) goto L10;
        l.a(r1, "java_heap_usage", Long.valueOf(((r6 - r4) * 100) / r2));
    L10:
        JSONObject r13 = r11.optJSONObject("memory_info");
        if (r13 == null) goto L14;
        l.a(r1, "total_pss", Long.valueOf(r13.optLong("totalPss") / 1048576));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.crash.anr.d$a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.crash.anr.d$a] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.crash.anr.d$a] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.crash.anr.d] */
    /* JADX WARN: Type inference failed for: r5v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void e(JSONObject r5) {
        ?? r6 = l.a(r5, "anr_atribute");
        ?? r0 = new JSONObject();
        d(r0);     // Catch: Throwable -> L16
        ?? r1 = this.f7192a;     // Catch: Throwable -> L16
        if (r1 == 0) goto L6;
        r1.a(r0, true);     // Catch: Throwable -> L16
    L6:
        ?? r2 = this.f7193b;     // Catch: Throwable -> L16
        if (r2 == 0) goto L9;
        r2.a(r0, false);     // Catch: Throwable -> L16
    L9:
        ?? r3 = -1;
        r3 = -1;
        ?? r4 = this.f7194c;     // Catch: Throwable -> L16
        if (r4 == 0) goto L14;
        r4.a(r0);     // Catch: Throwable -> L16
        c r7 = this.f7194c.e();     // Catch: Throwable -> L16
        if (r7 == null) goto L14;
        r0.put("top_cpu_process_name", r7.f7204a);     // Catch: Throwable -> L16
        r3 = this.f.equals(r7.f7204a);     // Catch: Throwable -> L16
    L14:
        r0.put("top_cpu_process_is_anrapp", r3);     // Catch: Throwable -> L16
        r0.put("process_name", this.f);     // Catch: Throwable -> L16
        r6.put(MonitorConstants.CPU, r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        r.b(th);
    }

    private String g() {
        if (TextUtils.isEmpty(this.h) == false) goto L5;
        return SensitiveType.UNKNOWN;
    L5:
        if ("null".equals(this.h) == false) goto L8;
        return SensitiveType.UNKNOWN;
    L8:
        if (this.h.startsWith("ANR ") == false) goto L28;
        if (this.h.startsWith("Input dispatching timed out", 4) == false) goto L14;
        return d(this.h);
    L14:
        if (this.h.startsWith("executing service", 4) == false) goto L17;
        return "executing service";
    L17:
        if (this.h.startsWith("Broadcast of Intent", 4) == false) goto L20;
        return "Broadcast of Intent";
    L20:
        if (this.h.startsWith("keyDispatchingTimedOut", 4) == false) goto L23;
        return "keyDispatchingTimedOut";
    L23:
        if (this.h.contains("not then call Service.startForeground") == false) goto L26;
        return "not then call Service.startForeground";
    L26:
        return b(this.h.substring(4));
    L28:
        return this.h;
    }

    public static String b(String r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.replaceAll("\\d+", "xxx");
    L10:
        return r2;
    }

    private static String d(String r1) {
        if (r1.contains("Waiting to send non-key event") == false) goto L9;
        if (r1.contains("finished processing certain input events that were delivered") == false) goto L9;
        return "Input dispatching timed out (Waiting to send non-key event because the touched window has not finished processing certain input events that were delivered to it over xxms ago.  Wait queue length: xx.  Wait queue head age: xxms.)";
    L9:
        if (r1.contains("Application does not have a focused window") == false) goto L13;
        return "Input dispatching timed out (Application does not have a focused window)";
    L13:
        if (r1.contains("Waiting because no window has focus but there is a focused") == false) goto L17;
        return "Input dispatching timed out (Waiting because no window has focus but there is a focused application that may eventually add a window when it finishes starting up.)";
    L17:
        if (r1.contains("window's input channel is full.") == false) goto L20;
        return "Input dispatching timed out (Waiting because the touched window input channel is full.Outbound queue length: XXX.Wait queue length: XX.)";
    L20:
        return "Input dispatching timed out";
    }

    private String h() {
        if (TextUtils.isEmpty(this.j) == true) goto L9;
        if ("null".equals(this.j) == true) goto L9;
        return this.j;
    L9:
        if (TextUtils.isEmpty(this.h) == false) goto L11;
        return SensitiveType.UNKNOWN;
    L11:
        if ("null".equals(this.h) == false) goto L14;
        return SensitiveType.UNKNOWN;
    L14:
        if (this.h.contains("executing service") == false) goto L20;
        String r5 = this.h;
        String r6 = r5.substring(r5.indexOf("service ") + 8).trim();
        String[] r0 = r6.split("/");
        if (r0.length <= 1) goto L25;
        r6 = r0[r0.length - 1];
    L25:
        return r6;
    L20:
        if (this.h.contains("Broadcast of Intent") == false) goto L26;
        String r1 = this.h;
        r6 = r1.substring(r1.indexOf("{") + 1, this.h.indexOf("}")).trim();
        String[] r2 = r6.split("/");
        if (r2.length <= 1) goto L25;
        r6 = r2[r2.length - 1];
        goto L25
    L26:
        return SensitiveType.UNKNOWN;
    }

    String f() {
        String r0 = this.i;
        if (r0 != null) goto L5;
        return "invalid";
    L5:
        if (r0.equals("Input dispatching timed out") == false) goto L43;
        String r2 = this.h.toLowerCase();
        if (r2.contains("no window has focus but there is a focused application") == false) goto L9;
        return "no focused window";
    L9:
        if (r2.contains("does not have a focused window") == false) goto L12;
        return "no focused window";
    L12:
        if (r2.contains("waiting to send non-key event because the touched window has not finished") == false) goto L16;
        return "non-key event not finished";
    L16:
        if (r2.contains("waiting to send key event because the focused window has not finished") == false) goto L20;
        return "key event not finished";
    L20:
        if (r2.contains("window is paused") == false) goto L23;
        return "window is paused";
    L23:
        if (r2.contains("window’s input channel is not registered") == false) goto L27;
        return "input channel not registered";
    L27:
        if (r2.contains("window’s input connection is") == false) goto L31;
        return "window being removed";
    L31:
        if (r2.contains("window’s input channel is full") == false) goto L35;
        return "input channel is full";
    L35:
        if (r2.contains("is not responding. waited") == false) goto L44;
        return "activity is not responding";
    L44:
        return "invalid";
    L43:
        return "invalid";
    }

    void d(JSONObject r7) {
        int r0 = this.k;
    L4:
        if (r0 >= this.l) goto L11;
        int r1 = this.f7195d.indexOf("\n", r0);
        if (r1 < 0) goto L11;
        if (this.f7195d.startsWith("Load: ", r0) == true) goto L9;
        r0 = r1 + 1;
        goto L4
    L9:
        String r6 = this.f7195d.substring(r0 + 6, r1);
    L12:
        if (r6 == null) goto L24;
        String[] r8 = r6.split(" / ");
        if (r8.length == 3) goto L19;
        return;
    L19:
        double r2 = Double.parseDouble(r8[0].trim());     // Catch: Throwable -> L18
        double r3 = Double.parseDouble(r8[1].trim());     // Catch: Throwable -> L18
        double r4 = Double.parseDouble(r8[2].trim());     // Catch: Throwable -> L18
        JSONArray r9 = new JSONArray();     // Catch: Throwable -> L18
        r9.put(r2);     // Catch: Throwable -> L18
        r9.put(r3);     // Catch: Throwable -> L18
        r9.put(r4);     // Catch: Throwable -> L18
        r7.put("load", r9);     // Catch: Throwable -> L18
        return;
    L26:
        return;
    L24:
        return;
    L11:
        r6 = null;
        goto L12
    }

    private static int[] a(String r5, int r6) {
        int[] r0 = new int[4];
    L3:
        int r1 = r5.indexOf("\n", r6);
        if (r1 < 0) goto L16;
        if (r5.startsWith("CPU usage from", r6) == true) goto L7;
        r6 = r1 + 1;
        goto L3
    L7:
        r0[0] = r6;
        r0[1] = r1;
        int r2 = r5.indexOf("% TOTAL: ", r1 + 1);
        if (r2 <= 0) goto L14;
        int r4 = r5.lastIndexOf(10, r2) + 1;
        int r7 = r5.indexOf(10, r2);
        if (r4 <= 0) goto L14;
        if (r7 <= 0) goto L14;
        r0[2] = r4;
        r0[3] = r7;
        return r0;
    L14:
        return null;
    L16:
        return null;
    }
}
