package C2;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f341a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f342b;

    public d(Class cls) {
        new HashMap();
        this.f342b = new HashMap();
        new HashMap();
        this.f341a = cls;
    }

    public final e a(String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        StringBuilder sb = new StringBuilder(str);
        if (clsArr.length > 0) {
            for (Class cls : clsArr) {
                sb.append(cls.getName());
            }
        }
        String string = sb.toString();
        HashMap map = this.f342b;
        e eVar = (e) map.get(string);
        if (eVar != null) {
            return eVar;
        }
        Class superclass = this.f341a;
        while (true) {
            declaredMethod = null;
            if (superclass == null) {
                break;
            }
            try {
                declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                break;
            } catch (Exception unused) {
                if (f.f345b != null) {
                    try {
                        declaredMethod = (Method) f.f345b.invoke(null, superclass, str, clsArr);
                        break;
                    } catch (Exception unused2) {
                        continue;
                        superclass = superclass.getSuperclass();
                    }
                }
                superclass = superclass.getSuperclass();
            }
        }
        if (declaredMethod != null) {
            e eVar2 = new e(declaredMethod);
            map.put(string, eVar2);
            return eVar2;
        }
        StringBuilder sbV = B0.g.v(str, AwarenessDataItem.PERMISSION_SPLITTER);
        sbV.append(Arrays.toString(clsArr));
        throw new NoSuchMethodException(sbV.toString());
    }
}
