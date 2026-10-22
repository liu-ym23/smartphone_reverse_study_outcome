package com.baidu.mapapi.map;

import android.graphics.Typeface;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* JADX INFO: loaded from: classes39.dex */
public class TextStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BmTextStyle f31422a;

    public TextStyle() {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L7;
        this.f31422a = new BmTextStyle();
        return;
    L7:
        throw new NullPointerException("BDMapSDKException: TextStyle must be used in Overlay2.0");
    }

    public BmTextStyle getBmTextStyle() {
        return this.f31422a;
    }

    public void setBorderColor(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31422a.a(r100);
        return;
    }

    public void setBorderWidth(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31422a.b(r100);
        return;
    }

    public void setFontOption(Typeface r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31422a.c(r100.getStyle());
        return;
    }

    public void setTextColor(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31422a.d(r100);
        return;
    }

    public void setTextSize(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31422a.e(r100);
        return;
    }

    public void setTextSizeType(TextFontSizeType r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31422a.f(r100.ordinal());
        return;
    }
}
