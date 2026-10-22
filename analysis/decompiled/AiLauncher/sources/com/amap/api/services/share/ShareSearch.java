package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.col.jmsl.D;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;

/* loaded from: classes.dex */
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

    /* renamed from: a, reason: collision with root package name */
    private IShareSearch f18009a;

    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(String str, int i10);

        void onDrivingRouteShareUrlSearched(String str, int i10);

        void onLocationShareUrlSearched(String str, int i10);

        void onNaviShareUrlSearched(String str, int i10);

        void onPoiShareUrlSearched(String str, int i10);

        void onWalkRouteShareUrlSearched(String str, int i10);
    }

    public static class ShareBusRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f18010a;

        /* renamed from: b, reason: collision with root package name */
        private int f18011b;

        public ShareBusRouteQuery(ShareFromAndTo shareFromAndTo, int i10) {
            this.f18010a = shareFromAndTo;
            this.f18011b = i10;
        }

        public int getBusMode() {
            return this.f18011b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f18010a;
        }
    }

    public static class ShareDrivingRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f18012a;

        /* renamed from: b, reason: collision with root package name */
        private int f18013b;

        public ShareDrivingRouteQuery(ShareFromAndTo shareFromAndTo, int i10) {
            this.f18012a = shareFromAndTo;
            this.f18013b = i10;
        }

        public int getDrivingMode() {
            return this.f18013b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f18012a;
        }
    }

    public static class ShareFromAndTo {

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f18014a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f18015b;

        /* renamed from: c, reason: collision with root package name */
        private String f18016c = "起点";

        /* renamed from: d, reason: collision with root package name */
        private String f18017d = "终点";

        public ShareFromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f18014a = latLonPoint;
            this.f18015b = latLonPoint2;
        }

        public LatLonPoint getFrom() {
            return this.f18014a;
        }

        public String getFromName() {
            return this.f18016c;
        }

        public LatLonPoint getTo() {
            return this.f18015b;
        }

        public String getToName() {
            return this.f18017d;
        }

        public void setFromName(String str) {
            this.f18016c = str;
        }

        public void setToName(String str) {
            this.f18017d = str;
        }
    }

    public static class ShareNaviQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f18018a;

        /* renamed from: b, reason: collision with root package name */
        private int f18019b;

        public ShareNaviQuery(ShareFromAndTo shareFromAndTo, int i10) {
            this.f18018a = shareFromAndTo;
            this.f18019b = i10;
        }

        public ShareFromAndTo getFromAndTo() {
            return this.f18018a;
        }

        public int getNaviMode() {
            return this.f18019b;
        }
    }

    public static class ShareWalkRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f18020a;

        /* renamed from: b, reason: collision with root package name */
        private int f18021b;

        public ShareWalkRouteQuery(ShareFromAndTo shareFromAndTo, int i10) {
            this.f18020a = shareFromAndTo;
            this.f18021b = i10;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f18020a;
        }

        public int getWalkMode() {
            return this.f18021b;
        }
    }

    public ShareSearch(Context context) throws AMapException {
        if (this.f18009a == null) {
            try {
                this.f18009a = new D(context);
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof AMapException) {
                    throw ((AMapException) e10);
                }
            }
        }
    }

    public String searchBusRouteShareUrl(ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchBusRouteShareUrl(shareBusRouteQuery);
        return null;
    }

    public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery shareBusRouteQuery) {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrlAsyn(shareBusRouteQuery);
        }
    }

    public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
        return null;
    }

    public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery shareDrivingRouteQuery) {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrlAsyn(shareDrivingRouteQuery);
        }
    }

    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchLocationShareUrl(latLonSharePoint);
        return null;
    }

    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrlAsyn(latLonSharePoint);
        }
    }

    public String searchNaviShareUrl(ShareNaviQuery shareNaviQuery) throws AMapException {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchNaviShareUrl(shareNaviQuery);
        return null;
    }

    public void searchNaviShareUrlAsyn(ShareNaviQuery shareNaviQuery) {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrlAsyn(shareNaviQuery);
        }
    }

    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchPoiShareUrl(poiItem);
        return null;
    }

    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrlAsyn(poiItem);
        }
    }

    public String searchWalkRouteShareUrl(ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchWalkRouteShareUrl(shareWalkRouteQuery);
        return null;
    }

    public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery shareWalkRouteQuery) {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrlAsyn(shareWalkRouteQuery);
        }
    }

    public void setOnShareSearchListener(OnShareSearchListener onShareSearchListener) {
        IShareSearch iShareSearch = this.f18009a;
        if (iShareSearch != null) {
            iShareSearch.setOnShareSearchListener(onShareSearchListener);
        }
    }
}
