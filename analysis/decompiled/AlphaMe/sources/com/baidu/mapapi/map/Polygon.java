package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.t;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmPolygon;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class Polygon extends Overlay {

    /* renamed from: A, reason: collision with root package name */
    BmPolygon f6730A;

    /* renamed from: D, reason: collision with root package name */
    float f6733D;

    /* renamed from: E, reason: collision with root package name */
    float f6734E;

    /* renamed from: F, reason: collision with root package name */
    int f6735F;

    /* renamed from: G, reason: collision with root package name */
    float f6736G;

    /* renamed from: g, reason: collision with root package name */
    Stroke f6737g;

    /* renamed from: i, reason: collision with root package name */
    BmGeoElement f6739i;

    /* renamed from: j, reason: collision with root package name */
    String f6740j;

    /* renamed from: k, reason: collision with root package name */
    BmSurfaceStyle f6741k;

    /* renamed from: l, reason: collision with root package name */
    BmLineStyle f6742l;

    /* renamed from: n, reason: collision with root package name */
    BmGeoElement f6744n;

    /* renamed from: p, reason: collision with root package name */
    int f6746p;

    /* renamed from: q, reason: collision with root package name */
    List<LatLng> f6747q;

    /* renamed from: r, reason: collision with root package name */
    List<HoleOptions> f6748r;

    /* renamed from: s, reason: collision with root package name */
    HoleOptions f6749s;

    /* renamed from: t, reason: collision with root package name */
    boolean f6750t;

    /* renamed from: x, reason: collision with root package name */
    boolean f6754x;

    /* renamed from: y, reason: collision with root package name */
    ThinAndSmoothAlgorithm f6755y;

    /* renamed from: z, reason: collision with root package name */
    float f6756z;

    /* renamed from: h, reason: collision with root package name */
    boolean f6738h = false;

    /* renamed from: m, reason: collision with root package name */
    int f6743m = PolylineDottedLineType.DOTTED_LINE_SQUARE.ordinal();

    /* renamed from: o, reason: collision with root package name */
    List<BmGeoElement> f6745o = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    boolean f6751u = false;

    /* renamed from: v, reason: collision with root package name */
    boolean f6752v = false;

    /* renamed from: w, reason: collision with root package name */
    int f6753w = -1;

    /* renamed from: B, reason: collision with root package name */
    LineBloomType f6731B = LineBloomType.NONE;

    /* renamed from: C, reason: collision with root package name */
    LineBloomDirection f6732C = LineBloomDirection.BloomAround;

    public Polygon() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.polygon;
    }

    private void b(Bundle bundle) {
        int i4 = this.f6743m;
        BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset(i4 == 1 ? "CircleDashTexture.png" : i4 == 2 ? "lineDash_Rectangle.png" : "lineDashTexture.png");
        if (bitmapDescriptorFromAsset != null) {
            bundle.putBundle("image_info", bitmapDescriptorFromAsset.a());
        }
    }

    private void e(List<HoleOptions> list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        boolean zB = Overlay.b(list, bundle2);
        bundle.putInt("has_holes", zB ? 1 : 0);
        if (zB) {
            bundle.putBundle("holes", bundle2);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.f6750t) {
            bundle.putInt("has_dotted_stroke", 1);
            b(bundle);
        } else {
            bundle.putInt("has_dotted_stroke", 0);
        }
        String str = this.f6740j;
        if (str == null || str.length() <= 0 || this.f6719b == null) {
            List<LatLng> list = this.f6747q;
            if (list != null) {
                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(list.get(0));
                bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
                bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
                Overlay.c(this.f6747q, bundle);
                if (this.f6750t) {
                    bundle.putDouble("dotted_stroke_location_x", geoPointLl2mc.getLongitudeE6());
                    bundle.putDouble("dotted_stroke_location_y", geoPointLl2mc.getLatitudeE6());
                }
            }
        } else {
            bundle.putString("encodedPoints", this.f6740j);
            bundle.putInt("encodePointType", this.f6719b.ordinal());
        }
        Overlay.d(this.f6746p, bundle);
        if (this.f6737g == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f6737g.a(new Bundle()));
        }
        List<HoleOptions> list2 = this.f6748r;
        if (list2 != null && list2.size() != 0) {
            e(this.f6748r, bundle);
            bundle.putInt("holes_count", this.f6748r.size());
        } else if (this.f6749s != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f6749s);
            e(arrayList, bundle);
            bundle.putInt("holes_count", 1);
        } else {
            bundle.putInt("has_holes", 0);
        }
        bundle.putInt("isClickable", this.f6751u ? 1 : 0);
        bundle.putInt("isHoleClickable", this.f6752v ? 1 : 0);
        bundle.putInt("isThined", this.f6754x ? 1 : 0);
        return bundle;
    }

    public String getEncodedPoint() {
        return this.f6740j;
    }

    public int getFillColor() {
        return this.f6746p;
    }

    public int getHoleClickedIndex() {
        return this.f6753w;
    }

    public HoleOptions getHoleOption() {
        return this.f6749s;
    }

    public List<HoleOptions> getHoleOptions() {
        return this.f6748r;
    }

    public EncodePointType getPointType() {
        return this.f6719b;
    }

    public List<LatLng> getPoints() {
        return this.f6747q;
    }

    public Stroke getStroke() {
        return this.f6737g;
    }

    public boolean isClickable() {
        return this.f6751u;
    }

    public boolean isThined() {
        return this.f6754x;
    }

    public void setBloomAlpha(float f4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6733D = f4;
            this.f6730A.b(f4);
            this.f6723f.b();
        }
    }

    public void setBloomBlurTimes(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6735F = i4;
            this.f6730A.e(i4);
            this.f6723f.b();
        }
    }

    public void setBloomGradientASpeed(float f4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6736G = f4;
            this.f6730A.c(f4);
            this.f6723f.b();
        }
    }

    public void setBloomWidth(float f4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6734E = f4;
            this.f6730A.d(f4);
            this.f6723f.b();
        }
    }

    public void setClickable(boolean z4) {
        this.f6751u = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPolygon bmPolygon = this.f6730A;
        if (bmPolygon == null || this.f6723f == null) {
            return;
        }
        bmPolygon.a(z4);
        this.f6723f.b();
    }

    public void setEncodeInfo(String str, EncodePointType encodePointType) {
        if (str == null || str.length() <= 0) {
            return;
        }
        this.f6740j = str;
        this.f6719b = encodePointType;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setFillColor(int i4) {
        this.f6746p = i4;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setHoleClickable(boolean z4) {
        this.f6752v = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPolygon bmPolygon = this.f6730A;
        if (bmPolygon == null || this.f6723f == null) {
            return;
        }
        bmPolygon.b(z4);
        this.f6723f.b();
    }

    public void setHoleOption(HoleOptions holeOptions) {
        if (holeOptions == null) {
            return;
        }
        this.f6749s = holeOptions;
        this.f6748r = null;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setHoleOptions(List<HoleOptions> list) {
        this.f6748r = list;
        this.f6749s = null;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setLineBloomDirection(LineBloomDirection lineBloomDirection) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6732C = lineBloomDirection;
            this.f6730A.g(lineBloomDirection.ordinal());
            this.f6723f.b();
        }
    }

    public void setLineBloomType(LineBloomType lineBloomType) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6731B = lineBloomType;
            this.f6730A.h(lineBloomType.ordinal());
            this.f6723f.b();
        }
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() <= 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        int i4 = 0;
        while (i4 < list.size()) {
            int i5 = i4 + 1;
            for (int i6 = i5; i6 < list.size(); i6++) {
                if (list.get(i4) == list.get(i6)) {
                    throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                }
            }
            i4 = i5;
        }
        this.f6747q = list;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setStroke(Stroke stroke) {
        this.f6737g = stroke;
        this.f6738h = true;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setThinAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.f6755y = thinAndSmoothAlgorithm;
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6730A.i(this.f6755y.getValue());
            this.f6723f.b();
        }
    }

    public void setThinFactor(float f4) {
        if (f4 > Property.DEFAULT_FLOAT_VALUE) {
            this.f6756z = f4;
        }
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6730A.e(this.f6756z);
            this.f6723f.b();
        }
    }

    public void setThined(boolean z4) {
        this.f6754x = z4;
        this.listener.c(this);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmPolygon bmPolygon = new BmPolygon();
        this.f6730A = bmPolygon;
        bmPolygon.a(this);
        setDrawItem(this.f6730A);
        super.toDrawItem();
        this.f6739i = new BmGeoElement();
        BmLineStyle bmLineStyle = new BmLineStyle();
        this.f6742l = bmLineStyle;
        Stroke stroke = this.f6737g;
        if (stroke != null) {
            bmLineStyle.d(stroke.strokeWidth);
            this.f6742l.a(this.f6737g.color);
            if (this.f6750t) {
                setDottedBitmapResource(this.f6742l, this.f6743m);
                this.f6742l.c(5);
            } else {
                this.f6742l.b(0);
            }
            this.f6730A.h(this.f6731B.ordinal());
            this.f6730A.g(this.f6732C.ordinal());
            this.f6730A.b(this.f6733D);
            this.f6730A.d(this.f6734E);
            this.f6730A.c(this.f6736G);
            this.f6730A.e(this.f6735F);
        }
        this.f6739i.a(this.f6742l);
        ArrayList arrayList = new ArrayList();
        String str = this.f6740j;
        if (str == null || str.length() <= 0 || this.f6719b == null) {
            List<LatLng> list = this.f6747q;
            if (list != null) {
                Overlay.mcLocation = CoordUtil.ll2mc(list.get(0));
                Iterator<LatLng> it = this.f6747q.iterator();
                while (it.hasNext()) {
                    GeoPoint geoPointLl2mc = CoordUtil.ll2mc(it.next());
                    arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
                }
                this.f6739i.a(arrayList);
            }
        } else {
            Iterator<LatLng> it2 = new t().d(this.f6740j).iterator();
            while (it2.hasNext()) {
                GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(it2.next());
                arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
            }
            this.f6739i.a(arrayList);
        }
        this.f6730A.a(this.f6739i);
        List<HoleOptions> list2 = this.f6748r;
        if (list2 != null && list2.size() != 0) {
            List<List<com.baidu.platform.comapi.bmsdk.b>> listHoleInfo2BmGeo = Overlay.holeInfo2BmGeo(this.f6748r);
            for (int i4 = 0; i4 < listHoleInfo2BmGeo.size(); i4++) {
                BmGeoElement bmGeoElement = new BmGeoElement();
                bmGeoElement.a(listHoleInfo2BmGeo.get(i4));
                this.f6745o.add(bmGeoElement);
                this.f6730A.b(bmGeoElement);
            }
        } else if (this.f6749s != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.f6749s);
            List<com.baidu.platform.comapi.bmsdk.b> list3 = Overlay.holeInfo2BmGeo(arrayList2).get(0);
            BmGeoElement bmGeoElement2 = new BmGeoElement();
            this.f6744n = bmGeoElement2;
            bmGeoElement2.a(list3);
            this.f6730A.b(this.f6744n);
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        this.f6741k = bmSurfaceStyle;
        bmSurfaceStyle.a(this.f6746p);
        this.f6730A.a(this.f6741k);
        this.f6730A.f(4096);
        this.f6730A.a(this.f6751u);
        this.f6730A.b(this.f6752v);
        if (this.f6754x) {
            this.f6730A.i(this.f6755y.getValue());
            float f4 = this.f6756z;
            if (f4 > Property.DEFAULT_FLOAT_VALUE) {
                this.f6730A.e(f4);
            }
        }
        return this.f6730A;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem b() {
        BmLineStyle bmLineStyle;
        if (this.f6739i != null && this.f6730A != null) {
            super.b();
            this.f6730A.c();
            Stroke stroke = this.f6737g;
            if (stroke != null && (bmLineStyle = this.f6742l) != null) {
                bmLineStyle.d(stroke.strokeWidth);
                this.f6742l.a(this.f6737g.color);
                if (this.f6750t) {
                    setDottedBitmapResource(this.f6742l, this.f6743m);
                    this.f6742l.c(5);
                } else {
                    this.f6742l.b(0);
                }
                this.f6739i.a(this.f6742l);
            }
            ArrayList arrayList = new ArrayList();
            String str = this.f6740j;
            if (str != null && str.length() > 0 && this.f6719b != null) {
                Iterator<LatLng> it = new t().d(this.f6740j).iterator();
                while (it.hasNext()) {
                    GeoPoint geoPointLl2mc = CoordUtil.ll2mc(it.next());
                    arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
                }
                this.f6739i.a(arrayList);
            } else {
                List<LatLng> list = this.f6747q;
                if (list != null) {
                    Overlay.mcLocation = CoordUtil.ll2mc(list.get(0));
                    Iterator<LatLng> it2 = this.f6747q.iterator();
                    while (it2.hasNext()) {
                        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(it2.next());
                        arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
                    }
                    this.f6739i.a(arrayList);
                }
            }
            this.f6730A.a(this.f6739i);
            List<HoleOptions> list2 = this.f6748r;
            if (list2 != null && list2.size() != 0) {
                List<List<com.baidu.platform.comapi.bmsdk.b>> listHoleInfo2BmGeo = Overlay.holeInfo2BmGeo(this.f6748r);
                for (int i4 = 0; i4 < listHoleInfo2BmGeo.size(); i4++) {
                    BmGeoElement bmGeoElement = new BmGeoElement();
                    bmGeoElement.a(listHoleInfo2BmGeo.get(i4));
                    this.f6745o.add(bmGeoElement);
                    this.f6730A.b(bmGeoElement);
                }
            } else if (this.f6749s != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.f6749s);
                List<com.baidu.platform.comapi.bmsdk.b> list3 = Overlay.holeInfo2BmGeo(arrayList2).get(0);
                BmGeoElement bmGeoElement2 = new BmGeoElement();
                this.f6744n = bmGeoElement2;
                bmGeoElement2.a(list3);
                this.f6730A.b(this.f6744n);
            }
            BmSurfaceStyle bmSurfaceStyle = this.f6741k;
            if (bmSurfaceStyle != null) {
                bmSurfaceStyle.a(this.f6746p);
                this.f6730A.a(this.f6741k);
            }
            this.f6730A.f(4096);
            this.f6730A.a(this.f6751u);
            this.f6730A.b(this.f6752v);
            this.f6723f.b();
            return this.f6730A;
        }
        return this.f6730A;
    }
}
