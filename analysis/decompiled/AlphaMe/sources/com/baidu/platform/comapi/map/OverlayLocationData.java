package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class OverlayLocationData {

    /* renamed from: a, reason: collision with root package name */
    private String f9037a;

    /* renamed from: b, reason: collision with root package name */
    private String f9038b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f9039c;

    /* renamed from: d, reason: collision with root package name */
    private int f9040d;

    /* renamed from: e, reason: collision with root package name */
    private int f9041e;

    /* renamed from: f, reason: collision with root package name */
    private String f9042f;

    /* renamed from: g, reason: collision with root package name */
    private float f9043g;

    /* renamed from: h, reason: collision with root package name */
    private float f9044h;

    /* renamed from: i, reason: collision with root package name */
    private int f9045i;

    /* renamed from: j, reason: collision with root package name */
    private int f9046j;

    public float getArrowSize() {
        return this.f9044h;
    }

    public String getGIFImgPath() {
        return this.f9042f;
    }

    public Bitmap getImage() {
        return this.f9039c;
    }

    public int getImgHeight() {
        return this.f9041e;
    }

    public String getImgName() {
        return this.f9037a;
    }

    public String getImgType() {
        return this.f9038b;
    }

    public int getImgWidth() {
        return this.f9040d;
    }

    public float getMarkerSize() {
        return this.f9043g;
    }

    public int isAnimation() {
        return this.f9046j;
    }

    public int isRotation() {
        return this.f9045i;
    }

    public void setAnimation(int i4) {
        this.f9046j = i4;
    }

    public void setArrowSize(float f4) {
        this.f9044h = f4;
    }

    public void setGIFImgPath(String str) {
        this.f9042f = str;
    }

    public void setImage(Bitmap bitmap) {
        this.f9039c = bitmap;
    }

    public void setImgHeight(int i4) {
        this.f9041e = i4;
    }

    public void setImgName(String str) {
        this.f9037a = str;
    }

    public void setImgType(String str) {
        this.f9038b = str;
    }

    public void setImgWidth(int i4) {
        this.f9040d = i4;
    }

    public void setMarkerSize(float f4) {
        this.f9043g = f4;
    }

    public void setRotation(int i4) {
        this.f9045i = i4;
    }
}
