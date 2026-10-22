package com.obric.aiagent.platform.depend;

import android.app.Application;
import android.content.Context;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IAppContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppContext implements IAppContext {
    public static final AppContext INSTANCE = null;
    private final /* synthetic */ IAppContext $$delegate_0;

    static {
        INSTANCE = new AppContext();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public int getAppId() {
        return this.$$delegate_0.getAppId();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getAppName() {
        return this.$$delegate_0.getAppName();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getAppStringName() {
        return this.$$delegate_0.getAppStringName();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public Application getApplication() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.$$delegate_0.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getBuildChannel() {
        return this.$$delegate_0.getBuildChannel();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.$$delegate_0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public long getCurrentTimeMillis() {
        return this.$$delegate_0.getCurrentTimeMillis();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public int getManifestVersionCode() {
        return this.$$delegate_0.getManifestVersionCode();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getManifestVersionName() {
        return this.$$delegate_0.getManifestVersionName();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getMsSdkLicense() {
        return this.$$delegate_0.getMsSdkLicense();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public int getOldAiagentAppId() {
        return this.$$delegate_0.getOldAiagentAppId();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getPackageName() {
        return this.$$delegate_0.getPackageName();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public int getUpdateVersionCode() {
        return this.$$delegate_0.getUpdateVersionCode();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public int getVersionCode() {
        return this.$$delegate_0.getVersionCode();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getVersionName() {
        return this.$$delegate_0.getVersionName();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public boolean isDebug() {
        return this.$$delegate_0.isDebug();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public boolean isDebugChannel() {
        return this.$$delegate_0.isDebugChannel();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public boolean isReleaseChannel() {
        return this.$$delegate_0.isReleaseChannel();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public boolean isTestChannel() {
        return this.$$delegate_0.isTestChannel();
    }

    private AppContext() {
        Object r0 = ServiceManager.get().getService(IAppContext.class);
        o.a(r0);
        this.$$delegate_0 = (IAppContext) ZeusTransformUtils.preCheckCast(r0, IAppContext.class, "com.obric.aiagent.plugin");
    }
}
