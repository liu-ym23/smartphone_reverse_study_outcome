package com.amap.api.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes28.dex */
public abstract class UrlTileProvider implements TileProvider {
    private final int height;
    private final int width;

    public abstract URL getTileUrl(int r100, int r101, int r102);

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return this.height;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return this.width;
    }

    public UrlTileProvider(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int r100, int r101, int r102) {
        URL r103 = getTileUrl(r100, r101, r102);
        if (r103 == null) goto L5;
        int r104 = this.width;     // Catch: IOException -> L12
        int r105 = this.height;     // Catch: IOException -> L12
        InputStream r106 = r103.openStream();     // Catch: IOException -> L12
        ByteArrayOutputStream r107 = new ByteArrayOutputStream();     // Catch: IOException -> L12
        byte[] r108 = new byte[4096];     // Catch: IOException -> L12
    L7:
        int r109 = r106.read(r108);     // Catch: IOException -> L12
        if (r109 == (-1)) goto L9;
        r107.write(r108, 0, r109);     // Catch: IOException -> L12
        goto L7
    L9:
        return Tile.obtain(r104, r105, r107.toByteArray());
    L12:
        e = move-exception;
        Tile r110 = TileProvider.NO_TILE;
        e.printStackTrace();
        return r110;
    L5:
        return TileProvider.NO_TILE;
    }
}
