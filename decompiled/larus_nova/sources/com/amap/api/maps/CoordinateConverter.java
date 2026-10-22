package com.amap.api.maps;

import android.content.Context;
import com.amap.api.mapcore.util.o0;
import com.amap.api.mapcore.util.t3;
import com.amap.api.mapcore.util.t6;
import com.amap.api.mapcore.util.u3;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes28.dex */
public class CoordinateConverter {
    private static final String TAG = "CoordinateConverter";
    private CoordType coordType;
    private Context ctx;
    private LatLng sourceLatLng;

    public static final enum CoordType extends Enum<CoordType> {
        private static final /* synthetic */ CoordType[] $VALUES = null;
        public static final CoordType ALIYUN = null;
        public static final CoordType BAIDU = null;
        public static final CoordType GOOGLE = null;
        public static final CoordType GPS = null;
        public static final CoordType MAPABC = null;
        public static final CoordType MAPBAR = null;
        public static final CoordType SOSOMAP = null;

        static {
            CoordType r100 = new CoordType("BAIDU", 0);
            BAIDU = r100;
            CoordType r101 = new CoordType("MAPBAR", 1);
            MAPBAR = r101;
            CoordType r102 = new CoordType("GPS", 2);
            GPS = r102;
            CoordType r103 = new CoordType("MAPABC", 3);
            MAPABC = r103;
            CoordType r104 = new CoordType("SOSOMAP", 4);
            SOSOMAP = r104;
            CoordType r105 = new CoordType("ALIYUN", 5);
            ALIYUN = r105;
            CoordType r110 = new CoordType("GOOGLE", 6);
            GOOGLE = r110;
            $VALUES = new CoordType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static CoordType[] values() {
            return (CoordType[]) $VALUES.clone();
        }

        public static CoordType valueOf(String r100) {
            return (CoordType) r27.a.a(CoordType.class, r100);
        }

        private CoordType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LatLng convert() {
        CoordType r100 = this.coordType;
        LatLng r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.sourceLatLng != null) goto L31;
        return null;
    L31:
    L28:
        th = move-exception;
        th.printStackTrace();
        t6.a(th, TAG, "convert");
        return this.sourceLatLng;
    L9:
        switch(r100.ordinal()) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            default: goto L10;
        };
    L10:
        String r102 = "";
    L26:
        u3.a(this.ctx, r102);     // Catch: Throwable -> L28
        return r101;
    L11:
        LatLng r103 = this.sourceLatLng;     // Catch: Throwable -> L28
        String r104 = "google";
    L19:
        String r105 = r104;
        r101 = r103;
        r102 = r105;
        goto L26
    L13:
        r103 = this.sourceLatLng;     // Catch: Throwable -> L28
        r104 = EventConstant.Value.ALIYUN;
        goto L19
    L15:
        r103 = this.sourceLatLng;     // Catch: Throwable -> L28
        r104 = "sosomap";
        goto L19
    L17:
        r103 = this.sourceLatLng;     // Catch: Throwable -> L28
        r104 = "mapabc";
        goto L19
    L20:
        r103 = o0.b(this.ctx, this.sourceLatLng);     // Catch: Throwable -> L28
        r104 = GeocodeSearch.GPS;
        goto L19
    L22:
        r101 = o0.a(this.ctx, this.sourceLatLng);     // Catch: Throwable -> L28
        r102 = "mapbar";
        goto L26
    L24:
        r101 = o0.a(this.sourceLatLng);     // Catch: Throwable -> L28
        r102 = "baidu";
        goto L26
    }

    public CoordinateConverter(Context r100) {
        this.coordType = null;
        this.sourceLatLng = null;
        this.ctx = r100;
    }

    public CoordinateConverter coord(LatLng r100) {
        this.sourceLatLng = r100;
        return this;
    }

    public CoordinateConverter from(CoordType r100) {
        this.coordType = r100;
        return this;
    }

    public static boolean isAMapDataAvailable(double r100, double r101) {
        return t3.b(r100, r101);
    }
}
