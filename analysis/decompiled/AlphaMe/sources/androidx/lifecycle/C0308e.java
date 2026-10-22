package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0308e {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3928a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f3929b;

    public C0308e(HashMap map) {
        this.f3929b = map;
        for (Map.Entry entry : map.entrySet()) {
            EnumC0326x enumC0326x = (EnumC0326x) entry.getValue();
            List arrayList = (List) this.f3928a.get(enumC0326x);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f3928a.put(enumC0326x, arrayList);
            }
            arrayList.add((C0309f) entry.getKey());
        }
    }

    public static void a(List list, G g4, EnumC0326x enumC0326x, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C0309f c0309f = (C0309f) list.get(size);
                c0309f.getClass();
                try {
                    int i4 = c0309f.f3936a;
                    Method method = c0309f.f3937b;
                    if (i4 == 0) {
                        method.invoke(obj, new Object[0]);
                    } else if (i4 == 1) {
                        method.invoke(obj, g4);
                    } else if (i4 == 2) {
                        method.invoke(obj, g4, enumC0326x);
                    }
                } catch (IllegalAccessException e4) {
                    throw new RuntimeException(e4);
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException("Failed to call observer method", e5.getCause());
                }
            }
        }
    }
}
