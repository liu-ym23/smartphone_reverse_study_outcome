package com.baidu.mapapi.http.wrapper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class ClassInfo {
    private final Map<Field, ClassInfo> genericFields;
    private final Map<String, ClassInfo> genericParams;
    private final boolean isRawClass;
    private final Class<?> rawType;

    public Map<Field, ClassInfo> getGenericFields() {
        return this.genericFields;
    }

    public Map<String, ClassInfo> getGenericParams() {
        return this.genericParams;
    }

    public Class<?> getRawType() {
        return this.rawType;
    }

    public boolean isRawClass() {
        return this.isRawClass;
    }

    public static ClassInfo getType(Type r100) {
        return getType(r100, new HashMap());
    }

    public ClassInfo(Class<?> r100, boolean r101) {
        this.genericParams = new HashMap();
        this.genericFields = new HashMap();
        this.rawType = r100;
        this.isRawClass = r101;
    }

    private static ClassInfo getGenericFieldClassInfo(Field r100, Map<String, ClassInfo> r101) {
        Type r102 = r100.getGenericType();
        if ((r102 instanceof Class) == false) goto L6;
        return null;
    L6:
        if ((r102 instanceof ParameterizedType) == false) goto L25;
        ParameterizedType r103 = (ParameterizedType) r102;
        int r104 = 0;
        ClassInfo r105 = new ClassInfo((Class) r103.getRawType(), false);
        Type[] r106 = r103.getActualTypeArguments();
        TypeVariable<Class<?>>[] r107 = r105.rawType.getTypeParameters();
        int r108 = 0;
    L9:
        if (r108 >= r106.length) goto L11;
        ClassInfo r109 = getType(r106[r108], r101);
        r105.genericParams.put(r107[r108].getName(), r109);
        r108 = r108 + 1;
        goto L9
    L11:
        Field[] r110 = r105.rawType.getFields();
        int r111 = r110.length;
        int r112 = 0;
    L12:
        if (r112 >= r111) goto L17;
        Field r113 = r110[r112];
        ClassInfo r114 = getGenericFieldClassInfo(r113, r105.genericParams);
        if (r114 == null) goto L16;
        r105.genericFields.put(r113, r114);
    L16:
        r112 = r112 + 1;
        goto L12
    L17:
        Field[] r115 = r105.rawType.getDeclaredFields();
        int r116 = r115.length;
    L18:
        if (r104 >= r116) goto L23;
        Field r117 = r115[r104];
        ClassInfo r118 = getGenericFieldClassInfo(r117, r105.genericParams);
        if (r118 == null) goto L22;
        r105.genericFields.put(r117, r118);
    L22:
        r104 = r104 + 1;
        goto L18
    L23:
        return r105;
    L25:
        if ((r102 instanceof TypeVariable) == true) goto L27;
        return null;
    L27:
        return r101.get(((TypeVariable) r102).getName());
    }

    private static ClassInfo getType(Type r100, Map<String, ClassInfo> r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Class) == false) goto L10;
        return new ClassInfo((Class) r100, true);
    L10:
        if ((r100 instanceof ParameterizedType) == false) goto L29;
        ParameterizedType r102 = (ParameterizedType) r100;
        int r103 = 0;
        ClassInfo r104 = new ClassInfo((Class) r102.getRawType(), false);
        Type[] r105 = r102.getActualTypeArguments();
        TypeVariable<Class<?>>[] r106 = r104.rawType.getTypeParameters();
        int r107 = 0;
    L13:
        if (r107 >= r105.length) goto L15;
        String r108 = r106[r107].getName();
        ClassInfo r109 = getType(r105[r107], r101);
        r104.genericParams.put(r108, r109);
        r107 = r107 + 1;
        goto L13
    L15:
        Field[] r110 = r104.rawType.getFields();
        int r111 = r110.length;
        int r112 = 0;
    L16:
        if (r112 >= r111) goto L21;
        Field r113 = r110[r112];
        ClassInfo r114 = getGenericFieldClassInfo(r113, r104.genericParams);
        if (r114 == null) goto L20;
        r104.genericFields.put(r113, r114);
    L20:
        r112 = r112 + 1;
        goto L16
    L21:
        Field[] r115 = r104.rawType.getDeclaredFields();
        int r116 = r115.length;
    L22:
        if (r103 >= r116) goto L27;
        Field r117 = r115[r103];
        ClassInfo r118 = getGenericFieldClassInfo(r117, r104.genericParams);
        if (r118 == null) goto L26;
        r104.genericFields.put(r117, r118);
    L26:
        r103 = r103 + 1;
        goto L22
    L27:
        return r104;
    L29:
        if ((r100 instanceof TypeVariable) == false) goto L33;
        if (r101 == null) goto L33;
        return r101.get(((TypeVariable) r100).getName());
    L33:
        return null;
    }
}
