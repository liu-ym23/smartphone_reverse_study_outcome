package com.bytedance.android.sdk.bdticketguard.setting;

import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a<Integer> {
    public f(String r100, int r101, Function0<? extends JSONObject> r102) {
        super(r100, Integer.valueOf(r101), r102);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.setting.a
    public final Integer b(JSONObject r100, String r101, Integer r102) {
        int r103 = r102.intValue();
        if (r100 == null) goto L6;
        r103 = r100.optInt(r101, r103);
    L6:
        return Integer.valueOf(r103);
    }
}
