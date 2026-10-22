package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class PolygonOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Stroke f31235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<LatLng> f31237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<HoleOptions> f31238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HoleOptions f31239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f31240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f31241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private EncodePointType f31242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f31244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LineBloomType f31245k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f31246l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f31247m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f31248n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f31249o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LineBloomDirection f31250p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f31251q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ThinAndSmoothAlgorithm f31252r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f31253s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f31254t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f31255u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Bundle f31256v;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Polygon r100 = new Polygon();
        r100.f31205d = this.f31255u;
        r100.f31204c = this.f31254t;
        r100.f31206e = this.f31256v;
        List<LatLng> r101 = this.f31237c;
        if (r101 != null) goto L5;
    L6:
        String r102 = this.f31241g;
        if (r102 == null) goto L14;
        if (r102.length() <= 0) goto L14;
        r100.f31217j = this.f31241g;
        r100.f31203b = this.f31242h;
    L11:
        r100.f31224q = this.f31237c;
        r100.f31223p = this.f31236b;
        r100.f31214g = this.f31235a;
        r100.f31225r = this.f31238d;
        r100.f31226s = this.f31239e;
        r100.f31227t = this.f31240f;
        r100.f31220m = this.f31243i;
        r100.f31228u = this.f31244j;
        r100.B = this.f31245k;
        r100.C = this.f31250p;
        r100.E = this.f31248n;
        r100.D = this.f31249o;
        r100.G = this.f31246l;
        r100.F = this.f31247m;
        r100.f31231x = this.f31251q;
        r100.f31232y = this.f31252r;
        r100.f31233z = this.f31253s;
        return r100;
    L14:
        throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
    L5:
        if (r101.size() >= 2) goto L11;
        goto L6
    }

    public PolygonOptions() {
        this.f31236b = -16777216;
        this.f31240f = false;
        this.f31243i = 0;
        this.f31244j = false;
        this.f31245k = LineBloomType.NONE;
        this.f31246l = 5.0f;
        this.f31247m = 1;
        this.f31250p = LineBloomDirection.BloomAround;
        this.f31251q = true;
        this.f31252r = ThinAndSmoothAlgorithm.DOUGLAS_PEUCKER;
        this.f31253s = 4.0f;
        this.f31255u = true;
    }

    public Bundle getExtraInfo() {
        return this.f31256v;
    }

    public int getFillColor() {
        return this.f31236b;
    }

    public LineBloomDirection getLineBloomDirection() {
        return this.f31250p;
    }

    public List<LatLng> getPoints() {
        return this.f31237c;
    }

    public Stroke getStroke() {
        return this.f31235a;
    }

    public int getZIndex() {
        return this.f31254t;
    }

    public boolean isVisible() {
        return this.f31255u;
    }

    public PolygonOptions addHoleOption(HoleOptions r100) {
        this.f31239e = r100;
        return this;
    }

    public PolygonOptions addHoleOptions(List<HoleOptions> r100) {
        this.f31238d = r100;
        return this;
    }

    public PolygonOptions bloomAlpha(int r100) {
        if (r100 > 255) goto L5;
        if (r100 < 0) goto L5;
    L6:
        this.f31249o = r100;
        return this;
    L5:
        r100 = 255;
        goto L6
    }

    public PolygonOptions bloomType(LineBloomType r100) {
        this.f31245k = r100;
        return this;
    }

    public PolygonOptions bloomWidth(int r100) {
        if (r100 >= 0) goto L4;
        r100 = 0;
    L4:
        this.f31248n = r100;
        return this;
    }

    public PolygonOptions dottedStroke(boolean r100) {
        this.f31240f = r100;
        return this;
    }

    public PolygonOptions dottedStrokeType(PolylineDottedLineType r100) {
        this.f31243i = r100.ordinal();
        return this;
    }

    public PolygonOptions extraInfo(Bundle r100) {
        this.f31256v = r100;
        return this;
    }

    public PolygonOptions fillColor(int r100) {
        this.f31236b = r100;
        return this;
    }

    public PolygonOptions isThined(boolean r100) {
        this.f31251q = r100;
        return this;
    }

    public PolygonOptions lineBloomDirection(LineBloomDirection r100) {
        this.f31250p = r100;
        return this;
    }

    public PolygonOptions points(List<LatLng> r100) {
        if (r100 == null) goto L26;
        if (r100.size() <= 2) goto L24;
        if (r100.contains(null) == true) goto L22;
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
        this.f31237c = r100;
        return this;
    L22:
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
    L24:
        throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
    L26:
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public PolygonOptions setBloomBlurTimes(int r100) {
        if (r100 >= 1) goto L6;
        r100 = 1;
    L6:
        if (r100 <= 10) goto L8;
        r100 = 10;
    L8:
        this.f31247m = r100;
        return this;
    }

    public PolygonOptions setBloomGradientASpeed(float r100) {
        if (r100 >= 1.0f) goto L6;
        r100 = 1.0f;
    L6:
        if (r100 <= 10.0f) goto L8;
        r100 = 10.0f;
    L8:
        this.f31246l = r100;
        return this;
    }

    public PolygonOptions setClickable(boolean r100) {
        this.f31244j = r100;
        return this;
    }

    public PolygonOptions stroke(Stroke r100) {
        this.f31235a = r100;
        return this;
    }

    public PolygonOptions thinAlgorithm(ThinAndSmoothAlgorithm r100) {
        this.f31252r = r100;
        return this;
    }

    public PolygonOptions thinFactor(float r100) {
        if (r100 <= 0.0f) goto L5;
        this.f31253s = r100;
    L5:
        return this;
    }

    public PolygonOptions visible(boolean r100) {
        this.f31255u = r100;
        return this;
    }

    public PolygonOptions zIndex(int r100) {
        this.f31254t = r100;
        return this;
    }

    public PolygonOptions points(String r100, EncodePointType r101) {
        this.f31241g = r100;
        this.f31242h = r101;
        return this;
    }
}
