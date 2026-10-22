package com.obric.autoaction.vdplayer.legacy.a.a;

import com.obric.autogui.vdplayer.api.function.IFunctionController;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ExitCallUserUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public c() {
    }

    public final Object a(d.c.d<? super Boolean> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        IFunctionController r3 = (IFunctionController) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFunctionController.class), IFunctionController.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        r3.stopFunction("CallUser");
        return d.c.b.a.b.a(true);
    L5:
        return d.c.b.a.b.a(false);
    }
}
