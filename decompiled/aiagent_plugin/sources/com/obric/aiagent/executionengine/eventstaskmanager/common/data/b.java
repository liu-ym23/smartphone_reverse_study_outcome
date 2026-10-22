package com.obric.aiagent.executionengine.eventstaskmanager.common.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.obric.eventkit.task.model.BatteryCondition;
import com.obric.eventkit.task.model.BluetoothCondition;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.eventkit.task.model.SmsCondition;
import com.obric.eventkit.task.model.StorageCondition;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.WifiCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;
import java.lang.reflect.Type;
import java.util.Iterator;

/* JADX INFO: compiled from: EventTaskTypeConverters.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements JsonSerializer<Condition> {
    public b() {
    }

    @Override // com.google.gson.JsonSerializer
    public /* synthetic */ JsonElement serialize(Condition r3, Type r4, JsonSerializationContext r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.aiagent.plugin");
        return a((Condition) ZeusTransformUtils.preCheckCast(r3, Condition.class, "com.obric.aiagent.plugin"), r6, r7);
    }

    public JsonElement a(Condition r6, Type r7, JsonSerializationContext r8) {
        Condition r9 = (Condition) ZeusTransformUtils.wrapperContextForParams(r6, Condition.class, "com.obric.aiagent.plugin");
        Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r7, Type.class, "com.obric.aiagent.plugin");
        JsonSerializationContext r11 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r8, JsonSerializationContext.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L6;
        JsonNull r5 = JsonNull.INSTANCE;
        o.c(r5, "INSTANCE");
        return (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin");
    L6:
        if (r11 == null) goto L11;
        JsonElement r12 = r11.serialize(r9, (Type) ZeusTransformUtils.preCheckCast(r9.getClass(), Type.class, "com.obric.aiagent.plugin"));
        if (r12 == null) goto L11;
        JsonObject r13 = r12.getAsJsonObject();
        if (r13 == null) goto L11;
    L13:
        if (ZeusTransformUtils.instanceOf(r9, ConditionGroup.class) == false) goto L16;
        int r0 = 1;
    L36:
        r13.addProperty("conditionType", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r0), Number.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.instanceOf(r9, ConditionGroup.class) == false) goto L44;
        JsonArray r1 = new JsonArray();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(((ConditionGroup) ZeusTransformUtils.preCheckCast(r9, ConditionGroup.class, "com.obric.aiagent.plugin")).getConditions(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L40:
        if (r14.hasNext() == false) goto L42;
        Condition r2 = (Condition) ZeusTransformUtils.preCheckCast(r14.next(), Condition.class, "com.obric.aiagent.plugin");
        r1.add(a(r2, (Type) ZeusTransformUtils.preCheckCast(r2.getClass(), Type.class, "com.obric.aiagent.plugin"), r11));
        goto L40
    L42:
        r13.add("conditions", (JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.aiagent.plugin"));
    L44:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r13, JsonElement.class, "com.obric.aiagent.plugin");
    L16:
        if (ZeusTransformUtils.instanceOf(r9, TimeCondition.class) == false) goto L19;
        r0 = 2;
        goto L36
    L19:
        if (ZeusTransformUtils.instanceOf(r9, LocationCondition.class) == false) goto L22;
        r0 = 3;
        goto L36
    L22:
        if (ZeusTransformUtils.instanceOf(r9, BatteryCondition.class) == false) goto L25;
        r0 = 4;
        goto L36
    L25:
        if (ZeusTransformUtils.instanceOf(r9, BluetoothCondition.class) == false) goto L28;
        r0 = 5;
        goto L36
    L28:
        if (ZeusTransformUtils.instanceOf(r9, WifiCondition.class) == false) goto L31;
        r0 = 6;
        goto L36
    L31:
        if (ZeusTransformUtils.instanceOf(r9, StorageCondition.class) == false) goto L34;
        r0 = 7;
        goto L36
    L34:
        if (ZeusTransformUtils.instanceOf(r9, SmsCondition.class) == false) goto L46;
        r0 = 8;
        goto L36
    L46:
        throw new k();
    L11:
        r13 = new JsonObject();
        goto L13
    }
}
