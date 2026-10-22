package com.obric.agent.office;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o.o;
import java.util.Map;

/* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final /* synthetic */ String a(Map r2) {
        return b((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"));
    }

    private static final String b(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L7;
        return null;
    L7:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L9;
        return null;
    L9:
        return r5;
    L10:
        return null;
    }
}
