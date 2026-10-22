package androidx.compose.material3.internal;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0000\u001aH\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0000\u001a&\u0010\u0014\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u0015\u001a\u0002H\u0002H\u0080@¢\u0006\u0002\u0010\u0016\u001a0\u0010\u0017\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u0015\u001a\u0002H\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0080@¢\u0006\u0002\u0010\u001a\u001aF\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e2\"\u0010\u001f\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070!\u0012\u0006\u0012\u0004\u0018\u00010\u00030 H\u0082@¢\u0006\u0002\u0010\"\u001a\u0014\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020$\"\u0004\b\u0000\u0010\u0002H\u0002\u001ar\u0010%\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2H\u0010&\u001aD\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110+¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u0002H\u00020-0 H\u0000¨\u0006."}, d2 = {"DraggableAnchors", "Landroidx/compose/material3/internal/DraggableAnchors;", ExifInterface.GPS_DIRECTION_TRUE, "", "builder", "Lkotlin/Function1;", "Landroidx/compose/material3/internal/DraggableAnchorsConfig;", "", "Lkotlin/ExtensionFunctionType;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "snapTo", "targetValue", "(Landroidx/compose/material3/internal/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "velocity", "", "(Landroidx/compose/material3/internal/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restartable", "I", "inputs", "Lkotlin/Function0;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emptyDraggableAnchors", "Landroidx/compose/material3/internal/MapDraggableAnchors;", "draggableAnchors", "anchors", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Pair;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnchoredDraggableKt {

    /* JADX INFO: renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$anchoredDraggable$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt$anchoredDraggable$1", f = "AnchoredDraggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnchoredDraggableState<T> $state;
        /* synthetic */ float F$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$anchoredDraggable$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt$anchoredDraggable$1$1", f = "AnchoredDraggable.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AnchoredDraggableState<T> $state;
            final /* synthetic */ float $velocity;
            int label;

            public C01721(AnchoredDraggableState<T> r100, float r101, Continuation<? super C01721> r102) {
                this.$state = r100;
                this.$velocity = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C01721(this.$state, this.$velocity, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C01721) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r102 = this.label;
                if (r102 == 0) goto L8;
                if (r102 != 1) goto L7;
                ResultKt.throwOnFailure(r100);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r100);
                AnchoredDraggableState<T> r103 = this.$state;
                float r104 = this.$velocity;
                this.label = 1;
                if (r103.settle(r104, this) != r101) goto L12;
                return r101;
            }
        }

        public AnonymousClass1(AnchoredDraggableState<T> r100, Continuation<? super AnonymousClass1> r101) {
            this.$state = r100;
            super(3, r101);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Float r101, Continuation<? super Unit> r102) {
            return invoke(r100, r101.floatValue(), r102);
        }

        public final Object invoke(CoroutineScope r100, float r101, Continuation<? super Unit> r102) {
            AnonymousClass1 r103 = new AnonymousClass1(this.$state, r102);
            r103.L$0 = r100;
            r103.F$0 = r101;
            return r103.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            CoroutineScope r101 = (CoroutineScope) this.L$0;
            float r102 = this.F$0;
            BuildersKt.launch$default(r101, null, null, new C01721(this.$state, r102, null), 3, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$animateTo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/material3/internal/AnchoredDragScope;", "anchors", "Landroidx/compose/material3/internal/DraggableAnchors;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt$animateTo$2", f = "AnchoredDraggable.kt", i = {}, l = {682}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public AnonymousClass2(AnchoredDraggableState<T> r100, float r101, Continuation<? super AnonymousClass2> r102) {
            this.$this_animateTo = r100;
            this.$velocity = r101;
            super(4, r102);
        }

        public static /* synthetic */ Unit a(AnchoredDragScope r100, Ref.FloatRef r101, float r102, float r103) {
            return invokeSuspend$lambda$0(r100, r101, r102, r103);
        }

        public final Object invoke(AnchoredDragScope r100, DraggableAnchors<T> r101, T r102, Continuation<? super Unit> r103) {
            AnonymousClass2 r104 = new AnonymousClass2(this.$this_animateTo, this.$velocity, r103);
            r104.L$0 = r100;
            r104.L$1 = r101;
            r104.L$2 = r102;
            return r104.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(AnchoredDragScope r100, Object r101, Object r102, Continuation<? super Unit> r103) {
            return invoke(r100, (DraggableAnchors) r101, r102, r103);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            final AnchoredDragScope r111 = (AnchoredDragScope) this.L$0;
            float r102 = ((DraggableAnchors) this.L$1).positionOf(this.L$2);
            if (Float.isNaN(r102) == true) goto L18;
            final Ref.FloatRef r103 = new Ref.FloatRef();
            if (Float.isNaN(this.$this_animateTo.getOffset()) == false) goto L13;
            float r104 = 0.0f;
        L14:
            r103.element = r104;
            float r105 = this.$velocity;
            AnimationSpec<Float> r106 = this.$this_animateTo.getAnimationSpec().invoke();
            Function2 r107 = new n(r111, r103);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            if (SuspendAnimationKt.animate(r104, r102, r105, r106, r107, this) != r100) goto L18;
            return r100;
        L13:
            r104 = this.$this_animateTo.getOffset();
            goto L14
        }

        private static final Unit invokeSuspend$lambda$0(AnchoredDragScope r100, Ref.FloatRef r101, float r102, float r103) {
            r100.dragTo(r102, r103);
            r101.element = r102;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt", f = "AnchoredDraggable.kt", i = {}, l = {706}, m = "restartable", n = {}, s = {})
    public static final class C87151<I> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C87151(Continuation<? super C87151> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.access$restartable(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_ENABLE_TEXTURE_RENDER_NO_RENDER_CHECK}, m = "invokeSuspend", n = {}, s = {})
    public static final class C87162 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Function0<I> $inputs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ Ref.ObjectRef<Job> $previousDrag;

            /* JADX INFO: renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", i = {}, l = {715}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01732 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
                final /* synthetic */ I $latestInputs;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public C01732(Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r100, I r101, CoroutineScope r102, Continuation<? super C01732> r103) {
                    this.$block = r100;
                    this.$latestInputs = r101;
                    this.$$this$coroutineScope = r102;
                    super(2, r103);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new C01732(this.$block, this.$latestInputs, this.$$this$coroutineScope, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((C01732) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r102 = this.label;
                    if (r102 == 0) goto L8;
                    if (r102 != 1) goto L7;
                    ResultKt.throwOnFailure(r100);
                L11:
                    CoroutineScopeKt.cancel(this.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r100);
                    Function2<I, Continuation<? super Unit>, Object> r103 = this.$block;
                    I r104 = this.$latestInputs;
                    this.label = 1;
                    if (r103.invoke(r104, this) != r101) goto L11;
                    return r101;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Ref.ObjectRef<Job> r100, CoroutineScope r101, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r102) {
                this.$previousDrag = r100;
                this.$$this$coroutineScope = r101;
                this.$block = r102;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(I r100, Continuation<? super Unit> r101) {
                if ((r101 instanceof AnchoredDraggableKt$restartable$2$1$emit$1) == false) goto L7;
                AnchoredDraggableKt$restartable$2$1$emit$1 r102 = (AnchoredDraggableKt$restartable$2$1$emit$1) r101;
                int r103 = r102.label;
                if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
                r102.label = r103 - Integer.MIN_VALUE;
            L8:
                Object r104 = r102.result;
                Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r106 = r102.label;
                if (r106 == 0) goto L14;
                if (r106 != 1) goto L13;
                Job r107 = (Job) r102.L$1;
                Object r108 = r102.L$0;
                ResultKt.throwOnFailure(r104);
                Object r109 = r108;
            L19:
                Ref.ObjectRef<Job> r110 = this.$previousDrag;
                CoroutineScope r111 = this.$$this$coroutineScope;
                r110.element = (T) BuildersKt.launch$default(r111, null, CoroutineStart.UNDISPATCHED, new C01732(this.$block, r109, r111, null), 1, null);
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r104);
                Job r112 = this.$previousDrag.element;
                r109 = r100;
                if (r112 == null) goto L19;
                r112.cancel(new AnchoredDragFinishedSignal());
                r102.L$0 = r100;
                r102.L$1 = r112;
                r102.label = 1;
                r109 = r100;
                if (r112.join(r102) != r105) goto L19;
                return r105;
            L7:
                r102 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, r101);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C87162(Function0<? extends I> r100, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super C87162> r102) {
            this.$inputs = r100;
            this.$block = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C87162 r102 = new C87162(this.$inputs, this.$block, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C87162) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CoroutineScope r103 = (CoroutineScope) this.L$0;
            Ref.ObjectRef r104 = new Ref.ObjectRef();
            Flow r105 = SnapshotStateKt.snapshotFlow(this.$inputs);
            AnonymousClass1 r106 = new AnonymousClass1(r104, r103, this.$block);
            this.label = 1;
            if (r105.collect(r106, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/material3/internal/AnchoredDragScope;", "anchors", "Landroidx/compose/material3/internal/DraggableAnchors;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt$snapTo$2", f = "AnchoredDraggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C87172<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public C87172(Continuation<? super C87172> r100) {
            super(4, r100);
        }

        public final Object invoke(AnchoredDragScope r100, DraggableAnchors<T> r101, T r102, Continuation<? super Unit> r103) {
            C87172 r104 = new C87172(r103);
            r104.L$0 = r100;
            r104.L$1 = r101;
            r104.L$2 = r102;
            return r104.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(AnchoredDragScope r100, Object r101, Object r102, Continuation<? super Unit> r103) {
            return invoke(r100, (DraggableAnchors) r101, r102, r103);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r100);
            AnchoredDragScope r101 = (AnchoredDragScope) this.L$0;
            float r102 = ((DraggableAnchors) this.L$1).positionOf(this.L$2);
            if (Float.isNaN(r102) == true) goto L8;
            AnchoredDragScope.CC.dragTo$default(r101, r102, 0.0f, 2, null);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final <T> MapDraggableAnchors<T> emptyDraggableAnchors() {
        return new MapDraggableAnchors(MapsKt.emptyMap());
    }

    public static final /* synthetic */ MapDraggableAnchors access$emptyDraggableAnchors() {
        return emptyDraggableAnchors();
    }

    public static final <T> DraggableAnchors<T> DraggableAnchors(Function1<? super DraggableAnchorsConfig<T>, Unit> r100) {
        DraggableAnchorsConfig r101 = new DraggableAnchorsConfig();
        r100.invoke(r101);
        return new MapDraggableAnchors(r101.getAnchors$material3());
    }

    public static final /* synthetic */ Object access$restartable(Function0 r100, Function2 r101, Continuation r102) {
        return restartable(r100, r101, r102);
    }

    private static final <I> Object restartable(Function0<? extends I> r100, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof C87151) == false) goto L7;
        C87151 r103 = (C87151) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: AnchoredDragFinishedSignal -> L21
    L22:
        goto L20
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        C87162 r108 = new C87162(r100, r101, null);     // Catch: AnchoredDragFinishedSignal -> L21
        r103.label = 1;     // Catch: AnchoredDragFinishedSignal -> L21
        if (CoroutineScopeKt.coroutineScope(r108, r103) != r106) goto L22;
        return r106;
    L20:
        return Unit.INSTANCE;
    L7:
        r103 = new C87151(r102);
        goto L8
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> r100, T r101, Continuation<? super Unit> r102) {
        Object r103 = AnchoredDraggableState.anchoredDrag$default(r100, r101, null, new C87172(null), r102, 2, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> r100, T r101, float r102, Continuation<? super Unit> r110) {
        Object r103 = AnchoredDraggableState.anchoredDrag$default(r100, r101, null, new AnonymousClass2(r100, r102, null), r110, 2, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T> Modifier draggableAnchors(Modifier r100, AnchoredDraggableState<T> r101, Orientation r102, Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends DraggableAnchors<T>, ? extends T>> r103) {
        return r100.then(new DraggableAnchorsElement(r101, r103, r102));
    }

    public static final <T> Modifier anchoredDraggable(Modifier r110, AnchoredDraggableState<T> r111, Orientation r112, boolean r113, boolean r114, MutableInteractionSource r115) {
        return DraggableKt.draggable$default(r110, r111.getDraggableState$material3(), r112, r113, r115, r111.isAnimationRunning(), null, new AnonymousClass1(r111, null), r114, 32, null);
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState r100, Object r101, float r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = r100.getLastVelocity();
    L6:
        return animateTo(r100, r101, r102, r103);
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier r100, AnchoredDraggableState r101, Orientation r102, boolean r103, boolean r110, MutableInteractionSource r111, int r112, Object r113) {
        if ((r112 & 4) == 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r112 & 8) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r112 & 16) == 0) goto L14;
        r111 = null;
    L14:
        return anchoredDraggable(r100, r101, r102, r104, r105, r111);
    L9:
        r105 = r110;
        goto L11
    L5:
        r104 = r103;
        goto L7
    }
}
