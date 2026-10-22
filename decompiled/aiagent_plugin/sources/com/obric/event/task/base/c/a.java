package com.obric.event.task.base.c;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.event.task.base.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;

/* JADX INFO: compiled from: SettingsUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32688a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f32689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static JsonObject f32690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f32691d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f32692e = null;
    private static final String f = null;

    public static /* synthetic */ void lambda$yzHp0RmUY2sfzAkI4O1XznCSyIY(IFlowSettingsIDL r0) {
        a(r0);
    }

    private a() {
    }

    static {
        f32688a = new a();
        f32689b = "";
        f32691d = "obric_task_system_config";
        f32692e = "condition_task_v2";
        f = "sms_condition_type_list";
    }

    public final String a() {
        return f32692e;
    }

    public final String b() {
        return f;
    }

    public final String a(String r5, String r6) {
        o.e(r5, "settingKey");
        o.e(r6, "defaultValue");
        IFlowSettingsIDL r4 = at.a(aa.b(IFlowSettingsIDL.class));
        if (r4 != null) goto L13;
        b.f32684a.b("SettingsUtil", "Flow settings IPC is null, key=" + r5);
        return r6;
    L13:
        String r7 = r4.getObricFlowSettingsJson(r5);     // Catch: Throwable -> L10
        if (r7 != null) goto L15;
        return r6;
    L15:
        return r7;
    L10:
        th = move-exception;
        b.f32684a.b("SettingsUtil", "getFlowSetting failed, key=" + r5 + ", err=" + th.getMessage(), th);
        return r6;
    }

    public final void c() {
        at.a(aa.b(IFlowSettingsIDL.class), false, false, $$Lambda$a$yzHp0RmUY2sfzAkI4O1XznCSyIY.INSTANCE, 3, null);
    }

    private static final void a(IFlowSettingsIDL r4) {
        IFlowSettingsIDL r5 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        o.e(r5, "ipc");
        String r6 = r5.getObricFlowSettingsJson(f32691d);
        if (r6 != null) goto L5;
        r6 = f32689b;
    L5:
        f32689b = r6;
        b.f32684a.b("SettingsUtil", "init: " + f32689b);
        f32690c = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(f32689b, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        return;
    L8:
        b.f32684a.d("SettingsUtil", "failed to parse settings.");
    }

    public final void d() {
        IFlowSettingsIDL r3 = at.a(aa.b(IFlowSettingsIDL.class));
        if (r3 != null) goto L6;
        b.f32684a.b("SettingsUtil", "Flow settings IPC is null.");
        return;
    L6:
        String r4 = r3.getObricFlowSettingsJson(f32691d);
        if (r4 != null) goto L9;
        r4 = f32689b;
    L9:
        f32689b = r4;
        b.f32684a.b("SettingsUtil", "updateSettings: " + f32689b);
        f32690c = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(f32689b, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        return;
    L12:
        b.f32684a.d("SettingsUtil", "failed to parse settings.");
    }

    public final String a(String r5) {
        o.e(r5, "key");
        JsonObject r4 = f32690c;
        if (r4 != null) goto L19;
        return null;
    L19:
        JsonElement r6 = r4.get(r5);     // Catch: Throwable -> L16
        if (r6 != null) goto L9;
        return null;
    L9:
        if (r6.isJsonNull() == false) goto L12;
        return null;
    L12:
        if (r6.isJsonPrimitive() == false) goto L14;
        String r7 = r6.getAsString();     // Catch: Throwable -> L16
    L20:
        return r7;
    L14:
        r7 = r6.toString();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        b.f32684a.d("SettingsUtil", "getConditionSetting failed, key=" + r5 + ", err=" + th.getMessage());
        return null;
    }
}
