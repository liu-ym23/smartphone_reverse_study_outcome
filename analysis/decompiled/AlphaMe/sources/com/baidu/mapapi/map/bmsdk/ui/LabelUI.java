package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.TextStyle;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmLabelUI;

/* loaded from: classes.dex */
public class LabelUI extends BaseUI {

    /* renamed from: c, reason: collision with root package name */
    private BmLabelUI f7141c;

    /* renamed from: d, reason: collision with root package name */
    private TextStyle f7142d;

    public LabelUI() {
        BmLabelUI bmLabelUI = new BmLabelUI();
        this.f7141c = bmLabelUI;
        bmLabelUI.a(this);
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.f7141c;
    }

    public TextStyle getStyle() {
        return this.f7142d;
    }

    public String getText() {
        return this.f7141c.b();
    }

    public void setBackground(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.f7141c.a(new BmBitmapResource(bitmapDescriptor.getBitmap()));
    }

    public void setBackgroundColor(int i4) {
        this.f7141c.b(i4);
    }

    public void setClickable(boolean z4) {
        this.f7141c.a(z4);
    }

    public void setGravity(UIGravity uIGravity) {
        this.f7141c.e(uIGravity.getNumber());
    }

    public void setHeight(int i4) {
        this.f7141c.f(i4);
    }

    public void setMargin(int i4, int i5, int i6, int i7) {
        this.f7141c.a(i4, i5, i6, i7);
    }

    public void setMaxLines(int i4) {
        this.f7141c.j(i4);
    }

    public void setPadding(int i4, int i5, int i6, int i7) {
        this.f7141c.b(i4, i5, i6, i7);
    }

    public void setText(String str) {
        this.f7141c.b(str);
    }

    public void setTextStyle(TextStyle textStyle) {
        if (textStyle != null) {
            this.f7142d = textStyle;
            this.f7141c.a(textStyle.getBmTextStyle());
        }
    }

    public void setWidth(int i4) {
        this.f7141c.i(i4);
    }
}
