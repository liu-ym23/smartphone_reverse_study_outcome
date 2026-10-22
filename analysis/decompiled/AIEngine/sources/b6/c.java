package b6;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.aiengine.R;
import com.stepos.aiengine.memory.CameraLaunchReleaseHandler;
import com.stepos.core.common.cloudconfig.CloudConfigManager;
import com.stepos.core.common.cloudconfig.ICloudConfigListener;
import com.stepos.core.common.log.TraceContext;
import com.stepos.core.common.log.TraceStatistic;
import com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor;
import gc.q;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.coroutines.d;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.flow.internal.SafeCollector_commonKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3059a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3060b;

    public /* synthetic */ c(Object obj, int i10) {
        this.f3059a = i10;
        this.f3060b = obj;
    }

    @Override // zb.p
    public final Object invoke(Object obj, Object obj2) {
        int i10 = this.f3059a;
        Object obj3 = this.f3060b;
        switch (i10) {
            case 0:
                String otaId = (String) obj;
                ActiveDownloadConditionMonitor.ConditionKind kind = (ActiveDownloadConditionMonitor.ConditionKind) obj2;
                int i11 = AIEngineApplication.f5748d;
                kotlin.jvm.internal.g.f(otaId, "otaId");
                kotlin.jvm.internal.g.f(kind, "kind");
                k6.a aVar = k6.a.f9946a;
                Context applicationContext = ((AIEngineApplication) obj3).getApplicationContext();
                kotlin.jvm.internal.g.e(applicationContext, "getApplicationContext(...)");
                aVar.getClass();
                Context applicationContext2 = applicationContext.getApplicationContext();
                NotificationManager notificationManager = (NotificationManager) applicationContext2.getSystemService(NotificationManager.class);
                if (notificationManager != null) {
                    int iOrdinal = kind.ordinal() + 92000;
                    if (!k6.a.a(notificationManager, iOrdinal)) {
                        k6.a.f9947b.put(kind, otaId);
                        notificationManager.createNotificationChannel(new NotificationChannel("aiengine_condition_break", applicationContext2.getString(R.string.mm_cond_channel), 4));
                        k6.a.b(applicationContext2, notificationManager, otaId, kind, iOrdinal);
                    }
                }
                return n.f10413a;
            case 1:
                int iIntValue = ((Integer) obj).intValue();
                int iIntValue2 = ((Integer) obj2).intValue();
                int i12 = AIEngineApplication.f5748d;
                ((CameraLaunchReleaseHandler) obj3).a(iIntValue, iIntValue2);
                return n.f10413a;
            case 2:
                return CloudConfigManager.start$lambda$1$lambda$0((ICloudConfigListener) obj3, (String) obj, (InputStream) obj2);
            case 3:
                return TraceContext.updateStats$lambda$9((TraceContext.TraceInfo) obj3, (String) obj, (TraceStatistic) obj2);
            case 4:
                CharSequence DelimitedRangesSequence = (CharSequence) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                kotlin.jvm.internal.g.f(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
                int iS0 = q.s0(DelimitedRangesSequence, (char[]) obj3, iIntValue3, false);
                if (iS0 < 0) {
                    return null;
                }
                return new Pair(Integer.valueOf(iS0), 1);
            default:
                return Integer.valueOf(SafeCollector_commonKt.checkContext$lambda$0((SafeCollector) obj3, ((Integer) obj).intValue(), (d.a) obj2));
        }
    }
}
