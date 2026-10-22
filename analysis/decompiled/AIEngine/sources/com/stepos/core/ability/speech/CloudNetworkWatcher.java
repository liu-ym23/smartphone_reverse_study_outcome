package com.stepos.core.ability.speech;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudNetworkWatcher {
    public static final CloudNetworkWatcher INSTANCE;
    private static final String TAG = "CloudNetworkWatcher";
    private static final CloudNetworkWatcher$callback$1 callback;
    private static volatile Override internetOverride;
    private static final MutableSharedFlow<lb.n> internetRestored;
    private static volatile boolean lastHasInternet;
    private static volatile boolean lastValidated;
    private static final AtomicBoolean registered;
    private static volatile Override validatedOverride;
    private static final MutableSharedFlow<lb.n> validatedRestored;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Override {
        private final Boolean value;

        public Override(Boolean bool) {
            this.value = bool;
        }

        public final Boolean getValue() {
            return this.value;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.CloudNetworkWatcher$awaitEdge$2", f = "CloudNetworkWatcher.kt", l = {157}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.CloudNetworkWatcher$awaitEdge$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<FlowCollector<? super lb.n>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ zb.a<Boolean> $alreadyThere;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(zb.a<Boolean> aVar, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$alreadyThere = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$alreadyThere, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                if (this.$alreadyThere.invoke().booleanValue()) {
                    lb.n nVar = lb.n.f10413a;
                    this.label = 1;
                    if (flowCollector.emit(nVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super lb.n> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.stepos.core.ability.speech.CloudNetworkWatcher$callback$1] */
    static {
        CloudNetworkWatcher cloudNetworkWatcher = new CloudNetworkWatcher();
        INSTANCE = cloudNetworkWatcher;
        internetRestored = cloudNetworkWatcher.newEdgeFlow();
        validatedRestored = cloudNetworkWatcher.newEdgeFlow();
        registered = new AtomicBoolean(false);
        callback = new ConnectivityManager.NetworkCallback() { // from class: com.stepos.core.ability.speech.CloudNetworkWatcher$callback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities caps) {
                kotlin.jvm.internal.g.f(network, "network");
                kotlin.jvm.internal.g.f(caps, "caps");
                boolean zHasCapability = caps.hasCapability(12);
                boolean z = false;
                boolean z3 = zHasCapability && caps.hasCapability(16);
                boolean z10 = zHasCapability && !CloudNetworkWatcher.lastHasInternet;
                if (z3 && !CloudNetworkWatcher.lastValidated) {
                    z = true;
                }
                CloudNetworkWatcher.lastHasInternet = zHasCapability;
                CloudNetworkWatcher.lastValidated = z3;
                if (z10) {
                    CloudNetworkWatcher.internetRestored.tryEmit(lb.n.f10413a);
                }
                if (z) {
                    CloudNetworkWatcher.validatedRestored.tryEmit(lb.n.f10413a);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                kotlin.jvm.internal.g.f(network, "network");
                CloudNetworkWatcher.lastHasInternet = false;
                CloudNetworkWatcher.lastValidated = false;
            }
        };
    }

    private CloudNetworkWatcher() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitEdge(MutableSharedFlow<lb.n> mutableSharedFlow, zb.a<Boolean> aVar, qb.b<? super lb.n> bVar) {
        ensureRegistered();
        Object objFirst = FlowKt.first(FlowKt.onSubscription(mutableSharedFlow, new AnonymousClass2(aVar, null)), bVar);
        return objFirst == CoroutineSingletons.f10059a ? objFirst : lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean awaitHasInternet$lambda$6() {
        return !INSTANCE.isLinkDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean awaitValidated$lambda$5() {
        return INSTANCE.isValidated();
    }

    private final void ensureRegistered() {
        Object objA;
        Context context;
        if (registered.compareAndSet(false, true)) {
            try {
                context = l7.a.f10344a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            if (context == null) {
                throw new IllegalStateException("ContextHolder must be initialized before use!");
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
            if (connectivityManager == null) {
                throw new IllegalStateException("ConnectivityManager unavailable");
            }
            connectivityManager.registerDefaultNetworkCallback(callback);
            objA = lb.n.f10413a;
            if (objA instanceof Result.Failure) {
                registered.set(false);
                AIEngineLogger.w(LogModule.ABILITY, TAG, "registerDefaultNetworkCallback failed; reconnect backoff will not collapse on recovery");
            }
        }
    }

    private final MutableSharedFlow<lb.n> newEdgeFlow() {
        return SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, null);
    }

    private final Boolean queryCaps(Override override, zb.l<? super NetworkCapabilities, Boolean> lVar) {
        Object objA;
        Context context;
        if (override != null) {
            return override.getValue();
        }
        try {
            context = l7.a.f10344a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (context == null) {
            throw new IllegalStateException("ContextHolder must be initialized before use!");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
        if (connectivityManager == null) {
            throw new IllegalStateException("ConnectivityManager unavailable");
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        NetworkCapabilities networkCapabilities = activeNetwork != null ? connectivityManager.getNetworkCapabilities(activeNetwork) : null;
        objA = Boolean.valueOf(networkCapabilities != null && lVar.invoke(networkCapabilities).booleanValue());
        return (Boolean) (objA instanceof Result.Failure ? null : objA);
    }

    private final Boolean queryHasInternet() {
        return queryCaps(internetOverride, new n0(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean queryHasInternet$lambda$1(NetworkCapabilities caps) {
        kotlin.jvm.internal.g.f(caps, "caps");
        return caps.hasCapability(12);
    }

    private final Boolean queryValidated() {
        return queryCaps(validatedOverride, new v(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean queryValidated$lambda$0(NetworkCapabilities caps) {
        kotlin.jvm.internal.g.f(caps, "caps");
        return caps.hasCapability(12) && caps.hasCapability(16);
    }

    public final Object awaitHasInternet(qb.b<? super lb.n> bVar) {
        Object objAwaitEdge = awaitEdge(internetRestored, new b(2), bVar);
        return objAwaitEdge == CoroutineSingletons.f10059a ? objAwaitEdge : lb.n.f10413a;
    }

    public final Object awaitValidated(qb.b<? super lb.n> bVar) {
        Object objAwaitEdge = awaitEdge(validatedRestored, new a(3), bVar);
        return objAwaitEdge == CoroutineSingletons.f10059a ? objAwaitEdge : lb.n.f10413a;
    }

    public final int internetWaiterCountForTest$ability_release() {
        return internetRestored.getSubscriptionCount().getValue().intValue();
    }

    public final boolean isLinkDown() {
        return kotlin.jvm.internal.g.b(queryHasInternet(), Boolean.FALSE);
    }

    public final boolean isValidated() {
        return kotlin.jvm.internal.g.b(queryValidated(), Boolean.TRUE);
    }

    public final void setInternetOnlyForTest$ability_release() {
        internetOverride = new Override(Boolean.TRUE);
        validatedOverride = new Override(Boolean.FALSE);
    }

    public final void setUnknownForTest$ability_release() {
        internetOverride = new Override(null);
        validatedOverride = new Override(null);
    }

    public final void setValidatedForTest$ability_release(Boolean bool) {
        Override override = bool != null ? new Override(bool) : null;
        internetOverride = override;
        validatedOverride = override;
    }

    public final void signalInternetForTest$ability_release() {
        internetRestored.tryEmit(lb.n.f10413a);
    }

    public final void signalValidatedForTest$ability_release() {
        validatedRestored.tryEmit(lb.n.f10413a);
    }

    public final int waiterCountForTest$ability_release() {
        return validatedRestored.getSubscriptionCount().getValue().intValue();
    }
}
