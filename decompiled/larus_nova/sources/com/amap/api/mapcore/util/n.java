package com.amap.api.mapcore.util;

import android.location.Location;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX INFO: loaded from: classes28.dex */
class n implements LocationSource.OnLocationChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAMapDelegate f27626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Location f27627b;

    public n(IAMapDelegate r100) {
        this.f27626a = r100;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public void onLocationChanged(Location r100) {
        this.f27627b = r100;
    L7:
        th = move-exception;
        t6.a(th, "AMapOnLocationChangedListener", "onLocationChanged");
        th.printStackTrace();
        return;
    L4:
        if (this.f27626a.isMyLocationEnabled() == false) goto L12;
        this.f27626a.showMyLocationOverlay(r100);     // Catch: Throwable -> L7
        return;
    }
}
