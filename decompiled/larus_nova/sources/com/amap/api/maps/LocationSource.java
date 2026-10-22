package com.amap.api.maps;

import android.location.Location;

/* JADX INFO: loaded from: classes28.dex */
public interface LocationSource {

    public interface OnLocationChangedListener {
        void onLocationChanged(Location r100);
    }

    void activate(OnLocationChangedListener r100);

    void deactivate();
}
