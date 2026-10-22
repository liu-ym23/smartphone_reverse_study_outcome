package h5;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a implements f5.c, d, Serializable {
    private final f5.c completion;

    public a(f5.c cVar) {
        this.completion = cVar;
    }

    public f5.c create(f5.c completion) {
        p.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public d getCallerFrame() {
        f5.c cVar = this.completion;
        if (cVar instanceof d) {
            return (d) cVar;
        }
        return null;
    }

    public final f5.c getCompletion() {
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
        if (eVar == null || eVar.v() < 1) {
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
        int i8 = iIntValue >= 0 ? eVar.l()[iIntValue] : -1;
        a4.d dVar = f.f3035b;
        a4.d dVar2 = f.f3034a;
        if (dVar == null) {
            try {
                a4.d dVar3 = new a4.d(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                f.f3035b = dVar3;
                dVar = dVar3;
            } catch (Exception unused2) {
                f.f3035b = dVar2;
                dVar = dVar2;
            }
        }
        if (dVar != dVar2 && (method = (Method) dVar.f96b) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = (Method) dVar.f97c) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = (Method) dVar.d;
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
        return new StackTraceElement(strC, eVar.m(), eVar.f(), i8);
    }

    public abstract Object invokeSuspend(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f5.c
    public final void resumeWith(Object obj) {
        while (true) {
            a aVar = this;
            f5.c cVar = aVar.completion;
            p.b(cVar);
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj == g5.a.f2984a) {
                    return;
                }
            } catch (Throwable th) {
                obj = a.a.o(th);
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
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public f5.c create(Object obj, f5.c completion) {
        p.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
