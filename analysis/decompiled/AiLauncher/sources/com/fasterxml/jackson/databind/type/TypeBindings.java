package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public class TypeBindings implements Serializable {
    private static final TypeBindings EMPTY;
    private static final String[] NO_STRINGS;
    private static final JavaType[] NO_TYPES;
    private static final long serialVersionUID = 1;
    private final int _hashCode;
    private final String[] _names;
    private final JavaType[] _types;
    private final String[] _unboundVariables;

    public static final class AsKey {
        private final int _hash;
        private final JavaType[] _params;
        private final Class<?> _raw;

        public AsKey(Class<?> cls, JavaType[] javaTypeArr, int i10) {
            this._raw = cls;
            this._params = javaTypeArr;
            this._hash = (cls.hashCode() * 31) + i10;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != AsKey.class) {
                return false;
            }
            AsKey asKey = (AsKey) obj;
            if (this._hash == asKey._hash && this._raw == asKey._raw) {
                JavaType[] javaTypeArr = asKey._params;
                int length = this._params.length;
                if (length == javaTypeArr.length) {
                    for (int i10 = 0; i10 < length; i10++) {
                        if (!Objects.equals(this._params[i10], javaTypeArr[i10])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this._hash;
        }

        public String toString() {
            return this._raw.getName() + "<>";
        }
    }

    public static class TypeParamStash {
        private static final TypeVariable<?>[] VARS_ABSTRACT_LIST = AbstractList.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_COLLECTION = Collection.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_ITERABLE = Iterable.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_LIST = List.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_ARRAY_LIST = ArrayList.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_MAP = Map.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_HASH_MAP = HashMap.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_LINKED_HASH_MAP = LinkedHashMap.class.getTypeParameters();

        public static TypeVariable<?>[] paramsFor1(Class<?> cls) {
            return cls == Collection.class ? VARS_COLLECTION : cls == List.class ? VARS_LIST : cls == ArrayList.class ? VARS_ARRAY_LIST : cls == AbstractList.class ? VARS_ABSTRACT_LIST : cls == Iterable.class ? VARS_ITERABLE : cls.getTypeParameters();
        }

        public static TypeVariable<?>[] paramsFor2(Class<?> cls) {
            return cls == Map.class ? VARS_MAP : cls == HashMap.class ? VARS_HASH_MAP : cls == LinkedHashMap.class ? VARS_LINKED_HASH_MAP : cls.getTypeParameters();
        }
    }

    static {
        String[] strArr = new String[0];
        NO_STRINGS = strArr;
        JavaType[] javaTypeArr = new JavaType[0];
        NO_TYPES = javaTypeArr;
        EMPTY = new TypeBindings(strArr, javaTypeArr, null);
    }

    private TypeBindings(String[] strArr, JavaType[] javaTypeArr, String[] strArr2) {
        strArr = strArr == null ? NO_STRINGS : strArr;
        this._names = strArr;
        javaTypeArr = javaTypeArr == null ? NO_TYPES : javaTypeArr;
        this._types = javaTypeArr;
        if (strArr.length == javaTypeArr.length) {
            this._unboundVariables = strArr2;
            this._hashCode = Arrays.hashCode(javaTypeArr);
            return;
        }
        throw new IllegalArgumentException("Mismatching names (" + strArr.length + "), types (" + javaTypeArr.length + ")");
    }

    public static TypeBindings create(Class<?> cls, List<JavaType> list) {
        return create(cls, (list == null || list.isEmpty()) ? NO_TYPES : (JavaType[]) list.toArray(NO_TYPES));
    }

    public static TypeBindings createIfNeeded(Class<?> cls, JavaType javaType) {
        TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 0) {
            return EMPTY;
        }
        if (length == 1) {
            return new TypeBindings(new String[]{typeParameters[0].getName()}, new JavaType[]{javaType}, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 1 type parameter: class expects " + length);
    }

    public static TypeBindings emptyBindings() {
        return EMPTY;
    }

    private boolean invalidCacheKey() {
        for (JavaType javaType : this._types) {
            if (javaType instanceof IdentityEqualityType) {
                return true;
            }
        }
        return false;
    }

    public Object asKey(Class<?> cls) {
        if (invalidCacheKey()) {
            return null;
        }
        return new AsKey(cls, this._types, this._hashCode);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!ClassUtil.hasClass(obj, getClass())) {
            return false;
        }
        TypeBindings typeBindings = (TypeBindings) obj;
        return this._hashCode == typeBindings._hashCode && Arrays.equals(this._types, typeBindings._types);
    }

    public JavaType findBoundType(String str) {
        JavaType selfReferencedType;
        int length = this._names.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(this._names[i10])) {
                JavaType javaType = this._types[i10];
                return (!(javaType instanceof ResolvedRecursiveType) || (selfReferencedType = ((ResolvedRecursiveType) javaType).getSelfReferencedType()) == null) ? javaType : selfReferencedType;
            }
        }
        return null;
    }

    public String getBoundName(int i10) {
        if (i10 < 0) {
            return null;
        }
        String[] strArr = this._names;
        if (i10 >= strArr.length) {
            return null;
        }
        return strArr[i10];
    }

    public JavaType getBoundType(int i10) {
        if (i10 < 0) {
            return null;
        }
        JavaType[] javaTypeArr = this._types;
        if (i10 >= javaTypeArr.length) {
            return null;
        }
        JavaType javaType = javaTypeArr[i10];
        return javaType == null ? TypeFactory.unknownType() : javaType;
    }

    public JavaType getBoundTypeOrNull(int i10) {
        if (i10 < 0) {
            return null;
        }
        JavaType[] javaTypeArr = this._types;
        if (i10 >= javaTypeArr.length) {
            return null;
        }
        return javaTypeArr[i10];
    }

    public List<JavaType> getTypeParameters() {
        JavaType[] javaTypeArr = this._types;
        if (javaTypeArr.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<JavaType> listAsList = Arrays.asList(javaTypeArr);
        if (!listAsList.contains(null)) {
            return listAsList;
        }
        ArrayList arrayList = new ArrayList(listAsList);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (arrayList.get(i10) == null) {
                arrayList.set(i10, TypeFactory.unknownType());
            }
        }
        return arrayList;
    }

    public boolean hasUnbound(String str) {
        String[] strArr = this._unboundVariables;
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                return false;
            }
        } while (!str.equals(this._unboundVariables[length]));
        return true;
    }

    public int hashCode() {
        return this._hashCode;
    }

    public boolean isEmpty() {
        return this._types.length == 0;
    }

    public Object readResolve() {
        String[] strArr = this._names;
        return (strArr == null || strArr.length == 0) ? EMPTY : this;
    }

    public int size() {
        return this._types.length;
    }

    public String toString() {
        if (this._types.length == 0) {
            return "<>";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('<');
        int length = this._types.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 > 0) {
                sb2.append(',');
            }
            JavaType javaType = this._types[i10];
            if (javaType == null) {
                sb2.append("?");
            } else {
                sb2.append(javaType.getGenericSignature());
            }
        }
        sb2.append('>');
        return sb2.toString();
    }

    public JavaType[] typeParameterArray() {
        return this._types;
    }

    public TypeBindings withUnboundVariable(String str) {
        String[] strArr = this._unboundVariables;
        int length = strArr == null ? 0 : strArr.length;
        String[] strArr2 = length == 0 ? new String[1] : (String[]) Arrays.copyOf(strArr, length + 1);
        strArr2[length] = str;
        return new TypeBindings(this._names, this._types, strArr2);
    }

    public TypeBindings withoutVariable(String str) {
        int iIndexOf = Arrays.asList(this._names).indexOf(str);
        if (iIndexOf == -1) {
            return this;
        }
        JavaType[] javaTypeArr = (JavaType[]) this._types.clone();
        javaTypeArr[iIndexOf] = null;
        return new TypeBindings(this._names, javaTypeArr, this._unboundVariables);
    }

    public static TypeBindings create(Class<?> cls, JavaType[] javaTypeArr) {
        String[] strArr;
        if (javaTypeArr == null) {
            javaTypeArr = NO_TYPES;
        } else {
            int length = javaTypeArr.length;
            if (length == 1) {
                return create(cls, javaTypeArr[0]);
            }
            if (length == 2) {
                return create(cls, javaTypeArr[0], javaTypeArr[1]);
            }
        }
        TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
        if (typeParameters != null && typeParameters.length != 0) {
            int length2 = typeParameters.length;
            strArr = new String[length2];
            for (int i10 = 0; i10 < length2; i10++) {
                strArr[i10] = typeParameters[i10].getName();
            }
        } else {
            strArr = NO_STRINGS;
        }
        if (strArr.length != javaTypeArr.length) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot create TypeBindings for class ");
            sb2.append(cls.getName());
            sb2.append(" with ");
            sb2.append(javaTypeArr.length);
            sb2.append(" type parameter");
            sb2.append(javaTypeArr.length == 1 ? "" : "s");
            sb2.append(": class expects ");
            sb2.append(strArr.length);
            throw new IllegalArgumentException(sb2.toString());
        }
        return new TypeBindings(strArr, javaTypeArr, null);
    }

    public static TypeBindings createIfNeeded(Class<?> cls, JavaType[] javaTypeArr) {
        TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
        if (typeParameters != null && typeParameters.length != 0) {
            if (javaTypeArr == null) {
                javaTypeArr = NO_TYPES;
            }
            int length = typeParameters.length;
            String[] strArr = new String[length];
            for (int i10 = 0; i10 < length; i10++) {
                strArr[i10] = typeParameters[i10].getName();
            }
            if (length != javaTypeArr.length) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot create TypeBindings for class ");
                sb2.append(cls.getName());
                sb2.append(" with ");
                sb2.append(javaTypeArr.length);
                sb2.append(" type parameter");
                sb2.append(javaTypeArr.length == 1 ? "" : "s");
                sb2.append(": class expects ");
                sb2.append(length);
                throw new IllegalArgumentException(sb2.toString());
            }
            return new TypeBindings(strArr, javaTypeArr, null);
        }
        return EMPTY;
    }

    public static TypeBindings create(Class<?> cls, JavaType javaType) {
        TypeVariable<?>[] typeVariableArrParamsFor1 = TypeParamStash.paramsFor1(cls);
        int length = typeVariableArrParamsFor1 == null ? 0 : typeVariableArrParamsFor1.length;
        if (length == 1) {
            return new TypeBindings(new String[]{typeVariableArrParamsFor1[0].getName()}, new JavaType[]{javaType}, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 1 type parameter: class expects " + length);
    }

    public static TypeBindings create(Class<?> cls, JavaType javaType, JavaType javaType2) {
        TypeVariable<?>[] typeVariableArrParamsFor2 = TypeParamStash.paramsFor2(cls);
        int length = typeVariableArrParamsFor2 == null ? 0 : typeVariableArrParamsFor2.length;
        if (length == 2) {
            return new TypeBindings(new String[]{typeVariableArrParamsFor2[0].getName(), typeVariableArrParamsFor2[1].getName()}, new JavaType[]{javaType, javaType2}, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 2 type parameters: class expects " + length);
    }

    public static TypeBindings create(List<String> list, List<JavaType> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            return new TypeBindings((String[]) list.toArray(NO_STRINGS), (JavaType[]) list2.toArray(NO_TYPES), null);
        }
        return EMPTY;
    }
}
