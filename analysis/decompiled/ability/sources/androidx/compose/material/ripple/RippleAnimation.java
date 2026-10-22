package androidx.compose.material.ripple;

import C7.r;
import J7.c;
import S7.n;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appfunctions.metadata.a;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.C1724q;
import m9.InterfaceC1723p;
import m9.InterfaceC1733z;
import m9.c0;
import org.java_websocket.WebSocketImpl;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nH\u0082@¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0016\u001a\u00020\n*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R+\u0010-\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u00101\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Landroidx/compose/material/ripple/RippleAnimation;", "", "Landroidx/compose/ui/geometry/Offset;", "origin", "", "radius", "", "bounded", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/geometry/Offset;FZLkotlin/jvm/internal/e;)V", "LC7/r;", "fadeIn", "(LH7/c;)Ljava/lang/Object;", "fadeOut", "animate", "finish", "()V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "draw-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "draw", "Landroidx/compose/ui/geometry/Offset;", "F", "Z", "startRadius", "Ljava/lang/Float;", "targetCenter", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "animatedRadiusPercent", "animatedCenterPercent", "Lm9/p;", "finishSignalDeferred", "Lm9/p;", "<set-?>", "finishedFadingIn$delegate", "Landroidx/compose/runtime/MutableState;", "getFinishedFadingIn", "()Z", "setFinishedFadingIn", "(Z)V", "finishedFadingIn", "finishRequested$delegate", "getFinishRequested", "setFinishRequested", "finishRequested", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RippleAnimation {
    public static final int $stable = 8;
    private final Animatable<Float, AnimationVector1D> animatedAlpha;
    private final Animatable<Float, AnimationVector1D> animatedCenterPercent;
    private final Animatable<Float, AnimationVector1D> animatedRadiusPercent;
    private final boolean bounded;

    /* renamed from: finishRequested$delegate, reason: from kotlin metadata */
    private final MutableState finishRequested;
    private final InterfaceC1723p finishSignalDeferred;

    /* renamed from: finishedFadingIn$delegate, reason: from kotlin metadata */
    private final MutableState finishedFadingIn;
    private Offset origin;
    private final float radius;
    private Float startRadius;
    private Offset targetCenter;

    @c(c = "androidx.compose.material.ripple.RippleAnimation", f = "RippleAnimation.kt", l = {77, 79, WebSocketImpl.DEFAULT_PORT}, m = "animate")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material.ripple.RippleAnimation$animate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return RippleAnimation.this.animate(this);
        }
    }

    @c(c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2", f = "RippleAnimation.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lm9/c0;", "<anonymous>", "(Lm9/z;)Lm9/c0;"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2$1", f = "RippleAnimation.kt", l = {86}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RippleAnimation rippleAnimation, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    Animatable animatable = this.this$0.animatedAlpha;
                    Float f = new Float(1.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, f, tweenSpecTween$default, null, null, this, 12, null) == coroutineSingletons) {
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
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2$2", f = "RippleAnimation.kt", l = {92}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C00652 extends SuspendLambda implements n {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00652(RippleAnimation rippleAnimation, H7.c<? super C00652> cVar) {
                super(2, cVar);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C00652(this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    Animatable animatable = this.this$0.animatedRadiusPercent;
                    Float f = new Float(1.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(225, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, f, tweenSpecTween$default, null, null, this, 12, null) == coroutineSingletons) {
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
                return ((C00652) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2$3", f = "RippleAnimation.kt", l = {98}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$3, reason: invalid class name */
        public static final class AnonymousClass3 extends SuspendLambda implements n {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(RippleAnimation rippleAnimation, H7.c<? super AnonymousClass3> cVar) {
                super(2, cVar);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass3(this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    Animatable animatable = this.this$0.animatedCenterPercent;
                    Float f = new Float(1.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(225, 0, EasingKt.getLinearEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, f, tweenSpecTween$default, null, null, this, 12, null) == coroutineSingletons) {
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
                return ((AnonymousClass3) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = RippleAnimation.this.new AnonymousClass2(cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
            AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(RippleAnimation.this, null), 3);
            AbstractC1683A.n(interfaceC1733z, null, new C00652(RippleAnimation.this, null), 3);
            return AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass3(RippleAnimation.this, null), 3);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super c0> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.compose.material.ripple.RippleAnimation$fadeOut$2", f = "RippleAnimation.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lm9/c0;", "<anonymous>", "(Lm9/z;)Lm9/c0;"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material.ripple.RippleAnimation$fadeOut$2, reason: invalid class name and case insensitive filesystem */
    public static final class C05402 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.material.ripple.RippleAnimation$fadeOut$2$1", f = "RippleAnimation.kt", l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material.ripple.RippleAnimation$fadeOut$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RippleAnimation rippleAnimation, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    Animatable animatable = this.this$0.animatedAlpha;
                    Float f = new Float(0.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, f, tweenSpecTween$default, null, null, this, 12, null) == coroutineSingletons) {
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
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public C05402(H7.c<? super C05402> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C05402 c05402 = RippleAnimation.this.new C05402(cVar);
            c05402.L$0 = obj;
            return c05402;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return AbstractC1683A.n((InterfaceC1733z) this.L$0, null, new AnonymousClass1(RippleAnimation.this, null), 3);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super c0> cVar) {
            return ((C05402) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public /* synthetic */ RippleAnimation(Offset offset, float f, boolean z10, e eVar) {
        this(offset, f, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fadeIn(H7.c<? super r> cVar) {
        Object objF = AbstractC1683A.f(new AnonymousClass2(null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fadeOut(H7.c<? super r> cVar) {
        Object objF = AbstractC1683A.f(new C05402(null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getFinishRequested() {
        return ((Boolean) this.finishRequested.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getFinishedFadingIn() {
        return ((Boolean) this.finishedFadingIn.getValue()).booleanValue();
    }

    private final void setFinishRequested(boolean z10) {
        this.finishRequested.setValue(Boolean.valueOf(z10));
    }

    private final void setFinishedFadingIn(boolean z10) {
        this.finishedFadingIn.setValue(Boolean.valueOf(z10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        if (r6.fadeOut(r0) != r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animate(H7.c<? super C7.r> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.material.ripple.RippleAnimation.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = (androidx.compose.material.ripple.RippleAnimation.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = new androidx.compose.material.ripple.RippleAnimation$animate$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.b.b(r7)
            goto L71
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$0
            androidx.compose.material.ripple.RippleAnimation r6 = (androidx.compose.material.ripple.RippleAnimation) r6
            kotlin.b.b(r7)
            goto L65
        L3d:
            java.lang.Object r6 = r0.L$0
            androidx.compose.material.ripple.RippleAnimation r6 = (androidx.compose.material.ripple.RippleAnimation) r6
            kotlin.b.b(r7)
            goto L53
        L45:
            kotlin.b.b(r7)
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r6.fadeIn(r0)
            if (r7 != r1) goto L53
            goto L70
        L53:
            r6.setFinishedFadingIn(r5)
            m9.p r7 = r6.finishSignalDeferred
            r0.L$0 = r6
            r0.label = r4
            m9.q r7 = (m9.C1724q) r7
            java.lang.Object r7 = r7.z(r0)
            if (r7 != r1) goto L65
            goto L70
        L65:
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.fadeOut(r0)
            if (r6 != r1) goto L71
        L70:
            return r1
        L71:
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.RippleAnimation.animate(H7.c):java.lang.Object");
    }

    /* renamed from: draw-4WTKRHQ, reason: not valid java name */
    public final void m1481draw4WTKRHQ(DrawScope drawScope, long j5) {
        if (this.startRadius == null) {
            this.startRadius = Float.valueOf(RippleAnimationKt.m1483getRippleStartRadiusuvyYCjk(drawScope.mo4707getSizeNHjbRc()));
        }
        if (this.origin == null) {
            this.origin = Offset.m3884boximpl(drawScope.mo4706getCenterF1C5BW0());
        }
        if (this.targetCenter == null) {
            this.targetCenter = Offset.m3884boximpl(OffsetKt.Offset(Size.m3964getWidthimpl(drawScope.mo4707getSizeNHjbRc()) / 2.0f, Size.m3961getHeightimpl(drawScope.mo4707getSizeNHjbRc()) / 2.0f));
        }
        float fFloatValue = (!getFinishRequested() || getFinishedFadingIn()) ? this.animatedAlpha.getValue().floatValue() : 1.0f;
        Float f = this.startRadius;
        k.c(f);
        float fLerp = MathHelpersKt.lerp(f.floatValue(), this.radius, this.animatedRadiusPercent.getValue().floatValue());
        Offset offset = this.origin;
        k.c(offset);
        float fM3895getXimpl = Offset.m3895getXimpl(offset.m3905unboximpl());
        Offset offset2 = this.targetCenter;
        k.c(offset2);
        float fLerp2 = MathHelpersKt.lerp(fM3895getXimpl, Offset.m3895getXimpl(offset2.m3905unboximpl()), this.animatedCenterPercent.getValue().floatValue());
        Offset offset3 = this.origin;
        k.c(offset3);
        float fM3896getYimpl = Offset.m3896getYimpl(offset3.m3905unboximpl());
        Offset offset4 = this.targetCenter;
        k.c(offset4);
        long jOffset = OffsetKt.Offset(fLerp2, MathHelpersKt.lerp(fM3896getYimpl, Offset.m3896getYimpl(offset4.m3905unboximpl()), this.animatedCenterPercent.getValue().floatValue()));
        long jM4138copywmQWz5c$default = Color.m4138copywmQWz5c$default(j5, Color.m4141getAlphaimpl(j5) * fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.bounded) {
            DrawScope.m4688drawCircleVaOC9Bg$default(drawScope, jM4138copywmQWz5c$default, fLerp, jOffset, 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
            return;
        }
        float fM3964getWidthimpl = Size.m3964getWidthimpl(drawScope.mo4707getSizeNHjbRc());
        float fM3961getHeightimpl = Size.m3961getHeightimpl(drawScope.mo4707getSizeNHjbRc());
        int iM4128getIntersectrtfAjoo = ClipOp.INSTANCE.m4128getIntersectrtfAjoo();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo4631clipRectN_I0leg(0.0f, 0.0f, fM3964getWidthimpl, fM3961getHeightimpl, iM4128getIntersectrtfAjoo);
        DrawScope.m4688drawCircleVaOC9Bg$default(drawScope, jM4138copywmQWz5c$default, fLerp, jOffset, 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        a.A(drawContext, jMo4628getSizeNHjbRc);
    }

    public final void finish() {
        setFinishRequested(true);
        ((C1724q) this.finishSignalDeferred).U(r.f317a);
    }

    private RippleAnimation(Offset offset, float f, boolean z10) {
        this.origin = offset;
        this.radius = f;
        this.bounded = z10;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.finishSignalDeferred = new C1724q();
        Boolean bool = Boolean.FALSE;
        this.finishedFadingIn = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.finishRequested = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
    }
}
