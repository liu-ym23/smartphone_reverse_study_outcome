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
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TextPathMarker extends Overlay {

    /* renamed from: g, reason: collision with root package name */
    String f6954g;

    /* renamed from: h, reason: collision with root package name */
    private BmTextStyle f6955h;

    /* renamed from: i, reason: collision with root package name */
    private BmGeoElement f6956i;

    /* renamed from: j, reason: collision with root package name */
    private BmTextPathMarker f6957j;

    /* renamed from: k, reason: collision with root package name */
    int f6958k;

    /* renamed from: l, reason: collision with root package name */
    int f6959l;

    /* renamed from: m, reason: collision with root package name */
    int f6960m;

    /* renamed from: n, reason: collision with root package name */
    int f6961n;

    /* renamed from: o, reason: collision with root package name */
    Typeface f6962o;

    /* renamed from: p, reason: collision with root package name */
    List<LatLng> f6963p;

    public TextPathMarker() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.textPath;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        bundle.putString("id", this.f6718a);
        bundle.putInt("type", this.type.ordinal());
        bundle.putInt("visibility", this.f6721d ? 1 : 0);
        bundle.putInt("z_index", this.f6720c);
        return null;
    }

    public List<LatLng> getPoints() {
        return this.f6963p;
    }

    public String getText() {
        return this.f6954g;
    }

    public int getTextBorderColor() {
        return this.f6960m;
    }

    public int getTextBorderWidth() {
        return this.f6961n;
    }

    public int getTextColor() {
        return this.f6958k;
    }

    public Typeface getTextFontOption() {
        return this.f6962o;
    }

    public int getTextSize() {
        return this.f6959l;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public int getZIndex() {
        return this.f6720c;
    }

    public void setPoints(List<LatLng> list) {
        if (!OverlayUtil.isOverlayUpgrade() || list == null || list.size() < 2) {
            return;
        }
        this.f6963p = list;
        ArrayList arrayList = new ArrayList();
        for (int i4 = 1; i4 < list.size(); i4++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(list.get(i4 - 1));
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(list.get(i4));
            com.baidu.platform.comapi.bmsdk.b bVar = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6());
            com.baidu.platform.comapi.bmsdk.b bVar2 = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6());
            arrayList.add(bVar);
            arrayList.add(bVar2);
        }
        this.f6956i.a(arrayList);
        this.f6723f.b();
    }

    public void setText(String str) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6954g = str;
            this.f6957j.a(str);
            this.f6723f.b();
        }
    }

    public void setTextBorderColor(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6960m = i4;
            this.f6955h.a(i4);
            this.f6723f.b();
        }
    }

    public void setTextBorderWidth(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6961n = i4;
            this.f6955h.b(i4);
            this.f6723f.b();
        }
    }

    public void setTextColor(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6958k = i4;
            this.f6955h.d(i4);
            this.f6723f.b();
        }
    }

    public void setTextFontOption(Typeface typeface) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6962o = typeface;
            this.f6955h.c(typeface.getStyle());
            this.f6723f.b();
        }
    }

    public void setTextSize(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6959l = i4;
            this.f6955h.e(i4);
            this.f6723f.b();
        }
    }

    public void setZIndex(short s4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6720c = s4;
            this.f6957j.d(s4);
            this.f6723f.b();
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        List<LatLng> list = this.f6963p;
        if (list == null || list.size() < 2) {
            return null;
        }
        if (this.f6957j == null) {
            this.f6957j = new BmTextPathMarker();
        }
        if (this.f6955h == null) {
            this.f6955h = new BmTextStyle();
        }
        if (this.f6956i == null) {
            this.f6956i = new BmGeoElement(0);
        }
        super.toDrawItem();
        setDrawItem(this.f6957j);
        this.f6957j.a(this.f6954g);
        this.f6957j.d(this.f6720c);
        this.f6955h.d(this.f6958k);
        this.f6955h.a(this.f6960m);
        this.f6955h.b(this.f6961n);
        Typeface typeface = this.f6962o;
        if (typeface != null) {
            this.f6955h.c(typeface.getStyle());
        } else {
            this.f6955h.c(Typeface.DEFAULT.getStyle());
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 1; i4 < this.f6963p.size(); i4++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6963p.get(i4 - 1));
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.f6963p.get(i4));
            com.baidu.platform.comapi.bmsdk.b bVar = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6());
            com.baidu.platform.comapi.bmsdk.b bVar2 = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6());
            arrayList.add(bVar);
            arrayList.add(bVar2);
        }
        this.f6957j.a(this.f6955h);
        this.f6956i.a(arrayList);
        this.f6957j.a(this.f6956i);
        this.f6723f.b();
        return this.f6957j;
    }
}
