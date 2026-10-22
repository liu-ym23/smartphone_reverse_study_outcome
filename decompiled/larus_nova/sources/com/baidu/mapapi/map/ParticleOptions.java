package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class ParticleOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<BitmapDescriptor> f31211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLng f31212b;

    public ParticleOptions() {
    }

    public List<BitmapDescriptor> getParticleImgs() {
        return this.f31211a;
    }

    public LatLng getParticlePos() {
        return this.f31212b;
    }

    public void setParticleImgs(List<BitmapDescriptor> r100) {
        this.f31211a = r100;
    }

    public void setParticlePos(LatLng r100) {
        this.f31212b = r100;
    }
}
