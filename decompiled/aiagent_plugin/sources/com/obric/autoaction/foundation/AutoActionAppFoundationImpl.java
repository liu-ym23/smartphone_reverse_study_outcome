package com.obric.autoaction.foundation;

import android.app.Application;
import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.app.HostAppInfo;
import com.obric.autogui.common.api.app.foundation.FoundationStatus;
import com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.d;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: AutoActionAppFoundationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionAppFoundationImpl implements IAutoActionFoundationApi {
    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public long getPluginVersionCode() {
        return 150200100;
    }

    public AutoActionAppFoundationImpl() {
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public FoundationStatus getStatus() {
        return AutoActionFoundation.INSTANCE.getStatus();
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public Object suspendUntilCreated(d<? super x> r2) {
        d<? super x> r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        Object r3 = AutoActionFoundation.INSTANCE.getCreatedDeferred().a(r1);
        if (r3 != b.a()) goto L6;
        return r3;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public Object suspendUntilReady(d<? super x> r2) {
        d<? super x> r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        Object r3 = AutoActionFoundation.INSTANCE.getReadyDeferred().a(r1);
        if (r3 != b.a()) goto L6;
        return r3;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public Context getContext() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AutoActionFoundation.INSTANCE.getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("AutoActionFoundation is not created yet");
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public Context getContextOrNull() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AutoActionFoundation.INSTANCE.getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public Application getHostApp() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi
    public HostAppInfo getHostAppInfo() {
        String r4 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getHostApp(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName();
        o.c(r4, "getPackageName(...)");
        return new HostAppInfo(r4, IAppContext.Companion.getVersionName(), IAppContext.Companion.getVersionCode(), IAppContext.Companion.isDebug());
    }
}
