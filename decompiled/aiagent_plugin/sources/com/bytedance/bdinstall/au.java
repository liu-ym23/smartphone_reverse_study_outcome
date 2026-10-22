package com.bytedance.bdinstall;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: OpInstallServiceImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class au implements at.a, com.bytedance.bdinstall.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private am f6152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.bdinstall.a.b f6153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private aa f6154c;

    @Override // com.bytedance.bdinstall.g.b
    public void a() {
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(Context r1, u r2, long r3, as r5) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        as r4 = (as) ZeusTransformUtils.wrapperContextForParams(r5, as.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(Context r2, Map<String, Object> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(Context r1, Map<String, String> r2, boolean r3, boolean r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(u r1) {
    }

    @Override // com.bytedance.bdinstall.g.b
    public boolean a(JSONObject r1) {
        return false;
    }

    @Override // com.bytedance.bdinstall.g.b
    public void b(u r1) {
    }

    @Override // com.bytedance.bdinstall.g.b
    public boolean d() {
        return false;
    }

    @Override // com.bytedance.bdinstall.g.b
    public u e() {
        return null;
    }

    au(aa r3) {
        this.f6154c = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.aiagent.plugin");
        t.a("OTHER PROCESS IMPL");
    }

    public void a(com.bytedance.bdinstall.a.b r1) {
        this.f6153b = r1;
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(an r4, u r5) {
        at r6 = new at((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r6.a(r4);
        r6.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this);
        n.a(r4);
        com.bytedance.bdinstall.g.d.a(r.class, new o(r4), String.valueOf(r4.a()));
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(am r1) {
        this.f6152a = r1;
    }

    @Override // com.bytedance.bdinstall.g.b
    public am b() {
        am r0 = this.f6152a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j();
    }

    @Override // com.bytedance.bdinstall.g.b
    public String c() {
        am r0 = this.f6152a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    @Override // com.bytedance.bdinstall.at.a
    public void a(am r2, String r3) {
        t.a("install info changed : " + r2);
        this.f6154c.a(r2);
        com.bytedance.bdinstall.a.b r1 = this.f6153b;
        if (r1 == null) goto L6;
        r1.b(new com.bytedance.bdinstall.a.a.b(r2));
        return;
    }
}
