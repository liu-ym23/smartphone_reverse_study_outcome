package f5;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f8752a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: f5.h$a$a, reason: collision with other inner class name */
        public class C0081a extends a {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Method f8753b;

            public C0081a(Method method) {
                this.f8753b = method;
            }

            @Override // f5.h.a
            public final boolean a(Object obj, AccessibleObject accessibleObject) {
                try {
                    return ((Boolean) this.f8753b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e10) {
                    throw new RuntimeException("Failed invoking canAccess", e10);
                }
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class b extends a {
            @Override // f5.h.a
            public final boolean a(Object obj, AccessibleObject accessibleObject) {
                return true;
            }
        }

        static {
            a c0081a;
            if (f.f8751a >= 9) {
                try {
                    c0081a = new C0081a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                }
            } else {
                c0081a = null;
            }
            if (c0081a == null) {
                c0081a = new b();
            }
            f8752a = c0081a;
        }

        public abstract boolean a(Object obj, AccessibleObject accessibleObject);
    }

    public static ReflectionAccessFilter.FilterResult a(Class cls, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ReflectionAccessFilter.FilterResult filterResultA = ((ReflectionAccessFilter) it.next()).a();
            if (filterResultA != ReflectionAccessFilter.FilterResult.f5430b) {
                return filterResultA;
            }
        }
        return ReflectionAccessFilter.FilterResult.f5429a;
    }
}
