package com.amap.api.services.routepoisearch;

import android.content.Context;
import com.amap.api.col.s.bd;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class RoutePOISearch {
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IRoutePOISearch f29263a;

    public interface OnRoutePOISearchListener {
        void onRoutePoiSearched(RoutePOISearchResult r100, int r101);
    }

    public static final enum RoutePOISearchType extends Enum<RoutePOISearchType> {
        public static final RoutePOISearchType TypeATM = null;
        public static final RoutePOISearchType TypeFillingStation = null;
        public static final RoutePOISearchType TypeGasStation = null;
        public static final RoutePOISearchType TypeMaintenanceStation = null;
        public static final RoutePOISearchType TypeServiceArea = null;
        public static final RoutePOISearchType TypeToilet = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ RoutePOISearchType[] f29264a = null;

        static {
            RoutePOISearchType r100 = new RoutePOISearchType("TypeGasStation", 0);
            TypeGasStation = r100;
            RoutePOISearchType r101 = new RoutePOISearchType("TypeMaintenanceStation", 1);
            TypeMaintenanceStation = r101;
            RoutePOISearchType r102 = new RoutePOISearchType("TypeATM", 2);
            TypeATM = r102;
            RoutePOISearchType r103 = new RoutePOISearchType("TypeToilet", 3);
            TypeToilet = r103;
            RoutePOISearchType r104 = new RoutePOISearchType("TypeFillingStation", 4);
            TypeFillingStation = r104;
            RoutePOISearchType r105 = new RoutePOISearchType("TypeServiceArea", 5);
            TypeServiceArea = r105;
            f29264a = new RoutePOISearchType[]{r100, r101, r102, r103, r104, r105};
        }

        public static RoutePOISearchType[] values() {
            return (RoutePOISearchType[]) f29264a.clone();
        }

        public static RoutePOISearchType valueOf(String r100) {
            return (RoutePOISearchType) a.a(RoutePOISearchType.class, r100);
        }

        private RoutePOISearchType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public RoutePOISearchResult searchRoutePOI() throws AMapException {
        IRoutePOISearch r100 = this.f29263a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.searchRoutePOI();
    }

    public void searchRoutePOIAsyn() {
        IRoutePOISearch r100 = this.f29263a;
        if (r100 == null) goto L6;
        r100.searchRoutePOIAsyn();
        return;
    }

    public void setPoiSearchListener(OnRoutePOISearchListener r100) {
        IRoutePOISearch r101 = this.f29263a;
        if (r101 == null) goto L6;
        r101.setRoutePOISearchListener(r100);
        return;
    }

    public void setQuery(RoutePOISearchQuery r100) {
        IRoutePOISearch r101 = this.f29263a;
        if (r101 == null) goto L6;
        r101.setQuery(r100);
        return;
    }

    public RoutePOISearch(Context r100, RoutePOISearchQuery r101) {
        if (this.f29263a != null) goto L11;
        this.f29263a = new bd(r100, r101);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
