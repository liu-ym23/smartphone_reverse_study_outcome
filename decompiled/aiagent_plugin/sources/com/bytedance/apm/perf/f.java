package com.bytedance.apm.perf;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.util.p;
import com.bytedance.apm.util.y;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: StorageCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends com.bytedance.apm.perf.a {
    private static final String TAG = "MonitorStorage";
    private static long h = 17179869184L;
    private static String j;
    private static String l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4804e;
    private long f;
    private com.bytedance.apm.g.f i;
    private String k;
    private String m;
    private long n;
    private long o;
    private long p;
    private long q;
    private boolean r;
    private List<a> s;
    private List<String> t;
    private List<String> u;
    private List<String> v;
    private List<String> w;
    private y<b> x;
    private y<b> y;
    private y<d> z;

    /* JADX INFO: compiled from: StorageCollector.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f4811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f4812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4813d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f4814e;
        public List<a> f;

        private a() {
            this.f4814e = "normal";
            this.f = new ArrayList();
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put(DownloadConstants.PATH_KEY, b());     // Catch: JSONException -> L11
            r0.put(MonitorConstants.SIZE, this.f4811b);     // Catch: JSONException -> L11
            r0.put("size_rate", this.f4812c);     // Catch: JSONException -> L11
            r0.put("is_folder", this.f4813d);     // Catch: JSONException -> L11
            r0.put("report_type", this.f4814e);     // Catch: JSONException -> L11
            if (this.f.isEmpty() == true) goto L13;
            JSONArray r1 = new JSONArray();     // Catch: JSONException -> L11
            Iterator<a> r5 = this.f.iterator();     // Catch: JSONException -> L11
        L7:
            if (r5.hasNext() == false) goto L9;
            r1.put(((a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.aiagent.plugin")).a());     // Catch: JSONException -> L11
            goto L7
        L9:
            r0.put("next_disk", r1);     // Catch: JSONException -> L11
        L13:
            return r0;
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }

        private String b() {
            String r2 = this.f4810a;
            if (r2.contains(f.g()) == false) goto L6;
            return r2.replace(f.g(), "internal");
        L6:
            if (r2.contains(f.h()) == true) goto L8;
            return r2;
        L8:
            return r2.replace(f.h(), "external");
        }
    }

    /* JADX INFO: compiled from: StorageCollector.java */
    private static class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f4815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f4816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4817c;

        static /* synthetic */ String a(b r0) {
            return r0.f4816b;
        }

        public b() {
        }

        public b(String r1, long r2, int r4) {
            this.f4816b = r1;
            this.f4815a = r2;
            this.f4817c = r4;
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
            r0.put("name", b());     // Catch: Exception -> L6
            r0.put(MonitorConstants.SIZE, this.f4815a);     // Catch: Exception -> L6
            int r4 = this.f4817c;     // Catch: Exception -> L6
            if (r4 <= 0) goto L5;
            r0.put("num", r4);     // Catch: Exception -> L6
        L5:
            return r0;
        L6:
            return null;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r4) {
            b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
            long r0 = this.f4815a;
            long r3 = r5.f4815a;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }

        private String b() {
            String r2 = this.f4816b;
            if (r2.contains(f.g()) == false) goto L6;
            return r2.replace(f.g(), "internal");
        L6:
            if (r2.contains(f.h()) == true) goto L8;
            return r2;
        L8:
            return r2.replace(f.h(), "external");
        }
    }

    /* JADX INFO: compiled from: StorageCollector.java */
    private class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f4818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f4819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f4820c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f4821d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f4822e;
        private int f;
        private boolean g;
        private long h;
        private boolean i;

        private c(f r1) {
            this.f4820c = r1;
        }

        /* synthetic */ c(f r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int a(c r0, int r1) {
            r0.f4822e = r1;
            return r1;
        }

        static /* synthetic */ long a(c r0, long r1) {
            r0.h = r1;
            return r1;
        }

        static /* synthetic */ String a(c r0) {
            return r0.f4821d;
        }

        static /* synthetic */ String a(c r0, String r1) {
            r0.f4821d = r1;
            return r1;
        }

        static /* synthetic */ boolean a(c r0, boolean r1) {
            r0.g = r1;
            return r1;
        }

        static /* synthetic */ int b(c r2) {
            int r0 = r2.f4822e;
            r2.f4822e = r0 - 1;
            return r0;
        }

        static /* synthetic */ boolean c(c r0) {
            return r0.g;
        }

        private boolean a() {
            if (this.f != this.f4822e) goto L5;
            return true;
        L5:
            return false;
        }

        public void a(long r8) {
            this.f4819b += r8;
            this.f++;
            if (this.f4818a != null) goto L5;
            return;
        L5:
            if (a() == true) goto L7;
            return;
        L7:
            if (this.i == false) goto L10;
            this.f4818a.i = true;
        L10:
            if (this.f4819b >= f.c(this.f4820c)) goto L12;
        L14:
            this.f4818a.a(this.f4819b);
            if (this.g == false) goto L17;
            f.a(this.f4820c, this.f4821d, this.f4819b, this.f4822e, this.h);
        L17:
            b();
            return;
        L12:
            if (this.i == true) goto L14;
            f.a(this.f4820c, this.f4821d, this.f4819b, this.f, this.f4822e);
            this.f4818a.i = true;
            goto L14
        }

        private void b() {
            if (TextUtils.equals(this.f4821d, f.g()) == false) goto L6;
            f.a(this.f4820c, this.f4819b);
            return;
        L6:
            if (TextUtils.equals(this.f4821d, f.h()) == false) goto L9;
            f.b(this.f4820c, this.f4819b);
            return;
        L9:
            if (TextUtils.equals(this.f4821d, f.d(this.f4820c)) == false) goto L12;
            f.c(this.f4820c, this.f4819b);
            return;
        L12:
            if (TextUtils.equals(this.f4821d, f.e(this.f4820c)) == false) goto L18;
            f.d(this.f4820c, this.f4819b);
            return;
        }
    }

    /* JADX INFO: compiled from: StorageCollector.java */
    private static class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f4823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f4824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f4825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f4826e;

        public d(String r1, long r2, int r4, long r5) {
            this.f4824c = r1;
            this.f4823b = r2;
            this.f4825d = r4;
            this.f4826e = r5;
        }

        @Override // com.bytedance.apm.perf.f.b
        public JSONObject a() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
            r0.put("name", b());     // Catch: Exception -> L7
            r0.put(MonitorConstants.SIZE, this.f4823b);     // Catch: Exception -> L7
            int r1 = this.f4825d;     // Catch: Exception -> L7
            if (r1 <= 0) goto L5;
            r0.put("num", r1);     // Catch: Exception -> L7
        L5:
            r0.put("outdate_interval", this.f4826e);     // Catch: Exception -> L7
            return r0;
        L7:
            return null;
        }

        @Override // com.bytedance.apm.perf.f.b, java.lang.Comparable
        public int compareTo(Object r4) {
            d r5 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
            long r0 = this.f4826e;
            long r3 = r5.f4826e;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }

        private String b() {
            String r2 = this.f4824c;
            if (r2.contains(f.g()) == false) goto L6;
            return r2.replace(f.g(), "internal");
        L6:
            if (r2.contains(f.h()) == true) goto L8;
            return r2;
        L8:
            return r2.replace(f.h(), "external");
        }
    }

    static {
    }

    @Override // com.bytedance.apm.perf.a
    public boolean c() {
        return true;
    }

    @Override // com.bytedance.apm.perf.a
    public long d() {
        return 120000;
    }

    static /* synthetic */ long a(f r2) {
        return r2.f4802c;
    }

    static /* synthetic */ long a(f r0, long r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ void a(f r0, String r1, long r2, int r4, int r5) {
        r0.a(r1, r2, r4, r5);
    }

    static /* synthetic */ void a(f r0, String r1, long r2, int r4, long r5) {
        r0.a(r1, r2, r4, r5);
    }

    static /* synthetic */ long b(f r0, long r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.apm.g.f b(f r0) {
        return r0.i;
    }

    static /* synthetic */ long c(f r2) {
        return r2.f4803d;
    }

    static /* synthetic */ long c(f r0, long r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ long d(f r0, long r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ String d(f r0) {
        return r0.k;
    }

    static /* synthetic */ String e(f r0) {
        return r0.m;
    }

    static /* synthetic */ String g() {
        return j;
    }

    static /* synthetic */ String h() {
        return l;
    }

    public f() {
        this.f4802c = 524288000;
        this.f4803d = 524288000;
        this.f4804e = 20;
        this.f = 2592000000L;
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.g = "disk";
    }

    public void a(com.bytedance.apm.g.f r3) {
        this.i = (com.bytedance.apm.g.f) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.g.f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.apm.perf.a
    public void a(JSONObject r10) {
        boolean r0 = r10.optBoolean("dump_switch", true);
        this.f4801b = r0;
        if (r0 == false) goto L22;
        long r2 = com.bytedance.apm.internal.b.a().c("check_disk_last_time");
        long r4 = System.currentTimeMillis() - r2;
        if (r4 >= 86400000) goto L10;
        if (r4 <= 0) goto L10;
        this.f4800a = true;
    L10:
        if (r10.optInt("dump_threshold") <= 0) goto L13;
        this.f4802c = (((long) r10.optInt("dump_threshold")) * 1024) * 1024;
    L13:
        if (r10.optInt("abnormal_folder_size") <= 0) goto L16;
        this.f4803d = (((long) r10.optInt("abnormal_folder_size")) * 1024) * 1024;
    L16:
        if (r10.optInt("dump_top_count") <= 0) goto L19;
        this.f4804e = r10.optInt("dump_top_count");
    L19:
        if (r10.optInt("outdated_days") <= 0) goto L21;
        this.f = ((long) r10.optInt("outdated_days")) * 86400000;
    L21:
        this.t = p.c(r10, "disk_customed_paths");
        this.u = p.b(r10, "ignored_relative_paths");
    L22:
        this.f4800a = true;
    }

    private void i() {
        if (j == null) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r0.getPackageName();     // Catch: Exception -> L33
        j = r0.getFilesDir().getParent();     // Catch: Exception -> L33
        this.k = r0.getCacheDir().getAbsolutePath();     // Catch: Exception -> L33
        l = r0.getExternalFilesDir(null).getParentFile().getAbsolutePath();     // Catch: Exception -> L33
        File r1 = r0.getExternalCacheDir();     // Catch: Exception -> L33
        if (r1 == null) goto L9;
        this.m = r1.getAbsolutePath();     // Catch: Exception -> L33
    L9:
        List<String> r2 = this.u;     // Catch: Exception -> L33
        if (r2 == null) goto L21;
        Iterator<String> r3 = r2.iterator();     // Catch: Exception -> L33
    L14:
        if (r3.hasNext() == false) goto L21;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L33
        if (r4.contains("internal") == true) goto L17;
        if (r4.contains("external") == false) goto L14;
        this.v.add(r4.replace("external", l));     // Catch: Exception -> L33
        goto L14
    L17:
        this.v.add(r4.replace("internal", j));     // Catch: Exception -> L33
    L21:
        List<String> r5 = this.t;     // Catch: Exception -> L33
        if (r5 == null) goto L53;
        Iterator<String> r6 = r5.iterator();     // Catch: Exception -> L33
    L24:
        if (r6.hasNext() == false) goto L54;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L33
        if (r7.contains("internal") == true) goto L28;
        if (r7.contains("external") == false) goto L24;
        this.w.add(r7.replace("external", l));     // Catch: Exception -> L33
        goto L24
    L28:
        this.w.add(r7.replace("internal", j));     // Catch: Exception -> L33
        goto L24
    L54:
        return;
    L53:
        return;
    L33:
        this.r = true;
    }

    @Override // com.bytedance.apm.perf.a
    public void e() {
        boolean r0 = n();
        if (this.f4800a == true) goto L16;
        if (r0 == false) goto L17;
        i();
        if (this.r == false) goto L11;
        this.f4800a = true;
        return;
    L11:
        if (this.f4801b == false) goto L13;
        p();
    L14:
        this.f4800a = true;
        k();
        l();
        return;
    L13:
        o();
        goto L14
    L17:
        return;
    }

    private void o() {
        a(com.bytedance.apm.util.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), com.bytedance.apm.util.b.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), com.bytedance.apm.util.b.f(), Environment.getDataDirectory().getFreeSpace());     // Catch: Exception -> L5
        return;
    }

    private void p() {
        a();     // Catch: Throwable -> L4
        a(this.n + this.o, this.p + this.q, Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());     // Catch: Throwable -> L4
        com.bytedance.apm.internal.b.a().a("check_disk_last_time", System.currentTimeMillis());     // Catch: Throwable -> L4
        return;
    }

    private void a(long r8, long r10, long r12, long r14) {
        if (com.bytedance.apm.c.i() == false) goto L5;
        com.bytedance.apm.h.e.c(com.bytedance.apm.h.b.f4647c, new String[]{"disk: data: " + r8 + " , cache: " + r10 + " , total: " + r12 + " , free: " + r14});     // Catch: Exception -> L87
    L5:
        long r0 = h;     // Catch: Exception -> L87
        if (r8 <= r0) goto L8;
        long r2 = r0;
    L10:
        if (r10 > r0) goto L13;
        r0 = r10;
    L13:
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L87
        if (r8 <= 0) goto L17;
        r4.put("data", r2);     // Catch: Exception -> L87
    L17:
        if (r10 <= 0) goto L20;
        r4.put("cache", r0);     // Catch: Exception -> L87
    L20:
        if (r12 <= 0) goto L23;
        r4.put("total", a(r12));     // Catch: Exception -> L87
    L23:
        if (r14 <= 0) goto L25;
        r4.put("rom_free", a(r14));     // Catch: Exception -> L87
    L25:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L87
        if (this.f4801b == true) goto L28;
    L85:
        a(new com.bytedance.apm.d.b.e("disk", "storageUsed", false, r4, null, r15));     // Catch: Exception -> L87
        return;
    L28:
        if (r2 <= this.f4802c) goto L85;
        if (this.x == null) goto L40;
        JSONArray r9 = new JSONArray();     // Catch: Exception -> L87
        Iterator r11 = this.x.a().iterator();     // Catch: Exception -> L87
    L34:
        if (r11.hasNext() == false) goto L38;
        JSONObject r13 = ((b) ZeusTransformUtils.preCheckCast(r11.next(), b.class, "com.obric.aiagent.plugin")).a();     // Catch: Exception -> L87
        if (r13 == null) goto L34;
        r9.put(r13);     // Catch: Exception -> L87
        goto L34
    L38:
        r15.put("top_usage", r9);     // Catch: Exception -> L87
    L40:
        if (this.y == null) goto L49;
        JSONArray r16 = new JSONArray();     // Catch: Exception -> L87
        Iterator r17 = this.y.a().iterator();     // Catch: Exception -> L87
    L43:
        if (r17.hasNext() == false) goto L47;
        JSONObject r18 = ((b) ZeusTransformUtils.preCheckCast(r17.next(), b.class, "com.obric.aiagent.plugin")).a();     // Catch: Exception -> L87
        if (r18 == null) goto L43;
        r16.put(r18);     // Catch: Exception -> L87
        goto L43
    L47:
        r15.put("exception_folders", r16);     // Catch: Exception -> L87
    L49:
        if (this.z == null) goto L57;
        JSONArray r19 = new JSONArray();     // Catch: Exception -> L87
        Iterator r110 = this.z.a().iterator();     // Catch: Exception -> L87
    L52:
        if (r110.hasNext() == false) goto L56;
        JSONObject r111 = ((d) ZeusTransformUtils.preCheckCast(r110.next(), d.class, "com.obric.aiagent.plugin")).a();     // Catch: Exception -> L87
        if (r111 == null) goto L52;
        r19.put(r111);     // Catch: Exception -> L87
        goto L52
    L56:
        r15.put("outdated_files", r19);     // Catch: Exception -> L87
    L57:
        List<a> r20 = this.s;     // Catch: Exception -> L87
        if (r20 == null) goto L82;
        if (r20.isEmpty() == true) goto L82;
        BigDecimal r21 = new BigDecimal(r2);     // Catch: Exception -> L87
        JSONArray r112 = new JSONArray();     // Catch: Exception -> L87
        Iterator<a> r113 = this.s.iterator();     // Catch: Exception -> L87
    L63:
        if (r113.hasNext() == false) goto L80;
        a r114 = (a) ZeusTransformUtils.preCheckCast(r113.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L87
        if (a(r114) == false) goto L67;
        r114.f4812c = 0.0f;     // Catch: Exception -> L87
    L68:
        List<a> r115 = r114.f;     // Catch: Exception -> L87
        if (r115 == null) goto L79;
        if (r115.size() <= 0) goto L79;
        Iterator<a> r116 = r115.iterator();     // Catch: Exception -> L87
    L74:
        if (r116.hasNext() == false) goto L79;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r116.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L87
        if (a(r1) == true) goto L77;
        r1.f4812c = a(r1.f4811b, r21);     // Catch: Exception -> L87
        goto L74
    L77:
        r1.f4812c = 0.0f;     // Catch: Exception -> L87
    L79:
        r112.put(r114.a());     // Catch: Exception -> L87
        goto L63
    L67:
        r114.f4812c = a(r114.f4811b, r21);     // Catch: Exception -> L87
        goto L68
    L80:
        r15.put("disk_info", r112);     // Catch: Exception -> L87
    L82:
        if (this.i == null) goto L84;
        final List<String> r117 = a(this.x);     // Catch: Exception -> L87
        final List<String> r118 = a(this.y);     // Catch: Exception -> L87
        final List<String> r119 = a(this.z);     // Catch: Exception -> L87
        final long r120 = r2;
        com.bytedance.apm.thread.b.a().c(new AnonymousClass1(this, r120, r117, r118, r119));     // Catch: Exception -> L87
    L84:
        this.x = null;     // Catch: Exception -> L87
        this.y = null;     // Catch: Exception -> L87
        this.z = null;     // Catch: Exception -> L87
        this.s = null;     // Catch: Exception -> L87
        goto L85
    L8:
        r2 = r8;
    }

    private float a(long r1, BigDecimal r3) {
        return (float) new BigDecimal(r1).divide(r3, 4, 4).doubleValue();
    }

    private static List<String> a(y<? extends b> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        LinkedList r0 = new LinkedList();
        Iterator r5 = r4.a().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r0.add(b.a((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin")));
        goto L7
    L9:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v2 */
    public void a() {
        int r8 = 2;
        int r10 = 0;
        ?? r11 = 1;
        String[] r9 = {j, l};
        this.s = new ArrayList();
        int r12 = 0;
    L4:
        if (r12 >= r8) goto L57;
        String r0 = r9[r12];
        a(new File(r0), r11, r11, this.s);
        File r1 = new File(r0);
        AnonymousClass1 r14 = null;
        c r2 = new c(this, r14);
        c.a(r2, r0);
        r2.f4818a = new c(this, r14);
        File[] r3 = r1.listFiles();
        if (r3 == null) goto L56;
        if (r3.length == 0) goto L56;
        c.a(r2, r3.length);
        LinkedList r15 = new LinkedList();
        r15.offer(r2);
    L12:
        if (r15.isEmpty() == true) goto L56;
        int r5 = r15.size();
        int r6 = r10;
    L14:
        if (r6 >= r5) goto L12;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r15.poll(), c.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L19;
        String[] r16 = r9;
    L18:
        int r18 = r12;
    L55:
        r6 = r6 + 1;
        r9 = r16;
        r12 = r18;
        r5 = r5;
        r10 = 0;
        goto L14
    L19:
        String r7 = c.a(r4);
        File r13 = new File(r7);
        if (r13.exists() == true) goto L22;
    L54:
        r5 = r5;
        r6 = r6;
        r16 = r9;
        r18 = r12;
        c.b(r4.f4818a);
        goto L55
    L22:
        if (this.v.contains(r7) == true) goto L54;
        r16 = r9;
        if (r13.isFile() == false) goto L38;
        long r17 = r13.length();
        if (r17 <= 0) goto L30;
        a(r7, r17);
    L30:
        if (r4.f4818a == null) goto L18;
        r4.f4818a.a(r17);
        if (c.c(r4.f4818a) == true) goto L18;
        r18 = r12;
        long r19 = b(r13.lastModified());
        if (r19 <= 0) goto L36;
        r5 = r5;
        r6 = r6;
        a(r7, r17, 0, r19);
        goto L55
    L36:
        r5 = r5;
        r6 = r6;
        goto L55
    L38:
        r5 = r5;
        r6 = r6;
        r18 = r12;
        File[] r20 = r13.listFiles();
        if (r20 != null) goto L41;
    L53:
        r4.f4818a.a(0);
        goto L55
    L41:
        if (r20.length == 0) goto L53;
        c.a(r4, r20.length);
        int r21 = r20.length;
        int r22 = 0;
    L44:
        if (r22 >= r21) goto L55;
        File r23 = r20[r22];
        c r24 = new c(this, r14);
        r24.f4818a = r4;
        c.a(r24, r23.getAbsolutePath());
        if (r23.isDirectory() == false) goto L52;
        if (c.c(r4) == true) goto L52;
        long r110 = b(r23.lastModified());
        if (r110 <= 0) goto L52;
        c.a(r24, true);
        c.a(r24, r110);
    L52:
        r15.offer(r24);
        r22 = r22 + 1;
    L56:
        r12 = r12 + 1;
        r9 = r9;
        r8 = 2;
        r10 = 0;
        r11 = 1;
        goto L4
    L57:
        List<String> r25 = this.w;
        if (r25 != null) goto L60;
    L65:
        Iterator<a> r26 = this.s.iterator();
    L67:
        if (r26.hasNext() == false) goto L78;
        a r27 = (a) ZeusTransformUtils.preCheckCast(r26.next(), a.class, "com.obric.aiagent.plugin");
        if ("normal".equals(r27.f4814e) == false) goto L67;
        List<a> r28 = r27.f;
        if (r28 == null) goto L67;
        if (r28.isEmpty() == true) goto L67;
        Iterator<a> r29 = r28.iterator();
    L76:
        if (r29.hasNext() == false) goto L67;
        r27.f4811b += ((a) ZeusTransformUtils.preCheckCast(r29.next(), a.class, "com.obric.aiagent.plugin")).f4811b;
        goto L76
    L78:
        return;
    L60:
        if (r25.size() <= 0) goto L65;
        Iterator<String> r30 = this.w.iterator();
    L63:
        if (r30.hasNext() == false) goto L65;
        a(new File((String) ZeusTransformUtils.preCheckCast(r30.next(), String.class, "com.obric.aiagent.plugin")), 1, false, this.s);
        goto L63
    }

    private void a(File r10, int r11, boolean r12, List<a> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        if (r11 > 2) goto L49;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.exists() == true) goto L8;
        return;
    L8:
        if (this.v.contains(r10.getAbsolutePath()) == true) goto L53;
        int r3 = 0;
        AnonymousClass1 r4 = null;
        if (r10.isDirectory() == false) goto L37;
        if (r12 == false) goto L36;
        File[] r15 = r10.listFiles();
        if (r15 != null) goto L16;
        return;
    L16:
        if (r15.length == 0) goto L48;
        int r1 = r15.length;
    L19:
        if (r3 >= r1) goto L54;
        File r2 = r15[r3];
        if (r2 == null) goto L34;
        if (r2.exists() == false) goto L34;
        if (this.v.contains(r2.getAbsolutePath()) == true) goto L34;
        a r5 = new a(r4);
        r5.f4813d = r2.isDirectory();
        r5.f4810a = r2.getAbsolutePath();
        if (r2.isDirectory() == false) goto L33;
        ArrayList r6 = new ArrayList();
        r5.f = r6;
        if (r11 != 2) goto L32;
        r5.f4811b = a(r2);
    L32:
        a(r2, r11 + 1, r12, r6);
        r14.add(r5);
        goto L34
    L33:
        r5.f4811b = r2.length();
        r14.add(r5);
    L34:
        r3 = r3 + 1;
        goto L19
    L54:
        return;
    L48:
        return;
    L36:
        a r16 = new a(r4);
        r16.f4813d = true;
        r16.f4814e = MonitorConstants.CUSTOM;
        r16.f4810a = r10.getAbsolutePath();
        r16.f4811b = a(r10);
        r14.add(r16);
        return;
    L37:
        a r9 = new a(r4);
        r9.f4813d = false;
        r9.f4810a = r10.getAbsolutePath();
        r9.f4811b = r10.length();
        if (r12 == true) goto L40;
        r9.f4814e = MonitorConstants.CUSTOM;
    L40:
        r14.add(r9);
        return;
    L53:
        return;
    }

    private long a(long r3) {
        return r3 / DownloadConstants.GB;
    }

    private long a(File r7) {
        long r0 = 0;
        File[] r8 = r7.listFiles();     // Catch: Exception -> L16
        if (r8 != null) goto L6;
    L15:
        return 0;
    L6:
        if (r8.length == 0) goto L15;
        int r2 = r8.length;     // Catch: Exception -> L16
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L18;
        File r4 = r8[r3];     // Catch: Exception -> L16
        if (r4.isDirectory() == false) goto L13;
        long r5 = a(r4);     // Catch: Exception -> L16
    L14:
        r0 = r0 + r5;
        r3 = r3 + 1;
        goto L9
    L13:
        r5 = r4.length();     // Catch: Exception -> L16
    L18:
        return r0;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    private long b(long r3) {
        long r0 = System.currentTimeMillis() - r3;
        if (r0 >= this.f) goto L5;
        return 0;
    L5:
        if (r0 >= 62899200000L) goto L9;
        return r0;
    L9:
        return 0;
    }

    private void a(String r6, long r7) {
        if (com.bytedance.apm.c.i() == false) goto L6;
        com.bytedance.apm.h.e.d(TAG, new String[]{"appendExceptionFileQueue: path: " + r6 + ", size: " + r7});
    L6:
        if (r7 <= h) goto L9;
        return;
    L9:
        if (this.x != null) goto L11;
        this.x = new y(this.f4804e);
    L11:
        this.x.a(new b(r6, r7, 1));
    }

    private void a(String r3, long r4, int r6, int r7) {
        if (com.bytedance.apm.c.i() == false) goto L6;
        a(TAG, "appendExceptionFolderQueue: path: " + r3 + ":  size: " + r4 + " , accumulateNum: " + r6 + " , num: " + r7);
    L6:
        if (r4 <= h) goto L9;
        return;
    L9:
        if (this.y != null) goto L11;
        this.y = new y(this.f4804e);
    L11:
        this.y.a(new b(r3, r4, r7));
    }

    private void a(String r9, long r10, int r12, long r13) {
        if (com.bytedance.apm.c.i() == false) goto L6;
        com.bytedance.apm.h.e.d(TAG, new String[]{"appendutdatedFileQueue: path: " + r9 + ", size: " + r10});
    L6:
        if (r10 >= WsConstants.DEFAULT_IO_LIMIT) goto L8;
        return;
    L8:
        if (r10 <= h) goto L11;
        return;
    L11:
        if (this.z != null) goto L13;
        this.z = new y(this.f4804e);
    L13:
        this.z.a(new d(r9, r10, r12, r13));
    }

    private boolean a(a r4) {
        Iterator<String> r3 = this.v.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        if (r4.f4810a.contains(r0) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
