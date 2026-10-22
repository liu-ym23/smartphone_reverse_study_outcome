package com.baidu.mapapi.map;

import android.graphics.Color;
import android.os.Bundle;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class TitleOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private int f7041a;

    /* renamed from: d, reason: collision with root package name */
    private float f7044d;

    /* renamed from: e, reason: collision with root package name */
    private String f7045e;

    /* renamed from: f, reason: collision with root package name */
    private int f7046f;

    /* renamed from: g, reason: collision with root package name */
    private int f7047g;

    /* renamed from: b, reason: collision with root package name */
    private int f7042b = -16777216;

    /* renamed from: c, reason: collision with root package name */
    private int f7043c = 48;

    /* renamed from: h, reason: collision with root package name */
    private float f7048h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    private float f7049i = 1.0f;

    public Bundle a() {
        Bundle bundle = new Bundle();
        int i4 = this.f7042b;
        int i5 = (i4 >> 8) & 255;
        bundle.putInt("font_color", Color.argb(i4 >>> 24, i4 & 255, i5, (i4 >> 16) & 255));
        int i6 = this.f7041a;
        int i7 = (i6 >> 8) & 255;
        bundle.putInt("bg_color", Color.argb(i6 >>> 24, i6 & 255, i7, (i6 >> 16) & 255));
        bundle.putInt("font_size", this.f7043c);
        bundle.putFloat("align_x", this.f7048h);
        bundle.putFloat("align_y", this.f7049i);
        bundle.putFloat("title_rotate", this.f7044d);
        bundle.putInt("title_x_offset", this.f7047g);
        bundle.putInt("title_y_offset", this.f7046f);
        bundle.putString("text", this.f7045e);
        return bundle;
    }

    public String getText() {
        return this.f7045e;
    }

    public float getTitleAnchorX() {
        return this.f7048h;
    }

    public float getTitleAnchorY() {
        return this.f7049i;
    }

    public int getTitleBgColor() {
        return this.f7041a;
    }

    public int getTitleFontColor() {
        return this.f7042b;
    }

    public int getTitleFontSize() {
        return this.f7043c;
    }

    public float getTitleRotate() {
        return this.f7044d;
    }

    public int getTitleXOffset() {
        return this.f7047g;
    }

    public int getTitleYOffset() {
        return this.f7046f;
    }

    public TitleOptions text(String str) {
        this.f7045e = str;
        return this;
    }

    public TitleOptions titleAnchor(float f4, float f5) {
        this.f7048h = f4;
        this.f7049i = f5;
        return this;
    }

    public TitleOptions titleBgColor(int i4) {
        this.f7041a = i4;
        return this;
    }

    public TitleOptions titleFontColor(int i4) {
        this.f7042b = i4;
        return this;
    }

    public TitleOptions titleFontSize(int i4) {
        this.f7043c = i4;
        return this;
    }

    public TitleOptions titleOffset(int i4, int i5) {
        this.f7047g = i4;
        this.f7046f = i5;
        return this;
    }

    public TitleOptions titleRotate(float f4) {
        while (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 += 360.0f;
        }
        this.f7044d = f4 % 360.0f;
        return this;
    }
}
