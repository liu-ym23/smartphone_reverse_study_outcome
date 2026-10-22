package com.alibaba.fastjson;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes28.dex */
public class TypeReference<T> {
    public static final Type LIST_STRING = null;
    static ConcurrentMap<Type, Type> classTypeCache;
    protected final Type type;

    static {
        classTypeCache = new ConcurrentHashMap(16, 0.75f, 1);
        LIST_STRING = new AnonymousClass1().getType();
    }

    public TypeReference() {
        Type r100 = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type r101 = classTypeCache.get(r100);
        if (r101 != null) goto L5;
        classTypeCache.putIfAbsent(r100, r100);
        r101 = classTypeCache.get(r100);
    L5:
        this.type = r101;
    }

    public Type getType() {
        return this.type;
    }

    public TypeReference(Type... r100) {
        Class<?> r101 = getClass();
        int r102 = 0;
        ParameterizedType r103 = (ParameterizedType) ((ParameterizedType) r101.getGenericSuperclass()).getActualTypeArguments()[0];
        Type r104 = r103.getRawType();
        Type[] r105 = r103.getActualTypeArguments();
        int r106 = 0;
    L4:
        if (r102 >= r105.length) goto L17;
        if ((r105[r102] instanceof TypeVariable) == true) goto L8;
    L10:
        Type r107 = r105[r102];
        if ((r107 instanceof GenericArrayType) == false) goto L13;
        r105[r102] = TypeUtils.checkPrimitiveArray((GenericArrayType) r107);
    L13:
        Type r108 = r105[r102];
        if ((r108 instanceof ParameterizedType) == false) goto L16;
        r105[r102] = handlerParameterizedType((ParameterizedType) r108, r100, r106);
    L16:
        r102 = r102 + 1;
        goto L4
    L8:
        if (r106 >= r100.length) goto L10;
        int r109 = r106 + 1;
        r105[r102] = r100[r106];
        r106 = r109;
        goto L10
    L17:
        ParameterizedTypeImpl r110 = new ParameterizedTypeImpl(r105, r101, r104);
        Type r111 = classTypeCache.get(r110);
        if (r111 != null) goto L20;
        classTypeCache.putIfAbsent(r110, r110);
        r111 = classTypeCache.get(r110);
    L20:
        this.type = r111;
    }

    public static Type intern(ParameterizedTypeImpl r100) {
        Type r101 = classTypeCache.get(r100);
        if (r101 != null) goto L6;
        classTypeCache.putIfAbsent(r100, r100);
        return classTypeCache.get(r100);
    L6:
        return r101;
    }

    private Type handlerParameterizedType(ParameterizedType r100, Type[] r101, int r102) {
        Class<?> r103 = getClass();
        Type r104 = r100.getRawType();
        Type[] r105 = r100.getActualTypeArguments();
        int r106 = 0;
    L4:
        if (r106 >= r105.length) goto L18;
        if ((r105[r106] instanceof TypeVariable) == true) goto L8;
    L10:
        Type r107 = r105[r106];
        if ((r107 instanceof GenericArrayType) == false) goto L13;
        r105[r106] = TypeUtils.checkPrimitiveArray((GenericArrayType) r107);
    L13:
        Type r108 = r105[r106];
        if ((r108 instanceof ParameterizedType) == false) goto L16;
        r105[r106] = handlerParameterizedType((ParameterizedType) r108, r101, r102);
    L16:
        r106 = r106 + 1;
        goto L4
    L8:
        if (r102 >= r101.length) goto L10;
        int r109 = r102 + 1;
        r105[r106] = r101[r102];
        r102 = r109;
        goto L10
    L18:
        return new ParameterizedTypeImpl(r105, r103, r104);
    }
}
