package p0;

import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import o0.C0888a;

/* loaded from: classes.dex */
public class p implements t {

    /* renamed from: a, reason: collision with root package name */
    public static final p f19316a = new p();

    @Override // p0.t
    public int d() {
        return 12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return (!(type instanceof Class) || type == Object.class || type == Serializable.class || type == Cloneable.class || type == Closeable.class || type == Comparable.class) ? (T) c0888a.T(obj) : (T) c0888a.j0(type);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        ArrayList arrayList = new ArrayList();
        c0888a.W(genericComponentType, arrayList);
        T t5 = (T) ((Object[]) Array.newInstance(u0.o.h0(genericComponentType), arrayList.size()));
        arrayList.toArray((Object[]) t5);
        return t5;
    }
}
