package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.g;
import lb.n;
import qb.b;
import rb.c;
import rb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class BaseContinuationImpl implements b<Object>, rb.b, Serializable {
    private final b<Object> completion;

    public BaseContinuationImpl(b<Object> bVar) {
        this.completion = bVar;
    }

    public b<n> create(b<?> completion) {
        g.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // rb.b
    public rb.b getCallerFrame() {
        b<Object> bVar = this.completion;
        if (bVar instanceof rb.b) {
            return (rb.b) bVar;
        }
        return null;
    }

    public final b<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        c cVar = (c) getClass().getAnnotation(c.class);
        String str = null;
        if (cVar == null) {
            return null;
        }
        int iV = cVar.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
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
        int i10 = iIntValue >= 0 ? cVar.l()[iIntValue] : -1;
        d.a aVar = d.f11765b;
        d.a aVar2 = d.f11764a;
        if (aVar == null) {
            try {
                d.a aVar3 = new d.a(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                d.f11765b = aVar3;
                aVar = aVar3;
            } catch (Exception unused2) {
                d.f11765b = aVar2;
                aVar = aVar2;
            }
        }
        if (aVar != aVar2 && (method = aVar.f11766a) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = aVar.f11767b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = aVar.f11768c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = cVar.c();
        } else {
            strC = str + '/' + cVar.c();
        }
        return new StackTraceElement(strC, cVar.m(), cVar.f(), i10);
    }

    public abstract Object invokeSuspend(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, qb.b, qb.b<java.lang.Object>] */
    @Override // qb.b
    public final void resumeWith(Object obj) {
        while (true) {
            BaseContinuationImpl baseContinuationImpl = this;
            ?? r02 = baseContinuationImpl.completion;
            g.c(r02);
            try {
                obj = baseContinuationImpl.invokeSuspend(obj);
                if (obj == CoroutineSingletons.f10059a) {
                    return;
                }
            } catch (Throwable th) {
                obj = kotlin.c.a(th);
            }
            baseContinuationImpl.releaseIntercepted();
            if (!(r02 instanceof BaseContinuationImpl)) {
                r02.resumeWith(obj);
                return;
            }
            this = r02;
        }
    }

    public String toString() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        StringBuilder sb2 = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    public b<n> create(Object obj, b<?> completion) {
        g.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
