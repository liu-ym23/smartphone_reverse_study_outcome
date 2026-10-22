package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.favorite.NAFavorite;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f32078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NAFavorite f32079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f32080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Vector<String> f32082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Vector<String> f32083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f32084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f32085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f32086i;

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.favrite.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0644a {
    }

    public class b implements Comparator<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f32087a;

        public b(a r100) {
            this.f32087a = r100;
        }

        public int a(String r100, String r101) {
            return r101.compareTo(r100);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(String r100, String r101) {
            return a(r100, r101);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f32088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f32089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f32090c;

        private boolean a() {
            if ((this.f32089b - this.f32088a) <= 1000) goto L5;
            return true;
        L5:
            return false;
        }

        private void b() {
            this.f32089b = System.currentTimeMillis();
        }

        private void c() {
            this.f32088a = System.currentTimeMillis();
        }

        private c(a r100) {
            this.f32090c = r100;
        }

        public static /* synthetic */ boolean a(c r100) {
            return r100.a();
        }

        public static /* synthetic */ void b(c r100) {
            r100.c();
        }

        public static /* synthetic */ void c(c r100) {
            r100.b();
        }

        public /* synthetic */ c(a r100, C0644a r101) {
            this(r100);
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f32091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f32092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f32093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f32094d;

        private boolean c() {
            return true;
        }

        private boolean b() {
            return TextUtils.isEmpty(this.f32091a);
        }

        private String a() {
            return this.f32091a;
        }

        private d(a r100) {
            this.f32094d = r100;
            this.f32092b = 5000;
            this.f32093c = 0;
        }

        private void a(String r100) {
            this.f32091a = r100;
            this.f32093c = System.currentTimeMillis();
        }

        public static /* synthetic */ boolean b(d r100) {
            return r100.b();
        }

        public static /* synthetic */ String c(d r100) {
            return r100.a();
        }

        public static /* synthetic */ boolean a(d r100) {
            return r100.c();
        }

        public /* synthetic */ d(a r100, C0644a r101) {
            this(r100);
        }

        public static /* synthetic */ void a(d r100, String r101) {
            r100.a(r101);
        }
    }

    private void h() {
        this.f32080c = false;
        this.f32081d = false;
    }

    public synchronized boolean a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f32079b != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        h();     // Catch: Throwable -> L11
        boolean r100 = this.f32079b.a();     // Catch: Throwable -> L11
        j();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r100;
    }

    public static a f() {
        if (f32078a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f32078a != null) goto L9;
        a r100 = new a();     // Catch: Throwable -> L11
        f32078a = r100;     // Catch: Throwable -> L11
        r100.g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f32078a;
    }

    private boolean g() {
        if (this.f32079b != null) goto L9;
        NAFavorite r100 = new NAFavorite();
        this.f32079b = r100;
        if (r100.b() != 0) goto L8;
        this.f32079b = null;
        return false;
    L8:
        h();
        i();
    L9:
        return true;
    }

    private boolean i() {
        if (this.f32079b != null) goto L6;
        return false;
    L6:
        String r100 = SysOSUtil.getModuleFileName() + HTTP.URL_DEFAULT;
        this.f32079b.a(1);
        return this.f32079b.a(r100, "fav_poi", "fifo", 10, 501, -1);
    }

    public static boolean j() {
        a r100 = f32078a;
        if (r100 == null) goto L9;
        NAFavorite r101 = r100.f32079b;
        if (r101 == null) goto L9;
        if (r101.d() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public void b() {
        a r100 = f32078a;
        if (r100 == null) goto L9;
        NAFavorite r101 = r100.f32079b;
        if (r101 == null) goto L7;
        r101.c();
        f32078a.f32079b = null;
    L7:
        f32078a = null;
        return;
    }

    public String c() {
        if (c.a(this.f32086i) == true) goto L5;
    L10:
        c.b(this.f32086i);
        if (this.f32079b != null) goto L13;
        return null;
    L13:
        ArrayList<String> r100 = e();
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L32;
    L29:
        c.c(this.f32086i);     // Catch: JSONException -> L31
        d.a(this.f32085h, r101.toString());     // Catch: JSONException -> L31
        return d.c(this.f32085h);
    L31:
        return null;
    L32:
        JSONArray r102 = new JSONArray();     // Catch: JSONException -> L31
        Iterator<String> r103 = r100.iterator();     // Catch: JSONException -> L31
        int r104 = 0;
    L17:
        if (r103.hasNext() == false) goto L27;
        String r105 = r103.next();     // Catch: JSONException -> L31
        if (r105 == null) goto L17;
        if (r105.equals("data_version") == true) goto L17;
        String r106 = this.f32079b.a(r105);     // Catch: JSONException -> L31
        if (r106 == null) goto L17;
        if (r106.equals("") == true) goto L17;
        JSONObject r107 = new JSONObject(r106).optJSONObject("Fav_Sync");     // Catch: JSONException -> L31
        r107.put("key", r105);     // Catch: JSONException -> L31
        r102.put(r104, r107);     // Catch: JSONException -> L31
        r104 = r104 + 1;     // Catch: JSONException -> L31
        goto L17
    L27:
        if (r104 <= 0) goto L29;
        r101.put("favcontents", r102);     // Catch: JSONException -> L31
        r101.put("favpoinum", r104);     // Catch: JSONException -> L31
        goto L29
    L5:
        if (d.a(this.f32085h) == true) goto L10;
        if (d.b(this.f32085h) == true) goto L10;
        return d.c(this.f32085h);
    }

    public ArrayList<String> d() {
        if (this.f32079b != null) goto L6;
        return null;
    L6:
        if (this.f32080c == true) goto L8;
    L41:
        Bundle r100 = new Bundle();     // Catch: Exception -> L40
        this.f32079b.a(r100);     // Catch: Exception -> L40
        String[] r101 = r100.getStringArray("rstString");     // Catch: Exception -> L40
        if (r101 == null) goto L30;
        Vector<String> r102 = this.f32082e;     // Catch: Exception -> L40
        if (r102 != null) goto L16;
        this.f32082e = new Vector();     // Catch: Exception -> L40
    L17:
        int r103 = r101.length;     // Catch: Exception -> L40
        int r104 = 0;
    L18:
        if (r104 >= r103) goto L24;
        String r105 = r101[r104];     // Catch: Exception -> L40
        if (r105.equals("data_version") == true) goto L22;
        this.f32082e.add(r105);     // Catch: Exception -> L40
    L22:
        r104 = r104 + 1;     // Catch: Exception -> L40
        goto L18
    L24:
        if (this.f32082e.size() > 0) goto L42;
    L33:
        Vector<String> r106 = this.f32082e;
        if (r106 != null) goto L36;
        return null;
    L36:
        if (r106.size() != 0) goto L39;
        return null;
    L39:
        return new ArrayList(this.f32082e);
    L42:
        Collections.sort(this.f32082e, new b(this));     // Catch: Exception -> L27
    L29:
        this.f32080c = true;     // Catch: Exception -> L40
        goto L33
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L40
        goto L29
    L16:
        r102.clear();     // Catch: Exception -> L40
        goto L17
    L30:
        Vector<String> r107 = this.f32082e;     // Catch: Exception -> L40
        if (r107 == null) goto L33;
        r107.clear();     // Catch: Exception -> L40
        this.f32082e = null;     // Catch: Exception -> L40
    L49:
        return null;
    L8:
        if (this.f32082e == null) goto L41;
        return new ArrayList(this.f32082e);
    }

    public ArrayList<String> e() {
        if (this.f32079b != null) goto L6;
        return null;
    L6:
        if (this.f32081d == true) goto L8;
    L48:
        Bundle r100 = new Bundle();     // Catch: Exception -> L47
        this.f32079b.a(r100);     // Catch: Exception -> L47
        String[] r101 = r100.getStringArray("rstString");     // Catch: Exception -> L47
        if (r101 == null) goto L36;
        Vector<String> r102 = this.f32083f;     // Catch: Exception -> L47
        if (r102 != null) goto L16;
        this.f32083f = new Vector();     // Catch: Exception -> L47
    L17:
        int r103 = 0;
    L19:
        if (r103 >= r101.length) goto L30;
        if (r101[r103].equals("data_version") == true) goto L28;
        String r104 = this.f32079b.a(r101[r103]);     // Catch: Exception -> L47
        if (r104 == null) goto L28;
        if (r104.equals("") == true) goto L28;
        this.f32083f.add(r101[r103]);     // Catch: Exception -> L47
    L28:
        r103 = r103 + 1;     // Catch: Exception -> L47
        goto L19
    L30:
        if (this.f32083f.size() > 0) goto L50;
    L39:
        Vector<String> r105 = this.f32083f;     // Catch: Exception -> L47
        if (r105 != null) goto L42;
        return null;
    L42:
        if (r105.isEmpty() == true) goto L58;
        return new ArrayList(this.f32083f);
    L58:
        return null;
    L50:
        Collections.sort(this.f32083f, new b(this));     // Catch: Exception -> L33
    L35:
        this.f32081d = true;     // Catch: Exception -> L47
        goto L39
    L33:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L47
        goto L35
    L16:
        r102.clear();     // Catch: Exception -> L47
        goto L17
    L36:
        Vector<String> r106 = this.f32083f;     // Catch: Exception -> L47
        if (r106 == null) goto L39;
        r106.clear();     // Catch: Exception -> L47
        this.f32083f = null;     // Catch: Exception -> L47
    L59:
        return null;
    L8:
        if (this.f32083f == null) goto L48;
        return new ArrayList(this.f32083f);
    }

    private a() {
        C0644a r100 = null;
        this.f32079b = null;
        this.f32080c = false;
        this.f32081d = false;
        this.f32082e = null;
        this.f32083f = null;
        this.f32084g = false;
        this.f32085h = new d(this, r100);
        this.f32086i = new c(this, r100);
    }

    public synchronized boolean a(String r100) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.f32079b != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        if (r100 != null) goto L10;
    L19:
        monitor-exit(this);
        return false;
    L10:
        if (r100.equals("") == true) goto L19;
        if (c(r100) == true) goto L16;
        monitor-exit(this);
        return false;
    L16:
        h();     // Catch: Throwable -> L21
        boolean r101 = this.f32079b.c(r100);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r101;
    }

    public FavSyncPoi b(String r100) {
        if (this.f32079b == null) goto L24;
        if (r100 == null) goto L24;
        if (r100.equals("") == true) goto L24;
    L22:
        e = move-exception;
        e.printStackTrace();
    L19:
        e = move-exception;
        e.printStackTrace();
        return null;
    L9:
        if (c(r100) == true) goto L11;
        return null;
    L11:
        FavSyncPoi r101 = new FavSyncPoi();     // Catch: JSONException -> L19 NullPointerException -> L22
        String r102 = this.f32079b.a(r100);     // Catch: JSONException -> L19 NullPointerException -> L22
        if (r102 != null) goto L14;
    L18:
        return null;
    L14:
        if (r102.equals("") == true) goto L18;
        JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L19 NullPointerException -> L22
        JSONObject r104 = r103.optJSONObject("Fav_Sync");     // Catch: JSONException -> L19 NullPointerException -> L22
        String r105 = r103.optString("Fav_Content");     // Catch: JSONException -> L19 NullPointerException -> L22
        r101.f32069b = r104.optString("uspoiname");     // Catch: JSONException -> L19 NullPointerException -> L22
        JSONObject r106 = r104.optJSONObject(GXTemplateKey.GAIAX_PT);     // Catch: JSONException -> L19 NullPointerException -> L22
        r101.f32070c = new Point(r106.optInt("x"), r106.optInt("y"));     // Catch: JSONException -> L19 NullPointerException -> L22
        r101.f32072e = r104.optString("ncityid");     // Catch: JSONException -> L19 NullPointerException -> L22
        r101.f32073f = r104.optString("uspoiuid");     // Catch: JSONException -> L19 NullPointerException -> L22
        r101.f32074g = r104.optInt("npoitype");     // Catch: JSONException -> L19 NullPointerException -> L22
        r101.f32071d = r104.optString("addr");     // Catch: JSONException -> L19 NullPointerException -> L22
        r101.f32075h = r104.optString("addtimesec");     // Catch: JSONException -> L19 NullPointerException -> L22
        r101.f32076i = r104.optBoolean("bdetail");     // Catch: JSONException -> L19 NullPointerException -> L22
        r101.f32077j = r105;     // Catch: JSONException -> L19 NullPointerException -> L22
        r101.f32068a = r100;     // Catch: JSONException -> L19 NullPointerException -> L22
        return r101;
    L24:
        return null;
    }

    public boolean c(String r100) {
        if (this.f32079b == null) goto L10;
        if (r100 == null) goto L10;
        if (r100.equals("") == true) goto L10;
        if (this.f32079b.b(r100) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public synchronized int a(String r100, FavSyncPoi r101) {
        monitor-enter(this);
    L74:
        th = move-exception;
        throw th;
    L5:
        if (this.f32079b != null) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        if (r100 != null) goto L11;
    L72:
        monitor-exit(this);
        return -1;
    L11:
        if (r100.equals("") == true) goto L72;
        if (r101 == null) goto L72;
        h();     // Catch: Throwable -> L74
        ArrayList<String> r102 = d();     // Catch: Throwable -> L74
        if (r102 == null) goto L18;
        int r103 = r102.size();     // Catch: Throwable -> L74
    L20:
        if ((r103 + 1) <= 500) goto L24;
        monitor-exit(this);
        return -2;
    L24:
        if (r102 != null) goto L26;
    L78:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L66 JSONException -> L69
        r101.f32069b = r100;     // Catch: Throwable -> L66 JSONException -> L69
        String r105 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L66 JSONException -> L69
        String r106 = r105 + "_" + r101.hashCode();     // Catch: Throwable -> L66 JSONException -> L69
        r101.f32075h = r105;     // Catch: Throwable -> L66 JSONException -> L69
        r101.f32068a = r106;     // Catch: Throwable -> L66 JSONException -> L69
        r104.put("bdetail", r101.f32076i);     // Catch: Throwable -> L66 JSONException -> L69
        r104.put("uspoiname", r101.f32069b);     // Catch: Throwable -> L66 JSONException -> L69
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L66 JSONException -> L69
        r107.put("x", r101.f32070c.getDoubleX());     // Catch: Throwable -> L66 JSONException -> L69
        r107.put("y", r101.f32070c.getDoubleY());     // Catch: Throwable -> L66 JSONException -> L69
        r104.put(GXTemplateKey.GAIAX_PT, r107);     // Catch: Throwable -> L66 JSONException -> L69
        r104.put("ncityid", r101.f32072e);     // Catch: Throwable -> L66 JSONException -> L69
        r104.put("npoitype", r101.f32074g);     // Catch: Throwable -> L66 JSONException -> L69
        r104.put("uspoiuid", r101.f32073f);     // Catch: Throwable -> L66 JSONException -> L69
        r104.put("addr", r101.f32071d);     // Catch: Throwable -> L66 JSONException -> L69
        r104.put("addtimesec", r101.f32075h);     // Catch: Throwable -> L66 JSONException -> L69
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L66 JSONException -> L69
        r108.put("Fav_Sync", r104);     // Catch: Throwable -> L66 JSONException -> L69
        r108.put("Fav_Content", r101.f32077j);     // Catch: Throwable -> L66 JSONException -> L69
        if (this.f32079b.a(r106, r108.toString()) == false) goto L63;
        h();     // Catch: Throwable -> L66 JSONException -> L69
        j();     // Catch: Throwable -> L74
        monitor-exit(this);
        return 1;
    L63:
        j();     // Catch: Throwable -> L74
        monitor-exit(this);
        return 0;
    L69:
        j();     // Catch: Throwable -> L74
        return 0;
    L66:
        th = move-exception;
        j();     // Catch: Throwable -> L74
        throw th;     // Catch: Throwable -> L74
    L26:
        if (r102.size() <= 0) goto L78;
        Iterator<String> r109 = r102.iterator();     // Catch: Throwable -> L74
    L29:
        if (r109.hasNext() == false) goto L78;
        FavSyncPoi r110 = b(r109.next());     // Catch: Throwable -> L74
        if (r110 == null) goto L29;
        if (r100.equals(r110.f32069b) == false) goto L29;
        monitor-exit(this);
        return -1;
    L18:
        r103 = 0;
        goto L20
    }

    public synchronized boolean b(String r100, FavSyncPoi r101) {
        monitor-enter(this);
        boolean r102 = false;
        if (this.f32079b == null) goto L41;
        if (r100 == null) goto L41;
        if (r100.equals("") == true) goto L41;
        if (r101 == null) goto L41;
        if (c(r100) == true) goto L46;
        monitor-exit(this);
        return false;
    L46:
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L39 Throwable -> L43
        r103.put("uspoiname", r101.f32069b);     // Catch: JSONException -> L39 Throwable -> L43
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L39 Throwable -> L43
        r104.put("x", r101.f32070c.getDoubleX());     // Catch: JSONException -> L39 Throwable -> L43
        r104.put("y", r101.f32070c.getDoubleY());     // Catch: JSONException -> L39 Throwable -> L43
        r103.put(GXTemplateKey.GAIAX_PT, r104);     // Catch: JSONException -> L39 Throwable -> L43
        r103.put("ncityid", r101.f32072e);     // Catch: JSONException -> L39 Throwable -> L43
        r103.put("npoitype", r101.f32074g);     // Catch: JSONException -> L39 Throwable -> L43
        r103.put("uspoiuid", r101.f32073f);     // Catch: JSONException -> L39 Throwable -> L43
        r103.put("addr", r101.f32071d);     // Catch: JSONException -> L39 Throwable -> L43
        String r105 = String.valueOf(System.currentTimeMillis());     // Catch: JSONException -> L39 Throwable -> L43
        r101.f32075h = r105;     // Catch: JSONException -> L39 Throwable -> L43
        r103.put("addtimesec", r105);     // Catch: JSONException -> L39 Throwable -> L43
        r103.put("bdetail", false);     // Catch: JSONException -> L39 Throwable -> L43
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L39 Throwable -> L43
        r106.put("Fav_Sync", r103);     // Catch: JSONException -> L39 Throwable -> L43
        r106.put("Fav_Content", r101.f32077j);     // Catch: JSONException -> L39 Throwable -> L43
        h();     // Catch: JSONException -> L39 Throwable -> L43
        NAFavorite r107 = this.f32079b;     // Catch: JSONException -> L39 Throwable -> L43
        if (r107 == null) goto L37;
        if (r107.b(r100, r106.toString()) == false) goto L37;
        r102 = true;
        goto L37
    L37:
        monitor-exit(this);
        return r102;
    L40:
        return false;
    L41:
        monitor-exit(this);
        return false;
    L43:
        th = move-exception;
        throw th;
    }
}
