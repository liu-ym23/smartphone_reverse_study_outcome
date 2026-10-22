package com.baidu.mapapi.search.aoi;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;

/* loaded from: classes.dex */
public class AoiSearch extends b {

    /* renamed from: b, reason: collision with root package name */
    private boolean f7240b = false;

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.platform.core.aoi.b f7239a = new com.baidu.platform.core.aoi.b();

    public static AoiSearch newInstance() {
        BMapManager.init();
        return new AoiSearch();
    }

    public void destroy() {
        if (this.f7240b) {
            return;
        }
        this.f7240b = true;
        this.f7239a.destroy();
        BMapManager.destroy();
    }

    public boolean requestAoi(AoiSearchOption aoiSearchOption) {
        if (this.f7239a == null) {
            throw new IllegalStateException("BDMapSDKException: AoiSearch is null, please call newInstance() first.");
        }
        if (aoiSearchOption == null || aoiSearchOption.getLatLngList() == null || aoiSearchOption.getLatLngList().size() <= 0) {
            throw new IllegalStateException("BDMapSDKException: option or location can not be null");
        }
        return this.f7239a.searchAoi(aoiSearchOption);
    }

    public void setOnGetAoiSearchResultListener(OnGetAoiSearchResultListener onGetAoiSearchResultListener) {
        com.baidu.platform.core.aoi.b bVar = this.f7239a;
        if (bVar == null) {
            throw new IllegalStateException("BDMapSDKException: AoiSearch is null, please call newInstance first.");
        }
        if (onGetAoiSearchResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        bVar.setOnAoiSearchListener(onGetAoiSearchResultListener);
    }
}
