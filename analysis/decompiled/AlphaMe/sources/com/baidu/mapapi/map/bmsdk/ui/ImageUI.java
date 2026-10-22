package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmImageUI;

/* loaded from: classes.dex */
public class ImageUI extends BaseUI {

    /* renamed from: c, reason: collision with root package name */
    private BmImageUI f7140c;

    public ImageUI() {
        BmImageUI bmImageUI = new BmImageUI();
        this.f7140c = bmImageUI;
        bmImageUI.a(this);
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.f7140c;
    }

    public void setClickable(boolean z4) {
        this.f7140c.a(z4);
    }

    public void setColor(int i4) {
        this.f7140c.j(i4);
    }

    public void setDrawableResource(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.f7140c.b(new BmBitmapResource(bitmapDescriptor.getBitmap()));
    }

    public void setHeight(int i4) {
        this.f7140c.f(i4);
    }

    public void setMargin(int i4, int i5, int i6, int i7) {
        this.f7140c.a(i4, i5, i6, i7);
    }

    public void setPadding(int i4, int i5, int i6, int i7) {
        this.f7140c.b(i4, i5, i6, i7);
    }

    public void setWidth(int i4) {
        this.f7140c.i(i4);
    }
}
