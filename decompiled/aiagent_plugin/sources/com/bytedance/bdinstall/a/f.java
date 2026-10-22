package com.bytedance.bdinstall.a;

import com.bytedance.bdinstall.ag;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InstallFinishCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends c<com.bytedance.bdinstall.a.a.b, ag> implements a<com.bytedance.bdinstall.a.a.b> {
    @Override // com.bytedance.bdinstall.a.a
    public /* synthetic */ void a(com.bytedance.bdinstall.a.a.b r3) {
        a2((com.bytedance.bdinstall.a.a.b) ZeusTransformUtils.preCheckCast(r3, com.bytedance.bdinstall.a.a.b.class, "com.obric.aiagent.plugin"));
    }

    public f(ag r3) {
        super((ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(com.bytedance.bdinstall.a.a.b r3) {
        ag r2 = (ag) ZeusTransformUtils.preCheckCast(a(), ag.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.a(r3.a());
        return;
    }
}
