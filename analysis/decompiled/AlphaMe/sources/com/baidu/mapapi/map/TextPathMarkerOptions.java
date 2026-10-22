package com.baidu.mapapi.map;

import android.graphics.Typeface;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* loaded from: classes.dex */
public class TextPathMarkerOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private String f6964a;

    /* renamed from: b, reason: collision with root package name */
    private int f6965b;

    /* renamed from: c, reason: collision with root package name */
    private int f6966c;

    /* renamed from: d, reason: collision with root package name */
    private int f6967d;

    /* renamed from: e, reason: collision with root package name */
    private int f6968e;

    /* renamed from: f, reason: collision with root package name */
    private Typeface f6969f;

    /* renamed from: g, reason: collision with root package name */
    private List<LatLng> f6970g;

    /* renamed from: h, reason: collision with root package name */
    int f6971h;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        TextPathMarker textPathMarker = new TextPathMarker();
        List<LatLng> list = this.f6970g;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
        }
        textPathMarker.f6954g = this.f6964a;
        textPathMarker.f6959l = this.f6966c;
        textPathMarker.f6958k = this.f6965b;
        textPathMarker.f6960m = this.f6967d;
        textPathMarker.f6961n = this.f6968e;
        textPathMarker.f6962o = this.f6969f;
        textPathMarker.f6963p = this.f6970g;
        textPathMarker.f6720c = this.f6971h;
        return textPathMarker;
    }

    public List<LatLng> getPoints() {
        return this.f6970g;
    }

    public String getText() {
        return this.f6964a;
    }

    public int getTextBorderColor() {
        return this.f6967d;
    }

    public int getTextBorderWidth() {
        return this.f6968e;
    }

    public int getTextColor() {
        return this.f6965b;
    }

    public Typeface getTextFontOption() {
        return this.f6969f;
    }

    public int getTextSize() {
        return this.f6966c;
    }

    public int getZIndex() {
        return this.f6971h;
    }

    public TextPathMarkerOptions points(List<LatLng> list) {
        this.f6970g = list;
        return this;
    }

    public TextPathMarkerOptions text(String str) {
        this.f6964a = str;
        return this;
    }

    public TextPathMarkerOptions textBorderColor(int i4) {
        this.f6967d = i4;
        return this;
    }

    public TextPathMarkerOptions textBorderWidth(int i4) {
        this.f6968e = i4;
        return this;
    }

    public TextPathMarkerOptions textColor(int i4) {
        this.f6965b = i4;
        return this;
    }

    public TextPathMarkerOptions textFontOption(Typeface typeface) {
        this.f6969f = typeface;
        return this;
    }

    public TextPathMarkerOptions textSize(int i4) {
        this.f6966c = i4;
        return this;
    }

    public TextPathMarkerOptions zIndex(int i4) {
        this.f6971h = i4;
        return this;
    }
}
