package com.baidu.mapapi.map.track;

import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class TraceOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f31624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<LatLng> f31626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f31627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f31629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f31630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f31631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f31633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f31634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f31635l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private BitmapDescriptor f31636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f31637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f31638o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BM3DModelOptions f31639p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f31640q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f31641r;

    public static final enum TraceAnimateType extends Enum<TraceAnimateType> {
        public static final TraceAnimateType TraceOverlayAnimationEasingCurveEaseIn = null;
        public static final TraceAnimateType TraceOverlayAnimationEasingCurveEaseInOut = null;
        public static final TraceAnimateType TraceOverlayAnimationEasingCurveEaseOut = null;
        public static final TraceAnimateType TraceOverlayAnimationEasingCurveLinear = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ TraceAnimateType[] f31642a = null;

        static {
            TraceAnimateType r100 = new TraceAnimateType("TraceOverlayAnimationEasingCurveLinear", 0);
            TraceOverlayAnimationEasingCurveLinear = r100;
            TraceAnimateType r101 = new TraceAnimateType("TraceOverlayAnimationEasingCurveEaseIn", 1);
            TraceOverlayAnimationEasingCurveEaseIn = r101;
            TraceAnimateType r102 = new TraceAnimateType("TraceOverlayAnimationEasingCurveEaseOut", 2);
            TraceOverlayAnimationEasingCurveEaseOut = r102;
            TraceAnimateType r103 = new TraceAnimateType("TraceOverlayAnimationEasingCurveEaseInOut", 3);
            TraceOverlayAnimationEasingCurveEaseInOut = r103;
            f31642a = new TraceAnimateType[]{r100, r101, r102, r103};
        }

        public static TraceAnimateType[] values() {
            return (TraceAnimateType[]) f31642a.clone();
        }

        public static TraceAnimateType valueOf(String r100) {
            return (TraceAnimateType) a.a(TraceAnimateType.class, r100);
        }

        private TraceAnimateType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TraceAnimateType getAnimateType() {
        int r100 = this.f31632i;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
    L11:
        return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseInOut;
    L13:
        return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseOut;
    L15:
        return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseIn;
    }

    public TraceOverlay getOverlay() {
        TraceOverlay r100 = new TraceOverlay();
        r100.f31643a = this.f31624a;
        r100.f31644b = this.f31625b;
        r100.f31645c = this.f31626c;
        r100.f31647e = this.f31628e;
        r100.f31650h = this.f31629f;
        boolean r101 = this.f31630g;
        r100.f31649g = r101;
        if (r101 == false) goto L5;
        r100.f31646d = this.f31627d;
    L5:
        r100.f31648f = this.f31631h;
        r100.f31651i = this.f31632i;
        r100.f31652j = this.f31633j;
        r100.f31653k = this.f31634k;
        r100.f31654l = this.f31635l;
        r100.f31657o = this.f31636m;
        r100.f31655m = this.f31637n;
        r100.f31656n = this.f31638o;
        r100.f31658p = this.f31639p;
        boolean r102 = this.f31640q;
        r100.f31659q = r102;
        if (r102 == false) goto L8;
        r100.f31660r = this.f31641r;
    L8:
        return r100;
    }

    public TraceOptions() {
        this.f31624a = -15794282;
        this.f31625b = 14;
        this.f31628e = 300;
        this.f31629f = false;
        this.f31632i = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear.ordinal();
        this.f31633j = false;
        this.f31634k = true;
        this.f31635l = false;
        this.f31637n = true;
        this.f31638o = true;
        this.f31640q = false;
        this.f31641r = 5.0f;
    }

    public int getAnimationDuration() {
        return this.f31631h;
    }

    public int getAnimationTime() {
        return this.f31628e;
    }

    public float getBloomSpeed() {
        return this.f31641r;
    }

    public int getColor() {
        return this.f31624a;
    }

    public int[] getColors() {
        return this.f31627d;
    }

    public BitmapDescriptor getIcon() {
        return this.f31636m;
    }

    public List<LatLng> getPoints() {
        return this.f31626c;
    }

    public int getWidth() {
        return this.f31625b;
    }

    public boolean isAnimation() {
        return this.f31629f;
    }

    public boolean isPointMove() {
        return this.f31635l;
    }

    public boolean isRotateWhenTrack() {
        return this.f31634k;
    }

    public boolean isTrackMove() {
        return this.f31633j;
    }

    public boolean isUseColorarray() {
        return this.f31630g;
    }

    public TraceOptions animate(boolean r100) {
        this.f31629f = r100;
        return this;
    }

    public TraceOptions animationDuration(int r100) {
        this.f31631h = r100;
        return this;
    }

    public TraceOptions animationTime(int r100) {
        if (r100 < 300) goto L7;
        this.f31628e = r100;
        return this;
    L7:
        throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
    }

    public TraceOptions animationType(TraceAnimateType r100) {
        if (r100 != null) goto L4;
        r100 = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
    L4:
        this.f31632i = r100.ordinal();
        return this;
    }

    public TraceOptions color(int r100) {
        this.f31624a = r100;
        return this;
    }

    public TraceOptions colors(int[] r100) {
        this.f31627d = r100;
        return this;
    }

    public TraceOptions icon(BitmapDescriptor r100) {
        if (r100 == null) goto L6;
        this.f31636m = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: trace's icon can not be null");
    }

    public TraceOptions icon3D(BM3DModelOptions r100) {
        this.f31639p = r100;
        return this;
    }

    public TraceOptions points(List<LatLng> r100) {
        if (r100 == null) goto L14;
        if (r100.size() < 2) goto L12;
        if (r100.contains(null) == true) goto L10;
        this.f31626c = r100;
        return this;
    L10:
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
    L12:
        throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
    L14:
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public TraceOptions setBloomSpeed(float r100) {
        this.f31641r = r100;
        return this;
    }

    public TraceOptions setDataReduction(boolean r100) {
        this.f31637n = r100;
        return this;
    }

    public TraceOptions setDataSmooth(boolean r100) {
        this.f31638o = r100;
        return this;
    }

    public TraceOptions setPointMove(boolean r100) {
        this.f31635l = r100;
        return this;
    }

    public TraceOptions setRotateWhenTrack(boolean r100) {
        this.f31634k = r100;
        return this;
    }

    public TraceOptions setTrackBloom(boolean r100) {
        this.f31640q = r100;
        return this;
    }

    public TraceOptions setTrackMove(boolean r100) {
        this.f31633j = r100;
        return this;
    }

    public TraceOptions useColorArray(boolean r100) {
        this.f31630g = r100;
        return this;
    }

    public TraceOptions width(int r100) {
        this.f31625b = r100;
        return this;
    }
}
