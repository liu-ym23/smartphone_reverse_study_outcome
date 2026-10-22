package com.baidu.mapapi.map;

import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;

/* loaded from: classes.dex */
public class LineStyle {

    /* renamed from: a, reason: collision with root package name */
    BmLineStyle f6494a;

    /* renamed from: b, reason: collision with root package name */
    int f6495b;

    /* renamed from: c, reason: collision with root package name */
    int f6496c;

    /* renamed from: d, reason: collision with root package name */
    TextureOption f6497d;

    public LineStyle() {
        if (!OverlayUtil.isOverlayUpgrade()) {
            throw new NullPointerException("BDMapSDKException: LineStyle must be used in Overlay2.0");
        }
        this.f6494a = new BmLineStyle();
    }

    public void setBitmapResource(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null && OverlayUtil.isOverlayUpgrade()) {
            this.f6494a.a(new BmBitmapResource(bitmapDescriptor.getBitmap()));
        }
    }

    public void setColor(int i4) {
        this.f6495b = i4;
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6494a.a(i4);
        }
    }

    public void setTextureOption(TextureOption textureOption) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6497d = textureOption;
            this.f6494a.c(textureOption.ordinal());
        }
    }

    public void setWidth(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6496c = i4 / 2;
            this.f6494a.d(i4);
        }
    }
}
