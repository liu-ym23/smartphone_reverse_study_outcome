package com.obric.autogui.common.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.o.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AOSystemTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOSystemToolsKt {
    public static final Map<String, Object> buildTargetApkAuditFields(String r6, List<String> r7, String r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        Map r0 = ao.a();
        if (r6 != null) goto L5;
    L10:
        if (r9 == null) goto L23;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r10.iterator();
    L13:
        if (r12.hasNext() == false) goto L17;
        Object r3 = r12.next();
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L13;
        r11.add(r3);
        goto L13
    L17:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L21;
        r13 = null;
    L21:
        if (r13 == null) goto L23;
        r0.put("target_sign_sha256", r13);
    L23:
        if (r8 == null) goto L31;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L28;
        r8 = null;
    L28:
        if (r8 == null) goto L31;
        r0.put("target_apk_md5", r8);
    L31:
        return ao.a(r0);
    L5:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L10;
        r0.put("target_apk_version", r6);
        goto L10
    }
}
