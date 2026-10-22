package com.amap.api.maps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amap.api.col.jmsl.A0;
import com.amap.api.col.jmsl.C1569j2;
import com.amap.api.col.jmsl.C1623x1;
import com.amap.api.col.jmsl.g5;
import com.amap.api.maps.model.AMapException;
import com.amap.api.maps.model.LatLng;
import java.util.List;

/* loaded from: classes.dex */
public class AMapUtils {
    private static final String AMAPNAVIURL = "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d";
    private static final String AMAPPOISEARCHURL = "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0";
    private static final String AMAPROUTEURL = "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d";
    public static final int BUS_COMFORT = 4;
    public static final int BUS_MONEY_LITTLE = 1;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_TIME_FIRST = 0;
    public static final int BUS_TRANSFER_LITTLE = 2;
    public static final int BUS_WALK_LITTLE = 3;
    private static final double DEG_TO_RAD = 0.017453292519943295d;
    private static final int DRING_ROUTE_MODEL = 2;
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private static final double EARTHRADIUS = 6378137.0d;
    private static final double NF_PI = 0.01745329251994329d;

    /* renamed from: R, reason: collision with root package name */
    private static final double f17211R = 6378137.0d;
    private static final int TRANSIT_ROUTE_MODEL = 1;

    public static class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        String f17212a;

        /* renamed from: b, reason: collision with root package name */
        Context f17213b;

        public a(String str, Context context) {
            this.f17212a = str;
            if (context != null) {
                this.f17213b = context.getApplicationContext();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.f17213b != null) {
                try {
                    A0.e(this.f17213b, new C1569j2.a(this.f17212a, "1.2.0", C1623x1.f17031b).c(new String[]{"com.amap.api.maps"}).d());
                    interrupt();
                } catch (g5 e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public static float calculateArea(LatLng latLng, LatLng latLng2) throws AMapException {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e10) {
                e10.printStackTrace();
                return 0.0f;
            }
        }
        try {
            double dSin = Math.sin((latLng.latitude * 3.141592653589793d) / 180.0d) - Math.sin((latLng2.latitude * 3.141592653589793d) / 180.0d);
            double d10 = (latLng2.longitude - latLng.longitude) / 360.0d;
            if (d10 < 0.0d) {
                d10 += 1.0d;
            }
            return (float) (dSin * 2.5560394669790553E14d * d10);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public static float calculateLineDistance(LatLng latLng, LatLng latLng2) throws AMapException {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e10) {
                e10.printStackTrace();
                return 0.0f;
            }
        }
        try {
            double d10 = latLng.longitude;
            double d11 = latLng.latitude;
            double d12 = latLng2.longitude;
            double d13 = latLng2.latitude;
            double d14 = d10 * NF_PI;
            double d15 = d11 * NF_PI;
            double d16 = d12 * NF_PI;
            double d17 = d13 * NF_PI;
            double dSin = Math.sin(d14);
            double dSin2 = Math.sin(d15);
            double dCos = Math.cos(d14);
            double dCos2 = Math.cos(d15);
            double dSin3 = Math.sin(d16);
            double dSin4 = Math.sin(d17);
            double dCos3 = Math.cos(d16);
            double dCos4 = Math.cos(d17);
            double[] dArr = {dCos * dCos2, dCos2 * dSin, dSin2};
            double[] dArr2 = {dCos3 * dCos4, dCos4 * dSin3, dSin4};
            double d18 = dArr[0];
            double d19 = dArr2[0];
            double d20 = (d18 - d19) * (d18 - d19);
            double d21 = dArr[1];
            double d22 = dArr2[1];
            double d23 = d20 + ((d21 - d22) * (d21 - d22));
            double d24 = dArr[2];
            double d25 = dArr2[2];
            return (float) (Math.asin(Math.sqrt(d23 + ((d24 - d25) * (d24 - d25))) / 2.0d) * 1.27420015798544E7d);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public static void getLatestAMapApp(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("http://wap.amap.com/"));
            new a("glaa", context).start();
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static float calculateArea(List<LatLng> list) {
        if (list == null || list.size() < 3) {
            return 0.0f;
        }
        int size = list.size();
        double dCos = 0.0d;
        int i10 = 0;
        while (i10 < size) {
            LatLng latLng = list.get(i10);
            i10++;
            LatLng latLng2 = list.get(i10 % size);
            double dCos2 = latLng.longitude * 111319.49079327357d * Math.cos(latLng.latitude * DEG_TO_RAD);
            double d10 = latLng.latitude * 111319.49079327357d;
            dCos += (dCos2 * (latLng2.latitude * 111319.49079327357d)) - (((latLng2.longitude * 111319.49079327357d) * Math.cos(latLng2.latitude * DEG_TO_RAD)) * d10);
        }
        return (float) Math.abs(dCos / 2.0d);
    }
}
