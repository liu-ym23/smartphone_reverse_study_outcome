package com.amap.api.maps.model;

import com.amap.api.mapcore.util.f3;

/* JADX INFO: loaded from: classes28.dex */
public final class MVTTileProvider implements TileProvider {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f28654id;
    private String key;
    private int tileSize;
    private String url;

    public class a extends f3 {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        String f28655o;

        @Override // com.amap.api.mapcore.util.y7
        public String getURL() {
            return this.f28655o;
        }

        public a(MVTTileProvider r100, String r101) {
            this.isPostFlag = false;
            this.f28655o = r101;
        }
    }

    public String getId() {
        return this.f28654id;
    }

    public String getKey() {
        return this.key;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return this.tileSize;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return this.tileSize;
    }

    public String getUrl() {
        return this.url;
    }

    public MVTTileProvider(String r100, String r101, String r102) {
        this.url = r100;
        this.key = r101;
        this.f28654id = r102;
        this.tileSize = 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int r100, int r101, int r102) {
        byte[] r103 = new a(this, String.format(this.url + "?z=%d&x=%d&y=%d&size=%d&key=" + this.key + "&id=" + this.f28654id, new Object[]{Integer.valueOf(r102), Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(this.tileSize)})).makeHttpRequestWithInterrupted();     // Catch: Exception -> L5
    L6:
        if (r103 == null) goto L8;
        int r104 = this.tileSize;
        return new Tile(r104, r104, r103, false);
    L8:
        return TileProvider.NO_TILE;
    L5:
        r103 = null;
        goto L6
    }
}
