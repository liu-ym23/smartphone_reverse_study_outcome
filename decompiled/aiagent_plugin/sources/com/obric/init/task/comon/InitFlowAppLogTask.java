package com.obric.init.task.comon;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.ipc.IAgentIpcManager;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: InitFlowAppLogTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitFlowAppLogTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_FLOW_APPLOG_TASK";

    /* JADX INFO: compiled from: InitFlowAppLogTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: InitFlowAppLogTask.kt */
    public static final class b implements com.obric.aiagent.flow.applog.b {
        b() {
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void b() {
            com.obric.aiagent.flow.applog.b.a.a(this);
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void a() {
            ILogDepend.Companion.d(InitFlowAppLogTask.ID, "onSuccess");
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public InitFlowAppLogTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ILogDepend.Companion.i(ID, "run");
        INVOKESTATIC_com_obric_init_task_comon_InitFlowAppLogTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(ID, "run, logDepends = " + ServiceManager.get().getServices(ILogDepend.class, true));
        com.obric.aiagent.flow.applog.a.a(com.obric.aiagent.flow.applog.a.f18577a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (com.obric.aiagent.flow.applog.b) ZeusTransformUtils.preCheckCast(new b(), com.obric.aiagent.flow.applog.b.class, "com.obric.aiagent.plugin"), 32, 0, 8, null);
        IAgentIpcManager r9 = IAgentIpcManager.Companion.a();
        if (r9 == null) goto L6;
        r9.init((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_init_task_comon_InitFlowAppLogTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
