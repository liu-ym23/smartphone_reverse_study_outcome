package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.platform.core.busline.IBusLineSearch;
import com.baidu.platform.core.busline.c;

/* loaded from: classes.dex */
public class BusLineSearch extends b {

    /* renamed from: b, reason: collision with root package name */
    private boolean f7259b = false;

    /* renamed from: a, reason: collision with root package name */
    IBusLineSearch f7258a = new c();

    public static BusLineSearch newInstance() {
        BMapManager.init();
        return new BusLineSearch();
    }

    public void destroy() {
        if (this.f7259b) {
            return;
        }
        this.f7259b = true;
        this.f7258a.destroy();
        BMapManager.destroy();
    }

    public boolean searchBusLine(BusLineSearchOption busLineSearchOption) {
        IBusLineSearch iBusLineSearch = this.f7258a;
        if (iBusLineSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (busLineSearchOption == null || busLineSearchOption.mUid == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
        }
        return iBusLineSearch.a(busLineSearchOption);
    }

    public void setOnGetBusLineSearchResultListener(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        IBusLineSearch iBusLineSearch = this.f7258a;
        if (iBusLineSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (onGetBusLineSearchResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        iBusLineSearch.a(onGetBusLineSearchResultListener);
    }
}
