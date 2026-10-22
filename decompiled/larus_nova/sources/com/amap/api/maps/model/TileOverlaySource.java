package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public class TileOverlaySource {
    public static int TILESOURCE_TYPE_FBO_TEXTURE = 4;
    public static int TILESOURCE_TYPE_IMAGE = 1;
    public static int TILESOURCE_TYPE_IMAGE_DEM = 3;
    public static int TILESOURCE_TYPE_VECTOR = 2;
    private String attribute;
    private boolean cacheEnabled;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f28665id;
    private int maxZoom;
    private int minZoom;
    private final int type;
    private final String url;

    public int getId() {
        return this.f28665id;
    }

    public int getMaxZoom() {
        return this.maxZoom;
    }

    public int getMinZoom() {
        return this.minZoom;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCacheEnabled() {
        return this.cacheEnabled;
    }

    public void setCacheEnabled(boolean r100) {
        this.cacheEnabled = r100;
    }

    public void setMaxZoom(int r100) {
        this.maxZoom = r100;
    }

    public void setMinZoom(int r100) {
        this.minZoom = r100;
    }

    public TileOverlaySource(int r100, int r101, String r102) {
        this.minZoom = 3;
        this.maxZoom = 20;
        this.cacheEnabled = true;
        this.url = r102;
        this.type = r101;
        this.f28665id = r100;
    }
}
