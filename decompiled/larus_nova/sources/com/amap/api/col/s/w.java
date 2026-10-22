package com.amap.api.col.s;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
abstract class w<T, V> extends b<T, V> {
    public static boolean c(String r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.equals("") == false) goto L6;
        return true;
    L6:
        if (r100.equals("[]") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public w(Context r100, T r101) {
        super(r100, r101);
    }
}
