package androidx.compose.runtime;

import android.app.NotificationManager;
import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import b.p;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.core.ability.config.cloud.AbilityConfigDiff;
import com.stepos.core.common.cloud.RealFileStorageUploadGateway;
import com.stepos.core.common.log.LogEntry;
import com.stepos.core.common.log.LogLevel;
import com.stepos.core.common.log.LogRingBuffer;
import com.stepos.core.ota.crypto.attest.DeviceKeyProbe;
import com.stepos.core.ota.download.control.DeviceConditions;
import com.stepos.core.ota.download.control.DownloadControlCenter;
import com.stepos.core.ota.download.control.DownloadController;
import com.stepos.core.ota.download.control.DownloadStrategy;
import com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor;
import gc.i;
import java.util.ListIterator;
import org.json.JSONObject;
import tc.r0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f984a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f985b;

    public /* synthetic */ i(Object obj, int i10) {
        this.f984a = i10;
        this.f985b = obj;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        p pVarPrevious;
        int i10 = this.f984a;
        Object obj2 = this.f985b;
        switch (i10) {
            case 0:
                return j.component2$lambda$4((j) obj2, ((Float) obj).floatValue());
            case 1:
                return l.component2$lambda$4((l) obj2, ((Long) obj).longValue());
            case 2:
                OnBackPressedDispatcher onBackPressedDispatcher = (OnBackPressedDispatcher) obj2;
                b.a backEvent = (b.a) obj;
                kotlin.jvm.internal.g.f(backEvent, "backEvent");
                mb.k<p> kVar = onBackPressedDispatcher.f201b;
                ListIterator<p> listIterator = kVar.listIterator(kVar.a());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        pVarPrevious = listIterator.previous();
                        if (pVarPrevious.f3026a) {
                        }
                    } else {
                        pVarPrevious = null;
                    }
                }
                p pVar = pVarPrevious;
                if (onBackPressedDispatcher.f202c != null) {
                    onBackPressedDispatcher.b();
                }
                onBackPressedDispatcher.f202c = pVar;
                return lb.n.f10413a;
            case 3:
                ActiveDownloadConditionMonitor.ConditionKind kind = (ActiveDownloadConditionMonitor.ConditionKind) obj;
                int i11 = AIEngineApplication.f5748d;
                kotlin.jvm.internal.g.f(kind, "kind");
                k6.a aVar = k6.a.f9946a;
                Context applicationContext = ((AIEngineApplication) obj2).getApplicationContext();
                kotlin.jvm.internal.g.e(applicationContext, "getApplicationContext(...)");
                aVar.getClass();
                NotificationManager notificationManager = (NotificationManager) applicationContext.getApplicationContext().getSystemService(NotificationManager.class);
                if (notificationManager != null) {
                    notificationManager.cancel(kind.ordinal() + 92000);
                }
                return lb.n.f10413a;
            case 4:
                return DeviceKeyProbe.probeEcAgreement$lambda$19((byte[]) obj2, ((Boolean) obj).booleanValue());
            case 5:
                return RealFileStorageUploadGateway.enqueueSingle$lambda$0((zb.l) obj2, ((Integer) obj).intValue());
            case 6:
                return Boolean.valueOf(LogRingBuffer.filterLogs$lambda$10$lambda$9((LogLevel) obj2, (LogEntry) obj));
            case 7:
                return DownloadControlCenter.monitor$lambda$2((DownloadControlCenter) obj2, (DeviceConditions) obj);
            case 8:
                return Boolean.valueOf(DownloadController.register$lambda$1((DownloadStrategy) obj2, (DownloadStrategy) obj));
            case 9:
                return ((i.b) obj2).b(((Integer) obj).intValue());
            case 10:
                return obj == ((mb.a) obj2) ? "(this Collection)" : String.valueOf(obj);
            case 11:
                return AbilityConfigDiff.canonical$lambda$7((JSONObject) obj2, (String) obj);
            case 12:
                rc.f fVar = (rc.f) obj2;
                int iIntValue = ((Integer) obj).intValue();
                return fVar.f11791f[iIntValue] + ": " + fVar.f11792g[iIntValue].i();
            default:
                r0 r0Var = (r0) obj2;
                int iIntValue2 = ((Integer) obj).intValue();
                return r0Var.f13042e[iIntValue2] + ": " + r0Var.h(iIntValue2).i();
        }
    }
}
