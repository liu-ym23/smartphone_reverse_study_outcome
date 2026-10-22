package com.bytedance.apm6.hub.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonEventConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.apm6.commonevent.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.bytedance.apm6.commonevent.a.a f5386a;

    static /* synthetic */ void a(a r0, JSONObject r1, boolean r2) {
        r0.a(r1, r2);
    }

    public a() {
        com.bytedance.apm6.hub.a.a.a.a().b();
        com.bytedance.apm6.hub.a.a.a.a().a(new AnonymousClass1(this));
    }

    @Override // com.bytedance.apm6.commonevent.a.b
    public com.bytedance.apm6.commonevent.a.a a() {
        return this.f5386a;
    }

    private void a(JSONObject r8, boolean r9) {
        JSONObject r10 = r8.optJSONObject("custom_event_settings");
        if (r10 == null) goto L29;
        JSONObject r11 = r10.optJSONObject("allow_service_name");
        HashSet r0 = new HashSet();
        if (r11 == null) goto L10;
        Iterator<String> r12 = r11.keys();
    L8:
        if (r12.hasNext() == false) goto L10;
        r0.add((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin"));
    L10:
        HashSet r13 = new HashSet();
        JSONObject r2 = r10.optJSONObject("allow_log_type");
        if (r2 == null) goto L18;
        Iterator<String> r3 = r2.keys();
    L14:
        if (r3.hasNext() == false) goto L18;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        if (r2.optInt(r4) != 1) goto L14;
        r13.add(r4);
    L18:
        this.f5386a = new com.bytedance.apm6.commonevent.a.a(r0, r13);
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L21;
        com.bytedance.apm6.util.c.b.a("APM-Config", "received customEventSettings=" + r10);
        com.bytedance.apm6.util.c.b.a("APM-Config", "parsed CommonEventConfig=" + this.f5386a);
    L21:
        com.bytedance.apm6.commonevent.a.a(a());
        return;
    }
}
