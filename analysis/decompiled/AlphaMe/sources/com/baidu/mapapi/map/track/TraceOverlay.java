package com.baidu.mapapi.map.track;

import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.z.b;
import com.baidu.platform.comapi.UIMsg;
import java.util.List;

/* loaded from: classes.dex */
public class TraceOverlay {

    /* renamed from: c, reason: collision with root package name */
    List<LatLng> f7210c;

    /* renamed from: d, reason: collision with root package name */
    int[] f7211d;

    /* renamed from: g, reason: collision with root package name */
    boolean f7214g;

    /* renamed from: h, reason: collision with root package name */
    boolean f7215h;

    /* renamed from: i, reason: collision with root package name */
    int f7216i;

    /* renamed from: j, reason: collision with root package name */
    boolean f7217j;
    public b mListener;

    /* renamed from: o, reason: collision with root package name */
    BitmapDescriptor f7222o;

    /* renamed from: p, reason: collision with root package name */
    BM3DModelOptions f7223p;

    /* renamed from: a, reason: collision with root package name */
    int f7208a = -265058817;

    /* renamed from: b, reason: collision with root package name */
    int f7209b = 14;

    /* renamed from: e, reason: collision with root package name */
    int f7212e = UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME;

    /* renamed from: f, reason: collision with root package name */
    int f7213f = 0;

    /* renamed from: k, reason: collision with root package name */
    boolean f7218k = true;

    /* renamed from: l, reason: collision with root package name */
    boolean f7219l = false;

    /* renamed from: m, reason: collision with root package name */
    boolean f7220m = true;

    /* renamed from: n, reason: collision with root package name */
    boolean f7221n = true;

    /* renamed from: q, reason: collision with root package name */
    boolean f7224q = false;

    /* renamed from: r, reason: collision with root package name */
    float f7225r = 5.0f;

    /* renamed from: s, reason: collision with root package name */
    boolean f7226s = false;

    /* renamed from: t, reason: collision with root package name */
    boolean f7227t = false;

    public void clear() {
        this.mListener.b(this);
    }

    public int getAnimationDuration() {
        return this.f7213f;
    }

    public int getAnimationTime() {
        return this.f7212e;
    }

    public int getAnimationType() {
        return this.f7216i;
    }

    public float getBloomSpeed() {
        return this.f7225r;
    }

    public int getColor() {
        return this.f7208a;
    }

    public int[] getColors() {
        return this.f7211d;
    }

    public BitmapDescriptor getIcon() {
        return this.f7222o;
    }

    public BM3DModelOptions getIcon3D() {
        return this.f7223p;
    }

    public LatLngBounds getLatLngBounds() {
        List<LatLng> list = this.f7210c;
        if (list == null || list.size() == 0) {
            return null;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(this.f7210c);
        return builder.build();
    }

    public List<LatLng> getPoints() {
        return this.f7210c;
    }

    public int getWidth() {
        return this.f7209b;
    }

    public void icon(BitmapDescriptor bitmapDescriptor) {
        this.f7222o = bitmapDescriptor;
    }

    public void icon3D(BM3DModelOptions bM3DModelOptions) {
        this.f7223p = bM3DModelOptions;
    }

    public boolean isAnimate() {
        return this.f7215h;
    }

    public boolean isDataReduction() {
        return this.f7220m;
    }

    public boolean isDataSmooth() {
        return this.f7221n;
    }

    public boolean isOnPause() {
        return this.f7227t;
    }

    public boolean isPointMove() {
        return this.f7219l;
    }

    public boolean isRotateWhenTrack() {
        return this.f7218k;
    }

    public boolean isStatusChanged() {
        return this.f7226s;
    }

    public boolean isTrackBloom() {
        return this.f7224q;
    }

    public boolean isTrackMove() {
        return this.f7217j;
    }

    public boolean isUseColorArray() {
        return this.f7214g;
    }

    public void pause() {
        this.f7226s = true;
        this.f7227t = true;
        this.mListener.a(this);
    }

    public void remove() {
        this.mListener.c(this);
    }

    public void resume() {
        this.f7227t = false;
        this.f7226s = true;
        this.mListener.a(this);
        this.f7226s = false;
    }

    public void setAnimate(boolean z4) {
        this.f7215h = z4;
    }

    public void setAnimationDuration(int i4) {
        this.f7213f = i4;
    }

    public void setAnimationTime(int i4) {
        if (i4 < 300) {
            throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
        }
        this.f7212e = i4;
    }

    public void setBloomSpeed(float f4) {
        this.f7225r = f4;
    }

    public void setColor(int i4) {
        this.f7208a = i4;
    }

    public void setDataReduction(boolean z4) {
        this.f7220m = z4;
    }

    public void setDataSmooth(boolean z4) {
        this.f7221n = z4;
    }

    public void setPointMove(boolean z4) {
        this.f7219l = z4;
    }

    public void setRotateWhenTrack(boolean z4) {
        this.f7218k = z4;
    }

    public void setTraceAnimationType(TraceOptions.TraceAnimateType traceAnimateType) {
        if (traceAnimateType == null) {
            traceAnimateType = TraceOptions.TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
        }
        this.f7216i = traceAnimateType.ordinal();
    }

    public void setTraceColors(int[] iArr) {
        this.f7211d = iArr;
    }

    public void setTracePoints(List<LatLng> list) {
        this.f7210c = list;
    }

    public void setTrackBloom(boolean z4) {
        this.f7224q = z4;
    }

    public void setTrackMove(boolean z4) {
        this.f7217j = z4;
    }

    public void setWidth(int i4) {
        this.f7209b = i4;
    }

    public void update() {
        this.mListener.a(this);
    }

    public void useColorArray(boolean z4) {
        this.f7214g = z4;
    }
}
