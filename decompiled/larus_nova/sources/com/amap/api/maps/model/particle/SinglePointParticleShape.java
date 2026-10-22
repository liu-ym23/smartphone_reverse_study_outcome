package com.amap.api.maps.model.particle;

/* JADX INFO: loaded from: classes28.dex */
public class SinglePointParticleShape extends ParticleShapeModule {
    private float[] point_3;

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return this.point_3;
    }

    public SinglePointParticleShape(float r100, float r101, float r102) {
        this(r100, r101, r102, false);
    }

    public SinglePointParticleShape(float r100, float r101, float r102, boolean r103) {
        this.point_3 = new float[]{r100, r101, r102};
        this.isUseRatio = r103;
        this.type = 0;
    }
}
