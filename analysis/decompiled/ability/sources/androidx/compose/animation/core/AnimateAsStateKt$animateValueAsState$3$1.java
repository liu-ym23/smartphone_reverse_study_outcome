package androidx.compose.animation.core;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import o9.InterfaceC1779e;

@c(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1", f = "AnimateAsState.kt", l = {McpErrorCode.TOKEN_EXPIRED}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationVector;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class AnimateAsStateKt$animateValueAsState$3$1 extends SuspendLambda implements n {
    final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
    final /* synthetic */ Animatable<T, V> $animatable;
    final /* synthetic */ InterfaceC1779e $channel;
    final /* synthetic */ State<k> $listener$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    @c(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1", f = "AnimateAsState.kt", l = {428}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationVector;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
        final /* synthetic */ Animatable<T, V> $animatable;
        final /* synthetic */ State<k> $listener$delegate;
        final /* synthetic */ T $newTarget;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(T t9, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends k> state2, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$newTarget = t9;
            this.$animatable = animatable;
            this.$animSpec$delegate = state;
            this.$listener$delegate = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$newTarget, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnonymousClass1 anonymousClass1;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                if (!kotlin.jvm.internal.k.b(this.$newTarget, this.$animatable.getTargetValue())) {
                    Animatable<T, V> animatable = this.$animatable;
                    T t9 = this.$newTarget;
                    AnimationSpec animationSpecAnimateValueAsState$lambda$6 = AnimateAsStateKt.animateValueAsState$lambda$6(this.$animSpec$delegate);
                    this.label = 1;
                    anonymousClass1 = this;
                    if (Animatable.animateTo$default(animatable, t9, animationSpecAnimateValueAsState$lambda$6, null, null, anonymousClass1, 12, null) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return r.f317a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            anonymousClass1 = this;
            k kVarAnimateValueAsState$lambda$4 = AnimateAsStateKt.animateValueAsState$lambda$4(anonymousClass1.$listener$delegate);
            if (kVarAnimateValueAsState$lambda$4 != null) {
                kVarAnimateValueAsState$lambda$4.invoke(anonymousClass1.$animatable.getValue());
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnimateAsStateKt$animateValueAsState$3$1(InterfaceC1779e interfaceC1779e, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends k> state2, H7.c<? super AnimateAsStateKt$animateValueAsState$3$1> cVar) {
        super(2, cVar);
        this.$channel = interfaceC1779e;
        this.$animatable = animatable;
        this.$animSpec$delegate = state;
        this.$listener$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        AnimateAsStateKt$animateValueAsState$3$1 animateAsStateKt$animateValueAsState$3$1 = new AnimateAsStateKt$animateValueAsState$3$1(this.$channel, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, cVar);
        animateAsStateKt$animateValueAsState$3$1.L$0 = obj;
        return animateAsStateKt$animateValueAsState$3$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0035 -> B:12:0x0038). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r11.label
            r2 = 1
            if (r1 == 0) goto L1d
            if (r1 != r2) goto L15
            java.lang.Object r1 = r11.L$1
            o9.b r1 = (o9.C1776b) r1
            java.lang.Object r3 = r11.L$0
            m9.z r3 = (m9.InterfaceC1733z) r3
            kotlin.b.b(r12)
            goto L38
        L15:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1d:
            kotlin.b.b(r12)
            java.lang.Object r12 = r11.L$0
            m9.z r12 = (m9.InterfaceC1733z) r12
            o9.e r1 = r11.$channel
            o9.b r1 = r1.iterator()
            r3 = r12
        L2b:
            r11.L$0 = r3
            r11.L$1 = r1
            r11.label = r2
            java.lang.Object r12 = r1.b(r11)
            if (r12 != r0) goto L38
            return r0
        L38:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L65
            java.lang.Object r12 = r1.d()
            o9.e r4 = r11.$channel
            java.lang.Object r4 = r4.q()
            java.lang.Object r4 = o9.C1782h.a(r4)
            if (r4 != 0) goto L52
            r6 = r12
            goto L53
        L52:
            r6 = r4
        L53:
            androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1 r5 = new androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1
            androidx.compose.animation.core.Animatable<T, V> r7 = r11.$animatable
            androidx.compose.runtime.State<androidx.compose.animation.core.AnimationSpec<T>> r8 = r11.$animSpec$delegate
            androidx.compose.runtime.State<S7.k> r9 = r11.$listener$delegate
            r10 = 0
            r5.<init>(r6, r7, r8, r9, r10)
            r12 = 3
            r4 = 0
            m9.AbstractC1683A.n(r3, r4, r5, r12)
            goto L2b
        L65:
            C7.r r11 = C7.r.f317a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((AnimateAsStateKt$animateValueAsState$3$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
