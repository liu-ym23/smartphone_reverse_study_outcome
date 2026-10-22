package com.lynx.markdown.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: MapUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static HashMap a(HashMap r0, String r1, HashMap r2) {
        Object r3 = r0.get(r1);
        if (ZeusTransformUtils.instanceOf(r3, HashMap.class) == true) goto L5;
        return r2;
    L5:
        return (HashMap) ZeusTransformUtils.preCheckCast(r3, HashMap.class, "com.obric.aiagent.plugin");
    }

    public static double a(HashMap r1, String r2, double r3) {
        Object r4 = r1.get(r2);
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L7;
        return ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).doubleValue();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L14;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L11;
        return 1.0d;
    L11:
        return 0.0d;
    L14:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L20;
    L19:
        return r3;
    L20:
        return Double.parseDouble((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static String a(HashMap r1, String r2, String r3) {
        Object r4 = r1.get(r2);
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L14;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L11;
        return "true";
    L11:
        return "false";
    L14:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == true) goto L16;
        return r3;
    L16:
        return ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).toString();
    }
}
