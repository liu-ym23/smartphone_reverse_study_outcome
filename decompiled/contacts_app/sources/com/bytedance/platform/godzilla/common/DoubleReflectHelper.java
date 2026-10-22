package com.bytedance.platform.godzilla.common;

import com.bytedance.platform.godzilla.utils.FieldUtils;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import com.bytedance.platform.godzilla.utils.OSUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class DoubleReflectHelper {
    private DoubleReflectHelper() {
    }

    public static Field getField(Class<?> r1, String r2) {
        if (OSUtil.isAndroidPHigher() == false) goto L9;
        return DoubleReflectTool.getField(r1, r2);
    L6:
        return null;
    L9:
        return FieldUtils.getField(r1, r2);
    }

    public static Method getMethod(Class<?> r1, String r2, Class... r3) {
        if (OSUtil.isAndroidPHigher() == false) goto L9;
        return DoubleReflectTool.getMethod(r1, r2, r3);
    L6:
        return null;
    L9:
        return MethodUtils.getAccessibleMethod(r1, r2, r3);
    }
}
