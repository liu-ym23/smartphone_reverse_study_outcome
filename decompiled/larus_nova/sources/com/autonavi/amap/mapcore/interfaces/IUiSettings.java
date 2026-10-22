package com.autonavi.amap.mapcore.interfaces;

import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.maps.UiSettings;

/* JADX INFO: loaded from: classes39.dex */
public interface IUiSettings {
    float getLogoMarginRate(int r100) throws RemoteException;

    int getLogoPosition() throws RemoteException;

    Point getLogoSize() throws RemoteException;

    float getLogoSizeScale() throws RemoteException;

    UiSettings.ScaleControlsUnit getScaleControlsUnit();

    int getZoomPosition() throws RemoteException;

    boolean isCompassEnabled() throws RemoteException;

    boolean isGestureScaleByMapCenter() throws RemoteException;

    boolean isIndoorSwitchEnabled() throws RemoteException;

    boolean isLogoEnable();

    boolean isMyLocationButtonEnabled() throws RemoteException;

    boolean isRotateGesturesEnabled() throws RemoteException;

    boolean isScaleControlsEnabled() throws RemoteException;

    boolean isScrollGesturesEnabled() throws RemoteException;

    boolean isTiltGesturesEnabled() throws RemoteException;

    boolean isZoomControlsEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    boolean isZoomInByScreenCenter() throws RemoteException;

    void requestRefreshLogo();

    void setAllGesturesEnabled(boolean r100) throws RemoteException;

    void setCompassEnabled(boolean r100) throws RemoteException;

    void setGestureScaleByMapCenter(boolean r100) throws RemoteException;

    void setIndoorSwitchEnabled(boolean r100) throws RemoteException;

    void setLayoutDirectionRtl(boolean r100) throws RemoteException;

    void setLogoBottomMargin(int r100) throws RemoteException;

    void setLogoEnable(boolean r100);

    void setLogoLeftMargin(int r100) throws RemoteException;

    void setLogoMarginRate(int r100, float r101) throws RemoteException;

    void setLogoPosition(int r100) throws RemoteException;

    void setLogoSizeScale(float r100) throws RemoteException;

    void setMyLocationButtonEnabled(boolean r100) throws RemoteException;

    void setRotateGesturesEnabled(boolean r100) throws RemoteException;

    void setScaleControlsEnabled(boolean r100) throws RemoteException;

    void setScaleControlsPosition(Point r100);

    void setScaleControlsUnit(UiSettings.ScaleControlsUnit r100);

    void setScrollGesturesEnabled(boolean r100) throws RemoteException;

    void setTiltGesturesEnabled(boolean r100) throws RemoteException;

    void setZoomControlsEnabled(boolean r100) throws RemoteException;

    void setZoomGesturesEnabled(boolean r100) throws RemoteException;

    void setZoomInByScreenCenter(boolean r100) throws RemoteException;

    void setZoomPosition(int r100) throws RemoteException;
}
