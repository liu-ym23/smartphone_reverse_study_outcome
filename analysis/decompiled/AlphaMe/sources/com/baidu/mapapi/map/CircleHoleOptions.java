package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.stepos.activeview.graphicsanim.renderable.ParticleSystem;

/* loaded from: classes.dex */
public class CircleHoleOptions extends HoleOptions {

    /* renamed from: a, reason: collision with root package name */
    private LatLng f6313a;

    /* renamed from: b, reason: collision with root package name */
    private int f6314b;

    public CircleHoleOptions() {
        this.mHoleType = ParticleSystem.TYPE_CIRCLE;
    }

    public CircleHoleOptions center(LatLng latLng) {
        if (latLng == null) {
            Log.e("baidumapsdk", "CircleHole center can not be null");
            return this;
        }
        this.f6313a = latLng;
        return this;
    }

    public LatLng getHoleCenter() {
        return this.f6313a;
    }

    public int getHoleRadius() {
        return this.f6314b;
    }

    public CircleHoleOptions radius(int i4) {
        if (i4 <= 0) {
            Log.e("baidumapsdk", "CircleHole's radius can not be less than zero");
            return this;
        }
        this.f6314b = i4;
        return this;
    }
}
