package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.poisearch.PoiSearchV2;

/* renamed from: com.amap.api.col.jmsl.h1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1560h1<T, V> extends Q1<T, V> {
    public AbstractC1560h1(Context context, T t10) {
        super(context, t10);
    }

    public String o(PoiSearchV2.ShowFields showFields) {
        if (showFields == null || showFields.getValue() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if ((showFields.getValue() & 1) != 0) {
            sb2.append("children,");
        }
        if ((showFields.getValue() & 2) != 0) {
            sb2.append("business,");
        }
        if ((showFields.getValue() & 4) != 0) {
            sb2.append("indoor,");
        }
        if ((showFields.getValue() & 8) != 0) {
            sb2.append("navi,");
        }
        if ((showFields.getValue() & 16) != 0) {
            sb2.append("photos,");
        }
        if (sb2.length() <= 0) {
            return null;
        }
        sb2.replace(sb2.length() - 1, sb2.length(), "");
        return sb2.toString();
    }

    public boolean p(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }
}
