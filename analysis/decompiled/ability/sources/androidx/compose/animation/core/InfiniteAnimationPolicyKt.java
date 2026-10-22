package androidx.compose.animation.core;

import C7.r;
import J7.c;
import S7.k;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.platform.InfiniteAnimationPolicy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a*\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a,\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0086H¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"R", "Lkotlin/Function1;", "", "onFrame", "withInfiniteAnimationFrameNanos", "(LS7/k;LH7/c;)Ljava/lang/Object;", "withInfiniteAnimationFrameMillis", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InfiniteAnimationPolicyKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "R", "it", "", "invoke", "(J)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements k {
        final /* synthetic */ k $onFrame;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar) {
            super(1);
            this.$onFrame = kVar;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [R, java.lang.Object] */
        public final R invoke(long j5) {
            return this.$onFrame.invoke(Long.valueOf(j5 / AnimationKt.MillisToNanos));
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).longValue());
        }
    }

    @c(c = "androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2", f = "InfiniteAnimationPolicy.kt", l = {31}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\u008a@"}, d2 = {"<anonymous>", "R"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03582 extends SuspendLambda implements k {
        final /* synthetic */ k $onFrame;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03582(k kVar, H7.c<? super C03582> cVar) {
            super(1, cVar);
            this.$onFrame = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new C03582(this.$onFrame, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super R> cVar) {
            return ((C03582) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            k kVar = this.$onFrame;
            this.label = 1;
            Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(kVar, this);
            return objWithFrameNanos == coroutineSingletons ? coroutineSingletons : objWithFrameNanos;
        }
    }

    public static final <R> Object withInfiniteAnimationFrameMillis(k kVar, H7.c<? super R> cVar) {
        return withInfiniteAnimationFrameNanos(new AnonymousClass2(kVar), cVar);
    }

    public static final <R> Object withInfiniteAnimationFrameNanos(k kVar, H7.c<? super R> cVar) {
        InfiniteAnimationPolicy infiniteAnimationPolicy = (InfiniteAnimationPolicy) cVar.getContext().get(InfiniteAnimationPolicy.INSTANCE);
        return infiniteAnimationPolicy == null ? MonotonicFrameClockKt.withFrameNanos(kVar, cVar) : infiniteAnimationPolicy.onInfiniteOperation(new C03582(kVar, null), cVar);
    }
}
