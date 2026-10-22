package com.bytedance.android.sdk.bdticketguard.setting;

import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends a<Long> {
    public g(String r100, long r101, Function0<? extends JSONObject> r102) {
        super(r100, Long.valueOf(r101), r102);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.setting.a
    public final Long b(JSONObject r100, String r101, Long r102) {
        long r103 = r102.longValue();
        if (r100 == null) goto L6;
        r103 = r100.optLong(r101, r103);
    L6:
        return Long.valueOf(r103);
    }
}
