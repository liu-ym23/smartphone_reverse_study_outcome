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
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class Circle extends Overlay {

    /* renamed from: B, reason: collision with root package name */
    float f6288B;

    /* renamed from: C, reason: collision with root package name */
    float f6289C;

    /* renamed from: D, reason: collision with root package name */
    int f6290D;

    /* renamed from: E, reason: collision with root package name */
    float f6291E;

    /* renamed from: g, reason: collision with root package name */
    LatLng f6292g;

    /* renamed from: h, reason: collision with root package name */
    int f6293h;

    /* renamed from: i, reason: collision with root package name */
    int f6294i;

    /* renamed from: j, reason: collision with root package name */
    Stroke f6295j;

    /* renamed from: k, reason: collision with root package name */
    boolean f6296k;

    /* renamed from: l, reason: collision with root package name */
    List<HoleOptions> f6297l;

    /* renamed from: m, reason: collision with root package name */
    HoleOptions f6298m;

    /* renamed from: n, reason: collision with root package name */
    boolean f6299n;

    /* renamed from: u, reason: collision with root package name */
    int f6306u;

    /* renamed from: v, reason: collision with root package name */
    int f6307v;

    /* renamed from: y, reason: collision with root package name */
    private BmCircle f6310y;

    /* renamed from: o, reason: collision with root package name */
    boolean f6300o = false;

    /* renamed from: p, reason: collision with root package name */
    boolean f6301p = false;

    /* renamed from: q, reason: collision with root package name */
    int f6302q = -1;

    /* renamed from: r, reason: collision with root package name */
    int f6303r = 1;

    /* renamed from: s, reason: collision with root package name */
    int f6304s = PolylineDottedLineType.DOTTED_LINE_SQUARE.ordinal();

    /* renamed from: t, reason: collision with root package name */
    BmSurfaceStyle f6305t = new BmSurfaceStyle();

    /* renamed from: w, reason: collision with root package name */
    float f6308w = 0.5f;

    /* renamed from: x, reason: collision with root package name */
    float f6309x = 0.2f;

    /* renamed from: z, reason: collision with root package name */
    LineBloomType f6311z = LineBloomType.NONE;

    /* renamed from: A, reason: collision with root package name */
    LineBloomDirection f6287A = LineBloomDirection.BloomAround;

    public Circle() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.circle;
    }

    private void b(Bundle bundle) {
        int i4 = this.f6304s;
        BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset(i4 == 1 ? "CircleDashTexture.png" : i4 == 2 ? "lineDash_Rectangle.png" : "lineDashTexture.png");
        if (bitmapDescriptorFromAsset != null) {
            bundle.putBundle("image_info", bitmapDescriptorFromAsset.a());
        }
    }

    private void c() {
        BmCircle bmCircle = this.f6310y;
        if (bmCircle == null || this.f6723f == null) {
            return;
        }
        bmCircle.c(this.f6299n);
        if (this.f6299n) {
            this.f6310y.d();
            ArrayList arrayList = new ArrayList();
            this.f6310y.e(this.f6309x);
            this.f6310y.f(this.f6308w);
            arrayList.add(Integer.valueOf(this.f6306u));
            arrayList.add(Integer.valueOf(this.f6307v));
            this.f6310y.a(this.f6303r, arrayList);
        }
        this.f6723f.b();
    }

    private void d() {
        if (this.f6310y == null || this.f6723f == null) {
            return;
        }
        List<HoleOptions> list = this.f6297l;
        if (list != null && list.size() != 0) {
            this.f6310y.c();
            List<List<com.baidu.platform.comapi.bmsdk.b>> listHoleInfo2BmGeo = Overlay.holeInfo2BmGeo(this.f6297l);
            for (int i4 = 0; i4 < listHoleInfo2BmGeo.size(); i4++) {
                BmGeoElement bmGeoElement = new BmGeoElement();
                bmGeoElement.a(listHoleInfo2BmGeo.get(i4));
                this.f6310y.a(bmGeoElement);
            }
        } else if (this.f6298m != null) {
            this.f6310y.c();
            BmGeoElement bmGeoElement2 = new BmGeoElement();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f6298m);
            bmGeoElement2.a(Overlay.holeInfo2BmGeo(arrayList).get(0));
            this.f6310y.a(bmGeoElement2);
        }
        this.f6723f.b();
    }

    private void e() {
        if (this.f6295j != null) {
            BmLineStyle bmLineStyle = new BmLineStyle();
            bmLineStyle.d(this.f6295j.strokeWidth);
            bmLineStyle.a(this.f6295j.color);
            if (this.f6296k) {
                setDottedBitmapResource(bmLineStyle, this.f6304s);
                bmLineStyle.c(5);
            } else {
                bmLineStyle.b(0);
            }
            this.f6310y.a(bmLineStyle);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6292g);
        bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
        bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
        if (this.f6299n) {
            bundle.putInt("m_isGradientCircle", 1);
            Overlay.b(this.f6306u, bundle);
            Overlay.c(this.f6307v, bundle);
            bundle.putFloat("m_color_weight", this.f6309x);
            bundle.putFloat("m_radius_weight", this.f6308w);
        } else {
            bundle.putInt("m_isGradientCircle", 0);
        }
        if (this.f6296k) {
            bundle.putDouble("dotted_stroke_location_x", geoPointLl2mc.getLongitudeE6());
            bundle.putDouble("dotted_stroke_location_y", geoPointLl2mc.getLatitudeE6());
            bundle.putInt("has_dotted_stroke", 1);
            b(bundle);
        } else {
            bundle.putInt("has_dotted_stroke", 0);
        }
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f6292g, this.f6294i));
        Overlay.d(this.f6293h, bundle);
        if (this.f6295j == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f6295j.a(new Bundle()));
        }
        List<HoleOptions> list = this.f6297l;
        if (list != null && list.size() != 0) {
            e(this.f6297l, bundle);
            bundle.putInt("holes_count", this.f6297l.size());
        } else if (this.f6298m != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f6298m);
            e(arrayList, bundle);
            bundle.putInt("holes_count", 1);
        } else {
            bundle.putInt("has_holes", 0);
        }
        bundle.putInt("isClickable", this.f6300o ? 1 : 0);
        bundle.putInt("isHoleClickable", this.f6301p ? 1 : 0);
        return bundle;
    }

    public LatLng getCenter() {
        return this.f6292g;
    }

    public int getCenterColor() {
        return this.f6306u;
    }

    public float getColorWeight() {
        return this.f6309x;
    }

    public int getDottedStrokeType() {
        return this.f6304s;
    }

    public int getFillColor() {
        return this.f6293h;
    }

    public int getHoleClickedIndex() {
        return this.f6302q;
    }

    public HoleOptions getHoleOption() {
        return this.f6298m;
    }

    public List<HoleOptions> getHoleOptions() {
        return this.f6297l;
    }

    public int getRadius() {
        return this.f6294i;
    }

    public float getRadiusWeight() {
        return this.f6308w;
    }

    public int getSideColor() {
        return this.f6307v;
    }

    public Stroke getStroke() {
        return this.f6295j;
    }

    public boolean isClickable() {
        return this.f6300o;
    }

    public boolean isDottedStroke() {
        return this.f6296k;
    }

    public boolean isIsGradientCircle() {
        return this.f6299n;
    }

    public void setBloomAlpha(float f4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6288B = f4;
            this.f6310y.b(f4);
            this.f6723f.b();
        }
    }

    public void setBloomBlurTimes(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6290D = i4;
            this.f6310y.e(i4);
            this.f6723f.b();
        }
    }

    public void setBloomGradientASpeed(float f4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6291E = f4;
            this.f6310y.c(f4);
            this.f6723f.b();
        }
    }

    public void setBloomWidth(float f4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6289C = f4;
            this.f6310y.d(f4);
            this.f6723f.b();
        }
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
        }
        this.f6292g = latLng;
        Overlay.mcLocation = CoordUtil.ll2mc(latLng);
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmCircle bmCircle = this.f6310y;
        if (bmCircle == null || this.f6723f == null) {
            return;
        }
        bmCircle.a(new com.baidu.platform.comapi.bmsdk.b(Overlay.mcLocation.getLongitudeE6(), Overlay.mcLocation.getLatitudeE6()));
        this.f6723f.b();
    }

    public void setCenterColor(int i4) {
        this.f6306u = i4;
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
        } else {
            this.listener.c(this);
        }
    }

    public void setClickable(boolean z4) {
        this.f6300o = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmCircle bmCircle = this.f6310y;
        if (bmCircle == null || this.f6723f == null) {
            return;
        }
        bmCircle.a(z4);
        this.f6723f.b();
    }

    public void setColorWeight(float f4) {
        if (f4 <= Property.DEFAULT_FLOAT_VALUE || f4 >= 1.0f) {
            return;
        }
        this.f6309x = f4;
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
        } else {
            this.listener.c(this);
        }
    }

    public void setDottedStroke(boolean z4) {
        this.f6296k = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.f6310y == null || this.f6723f == null || this.f6305t == null) {
                return;
            }
            e();
            this.f6723f.b();
        }
    }

    public void setDottedStrokeType(CircleDottedStrokeType circleDottedStrokeType) {
        this.f6304s = circleDottedStrokeType.ordinal();
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.f6310y == null || this.f6723f == null || this.f6305t == null) {
                return;
            }
            e();
            this.f6723f.b();
        }
    }

    public void setFillColor(int i4) {
        BmSurfaceStyle bmSurfaceStyle;
        this.f6293h = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6310y == null || this.f6723f == null || (bmSurfaceStyle = this.f6305t) == null) {
            return;
        }
        bmSurfaceStyle.a(this.f6293h);
        this.f6310y.a(this.f6305t);
        this.f6723f.b();
    }

    public void setHoleClickable(boolean z4) {
        this.f6301p = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmCircle bmCircle = this.f6310y;
        if (bmCircle == null || this.f6723f == null) {
            return;
        }
        bmCircle.b(z4);
        this.f6723f.b();
    }

    public void setHoleOption(HoleOptions holeOptions) {
        if (holeOptions == null) {
            return;
        }
        this.f6298m = holeOptions;
        this.f6297l = null;
        if (OverlayUtil.isOverlayUpgrade()) {
            d();
        } else {
            this.listener.c(this);
        }
    }

    public void setHoleOptions(List<HoleOptions> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f6297l = list;
        this.f6298m = null;
        if (OverlayUtil.isOverlayUpgrade()) {
            d();
        } else {
            this.listener.c(this);
        }
    }

    public void setIsGradientCircle(boolean z4) {
        this.f6299n = z4;
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
        } else {
            this.listener.c(this);
        }
    }

    public void setLineBloomDirection(LineBloomDirection lineBloomDirection) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6287A = lineBloomDirection;
            this.f6310y.f(lineBloomDirection.ordinal());
            this.f6723f.b();
        }
    }

    public void setLineBloomType(LineBloomType lineBloomType) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6311z = lineBloomType;
            this.f6310y.g(lineBloomType.ordinal());
            this.f6723f.b();
        }
    }

    public void setRadius(int i4) {
        this.f6294i = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6310y == null || this.f6723f == null || this.f6305t == null) {
            return;
        }
        this.f6310y.a(CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f6292g, this.f6294i));
        this.f6723f.b();
    }

    public void setRadiusWeight(float f4) {
        if (f4 <= Property.DEFAULT_FLOAT_VALUE || f4 >= 1.0f) {
            return;
        }
        this.f6308w = f4;
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
        } else {
            this.listener.c(this);
        }
    }

    public void setSideColor(int i4) {
        this.f6307v = i4;
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
        } else {
            this.listener.c(this);
        }
    }

    public void setStroke(Stroke stroke) {
        this.f6295j = stroke;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.f6310y == null || this.f6723f == null || this.f6305t == null) {
                return;
            }
            e();
            this.f6723f.b();
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmCircle bmCircle = new BmCircle();
        this.f6310y = bmCircle;
        bmCircle.a(this);
        setDrawItem(this.f6310y);
        super.toDrawItem();
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6292g);
        Overlay.mcLocation = geoPointLl2mc;
        this.f6310y.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), Overlay.mcLocation.getLatitudeE6()));
        this.f6310y.a(CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f6292g, this.f6294i));
        if (this.f6295j != null) {
            BmLineStyle bmLineStyle = new BmLineStyle();
            bmLineStyle.d(this.f6295j.strokeWidth);
            bmLineStyle.a(this.f6295j.color);
            if (this.f6296k) {
                setDottedBitmapResource(bmLineStyle, this.f6304s);
                bmLineStyle.c(5);
            } else {
                bmLineStyle.b(0);
            }
            this.f6310y.a(bmLineStyle);
            this.f6310y.b(this.f6288B);
            this.f6310y.d(this.f6289C);
            this.f6310y.g(this.f6311z.ordinal());
            this.f6310y.c(this.f6291E);
            this.f6310y.f(this.f6287A.ordinal());
        }
        this.f6305t.a(this.f6293h);
        this.f6310y.a(this.f6305t);
        List<HoleOptions> list = this.f6297l;
        if (list != null && list.size() != 0) {
            List<List<com.baidu.platform.comapi.bmsdk.b>> listHoleInfo2BmGeo = Overlay.holeInfo2BmGeo(this.f6297l);
            for (int i4 = 0; i4 < listHoleInfo2BmGeo.size(); i4++) {
                BmGeoElement bmGeoElement = new BmGeoElement();
                bmGeoElement.a(listHoleInfo2BmGeo.get(i4));
                this.f6310y.a(bmGeoElement);
            }
        } else if (this.f6298m != null) {
            BmGeoElement bmGeoElement2 = new BmGeoElement();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f6298m);
            bmGeoElement2.a(Overlay.holeInfo2BmGeo(arrayList).get(0));
            this.f6310y.a(bmGeoElement2);
        }
        this.f6310y.b(this.f6301p);
        this.f6310y.a(this.f6300o);
        this.f6310y.c(this.f6299n);
        if (this.f6299n) {
            ArrayList arrayList2 = new ArrayList();
            this.f6310y.e(this.f6309x);
            this.f6310y.f(this.f6308w);
            arrayList2.add(Integer.valueOf(this.f6306u));
            arrayList2.add(Integer.valueOf(this.f6307v));
            this.f6310y.a(this.f6303r, arrayList2);
        }
        return this.f6310y;
    }

    private void e(List<HoleOptions> list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        boolean zB = Overlay.b(list, bundle2);
        bundle.putInt("has_holes", zB ? 1 : 0);
        if (zB) {
            bundle.putBundle("holes", bundle2);
        }
    }
}
