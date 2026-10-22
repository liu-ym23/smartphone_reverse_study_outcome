package androidx.slidingpanelayout.widget;

import android.app.Activity;
import android.view.animation.PathInterpolator;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import androidx.window.layout.f;
import d2.m;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", l = {97}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2592a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.slidingpanelayout.widget.a f2593b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f2594c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements FlowCollector<f> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.slidingpanelayout.widget.a f2595a;

        public a(androidx.slidingpanelayout.widget.a aVar) {
            this.f2595a = aVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(f fVar, b<? super n> bVar) {
            n nVar;
            f fVar2 = fVar;
            SlidingPaneLayout.a aVar = this.f2595a.f2627d;
            if (aVar == null) {
                nVar = null;
            } else {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f2615y = fVar2;
                d2.b bVar2 = new d2.b();
                bVar2.f8284c = 300L;
                bVar2.f8285d = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
                m.a(slidingPaneLayout, bVar2);
                slidingPaneLayout.requestLayout();
                nVar = n.f10413a;
            }
            return nVar == CoroutineSingletons.f10059a ? nVar : n.f10413a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldingFeatureObserver$registerLayoutStateChangeCallback$1(androidx.slidingpanelayout.widget.a aVar, Activity activity, b<? super FoldingFeatureObserver$registerLayoutStateChangeCallback$1> bVar) {
        super(2, bVar);
        this.f2593b = aVar;
        this.f2594c = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this.f2593b, this.f2594c, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((FoldingFeatureObserver$registerLayoutStateChangeCallback$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2592a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            final androidx.slidingpanelayout.widget.a aVar = this.f2593b;
            final Flow<androidx.window.layout.m> flowA = aVar.f2624a.a(this.f2594c);
            Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<f>() { // from class: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1

                /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
                /* renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                public static final class AnonymousClass2 implements FlowCollector<androidx.window.layout.m> {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ FlowCollector f2587a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ a f2588b;

                    @c(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "FoldingFeatureObserver.kt", l = {138}, m = "emit")
                    /* renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: a, reason: collision with root package name */
                        public /* synthetic */ Object f2589a;

                        /* renamed from: b, reason: collision with root package name */
                        public int f2590b;

                        public AnonymousClass1(b bVar) {
                            super(bVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f2589a = obj;
                            this.f2590b |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, a aVar) {
                        this.f2587a = flowCollector;
                        this.f2588b = aVar;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    /* JADX WARN: Type inference failed for: r7v4 */
                    /* JADX WARN: Type inference failed for: r7v5 */
                    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(androidx.window.layout.m r6, qb.b r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f2590b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f2590b = r1
                            goto L18
                        L13:
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.f2589a
                            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                            int r2 = r0.f2590b
                            r3 = 1
                            if (r2 == 0) goto L2f
                            if (r2 != r3) goto L27
                            kotlin.c.b(r7)
                            goto L68
                        L27:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L2f:
                            kotlin.c.b(r7)
                            androidx.window.layout.m r6 = (androidx.window.layout.m) r6
                            androidx.slidingpanelayout.widget.a r7 = r5.f2588b
                            r7.getClass()
                            java.util.List<androidx.window.layout.a> r6 = r6.f2757a
                            java.util.Iterator r6 = r6.iterator()
                        L3f:
                            boolean r7 = r6.hasNext()
                            r2 = 0
                            if (r7 == 0) goto L52
                            java.lang.Object r7 = r6.next()
                            r4 = r7
                            androidx.window.layout.a r4 = (androidx.window.layout.a) r4
                            boolean r4 = r4 instanceof androidx.window.layout.f
                            if (r4 == 0) goto L3f
                            goto L53
                        L52:
                            r7 = r2
                        L53:
                            boolean r6 = r7 instanceof androidx.window.layout.f
                            if (r6 == 0) goto L5a
                            r2 = r7
                            androidx.window.layout.f r2 = (androidx.window.layout.f) r2
                        L5a:
                            if (r2 != 0) goto L5d
                            goto L68
                        L5d:
                            r0.f2590b = r3
                            kotlinx.coroutines.flow.FlowCollector r5 = r5.f2587a
                            java.lang.Object r5 = r5.emit(r2, r0)
                            if (r5 != r1) goto L68
                            return r1
                        L68:
                            lb.n r5 = lb.n.f10413a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, qb.b):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public final Object collect(FlowCollector<? super f> flowCollector, b bVar) {
                    Object objCollect = flowA.collect(new AnonymousClass2(flowCollector, aVar), bVar);
                    return objCollect == CoroutineSingletons.f10059a ? objCollect : n.f10413a;
                }
            });
            a aVar2 = new a(aVar);
            this.f2592a = 1;
            if (flowDistinctUntilChanged.collect(aVar2, this) == coroutineSingletons) {
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
