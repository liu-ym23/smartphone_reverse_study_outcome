package a8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import z7.x1;

/* loaded from: classes.dex */
public final class x implements h {

    /* renamed from: a, reason: collision with root package name */
    public final h f463a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f464b;

    /* renamed from: c, reason: collision with root package name */
    public final i5.l f465c;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x(a8.h r9, f8.c r10, boolean r11) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a8.x.<init>(a8.h, f8.c, boolean):void");
    }

    @Override // a8.h
    public final Type f() {
        return this.f463a.f();
    }

    @Override // a8.h
    public final Object h(Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        q7.k.e(objArr, "args");
        i5.l lVar = this.f465c;
        v7.d dVar = (v7.d) lVar.f4687g;
        Method[] methodArr = (Method[]) lVar.f4688h;
        Method method = (Method) lVar.f4689i;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        q7.k.d(objArrCopyOf, "copyOf(this, size)");
        int i2 = dVar.f10523f;
        int i10 = dVar.f10524g;
        if (i2 <= i10) {
            while (true) {
                Method method2 = methodArr[i2];
                Object objE = objArr[i2];
                if (method2 != null) {
                    if (objE != null) {
                        objE = method2.invoke(objE, null);
                    } else {
                        Class<?> returnType = method2.getReturnType();
                        q7.k.d(returnType, "method.returnType");
                        objE = x1.e(returnType);
                    }
                }
                objArrCopyOf[i2] = objE;
                if (i2 == i10) {
                    break;
                }
                i2++;
            }
        }
        Object objH = this.f463a.h(objArrCopyOf);
        return (method == null || (objInvoke = method.invoke(null, objH)) == null) ? objH : objInvoke;
    }

    @Override // a8.h
    public final List i() {
        return this.f463a.i();
    }

    @Override // a8.h
    public final Member j() {
        return this.f463a.j();
    }
}
