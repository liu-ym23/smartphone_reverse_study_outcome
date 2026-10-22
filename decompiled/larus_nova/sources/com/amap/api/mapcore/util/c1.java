package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class c1 extends OfflineMapCity implements b2, l1 {
    public static final Parcelable.Creator<c1> CREATOR = null;
    private long A;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f2 f27088k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f2 f27089l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f2 f27090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f2 f27091n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f2 f27092o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final f2 f27093p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f2 f27094q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f2 f27095r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f2 f27096s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final f2 f27097t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f2 f27098u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    f2 f27099v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Context f27100w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f27101x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f27102y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f27103z;

    public static class a implements Parcelable.Creator<c1> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public c1 createFromParcel(Parcel r100) {
            return new c1(r100);
        }

        @Override // android.os.Parcelable.Creator
        public c1[] newArray(int r100) {
            return new c1[r100];
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.amap.api.mapcore.util.b2
    public void b() {
        this.A = 0;
        setCompleteCode(0);
        this.f27099v.equals(this.f27092o);
        this.f27099v.h();
    }

    @Override // com.amap.api.mapcore.util.b2
    public String e() {
        StringBuffer r100 = new StringBuffer();
        String r101 = a2.b(getUrl());
        if (r101 == null) goto L5;
        r100.append(r101);
    L6:
        r100.append(".zip");
        return r100.toString();
    L5:
        r100.append(getPinyin());
        goto L6
    }

    @Override // com.amap.api.mapcore.util.b2
    public void f() {
        this.f27099v.equals(this.f27092o);
        this.f27099v.a(this.f27095r.e());
    }

    @Override // com.amap.api.mapcore.util.c2
    public void h() {
        this.A = 0;
        this.f27099v.equals(this.f27089l);
        this.f27099v.h();
    }

    public void j() {
        f1 r100 = f1.a(this.f27100w);
        if (r100 == null) goto L11;
        i1 r101 = r100.f27233j;
        if (r101 == null) goto L7;
        r101.a(this);
    L7:
        f1.e r102 = r100.f27232i;
        if (r102 == null) goto L12;
        Message r103 = r102.obtainMessage(10);
        r103.obj = this;
        r100.f27232i.sendMessage(r103);
        return;
    L12:
        return;
    }

    public void k() {
        this.f27099v.e();
        if (this.f27099v.equals(this.f27091n) == false) goto L6;
        this.f27099v.b();
        return;
    L6:
        if (this.f27099v.equals(this.f27090m) == false) goto L9;
        this.f27099v.g();
        return;
    L9:
        if (this.f27099v.equals(this.f27094q) == false) goto L11;
    L22:
        f1 r100 = f1.a(this.f27100w);
        if (r100 == null) goto L25;
        r100.c(this);
    L25:
        this.f27103z = true;
        return;
    L11:
        if (this.f27099v.equals(this.f27095r) == true) goto L22;
        if (this.f27099v.equals(this.f27097t) == false) goto L16;
    L21:
        this.f27099v.h();
        return;
    L16:
        if (this.f27099v.equals(this.f27096s) == true) goto L21;
        if (this.f27099v.a(this.f27098u) == true) goto L21;
        this.f27099v.d();
    }

    public String m() {
        if (TextUtils.isEmpty(this.f27101x) == false) goto L6;
        return null;
    L6:
        String r100 = n();
        return r100.substring(0, r100.lastIndexOf(46));
    }

    public String n() {
        if (TextUtils.isEmpty(this.f27101x) == false) goto L6;
        return null;
    L6:
        String r100 = this.f27101x;
        return r100.substring(0, r100.lastIndexOf("."));
    }

    @Override // com.amap.api.mapcore.util.c2
    public void onFinish() {
        this.f27099v.equals(this.f27090m);
        this.f27099v.a();
    }

    public void p() {
        String r100 = f1.f27220m;
        String r101 = a2.b(getUrl());
        if (r101 == null) goto L5;
        this.f27101x = r100 + r101 + ".zip.tmp";
        return;
    L5:
        this.f27101x = r100 + getPinyin() + ".zip.tmp";
    }

    public void q() {
        f1 r100 = f1.a(this.f27100w);
        if (r100 == null) goto L6;
        r100.a(this);
        j();
        return;
    }

    public void r() {
        f1 r100 = f1.a(this.f27100w);
        if (r100 == null) goto L6;
        r100.b(this);
        return;
    }

    public void s() {
        f1 r100 = f1.a(this.f27100w);
        if (r100 == null) goto L6;
        r100.d(this);
        return;
    }

    public n1 t() {
        setState(this.f27099v.e());
        n1 r100 = new n1(this, this.f27100w);
        r100.e(this.f27102y);
        return r100;
    }

    @Override // com.amap.api.mapcore.util.b2
    public String a() {
        return getAdcode();
    }

    @Override // com.amap.api.mapcore.util.v1
    public String c() {
        return n();
    }

    @Override // com.amap.api.mapcore.util.b2
    public boolean g() {
        a2.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    @Override // com.amap.api.mapcore.util.v1
    public String i() {
        return m();
    }

    @Override // com.amap.api.mapcore.util.b2
    public void d() {
        q();
    }

    public f2 l() {
        return this.f27099v;
    }

    public String o() {
        return this.f27102y;
    }

    @Override // com.amap.api.mapcore.util.c2
    public void onCancel() {
        q();
    }

    public c1(Parcel r100) {
        super(r100);
        this.f27088k = new h2(6, this);
        this.f27089l = new n2(2, this);
        this.f27090m = new j2(0, this);
        this.f27091n = new l2(3, this);
        this.f27092o = new m2(1, this);
        this.f27093p = new g2(4, this);
        this.f27094q = new k2(7, this);
        this.f27095r = new i2(-1, this);
        this.f27096s = new i2(101, this);
        this.f27097t = new i2(102, this);
        this.f27098u = new i2(103, this);
        this.f27101x = null;
        this.f27102y = "";
        this.f27103z = false;
        this.A = 0;
        this.f27102y = r100.readString();
    }

    @Override // com.amap.api.mapcore.util.b2
    public void a(String r110) {
        this.f27099v.equals(this.f27092o);
        this.f27102y = r110;
        String r111 = n();
        String r100 = m();
        if (TextUtils.isEmpty(r111) == false) goto L5;
    L19:
        f();
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L19;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100 + HTTP.URL_DEFAULT);
        PolarisFileWrapper r102 = new PolarisFileWrapper(w3.c(this.f27100w) + File.separator + "map/");
        PolarisFileWrapper r103 = new PolarisFileWrapper(w3.c(this.f27100w));
        if (r103.exists() == true) goto L13;
        if (r103.mkdir() == true) goto L13;
        return;
    L13:
        if (r102.exists() == false) goto L15;
    L17:
        new u1().a(r101, r102, -1, a2.b(r101), new b1(this, r111, r101));
        return;
    L15:
        if (r102.mkdir() == true) goto L17;
    }

    public boolean b(c1 r100) {
        if (r100 != null) goto L5;
    L40:
        return false;
    L5:
        if (r100.getAdcode() == null) goto L40;
        if (r100.getAdcode().isEmpty() == true) goto L40;
        String r101 = r100.getAdcode();     // Catch: Throwable -> L38 AMapException -> L41
        if ("100000".equals(r101) == false) goto L12;
    L13:
        r101 = "000000";
    L42:
        d1.a r102 = new d1(this.f27100w, r101).c();     // Catch: c5 -> L35 Throwable -> L38 AMapException -> L41
        if (r102 != null) goto L18;
    L34:
        return false;
    L18:
        if (r102.f27162a == false) goto L34;
        List<String> r103 = r102.f27165d;     // Catch: Throwable -> L38 AMapException -> L41
        if (r103 == null) goto L34;
        if (r103.isEmpty() == true) goto L34;
        r100.setUrl(r102.f27165d.get(0));     // Catch: Throwable -> L38 AMapException -> L41
        r100.p();     // Catch: Throwable -> L38 AMapException -> L41
        String r104 = r102.f27163b;     // Catch: Throwable -> L38 AMapException -> L41
        if (r104 != null) goto L27;
    L29:
        long r105 = r102.f27164c;     // Catch: Throwable -> L38 AMapException -> L41
        if (r105 <= 0) goto L45;
        r100.setSize(r105);     // Catch: Throwable -> L38 AMapException -> L41
        return true;
    L45:
        return true;
    L27:
        if (r104.isEmpty() == true) goto L29;
        r100.setVersion(r102.f27163b);     // Catch: Throwable -> L38 AMapException -> L41
    L35:
        e = move-exception;
        throw new AMapException(e.a());     // Catch: Throwable -> L38 AMapException -> L41
    L12:
        if ("000001".equals(r101) == false) goto L42;
    L38:
        th = move-exception;
        t6.a(th, "OfflineDownloadManager", "fetchDownloadUrlFromNetwork");
        goto L40
    }

    @Override // com.amap.api.mapcore.util.c2
    public void a(c2.a r100) {
        int r101 = r100.ordinal();
        if (r101 != 0) goto L5;
        int r102 = this.f27097t.e();
    L13:
        if (this.f27099v.equals(this.f27090m) == false) goto L15;
    L17:
        this.f27099v.a(r102);
        return;
    L15:
        if (this.f27099v.equals(this.f27089l) == true) goto L17;
        return;
    L5:
        if (r101 != 1) goto L7;
        r102 = this.f27096s.e();
        goto L13
    L7:
        if (r101 == 2) goto L9;
        r102 = 6;
        goto L13
    L9:
        r102 = this.f27098u.e();
        goto L13
    }

    public void b(int r100) {
        if (r100 != 6) goto L5;
        this.f27099v = this.f27088k;
    L31:
        setState(r100);
        return;
    L5:
        if (r100 != 7) goto L7;
        this.f27099v = this.f27094q;
        goto L31
    L7:
        if (r100 == (-1)) goto L28;
        if (r100 != 0) goto L10;
        this.f27099v = this.f27090m;
        goto L31
    L10:
        if (r100 != 1) goto L12;
        this.f27099v = this.f27092o;
        goto L31
    L12:
        if (r100 != 2) goto L14;
        this.f27099v = this.f27089l;
        goto L31
    L14:
        if (r100 != 3) goto L16;
        this.f27099v = this.f27091n;
        goto L31
    L16:
        if (r100 == 4) goto L23;
        switch(r100) {
            case 101: goto L22;
            case 102: goto L21;
            case 103: goto L20;
            default: goto L18;
        };
    L18:
        if (r100 >= 0) goto L31;
        this.f27099v = this.f27095r;
        goto L31
    L20:
        this.f27099v = this.f27098u;
        goto L31
    L21:
        this.f27099v = this.f27097t;
        goto L31
    L22:
        this.f27099v = this.f27096s;
        goto L31
    L23:
        this.f27099v = this.f27093p;
        goto L31
    L28:
        this.f27099v = this.f27095r;
        goto L31
    }

    @Override // com.amap.api.mapcore.util.b2
    public void a(long r100) {
        long r101 = System.currentTimeMillis();
        if ((r101 - this.A) <= 500) goto L9;
        int r102 = (int) r100;
        if (r102 <= getcompleteCode()) goto L7;
        setCompleteCode(r102);
        j();
    L7:
        this.A = r101;
        return;
    }

    public void b(String r100) {
        this.f27102y = r100;
    }

    public f2 a(int r100) {
        switch(r100) {
            case 101: goto L10;
            case 102: goto L8;
            case 103: goto L6;
            default: goto L4;
        };
    L4:
        return this.f27095r;
    L6:
        return this.f27098u;
    L8:
        return this.f27097t;
    L10:
        return this.f27096s;
    }

    public void a(f2 r100) {
        this.f27099v = r100;
        setState(r100.e());
    }

    public static /* synthetic */ long a(c1 r100) {
        return r100.A;
    }

    public c1(Context r100, int r101) {
        this.f27088k = new h2(6, this);
        this.f27089l = new n2(2, this);
        this.f27090m = new j2(0, this);
        this.f27091n = new l2(3, this);
        this.f27092o = new m2(1, this);
        this.f27093p = new g2(4, this);
        this.f27094q = new k2(7, this);
        this.f27095r = new i2(-1, this);
        this.f27096s = new i2(101, this);
        this.f27097t = new i2(102, this);
        this.f27098u = new i2(103, this);
        this.f27101x = null;
        this.f27102y = "";
        this.f27103z = false;
        this.A = 0;
        this.f27100w = r100;
        b(r101);
    }

    @Override // com.amap.api.mapcore.util.c2
    public void a(long r100, long r101) {
        int r102 = (int) ((r101 * 100) / r100);
        if (r102 == getcompleteCode()) goto L6;
        setCompleteCode(r102);
        j();
        return;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f27102y);
    }

    public c1(Context r100, OfflineMapCity r101) {
        this(r100, r101.getState());
        setCity(r101.getCity());
        setUrl(r101.getUrl());
        setState(r101.getState());
        setCompleteCode(r101.getcompleteCode());
        setAdcode(r101.getAdcode());
        setVersion(r101.getVersion());
        setSize(r101.getSize());
        setCode(r101.getCode());
        setJianpin(r101.getJianpin());
        setPinyin(r101.getPinyin());
        p();
    }

    public static /* synthetic */ long a(c1 r100, long r101) {
        r100.A = r101;
        return r101;
    }
}
