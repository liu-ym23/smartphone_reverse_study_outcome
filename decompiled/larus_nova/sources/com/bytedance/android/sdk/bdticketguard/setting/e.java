package com.bytedance.android.sdk.bdticketguard.setting;

import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends a<Boolean> {
    public e(String r100, boolean r101, Function0<? extends JSONObject> r102) {
        super(r100, Boolean.valueOf(r101), r102);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.setting.a
    public final Boolean b(JSONObject r100, String r101, Boolean r102) {
        boolean r103 = r102.booleanValue();
        if (r100 == null) goto L6;
        r103 = r100.optBoolean(r101, r103);
    L6:
        return Boolean.valueOf(r103);
    }
}
