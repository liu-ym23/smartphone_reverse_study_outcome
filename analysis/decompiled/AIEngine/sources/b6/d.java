package b6;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.aiengine.modelmanager.OtaModelClient;
import com.stepos.core.common.display.ModelDisplayResolver;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor;
import gc.q;
import kotlin.Result;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3061a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIEngineApplication f3062b;

    public /* synthetic */ d(AIEngineApplication aIEngineApplication, int i10) {
        this.f3061a = i10;
        this.f3062b = aIEngineApplication;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        Object objA;
        String strResolveDisplayName;
        int i10 = this.f3061a;
        AIEngineApplication aIEngineApplication = this.f3062b;
        String otaId = (String) obj;
        switch (i10) {
            case 0:
                int i11 = AIEngineApplication.f5748d;
                kotlin.jvm.internal.g.f(otaId, "otaId");
                OtaModelClient otaModelClient = OtaModelClient.f5871a;
                Context applicationContext = aIEngineApplication.getApplicationContext();
                kotlin.jvm.internal.g.e(applicationContext, "getApplicationContext(...)");
                otaModelClient.getClass();
                try {
                    IOtaDeepBinderService iOtaDeepBinderServiceK = otaModelClient.k();
                    objA = iOtaDeepBinderServiceK != null ? iOtaDeepBinderServiceK.queryUpdateMeta(otaId) : null;
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    Log.w("OtaModelClient", "queryReminderMeta failed otaId=".concat(otaId), thB);
                }
                if (objA instanceof Result.Failure) {
                    objA = null;
                }
                Bundle bundle = (Bundle) objA;
                long j10 = bundle != null ? bundle.getLong("sizeBytes") : 0L;
                String string = bundle != null ? bundle.getString("updateInfo") : null;
                if (string == null) {
                    string = "";
                }
                if (bundle == null || (strResolveDisplayName = bundle.getString("modelLabel")) == null || q.t0(strResolveDisplayName) || strResolveDisplayName.equals(otaId)) {
                    strResolveDisplayName = null;
                }
                if (strResolveDisplayName == null) {
                    strResolveDisplayName = ModelDisplayResolver.INSTANCE.resolveDisplayName(applicationContext, otaId, null);
                }
                return new ActiveDownloadConditionMonitor.ReminderMeta(strResolveDisplayName, j10, string);
            default:
                int i12 = AIEngineApplication.f5748d;
                kotlin.jvm.internal.g.f(otaId, "modelId");
                com.stepos.aiengine.preheat.a aVar = aIEngineApplication.f5751c;
                if (aVar != null) {
                    aVar.d(otaId, "so_load_slow");
                }
                return n.f10413a;
        }
    }
}
