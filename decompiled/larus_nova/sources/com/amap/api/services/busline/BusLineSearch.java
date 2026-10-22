package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.s.au;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;

/* JADX INFO: loaded from: classes28.dex */
public class BusLineSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBusLineSearch f28781a;

    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult r100, int r101);
    }

    public BusLineQuery getQuery() {
        IBusLineSearch r100 = this.f28781a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getQuery();
    }

    public BusLineResult searchBusLine() throws AMapException {
        IBusLineSearch r100 = this.f28781a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.searchBusLine();
    }

    public void searchBusLineAsyn() {
        IBusLineSearch r100 = this.f28781a;
        if (r100 == null) goto L6;
        r100.searchBusLineAsyn();
        return;
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener r100) {
        IBusLineSearch r101 = this.f28781a;
        if (r101 == null) goto L6;
        r101.setOnBusLineSearchListener(r100);
        return;
    }

    public void setQuery(BusLineQuery r100) {
        IBusLineSearch r101 = this.f28781a;
        if (r101 == null) goto L6;
        r101.setQuery(r100);
        return;
    }

    public BusLineSearch(Context r100, BusLineQuery r101) {
        this.f28781a = null;
        this.f28781a = new au(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
