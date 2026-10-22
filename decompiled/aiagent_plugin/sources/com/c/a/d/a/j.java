package com.c.a.d.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends com.c.a.d.a implements com.c.a.h.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f11922a;

    @Override // com.c.a.d.a
    public String b() {
        return "network";
    }

    public j() {
        this.f11922a = null;
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r11) {
        if (a(new JSONObject(r11.a()), r11) == false) goto L5;
        return true;
    L5:
        File r0 = com.c.a.e.b.a.e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new JSONObject(r11.a()));
        if (r0 != null) goto L9;
        a("网络信息文件生成失败", r11);
        return true;
    L9:
        this.f11922a = r0;
        com.c.a.h.a.a(new com.c.a.h.b.a("json", 0, false, r11.d(), this, null));
        return true;
    }

    @Override // com.c.a.h.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.f11922a;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }
}
