package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;

/* JADX INFO: loaded from: classes39.dex */
public class LineStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    BmLineStyle f31009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f31010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f31011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    TextureOption f31012d;

    public LineStyle() {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L7;
        this.f31009a = new BmLineStyle();
        return;
    L7:
        throw new NullPointerException("BDMapSDKException: LineStyle must be used in Overlay2.0");
    }

    public void setBitmapResource(BitmapDescriptor r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        Bitmap r101 = r100.getBitmap();
        this.f31009a.a(new BmBitmapResource(r101));
        return;
    }

    public void setColor(int r100) {
        this.f31010b = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31009a.a(r100);
        return;
    }

    public void setTextureOption(TextureOption r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31012d = r100;
        this.f31009a.c(r100.ordinal());
        return;
    }

    public void setWidth(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31011c = r100 / 2;
        this.f31009a.a(r100);
        return;
    }
}
