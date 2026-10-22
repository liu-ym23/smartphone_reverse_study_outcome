package com.amap.api.mapcore.util;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes28.dex */
public class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, StyleItem> f27057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StyleItem[] f27058b;

    public StyleItem[] a() {
        Map<Integer, StyleItem> r100 = this.f27057a;
        if (r100 != null) goto L5;
    L17:
        return null;
    L5:
        if (r100.size() == 0) goto L17;
        ArrayList r101 = new ArrayList();
        Iterator<StyleItem> r102 = this.f27057a.values().iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        StyleItem r103 = r102.next();
        if (r103.isValid() == false) goto L9;
        r101.add(r103);
        goto L9
    L13:
        int r104 = r101.size();
        if (r104 <= 0) goto L17;
        StyleItem[] r105 = (StyleItem[]) r101.toArray(new StyleItem[r104]);
        this.f27058b = r105;
        return r105;
    }

    public b3() {
        this.f27057a = new ConcurrentHashMap();
    }

    public StyleItem[] b() {
        return this.f27058b;
    }

    public Map<Integer, StyleItem> c() {
        return this.f27057a;
    }
}
