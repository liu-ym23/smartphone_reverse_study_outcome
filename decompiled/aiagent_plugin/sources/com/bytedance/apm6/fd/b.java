package com.bytedance.apm6.fd;

import com.bytedance.apm6.perf.base.c;
import com.bytedance.apm6.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: FdEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.apm6.perf.base.model.a {
    private int g;
    private List<String> h;
    private boolean i;

    @Override // com.bytedance.apm6.perf.base.model.a
    public String a() {
        return "fd";
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject b() {
        return null;
    }

    @Override // com.bytedance.apm6.monitor.b
    public boolean h() {
        return true;
    }

    public b(int r3, List<String> r4, boolean r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.g = r3;
        this.h = r6;
        this.i = r5;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject e() {
        JSONObject r0 = new JSONObject();
        r0.put("fd_count", this.g);     // Catch: Exception -> L7
        if (f.a(this.h) == true) goto L6;
        r0.put("fd_detail", f.a(this.h, "\n"));     // Catch: Exception -> L7
    L6:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject c() {
        JSONObject r0 = super.c();
        if (r0 == null) goto L8;
    L5:
        r0.put("is_front", this.i);     // Catch: Exception -> L7
    L6:
        return r0;
    L8:
        r0 = new JSONObject();     // Catch: Exception -> L7
        goto L5
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject d() {
        return c.a().c();
    }
}
