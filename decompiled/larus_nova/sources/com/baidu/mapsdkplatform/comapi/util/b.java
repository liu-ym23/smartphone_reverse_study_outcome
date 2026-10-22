package com.baidu.mapsdkplatform.comapi.util;

import android.os.Bundle;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static double[] f32294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static double[] f32295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static double[][] f32296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static double[][] f32297d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f32298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f32299b;

        public a() {
        }
    }

    static {
        f32294a = new double[]{1.289059486E7d, 8362377.87d, 5591021.0d, 3481989.83d, 1678043.12d, AudioStats.AUDIO_AMPLITUDE_NONE};
        f32295b = new double[]{85.0d, 60.0d, 45.0d, 30.0d, 15.0d, AudioStats.AUDIO_AMPLITUDE_NONE};
        f32296c = new double[][]{new double[]{1.410526172116255E-8d, 8.98305509648872E-6d, -1.9939833816331d, 200.9824383106796d, -187.2403703815547d, 91.6087516669843d, -23.38765649603339d, 2.57121317296198d, -0.03801003308653d, 1.73379812E7d}, new double[]{-7.435856389565537E-9d, 8.983055097726239E-6d, -0.78625201886289d, 96.32687599759846d, -1.85204757529826d, -59.36935905485877d, 47.40033549296737d, -16.50741931063887d, 2.28786674699375d, 1.026014486E7d}, new double[]{-3.030883460898826E-8d, 8.98305509983578E-6d, 0.30071316287616d, 59.74293618442277d, 7.357984074871d, -25.38371002664745d, 13.45380521110908d, -3.29883767235584d, 0.32710905363475d, 6856817.37d}, new double[]{-1.981981304930552E-8d, 8.983055099779535E-6d, 0.03278182852591d, 40.31678527705744d, 0.65659298677277d, -4.44255534477492d, 0.85341911805263d, 0.12923347998204d, -0.04625736007561d, 4482777.06d}, new double[]{3.09191371068437E-9d, 8.983055096812155E-6d, 6.995724062E-5d, 23.10934304144901d, -2.3663490511E-4d, -0.6321817810242d, -0.00663494467273d, 0.03430082397953d, -0.00466043876332d, 2555164.4d}, new double[]{2.890871144776878E-9d, 8.983055095805407E-6d, -3.068298E-8d, 7.47137025468032d, -3.53937994E-6d, -0.02145144861037d, -1.234426596E-5d, 1.0322952773E-4d, -3.23890364E-6d, 826088.5d}};
        f32297d = new double[][]{new double[]{-0.0015702102444d, 111320.7020616939d, 1.704480524535203E15d, -1.033898737604234E16d, 2.611266785660388E16d, -3.51496691766537E16d, 2.659570071840392E16d, -1.072501245418824E16d, 1.800819912950474E15d, 82.5d}, new double[]{8.277824516172526E-4d, 111320.7020463578d, 6.477955746671607E8d, -4.082003173641316E9d, 1.077490566351142E10d, -1.517187553151559E10d, 1.205306533862167E10d, -5.124939663577472E9d, 9.133119359512032E8d, 67.5d}, new double[]{0.00337398766765d, 111320.7020202162d, 4481351.045890365d, -2.339375119931662E7d, 7.968221547186455E7d, -1.159649932797253E8d, 9.723671115602145E7d, -4.366194633752821E7d, 8477230.501135234d, 52.5d}, new double[]{0.00220636496208d, 111320.7020209128d, 51751.86112841131d, 3796837.749470245d, 992013.7397791013d, -1221952.21711287d, 1340652.697009075d, -620943.6990984312d, 144416.9293806241d, 37.5d}, new double[]{-3.441963504368392E-4d, 111320.7020576856d, 278.2353980772752d, 2485758.690035394d, 6070.750963243378d, 54821.18345352118d, 9540.606633304236d, -2710.55326746645d, 1405.483844121726d, 22.5d}, new double[]{-3.218135878613132E-4d, 111320.7020701615d, 0.00369383431289d, 823725.6402795718d, 0.46104986909093d, 2351.343141331292d, 1.58060784298199d, 8.77738589078284d, 0.37238884252424d, 7.45d}};
    }

    public static LatLng a(GeoPoint r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        a r100 = new a();
        r100.f32298a = r110.getLongitudeE6();
        r100.f32299b = r110.getLatitudeE6();
        a r111 = new a();
        double r101 = r100.f32298a;
        r111.f32298a = r101;
        if (r101 <= 2.0037508342E7d) goto L9;
        r111.f32298a = (r101 - 2.0037508342E7d) - 2.0037508342E7d;
    L11:
        double r102 = r100.f32299b;
        r111.f32299b = r102;
        if (r102 >= 1.0E-6d) goto L17;
        if (r102 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L17;
        r111.f32299b = 1.0E-6d;
    L27:
        double[] r103 = new double[10];
        int r104 = 0;
    L29:
        if (r104 >= 6) goto L34;
        if (Math.abs(r111.f32299b) >= f32294a[r104]) goto L32;
        r104 = r104 + 1;
        goto L29
    L32:
        r103 = f32296c[r104];
    L34:
        a r112 = a(r111, r103);
        return new LatLng(r112.f32299b, r112.f32298a);
    L17:
        if (r102 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L22;
        if (r102 <= (-1.0E-6d)) goto L22;
        r111.f32299b = -1.0E-6d;
    L22:
        if (r102 <= 2.0037508342E7d) goto L25;
        r111.f32299b = 2.0037508342E7d;
        goto L27
    L25:
        if (r102 >= (-2.0037508342E7d)) goto L27;
        r111.f32299b = -2.0037508342E7d;
        goto L27
    L9:
        if (r101 >= (-2.0037508342E7d)) goto L11;
        r111.f32298a = 2.0037508342E7d - ((-2.0037508342E7d) - r101);
        goto L11
    }

    public static List<LatLng> b(String r110) {
        ComplexPt r111 = com.baidu.mapsdkplatform.comjni.tools.a.a(r110);
        ArrayList r100 = new ArrayList();
        if (r111 == null) goto L18;
        ArrayList<ArrayList<Point>> r112 = r111.mGeoPt;
        if (r112 != null) goto L8;
        return null;
    L8:
        if (r112.size() <= 0) goto L17;
        int r101 = 0;
        ArrayList r113 = (ArrayList) ListProtector.get(r112, 0);
    L11:
        if (r101 >= r113.size()) goto L17;
        Point r102 = (Point) ListProtector.get(r113, r101);
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L15;
        r100.add(CoordTrans.baiduToGcj(a(new GeoPoint(r102.getDoubleY() / 100.0d, r102.getDoubleX() / 100.0d))));
    L16:
        r101 = r101 + 1;
        goto L11
    L15:
        r100.add(a(new GeoPoint(r102.getDoubleY() / 100.0d, r102.getDoubleX() / 100.0d)));
    L17:
        return r100;
    L18:
        return null;
    }

    public static List<List<LatLng>> c(String r110) {
        ComplexPt r111 = com.baidu.mapsdkplatform.comjni.tools.a.a(r110);
        if (r111 == null) goto L19;
        ArrayList<ArrayList<Point>> r112 = r111.mGeoPt;
        if (r112 == null) goto L28;
        ArrayList r100 = new ArrayList();
        Iterator<ArrayList<Point>> r113 = r112.iterator();
    L9:
        if (r113.hasNext() == false) goto L18;
        ArrayList<Point> r101 = r113.next();
        ArrayList r102 = new ArrayList();
        Iterator<Point> r103 = r101.iterator();
    L12:
        if (r103.hasNext() == false) goto L17;
        Point r104 = r103.next();
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) goto L15;
        r102.add(a(new GeoPoint(r104.getDoubleY() / 100.0d, r104.getDoubleX() / 100.0d)));
        goto L12
    L15:
        r102.add(CoordTrans.baiduToGcj(a(new GeoPoint(r104.getDoubleY() / 100.0d, r104.getDoubleX() / 100.0d))));
        goto L12
    L17:
        r100.add(r102);
        goto L9
    L18:
        return r100;
    L28:
        return null;
    L19:
        return null;
    }

    public static LatLng d(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() <= 0) goto L10;
        Bundle r101 = new Bundle();
        r101.putString("strkey", r100);
        JNITools.TransNodeStr2Pt(r101);
        return a(new GeoPoint(r101.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY), r101.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX)));
    L10:
        return null;
    }

    public static GeoPoint a(LatLng r100) {
        a r101 = new a();
        double[] r102 = new double[10];
        r101.f32298a = r100.longitude;
        double r103 = r100.latitude;
        r101.f32299b = r103;
        if (r103 >= 1.0E-7d) goto L8;
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        r101.f32299b = 1.0E-7d;
    L18:
        int r104 = 0;
    L20:
        if (r104 >= f32295b.length) goto L25;
        if (Math.abs(r101.f32299b) >= f32295b[r104]) goto L23;
        r104 = r104 + 1;
        goto L20
    L23:
        r102 = f32297d[r104];
    L25:
        a r105 = a(r101, r102);
        return new GeoPoint(r105.f32299b, r105.f32298a);
    L8:
        if (r103 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        if (r103 <= (-1.0E-7d)) goto L13;
        r101.f32299b = -1.0E-7d;
    L13:
        if (r103 < 85.0d) goto L16;
        r101.f32299b = 84.9999999d;
        goto L18
    L16:
        if (r103 > (-85.0d)) goto L18;
        r101.f32299b = -84.9999999d;
        goto L18
    }

    public static Point b(LatLng r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Bundle r101 = new Bundle();
        JNITools.CoordinateEncryptMc(r100.longitude, r100.latitude, r101);
        return new Point(r101.getDouble("x"), r101.getDouble("y"));
    }

    public static LatLng a(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() <= 0) goto L10;
        Bundle r101 = new Bundle();
        r101.putString("strkey", r100);
        JNITools.TransGeoStr2Pt(r101);
        GeoPoint r102 = new GeoPoint(0, 0);
        r102.setLongitudeE6(r101.getInt(MapBundleKey.MapObjKey.OBJ_SL_PTX));
        r102.setLatitudeE6(r101.getInt(MapBundleKey.MapObjKey.OBJ_SL_PTY));
        return a(r102);
    L10:
        return null;
    }

    public static a a(a r110, double[] r111) {
        a r100 = new a();
        int r101 = 1;
        r100.f32298a = r111[0] + (r111[1] * Math.abs(r110.f32298a));
        double r102 = Math.abs(r110.f32299b) / r111[9];
        double r103 = (((((r111[2] + (r111[3] * r102)) + ((r111[4] * r102) * r102)) + (((r111[5] * r102) * r102) * r102)) + ((((r111[6] * r102) * r102) * r102) * r102)) + (((((r111[7] * r102) * r102) * r102) * r102) * r102)) + ((((((r111[8] * r102) * r102) * r102) * r102) * r102) * r102);
        r100.f32299b = r103;
        double r104 = r100.f32298a;
        if (r110.f32298a >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        int r105 = -1;
    L6:
        r100.f32298a = r104 * ((double) r105);
        if (r110.f32299b >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        r101 = -1;
    L9:
        r100.f32299b = r103 * ((double) r101);
        return r100;
    L5:
        r105 = 1;
        goto L6
    }

    public static int a(LatLng r100, int r101) {
        LatLng r102 = new LatLng(r100.latitude + (((double) r101) / 111000.0d), r100.longitude);
        GeoPoint r103 = a(r100);
        GeoPoint r104 = a(r102);
        return (int) Math.sqrt(Math.pow(r103.getLatitudeE6() - r104.getLatitudeE6(), 2.0d) + Math.pow(r103.getLongitudeE6() - r104.getLongitudeE6(), 2.0d));
    }

    public static LatLng a(float r100, float r101, String r102) {
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.equals("") == true) goto L25;
        if (r102.equals(CoordinateType.BD09LL) == true) goto L25;
        if (r102.equals(CoordinateType.BD09LL) == false) goto L13;
    L19:
        Bundle r103 = new Bundle();
        JNITools.CoordinateEncryptEx(r100, r101, r102, r103);
        if (r103.isEmpty() == false) goto L22;
        return null;
    L22:
        return new LatLng(r103.getDouble("y"), r103.getDouble("x"));
    L13:
        if (r102.equals(CoordinateType.BD09MC) == true) goto L19;
        if (r102.equals("gcj02") == true) goto L19;
        if (r102.equals("wgs84") == true) goto L19;
        return null;
    L25:
        return new LatLng(r100, r101);
    }
}
