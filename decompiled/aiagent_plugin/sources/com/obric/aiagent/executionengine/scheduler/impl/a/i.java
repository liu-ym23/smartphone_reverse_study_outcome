package com.obric.aiagent.executionengine.scheduler.impl.a;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: EventAtomicAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends e {
    private static final String TAG = "EventAtomicAction";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f18140b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JsonArray f18141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f18142d;

    /* JADX INFO: compiled from: EventAtomicAction.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18140b = new a(null);
    }

    public /* synthetic */ i(AppAction r11, JsonObject r12, JsonObject r13, androidx.b.a r14, com.obric.aiagent.executionengine.scheduler.impl.job.c r15, JsonArray r16, c r17, int r18, int r19, d.h.b.h r20) {
        if ((r19 & 128) == 0) goto L5;
        int r9 = 1;
    L6:
        this(r11, r12, r13, r14, r15, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public i(AppAction r15, JsonObject r16, JsonObject r17, androidx.b.a<String, JsonObject> r18, com.obric.aiagent.executionengine.scheduler.impl.job.c r19, JsonArray r20, c<e> r21, int r22) {
        o.e(r15, "appAction");
        o.e(r16, "inputParamsEvent");
        o.e(r19, "job");
        o.e(r21, "dag");
        super(r15, r16, r17, (Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.aiagent.plugin"), r19, r21, null, 64, null);
        this.f18141c = r20;
        this.f18142d = r22;
        f();
        if (a() != null) goto L8;
        if (r20 == null) goto L8;
        if (r20.size() <= 0) goto L8;
        a(new JsonObject());
    L8:
        JsonObject r1 = a();
        if (r1 == null) goto L11;
        r1.add("todo_actions", (JsonElement) ZeusTransformUtils.preCheckCast(r20, JsonElement.class, "com.obric.aiagent.plugin"));
    L11:
        JsonObject r2 = a();
        if (r2 == null) goto L14;
        r2.addProperty(Ext.KEY_JOB_ID, (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r19.e()), Number.class, "com.obric.aiagent.plugin"));
    L14:
        JsonObject r3 = a();
        if (r3 == null) goto L17;
        r3.addProperty("event_id", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(k()), Number.class, "com.obric.aiagent.plugin"));
    L17:
        JsonObject r4 = a();
        if (r4 == null) goto L21;
        r4.addProperty("event_counts", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r22), Number.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.a.e
    public String toString() {
        return "EventAtomicAction(packageName=" + d() + ", operationId=" + e() + ", inputParams=" + a() + ", inputParamsWantsDependsOnOthers=" + b() + ", todoActionsArray=" + this.f18141c + "state=" + g() + ')';
    }
}
