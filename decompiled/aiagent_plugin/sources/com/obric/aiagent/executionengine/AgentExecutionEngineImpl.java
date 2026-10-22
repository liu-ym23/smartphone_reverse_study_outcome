package com.obric.aiagent.executionengine;

import android.app.Application;
import android.content.Context;
import com.obric.agent.IAgentExecutor;
import com.obric.aiagent.executionengine.capabilitymanager.api.intention.IIntentionDataManagerApi;
import com.obric.aiagent.executionengine.capabilitymanager.api.publish.IIntentInfoManagerApi;
import com.obric.aiagent.executionengine.utils.pkms.PackageInfoCache;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: AgentExecutionEngineImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AgentExecutionEngineImpl implements IAgentExecutor {
    public static final a Companion = null;
    private static final String TAG = "AgentExecutionEngineImp";

    /* JADX INFO: compiled from: AgentExecutionEngineImpl.kt */
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

    public AgentExecutionEngineImpl() {
    }

    @Override // com.obric.agent.IAgentExecutor
    public void init() {
        ILogDepend.Companion.i(TAG, "init: called");
        com.obric.aiagent.executionengine.capabilitymanager.matcher.a.f16453a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        IIntentInfoManagerApi r3 = (IIntentInfoManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentInfoManagerApi.class), IIntentInfoManagerApi.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        r3.init();
    L5:
        IIntentionDataManagerApi r4 = (IIntentionDataManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentionDataManagerApi.class), IIntentionDataManagerApi.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        r4.init();
    L8:
        PackageInfoCache.f18569a.a();
    }
}
