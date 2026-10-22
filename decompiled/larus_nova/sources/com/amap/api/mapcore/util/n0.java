package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes28.dex */
public class n0 {
    public static void a(String r100, String r101, boolean r102) {
    }

    public static void b(String r100, String r101, boolean r102) {
    }

    public static AbstractCameraUpdateMessage a() {
        m0 r100 = new m0();
        r100.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        r100.amount = -1.0f;
        return r100;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_amap_api_mapcore_util_n0_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static AbstractCameraUpdateMessage a(CameraPosition r100) {
        k0 r101 = new k0();
        r101.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (r100 == null) goto L8;
        LatLng r102 = r100.target;
        if (r102 == null) goto L8;
        DPoint r103 = VirtualEarthProjection.latLongToPixelsDouble(r102.latitude, r102.longitude, 20);
        r101.geoPoint = new DPoint(r103.f30021x, r103.f30022y);
        r101.zoom = r100.zoom;
        r101.bearing = r100.bearing;
        r101.tilt = r100.tilt;
        r101.cameraPosition = r100;
    L8:
        return r101;
    }

    public static z8 b(String r100) {
        return z8.a(new y8.a().a(r100).a());
    }

    public static PublicKey a(String r100) throws Exception {
        byte[] r101 = h6.a(r100);     // Catch: NullPointerException -> L4 InvalidKeySpecException -> L6 NoSuchAlgorithmException -> L8
        return KeyFactory.getInstance(x5.b("EUlNB")).generatePublic(new X509EncodedKeySpec(r101));
    L5:
        throw new Exception("公钥数据为空");
    L9:
        throw new Exception("无此算法");
    L7:
        throw new Exception("公钥非法");
    }

    public static AbstractCameraUpdateMessage a(Point r100) {
        k0 r101 = new k0();
        r101.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        r101.geoPoint = new DPoint(r100.x, r100.y);
        return r101;
    }

    public static AbstractCameraUpdateMessage a(float r100) {
        k0 r101 = new k0();
        r101.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        r101.bearing = r100;
        return r101;
    }

    public static int a(Context r100, float r101) {
        return (int) ((r101 * INVOKEVIRTUAL_com_amap_api_mapcore_util_n0_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static AbstractCameraUpdateMessage a(float r100, Point r101) {
        m0 r102 = new m0();
        r102.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        r102.amount = r100;
        r102.focus = r101;
        return r102;
    }

    public static void a(Context r100, String r101, String r102, Object r103) {
        String r104 = r103.getClass().getSimpleName();
        SharedPreferences.Editor r105 = r100.getSharedPreferences(r101, 0).edit();
        if ("String".equals(r104) == false) goto L6;
        r105.putString(r102, (String) r103);
    L17:
        r105.commit();
        return;
    L6:
        if ("Integer".equals(r104) == false) goto L9;
        r105.putInt(r102, ((Integer) r103).intValue());
        goto L17
    L9:
        if ("Boolean".equals(r104) == false) goto L12;
        r105.putBoolean(r102, ((Boolean) r103).booleanValue());
        goto L17
    L12:
        if ("Float".equals(r104) == false) goto L15;
        r105.putFloat(r102, ((Float) r103).floatValue());
        goto L17
    L15:
        if ("Long".equals(r104) == false) goto L17;
        r105.putLong(r102, ((Long) r103).longValue());
        goto L17
    }

    public static z8 a(int r100, int r101, BlockingQueue<Runnable> r102, String r103) {
        return z8.a(new y8.a().a(r100).b(r101).a(r102).a(r103).a());
    }

    public static void a(IGLSurfaceView r100, int r101, int r110, int r111, int r112, int r113, int r114) {
        if (r112 <= 0) goto L6;
        SurfaceHolder r102 = r100.getHolder();
        if (r102 == null) goto L6;
        r102.setFormat(-3);
    L6:
        r100.setEGLContextFactory(new l3());
        r100.setEGLConfigChooser(new k3(r101, r110, r111, r112, r113, r114));
    }
}
