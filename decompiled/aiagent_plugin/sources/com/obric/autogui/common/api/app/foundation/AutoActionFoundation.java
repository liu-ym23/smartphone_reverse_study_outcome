package com.obric.autogui.common.api.app.foundation;

import android.app.Application;
import android.content.Context;
import com.obric.autogui.common.api.app.HostAppInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: AutoActionFoundation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionFoundation implements IAutoActionFoundationApi {
    public static final AutoActionFoundation INSTANCE = null;
    private final /* synthetic */ IAutoActionFoundationApi $$delegate_0;

    static {
        INSTANCE = new AutoActionFoundation();
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.$$delegate_0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public Context getContextOrNull() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.$$delegate_0.getContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public Application getHostApp() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.$$delegate_0.getHostApp(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public HostAppInfo getHostAppInfo() {
        return this.$$delegate_0.getHostAppInfo();
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public long getPluginVersionCode() {
        return this.$$delegate_0.getPluginVersionCode();
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public FoundationStatus getStatus() {
        return this.$$delegate_0.getStatus();
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public Object suspendUntilCreated(d<? super x> r3) {
        d<? super x> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.suspendUntilCreated(r4);
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public Object suspendUntilReady(d<? super x> r3) {
        d<? super x> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.suspendUntilReady(r4);
    }

    private AutoActionFoundation() {
        IAutoActionFoundationApi r0 = (IAutoActionFoundationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionFoundationApi.class), IAutoActionFoundationApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        this.$$delegate_0 = r0;
        return;
    L7:
        throw new IllegalStateException("the Foundation API must be implemented.");
    }
}
