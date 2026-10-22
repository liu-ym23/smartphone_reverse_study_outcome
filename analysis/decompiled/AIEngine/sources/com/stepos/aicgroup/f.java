package com.stepos.aicgroup;

import android.content.Context;
import com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator;
import com.stepos.core.cta.CtaGateManager;
import com.stepos.core.model.task.AITaskRecord;
import com.stepos.core.model.task.AITaskSupervisor;
import com.stepos.core.ota.IOtaProcessControl;
import com.stepos.core.ota.confirmui.ConfirmUiRequest;
import com.stepos.core.ota.confirmui.InProcessConfirmHost;
import com.stepos.core.ota.confirmui.OtaAlertDialog;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.process.OtaProcessClient;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5694a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5695b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5696c;

    public /* synthetic */ f(int i10, Object obj, Object obj2) {
        this.f5694a = i10;
        this.f5695b = obj;
        this.f5696c = obj2;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f5694a) {
            case 0:
                PausableCoroutineDispatcher pausableCoroutineDispatcher = (PausableCoroutineDispatcher) this.f5695b;
                pausableCoroutineDispatcher.f5659l.remove((Job) this.f5696c);
                return n.f10413a;
            case 1:
                return AsrRealtimeBinderCoordinator.ensureReorderBuffer$lambda$4((AsrRealtimeBinderCoordinator) this.f5695b, (String) this.f5696c, (String) obj);
            case 2:
                return CtaGateManager.runWhenGranted$lambda$4((String) this.f5695b, (zb.a) this.f5696c, (Context) obj);
            case 3:
                return AITaskSupervisor.handleTaskCompletion$lambda$20((AITaskRecord) this.f5695b, (TimeoutCancellationException) this.f5696c, (p6.g) obj);
            case 4:
                return AITaskSupervisor.handleTaskCompletion$lambda$23((AITaskRecord) this.f5695b, (Throwable) this.f5696c, (p6.g) obj);
            case 5:
                return InProcessConfirmHost.showOnActivity$lambda$2((InProcessConfirmHost) this.f5695b, (ConfirmUiRequest) this.f5696c, (OtaAlertDialog) obj);
            default:
                return Boolean.valueOf(OtaProcessClient.resume$lambda$16((String) this.f5695b, (TriggerSource) this.f5696c, (IOtaProcessControl) obj));
        }
    }
}
