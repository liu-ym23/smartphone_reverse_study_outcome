package com.c.a.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: TemplateMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends com.c.a.d.a implements com.c.a.h.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.c.a.b.j f11928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f11929b;

    @Override // com.c.a.d.a
    public String b() {
        return MonitorConstants.CUSTOM;
    }

    public r() {
        this.f11929b = null;
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r14) {
        String r0 = r14.a();
        if (this.f11928a != null) goto L6;
        return false;
    L6:
        JSONObject r1 = new JSONObject(r0);
        if (a(r1, r14) == false) goto L9;
        return true;
    L9:
        JSONObject r2 = r1.optJSONObject("template");
        if (r2 != null) goto L13;
        a("template字段异常", r14);
        return true;
    L13:
        r1.put("cloud_command_id", r14.d());
        String r3 = this.f11928a.a(r2);
        com.c.a.c.c r4 = this.f11928a.getConsumerResult();
        if (r4.a() == true) goto L16;
        a(r4.b(), r4.c(), r14);
    L24:
        return true;
    L16:
        if (TextUtils.isEmpty(r3) == false) goto L18;
        r3 = "{\"result\" : \"no one handle it.\"}";
    L18:
        File r5 = com.c.a.e.b.a.i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3);
        if (r5 != null) goto L22;
        a("template文件生成异常", r14);
        return true;
    L22:
        this.f11929b = r5;
        com.c.a.h.a.a(new com.c.a.h.b.a(r1.optString("fileContentType", "template_file_type"), 0, false, r14.d(), this, r4.c()));
        goto L24
    }

    public void a(com.c.a.b.j r3) {
        this.f11928a = (com.c.a.b.j) ZeusTransformUtils.wrapperContextForParams(r3, com.c.a.b.j.class, "com.obric.aiagent.plugin");
    }

    @Override // com.c.a.h.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.f11929b;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }
}
