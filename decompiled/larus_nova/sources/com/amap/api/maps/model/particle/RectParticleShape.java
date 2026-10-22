package com.amap.api.maps.model.particle;

/* JADX INFO: loaded from: classes28.dex */
public class RectParticleShape extends ParticleShapeModule {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return null;
    }

    public RectParticleShape(float r100, float r101, float r102, float r103, boolean r104) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
        this.isUseRatio = r104;
        this.type = 1;
    }
}
