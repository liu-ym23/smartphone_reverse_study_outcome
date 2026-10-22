package com.obric.autogui.session.state.a;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StateIdle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.obric.autogui.session.state.a {
    public g(com.obric.autogui.session.state.b r9, com.obric.autogui.session.a r10) {
        d.h.b.o.e(r9, "machine");
        d.h.b.o.e(r10, SensitiveType.SESSION);
        super(BizStatus.IDLE, r10, r9, false, 8, null);
    }

    @Override // com.obric.autogui.session.state.a
    public int g() {
        return f().getReason();
    }

    @Override // com.obric.autogui.session.state.a
    public Object a(com.obric.autogui.session.state.a r8, d.c.d<? super com.obric.autogui.common.e> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, k.class) == false) goto L7;
        a(new BizStatus.StatusChangedReasonStruct(0, null, null, null, 15, null));
        AppBlackListEventHolder.INSTANCE.acquireNewHolder();
        return com.obric.autogui.session.c.f30777a.a(d());
    L7:
        return com.obric.autogui.common.e.f29014b.b("not supported");
    }
}
