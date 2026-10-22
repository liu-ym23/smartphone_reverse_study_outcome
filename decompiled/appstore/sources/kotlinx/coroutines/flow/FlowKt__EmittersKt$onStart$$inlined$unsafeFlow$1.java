package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 implements Flow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f21441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Flow f21442b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0}, l = {116, 120}, m = "collect", n = {"this", "$this$onStart_u24lambda_u241", "safeCollector"}, s = {"L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,112:1\n*E\n"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 this$0;

        public AnonymousClass1(FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r10, Continuation r11) {
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

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Function2 r10, Flow r11) {
        this.f21441a = r10;
        this.f21442b = r11;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector r10, Continuation r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L20;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        kotlin.c.b(r14);
    L29:
        return Unit.f21064a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SafeCollector r17 = (SafeCollector) r12.L$2;
        r10 = (FlowCollector) r12.L$1;
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r18 = (FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L18
    L25:
        r17.releaseIntercepted();
        Flow r19 = r18.f21442b;
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.label = 2;
        if (r19.collect(r10, r12) != r15) goto L29;
        return r15;
    L18:
        th = th;
    L32:
        r17.releaseIntercepted();
        throw th;
    L20:
        kotlin.c.b(r14);
        SafeCollector r20 = new SafeCollector(r10, r12.getContext());
        Function2 r21 = this.f21441a;     // Catch: Throwable -> L30
        r12.L$0 = this;     // Catch: Throwable -> L30
        r12.L$1 = r10;     // Catch: Throwable -> L30
        r12.L$2 = r20;     // Catch: Throwable -> L30
        r12.label = 1;     // Catch: Throwable -> L30
        kotlin.jvm.internal.p.c(6);     // Catch: Throwable -> L30
        Object r22 = r21.mo0invoke(r20, r12);     // Catch: Throwable -> L30
        kotlin.jvm.internal.p.c(7);     // Catch: Throwable -> L30
        if (r22 != r15) goto L24;
        return r15;
    L24:
        r18 = this;
        r17 = r20;
    L30:
        th = th;
        r17 = r20;
    L7:
        r12 = new AnonymousClass1(this, r11);
        goto L8
    }
}
