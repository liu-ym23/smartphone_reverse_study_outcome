package a6;

import com.stepos.aicgroup.resource.ResourcePressureSceneManager;
import com.stepos.core.common.atomic.AtomicSdkClientReal;
import com.stepos.core.common.telemetry.AiPowerEventBus;
import com.stepos.core.cta.CTADialogGate;
import com.stepos.core.ota.OtaAlgorithmUpdater;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f47a;

    public /* synthetic */ d(int i10) {
        this.f47a = i10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f47a) {
            case 0:
                return ResourcePressureSceneManager.executor$lambda$1(runnable);
            case 1:
                return AiPowerEventBus.dispatcher_delegate$lambda$3$lambda$2(runnable);
            case 2:
                return CTADialogGate.continuationExecutor$lambda$1(runnable);
            case 3:
                return OtaAlgorithmUpdater.fetchExecutor$lambda$1(runnable);
            case 4:
                return new Thread(runnable, "clawbench-probe-store");
            case 5:
                Thread thread = new Thread(runnable, "aiengine-preheat-retry");
                thread.setDaemon(true);
                thread.setPriority(1);
                return thread;
            case 6:
                return com.stepos.core.ota.d.n(runnable, "aiengine-watchdog", true);
            case 7:
                return new Thread(runnable, "GlobalTask");
            default:
                return AtomicSdkClientReal.cleanupExecutor$lambda$9(runnable);
        }
    }
}
