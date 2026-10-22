package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class q extends f {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List<GeoPoint> f33356x;

    private boolean b() {
        List<GeoPoint> r100 = this.f33356x;
        monitor-enter(r100);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.f33356x.size() >= 2) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L19
        return false;
    L8:
        int r101 = this.f33356x.size();     // Catch: Throwable -> L19
        this.f33303p = new double[this.f33356x.size() * 3];     // Catch: Throwable -> L19
        this.f33302o = new double[(this.f33356x.size() * 2) + 5];     // Catch: Throwable -> L19
        if (c() == false) goto L11;
        this.f33302o[0] = this.f33305r.getLongitude();     // Catch: Throwable -> L19
        this.f33302o[1] = this.f33305r.getLatitude();     // Catch: Throwable -> L19
        this.f33302o[2] = this.f33306s.getLongitude();     // Catch: Throwable -> L19
        this.f33302o[3] = this.f33306s.getLatitude();     // Catch: Throwable -> L19
    L11:
        this.f33302o[4] = 2.0d;     // Catch: Throwable -> L19
        int r102 = 0;
    L12:
        if (r102 >= r101) goto L17;
        if (r102 != 0) goto L15;
        this.f33302o[5] = this.f33356x.get(0).getLongitude();     // Catch: Throwable -> L19
        this.f33302o[6] = this.f33356x.get(0).getLatitude();     // Catch: Throwable -> L19
    L16:
        int r103 = r102 * 3;     // Catch: Throwable -> L19
        this.f33303p[r103] = this.f33356x.get(r102).getLongitude();     // Catch: Throwable -> L19
        this.f33303p[r103 + 1] = this.f33356x.get(r102).getLatitude();     // Catch: Throwable -> L19
        this.f33303p[r103 + 2] = 0.0d;     // Catch: Throwable -> L19
        r102 = r102 + 1;     // Catch: Throwable -> L19
        goto L12
    L15:
        int r104 = (r102 * 2) + 5;     // Catch: Throwable -> L19
        int r110 = r102 - 1;     // Catch: Throwable -> L19
        this.f33302o[r104] = this.f33356x.get(r102).getLongitude() - this.f33356x.get(r110).getLongitude();     // Catch: Throwable -> L19
        this.f33302o[r104 + 1] = this.f33356x.get(r102).getLatitude() - this.f33356x.get(r110).getLatitude();     // Catch: Throwable -> L19
        goto L16
    L17:
        monitor-exit(r100);     // Catch: Throwable -> L19
        return true;
    }

    private boolean c() {
        List<GeoPoint> r100 = this.f33356x;
        monitor-enter(r100);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.f33356x.size() >= 2) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L26
        return false;
    L8:
        this.f33305r.setLatitude(this.f33356x.get(0).getLatitude());     // Catch: Throwable -> L26
        this.f33305r.setLongitude(this.f33356x.get(0).getLongitude());     // Catch: Throwable -> L26
        this.f33306s.setLatitude(this.f33356x.get(0).getLatitude());     // Catch: Throwable -> L26
        this.f33306s.setLongitude(this.f33356x.get(0).getLongitude());     // Catch: Throwable -> L26
        Iterator<GeoPoint> r101 = this.f33356x.iterator();     // Catch: Throwable -> L26
    L10:
        if (r101.hasNext() == false) goto L23;
        GeoPoint r102 = r101.next();     // Catch: Throwable -> L26
        if (this.f33305r.getLatitude() < r102.getLatitude()) goto L15;
        this.f33305r.setLatitude(r102.getLatitude());     // Catch: Throwable -> L26
    L15:
        if (this.f33305r.getLongitude() < r102.getLongitude()) goto L18;
        this.f33305r.setLongitude(r102.getLongitude());     // Catch: Throwable -> L26
    L18:
        if (this.f33306s.getLatitude() > r102.getLatitude()) goto L21;
        this.f33306s.setLatitude(r102.getLatitude());     // Catch: Throwable -> L26
    L21:
        if (this.f33306s.getLongitude() > r102.getLongitude()) goto L10;
        this.f33306s.setLongitude(r102.getLongitude());     // Catch: Throwable -> L26
        goto L10
    L23:
        monitor-exit(r100);     // Catch: Throwable -> L26
        return true;
    }

    @Override // com.baidu.platform.comapi.map.f
    public String a() {
        List<GeoPoint> r100 = this.f33356x;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f33307t == false) goto L7;
        this.f33307t = !b();     // Catch: Throwable -> L10
    L7:
        String r101 = a(this.f33309v);     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    }

    public q(z r100) {
        super(r100);
        this.f33356x = new ArrayList();
        this.f33309v = 0;
        this.f33310w = 2;
    }

    public void a(List<GeoPoint> r100) {
        if (r100 == null) goto L16;
        if (r100.size() < 2) goto L14;
        List<GeoPoint> r101 = this.f33356x;
        monitor-enter(r101);
        this.f33356x.clear();     // Catch: Throwable -> L10
        this.f33356x.addAll(r100);     // Catch: Throwable -> L10
        this.f33307t = true;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalArgumentException("points count can not be less than two!");
    L16:
        throw new IllegalArgumentException("points list can not be null!");
    }

    public void a(int[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length == 0) goto L9;
        this.f33304q = r100;
        return;
    }

    public void a(z r100) {
        this.f33288a = r100;
    }

    public void a(boolean r100) {
        this.f33294g = r100;
    }
}
