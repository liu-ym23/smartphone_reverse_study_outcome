package pb;

import com.fasterxml.jackson.core.JsonPointer;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a implements nb.c, d, Serializable {
    private final nb.c completion;

    public a(nb.c cVar) {
        this.completion = cVar;
    }

    public nb.c create(nb.c cVar) {
        cVar.getClass();
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public d getCallerFrame() {
        nb.c cVar = this.completion;
        if (cVar instanceof d) {
            return (d) cVar;
        }
        return null;
    }

    public final nb.c getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str = null;
        if (eVar == null) {
            return null;
        }
        int iV = eVar.v();
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
        int i = iIntValue >= 0 ? eVar.l()[iIntValue] : -1;
        m mVar = f.f9941b;
        m mVar2 = f.f9940a;
        if (mVar == null) {
            try {
                m mVar3 = new m(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                f.f9941b = mVar3;
                mVar = mVar3;
            } catch (Exception unused2) {
                f.f9941b = mVar2;
                mVar = mVar2;
            }
        }
        if (mVar != mVar2 && (method = (Method) mVar.f9741f) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = (Method) mVar.f9742g) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = (Method) mVar.f9743h;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = eVar.c();
        } else {
            strC = str + JsonPointer.SEPARATOR + eVar.c();
        }
        return new StackTraceElement(strC, eVar.m(), eVar.f(), i);
    }

    public abstract Object invokeSuspend(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nb.c
    public final void resumeWith(Object obj) {
        while (true) {
            a aVar = this;
            nb.c cVar = aVar.completion;
            cVar.getClass();
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj == ob.a.f9351c) {
                    return;
                }
            } catch (Throwable th) {
                obj = id.c.l(th);
            }
            aVar.releaseIntercepted();
            if (!(cVar instanceof a)) {
                cVar.resumeWith(obj);
                return;
            }
            this = cVar;
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

    public nb.c create(Object obj, nb.c cVar) {
        cVar.getClass();
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
