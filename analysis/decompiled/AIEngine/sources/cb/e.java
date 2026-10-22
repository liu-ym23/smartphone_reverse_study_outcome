package cb;

import android.os.Handler;
import androidx.appcompat.widget.z0;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.deepbinder.OtaInteractiveDownloadFlow;
import com.stepos.core.ota.downloader.Fetch2DownloadEngine;
import com.tonyodev.fetch2.Error;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements ConfirmDecisionBus.DecisionListener {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3324g;
    public final /* synthetic */ Object h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f3325i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f3326j;

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i10) {
        this.f3324g = i10;
        this.h = obj;
        this.f3325i = obj2;
        this.f3326j = obj3;
    }

    public void a(Object obj) {
        switch (this.f3324g) {
            case 0:
                Handler handler = ((i) this.h).f3339d;
                com.stepos.core.ota.downloader.b bVar = (com.stepos.core.ota.downloader.b) this.f3325i;
                com.stepos.core.ota.downloader.a aVar = (com.stepos.core.ota.downloader.a) this.f3326j;
                List result = (List) obj;
                kotlin.jvm.internal.g.f(result, "result");
                if (!result.isEmpty()) {
                    Pair pair = (Pair) kotlin.collections.a.t0(result);
                    if (pair.f9986b == Error.f8155d) {
                        handler.post(new androidx.room.o(2, aVar, pair));
                        break;
                    } else {
                        handler.post(new androidx.appcompat.app.l(4, bVar, pair));
                        break;
                    }
                } else {
                    handler.post(new z0(bVar, 5));
                    break;
                }
            default:
                Fetch2DownloadEngine.getDownloadsInGroup$lambda$4((Ref$ObjectRef) this.h, (CountDownLatch) this.f3325i, (Fetch2DownloadEngine) this.f3326j, (List) obj);
                break;
        }
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
    public void onDecision(ConfirmDecisionBus.Decision decision) {
        OtaInteractiveDownloadFlow.launchUnifiedConfirm$lambda$22((String) this.h, (String) this.f3325i, (zb.l) this.f3326j, decision);
    }
}
