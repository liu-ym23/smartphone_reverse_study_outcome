package com.obric.aiagent.plugin_impl;

import com.obric.aiagent.platform.IAIAgentPlatform;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.IBuildContext;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PluginPlatformImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PluginPlatformImpl implements IAIAgentPlatform {
    private final PluginAppContextImpl appContext;

    public PluginPlatformImpl() {
        this.appContext = new PluginAppContextImpl();
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public IBuildContext getBuildContext() {
        return IAIAgentPlatform.DefaultImpls.getBuildContext(this);
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public ICloudConfig getCloudConfig() {
        return IAIAgentPlatform.DefaultImpls.getCloudConfig(this);
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public ILogDepend getLogger() {
        return IAIAgentPlatform.DefaultImpls.getLogger(this);
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public IRuntimeContext getRuntimeContext() {
        return IAIAgentPlatform.DefaultImpls.getRuntimeContext(this);
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public ISecureLogDepend getSecureLogger() {
        return IAIAgentPlatform.DefaultImpls.getSecureLogger(this);
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public ISysLogDepend getSysLogger() {
        return IAIAgentPlatform.DefaultImpls.getSysLogger(this);
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public ITraceDepend getTracer() {
        return IAIAgentPlatform.DefaultImpls.getTracer(this);
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public IAppContext getAppContext() {
        return (IAppContext) ZeusTransformUtils.preCheckCast(this.appContext, IAppContext.class, "com.obric.aiagent.plugin");
    }
}
