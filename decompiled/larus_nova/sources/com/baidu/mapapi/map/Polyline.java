package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.animation.Animation;
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
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class Polyline extends Overlay {
    ThinAndSmoothAlgorithm A;
    float B;
    boolean C;
    boolean D;
    int E;
    int F;
    float G;
    int H;
    boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f31257J;
    LineBloomDirection K;
    private BmBaseLine L;
    private BmLineStyle M;
    private BmGeoElement N;
    private List<BmGeoElement> O;
    private List<BmLineStyle> P;
    Animation Q;
    PolylineOptions.LineCapType R;
    PolylineOptions.LineJoinType S;
    PolylineOptions.LineDirectionCross180 T;
    PolylineOptions.LineBloomType U;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f31258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    List<LatLng> f31259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int[] f31260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    List<Integer> f31261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int[] f31262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    List<Integer> f31263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    WidthType f31264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float f31265n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f31266o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f31267p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f31268q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f31269r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    BitmapDescriptor f31270s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    BmBitmapResource f31271t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    List<BitmapDescriptor> f31272u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    List<BmBitmapResource> f31273v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f31274w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f31275x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    ThinAndSmoothAlgorithm f31276y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    float f31277z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31278a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f31279b = null;

        static {
            int[] r100 = new int[PolylineOptions.LineCapType.values().length];
            f31279b = r100;
            r100[PolylineOptions.LineCapType.LineCapButt.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            f31279b[PolylineOptions.LineCapType.LineCapRound.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            f31279b[PolylineOptions.LineCapType.LineCapSQUARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r101 = new int[PolylineOptions.LineJoinType.values().length];
            f31278a = r101;
            r101[PolylineOptions.LineJoinType.LineJoinBevel.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            f31278a[PolylineOptions.LineJoinType.LineJoinMiter.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            f31278a[PolylineOptions.LineJoinType.LineJoinRound.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    public void cancelAnimation() {
        if (this.Q != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.Q.bmAnimation.cancel();
        this.f31207f.b();
        return;
    }

    public int getBloomWidth() {
        int r100 = this.E;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return (int) (this.f31265n * 2.0f);
    }

    public int getWidth() {
        return (int) this.f31265n;
    }

    public void pauseAnimation() {
        if (this.Q != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.Q.bmAnimation.pause();
        this.f31207f.b();
        return;
    }

    public void resumeAnimation() {
        if (this.Q != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.Q.bmAnimation.resume();
        this.f31207f.b();
        return;
    }

    public void startAnimation() {
        if (this.Q != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.Q.bmAnimation.start();
        this.f31207f.b();
        return;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        if (this.D == false) goto L5;
        this.L = new BmGradientLine();
    L6:
        this.L.a(this);
        setDrawItem(this.L);
        super.toDrawItem();
        List<LatLng> r100 = this.f31259h;
        if (r100 == null) goto L101;
        if (r100.size() < 2) goto L101;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
        int r103 = 1;
        if (this.C == true) goto L13;
    L15:
        List<LatLng> r104 = this.f31259h;
    L16:
        a(r104, r101, this.T);
        this.L.c(this.I);
        this.L.i(a(this.S));
        this.L.n(a(this.R));
        this.L.h(a(this.R));
        this.L.k(this.U.ordinal());
        this.L.d(this.E / 2.0f);
        this.L.j(this.K.ordinal());
        this.L.d(this.E / 2);
        this.L.b(this.F);
        this.L.e(this.H);
        this.L.c(this.G);
        this.L.l(this.T.ordinal());
        this.L.a(this.f31269r);
        if (this.f31257J == false) goto L20;
        this.L.g(1);
        this.L.f(CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber());
    L20:
        if (this.D == false) goto L36;
        int[] r105 = this.f31262k;
        if (r105 == null) goto L36;
        if (r105.length <= 0) goto L36;
        BmGeoElement r106 = new BmGeoElement(0);
        this.N = r106;
        r106.a(r101);
        this.f31263l = new ArrayList();
    L27:
        if (r102 >= Math.min(this.f31259h.size(), this.f31262k.length)) goto L29;
        this.f31263l.add(Integer.valueOf(this.f31262k[r102]));
        r102 = r102 + 1;
        goto L27
    L29:
        int r107 = this.f31263l.size();
    L31:
        if (r107 >= this.f31259h.size()) goto L33;
        List<Integer> r108 = this.f31263l;
        r108.add((Integer) ListProtector.get(r108, r108.size() - 1));
        r107 = r107 + 1;
        goto L31
    L33:
        this.N.a(1, this.f31263l);
        BmLineStyle r109 = new BmLineStyle();
        this.M = r109;
        r109.d(this.f31264m.ordinal());
        this.M.a(this.f31265n);
        this.N.a(this.M);
        this.L.a(this.N);
        return this.L;
    L36:
        if (this.C == false) goto L39;
        this.f31275x = false;
        this.D = false;
    L39:
        if (this.f31275x == false) goto L46;
        this.L.o(this.f31276y.getValue());
        float r110 = this.f31277z;
        if (r110 <= 0.0f) goto L44;
        this.L.f(r110);
    L44:
        if (this.U != PolylineOptions.LineBloomType.NONE) goto L46;
        this.L.m(this.A.getValue());
        this.L.e(this.B);
    L46:
        List<BitmapDescriptor> r111 = this.f31272u;
        if (r111 == null) goto L72;
        if (r111.isEmpty() == true) goto L72;
        this.O = new ArrayList();
        this.P = new ArrayList();
        this.f31273v = new ArrayList();
        int r112 = this.f31259h.size() - 1;
        this.f31261j = new ArrayList();
        int r113 = 0;
    L52:
        if (r113 >= Math.min(r112, this.f31260i.length)) goto L54;
        this.f31261j.add(Integer.valueOf(this.f31260i[r113]));
        r113 = r113 + 1;
        goto L52
    L54:
        int r114 = this.f31261j.size();
    L55:
        if (r114 >= r112) goto L57;
        List<Integer> r115 = this.f31261j;
        r115.add((Integer) ListProtector.get(r115, r115.size() - 1));
        r114 = r114 + 1;
        goto L55
    L57:
        int r116 = ((Integer) ListProtector.get(this.f31261j, 0)).intValue();
    L58:
        if (r102 >= r112) goto L99;
        int r117 = r102;
    L60:
        if (r117 >= r112) goto L64;
        if (r116 != ((Integer) ListProtector.get(this.f31261j, r117)).intValue()) goto L64;
        r117 = r117 + 1;
    L64:
        ArrayList r118 = new ArrayList();
    L65:
        if (r102 > r117) goto L67;
        r118.add(ListProtector.get(r101, r102));
        r102 = r102 + 1;
        goto L65
    L67:
        BmGeoElement r119 = new BmGeoElement();
        BmLineStyle r120 = new BmLineStyle();
        r120.d(this.f31264m.ordinal());
        r120.a(this.f31265n);
        BmBitmapResource r121 = new BmBitmapResource(((BitmapDescriptor) ListProtector.get(this.f31272u, r116)).getBitmap());
        this.f31273v.add(r121);
        r120.a(r121);
        r120.c(5);
        r119.a(r120);
        r119.a(r118);
        this.O.add(r119);
        this.L.a(r119);
        this.P.add(r120);
        if (r117 >= r112) goto L70;
        r116 = ((Integer) ListProtector.get(this.f31261j, r117)).intValue();
    L70:
        r102 = r117;
    L99:
        return this.L;
    L72:
        if (this.f31262k == null) goto L91;
        this.f31263l = new ArrayList();
        int r122 = 0;
    L75:
        if (r122 >= Math.min(this.f31259h.size() - 1, this.f31262k.length)) goto L77;
        this.f31263l.add(Integer.valueOf(this.f31262k[r122]));
        r122 = r122 + 1;
        goto L75
    L77:
        int r123 = this.f31263l.size();
    L79:
        if (r123 >= (this.f31259h.size() - 1)) goto L81;
        List<Integer> r124 = this.f31263l;
        r124.add((Integer) ListProtector.get(r124, r124.size() - 1));
        r123 = r123 + 1;
        goto L79
    L81:
        ArrayList r125 = new ArrayList();
        this.O = new ArrayList();
        this.P = new ArrayList();
    L83:
        if (r103 >= this.f31259h.size()) goto L86;
        ArrayList r126 = new ArrayList();
        r126.add(ListProtector.get(r101, r103 - 1));
        r126.add(ListProtector.get(r101, r103));
        r125.add(r126);
        r103 = r103 + 1;
    L86:
        if (r102 >= r125.size()) goto L99;
        BmGeoElement r127 = new BmGeoElement();
        BmLineStyle r128 = new BmLineStyle();
        r128.d(this.f31264m.ordinal());
        r128.a(this.f31265n);
        if (this.f31266o == false) goto L90;
        setDottedBitmapResource(r128, this.f31274w);
        r128.c(5);
    L90:
        r128.a(((Integer) ListProtector.get(this.f31263l, r102)).intValue());
        r127.a(r128);
        r127.a((List) ListProtector.get(r125, r102));
        this.O.add(r127);
        this.P.add(r128);
        this.L.a(r127);
        r102 = r102 + 1;
        goto L86
    L91:
        BmGeoElement r129 = new BmGeoElement(0);
        this.N = r129;
        r129.a(r101);
        BmLineStyle r130 = new BmLineStyle();
        this.M = r130;
        r130.d(this.f31264m.ordinal());
        this.M.a(this.f31265n);
        BitmapDescriptor r131 = this.f31270s;
        if (r131 == null) goto L94;
        BmBitmapResource r132 = new BmBitmapResource(r131.getBitmap());
        this.f31271t = r132;
        this.M.a(r132);
    L97:
        this.N.a(this.M);
        this.L.a(this.N);
        goto L99
    L94:
        this.M.a(this.f31258g);
        if (this.f31266o == false) goto L97;
        setDottedBitmapResource(this.M, this.f31274w);
        this.M.c(5);
        goto L97
    L13:
        if (this.f31259h.size() != 2) goto L15;
        r104 = f.b((LatLng) ListProtector.get(this.f31259h, 0), (LatLng) ListProtector.get(this.f31259h, 1));
    L101:
        throw new IllegalStateException("BDMapSDKException: when you add Polyline, you must at least supply 2 points");
    L5:
        this.L = new BmPolyline();
        goto L6
    }

    public Polyline() {
        this.f31264m = WidthType.AdaptWidth;
        this.f31265n = 5.0f;
        this.f31266o = false;
        this.f31267p = false;
        this.f31268q = true;
        this.f31269r = true;
        this.f31274w = 0;
        this.f31275x = true;
        this.f31276y = ThinAndSmoothAlgorithm.DOUGLAS_PEUCKER;
        this.f31277z = 4.0f;
        this.A = ThinAndSmoothAlgorithm.BEZIER_SMOOTH;
        this.B = 16.0f;
        this.C = false;
        this.D = false;
        this.G = 5.0f;
        this.H = 1;
        this.I = false;
        this.f31257J = false;
        this.K = LineBloomDirection.BloomAround;
        this.O = null;
        this.P = null;
        this.R = PolylineOptions.LineCapType.LineCapButt;
        this.S = PolylineOptions.LineJoinType.LineJoinRound;
        this.T = PolylineOptions.LineDirectionCross180.NONE;
        this.U = PolylineOptions.LineBloomType.NONE;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32149i;
    }

    public int getBloomAlpha() {
        return this.F;
    }

    public int getBloomBlurTimes() {
        return this.H;
    }

    public float getBloomGradientASpeed() {
        return this.G;
    }

    public int getColor() {
        return this.f31258g;
    }

    public int[] getColorList() {
        return this.f31262k;
    }

    public int getDottedLineType() {
        return this.f31274w;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem getDrawItem() {
        return this.L;
    }

    public boolean getIsPoiCollided() {
        return this.f31257J;
    }

    public PolylineOptions.LineBloomType getLineBloomType() {
        return this.U;
    }

    public PolylineOptions.LineCapType getLineCapType() {
        return this.R;
    }

    public PolylineOptions.LineDirectionCross180 getLineDirectionCross180() {
        return this.T;
    }

    public PolylineOptions.LineJoinType getLineJoinType() {
        return this.S;
    }

    public List<LatLng> getPoints() {
        return this.f31259h;
    }

    public BitmapDescriptor getTexture() {
        return this.f31270s;
    }

    public float getWidthFloat() {
        return this.f31265n;
    }

    public WidthType getWidthType() {
        return this.f31264m;
    }

    public boolean isClickable() {
        return this.f31269r;
    }

    public boolean isDottedLine() {
        return this.f31266o;
    }

    public boolean isFocus() {
        return this.f31267p;
    }

    public boolean isGeodesic() {
        return this.C;
    }

    public boolean isGradient() {
        return this.D;
    }

    public boolean isIsKeepScale() {
        return this.f31268q;
    }

    public boolean isThined() {
        return this.f31275x;
    }

    private Bundle b(Bundle r100) {
        int[] r101 = this.f31262k;
        if (r101 == null) goto L17;
        if (r101.length == 0) goto L15;
        b(r101, r100);
        a(this.f31259h, this.T, r100);
        int r102 = this.f31262k.length;
        int[] r103 = new int[r102];
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L9;
        r103[r104] = r104;
        r104 = r104 + 1;
        goto L7
    L9:
        int r105 = this.f31259h.size();
        int[] r106 = this.f31262k;
        if (r105 != r106.length) goto L12;
        r103[r106.length - 1] = r106.length - 2;
    L12:
        c(r103, r100);
        return r100;
    L15:
        throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
    L17:
        throw new IllegalStateException("BDMapSDKException: colors array can not be null");
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r110) {
        super.a(r110);
        List<LatLng> r100 = this.f31259h;
        if (r100 == null) goto L59;
        if (r100.size() < 2) goto L59;
        GeoPoint r101 = CoordUtil.ll2mc((LatLng) ListProtector.get(this.f31259h, 0));
        r110.putDouble("location_x", r101.getLongitudeE6());
        r110.putDouble("location_y", r101.getLatitudeE6());
        r110.putInt("width", (int) this.f31265n);
        r110.putInt("isClickable", this.f31269r ? 1 : 0);
        r110.putInt("lineBloomType", this.U.ordinal());
        r110.putInt("lineBloomWidth", this.E);
        r110.putInt("lineBloomAlpha", this.F);
        r110.putFloat("lineBloomGradientASPeed", this.G);
        r110.putInt("lineBloomBlurTimes", this.H);
        r110.putInt("isHighPrecision", this.I ? 1 : 0);
        if (this.D == false) goto L11;
        return b(r110);
    L11:
        if (this.C == true) goto L13;
    L15:
        a(this.f31259h, this.T, r110);
        Overlay.d(this.f31258g, r110);
        d(this.f31260i, r110);
        a(this.f31262k, r110);
        int[] r102 = this.f31260i;
        if (r102 != null) goto L18;
    L20:
        r110.putInt("dotline", this.f31266o ? 1 : 0);
        r110.putInt(ButtonColorBean.StateFocus, this.f31267p ? 1 : 0);
        if (this.C == false) goto L23;
        this.f31275x = false;
        this.D = false;
    L23:
        r110.putInt("isThined", this.f31275x ? 1 : 0);
        r110.putInt("isGradient", this.D ? 1 : 0);
        r110.putInt("lineJoinType", this.S.ordinal());
        r110.putInt("lineCapType", this.R.ordinal());
        r110.putInt("lineDirectionCross180", this.T.ordinal());
    L56:
        r110.putInt("dotline", 0);
    L57:
        return r110;
    L25:
        String r103 = "line_texture.png";
        if (this.f31270s == null) goto L29;
        r110.putInt("custom", 1);     // Catch: Exception -> L56
        r110.putBundle("image_info", a(false, null));     // Catch: Exception -> L56
    L37:
        if (this.f31272u == null) goto L40;
        r110.putInt("customlist", 1);     // Catch: Exception -> L56
        r110.putBundle("image_info_list", b(false, null));     // Catch: Exception -> L56
        r110.putInt("dotline", 0);     // Catch: Exception -> L56
    L54:
        r110.putInt("keep", this.f31268q ? 1 : 0);     // Catch: Exception -> L56
        goto L57
    L40:
        if (this.f31266o == false) goto L43;
        r103 = null;
    L43:
        int[] r104 = this.f31262k;     // Catch: Exception -> L56
        if (r104 != null) goto L46;
    L48:
        BitmapDescriptor r105 = this.f31270s;     // Catch: Exception -> L56
        if (r105 == null) goto L51;
        r110.putBundle("image_info", r105.a());     // Catch: Exception -> L56
        r110.putInt("dotline", 0);     // Catch: Exception -> L56
    L52:
        r110.putInt("customlist", 0);     // Catch: Exception -> L56
        goto L54
    L51:
        r110.putBundle("image_info", a(true, r103));     // Catch: Exception -> L56
        goto L52
    L46:
        if (r104.length <= 0) goto L48;
        r110.putBundle("image_info_list", b(true, r103));     // Catch: Exception -> L56
        goto L52
    L29:
        if (this.f31266o == false) goto L33;
        r110.putBundle("image_info", a(true, null));     // Catch: Exception -> L56
        r110.putInt("dotted_line_type", this.f31274w);     // Catch: Exception -> L56
    L34:
        r110.putInt("custom", 0);     // Catch: Exception -> L56
        goto L37
    L33:
        r110.putBundle("image_info", a(true, "line_texture.png"));     // Catch: Exception -> L56
        goto L34
    L18:
        if (r102.length <= 0) goto L20;
        this.f31259h.size();
        goto L20
    L13:
        if (this.f31259h.size() != 2) goto L15;
        this.f31259h = f.b((LatLng) ListProtector.get(this.f31259h, 0), (LatLng) ListProtector.get(this.f31259h, 1));
    L59:
        throw new IllegalStateException("BDMapSDKException: when you add Polyline, you must at least supply 2 points");
    }

    public void setAnimation(Animation r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.Q = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmAnimation r101 = this.Q.bmAnimation;
        if (r101 == null) goto L11;
        this.L.a(r101);
        this.f31207f.b();
        return;
    L11:
        return;
    }

    public void setBloomAlpha(int r100) {
        if (r100 > 255) goto L5;
        if (r100 < 0) goto L5;
    L6:
        this.F = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.L.b(r100);
        this.f31207f.b();
        return;
    L9:
        this.listener.c(this);
        return;
    L5:
        r100 = 255;
        goto L6
    }

    public void setBloomBlurTimes(int r100) {
        if (r100 <= 10) goto L6;
        r100 = 10;
    L6:
        if (r100 >= 1) goto L8;
        r100 = 1;
    L8:
        this.H = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L11;
        this.L.e(r100);
        this.f31207f.b();
        return;
    L11:
        this.listener.c(this);
    }

    public void setBloomGradientASpeed(float r100) {
        if (r100 >= 1.0f) goto L6;
        r100 = 1.0f;
    L6:
        if (r100 <= 10.0f) goto L8;
        r100 = 10.0f;
    L8:
        this.G = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L11;
        this.L.c(r100);
        this.f31207f.b();
        return;
    L11:
        this.listener.c(this);
    }

    public void setBloomWidth(int r100) {
        if (r100 >= 0) goto L4;
        r100 = 0;
    L4:
        this.E = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L7;
        this.L.d(r100);
        this.f31207f.b();
        return;
    L7:
        this.listener.c(this);
    }

    public void setClickable(boolean r100) {
        if (this.f31269r != r100) goto L5;
        return;
    L5:
        this.f31269r = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        this.L.a(r100);
        this.f31207f.b();
        return;
    L8:
        this.listener.c(this);
    }

    public void setColor(int r100) {
        this.f31258g = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.D == false) goto L7;
        return;
    L7:
        if (this.f31270s == null) goto L9;
        return;
    L9:
        if (this.f31272u == null) goto L12;
        return;
    L12:
        if (this.N == null) goto L21;
        BmLineStyle r101 = this.M;
        if (r101 == null) goto L22;
        r101.a(this.f31258g);
        this.f31207f.b();
        return;
    L22:
        return;
    }

    public void setColorList(int[] r100) {
        if (r100 == null) goto L45;
        if (r100.length == 0) goto L45;
        this.f31262k = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L8;
        return;
    L8:
        if (this.f31270s == null) goto L10;
        return;
    L10:
        if (this.f31272u != null) goto L55;
        int r101 = 0;
        if (this.D == false) goto L25;
        this.f31263l.clear();
    L16:
        if (r101 >= Math.min(this.f31259h.size(), this.f31262k.length)) goto L18;
        this.f31263l.add(Integer.valueOf(this.f31262k[r101]));
        r101 = r101 + 1;
        goto L16
    L18:
        int r102 = this.f31263l.size();
    L20:
        if (r102 >= this.f31259h.size()) goto L22;
        List<Integer> r103 = this.f31263l;
        r103.add((Integer) ListProtector.get(r103, r103.size() - 1));
        r102 = r102 + 1;
        goto L20
    L22:
        this.N.a(1, this.f31263l);
        this.f31207f.b();
        return;
    L25:
        if (this.O == null) goto L53;
        List<BmLineStyle> r104 = this.P;
        if (r104 != null) goto L29;
        return;
    L29:
        if (r104.size() == this.f31263l.size()) goto L31;
        return;
    L31:
        this.f31263l.clear();
        int r105 = 0;
    L33:
        if (r105 >= Math.min(this.f31259h.size() - 1, this.f31262k.length)) goto L35;
        this.f31263l.add(Integer.valueOf(this.f31262k[r105]));
        r105 = r105 + 1;
        goto L33
    L35:
        int r106 = this.f31263l.size();
    L37:
        if (r106 >= (this.f31259h.size() - 1)) goto L40;
        List<Integer> r107 = this.f31263l;
        r107.add((Integer) ListProtector.get(r107, r107.size() - 1));
        r106 = r106 + 1;
    L40:
        if (r101 >= this.P.size()) goto L42;
        ((BmLineStyle) ListProtector.get(this.P, r101)).a(((Integer) ListProtector.get(this.f31263l, r101)).intValue());
        r101 = r101 + 1;
        goto L40
    L42:
        this.f31207f.b();
        return;
    L53:
        return;
    L55:
        return;
    L45:
        throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
    }

    public void setDottedLine(boolean r100) {
        if (this.f31266o != r100) goto L5;
        return;
    L5:
        this.f31266o = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L8;
        this.listener.c(this);
        return;
    L8:
        if (this.D == false) goto L10;
        return;
    L10:
        if (this.f31270s == null) goto L12;
        return;
    L12:
        if (this.f31272u != null) goto L39;
        BmLineStyle r101 = this.M;
        if (r101 != null) goto L17;
    L20:
        List<BmLineStyle> r102 = this.P;
        if (r102 != null) goto L23;
    L32:
        this.f31207f.b();
        return;
    L23:
        if (this.f31266o == false) goto L28;
        Iterator<BmLineStyle> r103 = r102.iterator();
    L26:
        if (r103.hasNext() == false) goto L32;
        BmLineStyle r104 = r103.next();
        setDottedBitmapResource(r104, this.f31274w);
        r104.c(5);
        goto L26
    L28:
        int r105 = 0;
    L30:
        if (r105 >= this.P.size()) goto L32;
        ((BmLineStyle) ListProtector.get(this.P, r105)).b(0);
        ((BmLineStyle) ListProtector.get(this.P, r105)).a();
        r105 = r105 + 1;
        goto L30
    L17:
        if (this.f31266o == false) goto L19;
        setDottedBitmapResource(r101, this.f31274w);
        this.M.c(5);
        goto L20
    L19:
        r101.b(0);
        this.M.a();
        goto L20
    }

    public void setDottedLineType(PolylineDottedLineType r100) {
        this.f31274w = r100.ordinal();
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f31266o == true) goto L8;
        return;
    L8:
        if (this.D == false) goto L10;
        return;
    L10:
        if (this.f31270s == null) goto L12;
        return;
    L12:
        if (this.f31272u != null) goto L29;
        BmLineStyle r101 = this.M;
        if (r101 == null) goto L17;
        setDottedBitmapResource(r101, this.f31274w);
        this.M.c(5);
    L17:
        List<BmLineStyle> r102 = this.P;
        if (r102 == null) goto L23;
        Iterator<BmLineStyle> r103 = r102.iterator();
    L21:
        if (r103.hasNext() == false) goto L23;
        BmLineStyle r104 = r103.next();
        setDottedBitmapResource(r104, this.f31274w);
        r104.c(5);
    L23:
        this.f31207f.b();
        return;
    }

    public void setFocus(boolean r100) {
        this.f31267p = r100;
        this.listener.c(this);
    }

    public void setGeodesic(boolean r100) {
        this.C = r100;
        this.listener.c(this);
    }

    public void setGradient(boolean r100) {
        this.D = r100;
        this.listener.c(this);
    }

    public void setIndexs(int[] r110) {
        if (r110 == null) goto L50;
        if (r110.length == 0) goto L50;
        this.f31260i = r110;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L8;
        return;
    L8:
        if (this.f31272u == null) goto L61;
        List<BmLineStyle> r100 = this.P;
        if (r100 != null) goto L12;
        return;
    L12:
        if (this.O == null) goto L63;
        r100.clear();
        this.O.clear();
        this.L.c();
        List<Integer> r101 = this.f31261j;
        if (r101 == null) goto L17;
        r101.clear();
    L18:
        int r102 = this.f31259h.size() - 1;
        int r103 = 0;
        int r104 = 0;
    L20:
        if (r104 >= Math.min(r110.length, r102)) goto L22;
        this.f31261j.add(Integer.valueOf(r110[r104]));
        r104 = r104 + 1;
        goto L20
    L22:
        int r111 = this.f31261j.size();
    L23:
        if (r111 >= r102) goto L25;
        List<Integer> r105 = this.f31261j;
        r105.add((Integer) ListProtector.get(r105, r105.size() - 1));
        r111 = r111 + 1;
        goto L23
    L25:
        ArrayList r112 = new ArrayList();
        Bundle r106 = new Bundle();
        a(this.f31259h, this.T, r106);
        if (r106.containsKey("x_array") == true) goto L28;
    L33:
        int r107 = ((Integer) ListProtector.get(this.f31261j, 0)).intValue();
    L34:
        if (r103 >= r102) goto L47;
        int r108 = r103;
    L36:
        if (r108 >= r102) goto L40;
        if (r107 != ((Integer) ListProtector.get(this.f31261j, r108)).intValue()) goto L40;
        r108 = r108 + 1;
    L40:
        ArrayList r109 = new ArrayList();
    L41:
        if (r103 > r108) goto L43;
        r109.add(ListProtector.get(r112, r103));
        r103 = r103 + 1;
        goto L41
    L43:
        BmGeoElement r113 = new BmGeoElement();
        BmLineStyle r114 = new BmLineStyle();
        r114.d(this.f31264m.ordinal());
        r114.a(this.f31265n);
        r114.a(new BmBitmapResource(((BitmapDescriptor) ListProtector.get(this.f31272u, r107)).getBitmap()));
        r113.a(r114);
        r113.a(r109);
        this.O.add(r113);
        this.L.a(r113);
        this.P.add(r114);
        if (r108 >= r102) goto L46;
        r107 = ((Integer) ListProtector.get(this.f31261j, r108)).intValue();
    L46:
        r103 = r108;
        goto L34
    L47:
        this.f31207f.b();
        return;
    L28:
        if (r106.containsKey("y_array") == false) goto L33;
        double[] r115 = r106.getDoubleArray("x_array");
        double[] r116 = r106.getDoubleArray("y_array");
        int r117 = 0;
    L31:
        if (r117 >= r115.length) goto L33;
        r112.add(new com.baidu.platform.comapi.bmsdk.b(r115[r117], r116[r117]));
        r117 = r117 + 1;
        goto L31
    L17:
        this.f31261j = new ArrayList();
        goto L18
    L63:
        return;
    L61:
        return;
    L50:
        throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
    }

    public void setIsKeepScale(boolean r100) {
        this.f31268q = r100;
    }

    public void setLineBloomDirection(LineBloomDirection r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.K = r100;
        this.L.j(r100.ordinal());
        this.f31207f.b();
        return;
    }

    public void setLineBloomType(PolylineOptions.LineBloomType r100) {
        this.U = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        this.L.k(r100.ordinal());
        this.f31207f.b();
        return;
    L5:
        this.listener.c(this);
    }

    public void setLineCapType(PolylineOptions.LineCapType r100) {
        this.R = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        this.L.n(a(this.R));
        this.L.h(a(this.R));
        this.f31207f.b();
        return;
    L5:
        this.listener.c(this);
    }

    public void setLineDirectionCross180(PolylineOptions.LineDirectionCross180 r100) {
        this.T = r100;
    }

    public void setLineJoinType(PolylineOptions.LineJoinType r100) {
        this.S = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (isGeodesic() == false) goto L7;
        return;
    L7:
        this.L.i(a(this.S));
        this.f31207f.b();
    }

    public void setPoiCollided(boolean r100) {
        this.f31257J = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        return;
    L5:
        if (this.f31257J == false) goto L7;
        this.L.g(1);
        this.L.f(CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber());
    L8:
        this.f31207f.b();
        return;
    L7:
        this.L.g(0);
        this.L.f(0);
        goto L8
    }

    public void setPoints(List<LatLng> r100) {
        if (r100 == null) goto L122;
        if (r100.size() < 2) goto L120;
        if (r100.contains(null) == true) goto L118;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L115;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
        if (this.C == true) goto L12;
    L14:
        List<LatLng> r103 = r100;
    L15:
        a(r103, r101, this.T);
        if (this.D == false) goto L33;
        if (this.f31259h.size() == this.f31263l.size()) goto L21;
        return;
    L21:
        if (r100.size() <= this.f31259h.size()) goto L28;
        int r104 = this.f31263l.size();
    L24:
        if (r104 >= r100.size()) goto L26;
        List<Integer> r105 = this.f31263l;
        r105.add((Integer) ListProtector.get(r105, r105.size() - 1));
        r104 = r104 + 1;
        goto L24
    L26:
        this.N.a(1, this.f31263l);
    L28:
        if (r100.size() >= this.f31259h.size()) goto L30;
        this.f31263l.subList(r100.size(), this.f31263l.size()).clear();
        this.N.a(1, this.f31263l);
    L30:
        this.N.a(r101);
        this.f31259h = r100;
        this.f31207f.b();
        return;
    L33:
        if (this.f31272u == null) goto L82;
        if (this.f31259h.size() == (this.f31261j.size() + 1)) goto L37;
        return;
    L37:
        int r106 = r100.size() - 1;
        if (r100.size() <= this.f31259h.size()) goto L43;
        int r107 = this.f31261j.size();
    L40:
        if (r107 >= r106) goto L43;
        List<Integer> r108 = this.f31261j;
        r108.add((Integer) ListProtector.get(r108, r108.size() - 1));
        r107 = r107 + 1;
    L43:
        if (r100.size() >= this.f31259h.size()) goto L67;
        int r109 = r100.size() - 1;
        int r110 = ((Integer) ListProtector.get(this.f31261j, r109 - 1)).intValue();
    L46:
        if (r109 >= this.f31261j.size()) goto L50;
        if (((Integer) ListProtector.get(this.f31261j, r109)).intValue() != r110) goto L50;
        r109 = r109 + 1;
    L50:
        int r111 = 0;
    L52:
        if (r109 >= this.f31261j.size()) goto L60;
        int r112 = ((Integer) ListProtector.get(this.f31261j, r109)).intValue();
    L55:
        if (r109 >= this.f31261j.size()) goto L59;
        if (((Integer) ListProtector.get(this.f31261j, r109)).intValue() != r112) goto L59;
        r109 = r109 + 1;
    L59:
        r111 = r111 + 1;
        goto L52
    L60:
        int r113 = this.O.size() - r111;
        if (r113 > 0) goto L63;
        return;
    L63:
        int r114 = this.O.size() - 1;
    L64:
        if (r114 < r113) goto L66;
        this.L.b((BmGeoElement) ListProtector.get(this.O, r114));
        r114 = r114 - 1;
        goto L64
    L66:
        List<BmGeoElement> r115 = this.O;
        r115.subList(r113, r115.size()).clear();
        List<BmLineStyle> r116 = this.P;
        r116.subList(r113, r116.size()).clear();
        this.f31261j.subList(r100.size(), this.f31261j.size()).clear();
    L67:
        int r117 = ((Integer) ListProtector.get(this.f31261j, 0)).intValue();
        int r118 = 0;
    L68:
        if (r102 >= r106) goto L114;
        int r119 = r102;
    L70:
        if (r119 >= r106) goto L74;
        if (r117 != ((Integer) ListProtector.get(this.f31261j, r119)).intValue()) goto L74;
        r119 = r119 + 1;
    L74:
        ArrayList r120 = new ArrayList();
    L75:
        if (r102 > r119) goto L77;
        r120.add(ListProtector.get(r101, r102));
        r102 = r102 + 1;
        goto L75
    L77:
        int r121 = r118 + 1;
        ((BmGeoElement) ListProtector.get(this.O, r118)).a(r120);
        if (r119 >= r106) goto L80;
        r117 = ((Integer) ListProtector.get(this.f31261j, r119)).intValue();
    L80:
        r102 = r119;
        r118 = r121;
    L114:
        this.f31259h = r100;
        this.f31207f.b();
        return;
    L82:
        if (this.f31262k != null) goto L84;
        this.N.a(r101);
        goto L114
    L84:
        if (this.f31259h.size() == (this.f31263l.size() + 1)) goto L87;
        return;
    L87:
        if (r100.size() <= this.f31259h.size()) goto L93;
        int r122 = this.f31263l.size();
    L90:
        if (r122 >= (r100.size() - 1)) goto L93;
        List<Integer> r123 = this.f31263l;
        r123.add((Integer) ListProtector.get(r123, r123.size() - 1));
        r122 = r122 + 1;
    L93:
        if (r100.size() >= this.f31259h.size()) goto L99;
        this.f31263l.subList(r100.size() - 1, this.f31263l.size()).clear();
        int r124 = this.O.size() - 1;
    L96:
        if (r124 < (r100.size() - 1)) goto L98;
        this.L.b((BmGeoElement) ListProtector.get(this.O, r124));
        r124 = r124 - 1;
        goto L96
    L98:
        this.O.subList(r100.size() - 1, this.O.size()).clear();
        this.P.subList(r100.size() - 1, this.P.size()).clear();
    L99:
        ArrayList r125 = new ArrayList();
        int r126 = 1;
    L101:
        if (r126 >= r100.size()) goto L104;
        ArrayList r127 = new ArrayList();
        r127.add(ListProtector.get(r101, r126 - 1));
        r127.add(ListProtector.get(r101, r126));
        r125.add(r127);
        r126 = r126 + 1;
    L104:
        if (r102 >= r125.size()) goto L114;
        if (r102 >= (this.f31259h.size() - 1)) goto L108;
        ((BmGeoElement) ListProtector.get(this.O, r102)).a((List) ListProtector.get(r125, r102));
    L112:
        r102 = r102 + 1;
        goto L104
    L108:
        BmLineStyle r128 = new BmLineStyle();
        r128.a(((Integer) ListProtector.get(this.f31263l, r102)).intValue());
        r128.d(this.f31264m.ordinal());
        r128.a(this.f31265n);
        if (this.f31266o == false) goto L111;
        setDottedBitmapResource(r128, this.f31274w);
        r128.c(5);
    L111:
        BmGeoElement r129 = new BmGeoElement();
        r129.a((List) ListProtector.get(r125, r102));
        r129.a(r128);
        this.O.add(r129);
        this.P.add(r128);
        this.L.a(r129);
        goto L112
    L12:
        if (r100.size() != 2) goto L14;
        r103 = f.b((LatLng) ListProtector.get(r100, 0), (LatLng) ListProtector.get(r100, 1));
        goto L15
    L115:
        this.f31259h = r100;
        this.listener.c(this);
        return;
    L118:
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
    L120:
        throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2 or more than 10000");
    L122:
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public void setSmoothAlgorithm(ThinAndSmoothAlgorithm r100) {
        this.A = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.L.m(this.A.getValue());
        this.f31207f.b();
        return;
    }

    public void setSmoothFactor(float r100) {
        if (r100 <= 0.0f) goto L6;
        this.B = r100;
    L6:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.L.e(this.B);
        this.f31207f.b();
        return;
    }

    public void setTexture(BitmapDescriptor r100) {
        this.f31270s = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        BmBitmapResource r101 = new BmBitmapResource(r100.getBitmap());
        this.f31271t = r101;
        BmLineStyle r102 = this.M;
        if (r102 == null) goto L7;
        r102.a(r101);
    L7:
        this.f31207f.b();
        return;
    L8:
        this.listener.c(this);
    }

    public void setTextureList(List<BitmapDescriptor> r100) {
        if (r100 == null) goto L31;
        if (r100.isEmpty() == true) goto L31;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L8;
        this.f31272u = r100;
        return;
    L8:
        if (this.f31272u == null) goto L36;
        List<BmBitmapResource> r101 = this.f31273v;
        if (r101 == null) goto L13;
        r101.clear();
    L13:
        if (this.f31273v != null) goto L15;
        this.f31273v = new ArrayList();
    L15:
        int r102 = 0;
        int r103 = 0;
    L17:
        if (r102 >= this.P.size()) goto L27;
        if (r103 >= this.f31261j.size()) goto L27;
        int r104 = ((Integer) ListProtector.get(this.f31261j, r103)).intValue();
        BmBitmapResource r105 = new BmBitmapResource(((BitmapDescriptor) ListProtector.get(r100, r104)).getBitmap());
        ((BmLineStyle) ListProtector.get(this.P, r102)).a(r105);
        this.f31273v.add(r105);
    L22:
        if (r103 >= this.f31261j.size()) goto L26;
        if (r104 != ((Integer) ListProtector.get(this.f31261j, r103)).intValue()) goto L26;
        r103 = r103 + 1;
    L26:
        r102 = r102 + 1;
    L27:
        this.f31272u = r100;
        this.f31207f.b();
        return;
    L36:
        return;
    L31:
        throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
    }

    public void setThinAlgorithm(ThinAndSmoothAlgorithm r100) {
        this.f31276y = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.L.o(this.f31276y.getValue());
        this.f31207f.b();
        return;
    }

    public void setThinFactor(float r100) {
        if (r100 <= 0.0f) goto L6;
        this.f31277z = r100;
    L6:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.L.f(this.f31277z);
        this.f31207f.b();
        return;
    }

    public void setThined(boolean r100) {
        this.f31275x = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    }

    public void setTrackBackwardStyle(LineStyle r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        BmLineStyleOption r101 = new BmLineStyleOption(256, r100.f31009a);
        this.N.a(r101);
        this.f31207f.b();
        return;
    }

    public void setTrackBackwardStyles(List<LineStyle> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return;
    L7:
        if (OverlayUtil.isOverlayUpgrade() == true) goto L9;
        return;
    L9:
        if (this.O != null) goto L11;
        return;
    L11:
        if (r100.size() != this.O.size()) goto L22;
        int r101 = 0;
    L14:
        if (r101 >= r100.size()) goto L16;
        BmLineStyleOption r102 = new BmLineStyleOption(256, ((LineStyle) ListProtector.get(r100, r101)).f31009a);
        ((BmGeoElement) ListProtector.get(this.O, r101)).a(r102);
        r101 = r101 + 1;
        goto L14
    L16:
        this.f31207f.b();
        return;
    }

    public void setTrackForwardStyle(LineStyle r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        BmLineStyleOption r101 = new BmLineStyleOption(128, r100.f31009a);
        this.N.a(r101);
        this.f31207f.b();
        return;
    }

    public void setTrackForwardStyles(List<LineStyle> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return;
    L7:
        if (OverlayUtil.isOverlayUpgrade() == true) goto L9;
        return;
    L9:
        if (this.O != null) goto L11;
        return;
    L11:
        if (r100.size() != this.O.size()) goto L22;
        int r101 = 0;
    L14:
        if (r101 >= r100.size()) goto L16;
        BmLineStyleOption r102 = new BmLineStyleOption(128, ((LineStyle) ListProtector.get(r100, r101)).f31009a);
        ((BmGeoElement) ListProtector.get(this.O, r101)).a(r102);
        r101 = r101 + 1;
        goto L14
    L16:
        this.f31207f.b();
        return;
    }

    public void setWidth(float r100) {
        if (r100 <= 0.0f) goto L19;
        this.f31265n = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L16;
        BmLineStyle r101 = this.M;
        if (r101 == null) goto L9;
        r101.a(this.f31265n);
    L9:
        List<BmLineStyle> r102 = this.P;
        if (r102 == null) goto L15;
        Iterator<BmLineStyle> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        r103.next().a(this.f31265n);
    L15:
        this.f31207f.b();
        return;
    L16:
        this.listener.c(this);
        return;
    }

    public void setWidthType(WidthType r100) {
        if (this.f31264m != r100) goto L5;
        return;
    L5:
        this.f31264m = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L19;
        BmLineStyle r101 = this.M;
        if (r101 == null) goto L10;
        r101.d(this.f31264m.ordinal());
        this.M.a(this.f31265n);
    L10:
        List<BmLineStyle> r102 = this.P;
        if (r102 == null) goto L16;
        Iterator<BmLineStyle> r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L16;
        BmLineStyle r104 = r103.next();
        r104.d(this.f31264m.ordinal());
        r104.a(this.f31265n);
    L16:
        this.f31207f.b();
        return;
    }

    private static int a(PolylineOptions.LineJoinType r100) {
        int r101 = a.f31278a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 2048;
    L5:
        if (r101 != 2) goto L7;
        return 8192;
    L7:
        if (r101 != 3) goto L14;
        return 4096;
    L14:
        return 2048;
    }

    private static int a(PolylineOptions.LineCapType r100) {
        int r101 = a.f31279b[r100.ordinal()];
        if (r101 == 1) goto L11;
        if (r101 != 2) goto L6;
        return 4;
    L6:
        if (r101 != 3) goto L13;
        return 8;
    L13:
        return 2;
    L11:
        return 2;
    }

    private Bundle a(boolean r100, String r101) {
        if (r100 == false) goto L18;
        int r102 = this.f31274w;
        if (r102 != 1) goto L7;
        String r103 = "CircleDashTexture.png";
    L10:
        if (r101 != null) goto L13;
        r101 = r103;
    L13:
        BitmapDescriptor r104 = BitmapDescriptorFactory.fromAsset(r101);
        if (r104 == null) goto L18;
        return r104.a();
    L7:
        if (r102 != 2) goto L9;
        r103 = "lineDash_Rectangle.png";
        goto L10
    L9:
        r103 = "lineDashTexture.png";
    L18:
        return this.f31270s.a();
    }

    private Bundle b(boolean r100, String r101) {
        if (r100 == false) goto L18;
        Bundle r102 = new Bundle();
        r102.putInt("total", 1);
        int r103 = this.f31274w;
        if (r103 != 1) goto L8;
        String r104 = "CircleDashTexture.png";
    L11:
        if (r101 != null) goto L14;
        r101 = r104;
    L14:
        BitmapDescriptor r105 = BitmapDescriptorFactory.fromAsset(r101);
        if (r105 == null) goto L17;
        r102.putBundle("texture_0", r105.a());
    L17:
        return r102;
    L8:
        if (r103 != 2) goto L10;
        r104 = "lineDash_Rectangle.png";
        goto L11
    L10:
        r104 = "lineDashTexture.png";
        goto L11
    L18:
        Bundle r106 = new Bundle();
        int r107 = 0;
        int r108 = 0;
    L20:
        if (r107 >= this.f31272u.size()) goto L25;
        if (ListProtector.get(this.f31272u, r107) == null) goto L24;
        r106.putBundle("texture_" + String.valueOf(r108), ((BitmapDescriptor) ListProtector.get(this.f31272u, r107)).a());
        r108 = r108 + 1;
    L24:
        r107 = r107 + 1;
        goto L20
    L25:
        r106.putInt("total", r108);
        return r106;
    }

    private static void c(int[] r100, Bundle r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 0) goto L8;
        r101.putIntArray("color_indexs", r100);
        return;
    }

    private static void d(int[] r100, Bundle r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 0) goto L8;
        r101.putIntArray("traffic_array", r100);
        return;
    }

    private static void a(int[] r100, Bundle r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 0) goto L8;
        r101.putIntArray("color_array", r100);
        r101.putInt("total", 1);
        return;
    }

    private static void b(int[] r100, Bundle r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 0) goto L8;
        r101.putIntArray("color_array", r100);
        return;
    }

    private static void a(List<LatLng> r110, PolylineOptions.LineDirectionCross180 r111, Bundle r112) {
        int r100 = r110.size();
        double[] r101 = new double[r100];
        double[] r102 = new double[r100];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L16;
        LatLng r104 = (LatLng) ListProtector.get(r110, r103);
        if (r111 != PolylineOptions.LineDirectionCross180.FROM_EAST_TO_WEST) goto L11;
        double r113 = r104.longitude;
        if (r113 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        LatLng r105 = new LatLng(r104.latitude, r113 + 360.0d);
    L9:
        r104 = r105;
    L15:
        GeoPoint r106 = CoordUtil.ll2mc(r104);
        r101[r103] = r106.getLongitudeE6();
        r102[r103] = r106.getLatitudeE6();
        r103 = r103 + 1;
    L11:
        if (r111 != PolylineOptions.LineDirectionCross180.FROM_WEST_TO_EAST) goto L15;
        double r114 = r104.longitude;
        if (r114 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        r105 = new LatLng(r104.latitude, r114 - 360.0d);
        goto L9
    L16:
        r112.putDoubleArray("x_array", r101);
        r112.putDoubleArray("y_array", r102);
    }

    private static void a(List<LatLng> r110, List<com.baidu.platform.comapi.bmsdk.b> r111, PolylineOptions.LineDirectionCross180 r112) {
        int r100 = r110.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L16;
        LatLng r102 = (LatLng) ListProtector.get(r110, r101);
        if (r112 != PolylineOptions.LineDirectionCross180.FROM_EAST_TO_WEST) goto L11;
        double r103 = r102.longitude;
        if (r103 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        LatLng r104 = new LatLng(r102.latitude, r103 + 360.0d);
    L9:
        r102 = r104;
    L15:
        GeoPoint r105 = CoordUtil.ll2mc(r102);
        r111.add(new com.baidu.platform.comapi.bmsdk.b(r105.getLongitudeE6(), r105.getLatitudeE6()));
        r101 = r101 + 1;
    L11:
        if (r112 != PolylineOptions.LineDirectionCross180.FROM_WEST_TO_EAST) goto L15;
        double r106 = r102.longitude;
        if (r106 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        r104 = new LatLng(r102.latitude, r106 - 360.0d);
        goto L9
    }
}
