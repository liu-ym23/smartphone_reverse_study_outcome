package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmCircle;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class Circle extends Overlay {
    LineBloomDirection A;
    float B;
    float C;
    int D;
    float E;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    LatLng f30811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f30812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f30813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Stroke f30814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f30815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    List<HoleOptions> f30816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    HoleOptions f30817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f30818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f30819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f30820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f30821q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f30822r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f30823s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    BmSurfaceStyle f30824t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f30825u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f30826v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    float f30827w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    float f30828x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BmCircle f30829y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    LineBloomType f30830z;

    private void c() {
        BmCircle r100 = this.f30829y;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f31207f == null) goto L12;
        r100.c(this.f30818n);
        if (this.f30818n == false) goto L9;
        this.f30829y.d();
        ArrayList r101 = new ArrayList();
        this.f30829y.e(this.f30828x);
        this.f30829y.f(this.f30827w);
        r101.add(Integer.valueOf(this.f30825u));
        r101.add(Integer.valueOf(this.f30826v));
        this.f30829y.a(this.f30822r, r101);
    L9:
        this.f31207f.b();
        return;
    }

    private void d() {
        if (this.f30829y != null) goto L5;
        return;
    L5:
        if (this.f31207f == null) goto L22;
        List<HoleOptions> r100 = this.f30816l;
        int r101 = 0;
        if (r100 == null) goto L16;
        if (r100.size() == 0) goto L16;
        this.f30829y.c();
        List<List<com.baidu.platform.comapi.bmsdk.b>> r102 = Overlay.holeInfo2BmGeo(this.f30816l);
    L13:
        if (r101 >= r102.size()) goto L18;
        BmGeoElement r103 = new BmGeoElement();
        r103.a((List) ListProtector.get(r102, r101));
        this.f30829y.a(r103);
        r101 = r101 + 1;
    L18:
        this.f31207f.b();
        return;
    L16:
        if (this.f30817m == null) goto L18;
        this.f30829y.c();
        BmGeoElement r104 = new BmGeoElement();
        ArrayList r105 = new ArrayList();
        r105.add(this.f30817m);
        r104.a((List) ListProtector.get(Overlay.holeInfo2BmGeo(r105), 0));
        this.f30829y.a(r104);
        goto L18
    }

    private void e() {
        if (this.f30814j == null) goto L10;
        BmLineStyle r100 = new BmLineStyle();
        r100.d(this.f30814j.strokeWidthType.ordinal());
        r100.a(this.f30814j.strokeWidth);
        r100.a(this.f30814j.color);
        if (this.f30815k == false) goto L7;
        setDottedBitmapResource(r100, this.f30823s);
        r100.c(5);
    L8:
        this.f30829y.a(r100);
        return;
    L7:
        r100.b(0);
        goto L8
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmCircle r100 = new BmCircle();
        this.f30829y = r100;
        r100.a(this);
        setDrawItem(this.f30829y);
        super.toDrawItem();
        GeoPoint r101 = CoordUtil.ll2mc(this.f30811g);
        Overlay.mcLocation = r101;
        this.f30829y.a(new com.baidu.platform.comapi.bmsdk.b(r101.getLongitudeE6(), Overlay.mcLocation.getLatitudeE6()));
        this.f30829y.a(CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f30811g, this.f30813i));
        int r102 = 0;
        if (this.f30814j == null) goto L9;
        BmLineStyle r103 = new BmLineStyle();
        r103.d(this.f30814j.strokeWidthType.ordinal());
        r103.a(this.f30814j.strokeWidth);
        r103.a(this.f30814j.color);
        if (this.f30815k == false) goto L7;
        setDottedBitmapResource(r103, this.f30823s);
        r103.c(5);
    L8:
        this.f30829y.a(r103);
        this.f30829y.b(this.B);
        this.f30829y.d(this.C);
        this.f30829y.g(this.f30830z.ordinal());
        this.f30829y.c(this.E);
        this.f30829y.f(this.A.ordinal());
        goto L9
    L7:
        r103.b(0);
    L9:
        this.f30824t.a(this.f30812h);
        this.f30829y.a(this.f30824t);
        List<HoleOptions> r104 = this.f30816l;
        if (r104 == null) goto L18;
        if (r104.size() == 0) goto L18;
        List<List<com.baidu.platform.comapi.bmsdk.b>> r105 = Overlay.holeInfo2BmGeo(this.f30816l);
    L15:
        if (r102 >= r105.size()) goto L20;
        BmGeoElement r106 = new BmGeoElement();
        r106.a((List) ListProtector.get(r105, r102));
        this.f30829y.a(r106);
        r102 = r102 + 1;
    L20:
        this.f30829y.b(this.f30820p);
        this.f30829y.a(this.f30819o);
        this.f30829y.c(this.f30818n);
        if (this.f30818n == false) goto L24;
        ArrayList r107 = new ArrayList();
        this.f30829y.e(this.f30828x);
        this.f30829y.f(this.f30827w);
        r107.add(Integer.valueOf(this.f30825u));
        r107.add(Integer.valueOf(this.f30826v));
        this.f30829y.a(this.f30822r, r107);
    L24:
        return this.f30829y;
    L18:
        if (this.f30817m == null) goto L20;
        BmGeoElement r108 = new BmGeoElement();
        ArrayList r109 = new ArrayList();
        r109.add(this.f30817m);
        r108.a((List) ListProtector.get(Overlay.holeInfo2BmGeo(r109), 0));
        this.f30829y.a(r108);
        goto L20
    }

    public Circle() {
        this.f30819o = false;
        this.f30820p = false;
        this.f30821q = -1;
        this.f30822r = 1;
        this.f30823s = PolylineDottedLineType.DOTTED_LINE_SQUARE.ordinal();
        this.f30824t = new BmSurfaceStyle();
        this.f30827w = 0.5f;
        this.f30828x = 0.2f;
        this.f30830z = LineBloomType.NONE;
        this.A = LineBloomDirection.BloomAround;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32148h;
    }

    public LatLng getCenter() {
        return this.f30811g;
    }

    public int getCenterColor() {
        return this.f30825u;
    }

    public float getColorWeight() {
        return this.f30828x;
    }

    public int getDottedStrokeType() {
        return this.f30823s;
    }

    public int getFillColor() {
        return this.f30812h;
    }

    public int getHoleClickedIndex() {
        return this.f30821q;
    }

    public HoleOptions getHoleOption() {
        return this.f30817m;
    }

    public List<HoleOptions> getHoleOptions() {
        return this.f30816l;
    }

    public int getRadius() {
        return this.f30813i;
    }

    public float getRadiusWeight() {
        return this.f30827w;
    }

    public int getSideColor() {
        return this.f30826v;
    }

    public Stroke getStroke() {
        return this.f30814j;
    }

    public boolean isClickable() {
        return this.f30819o;
    }

    public boolean isDottedStroke() {
        return this.f30815k;
    }

    public boolean isIsGradientCircle() {
        return this.f30818n;
    }

    private void b(Bundle r100) {
        int r101 = this.f30823s;
        if (r101 != 1) goto L6;
        String r102 = "CircleDashTexture.png";
    L9:
        BitmapDescriptor r103 = BitmapDescriptorFactory.fromAsset(r102);
        if (r103 == null) goto L13;
        r100.putBundle("image_info", r103.a());
        return;
    L13:
        return;
    L6:
        if (r101 != 2) goto L8;
        r102 = "lineDash_Rectangle.png";
        goto L9
    L8:
        r102 = "lineDashTexture.png";
        goto L9
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        GeoPoint r101 = CoordUtil.ll2mc(this.f30811g);
        r100.putDouble("location_x", r101.getLongitudeE6());
        r100.putDouble("location_y", r101.getLatitudeE6());
        if (this.f30818n == false) goto L5;
        r100.putInt("m_isGradientCircle", 1);
        Overlay.b(this.f30825u, r100);
        Overlay.c(this.f30826v, r100);
        r100.putFloat("m_color_weight", this.f30828x);
        r100.putFloat("m_radius_weight", this.f30827w);
    L7:
        if (this.f30815k == false) goto L9;
        r100.putDouble("dotted_stroke_location_x", r101.getLongitudeE6());
        r100.putDouble("dotted_stroke_location_y", r101.getLatitudeE6());
        r100.putInt("has_dotted_stroke", 1);
        b(r100);
    L10:
        r100.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f30811g, this.f30813i));
        Overlay.d(this.f30812h, r100);
        if (this.f30814j != null) goto L13;
        r100.putInt("has_stroke", 0);
    L14:
        List<HoleOptions> r102 = this.f30816l;
        if (r102 == null) goto L20;
        if (r102.size() == 0) goto L20;
        e(this.f30816l, r100);
        r100.putInt("holes_count", this.f30816l.size());
    L23:
        r100.putInt("isClickable", this.f30819o ? 1 : 0);
        r100.putInt("isHoleClickable", this.f30820p ? 1 : 0);
        return r100;
    L20:
        if (this.f30817m == null) goto L22;
        ArrayList r103 = new ArrayList();
        r103.add(this.f30817m);
        e(r103, r100);
        r100.putInt("holes_count", 1);
        goto L23
    L22:
        r100.putInt("has_holes", 0);
        goto L23
    L13:
        r100.putInt("has_stroke", 1);
        Bundle r104 = new Bundle();
        r100.putBundle("stroke", this.f30814j.a(r104));
        goto L14
    L9:
        r100.putInt("has_dotted_stroke", 0);
        goto L10
    L5:
        r100.putInt("m_isGradientCircle", 0);
        goto L7
    }

    public void setBloomAlpha(float r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.B = r100;
        this.f30829y.b(r100);
        this.f31207f.b();
        return;
    }

    public void setBloomBlurTimes(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.D = r100;
        this.f30829y.e(r100);
        this.f31207f.b();
        return;
    }

    public void setBloomGradientASpeed(float r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.E = r100;
        this.f30829y.c(r100);
        this.f31207f.b();
        return;
    }

    public void setBloomWidth(float r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.C = r100;
        this.f30829y.d(r100);
        this.f31207f.b();
        return;
    }

    public void setCenter(LatLng r100) {
        if (r100 == null) goto L13;
        this.f30811g = r100;
        Overlay.mcLocation = CoordUtil.ll2mc(r100);
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmCircle r101 = this.f30829y;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L15;
        r101.a(new com.baidu.platform.comapi.bmsdk.b(Overlay.mcLocation.getLongitudeE6(), Overlay.mcLocation.getLatitudeE6()));
        this.f31207f.b();
        return;
    L15:
        return;
    L10:
        this.listener.c(this);
        return;
    L13:
        throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
    }

    public void setCenterColor(int r100) {
        this.f30825u = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        c();
        return;
    L5:
        this.listener.c(this);
    }

    public void setClickable(boolean r100) {
        this.f30819o = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmCircle r101 = this.f30829y;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.a(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setColorWeight(float r100) {
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        if (r100 >= 1.0f) goto L14;
        this.f30828x = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        c();
        return;
    L10:
        this.listener.c(this);
        return;
    }

    public void setDottedStroke(boolean r100) {
        this.f30815k = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f30829y != null) goto L7;
        return;
    L7:
        if (this.f31207f != null) goto L9;
        return;
    L9:
        if (this.f30824t == null) goto L15;
        e();
        this.f31207f.b();
        return;
    }

    public void setDottedStrokeType(CircleDottedStrokeType r100) {
        this.f30823s = r100.ordinal();
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f30829y != null) goto L7;
        return;
    L7:
        if (this.f31207f != null) goto L9;
        return;
    L9:
        if (this.f30824t == null) goto L15;
        e();
        this.f31207f.b();
        return;
    }

    public void setFillColor(int r100) {
        this.f30812h = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f30829y != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L14;
        BmSurfaceStyle r101 = this.f30824t;
        if (r101 == null) goto L15;
        r101.a(this.f30812h);
        this.f30829y.a(this.f30824t);
        this.f31207f.b();
        return;
    L15:
        return;
    }

    public void setHoleClickable(boolean r100) {
        this.f30820p = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmCircle r101 = this.f30829y;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.b(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setHoleOption(HoleOptions r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f30817m = r100;
        this.f30816l = null;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L7;
        d();
        return;
    L7:
        this.listener.c(this);
    }

    public void setHoleOptions(List<HoleOptions> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() == 0) goto L13;
        this.f30816l = r100;
        this.f30817m = null;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        d();
        return;
    L9:
        this.listener.c(this);
        return;
    }

    public void setIsGradientCircle(boolean r100) {
        this.f30818n = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        c();
        return;
    L5:
        this.listener.c(this);
    }

    public void setLineBloomDirection(LineBloomDirection r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.A = r100;
        this.f30829y.f(r100.ordinal());
        this.f31207f.b();
        return;
    }

    public void setLineBloomType(LineBloomType r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f30830z = r100;
        this.f30829y.g(r100.ordinal());
        this.f31207f.b();
        return;
    }

    public void setRadius(int r100) {
        this.f30813i = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f30829y != null) goto L7;
        return;
    L7:
        if (this.f31207f != null) goto L9;
        return;
    L9:
        if (this.f30824t == null) goto L15;
        this.f30829y.a(CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f30811g, this.f30813i));
        this.f31207f.b();
        return;
    }

    public void setRadiusWeight(float r100) {
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        if (r100 >= 1.0f) goto L14;
        this.f30827w = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        c();
        return;
    L10:
        this.listener.c(this);
        return;
    }

    public void setSideColor(int r100) {
        this.f30826v = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        c();
        return;
    L5:
        this.listener.c(this);
    }

    public void setStroke(Stroke r100) {
        this.f30814j = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f30829y != null) goto L7;
        return;
    L7:
        if (this.f31207f != null) goto L9;
        return;
    L9:
        if (this.f30824t == null) goto L15;
        e();
        this.f31207f.b();
        return;
    }

    private void e(List<HoleOptions> r100, Bundle r101) {
        Bundle r102 = new Bundle();
        boolean r103 = Overlay.b(r100, r102);
        r101.putInt("has_holes", r103 ? 1 : 0);
        if (r103 == false) goto L6;
        r101.putBundle("holes", r102);
        return;
    }
}
