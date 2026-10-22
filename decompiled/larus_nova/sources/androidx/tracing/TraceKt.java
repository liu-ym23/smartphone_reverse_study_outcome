package androidx.tracing;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a/\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0007\u001a\u00020\u00042\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001aA\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001aG\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u001e\b\u0004\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0086Hø\u0001\u0001¢\u0006\u0002\u0010\u0013\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"trace", ExifInterface.GPS_DIRECTION_TRUE, "lazyLabel", "Lkotlin/Function0;", "", "block", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "label", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "traceAsync", "lazyMethodName", "lazyCookie", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "methodName", BaseHttpRequestInfo.KEY_COOKIE, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tracing-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TraceKt {

    /* JADX INFO: renamed from: androidx.tracing.TraceKt$traceAsync$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "androidx.tracing.TraceKt", f = "Trace.kt", i = {0, 0}, l = {76}, m = "traceAsync", n = {"methodName", BaseHttpRequestInfo.KEY_COOKIE}, s = {"L$0", "I$0"})
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        int I$0;
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
            return TraceKt.traceAsync(null, 0, null, this);
        }
    }

    public static final <T> T trace(Function0<String> r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "lazyLabel");
        Intrinsics.checkNotNullParameter(r101, "block");
        boolean r102 = Trace.isEnabled();
        if (r102 == false) goto L18;
        Trace.beginSection(r100.invoke());
    L18:
        T r103 = r101.invoke();     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        if (r102 == false) goto L10;
        Trace.endSection();
    L10:
        InlineMarker.finallyEnd(1);
        return r103;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r102 == false) goto L16;
        Trace.endSection();
    L16:
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T> T trace(String r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "block");
        Trace.beginSection(r100);
        T r102 = r101.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        Trace.endSection();
        InlineMarker.finallyEnd(1);
        return r102;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        Trace.endSection();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T> T traceAsync(Function0<String> r100, Function0<Integer> r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "lazyMethodName");
        Intrinsics.checkNotNullParameter(r101, "lazyCookie");
        Intrinsics.checkNotNullParameter(r102, "block");
        if (Trace.isEnabled() == false) goto L5;
        String r103 = r100.invoke();
        int r104 = r101.invoke().intValue();
        Trace.beginAsyncSection(r103, r104);
    L19:
        T r105 = r102.invoke();     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        if (r103 == null) goto L11;
        Trace.endAsyncSection(r103, r104);
    L11:
        InlineMarker.finallyEnd(1);
        return r105;
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r103 == null) goto L17;
        Trace.endAsyncSection(r103, r104);
    L17:
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r103 = null;
        r104 = 0;
        goto L19
    }

    public static final <T> Object traceAsync(String r100, int r101, Function1<? super Continuation<? super T>, ? extends Object> r102, Continuation<? super T> r103) {
        if ((r103 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r104 = (AnonymousClass1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 != 1) goto L15;
        r101 = r104.I$0;
        r100 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L22
    L20:
        InlineMarker.finallyStart(1);
        Trace.endAsyncSection(r100, r101);
        InlineMarker.finallyEnd(1);
        return r106;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r106);
        Trace.beginAsyncSection(r100, r101);
        r104.L$0 = r100;     // Catch: Throwable -> L22
        r104.I$0 = r101;     // Catch: Throwable -> L22
        r104.label = 1;     // Catch: Throwable -> L22
        r106 = r102.invoke(r104);     // Catch: Throwable -> L22
        if (r106 != r107) goto L20;
        return r107;
    L22:
        th = move-exception;
        InlineMarker.finallyStart(1);
        Trace.endAsyncSection(r100, r101);
        InlineMarker.finallyEnd(1);
        throw th;
    L7:
        r104 = new AnonymousClass1(r103);
        goto L8
    }

    private static final <T> Object traceAsync$$forInline(String r100, int r101, Function1<? super Continuation<? super T>, ? extends Object> r102, Continuation<? super T> r103) {
        Trace.beginAsyncSection(r100, r101);
        Object r104 = r102.invoke(r103);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        Trace.endAsyncSection(r100, r101);
        InlineMarker.finallyEnd(1);
        return r104;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        Trace.endAsyncSection(r100, r101);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
