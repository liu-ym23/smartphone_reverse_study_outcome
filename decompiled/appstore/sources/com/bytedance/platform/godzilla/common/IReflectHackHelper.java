package com.bytedance.platform.godzilla.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public interface IReflectHackHelper {
    Field getField(Class<?> r10, String r11);

    Method getMethod(Class<?> r10, String r11, Class... r12);
}
