package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.stepos.alphame.utils.Property;
import java.util.List;

/* loaded from: classes.dex */
public final class CircleOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private LatLng f6315a;

    /* renamed from: c, reason: collision with root package name */
    private int f6317c;

    /* renamed from: d, reason: collision with root package name */
    private Stroke f6318d;

    /* renamed from: g, reason: collision with root package name */
    private List<HoleOptions> f6321g;

    /* renamed from: h, reason: collision with root package name */
    private HoleOptions f6322h;

    /* renamed from: k, reason: collision with root package name */
    private int f6325k;

    /* renamed from: l, reason: collision with root package name */
    private int f6326l;

    /* renamed from: r, reason: collision with root package name */
    private int f6332r;

    /* renamed from: s, reason: collision with root package name */
    private int f6333s;

    /* renamed from: u, reason: collision with root package name */
    int f6335u;

    /* renamed from: w, reason: collision with root package name */
    Bundle f6337w;

    /* renamed from: b, reason: collision with root package name */
    private int f6316b = -16777216;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6319e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f6320f = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6323i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6324j = false;

    /* renamed from: m, reason: collision with root package name */
    private float f6327m = 0.5f;

    /* renamed from: n, reason: collision with root package name */
    private float f6328n = 0.2f;

    /* renamed from: o, reason: collision with root package name */
    private LineBloomType f6329o = LineBloomType.NONE;

    /* renamed from: p, reason: collision with root package name */
    private float f6330p = 5.0f;

    /* renamed from: q, reason: collision with root package name */
    private int f6331q = 1;

    /* renamed from: t, reason: collision with root package name */
    private LineBloomDirection f6334t = LineBloomDirection.BloomAround;

    /* renamed from: v, reason: collision with root package name */
    boolean f6336v = true;

    public CircleOptions addHoleOption(HoleOptions holeOptions) {
        this.f6322h = holeOptions;
        return this;
    }

    public CircleOptions addHoleOptions(List<HoleOptions> list) {
        this.f6321g = list;
        return this;
    }

    public CircleOptions bloomAlpha(int i4) {
        if (i4 > 255 || i4 < 0) {
            i4 = 255;
        }
        this.f6333s = i4;
        return this;
    }

    public CircleOptions bloomType(LineBloomType lineBloomType) {
        this.f6329o = lineBloomType;
        return this;
    }

    public CircleOptions bloomWidth(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        this.f6332r = i4;
        return this;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
        }
        this.f6315a = latLng;
        return this;
    }

    public CircleOptions dottedStroke(boolean z4) {
        this.f6319e = z4;
        return this;
    }

    public CircleOptions dottedStrokeType(CircleDottedStrokeType circleDottedStrokeType) {
        this.f6320f = circleDottedStrokeType.ordinal();
        return this;
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.f6337w = bundle;
        return this;
    }

    public CircleOptions fillColor(int i4) {
        this.f6316b = i4;
        return this;
    }

    public LatLng getCenter() {
        return this.f6315a;
    }

    public int getCenterColor() {
        return this.f6325k;
    }

    public float getColorWeight() {
        return this.f6328n;
    }

    public Bundle getExtraInfo() {
        return this.f6337w;
    }

    public int getFillColor() {
        return this.f6316b;
    }

    public LineBloomDirection getLineBloomDirection() {
        return this.f6334t;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Circle circle = new Circle();
        circle.f6721d = this.f6336v;
        circle.f6720c = this.f6335u;
        circle.f6722e = this.f6337w;
        circle.f6293h = this.f6316b;
        circle.f6292g = this.f6315a;
        circle.f6294i = this.f6317c;
        circle.f6295j = this.f6318d;
        circle.f6296k = this.f6319e;
        circle.f6304s = this.f6320f;
        circle.f6297l = this.f6321g;
        circle.f6298m = this.f6322h;
        circle.f6299n = this.f6323i;
        circle.f6306u = this.f6325k;
        circle.f6307v = this.f6326l;
        circle.f6308w = this.f6327m;
        circle.f6309x = this.f6328n;
        circle.f6300o = this.f6324j;
        circle.f6311z = this.f6329o;
        circle.f6287A = this.f6334t;
        circle.f6289C = this.f6332r;
        circle.f6288B = this.f6333s;
        circle.f6291E = this.f6330p;
        circle.f6290D = this.f6331q;
        return circle;
    }

    public int getRadius() {
        return this.f6317c;
    }

    public float getRadiusWeight() {
        return this.f6327m;
    }

    public int getSideColor() {
        return this.f6326l;
    }

    public Stroke getStroke() {
        return this.f6318d;
    }

    public int getZIndex() {
        return this.f6335u;
    }

    public boolean isIsGradientCircle() {
        return this.f6323i;
    }

    public boolean isVisible() {
        return this.f6336v;
    }

    public CircleOptions lineBloomDirection(LineBloomDirection lineBloomDirection) {
        this.f6334t = lineBloomDirection;
        return this;
    }

    public CircleOptions radius(int i4) {
        this.f6317c = i4;
        return this;
    }

    public CircleOptions setBloomBlurTimes(int i4) {
        if (i4 < 1) {
            i4 = 1;
        }
        if (i4 > 10) {
            i4 = 10;
        }
        this.f6331q = i4;
        return this;
    }

    public CircleOptions setBloomGradientASpeed(float f4) {
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        if (f4 > 10.0f) {
            f4 = 10.0f;
        }
        this.f6330p = f4;
        return this;
    }

    public CircleOptions setCenterColor(int i4) {
        this.f6325k = i4;
        return this;
    }

    public CircleOptions setClickable(boolean z4) {
        this.f6324j = z4;
        return this;
    }

    public CircleOptions setColorWeight(float f4) {
        if (f4 > Property.DEFAULT_FLOAT_VALUE && f4 < 1.0f) {
            this.f6328n = f4;
        }
        return this;
    }

    public CircleOptions setIsGradientCircle(boolean z4) {
        this.f6323i = z4;
        return this;
    }

    public CircleOptions setRadiusWeight(float f4) {
        if (f4 > Property.DEFAULT_FLOAT_VALUE && f4 < 1.0f) {
            this.f6327m = f4;
        }
        return this;
    }

    public CircleOptions setSideColor(int i4) {
        this.f6326l = i4;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.f6318d = stroke;
        return this;
    }

    public CircleOptions visible(boolean z4) {
        this.f6336v = z4;
        return this;
    }

    public CircleOptions zIndex(int i4) {
        this.f6335u = i4;
        return this;
    }
}
