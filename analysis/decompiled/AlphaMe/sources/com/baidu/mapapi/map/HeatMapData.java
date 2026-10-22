package com.baidu.mapapi.map;

import android.os.Bundle;
import java.util.Collection;

/* loaded from: classes.dex */
public class HeatMapData {

    /* renamed from: a, reason: collision with root package name */
    private double[] f6442a;

    /* renamed from: b, reason: collision with root package name */
    private double[] f6443b;

    /* renamed from: c, reason: collision with root package name */
    private double[] f6444c;

    /* renamed from: d, reason: collision with root package name */
    private float f6445d;

    public HeatMapData(Collection<WeightedLatLng> collection, float f4) {
        int size = collection.size();
        this.f6442a = new double[size];
        this.f6443b = new double[size];
        this.f6444c = new double[size];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (WeightedLatLng weightedLatLng : collection) {
            this.f6442a[i4] = weightedLatLng.getPoint().x;
            this.f6443b[i5] = weightedLatLng.getPoint().y;
            this.f6444c[i6] = weightedLatLng.getIntensity();
            i6++;
            i5++;
            i4++;
        }
        this.f6445d = f4;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putDoubleArray("x_array", this.f6442a);
        bundle.putDoubleArray("y_array", this.f6443b);
        bundle.putDoubleArray("z_array", this.f6444c);
        bundle.putFloat("max_intentity", this.f6445d);
        return bundle;
    }
}
