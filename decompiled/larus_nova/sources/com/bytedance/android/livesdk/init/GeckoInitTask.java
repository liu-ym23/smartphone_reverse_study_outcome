package com.bytedance.android.livesdk.init;

import com.bytedance.android.annie.resource.AnnieGeckoAppRegister;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractSourceManager;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.py;
import com.bytedance.android.livesdk.gecko.LiveGeckoClientImpl;
import com.bytedance.android.livesdk.gecko.LiveResourcesDistributionImpl;
import com.bytedance.android.livesdk.gecko.TC21GeckoClientImpl;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@WorkThreadTask
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/init/GeckoInitTask;", "Lcom/bytedance/android/live/core/launch/AbsTask;", "", "initBackPacketGecko", "Lcom/bytedance/android/livesdk/gecko/j;", "initInstance", "run", "initGeckoClient", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@Task(businessInfo = "WTO_GeckoInitTask", value = 6)
public final class GeckoInitTask extends AbsTask {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final void initBackPacketGecko() {
        int r100 = com.bytedance.android.annie.resource.h.f39796a;
        com.bytedance.geckox.b r101 = com.bytedance.geckox.b.a.f245076a;
        com.bytedance.geckox.b.e(new AnnieGeckoAppRegister());
    }

    private final com.bytedance.android.livesdk.gecko.j initInstance() {
        if (py.f121015a.getValue().booleanValue() == false) goto L5;
        Lazy r100 = LiveGeckoClientImpl.f125774f;
        com.bytedance.android.livesdk.gecko.j r101 = (LiveGeckoClientImpl) LiveGeckoClientImpl.f125774f.getValue();
    L13:
        IInteractSourceManager r102 = (IInteractSourceManager) jc1.k.f(IInteractSourceManager.class);     // Catch: Exception -> L10
        if (r102 == null) goto L11;
        r102.setTC21GeckoClient(new TC21GeckoClientImpl());     // Catch: Exception -> L10
    L11:
        ALogger.i("GeckoInitTask", "initInstance, client = " + (r101 instanceof LiveGeckoClientImpl));
        return r101;
    L10:
        ALogger.i("GeckoInitTask", "setGeckoClient fail");
        goto L11
    L5:
        r101 = com.bytedance.android.livesdk.gecko.j.e.f125813a;
        goto L13
    }

    public final void initGeckoClient() {
        com.bytedance.android.livesdk.gecko.n r100 = com.bytedance.android.livesdk.gecko.n.f125818b;
        com.bytedance.android.livesdk.gecko.j r101 = initInstance();
        AnonymousClass1 r102 = AnonymousClass1.INSTANCE;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "client");
        Intrinsics.checkNotNullParameter(r102, "interceptRequestHandler");
        LiveResourcesDistributionImpl r103 = r100.f125819a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "client");
        Intrinsics.checkNotNullParameter(r102, "interceptRequestHandler");
        r103.f125787a = r101;
        r103.f125788b = r102;
    }

    @Override // com.bytedance.android.live.core.launch.AbsTask
    public void run() {
        initGeckoClient();
        initBackPacketGecko();
        ((IBrowserService) jc1.k.n(IBrowserService.class)).initRedirectProcessor();
        ((IBrowserService) jc1.k.n(IBrowserService.class)).initPrefetch();
    }

    public GeckoInitTask() {
    }
}
