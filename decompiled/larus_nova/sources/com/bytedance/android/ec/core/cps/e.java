package com.bytedance.android.ec.core.cps;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class e {
    public static final JSONObject a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJSON");
        JSONObject r101 = new JSONObject();
        r101.put(BaseSwitches.V, r100.g());
        r101.put("e", r100.b());
        r101.put("d", r100.d());
        r101.put("t", r100.f());
        r101.put("h", r100.c());
        r101.put("r", r100.e());
        r101.put("c", r100.a());
        return r101;
    }
}
