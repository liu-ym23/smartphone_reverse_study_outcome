package com.alipay.sdk.m.f;

import com.obric.miniapp.alarm.AlarmSessionType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public final class a {
    public static Class<?> a(Type r100) {
    L3:
        if ((r100 instanceof Class) == true) goto L5;
        if ((r100 instanceof ParameterizedType) == false) goto L10;
        r100 = ((ParameterizedType) r100).getRawType();
        goto L3
    L10:
        throw new IllegalArgumentException(AlarmSessionType.TODO);
    L5:
        return (Class) r100;
    }

    public static boolean a(Class<?> r100) {
        if (r100.isPrimitive() == false) goto L6;
        return true;
    L6:
        if (r100.equals(String.class) == false) goto L9;
        return true;
    L9:
        if (r100.equals(Integer.class) == false) goto L12;
        return true;
    L12:
        if (r100.equals(Long.class) == false) goto L15;
        return true;
    L15:
        if (r100.equals(Double.class) == false) goto L18;
        return true;
    L18:
        if (r100.equals(Float.class) == false) goto L21;
        return true;
    L21:
        if (r100.equals(Boolean.class) == false) goto L24;
        return true;
    L24:
        if (r100.equals(Short.class) == false) goto L27;
        return true;
    L27:
        if (r100.equals(Character.class) == false) goto L30;
        return true;
    L30:
        if (r100.equals(Byte.class) == false) goto L33;
        return true;
    L33:
        if (r100.equals(Void.class) == false) goto L35;
        return true;
    L35:
        return false;
    }
}
