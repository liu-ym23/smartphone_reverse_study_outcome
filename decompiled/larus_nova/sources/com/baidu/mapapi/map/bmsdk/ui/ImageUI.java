package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmImageUI;

/* JADX INFO: loaded from: classes39.dex */
public class ImageUI extends BaseUI {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BmImageUI f31575c;

    public ImageUI() {
        BmImageUI r100 = new BmImageUI();
        this.f31575c = r100;
        r100.a(this);
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.f31575c;
    }

    public void setClickable(boolean r100) {
        this.f31575c.a(r100);
    }

    public void setColor(int r100) {
        this.f31575c.j(r100);
    }

    public void setDrawableResource(BitmapDescriptor r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BmBitmapResource r101 = new BmBitmapResource(r100.getBitmap());
        this.f31575c.b(r101);
    }

    public void setHeight(int r100) {
        this.f31575c.f(r100);
    }

    public void setWidth(int r100) {
        this.f31575c.i(r100);
    }

    public void setMargin(int r100, int r101, int r102, int r103) {
        this.f31575c.a(r100, r101, r102, r103);
    }

    public void setPadding(int r100, int r101, int r102, int r103) {
        this.f31575c.b(r100, r101, r102, r103);
    }
}
