package com.bytedance.apm.agent.a;

import com.bytedance.apm.internal.ApmDelegate;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: PageShowHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(Object r4, boolean r5) {
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L5;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L6:
        JSONObject r2 = new JSONObject();
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L10;
        r2.put("label", ((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L19
    L10:
        if (r5 == false) goto L12;
        String r6 = "page_show";
    L13:
        if (r5 == true) goto L15;
    L17:
        com.bytedance.apm.agent.b.a.a(r6, r0, r2);
        return;
    L15:
        if (ApmDelegate.a().c().d() == null) goto L17;
        ApmDelegate.a().c().d().a(r0, true);
        goto L17
    L12:
        r6 = "page_hide";
        goto L13
    L5:
        r0 = r4.getClass().getName();
        goto L6
    }
}
