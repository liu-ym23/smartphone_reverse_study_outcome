package com.obric.autoaction.app.launcherpage.module.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskListItemDateView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AutoActionTaskDateCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.autoaction.app.launcherpage.ui.f<com.obric.autoaction.app.launcherpage.module.a.a.g> {
    public b() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3) {
        a((com.obric.autoaction.app.launcherpage.module.a.a.g) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.module.a.a.g.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3, List r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((com.obric.autoaction.app.launcherpage.module.a.a.g) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.module.a.a.g.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r8) {
        o.e(r8, "parent");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "getContext(...)");
        return (View) ZeusTransformUtils.preCheckCast(new AutoActionTaskListItemDateView(r1, null, 0, 6, null), View.class, "com.obric.aiagent.plugin");
    }

    public void a(com.obric.autoaction.app.launcherpage.module.a.a.g r3) {
        o.e(r3, "item");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"));
        View r2 = this.f35660b;
        o.a(r2, "null cannot be cast to non-null type com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskListItemDateView");
        ((AutoActionTaskListItemDateView) ZeusTransformUtils.preCheckCast(r2, AutoActionTaskListItemDateView.class, "com.obric.aiagent.plugin")).fitData(r3);
    }

    public void a(com.obric.autoaction.app.launcherpage.module.a.a.g r3, List<? extends Object> r4) {
        List<? extends Object> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "item");
        o.e(r5, "payloads");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), r5);
        View r2 = this.f35660b;
        o.a(r2, "null cannot be cast to non-null type com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskListItemDateView");
        ((AutoActionTaskListItemDateView) ZeusTransformUtils.preCheckCast(r2, AutoActionTaskListItemDateView.class, "com.obric.aiagent.plugin")).fitData(r3);
    }
}
