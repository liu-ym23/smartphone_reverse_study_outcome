package bi4;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.g;
import com.bytedance.crash.i;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.j;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f19100i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f19101j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f19102k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f19103l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f19104m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f19105n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f19106o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f19107p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile a f19108q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, c> f19112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<c> f19113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d[] f19114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedList<e> f19115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<WeakReference<Activity>> f19116h;

    /* JADX INFO: renamed from: bi4.a$a, reason: collision with other inner class name */
    public static class C0307a implements Comparator<Map.Entry<Integer, c>> {
        public C0307a() {
        }

        @Override // java.util.Comparator
        public final int compare(Map.Entry<Integer, c> r100, Map.Entry<Integer, c> r101) {
            long r102 = r100.getValue().f19122e - r101.getValue().f19122e;
            if (r102 <= 0) goto L5;
            return 1;
        L5:
            if (r102 >= 0) goto L7;
            return -1;
        L7:
            return 0;
        }
    }

    public class b implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f19117a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        public b(a r100) {
            this.f19117a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            a.a(this.f19117a, 5, r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            a r101 = this.f19117a;
            r101.getClass();
            r101.f19109a = r100.getClass().getName();
            a r102 = this.f19117a;
            int r103 = r102.f19111c - 1;
            r102.f19111c = r103;
            if (r103 != 0) goto L5;
            r102.f19110b = false;
            a.f19103l = false;
        L7:
            a.a(r102, 3, r100);
            return;
        L5:
            if (r103 >= 0) goto L7;
            r102.f19111c = 0;
            r102.f19110b = false;
            a.f19103l = false;
            goto L7
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            a.a(this.f19117a, 2, r100);
            this.f19117a.getClass();
            String r101 = r100.getClass().getName();
            long r102 = System.currentTimeMillis();
            a r103 = this.f19117a;
            r103.f19111c++;
            if (r103.f19110b == true) goto L19;
            r103.f19110b = true;
            if (a.f19100i == false) goto L8;
            a.f19100i = false;
            a.f19101j = 1;
            a.f19102k = r102;
        L8:
            if (r101.equals(r103.f19109a) == true) goto L11;
            return;
        L11:
            if (a.f19103l == false) goto L16;
            if (a.f19104m == true) goto L16;
            a.f19101j = 4;
            a.f19102k = r102;
            return;
        L16:
            if (a.f19103l == true) goto L21;
            a.f19101j = 3;
            a.f19102k = r102;
            return;
        L21:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            a.a(this.f19117a, 1, r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            a.a(this.f19117a, 4, r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            if (r101 == null) goto L5;
            boolean r102 = true;
        L6:
            a.f19104m = r102;
            a.a(this.f19117a, 0, r100);
            a.f19103l = true;
            this.f19117a.f19116h.add(new WeakReference(r100));
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f19121d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f19122e;

        public c(String r100, long r101, int r102) {
            this.f19118a = r100;
            this.f19119b = r102;
            this.f19122e = r101;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f19123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19124b;

        public d() {
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f19125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19127c;

        public e() {
        }

        public static String a(long r100, String r101, int r102, int r103) {
            StringBuilder r104 = new StringBuilder();
            if (com.bytedance.crash.util.c.f203407a != null) goto L5;
            com.bytedance.crash.util.c.f203407a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        L5:
            r104.append(com.bytedance.crash.util.c.f203407a.format(new Date(r100)));
            r104.append(" : ");
            r104.append(r101);
            r104.append('.');
            r104.append(a.f19107p[r103]);
            r104.append('@');
            r104.append(Long.toHexString(r102));
            return r104.toString();
        }
    }

    static {
        f19106o = new String[]{"last_create_activity", "last_start_activity", "last_resume_activity", "last_pause_activity", "last_stop_activity", "last_destroy_activity"};
        f19107p = new String[]{WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY};
    }

    public static JSONArray c() {
        JSONArray r100 = new JSONArray();
        Iterator r101 = new ArrayList(d().f19115g).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        e r102 = (e) r101.next();
        long r103 = r102.f19126b;
        c r104 = r102.f19125a;
        r100.put(e.a(r103, r104.f19118a, r104.f19119b, r102.f19127c));
        goto L4
    L6:
        return r100;
    }

    public static a d() {
        if (f19108q != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f19108q != null) goto L9;
        f19108q = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f19108q;
    }

    public final boolean f() {
        ArrayList r100 = new ArrayList(((HashMap) this.f19112d).entrySet());
        int r101 = 0;
    L4:
        if (r101 >= r100.size()) goto L10;
        if (((c) ((Map.Entry) ListProtector.get(r100, r101)).getValue()).f19120c < 3) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public a() {
        this.f19112d = new HashMap();
        this.f19113e = new ArrayList();
        this.f19114f = new d[6];
        this.f19115g = new LinkedList();
        this.f19116h = new ArrayList();
        Application r100 = i.a().f203223c;
        if (Build.VERSION.SDK_INT < 24) goto L9;
        if (r100 == null) goto L9;
        r100.registerActivityLifecycleCallbacks(new b(this));
    L9:
        com.bytedance.crash.util.a.f203405a = new g();     // Catch: Throwable -> L8
        return;
    }

    public static boolean e() {
        if (((HashMap) d().f19112d).isEmpty() == false) goto L5;
        Context r100 = i.getContext();
        if (r100 == null) goto L28;
        r100.getPackageName();
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L29
    L28:
        return true;
    L5:
        if (d().f() == true) goto L22;
        long r102 = System.currentTimeMillis();
        a r103 = d();
        r103.getClass();
        ArrayList r104 = new ArrayList(((HashMap) r103.f19112d).entrySet());
        long r105 = 0;
        long r106 = 0;
        int r107 = 0;
    L8:
        if (r107 >= r104.size()) goto L16;
        c r110 = (c) ((Map.Entry) ListProtector.get(r104, r107)).getValue();
        if (r110.f19120c < 3) goto L18;
        long r111 = r110.f19121d;
        if (r106 >= r111) goto L15;
        r106 = r111;
    L15:
        r107 = r107 + 1;
    L18:
        if ((r102 - r105) > 2000) goto L36;
        return false;
    L36:
        return true;
    L16:
        r105 = r106;
        goto L18
    L22:
        return false;
    }

    public static void b(File r110) {
        if (e() == false) goto L6;
        com.bytedance.crash.util.g.d(r110, "background");
    L6:
        if (((HashMap) d().f19112d).isEmpty() == false) goto L8;
        Context r100 = i.getContext();
        if (r100 == null) goto L18;
        r100.getPackageName();
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L17
    L18:
        boolean r102 = true;
    L19:
        if (r102 == false) goto L21;
        com.bytedance.crash.util.g.d(r110, "background_v2");
    L21:
        a r103 = d();
        r103.getClass();
        dh4.f r104 = new dh4.f(r110.getAbsolutePath() + "/activity_trace.json");
        r104.j();
        r104.h("activity_trace");
        r104.j();
        int r105 = 0;
    L23:
        if (r105 >= 6) goto L30;
        d r106 = r103.f19114f[r105];
        if (r106 == null) goto L29;
        if (r106.f19123a == null) goto L29;
        r104.h(f19106o[r105]);
        r104.j();
        r104.h("name");
        r104.l(r103.f19114f[r105].f19123a.f19118a);
        r104.i();
        r104.h("time");
        r104.c(r103.f19114f[r105].f19124b);
        r104.k();
        r104.i();
    L29:
        r105 = r105 + 1;
        goto L23
    L30:
        r104.h("alive_activities");
        r104.a('[');
        ArrayList r107 = new ArrayList(((HashMap) r103.f19112d).entrySet());
        Collections.sort(r107, new bi4.b());
        Iterator r108 = r107.iterator();
        boolean r109 = true;
    L32:
        if (r108.hasNext() == false) goto L38;
        Map.Entry r111 = (Map.Entry) r108.next();
        if (r109 == false) goto L36;
        r109 = false;
    L37:
        r104.j();
        r104.h("name");
        r104.l(((c) r111.getValue()).f19118a);
        r104.i();
        r104.h("time");
        r104.c(((c) r111.getValue()).f19122e);
        r104.k();
        goto L32
    L36:
        r104.i();
        goto L37
    L38:
        r104.a(']');
        r104.i();
        r104.h("finish_activities");
        r104.a('[');
        int r112 = ((ArrayList) r103.f19113e).size() - 1;
    L39:
        if (r112 < 0) goto L44;
        r104.j();
        r104.h("name");
        r104.l(((c) ListProtector.get(r103.f19113e, r112)).f19118a);
        r104.i();
        r104.h("time");
        r104.c(((c) ListProtector.get(r103.f19113e, r112)).f19121d);
        r104.k();
        if (r112 == 0) goto L43;
        r104.i();
    L43:
        r112 = r112 - 1;
        goto L39
    L44:
        r104.a(']');
        r104.k();
        r104.k();
        r104.g();
        d().getClass();
        StringBuilder r113 = new StringBuilder();
        Iterator<e> r114 = d().f19115g.iterator();
    L46:
        if (r114.hasNext() == false) goto L49;
        e r115 = r114.next();
        r113.append(r115.f19126b);
        r113.append(' ');
        r113.append(r115.f19125a.f19118a);
        r113.append(' ');
        r113.append(r115.f19125a.f19119b);
        r113.append(' ');
        r113.append(r115.f19127c);
        r113.append('\n');
        goto L46
    L49:
        if (r113.length() != 0) goto L55;
        return;
    L55:
        h.h(new PolarisFileWrapper(r110, "activity_track.inf"), r113.toString(), false);     // Catch: Exception -> L54
        return;
    L71:
        return;
    L8:
        if (d().f() == false) goto L18;
        r102 = false;
        goto L19
    }

    public static void h(JSONObject r100) {
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L22
        int r102 = 0;
    L5:
        if (r102 >= 6) goto L12;
        if (d().f19114f[r102] == null) goto L11;
        if (d().f19114f[r102].f19123a == null) goto L11;
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L22
        r103.put("name", d().f19114f[r102].f19123a.f19118a);     // Catch: Throwable -> L22
        r103.put("time", d().f19114f[r102].f19124b);     // Catch: Throwable -> L22
        r101.put(f19106o[r102], r103);     // Catch: Throwable -> L22
    L11:
        r102 = r102 + 1;     // Catch: Throwable -> L22
        goto L5
    L12:
        ArrayList r104 = new ArrayList(((HashMap) d().f19112d).entrySet());     // Catch: Throwable -> L22
        Collections.sort(r104, new C0307a());     // Catch: Throwable -> L22
        JSONArray r105 = new JSONArray();     // Catch: Throwable -> L22
        Iterator r106 = r104.iterator();     // Catch: Throwable -> L22
    L14:
        if (r106.hasNext() == false) goto L16;
        Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Throwable -> L22
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L22
        r108.put("name", ((c) r107.getValue()).f19118a);     // Catch: Throwable -> L22
        r108.put("time", ((c) r107.getValue()).f19122e);     // Catch: Throwable -> L22
        r105.put(r108);     // Catch: Throwable -> L22
        goto L14
    L16:
        r101.put("alive_activities", r105);     // Catch: Throwable -> L22
        Object r109 = new JSONArray();     // Catch: Throwable -> L22
        int r110 = ((ArrayList) d().f19113e).size();     // Catch: Throwable -> L22
    L17:
        r110 = r110 - 1;     // Catch: Throwable -> L22
        if (r110 < 0) goto L20;
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L22
        r111.put("name", ((c) ListProtector.get(d().f19113e, r110)).f19118a);     // Catch: Throwable -> L22
        r111.put("time", ((c) ListProtector.get(d().f19113e, r110)).f19121d);     // Catch: Throwable -> L22
        goto L17
    L20:
        r101.put("finish_activities", r109);     // Catch: Throwable -> L22
        r100.put("activity_trace", r101);     // Catch: Throwable -> L22
        return;
    }

    public static void i(JSONObject r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = new ArrayList(d().f19115g).iterator();     // Catch: Exception -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        e r103 = (e) r102.next();     // Catch: Exception -> L9
        long r104 = r103.f19126b;     // Catch: Exception -> L9
        c r105 = r103.f19125a;     // Catch: Exception -> L9
        r101.put(e.a(r104, r105.f19118a, r105.f19119b, r103.f19127c));     // Catch: Exception -> L9
        goto L5
    L7:
        eh4.c.a(r100, "activity_track", r101);     // Catch: Exception -> L9
        return;
    }

    public static void g(JSONObject r100, File r101) {
        r100.put(LocationMonitorConst.IS_BACKGROUND, new PolarisFileWrapper(r101, "background").exists());     // Catch: Throwable -> L4
    L5:
        String r102 = com.bytedance.crash.util.g.f(new PolarisFileWrapper(r101, "activity_trace.json"));
        if (r102 == null) goto L34;
        j.d(r100, new JSONObject(r102));     // Catch: Throwable -> L27
    L34:
        JSONArray r103 = new JSONArray();     // Catch: IOException -> L29
        BufferedReader r104 = new BufferedReader(new PolarisFileReaderWrapper(new PolarisFileWrapper(r101, "activity_track.inf")));     // Catch: IOException -> L29
    L9:
        String r105 = r104.readLine();     // Catch: IOException -> L29
        if (r105 == null) goto L25;
        String[] r106 = r105.split(" ");     // Catch: IOException -> L29
        if (r106.length == 4) goto L36;
    L22:
        String r107 = null;
    L23:
        if (r107 == null) goto L9;
        r103.put(r107);     // Catch: IOException -> L29
        goto L9
    L36:
        long r108 = CastLongProtector.parseLong(r106[0]);     // Catch: Exception -> L28
        String r109 = r106[1];     // Catch: Exception -> L28
        int r110 = CastIntegerProtector.parseInt(r106[2]);     // Catch: Exception -> L28
        int r111 = CastIntegerProtector.parseInt(r106[3]);     // Catch: Exception -> L28
        if (r111 < 0) goto L22;
        if (r111 >= f19107p.length) goto L22;
        r107 = e.a(r108, r109, r110, r111);     // Catch: Exception -> L28
    L25:
        eh4.c.a(r100, "activity_track", r103);     // Catch: IOException -> L29
        return;
    }

    public static void a(a r110, int r111, Activity r112) {
        r110.getClass();
        long r100 = System.currentTimeMillis();
        int r101 = r112.hashCode();
        c r102 = (c) ((HashMap) r110.f19112d).get(Integer.valueOf(r101));
        e r103 = null;
        if (r102 != null) goto L12;
        if (r111 != 0) goto L6;
        long r104 = r100;
    L8:
        if (TextUtils.isEmpty(null) == false) goto L10;
        String r105 = r112.getClass().getName();
    L11:
        r102 = new c(r105, r104, r101);
        ((HashMap) r110.f19112d).put(Integer.valueOf(r101), r102);
        goto L12
    L10:
        r105 = null;
        goto L11
    L6:
        r104 = 0;
    L12:
        r102.f19120c = r111;
        r102.f19121d = r100;
        if (bi4.e.f19140g.f19141a == false) goto L34;
        String r106 = r102.f19118a;
        long r107 = r102.f19122e;
        if (r111 != 0) goto L17;
        String r108 = WidgetCostModule.TYPE_ON_CREATE;
    L32:
        wh4.b.post(new bi4.c(r106, r108, r112.hashCode(), r107));
        goto L34
    L17:
        if (r111 != 1) goto L19;
        r108 = WidgetCostModule.TYPE_ON_START;
        goto L32
    L19:
        if (r111 != 2) goto L21;
        r108 = "onResume";
        goto L32
    L21:
        if (r111 != 3) goto L23;
        r108 = "onPause";
        goto L32
    L23:
        if (r111 == 4) goto L27;
        if (r111 == 5) goto L26;
        r108 = "";
        goto L32
    L26:
        r108 = LiveCommonConstants.REASON_ON_DEDTROY;
        goto L32
    L27:
        r108 = "onStop";
    L34:
        if (r110.f19115g.size() < 50) goto L36;
        r103 = r110.f19115g.poll();
    L36:
        if (r103 != null) goto L38;
        r103 = new e();
    L38:
        r110.f19115g.add(r103);
        r103.f19125a = r102;
        long r109 = r102.f19121d;
        r103.f19126b = r109;
        r103.f19127c = r102.f19120c;
        d[] r113 = r110.f19114f;
        if (r113[r111] != null) goto L41;
        r113[r111] = new d();
    L41:
        d r114 = r113[r111];
        r114.f19123a = r102;
        r114.f19124b = r109;
        if (r111 != 5) goto L48;
        ((HashMap) r110.f19112d).remove(Integer.valueOf(r102.f19119b));
        if (((ArrayList) r110.f19113e).size() != 20) goto L46;
        ListProtector.remove(r110.f19113e, 19);
    L46:
        ((ArrayList) r110.f19113e).add(r102);
        return;
    }
}
