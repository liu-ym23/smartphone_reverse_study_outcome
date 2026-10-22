package com.obric.autogui.agents.a.g;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectResultMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    private static final String TAG = "ActionEffectResult";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f26496a = null;

    static {
        f26496a = new j();
    }

    private j() {
    }

    public final com.obric.autogui.operator.g a(com.obric.autogui.operator.g r4, com.obric.autogui.agents.a.a.f r5, com.obric.autogui.agents.a.f.i r6) {
        com.obric.autogui.operator.g r3 = (com.obric.autogui.operator.g) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        o.e(r3, "originalResult");
        o.e(r5, "input");
        o.e(r6, "outcome");
        if (k.a(r6.b()) == false) goto L5;
        com.obric.autogui.operator.g r7 = r3;
    L6:
        Loog r0 = Loog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("[OAutoActionEffect] result applied ").append(com.obric.autogui.agents.a.c.f26286a.a(r5)).append(", outcome=").append(r6.b()).append(", result=");
        if (r7 != r3) goto L9;
        String r9 = "pass";
    L10:
        r0.i(TAG, r8.append(r9).append(", phase=").append(r7.b()).append(", status_code=").append(r7.d()).append(", has_error=").append(r7.a()).append(", strategy=").append(r7.e()).toString());
        return r7;
    L9:
        r9 = WsConstants.KEY_CONNECTION_ERROR;
        goto L10
    L5:
        r7 = com.obric.autogui.agents.a.j.b.f26524a.a(r3, r5, r6);
        goto L6
    }
}
