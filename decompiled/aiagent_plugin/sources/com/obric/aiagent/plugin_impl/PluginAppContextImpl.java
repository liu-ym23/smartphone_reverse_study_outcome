package com.obric.aiagent.plugin_impl;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.sharedstate.SharedState;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: PluginAppContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PluginAppContextImpl implements IAppContext {
    private final Application app;
    private String doubaoChannel;
    private final f packageInfo$delegate;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ PackageInfo lambda$AlN_5gMlmVYJaQjP7B2O0QMkIMM(PluginAppContextImpl r0) {
        return packageInfo_delegate$lambda$0(r0);
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public int getAppId() {
        return 482431;
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getAppName() {
        return "com.obric.aiagent.plugin";
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getMsSdkLicense() {
        return "FRCxz9TGzFoq91NQWK7mP13AdaOSsV0NQuc5PQpEqLwiA9cXLMkxGIEjVA/IkBf1bNlUcpC3DScvwvT5x5D76C8NAtAMIAR5O+1ubMhXwtmYJ5e81A/9lVfmjcMfSJtfHVxNNwctqgYqFRDevgsQ3EfTCnnVKpUW3FzHUnoBM1T9Cd0sgmNIQrw+GX1riLVyhy6u1bWUx5AxlrQ9Bz67hW5UG/PaztDweuU8fS2csjZohgyRipbyriGb8oajoIpYOvXienAMu6H2IVZ32Lh886gF+Soi7A8TAJKyk5UmY0TniC+4";
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public int getOldAiagentAppId() {
        return 773565;
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public boolean isDebug() {
        return false;
    }

    public PluginAppContextImpl() {
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        o.c(r0, "getAppApplication(...)");
        this.app = r0;
        this.packageInfo$delegate = g.a(new $$Lambda$PluginAppContextImpl$AlN_5gMlmVYJaQjP7B2O0QMkIMM(this));
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.DefaultImpls.getContext(this), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public long getCurrentTimeMillis() {
        return IAppContext.DefaultImpls.getCurrentTimeMillis(this);
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public boolean isReleaseChannel() {
        return IAppContext.DefaultImpls.isReleaseChannel(this);
    }

    private final PackageInfo getPackageInfo() {
        return (PackageInfo) ZeusTransformUtils.preCheckCast(this.packageInfo$delegate.b(), PackageInfo.class, "com.obric.aiagent.plugin");
    }

    private static final PackageInfo packageInfo_delegate$lambda$0(PluginAppContextImpl r2) {
        return r2.app.getPackageManager().getPackageInfo(r2.app.getPackageName(), 0);
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public Application getApplication() {
        return this.app;
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getAppStringName() {
        return getAppName();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public int getVersionCode() {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        return (int) getPackageInfo().getLongVersionCode();
    L6:
        return getPackageInfo().versionCode;
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getVersionName() {
        String r0 = getPackageInfo().versionName;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getPackageName() {
        String r1 = this.app.getPackageName();
        o.c(r1, "getPackageName(...)");
        return r1;
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public int getManifestVersionCode() {
        return getVersionCode();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getManifestVersionName() {
        return getVersionName();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public int getUpdateVersionCode() {
        return getVersionCode();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public String getBuildChannel() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.doubaoChannel, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        this.doubaoChannel = SharedState.INSTANCE.getString("doubao_channel", "");
    L11:
        INVOKESTATIC_com_obric_aiagent_plugin_impl_PluginAppContextImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("PluginAppContextImpl", "getBuildChannel: " + this.doubaoChannel);
        String r3 = this.doubaoChannel;
        if (r3 != null) goto L14;
    L19:
        if (r1 == false) goto L22;
        String r6 = this.doubaoChannel;
        o.a(r6);
        return r6;
    L22:
        INVOKESTATIC_com_obric_aiagent_plugin_impl_PluginAppContextImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("PluginAppContextImpl", "isDebug: " + isDebug());
        if (isDebug() == false) goto L25;
        return "debug";
    L25:
        return "release";
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L16;
        boolean r4 = true;
    L17:
        if (r4 != true) goto L19;
        r1 = true;
        goto L19
    L16:
        r4 = false;
        goto L17
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public boolean isDebugChannel() {
        return d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(getBuildChannel(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("debug", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public boolean isTestChannel() {
        return d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(getBuildChannel(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("test", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_plugin_impl_PluginAppContextImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
