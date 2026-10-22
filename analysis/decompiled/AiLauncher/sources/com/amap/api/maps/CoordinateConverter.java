package com.amap.api.maps;

import android.content.Context;
import com.amap.api.col.jmsl.C1541c2;
import com.amap.api.col.jmsl.C1629z;
import com.amap.api.col.jmsl.M2;
import com.amap.api.col.jmsl.Z2;
import com.amap.api.maps.model.LatLng;

/* loaded from: classes.dex */
public class CoordinateConverter {
    private static final String TAG = "CoordinateConverter";
    private Context ctx;
    private CoordType coordType = null;
    private LatLng sourceLatLng = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.ctx = context;
    }

    public static boolean isAMapDataAvailable(double d10, double d11) {
        return M2.a(d10, d11);
    }

    public LatLng convert() {
        String str;
        LatLng latLngG;
        String str2;
        CoordType coordType = this.coordType;
        LatLng latLngD = null;
        if (coordType == null || this.sourceLatLng == null) {
            return null;
        }
        try {
            switch (coordType) {
                case BAIDU:
                    latLngD = C1629z.d(this.sourceLatLng);
                    str = "baidu";
                    break;
                case MAPBAR:
                    latLngD = C1629z.c(this.ctx, this.sourceLatLng);
                    str = "mapbar";
                    break;
                case GPS:
                    latLngG = C1629z.g(this.ctx, this.sourceLatLng);
                    str2 = "gps";
                    String str3 = str2;
                    latLngD = latLngG;
                    str = str3;
                    break;
                case MAPABC:
                    latLngG = this.sourceLatLng;
                    str2 = "mapabc";
                    String str32 = str2;
                    latLngD = latLngG;
                    str = str32;
                    break;
                case SOSOMAP:
                    latLngG = this.sourceLatLng;
                    str2 = "sosomap";
                    String str322 = str2;
                    latLngD = latLngG;
                    str = str322;
                    break;
                case ALIYUN:
                    latLngG = this.sourceLatLng;
                    str2 = "aliyun";
                    String str3222 = str2;
                    latLngD = latLngG;
                    str = str3222;
                    break;
                case GOOGLE:
                    latLngG = this.sourceLatLng;
                    str2 = "google";
                    String str32222 = str2;
                    latLngD = latLngG;
                    str = str32222;
                    break;
                default:
                    str = "";
                    break;
            }
            Z2.d(this.ctx, str);
            return latLngD;
        } catch (Throwable th) {
            th.printStackTrace();
            C1541c2.b(th, TAG, "convert");
            return this.sourceLatLng;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.sourceLatLng = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.coordType = coordType;
        return this;
    }
}
