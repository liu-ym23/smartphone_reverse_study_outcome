package com.obric.autoaction.presentation.island.state;

import android.content.Context;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.IslandWidget;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: TaskCreateStateHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskCreateStateHandler extends com.obric.autoaction.presentation.island.state.a {
    public static final a Companion = null;
    private static final String TAG = "AutoAgentIslandWidgetImpl";
    private final Context appContext;

    /* JADX INFO: compiled from: TaskCreateStateHandler.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$_s-7_LCsAPx2GaBTHk5JYIfEXU0, reason: not valid java name */
    public static /* synthetic */ x m631lambda$_s7_LCsAPx2GaBTHk5JYIfEXU0(TaskCreateStateHandler r0) {
        return onPrepared$lambda$1$lambda$0(r0);
    }

    public TaskCreateStateHandler() {
        this.appContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPreparing(WidgetState.Preparing r8) {
        o.e(r8, "state");
        com.obric.autoaction.presentation.island.a.a().a(CommonCollapseTemplate.create$default(com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, "svg:island_normal", "lottie:auto_processing", null, null, 12, null), null, 1, null), null);
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPrepared(WidgetState.Prepared r10) {
        o.e(r10, "state");
        com.obric.autoaction.presentation.island.b r1 = com.obric.autoaction.presentation.island.a.a();
        IslandWidget r2 = CommonCollapseTemplate.create$default(com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, "svg:island_normal", "lottie:auto_processing", null, null, 12, null), null, 1, null);
        r2.setOnCardClickCallback(new $$Lambda$TaskCreateStateHandler$_s7_LCsAPx2GaBTHk5JYIfEXU0(this));
        com.obric.autoaction.presentation.island.b.a(r1, r2, null, false, 4, null);
    }

    private static final x onPrepared$lambda$1$lambda$0(TaskCreateStateHandler r7) {
        IAutoActionPresentationApi r1 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        IAutoActionPresentationApi.DefaultImpls.openPlayer$default(r1, r7.appContext, "click_dynamic_island", null, 4, null);
    L6:
        return x.f38692a;
    }
}
