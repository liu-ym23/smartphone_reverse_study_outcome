package com.obric.autogui.agents.vlm.models.impl.request.b.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: StdModelBizInferencingError.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autogui.agents.vlm.models.impl.request.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.request.b.b f28039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a f28040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28041c;

    public a(com.obric.autogui.agents.vlm.models.impl.request.b.b r2, com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a r3, String r4) {
        o.e(r2, "errorType");
        o.e(r3, "suggestedAction");
        o.e(r4, "terminationMessage");
        this.f28039a = r2;
        this.f28040b = r3;
        this.f28041c = r4;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public com.obric.autogui.agents.vlm.models.impl.request.b.b a() {
        return this.f28039a;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a b() {
        return this.f28040b;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public String a(Context r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        return this.f28041c;
    }
}
