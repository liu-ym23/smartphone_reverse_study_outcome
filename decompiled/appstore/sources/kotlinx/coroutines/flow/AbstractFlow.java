package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractFlow implements Flow, CancellableFlow {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.AbstractFlow$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", i = {0}, l = {230}, m = "collect", n = {"safeCollector"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AbstractFlow this$0;

        public AnonymousClass1(AbstractFlow r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    public AbstractFlow() {
    }

    public abstract Object a(FlowCollector r10, Continuation r11);

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector r10, Continuation r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        SafeCollector r17 = (SafeCollector) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L14
    L23:
        r17.releaseIntercepted();
        return Unit.f21064a;
    L14:
        th = th;
    L27:
        r17.releaseIntercepted();
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        SafeCollector r18 = new SafeCollector(r10, r12.getContext());
        r12.L$0 = r18;     // Catch: Throwable -> L25
        r12.label = 1;     // Catch: Throwable -> L25
        if (a(r18, r12) != r15) goto L22;
        return r15;
    L22:
        r17 = r18;
    L25:
        th = th;
        r17 = r18;
    L7:
        r12 = new AnonymousClass1(this, r11);
        goto L8
    }
}
