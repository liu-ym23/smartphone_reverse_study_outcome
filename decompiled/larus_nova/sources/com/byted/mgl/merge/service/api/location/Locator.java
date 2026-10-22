package com.byted.mgl.merge.service.api.location;

import android.content.Context;
import com.byted.mgl.merge.service.model.BdpLatLng;
import com.byted.mgl.merge.service.model.BdpLocation;
import com.byted.mgl.merge.service.model.BdpLocator;

/* JADX INFO: loaded from: classes43.dex */
public interface Locator {
    public static final int DEFAULT_REQUEST_INTERVAL_SEC = 2;

    BdpLocation getLastKnownLocation();

    BdpLocator.ISearchTask searchPoiListByKeyword(Context r100, BdpLatLng r101, String r102, String r103, int r104, int r105, BdpLocator.PoiResultCallback r106);

    BdpLocator.ISearchTask searchPoiListByLatLng(Context r100, BdpLatLng r101, int r102, int r103, int r104, BdpLocator.PoiResultCallback r105);

    void setLocationChangeListener(BdpLocator.ILocationListener r100);

    void startLocate(boolean r100);

    void stopLocate();
}
