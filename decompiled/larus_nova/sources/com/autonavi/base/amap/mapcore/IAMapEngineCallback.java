package com.autonavi.base.amap.mapcore;

import com.amap.api.maps.model.BitmapDescriptor;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public interface IAMapEngineCallback {
    void OnIndoorBuildingActivity(int r100, byte[] r101);

    void cancelRequireMapData(Object r100);

    int generateRequestId();

    BitmapDescriptor getDefaultTerrainImage();

    List<BitmapDescriptor> getSkyBoxImages();

    InitStorageParam getStorageInitParam();

    TileProviderInner getTerrainTileProvider();

    void onAMapAppResourceRequest(AMapAppRequestParam r100);

    void onMapBlandClick(double r100, double r101);

    void onMapPOIClick(MapPoi r100);

    void onMapRender(int r100, int r101);

    void reloadMapResource(int r100, String r101, int r102);

    byte[] requireCharBitmap(int r100, int r101, int r102);

    byte[] requireCharsWidths(int r100, int[] r101, int r102, int r103);

    void requireMapRender(int r100, int r101, int r102);

    byte[] requireMapResource(int r100, String r101);
}
