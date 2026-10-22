package com.c.a.d.a;

import android.content.Context;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: CacheMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.c.a.d.a {
    @Override // com.c.a.d.a
    public String b() {
        return "new_diskdir";
    }

    public c() {
    }

    static /* synthetic */ void a(c r0, String r1, com.c.a.c.a r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(c r0, JSONObject r1, boolean r2, com.c.a.c.a r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ void b(c r0, String r1, com.c.a.c.a r2) {
        r0.a(r1, r2);
    }

    @Override // com.c.a.d.a
    public boolean d(final com.c.a.c.a r3) {
        com.bytedance.services.slardar.config.a r0 = new AnonymousClass1(this, r3);
        ((IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin")).registerConfigListener(r0);
        return true;
    }

    private void a(JSONObject r4, boolean r5, com.c.a.c.a r6) {
        JSONObject r7 = r4.optJSONObject("performance_modules");
        if (r7 != null) goto L5;
        return;
    L5:
        JSONObject r8 = r7.optJSONObject("disk");
        if (r8 != null) goto L8;
        return;
    L8:
        List<String> r3 = a(com.bytedance.apm.util.p.b(r8, "compliance_relative_paths"));
        JSONObject r9 = r6.b();
        File r10 = com.c.a.i.b.c(r9.optString("rootNode"), r9.optString("relativeDirName"));
        if (r10 == null) goto L25;
        com.c.a.g.a.a("handling dir upload:" + r10.getAbsolutePath(), r6);
        if (r10.exists() == false) goto L23;
        File r11 = com.c.a.g.b.a().b();
        if (r11 == null) goto L21;
        File r0 = new File(r11, r6.d() + "_temp");
        com.c.a.i.b.a(r0);
        boolean r12 = com.c.a.e.b.a.b.a(r10, new File(r0, "dir_tree.txt"), r3);
        com.bytedance.apm.h.e.d("cloudmessage", new String[]{"dir tree generate result " + r12});
        if (r12 == false) goto L19;
        com.c.a.g.b.a().a(r6, r0, "log_dir_tree");
        return;
    L19:
        throw new com.c.a.c.b("目录树文件生成失败");
    L21:
        throw new com.c.a.c.b("pending目录因拿不到context而未设置");
    L23:
        throw new com.c.a.c.b("目录不存在");
    L25:
        throw new com.c.a.c.b("目录参数解析失败");
    }

    private List<String> a(List<String> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        ArrayList r7 = new ArrayList();
        if (com.bytedance.apm6.util.f.a(r5) == false) goto L5;
        return r7;
    L5:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Iterator r8 = r5.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        if (r2.contains("internal") == true) goto L10;
        if (r2.contains("external") == false) goto L7;
        r7.add(r2.replace("external", r1.getExternalFilesDir(null).getParentFile().getAbsolutePath()));
        goto L7
    L10:
        r7.add(r2.replace("internal", r1.getFilesDir().getParentFile().getAbsolutePath()));
        goto L7
    L14:
        return r7;
    }
}
