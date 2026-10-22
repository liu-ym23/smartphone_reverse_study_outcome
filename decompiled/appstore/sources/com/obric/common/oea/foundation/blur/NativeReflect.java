package com.obric.common.oea.foundation.blur;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class NativeReflect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NativeReflect f11557a = null;

    static {
        f11557a = new NativeReflect();
    }

    public NativeReflect() {
    }

    public native Constructor getDeclaredConstructorNative(Class<?> r10, Class<?>[] r11);

    public native Field getDeclaredFieldNative(Class<?> r10, String r11);

    public native Method getDeclaredMethodNative(Class<?> r10, String r11, Class<?>[] r12);
}
