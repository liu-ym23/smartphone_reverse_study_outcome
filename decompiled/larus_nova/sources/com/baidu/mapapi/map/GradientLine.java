package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class GradientLine extends Overlay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    List<LatLng> f30877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int[] f30878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int[] f30879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f30880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    GradientLineOptions.LineDirectionCross180 f30881k;

    public float getWidth() {
        return this.f30880j;
    }

    public GradientLine() {
        this.f30880j = 5;
        this.f30881k = GradientLineOptions.LineDirectionCross180.NONE;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32154n;
    }

    public int[] getColors() {
        return this.f30879i;
    }

    public int[] getIndexs() {
        return this.f30878h;
    }

    public GradientLineOptions.LineDirectionCross180 getLineDirectionCross180() {
        return this.f30881k;
    }

    public List<LatLng> getPoints() {
        return this.f30877g;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        List<LatLng> r101 = this.f30877g;
        if (r101 == null) goto L25;
        if (r101.size() < 2) goto L25;
        GeoPoint r102 = CoordUtil.ll2mc((LatLng) ListProtector.get(this.f30877g, 0));
        r100.putDouble("location_x", r102.getLongitudeE6());
        r100.putDouble("location_y", r102.getLatitudeE6());
        r100.putInt("width", this.f30880j);
        int[] r103 = this.f30878h;
        if (r103 == null) goto L23;
        if (r103.length == 0) goto L21;
        a(this.f30877g, this.f30881k, r100);
        a(this.f30878h, r100);
        int[] r104 = this.f30879i;
        if (r104 == null) goto L19;
        if (r104.length == 0) goto L17;
        b(r104, r100);
        return r100;
    L17:
        throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
    L19:
        throw new IllegalStateException("BDMapSDKException: colors array can not be null");
    L21:
        throw new IllegalStateException("BDMapSDKException: Indexs array size can not be Equal to zero");
    L23:
        throw new IllegalStateException("BDMapSDKException: Indexs array can not be null");
    L25:
        throw new IllegalStateException("BDMapSDKException: when you add GradientLine, you must at least supply 2 points");
    }

    public void lineDirectionCross180(GradientLineOptions.LineDirectionCross180 r100) {
        this.f30881k = r100;
    }

    public void setColorIndex(int[] r100) {
        if (r100 == null) goto L8;
        if (r100.length == 0) goto L8;
        this.f30878h = r100;
        this.listener.c(this);
        return;
    L8:
        throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
    }

    public void setColorList(int[] r100) {
        if (r100 == null) goto L8;
        if (r100.length == 0) goto L8;
        this.f30879i = r100;
        this.listener.c(this);
        return;
    L8:
        throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
    }

    public void setPoints(List<LatLng> r100) {
        if (r100 == null) goto L14;
        if (r100.size() < 2) goto L12;
        if (r100.contains(null) == true) goto L10;
        this.f30877g = r100;
        this.listener.c(this);
        return;
    L10:
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
    L12:
        throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
    L14:
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public void setWidth(int r100) {
        if (r100 <= 0) goto L5;
        this.f30880j = r100;
        this.listener.c(this);
        return;
    }

    private static void a(int[] r100, Bundle r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 0) goto L8;
        r101.putIntArray("color_indexs", r100);
        return;
    }

    private static void b(int[] r100, Bundle r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 0) goto L8;
        r101.putIntArray("color_array", r100);
        return;
    }

    private static void a(List<LatLng> r110, GradientLineOptions.LineDirectionCross180 r111, Bundle r112) {
        int r100 = r110.size();
        double[] r101 = new double[r100];
        double[] r102 = new double[r100];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L16;
        LatLng r104 = (LatLng) ListProtector.get(r110, r103);
        GradientLineOptions.LineDirectionCross180 r105 = GradientLineOptions.LineDirectionCross180.FROM_EAST_TO_WEST;
        if (r111 != r105) goto L9;
        double r113 = r104.longitude;
        if (r113 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        LatLng r114 = new LatLng(r104.latitude, r113 + 360.0d);
        r112.putInt("lineDirectionCross180", r105.ordinal());
        r104 = r114;
    L15:
        GeoPoint r106 = CoordUtil.ll2mc(r104);
        r101[r103] = r106.getLongitudeE6();
        r102[r103] = r106.getLatitudeE6();
        r103 = r103 + 1;
    L9:
        GradientLineOptions.LineDirectionCross180 r107 = GradientLineOptions.LineDirectionCross180.FROM_WEST_TO_EAST;
        if (r111 != r107) goto L14;
        double r115 = r104.longitude;
        if (r115 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        LatLng r108 = new LatLng(r104.latitude, r115 - 360.0d);
        r112.putInt("lineDirectionCross180", r107.ordinal());
        r104 = r108;
    L14:
        r112.putInt("lineDirectionCross180", GradientLineOptions.LineDirectionCross180.NONE.ordinal());
        goto L15
    L16:
        r112.putDoubleArray("x_array", r101);
        r112.putDoubleArray("y_array", r102);
    }
}
