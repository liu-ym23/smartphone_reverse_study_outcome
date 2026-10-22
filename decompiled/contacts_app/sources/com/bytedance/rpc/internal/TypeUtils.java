package com.bytedance.rpc.internal;

import android.util.Log;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class TypeUtils {
    private static Map<String, Class<?>> sDetectMap;

    private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type mOwnerType;
        private final Type mRawType;
        private final Type[] mTypeArguments;

        public ParameterizedTypeImpl(Type r1, Type r2, Type... r3) {
            if (r1 != null) goto L5;
            Type r4 = null;
        L6:
            this.mOwnerType = r4;
            this.mRawType = TypeUtils.normalizeType(r2);
            this.mTypeArguments = (Type[]) r3.clone();
            int r5 = 0;
        L7:
            Type[] r6 = this.mTypeArguments;
            if (r5 >= r6.length) goto L10;
            r6[r5] = TypeUtils.normalizeType(r6[r5]);
            r5 = r5 + 1;
            goto L7
        L10:
            return;
        L5:
            r4 = TypeUtils.normalizeType(r1);
            goto L6
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.mTypeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.mRawType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.mOwnerType;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (TypeUtils.equalType(this, (ParameterizedType) r2) == false) goto L7;
            return true;
        }

        public int hashCode() {
            int r0 = Arrays.hashCode(this.mTypeArguments) ^ this.mRawType.hashCode();
            return Objects.hashCode(this.mOwnerType) ^ r0;
        }

        public String toString() {
            int r2 = 1;
            StringBuilder r0 = new StringBuilder((this.mTypeArguments.length + 1) * 30);
            r0.append(TypeUtils.typeToString(this.mRawType));
            if (this.mTypeArguments.length == 0) goto L5;
            r0.append("<").append(TypeUtils.typeToString(this.mTypeArguments[0]));
        L8:
            if (r2 >= this.mTypeArguments.length) goto L11;
            r0.append(", ").append(TypeUtils.typeToString(this.mTypeArguments[r2]));
            r2 = r2 + 1;
            goto L8
        L11:
            return r0.append(">").toString();
        L5:
            return r0.toString();
        }
    }

    public TypeUtils() {
    }

    static {
        sDetectMap = new LruMap(8, 16);
    }

    public static Class<?> detect(String r2, boolean r3) {
        if (r3 == false) goto L17;
        Map<String, Class<?>> r4 = sDetectMap;
        monitor-enter(r4);
        Iterator<Map.Entry<String, Class<?>>> r0 = sDetectMap.entrySet().iterator();     // Catch: Throwable -> L13
    L7:
        if (r0.hasNext() == false) goto L11;
        if (r0.next().getValue() != null) goto L7;
        r0.remove();     // Catch: Throwable -> L13
        goto L7
    L11:
        monitor-exit(r4);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        return detect(r2);
    }

    public static Class<?> detect(String r4) {
        if (RpcUtils.isVisibleUnNull(r4) == true) goto L5;
        return null;
    L5:
        if (sDetectMap.containsKey(r4) == false) goto L9;
        Class<?> r0 = sDetectMap.get(r4);
        if (r0 == null) goto L9;
        return r0;
    L9:
        Map<String, Class<?>> r1 = sDetectMap;
        monitor-enter(r1);
        Class<?> r2 = sDetectMap.get(r4);     // Catch: Throwable -> L26
        if (r2 != null) goto L14;
        String r3 = "null";
    L15:
        Log.i("TypeUtils", r3);     // Catch: Throwable -> L26
        if (r2 == null) goto L18;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L26
        return r2;
    L18:
        if (sDetectMap.containsKey(r4) == true) goto L24;
        r2 = Class.forName(r4);     // Catch: ClassNotFoundException -> L21 Throwable -> L26
    L23:
        sDetectMap.put(r4, r2);     // Catch: Throwable -> L26
        goto L24
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
        goto L23
    L14:
        r3 = r2.toString();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public static boolean detectType(String r2, Class<?> r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Class<?> r1 = detect(r2);
        if (r1 != null) goto L16;
        if (RpcUtils.isInvisibleOrNull(r2) == false) goto L11;
        return false;
    L11:
        if (r2.equals(r3.toString()) == false) goto L14;
        return true;
    L14:
        return false;
    L16:
        return r1.isAssignableFrom(r3);
    }

    public static boolean isCollectType(Type r3) {
        if (r3 != null) goto L4;
        Class<?> r4 = null;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (Collection.class.isAssignableFrom(r4) == false) goto L12;
        return true;
    L12:
        if (Map.class.isAssignableFrom(r4) == false) goto L14;
        return true;
    L14:
        return false;
    L4:
        r4 = getRawType(r3);
        goto L6
    }

    public static Object instance(String r0) {
        return instance(detect(r0));
    }

    public static Object instance(Class<?> r1) {
        if (r1 != null) goto L12;
        return null;
    L12:
    L15:
        return r1.newInstance();
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean isByteArrayType(Type r2) {
        if (r2 != byte[].class) goto L6;
        return true;
    L6:
        if ((r2 instanceof GenericArrayType) == true) goto L8;
    L10:
        return false;
    L8:
        if (((GenericArrayType) r2).getGenericComponentType() != Byte.TYPE) goto L10;
        return true;
    }

    public static Class<?> getRawType(Type r4) {
        if ((r4 instanceof Class) == false) goto L7;
        return (Class) r4;
    L7:
        if ((r4 instanceof ParameterizedType) == false) goto L13;
        Type r0 = ((ParameterizedType) r4).getRawType();
        if ((r0 instanceof Class) == true) goto L11;
    L24:
        if (r4 != null) goto L26;
        String r1 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r4 + "> is of type " + r1);
    L26:
        r1 = r4.getClass().getName();
        goto L28
    L11:
        return (Class) r0;
    L13:
        if ((r4 instanceof GenericArrayType) == false) goto L17;
        return Array.newInstance(getRawType(((GenericArrayType) r4).getGenericComponentType()), 0).getClass();
    L17:
        if ((r4 instanceof TypeVariable) == false) goto L21;
        return Object.class;
    L21:
        if ((r4 instanceof WildcardType) == false) goto L24;
        return getRawType(((WildcardType) r4).getUpperBounds()[0]);
    }

    public static Type normalizeType(Type r3) {
        if ((r3 instanceof ParameterizedType) == true) goto L5;
    L8:
        return r3;
    L5:
        if ((r3 instanceof ParameterizedTypeImpl) == true) goto L8;
        ParameterizedType r4 = (ParameterizedType) r3;
        return new ParameterizedTypeImpl(r4.getOwnerType(), r4.getRawType(), r4.getActualTypeArguments());
    }

    public static boolean equalType(Type r4, Type r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if ((r4 instanceof Class) == false) goto L10;
        return r4.equals(r5);
    L10:
        if ((r4 instanceof ParameterizedType) == false) goto L24;
        if ((r5 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r6 = (ParameterizedType) r4;
        ParameterizedType r7 = (ParameterizedType) r5;
        if (Objects.equals(r6.getOwnerType(), r7.getOwnerType()) == false) goto L22;
        if (r6.getRawType().equals(r7.getRawType()) == false) goto L22;
        if (Arrays.equals(r6.getActualTypeArguments(), r7.getActualTypeArguments()) == false) goto L22;
        return true;
    L22:
        return false;
    L24:
        if ((r4 instanceof GenericArrayType) == false) goto L31;
        if ((r5 instanceof GenericArrayType) == true) goto L29;
        return false;
    L29:
        return equalType(((GenericArrayType) r4).getGenericComponentType(), ((GenericArrayType) r5).getGenericComponentType());
    L31:
        if ((r4 instanceof WildcardType) == false) goto L43;
        if ((r5 instanceof WildcardType) == true) goto L35;
        return false;
    L35:
        WildcardType r8 = (WildcardType) r4;
        WildcardType r9 = (WildcardType) r5;
        if (Arrays.equals(r8.getUpperBounds(), r9.getUpperBounds()) == false) goto L41;
        if (Arrays.equals(r8.getLowerBounds(), r9.getLowerBounds()) == false) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((r4 instanceof TypeVariable) == true) goto L45;
        return false;
    L45:
        if ((r5 instanceof TypeVariable) == true) goto L47;
        return false;
    L47:
        TypeVariable r10 = (TypeVariable) r4;
        TypeVariable r11 = (TypeVariable) r5;
        if (r10.getGenericDeclaration() != r11.getGenericDeclaration()) goto L53;
        if (r10.getName().equals(r11.getName()) == false) goto L53;
        return true;
    L53:
        return false;
    }

    public static String typeToString(Type r1) {
        if ((r1 instanceof Class) == false) goto L6;
        return ((Class) r1).getName();
    L6:
        return r1.toString();
    }
}
