package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.EnumNamingStrategy;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class EnumResolver implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Enum<?> _defaultValue;
    protected final Class<Enum<?>> _enumClass;
    protected final Enum<?>[] _enums;
    protected final HashMap<String, Enum<?>> _enumsById;
    protected final boolean _isFromIntValue;
    protected final boolean _isIgnoreCase;

    public EnumResolver(Class<Enum<?>> cls, Enum<?>[] enumArr, HashMap<String, Enum<?>> map, Enum<?> r42, boolean z10, boolean z11) {
        this._enumClass = cls;
        this._enums = enumArr;
        this._enumsById = map;
        this._defaultValue = r42;
        this._isIgnoreCase = z10;
        this._isFromIntValue = z11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Class<Enum<?>> _enumClass(Class<?> cls) {
        return cls;
    }

    public static Enum<?>[] _enumConstants(Class<?> cls) {
        Enum<?>[] enumConstants = _enumClass(cls).getEnumConstants();
        if (enumConstants != null) {
            return enumConstants;
        }
        throw new IllegalArgumentException("No enum constants for class " + cls.getName());
    }

    public static Enum<?> _enumDefault(AnnotationIntrospector annotationIntrospector, AnnotatedClass annotatedClass, Enum<?>[] enumArr) {
        if (annotationIntrospector != null) {
            return annotationIntrospector.findDefaultEnumValue(annotatedClass, enumArr);
        }
        return null;
    }

    public static boolean _isIntType(Class<?> cls) {
        if (cls.isPrimitive()) {
            cls = ClassUtil.wrapperType(cls);
        }
        return cls == Long.class || cls == Integer.class || cls == Short.class || cls == Byte.class;
    }

    public static EnumResolver constructFor(DeserializationConfig deserializationConfig, AnnotatedClass annotatedClass) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Class<?> rawType = annotatedClass.getRawType();
        Class<Enum<?>> cls_enumClass = _enumClass(rawType);
        Enum<?>[] enumArr_enumConstants = _enumConstants(rawType);
        String[] strArrFindEnumValues = annotationIntrospector.findEnumValues(deserializationConfig, annotatedClass, enumArr_enumConstants, new String[enumArr_enumConstants.length]);
        String[][] strArr = new String[strArrFindEnumValues.length][];
        annotationIntrospector.findEnumAliases(deserializationConfig, annotatedClass, enumArr_enumConstants, strArr);
        HashMap map = new HashMap();
        int length = enumArr_enumConstants.length;
        for (int i10 = 0; i10 < length; i10++) {
            Enum<?> r92 = enumArr_enumConstants[i10];
            String strName = strArrFindEnumValues[i10];
            if (strName == null) {
                strName = r92.name();
            }
            map.put(strName, r92);
            String[] strArr2 = strArr[i10];
            if (strArr2 != null) {
                for (String str : strArr2) {
                    map.putIfAbsent(str, r92);
                }
            }
        }
        return new EnumResolver(cls_enumClass, enumArr_enumConstants, map, _enumDefault(annotationIntrospector, annotatedClass, enumArr_enumConstants), zIsEnabled, false);
    }

    @Deprecated
    public static EnumResolver constructUsingEnumNamingStrategy(DeserializationConfig deserializationConfig, Class<?> cls, EnumNamingStrategy enumNamingStrategy) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Class<Enum<?>> cls_enumClass = _enumClass(cls);
        Enum<?>[] enumArr_enumConstants = _enumConstants(cls);
        HashMap map = new HashMap();
        String[] strArr = new String[enumArr_enumConstants.length];
        String[][] strArr2 = new String[enumArr_enumConstants.length][];
        if (annotationIntrospector != null) {
            annotationIntrospector.findEnumValues(cls_enumClass, enumArr_enumConstants, strArr);
            annotationIntrospector.findEnumAliases(cls_enumClass, enumArr_enumConstants, strArr2);
        }
        int length = enumArr_enumConstants.length;
        while (true) {
            length--;
            if (length < 0) {
                return new EnumResolver(cls_enumClass, enumArr_enumConstants, map, _enumDefault(annotationIntrospector, cls_enumClass), zIsEnabled, false);
            }
            Enum<?> r22 = enumArr_enumConstants[length];
            String strConvertEnumToExternalName = strArr[length];
            if (strConvertEnumToExternalName == null) {
                strConvertEnumToExternalName = enumNamingStrategy.convertEnumToExternalName(r22.name());
            }
            map.put(strConvertEnumToExternalName, r22);
            String[] strArr3 = strArr2[length];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    map.putIfAbsent(str, r22);
                }
            }
        }
    }

    public static EnumResolver constructUsingIndex(DeserializationConfig deserializationConfig, AnnotatedClass annotatedClass) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Class<?> rawType = annotatedClass.getRawType();
        Class<Enum<?>> cls_enumClass = _enumClass(rawType);
        Enum<?>[] enumArr_enumConstants = _enumConstants(rawType);
        HashMap map = new HashMap();
        int length = enumArr_enumConstants.length;
        while (true) {
            length--;
            if (length < 0) {
                return new EnumResolver(cls_enumClass, enumArr_enumConstants, map, _enumDefault(annotationIntrospector, annotatedClass, enumArr_enumConstants), zIsEnabled, false);
            }
            map.put(String.valueOf(length), enumArr_enumConstants[length]);
        }
    }

    @Deprecated
    public static EnumResolver constructUsingMethod(DeserializationConfig deserializationConfig, Class<?> cls, AnnotatedMember annotatedMember) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Class<Enum<?>> cls_enumClass = _enumClass(cls);
        Enum<?>[] enumArr_enumConstants = _enumConstants(cls);
        HashMap map = new HashMap();
        int length = enumArr_enumConstants.length;
        while (true) {
            length--;
            if (length < 0) {
                return new EnumResolver(cls_enumClass, enumArr_enumConstants, map, _enumDefault(annotationIntrospector, cls_enumClass), zIsEnabled, _isIntType(annotatedMember.getRawType()));
            }
            Enum<?> r10 = enumArr_enumConstants[length];
            try {
                Object value = annotatedMember.getValue(r10);
                if (value != null) {
                    map.put(value.toString(), r10);
                }
            } catch (Exception e10) {
                throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + r10 + ": " + e10.getMessage());
            }
        }
    }

    public static EnumResolver constructUsingToString(DeserializationConfig deserializationConfig, AnnotatedClass annotatedClass) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Class<?> rawType = annotatedClass.getRawType();
        Class<Enum<?>> cls_enumClass = _enumClass(rawType);
        Enum<?>[] enumArr_enumConstants = _enumConstants(rawType);
        String[] strArr = new String[enumArr_enumConstants.length];
        String[][] strArr2 = new String[enumArr_enumConstants.length][];
        if (annotationIntrospector != null) {
            annotationIntrospector.findEnumValues(deserializationConfig, annotatedClass, enumArr_enumConstants, strArr);
            annotationIntrospector.findEnumAliases(deserializationConfig, annotatedClass, enumArr_enumConstants, strArr2);
        }
        HashMap map = new HashMap();
        int length = enumArr_enumConstants.length;
        while (true) {
            length--;
            if (length < 0) {
                return new EnumResolver(cls_enumClass, enumArr_enumConstants, map, _enumDefault(annotationIntrospector, annotatedClass, enumArr_enumConstants), zIsEnabled, false);
            }
            Enum<?> r62 = enumArr_enumConstants[length];
            String string = strArr[length];
            if (string == null) {
                string = r62.toString();
            }
            map.put(string, r62);
            String[] strArr3 = strArr2[length];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    map.putIfAbsent(str, r62);
                }
            }
        }
    }

    public Enum<?> _findEnumCaseInsensitive(String str) {
        for (Map.Entry<String, Enum<?>> entry : this._enumsById.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public CompactStringObjectMap constructLookup() {
        return CompactStringObjectMap.construct(this._enumsById);
    }

    public Enum<?> findEnum(String str) {
        Enum<?> r02 = this._enumsById.get(str);
        return (r02 == null && this._isIgnoreCase) ? _findEnumCaseInsensitive(str) : r02;
    }

    public Enum<?> getDefaultValue() {
        return this._defaultValue;
    }

    public Enum<?> getEnum(int i10) {
        if (i10 < 0) {
            return null;
        }
        Enum<?>[] enumArr = this._enums;
        if (i10 >= enumArr.length) {
            return null;
        }
        return enumArr[i10];
    }

    public Class<Enum<?>> getEnumClass() {
        return this._enumClass;
    }

    public Collection<String> getEnumIds() {
        return this._enumsById.keySet();
    }

    public List<Enum<?>> getEnums() {
        ArrayList arrayList = new ArrayList(this._enums.length);
        for (Enum<?> r02 : this._enums) {
            arrayList.add(r02);
        }
        return arrayList;
    }

    public Enum<?>[] getRawEnums() {
        return this._enums;
    }

    public boolean isFromIntValue() {
        return this._isFromIntValue;
    }

    public int lastValidIndex() {
        return this._enums.length - 1;
    }

    @Deprecated
    public static Enum<?> _enumDefault(AnnotationIntrospector annotationIntrospector, Class<?> cls) {
        if (annotationIntrospector != null) {
            return annotationIntrospector.findDefaultEnumValue(_enumClass(cls));
        }
        return null;
    }

    @Deprecated
    public static EnumResolver constructUsingIndex(DeserializationConfig deserializationConfig, Class<Enum<?>> cls) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Class<Enum<?>> cls_enumClass = _enumClass(cls);
        Enum<?>[] enumArr_enumConstants = _enumConstants(cls);
        HashMap map = new HashMap();
        int length = enumArr_enumConstants.length;
        while (true) {
            length--;
            if (length >= 0) {
                map.put(String.valueOf(length), enumArr_enumConstants[length]);
            } else {
                return new EnumResolver(cls_enumClass, enumArr_enumConstants, map, _enumDefault(annotationIntrospector, cls_enumClass), zIsEnabled, false);
            }
        }
    }

    public static EnumResolver constructUsingMethod(DeserializationConfig deserializationConfig, AnnotatedClass annotatedClass, AnnotatedMember annotatedMember) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Class<?> rawType = annotatedClass.getRawType();
        Class<Enum<?>> cls_enumClass = _enumClass(rawType);
        Enum<?>[] enumArr_enumConstants = _enumConstants(rawType);
        HashMap map = new HashMap();
        int length = enumArr_enumConstants.length;
        while (true) {
            length--;
            if (length >= 0) {
                Enum<?> r12 = enumArr_enumConstants[length];
                try {
                    Object value = annotatedMember.getValue(r12);
                    if (value != null) {
                        map.put(value.toString(), r12);
                    }
                } catch (Exception e10) {
                    throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + r12 + ": " + e10.getMessage());
                }
            } else {
                return new EnumResolver(cls_enumClass, enumArr_enumConstants, map, _enumDefault(annotationIntrospector, annotatedClass, enumArr_enumConstants), zIsEnabled, _isIntType(annotatedMember.getRawType()));
            }
        }
    }

    @Deprecated
    public static EnumResolver constructFor(DeserializationConfig deserializationConfig, Class<?> cls) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Class<Enum<?>> cls_enumClass = _enumClass(cls);
        Enum<?>[] enumArr_enumConstants = _enumConstants(cls);
        String[] strArrFindEnumValues = annotationIntrospector.findEnumValues(cls_enumClass, enumArr_enumConstants, new String[enumArr_enumConstants.length]);
        String[][] strArr = new String[strArrFindEnumValues.length][];
        annotationIntrospector.findEnumAliases(cls_enumClass, enumArr_enumConstants, strArr);
        HashMap map = new HashMap();
        int length = enumArr_enumConstants.length;
        for (int i10 = 0; i10 < length; i10++) {
            Enum<?> r82 = enumArr_enumConstants[i10];
            String strName = strArrFindEnumValues[i10];
            if (strName == null) {
                strName = r82.name();
            }
            map.put(strName, r82);
            String[] strArr2 = strArr[i10];
            if (strArr2 != null) {
                for (String str : strArr2) {
                    map.putIfAbsent(str, r82);
                }
            }
        }
        return new EnumResolver(cls_enumClass, enumArr_enumConstants, map, _enumDefault(annotationIntrospector, cls_enumClass), zIsEnabled, false);
    }

    public static EnumResolver constructUsingEnumNamingStrategy(DeserializationConfig deserializationConfig, AnnotatedClass annotatedClass, EnumNamingStrategy enumNamingStrategy) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Class<?> rawType = annotatedClass.getRawType();
        Class<Enum<?>> cls_enumClass = _enumClass(rawType);
        Enum<?>[] enumArr_enumConstants = _enumConstants(rawType);
        String[] strArr = new String[enumArr_enumConstants.length];
        String[][] strArr2 = new String[enumArr_enumConstants.length][];
        if (annotationIntrospector != null) {
            annotationIntrospector.findEnumValues(deserializationConfig, annotatedClass, enumArr_enumConstants, strArr);
            annotationIntrospector.findEnumAliases(deserializationConfig, annotatedClass, enumArr_enumConstants, strArr2);
        }
        HashMap map = new HashMap();
        int length = enumArr_enumConstants.length;
        while (true) {
            length--;
            if (length >= 0) {
                Enum<?> r62 = enumArr_enumConstants[length];
                String strConvertEnumToExternalName = strArr[length];
                if (strConvertEnumToExternalName == null) {
                    strConvertEnumToExternalName = enumNamingStrategy.convertEnumToExternalName(r62.name());
                }
                map.put(strConvertEnumToExternalName, r62);
                String[] strArr3 = strArr2[length];
                if (strArr3 != null) {
                    for (String str : strArr3) {
                        map.putIfAbsent(str, r62);
                    }
                }
            } else {
                return new EnumResolver(cls_enumClass, enumArr_enumConstants, map, _enumDefault(annotationIntrospector, annotatedClass, enumArr_enumConstants), zIsEnabled, false);
            }
        }
    }

    @Deprecated
    public static EnumResolver constructUsingToString(DeserializationConfig deserializationConfig, Class<?> cls) {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Class<Enum<?>> cls_enumClass = _enumClass(cls);
        Enum<?>[] enumArr_enumConstants = _enumConstants(cls);
        HashMap map = new HashMap();
        String[][] strArr = new String[enumArr_enumConstants.length][];
        if (annotationIntrospector != null) {
            annotationIntrospector.findEnumAliases(cls_enumClass, enumArr_enumConstants, strArr);
        }
        int length = enumArr_enumConstants.length;
        while (true) {
            length--;
            if (length >= 0) {
                Enum<?> r12 = enumArr_enumConstants[length];
                map.put(r12.toString(), r12);
                String[] strArr2 = strArr[length];
                if (strArr2 != null) {
                    for (String str : strArr2) {
                        map.putIfAbsent(str, r12);
                    }
                }
            } else {
                return new EnumResolver(cls_enumClass, enumArr_enumConstants, map, _enumDefault(annotationIntrospector, cls_enumClass), zIsEnabled, false);
            }
        }
    }
}
