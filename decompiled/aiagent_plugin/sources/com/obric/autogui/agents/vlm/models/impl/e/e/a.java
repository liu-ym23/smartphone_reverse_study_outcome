package com.obric.autogui.agents.vlm.models.impl.e.e;

import android.content.Context;
import com.obric.autogui.agents.scripted.api.IJSScriptService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ScriptSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27878a;

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this.f27878a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.e.b
    public String a(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        IJSScriptService r1 = (IJSScriptService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJSScriptService.class), IJSScriptService.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getMainJSCodeByAbility(this.f27878a, r5);
    }
}
