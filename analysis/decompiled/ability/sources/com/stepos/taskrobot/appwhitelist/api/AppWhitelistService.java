package com.stepos.taskrobot.appwhitelist.api;

import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.appwhitelist.engine.AppWhitelistEngine;
import com.stepos.taskrobot.appwhitelist.engine.PackageManagerInstalledChecker;
import com.stepos.taskrobot.appwhitelist.model.WhitelistManifest;
import com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource;
import com.stepos.taskrobot.appwhitelist.repository.DefaultManifestAdapter;
import com.stepos.taskrobot.appwhitelist.repository.DefaultManifestSource;
import com.stepos.taskrobot.appwhitelist.repository.DiskCache;
import com.stepos.taskrobot.appwhitelist.repository.DiskCacheAdapter;
import com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository;
import com.stepos.taskrobot.common.bean.WhitelistCheckResult;
import com.uxsense.parse.a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.r0;
import s9.C1923c;
import u9.c;
import u9.d;
import z2.l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/api/AppWhitelistService;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", "warmUp", "(Landroid/content/Context;)V", "", "appName", "Lcom/stepos/taskrobot/common/bean/WhitelistCheckResult;", "check", "(Ljava/lang/String;)Lcom/stepos/taskrobot/common/bean/WhitelistCheckResult;", "Lcom/stepos/taskrobot/appwhitelist/repository/WhitelistRepository;", "repository", "Lcom/stepos/taskrobot/appwhitelist/repository/WhitelistRepository;", "Lcom/stepos/taskrobot/appwhitelist/engine/AppWhitelistEngine;", "engine", "Lcom/stepos/taskrobot/appwhitelist/engine/AppWhitelistEngine;", "", "initialized", "Z", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppWhitelistService {
    public static final AppWhitelistService INSTANCE = new AppWhitelistService();
    private static AppWhitelistEngine engine;
    private static volatile boolean initialized;
    private static WhitelistRepository repository;

    private AppWhitelistService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WhitelistManifest warmUp$lambda$0() {
        WhitelistRepository whitelistRepository = repository;
        if (whitelistRepository != null) {
            return whitelistRepository.getCurrent();
        }
        k.n("repository");
        throw null;
    }

    public final WhitelistCheckResult check(String appName) {
        k.f(appName, "appName");
        if (!initialized) {
            return new WhitelistCheckResult(2, "", -1);
        }
        AppWhitelistEngine appWhitelistEngine = engine;
        if (appWhitelistEngine == null) {
            k.n("engine");
            throw null;
        }
        WhitelistCheckResult whitelistCheckResultCheck = appWhitelistEngine.check(appName);
        WhitelistRepository whitelistRepository = repository;
        if (whitelistRepository != null) {
            whitelistRepository.refreshIfExpired();
            return whitelistCheckResultCheck;
        }
        k.n("repository");
        throw null;
    }

    public final synchronized void warmUp(Context context) {
        k.f(context, "context");
        if (initialized) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        r0 r0VarC = AbstractC1683A.c();
        d dVar = AbstractC1691I.f5315a;
        C1923c c1923cB = AbstractC1683A.b(l.H(r0VarC, c.f6743a));
        k.c(applicationContext);
        repository = new WhitelistRepository(new MockWhitelistRemoteSource(applicationContext), new DiskCacheAdapter(new DiskCache(applicationContext)), new DefaultManifestAdapter(new DefaultManifestSource(applicationContext)), c1923cB, null, 16, null);
        engine = new AppWhitelistEngine(new a(19), new PackageManagerInstalledChecker(applicationContext));
        WhitelistRepository whitelistRepository = repository;
        if (whitelistRepository == null) {
            k.n("repository");
            throw null;
        }
        whitelistRepository.loadFromDiskOrAssets();
        WhitelistRepository whitelistRepository2 = repository;
        if (whitelistRepository2 == null) {
            k.n("repository");
            throw null;
        }
        whitelistRepository2.scheduleRefresh();
        initialized = true;
    }
}
