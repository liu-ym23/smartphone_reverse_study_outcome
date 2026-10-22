package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__ErrorsKt$catchImpl$2 implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f21445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f21446b;

    public FlowKt__ErrorsKt$catchImpl$2(FlowCollector r10, Ref$ObjectRef r11) {
        this.f21445a = r10;
        this.f21446b = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Throwable] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r10, Continuation r11) {
        if ((r11 instanceof FlowKt__ErrorsKt$catchImpl$2$emit$1) == false) goto L7;
        FlowKt__ErrorsKt$catchImpl$2$emit$1 r12 = (FlowKt__ErrorsKt$catchImpl$2$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        FlowKt__ErrorsKt$catchImpl$2 r17 = (FlowKt__ErrorsKt$catchImpl$2) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L14
    L22:
        FlowKt__ErrorsKt$catchImpl$2 this = Unit.f21064a;
        return this;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        FlowCollector r18 = this.f21445a;     // Catch: Throwable -> L14
        r12.L$0 = this;     // Catch: Throwable -> L14
        r12.label = 1;     // Catch: Throwable -> L14
        if (r18.emit(r10, r12) != r15) goto L22;
        return r15;
    L14:
        th = move-exception;
        this.f21446b.element = th;
        throw th;
    L7:
        r12 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, r11);
        goto L8
    }
}
