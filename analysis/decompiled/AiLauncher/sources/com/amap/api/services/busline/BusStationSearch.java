package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.jmsl.S1;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;

/* loaded from: classes.dex */
public class BusStationSearch {

    /* renamed from: a, reason: collision with root package name */
    private IBusStationSearch f17302a;

    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i10);
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) throws AMapException {
        if (this.f17302a == null) {
            try {
                this.f17302a = new S1(context, busStationQuery);
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof AMapException) {
                    throw ((AMapException) e10);
                }
            }
        }
    }

    public BusStationQuery getQuery() {
        IBusStationSearch iBusStationSearch = this.f17302a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.getQuery();
        }
        return null;
    }

    public BusStationResult searchBusStation() throws AMapException {
        IBusStationSearch iBusStationSearch = this.f17302a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.searchBusStation();
        }
        return null;
    }

    public void searchBusStationAsyn() {
        IBusStationSearch iBusStationSearch = this.f17302a;
        if (iBusStationSearch != null) {
            iBusStationSearch.searchBusStationAsyn();
        }
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        IBusStationSearch iBusStationSearch = this.f17302a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setOnBusStationSearchListener(onBusStationSearchListener);
        }
    }

    public void setQuery(BusStationQuery busStationQuery) {
        IBusStationSearch iBusStationSearch = this.f17302a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setQuery(busStationQuery);
        }
    }
}
