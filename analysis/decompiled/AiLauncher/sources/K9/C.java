package K9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public final class C extends x implements Z9.w {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4145a;

    public C(Object recordComponent) {
        kotlin.jvm.internal.p.i(recordComponent, "recordComponent");
        this.f4145a = recordComponent;
    }

    @Override // K9.x
    public Member N() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method methodC = C0920a.f4155a.c(this.f4145a);
        if (methodC != null) {
            return methodC;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // Z9.w
    public boolean a() {
        return false;
    }

    @Override // Z9.w
    public Z9.x getType() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> clsD = C0920a.f4155a.d(this.f4145a);
        if (clsD != null) {
            return new r(clsD);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }
}
