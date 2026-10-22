package com.stepos.aiengine.modelmanager;

import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.deepbinder.IOtaTaskStateCallback;
import h6.w;
import h6.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.aiengine.modelmanager.OtaModelClient$taskStateFlow$1", f = "OtaModelClient.kt", l = {731}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OtaModelClient$taskStateFlow$1 extends SuspendLambda implements p<ProducerScope<? super Map<String, ? extends x>>, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f5887a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f5888b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements IOtaTaskStateCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap<String, x> f5889a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProducerScope<Map<String, x>> f5890b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ConcurrentHashMap<String, x> concurrentHashMap, ProducerScope<? super Map<String, x>> producerScope) {
            this.f5889a = concurrentHashMap;
            this.f5890b = producerScope;
        }

        @Override // com.stepos.core.deepbinder.IOtaTaskStateCallback
        public final void onRecycle() {
            SendChannel.DefaultImpls.close$default(this.f5890b, null, 1, null);
        }

        @Override // com.stepos.core.deepbinder.IOtaTaskStateCallback
        public final void onTaskState(String otaId, int i10, int i11, int i12) {
            g.f(otaId, "otaId");
            w.f9354a.getClass();
            x xVar = new x(otaId, i10, i11, i12, !w.b(otaId));
            ConcurrentHashMap<String, x> concurrentHashMap = this.f5889a;
            concurrentHashMap.put(otaId, xVar);
            this.f5890b.mo149trySendJP2dKIU(new HashMap(concurrentHashMap));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        OtaModelClient$taskStateFlow$1 otaModelClient$taskStateFlow$1 = new OtaModelClient$taskStateFlow$1(2, bVar);
        otaModelClient$taskStateFlow$1.f5888b = obj;
        return otaModelClient$taskStateFlow$1;
    }

    @Override // zb.p
    public final Object invoke(ProducerScope<? super Map<String, ? extends x>> producerScope, b<? super n> bVar) {
        return ((OtaModelClient$taskStateFlow$1) create(producerScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f5887a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f5888b;
            final IOtaDeepBinderService iOtaDeepBinderServiceK = OtaModelClient.f5871a.k();
            if (iOtaDeepBinderServiceK == null) {
                SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                return n.f10413a;
            }
            final a aVar = new a(new ConcurrentHashMap(), producerScope);
            try {
                iOtaDeepBinderServiceK.registerTaskStateCallback(aVar);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                producerScope.close(thB);
            }
            zb.a aVar2 = new zb.a() { // from class: h6.v
                @Override // zb.a
                public final Object invoke() {
                    try {
                        iOtaDeepBinderServiceK.unregisterTaskStateCallback(aVar);
                        lb.n nVar = lb.n.f10413a;
                    } catch (Throwable th2) {
                        kotlin.c.a(th2);
                    }
                    return lb.n.f10413a;
                }
            };
            this.f5887a = 1;
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
