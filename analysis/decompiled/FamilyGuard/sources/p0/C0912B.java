package p0;

import java.lang.reflect.Constructor;
import o0.C0896i;

/* renamed from: p0.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0912B extends o {
    public C0912B(C0896i c0896i, Class<?> cls) {
        super(c0896i, cls, cls);
    }

    private Throwable t(String str, Throwable th, Class<?> cls) throws SecurityException {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(null);
        }
        return null;
    }

    @Override // p0.o, p0.t
    public int d() {
        return 12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0128  */
    /* JADX WARN: Type inference failed for: r0v8, types: [p0.o] */
    @Override // p0.o, p0.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T e(o0.C0888a r17, java.lang.reflect.Type r18, java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C0912B.e(o0.a, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }
}
