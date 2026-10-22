package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "", "animate", "", "<init>", "(Z)V", "getAnimate", "()Z", "animationJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "Landroidx/compose/foundation/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "<set-?>", "", "cursorAlpha", "getCursorAlpha", "()F", "setCursorAlpha", "(F)V", "cursorAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "snapToVisibleAndAnimate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelAndHide", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CursorAnimationState {
    public static final int $stable = 8;
    private final boolean animate;
    private AtomicReference<Job> animationJob;
    private final MutableFloatState cursorAlpha$delegate;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2", f = "CursorAnimationState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CursorAnimationState this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1", f = "CursorAnimationState.kt", i = {}, l = {72, 77, 79, 81}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $oldJob;
            int label;
            final /* synthetic */ CursorAnimationState this$0;

            public AnonymousClass1(Job r100, CursorAnimationState r101, Continuation<? super AnonymousClass1> r102) {
                this.$oldJob = r100;
                this.this$0 = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass1(this.$oldJob, this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0077 -> B:43:0x007a). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                if (r101 == 0) goto L18;
                if (r101 == 1) goto L17;
                if (r101 == 2) goto L13;
                if (r101 == 3) goto L12;
                if (r101 != 4) goto L11;
                ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L15
                AnonymousClass1 r111 = this;
            L43:
                CursorAnimationState.access$setCursorAlpha(r111.this$0, 1.0f);     // Catch: Throwable -> L39
            L31:
                r111.label = 3;     // Catch: Throwable -> L39
                if (DelayKt.delay(500, r111) != r100) goto L34;
                return r100;
            L34:
                CursorAnimationState.access$setCursorAlpha(r111.this$0, 0.0f);     // Catch: Throwable -> L39
                r111.label = 4;     // Catch: Throwable -> L39
                if (DelayKt.delay(500, r111) != r100) goto L43;
                return r100;
            L39:
                th = move-exception;
                AnonymousClass1 r102 = r111;
                th = th;
            L41:
                CursorAnimationState.access$setCursorAlpha(r102.this$0, 0.0f);
                throw th;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L15
                r111 = this;
                goto L34
            L13:
                ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L15
            L29:
                throw new KotlinNothingValueException();     // Catch: Throwable -> L15
            L17:
                ResultKt.throwOnFailure(r110);
            L23:
                CursorAnimationState.access$setCursorAlpha(this.this$0, 1.0f);     // Catch: Throwable -> L15
                if (this.this$0.getAnimate() == true) goto L30;
                this.label = 2;     // Catch: Throwable -> L15
                if (DelayKt.awaitCancellation(this) != r100) goto L29;
                return r100;
            L30:
                r111 = this;
                goto L31
            L18:
                ResultKt.throwOnFailure(r110);
                Job r112 = this.$oldJob;
                if (r112 == null) goto L23;
                this.label = 1;
                if (JobKt.cancelAndJoin(r112, this) != r100) goto L23;
                return r100;
            L15:
                th = th;
                r102 = this;
                goto L41
            }
        }

        public AnonymousClass2(CursorAnimationState r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass2 r102 = new AnonymousClass2(this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r100);
            CoroutineScope r101 = (CoroutineScope) this.L$0;
            Job r102 = (Job) CursorAnimationState.access$getAnimationJob$p(this.this$0).getAndSet(null);
            AtomicReference r103 = CursorAnimationState.access$getAnimationJob$p(this.this$0);
            Job r104 = BuildersKt.launch$default(r101, null, null, new AnonymousClass1(r102, this.this$0, null), 3, null);
        L6:
            if (r103.compareAndSet(null, r104) == true) goto L7;
            if (r103.get() == null) goto L6;
            boolean r105 = false;
        L12:
            return Boxing.boxBoolean(r105);
        L7:
            r105 = true;
            goto L12
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void cancelAndHide() {
        Job r100 = this.animationJob.getAndSet(null);
        if (r100 == null) goto L6;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
        return;
    }

    public final float getCursorAlpha() {
        return this.cursorAlpha$delegate.getFloatValue();
    }

    public final boolean getAnimate() {
        return this.animate;
    }

    public CursorAnimationState(boolean r100) {
        this.animate = r100;
        this.animationJob = new AtomicReference(null);
        this.cursorAlpha$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }

    public static final /* synthetic */ AtomicReference access$getAnimationJob$p(CursorAnimationState r100) {
        return r100.animationJob;
    }

    private final void setCursorAlpha(float r100) {
        this.cursorAlpha$delegate.setFloatValue(r100);
    }

    public final Object snapToVisibleAndAnimate(Continuation<? super Unit> r100) {
        Object r101 = CoroutineScopeKt.coroutineScope(new AnonymousClass2(this, null), r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$setCursorAlpha(CursorAnimationState r100, float r101) {
        r100.setCursorAlpha(r101);
    }
}
