package com.obric.autogui.platforms.obric.d;

import com.obric.autogui.platforms.obric.d.a.c;
import com.obric.autogui.platforms.tools.security.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: ObricSecurityApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    public a() {
    }

    @Override // com.obric.autogui.platforms.tools.security.a, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public Object checkVirus(String r2, d<? super Boolean> r3) {
        d<? super Boolean> r1 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return c.f30087a.a(r2, r1);
    }
}
