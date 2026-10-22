package com.amap.api.maps.model.particle;

/* JADX INFO: loaded from: classes28.dex */
public class ParticleOverLifeModule {
    private static final int TYPE_COLOR = 3;
    private static final int TYPE_ROTATE = 1;
    private static final int TYPE_SCALE = 2;
    private static final int TYPE_VEL = 0;
    private ColorGenerate colorGenerate;
    private Object colorGenerateObject;
    private boolean isNeedReloadColorGenerate;
    private boolean isNeedReloadRotationOverLife;
    private boolean isNeedReloadSizeOverLife;
    private boolean isNeedReloadVelocityGenerate;
    private VelocityGenerate overLife;
    private RotationOverLife rotateOverLife;
    private Object rotateOverLifeObject;
    private SizeOverLife sizeOverLife;
    private Object sizeOverLifeObject;
    private VelocityGenerate velocityOverLife;
    private Object velocityOverLifeObject;

    public ParticleOverLifeModule() {
        this.overLife = null;
        this.velocityOverLife = null;
        this.isNeedReloadVelocityGenerate = false;
        this.isNeedReloadRotationOverLife = false;
        this.isNeedReloadSizeOverLife = false;
        this.isNeedReloadColorGenerate = false;
    }

    public void setColorGenerate(ColorGenerate r100) {
        this.colorGenerate = r100;
        this.colorGenerateObject = r100;
        this.isNeedReloadColorGenerate = true;
    }

    public void setRotateOverLife(RotationOverLife r100) {
        this.rotateOverLife = r100;
        this.rotateOverLifeObject = r100;
        this.isNeedReloadRotationOverLife = true;
    }

    public void setSizeOverLife(SizeOverLife r100) {
        this.sizeOverLife = r100;
        this.sizeOverLifeObject = r100;
        this.isNeedReloadSizeOverLife = true;
    }

    public void setVelocityOverLife(VelocityGenerate r100) {
        this.overLife = r100;
        this.velocityOverLife = r100;
        this.velocityOverLifeObject = r100;
        this.isNeedReloadVelocityGenerate = true;
    }
}
