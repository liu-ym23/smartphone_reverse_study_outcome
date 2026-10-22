package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class CircleOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f30834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Stroke f30837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f30838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f30839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<HoleOptions> f30840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HoleOptions f30841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f30842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f30843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f30844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f30845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f30846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f30847n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LineBloomType f30848o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f30849p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f30850q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f30851r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f30852s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private LineBloomDirection f30853t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f30854u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f30855v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Bundle f30856w;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Circle r100 = new Circle();
        r100.f31205d = this.f30855v;
        r100.f31204c = this.f30854u;
        r100.f31206e = this.f30856w;
        r100.f30812h = this.f30835b;
        r100.f30811g = this.f30834a;
        r100.f30813i = this.f30836c;
        r100.f30814j = this.f30837d;
        r100.f30815k = this.f30838e;
        r100.f30823s = this.f30839f;
        r100.f30816l = this.f30840g;
        r100.f30817m = this.f30841h;
        r100.f30818n = this.f30842i;
        r100.f30825u = this.f30844k;
        r100.f30826v = this.f30845l;
        r100.f30827w = this.f30846m;
        r100.f30828x = this.f30847n;
        r100.f30819o = this.f30843j;
        r100.f30830z = this.f30848o;
        r100.A = this.f30853t;
        r100.C = this.f30851r;
        r100.B = this.f30852s;
        r100.E = this.f30849p;
        r100.D = this.f30850q;
        return r100;
    }

    public CircleOptions() {
        this.f30835b = -16777216;
        this.f30838e = false;
        this.f30839f = 0;
        this.f30842i = false;
        this.f30843j = false;
        this.f30846m = 0.5f;
        this.f30847n = 0.2f;
        this.f30848o = LineBloomType.NONE;
        this.f30849p = 5.0f;
        this.f30850q = 1;
        this.f30853t = LineBloomDirection.BloomAround;
        this.f30855v = true;
    }

    public LatLng getCenter() {
        return this.f30834a;
    }

    public int getCenterColor() {
        return this.f30844k;
    }

    public float getColorWeight() {
        return this.f30847n;
    }

    public Bundle getExtraInfo() {
        return this.f30856w;
    }

    public int getFillColor() {
        return this.f30835b;
    }

    public LineBloomDirection getLineBloomDirection() {
        return this.f30853t;
    }

    public int getRadius() {
        return this.f30836c;
    }

    public float getRadiusWeight() {
        return this.f30846m;
    }

    public int getSideColor() {
        return this.f30845l;
    }

    public Stroke getStroke() {
        return this.f30837d;
    }

    public int getZIndex() {
        return this.f30854u;
    }

    public boolean isIsGradientCircle() {
        return this.f30842i;
    }

    public boolean isVisible() {
        return this.f30855v;
    }

    public CircleOptions addHoleOption(HoleOptions r100) {
        this.f30841h = r100;
        return this;
    }

    public CircleOptions addHoleOptions(List<HoleOptions> r100) {
        this.f30840g = r100;
        return this;
    }

    public CircleOptions bloomAlpha(int r100) {
        if (r100 > 255) goto L5;
        if (r100 < 0) goto L5;
    L6:
        this.f30852s = r100;
        return this;
    L5:
        r100 = 255;
        goto L6
    }

    public CircleOptions bloomType(LineBloomType r100) {
        this.f30848o = r100;
        return this;
    }

    public CircleOptions bloomWidth(int r100) {
        if (r100 >= 0) goto L4;
        r100 = 0;
    L4:
        this.f30851r = r100;
        return this;
    }

    public CircleOptions center(LatLng r100) {
        if (r100 == null) goto L6;
        this.f30834a = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
    }

    public CircleOptions dottedStroke(boolean r100) {
        this.f30838e = r100;
        return this;
    }

    public CircleOptions dottedStrokeType(CircleDottedStrokeType r100) {
        this.f30839f = r100.ordinal();
        return this;
    }

    public CircleOptions extraInfo(Bundle r100) {
        this.f30856w = r100;
        return this;
    }

    public CircleOptions fillColor(int r100) {
        this.f30835b = r100;
        return this;
    }

    public CircleOptions lineBloomDirection(LineBloomDirection r100) {
        this.f30853t = r100;
        return this;
    }

    public CircleOptions radius(int r100) {
        this.f30836c = r100;
        return this;
    }

    public CircleOptions setBloomBlurTimes(int r100) {
        if (r100 >= 1) goto L6;
        r100 = 1;
    L6:
        if (r100 <= 10) goto L8;
        r100 = 10;
    L8:
        this.f30850q = r100;
        return this;
    }

    public CircleOptions setBloomGradientASpeed(float r100) {
        if (r100 >= 1.0f) goto L6;
        r100 = 1.0f;
    L6:
        if (r100 <= 10.0f) goto L8;
        r100 = 10.0f;
    L8:
        this.f30849p = r100;
        return this;
    }

    public CircleOptions setCenterColor(int r100) {
        this.f30844k = r100;
        return this;
    }

    public CircleOptions setClickable(boolean r100) {
        this.f30843j = r100;
        return this;
    }

    public CircleOptions setColorWeight(float r100) {
        if (r100 > 0.0f) goto L5;
    L7:
        return this;
    L5:
        if (r100 >= 1.0f) goto L7;
        this.f30847n = r100;
        goto L7
    }

    public CircleOptions setIsGradientCircle(boolean r100) {
        this.f30842i = r100;
        return this;
    }

    public CircleOptions setRadiusWeight(float r100) {
        if (r100 > 0.0f) goto L5;
    L7:
        return this;
    L5:
        if (r100 >= 1.0f) goto L7;
        this.f30846m = r100;
        goto L7
    }

    public CircleOptions setSideColor(int r100) {
        this.f30845l = r100;
        return this;
    }

    public CircleOptions stroke(Stroke r100) {
        this.f30837d = r100;
        return this;
    }

    public CircleOptions visible(boolean r100) {
        this.f30855v = r100;
        return this;
    }

    public CircleOptions zIndex(int r100) {
        this.f30854u = r100;
        return this;
    }
}
