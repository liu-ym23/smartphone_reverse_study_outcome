package com.obric.autogui.agents.vlm.models.impl.request.c;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.autogui.agents.vlm.models.impl.request.b.a.c;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: StdModelHttpImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements com.obric.autogui.agents.vlm.models.impl.request.a {
    private static final String TAG = "M-Std-Http";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0706a f28055a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autogui.tools.api.net.a f28056b;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StdModelHttpImpl.kt */
    public static final class C0706a {
        public /* synthetic */ C0706a(h r1) {
            this();
        }

        private C0706a() {
        }
    }

    static {
        f28055a = new C0706a(null);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public Object a(d<? super e> r3) {
        return a(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
    }

    public a() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public Object b(d<? super x> r3) {
        return com.obric.autogui.agents.vlm.models.impl.request.a.C0702a.a(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
    }

    public final com.obric.autogui.tools.api.net.a a() {
        return this.f28056b;
    }

    static /* synthetic */ Object a(a r2, d<? super e> r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.tools.api.net.a r5 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r5 != null) goto L6;
        Loog.INSTANCE.e(TAG, " - no available HTTP client.");
        return e.f29014b.b("cannot obtain http client.");
    L6:
        r2.f28056b = r5;
        return e.f29014b.a();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public void a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r2) {
        o.e(r2, "inferenceContext");
        r2.c().addProperty("enable_stream", true);
    }

    public final com.obric.autogui.agents.vlm.models.impl.request.a.b b() {
        return new com.obric.autogui.agents.vlm.models.impl.request.a.b(null, 1, null);
    }

    public final com.obric.autogui.agents.vlm.models.impl.request.a.c a(com.obric.autogui.agents.vlm.models.impl.request.b.a r2) {
        com.obric.autogui.agents.vlm.models.impl.request.b.a r1 = (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        o.e(r1, WsConstants.KEY_CONNECTION_ERROR);
        return (com.obric.autogui.agents.vlm.models.impl.request.a.c) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.a.b(r1), com.obric.autogui.agents.vlm.models.impl.request.a.c.class, "com.obric.aiagent.plugin");
    }

    public final com.obric.autogui.agents.vlm.models.impl.request.a.c a(com.obric.autogui.tools.api.net.b r3) {
        com.obric.autogui.tools.api.net.b r4 = (com.obric.autogui.tools.api.net.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.tools.api.net.b.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        com.obric.autogui.agents.vlm.models.impl.request.b.a r5 = (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(c.f28044a, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
    L7:
        return a(r5);
    L5:
        r5 = (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.b.a.b(r4), com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        goto L7
    }
}
