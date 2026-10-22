package com.autonavi.base.amap.api.mapcore.infowindow;

import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.z0;
import com.amap.api.maps.model.BasePointOverlay;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;

/* JADX INFO: loaded from: classes39.dex */
public interface IInfoWindowAction {
    void hideInfoWindow();

    boolean isInfoWindowShown();

    boolean onInfoWindowTap(MotionEvent r100);

    void redrawInfoWindow();

    void setInfoWindowAdapterManager(z0 r100);

    void showInfoWindow(BasePointOverlay r100) throws RemoteException;

    void showInfoWindow(BaseOverlayImp r100) throws RemoteException;
}
