package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class f1 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f27220m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f27221n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile f1 f27222o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f27223p = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    List<c1> f27225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f27226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private m1 f27227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private s1 f27228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private z8 f27229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private z8 f27230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private z8 f27231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    e f27232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i1 f27233j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    k1 f27234k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    h1 f27235l;

    public class a extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f1 f27237c;

        @Override // com.amap.api.mapcore.util.a9
        public void runTask() {
            c1 r100 = f1.a(this.f27237c, this.f27236b);
            if (r100 != null) goto L127;
        L35:
            f1.b(this.f27237c);     // Catch: Throwable -> L81 Exception -> L96
            e1.a r101 = new e1(f1.c(this.f27237c)).c();     // Catch: c5 -> L78 Throwable -> L81 Exception -> L96
            if (f1.d(this.f27237c) == null) goto L66;
            if (r101 == null) goto L52;
            if (r101.f27196a == false) goto L52;
            String r102 = r101.f27198c;     // Catch: Throwable -> L81 Exception -> L96
            if (r102 == null) goto L66;
            if (r102.length() <= 0) goto L66;
            if (r101.f27198c.equals(f1.f27223p) == true) goto L66;
            f1.f27223p = r101.f27198c;     // Catch: Throwable -> L81 Exception -> L96
            f1.a(this.f27237c, r101);     // Catch: Throwable -> L81 Exception -> L96
        L52:
            if (f1.d(this.f27237c) == null) goto L64;
            f1 r103 = this.f27237c;
            monitor-enter(r103);
            f1.d(this.f27237c).b(r100);     // Catch: Throwable -> L57
        L59:
            monitor-exit(r103);     // Catch: Throwable -> L61
            return;
        L57:
            th = move-exception;
            t6.a(th, "OfflineDownloadManager", "checkUpdatefinally");     // Catch: Throwable -> L61
        L61:
            th = move-exception;
            throw th;
        L64:
            return;
        L66:
            if (f1.d(this.f27237c) == null) goto L109;
            f1 r104 = this.f27237c;
            monitor-enter(r104);
            f1.d(this.f27237c).b(r100);     // Catch: Throwable -> L71
        L73:
            monitor-exit(r104);     // Catch: Throwable -> L75
            return;
        L75:
            th = move-exception;
            throw th;
        L71:
            th = move-exception;
            t6.a(th, "OfflineDownloadManager", "checkUpdatefinally");     // Catch: Throwable -> L75
            goto L73
        L109:
            return;
        L78:
            e = move-exception;
            throw new AMapException(e.a());     // Catch: Throwable -> L81 Exception -> L96
        L127:
        L81:
            th = move-exception;
            if (f1.d(this.f27237c) != null) goto L85;
        L95:
            throw th;
        L85:
            monitor-enter(this.f27237c);
            f1.d(this.f27237c).b(r100);     // Catch: Throwable -> L88
        L90:
            goto L95
        L88:
            th = move-exception;
            t6.a(th, "OfflineDownloadManager", "checkUpdatefinally");     // Catch: Throwable -> L92
        L92:
            th = move-exception;
            throw th;
        L5:
            if (r100.f27099v.equals(r100.f27090m) == true) goto L22;
            if (r100.f27099v.equals(r100.f27092o) == true) goto L22;
            String r105 = r100.getAdcode();     // Catch: Throwable -> L81 Exception -> L96
            if (r105.length() <= 0) goto L35;
            String r106 = f1.a(this.f27237c).d(r105);     // Catch: Throwable -> L81 Exception -> L96
            if (r106 != null) goto L15;
            r106 = r100.getVersion();     // Catch: Throwable -> L81 Exception -> L96
        L15:
            if (f1.f27223p.length() <= 0) goto L35;
            if (r106 == null) goto L35;
            if (f1.a(this.f27237c, f1.f27223p, r106) == false) goto L35;
            r100.f27099v.equals(r100.f27093p);     // Catch: Throwable -> L81 Exception -> L96
            r100.f27099v.f();     // Catch: Throwable -> L81 Exception -> L96
        L22:
            if (f1.d(this.f27237c) == null) goto L34;
            f1 r107 = this.f27237c;
            monitor-enter(r107);
            f1.d(this.f27237c).b(r100);     // Catch: Throwable -> L27
        L29:
            monitor-exit(r107);     // Catch: Throwable -> L31
            return;
        L27:
            th = move-exception;
            t6.a(th, "OfflineDownloadManager", "checkUpdatefinally");     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            throw th;
        L34:
            return;
        L97:
            if (f1.d(this.f27237c) != null) goto L99;
            return;
        L99:
            monitor-enter(this.f27237c);
            f1.d(this.f27237c).b(r100);     // Catch: Throwable -> L102
        L104:
            return;
        L102:
            th = move-exception;
            t6.a(th, "OfflineDownloadManager", "checkUpdatefinally");     // Catch: Throwable -> L106
        L106:
            th = move-exception;
            throw th;
        }

        public a(f1 r100, String r101) {
            this.f27237c = r100;
            this.f27236b = r101;
        }
    }

    public class b extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c1 f27238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f27239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ f1 f27240d;

        @Override // com.amap.api.mapcore.util.a9
        public void runTask() {
        L16:
            th = move-exception;
            t6.a(th, "requestDelete", "removeExcecRunnable");
            return;
        L3:
            if (this.f27238b.getState() != 7) goto L5;
        L10:
            this.f27240d.f27234k.b(this.f27238b);     // Catch: Throwable -> L16
            if (this.f27239c == true) goto L13;
        L19:
            return;
        L13:
            if (f1.d(this.f27240d) == null) goto L19;
            f1.d(this.f27240d).c(this.f27238b);     // Catch: Throwable -> L16
            goto L19
        L5:
            if (this.f27238b.getState() == (-1)) goto L10;
            this.f27240d.f27234k.b(this.f27238b);     // Catch: Throwable -> L16
            if (f1.d(this.f27240d) == null) goto L19;
            f1.d(this.f27240d).c(this.f27238b);     // Catch: Throwable -> L16
            goto L19
        }

        public b(f1 r100, c1 r101, boolean r102) {
            this.f27240d = r100;
            this.f27238b = r101;
            this.f27239c = r102;
        }
    }

    public class c extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c1 f27241b;

        @Override // com.amap.api.mapcore.util.a9
        public void runTask() {
            this.f27241b.k();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            t6.a(th, "OfflineDownloadManager", "startDownloadRunnable");
        }

        public c(f1 r100, c1 r101) {
            this.f27241b = r101;
        }
    }

    public interface d {
        void a(c1 r100);

        void b(c1 r100);

        void c(c1 r100);

        void onVerifyComplete();
    }

    public class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f1 f27242a;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            r100.getData();     // Catch: Throwable -> L8
            Object r101 = r100.obj;     // Catch: Throwable -> L8
            if ((r101 instanceof c1) == false) goto L13;
            c1 r102 = (c1) r101;     // Catch: Throwable -> L8
            r102.getCity();     // Catch: Throwable -> L8
            r102.getcompleteCode();     // Catch: Throwable -> L8
            r102.getState();     // Catch: Throwable -> L8
            if (f1.d(this.f27242a) == null) goto L14;
            f1.d(this.f27242a).a(r102);     // Catch: Throwable -> L8
            return;
        L14:
            return;
        L13:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();
        }

        public e(f1 r100, Looper r101) {
            this.f27242a = r100;
            super(r101);
        }
    }

    private void e() {
        if ("".equals(w3.a(this.f27224a)) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r100 = new PolarisFileWrapper(w3.a(this.f27224a) + "offlinemapv4.png");
        if (r100.exists() == true) goto L8;
        String r101 = a2.a(this.f27224a, "offlinemapv4.png");
    L9:
        if (r101 != null) goto L38;
    L37:
    L34:
        th = move-exception;
        t6.a(th, "OfflineDownloadManager", "checkAndTriggerCityListUpdate");
        return;
    L18:
        if (r100.exists() == true) goto L22;
    L23:
        boolean r102 = true;
    L25:
        if (r102 == false) goto L42;
    L31:
        th = move-exception;
        t6.a(th, "OfflineDownloadManager", "fetchAndUpdateCityListFromNetwork");     // Catch: Throwable -> L34
        return;
    L27:
        if (this.f27229f != null) goto L29;
        this.f27229f = n0.b("AMapOfflineCheckUpdate");     // Catch: Throwable -> L31
    L29:
        this.f27229f.d(new g1(this));     // Catch: Throwable -> L31
    L43:
        return;
    L42:
        return;
    L22:
        if ((System.currentTimeMillis() - r100.lastModified()) > 604800000) goto L23;
        r102 = false;
        goto L25
    L38:
        e(r101);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        if (r100.exists() == false) goto L16;
        r100.delete();
    L16:
        t6.a(e, "MapDownloadManager", "paseJson io");
        e.printStackTrace();
        goto L37
    L8:
        r101 = a2.c(r100);
        goto L9
    }

    public void a() {
        z8 r100 = this.f27229f;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        z8 r101 = this.f27231h;
        if (r101 == null) goto L8;
        r101.a();
        this.f27231h = null;
    L8:
        h1 r102 = this.f27235l;
        if (r102 != null) goto L11;
    L14:
        e r103 = this.f27232i;
        if (r103 == null) goto L17;
        r103.removeCallbacksAndMessages(null);
        this.f27232i = null;
    L17:
        m1 r104 = this.f27227d;
        if (r104 == null) goto L20;
        r104.a();
        this.f27227d = null;
    L20:
        i1 r105 = this.f27233j;
        if (r105 == null) goto L23;
        r105.a();
    L23:
        f27222o = null;
        f27221n = true;
        monitor-enter(this);
        this.f27226c = null;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    L11:
        if (ThreadMethodProxy.isAlive(r102) == false) goto L13;
        this.f27235l.interrupt();
    L13:
        this.f27235l = null;
        goto L14
    }

    public void b() {
        s1 r100 = s1.b(this.f27224a.getApplicationContext());
        this.f27228e = r100;
        n1 r101 = r100.c("000001");     // Catch: Throwable -> L7
        if (r101 == null) goto L9;
        this.f27228e.a("000001");     // Catch: Throwable -> L7
        r101.b("100000");     // Catch: Throwable -> L7
        this.f27228e.b(r101);     // Catch: Throwable -> L7
    L9:
        this.f27232i = new e(this, this.f27224a.getMainLooper());
        this.f27233j = new i1(this.f27224a);
        this.f27227d = m1.a(1);
        f27220m = w3.a(this.f27224a);
        e();     // Catch: Throwable -> L12
    L14:
        List<c1> r102 = this.f27225b;
        monitor-enter(r102);
        Iterator<OfflineMapProvince> r103 = this.f27233j.b().iterator();     // Catch: Throwable -> L28
    L18:
        if (r103.hasNext() == false) goto L25;
        Iterator<OfflineMapCity> r104 = r103.next().getCityList().iterator();     // Catch: Throwable -> L28
    L21:
        if (r104.hasNext() == false) goto L18;
        OfflineMapCity r105 = r104.next();     // Catch: Throwable -> L28
        if (r105 == null) goto L21;
        this.f27225b.add(new c1(this.f27224a, r105));     // Catch: Throwable -> L28
        goto L21
    L25:
        monitor-exit(r102);     // Catch: Throwable -> L28
        h1 r106 = new h1(this.f27224a);
        this.f27235l = r106;
        ThreadMethodProxy.start(r106);
        return;
    L28:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        th.printStackTrace();
    L7:
        th = move-exception;
        t6.a(th, "OfflineDownloadManager", "changeBadCase");
        goto L9
    }

    public void c() {
        List<c1> r100 = this.f27225b;
        monitor-enter(r100);
        Iterator<c1> r101 = this.f27225b.iterator();     // Catch: Throwable -> L17
    L6:
        if (r101.hasNext() == false) goto L15;
        c1 r102 = r101.next();     // Catch: Throwable -> L17
        if (r102.f27099v.equals(r102.f27090m) == true) goto L11;
        if (r102.f27099v.equals(r102.f27089l) == false) goto L6;
    L11:
        m1 r103 = this.f27227d;     // Catch: Throwable -> L17
        if (r103 == null) goto L14;
        r103.b(r102);     // Catch: Throwable -> L17
    L14:
        r102.f27099v.g();     // Catch: Throwable -> L17
        goto L6
    L15:
        monitor-exit(r100);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void d() {
        List<c1> r100 = this.f27225b;
        monitor-enter(r100);
        Iterator<c1> r101 = this.f27225b.iterator();     // Catch: Throwable -> L12
    L6:
        if (r101.hasNext() == false) goto L10;
        c1 r102 = r101.next();     // Catch: Throwable -> L12
        if (r102.f27099v.equals(r102.f27090m) == false) goto L6;
        r102.f27099v.g();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void f() {
        Iterator<n1> r100 = this.f27228e.b().iterator();
    L4:
        if (r100.hasNext() == false) goto L36;
        n1 r101 = r100.next();
        if (r101 == null) goto L4;
        if (r101.c() == null) goto L4;
        if (r101.a().length() < 1) goto L4;
        int r102 = r101.f27887m;
        if (r102 == 4) goto L17;
        if (r102 == 7) goto L17;
        if (r102 < 0) goto L17;
        r101.f27887m = 3;
    L17:
        c1 r103 = c(r101.c());
        if (r103 == null) goto L4;
        r103.setUrl(r101.d());
        String r104 = r101.e();
        if (r104 != null) goto L23;
    L25:
        r103.b(r101.f27887m);
        r103.setCompleteCode(r101.b());
    L27:
        if (r101.e().length() <= 0) goto L29;
        r103.setVersion(r101.e());
    L29:
        List<String> r105 = this.f27228e.b(r101.a());
        StringBuffer r106 = new StringBuffer();
        Iterator r107 = ((ArrayList) r105).iterator();
    L31:
        if (r107.hasNext() == false) goto L33;
        r106.append((String) r107.next());
        r106.append(com.alipay.sdk.m.u.i.f25853b);
        goto L31
    L33:
        r103.b(r106.toString());
        i1 r108 = this.f27233j;
        if (r108 == null) goto L4;
        r108.a(r103);
        goto L4
    L23:
        if (a(f27223p, r104) == false) goto L25;
        r103.b(7);
        goto L27
    L36:
        d r109 = this.f27226c;
        if (r109 == null) goto L59;
        r109.onVerifyComplete();     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        t6.a(th, "OfflineDownloadManager", "verifyCallBack");
        return;
    }

    private f1(Context r100) {
        this.f27225b = new Vector();
        this.f27229f = null;
        this.f27230g = null;
        this.f27231h = null;
        this.f27232i = null;
        this.f27235l = null;
        this.f27224a = r100;
    }

    public static void b(f1 r100) throws AMapException {
        if (w3.d(r100.f27224a) == false) goto L6;
        return;
    L6:
        throw new AMapException(AMapException.ERROR_CONNECTION);
    }

    private c1 c(String r100) {
        if (r100 != null) goto L5;
    L23:
        return null;
    L5:
        if (r100.length() < 1) goto L23;
        List<c1> r101 = this.f27225b;
        monitor-enter(r101);
        Iterator<c1> r102 = this.f27225b.iterator();     // Catch: Throwable -> L20
    L11:
        if (r102.hasNext() == false) goto L18;
        c1 r103 = r102.next();     // Catch: Throwable -> L20
        if (r100.equals(r103.getCity()) == true) goto L16;
        if (r100.equals(r103.getPinyin()) == false) goto L11;
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return r103;
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    private void e(String r110) throws JSONException {
        Context r100 = this.f27224a.getApplicationContext();
        int r101 = 0;
        if (r110 != null) goto L5;
    L46:
        ArrayList r111 = new ArrayList();
    L48:
        if (r111.size() != 0) goto L50;
        return;
    L50:
        i1 r102 = this.f27233j;
        if (r102 == null) goto L136;
        ArrayList<OfflineMapProvince> r103 = r102.f27428a;
        monitor-enter(r103);
    L133:
        th = move-exception;
        throw th;
    L55:
        if (r102.f27428a.size() > 0) goto L57;
        Iterator r112 = r111.iterator();     // Catch: Throwable -> L133
    L129:
        if (r112.hasNext() == false) goto L131;
        r102.f27428a.add((OfflineMapProvince) r112.next());     // Catch: Throwable -> L133
    L131:
        monitor-exit(r103);     // Catch: Throwable -> L133
        return;
    L57:
        if (r101 >= r102.f27428a.size()) goto L107;
        OfflineMapProvince r104 = r102.f27428a.get(r101);     // Catch: Throwable -> L133
        Iterator r105 = r111.iterator();     // Catch: Throwable -> L133
    L60:
        if (r105.hasNext() == false) goto L77;
        OfflineMapProvince r106 = (OfflineMapProvince) r105.next();     // Catch: Throwable -> L133
        if (r104.getProvinceCode().equals(r106.getProvinceCode()) == true) goto L78;
        if (r104.getPinyin().equals("quanguogaiyaotu") == true) goto L71;
        if (r104.getProvinceCode().equals("000001") == true) goto L71;
        if (r104.getProvinceCode().equals("100000") == false) goto L60;
    L71:
        if (r106.getPinyin().equals("quanguogaiyaotu") == true) goto L78;
        if (r106.getProvinceCode().equals("000001") == true) goto L78;
        if (r106.getProvinceCode().equals("100000") == false) goto L60;
    L78:
        if (r106 == null) goto L106;
        r104.setUrl(r106.getUrl());     // Catch: Throwable -> L133
        r104.setVersion(r106.getVersion());     // Catch: Throwable -> L133
        r104.setSize(r106.getSize());     // Catch: Throwable -> L133
        r104.setPinyin(r106.getPinyin());     // Catch: Throwable -> L133
        r104.setJianpin(r106.getJianpin());     // Catch: Throwable -> L133
        ArrayList<OfflineMapCity> r107 = r104.getCityList();     // Catch: Throwable -> L133
        ArrayList<OfflineMapCity> r108 = r106.getCityList();     // Catch: Throwable -> L133
        HashSet r109 = new HashSet();     // Catch: Throwable -> L133
        Iterator<OfflineMapCity> r113 = r108.iterator();     // Catch: Throwable -> L133
    L82:
        if (r113.hasNext() == false) goto L84;
        r109.add(r113.next().getAdcode());     // Catch: Throwable -> L133
        goto L82
    L84:
        Iterator<OfflineMapCity> r114 = r107.iterator();     // Catch: Throwable -> L133
    L86:
        if (r114.hasNext() == false) goto L96;
        OfflineMapCity r115 = r114.next();     // Catch: Throwable -> L133
        if (r109.contains(r115.getAdcode()) == true) goto L89;
        r114.remove();     // Catch: Throwable -> L133
        goto L86
    L89:
        Iterator<OfflineMapCity> r116 = r108.iterator();     // Catch: Throwable -> L133
    L91:
        if (r116.hasNext() == false) goto L86;
        OfflineMapCity r117 = r116.next();     // Catch: Throwable -> L133
        if (r115.getAdcode().equals(r117.getAdcode()) == false) goto L91;
        r115.setUrl(r117.getUrl());     // Catch: Throwable -> L133
        r115.setVersion(r117.getVersion());     // Catch: Throwable -> L133
        r115.setSize(r117.getSize());     // Catch: Throwable -> L133
        r115.setCode(r117.getCode());     // Catch: Throwable -> L133
        r115.setPinyin(r117.getPinyin());     // Catch: Throwable -> L133
        r115.setJianpin(r117.getJianpin());     // Catch: Throwable -> L133
        goto L86
    L96:
        HashSet r118 = new HashSet();     // Catch: Throwable -> L133
        Iterator<OfflineMapCity> r119 = r107.iterator();     // Catch: Throwable -> L133
    L98:
        if (r119.hasNext() == false) goto L100;
        r118.add(r119.next().getAdcode());     // Catch: Throwable -> L133
        goto L98
    L100:
        Iterator<OfflineMapCity> r120 = r108.iterator();     // Catch: Throwable -> L133
    L102:
        if (r120.hasNext() == false) goto L106;
        OfflineMapCity r121 = r120.next();     // Catch: Throwable -> L133
        if (r118.contains(r121.getAdcode()) == true) goto L102;
        r107.add(r121);     // Catch: Throwable -> L133
    L106:
        r101 = r101 + 1;     // Catch: Throwable -> L133
        goto L57
    L77:
        r106 = null;
        goto L78
    L107:
        HashSet r122 = new HashSet();     // Catch: Throwable -> L133
        Iterator r123 = r111.iterator();     // Catch: Throwable -> L133
    L109:
        if (r123.hasNext() == false) goto L111;
        r122.add(((OfflineMapProvince) r123.next()).getProvinceCode());     // Catch: Throwable -> L133
        goto L109
    L111:
        Iterator<OfflineMapProvince> r124 = r102.f27428a.iterator();     // Catch: Throwable -> L133
    L113:
        if (r124.hasNext() == false) goto L117;
        if (r122.contains(r124.next().getProvinceCode()) == true) goto L113;
        r124.remove();     // Catch: Throwable -> L133
        goto L113
    L117:
        HashSet r125 = new HashSet();     // Catch: Throwable -> L133
        Iterator<OfflineMapProvince> r126 = r102.f27428a.iterator();     // Catch: Throwable -> L133
    L119:
        if (r126.hasNext() == false) goto L121;
        r125.add(r126.next().getProvinceCode());     // Catch: Throwable -> L133
        goto L119
    L121:
        Iterator r127 = r111.iterator();     // Catch: Throwable -> L133
    L123:
        if (r127.hasNext() == false) goto L131;
        OfflineMapProvince r128 = (OfflineMapProvince) r127.next();     // Catch: Throwable -> L133
        if (r125.contains(r128.getProvinceCode()) == true) goto L123;
        r102.f27428a.add(r128);     // Catch: Throwable -> L133
        goto L123
    L136:
        return;
    L5:
        if ("".equals(r110) == true) goto L46;
        JSONObject r129 = new JSONObject(r110);
        r111 = new ArrayList();
        if (r129.has("result") == true) goto L14;
        JSONObject r130 = new JSONObject();
        r130.put("result", new JSONObject().put("offlinemap_with_province_vfour", r129));     // Catch: JSONException -> L12
        a2.b(r130.toString(), r100);     // Catch: JSONException -> L12
        JSONObject r131 = r130.optJSONObject("result");     // Catch: JSONException -> L12
    L15:
        if (r131 == null) goto L20;
        JSONObject r132 = r131.optJSONObject("offlinemap_with_province_vfour");
        if (r132 == null) goto L48;
        JSONObject r133 = r132.optJSONObject("offlinemapinfo_with_province");
    L21:
        if (r133 == null) goto L48;
        if (r133.has("version") == false) goto L26;
        f27223p = a2.a(r133, "version");
    L26:
        JSONArray r134 = r133.optJSONArray("provinces");
        if (r134 == null) goto L48;
        int r135 = 0;
    L31:
        if (r135 >= r134.length()) goto L37;
        JSONObject r136 = r134.optJSONObject(r135);
        if (r136 == null) goto L36;
        r111.add(a2.b(r136));
    L36:
        r135 = r135 + 1;
        goto L31
    L37:
        JSONArray r137 = r133.optJSONArray("others");
        if (r137 != null) goto L40;
    L42:
        JSONObject r138 = null;
    L43:
        if (r138 == null) goto L48;
        r111.add(a2.b(r138));
        goto L48
    L40:
        if (r137.length() <= 0) goto L42;
        r138 = JSONArrayProtectorUtils.getJSONObject(r137, 0);
        goto L43
    L20:
        r133 = r129.optJSONObject("offlinemapinfo_with_province");
    L12:
        e = move-exception;
        JSONObject r139 = r129.optJSONObject("result");
        t6.a(e, "Utility", "parseJson");
        e.printStackTrace();
        r131 = r139;
        goto L15
    L14:
        r131 = r129.optJSONObject("result");
        goto L15
    }

    public void a(String r100) {
        if (r100 != null) goto L8;
        d r101 = this.f27226c;     // Catch: Throwable -> L12
        if (r101 == null) goto L16;
        r101.b(null);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L8:
        if (this.f27229f != null) goto L10;
        this.f27229f = n0.b("AMapOfflineCheckUpdate");     // Catch: Throwable -> L12
    L10:
        this.f27229f.d(new a(this, r100));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        t6.a(th, "OfflineDownloadManager", "checkUpdate");
    }

    public void d(c1 r100) {
        m1 r101 = this.f27227d;     // Catch: k5 -> L6
        if (r101 == null) goto L11;
        r101.a(r100, this.f27224a, null);     // Catch: k5 -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void f(String r100) {
        c1 r101 = c(r100);
        if (r101 == null) goto L6;
        r101.k();
        return;
    }

    public void g(String r100) {
        c1 r101 = c(r100);
        if (r101 != null) goto L11;
        d r102 = this.f27226c;
        if (r102 == null) goto L18;
        r102.c(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        t6.a(th, "OfflineDownloadManager", "remove");
        return;
    L18:
        return;
    L11:
        m1 r103 = this.f27227d;
        if (r103 == null) goto L14;
        r103.b(r101);
    L14:
        a(r101, true);
    }

    public void h(String r100) throws AMapException {
        c1 r101 = c(r100);
        if (r100 == null) goto L10;
        if (r100.length() < 1) goto L10;
        if (r101 == null) goto L10;
        e(r101);
        return;
    L10:
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
    }

    public void i(String r100) throws AMapException {
        if (r100 != null) goto L4;
    L20:
        c1 r101 = null;
    L21:
        if (r101 == null) goto L25;
        e(r101);
        return;
    L25:
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
    L4:
        if (r100.length() < 1) goto L20;
        List<c1> r102 = this.f27225b;
        monitor-enter(r102);
        Iterator<c1> r103 = this.f27225b.iterator();     // Catch: Throwable -> L17
    L10:
        if (r103.hasNext() == false) goto L15;
        r101 = r103.next();     // Catch: Throwable -> L17
        if (r100.equals(r101.getCode()) == false) goto L10;
        monitor-exit(r102);     // Catch: Throwable -> L17
        goto L21
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static f1 a(Context r100) {
        if (f27222o != null) goto L17;
        monitor-enter(f1.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (f27222o == null) goto L9;
    L11:
        monitor-exit(f1.class);     // Catch: Throwable -> L13
        goto L17
    L9:
        if (f27221n == true) goto L11;
        f27222o = new f1(r100.getApplicationContext());     // Catch: Throwable -> L13
    L17:
        return f27222o;
    }

    private void e(c1 r100) throws AMapException {
        if (w3.d(this.f27224a) == false) goto L16;
        if (r100 == null) goto L14;
        if (this.f27231h != null) goto L17;
        this.f27231h = n0.b("AMapOfflineDownload");
    L17:
        this.f27231h.d(new c(this, r100));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        t6.a(th, "startDownload", "downloadExcecRunnable");
        return;
    L14:
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
    L16:
        throw new AMapException(AMapException.ERROR_CONNECTION);
    }

    public String b(String r100) {
        c1 r101 = c(r100);
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getAdcode();
    }

    public void c(c1 r100) {
        a(r100, false);
    }

    public boolean d(String r100) {
        if (c(r100) != null) goto L6;
        return false;
    L6:
        return true;
    }

    public static /* synthetic */ Context c(f1 r100) {
        return r100.f27224a;
    }

    public static /* synthetic */ d d(f1 r100) {
        return r100.f27226c;
    }

    public void a(c1 r100) {
        m1 r101 = this.f27227d;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public void b(c1 r100) {
        m1 r101 = this.f27227d;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public static /* synthetic */ s1 a(f1 r100) {
        return r100.f27228e;
    }

    public void a(d r100) {
        this.f27226c = r100;
    }

    public static void a(f1 r100, e1.a r101) {
        r100.getClass();
        String r102 = r101.f27199d;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isEmpty() == true) goto L96;
        PolarisFileWrapper r103 = new PolarisFileWrapper(w3.a(r100.f27224a) + "offlinemapv4.png");
        if (r103.exists() == true) goto L10;
        String r104 = a2.a(r100.f27224a, "offlinemapv4.png");
    L11:
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.isEmpty() == false) goto L64;
        return;
    L64:
        r100.e(a2.a(r104, r102, r100.f27224a));     // Catch: JSONException -> L61
        if (r100.f27233j == null) goto L60;
        List<c1> r105 = r100.f27225b;
        if (r105 == null) goto L60;
        monitor-enter(r105);
        HashSet r106 = new HashSet();     // Catch: Throwable -> L57
        Iterator<OfflineMapProvince> r107 = r100.f27233j.b().iterator();     // Catch: Throwable -> L57
    L24:
        if (r107.hasNext() == false) goto L31;
        Iterator<OfflineMapCity> r108 = r107.next().getCityList().iterator();     // Catch: Throwable -> L57
    L27:
        if (r108.hasNext() == false) goto L24;
        OfflineMapCity r109 = r108.next();     // Catch: Throwable -> L57
        if (r109.getAdcode() == null) goto L27;
        r106.add(r109.getAdcode());     // Catch: Throwable -> L57
        goto L27
    L31:
        Iterator<c1> r110 = r100.f27225b.iterator();     // Catch: Throwable -> L57
    L33:
        if (r110.hasNext() == false) goto L37;
        if (r106.contains(r110.next().getAdcode()) == true) goto L33;
        r110.remove();     // Catch: Throwable -> L57
        goto L33
    L37:
        Iterator<OfflineMapProvince> r111 = r100.f27233j.b().iterator();     // Catch: Throwable -> L57
    L39:
        if (r111.hasNext() == false) goto L55;
        Iterator<OfflineMapCity> r112 = r111.next().getCityList().iterator();     // Catch: Throwable -> L57
    L42:
        if (r112.hasNext() == false) goto L39;
        OfflineMapCity r113 = r112.next();     // Catch: Throwable -> L57
        Iterator<c1> r114 = r100.f27225b.iterator();     // Catch: Throwable -> L57
    L45:
        if (r114.hasNext() == false) goto L51;
        c1 r115 = r114.next();     // Catch: Throwable -> L57
        if (r113.getAdcode() == null) goto L45;
        if (r113.getAdcode().equals(r115.getAdcode()) == false) goto L45;
        r115.setCity(r113.getCity());     // Catch: Throwable -> L57
        r115.setSize(r113.getSize());     // Catch: Throwable -> L57
        r115.setUrl(r113.getUrl());     // Catch: Throwable -> L57
        r115.p();     // Catch: Throwable -> L57
        boolean r116 = true;
    L52:
        if (r116 == true) goto L42;
        if (r113 == null) goto L42;
        r100.f27225b.add(new c1(r100.f27224a, r113));     // Catch: Throwable -> L57
        goto L42
    L51:
        r116 = false;
        goto L52
    L55:
        monitor-exit(r105);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        throw th;
    L60:
        h1 r117 = new h1(r100.f27224a);
        r100.f27235l = r117;
        ThreadMethodProxy.start(r117);
        return;
    L61:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        r104 = a2.c(r103);
        goto L11
    }

    private void a(c1 r100, boolean r101) {
        if (this.f27234k != null) goto L6;
        this.f27234k = new k1(this.f27224a);
    L6:
        if (this.f27230g != null) goto L13;
        this.f27230g = n0.b("AMapOfflineRemove");
    L13:
        this.f27230g.d(new b(this, r100, r101));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        t6.a(th, "requestDelete", "removeExcecRunnable");
    }

    private boolean a(String r100, String r101) {
        int r102 = 0;
    L15:
        if (r102 >= r101.length()) goto L13;
        if (r100.charAt(r102) > r101.charAt(r102)) goto L7;
        if (r100.charAt(r102) < r101.charAt(r102)) goto L11;
        r102 = r102 + 1;
        goto L15
    L11:
        return false;
    L7:
        return true;
    L13:
        return false;
    }

    public static /* synthetic */ c1 a(f1 r100, String r101) {
        return r100.c(r101);
    }

    public static /* synthetic */ boolean a(f1 r100, String r101, String r102) {
        return r100.a(r101, r102);
    }
}
