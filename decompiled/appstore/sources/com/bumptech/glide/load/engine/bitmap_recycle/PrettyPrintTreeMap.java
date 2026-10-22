package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    public PrettyPrintTreeMap() {
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("( ");
        Iterator<Map.Entry<K, V>> r11 = entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        Map.Entry<K, V> r12 = r11.next();
        r10.append('{');
        r10.append(r12.getKey());
        r10.append(':');
        r10.append(r12.getValue());
        r10.append("}, ");
        goto L4
    L7:
        if (isEmpty() == true) goto L9;
        r10.replace(r10.length() - 2, r10.length(), "");
    L9:
        r10.append(" )");
        return r10.toString();
    }
}
