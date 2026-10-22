package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public interface MapViewListener {
    void onClickPolymericMapObj(List<MapObj> r100);

    void onClickSdkMapObj(int r100, JSONObject r101);

    void onClickStreetArrow(MapObj r100);

    void onClickStreetSurface(MapObj r100);

    void onClickedBackground(int r100, int r101);

    void onClickedItem(int r100, int r101, GeoPoint r102, long r103);

    void onClickedItem(int r100, GeoPoint r101, long r102);

    void onClickedItsMapObj(List<ItsMapObj> r100);

    void onClickedMapObj(List<MapObj> r100);

    void onClickedOPPoiEventMapObj(MapObj r100);

    void onClickedParticleEventMapObj(List<MapObj> r100);

    void onClickedPoiObj(List<MapObj> r100);

    void onClickedPopup(int r100);

    void onClickedRouteLabelObj(List<MapObj> r100);

    void onClickedRouteObj(List<MapObj> r100);

    void onClickedStreetIndoorPoi(MapObj r100);

    void onClickedStreetPopup(String r100);

    void onClickedTrafficUgcEventMapObj(MapObj r100, boolean r101);

    void onClickedUniversalLayerPoiEventMapObj(List<MapObj> r100);

    void onMapAnimationFinish();
}
