package kotlin.coroutines.jvm.internal;

import C7.r;
import H7.c;
import J7.b;
import J7.d;
import androidx.autofill.HintConstants;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004J\u001d\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016¢\u0006\u0004\b\r\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "LH7/c;", "", "LJ7/b;", "Ljava/io/Serializable;", "Lkotlin/Result;", "result", "LC7/r;", "resumeWith", "(Ljava/lang/Object;)V", "releaseIntercepted", "()V", "completion", "create", "(LH7/c;)LH7/c;", "value", "(Ljava/lang/Object;LH7/c;)LH7/c;", "", "toString", "()Ljava/lang/String;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "LH7/c;", "getCompletion", "()LH7/c;", "getCallerFrame", "()LJ7/b;", "callerFrame", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseContinuationImpl implements c<Object>, b, Serializable {
    private final c<Object> completion;

    public BaseContinuationImpl(c cVar) {
        this.completion = cVar;
    }

    public c<r> create(c<?> completion) {
        k.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // J7.b
    public b getCallerFrame() {
        c<Object> cVar = this.completion;
        if (cVar instanceof b) {
            return (b) cVar;
        }
        return null;
    }

    public final c<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        J7.c cVar = (J7.c) getClass().getAnnotation(J7.c.class);
        String str = null;
        if (cVar == null || cVar.v() < 1) {
            return null;
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? cVar.l()[iIntValue] : -1;
        A5.c cVar2 = d.b;
        A5.c cVar3 = d.f879a;
        if (cVar2 == null) {
            try {
                A5.c cVar4 = new A5.c(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(HintConstants.AUTOFILL_HINT_NAME, null), 3);
                d.b = cVar4;
                cVar2 = cVar4;
            } catch (Exception unused2) {
                d.b = cVar3;
                cVar2 = cVar3;
            }
        }
        if (cVar2 != cVar3 && (method = (Method) cVar2.b) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = (Method) cVar2.c) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = (Method) cVar2.d;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = cVar.c();
        } else {
            strC = str + JsonPointer.SEPARATOR + cVar.c();
        }
        return new StackTraceElement(strC, cVar.m(), cVar.f(), i);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [H7.c, H7.c<java.lang.Object>, java.lang.Object] */
    @Override // H7.c
    public final void resumeWith(Object result) {
        while (true) {
            BaseContinuationImpl baseContinuationImpl = this;
            ?? r02 = baseContinuationImpl.completion;
            k.c(r02);
            try {
                result = baseContinuationImpl.invokeSuspend(result);
                if (result == CoroutineSingletons.f4909a) {
                    return;
                }
            } catch (Throwable th) {
                result = kotlin.b.a(th);
            }
            baseContinuationImpl.releaseIntercepted();
            if (!(r02 instanceof BaseContinuationImpl)) {
                r02.resumeWith(result);
                return;
            }
            this = r02;
        }
    }

    public String toString() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public c<r> create(Object value, c<?> completion) {
        k.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
