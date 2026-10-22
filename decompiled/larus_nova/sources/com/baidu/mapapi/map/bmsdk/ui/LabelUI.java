package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.TextStyle;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmLabelUI;

/* JADX INFO: loaded from: classes39.dex */
public class LabelUI extends BaseUI {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BmLabelUI f31576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextStyle f31577d;

    public String getText() {
        return this.f31576c.b();
    }

    public LabelUI() {
        BmLabelUI r100 = new BmLabelUI();
        this.f31576c = r100;
        r100.a(this);
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.f31576c;
    }

    public TextStyle getStyle() {
        return this.f31577d;
    }

    public void setBackground(BitmapDescriptor r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BmBitmapResource r101 = new BmBitmapResource(r100.getBitmap());
        this.f31576c.a(r101);
    }

    public void setBackgroundColor(int r100) {
        this.f31576c.b(r100);
    }

    public void setClickable(boolean r100) {
        this.f31576c.a(r100);
    }

    public void setGravity(UIGravity r100) {
        this.f31576c.e(r100.getNumber());
    }

    public void setHeight(int r100) {
        this.f31576c.f(r100);
    }

    public void setMaxLines(int r100) {
        this.f31576c.j(r100);
    }

    public void setText(String r100) {
        this.f31576c.b(r100);
    }

    public void setTextStyle(TextStyle r100) {
        if (r100 == null) goto L5;
        this.f31577d = r100;
        this.f31576c.a(r100.getBmTextStyle());
        return;
    }

    public void setWidth(int r100) {
        this.f31576c.i(r100);
    }

    public void setMargin(int r100, int r101, int r102, int r103) {
        this.f31576c.a(r100, r101, r102, r103);
    }

    public void setPadding(int r100, int r101, int r102, int r103) {
        this.f31576c.b(r100, r101, r102, r103);
    }
}
