package com.bytedance.platform.godzilla.common;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: DoubleReflectHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static Field a(Class<?> r1, String r2) {
        if (com.bytedance.platform.godzilla.b.e.a() == false) goto L9;
        return d.a(r1, r2);
    L6:
        return null;
    L9:
        return com.bytedance.platform.godzilla.b.a.a(r1, r2);
    }
}
