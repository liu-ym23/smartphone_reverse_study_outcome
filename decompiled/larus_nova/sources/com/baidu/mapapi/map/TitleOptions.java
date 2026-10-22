package com.baidu.mapapi.map;

import android.graphics.Color;
import android.os.Bundle;

/* JADX INFO: loaded from: classes39.dex */
public class TitleOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f31486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextFontSizeType f31488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f31490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f31491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f31492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f31493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f31494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f31495j;

    public Bundle a() {
        Bundle r100 = new Bundle();
        int r101 = this.f31487b;
        int r102 = (r101 >> 16) & 255;
        int r103 = (r101 >> 8) & 255;
        r100.putInt("font_color", Color.argb(r101 >>> 24, r101 & 255, r103, r102));
        int r104 = this.f31486a;
        int r105 = (r104 >> 16) & 255;
        int r106 = (r104 >> 8) & 255;
        r100.putInt("bg_color", Color.argb(r104 >>> 24, r104 & 255, r106, r105));
        r100.putInt("font_size", this.f31489d);
        r100.putFloat("align_x", this.f31494i);
        r100.putFloat("align_y", this.f31495j);
        r100.putFloat("title_rotate", this.f31490e);
        r100.putInt("title_x_offset", this.f31493h);
        r100.putInt("title_y_offset", this.f31492g);
        r100.putString("text", this.f31491f);
        return r100;
    }

    public TitleOptions() {
        this.f31487b = -16777216;
        this.f31488c = TextFontSizeType.PixelTextFontSize;
        this.f31489d = 48;
        this.f31494i = 0.5f;
        this.f31495j = 1.0f;
    }

    public String getText() {
        return this.f31491f;
    }

    public float getTitleAnchorX() {
        return this.f31494i;
    }

    public float getTitleAnchorY() {
        return this.f31495j;
    }

    public int getTitleBgColor() {
        return this.f31486a;
    }

    public int getTitleFontColor() {
        return this.f31487b;
    }

    public int getTitleFontSize() {
        return this.f31489d;
    }

    public TextFontSizeType getTitleFontSizeType() {
        return this.f31488c;
    }

    public float getTitleRotate() {
        return this.f31490e;
    }

    public int getTitleXOffset() {
        return this.f31493h;
    }

    public int getTitleYOffset() {
        return this.f31492g;
    }

    public TitleOptions text(String r100) {
        this.f31491f = r100;
        return this;
    }

    public TitleOptions titleBgColor(int r100) {
        this.f31486a = r100;
        return this;
    }

    public TitleOptions titleFontColor(int r100) {
        this.f31487b = r100;
        return this;
    }

    public TitleOptions titleFontSize(int r100) {
        this.f31489d = r100;
        return this;
    }

    public TitleOptions titleFontSizeType(TextFontSizeType r100) {
        this.f31488c = r100;
        return this;
    }

    public TitleOptions titleRotate(float r100) {
    L3:
        if (r100 >= 0.0f) goto L5;
        r100 = r100 + 360.0f;
        goto L3
    L5:
        this.f31490e = r100 % 360.0f;
        return this;
    }

    public TitleOptions titleAnchor(float r100, float r101) {
        this.f31494i = r100;
        this.f31495j = r101;
        return this;
    }

    public TitleOptions titleOffset(int r100, int r101) {
        this.f31493h = r100;
        this.f31492g = r101;
        return this;
    }
}
