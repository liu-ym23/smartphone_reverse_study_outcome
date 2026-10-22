package i7;

import i5.l;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import q7.k;
import w7.e0;

/* loaded from: classes.dex */
public abstract class a implements g7.d, d, Serializable {
    private final g7.d completion;

    public a(g7.d dVar) {
        this.completion = dVar;
    }

    public g7.d create(g7.d dVar) {
        k.e(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // i7.d
    public d getCallerFrame() {
        g7.d dVar = this.completion;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    public final g7.d getCompletion() {
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
        int i2 = iIntValue >= 0 ? eVar.l()[iIntValue] : -1;
        l lVar = f.f4734b;
        l lVar2 = f.f4733a;
        if (lVar == null) {
            try {
                l lVar3 = new l(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null), 14);
                f.f4734b = lVar3;
                lVar = lVar3;
            } catch (Exception unused2) {
                f.f4734b = lVar2;
                lVar = lVar2;
            }
        }
        if (lVar != lVar2 && (method = (Method) lVar.f4687g) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = (Method) lVar.f4688h) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = (Method) lVar.f4689i;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = eVar.c();
        } else {
            strC = str + '/' + eVar.c();
        }
        return new StackTraceElement(strC, eVar.m(), eVar.f(), i2);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g7.d
    public final void resumeWith(Object obj) {
        while (true) {
            a aVar = this;
            g7.d dVar = aVar.completion;
            k.b(dVar);
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj == h7.a.f4212f) {
                    return;
                }
            } catch (Throwable th) {
                obj = e0.n(th);
            }
            aVar.releaseIntercepted();
            if (!(dVar instanceof a)) {
                dVar.resumeWith(obj);
                return;
            }
            this = dVar;
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

    public g7.d create(Object obj, g7.d dVar) {
        k.e(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
