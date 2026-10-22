package com.amap.api.maps.model.particle;

/* JADX INFO: loaded from: classes28.dex */
public abstract class VelocityGenerate {
    protected final int TYPE_DEFAULT;
    protected final int TYPE_RANDOMVELOCITYBETWEENTWOCONSTANTS;
    protected int type;

    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();

    public VelocityGenerate() {
        this.TYPE_DEFAULT = -1;
        this.TYPE_RANDOMVELOCITYBETWEENTWOCONSTANTS = 0;
        this.type = -1;
    }
}
