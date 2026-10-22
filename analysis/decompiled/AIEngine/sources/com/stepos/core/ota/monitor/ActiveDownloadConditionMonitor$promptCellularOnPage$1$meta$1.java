package com.stepos.core.ota.monitor;

import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor;
import com.stepos.core.ota.process.OtaRuntime;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor$promptCellularOnPage$1$meta$1", f = "ActiveDownloadConditionMonitor.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ActiveDownloadConditionMonitor$promptCellularOnPage$1$meta$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super Pair<? extends Integer, ? extends ActiveDownloadConditionMonitor.ReminderMeta>>, Object> {
    final /* synthetic */ String $otaId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveDownloadConditionMonitor$promptCellularOnPage$1$meta$1(String str, qb.b<? super ActiveDownloadConditionMonitor$promptCellularOnPage$1$meta$1> bVar) {
        super(2, bVar);
        this.$otaId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        ActiveDownloadConditionMonitor$promptCellularOnPage$1$meta$1 activeDownloadConditionMonitor$promptCellularOnPage$1$meta$1 = new ActiveDownloadConditionMonitor$promptCellularOnPage$1$meta$1(this.$otaId, bVar);
        activeDownloadConditionMonitor$promptCellularOnPage$1$meta$1.L$0 = obj;
        return activeDownloadConditionMonitor$promptCellularOnPage$1$meta$1;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, qb.b<? super Pair<? extends Integer, ? extends ActiveDownloadConditionMonitor.ReminderMeta>> bVar) {
        return invoke2(coroutineScope, (qb.b<? super Pair<Integer, ActiveDownloadConditionMonitor.ReminderMeta>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        OtaStateSnapshot otaStateSnapshot = OtaRuntime.INSTANCE.snapshot().get(this.$otaId);
        int installedVersion = otaStateSnapshot != null ? otaStateSnapshot.getInstalledVersion() : 0;
        String str = this.$otaId;
        try {
            l<String, ActiveDownloadConditionMonitor.ReminderMeta> reminderMetaProvider = ActiveDownloadConditionMonitor.INSTANCE.getReminderMetaProvider();
            objA = reminderMetaProvider != null ? (ActiveDownloadConditionMonitor.ReminderMeta) reminderMetaProvider.invoke(str) : null;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Pair(new Integer(installedVersion), (ActiveDownloadConditionMonitor.ReminderMeta) (objA instanceof Result.Failure ? null : objA));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, qb.b<? super Pair<Integer, ActiveDownloadConditionMonitor.ReminderMeta>> bVar) {
        return ((ActiveDownloadConditionMonitor$promptCellularOnPage$1$meta$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
