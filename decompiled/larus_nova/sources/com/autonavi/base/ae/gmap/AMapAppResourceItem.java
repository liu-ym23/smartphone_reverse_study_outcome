package com.autonavi.base.ae.gmap;

/* JADX INFO: loaded from: classes39.dex */
public class AMapAppResourceItem {
    public static final int RESOURCE_TYPE_ABSPATH = 4;
    public static final int RESOURCE_TYPE_BINARY = 3;
    public static final int RESOURCE_TYPE_IMAGE = 1;
    public static final int RESOURCE_TYPE_NONE = 0;
    public static final int RESOURCE_TYPE_SVG = 2;
    private byte[] data;
    private int imageHeight;
    private float imageScale;
    private int imageWidth;
    private boolean preAlpha;
    private int resourceType;
    private long size;

    public AMapAppResourceItem() {
        this.resourceType = 0;
        this.preAlpha = false;
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.imageScale = 1.0f;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public float getImageScale() {
        return this.imageScale;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public int getResourceType() {
        return this.resourceType;
    }

    public long getSize() {
        return this.size;
    }

    public boolean isPreAlpha() {
        return this.preAlpha;
    }

    public void setData(byte[] r100) {
        this.data = r100;
    }

    public void setImageHeight(int r100) {
        this.imageHeight = r100;
    }

    public void setImageScale(float r100) {
        this.imageScale = r100;
    }

    public void setImageWidth(int r100) {
        this.imageWidth = r100;
    }

    public void setPreAlpha(boolean r100) {
        this.preAlpha = r100;
    }

    public void setResourceType(int r100) {
        this.resourceType = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }
}
