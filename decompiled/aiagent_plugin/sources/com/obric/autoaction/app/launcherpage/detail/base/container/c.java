package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DetailConfigViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<? extends AutoCondition> f23303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f23304b;

    public c(List<? extends AutoCondition> r3, boolean r4) {
        List<? extends AutoCondition> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "conditions");
        this.f23303a = r5;
        this.f23304b = r4;
    }

    public final List<AutoCondition> a() {
        return this.f23303a;
    }

    public final void a(List<? extends AutoCondition> r3) {
        List<? extends AutoCondition> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<set-?>");
        this.f23303a = r4;
    }
}
