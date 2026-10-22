package com.obric.capabilitykit.common.execution.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends c> f32053a;

    public e() {
    }

    public final void a(List<? extends c> r3) {
        List<? extends c> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.f32053a = r4;
    }

    public final List<c> c() {
        List r0 = this.f32053a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("jobs");
        return null;
    }

    @Override // com.obric.capabilitykit.common.execution.a.d
    public boolean h() {
        return d.a.a(this);
    }
}
