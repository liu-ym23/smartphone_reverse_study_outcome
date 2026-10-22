package com.c.a.d.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: StatMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends com.c.a.d.a implements com.c.a.h.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f11927a;

    @Override // com.c.a.d.a
    public String b() {
        return "stat";
    }

    public q() {
        this.f11927a = null;
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r13) {
        JSONObject r0 = new JSONObject(r13.a());
        String r1 = r0.optString("type", "system_info");
        if (a(r0, r13) == false) goto L5;
        return true;
    L5:
        JSONObject r2 = new JSONObject();
        if ("all".equals(r1) == false) goto L9;
        r2.put("all", new com.c.a.e.a.a.a().a());
    L14:
        File r3 = com.c.a.e.b.a.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2);
        if (r3 != null) goto L18;
        a("系统信息文件生成失败", r13);
        return true;
    L18:
        this.f11927a = r3;
        com.c.a.h.a.a(new com.c.a.h.b.a("json", 0, false, r13.d(), this, null));
        return true;
    L9:
        if ("stack_info".equals(r1) == true) goto L14;
        if ("system_info".equals(r1) == false) goto L14;
        r2.put("system_info", new com.c.a.e.a.a.a().a());
        goto L14
    }

    @Override // com.c.a.h.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList();
        File r1 = this.f11927a;
        if (r1 == null) goto L5;
        r0.add(r1.getAbsolutePath());
    L5:
        return r0;
    }
}
