package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f1357a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f1358b;

    public static void a(List list, x xVar, o oVar, w wVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c cVar = (c) list.get(size);
                Method method = cVar.f1364b;
                try {
                    int i = cVar.f1363a;
                    if (i == 0) {
                        method.invoke(wVar, null);
                    } else if (i == 1) {
                        method.invoke(wVar, xVar);
                    } else if (i == 2) {
                        method.invoke(wVar, xVar, oVar);
                    }
                } catch (IllegalAccessException e10) {
                    ad.o.h(e10);
                    return;
                } catch (InvocationTargetException e11) {
                    od.f.g("Failed to call observer method", e11.getCause());
                    return;
                }
            }
        }
    }
}
