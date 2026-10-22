package com.byted.mgl.merge.service.model;

import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public interface BdpLocator {

    public interface ILocationListener {
        void onLocationChanged(BdpLocation r100);
    }

    public interface ISearchTask {
        void cancel();
    }

    public static class LocateConfig {
        public static final int TYPE_GAODE = 2;
        public static final int TYPE_HOST = 3;
        public static final int TYPE_SYSTEM = 1;
        public boolean isUseGps;
        public long timeout;

        public LocateConfig() {
        }
    }

    public interface PoiResultCallback {
        void onFailed();

        void onSucceed(List<BdpPoiInfo> r100);
    }

    BdpLocation getLastKnwonLocation();

    ISearchTask searchPoiListByKeyword(BdpLatLng r100, String r101, String r102, int r103, int r104, PoiResultCallback r105);

    ISearchTask searchPoiListByLatLng(BdpLatLng r100, int r101, int r102, int r103, PoiResultCallback r104);

    void startLocate(LocateConfig r100, ILocationListener r101);

    void stopLocate(ILocationListener r100);
}
