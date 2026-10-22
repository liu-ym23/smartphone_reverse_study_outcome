package com.byted.mgl.merge.service.model;

import android.content.Context;
import android.content.res.Resources;
import com.larus.nova.R;
import java.io.Serializable;

/* JADX INFO: loaded from: classes43.dex */
public class BdpPoiInfo implements Serializable {
    private static final int DISTANCE_TOO_CLOSE_THRESHOLD_IN_METER = 50;
    public long distanceInMeter;
    public BdpLatLng latLng;
    public String poiAddress;
    public String poiName;

    public BdpPoiInfo() {
    }

    public String toFriendlyDistanceString(Context r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.getResources() == null) goto L19;
        Resources r101 = r100.getResources();
        long r102 = this.distanceInMeter;
        if (r102 < 1000) goto L10;
        return r101.getString(R.string.bdpapp_m_choose_location_distance_in_kilometer, new Object[]{Float.valueOf(r102 / 1000.0f)});
    L10:
        if (r102 < 50) goto L14;
        return r101.getString(R.string.bdpapp_m_choose_location_distance_in_meter, new Object[]{Long.valueOf(r102)});
    L14:
        if (r102 >= 0) goto L16;
        return null;
    L16:
        return r101.getString(R.string.bdpapp_m_choose_location_distance_too_close, new Object[]{50});
    L19:
        return null;
    }
}
