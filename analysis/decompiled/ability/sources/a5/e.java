package a5;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public Class f1641a;
    public HashMap b;

    public final f a(String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        HashMap map = this.b;
        StringBuilder sb = new StringBuilder(str);
        if (clsArr.length > 0) {
            for (Class cls : clsArr) {
                sb.append(cls.getName());
            }
        }
        String string = sb.toString();
        f fVar = (f) map.get(string);
        if (fVar != null) {
            return fVar;
        }
        Class superclass = this.f1641a;
        while (true) {
            if (superclass == null) {
                declaredMethod = null;
                break;
            }
            try {
                declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                break;
            } catch (Exception unused) {
                superclass = superclass.getSuperclass();
            }
        }
        if (declaredMethod == null) {
            StringBuilder sbX = androidx.appfunctions.metadata.a.x(str, " ");
            sbX.append(Arrays.toString(clsArr));
            throw new NoSuchMethodException(sbX.toString());
        }
        f fVar2 = new f();
        fVar2.f1642a = declaredMethod;
        declaredMethod.setAccessible(true);
        map.put(string, fVar2);
        return fVar2;
    }
}
