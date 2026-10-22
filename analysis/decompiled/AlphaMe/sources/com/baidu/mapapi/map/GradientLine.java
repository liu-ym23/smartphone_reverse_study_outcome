package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.GradientLineOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.stepos.alphame.sleep.SleepModeData;
import java.util.List;

/* loaded from: classes.dex */
public class GradientLine extends Overlay {

    /* renamed from: g, reason: collision with root package name */
    List<LatLng> f6358g;

    /* renamed from: h, reason: collision with root package name */
    int[] f6359h;

    /* renamed from: i, reason: collision with root package name */
    int[] f6360i;

    /* renamed from: j, reason: collision with root package name */
    int f6361j = 5;

    /* renamed from: k, reason: collision with root package name */
    GradientLineOptions.LineDirectionCross180 f6362k = GradientLineOptions.LineDirectionCross180.NONE;

    public GradientLine() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.gradientLine;
    }

    private static void b(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        List<LatLng> list = this.f6358g;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add GradientLine, you must at least supply 2 points");
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6358g.get(0));
        bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
        bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
        bundle.putInt("width", this.f6361j);
        int[] iArr = this.f6359h;
        if (iArr == null) {
            throw new IllegalStateException("BDMapSDKException: Indexs array can not be null");
        }
        if (iArr.length == 0) {
            throw new IllegalStateException("BDMapSDKException: Indexs array size can not be Equal to zero");
        }
        a(this.f6358g, this.f6362k, bundle);
        a(this.f6359h, bundle);
        int[] iArr2 = this.f6360i;
        if (iArr2 == null) {
            throw new IllegalStateException("BDMapSDKException: colors array can not be null");
        }
        if (iArr2.length == 0) {
            throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
        }
        b(iArr2, bundle);
        return bundle;
    }

    public int[] getColors() {
        return this.f6360i;
    }

    public int[] getIndexs() {
        return this.f6359h;
    }

    public GradientLineOptions.LineDirectionCross180 getLineDirectionCross180() {
        return this.f6362k;
    }

    public List<LatLng> getPoints() {
        return this.f6358g;
    }

    public float getWidth() {
        return this.f6361j;
    }

    public void lineDirectionCross180(GradientLineOptions.LineDirectionCross180 lineDirectionCross180) {
        this.f6362k = lineDirectionCross180;
    }

    public void setColorIndex(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
        }
        this.f6359h = iArr;
        this.listener.c(this);
    }

    public void setColorList(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
        }
        this.f6360i = iArr;
        this.listener.c(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.f6358g = list;
        this.listener.c(this);
    }

    public void setWidth(int i4) {
        if (i4 > 0) {
            this.f6361j = i4;
            this.listener.c(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.util.List<com.baidu.mapapi.model.LatLng> r17, com.baidu.mapapi.map.GradientLineOptions.LineDirectionCross180 r18, android.os.Bundle r19) {
        /*
            r0 = r18
            r1 = r19
            int r2 = r17.size()
            double[] r3 = new double[r2]
            double[] r4 = new double[r2]
            r5 = 0
        Ld:
            if (r5 >= r2) goto L72
            r6 = r17
            java.lang.Object r7 = r6.get(r5)
            com.baidu.mapapi.model.LatLng r7 = (com.baidu.mapapi.model.LatLng) r7
            com.baidu.mapapi.map.GradientLineOptions$LineDirectionCross180 r8 = com.baidu.mapapi.map.GradientLineOptions.LineDirectionCross180.FROM_EAST_TO_WEST
            r9 = 4645040803167600640(0x4076800000000000, double:360.0)
            r11 = 0
            java.lang.String r13 = "lineDirectionCross180"
            if (r0 != r8) goto L3b
            double r14 = r7.longitude
            int r16 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r16 >= 0) goto L3b
            com.baidu.mapapi.model.LatLng r11 = new com.baidu.mapapi.model.LatLng
            double r6 = r7.latitude
            double r14 = r14 + r9
            r11.<init>(r6, r14)
            int r6 = r8.ordinal()
            r1.putInt(r13, r6)
            r7 = r11
            goto L5f
        L3b:
            com.baidu.mapapi.map.GradientLineOptions$LineDirectionCross180 r6 = com.baidu.mapapi.map.GradientLineOptions.LineDirectionCross180.FROM_WEST_TO_EAST
            if (r0 != r6) goto L56
            double r14 = r7.longitude
            int r8 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r8 <= 0) goto L56
            com.baidu.mapapi.model.LatLng r8 = new com.baidu.mapapi.model.LatLng
            double r11 = r7.latitude
            double r14 = r14 - r9
            r8.<init>(r11, r14)
            int r6 = r6.ordinal()
            r1.putInt(r13, r6)
            r7 = r8
            goto L5f
        L56:
            com.baidu.mapapi.map.GradientLineOptions$LineDirectionCross180 r6 = com.baidu.mapapi.map.GradientLineOptions.LineDirectionCross180.NONE
            int r6 = r6.ordinal()
            r1.putInt(r13, r6)
        L5f:
            com.baidu.platform.comapi.basestruct.GeoPoint r6 = com.baidu.mapapi.model.CoordUtil.ll2mc(r7)
            double r7 = r6.getLongitudeE6()
            r3[r5] = r7
            double r6 = r6.getLatitudeE6()
            r4[r5] = r6
            int r5 = r5 + 1
            goto Ld
        L72:
            java.lang.String r0 = "x_array"
            r1.putDoubleArray(r0, r3)
            java.lang.String r0 = "y_array"
            r1.putDoubleArray(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.GradientLine.a(java.util.List, com.baidu.mapapi.map.GradientLineOptions$LineDirectionCross180, android.os.Bundle):void");
    }

    private static void a(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_indexs", iArr);
    }
}
