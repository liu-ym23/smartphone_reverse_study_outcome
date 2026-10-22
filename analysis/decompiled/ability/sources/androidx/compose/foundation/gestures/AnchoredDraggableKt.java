package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.a;
import S7.k;
import S7.n;
import S7.p;
import androidx.collection.MutableObjectFloatMap;
import androidx.collection.ObjectFloatMap;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ac\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a[\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u0010\u001a9\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\b\b\u0000\u0010\u0000*\u00020\u00112\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a(\u0010\u001a\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0019\u001a\u00028\u0000H\u0087@¢\u0006\u0004\b\u001a\u0010\u001b\u001aF\u0010\"\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010!\u001a\u00028\u0000H\u0082@¢\u0006\u0004\b\"\u0010#\u001a(\u0010\"\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0019\u001a\u00028\u0000H\u0087@¢\u0006\u0004\b\"\u0010\u001b\u001a0\u0010$\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0087@¢\u0006\u0004\b$\u0010%\u001a\u001b\u0010'\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010&\u001a\u00020\u001cH\u0002¢\u0006\u0004\b'\u0010(\u001aH\u0010/\u001a\u00020\u0014\"\u0004\b\u0000\u0010)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*2\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140-\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0082@¢\u0006\u0004\b/\u00100\u001a\u001b\u00102\u001a\b\u0012\u0004\u0012\u00028\u000001\"\u0004\b\u0000\u0010\u0000H\u0002¢\u0006\u0004\b2\u00103\u001a\u001f\u00106\u001a\u00020\u001c\"\u0004\b\u0000\u00104*\b\u0012\u0004\u0012\u00028\u000005H\u0002¢\u0006\u0004\b6\u00107\u001a\u001f\u00108\u001a\u00020\u001c\"\u0004\b\u0000\u00104*\b\u0012\u0004\u0012\u00028\u000005H\u0002¢\u0006\u0004\b8\u00107\u001a\u001e\u0010;\u001a\u00020\u00142\f\u0010:\u001a\b\u0012\u0004\u0012\u0002090*H\u0082\b¢\u0006\u0004\b;\u0010<\" \u0010>\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?\"\u0014\u0010@\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006B"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "state", "", "reverseDirection", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/foundation/OverscrollEffect;", "overscrollEffect", "startDragImmediately", "anchoredDraggable", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/AnchoredDraggableState;ZLandroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Z)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Z)Landroidx/compose/ui/Modifier;", "", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "LC7/r;", "builder", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "DraggableAnchors", "(LS7/k;)Landroidx/compose/foundation/gestures/DraggableAnchors;", "targetValue", "snapTo", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "", "velocity", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchoredDragScope", "anchors", "latestTarget", "animateTo", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;FLandroidx/compose/foundation/gestures/AnchoredDragScope;Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "animateToWithDecay", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;FLH7/c;)Ljava/lang/Object;", TypedValues.AttributesType.S_TARGET, "coerceToTarget", "(FF)F", "I", "Lkotlin/Function0;", "inputs", "Lkotlin/Function2;", "LH7/c;", "block", "restartable", "(LS7/a;LS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/foundation/gestures/MapDraggableAnchors;", "emptyDraggableAnchors", "()Landroidx/compose/foundation/gestures/MapDraggableAnchors;", "K", "Landroidx/collection/ObjectFloatMap;", "minValueOrNaN", "(Landroidx/collection/ObjectFloatMap;)F", "maxValueOrNaN", "", "generateMsg", "debugLog", "(LS7/a;)V", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "AlwaysDrag", "LS7/k;", "DEBUG", "Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnchoredDraggableKt {
    private static final k AlwaysDrag = new k() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$AlwaysDrag$1
        @Override // S7.k
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return Boolean.TRUE;
        }
    };
    private static final boolean DEBUG = false;

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4", f = "AnchoredDraggable.kt", l = {1022}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "anchors", "latestTarget", "LC7/r;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p {
        final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AnchoredDraggableState<T> anchoredDraggableState, H7.c<? super AnonymousClass4> cVar) {
            super(4, cVar);
            this.$this_animateTo = anchoredDraggableState;
        }

        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t9, H7.c<? super r> cVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$this_animateTo, cVar);
            anonymousClass4.L$0 = anchoredDragScope;
            anonymousClass4.L$1 = draggableAnchors;
            anonymousClass4.L$2 = t9;
            return anonymousClass4.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                DraggableAnchors draggableAnchors = (DraggableAnchors) this.L$1;
                Object obj2 = this.L$2;
                AnchoredDraggableState<T> anchoredDraggableState = this.$this_animateTo;
                float lastVelocity = anchoredDraggableState.getLastVelocity();
                this.L$0 = null;
                this.L$1 = null;
                this.label = 1;
                if (AnchoredDraggableKt.animateTo(anchoredDraggableState, lastVelocity, anchoredDragScope, draggableAnchors, obj2, this) == coroutineSingletons) {
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

        @Override // S7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return invoke((AnchoredDragScope) obj, (DraggableAnchors<DraggableAnchors>) obj2, (DraggableAnchors) obj3, (H7.c<? super r>) obj4);
        }
    }

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt", f = "AnchoredDraggable.kt", l = {1049}, m = "animateToWithDecay")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.animateToWithDecay(null, null, 0.0f, this);
        }
    }

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2", f = "AnchoredDraggable.kt", l = {1059, 1077, 1092}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "anchors", "latestTarget", "LC7/r;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p {
        final /* synthetic */ Ref$FloatRef $remainingVelocity;
        final /* synthetic */ AnchoredDraggableState<T> $this_animateToWithDecay;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnchoredDraggableState<T> anchoredDraggableState, float f, Ref$FloatRef ref$FloatRef, H7.c<? super AnonymousClass2> cVar) {
            super(4, cVar);
            this.$this_animateToWithDecay = anchoredDraggableState;
            this.$velocity = f;
            this.$remainingVelocity = ref$FloatRef;
        }

        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t9, H7.c<? super r> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_animateToWithDecay, this.$velocity, this.$remainingVelocity, cVar);
            anonymousClass2.L$0 = anchoredDragScope;
            anonymousClass2.L$1 = draggableAnchors;
            anonymousClass2.L$2 = t9;
            return anonymousClass2.invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
        
            if (androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r1, r3, false, r3, r23, 2, null) == r7) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d4, code lost:
        
            if (androidx.compose.foundation.gestures.AnchoredDraggableKt.animateTo(r0, r15, r0, r4, r8, r23) == r7) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00ea, code lost:
        
            if (androidx.compose.foundation.gestures.AnchoredDraggableKt.animateTo(r0, r12, r0, r4, r8, r23) == r7) goto L43;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instructions count: 244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return invoke((AnchoredDragScope) obj, (DraggableAnchors<DraggableAnchors>) obj2, (DraggableAnchors) obj3, (H7.c<? super r>) obj4);
        }
    }

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt", f = "AnchoredDraggable.kt", l = {1116}, m = "restartable")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03881<I> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C03881(H7.c<? super C03881> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.restartable(null, null, this);
        }
    }

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", l = {1119}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"I", "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03892 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ a $inputs;
        private /* synthetic */ Object L$0;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"I", "latestInputs", "LC7/r;", "emit", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements d {
            final /* synthetic */ InterfaceC1733z $$this$coroutineScope;
            final /* synthetic */ n $block;
            final /* synthetic */ Ref$ObjectRef<c0> $previousDrag;

            @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", l = {1125}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"I", "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name and collision with other inner class name */
            public static final class C00152 extends SuspendLambda implements n {
                final /* synthetic */ InterfaceC1733z $$this$coroutineScope;
                final /* synthetic */ n $block;
                final /* synthetic */ I $latestInputs;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00152(n nVar, I i, InterfaceC1733z interfaceC1733z, H7.c<? super C00152> cVar) {
                    super(2, cVar);
                    this.$block = nVar;
                    this.$latestInputs = i;
                    this.$$this$coroutineScope = interfaceC1733z;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    return new C00152(this.$block, this.$latestInputs, this.$$this$coroutineScope, cVar);
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
                    return ((C00152) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
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
                    boolean r0 = r6 instanceof androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r6
                    androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1
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
                    androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1 r4 = (androidx.compose.foundation.gestures.AnchoredDraggableKt.C03892.AnonymousClass1) r4
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
                    androidx.compose.foundation.gestures.AnchoredDragFinishedSignal r2 = new androidx.compose.foundation.gestures.AnchoredDragFinishedSignal
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
                    androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2 r1 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2
                    S7.n r4 = r4.$block
                    r2 = 0
                    r1.<init>(r4, r5, r0, r2)
                    m9.q0 r4 = m9.AbstractC1683A.n(r0, r2, r1, r3)
                    r6.f4920a = r4
                    C7.r r4 = C7.r.f317a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt.C03892.AnonymousClass1.emit(java.lang.Object, H7.c):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03892(a aVar, n nVar, H7.c<? super C03892> cVar) {
            super(2, cVar);
            this.$inputs = aVar;
            this.$block = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C03892 c03892 = new C03892(this.$inputs, this.$block, cVar);
            c03892.L$0 = obj;
            return c03892;
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
            return ((C03892) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$snapTo$2", f = "AnchoredDraggable.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "anchors", "latestTarget", "LC7/r;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$snapTo$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03902 extends SuspendLambda implements p {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public C03902(H7.c<? super C03902> cVar) {
            super(4, cVar);
        }

        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t9, H7.c<? super r> cVar) {
            C03902 c03902 = new C03902(cVar);
            c03902.L$0 = anchoredDragScope;
            c03902.L$1 = draggableAnchors;
            c03902.L$2 = t9;
            return c03902.invokeSuspend(r.f317a);
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

    @ExperimentalFoundationApi
    public static final <T> DraggableAnchors<T> DraggableAnchors(k kVar) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        kVar.invoke(draggableAnchorsConfig);
        return new MapDraggableAnchors(draggableAnchorsConfig.getAnchors$foundation_release());
    }

    @ExperimentalFoundationApi
    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, boolean z10, Orientation orientation, boolean z11, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z12) {
        return modifier.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, z11, Boolean.valueOf(z10), mutableInteractionSource, z12, overscrollEffect));
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, boolean z10, Orientation orientation, boolean z11, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z12, int i, Object obj) {
        if ((i & 8) != 0) {
            z11 = true;
        }
        return anchoredDraggable(modifier, anchoredDraggableState, z10, orientation, z11, (i & 16) != 0 ? null : mutableInteractionSource, (i & 32) != 0 ? null : overscrollEffect, (i & 64) != 0 ? anchoredDraggableState.isAnimationRunning() : z12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, float f, final AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t9, H7.c<? super r> cVar) {
        Object objAnimate;
        float fPositionOf = draggableAnchors.positionOf(t9);
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.f4917a = Float.isNaN(anchoredDraggableState.getOffset()) ? 0.0f : anchoredDraggableState.getOffset();
        if (!Float.isNaN(fPositionOf)) {
            float f7 = ref$FloatRef.f4917a;
            if (f7 != fPositionOf && (objAnimate = SuspendAnimationKt.animate(f7, fPositionOf, f, anchoredDraggableState.getSnapAnimationSpec(), new n() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                    return r.f317a;
                }

                public final void invoke(float f9, float f10) {
                    anchoredDragScope.dragTo(f9, f10);
                    ref$FloatRef.f4917a = f9;
                }
            }, cVar)) == CoroutineSingletons.f4909a) {
                return objAnimate;
            }
        }
        return r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @androidx.compose.foundation.ExperimentalFoundationApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object animateToWithDecay(androidx.compose.foundation.gestures.AnchoredDraggableState<T> r8, T r9, float r10, H7.c<? super java.lang.Float> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.AnchoredDraggableKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r5.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            float r10 = r5.F$0
            java.lang.Object r8 = r5.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref$FloatRef) r8
            kotlin.b.b(r11)
            goto L5a
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.b.b(r11)
            kotlin.jvm.internal.Ref$FloatRef r11 = new kotlin.jvm.internal.Ref$FloatRef
            r11.<init>()
            r11.f4917a = r10
            androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2 r4 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2
            r1 = 0
            r4.<init>(r8, r10, r11, r1)
            r5.L$0 = r11
            r5.F$0 = r10
            r5.label = r2
            r3 = 0
            r6 = 2
            r7 = 0
            r1 = r8
            r2 = r9
            java.lang.Object r8 = androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag$default(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto L59
            return r0
        L59:
            r8 = r11
        L5a:
            float r8 = r8.f4917a
            float r10 = r10 - r8
            java.lang.Float r8 = new java.lang.Float
            r8.<init>(r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt.animateToWithDecay(androidx.compose.foundation.gestures.AnchoredDraggableState, java.lang.Object, float, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float coerceToTarget(float f, float f7) {
        if (f7 == 0.0f) {
            return 0.0f;
        }
        return (f7 <= 0.0f ? f >= f7 : f <= f7) ? f : f7;
    }

    private static final void debugLog(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> MapDraggableAnchors<T> emptyDraggableAnchors() {
        return new MapDraggableAnchors<>(new MutableObjectFloatMap(0, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K> float maxValueOrNaN(ObjectFloatMap<K> objectFloatMap) {
        if (objectFloatMap.get_size() == 1) {
            return Float.NaN;
        }
        float[] fArr = objectFloatMap.values;
        long[] jArr = objectFloatMap.metadata;
        int length = jArr.length - 2;
        float f = Float.NEGATIVE_INFINITY;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j5 = jArr[i];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j5) < 128) {
                            float f7 = fArr[(i << 3) + i10];
                            if (f7 >= f) {
                                f = f7;
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        return f;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K> float minValueOrNaN(ObjectFloatMap<K> objectFloatMap) {
        if (objectFloatMap.get_size() == 1) {
            return Float.NaN;
        }
        float[] fArr = objectFloatMap.values;
        long[] jArr = objectFloatMap.metadata;
        int length = jArr.length - 2;
        float f = Float.POSITIVE_INFINITY;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j5 = jArr[i];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j5) < 128) {
                            float f7 = fArr[(i << 3) + i10];
                            if (f7 <= f) {
                                f = f7;
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        return f;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <I> java.lang.Object restartable(S7.a r4, S7.n r5, H7.c<? super C7.r> r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.AnchoredDraggableKt.C03881
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableKt.C03881) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r6)     // Catch: androidx.compose.foundation.gestures.AnchoredDragFinishedSignal -> L41
            goto L41
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r6)
            androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2 r6 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2     // Catch: androidx.compose.foundation.gestures.AnchoredDragFinishedSignal -> L41
            r2 = 0
            r6.<init>(r4, r5, r2)     // Catch: androidx.compose.foundation.gestures.AnchoredDragFinishedSignal -> L41
            r0.label = r3     // Catch: androidx.compose.foundation.gestures.AnchoredDragFinishedSignal -> L41
            java.lang.Object r4 = m9.AbstractC1683A.f(r6, r0)     // Catch: androidx.compose.foundation.gestures.AnchoredDragFinishedSignal -> L41
            if (r4 != r1) goto L41
            return r1
        L41:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt.restartable(S7.a, S7.n, H7.c):java.lang.Object");
    }

    @ExperimentalFoundationApi
    public static final <T> Object snapTo(AnchoredDraggableState<T> anchoredDraggableState, T t9, H7.c<? super r> cVar) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t9, null, new C03902(null), cVar, 2, null);
        return objAnchoredDrag$default == CoroutineSingletons.f4909a ? objAnchoredDrag$default : r.f317a;
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z10, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z11, int i, Object obj) {
        if ((i & 4) != 0) {
            z10 = true;
        }
        boolean z12 = z10;
        MutableInteractionSource mutableInteractionSource2 = (i & 8) != 0 ? null : mutableInteractionSource;
        OverscrollEffect overscrollEffect2 = (i & 16) != 0 ? null : overscrollEffect;
        if ((i & 32) != 0) {
            z11 = anchoredDraggableState.isAnimationRunning();
        }
        return anchoredDraggable(modifier, anchoredDraggableState, orientation, z12, mutableInteractionSource2, overscrollEffect2, z11);
    }

    @ExperimentalFoundationApi
    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z10, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z11) {
        return modifier.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, z10, null, mutableInteractionSource, z11, overscrollEffect));
    }

    @ExperimentalFoundationApi
    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, T t9, H7.c<? super r> cVar) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t9, null, new AnonymousClass4(anchoredDraggableState, null), cVar, 2, null);
        return objAnchoredDrag$default == CoroutineSingletons.f4909a ? objAnchoredDrag$default : r.f317a;
    }
}
