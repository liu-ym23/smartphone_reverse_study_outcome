package a8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class r extends w {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f454e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f455f;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ r(Method method, boolean z4, int i2) {
        z4 = (i2 & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z4;
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        q7.k.d(genericParameterTypes, "method.genericParameterTypes");
        this(method, z4, genericParameterTypes);
    }

    @Override // a8.w
    public void a(Object[] objArr) {
        switch (this.f454e) {
            case 0:
                q7.k.e(objArr, "args");
                g.checkArguments(this, objArr);
                if (this.f455f && d7.n.p0(objArr) == null) {
                    throw new IllegalArgumentException("null is not allowed as a value for this property.");
                }
                return;
            default:
                super.a(objArr);
                return;
        }
    }

    public Object c(Object[] objArr, Object obj) {
        q7.k.e(objArr, "args");
        return this.f455f ? c7.r.f1986a : ((Method) this.f459a).invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    @Override // a8.h
    public Object h(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
        q7.k.e(objArr, "args");
        a(objArr);
        ((Field) this.f459a).set(this.f461c != null ? d7.n.g0(objArr) : null, d7.n.p0(objArr));
        return c7.r.f1986a;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public r(Method method, boolean z4, Type[] typeArr) {
        Type genericReturnType = method.getGenericReturnType();
        q7.k.d(genericReturnType, "method.genericReturnType");
        super(method, genericReturnType, z4 ? method.getDeclaringClass() : null, typeArr);
        this.f455f = genericReturnType.equals(Void.TYPE);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public r(Field field, boolean z4, boolean z10) {
        Class cls = Void.TYPE;
        q7.k.d(cls, "TYPE");
        Class<?> declaringClass = z10 ? field.getDeclaringClass() : null;
        Type genericType = field.getGenericType();
        q7.k.d(genericType, "field.genericType");
        super(field, cls, declaringClass, new Type[]{genericType});
        this.f455f = z4;
    }
}
