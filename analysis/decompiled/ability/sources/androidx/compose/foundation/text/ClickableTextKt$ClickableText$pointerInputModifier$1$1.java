package androidx.compose.foundation.text;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@c(c = "androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1", f = "ClickableText.kt", l = {184}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ClickableTextKt$ClickableText$pointerInputModifier$1$1 extends SuspendLambda implements n {
    final /* synthetic */ InterfaceC1733z $coroutineScope;
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ k $onClick;
    final /* synthetic */ k $onHover;
    private /* synthetic */ Object L$0;
    int label;

    @c(c = "androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1$1", f = "ClickableText.kt", l = {175}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ PointerInputScope $$this$pointerInput;
        final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
        final /* synthetic */ k $onHover;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PointerInputScope pointerInputScope, k kVar, MutableState<TextLayoutResult> mutableState, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$$this$pointerInput = pointerInputScope;
            this.$onHover = kVar;
            this.$layoutResult = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$$this$pointerInput, this.$onHover, this.$layoutResult, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                PointerInputScope pointerInputScope = this.$$this$pointerInput;
                PointerEventPass pointerEventPass = PointerEventPass.Main;
                final k kVar = this.$onHover;
                final MutableState<TextLayoutResult> mutableState = this.$layoutResult;
                k kVar2 = new k() { // from class: androidx.compose.foundation.text.ClickableTextKt.ClickableText.pointerInputModifier.1.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        m1008invokek4lQ0M(((Offset) obj2).m3905unboximpl());
                        return r.f317a;
                    }

                    /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                    public final void m1008invokek4lQ0M(long j5) {
                        Integer numClickableText_03UYbkw$getOffset = ClickableTextKt.ClickableText_03UYbkw$getOffset(mutableState, j5);
                        if (kotlin.jvm.internal.k.b(ref$ObjectRef.f4920a, numClickableText_03UYbkw$getOffset)) {
                            return;
                        }
                        ref$ObjectRef.f4920a = numClickableText_03UYbkw$getOffset;
                        kVar.invoke(numClickableText_03UYbkw$getOffset);
                    }
                };
                this.label = 1;
                if (PointerMoveDetectorKt.detectMoves(pointerInputScope, pointerEventPass, kVar2, this) == coroutineSingletons) {
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
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableTextKt$ClickableText$pointerInputModifier$1$1(InterfaceC1733z interfaceC1733z, k kVar, MutableState<TextLayoutResult> mutableState, k kVar2, H7.c<? super ClickableTextKt$ClickableText$pointerInputModifier$1$1> cVar) {
        super(2, cVar);
        this.$coroutineScope = interfaceC1733z;
        this.$onHover = kVar;
        this.$layoutResult = mutableState;
        this.$onClick = kVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        ClickableTextKt$ClickableText$pointerInputModifier$1$1 clickableTextKt$ClickableText$pointerInputModifier$1$1 = new ClickableTextKt$ClickableText$pointerInputModifier$1$1(this.$coroutineScope, this.$onHover, this.$layoutResult, this.$onClick, cVar);
        clickableTextKt$ClickableText$pointerInputModifier$1$1.L$0 = obj;
        return clickableTextKt$ClickableText$pointerInputModifier$1$1;
    }

    @Override // S7.n
    public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
        return ((ClickableTextKt$ClickableText$pointerInputModifier$1$1) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AbstractC1683A.n(this.$coroutineScope, null, new AnonymousClass1(pointerInputScope, this.$onHover, this.$layoutResult, null), 3);
            final k kVar = this.$onClick;
            final MutableState<TextLayoutResult> mutableState = this.$layoutResult;
            k kVar2 = new k() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m1009invokek4lQ0M(((Offset) obj2).m3905unboximpl());
                    return r.f317a;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m1009invokek4lQ0M(long j5) {
                    Integer numClickableText_03UYbkw$getOffset = ClickableTextKt.ClickableText_03UYbkw$getOffset(mutableState, j5);
                    if (numClickableText_03UYbkw$getOffset != null) {
                        kVar.invoke(numClickableText_03UYbkw$getOffset);
                    }
                }
            };
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, kVar2, this, 7, null) == coroutineSingletons) {
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
}
