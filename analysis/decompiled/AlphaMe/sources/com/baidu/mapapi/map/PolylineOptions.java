package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PolylineOptions extends OverlayOptions {

    /* renamed from: C, reason: collision with root package name */
    private int f6823C;

    /* renamed from: D, reason: collision with root package name */
    private int f6824D;

    /* renamed from: F, reason: collision with root package name */
    private boolean f6826F;

    /* renamed from: b, reason: collision with root package name */
    private List<LatLng> f6828b;

    /* renamed from: c, reason: collision with root package name */
    private List<Integer> f6829c;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f6830d;

    /* renamed from: f, reason: collision with root package name */
    private BitmapDescriptor f6832f;

    /* renamed from: g, reason: collision with root package name */
    private List<BitmapDescriptor> f6833g;

    /* renamed from: j, reason: collision with root package name */
    int f6836j;

    /* renamed from: n, reason: collision with root package name */
    Bundle f6840n;

    /* renamed from: a, reason: collision with root package name */
    private int f6827a = -16777216;

    /* renamed from: e, reason: collision with root package name */
    private int f6831e = 5;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6834h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6835i = false;

    /* renamed from: k, reason: collision with root package name */
    boolean f6837k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6838l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6839m = true;

    /* renamed from: o, reason: collision with root package name */
    private int f6841o = 0;

    /* renamed from: p, reason: collision with root package name */
    private LineJoinType f6842p = LineJoinType.LineJoinRound;

    /* renamed from: q, reason: collision with root package name */
    private LineCapType f6843q = LineCapType.LineCapButt;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6844r = true;

    /* renamed from: s, reason: collision with root package name */
    private ThinAndSmoothAlgorithm f6845s = ThinAndSmoothAlgorithm.DOUGLAS_PEUCKER;

    /* renamed from: t, reason: collision with root package name */
    private float f6846t = 4.0f;

    /* renamed from: u, reason: collision with root package name */
    private ThinAndSmoothAlgorithm f6847u = ThinAndSmoothAlgorithm.BEZIER_SMOOTH;

    /* renamed from: v, reason: collision with root package name */
    private float f6848v = 16.0f;

    /* renamed from: w, reason: collision with root package name */
    private boolean f6849w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f6850x = false;

    /* renamed from: y, reason: collision with root package name */
    private LineDirectionCross180 f6851y = LineDirectionCross180.NONE;

    /* renamed from: z, reason: collision with root package name */
    private LineBloomType f6852z = LineBloomType.NONE;

    /* renamed from: A, reason: collision with root package name */
    private float f6821A = 5.0f;

    /* renamed from: B, reason: collision with root package name */
    private int f6822B = 1;

    /* renamed from: E, reason: collision with root package name */
    private LineBloomDirection f6825E = LineBloomDirection.BloomAround;

    public enum LineBloomType {
        NONE,
        GradientA,
        BLUR
    }

    public enum LineCapType {
        LineCapButt,
        LineCapRound
    }

    public enum LineDirectionCross180 {
        NONE,
        FROM_EAST_TO_WEST,
        FROM_WEST_TO_EAST
    }

    public enum LineJoinType {
        LineJoinBevel,
        LineJoinMiter,
        LineJoinRound,
        LineJoinBerzier
    }

    private Polyline a(Polyline polyline) {
        polyline.f6721d = this.f6837k;
        polyline.f6796Q = this.f6851y;
        polyline.f6799h = this.f6828b;
        polyline.f6803l = this.f6831e;
        polyline.f6781B = this.f6850x;
        List<Integer> list = this.f6830d;
        if (list == null || list.size() == 0) {
            throw new IllegalStateException("BDMapSDKException: colors array can not be null");
        }
        List<LatLng> list2 = this.f6828b;
        if (list2 == null || list2.size() == 0) {
            throw new IllegalStateException("BDMapSDKException: mPoints array can not be null");
        }
        int[] iArr = new int[this.f6830d.size()];
        Iterator<Integer> it = this.f6830d.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            iArr[i4] = it.next().intValue();
            i4++;
        }
        polyline.f6801j = iArr;
        return polyline;
    }

    public PolylineOptions bloomAlpha(int i4) {
        if (i4 > 255 || i4 < 0) {
            i4 = 255;
        }
        this.f6824D = i4;
        return this;
    }

    public PolylineOptions bloomType(LineBloomType lineBloomType) {
        this.f6852z = lineBloomType;
        return this;
    }

    public PolylineOptions bloomWidth(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        this.f6823C = i4;
        return this;
    }

    public PolylineOptions clickable(boolean z4) {
        this.f6839m = z4;
        return this;
    }

    public PolylineOptions color(int i4) {
        this.f6827a = i4;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
        }
        this.f6830d = list;
        return this;
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        this.f6832f = bitmapDescriptor;
        return this;
    }

    public PolylineOptions customTextureList(List<BitmapDescriptor> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: customTexture list can not be null");
        }
        if (list.size() == 0) {
            Log.e("baidumapsdk", "custom texture list is empty,the texture will not work");
        }
        Iterator<BitmapDescriptor> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                Log.e("baidumapsdk", "the custom texture item is null,it will be discard");
            }
        }
        this.f6833g = list;
        return this;
    }

    public PolylineOptions dottedLine(boolean z4) {
        this.f6838l = z4;
        return this;
    }

    public PolylineOptions dottedLineType(PolylineDottedLineType polylineDottedLineType) {
        this.f6841o = polylineDottedLineType.ordinal();
        return this;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        this.f6840n = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z4) {
        this.f6834h = z4;
        return this;
    }

    public int getColor() {
        return this.f6827a;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.f6832f;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.f6833g;
    }

    public Bundle getExtraInfo() {
        return this.f6840n;
    }

    public LineBloomDirection getLineBloomDirection() {
        return this.f6825E;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        BitmapDescriptor bitmapDescriptor;
        Polyline polyline = new Polyline();
        List<LatLng> list = this.f6828b;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
        }
        polyline.f6797R = this.f6852z;
        polyline.f6787H = this.f6825E;
        polyline.f6782C = this.f6823C;
        polyline.f6783D = this.f6824D;
        polyline.f6784E = this.f6821A;
        polyline.f6785F = this.f6822B;
        if (this.f6850x) {
            polyline.type = com.baidu.mapsdkplatform.comapi.map.d.gradientLine;
            return a(polyline);
        }
        polyline.f6721d = this.f6837k;
        polyline.f6804m = this.f6838l;
        polyline.f6720c = this.f6836j;
        polyline.f6722e = this.f6840n;
        polyline.f6799h = this.f6828b;
        polyline.f6798g = this.f6827a;
        polyline.f6803l = this.f6831e;
        polyline.f6808q = this.f6832f;
        if (OverlayUtil.isOverlayUpgrade() && (bitmapDescriptor = this.f6832f) != null) {
            polyline.f6809r = new BmBitmapResource(bitmapDescriptor.getBitmap());
        }
        polyline.f6810s = this.f6833g;
        int i4 = 0;
        if (OverlayUtil.isOverlayUpgrade() && this.f6833g != null) {
            polyline.f6811t = new ArrayList();
            for (int i5 = 0; i5 < this.f6833g.size(); i5++) {
                polyline.f6811t.add(new BmBitmapResource(this.f6833g.get(i5).getBitmap()));
            }
        }
        polyline.f6805n = this.f6834h;
        polyline.f6806o = this.f6835i;
        polyline.f6807p = this.f6839m;
        polyline.f6813v = this.f6844r;
        polyline.f6814w = this.f6845s;
        polyline.f6815x = this.f6846t;
        polyline.f6816y = this.f6847u;
        polyline.f6817z = this.f6848v;
        polyline.f6780A = this.f6849w;
        polyline.f6781B = this.f6850x;
        polyline.f6812u = this.f6841o;
        polyline.f6795P = this.f6842p;
        polyline.f6794O = this.f6843q;
        polyline.f6796Q = this.f6851y;
        List<Integer> list2 = this.f6829c;
        if (list2 != null && list2.size() < this.f6828b.size() - 1) {
            ArrayList arrayList = new ArrayList((this.f6828b.size() - 1) - this.f6829c.size());
            List<Integer> list3 = this.f6829c;
            list3.addAll(list3.size(), arrayList);
        }
        List<Integer> list4 = this.f6829c;
        if (list4 != null && list4.size() > 0) {
            int[] iArr = new int[this.f6829c.size()];
            Iterator<Integer> it = this.f6829c.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                iArr[i6] = it.next().intValue();
                i6++;
            }
            polyline.f6800i = iArr;
        }
        List<Integer> list5 = this.f6830d;
        if (list5 != null && list5.size() < this.f6828b.size() - 1) {
            ArrayList arrayList2 = new ArrayList((this.f6828b.size() - 1) - this.f6830d.size());
            List<Integer> list6 = this.f6830d;
            list6.addAll(list6.size(), arrayList2);
        }
        List<Integer> list7 = this.f6830d;
        if (list7 != null && list7.size() > 0) {
            int[] iArr2 = new int[this.f6830d.size()];
            Iterator<Integer> it2 = this.f6830d.iterator();
            while (it2.hasNext()) {
                iArr2[i4] = it2.next().intValue();
                i4++;
            }
            polyline.f6801j = iArr2;
        }
        polyline.f6786G = this.f6826F;
        return polyline;
    }

    public List<LatLng> getPoints() {
        return this.f6828b;
    }

    public List<Integer> getTextureIndexs() {
        return this.f6829c;
    }

    public int getWidth() {
        return this.f6831e;
    }

    public int getZIndex() {
        return this.f6836j;
    }

    public boolean isDottedLine() {
        return this.f6838l;
    }

    public boolean isFocus() {
        return this.f6834h;
    }

    public PolylineOptions isGeodesic(boolean z4) {
        this.f6849w = z4;
        return this;
    }

    public PolylineOptions isGradient(boolean z4) {
        this.f6850x = z4;
        return this;
    }

    public PolylineOptions isThined(boolean z4) {
        this.f6844r = z4;
        return this;
    }

    public boolean isVisible() {
        return this.f6837k;
    }

    public PolylineOptions keepScale(boolean z4) {
        this.f6835i = z4;
        return this;
    }

    public PolylineOptions lineBloomDirection(LineBloomDirection lineBloomDirection) {
        this.f6825E = lineBloomDirection;
        return this;
    }

    public PolylineOptions lineCapType(LineCapType lineCapType) {
        this.f6843q = lineCapType;
        return this;
    }

    public PolylineOptions lineDirectionCross180(LineDirectionCross180 lineDirectionCross180) {
        this.f6851y = lineDirectionCross180;
        return this;
    }

    public PolylineOptions lineJoinType(LineJoinType lineJoinType) {
        this.f6842p = lineJoinType;
        return this;
    }

    public PolylineOptions points(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.f6828b = list;
        return this;
    }

    public PolylineOptions setBloomBlurTimes(int i4) {
        if (i4 < 1) {
            i4 = 1;
        }
        if (i4 > 10) {
            i4 = 10;
        }
        this.f6822B = i4;
        return this;
    }

    public PolylineOptions setBloomGradientASpeed(float f4) {
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        if (f4 > 10.0f) {
            f4 = 10.0f;
        }
        this.f6821A = f4;
        return this;
    }

    public PolylineOptions setHighPrecision(boolean z4) {
        this.f6826F = z4;
        return this;
    }

    public PolylineOptions smoothAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.f6847u = thinAndSmoothAlgorithm;
        return this;
    }

    public PolylineOptions smoothFactor(float f4) {
        if (f4 > Property.DEFAULT_FLOAT_VALUE) {
            this.f6848v = f4;
        }
        return this;
    }

    public PolylineOptions textureIndex(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: index list can not contains null");
        }
        this.f6829c = list;
        return this;
    }

    public PolylineOptions thinAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.f6845s = thinAndSmoothAlgorithm;
        return this;
    }

    public PolylineOptions thinFactor(float f4) {
        if (f4 > Property.DEFAULT_FLOAT_VALUE) {
            this.f6846t = f4;
        }
        return this;
    }

    public PolylineOptions visible(boolean z4) {
        this.f6837k = z4;
        return this;
    }

    public PolylineOptions width(int i4) {
        if (i4 > 0) {
            this.f6831e = i4;
        }
        return this;
    }

    public PolylineOptions zIndex(int i4) {
        this.f6836j = i4;
        return this;
    }
}
