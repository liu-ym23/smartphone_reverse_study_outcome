package com.stepos.core.ota.monitor;

import android.content.Context;
import android.widget.Toast;
import com.stepos.core.common.R;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor$onNoNetwork$2$1", f = "ActiveDownloadConditionMonitor.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ActiveDownloadConditionMonitor$onNoNetwork$2$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
    final /* synthetic */ Context $ctx;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveDownloadConditionMonitor$onNoNetwork$2$1(Context context, qb.b<? super ActiveDownloadConditionMonitor$onNoNetwork$2$1> bVar) {
        super(2, bVar);
        this.$ctx = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        ActiveDownloadConditionMonitor$onNoNetwork$2$1 activeDownloadConditionMonitor$onNoNetwork$2$1 = new ActiveDownloadConditionMonitor$onNoNetwork$2$1(this.$ctx, bVar);
        activeDownloadConditionMonitor$onNoNetwork$2$1.L$0 = obj;
        return activeDownloadConditionMonitor$onNoNetwork$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        try {
            Toast.makeText(this.$ctx, R.string.mdl_dl_no_network_toast, 0).show();
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((ActiveDownloadConditionMonitor$onNoNetwork$2$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
