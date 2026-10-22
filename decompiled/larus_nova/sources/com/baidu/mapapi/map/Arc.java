package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmArc;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public final class Arc extends Overlay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f30578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    WidthType f30579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f30580i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    LatLng f30581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    LatLng f30582k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    LatLng f30583l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f30584m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    double f30585n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    double f30586o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    double f30587p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f30588q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    com.baidu.platform.comapi.bmsdk.b f30589r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    LatLng f30590s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private BmArc f30591t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    BmLineStyle f30592u;

    private void c() {
        LatLng r100 = this.f30581j;
        if (r100 == null) goto L5;
    L9:
        GeoPoint r110 = CoordUtil.ll2mc(r100);
        GeoPoint r111 = CoordUtil.ll2mc(this.f30582k);
        GeoPoint r112 = CoordUtil.ll2mc(this.f30583l);
        GeoPoint r101 = a(r110.getLongitudeE6(), r110.getLatitudeE6(), r111.getLongitudeE6(), r111.getLatitudeE6(), r112.getLongitudeE6(), r112.getLatitudeE6());
        this.f30589r = new com.baidu.platform.comapi.bmsdk.b(r101.getLongitudeE6(), r101.getLatitudeE6());
        this.f30585n = b(r110, r101);
        a(a(r110, r101), a(r111, r101), a(r112, r101));
        return;
    L5:
        if (this.f30582k != null) goto L9;
        if (this.f30583l != null) goto L9;
    }

    public int getWidth() {
        return (int) this.f30580i;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmArc r100 = new BmArc();
        this.f30591t = r100;
        r100.a(this);
        setDrawItem(this.f30591t);
        super.toDrawItem();
        BmLineStyle r101 = new BmLineStyle();
        this.f30592u = r101;
        r101.d(this.f30579h.ordinal());
        this.f30592u.a(this.f30580i);
        this.f30592u.a(this.f30578g);
        this.f30591t.a(this.f30592u);
        if (this.f30581j != null) goto L5;
    L9:
        GeoPoint r102 = CoordUtil.ll2mc(this.f30590s);
        if (r102 == null) goto L12;
        this.f30589r = new com.baidu.platform.comapi.bmsdk.b(r102.getLongitudeE6(), r102.getLatitudeE6());
    L12:
        this.f30591t.a(this.f30589r);
        this.f30591t.c(this.f30588q);
        this.f30591t.a(this.f30587p);
        this.f30591t.c(this.f30586o);
        this.f30591t.b(this.f30585n);
        this.f30591t.a(this.f30584m);
        return this.f30591t;
    L5:
        if (this.f30582k == null) goto L9;
        if (this.f30583l == null) goto L9;
        c();
        goto L12
    }

    public Arc() {
        this.f30579h = WidthType.AdaptWidth;
        this.f30584m = true;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32146f;
    }

    public BmArc getBmArc() {
        return this.f30591t;
    }

    public int getColor() {
        return this.f30578g;
    }

    public LatLng getEndPoint() {
        return this.f30583l;
    }

    public LatLng getMiddlePoint() {
        return this.f30582k;
    }

    public LatLng getStartPoint() {
        return this.f30581j;
    }

    public float getWidthFloat() {
        return this.f30580i;
    }

    public WidthType getWidthType() {
        return this.f30579h;
    }

    public boolean isClickable() {
        return this.f30584m;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        ArrayList r101 = new ArrayList();
        r101.clear();
        r101.add(this.f30581j);
        r101.add(this.f30582k);
        r101.add(this.f30583l);
        GeoPoint r102 = CoordUtil.ll2mc((LatLng) ListProtector.get(r101, 0));
        r100.putDouble("location_x", r102.getLongitudeE6());
        r100.putDouble("location_y", r102.getLatitudeE6());
        r100.putInt("width", (int) this.f30580i);
        Overlay.c(r101, r100);
        Overlay.d(this.f30578g, r100);
        r100.putInt("isClickable", this.f30584m ? 1 : 0);
        return r100;
    }

    public void setClickable(boolean r100) {
        this.f30584m = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L11;
        BmArc r101 = this.f30591t;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f != null) goto L9;
        return;
    L9:
        if (this.f30592u == null) goto L15;
        r101.a(r100);
        this.f31207f.b();
        return;
    L15:
        return;
    L11:
        this.listener.c(this);
    }

    public void setColor(int r100) {
        this.f30578g = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f30591t != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L14;
        BmLineStyle r101 = this.f30592u;
        if (r101 == null) goto L15;
        r101.a(this.f30578g);
        this.f30591t.a(this.f30592u);
        this.f31207f.b();
        return;
    L15:
        return;
    }

    public void setWidth(float r100) {
        if (r100 <= 0.0f) goto L15;
        this.f30580i = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L7;
        this.listener.c(this);
        return;
    L7:
        if (this.f30591t != null) goto L9;
        return;
    L9:
        if (this.f31207f == null) goto L17;
        BmLineStyle r101 = this.f30592u;
        if (r101 == null) goto L18;
        r101.a(r100);
        this.f31207f.b();
        return;
    L18:
        return;
    L17:
        return;
    }

    public void setWidthType(WidthType r100) {
        if (this.f30579h != r100) goto L5;
        return;
    L5:
        this.f30579h = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L11;
        BmLineStyle r101 = this.f30592u;
        if (r101 == null) goto L12;
        r101.d(this.f30579h.ordinal());
        this.f30592u.a(this.f30580i);
        this.f31207f.b();
        return;
    L12:
        return;
    }

    private double a(GeoPoint r100, GeoPoint r101) {
        double r102 = r100.getLatitudeE6() - r101.getLatitudeE6();
        double r103 = r100.getLongitudeE6() - r101.getLongitudeE6();
        if (r103 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r103 = 1.0E-5d;
    L6:
        if (r102 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        r102 = 1.0E-5d;
    L8:
        double r104 = Math.atan(r102 / r103);
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        return r104 * 1.0d;
    L14:
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
    L18:
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L20;
    L22:
        double r105 = 6.283185307179586d;
    L24:
        return r104 + r105;
    L20:
        if (r102 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L22;
    L21:
        r105 = 3.141592653589793d;
        goto L24
    L16:
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L18;
        goto L18
    }

    private double b(GeoPoint r100, GeoPoint r101) {
        double r102 = r100.getLongitudeE6();
        double r103 = r100.getLatitudeE6();
        double r104 = r101.getLongitudeE6();
        double r105 = r102 - r104;
        double r106 = r103 - r101.getLatitudeE6();
        return Math.sqrt((r105 * r105) + (r106 * r106));
    }

    private void a(double r100, double r101, double r102) {
        if (r100 >= r101) goto L21;
        if (r100 >= r102) goto L13;
        if (r101 >= r102) goto L10;
        this.f30586o = r100;
        this.f30587p = r102;
        this.f30588q = false;
        return;
    L10:
        if (r101 <= r102) goto L37;
        this.f30586o = r102;
        this.f30587p = r100 + 6.283185307179586d;
        this.f30588q = false;
        return;
    L37:
        return;
    L13:
        if (r100 > r102) goto L15;
        return;
    L15:
        if (r101 >= r102) goto L18;
        return;
    L18:
        if (r101 <= r102) goto L40;
        this.f30586o = r100;
        this.f30587p = r102 + 6.283185307179586d;
        this.f30588q = false;
        return;
    L40:
        return;
    L21:
        if (r100 > r101) goto L23;
        return;
    L23:
        if (r100 >= r102) goto L28;
        if (r101 >= r102) goto L43;
        this.f30586o = r102;
        this.f30587p = r100 + 6.283185307179586d;
        this.f30588q = false;
        return;
    L43:
        return;
    L28:
        if (r100 > r102) goto L30;
        return;
    L30:
        if (r101 >= r102) goto L33;
        this.f30586o = r100;
        this.f30587p = r102 + 6.283185307179586d;
        this.f30588q = false;
        return;
    L33:
        if (r101 <= r102) goto L47;
        this.f30586o = r102;
        this.f30587p = r100;
        this.f30588q = false;
        return;
    }

    public void setPoints(LatLng r100, LatLng r101, LatLng r102) {
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        if (r102 == null) goto L22;
        if (r100 == r101) goto L20;
        if (r100 == r102) goto L20;
        if (r101 == r102) goto L20;
        this.f30581j = r100;
        this.f30582k = r101;
        this.f30583l = r102;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L11;
        this.listener.c(this);
        return;
    L11:
        if (this.f30591t != null) goto L13;
        return;
    L13:
        if (this.f31207f == null) goto L24;
        BmLineStyle r103 = this.f30592u;
        if (r103 == null) goto L25;
        r103.a(this.f30578g);
        c();
        this.f30591t.a(this.f30589r);
        this.f30591t.c(this.f30588q);
        this.f30591t.a(this.f30587p);
        this.f30591t.c(this.f30586o);
        this.f30591t.b(this.f30585n);
        this.f31207f.b();
        return;
    L25:
        return;
    L24:
        return;
    L20:
        throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
    L22:
        throw new IllegalArgumentException("BDMapSDKException:start and middle and end points can not be null");
    }

    private GeoPoint a(double r110, double r210, double r211, double r212, double r213, double r214) {
        double r100 = (r110 + r211) / 2.0d;
        double r101 = (r210 + r212) / 2.0d;
        double r102 = (r211 + r213) / 2.0d;
        double r103 = (r212 + r214) / 2.0d;
        double r104 = r212 - r210;
        if (r104 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        double r105 = r214 - r212;
        if (r105 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        return null;
    L7:
        double r106 = ((((r213 - r211) * (-1.0d)) / r105) * (r100 - r102)) + r103;
    L16:
        return new GeoPoint(r106, r100);
    L8:
        double r111 = ((r211 - r110) * (-1.0d)) / r104;
        double r107 = r214 - r212;
        if (r107 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        r106 = r101 + (r111 * (r102 - r100));
        r100 = r102;
        goto L16
    L11:
        double r112 = ((r213 - r211) * (-1.0d)) / r107;
        if (r111 != r112) goto L14;
        return null;
    L14:
        double r108 = (((r103 - r101) + (r111 * r100)) - (r102 * r112)) / (r111 - r112);
        r106 = r101 + (r111 * (r108 - r100));
        r100 = r108;
        goto L16
    }
}
