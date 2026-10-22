package com.amap.api.mapcore.util;

import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.amap.api.maps.UiSettings;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;

/* JADX INFO: loaded from: classes28.dex */
class i0 implements IUiSettingsDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAMapDelegate f27410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f27411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f27412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f27413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f27414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f27415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f27416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f27418i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f27419j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f27420k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f27421l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f27422m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f27423n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f27424o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f27425p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final Handler f27426q;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i0 f27427a;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (i0.a(this.f27427a) == null) goto L25;
        L17:
            th = move-exception;
            t6.a(th, "UiSettingsDelegateImp", "handleMessage");
            return;
        L7:
            switch(r100.what) {
                case 0: goto L15;
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                default: goto L20;
            };     // Catch: Throwable -> L17
        L9:
            i0.a(this.f27427a).refreshLogo();     // Catch: Throwable -> L17
            goto L20
        L10:
            i0.a(this.f27427a).showLogoEnabled(i0.g(this.f27427a));     // Catch: Throwable -> L17
            goto L20
        L11:
            i0.a(this.f27427a).showIndoorSwitchControlsEnabled(i0.f(this.f27427a));     // Catch: Throwable -> L17
            goto L20
        L12:
            i0.a(this.f27427a).showMyLocationButtonEnabled(i0.e(this.f27427a));     // Catch: Throwable -> L17
            goto L20
        L13:
            i0.a(this.f27427a).showCompassEnabled(i0.d(this.f27427a));     // Catch: Throwable -> L17
            goto L20
        L14:
            i0.a(this.f27427a).showScaleEnabled(i0.c(this.f27427a));     // Catch: Throwable -> L17
            goto L20
        L15:
            i0.a(this.f27427a).showZoomControlsEnabled(i0.b(this.f27427a));     // Catch: Throwable -> L17
        L20:
            return;
        }

        public a(i0 r100, Looper r101) {
            this.f27427a = r100;
            super(r101);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public Point getLogoSize() throws RemoteException {
        return this.f27410a.getLogoSize();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public UiSettings.ScaleControlsUnit getScaleControlsUnit() {
        return this.f27410a.getScaleControlsUnit();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void requestRefreshLogo() {
        this.f27426q.obtainMessage(6).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public int getLogoPosition() throws RemoteException {
        return this.f27420k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public float getLogoSizeScale() throws RemoteException {
        return this.f27421l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public int getZoomPosition() throws RemoteException {
        return this.f27422m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isCompassEnabled() throws RemoteException {
        return this.f27417h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.f27425p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.f27423n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isLogoEnable() {
        return this.f27419j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.f27414e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isRotateGesturesEnabled() throws RemoteException {
        return this.f27411b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isScaleControlsEnabled() throws RemoteException {
        return this.f27418i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isScrollGesturesEnabled() throws RemoteException {
        return this.f27412c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isTiltGesturesEnabled() throws RemoteException {
        return this.f27413d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomControlsEnabled() throws RemoteException {
        return this.f27416g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomGesturesEnabled() throws RemoteException {
        return this.f27415f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomInByScreenCenter() {
        return this.f27424o;
    }

    public i0(IAMapDelegate r100) {
        this.f27411b = true;
        this.f27412c = true;
        this.f27413d = true;
        this.f27414e = false;
        this.f27415f = true;
        this.f27416g = true;
        this.f27417h = true;
        this.f27418i = false;
        this.f27419j = true;
        this.f27420k = 0;
        this.f27421l = 1.0f;
        this.f27422m = 1;
        this.f27423n = true;
        this.f27424o = false;
        this.f27425p = false;
        this.f27426q = new a(this, Looper.getMainLooper());
        this.f27410a = r100;
    }

    public static /* synthetic */ IAMapDelegate a(i0 r100) {
        return r100.f27410a;
    }

    public static /* synthetic */ boolean b(i0 r100) {
        return r100.f27416g;
    }

    public static /* synthetic */ boolean c(i0 r100) {
        return r100.f27418i;
    }

    public static /* synthetic */ boolean d(i0 r100) {
        return r100.f27417h;
    }

    public static /* synthetic */ boolean e(i0 r100) {
        return r100.f27414e;
    }

    public static /* synthetic */ boolean f(i0 r100) {
        return r100.f27423n;
    }

    public static /* synthetic */ boolean g(i0 r100) {
        return r100.f27419j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public float getLogoMarginRate(int r100) {
        return this.f27410a.getLogoMarginRate(r100);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setAllGesturesEnabled(boolean r100) throws RemoteException {
        this.f27411b = r100;
        this.f27413d = r100;
        this.f27415f = r100;
        this.f27412c = r100;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setCompassEnabled(boolean r100) throws RemoteException {
        this.f27417h = r100;
        this.f27426q.obtainMessage(2).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setGestureScaleByMapCenter(boolean r100) throws RemoteException {
        this.f27425p = r100;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setIndoorSwitchEnabled(boolean r100) throws RemoteException {
        this.f27423n = r100;
        this.f27426q.obtainMessage(4).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLayoutDirectionRtl(boolean r100) {
        IAMapDelegate r101 = this.f27410a;
        if (r101 == null) goto L6;
        r101.setLayoutDirectionRtl(r100);
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoBottomMargin(int r100) {
        this.f27410a.setLogoBottomMargin(r100);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoEnable(boolean r100) {
        this.f27419j = r100;
        this.f27426q.obtainMessage(5).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoLeftMargin(int r100) {
        this.f27410a.setLogoLeftMargin(r100);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoPosition(int r100) throws RemoteException {
        this.f27420k = r100;
        this.f27410a.setLogoPosition(r100);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoSizeScale(float r100) throws RemoteException {
        if (Float.isNaN(r100) == false) goto L5;
    L8:
        r100 = 1.0f;
    L9:
        this.f27421l = r100;
        this.f27410a.setLogoSizeScale(r100);
        return;
    L5:
        if (Float.isInfinite(r100) == true) goto L8;
        if (r100 > 0.0f) goto L9;
        goto L8
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setMyLocationButtonEnabled(boolean r100) throws RemoteException {
        this.f27414e = r100;
        this.f27426q.obtainMessage(3).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setRotateGesturesEnabled(boolean r100) throws RemoteException {
        this.f27411b = r100;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setScaleControlsEnabled(boolean r100) throws RemoteException {
        this.f27418i = r100;
        this.f27426q.obtainMessage(1).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setScaleControlsPosition(Point r100) {
        IAMapDelegate r101 = this.f27410a;
        if (r101 == null) goto L6;
        r101.setScaleControlsPosition(r100);
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setScaleControlsUnit(UiSettings.ScaleControlsUnit r100) {
        this.f27410a.setScaleControlsUnit(r100);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setScrollGesturesEnabled(boolean r100) throws RemoteException {
        this.f27412c = r100;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setTiltGesturesEnabled(boolean r100) throws RemoteException {
        this.f27413d = r100;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomControlsEnabled(boolean r100) throws RemoteException {
        this.f27416g = r100;
        this.f27426q.obtainMessage(0).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomGesturesEnabled(boolean r100) throws RemoteException {
        this.f27415f = r100;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomInByScreenCenter(boolean r100) {
        this.f27424o = r100;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomPosition(int r100) throws RemoteException {
        this.f27422m = r100;
        this.f27410a.setZoomPosition(r100);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoMarginRate(int r100, float r101) {
        this.f27410a.setLogoMarginRate(r100, r101);
    }
}
