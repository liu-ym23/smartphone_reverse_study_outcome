package com.bytedance.amap.model;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.MapView;

/* JADX INFO: loaded from: classes43.dex */
public class AliMapView implements IMapView {
    private MapView mMapView;

    @Override // com.bytedance.amap.model.IMapView
    public AMap getMap() {
        return this.mMapView.getMap();
    }

    @Override // com.bytedance.amap.model.IMapView
    public void onDestroy() {
        this.mMapView.onDestroy();
    }

    @Override // com.bytedance.amap.model.IMapView
    public void onLowMemory() {
        this.mMapView.onLowMemory();
    }

    @Override // com.bytedance.amap.model.IMapView
    public void onPause() {
        this.mMapView.onPause();
    }

    @Override // com.bytedance.amap.model.IMapView
    public void onResume() {
        this.mMapView.onResume();
    }

    @Override // com.bytedance.amap.model.IMapView
    public View getRealMapView() {
        return this.mMapView;
    }

    @Override // com.bytedance.amap.model.IMapView
    public void onCreate(Bundle r100) {
        this.mMapView.onCreate(r100);
    }

    @Override // com.bytedance.amap.model.IMapView
    public void onSaveInstanceState(Bundle r100) {
        this.mMapView.onSaveInstanceState(r100);
    }

    public AliMapView(Context r100, AMapOptions r101) {
        this.mMapView = new MapView(r100, r101);
    }
}
