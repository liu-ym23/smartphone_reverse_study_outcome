package com.autonavi.base.ae.gmap.style;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class StyleItem {
    public int mainKey;
    private Map<Integer, StyleElement> styleElements;
    private int styleTypeId;
    public int[] subKey;

    public StyleElement[] getStyleElements() {
        Map<Integer, StyleElement> r100 = this.styleElements;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.size() <= 0) goto L10;
        StyleElement[] r101 = new StyleElement[this.styleElements.size()];
        return (StyleElement[]) this.styleElements.values().toArray(r101);
    L10:
        return null;
    }

    public boolean isValid() {
        if (this.styleElements.size() > 0) goto L5;
        return false;
    L5:
        if (this.styleTypeId < 0) goto L10;
        return true;
    L10:
        return false;
    }

    public String toString() {
        return "styleTypeId:" + this.styleTypeId + "\nstyleElements.size :" + this.styleElements.size();
    }

    public StyleItem(int r100) {
        this.styleElements = new HashMap();
        this.styleTypeId = r100;
    }

    public StyleElement get(int r100) {
        return this.styleElements.get(Integer.valueOf(r100));
    }

    public void put(int r100, StyleElement r101) {
        this.styleElements.put(Integer.valueOf(r100), r101);
    }
}
