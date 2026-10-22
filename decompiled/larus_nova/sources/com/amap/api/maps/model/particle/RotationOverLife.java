package com.amap.api.maps.model.particle;

/* JADX INFO: loaded from: classes28.dex */
public abstract class RotationOverLife {
    protected final int TYPE_CONSTANTROTATIONOVERLIFE;
    protected final int TYPE_DEFAULT;
    protected int type;

    public abstract float getRotate();

    public RotationOverLife() {
        this.TYPE_DEFAULT = -1;
        this.TYPE_CONSTANTROTATIONOVERLIFE = 0;
        this.type = -1;
    }
}
