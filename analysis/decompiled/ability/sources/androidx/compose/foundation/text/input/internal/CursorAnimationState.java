package androidx.compose.foundation.text.input.internal;

import C7.r;
import S7.n;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003R*\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR+\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "snapToVisibleAndAnimate", "(LH7/c;)Ljava/lang/Object;", "cancelAndHide", "Ljava/util/concurrent/atomic/AtomicReference;", "Lm9/c0;", "Landroidx/compose/foundation/AtomicReference;", "animationJob", "Ljava/util/concurrent/atomic/AtomicReference;", "", "<set-?>", "cursorAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getCursorAlpha", "()F", "setCursorAlpha", "(F)V", "cursorAlpha", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CursorAnimationState {
    public static final int $stable = 8;
    private AtomicReference<c0> animationJob = new AtomicReference<>(null);

    /* renamed from: cursorAlpha$delegate, reason: from kotlin metadata */
    private final MutableFloatState cursorAlpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    @J7.c(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2", f = "CursorAnimationState.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        @J7.c(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1", f = "CursorAnimationState.kt", l = {69, 77, 79}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ c0 $oldJob;
            int label;
            final /* synthetic */ CursorAnimationState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(c0 c0Var, CursorAnimationState cursorAnimationState, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$oldJob = c0Var;
                this.this$0 = cursorAnimationState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.$oldJob, this.this$0, cVar);
            }

            /* JADX WARN: Path cross not found for [B:18:0x002f, B:21:0x0038], limit reached: 27 */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0048 A[Catch: all -> 0x0016, TRY_LEAVE, TryCatch #0 {all -> 0x0016, blocks: (B:7:0x0012, B:21:0x0038, B:24:0x0048, B:13:0x0020), top: B:29:0x000a }] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0053 -> B:21:0x0038). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r1 = r8.label
                    r2 = 0
                    r3 = 500(0x1f4, double:2.47E-321)
                    r5 = 3
                    r6 = 2
                    r7 = 1
                    if (r1 == 0) goto L28
                    if (r1 == r7) goto L24
                    if (r1 == r6) goto L20
                    if (r1 != r5) goto L18
                    kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L16
                    goto L38
                L16:
                    r9 = move-exception
                    goto L56
                L18:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L20:
                    kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L16
                    goto L48
                L24:
                    kotlin.b.b(r9)
                    goto L38
                L28:
                    kotlin.b.b(r9)
                    m9.c0 r9 = r8.$oldJob
                    if (r9 == 0) goto L38
                    r8.label = r7
                    java.lang.Object r9 = kotlinx.coroutines.a.e(r9, r8)
                    if (r9 != r0) goto L38
                    goto L55
                L38:
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r9 = r8.this$0     // Catch: java.lang.Throwable -> L16
                    r1 = 1065353216(0x3f800000, float:1.0)
                    androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r9, r1)     // Catch: java.lang.Throwable -> L16
                    r8.label = r6     // Catch: java.lang.Throwable -> L16
                    java.lang.Object r9 = kotlinx.coroutines.a.f(r3, r8)     // Catch: java.lang.Throwable -> L16
                    if (r9 != r0) goto L48
                    goto L55
                L48:
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r9 = r8.this$0     // Catch: java.lang.Throwable -> L16
                    androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r9, r2)     // Catch: java.lang.Throwable -> L16
                    r8.label = r5     // Catch: java.lang.Throwable -> L16
                    java.lang.Object r9 = kotlinx.coroutines.a.f(r3, r8)     // Catch: java.lang.Throwable -> L16
                    if (r9 != r0) goto L38
                L55:
                    return r0
                L56:
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r8 = r8.this$0
                    androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r8, r2)
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnimationState.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = CursorAnimationState.this.new AnonymousClass2(cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return Boolean.valueOf(CursorAnimationState.this.animationJob.compareAndSet(null, AbstractC1683A.n((InterfaceC1733z) this.L$0, null, new AnonymousClass1((c0) CursorAnimationState.this.animationJob.getAndSet(null), CursorAnimationState.this, null), 3)));
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCursorAlpha(float f) {
        this.cursorAlpha.setFloatValue(f);
    }

    public final void cancelAndHide() {
        c0 andSet = this.animationJob.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(null);
        }
    }

    public final float getCursorAlpha() {
        return this.cursorAlpha.getFloatValue();
    }

    public final Object snapToVisibleAndAnimate(H7.c<? super r> cVar) {
        Object objF = AbstractC1683A.f(new AnonymousClass2(null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }
}
