package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface MapViewListener {
    void onClickPolymericMapObj(List<MapObj> list);

    void onClickSdkMapObj(int i4, JSONObject jSONObject);

    void onClickStreetArrow(MapObj mapObj);

    void onClickStreetSurface(MapObj mapObj);

    void onClickedBackground(int i4, int i5);

    void onClickedItem(int i4, int i5, GeoPoint geoPoint, long j4);

    void onClickedItem(int i4, GeoPoint geoPoint, long j4);

    void onClickedItsMapObj(List<ItsMapObj> list);

    void onClickedMapObj(List<MapObj> list);

    @Deprecated
    void onClickedOPPoiEventMapObj(MapObj mapObj);

    void onClickedParticleEventMapObj(List<MapObj> list);

    void onClickedPoiObj(List<MapObj> list);

    void onClickedPopup(int i4);

    void onClickedRouteLabelObj(List<MapObj> list);

    void onClickedRouteObj(List<MapObj> list);

    void onClickedStreetIndoorPoi(MapObj mapObj);

    void onClickedStreetPopup(String str);

    void onClickedTrafficUgcEventMapObj(MapObj mapObj, boolean z4);

    void onClickedUniversalLayerPoiEventMapObj(List<MapObj> list);

    void onMapAnimationFinish();
}
