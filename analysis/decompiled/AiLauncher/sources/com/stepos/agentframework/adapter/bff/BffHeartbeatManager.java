package com.stepos.agentframework.adapter.bff;

import Ua.AbstractC1067l0;
import Ua.C1060i;
import Ua.C1071n0;
import Ua.C1073o0;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffHeartbeatManager;", "", "Lkotlin/Function0;", "LY8/t;", "onSendHeartbeat", "onRemoveNullCallbacks", "<init>", "(Lp9/a;Lp9/a;)V", "", "intervalMs", "e", "(J)V", Const.INTENT_KEY_UMID, "()V", "Lp9/a;", "Lkotlinx/coroutines/g;", "heartJob", "Lkotlinx/coroutines/g;", "heartTimeout", "J", "LUa/l0;", "heartPool", "LUa/l0;", "Companion", Const.INTENT_KEY_APIKEY, "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BffHeartbeatManager {
    private static final long MIN_HEART_TIMEOUT = 10000;
    private kotlinx.coroutines.g heartJob;
    private final AbstractC1067l0 heartPool;
    private long heartTimeout;
    private final InterfaceC5063a<Y8.t> onRemoveNullCallbacks;
    private final InterfaceC5063a<Y8.t> onSendHeartbeat;

    public BffHeartbeatManager(InterfaceC5063a<Y8.t> onSendHeartbeat, InterfaceC5063a<Y8.t> onRemoveNullCallbacks) {
        kotlin.jvm.internal.p.i(onSendHeartbeat, "onSendHeartbeat");
        kotlin.jvm.internal.p.i(onRemoveNullCallbacks, "onRemoveNullCallbacks");
        this.onSendHeartbeat = onSendHeartbeat;
        this.onRemoveNullCallbacks = onRemoveNullCallbacks;
        this.heartTimeout = 10000L;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        kotlin.jvm.internal.p.h(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.heartPool = C1071n0.c(executorServiceNewSingleThreadExecutor);
    }

    public final void d() {
        kotlinx.coroutines.g gVar = this.heartJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.heartJob = C1060i.d(C1073o0.f6391a, this.heartPool, null, new BffHeartbeatManager$scheduleNext$1(this, null), 2, null);
    }

    public final void e(long intervalMs) {
        if (intervalMs < 10000) {
            this.heartTimeout = 10000L;
        } else {
            this.heartTimeout = intervalMs;
        }
    }
}
