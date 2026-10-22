package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", i = {}, l = {33, 33}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combine$1$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$1$1(Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r10, Continuation<? super FlowKt__ZipKt$combine$1$1> r11) {
        this.$transform = r10;
        super(3, r11);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r10, Object[] r11, Continuation<? super Unit> r12) {
        return invoke2(r10, r11, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        kotlin.c.b(r10);
    L17:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        FlowCollector r13 = (FlowCollector) this.L$0;
        kotlin.c.b(r10);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (r13.emit(r10, this) != r11) goto L17;
        return r11;
    L10:
        kotlin.c.b(r10);
        r13 = (FlowCollector) this.L$0;
        Object[] r14 = (Object[]) this.L$1;
        Function3<Object, Object, Continuation<Object>, Object> r15 = this.$transform;
        Object r16 = r14[0];
        Object r17 = r14[1];
        this.L$0 = r13;
        this.label = 1;
        r10 = r15.invoke(r16, r17, this);
        if (r10 != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull FlowCollector<Object> r10, @NotNull Object[] r11, @Nullable Continuation<? super Unit> r12) {
        FlowKt__ZipKt$combine$1$1 r13 = new FlowKt__ZipKt$combine$1$1(this.$transform, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.f21064a);
    }
}
