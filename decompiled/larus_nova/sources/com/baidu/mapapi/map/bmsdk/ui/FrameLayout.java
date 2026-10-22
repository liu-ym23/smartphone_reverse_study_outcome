package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.Overlay;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmFrameLayout;

/* JADX INFO: loaded from: classes39.dex */
public class FrameLayout extends GroupUI {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BmFrameLayout f31573c;

    public FrameLayout() {
        BmFrameLayout r100 = new BmFrameLayout();
        this.f31573c = r100;
        r100.a(this);
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.GroupUI, com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.f31573c;
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.GroupUI
    public void addView(BaseUI r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f31573c.a(r100.getBmBaseUI());
    }

    public void setBackground(BitmapDescriptor r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BmBitmapResource r101 = new BmBitmapResource(r100.getBitmap());
        this.f31573c.a(r101);
    }

    public void setBackgroundColor(int r100) {
        this.f31573c.b(r100);
    }

    public void setClickable(boolean r100) {
        this.f31573c.a(r100);
    }

    public void setGravity(int r100) {
        this.f31573c.e(r100);
    }

    public void updateAddView(BaseUI r100, Overlay r101) {
        if (r100 == null) goto L9;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getBmLayer() == null) goto L11;
        this.f31573c.a(r100.getBmBaseUI());
        r101.getBmLayer().b();
        return;
    L11:
        return;
    }

    public void updateBackground(BitmapDescriptor r100, Overlay r101) {
        if (r100 == null) goto L9;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getBmLayer() == null) goto L11;
        BmBitmapResource r102 = new BmBitmapResource(r100.getBitmap());
        this.f31573c.a(r102);
        r101.getBmLayer().b();
        return;
    L11:
        return;
    }

    public void updateBackgroundColor(int r100, Overlay r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getBmLayer() == null) goto L9;
        this.f31573c.b(r100);
        r101.getBmLayer().b();
        return;
    }

    public void updateClickable(boolean r100, Overlay r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getBmLayer() == null) goto L9;
        this.f31573c.a(r100);
        r101.getBmLayer().b();
        return;
    }

    public void updateGravity(int r100, Overlay r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getBmLayer() == null) goto L9;
        this.f31573c.e(r100);
        r101.getBmLayer().b();
        return;
    }

    public void setMargin(int r100, int r101, int r102, int r103) {
        this.f31573c.a(r100, r101, r102, r103);
    }

    public void setPadding(int r100, int r101, int r102, int r103) {
        this.f31573c.b(r100, r101, r102, r103);
    }
}
