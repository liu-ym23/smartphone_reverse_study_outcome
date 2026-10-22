package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext r10, CoroutineContext r11, final boolean r12) {
        boolean r13 = c(r10);
        boolean r14 = c(r11);
        if (r13 == true) goto L7;
        if (r14 == true) goto L7;
        return r10.plus(r11);
    L7:
        final Ref$ObjectRef r15 = new Ref$ObjectRef();
        r15.element = r11;
        EmptyCoroutineContext r16 = EmptyCoroutineContext.INSTANCE;
        CoroutineContext r17 = (CoroutineContext) r10.fold(r16, new CoroutineContextKt$foldCopies$folded$1(r15, r12));
        if (r14 == false) goto L11;
        r15.element = ((CoroutineContext) r15.element).fold(r16, CoroutineContextKt$foldCopies$1.INSTANCE);
    L11:
        return r17.plus((CoroutineContext) r15.element);
    }

    public static final String b(CoroutineContext r10) {
        return null;
    }

    public static final boolean c(CoroutineContext r10) {
        return ((Boolean) r10.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.INSTANCE)).booleanValue();
    }

    public static final CoroutineContext d(CoroutineContext r10, CoroutineContext r11) {
        if (c(r11) == true) goto L7;
        return r10.plus(r11);
    L7:
        return a(r10, r11, false);
    }

    public static final CoroutineContext e(CoroutineScope r10, CoroutineContext r11) {
        CoroutineContext r12 = a(r10.getCoroutineContext(), r11, true);
        if (r12 != l0.a()) goto L5;
        return r12;
    L5:
        if (r12.get(ContinuationInterceptor.Key) == null) goto L7;
        return r12;
    L7:
        return r12.plus(l0.a());
    }

    public static final d2 f(CoroutineStackFrame r10) {
    L3:
        if ((r10 instanceof i0) == true) goto L4;
        r10 = r10.getCallerFrame();
        if (r10 == null) goto L7;
        if ((r10 instanceof d2) == false) goto L3;
        return (d2) r10;
    L7:
        return null;
    L4:
        return null;
    }

    public static final d2 g(Continuation r10, CoroutineContext r11, Object r12) {
        if ((r10 instanceof CoroutineStackFrame) == true) goto L6;
        return null;
    L6:
        if (r11.get(e2.f21419a) == null) goto L11;
        d2 r13 = f((CoroutineStackFrame) r10);
        if (r13 == null) goto L10;
        r13.s0(r11, r12);
    L10:
        return r13;
    L11:
        return null;
    }
}
