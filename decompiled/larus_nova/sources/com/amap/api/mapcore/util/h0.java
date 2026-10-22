package com.amap.api.mapcore.util;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceReq;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class h0 implements TileSourceProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TileOverlaySource f27331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TileOverlaySource f27332b;

    public class a extends f3 {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f27333o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private String f27334p;

        @Override // com.amap.api.mapcore.util.y7
        public String getURL() {
            StringBuffer r100 = new StringBuffer();
            r100.append(this.f27334p);
            r100.append("&key=");
            r100.append(l5.e(b0.f27047f));
            r100.append("&channel=amapapi");
            return this.f27333o + appendTsScode(r100.toString());
        }

        @Override // com.amap.api.mapcore.util.f3, com.amap.api.mapcore.util.y7
        public Map<String, String> getRequestHead() {
            return super.getRequestHead();
        }

        public a(h0 r100, int r101, int r102, int r103, String r104) {
            this.f27333o = "";
            this.f27334p = "";
            String r105 = String.format(r104, new Object[]{Integer.valueOf(r103), Integer.valueOf(r101), Integer.valueOf(r102)});
            if (r105.contains("?") == true) goto L5;
            this.f27333o = r105.concat("?");
            return;
        L5:
            String[] r106 = r105.split("\\?");
            if (r106.length <= 1) goto L10;
            this.f27333o = r106[0] + "?";
            this.f27334p = r106[1];
            return;
        }
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public void cancel(TileSourceReq r100) {
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int r100, int r101, int r102) {
        return null;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }

    private Tile a(TileSourceReq r100) {
        String r101 = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH;
        int r102 = r100.f30029x;     // Catch: FileNotFoundException -> L11 IOException -> L25
        if (r102 <= 0) goto L6;
        r102 = r102 / 10;     // Catch: FileNotFoundException -> L11 IOException -> L25
    L6:
        int r103 = r100.f30030y;     // Catch: FileNotFoundException -> L11 IOException -> L25
        if (r103 <= 0) goto L9;
        r103 = r103 / 10;     // Catch: FileNotFoundException -> L11 IOException -> L25
    L9:
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r101 + r100.zoom + HTTP.URL_DEFAULT + r102 + HTTP.URL_DEFAULT + r103 + HTTP.URL_DEFAULT + r100.f30029x + "_" + r100.f30030y + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT));     // Catch: FileNotFoundException -> L11 IOException -> L25
        byte[] r105 = new byte[r104.available()];     // Catch: FileNotFoundException -> L11 IOException -> L25
        r104.read(r105);     // Catch: FileNotFoundException -> L11 IOException -> L25
        Tile r106 = new Tile(256, 256, r105, true);     // Catch: FileNotFoundException -> L11 IOException -> L25
        r104.close();     // Catch: FileNotFoundException -> L11 IOException -> L25
        return r106;
    L11:
        int r107 = r100.f30029x;
        int r108 = r100.zoom - 6;
        int r109 = r107 >> r108;
        int r110 = r100.f30030y >> r108;
        if (r109 < 51) goto L24;
        if (r109 > 53) goto L24;
        if (r110 < 28) goto L24;
        if (r110 > 31) goto L24;
        PolarisFileInputStreamWrapper r111 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r101 + "default.png"));     // Catch: Exception -> L21
        byte[] r112 = new byte[r111.available()];     // Catch: Exception -> L21
        r111.read(r112);     // Catch: Exception -> L21
        Tile r113 = new Tile(256, 256, r112, true);     // Catch: Exception -> L21
        r111.close();     // Catch: Exception -> L21
        return r113;
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        return TileProvider.NO_TILE;
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public Tile getTile(TileSourceReq r100) {
        if (r100 == null) goto L4;
        Tile r101 = TileProvider.NO_TILE;
    L25:
        e = move-exception;
        Tile r102 = TileProvider.NO_TILE;
        e.printStackTrace();
        return r102;
    L7:
        if (r100.sourceType != this.f27332b.getId()) goto L10;
        String r103 = this.f27332b.getUrl();     // Catch: Exception -> L25
    L9:
        String r104 = r103;
        if (r104 != null) goto L14;
        return r101;
    L14:
        if (MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH == null) goto L16;
        Tile r105 = a(r100);     // Catch: Exception -> L25
    L17:
        if (r105 == r101) goto L30;
        return r105;
    L30:
        byte[] r106 = new a(this, r100.f30029x, r100.f30030y, r100.zoom, r104).makeHttpRequestWithInterrupted();     // Catch: Throwable -> L21
    L23:
        return new Tile(256, 256, r106, true);
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L25
        r106 = null;
        goto L23
    L16:
        r105 = r101;
        goto L17
    L10:
        r103 = this.f27331a.getUrl();     // Catch: Exception -> L25
        goto L9
    L4:
        return TileProvider.NO_TILE;
    }

    public h0(TileOverlaySource r100, TileOverlaySource r101) {
        this.f27331a = r100;
        this.f27332b = r101;
    }
}
