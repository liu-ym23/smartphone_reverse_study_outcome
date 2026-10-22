package androidx.compose.material3.internal;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import S7.o;
import S7.p;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;
import p9.d;

@Metadata(d1 = {"\u0000n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aO\u0010\u0013\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a(\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0015\u001a\u00028\u0000H\u0080@¢\u0006\u0004\b\u0016\u0010\u0017\u001a2\u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0015\u001a\u00028\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0080@¢\u0006\u0004\b\u001a\u0010\u001b\u001aH\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\"\u0010!\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 \u0012\u0006\u0012\u0004\u0018\u00010\u00000\u001fH\u0082@¢\u0006\u0004\b\"\u0010#\u001a\u001b\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$\"\u0004\b\u0000\u0010\u0001H\u0002¢\u0006\u0004\b%\u0010&\u001a[\u0010+\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\r\u001a\u00020\f2*\u0010*\u001a&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00028\u00000)0\u001fH\u0000¢\u0006\u0004\b+\u0010,¨\u0006-"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Landroidx/compose/material3/internal/DraggableAnchorsConfig;", "LC7/r;", "builder", "Landroidx/compose/material3/internal/DraggableAnchors;", "DraggableAnchors", "(LS7/k;)Landroidx/compose/material3/internal/DraggableAnchors;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "state", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "", "enabled", "reverseDirection", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "anchoredDraggable", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/internal/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;)Landroidx/compose/ui/Modifier;", "targetValue", "snapTo", "(Landroidx/compose/material3/internal/AnchoredDraggableState;Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "", "velocity", "animateTo", "(Landroidx/compose/material3/internal/AnchoredDraggableState;Ljava/lang/Object;FLH7/c;)Ljava/lang/Object;", "I", "Lkotlin/Function0;", "inputs", "Lkotlin/Function2;", "LH7/c;", "block", "restartable", "(LS7/a;LS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/material3/internal/MapDraggableAnchors;", "emptyDraggableAnchors", "()Landroidx/compose/material3/internal/MapDraggableAnchors;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "Lkotlin/Pair;", "anchors", "draggableAnchors", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/internal/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;LS7/n;)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnchoredDraggableKt {

    @c(c = "androidx.compose.material3.internal.AnchoredDraggableKt$anchoredDraggable$1", f = "AnchoredDraggable.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "", "velocity", "LC7/r;", "<anonymous>", "(Lm9/z;F)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$anchoredDraggable$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements o {
        final /* synthetic */ AnchoredDraggableState<T> $state;
        /* synthetic */ float F$0;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.material3.internal.AnchoredDraggableKt$anchoredDraggable$1$1", f = "AnchoredDraggable.kt", l = {177}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$anchoredDraggable$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01021 extends SuspendLambda implements n {
            final /* synthetic */ AnchoredDraggableState<T> $state;
            final /* synthetic */ float $velocity;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01021(AnchoredDraggableState<T> anchoredDraggableState, float f, H7.c<? super C01021> cVar) {
                super(2, cVar);
                this.$state = anchoredDraggableState;
                this.$velocity = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01021(this.$state, this.$velocity, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    AnchoredDraggableState<T> anchoredDraggableState = this.$state;
                    float f = this.$velocity;
                    this.label = 1;
                    if (anchoredDraggableState.settle(f, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01021) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AnchoredDraggableState<T> anchoredDraggableState, H7.c<? super AnonymousClass1> cVar) {
            super(3, cVar);
            this.$state = anchoredDraggableState;
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((InterfaceC1733z) obj, ((Number) obj2).floatValue(), (H7.c<? super r>) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            AbstractC1683A.n((InterfaceC1733z) this.L$0, null, new C01021(this.$state, this.F$0, null), 3);
            return r.f317a;
        }

        public final Object invoke(InterfaceC1733z interfaceC1733z, float f, H7.c<? super r> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, cVar);
            anonymousClass1.L$0 = interfaceC1733z;
            anonymousClass1.F$0 = f;
            return anonymousClass1.invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.compose.material3.internal.AnchoredDraggableKt$animateTo$2", f = "AnchoredDraggable.kt", l = {685}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/material3/internal/AnchoredDragScope;", "Landroidx/compose/material3/internal/DraggableAnchors;", "anchors", "latestTarget", "LC7/r;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$animateTo$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p {
        final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnchoredDraggableState<T> anchoredDraggableState, float f, H7.c<? super AnonymousClass2> cVar) {
            super(4, cVar);
            this.$this_animateTo = anchoredDraggableState;
            this.$velocity = f;
        }

        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t9, H7.c<? super r> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_animateTo, this.$velocity, cVar);
            anonymousClass2.L$0 = anchoredDragScope;
            anonymousClass2.L$1 = draggableAnchors;
            anonymousClass2.L$2 = t9;
            return anonymousClass2.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                float fPositionOf = ((DraggableAnchors) this.L$1).positionOf(this.L$2);
                if (!Float.isNaN(fPositionOf)) {
                    final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                    float offset = Float.isNaN(this.$this_animateTo.getOffset()) ? 0.0f : this.$this_animateTo.getOffset();
                    ref$FloatRef.f4917a = offset;
                    float f = this.$velocity;
                    AnimationSpec<Float> animationSpec = this.$this_animateTo.getAnimationSpec();
                    n nVar = new n() { // from class: androidx.compose.material3.internal.AnchoredDraggableKt.animateTo.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // S7.n
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                            return r.f317a;
                        }

                        public final void invoke(float f7, float f9) {
                            anchoredDragScope.dragTo(f7, f9);
                            ref$FloatRef.f4917a = f7;
                        }
                    };
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 1;
                    if (SuspendAnimationKt.animate(offset, fPositionOf, f, animationSpec, nVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return invoke((AnchoredDragScope) obj, (DraggableAnchors<DraggableAnchors>) obj2, (DraggableAnchors) obj3, (H7.c<? super r>) obj4);
        }
    }

    @c(c = "androidx.compose.material3.internal.AnchoredDraggableKt", f = "AnchoredDraggable.kt", l = {713}, m = "restartable")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06681<I> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C06681(H7.c<? super C06681> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.restartable(null, null, this);
        }
    }

    @c(c = "androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", l = {715}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"I", "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2, reason: invalid class name and case insensitive filesystem */
    public static final class C06692 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ S7.a $inputs;
        private /* synthetic */ Object L$0;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"I", "latestInputs", "LC7/r;", "emit", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements d {
            final /* synthetic */ InterfaceC1733z $$this$coroutineScope;
            final /* synthetic */ n $block;
            final /* synthetic */ Ref$ObjectRef<c0> $previousDrag;

            @c(c = "androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", l = {722}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"I", "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name and collision with other inner class name */
            public static final class C01032 extends SuspendLambda implements n {
                final /* synthetic */ InterfaceC1733z $$this$coroutineScope;
                final /* synthetic */ n $block;
                final /* synthetic */ I $latestInputs;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01032(n nVar, I i, InterfaceC1733z interfaceC1733z, H7.c<? super C01032> cVar) {
                    super(2, cVar);
                    this.$block = nVar;
                    this.$latestInputs = i;
                    this.$$this$coroutineScope = interfaceC1733z;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    return new C01032(this.$block, this.$latestInputs, this.$$this$coroutineScope, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    int i = this.label;
                    if (i == 0) {
                        b.b(obj);
                        n nVar = this.$block;
                        Object obj2 = this.$latestInputs;
                        this.label = 1;
                        if (nVar.invoke(obj2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        b.b(obj);
                    }
                    AbstractC1683A.e(this.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                    return r.f317a;
                }

                @Override // S7.n
                public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                    return ((C01032) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                }
            }

            public AnonymousClass1(Ref$ObjectRef<c0> ref$ObjectRef, InterfaceC1733z interfaceC1733z, n nVar) {
                this.$previousDrag = ref$ObjectRef;
                this.$$this$coroutineScope = interfaceC1733z;
                this.$block = nVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // p9.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(I r5, H7.c<? super C7.r> r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r6
                    androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = (androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = new androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1
                    r0.<init>(r4, r6)
                L18:
                    java.lang.Object r6 = r0.result
                    kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L39
                    if (r2 != r3) goto L31
                    java.lang.Object r4 = r0.L$2
                    m9.c0 r4 = (m9.c0) r4
                    java.lang.Object r5 = r0.L$1
                    java.lang.Object r4 = r0.L$0
                    androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1 r4 = (androidx.compose.material3.internal.AnchoredDraggableKt.C06692.AnonymousClass1) r4
                    kotlin.b.b(r6)
                    goto L5b
                L31:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L39:
                    kotlin.b.b(r6)
                    kotlin.jvm.internal.Ref$ObjectRef<m9.c0> r6 = r4.$previousDrag
                    java.lang.Object r6 = r6.f4920a
                    m9.c0 r6 = (m9.c0) r6
                    if (r6 == 0) goto L5b
                    androidx.compose.material3.internal.AnchoredDragFinishedSignal r2 = new androidx.compose.material3.internal.AnchoredDragFinishedSignal
                    r2.<init>()
                    r6.cancel(r2)
                    r0.L$0 = r4
                    r0.L$1 = r5
                    r0.L$2 = r6
                    r0.label = r3
                    java.lang.Object r6 = r6.g(r0)
                    if (r6 != r1) goto L5b
                    return r1
                L5b:
                    kotlin.jvm.internal.Ref$ObjectRef<m9.c0> r6 = r4.$previousDrag
                    m9.z r0 = r4.$$this$coroutineScope
                    kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.f5175a
                    androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2 r1 = new androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2
                    S7.n r4 = r4.$block
                    r2 = 0
                    r1.<init>(r4, r5, r0, r2)
                    m9.q0 r4 = m9.AbstractC1683A.n(r0, r2, r1, r3)
                    r6.f4920a = r4
                    C7.r r4 = C7.r.f317a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.AnchoredDraggableKt.C06692.AnonymousClass1.emit(java.lang.Object, H7.c):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06692(S7.a aVar, n nVar, H7.c<? super C06692> cVar) {
            super(2, cVar);
            this.$inputs = aVar;
            this.$block = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C06692 c06692 = new C06692(this.$inputs, this.$block, cVar);
            c06692.L$0 = obj;
            return c06692;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                p9.c cVarSnapshotFlow = SnapshotStateKt.snapshotFlow(this.$inputs);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$ObjectRef, interfaceC1733z, this.$block);
                this.label = 1;
                if (cVarSnapshotFlow.collect(anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C06692) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.compose.material3.internal.AnchoredDraggableKt$snapTo$2", f = "AnchoredDraggable.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/material3/internal/AnchoredDragScope;", "Landroidx/compose/material3/internal/DraggableAnchors;", "anchors", "latestTarget", "LC7/r;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$snapTo$2, reason: invalid class name and case insensitive filesystem */
    public static final class C06702 extends SuspendLambda implements p {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public C06702(H7.c<? super C06702> cVar) {
            super(4, cVar);
        }

        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t9, H7.c<? super r> cVar) {
            C06702 c06702 = new C06702(cVar);
            c06702.L$0 = anchoredDragScope;
            c06702.L$1 = draggableAnchors;
            c06702.L$2 = t9;
            return c06702.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
            float fPositionOf = ((DraggableAnchors) this.L$1).positionOf(this.L$2);
            if (!Float.isNaN(fPositionOf)) {
                AnchoredDragScope.dragTo$default(anchoredDragScope, fPositionOf, 0.0f, 2, null);
            }
            return r.f317a;
        }

        @Override // S7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return invoke((AnchoredDragScope) obj, (DraggableAnchors<DraggableAnchors>) obj2, (DraggableAnchors) obj3, (H7.c<? super r>) obj4);
        }
    }

    public static final <T> DraggableAnchors<T> DraggableAnchors(k kVar) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        kVar.invoke(draggableAnchorsConfig);
        return new MapDraggableAnchors(draggableAnchorsConfig.getAnchors$material3_release());
    }

    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z10, boolean z11, MutableInteractionSource mutableInteractionSource) {
        return DraggableKt.draggable$default(modifier, anchoredDraggableState.getDraggableState(), orientation, z10, mutableInteractionSource, anchoredDraggableState.isAnimationRunning(), null, new AnonymousClass1(anchoredDraggableState, null), z11, 32, null);
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z10, boolean z11, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 4) != 0) {
            z10 = true;
        }
        boolean z12 = z10;
        if ((i & 8) != 0) {
            z11 = false;
        }
        boolean z13 = z11;
        if ((i & 16) != 0) {
            mutableInteractionSource = null;
        }
        return anchoredDraggable(modifier, anchoredDraggableState, orientation, z12, z13, mutableInteractionSource);
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, T t9, float f, H7.c<? super r> cVar) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t9, null, new AnonymousClass2(anchoredDraggableState, f, null), cVar, 2, null);
        return objAnchoredDrag$default == CoroutineSingletons.f4909a ? objAnchoredDrag$default : r.f317a;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState anchoredDraggableState, Object obj, float f, H7.c cVar, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = anchoredDraggableState.getLastVelocity();
        }
        return animateTo(anchoredDraggableState, obj, f, cVar);
    }

    public static final <T> Modifier draggableAnchors(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, n nVar) {
        return modifier.then(new DraggableAnchorsElement(anchoredDraggableState, nVar, orientation));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> MapDraggableAnchors<T> emptyDraggableAnchors() {
        return new MapDraggableAnchors<>(kotlin.collections.a.M());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <I> java.lang.Object restartable(S7.a r4, S7.n r5, H7.c<? super C7.r> r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.material3.internal.AnchoredDraggableKt.C06681
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.material3.internal.AnchoredDraggableKt$restartable$1 r0 = (androidx.compose.material3.internal.AnchoredDraggableKt.C06681) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material3.internal.AnchoredDraggableKt$restartable$1 r0 = new androidx.compose.material3.internal.AnchoredDraggableKt$restartable$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r6)     // Catch: androidx.compose.material3.internal.AnchoredDragFinishedSignal -> L41
            goto L41
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r6)
            androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2 r6 = new androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2     // Catch: androidx.compose.material3.internal.AnchoredDragFinishedSignal -> L41
            r2 = 0
            r6.<init>(r4, r5, r2)     // Catch: androidx.compose.material3.internal.AnchoredDragFinishedSignal -> L41
            r0.label = r3     // Catch: androidx.compose.material3.internal.AnchoredDragFinishedSignal -> L41
            java.lang.Object r4 = m9.AbstractC1683A.f(r6, r0)     // Catch: androidx.compose.material3.internal.AnchoredDragFinishedSignal -> L41
            if (r4 != r1) goto L41
            return r1
        L41:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.AnchoredDraggableKt.restartable(S7.a, S7.n, H7.c):java.lang.Object");
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> anchoredDraggableState, T t9, H7.c<? super r> cVar) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t9, null, new C06702(null), cVar, 2, null);
        return objAnchoredDrag$default == CoroutineSingletons.f4909a ? objAnchoredDrag$default : r.f317a;
    }
}
