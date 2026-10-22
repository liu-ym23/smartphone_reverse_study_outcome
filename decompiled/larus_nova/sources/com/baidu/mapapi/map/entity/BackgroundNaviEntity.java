package com.baidu.mapapi.map.entity;

import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class BackgroundNaviEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<LatLng> f31595a;

    public BackgroundNaviEntity() {
    }

    public ArrayList<LatLng> getRouteShapePoints() {
        return this.f31595a;
    }

    public void setRouteShapePoints(ArrayList<LatLng> r100) {
        this.f31595a = r100;
    }
}
