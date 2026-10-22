package com.amap.api.maps.model.particle;

/* JADX INFO: loaded from: classes28.dex */
public class CurveSizeOverLife extends SizeOverLife {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f28676x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f28677y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f28678z;

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeX(float r100) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeY(float r100) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeZ(float r100) {
        return 0.0f;
    }

    public CurveSizeOverLife(float r100, float r101, float r102) {
        this.f28676x = r100;
        this.f28677y = r101;
        this.f28678z = r102;
        this.type = 0;
    }
}
