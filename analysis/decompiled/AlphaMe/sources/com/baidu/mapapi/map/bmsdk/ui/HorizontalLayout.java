package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmHorizontalLayout;

/* loaded from: classes.dex */
public class HorizontalLayout extends GroupUI {

    /* renamed from: c, reason: collision with root package name */
    private final BmHorizontalLayout f7139c = new BmHorizontalLayout();

    @Override // com.baidu.mapapi.map.bmsdk.ui.GroupUI
    public void addView(BaseUI baseUI) {
        if (baseUI == null) {
            return;
        }
        this.f7139c.a(baseUI.getBmBaseUI());
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.GroupUI, com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.f7139c;
    }

    public void setBackground(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.f7139c.a(new BmBitmapResource(bitmapDescriptor.getBitmap()));
    }

    public void setBackgroundColor(int i4) {
        this.f7139c.b(i4);
    }

    public void setClickable(boolean z4) {
        this.f7139c.a(z4);
    }

    public void setGravity(UIGravity uIGravity) {
        this.f7139c.e(uIGravity.getNumber());
    }

    public void setMargin(int i4, int i5, int i6, int i7) {
        this.f7139c.a(i4, i5, i6, i7);
    }

    public void setPadding(int i4, int i5, int i6, int i7) {
        this.f7139c.b(i4, i5, i6, i7);
    }
}
