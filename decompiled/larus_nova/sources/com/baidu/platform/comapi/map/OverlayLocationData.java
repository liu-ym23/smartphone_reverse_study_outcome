package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes39.dex */
public class OverlayLocationData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f33142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f33143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f33144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f33145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f33146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f33147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f33148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f33149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f33150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f33151j;

    public OverlayLocationData() {
    }

    public float getArrowSize() {
        return this.f33149h;
    }

    public String getGIFImgPath() {
        return this.f33147f;
    }

    public Bitmap getImage() {
        return this.f33144c;
    }

    public int getImgHeight() {
        return this.f33146e;
    }

    public String getImgName() {
        return this.f33142a;
    }

    public String getImgType() {
        return this.f33143b;
    }

    public int getImgWidth() {
        return this.f33145d;
    }

    public float getMarkerSize() {
        return this.f33148g;
    }

    public int isAnimation() {
        return this.f33151j;
    }

    public int isRotation() {
        return this.f33150i;
    }

    public void setAnimation(int r100) {
        this.f33151j = r100;
    }

    public void setArrowSize(float r100) {
        this.f33149h = r100;
    }

    public void setGIFImgPath(String r100) {
        this.f33147f = r100;
    }

    public void setImage(Bitmap r100) {
        this.f33144c = r100;
    }

    public void setImgHeight(int r100) {
        this.f33146e = r100;
    }

    public void setImgName(String r100) {
        this.f33142a = r100;
    }

    public void setImgType(String r100) {
        this.f33143b = r100;
    }

    public void setImgWidth(int r100) {
        this.f33145d = r100;
    }

    public void setMarkerSize(float r100) {
        this.f33148g = r100;
    }

    public void setRotation(int r100) {
        this.f33150i = r100;
    }
}
