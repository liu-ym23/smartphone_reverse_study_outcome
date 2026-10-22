package com.c.a.d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: PluginMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends com.c.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.c.a.b.h f11925a;

    @Override // com.c.a.d.a
    public String b() {
        return "plugin";
    }

    public n() {
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r10) {
        JSONObject r0 = new JSONObject(r10.a());
        if (this.f11925a != null) goto L5;
        return false;
    L5:
        String r4 = r0.optString("packageName");
        int r5 = r0.optInt("versionCode");
        String r6 = r0.optString("url");
        String r7 = r0.optString("md5");
        boolean r8 = r0.optBoolean("wifiOnly", false);
        this.f11925a.a(r4, r5, r6, r7, r8);
        com.c.a.c.c r1 = this.f11925a.getConsumerResult();
        if (r1.a() == false) goto L8;
        c(r10);
        return true;
    L8:
        a(r1.b(), r1.c(), r10);
        return true;
    }

    public void a(com.c.a.b.h r3) {
        this.f11925a = (com.c.a.b.h) ZeusTransformUtils.wrapperContextForParams(r3, com.c.a.b.h.class, "com.obric.aiagent.plugin");
    }
}
