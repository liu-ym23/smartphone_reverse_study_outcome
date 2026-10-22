package com.obric.aiagent.executionengine.capabilitymanager.matcher;

import android.app.Application;
import android.content.Context;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.aiagent.executionengine.capabilitymanager.matcher.bean.ActionData;
import com.obric.aiagent.executionengine.capabilitymanager.matcher.bean.Impl;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.common.intent.MatchException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: UnifiedServiceMatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String TAG = "UnifiedServiceMatcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f16514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f16515b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f16516c = null;

    public static /* synthetic */ String lambda$VReNGDLjSJGTLm2nBjCbd2LLwmI() {
        return c();
    }

    public static /* synthetic */ List lambda$tfwOKi18CQFrX2etN9IThN8OHzU() {
        return d();
    }

    private c() {
    }

    static {
        f16514a = new c();
        f16515b = g.a($$Lambda$c$VReNGDLjSJGTLm2nBjCbd2LLwmI.INSTANCE);
        f16516c = g.a($$Lambda$c$tfwOKi18CQFrX2etN9IThN8OHzU.INSTANCE);
    }

    private final String a() {
        Object r2 = f16515b.b();
        o.c(r2, "getValue(...)");
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    }

    private static final String c() {
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName();
    }

    private final List<com.obric.aiagent.executionengine.capabilitymanager.api.publish.a> b() {
        return (List) ZeusTransformUtils.preCheckCast(f16516c.b(), List.class, "com.obric.aiagent.plugin");
    }

    private static final List d() {
        return com.obric.aiagent.executionengine.capabilitymanager.matcher.b.a.f16513a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public final com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a a(Map<String, ? extends List<com.obric.aiagent.executionengine.capabilitymanager.api.a.b>> r11, ActionData r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        o.e(r13, "index");
        o.e(r12, "actionData");
        String r0 = r12.getActionName();
        List<com.obric.aiagent.executionengine.capabilitymanager.api.a.b> r14 = (List) ZeusTransformUtils.preCheckCast(r13.get(r0), List.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r12.getImpls(), Collection.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == true) goto L43;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r15.iterator();
    L27:
        if (r16.hasNext() == false) goto L41;
        Object r7 = r16.next();
        com.obric.aiagent.executionengine.capabilitymanager.api.a.b r8 = (com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getImpls(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L31;
    L33:
        Iterator r10 = r9.iterator();
    L35:
        if (r10.hasNext() == false) goto L32;
        if (o.a(((Impl) ZeusTransformUtils.preCheckCast(r10.next(), Impl.class, "com.obric.aiagent.plugin")).getPkgName(), r8.b()) == false) goto L35;
        boolean r17 = true;
    L39:
        if (r17 == false) goto L27;
        r6.add(r7);
    L32:
        r17 = false;
        goto L39
    L31:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L33;
    L41:
        r14 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
    L43:
        if (r14.isEmpty() == true) goto L47;
        com.obric.aiagent.executionengine.capabilitymanager.api.a.b r18 = a(r0, r14);
        ILogDepend.Companion.i(TAG, "matched: " + r0 + " -> type=" + r18.getType() + ", pkg=" + r18.b() + ", implRef=" + r18.c());
        return new com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a(a(r18, r12), r18.getType());
    L47:
        throw new MatchException.NoImplException("capability: " + r0 + " with impls: " + r12.getImpls() + " no register");
    L19:
        if (r4.isEmpty() == true) goto L22;
        r5 = false;
        goto L23
    L11:
        if (com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a.a(r0) == false) goto L15;
        throw new MatchException.NoImplException("No impls of capability: " + r0);
    L15:
        throw new MatchException.NoDefineIntentException("No define capability: " + r0);
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    private final com.obric.aiagent.executionengine.capabilitymanager.api.a.b a(String r8, List<com.obric.aiagent.executionengine.capabilitymanager.api.a.b> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r0.hasNext() == false) goto L75;
        int r2 = ((com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin")).getType().a();
    L6:
        if (r0.hasNext() == false) goto L10;
        int r3 = ((com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin")).getType().a();
        if (r2 >= r3) goto L6;
        r2 = r3;
        goto L6
    L10:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L11:
        boolean r4 = true;
        if (r12.hasNext() == false) goto L19;
        Object r5 = r12.next();
        if (((com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin")).getType().a() == r2) goto L17;
        r4 = false;
    L17:
        if (r4 == false) goto L11;
        r1.add(r5);
        goto L11
    L19:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        if (r13.size() == 1) goto L22;
        List<com.obric.aiagent.executionengine.capabilitymanager.api.publish.a> r7 = b();
        Object r6 = null;
        if (r7 == null) goto L64;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L27:
        if (r14.hasNext() == false) goto L31;
        Object r15 = r14.next();
        if (o.a(((com.obric.aiagent.executionengine.capabilitymanager.api.publish.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.executionengine.capabilitymanager.api.publish.a.class, "com.obric.aiagent.plugin")).a(), r8) == false) goto L27;
    L32:
        com.obric.aiagent.executionengine.capabilitymanager.api.publish.a r16 = (com.obric.aiagent.executionengine.capabilitymanager.api.publish.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.executionengine.capabilitymanager.api.publish.a.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L64;
        AppIntentImplInfo r17 = (AppIntentImplInfo) ZeusTransformUtils.preCheckCast(p.l(r16.b()), AppIntentImplInfo.class, "com.obric.aiagent.plugin");
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L36:
        if (r18.hasNext() == false) goto L44;
        Object r19 = r18.next();
        String r20 = ((com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r19, com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin")).c();
        if (r17 == null) goto L40;
        String r21 = r17.getImplClassName();
    L42:
        if (o.a(r20, r21) == false) goto L36;
    L45:
        com.obric.aiagent.executionengine.capabilitymanager.api.a.b r22 = (com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r19, com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L49;
        ILogDepend.Companion.d(TAG, "arbitrate use config by implRef: " + r22);
        return r22;
    L49:
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L51:
        if (r23.hasNext() == false) goto L59;
        Object r24 = r23.next();
        String r25 = ((com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r24, com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin")).b();
        if (r17 == null) goto L55;
        String r26 = r17.getPackageName();
    L57:
        if (o.a(r25, r26) == false) goto L51;
    L60:
        com.obric.aiagent.executionengine.capabilitymanager.api.a.b r27 = (com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r24, com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin");
        if (r27 == null) goto L64;
        ILogDepend.Companion.d(TAG, "arbitrate use config by pkg: " + r27);
        return r27;
    L55:
        r26 = null;
        goto L57
    L59:
        r24 = null;
        goto L60
    L40:
        r21 = null;
        goto L42
    L44:
        r19 = null;
        goto L45
    L31:
        r15 = null;
    L64:
        Iterator r28 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L66:
        if (r28.hasNext() == false) goto L70;
        Object r29 = r28.next();
        if ((!o.a(((com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r29, com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin")).b(), f16514a.a())) == false) goto L66;
        r6 = r29;
    L70:
        com.obric.aiagent.executionengine.capabilitymanager.api.a.b r30 = (com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin");
        if (r30 == null) goto L73;
        return r30;
    L73:
        return (com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(p.k(r13), com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin");
    L22:
        return (com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(p.k(r13), com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin");
    L75:
        throw new NoSuchElementException();
    }

    private final AppAction a(com.obric.aiagent.executionengine.capabilitymanager.api.a.b r14, ActionData r15) {
        JsonObject r13 = a(r15);
        String r1 = r14.b();
        String r2 = r15.getActionName();
        String r3 = r13.toString();
        o.c(r3, "toString(...)");
        String r10 = r14.c();
        return new AppAction(r1, r2, r3, null, 0, null, r15.getActionName(), r14.b(), null, r10, 312, null);
    }

    private final JsonObject a(ActionData r11) {
        JsonObject r10 = new JsonObject();
        JsonObject r12 = r11.getInputParams();
        if (r12 == null) goto L17;
        Iterator<String> r0 = r12.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        JsonObject r2 = r12.get(r1).getAsJsonObject();
        if (r2.has("value") == false) goto L6;
        JsonElement r3 = r2.get("value");
        if (ZeusTransformUtils.instanceOf(r3, JsonPrimitive.class) == false) goto L11;
        String r4 = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(r3, JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsString();
        o.a(r4);
        if (d.o.o.b(r4, "$", false, 2, null) == false) goto L16;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("outputParams", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L6;
    L16:
        r10.add(r1, r3);
        goto L6
    L11:
        r10.add(r1, r3);
    L17:
        return r10;
    }
}
