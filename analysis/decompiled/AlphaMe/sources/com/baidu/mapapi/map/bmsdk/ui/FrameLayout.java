package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.Overlay;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmFrameLayout;

/* loaded from: classes.dex */
public class FrameLayout extends GroupUI {

    /* renamed from: c, reason: collision with root package name */
    private BmFrameLayout f7138c;

    public FrameLayout() {
        BmFrameLayout bmFrameLayout = new BmFrameLayout();
        this.f7138c = bmFrameLayout;
        bmFrameLayout.a(this);
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.GroupUI
    public void addView(BaseUI baseUI) {
        if (baseUI == null) {
            return;
        }
        this.f7138c.a(baseUI.getBmBaseUI());
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.GroupUI, com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.f7138c;
    }

    public void setBackground(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.f7138c.a(new BmBitmapResource(bitmapDescriptor.getBitmap()));
    }

    public void setBackgroundColor(int i4) {
        this.f7138c.b(i4);
    }

    public void setClickable(boolean z4) {
        this.f7138c.a(z4);
    }

    public void setGravity(int i4) {
        this.f7138c.e(i4);
    }

    public void setMargin(int i4, int i5, int i6, int i7) {
        this.f7138c.a(i4, i5, i6, i7);
    }

    public void setPadding(int i4, int i5, int i6, int i7) {
        this.f7138c.b(i4, i5, i6, i7);
    }

    public void updateAddView(BaseUI baseUI, Overlay overlay) {
        if (baseUI == null || overlay == null || overlay.getBmLayer() == null) {
            return;
        }
        this.f7138c.a(baseUI.getBmBaseUI());
        overlay.getBmLayer().b();
    }

    public void updateBackground(BitmapDescriptor bitmapDescriptor, Overlay overlay) {
        if (bitmapDescriptor == null || overlay == null || overlay.getBmLayer() == null) {
            return;
        }
        this.f7138c.a(new BmBitmapResource(bitmapDescriptor.getBitmap()));
        overlay.getBmLayer().b();
    }

    public void updateBackgroundColor(int i4, Overlay overlay) {
        if (overlay == null || overlay.getBmLayer() == null) {
            return;
        }
        this.f7138c.b(i4);
        overlay.getBmLayer().b();
    }

    public void updateClickable(boolean z4, Overlay overlay) {
        if (overlay == null || overlay.getBmLayer() == null) {
            return;
        }
        this.f7138c.a(z4);
        overlay.getBmLayer().b();
    }

    public void updateGravity(int i4, Overlay overlay) {
        if (overlay == null || overlay.getBmLayer() == null) {
            return;
        }
        this.f7138c.e(i4);
        overlay.getBmLayer().b();
    }
}
