package com.baidu.mapapi.map.track;

import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.UIMsg;
import java.util.List;

/* loaded from: classes.dex */
public class TraceOptions {

    /* renamed from: c, reason: collision with root package name */
    private List<LatLng> f7191c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f7192d;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7195g;

    /* renamed from: h, reason: collision with root package name */
    private int f7196h;

    /* renamed from: m, reason: collision with root package name */
    private BitmapDescriptor f7201m;

    /* renamed from: p, reason: collision with root package name */
    private BM3DModelOptions f7204p;

    /* renamed from: a, reason: collision with root package name */
    private int f7189a = -15794282;

    /* renamed from: b, reason: collision with root package name */
    private int f7190b = 14;

    /* renamed from: e, reason: collision with root package name */
    private int f7193e = UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7194f = false;

    /* renamed from: i, reason: collision with root package name */
    private int f7197i = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear.ordinal();

    /* renamed from: j, reason: collision with root package name */
    private boolean f7198j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7199k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7200l = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7202n = true;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7203o = true;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7205q = false;

    /* renamed from: r, reason: collision with root package name */
    private float f7206r = 5.0f;

    public enum TraceAnimateType {
        TraceOverlayAnimationEasingCurveLinear,
        TraceOverlayAnimationEasingCurveEaseIn,
        TraceOverlayAnimationEasingCurveEaseOut,
        TraceOverlayAnimationEasingCurveEaseInOut
    }

    public TraceOptions animate(boolean z4) {
        this.f7194f = z4;
        return this;
    }

    public TraceOptions animationDuration(int i4) {
        this.f7196h = i4;
        return this;
    }

    public TraceOptions animationTime(int i4) {
        if (i4 < 300) {
            throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
        }
        this.f7193e = i4;
        return this;
    }

    public TraceOptions animationType(TraceAnimateType traceAnimateType) {
        if (traceAnimateType == null) {
            traceAnimateType = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
        }
        this.f7197i = traceAnimateType.ordinal();
        return this;
    }

    public TraceOptions color(int i4) {
        this.f7189a = i4;
        return this;
    }

    public TraceOptions colors(int[] iArr) {
        this.f7192d = iArr;
        return this;
    }

    public TraceAnimateType getAnimateType() {
        int i4 = this.f7197i;
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? TraceAnimateType.TraceOverlayAnimationEasingCurveLinear : TraceAnimateType.TraceOverlayAnimationEasingCurveEaseInOut : TraceAnimateType.TraceOverlayAnimationEasingCurveEaseOut : TraceAnimateType.TraceOverlayAnimationEasingCurveEaseIn;
    }

    public int getAnimationDuration() {
        return this.f7196h;
    }

    public int getAnimationTime() {
        return this.f7193e;
    }

    public float getBloomSpeed() {
        return this.f7206r;
    }

    public int getColor() {
        return this.f7189a;
    }

    public int[] getColors() {
        return this.f7192d;
    }

    public BitmapDescriptor getIcon() {
        return this.f7201m;
    }

    public TraceOverlay getOverlay() {
        TraceOverlay traceOverlay = new TraceOverlay();
        traceOverlay.f7208a = this.f7189a;
        traceOverlay.f7209b = this.f7190b;
        traceOverlay.f7210c = this.f7191c;
        traceOverlay.f7212e = this.f7193e;
        traceOverlay.f7215h = this.f7194f;
        boolean z4 = this.f7195g;
        traceOverlay.f7214g = z4;
        if (z4) {
            traceOverlay.f7211d = this.f7192d;
        }
        traceOverlay.f7213f = this.f7196h;
        traceOverlay.f7216i = this.f7197i;
        traceOverlay.f7217j = this.f7198j;
        traceOverlay.f7218k = this.f7199k;
        traceOverlay.f7219l = this.f7200l;
        traceOverlay.f7222o = this.f7201m;
        traceOverlay.f7220m = this.f7202n;
        traceOverlay.f7221n = this.f7203o;
        traceOverlay.f7223p = this.f7204p;
        boolean z5 = this.f7205q;
        traceOverlay.f7224q = z5;
        if (z5) {
            traceOverlay.f7225r = this.f7206r;
        }
        return traceOverlay;
    }

    public List<LatLng> getPoints() {
        return this.f7191c;
    }

    public int getWidth() {
        return this.f7190b;
    }

    public TraceOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: trace's icon can not be null");
        }
        this.f7201m = bitmapDescriptor;
        return this;
    }

    public TraceOptions icon3D(BM3DModelOptions bM3DModelOptions) {
        this.f7204p = bM3DModelOptions;
        return this;
    }

    public boolean isAnimation() {
        return this.f7194f;
    }

    public boolean isPointMove() {
        return this.f7200l;
    }

    public boolean isRotateWhenTrack() {
        return this.f7199k;
    }

    public boolean isTrackMove() {
        return this.f7198j;
    }

    public boolean isUseColorarray() {
        return this.f7195g;
    }

    public TraceOptions points(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.f7191c = list;
        return this;
    }

    public TraceOptions setBloomSpeed(float f4) {
        this.f7206r = f4;
        return this;
    }

    public TraceOptions setDataReduction(boolean z4) {
        this.f7202n = z4;
        return this;
    }

    public TraceOptions setDataSmooth(boolean z4) {
        this.f7203o = z4;
        return this;
    }

    public TraceOptions setPointMove(boolean z4) {
        this.f7200l = z4;
        return this;
    }

    public TraceOptions setRotateWhenTrack(boolean z4) {
        this.f7199k = z4;
        return this;
    }

    public TraceOptions setTrackBloom(boolean z4) {
        this.f7205q = z4;
        return this;
    }

    public TraceOptions setTrackMove(boolean z4) {
        this.f7198j = z4;
        return this;
    }

    public TraceOptions useColorArray(boolean z4) {
        this.f7195g = z4;
        return this;
    }

    public TraceOptions width(int i4) {
        this.f7190b = i4;
        return this;
    }
}
