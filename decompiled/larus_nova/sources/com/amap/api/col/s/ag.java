package com.amap.api.col.s;

import androidx.camera.video.AudioStats;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class ag {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static volatile ag f26024r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f26025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f26026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f26027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f26028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f26029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f26030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f26031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f26032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f26033i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f26034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f26035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f26036l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f26037m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f26038n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f26039o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f26040p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f26041q;

    public static ag a() {
        if (f26024r != null) goto L15;
        monitor-enter(ag.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f26024r != null) goto L9;
        f26024r = new ag();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ag.class);     // Catch: Throwable -> L11
    L15:
        return f26024r;
    }

    public ag() {
        this.f26025a = true;
        this.f26026b = true;
        this.f26027c = true;
        this.f26028d = true;
        this.f26029e = true;
        this.f26030f = true;
        this.f26031g = true;
        this.f26032h = 25;
        this.f26033i = 100;
        this.f26034j = 100;
        this.f26035k = 100;
        this.f26036l = 6;
        this.f26037m = 100;
        this.f26038n = 5000;
        this.f26039o = 1200;
        this.f26040p = 100000000;
        this.f26041q = 16;
    }

    public final void a(RouteSearch.FromAndTo r100) throws AMapException {
        if (this.f26029e == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getFrom() != null) goto L9;
        return;
    L9:
        if (r100.getTo() != null) goto L12;
        return;
    L12:
        if (this.f26039o < (((double) i.a(r100.getFrom(), r100.getTo())) / 1000.0d)) goto L15;
        return;
    L15:
        throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
    }

    public final void b(List<List<LatLonPoint>> r210) throws AMapException {
        if (this.f26025a == true) goto L5;
        return;
    L5:
        if (r210 != null) goto L8;
        return;
    L8:
        if (this.f26034j < r210.size()) goto L32;
        Iterator<List<LatLonPoint>> r100 = r210.iterator();
    L11:
        if (r100.hasNext() == false) goto L30;
        List<LatLonPoint> r101 = r100.next();
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r101 == null) goto L22;
        if (r101.size() < 3) goto L22;
        int r103 = r101.size();
        int r104 = 0;
    L18:
        if (r104 >= r103) goto L20;
        LatLonPoint r105 = (LatLonPoint) ListProtector.get(r101, r104);
        r104 = r104 + 1;
        LatLonPoint r106 = (LatLonPoint) ListProtector.get(r101, r104 % r103);
        double r107 = (r105.getLongitude() * 111319.49079327357d) * Math.cos(r105.getLatitude() * 0.017453292519943295d);
        double r110 = r105.getLatitude() * 111319.49079327357d;
        r102 = r102 + ((r107 * (r106.getLatitude() * 111319.49079327357d)) - (((r106.getLongitude() * 111319.49079327357d) * Math.cos(r106.getLatitude() * 0.017453292519943295d)) * r110));
        goto L18
    L20:
        r102 = Math.abs(r102 / 2.0d);
    L22:
        if (this.f26041q < r101.size()) goto L29;
        if (this.f26040p >= r102) goto L11;
        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION);
    L29:
        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION);
    L30:
        return;
    L32:
        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION);
    }

    public final void a(String r100) throws AMapException {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f26026b == true) goto L8;
        return;
    L8:
        if (r100.length() > this.f26033i) goto L11;
        return;
    L11:
        throw new AMapException(AMapException.AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION);
    }

    public final void b(RouteSearch.FromAndTo r100) throws AMapException {
        if (this.f26030f == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getFrom() != null) goto L9;
        return;
    L9:
        if (r100.getTo() != null) goto L12;
        return;
    L12:
        if (this.f26035k < (((double) i.a(r100.getFrom(), r100.getTo())) / 1000.0d)) goto L15;
        return;
    L15:
        throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
    }

    public final void a(List<LatLonPoint> r100) throws AMapException {
        if (this.f26031g == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        int r101 = r100.size();
        if (this.f26036l < r101) goto L11;
        return;
    L11:
        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
    }

    public final int b(int r100) {
        if (this.f26028d == true) goto L5;
        return r100;
    L5:
        int r101 = this.f26032h;
        if (r101 >= r100) goto L8;
        return r101;
    L8:
        return r100;
    }

    public final int a(int r100) {
        if (this.f26028d == true) goto L5;
        return r100;
    L5:
        int r101 = this.f26037m;
        if (r101 >= r100) goto L8;
        return r101;
    L8:
        return r100;
    }

    public final void a(RouteSearch.FromAndTo r100, List<LatLonPoint> r101) throws AMapException {
        if (this.f26027c == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getFrom() != null) goto L9;
        return;
    L9:
        if (r100.getTo() == null) goto L28;
        if (r101 != null) goto L13;
    L19:
        double r102 = i.a(r100.getFrom(), r100.getTo());
    L21:
        if (this.f26038n < (r102 / 1000.0d)) goto L24;
        return;
    L24:
        throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
    L13:
        if (r101.size() == 0) goto L19;
        LatLonPoint r103 = r100.getFrom();
        LatLonPoint r104 = r100.getTo();
        Iterator<LatLonPoint> r105 = r101.iterator();
        double r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L16:
        if (r105.hasNext() == false) goto L18;
        LatLonPoint r107 = r105.next();
        r106 = r106 + ((double) i.a(r103, r107));
        r103 = r107;
        goto L16
    L18:
        r102 = r106 + ((double) i.a(r103, r104));
        goto L21
    }
}
