package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.f;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmBaseLine;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmGradientLine;
import com.baidu.platform.comapi.bmsdk.BmPolyline;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyleOption;
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class Polyline extends Overlay {

    /* renamed from: C, reason: collision with root package name */
    int f6782C;

    /* renamed from: D, reason: collision with root package name */
    int f6783D;

    /* renamed from: I, reason: collision with root package name */
    private BmBaseLine f6788I;

    /* renamed from: J, reason: collision with root package name */
    private BmLineStyle f6789J;

    /* renamed from: K, reason: collision with root package name */
    private BmGeoElement f6790K;

    /* renamed from: N, reason: collision with root package name */
    Animation f6793N;

    /* renamed from: g, reason: collision with root package name */
    int f6798g;

    /* renamed from: h, reason: collision with root package name */
    List<LatLng> f6799h;

    /* renamed from: i, reason: collision with root package name */
    int[] f6800i;

    /* renamed from: j, reason: collision with root package name */
    int[] f6801j;

    /* renamed from: k, reason: collision with root package name */
    List<Integer> f6802k;

    /* renamed from: q, reason: collision with root package name */
    BitmapDescriptor f6808q;

    /* renamed from: r, reason: collision with root package name */
    BmBitmapResource f6809r;

    /* renamed from: s, reason: collision with root package name */
    List<BitmapDescriptor> f6810s;

    /* renamed from: t, reason: collision with root package name */
    List<BmBitmapResource> f6811t;

    /* renamed from: l, reason: collision with root package name */
    int f6803l = 5;

    /* renamed from: m, reason: collision with root package name */
    boolean f6804m = false;

    /* renamed from: n, reason: collision with root package name */
    boolean f6805n = false;

    /* renamed from: o, reason: collision with root package name */
    boolean f6806o = true;

    /* renamed from: p, reason: collision with root package name */
    boolean f6807p = true;

    /* renamed from: u, reason: collision with root package name */
    int f6812u = 0;

    /* renamed from: v, reason: collision with root package name */
    boolean f6813v = true;

    /* renamed from: w, reason: collision with root package name */
    ThinAndSmoothAlgorithm f6814w = ThinAndSmoothAlgorithm.DOUGLAS_PEUCKER;

    /* renamed from: x, reason: collision with root package name */
    float f6815x = 4.0f;

    /* renamed from: y, reason: collision with root package name */
    ThinAndSmoothAlgorithm f6816y = ThinAndSmoothAlgorithm.BEZIER_SMOOTH;

    /* renamed from: z, reason: collision with root package name */
    float f6817z = 16.0f;

    /* renamed from: A, reason: collision with root package name */
    boolean f6780A = false;

    /* renamed from: B, reason: collision with root package name */
    boolean f6781B = false;

    /* renamed from: E, reason: collision with root package name */
    float f6784E = 5.0f;

    /* renamed from: F, reason: collision with root package name */
    int f6785F = 1;

    /* renamed from: G, reason: collision with root package name */
    boolean f6786G = false;

    /* renamed from: H, reason: collision with root package name */
    LineBloomDirection f6787H = LineBloomDirection.BloomAround;

    /* renamed from: L, reason: collision with root package name */
    private List<BmGeoElement> f6791L = null;

    /* renamed from: M, reason: collision with root package name */
    private List<BmLineStyle> f6792M = null;

    /* renamed from: O, reason: collision with root package name */
    PolylineOptions.LineCapType f6794O = PolylineOptions.LineCapType.LineCapButt;

    /* renamed from: P, reason: collision with root package name */
    PolylineOptions.LineJoinType f6795P = PolylineOptions.LineJoinType.LineJoinRound;

    /* renamed from: Q, reason: collision with root package name */
    PolylineOptions.LineDirectionCross180 f6796Q = PolylineOptions.LineDirectionCross180.NONE;

    /* renamed from: R, reason: collision with root package name */
    PolylineOptions.LineBloomType f6797R = PolylineOptions.LineBloomType.NONE;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6818a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f6819b;

        static {
            int[] iArr = new int[PolylineOptions.LineCapType.values().length];
            f6819b = iArr;
            try {
                iArr[PolylineOptions.LineCapType.LineCapButt.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6819b[PolylineOptions.LineCapType.LineCapRound.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PolylineOptions.LineJoinType.values().length];
            f6818a = iArr2;
            try {
                iArr2[PolylineOptions.LineJoinType.LineJoinBevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6818a[PolylineOptions.LineJoinType.LineJoinMiter.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6818a[PolylineOptions.LineJoinType.LineJoinRound.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public Polyline() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.polyline;
    }

    private static void a(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
        bundle.putInt("total", 1);
    }

    private Bundle b(boolean z4, String str) {
        if (z4) {
            Bundle bundle = new Bundle();
            bundle.putInt("total", 1);
            int i4 = this.f6812u;
            String str2 = i4 == 1 ? "CircleDashTexture.png" : i4 == 2 ? "lineDash_Rectangle.png" : "lineDashTexture.png";
            if (str == null) {
                str = str2;
            }
            BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset(str);
            if (bitmapDescriptorFromAsset != null) {
                bundle.putBundle("texture_0", bitmapDescriptorFromAsset.a());
            }
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        int i5 = 0;
        for (int i6 = 0; i6 < this.f6810s.size(); i6++) {
            if (this.f6810s.get(i6) != null) {
                bundle2.putBundle("texture_" + String.valueOf(i5), this.f6810s.get(i6).a());
                i5++;
            }
        }
        bundle2.putInt("total", i5);
        return bundle2;
    }

    private static void c(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_indexs", iArr);
    }

    private static void d(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("traffic_array", iArr);
    }

    public void cancelAnimation() {
        if (this.f6793N == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6793N.bmAnimation.cancel();
        this.f6723f.b();
    }

    public int getBloomAlpha() {
        return this.f6783D;
    }

    public int getBloomBlurTimes() {
        return this.f6785F;
    }

    public float getBloomGradientASpeed() {
        return this.f6784E;
    }

    public int getBloomWidth() {
        int i4 = this.f6782C;
        return i4 == 0 ? this.f6803l * 2 : i4;
    }

    public int getColor() {
        return this.f6798g;
    }

    public int[] getColorList() {
        return this.f6801j;
    }

    public int getDottedLineType() {
        return this.f6812u;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem getDrawItem() {
        return this.f6788I;
    }

    public PolylineOptions.LineBloomType getLineBloomType() {
        return this.f6797R;
    }

    public PolylineOptions.LineCapType getLineCapType() {
        return this.f6794O;
    }

    public PolylineOptions.LineDirectionCross180 getLineDirectionCross180() {
        return this.f6796Q;
    }

    public PolylineOptions.LineJoinType getLineJoinType() {
        return this.f6795P;
    }

    public List<LatLng> getPoints() {
        return this.f6799h;
    }

    public BitmapDescriptor getTexture() {
        return this.f6808q;
    }

    public int getWidth() {
        return this.f6803l;
    }

    public boolean isClickable() {
        return this.f6807p;
    }

    public boolean isDottedLine() {
        return this.f6804m;
    }

    public boolean isFocus() {
        return this.f6805n;
    }

    public boolean isGeodesic() {
        return this.f6780A;
    }

    public boolean isGradient() {
        return this.f6781B;
    }

    public boolean isIsKeepScale() {
        return this.f6806o;
    }

    public boolean isThined() {
        return this.f6813v;
    }

    public void pauseAnimation() {
        if (this.f6793N == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6793N.bmAnimation.pause();
        this.f6723f.b();
    }

    public void resumeAnimation() {
        if (this.f6793N == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6793N.bmAnimation.resume();
        this.f6723f.b();
    }

    public void setAnimation(Animation animation) {
        BmAnimation bmAnimation;
        if (animation == null) {
            return;
        }
        this.f6793N = animation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.f6793N.bmAnimation) == null) {
            return;
        }
        this.f6788I.a(bmAnimation);
        this.f6723f.b();
    }

    public void setBloomAlpha(int i4) {
        if (i4 > 255 || i4 < 0) {
            i4 = 255;
        }
        this.f6783D = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.f6788I.b(i4);
            this.f6723f.b();
        }
    }

    public void setBloomBlurTimes(int i4) {
        if (i4 > 10) {
            i4 = 10;
        }
        if (i4 < 1) {
            i4 = 1;
        }
        this.f6785F = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.f6788I.e(i4);
            this.f6723f.b();
        }
    }

    public void setBloomGradientASpeed(float f4) {
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        if (f4 > 10.0f) {
            f4 = 10.0f;
        }
        this.f6784E = f4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.f6788I.c(f4);
            this.f6723f.b();
        }
    }

    public void setBloomWidth(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        this.f6782C = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.f6788I.d(i4);
            this.f6723f.b();
        }
    }

    public void setClickable(boolean z4) {
        this.f6807p = z4;
        this.listener.c(this);
    }

    public void setColor(int i4) {
        this.f6798g = i4;
        this.listener.c(this);
    }

    public void setColorList(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
        }
        this.f6801j = iArr;
    }

    public void setDottedLine(boolean z4) {
        this.f6804m = z4;
        this.listener.c(this);
    }

    public void setDottedLineType(PolylineDottedLineType polylineDottedLineType) {
        this.f6812u = polylineDottedLineType.ordinal();
        this.listener.c(this);
    }

    public void setFocus(boolean z4) {
        this.f6805n = z4;
        this.listener.c(this);
    }

    public void setGeodesic(boolean z4) {
        this.f6780A = z4;
        this.listener.c(this);
    }

    public void setGradient(boolean z4) {
        this.f6781B = z4;
        this.listener.c(this);
    }

    public void setIndexs(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
        }
        this.f6800i = iArr;
    }

    public void setIsKeepScale(boolean z4) {
        this.f6806o = z4;
    }

    public void setLineBloomDirection(LineBloomDirection lineBloomDirection) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6787H = lineBloomDirection;
            this.f6788I.h(lineBloomDirection.ordinal());
            this.f6723f.b();
        }
    }

    public void setLineBloomType(PolylineOptions.LineBloomType lineBloomType) {
        this.f6797R = lineBloomType;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.f6788I.i(lineBloomType.ordinal());
            this.f6723f.b();
        }
    }

    public void setLineCapType(PolylineOptions.LineCapType lineCapType) {
        this.f6794O = lineCapType;
        this.listener.c(this);
    }

    public void setLineDirectionCross180(PolylineOptions.LineDirectionCross180 lineDirectionCross180) {
        this.f6796Q = lineDirectionCross180;
    }

    public void setLineJoinType(PolylineOptions.LineJoinType lineJoinType) {
        this.f6795P = lineJoinType;
        this.listener.c(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2 or more than 10000");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.f6799h = list;
        this.listener.c(this);
    }

    public void setSmoothAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.f6816y = thinAndSmoothAlgorithm;
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6788I.k(this.f6816y.getValue());
            this.f6723f.b();
        }
    }

    public void setSmoothFactor(float f4) {
        if (f4 > Property.DEFAULT_FLOAT_VALUE) {
            this.f6817z = f4;
        }
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6788I.e(this.f6817z);
            this.f6723f.b();
        }
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        this.f6808q = bitmapDescriptor;
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6809r = new BmBitmapResource(bitmapDescriptor.getBitmap());
        }
        this.listener.c(this);
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
        }
        this.f6810s = list;
        if (OverlayUtil.isOverlayUpgrade()) {
            for (int i4 = 0; i4 < this.f6810s.size(); i4++) {
                if (this.f6811t == null) {
                    this.f6811t = new ArrayList();
                }
                this.f6811t.add(new BmBitmapResource(this.f6810s.get(i4).getBitmap()));
            }
        }
    }

    public void setThinAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.f6814w = thinAndSmoothAlgorithm;
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6788I.m(this.f6814w.getValue());
            this.f6723f.b();
        }
    }

    public void setThinFactor(float f4) {
        if (f4 > Property.DEFAULT_FLOAT_VALUE) {
            this.f6815x = f4;
        }
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6788I.f(this.f6815x);
            this.f6723f.b();
        }
    }

    public void setThined(boolean z4) {
        this.f6813v = z4;
        this.listener.c(this);
    }

    public void setTrackBackwardStyle(LineStyle lineStyle) {
        if (lineStyle != null && OverlayUtil.isOverlayUpgrade()) {
            this.f6790K.a(new BmLineStyleOption(256, lineStyle.f6494a));
            this.f6723f.b();
        }
    }

    public void setTrackBackwardStyles(List<LineStyle> list) {
        if (list == null || list.isEmpty() || !OverlayUtil.isOverlayUpgrade() || this.f6791L == null || list.size() != this.f6791L.size()) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f6791L.get(i4).a(new BmLineStyleOption(256, list.get(i4).f6494a));
        }
        this.f6723f.b();
    }

    public void setTrackForwardStyle(LineStyle lineStyle) {
        if (lineStyle != null && OverlayUtil.isOverlayUpgrade()) {
            this.f6790K.a(new BmLineStyleOption(128, lineStyle.f6494a));
            this.f6723f.b();
        }
    }

    public void setTrackForwardStyles(List<LineStyle> list) {
        if (list == null || list.isEmpty() || !OverlayUtil.isOverlayUpgrade() || this.f6791L == null || list.size() != this.f6791L.size()) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f6791L.get(i4).a(new BmLineStyleOption(128, list.get(i4).f6494a));
        }
        this.f6723f.b();
    }

    public void setWidth(int i4) {
        if (i4 > 0) {
            this.f6803l = i4;
            this.listener.c(this);
        }
    }

    public void startAnimation() {
        if (this.f6793N == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6793N.bmAnimation.start();
        this.f6723f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        int[] iArr;
        if (this.f6781B) {
            this.f6788I = new BmGradientLine();
        } else {
            this.f6788I = new BmPolyline();
        }
        this.f6788I.a(this);
        setDrawItem(this.f6788I);
        super.toDrawItem();
        List<LatLng> list = this.f6799h;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add Polyline, you must at least supply 2 points");
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        List<LatLng> listB = (this.f6780A && this.f6799h.size() == 2) ? f.b(this.f6799h.get(0), this.f6799h.get(1)) : this.f6799h;
        Bundle bundle = new Bundle();
        a(listB, this.f6796Q, bundle);
        if (bundle.containsKey("x_array") && bundle.containsKey("y_array")) {
            double[] doubleArray = bundle.getDoubleArray("x_array");
            double[] doubleArray2 = bundle.getDoubleArray("y_array");
            for (int i5 = 0; i5 < doubleArray.length; i5++) {
                arrayList.add(new com.baidu.platform.comapi.bmsdk.b(doubleArray[i5], doubleArray2[i5]));
            }
        }
        BmGeoElement bmGeoElement = new BmGeoElement(0);
        this.f6790K = bmGeoElement;
        bmGeoElement.a(arrayList);
        BmLineStyle bmLineStyle = new BmLineStyle();
        this.f6789J = bmLineStyle;
        bmLineStyle.d(this.f6803l);
        this.f6788I.c(this.f6786G);
        this.f6788I.g(a(this.f6795P));
        this.f6788I.l(a(this.f6794O));
        this.f6788I.f(a(this.f6794O));
        this.f6788I.i(this.f6797R.ordinal());
        this.f6788I.d(this.f6782C / 2.0f);
        this.f6788I.h(this.f6787H.ordinal());
        this.f6788I.d(this.f6782C / 2);
        this.f6788I.b(this.f6783D);
        this.f6788I.e(this.f6785F);
        this.f6788I.c(this.f6784E);
        this.f6788I.j(this.f6796Q.ordinal());
        this.f6788I.a(this.f6807p);
        this.f6802k = new ArrayList();
        if (this.f6781B && (iArr = this.f6801j) != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.f6801j;
                if (i4 >= iArr2.length) {
                    break;
                }
                this.f6802k.add(Integer.valueOf(iArr2[i4]));
                i4++;
            }
            for (int size = this.f6802k.size(); size < this.f6799h.size(); size++) {
                List<Integer> list2 = this.f6802k;
                list2.add(list2.get(list2.size() - 1));
            }
            this.f6790K.a(1, this.f6802k);
            this.f6790K.a(this.f6789J);
            this.f6788I.a(this.f6790K);
            return this.f6788I;
        }
        if (this.f6780A) {
            this.f6813v = false;
            this.f6781B = false;
        }
        if (this.f6813v) {
            this.f6788I.m(this.f6814w.getValue());
            float f4 = this.f6815x;
            if (f4 > Property.DEFAULT_FLOAT_VALUE) {
                this.f6788I.f(f4);
            }
            if (this.f6797R == PolylineOptions.LineBloomType.NONE) {
                this.f6788I.k(this.f6816y.getValue());
                this.f6788I.e(this.f6817z);
            }
        }
        if (this.f6804m) {
            setDottedBitmapResource(this.f6789J, this.f6812u);
            this.f6789J.c(5);
        } else {
            this.f6789J.b(0);
        }
        List<BmBitmapResource> list3 = this.f6811t;
        if (list3 != null && !list3.isEmpty()) {
            this.f6791L = new ArrayList();
            this.f6792M = new ArrayList();
            int[] iArr3 = this.f6800i;
            if (iArr3 == null || iArr3.length == 0 || iArr3.length != this.f6799h.size() - 1) {
                this.f6789J.a(this.f6811t.get(0));
                this.f6789J.d(this.f6803l);
                this.f6790K.a(this.f6789J);
                this.f6788I.a(this.f6790K);
            } else {
                int i6 = this.f6800i[0];
                while (i4 < this.f6800i.length) {
                    int i7 = i4;
                    while (true) {
                        int[] iArr4 = this.f6800i;
                        if (i7 >= iArr4.length || i6 != iArr4[i7]) {
                            break;
                        }
                        i7++;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (int i8 = i4; i8 <= i7; i8++) {
                        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6799h.get(i8));
                        arrayList2.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
                    }
                    BmGeoElement bmGeoElement2 = new BmGeoElement();
                    BmLineStyle bmLineStyle2 = new BmLineStyle();
                    bmLineStyle2.d(this.f6803l);
                    bmLineStyle2.a(this.f6811t.get(this.f6800i[i4]));
                    bmGeoElement2.a(bmLineStyle2);
                    bmGeoElement2.a(arrayList2);
                    this.f6791L.add(bmGeoElement2);
                    this.f6788I.a(bmGeoElement2);
                    this.f6792M.add(bmLineStyle2);
                    int[] iArr5 = this.f6800i;
                    if (i7 < iArr5.length) {
                        i6 = iArr5[i7];
                    }
                    i4 = i7;
                }
            }
        } else if (this.f6801j != null) {
            int i9 = 0;
            while (true) {
                int[] iArr6 = this.f6801j;
                if (i9 >= iArr6.length) {
                    break;
                }
                this.f6802k.add(Integer.valueOf(iArr6[i9]));
                i9++;
            }
            for (int size2 = this.f6802k.size(); size2 < this.f6799h.size(); size2++) {
                List<Integer> list4 = this.f6802k;
                list4.add(list4.get(list4.size() - 1));
            }
            ArrayList arrayList3 = new ArrayList();
            this.f6791L = new ArrayList();
            this.f6792M = new ArrayList();
            for (int i10 = 1; i10 < this.f6799h.size(); i10++) {
                ArrayList arrayList4 = new ArrayList();
                GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.f6799h.get(i10 - 1));
                GeoPoint geoPointLl2mc3 = CoordUtil.ll2mc(this.f6799h.get(i10));
                com.baidu.platform.comapi.bmsdk.b bVar = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6());
                com.baidu.platform.comapi.bmsdk.b bVar2 = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc3.getLongitudeE6(), geoPointLl2mc3.getLatitudeE6());
                arrayList4.add(bVar);
                arrayList4.add(bVar2);
                arrayList3.add(arrayList4);
            }
            while (i4 < arrayList3.size()) {
                BmGeoElement bmGeoElement3 = new BmGeoElement();
                BmLineStyle bmLineStyle3 = new BmLineStyle();
                bmLineStyle3.d(this.f6803l);
                if (this.f6804m) {
                    setDottedBitmapResource(bmLineStyle3, this.f6812u);
                    bmLineStyle3.c(5);
                }
                bmLineStyle3.a(this.f6802k.get(i4).intValue());
                bmGeoElement3.a(bmLineStyle3);
                bmGeoElement3.a((List<com.baidu.platform.comapi.bmsdk.b>) arrayList3.get(i4));
                this.f6791L.add(bmGeoElement3);
                this.f6792M.add(bmLineStyle3);
                this.f6788I.a(bmGeoElement3);
                i4++;
            }
        } else {
            if (this.f6808q != null) {
                this.f6789J.a(this.f6809r);
            } else {
                this.f6789J.d(this.f6803l);
                this.f6789J.a(this.f6798g);
            }
            this.f6790K.a(this.f6789J);
            this.f6788I.a(this.f6790K);
        }
        return this.f6788I;
    }

    private static int a(PolylineOptions.LineJoinType lineJoinType) {
        int i4 = a.f6818a[lineJoinType.ordinal()];
        if (i4 == 1) {
            return 2048;
        }
        if (i4 != 2) {
            return i4 != 3 ? 2048 : 4096;
        }
        return 8192;
    }

    private static int a(PolylineOptions.LineCapType lineCapType) {
        int i4 = a.f6819b[lineCapType.ordinal()];
        return (i4 == 1 || i4 != 2) ? 2 : 4;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        List<LatLng> list = this.f6799h;
        if (list != null && list.size() >= 2) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6799h.get(0));
            bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
            bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
            bundle.putInt("width", this.f6803l);
            bundle.putInt("isClickable", this.f6807p ? 1 : 0);
            bundle.putInt("lineBloomType", this.f6797R.ordinal());
            bundle.putInt("lineBloomWidth", this.f6782C);
            bundle.putInt("lineBloomAlpha", this.f6783D);
            bundle.putFloat("lineBloomGradientASPeed", this.f6784E);
            bundle.putInt("lineBloomBlurTimes", this.f6785F);
            bundle.putInt("isHighPrecision", this.f6786G ? 1 : 0);
            if (this.f6781B) {
                return b(bundle);
            }
            if (this.f6780A && this.f6799h.size() == 2) {
                this.f6799h = f.b(this.f6799h.get(0), this.f6799h.get(1));
            }
            a(this.f6799h, this.f6796Q, bundle);
            Overlay.d(this.f6798g, bundle);
            d(this.f6800i, bundle);
            a(this.f6801j, bundle);
            int[] iArr = this.f6800i;
            if (iArr != null && iArr.length > 0 && iArr.length > this.f6799h.size() - 1) {
                Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
            }
            bundle.putInt("dotline", this.f6804m ? 1 : 0);
            bundle.putInt("focus", this.f6805n ? 1 : 0);
            if (this.f6780A) {
                this.f6813v = false;
                this.f6781B = false;
            }
            bundle.putInt("isThined", this.f6813v ? 1 : 0);
            bundle.putInt("isGradient", this.f6781B ? 1 : 0);
            bundle.putInt("lineJoinType", this.f6795P.ordinal());
            bundle.putInt("lineCapType", this.f6794O.ordinal());
            bundle.putInt("lineDirectionCross180", this.f6796Q.ordinal());
            try {
                String str = "line_texture.png";
                if (this.f6808q != null) {
                    bundle.putInt(SchedulerSupport.CUSTOM, 1);
                    bundle.putBundle("image_info", a(false, (String) null));
                } else {
                    if (this.f6804m) {
                        bundle.putBundle("image_info", a(true, (String) null));
                        bundle.putInt("dotted_line_type", this.f6812u);
                    } else {
                        bundle.putBundle("image_info", a(true, "line_texture.png"));
                    }
                    bundle.putInt(SchedulerSupport.CUSTOM, 0);
                }
                if (this.f6810s != null) {
                    bundle.putInt("customlist", 1);
                    bundle.putBundle("image_info_list", b(false, (String) null));
                    bundle.putInt("dotline", 0);
                } else {
                    if (this.f6804m) {
                        str = null;
                    }
                    int[] iArr2 = this.f6801j;
                    if (iArr2 != null && iArr2.length > 0) {
                        bundle.putBundle("image_info_list", b(true, str));
                    } else {
                        BitmapDescriptor bitmapDescriptor = this.f6808q;
                        if (bitmapDescriptor != null) {
                            bundle.putBundle("image_info", bitmapDescriptor.a());
                            bundle.putInt("dotline", 0);
                        } else {
                            bundle.putBundle("image_info", a(true, str));
                        }
                    }
                    bundle.putInt("customlist", 0);
                }
                bundle.putInt("keep", this.f6806o ? 1 : 0);
            } catch (Exception unused) {
                Log.e("baidumapsdk", "load texture resource failed!");
                bundle.putInt("dotline", 0);
            }
            return bundle;
        }
        throw new IllegalStateException("BDMapSDKException: when you add Polyline, you must at least supply 2 points");
    }

    private Bundle b(Bundle bundle) {
        int[] iArr = this.f6801j;
        if (iArr != null) {
            if (iArr.length != 0) {
                b(iArr, bundle);
                a(this.f6799h, this.f6796Q, bundle);
                int length = this.f6801j.length;
                int[] iArr2 = new int[length];
                for (int i4 = 0; i4 < length; i4++) {
                    iArr2[i4] = i4;
                }
                if (this.f6799h.size() == this.f6801j.length) {
                    iArr2[r3.length - 1] = r3.length - 2;
                }
                c(iArr2, bundle);
                return bundle;
            }
            throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
        }
        throw new IllegalStateException("BDMapSDKException: colors array can not be null");
    }

    private static void b(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
    }

    private Bundle a(boolean z4, String str) {
        if (z4) {
            int i4 = this.f6812u;
            String str2 = i4 == 1 ? "CircleDashTexture.png" : i4 == 2 ? "lineDash_Rectangle.png" : "lineDashTexture.png";
            if (str == null) {
                str = str2;
            }
            BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset(str);
            if (bitmapDescriptorFromAsset != null) {
                return bitmapDescriptorFromAsset.a();
            }
        }
        return this.f6808q.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.util.List<com.baidu.mapapi.model.LatLng> r12, com.baidu.mapapi.map.PolylineOptions.LineDirectionCross180 r13, android.os.Bundle r14) {
        /*
            int r0 = r12.size()
            double[] r1 = new double[r0]
            double[] r2 = new double[r0]
            r3 = 0
        L9:
            if (r3 >= r0) goto L52
            java.lang.Object r4 = r12.get(r3)
            com.baidu.mapapi.model.LatLng r4 = (com.baidu.mapapi.model.LatLng) r4
            com.baidu.mapapi.map.PolylineOptions$LineDirectionCross180 r5 = com.baidu.mapapi.map.PolylineOptions.LineDirectionCross180.FROM_EAST_TO_WEST
            r6 = 4645040803167600640(0x4076800000000000, double:360.0)
            r8 = 0
            if (r13 != r5) goto L2c
            double r10 = r4.longitude
            int r5 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r5 >= 0) goto L2c
            com.baidu.mapapi.model.LatLng r5 = new com.baidu.mapapi.model.LatLng
            double r8 = r4.latitude
            double r10 = r10 + r6
            r5.<init>(r8, r10)
        L2a:
            r4 = r5
            goto L3f
        L2c:
            com.baidu.mapapi.map.PolylineOptions$LineDirectionCross180 r5 = com.baidu.mapapi.map.PolylineOptions.LineDirectionCross180.FROM_WEST_TO_EAST
            if (r13 != r5) goto L3f
            double r10 = r4.longitude
            int r5 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r5 <= 0) goto L3f
            com.baidu.mapapi.model.LatLng r5 = new com.baidu.mapapi.model.LatLng
            double r8 = r4.latitude
            double r10 = r10 - r6
            r5.<init>(r8, r10)
            goto L2a
        L3f:
            com.baidu.platform.comapi.basestruct.GeoPoint r4 = com.baidu.mapapi.model.CoordUtil.ll2mc(r4)
            double r5 = r4.getLongitudeE6()
            r1[r3] = r5
            double r4 = r4.getLatitudeE6()
            r2[r3] = r4
            int r3 = r3 + 1
            goto L9
        L52:
            java.lang.String r12 = "x_array"
            r14.putDoubleArray(r12, r1)
            java.lang.String r12 = "y_array"
            r14.putDoubleArray(r12, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.Polyline.a(java.util.List, com.baidu.mapapi.map.PolylineOptions$LineDirectionCross180, android.os.Bundle):void");
    }
}
