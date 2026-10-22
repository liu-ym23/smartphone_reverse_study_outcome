package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.platform.InfiniteAnimationPolicy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a7\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086@¢\u0006\u0002\u0010\b\u001a9\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012#\b\u0004\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086H¢\u0006\u0002\u0010\b¨\u0006\u000b"}, d2 = {"withInfiniteAnimationFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withInfiniteAnimationFrameMillis", "frameTimeMillis", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InfiniteAnimationPolicyKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass2<R> implements Function1<Long, R> {
        final /* synthetic */ Function1<Long, R> $onFrame;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super Long, ? extends R> r100) {
            this.$onFrame = r100;
        }

        public final R invoke(long r100) {
            return this.$onFrame.invoke(Long.valueOf(r100 / 1000000));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Long r100) {
            return invoke(r100.longValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, d2 = {"<anonymous>", "R"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2", f = "InfiniteAnimationPolicy.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class C85442<R> extends SuspendLambda implements Function1<Continuation<? super R>, Object> {
        final /* synthetic */ Function1<Long, R> $onFrame;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C85442(Function1<? super Long, ? extends R> r100, Continuation<? super C85442> r101) {
            this.$onFrame = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new C85442(this.$onFrame, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r100) {
            return invoke((Continuation) r100);
        }

        public final Object invoke(Continuation<? super R> r100) {
            return ((C85442) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Function1<Long, R> r103 = this.$onFrame;
            this.label = 1;
            r100 = MonotonicFrameClockKt.withFrameNanos(r103, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    public static final <R> Object withInfiniteAnimationFrameMillis(Function1<? super Long, ? extends R> r100, Continuation<? super R> r101) {
        return withInfiniteAnimationFrameNanos(new AnonymousClass2(r100), r101);
    }

    private static final <R> Object withInfiniteAnimationFrameMillis$$forInline(Function1<? super Long, ? extends R> r100, Continuation<? super R> r101) {
        AnonymousClass2 r102 = new AnonymousClass2(r100);
        InlineMarker.mark(0);
        Object r103 = withInfiniteAnimationFrameNanos(r102, r101);
        InlineMarker.mark(1);
        return r103;
    }

    public static final <R> Object withInfiniteAnimationFrameNanos(Function1<? super Long, ? extends R> r100, Continuation<? super R> r101) {
        InfiniteAnimationPolicy r102 = (InfiniteAnimationPolicy) r101.getContext().get(InfiniteAnimationPolicy.Key);
        if (r102 != null) goto L7;
        return MonotonicFrameClockKt.withFrameNanos(r100, r101);
    L7:
        return r102.onInfiniteOperation(new C85442(r100, null), r101);
    }
}
