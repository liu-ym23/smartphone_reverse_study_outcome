package com.stepos.taskrobot.appwhitelist.engine;

import S7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.appwhitelist.model.AppEntry;
import com.stepos.taskrobot.appwhitelist.model.WhitelistManifest;
import com.stepos.taskrobot.common.bean.WhitelistCheckResult;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.twoway.FlowType;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/engine/AppWhitelistEngine;", "", "Lkotlin/Function0;", "Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;", "manifestProvider", "Lcom/stepos/taskrobot/appwhitelist/engine/InstalledChecker;", "installedChecker", AppAgent.CONSTRUCT, "(LS7/a;Lcom/stepos/taskrobot/appwhitelist/engine/InstalledChecker;)V", "", "version", "Lcom/stepos/taskrobot/common/bean/WhitelistCheckResult;", FlowType.FAILED, "(I)Lcom/stepos/taskrobot/common/bean/WhitelistCheckResult;", "", "appName", "check", "(Ljava/lang/String;)Lcom/stepos/taskrobot/common/bean/WhitelistCheckResult;", "LS7/a;", "Lcom/stepos/taskrobot/appwhitelist/engine/InstalledChecker;", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppWhitelistEngine {
    private final InstalledChecker installedChecker;
    private final a manifestProvider;

    public AppWhitelistEngine(a manifestProvider, InstalledChecker installedChecker) {
        k.f(manifestProvider, "manifestProvider");
        k.f(installedChecker, "installedChecker");
        this.manifestProvider = manifestProvider;
        this.installedChecker = installedChecker;
    }

    private final WhitelistCheckResult failed(int version) {
        return new WhitelistCheckResult(2, "", version);
    }

    public final WhitelistCheckResult check(String appName) {
        k.f(appName, "appName");
        WhitelistManifest whitelistManifest = (WhitelistManifest) this.manifestProvider.invoke();
        AppEntry appEntry = whitelistManifest.getAppsIndex().get(appName);
        if (appEntry == null) {
            return failed(whitelistManifest.getVersion());
        }
        if (appEntry.getEnabled() && this.installedChecker.isInstalled(appName)) {
            return new WhitelistCheckResult(0, appName, whitelistManifest.getVersion());
        }
        for (String str : appEntry.getRecommendations()) {
            AppEntry appEntry2 = whitelistManifest.getAppsIndex().get(str);
            if (appEntry2 != null && appEntry2.getEnabled() && this.installedChecker.isInstalled(str)) {
                return new WhitelistCheckResult(1, str, whitelistManifest.getVersion());
            }
        }
        return failed(whitelistManifest.getVersion());
    }
}
