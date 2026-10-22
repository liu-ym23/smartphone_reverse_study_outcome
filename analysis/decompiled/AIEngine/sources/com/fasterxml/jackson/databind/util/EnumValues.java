package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import v2.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EnumValues implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Class<Enum<?>> f4504a;

    /* renamed from: b, reason: collision with root package name */
    public final e[] f4505b;

    public EnumValues(Class<Enum<?>> cls, e[] eVarArr) {
        this.f4504a = cls;
        cls.getEnumConstants();
        this.f4505b = eVarArr;
    }

    public static EnumValues a(MapperConfig<?> mapperConfig, Class<Enum<?>> cls) {
        Annotation[] annotationArr = a.f4529a;
        Class<Enum<?>> superclass = cls.getSuperclass() != Enum.class ? cls.getSuperclass() : cls;
        Enum<?>[] enumConstants = superclass.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("Cannot determine enum constants for Class ".concat(cls.getName()));
        }
        String[] strArrL = mapperConfig.d().l(superclass, enumConstants, new String[enumConstants.length]);
        e[] eVarArr = new e[enumConstants.length];
        int length = enumConstants.length;
        for (int i10 = 0; i10 < length; i10++) {
            Enum<?> r42 = enumConstants[i10];
            String strName = strArrL[i10];
            if (strName == null) {
                strName = r42.name();
            }
            eVarArr[r42.ordinal()] = new SerializedString(strName);
        }
        return new EnumValues(cls, eVarArr);
    }
}
