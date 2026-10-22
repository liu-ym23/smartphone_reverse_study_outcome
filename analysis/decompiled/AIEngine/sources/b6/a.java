package b6;

import android.util.Log;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.core.common.cloud.FileStorageBootstrap;
import com.stepos.core.common.cloud.FileStorageUploader;
import com.stepos.core.common.cloudconfig.CloudConfigManager;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.ModelCallFlywheel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3055a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIEngineApplication f3056b;

    public /* synthetic */ a(AIEngineApplication aIEngineApplication, int i10) {
        this.f3055a = i10;
        this.f3056b = aIEngineApplication;
    }

    @Override // zb.a
    public final Object invoke() {
        Object objA;
        AtomicLong atomicLongPutIfAbsent;
        int i10 = this.f3055a;
        AIEngineApplication aIEngineApplication = this.f3056b;
        switch (i10) {
            case 0:
                int i11 = AIEngineApplication.f5748d;
                ModelCallFlywheel.INSTANCE.init(aIEngineApplication);
                return n.f10413a;
            case 1:
                int i12 = AIEngineApplication.f5748d;
                try {
                    boolean zEnsureSetup = FileStorageBootstrap.INSTANCE.ensureSetup(aIEngineApplication, new FileStorageBootstrap.Params("ai-engine-test", "wjxJ8wrwRKUDG62Mc718", "https://biz-gw-in.zyql.com", "ai-engine-prod", "6PrSFRURhIEplf9XcXCp", "https://biz-gw.stepaos.com", "aiengine", "client", "aiengine", "client"));
                    jd.b.f9769b = new FileStorageUploader(aIEngineApplication);
                    objA = Integer.valueOf(Log.i("AIEngineApplication", "CloudFileUploader registered (FileStorage gateway upload, ready=" + zEnsureSetup + ")"));
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    Log.e("AIEngineApplication", "Failed to register CloudFileUploader (batch cloud ASR unavailable)", thB);
                }
                return n.f10413a;
            case 2:
                com.stepos.aiengine.preheat.a aVar = aIEngineApplication.f5751c;
                if (aVar != null) {
                    ConcurrentHashMap.KeySetView keySetView = aVar.f5918f;
                    if (!keySetView.isEmpty()) {
                        AIEngineLogger.i(LogModule.SERVICE, "PreheatGateController", "pressure recovered → schedule immediate preheat retry, pending=" + keySetView);
                        ConcurrentHashMap<String, AtomicLong> concurrentHashMap = aVar.f5920i;
                        AtomicLong atomicLong = concurrentHashMap.get("normal_event");
                        if (atomicLong == null && (atomicLongPutIfAbsent = concurrentHashMap.putIfAbsent("normal_event", (atomicLong = new AtomicLong()))) != null) {
                            atomicLong = atomicLongPutIfAbsent;
                        }
                        atomicLong.incrementAndGet();
                        aVar.f(0L);
                    }
                }
                return n.f10413a;
            case 3:
                return aIEngineApplication.f5750b.f5833b;
            default:
                int i13 = AIEngineApplication.f5748d;
                CloudConfigManager.INSTANCE.startAsync(aIEngineApplication);
                return n.f10413a;
        }
    }
}
