package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class TextOptions extends OverlayOptions {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;

    /* renamed from: a, reason: collision with root package name */
    private String f6931a;

    /* renamed from: b, reason: collision with root package name */
    private LatLng f6932b;

    /* renamed from: c, reason: collision with root package name */
    private int f6933c;

    /* renamed from: k, reason: collision with root package name */
    private float f6941k;

    /* renamed from: m, reason: collision with root package name */
    boolean f6943m;

    /* renamed from: s, reason: collision with root package name */
    Point f6949s;

    /* renamed from: u, reason: collision with root package name */
    int f6951u;

    /* renamed from: w, reason: collision with root package name */
    Bundle f6953w;

    /* renamed from: d, reason: collision with root package name */
    private int f6934d = -16777216;

    /* renamed from: e, reason: collision with root package name */
    private int f6935e = 12;

    /* renamed from: f, reason: collision with root package name */
    private Typeface f6936f = Typeface.DEFAULT;

    /* renamed from: g, reason: collision with root package name */
    private float f6937g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    private float f6938h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    private int f6939i = 4;

    /* renamed from: j, reason: collision with root package name */
    private int f6940j = 32;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6942l = true;

    /* renamed from: n, reason: collision with root package name */
    int f6944n = 0;

    /* renamed from: o, reason: collision with root package name */
    int f6945o = 0;

    /* renamed from: p, reason: collision with root package name */
    float f6946p = 1.0f;

    /* renamed from: q, reason: collision with root package name */
    float f6947q = 1.0f;

    /* renamed from: r, reason: collision with root package name */
    int f6948r = Integer.MAX_VALUE;

    /* renamed from: t, reason: collision with root package name */
    boolean f6950t = false;

    /* renamed from: v, reason: collision with root package name */
    boolean f6952v = true;

    public TextOptions align(int i4, int i5) {
        this.f6939i = i4;
        this.f6940j = i5;
        return this;
    }

    public TextOptions anchor(float f4, float f5) {
        if (f4 >= Property.DEFAULT_FLOAT_VALUE && f4 <= 1.0f && f5 >= Property.DEFAULT_FLOAT_VALUE && f5 <= 1.0f) {
            this.f6937g = f4;
            this.f6938h = f5;
        }
        return this;
    }

    public TextOptions bgColor(int i4) {
        this.f6933c = i4;
        return this;
    }

    public TextOptions extraInfo(Bundle bundle) {
        this.f6953w = bundle;
        return this;
    }

    public TextOptions fixedScreenPosition(Point point) {
        this.f6949s = point;
        this.f6950t = true;
        return this;
    }

    public TextOptions fontColor(int i4) {
        this.f6934d = i4;
        return this;
    }

    public TextOptions fontSize(int i4) {
        this.f6935e = i4;
        return this;
    }

    public float getAlignX() {
        return this.f6939i;
    }

    public float getAlignY() {
        return this.f6940j;
    }

    public int getBgColor() {
        return this.f6933c;
    }

    public Bundle getExtraInfo() {
        return this.f6953w;
    }

    public int getFontColor() {
        return this.f6934d;
    }

    public int getFontSize() {
        return this.f6935e;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Text text = new Text();
        text.f6721d = this.f6952v;
        text.f6720c = this.f6951u;
        text.f6722e = this.f6953w;
        text.f6913i = this.f6931a;
        text.f6914j = this.f6932b;
        text.f6915k = this.f6933c;
        text.f6916l = this.f6934d;
        text.f6917m = this.f6935e;
        text.f6918n = this.f6936f;
        text.f6922r = this.f6939i;
        text.f6923s = this.f6940j;
        text.f6921q = this.f6938h;
        text.f6920p = this.f6937g;
        text.f6924t = this.f6941k;
        text.f6926v = this.f6942l;
        text.f6929y = this.f6943m;
        text.f6903A = this.f6945o;
        text.f6930z = this.f6944n;
        text.f6904B = this.f6946p;
        text.f6905C = this.f6947q;
        text.f6907E = this.f6948r;
        boolean z4 = this.f6950t;
        text.f6909G = z4;
        if (z4) {
            text.f6908F = this.f6949s;
        }
        return text;
    }

    public LatLng getPosition() {
        return this.f6932b;
    }

    public int getPriority() {
        return this.f6948r;
    }

    public float getRotate() {
        return this.f6941k;
    }

    public String getText() {
        return this.f6931a;
    }

    public Typeface getTypeface() {
        return this.f6936f;
    }

    public int getZIndex() {
        return this.f6951u;
    }

    public boolean isPerspective() {
        return this.f6943m;
    }

    public boolean isVisible() {
        return this.f6952v;
    }

    public TextOptions perspective(boolean z4) {
        this.f6943m = z4;
        return this;
    }

    public TextOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.f6932b = latLng;
        return this;
    }

    public TextOptions priority(int i4) {
        this.f6948r = i4;
        return this;
    }

    public TextOptions rotate(float f4) {
        this.f6941k = f4;
        return this;
    }

    public TextOptions scaleX(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            return this;
        }
        this.f6946p = f4;
        return this;
    }

    public TextOptions scaleY(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            return this;
        }
        this.f6947q = f4;
        return this;
    }

    public TextOptions setClickable(boolean z4) {
        this.f6942l = z4;
        return this;
    }

    public TextOptions text(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
        }
        this.f6931a = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.f6936f = typeface;
        return this;
    }

    public TextOptions visible(boolean z4) {
        this.f6952v = z4;
        return this;
    }

    public TextOptions xOffset(int i4) {
        this.f6945o = i4;
        return this;
    }

    public TextOptions yOffset(int i4) {
        this.f6944n = i4;
        return this;
    }

    public TextOptions zIndex(int i4) {
        this.f6951u = i4;
        return this;
    }
}
