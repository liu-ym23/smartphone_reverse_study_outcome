package com.stepos.core.ota.process;

import com.stepos.core.ota.IOtaProcessControl;
import com.stepos.core.ota.IOtaTaskListener;
import com.stepos.core.ota.OtaContainer;
import com.stepos.core.ota.OtaDispatcher;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.PauseReason;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import dc.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.collections.EmptySet;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import lb.n;
import mb.l;
import mb.m;
import mb.x;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaProcessControlBinder extends IOtaProcessControl.Stub {
    private volatile IOtaTaskListener listener;
    private volatile boolean observing;
    private volatile zb.a<n> onShutdownRequested;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    private volatile Map<String, Integer> lastEmitted = kotlin.collections.b.d0();
    private volatile Set<String> previousSnapKeys = EmptySet.f10003a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.process.OtaProcessControlBinder$startObserving$1", f = "OtaProcessControlBinder.kt", l = {ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.process.OtaProcessControlBinder$startObserving$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = OtaProcessControlBinder.this.new AnonymousClass1(bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                StateFlow<Map<String, OtaStateSnapshot>> state = OtaContainer.INSTANCE.getState();
                final OtaProcessControlBinder otaProcessControlBinder = OtaProcessControlBinder.this;
                FlowCollector<? super Map<String, OtaStateSnapshot>> flowCollector = new FlowCollector() { // from class: com.stepos.core.ota.process.OtaProcessControlBinder.startObserving.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, qb.b bVar) {
                        return emit((Map<String, OtaStateSnapshot>) obj2, (qb.b<? super n>) bVar);
                    }

                    public final Object emit(Map<String, OtaStateSnapshot> map, qb.b<? super n> bVar) {
                        IOtaTaskListener iOtaTaskListener = otaProcessControlBinder.listener;
                        if (iOtaTaskListener == null) {
                            return n.f10413a;
                        }
                        Set<String> setT = x.T(otaProcessControlBinder.previousSnapKeys, map.keySet());
                        otaProcessControlBinder.previousSnapKeys = kotlin.collections.a.R0(map.keySet());
                        for (String str : setT) {
                            OtaProcessControlBinder otaProcessControlBinder2 = otaProcessControlBinder;
                            otaProcessControlBinder2.lastEmitted = kotlin.collections.b.h0(str, otaProcessControlBinder2.lastEmitted);
                            try {
                                iOtaTaskListener.onTaskUpdate(str, OtaStateCodec.INSTANCE.stateOrdinal(OtaState.Removed.INSTANCE), 0, 0, 0L, 0L, new int[0], false);
                                n nVar = n.f10413a;
                            } catch (Throwable th) {
                                kotlin.c.a(th);
                            }
                        }
                        OtaProcessControlBinder otaProcessControlBinder3 = otaProcessControlBinder;
                        for (Map.Entry<String, OtaStateSnapshot> entry : map.entrySet()) {
                            String key = entry.getKey();
                            OtaStateSnapshot value = entry.getValue();
                            int iStateOrdinal = OtaStateCodec.INSTANCE.stateOrdinal(value.getState());
                            int progress = value.getProgress() + (iStateOrdinal * 1000);
                            Integer num = (Integer) otaProcessControlBinder3.lastEmitted.get(key);
                            if (num == null || num.intValue() != progress) {
                                otaProcessControlBinder3.lastEmitted = kotlin.collections.b.k0(otaProcessControlBinder3.lastEmitted, new Pair(key, new Integer(progress)));
                                otaProcessControlBinder3.emit(iOtaTaskListener, key, iStateOrdinal, value);
                            }
                        }
                        return n.f10413a;
                    }
                };
                this.label = 1;
                if (state.collect(flowCollector, this) == coroutineSingletons) {
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
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private final OtaDispatcher dispatcher() {
        return OtaContainer.INSTANCE.getDispatcher();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void emit(IOtaTaskListener iOtaTaskListener, String str, int i10, OtaStateSnapshot otaStateSnapshot) {
        Pair pair;
        OtaState state = otaStateSnapshot.getState();
        if (state instanceof OtaState.Downloading) {
            OtaState.Downloading downloading = (OtaState.Downloading) state;
            pair = new Pair(Long.valueOf(downloading.getDownloadedBytes()), Long.valueOf(downloading.getTotalBytes()));
        } else {
            pair = new Pair(0L, 0L);
        }
        long jLongValue = ((Number) pair.f9985a).longValue();
        long jLongValue2 = ((Number) pair.f9986b).longValue();
        Set<TriggerSource> sources = otaStateSnapshot.getSources();
        ArrayList arrayList = new ArrayList(m.Z(sources, 10));
        Iterator<T> it = sources.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((TriggerSource) it.next()).ordinal()));
        }
        try {
            iOtaTaskListener.onTaskUpdate(str, i10, otaStateSnapshot.getProgress(), otaStateSnapshot.getInstalledVersion(), jLongValue, jLongValue2, kotlin.collections.a.N0(arrayList), otaStateSnapshot.getCellularAllowed());
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public boolean attachSource(String abilityId, int i10) {
        g.f(abilityId, "abilityId");
        return dispatcher().attach(abilityId, TriggerSource.getEntries().get(h.a0(i10, 0, m.a0(TriggerSource.getEntries()))));
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public boolean cancel(String abilityId) {
        g.f(abilityId, "abilityId");
        return dispatcher().cancel(abilityId);
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public boolean checkUpdate(String abilityId, int i10) {
        g.f(abilityId, "abilityId");
        return dispatcher().checkUpdate(abilityId, TriggerSource.getEntries().get(h.a0(i10, 0, m.a0(TriggerSource.getEntries()))));
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public boolean detach(String abilityId, String clientTag) {
        g.f(abilityId, "abilityId");
        g.f(clientTag, "clientTag");
        return dispatcher().detach(abilityId, clientTag);
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public boolean download(String abilityId, int i10, String str, String[] strArr, boolean z) {
        Set<String> setS0;
        g.f(abilityId, "abilityId");
        OtaDispatcher otaDispatcherDispatcher = dispatcher();
        TriggerSource triggerSource = TriggerSource.getEntries().get(h.a0(i10, 0, m.a0(TriggerSource.getEntries())));
        if (strArr == null || (setS0 = l.s0(strArr)) == null) {
            setS0 = EmptySet.f10003a;
        }
        return otaDispatcherDispatcher.download(abilityId, triggerSource, str, setS0, z);
    }

    public final zb.a<n> getOnShutdownRequested() {
        return this.onShutdownRequested;
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public int getProgress(String abilityId) {
        g.f(abilityId, "abilityId");
        OtaStateSnapshot otaStateSnapshot = OtaContainer.INSTANCE.snapshot().get(OtaEngine.INSTANCE.resolveAnyToOta(abilityId));
        if (otaStateSnapshot != null) {
            return otaStateSnapshot.getProgress();
        }
        return 0;
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public int getStatus(String abilityId) {
        OtaState state;
        g.f(abilityId, "abilityId");
        OtaStateSnapshot otaStateSnapshot = OtaContainer.INSTANCE.snapshot().get(OtaEngine.INSTANCE.resolveAnyToOta(abilityId));
        if (otaStateSnapshot == null || (state = otaStateSnapshot.getState()) == null) {
            return 0;
        }
        OtaStateCodec otaStateCodec = OtaStateCodec.INSTANCE;
        return otaStateCodec.toDownloadState(otaStateCodec.stateOrdinal(state));
    }

    public final void notifyIdleExitRequested() {
        try {
            IOtaTaskListener iOtaTaskListener = this.listener;
            if (iOtaTaskListener != null) {
                iOtaTaskListener.onIdleExitRequested();
                n nVar = n.f10413a;
            }
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public boolean pause(String abilityId) {
        g.f(abilityId, "abilityId");
        return OtaDispatcher.DefaultImpls.pause$default(dispatcher(), abilityId, null, 2, null);
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public boolean pauseWithReason(String abilityId, int i10) {
        g.f(abilityId, "abilityId");
        return dispatcher().pause(abilityId, PauseReason.getEntries().get(h.a0(i10, 0, m.a0(PauseReason.getEntries()))));
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public void requestShutdownPersisting() {
        try {
            zb.a<n> aVar = this.onShutdownRequested;
            if (aVar != null) {
                aVar.invoke();
                n nVar = n.f10413a;
            }
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public boolean resume(String abilityId, int i10) {
        g.f(abilityId, "abilityId");
        return dispatcher().resume(abilityId, TriggerSource.getEntries().get(h.a0(i10, 0, m.a0(TriggerSource.getEntries()))));
    }

    public final void setOnShutdownRequested(zb.a<n> aVar) {
        this.onShutdownRequested = aVar;
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public void setTaskListener(IOtaTaskListener iOtaTaskListener) {
        this.listener = iOtaTaskListener;
        this.lastEmitted = kotlin.collections.b.d0();
        if (iOtaTaskListener != null) {
            for (Map.Entry<String, OtaStateSnapshot> entry : OtaContainer.INSTANCE.snapshot().entrySet()) {
                String key = entry.getKey();
                OtaStateSnapshot value = entry.getValue();
                int iStateOrdinal = OtaStateCodec.INSTANCE.stateOrdinal(value.getState());
                this.lastEmitted = kotlin.collections.b.k0(this.lastEmitted, new Pair(key, Integer.valueOf(value.getProgress() + (iStateOrdinal * 1000))));
                emit(iOtaTaskListener, key, iStateOrdinal, value);
            }
        }
    }

    public final void startObserving() {
        if (this.observing) {
            return;
        }
        this.observing = true;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // com.stepos.core.ota.IOtaProcessControl
    public void syncAbilityMappings(String mappingsJson) {
        g.f(mappingsJson, "mappingsJson");
        OtaEngine.INSTANCE.rebuildMappingsFromCache();
    }
}
