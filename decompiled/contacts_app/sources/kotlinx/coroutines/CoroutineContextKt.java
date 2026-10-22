package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a8\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0003H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003H\u0007\u001a\u0013\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u00020\u001dH\u0080\u0010\u001a(\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006 "}, d2 = {"DEBUG_THREAD_NAME_SEPARATOR", "", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "foldCopies", "originalContext", "appendContext", "isNewCoroutine", "", "withContinuationContext", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "Lkotlin/coroutines/Continuation;", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withCoroutineContext", "context", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasCopyableElements", "newCoroutineContext", "addedContext", "Lkotlinx/coroutines/CoroutineScope;", "undispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateUndispatchedCompletion", "oldValue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutineContextKt {
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";

    public static final CoroutineContext newCoroutineContext(CoroutineScope r2, CoroutineContext r3) {
        CoroutineContext r4 = foldCopies(r2.getCoroutineContext(), r3, true);
        if (DebugKt.getDEBUG() == false) goto L5;
        CoroutineContext r5 = r4.plus(new CoroutineId(DebugKt.getCOROUTINE_ID().incrementAndGet()));
    L7:
        if (r4 != Dispatchers.getDefault()) goto L9;
        return r5;
    L9:
        if (r4.get(ContinuationInterceptor.Key) == null) goto L11;
        return r5;
    L11:
        return r5.plus(Dispatchers.getDefault());
    L5:
        r5 = r4;
        goto L7
    }

    public static final CoroutineContext newCoroutineContext(CoroutineContext r1, CoroutineContext r2) {
        if (hasCopyableElements(r2) == true) goto L7;
        return r1.plus(r2);
    L7:
        return foldCopies(r1, r2, false);
    }

    private static final boolean hasCopyableElements(CoroutineContext r2) {
        return ((Boolean) r2.fold(false, C05201.INSTANCE)).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.Object] */
    private static final CoroutineContext foldCopies(CoroutineContext r3, CoroutineContext r4, final boolean r5) {
        boolean r0 = hasCopyableElements(r3);
        boolean r1 = hasCopyableElements(r4);
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        return r3.plus(r4);
    L7:
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = r4;
        CoroutineContext r6 = (CoroutineContext) r3.fold(EmptyCoroutineContext.INSTANCE, new CoroutineContextKt$foldCopies$folded$1(r2, r5));
        if (r1 == false) goto L11;
        r2.element = ((CoroutineContext) r2.element).fold(EmptyCoroutineContext.INSTANCE, AnonymousClass1.INSTANCE);
    L11:
        return r6.plus((CoroutineContext) r2.element);
    }

    public static final <T> T withCoroutineContext(CoroutineContext r1, Object r2, Function0<? extends T> r3) {
        Object r4 = ThreadContextKt.updateThreadContext(r1, r2);
        T r5 = r3.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        ThreadContextKt.restoreThreadContext(r1, r4);
        InlineMarker.finallyEnd(1);
        return r5;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        ThreadContextKt.restoreThreadContext(r1, r4);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T> T withContinuationContext(Continuation<?> r2, Object r3, Function0<? extends T> r4) {
        CoroutineContext r0 = r2.getContext();
        Object r5 = ThreadContextKt.updateThreadContext(r0, r3);
        if (r5 == ThreadContextKt.NO_THREAD_ELEMENTS) goto L5;
        UndispatchedCoroutine<?> r6 = updateUndispatchedCompletion(r2, r0, r5);
    L23:
        T r7 = r4.invoke();     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);
        if (r6 != null) goto L11;
    L12:
        ThreadContextKt.restoreThreadContext(r0, r5);
    L13:
        InlineMarker.finallyEnd(1);
        return r7;
    L11:
        if (r6.clearThreadContext() == false) goto L13;
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r6 != null) goto L19;
    L20:
        ThreadContextKt.restoreThreadContext(r0, r5);
    L21:
        InlineMarker.finallyEnd(1);
        throw th;
    L19:
        if (r6.clearThreadContext() == false) goto L21;
    L5:
        r6 = null;
        goto L23
    }

    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(Continuation<?> r2, CoroutineContext r3, Object r4) {
        if ((r2 instanceof CoroutineStackFrame) == true) goto L6;
        return null;
    L6:
        if (r3.get(UndispatchedMarker.INSTANCE) == null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return null;
    L11:
        UndispatchedCoroutine<?> r5 = undispatchedCompletion((CoroutineStackFrame) r2);
        if (r5 == null) goto L14;
        r5.saveThreadContext(r3, r4);
    L14:
        return r5;
    L8:
        r0 = false;
        goto L9
    }

    public static final UndispatchedCoroutine<?> undispatchedCompletion(CoroutineStackFrame r2) {
    L3:
        if ((r2 instanceof DispatchedCoroutine) == true) goto L4;
        r2 = r2.getCallerFrame();
        if (r2 == null) goto L7;
        if ((r2 instanceof UndispatchedCoroutine) == false) goto L3;
        return (UndispatchedCoroutine) r2;
    L7:
        return null;
    L4:
        return null;
    }

    public static final String getCoroutineName(CoroutineContext r2) {
        if (DebugKt.getDEBUG() == true) goto L5;
        return null;
    L5:
        CoroutineId r0 = (CoroutineId) r2.get(CoroutineId.Key);
        if (r0 != null) goto L8;
        return null;
    L8:
        CoroutineName r3 = (CoroutineName) r2.get(CoroutineName.Key);
        if (r3 == null) goto L12;
        String r4 = r3.getName();
        if (r4 == null) goto L12;
    L14:
        return r4 + '#' + r0.getId();
    L12:
        r4 = "coroutine";
        goto L14
    }
}
