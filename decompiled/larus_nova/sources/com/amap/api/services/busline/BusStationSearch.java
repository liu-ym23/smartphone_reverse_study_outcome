package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.s.av;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;

/* JADX INFO: loaded from: classes28.dex */
public class BusStationSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBusStationSearch f28797a;

    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult r100, int r101);
    }

    public BusStationQuery getQuery() {
        IBusStationSearch r100 = this.f28797a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getQuery();
    }

    public BusStationResult searchBusStation() throws AMapException {
        IBusStationSearch r100 = this.f28797a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.searchBusStation();
    }

    public void searchBusStationAsyn() {
        IBusStationSearch r100 = this.f28797a;
        if (r100 == null) goto L6;
        r100.searchBusStationAsyn();
        return;
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener r100) {
        IBusStationSearch r101 = this.f28797a;
        if (r101 == null) goto L6;
        r101.setOnBusStationSearchListener(r100);
        return;
    }

    public void setQuery(BusStationQuery r100) {
        IBusStationSearch r101 = this.f28797a;
        if (r101 == null) goto L6;
        r101.setQuery(r100);
        return;
    }

    public BusStationSearch(Context r100, BusStationQuery r101) {
        if (this.f28797a != null) goto L11;
        this.f28797a = new av(r100, r101);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
