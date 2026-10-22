package y2;

import android.app.Application;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm.util.w;
import com.bytedance.apm6.util.ListUtils;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static c f26056p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f26058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f26059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f26060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f26061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f26062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f26063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f26064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f26065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z2.a f26066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f26067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f26068l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f26069m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f26070n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IStorageCheckListener f26071o;

    public static /* synthetic */ class a {
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f26072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f26073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f26074c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f26075d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f26076e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f26077f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ c f26078g;

        public b(c r10) {
            this.f26078g = r10;
            this.f26076e = "normal";
            this.f26077f = new ArrayList();
        }

        public final String a() {
            String r10 = this.f26072a;
            String r11 = c.c(this.f26078g, r10);
            if (r11 == null) goto L6;
            r10 = r11;
        L6:
            if (r10.contains(c.d(this.f26078g)) == false) goto L9;
            return r10.replace(c.d(this.f26078g), "internal");
        L9:
            if (r10.contains(c.e(this.f26078g)) == true) goto L11;
            return r10;
        L11:
            return r10.replace(c.e(this.f26078g), "external");
        }

        public JSONObject b() {
            JSONObject r10 = new JSONObject();
            r10.put("path", a());     // Catch: JSONException -> L9
            r10.put("size", this.f26073b);     // Catch: JSONException -> L9
            r10.put("size_rate", this.f26074c);     // Catch: JSONException -> L9
            r10.put("is_folder", this.f26075d);     // Catch: JSONException -> L9
            r10.put("report_type", this.f26076e);     // Catch: JSONException -> L9
            if (this.f26077f.isEmpty() == true) goto L14;
            JSONArray r11 = new JSONArray();     // Catch: JSONException -> L9
            Iterator r12 = this.f26077f.iterator();     // Catch: JSONException -> L9
        L7:
            if (r12.hasNext() == false) goto L11;
            r11.put(((b) r12.next()).b());     // Catch: JSONException -> L9
            goto L7
        L11:
            r10.put("next_disk", r11);     // Catch: JSONException -> L9
        L14:
            return r10;
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L14
        }

        public /* synthetic */ b(c r10, a r11) {
            this(r10);
        }
    }

    /* JADX INFO: renamed from: y2.c$c, reason: collision with other inner class name */
    public class C0412c implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f26079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f26080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f26081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f26082d;

        public C0412c(c r10) {
            this.f26082d = r10;
        }

        public static /* synthetic */ String a(C0412c r10) {
            return r10.f26079a;
        }

        private String b() {
            String r10 = this.f26079a;
            String r11 = c.c(this.f26082d, r10);
            if (r11 == null) goto L6;
            r10 = r11;
        L6:
            if (r10.contains(c.d(this.f26082d)) == false) goto L9;
            return r10.replace(c.d(this.f26082d), "internal");
        L9:
            if (r10.contains(c.e(this.f26082d)) == true) goto L11;
            return r10;
        L11:
            return r10.replace(c.e(this.f26082d), "external");
        }

        public JSONObject c() {
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L6
            r10.put("name", b());     // Catch: Exception -> L6
            r10.put("size", this.f26080b);     // Catch: Exception -> L6
            int r11 = this.f26081c;     // Catch: Exception -> L6
            if (r11 <= 0) goto L5;
            r10.put("num", r11);     // Catch: Exception -> L6
        L5:
            return r10;
        L6:
            return null;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r10) {
            long r11 = this.f26080b;
            long r12 = ((C0412c) r10).f26080b;
            if (r11 != r12) goto L7;
            return 0;
        L7:
            if (r11 <= r12) goto L10;
            return 1;
        L10:
            return -1;
        }

        public C0412c(c r10, String r11, long r12, int r13) {
            this.f26082d = r10;
            this.f26079a = r11;
            this.f26080b = r12;
            this.f26081c = r13;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f26083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f26084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f26085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26086d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26087e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f26088f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f26089g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f26090h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ c f26091i;

        public d(c r10) {
            this.f26091i = r10;
        }

        public static /* synthetic */ String a(d r10) {
            return r10.f26083a;
        }

        public static /* synthetic */ String b(d r10, String r11) {
            r10.f26083a = r11;
            return r11;
        }

        public static /* synthetic */ int c(d r10, int r11) {
            r10.f26086d = r11;
            return r11;
        }

        public static /* synthetic */ int d(d r10) {
            int r11 = r10.f26086d;
            r10.f26086d = r11 - 1;
            return r11;
        }

        public static /* synthetic */ boolean e(d r10) {
            return r10.f26088f;
        }

        public static /* synthetic */ boolean f(d r10, boolean r11) {
            r10.f26088f = r11;
            return r11;
        }

        public static /* synthetic */ long g(d r10, long r11) {
            r10.f26089g = r11;
            return r11;
        }

        public void h(long r10, w r11, w r12) {
            this.f26085c += r10;
            this.f26087e++;
            if (this.f26084b != null) goto L5;
            return;
        L5:
            if (i() == true) goto L7;
            return;
        L7:
            if (this.f26090h == false) goto L10;
            this.f26084b.f26090h = true;
        L10:
            if (this.f26085c >= c.a(this.f26091i).e()) goto L12;
        L17:
            this.f26084b.h(this.f26085c, r11, r12);
            if (this.f26088f == true) goto L20;
            return;
        L20:
            if (this.f26091i.F(this.f26085c) == false) goto L26;
            c r13 = this.f26091i;
            String r14 = this.f26083a;
            long r15 = this.f26085c;
            int r16 = this.f26086d;
            r11.a(new e(r13, r14, r15, r16, r16));
            return;
        L26:
            return;
        L12:
            if (this.f26090h == true) goto L17;
            if (c.b(this.f26091i, this.f26085c) == true) goto L16;
            r12.a(new C0412c(this.f26091i, this.f26083a, this.f26085c, this.f26086d));
        L16:
            this.f26084b.f26090h = true;
            goto L17
        }

        public boolean i() {
            if (this.f26087e != this.f26086d) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ d(c r10, a r11) {
            this(r10);
        }
    }

    public class e extends C0412c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f26092e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f26093f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f26094g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f26095h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ c f26096i;

        public e(c r10, String r11, long r12, int r13, long r14) {
            this.f26096i = r10;
            super(r10);
            this.f26092e = r11;
            this.f26093f = r12;
            this.f26094g = r13;
            this.f26095h = r14;
        }

        public final String b() {
            String r10 = this.f26092e;
            String r11 = c.c(this.f26096i, r10);
            if (r11 == null) goto L6;
            r10 = r11;
        L6:
            if (r10.contains(c.d(this.f26096i)) == false) goto L9;
            return r10.replace(c.d(this.f26096i), "internal");
        L9:
            if (r10.contains(c.e(this.f26096i)) == true) goto L11;
            return r10;
        L11:
            return r10.replace(c.e(this.f26096i), "external");
        }

        @Override // y2.c.C0412c
        public JSONObject c() {
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L7
            r10.put("name", b());     // Catch: Exception -> L7
            r10.put("size", this.f26093f);     // Catch: Exception -> L7
            int r11 = this.f26094g;     // Catch: Exception -> L7
            if (r11 <= 0) goto L5;
            r10.put("num", r11);     // Catch: Exception -> L7
        L5:
            r10.put(PerfConsts.PERF_DISK_FILE_OUTDATE_INTERVAL, this.f26095h);     // Catch: Exception -> L7
            return r10;
        L7:
            return null;
        }

        @Override // y2.c.C0412c, java.lang.Comparable
        public int compareTo(Object r10) {
            long r11 = this.f26095h;
            long r12 = ((e) r10).f26095h;
            if (r11 != r12) goto L7;
            return 0;
        L7:
            if (r11 <= r12) goto L10;
            return 1;
        L10:
            return -1;
        }
    }

    static {
        f26056p = new c();
    }

    public c() {
        this.f26061e = false;
        this.f26067k = 0;
        this.f26068l = 0;
        this.f26069m = 0;
        this.f26070n = 0;
    }

    public static /* synthetic */ z2.a a(c r10) {
        return r10.f26066j;
    }

    public static /* synthetic */ boolean b(c r10, long r11) {
        return r10.E(r11);
    }

    public static /* synthetic */ String c(c r10, String r11) {
        return r10.t(r11);
    }

    public static /* synthetic */ String d(c r10) {
        return r10.f26057a;
    }

    public static /* synthetic */ String e(c r10) {
        return r10.f26059c;
    }

    public static List n(w r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        LinkedList r11 = new LinkedList();
        Iterator r12 = r10.d().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add(C0412c.a((C0412c) r12.next()));
        goto L7
    L9:
        return r11;
    }

    public static c w() {
        return f26056p;
    }

    public final float A(long r10, BigDecimal r11) {
        return (float) new BigDecimal(r10).divide(r11, 4, 4).doubleValue();
    }

    public final void B() {
        if (this.f26065i == false) goto L5;
        return;
    L5:
        this.f26065i = true;
        Application r10 = r3.a.b();
        r10.getPackageName();     // Catch: Exception -> L10
        this.f26057a = r10.getFilesDir().getParent();     // Catch: Exception -> L10
        this.f26058b = r10.getCacheDir().getAbsolutePath();     // Catch: Exception -> L10
        this.f26059c = u(r10);     // Catch: Exception -> L10
        File r11 = r10.getExternalCacheDir();     // Catch: Exception -> L10
        if (r11 == null) goto L14;
        this.f26060d = r11.getAbsolutePath();     // Catch: Exception -> L10
        return;
    L14:
        return;
    L10:
        this.f26061e = true;
    }

    public final boolean C(File r10) {
        if (ListUtils.b(this.f26062f) == false) goto L5;
        return false;
    L5:
        return this.f26062f.contains(r10.getAbsolutePath());
    }

    public final boolean D(b r10) {
        Iterator r11 = this.f26062f.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        String r12 = (String) r11.next();
        if (r10.f26072a.contains(r12) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final boolean E(long r10) {
        if (r10 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r10 > 17179869184L) goto L8;
        return false;
    }

    public boolean F(long r10) {
        if (r10 >= 104857600) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 17179869184L) goto L7;
        return true;
    }

    public void G(IStorageCheckListener r10) {
        this.f26071o = r10;
    }

    public final List H(List r10) {
        ArrayList r11 = new ArrayList();
        if (ListUtils.b(r10) == false) goto L5;
        return r11;
    L5:
        Iterator r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L14;
        String r13 = (String) r12.next();
        if (r13.contains("internal") == true) goto L10;
        if (r13.contains("external") == false) goto L7;
        r11.add(r13.replace("external", this.f26059c));
        goto L7
    L10:
        r11.add(r13.replace("internal", this.f26057a));
        goto L7
    L14:
        return r11;
    }

    public final y2.b f() {
        ArrayList r10 = new ArrayList();
        l(new File(this.f26057a), r10);
        l(new File(this.f26059c), r10);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        b r13 = (b) r12.next();
        Iterator r14 = r13.f26077f.iterator();
    L7:
        if (r14.hasNext() == false) goto L11;
        if (((b) r14.next()).f26075d == false) goto L7;
    L11:
        r11.remove(r13);
        goto L4
    L12:
        r10.removeAll(r11);
        if (r3.a.c() == false) goto L18;
        Iterator r15 = r10.iterator();
    L16:
        if (r15.hasNext() == false) goto L18;
        s3.a.a("APM-Disk", "diskInfoNodes:" + ((b) r15.next()).b());
    L18:
        w r16 = new w(this.f26066j.j());
        w r17 = new w(this.f26066j.h());
        w r18 = new w(this.f26066j.i());
        List r19 = new ArrayList();
        r19.add(this.f26057a);
        r19.add(this.f26058b);
        k(j(this.f26057a, r16, r17, r18, r19));
        r19.clear();
        r19.add(this.f26060d);
        r19.add(this.f26059c);
        k(j(this.f26059c, r16, r17, r18, r19));
        if (r3.a.c() == false) goto L33;
        Iterator r20 = r16.d().iterator();
    L22:
        if (r20.hasNext() == false) goto L24;
        s3.a.a("APM-Disk", "fileListTopK:" + ((C0412c) r20.next()).c());
        goto L22
    L24:
        Iterator r21 = r17.d().iterator();
    L26:
        if (r21.hasNext() == false) goto L28;
        s3.a.a("APM-Disk", "dirListTopK:" + ((C0412c) r21.next()).c());
        goto L26
    L28:
        Iterator r22 = r18.d().iterator();
    L30:
        if (r22.hasNext() == false) goto L32;
        s3.a.a("APM-Disk", "outdatedListTopK:" + ((C0412c) r22.next()).c());
        goto L30
    L32:
        s3.a.a("APM-Disk", "insideDataSize:" + this.f26067k + " outsideDataSize:" + this.f26068l + " insideCacheSize:" + this.f26069m + " outsideCacheSize:" + this.f26070n);
    L33:
        h(r10);
        return q(r16, r17, r18, r10);
    }

    public final void g(File r10, List r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.exists() == true) goto L6;
        return;
    L6:
        if (C(r10) == true) goto L16;
        a r12 = null;
        if (r10.isFile() == false) goto L12;
        long r13 = r10.length();
        b r14 = new b(this, r12);
        r14.f26075d = false;
        r14.f26072a = r10.getAbsolutePath();
        r14.f26073b = r13;
        r14.f26076e = "custom";
        r11.add(r14);
        return;
    L12:
        b r15 = new b(this, r12);
        r15.f26075d = true;
        r15.f26076e = "custom";
        r15.f26072a = r10.getAbsolutePath();
        r15.f26073b = v(r10);
        r11.add(r15);
        return;
    }

    public final void h(List r10) {
        if (ListUtils.b(this.f26063g) == false) goto L5;
        return;
    L5:
        Iterator r11 = this.f26063g.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        g(new File((String) r11.next()), r10);
        goto L7
    }

    public final long i(File r10, List r11) {
        long r12 = 0;
        if (r10 != null) goto L5;
    L33:
        return r12;
    L5:
        if (r10.exists() == false) goto L33;
        if (C(r10) == true) goto L33;
        int r13 = 0;
        a r14 = null;
        if (r10.isFile() == false) goto L16;
        long r15 = r10.length();
        if (r15 >= this.f26066j.d()) goto L14;
        return r15;
    L14:
        b r16 = new b(this, r14);
        r16.f26075d = false;
        r16.f26072a = r10.getAbsolutePath();
        r16.f26073b = r15;
        r11.add(r16);
        return r15;
    L16:
        File[] r17 = r10.listFiles();
        if (r17 == null) goto L33;
        if (r17.length == 0) goto L33;
        b r18 = new b(this, r14);
        r18.f26075d = r10.isDirectory();
        r18.f26072a = r10.getAbsolutePath();
        ArrayList r19 = new ArrayList();
        r18.f26077f = r19;
        r11.add(r18);
        int r110 = r17.length;
    L22:
        if (r13 >= r110) goto L32;
        File r20 = r17[r13];
        if (r20 == null) goto L31;
        if (r20.exists() == false) goto L31;
        if (C(r20) == true) goto L31;
        r12 = r12 + i(r20, r19);
    L31:
        r13 = r13 + 1;
        goto L22
    L32:
        r18.f26073b = r12;
        goto L33
    }

    public final List j(String r23, w r24, w r25, w r26, List r27) {
        List r11 = r27;
        ArrayList r12 = new ArrayList();
        File r10 = new File(r23);
        a r13 = null;
        d r14 = new d(this, r13);
        d.b(r14, r23);
        r14.f26084b = new d(this, r13);
        File[] r15 = r10.listFiles();
        if (r15 == null) goto L69;
        if (r15.length == 0) goto L69;
        if (r11.contains(r10.getAbsolutePath()) == false) goto L10;
        r12.add(r14);
        r11.remove(r10.getAbsolutePath());
    L10:
        d.c(r14, r15.length);
        LinkedList r16 = new LinkedList();
        r16.offer(r14);
    L12:
        if (r16.isEmpty() == true) goto L68;
        int r17 = r16.size();
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L12;
        d r19 = (d) r16.poll();
        if (r19 != null) goto L18;
        r27 = r11;
        ArrayList r20 = r12;
        LinkedList r110 = r16;
        int r111 = r17;
        r18 = r18;
    L66:
        r18 = r18 + 1;
        r12 = r20;
        r16 = r110;
        r17 = r111;
        r11 = r27;
        goto L14
    L18:
        String r21 = d.a(r19);
        File r22 = new File(r21);
        if (r22.exists() == true) goto L21;
    L22:
        r27 = r11;
        r20 = r12;
        r110 = r16;
        r111 = r17;
        r18 = r18;
        d.d(r19.f26084b);
        goto L66
    L21:
        if (C(r22) == true) goto L22;
        if (r22.isFile() == false) goto L42;
        r110 = r16;
        long r112 = r22.length();
        if (E(r112) == true) goto L29;
        r24.a(new C0412c(this, r21, r112, 1));
    L29:
        d r28 = r19.f26084b;
        if (r28 != null) goto L33;
        r18 = r18;
    L32:
        r111 = r17;
        r20 = r12;
        goto L66
    L33:
        r28.h(r112, r26, r25);
        if (d.e(r19.f26084b) == true) goto L32;
        long r29 = y(r22.lastModified());
        if (r29 <= 0) goto L32;
        if (F(r112) == false) goto L32;
        r26.a(new e(this, r21, r17, 0, r29));
        goto L32
    L42:
        ArrayList r113 = r12;
        LinkedList r210 = r16;
        r18 = r18;
        r27 = r27;
        if (r27.contains(r22.getAbsolutePath()) == false) goto L45;
        r20 = r113;
        r20.add(r19);
        r27.remove(r22.getAbsolutePath());
    L46:
        File[] r30 = r22.listFiles();
        if (r30 != null) goto L49;
    L50:
        r110 = r210;
        r111 = r17;
        r19.f26084b.h(0, r26, r25);
        goto L66
    L49:
        if (r30.length == 0) goto L50;
        d.c(r19, r30.length);
        int r31 = r30.length;
        int r32 = 0;
    L52:
        if (r32 >= r31) goto L63;
        File r114 = r30[r32];
        d r115 = new d(this, null);
        r115.f26084b = r19;
        d.b(r115, r114.getAbsolutePath());
        if (r114.isDirectory() == true) goto L56;
    L61:
        int r116 = r17;
    L60:
        LinkedList r117 = r210;
        r117.offer(r115);
        r32 = r32 + 1;
        r210 = r117;
        r17 = r116;
        goto L52
    L56:
        if (d.e(r19) == true) goto L61;
        r116 = r17;
        long r118 = y(r114.lastModified());
        if (r118 <= 0) goto L60;
        d.f(r115, true);
        d.g(r115, r118);
        goto L60
    L63:
        r110 = r210;
        r111 = r17;
        goto L66
    L45:
        r20 = r113;
        goto L46
    L68:
        return r12;
    L69:
        return null;
    }

    public final void k(List r10) {
        if (ListUtils.b(r10) == false) goto L5;
        return;
    L5:
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L20;
        d r12 = (d) r11.next();
        if (TextUtils.equals(d.a(r12), this.f26057a) == true) goto L10;
        if (TextUtils.equals(d.a(r12), this.f26059c) == true) goto L13;
        if (TextUtils.equals(d.a(r12), this.f26058b) == true) goto L16;
        if (TextUtils.equals(d.a(r12), this.f26060d) == false) goto L7;
        this.f26070n = r12.f26085c;
        goto L7
    L16:
        this.f26069m = r12.f26085c;
        goto L7
    L13:
        this.f26068l = r12.f26085c;
        goto L7
    L10:
        this.f26067k = r12.f26085c;
        goto L7
    }

    public final void l(File r10, List r11) {
        File[] r12 = r10.listFiles();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.length == 0) goto L12;
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        i(r12[r14], r11);
        r14 = r14 + 1;
        goto L8
    L13:
        return;
    }

    public y2.b m(z2.a r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (this.f26061e == false) goto L8;
        return null;
    L8:
        this.f26066j = r10;
        B();
        this.f26062f = H(r10.f());
        this.f26063g = H(r10.b());
        this.f26064h = H(r10.a());
        return f();
    }

    public final JSONArray o(List r10, long r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L36;
        BigDecimal r12 = new BigDecimal(r11);
        JSONArray r13 = new JSONArray();
        Iterator r14 = r10.iterator();
    L7:
        if (r14.hasNext() == false) goto L24;
        b r15 = (b) r14.next();
        if (D(r15) == false) goto L11;
        r15.f26074c = 0.0f;
    L12:
        List r16 = r15.f26077f;
        if (r16 == null) goto L23;
        if (r16.size() <= 0) goto L23;
        Iterator r17 = r16.iterator();
    L18:
        if (r17.hasNext() == false) goto L23;
        b r18 = (b) r17.next();
        if (D(r18) == true) goto L21;
        r18.f26074c = A(r18.f26073b, r12);
        goto L18
    L21:
        r18.f26074c = 0.0f;
    L23:
        r13.put(r15.b());
        goto L7
    L11:
        r15.f26074c = A(r15.f26073b, r12);
        goto L12
    L24:
        return r13;
    L36:
        return null;
    }

    public JSONArray p(w r10) {
        JSONArray r11 = new JSONArray();
        Iterator r12 = r10.d().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        JSONObject r13 = ((C0412c) r12.next()).c();
        if (r13 == null) goto L4;
        r11.put(r13);
        goto L4
    L8:
        return r11;
    }

    public final y2.b q(w r29, w r30, w r31, List r32) {
        long r10 = this.f26067k + this.f26068l;     // Catch: Throwable -> L9
        long r11 = this.f26069m + this.f26070n;     // Catch: Throwable -> L9
        long r12 = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();     // Catch: Throwable -> L9
        long r14 = Environment.getDataDirectory().getFreeSpace();     // Catch: Throwable -> L9
        long r13 = Math.min(r10, 17179869184L);     // Catch: Throwable -> L9
        long r15 = Math.min(r11, 17179869184L);     // Catch: Throwable -> L9
        if (r13 >= 0) goto L7;
        return null;
    L7:
        if (this.f26071o == null) goto L11;
        this.f26071o.onDetectException(this.f26066j.c(), r13, n(r29), n(r30), n(r31));     // Catch: Throwable -> L9
    L11:
        Pair r16 = z();     // Catch: Throwable -> L9
        long r17 = s();     // Catch: Throwable -> L9
        if (r3.a.c() == false) goto L15;
        s3.a.a("APM-Disk", "appUsage:" + r17);     // Catch: Throwable -> L9
    L15:
        return new y2.b(r10, r15, r12, r14, r17, ((Long) r16.first).longValue(), ((Long) r16.second).longValue(), A(r17, new BigDecimal(r12)), p(r29), p(r30), p(r31), o(r32, r13));
    L9:
        th = move-exception;
        Log.e("APM-Disk", "error", th);
        return null;
    }

    public final String r(String r10) {
        if (ListUtils.b(this.f26064h) == true) goto L11;
        if (r10 == null) goto L16;
        Iterator r11 = this.f26064h.iterator();
    L7:
        if (r11.hasNext() == false) goto L17;
        String r12 = (String) r11.next();
        if (r10.startsWith(r12) == false) goto L7;
        return r12;
    L17:
        return null;
    L16:
        return null;
    L11:
        return null;
    }

    public final long s() {
        Application r10 = r3.a.b();     // Catch: Throwable -> L8
        String r11 = r10.getPackageName();     // Catch: Throwable -> L8
        StorageStats r12 = ((StorageStatsManager) r10.getSystemService("storagestats")).queryStatsForUid(((StorageManager) r10.getSystemService("storage")).getUuidForPath(new File(r10.getDataDir().getParent(), r11)), r10.getPackageManager().getApplicationInfo(r11, 128).uid);     // Catch: Throwable -> L8
        if (r3.a.c() == false) goto L6;
        Log.e("APM-Disk", "storageStats.getAppBytes():" + r12.getAppBytes());     // Catch: Throwable -> L8
    L6:
        return r12.getAppBytes();
    L8:
        long r13 = v(new File(r3.a.b().getPackageManager().getApplicationInfo(r3.a.b().getPackageName(), 0).sourceDir).getParentFile());     // Catch: Exception -> L14
        if (r3.a.c() == false) goto L11;
        Log.e("APM-Disk", "storageStats.getAppBytes():" + (((x() + r13) + this.f26067k) + this.f26068l));     // Catch: Exception -> L14
    L11:
        return ((r13 + x()) + this.f26067k) + this.f26068l;
    L14:
        return 0;
    }

    public final String t(String r10) {
        String r11 = r(r10);
        if (r11 == null) goto L7;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r11 + r10.substring(r11.length()).replaceAll("[^/]", "*");
    L7:
        return null;
    }

    public final String u(Context r10) {
        return r10.getExternalFilesDir(null).getParentFile().getAbsolutePath();
    L8:
        return null;
    }

    public final long v(File r10) {
        long r11 = 0;
        File[] r12 = r10.listFiles();     // Catch: Exception -> L14
        if (r12 != null) goto L6;
    L19:
        return 0;
    L6:
        if (r12.length == 0) goto L19;
        int r13 = r12.length;     // Catch: Exception -> L14
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L21;
        File r15 = r12[r14];     // Catch: Exception -> L14
        if (r15.isDirectory() == false) goto L16;
        long r16 = v(r15);     // Catch: Exception -> L14
    L13:
        r11 = r11 + r16;     // Catch: Exception -> L14
        r14 = r14 + 1;
        goto L9
    L16:
        r16 = r15.length();     // Catch: Exception -> L14
    L21:
        return r11;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    public final long x() {
        File[] r10 = r3.a.b().getApplicationContext().getExternalMediaDirs();
        int r11 = r10.length;
        long r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12 = r12 + v(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    public final long y(long r10) {
        long r11 = System.currentTimeMillis() - r10;
        if (r11 >= this.f26066j.g()) goto L5;
        return 0;
    L5:
        if (r11 >= 62899200000L) goto L9;
        return r11;
    L9:
        return 0;
    }

    public final Pair z() {
        StorageStatsManager r10 = (StorageStatsManager) r3.a.b().getSystemService("storagestats");     // Catch: Throwable -> L12
        StorageManager r11 = (StorageManager) r3.a.b().getSystemService("storage");     // Catch: Throwable -> L12
        Iterator<StorageVolume> r12 = r11.getStorageVolumes().iterator();     // Catch: Throwable -> L12
        long r13 = 0;
        long r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L10;
        String r15 = r12.next().getUuid();     // Catch: Throwable -> L12
        if (r15 != null) goto L8;
        UUID r16 = StorageManager.UUID_DEFAULT;     // Catch: Throwable -> L12
    L9:
        r13 = r13 + r10.getTotalBytes(r16);     // Catch: Throwable -> L12
        r14 = r14 + r11.getAllocatableBytes(r16);     // Catch: Throwable -> L12
        goto L4
    L8:
        r16 = UUID.fromString(r15);     // Catch: Throwable -> L12
        goto L9
    L10:
        return new Pair(Long.valueOf(((r13 / 1000) / 1000) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED), Long.valueOf(((r14 / 1000) / 1000) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED));
    L13:
        return new Pair(Long.valueOf(r3.c.d(Environment.getDataDirectory().getPath()) + r3.c.d(Environment.getRootDirectory().getPath())), Long.valueOf(r3.c.c(Environment.getDataDirectory().getPath())));
    }
}
