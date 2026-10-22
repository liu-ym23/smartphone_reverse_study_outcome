package androidx.lifecycle;

import androidx.activity.OnBackPressedDispatcher;
import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import com.stepos.aiengine.modelmanager.settings.AiEngineSettingsFragment;
import com.stepos.core.ability.converter.AbilityInputConverter;
import com.stepos.core.data.FileContent;
import com.stepos.core.model.ModelLifecycleImpl;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.model.task.AITaskSupervisor;
import com.stepos.core.ota.download.control.DownloadControlCenter;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.database.DownloadInfo;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class j0 implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2276a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2277b;

    public /* synthetic */ j0(Object obj, int i10) {
        this.f2276a = i10;
        this.f2277b = obj;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f2276a;
        Object obj = this.f2277b;
        switch (i10) {
            case 0:
                return i0.c((t0) obj);
            case 1:
                ((OnBackPressedDispatcher) obj).b();
                return lb.n.f10413a;
            case 2:
                bb.c cVar = (bb.c) obj;
                Download download = cVar.f3176a;
                db.a aVar = cVar.f3186o;
                kotlin.jvm.internal.g.c(aVar);
                DownloadInfo downloadInfoA = aVar.a();
                a4.a.w(download, downloadInfoA);
                return downloadInfoA;
            case 3:
                return AbilityInputConverter.decodeImageFromFileContent$lambda$9((FileContent) obj);
            case 4:
                return Long.valueOf(ModelCacheImpl.deviceTotalRamMb_delegate$lambda$69((ModelCacheImpl) obj));
            case 5:
                return AITaskSupervisor.inferenceExecutor_delegate$lambda$0((AITaskSupervisor) obj);
            case 6:
                return DownloadControlCenter.thermalStrategy$lambda$1((DownloadControlCenter) obj);
            case 7:
                return obj;
            case 8:
                return ((ModelManagerFragment) obj).getActivity();
            case 9:
                i2.n nVar = (i2.n) obj;
                nVar.getClass();
                r2.a.a(nVar);
                return lb.n.f10413a;
            case 10:
                return AiEngineSettingsFragment.onCreatePreferences$lambda$1((AiEngineSettingsFragment) obj);
            case 11:
                rc.f fVar = (rc.f) obj;
                return Integer.valueOf(tc.p0.d(fVar, fVar.f11795k));
            default:
                return Boolean.valueOf(ModelLifecycleImpl.init$lambda$2((ModelLifecycleImpl) obj));
        }
    }
}
