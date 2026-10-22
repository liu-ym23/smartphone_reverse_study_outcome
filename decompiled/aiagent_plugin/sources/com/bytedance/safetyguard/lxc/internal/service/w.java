package com.bytedance.safetyguard.lxc.internal.service;

import com.bytedance.safetyguard.lxc.internal.ipc.ProxyServiceConfigParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ProxyServiceDnsResolver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class w {
    public static final com.bytedance.safetyguard.lxc.internal.b.i a(ProxyServiceConfigParcel r11) {
        d.h.b.o.e(r11, "<this>");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r11.getAllowedDomainRules(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"), '.', false, 2, null) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r5.add(d.o.o.a((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(".", CharSequence.class, "com.obric.aiagent.plugin")));
        goto L10
    L12:
        LinkedHashSet r7 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r5, LinkedHashSet.class, "com.obric.aiagent.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r11.getAllowedDomainRules(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.iterator();
    L14:
        if (r10.hasNext() == false) goto L18;
        Object r12 = r10.next();
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"), '.', false, 2, null) == true) goto L14;
        r9.add(r12);
        goto L14
    L18:
        Set<String> r13 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        return com.bytedance.safetyguard.lxc.internal.b.i.f9754a.a(r13, (Set) ZeusTransformUtils.preCheckCast(r7, Set.class, "com.obric.aiagent.plugin"), d.a.i.h(r11.getAllowedPorts()));
    }
}
