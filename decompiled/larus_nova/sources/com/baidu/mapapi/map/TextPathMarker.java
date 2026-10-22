package com.baidu.mapapi.map;

import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmTextPathMarker;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class TextPathMarker extends Overlay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f31402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BmTextStyle f31403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BmGeoElement f31404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BmTextPathMarker f31405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f31406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    TextFontSizeType f31407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f31408m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f31409n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f31410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Typeface f31411p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    List<LatLng> f31412q;

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        List<LatLng> r100 = this.f31412q;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.size() >= 2) goto L8;
        return null;
    L8:
        if (this.f31405j != null) goto L11;
        this.f31405j = new BmTextPathMarker();
    L11:
        if (this.f31403h != null) goto L14;
        this.f31403h = new BmTextStyle();
    L14:
        if (this.f31404i != null) goto L16;
        this.f31404i = new BmGeoElement(0);
    L16:
        super.toDrawItem();
        setDrawItem(this.f31405j);
        this.f31405j.a(this.f31402g);
        this.f31405j.d(this.f31204c);
        this.f31403h.d(this.f31406k);
        this.f31403h.a(this.f31409n);
        this.f31403h.b(this.f31410o);
        this.f31403h.f(this.f31407l.ordinal());
        this.f31403h.e(this.f31408m);
        Typeface r101 = this.f31411p;
        if (r101 == null) goto L19;
        this.f31403h.c(r101.getStyle());
    L20:
        ArrayList r102 = new ArrayList();
        int r103 = 1;
    L22:
        if (r103 >= this.f31412q.size()) goto L24;
        GeoPoint r104 = CoordUtil.ll2mc((LatLng) ListProtector.get(this.f31412q, r103 - 1));
        GeoPoint r105 = CoordUtil.ll2mc((LatLng) ListProtector.get(this.f31412q, r103));
        com.baidu.platform.comapi.bmsdk.b r106 = new com.baidu.platform.comapi.bmsdk.b(r104.getLongitudeE6(), r104.getLatitudeE6());
        com.baidu.platform.comapi.bmsdk.b r107 = new com.baidu.platform.comapi.bmsdk.b(r105.getLongitudeE6(), r105.getLatitudeE6());
        r102.add(r106);
        r102.add(r107);
        r103 = r103 + 1;
        goto L22
    L24:
        this.f31405j.a(this.f31403h);
        this.f31404i.a(r102);
        this.f31405j.a(this.f31404i);
        this.f31207f.b();
        return this.f31405j;
    L19:
        this.f31403h.c(Typeface.DEFAULT.getStyle());
        goto L20
    }

    public TextPathMarker() {
        this.f31407l = TextFontSizeType.AdaptTextFontSize;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32156p;
    }

    public List<LatLng> getPoints() {
        return this.f31412q;
    }

    public String getText() {
        return this.f31402g;
    }

    public int getTextBorderColor() {
        return this.f31409n;
    }

    public int getTextBorderWidth() {
        return this.f31410o;
    }

    public int getTextColor() {
        return this.f31406k;
    }

    public Typeface getTextFontOption() {
        return this.f31411p;
    }

    public int getTextSize() {
        return this.f31408m;
    }

    public TextFontSizeType getTextSizeType() {
        return this.f31407l;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public int getZIndex() {
        return this.f31204c;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        r100.putString("id", this.f31202a);
        r100.putInt("type", this.type.ordinal());
        r100.putInt(RemoteMessageConst.Notification.VISIBILITY, this.f31205d ? 1 : 0);
        r100.putInt("z_index", this.f31204c);
        return null;
    }

    public void setPoints(List<LatLng> r110) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L15;
        if (r110 != null) goto L6;
        return;
    L6:
        if (r110.size() < 2) goto L17;
        this.f31412q = r110;
        ArrayList r100 = new ArrayList();
        int r101 = 1;
    L10:
        if (r101 >= r110.size()) goto L12;
        GeoPoint r102 = CoordUtil.ll2mc((LatLng) ListProtector.get(r110, r101 - 1));
        GeoPoint r103 = CoordUtil.ll2mc((LatLng) ListProtector.get(r110, r101));
        com.baidu.platform.comapi.bmsdk.b r104 = new com.baidu.platform.comapi.bmsdk.b(r102.getLongitudeE6(), r102.getLatitudeE6());
        com.baidu.platform.comapi.bmsdk.b r105 = new com.baidu.platform.comapi.bmsdk.b(r103.getLongitudeE6(), r103.getLatitudeE6());
        r100.add(r104);
        r100.add(r105);
        r101 = r101 + 1;
        goto L10
    L12:
        this.f31404i.a(r100);
        this.f31207f.b();
        return;
    L17:
        return;
    }

    public void setText(String r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31402g = r100;
        this.f31405j.a(r100);
        this.f31207f.b();
        return;
    }

    public void setTextBorderColor(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31409n = r100;
        this.f31403h.a(r100);
        this.f31207f.b();
        return;
    }

    public void setTextBorderWidth(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31410o = r100;
        this.f31403h.b(r100);
        this.f31207f.b();
        return;
    }

    public void setTextColor(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31406k = r100;
        this.f31403h.d(r100);
        this.f31207f.b();
        return;
    }

    public void setTextFontOption(Typeface r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31411p = r100;
        this.f31403h.c(r100.getStyle());
        this.f31207f.b();
        return;
    }

    public void setTextSize(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31408m = r100;
        this.f31403h.e(r100);
        this.f31207f.b();
        return;
    }

    public void setTextSizeType(TextFontSizeType r100) {
        if (this.f31407l != r100) goto L6;
        return;
    L6:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.f31403h.f(r100.ordinal());
        this.f31403h.e(this.f31408m);
        this.f31207f.b();
        return;
    }

    public void setZIndex(short r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31204c = r100;
        this.f31405j.d(r100);
        this.f31207f.b();
        return;
    }
}
