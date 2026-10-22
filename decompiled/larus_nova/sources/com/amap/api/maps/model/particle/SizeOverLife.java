package com.amap.api.maps.model.particle;

/* JADX INFO: loaded from: classes28.dex */
public abstract class SizeOverLife {
    public final int DEFAULT_SIZE;
    protected final int TYPE_CURVESIZEOVERLIFE;
    protected final int TYPE_DEFAULT;
    protected int type;

    public abstract float getSizeX(float r100);

    public abstract float getSizeY(float r100);

    public abstract float getSizeZ(float r100);

    public SizeOverLife() {
        this.TYPE_DEFAULT = -1;
        this.TYPE_CURVESIZEOVERLIFE = 0;
        this.type = -1;
        this.DEFAULT_SIZE = 0;
    }
}
