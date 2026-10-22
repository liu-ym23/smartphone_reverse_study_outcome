package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* loaded from: classes.dex */
public class ParticleOptions {

    /* renamed from: a, reason: collision with root package name */
    private List<BitmapDescriptor> f6727a;

    /* renamed from: b, reason: collision with root package name */
    private LatLng f6728b;

    public List<BitmapDescriptor> getParticleImgs() {
        return this.f6727a;
    }

    public LatLng getParticlePos() {
        return this.f6728b;
    }

    public void setParticleImgs(List<BitmapDescriptor> list) {
        this.f6727a = list;
    }

    public void setParticlePos(LatLng latLng) {
        this.f6728b = latLng;
    }
}
