package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;

/* loaded from: classes.dex */
public final class TileOverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private static Bundle f7031a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f7032b = "TileOverlayOptions";

    /* renamed from: d, reason: collision with root package name */
    private TileProvider f7034d;
    public int datasource;
    public String urlString;

    /* renamed from: c, reason: collision with root package name */
    private int f7033c = 209715200;

    /* renamed from: e, reason: collision with root package name */
    private int f7035e = 20;

    /* renamed from: f, reason: collision with root package name */
    private int f7036f = 3;

    /* renamed from: g, reason: collision with root package name */
    private int f7037g = 15786414;

    /* renamed from: h, reason: collision with root package name */
    private int f7038h = -20037726;

    /* renamed from: i, reason: collision with root package name */
    private int f7039i = -15786414;

    /* renamed from: j, reason: collision with root package name */
    private int f7040j = 20037726;

    public TileOverlayOptions() {
        Bundle bundle = new Bundle();
        f7031a = bundle;
        bundle.putInt("rectr", this.f7037g);
        f7031a.putInt("rectb", this.f7038h);
        f7031a.putInt("rectl", this.f7039i);
        f7031a.putInt("rectt", this.f7040j);
    }

    private TileOverlayOptions a(int i4, int i5) {
        this.f7035e = i4;
        this.f7036f = i5;
        return this;
    }

    public TileOverlayOptions setMaxTileTmp(int i4) {
        this.f7033c = i4;
        return this;
    }

    public TileOverlayOptions setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("BDMapSDKException: bound can not be null");
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLngBounds.northeast);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(latLngBounds.southwest);
        double latitudeE6 = geoPointLl2mc.getLatitudeE6();
        double longitudeE6 = geoPointLl2mc2.getLongitudeE6();
        double latitudeE62 = geoPointLl2mc2.getLatitudeE6();
        double longitudeE62 = geoPointLl2mc.getLongitudeE6();
        if (latitudeE6 <= latitudeE62 || longitudeE62 <= longitudeE6) {
            Log.e(f7032b, "BDMapSDKException: bounds is illegal, use default bounds");
        } else {
            f7031a.putInt("rectr", (int) longitudeE62);
            f7031a.putInt("rectb", (int) latitudeE62);
            f7031a.putInt("rectl", (int) longitudeE6);
            f7031a.putInt("rectt", (int) latitudeE6);
        }
        return this;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        if (tileProvider == null) {
            return null;
        }
        if (tileProvider instanceof UrlTileProvider) {
            this.datasource = 1;
            String tileUrl = ((UrlTileProvider) tileProvider).getTileUrl();
            if (tileUrl == null || "".equals(tileUrl) || !tileUrl.contains("{x}") || !tileUrl.contains("{y}") || !tileUrl.contains("{z}")) {
                Log.e(f7032b, "tile url template is illegal, must contains {x}、{y}、{z}");
                return null;
            }
            this.urlString = tileUrl;
        } else {
            if (!(tileProvider instanceof FileTileProvider)) {
                Log.e(f7032b, "tileProvider must be UrlTileProvider or FileTileProvider");
                return null;
            }
            this.datasource = 0;
        }
        this.f7034d = tileProvider;
        int maxDisLevel = tileProvider.getMaxDisLevel();
        int minDisLevel = tileProvider.getMinDisLevel();
        if (maxDisLevel > 21 || minDisLevel < 3) {
            Log.e(f7032b, "display level is illegal");
        } else {
            a(maxDisLevel, minDisLevel);
        }
        return this;
    }

    public TileOverlay a(BaiduMap baiduMap) {
        return new TileOverlay(baiduMap, this.f7034d);
    }

    public Bundle a() {
        f7031a.putString(MapBundleKey.MapObjKey.OBJ_URL, this.urlString);
        f7031a.putInt("datasource", this.datasource);
        f7031a.putInt("maxDisplay", this.f7035e);
        f7031a.putInt("minDisplay", this.f7036f);
        f7031a.putInt("sdktiletmpmax", this.f7033c);
        return f7031a;
    }
}
