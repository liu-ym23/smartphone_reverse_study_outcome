package b6;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import androidx.datastore.preferences.protobuf.b1;
import androidx.work.impl.WorkDatabase;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.aiengine.modelmanager.ModelManagerActivity;
import com.stepos.aiengine.modelmanager.settings.PrivacySettingsFragment;
import com.stepos.base.ability.AbilityBase;
import com.stepos.core.ability.AbilityBinderImpl;
import com.stepos.core.ability.converter.AbilityInputConverter;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.data.FileContent;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.ota.crypto.OtaAtRestDecryptor;
import com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl;
import com.stepos.core.ota.download.control.DeviceConditionMonitor;
import com.stepos.core.ota.download.control.DownloadControlCenter;
import com.stepos.core.performance.orchestrator.PerformanceOrchestratorImpl;
import com.stepos.core.performance.signal.SystemStateCollector;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.database.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
import lb.n;
import rc.j;
import tc.o0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3065a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3066b;

    public /* synthetic */ g(Object obj, int i10) {
        this.f3065a = i10;
        this.f3066b = obj;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f3065a;
        int i11 = 0;
        Object obj = this.f3066b;
        switch (i10) {
            case 0:
                int i12 = AIEngineApplication.f5748d;
                return ((ModelCacheImpl) obj).getLRUSnapshot();
            case 1:
                bb.d dVar = (bb.d) obj;
                Download download = dVar.f3196a;
                db.a aVar = dVar.f3205n;
                kotlin.jvm.internal.g.c(aVar);
                DownloadInfo downloadInfoA = aVar.a();
                a4.a.w(download, downloadInfoA);
                return downloadInfoA;
            case 2:
                return AbilityBinderImpl.asrSsePcmDumpSink_delegate$lambda$35((AbilityBinderImpl) obj);
            case 3:
                return AbilityInputConverter.decodeImageFromFileContent$lambda$8$lambda$7((FileContent) obj);
            case 4:
                return PowerPerfTracker.onInferStageFromNative$lambda$7((PowerPerfTracker) obj);
            case 5:
                return ((DownloadControlCenter) obj).currentConditions();
            case 6:
                return OtaAtRestDecryptor.resolveForBackend$lambda$5((File) obj);
            case 7:
                return OtaDeepBinderServiceImpl.getAvailableModelsForce$lambda$7((OtaDeepBinderServiceImpl) obj);
            case 8:
                return DeviceConditionMonitor.start$lambda$1$lambda$0((DeviceConditionMonitor) obj);
            case 9:
                db.d dVar2 = (db.d) obj;
                if (!dVar2.f8448p && !dVar2.f8447o && hb.b.a(dVar2.f8440d.f8782a) && dVar2.f8449q > 500) {
                    dVar2.K();
                }
                return n.f10413a;
            case 10:
                return PerformanceOrchestratorImpl.Companion.buildDefault$lambda$3((PerformanceOrchestratorImpl) obj);
            case 11:
                ModelManagerActivity modelManagerActivity = (ModelManagerActivity) obj;
                boolean z = ModelManagerActivity.f5846t;
                if (!modelManagerActivity.isFinishing() && !modelManagerActivity.isDestroyed()) {
                    modelManagerActivity.runOnUiThread(new h6.d(modelManagerActivity, 1));
                }
                return n.f10413a;
            case 12:
                return SystemStateCollector.activityManager_delegate$lambda$0((SystemStateCollector) obj);
            case 13:
                androidx.work.impl.b bVar = (androidx.work.impl.b) obj;
                WorkDatabase workDatabase = bVar.f2879c;
                int i13 = Build.VERSION.SDK_INT;
                Context context = bVar.f2877a;
                String str = l2.c.h;
                if (i13 >= 34) {
                    l2.a.b(context).cancelAll();
                }
                JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
                ArrayList arrayListB = l2.c.b(context, jobScheduler);
                if (arrayListB != null && !arrayListB.isEmpty()) {
                    int size = arrayListB.size();
                    while (i11 < size) {
                        Object obj2 = arrayListB.get(i11);
                        i11++;
                        l2.c.a(jobScheduler, ((JobInfo) obj2).getId());
                    }
                }
                workDatabase.w().l();
                i2.j.b(bVar.f2878b, workDatabase, bVar.f2881e);
                return n.f10413a;
            case 14:
                return PrivacySettingsFragment.onCreatePreferences$lambda$1((PrivacySettingsFragment) obj);
            case 15:
                return b1.O((Object[]) obj);
            case 16:
                return ((Iterable) obj).iterator();
            case 17:
                return ((AbilityBase) obj).buildOrchestrator();
            case 18:
                return rc.h.a("kotlin.Unit", j.d.f11804a, new rc.e[0], new androidx.compose.runtime.g((o0) obj, 22));
            default:
                w1.d dVar3 = (w1.d) obj;
                dVar3.getLifecycle().a(new w1.a(dVar3));
                return n.f10413a;
        }
    }
}
