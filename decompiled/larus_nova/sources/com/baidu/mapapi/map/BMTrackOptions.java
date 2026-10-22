package com.baidu.mapapi.map;

import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.model.LatLng;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class BMTrackOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LatLng> f30643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Integer> f30644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f30646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f30647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BMTrackType f30648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f30649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f30650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BMTrackAnimateType f30651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BitmapDescriptor f30652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BitmapDescriptor f30653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f30654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f30655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float f30656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f30657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TraceAnimationListener f30658p;

    public static final enum BMTrackAnimateType extends Enum<BMTrackAnimateType> {
        public static final BMTrackAnimateType TraceOverlayAnimationEasingCurveEaseIn = null;
        public static final BMTrackAnimateType TraceOverlayAnimationEasingCurveEaseInOut = null;
        public static final BMTrackAnimateType TraceOverlayAnimationEasingCurveEaseOut = null;
        public static final BMTrackAnimateType TraceOverlayAnimationEasingCurveLinear = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ BMTrackAnimateType[] f30659a = null;

        static {
            BMTrackAnimateType r100 = new BMTrackAnimateType("TraceOverlayAnimationEasingCurveLinear", 0);
            TraceOverlayAnimationEasingCurveLinear = r100;
            BMTrackAnimateType r101 = new BMTrackAnimateType("TraceOverlayAnimationEasingCurveEaseIn", 1);
            TraceOverlayAnimationEasingCurveEaseIn = r101;
            BMTrackAnimateType r102 = new BMTrackAnimateType("TraceOverlayAnimationEasingCurveEaseOut", 2);
            TraceOverlayAnimationEasingCurveEaseOut = r102;
            BMTrackAnimateType r103 = new BMTrackAnimateType("TraceOverlayAnimationEasingCurveEaseInOut", 3);
            TraceOverlayAnimationEasingCurveEaseInOut = r103;
            f30659a = new BMTrackAnimateType[]{r100, r101, r102, r103};
        }

        public static BMTrackAnimateType[] values() {
            return (BMTrackAnimateType[]) f30659a.clone();
        }

        public static BMTrackAnimateType valueOf(String r100) {
            return (BMTrackAnimateType) r27.a.a(BMTrackAnimateType.class, r100);
        }

        private BMTrackAnimateType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        List<LatLng> r100 = this.f30643a;
        if (r100 != null) goto L5;
    L24:
        return null;
    L5:
        if (r100.size() <= 1) goto L24;
        BMTrackType r101 = this.f30648f;
        if (r101 != BMTrackType.Default3D) goto L10;
    L11:
        int[] r102 = this.f30647e;
        if (r102 == null) goto L24;
        if (r102.length != this.f30643a.size()) goto L24;
    L16:
        Track r103 = new Track();
        int[] r104 = this.f30647e;
        if (r104 != null) goto L19;
    L21:
        int[] r105 = new int[this.f30643a.size()];
        r103.f31504o = r105;
        Arrays.fill(r105, 1);
    L22:
        r103.f31511v = this.f30645c;
        r103.f31505p = this.f30646d;
        r103.f31512w = this.f30655m;
        r103.f31513x = this.f30656n;
        r103.setTrackMove(this.f30657o);
        r103.f31503n = this.f30643a;
        r103.f31502m = this.f30644b;
        r103.f31510u = this.f30654l;
        r103.A = this.f30652j;
        r103.B = this.f30653k;
        r103.f31507r = this.f30649g;
        r103.f31508s = this.f30651i.ordinal();
        r103.f31506q = this.f30648f.getType();
        r103.f31205d = this.f30650h;
        r103.C = this.f30658p;
        return r103;
    L19:
        if (r104.length != this.f30643a.size()) goto L21;
        r103.f31504o = this.f30647e;
        goto L22
    L10:
        if (r101 != BMTrackType.Surface) goto L16;
        goto L11
    }

    public BMTrackOptions() {
        this.f30648f = BMTrackType.Surface;
        this.f30649g = 3000;
        this.f30650h = true;
        this.f30651i = BMTrackAnimateType.TraceOverlayAnimationEasingCurveLinear;
        this.f30652j = BitmapDescriptorFactory.fromAsset("track_palette.png");
        this.f30653k = BitmapDescriptorFactory.fromAsset("track_projection_palette.png");
        this.f30654l = 5;
        this.f30655m = 1.0f;
        this.f30656n = 0.3f;
        this.f30657o = false;
    }

    public BMTrackAnimateType getAnimateType() {
        return this.f30651i;
    }

    public int getAnimationTime() {
        return this.f30649g;
    }

    public int[] getColors() {
        return this.f30646d;
    }

    public int[] getHeights() {
        return this.f30647e;
    }

    public float getOpacity() {
        return this.f30655m;
    }

    public BitmapDescriptor getPalette() {
        return this.f30652j;
    }

    public float getPaletteOpacity() {
        return this.f30656n;
    }

    public List<LatLng> getPoints() {
        return this.f30643a;
    }

    public BitmapDescriptor getProjectionPaletteDescriptor() {
        return this.f30653k;
    }

    public BMTrackType getTrackType() {
        return this.f30648f;
    }

    public int getWidth() {
        return this.f30654l;
    }

    public boolean isVisible() {
        return this.f30650h;
    }

    public OverlayOptions setAnimateType(BMTrackAnimateType r100) {
        this.f30651i = r100;
        return this;
    }

    public OverlayOptions setAnimationTime(int r100) {
        this.f30649g = r100;
        return this;
    }

    public OverlayOptions setColor(int r100) {
        this.f30645c = r100;
        return this;
    }

    public OverlayOptions setColors(int[] r100) {
        this.f30646d = r100;
        return this;
    }

    public OverlayOptions setColorsArray(List<Integer> r100) {
        this.f30644b = r100;
        return this;
    }

    public OverlayOptions setHeights(int[] r100) {
        this.f30647e = r100;
        return this;
    }

    public void setOpacity(float r100) {
        this.f30655m = r100;
    }

    public OverlayOptions setPalette(BitmapDescriptor r100) {
        this.f30652j = r100;
        return this;
    }

    public void setPaletteOpacity(float r100) {
        this.f30656n = r100;
    }

    public OverlayOptions setPoints(List<LatLng> r100) {
        this.f30643a = r100;
        return this;
    }

    public OverlayOptions setProjectionPalette(BitmapDescriptor r100) {
        this.f30653k = r100;
        return this;
    }

    public OverlayOptions setTraceAnimationListener(TraceAnimationListener r100) {
        this.f30658p = r100;
        return this;
    }

    public void setTrackMove(boolean r100) {
        this.f30657o = r100;
    }

    public OverlayOptions setTrackType(BMTrackType r100) {
        this.f30648f = r100;
        return this;
    }

    public OverlayOptions setVisible(boolean r100) {
        this.f30650h = r100;
        return this;
    }

    public OverlayOptions setWidth(int r100) {
        this.f30654l = r100;
        return this;
    }
}
