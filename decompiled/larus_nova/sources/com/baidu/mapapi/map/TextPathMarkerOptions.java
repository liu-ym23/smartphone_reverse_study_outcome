package com.baidu.mapapi.map;

import android.graphics.Typeface;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class TextPathMarkerOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f31413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextFontSizeType f31415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f31418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Typeface f31419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<LatLng> f31420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f31421i;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        TextPathMarker r100 = new TextPathMarker();
        List<LatLng> r101 = this.f31420h;
        if (r101 == null) goto L9;
        if (r101.size() < 2) goto L9;
        r100.f31402g = this.f31413a;
        r100.f31407l = this.f31415c;
        r100.f31408m = this.f31416d;
        r100.f31406k = this.f31414b;
        r100.f31409n = this.f31417e;
        r100.f31410o = this.f31418f;
        r100.f31411p = this.f31419g;
        r100.f31412q = this.f31420h;
        r100.f31204c = this.f31421i;
        return r100;
    L9:
        throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
    }

    public TextPathMarkerOptions() {
        this.f31415c = TextFontSizeType.AdaptTextFontSize;
    }

    public List<LatLng> getPoints() {
        return this.f31420h;
    }

    public String getText() {
        return this.f31413a;
    }

    public int getTextBorderColor() {
        return this.f31417e;
    }

    public int getTextBorderWidth() {
        return this.f31418f;
    }

    public int getTextColor() {
        return this.f31414b;
    }

    public Typeface getTextFontOption() {
        return this.f31419g;
    }

    public int getTextSize() {
        return this.f31416d;
    }

    public TextFontSizeType getTextSizeType() {
        return this.f31415c;
    }

    public int getZIndex() {
        return this.f31421i;
    }

    public TextPathMarkerOptions points(List<LatLng> r100) {
        this.f31420h = r100;
        return this;
    }

    public TextPathMarkerOptions text(String r100) {
        this.f31413a = r100;
        return this;
    }

    public TextPathMarkerOptions textBorderColor(int r100) {
        this.f31417e = r100;
        return this;
    }

    public TextPathMarkerOptions textBorderWidth(int r100) {
        this.f31418f = r100;
        return this;
    }

    public TextPathMarkerOptions textColor(int r100) {
        this.f31414b = r100;
        return this;
    }

    public TextPathMarkerOptions textFontOption(Typeface r100) {
        this.f31419g = r100;
        return this;
    }

    public TextPathMarkerOptions textSize(int r100) {
        this.f31416d = r100;
        return this;
    }

    public TextPathMarkerOptions textSizeType(TextFontSizeType r100) {
        this.f31415c = r100;
        return this;
    }

    public TextPathMarkerOptions zIndex(int r100) {
        this.f31421i = r100;
        return this;
    }
}
