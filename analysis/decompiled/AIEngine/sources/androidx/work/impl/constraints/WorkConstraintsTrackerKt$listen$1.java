package androidx.work.impl.constraints;

import androidx.work.impl.constraints.a;
import java.util.ArrayList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;
import lb.n;
import mb.m;
import rb.c;
import zb.p;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", f = "WorkConstraintsTracker.kt", l = {67}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WorkConstraintsTrackerKt$listen$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2922a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WorkConstraintsTracker f2923b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q2.p f2924c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m2.c f2925d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> implements FlowCollector {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m2.c f2926a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q2.p f2927b;

        public a(m2.c cVar, q2.p pVar) {
            this.f2926a = cVar;
            this.f2927b = pVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, qb.b bVar) {
            this.f2926a.b(this.f2927b, (androidx.work.impl.constraints.a) obj);
            return n.f10413a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTrackerKt$listen$1(WorkConstraintsTracker workConstraintsTracker, q2.p pVar, m2.c cVar, qb.b<? super WorkConstraintsTrackerKt$listen$1> bVar) {
        super(2, bVar);
        this.f2923b = workConstraintsTracker;
        this.f2924c = pVar;
        this.f2925d = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new WorkConstraintsTrackerKt$listen$1(this.f2923b, this.f2924c, this.f2925d, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((WorkConstraintsTrackerKt$listen$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2922a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            WorkConstraintsTracker workConstraintsTracker = this.f2923b;
            workConstraintsTracker.getClass();
            q2.p spec = this.f2924c;
            g.f(spec, "spec");
            ArrayList arrayList = workConstraintsTracker.f2914a;
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj2 = arrayList.get(i11);
                i11++;
                if (((n2.c) obj2).b(spec)) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList(m.Z(arrayList2, 10));
            int size2 = arrayList2.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj3 = arrayList2.get(i12);
                i12++;
                arrayList3.add(((n2.c) obj3).c(spec.f11513j));
            }
            final Flow[] flowArr = (Flow[]) kotlin.collections.a.O0(arrayList3).toArray(new Flow[0]);
            Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<androidx.work.impl.constraints.a>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1

                /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
                @c(c = "androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3", f = "WorkConstraintsTracker.kt", l = {292}, m = "invokeSuspend")
                /* renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3, reason: invalid class name */
                public static final class AnonymousClass3 extends SuspendLambda implements q<FlowCollector<? super a>, a[], qb.b<? super n>, Object> {

                    /* renamed from: a, reason: collision with root package name */
                    public int f2917a;

                    /* renamed from: b, reason: collision with root package name */
                    public /* synthetic */ FlowCollector f2918b;

                    /* renamed from: c, reason: collision with root package name */
                    public /* synthetic */ Object[] f2919c;

                    @Override // zb.q
                    public final Object invoke(FlowCollector<? super a> flowCollector, a[] aVarArr, qb.b<? super n> bVar) {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(3, bVar);
                        anonymousClass3.f2918b = flowCollector;
                        anonymousClass3.f2919c = aVarArr;
                        return anonymousClass3.invokeSuspend(n.f10413a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        a aVar;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                        int i10 = this.f2917a;
                        if (i10 == 0) {
                            kotlin.c.b(obj);
                            FlowCollector flowCollector = this.f2918b;
                            a[] aVarArr = (a[]) this.f2919c;
                            int length = aVarArr.length;
                            int i11 = 0;
                            while (true) {
                                if (i11 >= length) {
                                    aVar = null;
                                    break;
                                }
                                aVar = aVarArr[i11];
                                if (!g.b(aVar, a.C0024a.f2928a)) {
                                    break;
                                }
                                i11++;
                            }
                            if (aVar == null) {
                                aVar = a.C0024a.f2928a;
                            }
                            this.f2917a = 1;
                            if (flowCollector.emit(aVar, this) == coroutineSingletons) {
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

                @Override // kotlinx.coroutines.flow.Flow
                public final Object collect(FlowCollector<? super a> flowCollector, qb.b bVar) {
                    final Flow[] flowArr2 = flowArr;
                    Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new zb.a<a[]>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // zb.a
                        public final a[] invoke() {
                            return new a[flowArr2.length];
                        }
                    }, new AnonymousClass3(3, null), bVar);
                    return objCombineInternal == CoroutineSingletons.f10059a ? objCombineInternal : n.f10413a;
                }
            });
            a aVar = new a(this.f2925d, spec);
            this.f2922a = 1;
            if (flowDistinctUntilChanged.collect(aVar, this) == coroutineSingletons) {
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
