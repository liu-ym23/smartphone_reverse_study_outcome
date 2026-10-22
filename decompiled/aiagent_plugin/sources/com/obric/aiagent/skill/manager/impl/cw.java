package com.obric.aiagent.skill.manager.impl;

import android.os.Bundle;
import com.bytedance.keva.Keva;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SkillManagerConfigStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cw f19708a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f19709b = null;

    public static /* synthetic */ CharSequence lambda$I6S0iH3Q54AtsBAw26wQTXjZ65s(d.m r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$iPHozUXrOOAo7-NWZhDUxMNToxw, reason: not valid java name */
    public static /* synthetic */ Keva m279lambda$iPHozUXrOOAo7NWZhDUxMNToxw() {
        return c();
    }

    private cw() {
    }

    static {
        f19708a = new cw();
        f19709b = d.g.a($$Lambda$cw$iPHozUXrOOAo7NWZhDUxMNToxw.INSTANCE);
    }

    private final Keva b() {
        return (Keva) ZeusTransformUtils.preCheckCast(f19709b.b(), Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva c() {
        return cx.f19710a.a();
    }

    public final OSkillManagerConfig a() {
        Bundle r3 = new Bundle();
        r3.putBoolean(OSkillManagerConfig.KEY_SKILL_EXTENSION_ENABLED, f19708a.b().getBoolean(OSkillManagerConfig.KEY_SKILL_EXTENSION_ENABLED, true));
        return new OSkillManagerConfig(r3);
    }

    public final boolean a(Bundle r13) {
        d.h.b.o.e(r13, "values");
        if (r13.isEmpty() == false) goto L6;
        ILogDepend.Companion.w("SkillManager", "setConfigValues ignored empty values");
        return false;
    L6:
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Set<String> r2 = r13.keySet();
        d.h.b.o.c(r2, "keySet(...)");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L24;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r4);
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.h.b.o.a(r5, OSkillManagerConfig.KEY_SKILL_EXTENSION_ENABLED) == false) goto L11;
        Object r6 = f19708a.a(r13, r4);
        if (ZeusTransformUtils.instanceOf(r6, Boolean.class) == false) goto L15;
        ((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).add(d.s.a(r5, r6));
        goto L8
    L15:
        ee r14 = ee.f19808a;
        StringBuilder r15 = new StringBuilder().append("setConfigValues ignored type mismatch, key=").append(r5).append(", expected=Boolean, actual=");
        if (r6 == null) goto L20;
        Class<?> r7 = r6.getClass();
        if (r7 == null) goto L20;
        String r8 = r7.getSimpleName();
    L21:
        r14.c("SkillManager", "setConfigValues ignored type mismatch", r15.append(r8).toString());
        return false;
    L20:
        r8 = null;
        goto L21
    L11:
        ee.f19808a.c("SkillManager", "setConfigValues ignored unknown key", "setConfigValues ignored unknown key=" + r5);
        return false;
    L24:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L26:
        if (r16.hasNext() == false) goto L28;
        d.m r0 = (d.m) ZeusTransformUtils.preCheckCast(r16.next(), d.m.class, "com.obric.aiagent.plugin");
        f19708a.b().storeBoolean((String) ZeusTransformUtils.preCheckCast(r0.c(), String.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r0.d(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        goto L26
    L28:
        ee.f19808a.b("SkillManager", "setConfigValues success count=" + r12.size(), "setConfigValues success, keys=" + d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$cw$I6S0iH3Q54AtsBAw26wQTXjZ65s.INSTANCE, 31, null));
        return true;
    }

    private static final CharSequence a(d.m r2) {
        d.h.b.o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final Object a(Bundle r1, String r2) {
        return r1.get(r2);
    }
}
