package com.b.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes.dex */
final class k {
    static org.a.b.c a(List<h> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        TreeSet r0 = new TreeSet();
        org.a.b.c.a r2 = org.a.b.c.a();
        if (r6 == null) goto L20;
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L13;
        h r3 = (h) ZeusTransformUtils.preCheckCast(r7.next(), h.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        if (r3.a() == null) goto L6;
        r0.addAll(r3.a());
        goto L6
    L13:
        if (r0.size() <= 0) goto L30;
        Iterator r8 = r0.iterator();
    L16:
        if (r8.hasNext() == false) goto L19;
        r2.a((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"));
        goto L16
    L19:
        return r2.a();
    L30:
        return null;
    L20:
        return null;
    }
}
