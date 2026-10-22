package io.modelcontextprotocol.json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class TypeRef<T> {
    private final Type type;

    public TypeRef() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            f.e("TypeRef constructed without actual type information");
            throw null;
        }
        this.type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }
}
