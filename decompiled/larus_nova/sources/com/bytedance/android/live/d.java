package com.bytedance.android.live;

/* JADX INFO: loaded from: classes45.dex */
public final class d {
    public static boolean a(Object r100, Object r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }
}
