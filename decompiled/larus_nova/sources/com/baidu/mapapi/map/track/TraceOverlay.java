package com.baidu.mapapi.map.track;

import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.z.b;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class TraceOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f31643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f31644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    List<LatLng> f31645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f31646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f31647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f31648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f31649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f31650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f31651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f31652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f31653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f31654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f31655m;
    public b mListener;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f31656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    BitmapDescriptor f31657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    BM3DModelOptions f31658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f31659q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    float f31660r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f31661s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f31662t;

    public void pause() {
        this.f31661s = true;
        this.f31662t = true;
        this.mListener.a(this);
    }

    public void resume() {
        this.f31662t = false;
        this.f31661s = true;
        this.mListener.a(this);
        this.f31661s = false;
    }

    public void clear() {
        this.mListener.b(this);
    }

    public LatLngBounds getLatLngBounds() {
        List<LatLng> r100 = this.f31645c;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.size() == 0) goto L11;
        LatLngBounds.Builder r101 = new LatLngBounds.Builder();
        r101.include(this.f31645c);
        return r101.build();
    L11:
        return null;
    }

    public void remove() {
        this.mListener.c(this);
    }

    public void update() {
        this.mListener.a(this);
    }

    public TraceOverlay() {
        this.f31643a = -265058817;
        this.f31644b = 14;
        this.f31647e = 300;
        this.f31648f = 0;
        this.f31653k = true;
        this.f31654l = false;
        this.f31655m = true;
        this.f31656n = true;
        this.f31659q = false;
        this.f31660r = 5.0f;
        this.f31661s = false;
        this.f31662t = false;
    }

    public int getAnimationDuration() {
        return this.f31648f;
    }

    public int getAnimationTime() {
        return this.f31647e;
    }

    public int getAnimationType() {
        return this.f31651i;
    }

    public float getBloomSpeed() {
        return this.f31660r;
    }

    public int getColor() {
        return this.f31643a;
    }

    public int[] getColors() {
        return this.f31646d;
    }

    public BitmapDescriptor getIcon() {
        return this.f31657o;
    }

    public BM3DModelOptions getIcon3D() {
        return this.f31658p;
    }

    public List<LatLng> getPoints() {
        return this.f31645c;
    }

    public int getWidth() {
        return this.f31644b;
    }

    public boolean isAnimate() {
        return this.f31650h;
    }

    public boolean isDataReduction() {
        return this.f31655m;
    }

    public boolean isDataSmooth() {
        return this.f31656n;
    }

    public boolean isOnPause() {
        return this.f31662t;
    }

    public boolean isPointMove() {
        return this.f31654l;
    }

    public boolean isRotateWhenTrack() {
        return this.f31653k;
    }

    public boolean isStatusChanged() {
        return this.f31661s;
    }

    public boolean isTrackBloom() {
        return this.f31659q;
    }

    public boolean isTrackMove() {
        return this.f31652j;
    }

    public boolean isUseColorArray() {
        return this.f31649g;
    }

    public void icon(BitmapDescriptor r100) {
        this.f31657o = r100;
    }

    public void icon3D(BM3DModelOptions r100) {
        this.f31658p = r100;
    }

    public void setAnimate(boolean r100) {
        this.f31650h = r100;
    }

    public void setAnimationDuration(int r100) {
        this.f31648f = r100;
    }

    public void setAnimationTime(int r100) {
        if (r100 < 300) goto L7;
        this.f31647e = r100;
        return;
    L7:
        throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
    }

    public void setBloomSpeed(float r100) {
        this.f31660r = r100;
    }

    public void setColor(int r100) {
        this.f31643a = r100;
    }

    public void setDataReduction(boolean r100) {
        this.f31655m = r100;
    }

    public void setDataSmooth(boolean r100) {
        this.f31656n = r100;
    }

    public void setPointMove(boolean r100) {
        this.f31654l = r100;
    }

    public void setRotateWhenTrack(boolean r100) {
        this.f31653k = r100;
    }

    public void setTraceAnimationType(TraceOptions.TraceAnimateType r100) {
        if (r100 != null) goto L4;
        r100 = TraceOptions.TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
    L4:
        this.f31651i = r100.ordinal();
    }

    public void setTraceColors(int[] r100) {
        this.f31646d = r100;
    }

    public void setTracePoints(List<LatLng> r100) {
        this.f31645c = r100;
    }

    public void setTrackBloom(boolean r100) {
        this.f31659q = r100;
    }

    public void setTrackMove(boolean r100) {
        this.f31652j = r100;
    }

    public void setWidth(int r100) {
        this.f31644b = r100;
    }

    public void useColorArray(boolean r100) {
        this.f31649g = r100;
    }
}
