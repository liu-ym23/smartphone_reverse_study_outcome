package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.a;
import h2.j;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import lb.n;
import o2.g;
import o2.h;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "androidx.work.impl.constraints.controllers.BaseConstraintController$track$1", f = "ContraintControllers.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BaseConstraintController$track$1 extends SuspendLambda implements p<ProducerScope<? super androidx.work.impl.constraints.a>, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2934a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2935b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseConstraintController<T> f2936c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> implements m2.a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseConstraintController<T> f2939a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProducerScope<androidx.work.impl.constraints.a> f2940b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(BaseConstraintController<T> baseConstraintController, ProducerScope<? super androidx.work.impl.constraints.a> producerScope) {
            this.f2939a = baseConstraintController;
            this.f2940b = producerScope;
        }

        @Override // m2.a
        public final void a(T t8) {
            BaseConstraintController<T> baseConstraintController = this.f2939a;
            this.f2940b.getChannel().mo149trySendJP2dKIU(baseConstraintController.e(t8) ? new a.b(baseConstraintController.d()) : a.C0024a.f2928a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseConstraintController$track$1(BaseConstraintController<T> baseConstraintController, b<? super BaseConstraintController$track$1> bVar) {
        super(2, bVar);
        this.f2936c = baseConstraintController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        BaseConstraintController$track$1 baseConstraintController$track$1 = new BaseConstraintController$track$1(this.f2936c, bVar);
        baseConstraintController$track$1.f2935b = obj;
        return baseConstraintController$track$1;
    }

    @Override // zb.p
    public final Object invoke(ProducerScope<? super androidx.work.impl.constraints.a> producerScope, b<? super n> bVar) {
        return ((BaseConstraintController$track$1) create(producerScope, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2934a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            ProducerScope producerScope = (ProducerScope) this.f2935b;
            BaseConstraintController<T> baseConstraintController = this.f2936c;
            final a aVar = new a(baseConstraintController, producerScope);
            g<T> gVar = baseConstraintController.f2933a;
            gVar.getClass();
            synchronized (gVar.f10723c) {
                try {
                    if (gVar.f10724d.add(aVar)) {
                        if (gVar.f10724d.size() == 1) {
                            gVar.f10725e = gVar.a();
                            j.d().a(h.f10726a, gVar.getClass().getSimpleName() + ": initial state = " + gVar.f10725e);
                            gVar.c();
                        }
                        aVar.a(gVar.f10725e);
                    }
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            final BaseConstraintController<T> baseConstraintController2 = this.f2936c;
            zb.a<n> aVar2 = new zb.a<n>() { // from class: androidx.work.impl.constraints.controllers.BaseConstraintController$track$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // zb.a
                public final n invoke() {
                    g<T> gVar2 = baseConstraintController2.f2933a;
                    Object obj2 = aVar;
                    gVar2.getClass();
                    synchronized (gVar2.f10723c) {
                        if (gVar2.f10724d.remove(obj2) && gVar2.f10724d.isEmpty()) {
                            gVar2.d();
                        }
                    }
                    return n.f10413a;
                }
            };
            this.f2934a = 1;
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
