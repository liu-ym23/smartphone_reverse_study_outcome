package com.obric.autogui.common.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.autogui.common.api.platform.packages.StartActivityPosition;
import com.obric.autogui.common.api.platform.packages.StartActivityResult;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherEntryInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherShortcutInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.OpenableAppInfo;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import java.util.Collection;

/* JADX INFO: compiled from: AOPackagesTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOPackagesTools implements IAutoActionPackagesApi {
    public static final AOPackagesTools INSTANCE = null;
    private final /* synthetic */ IAutoActionPackagesApi $$delegate_0;

    static {
        INSTANCE = new AOPackagesTools();
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public String getAppApkMd5(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "packageName");
        return this.$$delegate_0.getAppApkMd5(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public String getAppApkMd5FromCacheOnly(String r2) {
        o.e(r2, "packageName");
        return this.$$delegate_0.getAppApkMd5FromCacheOnly(r2);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Drawable getAppIconDrawable(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "packageName");
        return this.$$delegate_0.getAppIconDrawable(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public AppInfoEntry getAppInfo(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "packageName");
        return this.$$delegate_0.getAppInfo(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public String getAppSign(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "packageName");
        return this.$$delegate_0.getAppSign(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Intent getLaunchIntent(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "packageName");
        return this.$$delegate_0.getLaunchIntent(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Collection<LauncherEntryInfo> getLauncherEntriesForLabel(Context r3, String r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, "label");
        return this.$$delegate_0.getLauncherEntriesForLabel(r6, r4, r5);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Collection<LauncherShortcutInfo> getLauncherShortcutsForLabel(Context r3, String r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, "label");
        return this.$$delegate_0.getLauncherShortcutsForLabel(r6, r4, r5);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Object getOpenableApps(Context r3, d<? super Collection<OpenableAppInfo>> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d<? super Collection<OpenableAppInfo>> r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.getOpenableApps(r5, r6);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Collection<String> getPackageNamesForLabel(Context r3, String r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, "label");
        return this.$$delegate_0.getPackageNamesForLabel(r6, r4, r5);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void init(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this.$$delegate_0.init(r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void invalidateCache() {
        this.$$delegate_0.invalidateCache();
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public boolean isSystemApp(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "packageName");
        return this.$$delegate_0.isSystemApp(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public boolean killApp(String r1, boolean r2) {
        return this.$$delegate_0.killApp(r1, r2);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public Object killAppAndDelay(String r7, boolean r8, long r9, d<? super Boolean> r11) {
        d<? super Boolean> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.killAppAndDelay(r7, r8, r9, r5);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public boolean openAppOnMainDisplay(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "packageName");
        return this.$$delegate_0.openAppOnMainDisplay(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void prefetchAppSignAndMd5(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "packageName");
        this.$$delegate_0.prefetchAppSignAndMd5(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void refreshCacheAsync(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this.$$delegate_0.refreshCacheAsync(r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void registerPackageChangeListener(IAutoActionPackagesApi.PackageChangeListener r3) {
        IAutoActionPackagesApi.PackageChangeListener r4 = (IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.$$delegate_0.registerPackageChangeListener(r4);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public StartActivityResult startActivity(Context r3, Intent r4, StartActivityPosition r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, MemorySourceLinkType.INTENT);
        o.e(r5, "position");
        return this.$$delegate_0.startActivity(r6, r4, r5);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public StartActivityResult startActivity(Context r3, Intent r4, AOOperatingSpace r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r7 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r5, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, MemorySourceLinkType.INTENT);
        o.e(r7, "operatingSpace");
        return this.$$delegate_0.startActivity(r6, r4, r7);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void startActivityUnsafe(Context r3, Intent r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, MemorySourceLinkType.INTENT);
        this.$$delegate_0.startActivityUnsafe(r6, r4, r5);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public StartActivityResult startShortcut(Context r3, String r4, String r5, StartActivityPosition r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r4, "packageName");
        o.e(r5, "shortcutId");
        o.e(r6, "position");
        return this.$$delegate_0.startShortcut(r7, r4, r5, r6);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi
    public void unregisterPackageChangeListener(IAutoActionPackagesApi.PackageChangeListener r3) {
        IAutoActionPackagesApi.PackageChangeListener r4 = (IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.$$delegate_0.unregisterPackageChangeListener(r4);
    }

    private AOPackagesTools() {
        this.$$delegate_0 = AOPlatformTools.INSTANCE.packages();
    }
}
