package h6;

import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import com.stepos.aiengine.modelmanager.OtaModelClient;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9328a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f9329b;

    public /* synthetic */ m(String str, int i10) {
        this.f9328a = i10;
        this.f9329b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9328a) {
            case 0:
                ModelManagerFragment.onViewCreated$lambda$10$lambda$9(this.f9329b);
                break;
            default:
                ConcurrentHashMap<String, Runnable> concurrentHashMap = OtaModelClient.f5876f;
                String str = this.f9329b;
                concurrentHashMap.remove(str);
                if (OtaModelClient.f5874d.remove(str)) {
                    AIEngineLogger.w(LogModule.OTA, "MMUpdate", "[DIAG] gateWatchdog force-release modelId=" + str + " (no terminal within 180000ms)");
                    break;
                }
                break;
        }
    }
}
