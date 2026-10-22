package com.amap.api.maps.model.particle;

/* JADX INFO: loaded from: classes28.dex */
public abstract class ColorGenerate {
    protected final int TYPE_DEFAULT;
    protected final int TYPE_RANDOMCOLORBETWEENTWOCONSTANTS;
    protected int type;

    public abstract float[] getColor();

    public ColorGenerate() {
        this.TYPE_DEFAULT = -1;
        this.TYPE_RANDOMCOLORBETWEENTWOCONSTANTS = 0;
        this.type = -1;
    }
}
