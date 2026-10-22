package com.c.a.d.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: PermissionMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends com.c.a.d.a implements com.c.a.h.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f11924a;

    @Override // com.c.a.d.a
    public String b() {
        return "permission";
    }

    public m() {
        this.f11924a = null;
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r11) {
        if (a(new JSONObject(r11.a()), r11) == false) goto L5;
        return true;
    L5:
        File r0 = com.c.a.e.b.a.f.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r0 != null) goto L9;
        com.c.a.h.b.b r10 = new com.c.a.h.b.b(0, false, r11.d(), null);
        r10.a(3);
        r10.a("网络信息文件生成失败");
        com.c.a.h.a.a(r10);
        return true;
    L9:
        this.f11924a = r0;
        com.c.a.h.a.a(new com.c.a.h.b.a("txt", 0, false, r11.d(), this, null));
        return true;
    }

    @Override // com.c.a.h.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.f11924a;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }
}
