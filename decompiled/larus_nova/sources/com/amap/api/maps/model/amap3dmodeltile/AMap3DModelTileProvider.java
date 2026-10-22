package com.amap.api.maps.model.amap3dmodeltile;

import com.amap.api.mapcore.util.b0;
import com.amap.api.mapcore.util.f3;
import com.amap.api.mapcore.util.l5;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* JADX INFO: loaded from: classes28.dex */
public final class AMap3DModelTileProvider implements TileProvider {
    private static final String DEFAULT_URL = "https://lbs-3dtiles-service.amap.com/basemap/tiles/staging?compose=building@1669011850923&compose=tree@1668678765481&z=%d&x=%d&y=%d";
    private int tileSize;
    private String url;

    public static class AMap3DModelRequest extends f3 {
        private String baseQueryStr;
        private String baseUrl;

        @Override // com.amap.api.mapcore.util.y7
        public String getURL() {
            StringBuffer r100 = new StringBuffer();
            r100.append(this.baseQueryStr);
            r100.append("&key=");
            r100.append(l5.e(b0.f27047f));
            return this.baseUrl + appendTsScode(r100.toString());
        }

        public AMap3DModelRequest(String r100) {
            this.baseUrl = "";
            this.baseQueryStr = "";
            this.isPostFlag = false;
            if (r100.contains("?") == true) goto L5;
            this.baseUrl = r100.concat("?");
            return;
        L5:
            String[] r101 = r100.split("\\?");
            if (r101.length <= 1) goto L10;
            this.baseUrl = r101[0] + "?";
            this.baseQueryStr = r101[1];
            return;
        }
    }

    public AMap3DModelTileProvider() {
        this.tileSize = 256;
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

    public void setUrl(String r100) {
        this.url = r100;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int r100, int r101, int r102) {
        String r103 = this.url;
        if (r103 != null) goto L16;
        r103 = DEFAULT_URL;
    L16:
        byte[] r104 = new AMap3DModelRequest(String.format(r103, new Object[]{Integer.valueOf(r102), Integer.valueOf(r100), Integer.valueOf(r101)})).makeHttpRequestWithInterrupted();     // Catch: Exception -> L9
    L11:
        if (r104 == null) goto L13;
        int r105 = this.tileSize;
        return new Tile(r105, r105, r104, false);
    L13:
        return TileProvider.NO_TILE;
    L9:
        e = move-exception;
        e.printStackTrace();
        r104 = null;
        goto L11
    }
}
