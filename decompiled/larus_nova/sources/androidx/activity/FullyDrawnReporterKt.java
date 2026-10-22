package androidx.activity;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"reportWhenComplete", "", "Landroidx/activity/FullyDrawnReporter;", "reporter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FullyDrawnReporterKt {

    /* JADX INFO: renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", i = {0}, l = {185}, m = "reportWhenComplete", n = {"$this$reportWhenComplete"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    public static final Object reportWhenComplete(FullyDrawnReporter r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r103 = (AnonymousClass1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        FullyDrawnReporter r108 = (FullyDrawnReporter) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L25
        FullyDrawnReporter r109 = r108;
    L23:
        InlineMarker.finallyStart(1);
        r109.removeReporter();
        InlineMarker.finallyEnd(1);
        r100 = Unit.INSTANCE;
        return r100;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        r100.addReporter();
        if (r100.isFullyDrawnReported() == true) goto L19;
        r103.L$0 = r100;     // Catch: Throwable -> L25
        r103.label = 1;     // Catch: Throwable -> L25
        r109 = r100;
        if (r101.invoke(r103) != r106) goto L23;
        return r106;
    L19:
        return Unit.INSTANCE;
    L25:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.removeReporter();
        InlineMarker.finallyEnd(1);
        throw th;
    L7:
        r103 = new AnonymousClass1(r102);
        goto L8
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        r100.addReporter();
        if (r100.isFullyDrawnReported() == false) goto L13;
        return Unit.INSTANCE;
    L13:
        r101.invoke(r102);     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        r100.removeReporter();
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.removeReporter();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
