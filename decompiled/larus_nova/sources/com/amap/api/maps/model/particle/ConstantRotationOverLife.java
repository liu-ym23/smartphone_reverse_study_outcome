package com.amap.api.maps.model.particle;

/* JADX INFO: loaded from: classes28.dex */
public class ConstantRotationOverLife extends RotationOverLife {
    private float rotate;

    @Override // com.amap.api.maps.model.particle.RotationOverLife
    public float getRotate() {
        return this.rotate;
    }

    public ConstantRotationOverLife(float r100) {
        this.rotate = r100;
        this.type = 0;
    }
}
