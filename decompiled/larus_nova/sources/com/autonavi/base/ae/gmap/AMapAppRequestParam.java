package com.autonavi.base.ae.gmap;

/* JADX INFO: loaded from: classes39.dex */
public class AMapAppRequestParam {
    public static final int RESOURCE_TYPE_ABSPATH = 4;
    public static final int RESOURCE_TYPE_BINARY = 3;
    public static final int RESOURCE_TYPE_IMAGE = 1;
    public static final int RESOURCE_TYPE_NONE = 0;
    public static final int RESOURCE_TYPE_SVG = 2;
    private ResourceCallback callback;
    private long contextId;
    private int expectHeight;
    private int expectWidth;
    private int resourceType;
    private String url;

    public AMapAppRequestParam() {
        this.resourceType = 0;
        this.contextId = 0;
        this.expectWidth = 0;
        this.expectHeight = 0;
    }

    public ResourceCallback getCallback() {
        return this.callback;
    }

    public long getContextId() {
        return this.contextId;
    }

    public int getExpectHeight() {
        return this.expectHeight;
    }

    public int getExpectWidth() {
        return this.expectWidth;
    }

    public int getResourceType() {
        return this.resourceType;
    }

    public String getUrl() {
        return this.url;
    }

    public void generateCallback(long r100) {
        this.callback = new ResourceCallback(r100);
    }

    public void setCallback(ResourceCallback r100) {
        this.callback = r100;
    }

    public void setContextId(long r100) {
        this.contextId = r100;
    }

    public void setExpectHeight(int r100) {
        this.expectHeight = r100;
    }

    public void setExpectWidth(int r100) {
        this.expectWidth = r100;
    }

    public void setResourceType(int r100) {
        this.resourceType = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
