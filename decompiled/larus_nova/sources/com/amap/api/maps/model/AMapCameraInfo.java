package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public class AMapCameraInfo {
    private float aspectRatio;
    private float fov;
    private float positionX;
    private float positionY;
    private float positionZ;
    private float rotate;

    public String toString() {
        return "[fov:" + this.fov + " aspectRatio:" + this.aspectRatio + " rotate:" + this.rotate + " pos_x:" + this.positionX + " pos_y:" + this.positionY + " pos_z:" + this.positionZ + "]";
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public float getFov() {
        return this.fov;
    }

    public float getRotate() {
        return this.rotate;
    }

    public float getX() {
        return this.positionX;
    }

    public float getY() {
        return this.positionY;
    }

    public float getZ() {
        return this.positionZ;
    }

    public AMapCameraInfo(float r100, float r101, float r102, float r103, float r104, float r105) {
        this.fov = r100;
        this.aspectRatio = r101;
        this.rotate = r102;
        this.positionX = r103;
        this.positionY = r104;
        this.positionZ = r105;
    }
}
