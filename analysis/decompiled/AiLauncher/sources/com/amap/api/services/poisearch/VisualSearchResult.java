package com.amap.api.services.poisearch;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VisualSearchResult {

    /* renamed from: a, reason: collision with root package name */
    private String f17621a;

    /* renamed from: b, reason: collision with root package name */
    private List<VisualPoiItem> f17622b = new ArrayList();

    public String getCategory() {
        return this.f17621a;
    }

    public List<VisualPoiItem> getPois() {
        return this.f17622b;
    }

    public void setCategory(String str) {
        this.f17621a = str;
    }

    public void setPois(List<VisualPoiItem> list) {
        this.f17622b = list;
    }

    public String toString() {
        return "VisualSearchResult{category='" + this.f17621a + "', pois=" + this.f17622b + '}';
    }
}
