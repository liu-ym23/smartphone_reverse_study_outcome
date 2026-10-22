package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.stepos.alphame.utils.Property;
import java.util.List;

/* loaded from: classes.dex */
public final class PolygonOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private Stroke f6758a;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLng> f6760c;

    /* renamed from: d, reason: collision with root package name */
    private List<HoleOptions> f6761d;

    /* renamed from: e, reason: collision with root package name */
    private HoleOptions f6762e;

    /* renamed from: g, reason: collision with root package name */
    private String f6764g;

    /* renamed from: h, reason: collision with root package name */
    private EncodePointType f6765h;

    /* renamed from: n, reason: collision with root package name */
    private int f6771n;

    /* renamed from: o, reason: collision with root package name */
    private int f6772o;

    /* renamed from: t, reason: collision with root package name */
    int f6777t;

    /* renamed from: v, reason: collision with root package name */
    Bundle f6779v;

    /* renamed from: b, reason: collision with root package name */
    private int f6759b = -16777216;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6763f = false;

    /* renamed from: i, reason: collision with root package name */
    private int f6766i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6767j = false;

    /* renamed from: k, reason: collision with root package name */
    private LineBloomType f6768k = LineBloomType.NONE;

    /* renamed from: l, reason: collision with root package name */
    private float f6769l = 5.0f;

    /* renamed from: m, reason: collision with root package name */
    private int f6770m = 1;

    /* renamed from: p, reason: collision with root package name */
    private LineBloomDirection f6773p = LineBloomDirection.BloomAround;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6774q = true;

    /* renamed from: r, reason: collision with root package name */
    private ThinAndSmoothAlgorithm f6775r = ThinAndSmoothAlgorithm.DOUGLAS_PEUCKER;

    /* renamed from: s, reason: collision with root package name */
    private float f6776s = 4.0f;

    /* renamed from: u, reason: collision with root package name */
    boolean f6778u = true;

    public PolygonOptions addHoleOption(HoleOptions holeOptions) {
        this.f6762e = holeOptions;
        return this;
    }

    public PolygonOptions addHoleOptions(List<HoleOptions> list) {
        this.f6761d = list;
        return this;
    }

    public PolygonOptions bloomAlpha(int i4) {
        if (i4 > 255 || i4 < 0) {
            i4 = 255;
        }
        this.f6772o = i4;
        return this;
    }

    public PolygonOptions bloomType(LineBloomType lineBloomType) {
        this.f6768k = lineBloomType;
        return this;
    }

    public PolygonOptions bloomWidth(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        this.f6771n = i4;
        return this;
    }

    public PolygonOptions dottedStroke(boolean z4) {
        this.f6763f = z4;
        return this;
    }

    public PolygonOptions dottedStrokeType(PolylineDottedLineType polylineDottedLineType) {
        this.f6766i = polylineDottedLineType.ordinal();
        return this;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        this.f6779v = bundle;
        return this;
    }

    public PolygonOptions fillColor(int i4) {
        this.f6759b = i4;
        return this;
    }

    public Bundle getExtraInfo() {
        return this.f6779v;
    }

    public int getFillColor() {
        return this.f6759b;
    }

    public LineBloomDirection getLineBloomDirection() {
        return this.f6773p;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Polygon polygon = new Polygon();
        polygon.f6721d = this.f6778u;
        polygon.f6720c = this.f6777t;
        polygon.f6722e = this.f6779v;
        List<LatLng> list = this.f6760c;
        if (list == null || list.size() < 2) {
            String str = this.f6764g;
            if (str == null || str.length() <= 0) {
                throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
            }
            polygon.f6740j = this.f6764g;
            polygon.f6719b = this.f6765h;
        }
        polygon.f6747q = this.f6760c;
        polygon.f6746p = this.f6759b;
        polygon.f6737g = this.f6758a;
        polygon.f6748r = this.f6761d;
        polygon.f6749s = this.f6762e;
        polygon.f6750t = this.f6763f;
        polygon.f6743m = this.f6766i;
        polygon.f6751u = this.f6767j;
        polygon.f6731B = this.f6768k;
        polygon.f6732C = this.f6773p;
        polygon.f6734E = this.f6771n;
        polygon.f6733D = this.f6772o;
        polygon.f6736G = this.f6769l;
        polygon.f6735F = this.f6770m;
        polygon.f6754x = this.f6774q;
        polygon.f6755y = this.f6775r;
        polygon.f6756z = this.f6776s;
        return polygon;
    }

    public List<LatLng> getPoints() {
        return this.f6760c;
    }

    public Stroke getStroke() {
        return this.f6758a;
    }

    public int getZIndex() {
        return this.f6777t;
    }

    public PolygonOptions isThined(boolean z4) {
        this.f6774q = z4;
        return this;
    }

    public boolean isVisible() {
        return this.f6778u;
    }

    public PolygonOptions lineBloomDirection(LineBloomDirection lineBloomDirection) {
        this.f6773p = lineBloomDirection;
        return this;
    }

    public PolygonOptions points(String str, EncodePointType encodePointType) {
        this.f6764g = str;
        this.f6765h = encodePointType;
        return this;
    }

    public PolygonOptions setBloomBlurTimes(int i4) {
        if (i4 < 1) {
            i4 = 1;
        }
        if (i4 > 10) {
            i4 = 10;
        }
        this.f6770m = i4;
        return this;
    }

    public PolygonOptions setBloomGradientASpeed(float f4) {
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        if (f4 > 10.0f) {
            f4 = 10.0f;
        }
        this.f6769l = f4;
        return this;
    }

    public PolygonOptions setClickable(boolean z4) {
        this.f6767j = z4;
        return this;
    }

    public PolygonOptions stroke(Stroke stroke) {
        this.f6758a = stroke;
        return this;
    }

    public PolygonOptions thinAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.f6775r = thinAndSmoothAlgorithm;
        return this;
    }

    public PolygonOptions thinFactor(float f4) {
        if (f4 > Property.DEFAULT_FLOAT_VALUE) {
            this.f6776s = f4;
        }
        return this;
    }

    public PolygonOptions visible(boolean z4) {
        this.f6778u = z4;
        return this;
    }

    public PolygonOptions zIndex(int i4) {
        this.f6777t = i4;
        return this;
    }

    public PolygonOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() > 2) {
                if (!list.contains(null)) {
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
                    this.f6760c = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }
}
