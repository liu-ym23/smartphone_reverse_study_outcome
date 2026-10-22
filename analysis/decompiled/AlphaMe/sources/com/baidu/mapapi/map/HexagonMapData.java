package com.baidu.mapapi.map;

import android.os.Bundle;
import java.util.Collection;

/* loaded from: classes.dex */
public class HexagonMapData {

    /* renamed from: a, reason: collision with root package name */
    private double[] f6472a;

    /* renamed from: b, reason: collision with root package name */
    private double[] f6473b;

    /* renamed from: c, reason: collision with root package name */
    private double[] f6474c;

    /* renamed from: d, reason: collision with root package name */
    private float f6475d;

    public HexagonMapData(Collection<WeightedLatLng> collection, float f4) {
        int size = collection.size();
        this.f6472a = new double[size];
        this.f6473b = new double[size];
        this.f6474c = new double[size];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (WeightedLatLng weightedLatLng : collection) {
            this.f6472a[i4] = weightedLatLng.getPoint().x;
            this.f6473b[i5] = weightedLatLng.getPoint().y;
            this.f6474c[i6] = weightedLatLng.getIntensity();
            i6++;
            i5++;
            i4++;
        }
        this.f6475d = f4;
    }

    public void toBundle(Bundle bundle) {
        bundle.putDoubleArray("x_array", this.f6472a);
        bundle.putDoubleArray("y_array", this.f6473b);
        bundle.putDoubleArray("z_array", this.f6474c);
    }
}
