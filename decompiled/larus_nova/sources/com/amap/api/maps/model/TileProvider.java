package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public interface TileProvider {
    public static final Tile NO_TILE = null;

    static {
        NO_TILE = Tile.obtain(-1, -1, null);
    }

    Tile getTile(int r100, int r101, int r102);

    int getTileHeight();

    int getTileWidth();
}
