package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f976a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f977b;

    public b(HashMap map) {
        this.f977b = map;
        for (Map.Entry entry : map.entrySet()) {
            p pVar = (p) entry.getValue();
            List arrayList = (List) this.f976a.get(pVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f976a.put(pVar, arrayList);
            }
            arrayList.add((c) entry.getKey());
        }
    }

    public static void a(List list, v vVar, p pVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c cVar = (c) list.get(size);
                Method method = cVar.f979b;
                try {
                    int i2 = cVar.f978a;
                    if (i2 == 0) {
                        method.invoke(obj, null);
                    } else if (i2 == 1) {
                        method.invoke(obj, vVar);
                    } else if (i2 == 2) {
                        method.invoke(obj, vVar, pVar);
                    }
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(e10);
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException("Failed to call observer method", e11.getCause());
                }
            }
        }
    }
}
