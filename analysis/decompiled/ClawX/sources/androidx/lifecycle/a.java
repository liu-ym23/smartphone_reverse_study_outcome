package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f697a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f698b;

    public a(HashMap map) {
        this.f698b = map;
        for (Map.Entry entry : map.entrySet()) {
            l lVar = (l) entry.getValue();
            List arrayList = (List) this.f697a.get(lVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f697a.put(lVar, arrayList);
            }
            arrayList.add((b) entry.getKey());
        }
    }

    public static void a(List list, r rVar, l lVar, q qVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                b bVar = (b) list.get(size);
                Method method = bVar.f700b;
                try {
                    int i8 = bVar.f699a;
                    if (i8 == 0) {
                        method.invoke(qVar, null);
                    } else if (i8 == 1) {
                        method.invoke(qVar, rVar);
                    } else if (i8 == 2) {
                        method.invoke(qVar, rVar, lVar);
                    }
                } catch (IllegalAccessException e9) {
                    throw new RuntimeException(e9);
                } catch (InvocationTargetException e10) {
                    throw new RuntimeException("Failed to call observer method", e10.getCause());
                }
            }
        }
    }
}
