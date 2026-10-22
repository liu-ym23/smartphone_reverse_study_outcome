package com.c.a.d.a;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: RouteMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends com.c.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.c.a.b.i f11926a;

    @Override // com.c.a.d.a
    public String b() {
        return "route";
    }

    public o() {
        this.f11926a = null;
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r4) {
        String r0 = new JSONObject(r4.a()).optString("schema");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        a("路由scheme为空", r4);
        return true;
    L6:
        com.c.a.b.i r1 = this.f11926a;
        if (r1 == null) goto L13;
        r1.a(r0);
        com.c.a.c.c r2 = this.f11926a.getConsumerResult();
        if (r2.a() == false) goto L11;
        c(r4);
    L12:
        return true;
    L11:
        a(r2.b(), r2.c(), r4);
        goto L12
    L13:
        return false;
    }

    public void a(com.c.a.b.i r3) {
        this.f11926a = (com.c.a.b.i) ZeusTransformUtils.wrapperContextForParams(r3, com.c.a.b.i.class, "com.obric.aiagent.plugin");
    }
}
