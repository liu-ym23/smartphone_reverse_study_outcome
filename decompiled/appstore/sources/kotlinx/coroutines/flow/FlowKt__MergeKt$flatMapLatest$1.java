package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it"}, k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", i = {}, l = {193, 193}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n*L\n1#1,218:1\n*E\n"})
public final class FlowKt__MergeKt$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Flow<Object>>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$flatMapLatest$1(Function2<Object, ? super Continuation<? super Flow<Object>>, ? extends Object> r10, Continuation<? super FlowKt__MergeKt$flatMapLatest$1> r11) {
        this.$transform = r10;
        super(3, r11);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r10, Object r11, Continuation<? super Unit> r12) {
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
        if (c.r(r13, (Flow) r10, this) != r11) goto L17;
        return r11;
    L10:
        kotlin.c.b(r10);
        r13 = (FlowCollector) this.L$0;
        Object r14 = this.L$1;
        Function2<Object, Continuation<? super Flow<Object>>, Object> r15 = this.$transform;
        this.L$0 = r13;
        this.label = 1;
        r10 = r15.mo0invoke(r14, this);
        if (r10 != r11) goto L13;
        return r11;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object r10) {
        FlowCollector r11 = (FlowCollector) this.L$0;
        Object r12 = this.L$1;
        Flow r13 = (Flow) this.$transform.mo0invoke(r12, this);
        kotlin.jvm.internal.p.c(0);
        c.r(r11, r13, this);
        kotlin.jvm.internal.p.c(1);
        return Unit.f21064a;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull FlowCollector<Object> r10, Object r11, @Nullable Continuation<? super Unit> r12) {
        FlowKt__MergeKt$flatMapLatest$1 r13 = new FlowKt__MergeKt$flatMapLatest$1(this.$transform, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.f21064a);
    }
}
