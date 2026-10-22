package com.bytedance.android.sdk.bdticketguard.setting;

import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends a<String> {
    public i(String r100, String r101, Function0<? extends JSONObject> r102) {
        super(r100, r101, r102);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.setting.a
    public final String b(JSONObject r100, String r101, String r102) {
        String r103 = r102;
        if (r100 == null) goto L8;
        String r104 = r100.optString(r101, r103);
        if (r104 != null) goto L7;
        return r103;
    L7:
        return r104;
    L8:
        return r103;
    }
}
