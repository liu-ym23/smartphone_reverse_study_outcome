package com.c.a.d.a;

import android.content.Context;
import com.bytedance.apm.util.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetFlowMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends com.c.a.d.a implements com.c.a.h.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f11921a;

    @Override // com.c.a.d.a
    public String b() {
        return "net_flow";
    }

    public i() {
        this.f11921a = null;
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r20) {
        JSONObject r0 = new JSONObject(r20.a());
        if (a(r0, r20) == false) goto L5;
        return true;
    L5:
        long r2 = r0.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000);
        long r10 = r0.optLong("fetch_end_time", System.currentTimeMillis() / 1000);
        long r3 = r2 * 1000;
        long r4 = 1000 * r10;
        long r11 = z.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r4, 1);
        long r5 = z.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r4, 0);
        JSONObject r6 = new JSONObject();
        r6.put("netStatsWifi", r11);     // Catch: JSONException -> L8
        r6.put("netStatsMobile", r5);     // Catch: JSONException -> L8
        r6.put("netStatsTotal", r5 + r11);     // Catch: JSONException -> L8
    L10:
        File r1 = com.c.a.e.b.a.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6);
        if (r1 != null) goto L14;
        a("网络流量信息文件生成失败", r20);
        return true;
    L14:
        this.f11921a = r1;
        com.c.a.h.a.a(new com.c.a.h.b.a("json", 0, false, r20.d(), this, null));
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @Override // com.c.a.h.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList();
        File r1 = this.f11921a;
        if (r1 == null) goto L5;
        r0.add(r1.getAbsolutePath());
    L5:
        return r0;
    }
}
