package q0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import l0.AbstractC0822a;

/* renamed from: q0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0957d implements U {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Class f19775a = null;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f19776b = false;

    /* renamed from: c, reason: collision with root package name */
    private static volatile Method f19777c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile Method f19778d;

    /* renamed from: e, reason: collision with root package name */
    public static C0957d f19779e = new C0957d();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        l0.d dVar;
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
            Class<?> cls = interfaces[0];
            if (f19775a == null && !f19776b) {
                try {
                    f19775a = Class.forName("sun.reflect.annotation.AnnotationType");
                } finally {
                }
            }
            if (f19775a == null) {
                throw new l0.d("not support Type Annotation.");
            }
            if (f19777c == null && !f19776b) {
                try {
                    f19777c = f19775a.getMethod("getInstance", Class.class);
                } finally {
                }
            }
            if (f19778d == null && !f19776b) {
                try {
                    f19778d = f19775a.getMethod("members", null);
                } finally {
                }
            }
            if (f19777c == null || f19776b) {
                throw new l0.d("not support Type Annotation.");
            }
            try {
                try {
                    Map map = (Map) f19778d.invoke(f19777c.invoke(null, cls), null);
                    l0.e eVar = new l0.e(map.size());
                    Object objInvoke = null;
                    for (Map.Entry entry : map.entrySet()) {
                        try {
                            objInvoke = ((Method) entry.getValue()).invoke(obj, null);
                        } catch (IllegalAccessException | InvocationTargetException unused) {
                        }
                        eVar.put((String) entry.getKey(), AbstractC0822a.D(objInvoke));
                    }
                    c0946i.G(eVar);
                } finally {
                }
            } finally {
            }
        }
    }
}
