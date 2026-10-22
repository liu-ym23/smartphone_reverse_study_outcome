package com.obric.agent.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private static final String TAG = "ClientPhoneEnvInfo";

    public static final /* synthetic */ void a(JSONObject r0, JSONObject r1) {
        b(r0, r1);
    }

    private static final void b(JSONObject r6, JSONObject r7) {
        Iterator<String> r0 = r7.keys();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        Object r2 = r7.get(r1);
        Object r4 = r6.opt(r1);
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == false) goto L10;
        b((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.aiagent.plugin"), (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.aiagent.plugin"));
    L10:
        r6.put(r1, r2);
        goto L4
    }
}
