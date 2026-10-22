package com.amap.api.services.geocoder;

import android.content.Context;
import com.amap.api.col.s.az;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class GeocodeSearch {
    public static final String AMAP = "autonavi";
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final String GPS = "gps";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IGeocodeSearch f28919a;

    public interface OnGeocodeSearchListener {
        void onGeocodeSearched(GeocodeResult r100, int r101);

        void onRegeocodeSearched(RegeocodeResult r100, int r101);
    }

    public GeocodeSearch(Context r100) {
        if (this.f28919a != null) goto L11;
        this.f28919a = new az(r100);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final RegeocodeAddress getFromLocation(RegeocodeQuery r100) throws AMapException {
        IGeocodeSearch r101 = this.f28919a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getFromLocation(r100);
    }

    public final void getFromLocationAsyn(RegeocodeQuery r100) {
        IGeocodeSearch r101 = this.f28919a;
        if (r101 == null) goto L6;
        r101.getFromLocationAsyn(r100);
        return;
    }

    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery r100) throws AMapException {
        IGeocodeSearch r101 = this.f28919a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getFromLocationName(r100);
    }

    public final void getFromLocationNameAsyn(GeocodeQuery r100) {
        IGeocodeSearch r101 = this.f28919a;
        if (r101 == null) goto L6;
        r101.getFromLocationNameAsyn(r100);
        return;
    }

    public final void setOnGeocodeSearchListener(OnGeocodeSearchListener r100) {
        IGeocodeSearch r101 = this.f28919a;
        if (r101 == null) goto L6;
        r101.setOnGeocodeSearchListener(r100);
        return;
    }
}
