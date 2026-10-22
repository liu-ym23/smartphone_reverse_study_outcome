package Z2;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Ref;

/* renamed from: Z2.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0149x {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z4) {
        Boolean bool = Boolean.FALSE;
        C0148w c0148w = C0148w.f2253a;
        boolean zBooleanValue = ((Boolean) coroutineContext.fold(bool, c0148w)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) coroutineContext2.fold(bool, c0148w)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return coroutineContext.plus(coroutineContext2);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new C0147v(2));
        if (zBooleanValue2) {
            objectRef.element = ((CoroutineContext) objectRef.element).fold(emptyCoroutineContext, C0146u.f2244a);
        }
        return coroutineContext3.plus((CoroutineContext) objectRef.element);
    }

    public static final I0 b(Continuation continuation, CoroutineContext coroutineContext, Object obj) {
        I0 i02 = null;
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (coroutineContext.get(J0.f2183a) != null) {
            CoroutineStackFrame callerFrame = (CoroutineStackFrame) continuation;
            while (true) {
                if ((callerFrame instanceof N) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof I0) {
                    i02 = (I0) callerFrame;
                    break;
                }
            }
            if (i02 != null) {
                i02.b0(coroutineContext, obj);
            }
        }
        return i02;
    }
}
