package com.baidu.mapapi.map;

import android.graphics.Typeface;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* loaded from: classes.dex */
public class TextStyle {

    /* renamed from: a, reason: collision with root package name */
    private BmTextStyle f6972a;

    public TextStyle() {
        if (!OverlayUtil.isOverlayUpgrade()) {
            throw new NullPointerException("BDMapSDKException: TextStyle must be used in Overlay2.0");
        }
        this.f6972a = new BmTextStyle();
    }

    public BmTextStyle getBmTextStyle() {
        return this.f6972a;
    }

    public void setBorderColor(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6972a.a(i4);
        }
    }

    public void setBorderWidth(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6972a.b(i4);
        }
    }

    public void setFontOption(Typeface typeface) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6972a.c(typeface.getStyle());
        }
    }

    public void setTextColor(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6972a.d(i4);
        }
    }

    public void setTextSize(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6972a.e(i4);
        }
    }
}
