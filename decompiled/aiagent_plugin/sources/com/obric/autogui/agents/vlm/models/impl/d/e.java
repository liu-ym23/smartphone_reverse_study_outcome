package com.obric.autogui.agents.vlm.models.impl.d;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.obric.autogui.agents.vlm.models.impl.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ScriptStepParserImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27780a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f<e> f27781b = null;

    /* JADX INFO: compiled from: ScriptStepParserImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final e a() {
            return (e) ZeusTransformUtils.preCheckCast(e.a().b(), e.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: lambda$-NkoaBg8c-r_XTrk1WGDVy7sdGc, reason: not valid java name */
    public static /* synthetic */ e m754lambda$NkoaBg8cr_XTrk1WGDVy7sdGc() {
        return b();
    }

    public e() {
    }

    public static final /* synthetic */ d.f a() {
        return f27781b;
    }

    static {
        f27780a = new a(null);
        f27781b = d.g.a($$Lambda$e$NkoaBg8cr_XTrk1WGDVy7sdGc.INSTANCE);
    }

    private static final e b() {
        return new e();
    }

    public final com.obric.autogui.common.d<? extends com.obric.autogui.agents.vlm.models.impl.g> a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r5, JsonArray r6, JsonObject r7, com.obric.autogui.agents.vlm.models.impl.d.a r8) {
        com.obric.autogui.agents.vlm.models.impl.d.a r4 = (com.obric.autogui.agents.vlm.models.impl.d.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.autogui.agents.vlm.models.impl.d.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "inferenceContext");
        o.e(r6, "acParam");
        o.e(r7, "responseJson");
        o.e(r4, "genOpsFromResponse");
        return com.obric.autogui.common.d.f29012a.a(com.obric.autogui.agents.vlm.models.impl.g.f27904b.a((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.vlm.models.impl.g.f27904b.a((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(new l(r5, r4, r6), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin"), r7), com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin"), r7));
    }
}
