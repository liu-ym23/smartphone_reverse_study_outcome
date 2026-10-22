package u9;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public Class f14262a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f14263b;

    public final f a(String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        HashMap map = this.f14263b;
        StringBuilder sb2 = new StringBuilder(str);
        if (clsArr.length > 0) {
            for (Class cls : clsArr) {
                sb2.append(cls.getName());
            }
        }
        String string = sb2.toString();
        f fVar = (f) map.get(string);
        if (fVar != null) {
            return fVar;
        }
        Class superclass = this.f14262a;
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
            StringBuilder sbV = k0.a.v(str, " ");
            sbV.append(Arrays.toString(clsArr));
            throw new NoSuchMethodException(sbV.toString());
        }
        f fVar2 = new f();
        fVar2.f14264a = declaredMethod;
        declaredMethod.setAccessible(true);
        map.put(string, fVar2);
        return fVar2;
    }
}
