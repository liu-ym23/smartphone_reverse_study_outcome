package com.obric.autogui.agents;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;

/* JADX INFO: compiled from: IPredCondictionJudge.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: compiled from: IPredCondictionJudge.kt */
    public static final class a {
        public static void a(c r2, com.obric.autogui.session.a r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
            o.e(r3, SensitiveType.SESSION);
        }
    }

    Object a(com.obric.autogui.session.a r1, k r2, com.obric.autogui.agents.a.d r3, d<? super com.obric.autogui.agents.a.b> r4);

    void a(com.obric.autogui.session.a r1);
}
