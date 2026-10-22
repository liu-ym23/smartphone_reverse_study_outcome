package com.obric.autogui.common.api.app;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.os.UserHandle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.BuildConfig;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import java.util.Date;

/* JADX INFO: compiled from: AOHostAppTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOHostAppTools implements IAutoActionHostAppTools {
    public static final AOHostAppTools INSTANCE = null;
    private static final f appContext$delegate = null;
    private static final long appVersionCode = 0;
    private static final Date buildTime = null;
    private static final f functionName$delegate = null;
    private static final f hostAppContext$delegate = null;
    private static final f hostAppInfo$delegate = null;
    private static final f hostAppPackage$delegate = null;

    /* JADX INFO: renamed from: lambda$2izthTdUvLY7m6-2yvDyDiGxM9s, reason: not valid java name */
    public static /* synthetic */ Application m802lambda$2izthTdUvLY7m62yvDyDiGxM9s() {
        return hostAppContext_delegate$lambda$1();
    }

    public static /* synthetic */ String lambda$IJKjUonzIkcK_cPmoPffQq7JlnQ() {
        return hostAppPackage_delegate$lambda$2();
    }

    public static /* synthetic */ String lambda$IwkULC3ITZnrRsBdqGb3peUnXl8() {
        return functionName_delegate$lambda$4();
    }

    /* JADX INFO: renamed from: lambda$Kysd7EUpzuNdPbzLxvtheUI-UJg, reason: not valid java name */
    public static /* synthetic */ Context m803lambda$Kysd7EUpzuNdPbzLxvtheUIUJg() {
        return appContext_delegate$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$zfiqX-lSFgPpRzprcM4qf24kPpM, reason: not valid java name */
    public static /* synthetic */ HostAppInfo m804lambda$zfiqXlSFgPpRzprcM4qf24kPpM() {
        return hostAppInfo_delegate$lambda$3();
    }

    private AOHostAppTools() {
    }

    static {
        INSTANCE = new AOHostAppTools();
        appContext$delegate = g.a($$Lambda$AOHostAppTools$Kysd7EUpzuNdPbzLxvtheUIUJg.INSTANCE);
        appVersionCode = AutoActionFoundation.INSTANCE.getPluginVersionCode();
        hostAppContext$delegate = g.a($$Lambda$AOHostAppTools$2izthTdUvLY7m62yvDyDiGxM9s.INSTANCE);
        hostAppPackage$delegate = g.a($$Lambda$AOHostAppTools$IJKjUonzIkcK_cPmoPffQq7JlnQ.INSTANCE);
        hostAppInfo$delegate = g.a($$Lambda$AOHostAppTools$zfiqXlSFgPpRzprcM4qf24kPpM.INSTANCE);
        functionName$delegate = g.a($$Lambda$AOHostAppTools$IwkULC3ITZnrRsBdqGb3peUnXl8.INSTANCE);
        buildTime = new Date(BuildConfig.BUILD_TIMESTAMP);
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostAppTools
    public Context getAppContext() {
        return (Context) ZeusTransformUtils.preCheckCast(appContext$delegate.b(), Context.class, "com.obric.aiagent.plugin");
    }

    private static final Context appContext_delegate$lambda$0() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AutoActionFoundation.INSTANCE.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostAppTools
    public Context getAppContextOrNull() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AutoActionFoundation.INSTANCE.getContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostAppTools
    public long getAppVersionCode() {
        return appVersionCode;
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostAppTools
    public Application getHostAppContext() {
        return (Application) ZeusTransformUtils.preCheckCast(hostAppContext$delegate.b(), Application.class, "com.obric.aiagent.plugin");
    }

    private static final Application hostAppContext_delegate$lambda$1() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(INSTANCE.acquireAppContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostAppTools
    public String getHostAppPackage() {
        Object r2 = hostAppPackage$delegate.b();
        o.c(r2, "getValue(...)");
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    }

    private static final String hostAppPackage_delegate$lambda$2() {
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(INSTANCE.getHostAppContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName();
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostAppTools
    public HostAppInfo getHostAppInfo() {
        return (HostAppInfo) ZeusTransformUtils.preCheckCast(hostAppInfo$delegate.b(), HostAppInfo.class, "com.obric.aiagent.plugin");
    }

    private static final HostAppInfo hostAppInfo_delegate$lambda$3() {
        IAutoActionFoundationApi r0 = (IAutoActionFoundationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionFoundationApi.class), IAutoActionFoundationApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L8;
        HostAppInfo r1 = r0.getHostAppInfo();
        if (r1 == null) goto L8;
        return r1;
    L8:
        throw new IllegalStateException("No available host app info! Did you register the AutoActionFoundation?");
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostAppTools
    public UserHandle getUserHandle() {
        UserHandle r1 = Process.myUserHandle();
        o.c(r1, "myUserHandle(...)");
        return r1;
    }

    private final Application acquireAppContext() {
        IAutoActionFoundationApi r0 = (IAutoActionFoundationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionFoundationApi.class), IAutoActionFoundationApi.class, "com.obric.aiagent.plugin");
        Application r1 = null;
        if (r0 == null) goto L5;
        Application r2 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getHostApp(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 == null) goto L8;
        return r2;
    L8:
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "No available application context; is the LibAutoGUI correctly initialized?");
        Object r5 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        if (ZeusTransformUtils.instanceOf(r5, Application.class) == false) goto L11;
        r1 = (Application) ZeusTransformUtils.preCheckCast(r5, Application.class, "com.obric.aiagent.plugin");
    L11:
        if (r1 == null) goto L14;
        return r1;
    L14:
        throw new IllegalStateException("No available application context!");
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostAppTools
    public String getFunctionName() {
        return (String) ZeusTransformUtils.preCheckCast(functionName$delegate.b(), String.class, "com.obric.aiagent.plugin");
    }

    private static final String functionName_delegate$lambda$4() {
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.content_function_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "content_function_name"));
        o.c(r0, "getString(...)");
        return r0;
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostAppTools
    public Date getBuildTime() {
        return buildTime;
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostAppTools
    public boolean isSelf(String r3, String r4) {
        o.e(r3, "packageName");
        o.e(r4, "className");
        if (o.a(r3, getHostAppPackage()) == true) goto L6;
        return false;
    L6:
        if (d.o.o.b(r4, "com.obric.autogui", false, 2, null) == false) goto L8;
        return true;
    L8:
        if (d.o.o.b(r4, com.obric.autoaction.BuildConfig.LIBRARY_PACKAGE_NAME, false, 2, null) == true) goto L13;
        return false;
    L13:
        return true;
    }
}
