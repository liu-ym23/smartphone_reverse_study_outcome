package com.stepos.core.ota.bridge;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.deepbinder.IOtaTaskStateCallback;
import com.stepos.core.ota.data.DownloadStateKt;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.process.OtaRuntime;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.collections.a;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import lb.n;
import mb.x;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.bridge.OtaTaskStateBroadcaster$ensureStarted$1$1", f = "OtaTaskStateBroadcaster.kt", l = {60}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OtaTaskStateBroadcaster$ensureStarted$1$1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public OtaTaskStateBroadcaster$ensureStarted$1$1(b<? super OtaTaskStateBroadcaster$ensureStarted$1$1> bVar) {
        super(2, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        OtaTaskStateBroadcaster$ensureStarted$1$1 otaTaskStateBroadcaster$ensureStarted$1$1 = new OtaTaskStateBroadcaster$ensureStarted$1$1(bVar);
        otaTaskStateBroadcaster$ensureStarted$1$1.L$0 = obj;
        return otaTaskStateBroadcaster$ensureStarted$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            StateFlow<Map<String, OtaStateSnapshot>> stateFlowTaskStateFlow = OtaRuntime.INSTANCE.taskStateFlow();
            FlowCollector<? super Map<String, OtaStateSnapshot>> flowCollector = new FlowCollector() { // from class: com.stepos.core.ota.bridge.OtaTaskStateBroadcaster$ensureStarted$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, b bVar) {
                    return emit((Map<String, OtaStateSnapshot>) obj2, (b<? super n>) bVar);
                }

                public final Object emit(Map<String, OtaStateSnapshot> map, b<? super n> bVar) {
                    Object objA;
                    Set setKeySet = OtaTaskStateBroadcaster.lastSig.keySet();
                    g.e(setKeySet, "<get-keys>(...)");
                    for (String str : x.T(a.R0(setKeySet), map.keySet())) {
                        OtaTaskStateBroadcaster.lastSig.remove(str);
                        for (Map.Entry entry : OtaTaskStateBroadcaster.callbacks.entrySet()) {
                            String str2 = (String) entry.getKey();
                            try {
                                ((IOtaTaskStateCallback) entry.getValue()).onTaskState(str, 7, 0, 0);
                                objA = n.f10413a;
                            } catch (Throwable th) {
                                objA = kotlin.c.a(th);
                            }
                            if (objA instanceof Result.Failure) {
                                AIEngineLogger.w(LogModule.OTA, "OtaTaskStateBroadcaster", "callback dead on removal, removing: " + str2);
                                OtaTaskStateBroadcaster.callbacks.remove(str2);
                            }
                        }
                    }
                    for (OtaStateSnapshot otaStateSnapshot : map.values()) {
                        int progress = otaStateSnapshot.getProgress() + (DownloadStateKt.toDownloadStateCode(otaStateSnapshot.getState()) * 1000);
                        Integer num = (Integer) OtaTaskStateBroadcaster.lastSig.get(otaStateSnapshot.getOtaId());
                        if (num == null || num.intValue() != progress) {
                            OtaTaskStateBroadcaster.lastSig.put(otaStateSnapshot.getOtaId(), new Integer(progress));
                            for (Map.Entry entry2 : OtaTaskStateBroadcaster.callbacks.entrySet()) {
                                String str3 = (String) entry2.getKey();
                                if (!OtaTaskStateBroadcaster.INSTANCE.dispatch((IOtaTaskStateCallback) entry2.getValue(), otaStateSnapshot)) {
                                    AIEngineLogger.w(LogModule.OTA, "OtaTaskStateBroadcaster", "callback dead, removing: " + str3);
                                    OtaTaskStateBroadcaster.callbacks.remove(str3);
                                }
                            }
                        }
                    }
                    return n.f10413a;
                }
            };
            this.label = 1;
            if (stateFlowTaskStateFlow.collect(flowCollector, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((OtaTaskStateBroadcaster$ensureStarted$1$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
