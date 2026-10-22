package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import h2.j;
import java.util.LinkedHashMap;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import lb.n;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1", f = "WorkConstraintsTracker.kt", l = {178}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class NetworkRequestConstraintController$track$1 extends SuspendLambda implements p<ProducerScope<? super a>, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2901a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2902b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h2.c f2903c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ NetworkRequestConstraintController f2904d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkRequestConstraintController$track$1(h2.c cVar, NetworkRequestConstraintController networkRequestConstraintController, qb.b<? super NetworkRequestConstraintController$track$1> bVar) {
        super(2, bVar);
        this.f2903c = cVar;
        this.f2904d = networkRequestConstraintController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        NetworkRequestConstraintController$track$1 networkRequestConstraintController$track$1 = new NetworkRequestConstraintController$track$1(this.f2903c, this.f2904d, bVar);
        networkRequestConstraintController$track$1.f2902b = obj;
        return networkRequestConstraintController$track$1;
    }

    @Override // zb.p
    public final Object invoke(ProducerScope<? super a> producerScope, qb.b<? super n> bVar) {
        return ((NetworkRequestConstraintController$track$1) create(producerScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2901a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f2902b;
            final NetworkRequest networkRequestA = this.f2903c.a();
            if (networkRequestA == null) {
                SendChannel.DefaultImpls.close$default(producerScope.getChannel(), null, 1, null);
                return n.f10413a;
            }
            final Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new NetworkRequestConstraintController$track$1$timeoutJob$1(this.f2904d, producerScope, null), 3, null);
            l<a, n> lVar = new l<a, n>() { // from class: androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$onConstraintState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // zb.l
                public final n invoke(a aVar) {
                    a it = aVar;
                    g.f(it, "it");
                    Job.DefaultImpls.cancel$default(jobLaunch$default, null, 1, null);
                    producerScope.mo149trySendJP2dKIU(it);
                    return n.f10413a;
                }
            };
            final b bVar = b.f2930a;
            final ConnectivityManager connectivityManager = this.f2904d.f2900a;
            bVar.getClass();
            synchronized (b.f2931b) {
                try {
                    LinkedHashMap linkedHashMap = b.f2932c;
                    boolean zIsEmpty = linkedHashMap.isEmpty();
                    linkedHashMap.put(networkRequestA, lVar);
                    if (zIsEmpty) {
                        j.d().a(WorkConstraintsTrackerKt.f2921a, "NetworkRequestConstraintController register shared callback");
                        connectivityManager.registerDefaultNetworkCallback(bVar);
                    }
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            final zb.a<n> aVar = new zb.a<n>() { // from class: androidx.work.impl.constraints.SharedNetworkCallback$addCallback$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // zb.a
                public final n invoke() {
                    Object obj2 = b.f2931b;
                    NetworkRequest networkRequest = networkRequestA;
                    ConnectivityManager connectivityManager2 = connectivityManager;
                    b bVar2 = bVar;
                    synchronized (obj2) {
                        LinkedHashMap linkedHashMap2 = b.f2932c;
                        linkedHashMap2.remove(networkRequest);
                        if (linkedHashMap2.isEmpty()) {
                            j.d().a(WorkConstraintsTrackerKt.f2921a, "NetworkRequestConstraintController unregister shared callback");
                            connectivityManager2.unregisterNetworkCallback(bVar2);
                        }
                    }
                    return n.f10413a;
                }
            };
            zb.a<n> aVar2 = new zb.a<n>() { // from class: androidx.work.impl.constraints.NetworkRequestConstraintController$track$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // zb.a
                public final n invoke() {
                    aVar.invoke();
                    return n.f10413a;
                }
            };
            this.f2901a = 1;
            if (ProduceKt.awaitClose(producerScope, aVar2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return n.f10413a;
    }
}
