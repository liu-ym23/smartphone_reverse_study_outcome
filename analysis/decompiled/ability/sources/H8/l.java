package H8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType;

/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0241b f776a;
    public final Object b;
    public final AbstractC0241b c;
    public final k d;
    public final Method e;

    public l(AbstractC0241b abstractC0241b, Object obj, AbstractC0241b abstractC0241b2, k kVar, Class cls) {
        if (abstractC0241b == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (kVar.b == WireFormat$FieldType.f && abstractC0241b2 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.f776a = abstractC0241b;
        this.b = obj;
        this.c = abstractC0241b2;
        this.d = kVar;
        if (!m.class.isAssignableFrom(cls)) {
            this.e = null;
            return;
        }
        try {
            this.e = cls.getMethod("valueOf", Integer.TYPE);
        } catch (NoSuchMethodException e) {
            String name = cls.getName();
            throw new RuntimeException(androidx.constraintlayout.core.dsl.a.j(new StringBuilder(name.length() + 52), "Generated message class \"", name, "\" missing method \"valueOf\"."), e);
        }
    }

    public final Object a(Object obj) {
        if (this.d.b.f5101a != WireFormat$JavaType.ENUM) {
            return obj;
        }
        try {
            return this.e.invoke(null, (Integer) obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public final Object b(Object obj) {
        return this.d.b.f5101a == WireFormat$JavaType.ENUM ? Integer.valueOf(((m) obj).getNumber()) : obj;
    }
}
