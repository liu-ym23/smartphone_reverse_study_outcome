package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<OfflineMapProvince> f27428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private s1 f27429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f27430c;

    public boolean a(int r100) {
        if (r100 != 0) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 == 3) goto L22;
        if (r100 != 1) goto L10;
        return true;
    L10:
        if (r100 != 102) goto L12;
        return true;
    L12:
        if (r100 != 101) goto L14;
        return true;
    L14:
        if (r100 != 103) goto L16;
        return true;
    L16:
        if (r100 == (-1)) goto L27;
        return false;
    L27:
        return true;
    L22:
        return true;
    }

    public void a() {
        ArrayList<OfflineMapProvince> r100 = this.f27428a;
        if (r100 == null) goto L11;
        monitor-enter(r100);
        this.f27428a.clear();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        this.f27429b = null;
        this.f27430c = null;
    }

    public ArrayList<OfflineMapProvince> b() {
        ArrayList<OfflineMapProvince> r100 = new ArrayList();
        ArrayList<OfflineMapProvince> r101 = this.f27428a;
        monitor-enter(r101);
        Iterator<OfflineMapProvince> r102 = this.f27428a.iterator();     // Catch: Throwable -> L10
    L6:
        if (r102.hasNext() == false) goto L8;
        r100.add(r102.next());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public i1(Context r100) {
        this.f27428a = new ArrayList();
        this.f27430c = r100;
        this.f27429b = s1.b(r100);
    }

    public void a(c1 r100) {
        String r101 = r100.getPinyin();
        ArrayList<OfflineMapProvince> r102 = this.f27428a;
        monitor-enter(r102);
        Iterator<OfflineMapProvince> r103 = this.f27428a.iterator();     // Catch: Throwable -> L18
    L6:
        if (r103.hasNext() == false) goto L16;
        OfflineMapProvince r104 = r103.next();     // Catch: Throwable -> L18
        if (r104 == null) goto L6;
        Iterator<OfflineMapCity> r105 = r104.getCityList().iterator();     // Catch: Throwable -> L18
    L12:
        if (r105.hasNext() == false) goto L6;
        OfflineMapCity r106 = r105.next();     // Catch: Throwable -> L18
        if (r106.getPinyin().trim().equals(r101.trim()) == false) goto L12;
        a(r100, r106);     // Catch: Throwable -> L18
        a(r100, r104);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r102);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public OfflineMapProvince a(String r100) {
        if (r100 != null) goto L5;
    L21:
        return null;
    L5:
        if ("".equals(r100) == true) goto L21;
        ArrayList<OfflineMapProvince> r101 = this.f27428a;
        monitor-enter(r101);
        Iterator<OfflineMapProvince> r102 = this.f27428a.iterator();     // Catch: Throwable -> L18
    L11:
        if (r102.hasNext() == false) goto L16;
        OfflineMapProvince r103 = r102.next();     // Catch: Throwable -> L18
        if (r103.getProvinceName().trim().equalsIgnoreCase(r100.trim()) == false) goto L11;
        monitor-exit(r101);     // Catch: Throwable -> L18
        return r103;
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    private void a(c1 r100, OfflineMapProvince r101) {
        int r102 = r100.f27099v.e();
        boolean r103 = false;
        if (r102 != 6) goto L14;
        r101.setState(r102);
        r101.setCompleteCode(0);
        n1 r104 = new n1(r101, this.f27430c);
        s1 r105 = this.f27429b;
        if (r105 == null) goto L35;
        r105.a(r104);
    L35:
        a2.a(r101.getProvinceCode(), this.f27430c);     // Catch: Exception -> L9 IOException -> L11
    L44:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        if (r102 != 4) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L42;
        Iterator<OfflineMapCity> r107 = r101.getCityList().iterator();
    L20:
        if (r107.hasNext() == false) goto L24;
        if (r107.next().getState() == 4) goto L20;
    L25:
        if (r103 == true) goto L27;
        return;
    L27:
        if (r100.getPinyin().equals(r101.getPinyin()) == false) goto L29;
        r101.setState(r102);
        r101.setCompleteCode(r100.getcompleteCode());
        r101.setVersion(r100.getVersion());
        r101.setUrl(r100.getUrl());
        n1 r108 = new n1(r101, this.f27430c);
        r108.e(r100.o());
        r108.c(r100.getCode());
    L30:
        r108.h();
        s1 r109 = this.f27429b;
        if (r109 == null) goto L33;
        r109.b(r108);
    L33:
        r108.c();
        return;
    L29:
        r101.setState(r102);
        r101.setCompleteCode(100);
        r108 = new n1(r101, this.f27430c);
        goto L30
    L24:
        r103 = true;
        goto L25
    L42:
        return;
    L16:
        r106 = false;
        goto L17
    }

    private void a(c1 r100, OfflineMapCity r110) {
        int r101 = r100.f27099v.e();
        if (r100.f27099v.equals(r100.f27088k) == false) goto L7;
        n1 r102 = r100.t();
        s1 r103 = this.f27429b;
        if (r103 == null) goto L36;
        r103.a(r102);
    L36:
        r110.setState(r101);
        r110.setCompleteCode(r100.getcompleteCode());
        return;
    L7:
        boolean r104 = false;
        if (r100.f27099v.equals(r100.f27093p) == false) goto L25;
        r100.getCity();
        File[] r105 = new PolarisFileWrapper(w3.a(this.f27430c)).listFiles();
        if (r105 == null) goto L24;
        int r106 = r105.length;
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L24;
        File r108 = r105[r107];
        if (r108.isFile() == false) goto L23;
        if (r108.exists() == false) goto L23;
        if (r108.getName().contains(r100.getAdcode()) == false) goto L23;
        if (r108.getName().endsWith(".zip.tmp.dt") == false) goto L23;
        r108.delete();
    L23:
        r107 = r107 + 1;
    L24:
        r100.t().h();
    L25:
        int r109 = r100.getcompleteCode();
        if (r100.f27099v.e() == 1) goto L28;
    L31:
        r104 = true;
    L32:
        if (r104 == false) goto L36;
        n1 r111 = r100.t();
        s1 r112 = this.f27429b;
        if (r112 == null) goto L36;
        r112.b(r111);
        goto L36
    L28:
        if (r109 <= 2) goto L31;
        if (r109 < 98) goto L32;
        goto L31
    }
}
