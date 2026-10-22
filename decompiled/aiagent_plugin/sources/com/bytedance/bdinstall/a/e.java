package com.bytedance.bdinstall.a;

import com.bytedance.bdinstall.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HeaderUpdateCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends c<com.bytedance.bdinstall.a.a.a, y> implements a<com.bytedance.bdinstall.a.a.a> {
    @Override // com.bytedance.bdinstall.a.a
    public /* synthetic */ void a(com.bytedance.bdinstall.a.a.a r3) {
        a2((com.bytedance.bdinstall.a.a.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.bdinstall.a.a.a.class, "com.obric.aiagent.plugin"));
    }

    public e(y r3) {
        super((y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(com.bytedance.bdinstall.a.a.a r3) {
        y r2 = (y) ZeusTransformUtils.preCheckCast(a(), y.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.a(r3.a());
        return;
    }
}
