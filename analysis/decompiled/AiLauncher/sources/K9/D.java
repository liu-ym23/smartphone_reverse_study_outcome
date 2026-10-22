package K9;

import Z9.InterfaceC1178a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Iterator;

/* loaded from: classes5.dex */
public abstract class D implements Z9.x {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4146a = new a(null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final D a(Type type) {
            kotlin.jvm.internal.p.i(type, "type");
            boolean z10 = type instanceof Class;
            if (z10) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new B(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z10 && ((Class) type).isArray())) ? new m(type) : type instanceof WildcardType ? new G((WildcardType) type) : new r(type);
        }

        public a() {
        }
    }

    public abstract Type M();

    @Override // Z9.d
    public InterfaceC1178a d(ga.c fqName) {
        Object obj;
        kotlin.jvm.internal.p.i(fqName, "fqName");
        Iterator<T> it = getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ga.b bVarJ = ((InterfaceC1178a) next).j();
            if (kotlin.jvm.internal.p.d(bVarJ != null ? bVarJ.a() : null, fqName)) {
                obj = next;
                break;
            }
        }
        return (InterfaceC1178a) obj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof D) && kotlin.jvm.internal.p.d(M(), ((D) obj).M());
    }

    public int hashCode() {
        return M().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + M();
    }
}
