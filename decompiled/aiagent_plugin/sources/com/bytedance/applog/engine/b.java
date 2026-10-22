package com.bytedance.applog.engine;

import android.content.Context;
import com.bytedance.applog.util.g;
import com.bytedance.applog.util.p;
import com.bytedance.bdinstall.ar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: Configer.java */
/* JADX INFO: loaded from: classes.dex */
class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f5605d = null;

    @Override // com.bytedance.applog.engine.a
    public boolean c() {
        return true;
    }

    @Override // com.bytedance.applog.engine.a
    public String f() {
        return "configer";
    }

    static {
        f5605d = Collections.singletonList("Configer");
    }

    b(Engine r3) {
        super(r3, r3.getConfig().j());
    }

    @Override // com.bytedance.applog.engine.a
    public long d() {
        return this.f5601a.getConfig().v();
    }

    @Override // com.bytedance.applog.engine.a
    public long[] e() {
        return f5600c;
    }

    @Override // com.bytedance.applog.engine.a
    public boolean b(int r7) {
        b().Z().b(f5605d, f() + " start doWork curTs = {}", new Object[]{Long.valueOf(System.currentTimeMillis())});
        com.bytedance.applog.j.c r8 = this.f5601a.getDm();
        if (r8.e() == false) goto L21;
        JSONObject r0 = new JSONObject();
        r0.put("magic_tag", "ss_app_log");
        r0.put("header", r8.a());
        r0.put("_gen_time", System.currentTimeMillis());
        JSONObject r9 = new JSONObject();
        if (b().ap() == false) goto L8;
        r9.put("params_block_enable", 1);
    L8:
        if (b().aq() == false) goto L11;
        r9.put("header_custom_allow_enable", 1);
    L11:
        if (r9.length() <= 0) goto L13;
        r0.put("options", r9);
    L13:
        b().V().a(r0, false);
        JSONObject r10 = b().V().b(com.bytedance.applog.k.a.a(b().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f5601a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f5601a.getUriConfig().e(), true, ar.f6145b), g.f6037b), r0);
        com.bytedance.applog.j.b r1 = this.f5601a.getConfig();
        if (b().Q() == null) goto L16;
        b().Q().a(!p.a(r10, r1.h()), r10);
    L16:
        if (r10 == null) goto L21;
        r1.a(r10);
        if (this.f5601a.getConfig().c().J() == false) goto L20;
        this.f5601a.setEventFilter(com.bytedance.applog.e.a.a(this.f5601a.getAppLog(), com.bytedance.applog.b.a(this.f5601a.getAppLog(), "sp_filter_name"), r10));
    L20:
        return true;
    L21:
        return false;
    }
}
