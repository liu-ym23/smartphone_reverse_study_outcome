package com.baidu.mapapi.map;

import android.os.Bundle;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class HexagonMapData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double[] f30987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double[] f30988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double[] f30989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f30990d;

    public void toBundle(Bundle r100) {
        r100.putDoubleArray("x_array", this.f30987a);
        r100.putDoubleArray("y_array", this.f30988b);
        r100.putDoubleArray("z_array", this.f30989c);
    }

    public HexagonMapData(Collection<WeightedLatLng> r100, float r110) {
        int r101 = r100.size();
        this.f30987a = new double[r101];
        this.f30988b = new double[r101];
        this.f30989c = new double[r101];
        Iterator<WeightedLatLng> r102 = r100.iterator();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        WeightedLatLng r106 = r102.next();
        this.f30987a[r103] = r106.getPoint().x;
        this.f30988b[r104] = r106.getPoint().y;
        this.f30989c[r105] = r106.getIntensity();
        r105 = r105 + 1;
        r104 = r104 + 1;
        r103 = r103 + 1;
        goto L4
    L6:
        this.f30990d = r110;
    }
}
