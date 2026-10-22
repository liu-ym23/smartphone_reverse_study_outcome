package com.obric.autogui.agents.vlm.models.omni.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniTrackingPayload.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final void a(JSONObject r1, String r2) {
        o.e(r1, "<this>");
        String r3 = a(r2);
        if (r3 == null) goto L6;
        r1.put("log_id", r3);
        return;
    }

    public static final String a(String r3) {
        if (r3 == null) goto L8;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L8;
        return r3;
    L8:
        return null;
    }
}
