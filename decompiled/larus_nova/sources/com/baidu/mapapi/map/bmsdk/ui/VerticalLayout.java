package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmVerticalLayout;

/* JADX INFO: loaded from: classes39.dex */
public class VerticalLayout extends GroupUI {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BmVerticalLayout f31584c;

    public VerticalLayout() {
        BmVerticalLayout r100 = new BmVerticalLayout();
        this.f31584c = r100;
        r100.a(this);
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.GroupUI, com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.f31584c;
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.GroupUI
    public void addView(BaseUI r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f31584c.a(r100.getBmBaseUI());
    }

    public void setBackground(BitmapDescriptor r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BmBitmapResource r101 = new BmBitmapResource(r100.getBitmap());
        this.f31584c.a(r101);
    }

    public void setBackgroundColor(int r100) {
        this.f31584c.b(r100);
    }

    public void setClickable(boolean r100) {
        this.f31584c.a(r100);
    }

    public void setGravity(UIGravity r100) {
        this.f31584c.e(r100.getNumber());
    }

    public void addView(BaseUI r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f31584c.a(r100.getBmBaseUI(), r101);
    }

    public void setMargin(int r100, int r101, int r102, int r103) {
        this.f31584c.a(r100, r101, r102, r103);
    }

    public void setPadding(int r100, int r101, int r102, int r103) {
        this.f31584c.b(r100, r101, r102, r103);
    }
}
