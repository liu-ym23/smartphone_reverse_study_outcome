package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.col.s.bf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;

/* JADX INFO: loaded from: classes28.dex */
public class ShareSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoHighWay = 3;
    public static final int DrivingNoHighWayAvoidCongestion = 6;
    public static final int DrivingNoHighWaySaveMoney = 5;
    public static final int DrivingNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 7;
    public static final int DrivingShortDistance = 2;
    public static final int NaviAvoidCongestion = 4;
    public static final int NaviDefault = 0;
    public static final int NaviNoHighWay = 3;
    public static final int NaviNoHighWayAvoidCongestion = 6;
    public static final int NaviNoHighWaySaveMoney = 5;
    public static final int NaviNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int NaviSaveMoney = 1;
    public static final int NaviSaveMoneyAvoidCongestion = 7;
    public static final int NaviShortDistance = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IShareSearch f29273a;

    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(String r100, int r101);

        void onDrivingRouteShareUrlSearched(String r100, int r101);

        void onLocationShareUrlSearched(String r100, int r101);

        void onNaviShareUrlSearched(String r100, int r101);

        void onPoiShareUrlSearched(String r100, int r101);

        void onWalkRouteShareUrlSearched(String r100, int r101);
    }

    public static class ShareBusRouteQuery {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f29274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29275b;

        public int getBusMode() {
            return this.f29275b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f29274a;
        }

        public ShareBusRouteQuery(ShareFromAndTo r100, int r101) {
            this.f29274a = r100;
            this.f29275b = r101;
        }
    }

    public static class ShareDrivingRouteQuery {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f29276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29277b;

        public int getDrivingMode() {
            return this.f29277b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f29276a;
        }

        public ShareDrivingRouteQuery(ShareFromAndTo r100, int r101) {
            this.f29276a = r100;
            this.f29277b = r101;
        }
    }

    public static class ShareFromAndTo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLonPoint f29278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LatLonPoint f29279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f29280c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f29281d;

        public LatLonPoint getFrom() {
            return this.f29278a;
        }

        public String getFromName() {
            return this.f29280c;
        }

        public LatLonPoint getTo() {
            return this.f29279b;
        }

        public String getToName() {
            return this.f29281d;
        }

        public void setFromName(String r100) {
            this.f29280c = r100;
        }

        public void setToName(String r100) {
            this.f29281d = r100;
        }

        public ShareFromAndTo(LatLonPoint r100, LatLonPoint r101) {
            this.f29280c = "起点";
            this.f29281d = "终点";
            this.f29278a = r100;
            this.f29279b = r101;
        }
    }

    public static class ShareNaviQuery {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f29282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29283b;

        public ShareFromAndTo getFromAndTo() {
            return this.f29282a;
        }

        public int getNaviMode() {
            return this.f29283b;
        }

        public ShareNaviQuery(ShareFromAndTo r100, int r101) {
            this.f29282a = r100;
            this.f29283b = r101;
        }
    }

    public static class ShareWalkRouteQuery {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f29284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29285b;

        public ShareFromAndTo getShareFromAndTo() {
            return this.f29284a;
        }

        public int getWalkMode() {
            return this.f29285b;
        }

        public ShareWalkRouteQuery(ShareFromAndTo r100, int r101) {
            this.f29284a = r100;
            this.f29285b = r101;
        }
    }

    public ShareSearch(Context r100) {
        if (this.f29273a != null) goto L11;
        this.f29273a = new bf(r100);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public String searchBusRouteShareUrl(ShareBusRouteQuery r100) throws AMapException {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L7;
        r101.searchBusRouteShareUrl(r100);
        return null;
    L7:
        return null;
    }

    public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery r100) {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L6;
        r101.searchBusRouteShareUrlAsyn(r100);
        return;
    }

    public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery r100) throws AMapException {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L7;
        r101.searchDrivingRouteShareUrl(r100);
        return null;
    L7:
        return null;
    }

    public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery r100) {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L6;
        r101.searchDrivingRouteShareUrlAsyn(r100);
        return;
    }

    public String searchLocationShareUrl(LatLonSharePoint r100) throws AMapException {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L7;
        r101.searchLocationShareUrl(r100);
        return null;
    L7:
        return null;
    }

    public void searchLocationShareUrlAsyn(LatLonSharePoint r100) {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L6;
        r101.searchLocationShareUrlAsyn(r100);
        return;
    }

    public String searchNaviShareUrl(ShareNaviQuery r100) throws AMapException {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L7;
        r101.searchNaviShareUrl(r100);
        return null;
    L7:
        return null;
    }

    public void searchNaviShareUrlAsyn(ShareNaviQuery r100) {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L6;
        r101.searchNaviShareUrlAsyn(r100);
        return;
    }

    public String searchPoiShareUrl(PoiItem r100) throws AMapException {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L7;
        r101.searchPoiShareUrl(r100);
        return null;
    L7:
        return null;
    }

    public void searchPoiShareUrlAsyn(PoiItem r100) {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L6;
        r101.searchPoiShareUrlAsyn(r100);
        return;
    }

    public String searchWalkRouteShareUrl(ShareWalkRouteQuery r100) throws AMapException {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L7;
        r101.searchWalkRouteShareUrl(r100);
        return null;
    L7:
        return null;
    }

    public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery r100) {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L6;
        r101.searchWalkRouteShareUrlAsyn(r100);
        return;
    }

    public void setOnShareSearchListener(OnShareSearchListener r100) {
        IShareSearch r101 = this.f29273a;
        if (r101 == null) goto L6;
        r101.setOnShareSearchListener(r100);
        return;
    }
}
