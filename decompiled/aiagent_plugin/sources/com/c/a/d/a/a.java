package com.c.a.d.a;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: ABTestMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.c.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.c.a.b.a f11902a;

    @Override // com.c.a.d.a
    public String b() {
        return "abtest";
    }

    public a() {
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r6) {
        JSONObject r0 = new JSONObject(r6.a());
        if (this.f11902a != null) goto L6;
        return false;
    L6:
        if (a(r0, r6) == false) goto L8;
        return true;
    L8:
        String r1 = r0.optString("field");
        if (TextUtils.isEmpty(r1) == false) goto L11;
        return false;
    L11:
        Object r2 = r0.get("value");
        this.f11902a.a(r1, r2);
        if (this.f11902a.a() == false) goto L14;
        String r3 = r0.optString("spKey");
        this.f11902a.b(r3, r2);
    L14:
        com.c.a.c.c r4 = this.f11902a.getConsumerResult();
        if (r4.a() == false) goto L17;
        c(r6);
    L18:
        return true;
    L17:
        a(r4.b(), r4.c(), r6);
        goto L18
    }

    public void a(com.c.a.b.a r3) {
        this.f11902a = (com.c.a.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.c.a.b.a.class, "com.obric.aiagent.plugin");
    }
}
