package com.bytedance.android.live.lynx.components;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends com.bytedance.ies.web.jsbridge2.g<JsonObject, Object> {
    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JsonObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
