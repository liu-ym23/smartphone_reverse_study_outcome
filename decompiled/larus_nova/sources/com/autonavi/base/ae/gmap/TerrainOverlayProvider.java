package com.autonavi.base.ae.gmap;

import android.content.Context;
import com.amap.api.mapcore.util.h0;
import com.amap.api.mapcore.util.p5;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.TileOverlaySource;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class TerrainOverlayProvider {
    private static final int TERRAIN_OVERLAY_SOURCE_BASE_ID = 1;
    private static final int TERRAIN_OVERLAY_SOURCE_HIGH_ID = 0;
    private TileProviderInner tileProviderInner;

    public List<BitmapDescriptor> getSkyBoxImages() {
        String[] r100 = {"map_custom/skybox/right.png", "map_custom/skybox/left.png", "map_custom/skybox/front.png", "map_custom/skybox/back.png", "map_custom/skybox/top.png", "map_custom/skybox/bottom.png"};
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 >= 6) goto L6;
        r101.add(BitmapDescriptorFactory.fromAsset(r100[r102]));
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public BitmapDescriptor getDefaultTerrain() {
        return BitmapDescriptorFactory.fromAsset("terrainDefault.png");
    }

    public TileProviderInner getTileProvider() {
        return this.tileProviderInner;
    }

    public TerrainOverlayProvider(IGlOverlayLayer r100, Context r101) {
        String r102 = "http://" + p5.b(r101).a(27);
        boolean r103 = false;
        TileOverlaySource r104 = new TileOverlaySource(0, TileOverlaySource.TILESOURCE_TYPE_IMAGE_DEM, r102 + "/rest/lbs/dem/data?z=%d&x=%d&y=%d&type=2");
        r104.setMinZoom(3);
        r104.setMaxZoom(10);
        r104.setCacheEnabled(true);
        int r105 = TileOverlaySource.TILESOURCE_TYPE_FBO_TEXTURE;
        TileOverlaySource r106 = new TileOverlaySource(1, r105, "http://mst01.is.autonavi.com/appmaptile?z=%d&x=%d&y=%d&lang=zh_cn&size=1&scale=1&style=6");
        if (r105 == TileOverlaySource.TILESOURCE_TYPE_FBO_TEXTURE) goto L5;
        r103 = true;
    L5:
        r106.setCacheEnabled(r103);
        ArrayList r107 = new ArrayList();
        r107.add(r104);
        r107.add(r106);
        TileProviderInner r108 = new TileProviderInner(new h0(r104, r106));
        this.tileProviderInner = r108;
        r108.init(r100, "TerrainTileOverlay");
        this.tileProviderInner.setTileSource(r107);
    }
}
