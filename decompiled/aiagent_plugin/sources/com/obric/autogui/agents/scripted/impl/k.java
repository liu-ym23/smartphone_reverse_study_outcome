package com.obric.autogui.agents.scripted.impl;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ScriptAbilityRecall.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    private static final String TAG = "ScriptAbilityRecall";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f27010a = null;

    static {
        f27010a = new k();
    }

    /* JADX INFO: renamed from: lambda$I2l8t-bptV2mSR1_IhJzSRebWXs, reason: not valid java name */
    public static /* synthetic */ x m726lambda$I2l8tbptV2mSR1_IhJzSRebWXs(String r0) {
        return a(r0);
    }

    private k() {
    }

    public static /* synthetic */ List a(k r9, List r10, Set r11, Set r12, com.obric.autogui.agents.scripted.a.g r13, d.h.a.b r14, d.h.a.b r15, int r16, Object r17) {
        List<com.obric.autogui.agents.scripted.api.a> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Set<String> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super String, ? extends Set<String>> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super String, x> r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r16 & 32) == 0) goto L6;
        r0 = $$Lambda$k$I2l8tbptV2mSR1_IhJzSRebWXs.INSTANCE;
    L6:
        return r9.a(r3, r4, r5, r13, r7, r0);
    }

    public final List<com.obric.autogui.agents.scripted.api.a> a(List<com.obric.autogui.agents.scripted.api.a> r17, Set<String> r18, Set<String> r19, com.obric.autogui.agents.scripted.a.g r20, d.h.a.b<? super String, ? extends Set<String>> r21, d.h.a.b<? super String, x> r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r18, Set.class, "com.obric.aiagent.plugin");
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r19, Set.class, "com.obric.aiagent.plugin");
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "allAbilities");
        d.h.b.o.e(r2, "recalledScriptNames");
        d.h.b.o.e(r3, "blockedAbilitySet");
        d.h.b.o.e(r4, "blockedImplementationsFor");
        d.h.b.o.e(r5, "warn");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r1.iterator();
    L4:
        if (r7.hasNext() == false) goto L42;
        Object r8 = r7.next();
        com.obric.autogui.agents.scripted.api.a r9 = (com.obric.autogui.agents.scripted.api.a) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.agents.scripted.api.a.class, "com.obric.aiagent.plugin");
        boolean r10 = true;
        if (r2.contains(r9.a()) == true) goto L8;
    L38:
        r10 = false;
    L39:
        if (r10 == false) goto L4;
        r6.add(r8);
        goto L4
    L8:
        if (r3.contains(r9.b()) == true) goto L38;
        if (r20 == null) goto L39;
        Map<String, List<String>> r11 = r20.a();
        if (r11 == null) goto L15;
        List r12 = (List) ZeusTransformUtils.preCheckCast(r11.get(r9.a()), List.class, "com.obric.aiagent.plugin");
    L16:
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L24:
        if (r14 == false) goto L26;
        r5.invoke("Filter recalled script with invalid implementation metadata: scriptName=" + r9.a() + ", ability=" + r9.b());
        goto L38
    L26:
        Set r15 = (Set) ZeusTransformUtils.preCheckCast(r4.invoke(r9.b()), Set.class, "com.obric.aiagent.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L29;
    L31:
        Iterator r110 = r16.iterator();
    L33:
        if (r110.hasNext() == false) goto L30;
        if ((!r15.contains((String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.aiagent.plugin"))) == false) goto L33;
    L36:
        if (r10 == true) goto L39;
        r5.invoke("Filter recalled script because all implementations are blocked: scriptName=" + r9.a() + ", ability=" + r9.b() + ", implementations=" + r12);
    L30:
        r10 = false;
        goto L36
    L29:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L31;
    L19:
        if (r13.isEmpty() == true) goto L22;
        r14 = false;
        goto L24
    L15:
        r12 = null;
        goto L16
    L42:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
    }

    private static final x a(String r2) {
        d.h.b.o.e(r2, "message");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L6;
        Loog.INSTANCE.w(TAG, r2);
    L6:
        return x.f38692a;
    }
}
