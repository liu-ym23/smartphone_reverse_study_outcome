package com.bytedance.android.sdk.bdticketguard;

import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 {
    public static final JSONObject a(Pair... r100) {
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Pair r104 = r100[r103];
        r101.put((String) r104.component1(), r104.component2());
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }
}
