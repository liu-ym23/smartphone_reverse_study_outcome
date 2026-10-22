package com.obric.autoaction.app.launcherpage.module.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AutoActionTaskHistorySeparatorCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.obric.autoaction.app.launcherpage.ui.f<com.obric.autoaction.app.launcherpage.module.a.a.e> {
    public d() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3) {
        a((com.obric.autoaction.app.launcherpage.module.a.a.e) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.module.a.a.e.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r5) {
        o.e(r5, "parent");
        View r4 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.autoaction_task_list_item_histroy_separator, "layout", "autoaction_task_list_item_histroy_separator"), r5, false, "com.obric.aiagent.plugin");
        o.c(r4, "inflate(...)");
        return r4;
    }

    public void a(com.obric.autoaction.app.launcherpage.module.a.a.e r3) {
        o.e(r3, "item");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"));
    }
}
