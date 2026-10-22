package com.c.a.d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: PatchMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends com.c.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.c.a.b.g f11923a;

    @Override // com.c.a.d.a
    public String b() {
        return "patch";
    }

    public l() {
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r5) {
        JSONObject r0 = new JSONObject(r5.a());
        if (this.f11923a != null) goto L7;
        return false;
    L7:
        if (a(r0, r5) == false) goto L9;
        return true;
    L9:
        String r1 = r0.optString("url");
        String r2 = r0.optString("md5");
        this.f11923a.a(r1, r2);
        com.c.a.c.c r3 = this.f11923a.getConsumerResult();
        if (r3.a() == false) goto L12;
        c(r5);
    L13:
        return true;
    L12:
        a(r3.b(), r3.c(), r5);
        goto L13
    }

    public void a(com.c.a.b.g r3) {
        this.f11923a = (com.c.a.b.g) ZeusTransformUtils.wrapperContextForParams(r3, com.c.a.b.g.class, "com.obric.aiagent.plugin");
    }
}
