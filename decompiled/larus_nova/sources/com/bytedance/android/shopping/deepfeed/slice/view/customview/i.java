package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class i {
    public static final String a(Map r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Object r104 = r100.get(r101[r103]);
        if (r104 != null) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104.toString();
    L8:
        return null;
    }
}
