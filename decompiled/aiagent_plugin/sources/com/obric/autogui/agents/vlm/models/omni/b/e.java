package com.obric.autogui.agents.vlm.models.omni.b;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.agents.vlm.models.omni.l;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: OmniGuiToolTraceContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f28225a = null;

    static {
        f28225a = new e();
    }

    private e() {
    }

    public final void a(String r2, f r3) {
        o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r3, "point");
        b r1 = a(r2);
        if (r1 == null) goto L6;
        r1.a(r3);
        return;
    }

    public final void a(String r2, c r3) {
        o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r3, "detail");
        b r1 = a(r2);
        if (r1 == null) goto L6;
        r1.a(r3);
        return;
    }

    public final void b(String r2, c r3) {
        o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r3, "detail");
        b r1 = a(r2);
        if (r1 == null) goto L6;
        r1.b(r3);
        return;
    }

    public final void a(String r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r5, "fields");
        b r2 = a(r3);
        if (r2 == null) goto L6;
        r2.a(r5);
        return;
    }

    private final b a(String r1) {
        r r0 = t.f28523a.a(r1);
        if (r0 == null) goto L7;
        l r2 = r0.e();
        if (r2 == null) goto L7;
        return r2.d();
    L7:
        return null;
    }
}
