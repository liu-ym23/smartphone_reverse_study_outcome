package com.amap.api.maps.model.particle;

/* JADX INFO: loaded from: classes28.dex */
public abstract class ParticleShapeModule {
    protected final int TYPE_DEFAULT;
    protected final int TYPE_RECT;
    protected final int TYPE_SINGLEPOINT;
    protected boolean isUseRatio;
    protected int type;

    public abstract float[] getPoint();

    public ParticleShapeModule() {
        this.TYPE_DEFAULT = -1;
        this.TYPE_SINGLEPOINT = 0;
        this.TYPE_RECT = 1;
        this.type = -1;
        this.isUseRatio = false;
    }

    public boolean isUseRatio() {
        return this.isUseRatio;
    }
}
