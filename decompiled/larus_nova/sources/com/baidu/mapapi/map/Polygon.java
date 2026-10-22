package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmPolygon;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import com.baidu.platform.comapi.util.g;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class Polygon extends Overlay {
    BmPolygon A;
    LineBloomType B;
    LineBloomDirection C;
    float D;
    float E;
    int F;
    float G;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Stroke f31214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f31215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    BmGeoElement f31216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f31217j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    BmSurfaceStyle f31218k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    BmLineStyle f31219l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f31220m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    BmGeoElement f31221n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    List<BmGeoElement> f31222o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f31223p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    List<LatLng> f31224q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    List<HoleOptions> f31225r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    HoleOptions f31226s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f31227t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f31228u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f31229v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f31230w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f31231x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    ThinAndSmoothAlgorithm f31232y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    float f31233z;

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem b() {
        if (this.f31216i == null) goto L51;
        if (this.A == null) goto L51;
        super.b();
        this.A.c();
        Stroke r100 = this.f31214g;
        int r101 = 0;
        if (r100 == null) goto L16;
        BmLineStyle r102 = this.f31219l;
        if (r102 == null) goto L16;
        r102.d(r100.strokeWidthType.ordinal());
        this.f31219l.a(this.f31214g.strokeWidth);
        this.f31219l.a(this.f31214g.color);
        if (this.f31227t == false) goto L14;
        setDottedBitmapResource(this.f31219l, this.f31220m);
        this.f31219l.c(5);
    L15:
        this.f31216i.a(this.f31219l);
        goto L16
    L14:
        this.f31219l.b(0);
    L16:
        ArrayList r103 = new ArrayList();
        String r104 = this.f31217j;
        if (r104 != null) goto L19;
    L27:
        List<LatLng> r105 = this.f31224q;
        if (r105 == null) goto L34;
        Overlay.mcLocation = CoordUtil.ll2mc((LatLng) ListProtector.get(r105, 0));
        Iterator<LatLng> r106 = this.f31224q.iterator();
    L31:
        if (r106.hasNext() == false) goto L33;
        GeoPoint r107 = CoordUtil.ll2mc(r106.next());
        r103.add(new com.baidu.platform.comapi.bmsdk.b(r107.getLongitudeE6(), r107.getLatitudeE6()));
        goto L31
    L33:
        this.f31216i.a(r103);
    L34:
        this.A.a(this.f31216i);
        List<HoleOptions> r108 = this.f31225r;
        if (r108 == null) goto L43;
        if (r108.size() == 0) goto L43;
        List<List<com.baidu.platform.comapi.bmsdk.b>> r109 = Overlay.holeInfo2BmGeo(this.f31225r);
    L40:
        if (r101 >= r109.size()) goto L45;
        BmGeoElement r110 = new BmGeoElement();
        r110.a((List) ListProtector.get(r109, r101));
        this.f31222o.add(r110);
        this.A.b(r110);
        r101 = r101 + 1;
    L45:
        BmSurfaceStyle r111 = this.f31218k;
        if (r111 == null) goto L48;
        r111.a(this.f31223p);
        this.A.a(this.f31218k);
    L48:
        this.A.f(4096);
        this.A.a(this.f31228u);
        this.A.b(this.f31229v);
        this.f31207f.b();
        return this.A;
    L43:
        if (this.f31226s == null) goto L45;
        ArrayList r112 = new ArrayList();
        r112.add(this.f31226s);
        List<com.baidu.platform.comapi.bmsdk.b> r113 = (List) ListProtector.get(Overlay.holeInfo2BmGeo(r112), 0);
        BmGeoElement r114 = new BmGeoElement();
        this.f31221n = r114;
        r114.a(r113);
        this.A.b(this.f31221n);
        goto L45
    L19:
        if (r104.isEmpty() == true) goto L27;
        if (this.f31203b == null) goto L27;
        Iterator<LatLng> r115 = g.a().a(this.f31217j, this.f31203b.ordinal()).iterator();
    L24:
        if (r115.hasNext() == false) goto L26;
        GeoPoint r116 = CoordUtil.ll2mc(r115.next());
        r103.add(new com.baidu.platform.comapi.bmsdk.b(r116.getLongitudeE6(), r116.getLatitudeE6()));
        goto L24
    L26:
        this.f31216i.a(r103);
    L51:
        return this.A;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmPolygon r100 = new BmPolygon();
        this.A = r100;
        r100.a(this);
        setDrawItem(this.A);
        super.toDrawItem();
        this.f31216i = new BmGeoElement();
        BmLineStyle r101 = new BmLineStyle();
        this.f31219l = r101;
        Stroke r102 = this.f31214g;
        int r103 = 0;
        if (r102 == null) goto L9;
        r101.d(r102.strokeWidthType.ordinal());
        this.f31219l.a(this.f31214g.strokeWidth);
        this.f31219l.a(this.f31214g.color);
        if (this.f31227t == false) goto L7;
        setDottedBitmapResource(this.f31219l, this.f31220m);
        this.f31219l.c(5);
    L8:
        this.A.h(this.B.ordinal());
        this.A.g(this.C.ordinal());
        this.A.b(this.D);
        this.A.d(this.E);
        this.A.c(this.G);
        this.A.e(this.F);
        goto L9
    L7:
        this.f31219l.b(0);
    L9:
        this.f31216i.a(this.f31219l);
        ArrayList r104 = new ArrayList();
        String r105 = this.f31217j;
        if (r105 != null) goto L12;
    L19:
        List<LatLng> r106 = this.f31224q;
        if (r106 == null) goto L25;
        Overlay.mcLocation = CoordUtil.ll2mc((LatLng) ListProtector.get(r106, 0));
        Iterator<LatLng> r107 = this.f31224q.iterator();
    L23:
        if (r107.hasNext() == false) goto L25;
        GeoPoint r108 = CoordUtil.ll2mc(r107.next());
        r104.add(new com.baidu.platform.comapi.bmsdk.b(r108.getLongitudeE6(), r108.getLatitudeE6()));
    L25:
        this.f31216i.a(r104);
        this.A.a(this.f31216i);
        List<HoleOptions> r109 = this.f31225r;
        if (r109 == null) goto L34;
        if (r109.size() == 0) goto L34;
        List<List<com.baidu.platform.comapi.bmsdk.b>> r110 = Overlay.holeInfo2BmGeo(this.f31225r);
    L31:
        if (r103 >= r110.size()) goto L36;
        BmGeoElement r111 = new BmGeoElement();
        r111.a((List) ListProtector.get(r110, r103));
        this.f31222o.add(r111);
        this.A.b(r111);
        r103 = r103 + 1;
    L36:
        BmSurfaceStyle r112 = new BmSurfaceStyle();
        this.f31218k = r112;
        r112.a(this.f31223p);
        this.A.a(this.f31218k);
        this.A.f(4096);
        this.A.a(this.f31228u);
        this.A.b(this.f31229v);
        if (this.f31231x == false) goto L42;
        this.A.i(this.f31232y.getValue());
        float r113 = this.f31233z;
        if (r113 <= 0.0f) goto L42;
        this.A.e(r113);
    L42:
        return this.A;
    L34:
        if (this.f31226s == null) goto L36;
        ArrayList r114 = new ArrayList();
        r114.add(this.f31226s);
        List<com.baidu.platform.comapi.bmsdk.b> r115 = (List) ListProtector.get(Overlay.holeInfo2BmGeo(r114), 0);
        BmGeoElement r116 = new BmGeoElement();
        this.f31221n = r116;
        r116.a(r115);
        this.A.b(this.f31221n);
        goto L36
    L12:
        if (r105.isEmpty() == true) goto L19;
        if (this.f31203b == null) goto L19;
        Iterator<LatLng> r117 = g.a().a(this.f31217j, this.f31203b.ordinal()).iterator();
    L17:
        if (r117.hasNext() == false) goto L25;
        GeoPoint r118 = CoordUtil.ll2mc(r117.next());
        r104.add(new com.baidu.platform.comapi.bmsdk.b(r118.getLongitudeE6(), r118.getLatitudeE6()));
        goto L17
    }

    public Polygon() {
        this.f31215h = false;
        this.f31220m = PolylineDottedLineType.DOTTED_LINE_SQUARE.ordinal();
        this.f31222o = new ArrayList();
        this.f31228u = false;
        this.f31229v = false;
        this.f31230w = -1;
        this.B = LineBloomType.NONE;
        this.C = LineBloomDirection.BloomAround;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32150j;
    }

    public String getEncodedPoint() {
        return this.f31217j;
    }

    public int getFillColor() {
        return this.f31223p;
    }

    public int getHoleClickedIndex() {
        return this.f31230w;
    }

    public HoleOptions getHoleOption() {
        return this.f31226s;
    }

    public List<HoleOptions> getHoleOptions() {
        return this.f31225r;
    }

    public EncodePointType getPointType() {
        return this.f31203b;
    }

    public List<LatLng> getPoints() {
        return this.f31224q;
    }

    public Stroke getStroke() {
        return this.f31214g;
    }

    public boolean isClickable() {
        return this.f31228u;
    }

    public boolean isThined() {
        return this.f31231x;
    }

    private void b(Bundle r100) {
        int r101 = this.f31220m;
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
        if (this.f31227t == false) goto L5;
        r100.putInt("has_dotted_stroke", 1);
        b(r100);
    L6:
        String r101 = this.f31217j;
        if (r101 != null) goto L9;
    L13:
        List<LatLng> r102 = this.f31224q;
        if (r102 == null) goto L18;
        GeoPoint r103 = CoordUtil.ll2mc((LatLng) ListProtector.get(r102, 0));
        r100.putDouble("location_x", r103.getLongitudeE6());
        r100.putDouble("location_y", r103.getLatitudeE6());
        Overlay.c(this.f31224q, r100);
        if (this.f31227t == false) goto L18;
        r100.putDouble("dotted_stroke_location_x", r103.getLongitudeE6());
        r100.putDouble("dotted_stroke_location_y", r103.getLatitudeE6());
    L18:
        Overlay.d(this.f31223p, r100);
        if (this.f31214g != null) goto L21;
        r100.putInt("has_stroke", 0);
    L22:
        List<HoleOptions> r104 = this.f31225r;
        if (r104 == null) goto L28;
        if (r104.size() == 0) goto L28;
        e(this.f31225r, r100);
        r100.putInt("holes_count", this.f31225r.size());
    L31:
        r100.putInt("isClickable", this.f31228u ? 1 : 0);
        r100.putInt("isHoleClickable", this.f31229v ? 1 : 0);
        r100.putInt("isThined", this.f31231x ? 1 : 0);
        return r100;
    L28:
        if (this.f31226s == null) goto L30;
        ArrayList r105 = new ArrayList();
        r105.add(this.f31226s);
        e(r105, r100);
        r100.putInt("holes_count", 1);
        goto L31
    L30:
        r100.putInt("has_holes", 0);
        goto L31
    L21:
        r100.putInt("has_stroke", 1);
        Bundle r106 = new Bundle();
        r100.putBundle("stroke", this.f31214g.a(r106));
        goto L22
    L9:
        if (r101.length() <= 0) goto L13;
        if (this.f31203b == null) goto L13;
        r100.putString("encodedPoints", this.f31217j);
        r100.putInt("encodePointType", this.f31203b.ordinal());
        goto L18
    L5:
        r100.putInt("has_dotted_stroke", 0);
        goto L6
    }

    public void setBloomAlpha(float r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.D = r100;
        this.A.b(r100);
        this.f31207f.b();
        return;
    }

    public void setBloomBlurTimes(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.F = r100;
        this.A.e(r100);
        this.f31207f.b();
        return;
    }

    public void setBloomGradientASpeed(float r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.G = r100;
        this.A.c(r100);
        this.f31207f.b();
        return;
    }

    public void setBloomWidth(float r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.E = r100;
        this.A.d(r100);
        this.f31207f.b();
        return;
    }

    public void setClickable(boolean r100) {
        this.f31228u = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmPolygon r101 = this.A;
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

    public void setFillColor(int r100) {
        this.f31223p = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        b();
        return;
    L5:
        this.listener.c(this);
    }

    public void setHoleClickable(boolean r100) {
        this.f31229v = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmPolygon r101 = this.A;
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
        this.f31226s = r100;
        this.f31225r = null;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L7;
        b();
        return;
    L7:
        this.listener.c(this);
    }

    public void setHoleOptions(List<HoleOptions> r100) {
        this.f31225r = r100;
        this.f31226s = null;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        b();
        return;
    L5:
        this.listener.c(this);
    }

    public void setLineBloomDirection(LineBloomDirection r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.C = r100;
        this.A.g(r100.ordinal());
        this.f31207f.b();
        return;
    }

    public void setLineBloomType(LineBloomType r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.B = r100;
        this.A.h(r100.ordinal());
        this.f31207f.b();
        return;
    }

    public void setPoints(List<LatLng> r100) {
        if (r100 == null) goto L29;
        if (r100.size() <= 2) goto L27;
        if (r100.contains(null) == true) goto L25;
        int r101 = 0;
    L9:
        if (r101 >= r100.size()) goto L19;
        int r102 = r101 + 1;
        int r103 = r102;
    L12:
        if (r103 >= r100.size()) goto L18;
        if (((LatLng) ListProtector.get(r100, r101)) == ((LatLng) ListProtector.get(r100, r103))) goto L17;
        r103 = r103 + 1;
        goto L12
    L17:
        throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
    L18:
        r101 = r102;
        goto L9
    L19:
        this.f31224q = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L22;
        b();
        return;
    L22:
        this.listener.c(this);
        return;
    L25:
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
    L27:
        throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
    L29:
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public void setStroke(Stroke r100) {
        this.f31214g = r100;
        this.f31215h = true;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        b();
        return;
    L5:
        this.listener.c(this);
    }

    public void setThinAlgorithm(ThinAndSmoothAlgorithm r100) {
        this.f31232y = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.A.i(this.f31232y.getValue());
        this.f31207f.b();
        return;
    }

    public void setThinFactor(float r100) {
        if (r100 <= 0.0f) goto L6;
        this.f31233z = r100;
    L6:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.A.e(this.f31233z);
        this.f31207f.b();
        return;
    }

    public void setThined(boolean r100) {
        this.f31231x = r100;
        this.listener.c(this);
    }

    private void e(List<HoleOptions> r100, Bundle r101) {
        Bundle r102 = new Bundle();
        boolean r103 = Overlay.b(r100, r102);
        r101.putInt("has_holes", r103 ? 1 : 0);
        if (r103 == false) goto L6;
        r101.putBundle("holes", r102);
        return;
    }

    public void setEncodeInfo(String r100, EncodePointType r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L13;
        this.f31217j = r100;
        this.f31203b = r101;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        b();
        return;
    L9:
        this.listener.c(this);
        return;
    }
}
