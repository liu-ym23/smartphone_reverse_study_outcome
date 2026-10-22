package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* JADX INFO: loaded from: classes28.dex */
public class q2 implements IInfoWindowAction, IInfoWindowManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IGlOverlayLayer f27889a;

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public synchronized void hideInfoWindow() {
        monitor-enter(this);
        IGlOverlayLayer r100 = this.f27889a;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.getNativeProperties("PopupOverlay", "hideInfoWindow", null);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowAnimation(Animation r100, Animation.AnimationListener r101) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowAppearAnimation(Animation r100) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackColor(int r100) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackEnable(boolean r100) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackScale(float r100, float r101) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowDisappearAnimation(Animation r100) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowMovingAnimation(Animation r100) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public synchronized void showInfoWindow(BaseOverlayImp r100) throws RemoteException {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void startAnimation() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void redrawInfoWindow() {
        IGlOverlayLayer r100 = this.f27889a;
        if (r100 == null) goto L6;
        r100.getNativeProperties("PopupOverlay", "redrawInfoWindow", null);
        return;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean onInfoWindowTap(MotionEvent r100) {
        IGlOverlayLayer r101 = this.f27889a;
        if (r101 == null) goto L9;
        if (r100 == null) goto L9;
        Object r102 = r101.getNativeProperties("PopupOverlay", "onInfoWindowTap", new Object[]{Double.valueOf(r100.getX()), Double.valueOf(r100.getY())});
        if ((r102 instanceof Boolean) == false) goto L9;
        return ((Boolean) r102).booleanValue();
    L9:
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void setInfoWindowAdapterManager(z0 r100) {
        monitor-enter(this);
        monitor-exit(this);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw th;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public synchronized void showInfoWindow(BasePointOverlay r100) throws RemoteException {
        monitor-enter(this);
        IGlOverlayLayer r101 = this.f27889a;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        r101.getNativeProperties(r100.getId(), "showInfoWindow", new Object[]{r100.getId()});     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public q2(IGlOverlayLayer r100, Context r101) {
        this.f27889a = r100;
    }
}
