package com.obric.oui.material;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
class NativeReflect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NativeReflect f15195a = null;

    static {
        f15195a = new NativeReflect();
    }

    public NativeReflect() {
    }

    public static Method a(Class r10, String r11, Class[] r12) {
        return r10.getDeclaredMethod(r11, r12);
    }

    public native Constructor getDeclaredConstructorNative(Class<?> r10, Class<?>[] r11);

    public native Field getDeclaredFieldNative(Class<?> r10, String r11);

    public native Method getDeclaredMethodNative(Class<?> r10, String r11, Class<?>[] r12);
}
