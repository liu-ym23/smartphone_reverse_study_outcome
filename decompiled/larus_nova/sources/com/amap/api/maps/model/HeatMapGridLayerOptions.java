package com.amap.api.maps.model;

import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class HeatMapGridLayerOptions extends BaseOptions {
    public static final int TYPE_GRID = 1;
    public static final int TYPE_HEXAGON = 2;
    public static final int TYPE_NORMAL = 0;
    private boolean isPointsUpdated;
    private boolean isVisible;
    private List<ColorLatLng> mData;
    private int mType;
    private float maxZoom;
    private float minZoom;
    private float zIndex;

    public HeatMapGridLayerOptions() {
        this.maxZoom = 20.0f;
        this.minZoom = 3.0f;
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.mType = 2;
        this.isPointsUpdated = false;
        this.type = "HeatMapGridLayerOptions";
    }

    public List<ColorLatLng> getData() {
        return this.mData;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public int getType() {
        return this.mType;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public HeatMapGridLayerOptions data(List<ColorLatLng> r100) {
        this.mData = r100;
        this.isPointsUpdated = true;
        return this;
    }

    public HeatMapGridLayerOptions maxZoom(float r100) {
        this.maxZoom = r100;
        return this;
    }

    public HeatMapGridLayerOptions minZoom(float r100) {
        this.minZoom = r100;
        return this;
    }

    public HeatMapGridLayerOptions type(int r100) {
        this.mType = r100;
        return this;
    }

    public HeatMapGridLayerOptions visible(boolean r100) {
        this.isVisible = r100;
        return this;
    }

    public HeatMapGridLayerOptions zIndex(float r100) {
        this.zIndex = r100;
        return this;
    }
}
