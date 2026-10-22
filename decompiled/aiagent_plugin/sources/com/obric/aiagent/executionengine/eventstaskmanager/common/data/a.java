package com.obric.aiagent.executionengine.eventstaskmanager.common.data;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
import java.lang.reflect.Type;

/* JADX INFO: compiled from: EventTaskTypeConverters.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements JsonDeserializer<Condition> {
    public a() {
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ Condition deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin"));
    }

    public Condition a(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        Type r2 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        JsonDeserializationContext r6 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        JsonObject r7 = r3.getAsJsonObject();
    L6:
        if (r7 == null) goto L10;
        JsonElement r8 = r7.get("conditionType");
        if (r8 == null) goto L10;
        Integer r9 = Integer.valueOf(r8.getAsInt());
    L12:
        if (r9 == null) goto L18;
        if (r9.intValue() != 1) goto L18;
        return (Condition) ZeusTransformUtils.preCheckCast(d.a().fromJson(r3, ConditionGroup.class), Condition.class, "com.obric.aiagent.plugin");
    L18:
        if (r9 == null) goto L24;
        if (r9.intValue() != 2) goto L24;
        return (Condition) ZeusTransformUtils.preCheckCast(d.a().fromJson(r3, TimeCondition.class), Condition.class, "com.obric.aiagent.plugin");
    L24:
        if (r9 == null) goto L30;
        if (r9.intValue() != 3) goto L30;
        return (Condition) ZeusTransformUtils.preCheckCast(d.a().fromJson(r3, LocationCondition.class), Condition.class, "com.obric.aiagent.plugin");
    L30:
        if (r9 == null) goto L36;
        if (r9.intValue() != 4) goto L36;
        return (Condition) ZeusTransformUtils.preCheckCast(d.a().fromJson(r3, BatteryCondition.class), Condition.class, "com.obric.aiagent.plugin");
    L36:
        if (r9 == null) goto L42;
        if (r9.intValue() != 5) goto L42;
        return (Condition) ZeusTransformUtils.preCheckCast(d.a().fromJson(r3, BluetoothCondition.class), Condition.class, "com.obric.aiagent.plugin");
    L42:
        if (r9 == null) goto L48;
        if (r9.intValue() != 6) goto L48;
        return (Condition) ZeusTransformUtils.preCheckCast(d.a().fromJson(r3, WifiCondition.class), Condition.class, "com.obric.aiagent.plugin");
    L48:
        if (r9 == null) goto L54;
        if (r9.intValue() != 7) goto L54;
        return (Condition) ZeusTransformUtils.preCheckCast(d.a().fromJson(r3, StorageCondition.class), Condition.class, "com.obric.aiagent.plugin");
    L54:
        if (r9 != null) goto L57;
        return null;
    L57:
        if (r9.intValue() == 8) goto L59;
        return null;
    L59:
        return (Condition) ZeusTransformUtils.preCheckCast(d.a().fromJson(r3, SmsCondition.class), Condition.class, "com.obric.aiagent.plugin");
    L10:
        r9 = null;
        goto L12
    L5:
        r7 = null;
        goto L6
    }
}
