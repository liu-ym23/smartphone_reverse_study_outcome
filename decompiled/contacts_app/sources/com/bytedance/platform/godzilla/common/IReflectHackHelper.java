package com.bytedance.platform.godzilla.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public interface IReflectHackHelper {
    Field getField(Class<?> r1, String r2);

    Method getMethod(Class<?> r1, String r2, Class... r3);
}
