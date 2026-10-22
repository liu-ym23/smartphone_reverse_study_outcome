package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.MapsInitializer;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class w1 implements t7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    x1 f28258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f28259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f28260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f28261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f28262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f28263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    s1 f28264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c2 f28265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f28266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a8 f28267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private t1 f28268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f28269l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f28270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    a f28271n;

    public interface a {
    }

    public static class b extends c3 {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final String f28272o;

        @Override // com.amap.api.mapcore.util.y7
        public Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.y7
        public boolean isSupportIPV6() {
            return false;
        }

        @Override // com.amap.api.mapcore.util.y7
        public String getIPV6URL() {
            return this.f28272o;
        }

        @Override // com.amap.api.mapcore.util.y7
        public String getURL() {
            return this.f28272o;
        }

        public b(String r100) {
            this.f28272o = r100;
        }
    }

    private void a() {
        long r100 = System.currentTimeMillis();
        x1 r101 = this.f28258a;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r100 - this.f28269l) <= 500) goto L13;
        this.f28264g.a(r101.a(), this.f28258a.b(), this.f28261d, this.f28259b, this.f28260c);
        this.f28269l = r100;
        long r102 = this.f28259b;
        long r103 = this.f28261d;
        if (r103 <= 0) goto L14;
        c2 r104 = this.f28265h;
        if (r104 == null) goto L15;
        r104.a(r103, r102);
        this.f28269l = System.currentTimeMillis();
        return;
    L15:
        return;
    L14:
        return;
    }

    private void b() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f28258a.d() + this.f28258a.c());
        if (r100.exists() == false) goto L10;
        this.f28262e = false;
        this.f28259b = r100.length();
        long r101 = c();     // Catch: IOException -> L7
        this.f28261d = r101;     // Catch: IOException -> L7
        this.f28260c = r101;     // Catch: IOException -> L7
        return;
    L7:
        c2 r102 = this.f28265h;
        if (r102 == null) goto L14;
        r102.a(c2.a.f27106c);
        return;
    L14:
        return;
    L10:
        this.f28259b = 0;
        this.f28260c = 0;
    }

    private long c() throws IOException {
        int r100 = -1;
        if (u5.a(this.f28263f, w3.b()).f28191a != u5.e.f28083b) goto L5;
        String r101 = this.f28258a.e();
        x7 r102 = x7.b();     // Catch: k5 -> L13
        b r103 = new b(r101);     // Catch: k5 -> L13
        if (MapsInitializer.getProtocol() != 2) goto L10;
        boolean r104 = true;
    L11:
        Map<String, String> r105 = r102.d(r103, r104);     // Catch: k5 -> L13
    L15:
        if (r105 == null) goto L23;
        Iterator<String> r106 = r105.keySet().iterator();
    L18:
        if (r106.hasNext() == false) goto L23;
        String r107 = r106.next();
        if ("Content-Length".equalsIgnoreCase(r107) == false) goto L18;
        r100 = CastIntegerProtector.parseInt(r105.get(r107));
    L23:
        return r100;
    L10:
        r104 = false;
    L13:
        e = move-exception;
        e.printStackTrace();
        r105 = null;
        goto L15
    L5:
        return -1;
    }

    private void d() throws IOException {
        d2 r100 = new d2(this.f28266i);
        r100.setConnectionTimeout(30000);
        r100.setSoTimeout(30000);
        long r101 = this.f28259b;
        long r102 = this.f28260c;
        if (MapsInitializer.getProtocol() != 2) goto L5;
        boolean r103 = true;
    L6:
        this.f28267j = new a8(r100, r101, r102, r103);
        this.f28268k = new t1(this.f28258a.d() + File.separator + this.f28258a.c(), this.f28259b);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public void e() {
        a8 r100 = this.f28267j;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public void f() {
    L32:
        c2 r100 = this.f28265h;
        if (r100 == null) goto L39;
        r100.a(c2.a.f27106c);
        return;
    L39:
        return;
    L3:
        if (w3.d(this.f28263f) == true) goto L9;
        c2 r101 = this.f28265h;     // Catch: IOException -> L32
        if (r101 == null) goto L37;
        r101.a(c2.a.f27105b);     // Catch: IOException -> L32
        return;
    L37:
        return;
    L9:
        if (new PolarisFileWrapper(this.f28258a.d() + File.separator + this.f28258a.c()).length() >= 10) goto L11;
        boolean r102 = false;
    L12:
        if (r102 == true) goto L15;
        this.f28262e = true;     // Catch: IOException -> L32
    L15:
        if (this.f28262e == false) goto L24;
        long r103 = c();     // Catch: IOException -> L32
        this.f28261d = r103;     // Catch: IOException -> L32
        if (r103 != (-1)) goto L20;
    L23:
        this.f28259b = 0;     // Catch: IOException -> L32
        goto L24
    L20:
        if (r103 == (-2)) goto L23;
        this.f28260c = r103;     // Catch: IOException -> L32
    L24:
        c2 r104 = this.f28265h;     // Catch: IOException -> L32
        if (r104 == null) goto L28;
        r104.h();     // Catch: IOException -> L32
    L28:
        if (this.f28259b < this.f28260c) goto L30;
        onFinish();     // Catch: IOException -> L32
        return;
    L30:
        d();     // Catch: IOException -> L32
        this.f28267j.a(this);     // Catch: IOException -> L32
        return;
    L11:
        r102 = true;
        goto L12
    }

    @Override // com.amap.api.mapcore.util.t7.a
    public void onStop() {
        if (this.f28270m == false) goto L5;
        return;
    L5:
        c2 r100 = this.f28265h;
        if (r100 == null) goto L8;
        r100.onCancel();
    L8:
        this.f28264g.a(this.f28258a.a(), this.f28258a.b(), this.f28261d, this.f28259b, this.f28260c);
    }

    @Override // com.amap.api.mapcore.util.t7.a
    public void onFinish() {
        a();
        c2 r100 = this.f28265h;
        if (r100 == null) goto L5;
        r100.onFinish();
    L5:
        t1 r101 = this.f28268k;
        if (r101 == null) goto L14;
        RandomAccessFile r102 = r101.f27985a;
        if (r102 == null) goto L14;
        r102.close();     // Catch: IOException -> L11
    L13:
        r101.f27985a = null;
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        a r103 = this.f28271n;
        if (r103 == null) goto L20;
        ((j1) r103).c();
        return;
    }

    public void a(a r100) {
        this.f28271n = r100;
    }

    @Override // com.amap.api.mapcore.util.t7.a
    public void onException(Throwable r100) {
        this.f28270m = true;
        a8 r101 = this.f28267j;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        c2 r102 = this.f28265h;
        if (r102 == null) goto L9;
        r102.a(c2.a.f27105b);
    L9:
        if ((r100 instanceof IOException) == false) goto L11;
        return;
    L11:
        t1 r103 = this.f28268k;
        if (r103 == null) goto L23;
        RandomAccessFile r104 = r103.f27985a;
        if (r104 == null) goto L24;
        r104.close();     // Catch: IOException -> L17
    L19:
        r103.f27985a = null;
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L24:
        return;
    }

    @Override // com.amap.api.mapcore.util.t7.a
    public void onDownload(byte[] r100, long r101) {
        t1 r102 = this.f28268k;     // Catch: IOException -> L11
        monitor-enter(r102);     // Catch: IOException -> L11
        r102.f27985a.write(r100);     // Catch: Throwable -> L8
        monitor-exit(r102);     // Catch: IOException -> L11
        this.f28259b = r101;
        a();
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: IOException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        t6.a(e, "fileAccessI", "fileAccessI.write(byte[] data)");
        c2 r103 = this.f28265h;
        if (r103 == null) goto L15;
        r103.a(c2.a.f27106c);
    L15:
        a8 r104 = this.f28267j;
        if (r104 == null) goto L22;
        r104.a();
        return;
    }

    public w1(x1 r100, String r101, Context r102, c2 r103) throws IOException {
        this.f28258a = null;
        this.f28259b = 0;
        this.f28260c = 0;
        this.f28262e = true;
        this.f28269l = 0;
        this.f28270m = false;
        this.f28264g = s1.b(r102.getApplicationContext());
        this.f28258a = r100;
        this.f28263f = r102;
        this.f28266i = r101;
        this.f28265h = r103;
        b();
    }
}
