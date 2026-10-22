package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: InnerCrashBodyDumper.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements com.bytedance.crash.l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ICommonParams f7416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7417b;

    public j(ICommonParams r3) {
        ICommonParams r4 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r3, ICommonParams.class, "com.obric.aiagent.plugin");
        this.f7417b = "patch_info.json";
        this.f7416a = r4;
    }

    @Override // com.bytedance.crash.l.a
    public void a(File r2) {
        b(r2);     // Catch: Exception -> L4
        c.a(new File(r2, "bytest.json"));     // Catch: Exception -> L4
        return;
    }

    private void b(File r5) {
        List<String> r4 = this.f7416a.getPatchInfo();     // Catch: Throwable -> L14
        if (r4 != null) goto L5;
        return;
    L5:
        com.bytedance.crash.dumper.a.f r0 = new com.bytedance.crash.dumper.a.f(new File(r5, "patch_info.json").getAbsolutePath());     // Catch: Throwable -> L14
        r0.c();     // Catch: Throwable -> L14
        boolean r6 = false;
        Iterator<String> r7 = r4.iterator();     // Catch: Throwable -> L14
    L7:
        if (r7.hasNext() == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r6 == false) goto L11;
        r0.e();     // Catch: Throwable -> L14
    L11:
        r0.c(r1);     // Catch: Throwable -> L14
        r6 = true;
        goto L7
    L12:
        r0.d();     // Catch: Throwable -> L14
        r0.f();     // Catch: Throwable -> L14
        return;
    }

    private void a(JSONObject r2, File r3) {
        String r1 = com.bytedance.crash.o.i.d(new File(r3, "patch_info.json"));     // Catch: Exception -> L6
        if (r1 == null) goto L11;
        com.bytedance.crash.o.l.a(r2, "patch_info", new JSONArray(r1));     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.o.r.b(e);
    }

    @Override // com.bytedance.crash.l.a
    public void a(JSONObject r2, JSONObject r3, File r4) {
        a(r2, r4);
        JSONObject r1 = c.a(new File(r4, "bytest.json"), r2);
        JSONObject r5 = r2.optJSONObject("header");
        if (r5 != null) goto L5;
        c.a(r1, r3);
        return;
    L5:
        c.a(r1, r5);
    }

    @Override // com.bytedance.crash.l.a
    public JSONObject a(CrashType r2) {
        if (r2 != CrashType.ENSURE) goto L6;
        JSONObject r3 = new JSONObject();
        a(r3);
        JSONObject r1 = new JSONObject();
        c.a(r1);
        com.bytedance.crash.o.l.a(r3, "filters", r1);
        return r3;
    L6:
        return null;
    }

    private void a(JSONObject r5) {
        ICommonParams r4 = this.f7416a;     // Catch: Throwable -> L16
        if (r4 != null) goto L5;
        return;
    L5:
        List<String> r6 = r4.getPatchInfo();     // Catch: Throwable -> L16
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.isEmpty() == true) goto L21;
        JSONArray r0 = new JSONArray();     // Catch: Throwable -> L16
        Iterator<String> r7 = r6.iterator();     // Catch: Throwable -> L16
    L12:
        if (r7.hasNext() == false) goto L14;
        r0.put((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        goto L12
    L14:
        r5.put("patch_info", r0);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    }
}
