package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import android.view.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1", f = "SearchBar.android.kt", l = {ComposerKt.compositionLocalMapKey}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lp9/c;", "Landroidx/activity/BackEventCompat;", "progress", "LC7/r;", "<anonymous>", "(Lp9/c;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class SearchBar_androidKt$SearchBar$2$1 extends SuspendLambda implements n {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutatorMutex $mutatorMutex;
    final /* synthetic */ k $onExpandedChange;
    /* synthetic */ Object L$0;
    int label;

    @J7.c(c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1", f = "SearchBar.android.kt", l = {205, 216}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements k {
        final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
        final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
        final /* synthetic */ MutableFloatState $finalBackProgress;
        final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
        final /* synthetic */ k $onExpandedChange;
        final /* synthetic */ p9.c $progress;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MutableFloatState mutableFloatState, p9.c cVar, Animatable<Float, AnimationVector1D> animatable, k kVar, MutableState<BackEventCompat> mutableState, MutableState<BackEventCompat> mutableState2, H7.c<? super AnonymousClass1> cVar2) {
            super(1, cVar2);
            this.$finalBackProgress = mutableFloatState;
            this.$progress = cVar;
            this.$animationProgress = animatable;
            this.$onExpandedChange = kVar;
            this.$firstBackEvent = mutableState;
            this.$currentBackEvent = mutableState2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new AnonymousClass1(this.$finalBackProgress, this.$progress, this.$animationProgress, this.$onExpandedChange, this.$firstBackEvent, this.$currentBackEvent, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        
            if (androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, null, null, r9, 12, null) != r0) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r12.label
                r2 = 2143289344(0x7fc00000, float:NaN)
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1f
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.b.b(r13)
                r9 = r12
                goto L72
            L13:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L1b:
                kotlin.b.b(r13)     // Catch: java.util.concurrent.CancellationException -> L56
                goto L3d
            L1f:
                kotlin.b.b(r13)
                androidx.compose.runtime.MutableFloatState r13 = r12.$finalBackProgress     // Catch: java.util.concurrent.CancellationException -> L56
                r13.setFloatValue(r2)     // Catch: java.util.concurrent.CancellationException -> L56
                p9.c r13 = r12.$progress     // Catch: java.util.concurrent.CancellationException -> L56
                androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1$1 r1 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1$1     // Catch: java.util.concurrent.CancellationException -> L56
                androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r5 = r12.$firstBackEvent     // Catch: java.util.concurrent.CancellationException -> L56
                androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r6 = r12.$currentBackEvent     // Catch: java.util.concurrent.CancellationException -> L56
                androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r7 = r12.$animationProgress     // Catch: java.util.concurrent.CancellationException -> L56
                r1.<init>()     // Catch: java.util.concurrent.CancellationException -> L56
                r12.label = r4     // Catch: java.util.concurrent.CancellationException -> L56
                java.lang.Object r13 = r13.collect(r1, r12)     // Catch: java.util.concurrent.CancellationException -> L56
                if (r13 != r0) goto L3d
                goto L71
            L3d:
                androidx.compose.runtime.MutableFloatState r13 = r12.$finalBackProgress     // Catch: java.util.concurrent.CancellationException -> L56
                androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r12.$animationProgress     // Catch: java.util.concurrent.CancellationException -> L56
                java.lang.Object r1 = r1.getValue()     // Catch: java.util.concurrent.CancellationException -> L56
                java.lang.Number r1 = (java.lang.Number) r1     // Catch: java.util.concurrent.CancellationException -> L56
                float r1 = r1.floatValue()     // Catch: java.util.concurrent.CancellationException -> L56
                r13.setFloatValue(r1)     // Catch: java.util.concurrent.CancellationException -> L56
                S7.k r13 = r12.$onExpandedChange     // Catch: java.util.concurrent.CancellationException -> L56
                java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch: java.util.concurrent.CancellationException -> L56
                r13.invoke(r1)     // Catch: java.util.concurrent.CancellationException -> L56
                goto L82
            L56:
                androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r12.$animationProgress
                java.lang.Float r5 = new java.lang.Float
                r13 = 1065353216(0x3f800000, float:1.0)
                r5.<init>(r13)
                androidx.compose.animation.core.FiniteAnimationSpec r6 = androidx.compose.material3.SearchBar_androidKt.access$getAnimationPredictiveBackExitFloatSpec$p()
                r12.label = r3
                r7 = 0
                r8 = 0
                r10 = 12
                r11 = 0
                r9 = r12
                java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)
                if (r12 != r0) goto L72
            L71:
                return r0
            L72:
                androidx.compose.runtime.MutableFloatState r12 = r9.$finalBackProgress
                r12.setFloatValue(r2)
                androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r12 = r9.$firstBackEvent
                r13 = 0
                r12.setValue(r13)
                androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r12 = r9.$currentBackEvent
                r12.setValue(r13)
            L82:
                C7.r r12 = C7.r.f317a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBar_androidKt$SearchBar$2$1(MutatorMutex mutatorMutex, MutableFloatState mutableFloatState, Animatable<Float, AnimationVector1D> animatable, k kVar, MutableState<BackEventCompat> mutableState, MutableState<BackEventCompat> mutableState2, H7.c<? super SearchBar_androidKt$SearchBar$2$1> cVar) {
        super(2, cVar);
        this.$mutatorMutex = mutatorMutex;
        this.$finalBackProgress = mutableFloatState;
        this.$animationProgress = animatable;
        this.$onExpandedChange = kVar;
        this.$firstBackEvent = mutableState;
        this.$currentBackEvent = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        SearchBar_androidKt$SearchBar$2$1 searchBar_androidKt$SearchBar$2$1 = new SearchBar_androidKt$SearchBar$2$1(this.$mutatorMutex, this.$finalBackProgress, this.$animationProgress, this.$onExpandedChange, this.$firstBackEvent, this.$currentBackEvent, cVar);
        searchBar_androidKt$SearchBar$2$1.L$0 = obj;
        return searchBar_androidKt$SearchBar$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            p9.c cVar = (p9.c) this.L$0;
            MutatorMutex mutatorMutex = this.$mutatorMutex;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$finalBackProgress, cVar, this.$animationProgress, this.$onExpandedChange, this.$firstBackEvent, this.$currentBackEvent, null);
            this.label = 1;
            if (MutatorMutex.mutate$default(mutatorMutex, null, anonymousClass1, this, 1, null) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(p9.c cVar, H7.c<? super r> cVar2) {
        return ((SearchBar_androidKt$SearchBar$2$1) create(cVar, cVar2)).invokeSuspend(r.f317a);
    }
}
