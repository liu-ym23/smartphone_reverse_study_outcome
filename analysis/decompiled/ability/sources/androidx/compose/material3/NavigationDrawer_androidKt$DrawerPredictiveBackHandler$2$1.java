package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$FloatRef;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1", f = "NavigationDrawer.android.kt", l = {60, 86, 86, 86}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lp9/c;", "Landroidx/activity/BackEventCompat;", "progress", "LC7/r;", "<anonymous>", "(Lp9/c;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 extends SuspendLambda implements n {
    final /* synthetic */ DrawerPredictiveBackState $drawerPredictiveBackState;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ Ref$FloatRef $maxScaleXDistanceGrow;
    final /* synthetic */ Ref$FloatRef $maxScaleXDistanceShrink;
    final /* synthetic */ Ref$FloatRef $maxScaleYDistance;
    final /* synthetic */ InterfaceC1733z $scope;
    /* synthetic */ Object L$0;
    int label;

    @J7.c(c = "androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2", f = "NavigationDrawer.android.kt", l = {77}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ DrawerPredictiveBackState $drawerPredictiveBackState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DrawerPredictiveBackState drawerPredictiveBackState, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$drawerPredictiveBackState = drawerPredictiveBackState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$drawerPredictiveBackState, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnonymousClass2 anonymousClass2;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                float scaleXDistance = this.$drawerPredictiveBackState.getScaleXDistance();
                final DrawerPredictiveBackState drawerPredictiveBackState = this.$drawerPredictiveBackState;
                n nVar = new n() { // from class: androidx.compose.material3.NavigationDrawer_androidKt.DrawerPredictiveBackHandler.2.1.2.1
                    {
                        super(2);
                    }

                    @Override // S7.n
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                        return r.f317a;
                    }

                    public final void invoke(float f, float f7) {
                        drawerPredictiveBackState.setScaleXDistance(f);
                    }
                };
                this.label = 1;
                anonymousClass2 = this;
                if (SuspendAnimationKt.animate$default(scaleXDistance, 0.0f, 0.0f, null, nVar, anonymousClass2, 12, null) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                anonymousClass2 = this;
            }
            anonymousClass2.$drawerPredictiveBackState.clear();
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(DrawerPredictiveBackState drawerPredictiveBackState, InterfaceC1733z interfaceC1733z, DrawerState drawerState, boolean z10, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, Ref$FloatRef ref$FloatRef3, H7.c<? super NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1> cVar) {
        super(2, cVar);
        this.$drawerPredictiveBackState = drawerPredictiveBackState;
        this.$scope = interfaceC1733z;
        this.$drawerState = drawerState;
        this.$isRtl = z10;
        this.$maxScaleXDistanceGrow = ref$FloatRef;
        this.$maxScaleXDistanceShrink = ref$FloatRef2;
        this.$maxScaleYDistance = ref$FloatRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(this.$drawerPredictiveBackState, this.$scope, this.$drawerState, this.$isRtl, this.$maxScaleXDistanceGrow, this.$maxScaleXDistanceShrink, this.$maxScaleYDistance, cVar);
        navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.L$0 = obj;
        return navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        if (r14.close(r13) == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        if (r14.close(r13) != r1) goto L33;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r0 = r13.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r0 == 0) goto L2f
            if (r0 == r5) goto L28
            if (r0 == r4) goto L24
            if (r0 == r3) goto L24
            if (r0 == r2) goto L1b
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L1b:
            java.lang.Object r13 = r13.L$0
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            kotlin.b.b(r14)
            goto Lb6
        L24:
            kotlin.b.b(r14)
            goto L91
        L28:
            kotlin.b.b(r14)     // Catch: java.lang.Throwable -> L2c java.util.concurrent.CancellationException -> L6d
            goto L4e
        L2c:
            r0 = move-exception
            r14 = r0
            goto L94
        L2f:
            kotlin.b.b(r14)
            java.lang.Object r14 = r13.L$0
            p9.c r14 = (p9.c) r14
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$1 r7 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$1     // Catch: java.lang.Throwable -> L2c java.util.concurrent.CancellationException -> L6d
            androidx.compose.material3.DrawerPredictiveBackState r8 = r13.$drawerPredictiveBackState     // Catch: java.lang.Throwable -> L2c java.util.concurrent.CancellationException -> L6d
            boolean r9 = r13.$isRtl     // Catch: java.lang.Throwable -> L2c java.util.concurrent.CancellationException -> L6d
            kotlin.jvm.internal.Ref$FloatRef r10 = r13.$maxScaleXDistanceGrow     // Catch: java.lang.Throwable -> L2c java.util.concurrent.CancellationException -> L6d
            kotlin.jvm.internal.Ref$FloatRef r11 = r13.$maxScaleXDistanceShrink     // Catch: java.lang.Throwable -> L2c java.util.concurrent.CancellationException -> L6d
            kotlin.jvm.internal.Ref$FloatRef r12 = r13.$maxScaleYDistance     // Catch: java.lang.Throwable -> L2c java.util.concurrent.CancellationException -> L6d
            r7.<init>()     // Catch: java.lang.Throwable -> L2c java.util.concurrent.CancellationException -> L6d
            r13.label = r5     // Catch: java.lang.Throwable -> L2c java.util.concurrent.CancellationException -> L6d
            java.lang.Object r14 = r14.collect(r7, r13)     // Catch: java.lang.Throwable -> L2c java.util.concurrent.CancellationException -> L6d
            if (r14 != r1) goto L4e
            goto Lb4
        L4e:
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.$drawerPredictiveBackState
            boolean r14 = r14.getSwipeEdgeMatchesDrawer()
            if (r14 == 0) goto L62
            m9.z r14 = r13.$scope
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2 r0 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2
            androidx.compose.material3.DrawerPredictiveBackState r2 = r13.$drawerPredictiveBackState
            r0.<init>(r2, r6)
            m9.AbstractC1683A.n(r14, r6, r0, r3)
        L62:
            androidx.compose.material3.DrawerState r14 = r13.$drawerState
            r13.label = r4
            java.lang.Object r13 = r14.close(r13)
            if (r13 != r1) goto L91
            goto Lb4
        L6d:
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.$drawerPredictiveBackState     // Catch: java.lang.Throwable -> L2c
            r14.clear()     // Catch: java.lang.Throwable -> L2c
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.$drawerPredictiveBackState
            boolean r14 = r14.getSwipeEdgeMatchesDrawer()
            if (r14 == 0) goto L86
            m9.z r14 = r13.$scope
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2 r0 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2
            androidx.compose.material3.DrawerPredictiveBackState r2 = r13.$drawerPredictiveBackState
            r0.<init>(r2, r6)
            m9.AbstractC1683A.n(r14, r6, r0, r3)
        L86:
            androidx.compose.material3.DrawerState r14 = r13.$drawerState
            r13.label = r3
            java.lang.Object r13 = r14.close(r13)
            if (r13 != r1) goto L91
            goto Lb4
        L91:
            C7.r r13 = C7.r.f317a
            return r13
        L94:
            androidx.compose.material3.DrawerPredictiveBackState r0 = r13.$drawerPredictiveBackState
            boolean r0 = r0.getSwipeEdgeMatchesDrawer()
            if (r0 == 0) goto La8
            m9.z r0 = r13.$scope
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2 r4 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2
            androidx.compose.material3.DrawerPredictiveBackState r5 = r13.$drawerPredictiveBackState
            r4.<init>(r5, r6)
            m9.AbstractC1683A.n(r0, r6, r4, r3)
        La8:
            androidx.compose.material3.DrawerState r0 = r13.$drawerState
            r13.L$0 = r14
            r13.label = r2
            java.lang.Object r13 = r0.close(r13)
            if (r13 != r1) goto Lb5
        Lb4:
            return r1
        Lb5:
            r13 = r14
        Lb6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(p9.c cVar, H7.c<? super r> cVar2) {
        return ((NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1) create(cVar, cVar2)).invokeSuspend(r.f317a);
    }
}
