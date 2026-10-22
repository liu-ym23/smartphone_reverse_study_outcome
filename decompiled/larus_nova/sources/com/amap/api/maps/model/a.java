package com.amap.api.maps.model;

import com.amap.api.mapcore.util.g3;
import com.autonavi.amap.mapcore.DPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g3 f28666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<WeightedLatLng> f28668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<a> f28669d;

    public a(g3 r100) {
        this(r100, 0);
    }

    public void a(WeightedLatLng r100) {
        DPoint r101 = r100.getPoint();
        if (this.f28666a.a(r101.f30021x, r101.f30022y) == false) goto L6;
        a(r101.f30021x, r101.f30022y, r100);
        return;
    }

    public Collection<WeightedLatLng> a(g3 r100) {
        ArrayList r101 = new ArrayList();
        a(r100, r101);
        return r101;
    }

    private a(g3 r100, int r101) {
        this.f28669d = null;
        this.f28666a = r100;
        this.f28667b = r101;
    }

    private void a(g3 r100, Collection<WeightedLatLng> r101) {
        if (this.f28666a.a(r100) == true) goto L5;
        return;
    L5:
        List<a> r102 = this.f28669d;
        if (r102 == null) goto L11;
        Iterator<a> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L39;
        r103.next().a(r100, r101);
        goto L9
    L39:
        return;
    L11:
        List<WeightedLatLng> r104 = this.f28668c;
        if (r104 == null) goto L31;
        g3 r105 = this.f28666a;
        if (r105.f27297a >= r100.f27297a) goto L16;
    L22:
        boolean r106 = false;
    L23:
        if (r106 == false) goto L25;
        r101.addAll(r104);
        return;
    L25:
        Iterator<WeightedLatLng> r107 = r104.iterator();
    L27:
        if (r107.hasNext() == false) goto L40;
        WeightedLatLng r108 = r107.next();
        DPoint r109 = r108.getPoint();
        if (r100.a(r109.f30021x, r109.f30022y) == false) goto L27;
        r101.add(r108);
        goto L27
    L40:
        return;
    L16:
        if (r105.f27299c > r100.f27299c) goto L22;
        if (r105.f27298b < r100.f27298b) goto L22;
        if (r105.f27300d > r100.f27300d) goto L22;
        r106 = true;
        goto L23
    }

    private void a(double r110, double r210, WeightedLatLng r211) {
        List<a> r100 = this.f28669d;
        if (r100 == null) goto L16;
        g3 r101 = this.f28666a;
        if (r210 >= r101.f27302f) goto L11;
        if (r110 >= r101.f27301e) goto L9;
        ((a) ListProtector.get(r100, 0)).a(r110, r210, r211);
        return;
    L9:
        ((a) ListProtector.get(r100, 1)).a(r110, r210, r211);
        return;
    L11:
        if (r110 >= r101.f27301e) goto L13;
        ((a) ListProtector.get(r100, 2)).a(r110, r210, r211);
        return;
    L13:
        ((a) ListProtector.get(r100, 3)).a(r110, r210, r211);
        return;
    L16:
        if (this.f28668c != null) goto L18;
        this.f28668c = new ArrayList();
    L18:
        this.f28668c.add(r211);
        if (this.f28668c.size() > 50) goto L21;
        return;
    L21:
        if (this.f28667b >= 40) goto L39;
        ArrayList r102 = new ArrayList(4);
        this.f28669d = r102;
        g3 r103 = this.f28666a;
        r102.add(new a(r103.f27297a, r103.f27301e, r103.f27298b, r103.f27302f, this.f28667b + 1));
        List<a> r104 = this.f28669d;
        g3 r105 = this.f28666a;
        r104.add(new a(r105.f27301e, r105.f27299c, r105.f27298b, r105.f27302f, this.f28667b + 1));
        List<a> r106 = this.f28669d;
        g3 r107 = this.f28666a;
        r106.add(new a(r107.f27297a, r107.f27301e, r107.f27302f, r107.f27300d, this.f28667b + 1));
        List<a> r108 = this.f28669d;
        g3 r109 = this.f28666a;
        r108.add(new a(r109.f27301e, r109.f27299c, r109.f27302f, r109.f27300d, this.f28667b + 1));
        List<WeightedLatLng> r111 = this.f28668c;
        this.f28668c = null;
        Iterator<WeightedLatLng> r112 = r111.iterator();
    L24:
        if (r112.hasNext() == false) goto L40;
        WeightedLatLng r113 = r112.next();
        a(r113.getPoint().f30021x, r113.getPoint().f30022y, r113);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    L40:
        return;
    }

    private a(double r110, double r111, double r112, double r113, int r114) {
        this(new g3(r110, r111, r112, r113), r114);
    }
}
