package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public final class TextOptions extends OverlayOptions {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f31378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLng f31379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextFontSizeType f31382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f31383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Typeface f31384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f31385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f31386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f31387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f31388k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f31389l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f31390m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f31391n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f31392o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f31393p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f31394q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    float f31395r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f31396s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Point f31397t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f31398u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f31399v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f31400w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Bundle f31401x;

    public float getAlignX() {
        return this.f31387j;
    }

    public float getAlignY() {
        return this.f31388k;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Text r100 = new Text();
        r100.f31205d = this.f31400w;
        r100.f31204c = this.f31399v;
        r100.f31206e = this.f31401x;
        r100.f31359i = this.f31378a;
        r100.f31360j = this.f31379b;
        r100.f31361k = this.f31380c;
        r100.f31362l = this.f31381d;
        r100.f31363m = this.f31382e;
        r100.f31364n = this.f31383f;
        r100.f31365o = this.f31384g;
        r100.f31369s = this.f31387j;
        r100.f31370t = this.f31388k;
        r100.f31368r = this.f31386i;
        r100.f31367q = this.f31385h;
        r100.f31371u = this.f31389l;
        r100.f31373w = this.f31390m;
        r100.f31376z = this.f31391n;
        r100.B = this.f31393p;
        r100.A = this.f31392o;
        r100.C = this.f31394q;
        r100.D = this.f31395r;
        r100.F = this.f31396s;
        boolean r101 = this.f31398u;
        r100.H = r101;
        if (r101 == false) goto L5;
        r100.G = this.f31397t;
    L5:
        return r100;
    }

    public TextOptions() {
        this.f31381d = -16777216;
        this.f31382e = TextFontSizeType.AdaptTextFontSize;
        this.f31383f = 12;
        this.f31384g = Typeface.DEFAULT;
        this.f31385h = 0.5f;
        this.f31386i = 0.5f;
        this.f31387j = 4;
        this.f31388k = 32;
        this.f31390m = true;
        this.f31392o = 0;
        this.f31393p = 0;
        this.f31394q = 1.0f;
        this.f31395r = 1.0f;
        this.f31396s = Integer.MAX_VALUE;
        this.f31398u = false;
        this.f31400w = true;
    }

    public int getBgColor() {
        return this.f31380c;
    }

    public Bundle getExtraInfo() {
        return this.f31401x;
    }

    public int getFontColor() {
        return this.f31381d;
    }

    public int getFontSize() {
        return this.f31383f;
    }

    public TextFontSizeType getFontSizeType() {
        return this.f31382e;
    }

    public LatLng getPosition() {
        return this.f31379b;
    }

    public int getPriority() {
        return this.f31396s;
    }

    public float getRotate() {
        return this.f31389l;
    }

    public String getText() {
        return this.f31378a;
    }

    public Typeface getTypeface() {
        return this.f31384g;
    }

    public int getZIndex() {
        return this.f31399v;
    }

    public boolean isPerspective() {
        return this.f31391n;
    }

    public boolean isVisible() {
        return this.f31400w;
    }

    public TextOptions bgColor(int r100) {
        this.f31380c = r100;
        return this;
    }

    public TextOptions extraInfo(Bundle r100) {
        this.f31401x = r100;
        return this;
    }

    public TextOptions fixedScreenPosition(Point r100) {
        this.f31397t = r100;
        this.f31398u = true;
        return this;
    }

    public TextOptions fontColor(int r100) {
        this.f31381d = r100;
        return this;
    }

    public TextOptions fontSize(int r100) {
        this.f31383f = r100;
        return this;
    }

    public TextOptions fontSizeType(TextFontSizeType r100) {
        this.f31382e = r100;
        return this;
    }

    public TextOptions perspective(boolean r100) {
        this.f31391n = r100;
        return this;
    }

    public TextOptions position(LatLng r100) {
        if (r100 == null) goto L6;
        this.f31379b = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public TextOptions priority(int r100) {
        this.f31396s = r100;
        return this;
    }

    public TextOptions rotate(float r100) {
        this.f31389l = r100;
        return this;
    }

    public TextOptions scaleX(float r100) {
        if (r100 >= 0.0f) goto L5;
        return this;
    L5:
        this.f31394q = r100;
        return this;
    }

    public TextOptions scaleY(float r100) {
        if (r100 >= 0.0f) goto L5;
        return this;
    L5:
        this.f31395r = r100;
        return this;
    }

    public TextOptions setClickable(boolean r100) {
        this.f31390m = r100;
        return this;
    }

    public TextOptions text(String r100) {
        if (r100 == null) goto L8;
        if (r100.equals("") == true) goto L8;
        this.f31378a = r100;
        return this;
    L8:
        throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
    }

    public TextOptions typeface(Typeface r100) {
        this.f31384g = r100;
        return this;
    }

    public TextOptions visible(boolean r100) {
        this.f31400w = r100;
        return this;
    }

    public TextOptions xOffset(int r100) {
        this.f31393p = r100;
        return this;
    }

    public TextOptions yOffset(int r100) {
        this.f31392o = r100;
        return this;
    }

    public TextOptions zIndex(int r100) {
        this.f31399v = r100;
        return this;
    }

    public TextOptions align(int r100, int r101) {
        this.f31387j = r100;
        this.f31388k = r101;
        return this;
    }

    public TextOptions anchor(float r100, float r101) {
        if (r100 >= 0.0f) goto L5;
    L12:
        return this;
    L5:
        if (r100 > 1.0f) goto L12;
        if (r101 < 0.0f) goto L12;
        if (r101 > 1.0f) goto L12;
        this.f31385h = r100;
        this.f31386i = r101;
        goto L12
    }
}
