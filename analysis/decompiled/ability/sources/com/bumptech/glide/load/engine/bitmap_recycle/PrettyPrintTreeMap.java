package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.compose.foundation.b;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sbV = b.v("( ");
        for (Map.Entry<K, V> entry : entrySet()) {
            sbV.append('{');
            sbV.append(entry.getKey());
            sbV.append(':');
            sbV.append(entry.getValue());
            sbV.append("}, ");
        }
        if (!isEmpty()) {
            sbV.replace(sbV.length() - 2, sbV.length(), "");
        }
        sbV.append(" )");
        return sbV.toString();
    }
}
