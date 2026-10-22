package com.obric.autogui.agents.vlm.models.omni;

import android.content.Context;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniRequestDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.obric.autogui.agents.vlm.models.impl.request.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f28455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JsonObject f28456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.request.b.b f28457c;

    public p(boolean r2, JsonObject r3, com.obric.autogui.agents.vlm.models.impl.request.b.b r4) {
        d.h.b.o.e(r4, "errorType");
        this.f28455a = r2;
        this.f28456b = r3;
        this.f28457c = r4;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
    public boolean a() {
        return this.f28455a;
    }

    public /* synthetic */ p(boolean r1, JsonObject r2, com.obric.autogui.agents.vlm.models.impl.request.b.b r3, int r4, d.h.b.h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = com.obric.autogui.agents.vlm.models.impl.request.b.b.f;
    L5:
        this(r1, r2, r3);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
    public JsonObject b() {
        JsonObject r0 = this.f28456b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new JsonObject();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
    public com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r3) {
        d.h.b.o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        return (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(new n(this.f28457c, "omni_response_failed"), com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
    }
}
