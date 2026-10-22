package v1;

import android.content.Context;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.n;
import com.bytedance.apm.util.w;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends v1.a {
    public static long C = 17179869184L;
    public static String D;
    public static String E;
    public w A;
    public w B;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f24985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f24986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f24987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f24988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f24989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f24990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IStorageCheckListener f24991m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f24992n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f24993o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f24994p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f24995q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f24996r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f24997s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f24998t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List f24999u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List f25000v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List f25001w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List f25002x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List f25003y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public w f25004z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f25005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f25006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f25007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f25008d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ f f25009e;

        public a(f r10, long r11, List r12, List r13, List r14) {
            this.f25009e = r10;
            this.f25005a = r11;
            this.f25006b = r12;
            this.f25007c = r13;
            this.f25008d = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.o(this.f25009e).onDetectException(f.n(this.f25009e), this.f25005a, this.f25006b, this.f25007c, this.f25008d);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f25011b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f25012c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f25013d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f25014e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f25015f;

        public b() {
            this.f25014e = "normal";
            this.f25015f = new ArrayList();
        }

        public final String a() {
            String r10 = this.f25010a;
            if (r10.contains(f.z()) == false) goto L6;
            return r10.replace(f.z(), "internal");
        L6:
            if (r10.contains(f.p()) == true) goto L8;
            return r10;
        L8:
            return r10.replace(f.p(), "external");
        }

        public JSONObject b() {
            JSONObject r10 = new JSONObject();
            r10.put("path", a());     // Catch: JSONException -> L9
            r10.put("size", this.f25011b);     // Catch: JSONException -> L9
            r10.put("size_rate", this.f25012c);     // Catch: JSONException -> L9
            r10.put("is_folder", this.f25013d);     // Catch: JSONException -> L9
            r10.put("report_type", this.f25014e);     // Catch: JSONException -> L9
            if (this.f25015f.isEmpty() == true) goto L14;
            JSONArray r11 = new JSONArray();     // Catch: JSONException -> L9
            Iterator r12 = this.f25015f.iterator();     // Catch: JSONException -> L9
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

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    public static class c implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f25017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f25018c;

        public c() {
        }

        public static /* synthetic */ String a(c r10) {
            return r10.f25016a;
        }

        private String b() {
            String r10 = this.f25016a;
            if (r10.contains(f.z()) == false) goto L6;
            return r10.replace(f.z(), "internal");
        L6:
            if (r10.contains(f.p()) == true) goto L8;
            return r10;
        L8:
            return r10.replace(f.p(), "external");
        }

        public JSONObject c() {
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L6
            r10.put("name", b());     // Catch: Exception -> L6
            r10.put("size", this.f25017b);     // Catch: Exception -> L6
            int r11 = this.f25018c;     // Catch: Exception -> L6
            if (r11 <= 0) goto L5;
            r10.put("num", r11);     // Catch: Exception -> L6
        L5:
            return r10;
        L6:
            return null;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r10) {
            long r11 = this.f25017b;
            long r12 = ((c) r10).f25017b;
            if (r11 != r12) goto L7;
            return 0;
        L7:
            if (r11 <= r12) goto L10;
            return 1;
        L10:
            return -1;
        }

        public c(String r10, long r11, int r12) {
            this.f25016a = r10;
            this.f25017b = r11;
            this.f25018c = r12;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f25020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f25021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f25022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f25023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f25024f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f25025g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f25026h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ f f25027i;

        public d(f r10) {
            this.f25027i = r10;
        }

        public static /* synthetic */ String a(d r10) {
            return r10.f25019a;
        }

        public static /* synthetic */ String b(d r10, String r11) {
            r10.f25019a = r11;
            return r11;
        }

        public static /* synthetic */ int c(d r10, int r11) {
            r10.f25022d = r11;
            return r11;
        }

        public static /* synthetic */ int d(d r10) {
            int r11 = r10.f25022d;
            r10.f25022d = r11 - 1;
            return r11;
        }

        public static /* synthetic */ boolean e(d r10) {
            return r10.f25024f;
        }

        public static /* synthetic */ boolean f(d r10, boolean r11) {
            r10.f25024f = r11;
            return r11;
        }

        public static /* synthetic */ long g(d r10, long r11) {
            r10.f25025g = r11;
            return r11;
        }

        public void h(long r10) {
            this.f25021c += r10;
            this.f25023e++;
            if (this.f25020b != null) goto L5;
            return;
        L5:
            if (j() == true) goto L7;
            return;
        L7:
            if (this.f25026h == false) goto L10;
            this.f25020b.f25026h = true;
        L10:
            if (this.f25021c >= f.q(this.f25027i)) goto L12;
        L14:
            this.f25020b.h(this.f25021c);
            if (this.f25024f == false) goto L17;
            f.s(this.f25027i, this.f25019a, this.f25021c, this.f25022d, this.f25025g);
        L17:
            i();
            return;
        L12:
            if (this.f25026h == true) goto L14;
            f.r(this.f25027i, this.f25019a, this.f25021c, this.f25023e, this.f25022d);
            this.f25020b.f25026h = true;
            goto L14
        }

        public final void i() {
            if (TextUtils.equals(this.f25019a, f.z()) == false) goto L6;
            f.t(this.f25027i, this.f25021c);
            return;
        L6:
            if (TextUtils.equals(this.f25019a, f.p()) == false) goto L9;
            f.u(this.f25027i, this.f25021c);
            return;
        L9:
            if (TextUtils.equals(this.f25019a, f.v(this.f25027i)) == false) goto L12;
            f.w(this.f25027i, this.f25021c);
            return;
        L12:
            if (TextUtils.equals(this.f25019a, f.x(this.f25027i)) == false) goto L18;
            f.y(this.f25027i, this.f25021c);
            return;
        }

        public final boolean j() {
            if (this.f25023e != this.f25022d) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ d(f r10, a r11) {
            this(r10);
        }
    }

    public static class e extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f25028d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f25029e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f25030f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f25031g;

        public e(String r10, long r11, int r12, long r13) {
            this.f25028d = r10;
            this.f25029e = r11;
            this.f25030f = r12;
            this.f25031g = r13;
        }

        public final String b() {
            String r10 = this.f25028d;
            if (r10.contains(f.z()) == false) goto L6;
            return r10.replace(f.z(), "internal");
        L6:
            if (r10.contains(f.p()) == true) goto L8;
            return r10;
        L8:
            return r10.replace(f.p(), "external");
        }

        @Override // v1.f.c
        public JSONObject c() {
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L7
            r10.put("name", b());     // Catch: Exception -> L7
            r10.put("size", this.f25029e);     // Catch: Exception -> L7
            int r11 = this.f25030f;     // Catch: Exception -> L7
            if (r11 <= 0) goto L5;
            r10.put("num", r11);     // Catch: Exception -> L7
        L5:
            r10.put(PerfConsts.PERF_DISK_FILE_OUTDATE_INTERVAL, this.f25031g);     // Catch: Exception -> L7
            return r10;
        L7:
            return null;
        }

        @Override // v1.f.c, java.lang.Comparable
        public int compareTo(Object r10) {
            long r11 = this.f25031g;
            long r12 = ((e) r10).f25031g;
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
    }

    public f() {
        this.f24987i = 524288000;
        this.f24988j = 524288000;
        this.f24989k = 20;
        this.f24990l = 2592000000L;
        this.f25000v = new ArrayList();
        this.f25001w = new ArrayList();
        this.f25002x = new ArrayList();
        this.f25003y = new ArrayList();
        this.f24971e = "disk";
    }

    public static List G(w r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        LinkedList r11 = new LinkedList();
        Iterator r12 = r10.d().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add(c.a((c) r12.next()));
        goto L7
    L9:
        return r11;
    }

    public static /* synthetic */ long n(f r10) {
        return r10.f24987i;
    }

    public static /* synthetic */ IStorageCheckListener o(f r10) {
        return r10.f24991m;
    }

    public static /* synthetic */ String p() {
        return E;
    }

    public static /* synthetic */ long q(f r10) {
        return r10.f24988j;
    }

    public static /* synthetic */ void r(f r10, String r11, long r12, int r13, int r14) {
        r10.B(r11, r12, r13, r14);
    }

    public static /* synthetic */ void s(f r10, String r11, long r12, int r13, long r14) {
        r10.C(r11, r12, r13, r14);
    }

    public static /* synthetic */ long t(f r10, long r11) {
        r10.f24994p = r11;
        return r11;
    }

    public static /* synthetic */ long u(f r10, long r11) {
        r10.f24995q = r11;
        return r11;
    }

    public static /* synthetic */ String v(f r10) {
        return r10.f24992n;
    }

    public static /* synthetic */ long w(f r10, long r11) {
        r10.f24996r = r11;
        return r11;
    }

    public static /* synthetic */ String x(f r10) {
        return r10.f24993o;
    }

    public static /* synthetic */ long y(f r10, long r11) {
        r10.f24997s = r11;
        return r11;
    }

    public static /* synthetic */ String z() {
        return D;
    }

    public final void A(String r10, long r11) {
        if (w0.c.B() == false) goto L6;
        s1.c.b("MonitorStorage", new String[]{"appendExceptionFileQueue: path: " + r10 + ", size: " + r11});
    L6:
        if (r11 <= C) goto L9;
        return;
    L9:
        if (this.f25004z != null) goto L11;
        this.f25004z = new w(this.f24989k);
    L11:
        this.f25004z.a(new c(r10, r11, 1));
    }

    public final void B(String r10, long r11, int r12, int r13) {
        if (w0.c.B() == false) goto L6;
        Log.d("MonitorStorage", "appendExceptionFolderQueue: path: " + r10 + ":  size: " + r11 + " , accumulateNum: " + r12 + " , num: " + r13);
    L6:
        if (r11 <= C) goto L9;
        return;
    L9:
        if (this.A != null) goto L11;
        this.A = new w(this.f24989k);
    L11:
        this.A.a(new c(r10, r11, r13));
    }

    public final void C(String r10, long r11, int r12, long r13) {
        if (w0.c.B() == false) goto L6;
        s1.c.b("MonitorStorage", new String[]{"appendutdatedFileQueue: path: " + r10 + ", size: " + r11});
    L6:
        if (r11 >= 102400) goto L8;
        return;
    L8:
        if (r11 <= C) goto L11;
        return;
    L11:
        if (this.B != null) goto L13;
        this.B = new w(this.f24989k);
    L13:
        this.B.a(new e(r10, r11, r12, r13));
    }

    public final long D(long r10) {
        return r10 / 1073741824;
    }

    public final void E(File r10, int r11, boolean r12, List r13) {
        if (r11 > 2) goto L49;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.exists() == true) goto L8;
        return;
    L8:
        if (this.f25002x.contains(r10.getAbsolutePath()) == true) goto L53;
        int r14 = 0;
        a r15 = null;
        if (r10.isDirectory() == false) goto L37;
        if (r12 == false) goto L36;
        File[] r16 = r10.listFiles();
        if (r16 != null) goto L16;
        return;
    L16:
        if (r16.length == 0) goto L48;
        int r17 = r16.length;
    L19:
        if (r14 >= r17) goto L54;
        File r18 = r16[r14];
        if (r18 == null) goto L34;
        if (r18.exists() == false) goto L34;
        if (this.f25002x.contains(r18.getAbsolutePath()) == true) goto L34;
        b r19 = new b(r15);
        r19.f25013d = r18.isDirectory();
        r19.f25010a = r18.getAbsolutePath();
        if (r18.isDirectory() == false) goto L33;
        ArrayList r20 = new ArrayList();
        r19.f25015f = r20;
        if (r11 != 2) goto L32;
        r19.f25011b = H(r18);
    L32:
        E(r18, r11 + 1, r12, r20);
        r13.add(r19);
        goto L34
    L33:
        r19.f25011b = r18.length();
        r13.add(r19);
    L34:
        r14 = r14 + 1;
        goto L19
    L54:
        return;
    L48:
        return;
    L36:
        b r110 = new b(r15);
        r110.f25013d = true;
        r110.f25014e = "custom";
        r110.f25010a = r10.getAbsolutePath();
        r110.f25011b = H(r10);
        r13.add(r110);
        return;
    L37:
        b r21 = new b(r15);
        r21.f25013d = false;
        r21.f25010a = r10.getAbsolutePath();
        r21.f25011b = r10.length();
        if (r12 == true) goto L40;
        r21.f25014e = "custom";
    L40:
        r13.add(r21);
        return;
    L53:
        return;
    }

    public void F() {
        String[] r10 = {D, E};
        this.f24999u = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 >= 2) goto L58;
        String r12 = r10[r11];
        E(new File(r12), 1, true, this.f24999u);
        File r13 = new File(r12);
        a r14 = null;
        d r15 = new d(this, r14);
        d.b(r15, r12);
        r15.f25020b = new d(this, r14);
        File[] r16 = r13.listFiles();
        if (r16 == null) goto L57;
        if (r16.length == 0) goto L57;
        d.c(r15, r16.length);
        LinkedList r17 = new LinkedList();
        r17.offer(r15);
    L12:
        if (r17.isEmpty() == true) goto L57;
        int r18 = r17.size();
        int r19 = 0;
    L14:
        if (r19 >= r18) goto L12;
        d r20 = (d) r17.poll();
        if (r20 != null) goto L19;
        int r110 = r11;
    L18:
        LinkedList r21 = r17;
    L55:
        r19 = r19 + 1;
        r17 = r21;
        r11 = r110;
        r14 = null;
        goto L14
    L19:
        String r22 = d.a(r20);
        File r23 = new File(r22);
        if (r23.exists() == true) goto L22;
    L23:
        r110 = r11;
        r21 = r17;
        d.d(r20.f25020b);
        goto L55
    L22:
        if (this.f25002x.contains(r22) == true) goto L23;
        if (r23.isFile() == false) goto L36;
        r110 = r11;
        long r24 = r23.length();
        if (r24 <= 0) goto L29;
        A(r22, r24);
    L29:
        d r25 = r20.f25020b;
        if (r25 == null) goto L18;
        r25.h(r24);
        if (d.e(r20.f25020b) == true) goto L18;
        long r111 = N(r23.lastModified());
        if (r111 <= 0) goto L18;
        C(r22, r24, 0, r111);
        goto L18
    L36:
        r110 = r11;
        File[] r26 = r23.listFiles();
        if (r26 != null) goto L39;
    L40:
        r21 = r17;
        r20.f25020b.h(0);
        goto L55
    L39:
        if (r26.length == 0) goto L40;
        d.c(r20, r26.length);
        int r27 = r26.length;
        int r28 = 0;
    L42:
        if (r28 >= r27) goto L18;
        File r29 = r26[r28];
        d r30 = new d(this, r14);
        r30.f25020b = r20;
        d.b(r30, r29.getAbsolutePath());
        if (r29.isDirectory() == true) goto L46;
    L51:
        LinkedList r31 = r17;
    L52:
        r31.offer(r30);
        r28 = r28 + 1;
        r17 = r31;
        r14 = null;
        goto L42
    L46:
        if (d.e(r20) == true) goto L51;
        LinkedList r112 = r17;
        long r113 = N(r29.lastModified());
        if (r113 <= 0) goto L50;
        d.f(r30, true);
        d.g(r30, r113);
    L50:
        r31 = r112;
    L57:
        r11 = r11 + 1;
        goto L4
    L58:
        List r32 = this.f25003y;
        if (r32 != null) goto L61;
    L66:
        Iterator r33 = this.f24999u.iterator();
    L68:
        if (r33.hasNext() == false) goto L79;
        b r34 = (b) r33.next();
        if ("normal".equals(r34.f25014e) == false) goto L68;
        List r35 = r34.f25015f;
        if (r35 == null) goto L68;
        if (r35.isEmpty() == true) goto L68;
        Iterator r36 = r35.iterator();
    L77:
        if (r36.hasNext() == false) goto L68;
        r34.f25011b += ((b) r36.next()).f25011b;
        goto L77
    L79:
        return;
    L61:
        if (r32.size() <= 0) goto L66;
        Iterator r37 = this.f25003y.iterator();
    L64:
        if (r37.hasNext() == false) goto L66;
        E(new File((String) r37.next()), 1, false, this.f24999u);
        goto L64
    }

    public final long H(File r10) {
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
        long r16 = H(r15);     // Catch: Exception -> L14
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

    public final float I(long r10, BigDecimal r11) {
        return (float) new BigDecimal(r10).divide(r11, 4, 4).doubleValue();
    }

    public final void J() {
        F();     // Catch: Throwable -> L4
        O(this.f24994p + this.f24995q, this.f24996r + this.f24997s, Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());     // Catch: Throwable -> L4
        com.bytedance.apm.internal.b.a().f(PerfConsts.DISK_SP_KEY_CHECK_TIME, System.currentTimeMillis());     // Catch: Throwable -> L4
        return;
    }

    public final void K() {
        O(com.bytedance.apm.util.b.k(w0.c.g()), com.bytedance.apm.util.b.j(w0.c.g()), com.bytedance.apm.util.b.c(), Environment.getDataDirectory().getFreeSpace());     // Catch: Exception -> L4
        return;
    }

    public final void L() {
        if (D == null) goto L5;
        return;
    L5:
        Context r10 = w0.c.g();
        r10.getPackageName();     // Catch: Exception -> L33
        D = r10.getFilesDir().getParent();     // Catch: Exception -> L33
        this.f24992n = r10.getCacheDir().getAbsolutePath();     // Catch: Exception -> L33
        E = r10.getExternalFilesDir(null).getParentFile().getAbsolutePath();     // Catch: Exception -> L33
        File r11 = r10.getExternalCacheDir();     // Catch: Exception -> L33
        if (r11 == null) goto L9;
        this.f24993o = r11.getAbsolutePath();     // Catch: Exception -> L33
    L9:
        List r12 = this.f25001w;     // Catch: Exception -> L33
        if (r12 == null) goto L21;
        Iterator r13 = r12.iterator();     // Catch: Exception -> L33
    L14:
        if (r13.hasNext() == false) goto L21;
        String r14 = (String) r13.next();     // Catch: Exception -> L33
        if (r14.contains("internal") == true) goto L17;
        if (r14.contains("external") == false) goto L14;
        this.f25002x.add(r14.replace("external", E));     // Catch: Exception -> L33
        goto L14
    L17:
        this.f25002x.add(r14.replace("internal", D));     // Catch: Exception -> L33
    L21:
        List r15 = this.f25000v;     // Catch: Exception -> L33
        if (r15 == null) goto L53;
        Iterator r16 = r15.iterator();     // Catch: Exception -> L33
    L24:
        if (r16.hasNext() == false) goto L54;
        String r17 = (String) r16.next();     // Catch: Exception -> L33
        if (r17.contains("internal") == true) goto L28;
        if (r17.contains("external") == false) goto L24;
        this.f25003y.add(r17.replace("external", E));     // Catch: Exception -> L33
        goto L24
    L28:
        this.f25003y.add(r17.replace("internal", D));     // Catch: Exception -> L33
        goto L24
    L54:
        return;
    L53:
        return;
    L33:
        this.f24998t = true;
    }

    public final boolean M(b r10) {
        Iterator r11 = this.f25002x.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        String r12 = (String) r11.next();
        if (r10.f25010a.contains(r12) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final long N(long r10) {
        long r11 = System.currentTimeMillis() - r10;
        if (r11 >= this.f24990l) goto L5;
        return 0;
    L5:
        if (r11 >= 62899200000L) goto L9;
        return r11;
    L9:
        return 0;
    }

    public final void O(long r10, long r11, long r12, long r14) {
        if (w0.c.B() == false) goto L5;
        s1.c.d(s1.b.f24485c, new String[]{"disk: data: " + r10 + " , cache: " + r11 + " , total: " + r12 + " , free: " + r14});     // Catch: Exception -> L86
    L5:
        long r13 = C;     // Catch: Exception -> L86
        if (r10 <= r13) goto L8;
        long r15 = r13;
    L10:
        if (r11 > r13) goto L13;
        r13 = r11;
    L13:
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L86
        if (r10 <= 0) goto L17;
        r16.put("data", r15);     // Catch: Exception -> L86
    L17:
        if (r11 <= 0) goto L20;
        r16.put("cache", r13);     // Catch: Exception -> L86
    L20:
        if (r12 <= 0) goto L23;
        r16.put(PerfConsts.PERF_DISK_TOTAL, D(r12));     // Catch: Exception -> L86
    L23:
        if (r14 <= 0) goto L25;
        r16.put(PerfConsts.PERF_DISK_ROM_FREE, D(r14));     // Catch: Exception -> L86
    L25:
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L86
        if (this.f24986h == true) goto L28;
    L84:
        j(new m1.e("disk", SlardarSettingsConsts.PERF_DISK_SAMPLE_METRIC, false, r16, null, r17));     // Catch: Exception -> L86
        return;
    L28:
        if (r15 <= this.f24987i) goto L84;
        if (this.f25004z == null) goto L39;
        JSONArray r18 = new JSONArray();     // Catch: Exception -> L86
        Iterator r19 = this.f25004z.d().iterator();     // Catch: Exception -> L86
    L33:
        if (r19.hasNext() == false) goto L37;
        JSONObject r110 = ((c) r19.next()).c();     // Catch: Exception -> L86
        if (r110 == null) goto L33;
        r18.put(r110);     // Catch: Exception -> L86
        goto L33
    L37:
        r17.put(PerfConsts.PERF_DISK_TOP_USAGE, r18);     // Catch: Exception -> L86
    L39:
        if (this.A == null) goto L48;
        JSONArray r20 = new JSONArray();     // Catch: Exception -> L86
        Iterator r21 = this.A.d().iterator();     // Catch: Exception -> L86
    L42:
        if (r21.hasNext() == false) goto L46;
        JSONObject r111 = ((c) r21.next()).c();     // Catch: Exception -> L86
        if (r111 == null) goto L42;
        r20.put(r111);     // Catch: Exception -> L86
        goto L42
    L46:
        r17.put(PerfConsts.PERF_DISK_EXCEPTION_FOLDERS, r20);     // Catch: Exception -> L86
    L48:
        if (this.B == null) goto L56;
        JSONArray r22 = new JSONArray();     // Catch: Exception -> L86
        Iterator r23 = this.B.d().iterator();     // Catch: Exception -> L86
    L51:
        if (r23.hasNext() == false) goto L55;
        JSONObject r112 = ((e) r23.next()).c();     // Catch: Exception -> L86
        if (r112 == null) goto L51;
        r22.put(r112);     // Catch: Exception -> L86
        goto L51
    L55:
        r17.put(PerfConsts.PERF_DISK_OUTDATED_FILES, r22);     // Catch: Exception -> L86
    L56:
        List r24 = this.f24999u;     // Catch: Exception -> L86
        if (r24 == null) goto L81;
        if (r24.isEmpty() == true) goto L81;
        BigDecimal r25 = new BigDecimal(r15);     // Catch: Exception -> L86
        JSONArray r26 = new JSONArray();     // Catch: Exception -> L86
        Iterator r113 = this.f24999u.iterator();     // Catch: Exception -> L86
    L62:
        if (r113.hasNext() == false) goto L79;
        b r114 = (b) r113.next();     // Catch: Exception -> L86
        if (M(r114) == false) goto L66;
        r114.f25012c = 0.0f;     // Catch: Exception -> L86
    L67:
        List r115 = r114.f25015f;     // Catch: Exception -> L86
        if (r115 == null) goto L78;
        if (r115.size() <= 0) goto L78;
        Iterator r116 = r115.iterator();     // Catch: Exception -> L86
    L73:
        if (r116.hasNext() == false) goto L78;
        b r117 = (b) r116.next();     // Catch: Exception -> L86
        if (M(r117) == true) goto L76;
        r117.f25012c = I(r117.f25011b, r25);     // Catch: Exception -> L86
        goto L73
    L76:
        r117.f25012c = 0.0f;     // Catch: Exception -> L86
    L78:
        r26.put(r114.b());     // Catch: Exception -> L86
        goto L62
    L66:
        r114.f25012c = I(r114.f25011b, r25);     // Catch: Exception -> L86
        goto L67
    L79:
        r17.put(PerfConsts.PERF_DISK_DISK_INFO, r26);     // Catch: Exception -> L86
    L81:
        if (this.f24991m == null) goto L83;
        AsyncEventManager.e().n(new a(this, r15, G(this.f25004z), G(this.A), G(this.B)));     // Catch: Exception -> L86
    L83:
        this.f25004z = null;     // Catch: Exception -> L86
        this.A = null;     // Catch: Exception -> L86
        this.B = null;     // Catch: Exception -> L86
        this.f24999u = null;     // Catch: Exception -> L86
        goto L84
    L8:
        r15 = r10;
    }

    public void P(IStorageCheckListener r10) {
        this.f24991m = r10;
    }

    @Override // v1.a
    public void b(JSONObject r10) {
        boolean r11 = r10.optBoolean("dump_switch", true);
        this.f24986h = r11;
        if (r11 == false) goto L22;
        long r12 = com.bytedance.apm.internal.b.a().c(PerfConsts.DISK_SP_KEY_CHECK_TIME);
        long r13 = System.currentTimeMillis() - r12;
        if (r13 >= 86400000) goto L10;
        if (r13 <= 0) goto L10;
        this.f24985g = true;
    L10:
        if (r10.optInt("dump_threshold") <= 0) goto L13;
        this.f24987i = ((long) r10.optInt("dump_threshold")) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    L13:
        if (r10.optInt("abnormal_folder_size") <= 0) goto L16;
        this.f24988j = ((long) r10.optInt("abnormal_folder_size")) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    L16:
        if (r10.optInt("dump_top_count") <= 0) goto L19;
        this.f24989k = r10.optInt("dump_top_count");
    L19:
        if (r10.optInt("outdated_days") <= 0) goto L21;
        this.f24990l = ((long) r10.optInt("outdated_days")) * 86400000;
    L21:
        this.f25000v = n.e(r10, "disk_customed_paths");
        this.f25001w = n.d(r10, "ignored_relative_paths");
    L22:
        this.f24985g = true;
    }

    @Override // v1.a
    public boolean e() {
        return true;
    }

    @Override // v1.a
    public void h() {
        boolean r10 = d();
        if (this.f24985g == true) goto L16;
        if (r10 == false) goto L17;
        L();
        if (this.f24998t == false) goto L11;
        this.f24985g = true;
        return;
    L11:
        if (this.f24986h == false) goto L13;
        J();
    L14:
        this.f24985g = true;
        l();
        a();
        return;
    L13:
        K();
        goto L14
    L17:
        return;
    }

    @Override // v1.a
    public long m() {
        return 120000;
    }
}
