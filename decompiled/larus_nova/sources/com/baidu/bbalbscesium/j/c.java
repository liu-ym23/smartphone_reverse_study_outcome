package com.baidu.bbalbscesium.j;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import com.baidu.bbalbscesium.h;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.bduploader.UploadKeys;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class c extends com.baidu.bbalbscesium.j.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f30217i = "isc";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f30218j = 448;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f30219k = 256;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f30220l = 128;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f30221m = 64;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f30222n = 56;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f30223o = 32;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f30224p = 16;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f30225q = 8;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f30226r = 7;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f30227s = 4;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f30228t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f30229u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f30230v = -100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    com.baidu.bbalbscesium.n.a.C0628a f30231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f30232h;

    public static class a {
        public a() {
        }

        public static boolean a(com.baidu.bbalbscesium.n.a.C0628a r100, com.baidu.bbalbscesium.n.a r101) {
            if (Build.VERSION.SDK_INT < 23) goto L5;
        L10:
            if (r100 == null) goto L16;
            if (a(r100.b()) == false) goto L13;
            r100 = r100.d();
            goto L10
        L13:
            return false;
        L16:
            return a(r101.a());
        L5:
            if (r100 == null) goto L9;
            if (r100.b().equals(r101.a()) == true) goto L9;
            r100.b().setExecutable(true, false);
            r100 = r100.d();
        L9:
            return true;
        }

        private static boolean a(File r100) {
            if (Build.VERSION.SDK_INT >= 23) goto L10;
        L8:
            return false;
        L10:
            int r101 = Os.stat(r100.getAbsolutePath()).st_mode;     // Catch: Throwable -> L9
            if ((r101 & 1) != 0) goto L7;
            String r102 = r100.getAbsolutePath();     // Catch: Throwable -> L9
            Os.chmod(r102, r101 | 1);     // Catch: Throwable -> L9
        L7:
            return true;
        }
    }

    public class b {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final String f30233h = "pub.dat";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final String f30234i = "pub_lst_ts";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f30235j = "pub_info";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f30236k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f30237l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f30238m = 2;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f30239n = 3;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final String f30240o = "d_form_ver";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final int f30241p = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.baidu.bbalbscesium.o.b f30242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f30243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h.a f30244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f30245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f30246e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f30247f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f30248g;

        public b(c r100) {
            this.f30248g = r100;
            this.f30242a = new com.baidu.bbalbscesium.o.b();
            this.f30246e = true;
        }

        private boolean a(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L9;
        L7:
            return false;
        L9:
            JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L8
            this.f30243b = JSONObjectProtectorUtils.getLong(r101, f30234i);     // Catch: Exception -> L8
            this.f30244c = h.b(JSONObjectProtectorUtils.getString(r101, f30235j));     // Catch: Exception -> L8
            this.f30247f = JSONObjectProtectorUtils.getInt(r101, f30240o);     // Catch: Exception -> L8
            this.f30245d = false;     // Catch: Exception -> L8
            return true;
        }

        public long a(long r100) {
            return this.f30242a.a(r100);
        }

        public h.a a() {
            return this.f30244c;
        }

        public void a(long r100, long r101) {
            if (this.f30242a.a(r100, r101) == false) goto L6;
            this.f30245d = true;
            return;
        }

        public void a(h.a r100) {
            if (r100.equals(this.f30244c) == true) goto L6;
            this.f30244c = r100;
            this.f30245d = true;
            return;
        }

        public boolean a(PackageInfo r100) {
            String r101 = this.f30248g.f30231g.a(new PolarisFileWrapper(r100.applicationInfo.dataDir)).a(f30233h, true);
            this.f30246e = false;
            return a(r101);
        }

        public long b() {
            return this.f30243b;
        }

        public void b(long r100) {
            if (this.f30243b == r100) goto L6;
            this.f30243b = r100;
            this.f30245d = true;
            return;
        }

        public boolean c() {
            return c.a(this.f30248g.f30231g.a(f30233h), true);
        }

        public boolean d() {
            if (this.f30246e == false) goto L16;
            if (this.f30245d == true) goto L18;
        L14:
            return false;
        L18:
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L17
            r100.put(f30235j, this.f30244c.f());     // Catch: Exception -> L17
            r100.put(f30234i, this.f30243b);     // Catch: Exception -> L17
            r100.put(f30240o, 1);     // Catch: Exception -> L17
            com.baidu.bbalbscesium.n.a.C0628a r101 = this.f30248g.f30231g;     // Catch: Exception -> L17
            r101.a(f30233h, r100.toString(), true);     // Catch: Exception -> L17
            this.f30245d = false;     // Catch: Exception -> L17
            return true;
        L16:
            throw new IllegalStateException();
        }

        public boolean e() {
            return a(this.f30248g.f30231g.a(f30233h, true));
        }
    }

    /* JADX INFO: renamed from: com.baidu.bbalbscesium.j.c$c, reason: collision with other inner class name */
    public class C0626c extends com.baidu.bbalbscesium.j.a.c {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final String f30249n = "pkg";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final String f30250o = "last_fe_ts";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final String f30251p = "tar_pkg_lst_pub_ts";

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final String f30252q = "tar_pkg_lst_up_ts";

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final String f30253r = "info";

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final String f30254s = "d_form_ver";

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final int f30255t = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f30256g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f30257h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f30258i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f30259j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f30260k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private h.a f30261l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ c f30262m;

        public C0626c(c r100, String r101) {
            this.f30262m = r100;
            super(r100.f30231g, r101);
        }

        public void a(b r100) {
            a(r100.a());
            b(r100.b());
        }

        @Override // com.baidu.bbalbscesium.j.a.c
        public void a(JSONObject r100) throws JSONException {
            this.f30257h = JSONObjectProtectorUtils.getString(r100, f30249n);
            this.f30259j = JSONObjectProtectorUtils.getInt(r100, f30251p);
            this.f30258i = JSONObjectProtectorUtils.getLong(r100, f30250o);
            this.f30261l = h.b(JSONObjectProtectorUtils.getString(r100, "info"));
            this.f30260k = JSONObjectProtectorUtils.getLong(r100, f30252q);
            this.f30256g = JSONObjectProtectorUtils.getInt(r100, f30254s);
        }

        public boolean a(long r100) {
            if (this.f30258i == r100) goto L6;
            this.f30258i = r100;
            a(true);
            return true;
        L6:
            return false;
        }

        public boolean a(h.a r100) {
            if (r100.equals(this.f30261l) == true) goto L6;
            this.f30261l = r100;
            a(true);
            return true;
        L6:
            return false;
        }

        public boolean a(String r100) {
            if (r100.equals(this.f30257h) == true) goto L6;
            this.f30257h = r100;
            a(true);
            return true;
        L6:
            return false;
        }

        @Override // com.baidu.bbalbscesium.j.a.c
        public void b(JSONObject r100) throws JSONException {
            r100.put(f30249n, this.f30257h);
            r100.put(f30250o, this.f30258i);
            r100.put(f30251p, this.f30259j);
            r100.put("info", this.f30261l.f());
            r100.put(f30252q, this.f30260k);
            r100.put(f30254s, 1);
        }

        public boolean b(long r100) {
            if (this.f30259j == r100) goto L6;
            this.f30259j = r100;
            a(true);
            return true;
        L6:
            return false;
        }

        public h.a c() {
            return this.f30261l;
        }

        public boolean c(long r100) {
            if (this.f30260k == r100) goto L6;
            this.f30260k = r100;
            a(true);
            return true;
        L6:
            return false;
        }

        public long d() {
            return this.f30260k;
        }

        public String e() {
            return this.f30257h;
        }
    }

    public c() {
        super("isc", com.baidu.bbalbscesium.j.b.f30214f);
        this.f30232h = new b(this);
    }

    public static /* synthetic */ boolean a(File r100, boolean r101) {
        return b(r100, r101);
    }

    private com.baidu.bbalbscesium.j.a.f b(com.baidu.bbalbscesium.j.a.e r100, h.a r101) {
        this.f30232h.e();
        this.f30231g.a();
        if (r101.equals(this.f30232h.a()) == true) goto L5;
        this.f30232h.a(r101);
        this.f30232h.b(System.currentTimeMillis());
        return com.baidu.bbalbscesium.j.a.f.d();
    L5:
        return com.baidu.bbalbscesium.j.a.f.d();
    }

    private static boolean b(File r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 23) goto L22;
        if (r101 == false) goto L16;
        int r102 = UploadKeys.KeyIsEstimatedVideoInfo;
    L20:
        Os.chmod(r100.getAbsolutePath(), r102);     // Catch: Throwable -> L19
        return true;
    L19:
        return false;
    L16:
        r102 = 432;
        goto L20
    L22:
        if (r101 == true) goto L6;
        boolean r103 = r100.setReadable(false, false);     // Catch: Throwable -> L13
        boolean r104 = r100.setReadable(true, true);     // Catch: Throwable -> L13
        if (r103 == false) goto L11;
        if (r104 == false) goto L11;
        return true;
    L11:
        return false;
    L6:
        return r100.setReadable(true, false);
    L13:
        return false;
    }

    private void c() {
        if (a.a(this.f30231g, this.f30183a.f30188b) == false) goto L5;
        int r100 = 1;
    L6:
        this.f30232h.a(r100, 3);
        return;
    L5:
        r100 = 2;
        goto L6
    }

    @Override // com.baidu.bbalbscesium.j.a
    public com.baidu.bbalbscesium.j.a.f a(com.baidu.bbalbscesium.j.a.e r100, h.a r101) {
        return com.baidu.bbalbscesium.j.a.f.d();
    }

    @Override // com.baidu.bbalbscesium.j.a
    public com.baidu.bbalbscesium.j.a.h a(String r100, com.baidu.bbalbscesium.j.a.g r110) {
        C0626c r101 = null;
        PackageInfo r102 = this.f30183a.f30187a.getPackageManager().getPackageInfo(r100, 0);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r102 != null) goto L11;
        return com.baidu.bbalbscesium.j.a.h.a(-2);
    L11:
        if (r110.f30203a == false) goto L19;
        r101 = new C0626c(this, r100);
        r101.b();
        if (r100.equals(r101.e()) == false) goto L19;
        if (r102.lastUpdateTime != r101.d()) goto L19;
        h.a r103 = r101.c();
    L18:
        return com.baidu.bbalbscesium.j.a.h.a(r103);
    L19:
        b r104 = new b(this);
        if (r104.a(r102) == true) goto L24;
        return com.baidu.bbalbscesium.j.a.h.a(-2);
    L24:
        if (r110.f30203a == false) goto L27;
        if (r101 == null) goto L27;
        r101.a(r104);
        r101.a(System.currentTimeMillis());
        r101.c(r102.lastUpdateTime);
        r101.a(r100);
        r101.a();
    L27:
        r103 = r104.a();
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.baidu.bbalbscesium.j.a
    public void a(com.baidu.bbalbscesium.j.a.d r100) {
        this.f30231g = this.f30184b.b("isc");
    }
}
