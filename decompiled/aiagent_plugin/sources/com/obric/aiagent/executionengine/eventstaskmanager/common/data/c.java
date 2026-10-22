package com.obric.aiagent.executionengine.eventstaskmanager.common.data;

import com.google.gson.JsonParser;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTaskTypeConverters.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f16689a = null;

    /* JADX INFO: compiled from: EventTaskTypeConverters.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f16689a = new a(null);
    }

    public c() {
    }

    public final String a(ConditionGroup r1) {
        return d.a().toJson(r1);
    }

    public final ConditionGroup a(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Type r1 = new EventTaskTypeConverters$toConditionGroup$type$1().getType();
        return (ConditionGroup) ZeusTransformUtils.preCheckCast(d.a().fromJson(r2, r1), ConditionGroup.class, "com.obric.aiagent.plugin");
    }

    public final String a(PeriodicPolicy r1) {
        return d.a().toJson(r1);
    }

    public final PeriodicPolicy b(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Type r1 = new EventTaskTypeConverters$toPeriodicPolicy$type$1().getType();
        return (PeriodicPolicy) ZeusTransformUtils.preCheckCast(d.a().fromJson(r2, r1), PeriodicPolicy.class, "com.obric.aiagent.plugin");
    }

    public final String a(List<ConditionTaskAction> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        return d.a().toJson(r1);
    }

    public final List<ConditionTaskAction> c(String r15) {
        if (r15 != null) goto L5;
        return null;
    L5:
        JSONArray r0 = new JSONArray(r15);
        List<ConditionTaskAction> r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r1 = r0.length();
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L30;
        JSONObject r5 = r0.optJSONObject(r4);
        String r6 = r5.optString(MemorySourceLinkType.INTENT);
        Set r7 = ServiceManager.get().getServices(IntentFunction.class);
        o.b(r7, "ServiceManager.get().getServices(T::class.java)");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r8.hasNext() == false) goto L13;
        Object r9 = r8.next();
        if (o.a(((IntentFunction) ZeusTransformUtils.preCheckCast(r9, IntentFunction.class, "com.obric.aiagent.plugin")).getName(), r6) == false) goto L9;
    L14:
        IntentFunction r10 = (IntentFunction) ZeusTransformUtils.preCheckCast(r9, IntentFunction.class, "com.obric.aiagent.plugin");
        JSONObject r11 = r5.optJSONObject("params");
        if (r11 == null) goto L17;
        String r12 = r11.toString();
    L18:
        if (r12 == null) goto L28;
        if (r10 == null) goto L28;
        Type[] r13 = r10.getClass().getGenericInterfaces();
        o.c(r13, "getGenericInterfaces(...)");
        Object[] r14 = (Object[]) ZeusTransformUtils.preCheckCast(r13, Object[].class, "com.obric.aiagent.plugin");
        int r17 = r14.length;
        int r18 = 0;
    L21:
        if (r18 >= r17) goto L27;
        Object r19 = r14[r18];
        CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(((Type) ZeusTransformUtils.preCheckCast(r19, Type.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");
        String r111 = IntentFunction.class.getSimpleName();
        o.c(r111, "getSimpleName(...)");
        if (d.o.o.c(r110, (CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L24;
        r18 = r18 + 1;
        goto L21
    L24:
        o.a(r19, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        IntentParams r20 = (IntentParams) ZeusTransformUtils.preCheckCast(d.a().fromJson(r12, ((ParameterizedType) ZeusTransformUtils.preCheckCast(r19, ParameterizedType.class, "com.obric.aiagent.plugin")).getActualTypeArguments()[0]), IntentParams.class, "com.obric.aiagent.plugin");
    L29:
        o.a(r6);
        r16.add(new ConditionTaskAction(r6, r20));
        r4 = r4 + 1;
        goto L6
    L27:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L28:
        r20 = null;
        goto L29
    L17:
        r12 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L30:
        return r16;
    }

    public final String a(Map<String, String> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return d.a().toJson(r1);
    }

    public final Map<String, String> d(String r2) {
        if (r2 == null) goto L4;
        Type r1 = new EventTaskTypeConverters$toMap$1$type$1().getType();
        return (Map) ZeusTransformUtils.preCheckCast(d.a().fromJson(r2, r1), Map.class, "com.obric.aiagent.plugin");
    L4:
        return null;
    }

    public final String b(List<ShortcutTaskAction> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        return d.a().toJson(r1);
    }

    public final List<ShortcutTaskAction> e(String r15) {
        if (r15 != null) goto L5;
        return null;
    L5:
        JSONArray r0 = new JSONArray(r15);
        List<ShortcutTaskAction> r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r1 = r0.length();
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L30;
        JSONObject r5 = r0.optJSONObject(r4);
        String r6 = r5.optString(MemorySourceLinkType.INTENT);
        Set r7 = ServiceManager.get().getServices(IntentFunction.class);
        o.b(r7, "ServiceManager.get().getServices(T::class.java)");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r8.hasNext() == false) goto L13;
        Object r9 = r8.next();
        if (o.a(((IntentFunction) ZeusTransformUtils.preCheckCast(r9, IntentFunction.class, "com.obric.aiagent.plugin")).getName(), r6) == false) goto L9;
    L14:
        IntentFunction r10 = (IntentFunction) ZeusTransformUtils.preCheckCast(r9, IntentFunction.class, "com.obric.aiagent.plugin");
        JSONObject r11 = r5.optJSONObject("params");
        if (r11 == null) goto L17;
        String r12 = r11.toString();
    L18:
        if (r12 == null) goto L28;
        if (r10 == null) goto L28;
        Type[] r13 = r10.getClass().getGenericInterfaces();
        o.c(r13, "getGenericInterfaces(...)");
        Object[] r14 = (Object[]) ZeusTransformUtils.preCheckCast(r13, Object[].class, "com.obric.aiagent.plugin");
        int r17 = r14.length;
        int r18 = 0;
    L21:
        if (r18 >= r17) goto L27;
        Object r19 = r14[r18];
        CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(((Type) ZeusTransformUtils.preCheckCast(r19, Type.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");
        String r111 = IntentFunction.class.getSimpleName();
        o.c(r111, "getSimpleName(...)");
        if (d.o.o.c(r110, (CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L24;
        r18 = r18 + 1;
        goto L21
    L24:
        o.a(r19, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        IntentParams r20 = (IntentParams) ZeusTransformUtils.preCheckCast(d.a().fromJson(r12, ((ParameterizedType) ZeusTransformUtils.preCheckCast(r19, ParameterizedType.class, "com.obric.aiagent.plugin")).getActualTypeArguments()[0]), IntentParams.class, "com.obric.aiagent.plugin");
    L29:
        o.a(r6);
        r16.add(new ShortcutTaskAction(r6, r20));
        r4 = r4 + 1;
        goto L6
    L27:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L28:
        r20 = null;
        goto L29
    L17:
        r12 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L30:
        return r16;
    }

    public final TaskKnowledge f(String r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        TaskKnowledge r4 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(d.a().fromJson(r14, new EventTaskTypeConverters$toTaskKnowledge$type$1().getType()), TaskKnowledge.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L27;
        return null;
    L27:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L10
        c r13 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Object r15 = n.f(Boolean.valueOf(JsonParser.parseString(r14).getAsJsonObject().has("learningSwitch")));     // Catch: Throwable -> L10
    L13:
        if (n.b(r15) == false) goto L16;
        r15 = true;
    L16:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L26;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a r16 = com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a;
        StringBuilder r1 = new StringBuilder().append("toTaskKnowledge: legacy data without learningSwitch field, default to true. hasContent=");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.getContent(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L20;
    L23:
        boolean r3 = true;
    L24:
        r16.b("EventTaskTypeConverters", r1.append(true ^ r3).append(", rawLearningSwitch=").append(r4.getLearningSwitch()).toString());
        return TaskKnowledge.copy$default(r4, false, null, null, 0, true, null, 47, null);
    L20:
        if (r2.length() == 0) goto L23;
        r3 = false;
        goto L24
    L26:
        return r4;
    L10:
        th = move-exception;
        n.a r17 = n.f38560a;
        r15 = n.f(d.o.a(th));
        goto L13
    }

    public final String a(TaskKnowledge r1) {
        return d.a().toJson(r1);
    }

    public final String a(TriggerControlPolicy r1) {
        return d.a().toJson(r1);
    }

    public final TriggerControlPolicy g(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Type r1 = new EventTaskTypeConverters$toTriggerControlPolicy$type$1().getType();
        return (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(d.a().fromJson(r2, r1), TriggerControlPolicy.class, "com.obric.aiagent.plugin");
    }
}
