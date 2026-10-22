package m2;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public Class f13569a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f13570b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f13571c;

    public final g a() throws NoSuchFieldException, SecurityException {
        Field declaredField;
        HashMap map = this.f13571c;
        g gVar = (g) map.get("mDrawMatrix");
        if (gVar != null) {
            return gVar;
        }
        Class superclass = this.f13569a;
        while (true) {
            if (superclass == null) {
                declaredField = null;
                break;
            }
            try {
                declaredField = superclass.getDeclaredField("mDrawMatrix");
                break;
            } catch (Exception unused) {
                superclass = superclass.getSuperclass();
            }
        }
        if (declaredField == null) {
            throw new NoSuchFieldException("mDrawMatrix");
        }
        g gVar2 = new g();
        gVar2.f13572a = declaredField;
        declaredField.setAccessible(true);
        map.put("mDrawMatrix", gVar2);
        return gVar2;
    }

    public final h b(String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        StringBuilder sb = new StringBuilder(str);
        if (clsArr.length > 0) {
            for (Class cls : clsArr) {
                sb.append(cls.getName());
            }
        }
        String string = sb.toString();
        HashMap map = this.f13570b;
        h hVar = (h) map.get(string);
        if (hVar != null) {
            return hVar;
        }
        Class superclass = this.f13569a;
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
            StringBuilder sbV = B0.g.v(str, AwarenessDataItem.PERMISSION_SPLITTER);
            sbV.append(Arrays.toString(clsArr));
            throw new NoSuchMethodException(sbV.toString());
        }
        h hVar2 = new h();
        hVar2.f13573a = declaredMethod;
        declaredMethod.setAccessible(true);
        map.put(string, hVar2);
        return hVar2;
    }
}
