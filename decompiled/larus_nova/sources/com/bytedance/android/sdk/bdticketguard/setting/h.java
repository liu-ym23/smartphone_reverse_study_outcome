package com.bytedance.android.sdk.bdticketguard.setting;

import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends a<JSONObject> {
    public h(Function0 r100) {
        super("bd_ticket_guard_pubkey_recovery_enable_verify", null, r100);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.setting.a
    public final JSONObject b(JSONObject r100, String r101, JSONObject r102) {
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.optJSONObject(r101);
    }
}
