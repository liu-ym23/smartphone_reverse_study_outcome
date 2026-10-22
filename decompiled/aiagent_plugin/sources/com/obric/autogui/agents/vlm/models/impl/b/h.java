package com.obric.autogui.agents.vlm.models.impl.b;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StdModelFeedbackBuilderJsonImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.obric.autogui.agents.vlm.models.impl.b.a {
    private static final String TAG = "StdMod/Feedback/Json";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.b.C0677b f27601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JsonArray f27602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonArray f27603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final JsonArray f27604e;
    private final JsonArray f;
    private JsonObject g;

    /* JADX INFO: compiled from: StdModelFeedbackBuilderJsonImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f27600a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$1C_QB37w0rdU-9HXPrrVPIH444g, reason: not valid java name */
    public static /* synthetic */ String m748lambda$1C_QB37w0rdU9HXPrrVPIH444g(String r0) {
        return d(r0);
    }

    /* JADX INFO: renamed from: lambda$apaRGj7CiYP2V6_EtwC0Pa7sE-g, reason: not valid java name */
    public static /* synthetic */ String m749lambda$apaRGj7CiYP2V6_EtwC0Pa7sEg(JsonObject r0) {
        return b(r0);
    }

    public h(com.obric.autogui.agents.vlm.b.C0677b r2) {
        o.e(r2, SensitiveType.SESSION);
        this.f27601b = r2;
        this.f27602c = new JsonArray();
        this.f27603d = new JsonArray();
        this.f27604e = new JsonArray();
        this.f = new JsonArray();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.b.a
    public com.obric.autogui.agents.vlm.models.impl.b.a a(String r2) {
        o.e(r2, "reply");
        this.f27602c.add(r2);
        return (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.b.a
    public com.obric.autogui.agents.vlm.models.impl.b.a b(String r2) {
        o.e(r2, "reply");
        this.f27603d.add(r2);
        return (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.b.a
    public com.obric.autogui.agents.vlm.models.impl.b.a c(String r2) {
        o.e(r2, "systemHint");
        this.f27604e.add(r2);
        return (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
    }

    public com.obric.autogui.agents.vlm.models.impl.b.a a(String r3, boolean r4, int r5) {
        o.e(r3, "execStatus");
        JsonObject r0 = new JsonObject();
        r0.addProperty("exec", Boolean.valueOf(r4));
        r0.addProperty("status", r3);
        r0.addProperty(MonitorConstants.CODE, (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5), Number.class, "com.obric.aiagent.plugin"));
        this.f.add((JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.aiagent.plugin"));
        return (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.b.a
    public com.obric.autogui.agents.vlm.models.impl.b.a a(String r2, JsonElement r3) {
        o.e(r2, "key");
        o.e(r3, "value");
        if (this.g != null) goto L5;
        this.g = new JsonObject();
    L5:
        JsonObject r0 = this.g;
        if (r0 == null) goto L9;
        r0.add(r2, r3);
    L9:
        return (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
    }

    public void a(JsonObject r8) {
        o.e(r8, "body");
        JsonObject r0 = new JsonObject();
        r0.add("clarify_reply", (JsonElement) ZeusTransformUtils.preCheckCast(this.f27602c, JsonElement.class, "com.obric.aiagent.plugin"));
        r0.add("user_addition", (JsonElement) ZeusTransformUtils.preCheckCast(this.f27603d, JsonElement.class, "com.obric.aiagent.plugin"));
        r0.add("system_hint", (JsonElement) ZeusTransformUtils.preCheckCast(this.f27604e, JsonElement.class, "com.obric.aiagent.plugin"));
        r0.add("exec_status", (JsonElement) ZeusTransformUtils.preCheckCast(this.f, JsonElement.class, "com.obric.aiagent.plugin"));
        final String r1 = com.obric.autogui.util.b.f31495a.a().toJson((JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.aiagent.plugin"));
        r8.addProperty("user_response", r1);
        final JsonObject r7 = this.g;
        if (r7 == null) goto L11;
        Set<Map.Entry<String, JsonElement>> r2 = r7.entrySet();
        if (r2 == null) goto L10;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.add((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(r4.getValue(), JsonElement.class, "com.obric.aiagent.plugin"));
    L10:
        Loog.INSTANCE.dp(TAG, new $$Lambda$h$apaRGj7CiYP2V6_EtwC0Pa7sEg(r7));
    L11:
        Loog.INSTANCE.dp(TAG, new $$Lambda$h$1C_QB37w0rdU9HXPrrVPIH444g(r1));
    }

    private static final String b(JsonObject r2) {
        return " - [FeedBackForMod] BodyAdded=" + r2;
    }

    private static final String d(String r2) {
        return " - [FeedBackForMod] UserResp=" + r2;
    }
}
