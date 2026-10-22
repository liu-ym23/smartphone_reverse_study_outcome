package com.obric.autogui.operator;

import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOSingletonOperation.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends b {
    public abstract boolean b(b.a r1);

    public d() {
    }

    @Override // com.obric.autogui.operator.b
    public final b a(b.a r3) {
        b.a r4 = (b.a) ZeusTransformUtils.wrapperContextForParams(r3, b.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "input");
        if (b(r4) == true) goto L7;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "input is of valid type, of missing required parameters.");
        return null;
    L7:
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
    }
}
