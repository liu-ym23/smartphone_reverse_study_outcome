package com.baidu.mapapi.map;

import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.model.LatLng;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class BMTrackOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private List<LatLng> f6101a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f6102b;

    /* renamed from: c, reason: collision with root package name */
    private int f6103c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f6104d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f6105e;

    /* renamed from: f, reason: collision with root package name */
    private BMTrackType f6106f = BMTrackType.Surface;

    /* renamed from: g, reason: collision with root package name */
    private int f6107g = 3000;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6108h = true;

    /* renamed from: i, reason: collision with root package name */
    private BMTrackAnimateType f6109i = BMTrackAnimateType.TraceOverlayAnimationEasingCurveLinear;

    /* renamed from: j, reason: collision with root package name */
    private BitmapDescriptor f6110j = BitmapDescriptorFactory.fromAsset("track_palette.png");

    /* renamed from: k, reason: collision with root package name */
    private BitmapDescriptor f6111k = BitmapDescriptorFactory.fromAsset("track_projection_palette.png");

    /* renamed from: l, reason: collision with root package name */
    private int f6112l = 5;

    /* renamed from: m, reason: collision with root package name */
    float f6113m = 1.0f;

    /* renamed from: n, reason: collision with root package name */
    float f6114n = 0.3f;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6115o = false;

    /* renamed from: p, reason: collision with root package name */
    private TraceAnimationListener f6116p;

    public enum BMTrackAnimateType {
        TraceOverlayAnimationEasingCurveLinear,
        TraceOverlayAnimationEasingCurveEaseIn,
        TraceOverlayAnimationEasingCurveEaseOut,
        TraceOverlayAnimationEasingCurveEaseInOut
    }

    public BMTrackAnimateType getAnimateType() {
        return this.f6109i;
    }

    public int getAnimationTime() {
        return this.f6107g;
    }

    public int[] getColors() {
        return this.f6104d;
    }

    public int[] getHeights() {
        return this.f6105e;
    }

    public float getOpacity() {
        return this.f6113m;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        BMTrackType bMTrackType;
        int[] iArr;
        List<LatLng> list = this.f6101a;
        if (list == null || list.size() <= 1 || (((bMTrackType = this.f6106f) == BMTrackType.Default3D || bMTrackType == BMTrackType.Surface) && ((iArr = this.f6105e) == null || iArr.length != this.f6101a.size()))) {
            return null;
        }
        Track track = new Track();
        int[] iArr2 = this.f6105e;
        if (iArr2 == null || iArr2.length != this.f6101a.size()) {
            int[] iArr3 = new int[this.f6101a.size()];
            track.f7062o = iArr3;
            Arrays.fill(iArr3, 1);
        } else {
            track.f7062o = this.f6105e;
        }
        track.f7069v = this.f6103c;
        track.f7063p = this.f6104d;
        track.f7070w = this.f6113m;
        track.f7071x = this.f6114n;
        track.setTrackMove(this.f6115o);
        track.f7061n = this.f6101a;
        track.f7060m = this.f6102b;
        track.f7068u = this.f6112l;
        track.f7050A = this.f6110j;
        track.f7051B = this.f6111k;
        track.f7065r = this.f6107g;
        track.f7066s = this.f6109i.ordinal();
        track.f7064q = this.f6106f.getType();
        track.f6721d = this.f6108h;
        track.f7052C = this.f6116p;
        return track;
    }

    public BitmapDescriptor getPalette() {
        return this.f6110j;
    }

    public float getPaletteOpacity() {
        return this.f6114n;
    }

    public List<LatLng> getPoints() {
        return this.f6101a;
    }

    public BitmapDescriptor getProjectionPaletteDescriptor() {
        return this.f6111k;
    }

    public BMTrackType getTrackType() {
        return this.f6106f;
    }

    public int getWidth() {
        return this.f6112l;
    }

    public boolean isVisible() {
        return this.f6108h;
    }

    public OverlayOptions setAnimateType(BMTrackAnimateType bMTrackAnimateType) {
        this.f6109i = bMTrackAnimateType;
        return this;
    }

    public OverlayOptions setAnimationTime(int i4) {
        this.f6107g = i4;
        return this;
    }

    public OverlayOptions setColor(int i4) {
        this.f6103c = i4;
        return this;
    }

    public OverlayOptions setColors(int[] iArr) {
        this.f6104d = iArr;
        return this;
    }

    public OverlayOptions setColorsArray(List<Integer> list) {
        this.f6102b = list;
        return this;
    }

    public OverlayOptions setHeights(int[] iArr) {
        this.f6105e = iArr;
        return this;
    }

    public void setOpacity(float f4) {
        this.f6113m = f4;
    }

    public OverlayOptions setPalette(BitmapDescriptor bitmapDescriptor) {
        this.f6110j = bitmapDescriptor;
        return this;
    }

    public void setPaletteOpacity(float f4) {
        this.f6114n = f4;
    }

    public OverlayOptions setPoints(List<LatLng> list) {
        this.f6101a = list;
        return this;
    }

    public OverlayOptions setProjectionPalette(BitmapDescriptor bitmapDescriptor) {
        this.f6111k = bitmapDescriptor;
        return this;
    }

    public OverlayOptions setTraceAnimationListener(TraceAnimationListener traceAnimationListener) {
        this.f6116p = traceAnimationListener;
        return this;
    }

    public void setTrackMove(boolean z4) {
        this.f6115o = z4;
    }

    public OverlayOptions setTrackType(BMTrackType bMTrackType) {
        this.f6106f = bMTrackType;
        return this;
    }

    public OverlayOptions setVisible(boolean z4) {
        this.f6108h = z4;
        return this;
    }

    public OverlayOptions setWidth(int i4) {
        this.f6112l = i4;
        return this;
    }
}
