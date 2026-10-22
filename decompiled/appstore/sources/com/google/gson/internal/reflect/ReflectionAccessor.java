package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance = null;

    static {
        if (JavaVersion.getMajorJavaVersion() >= 9) goto L5;
        ReflectionAccessor r10 = new PreJava9ReflectionAccessor();
    L6:
        instance = r10;
        return;
    L5:
        r10 = new UnsafeReflectionAccessor();
        goto L6
    }

    public ReflectionAccessor() {
    }

    public static ReflectionAccessor getInstance() {
        return instance;
    }

    public abstract void makeAccessible(AccessibleObject r10);
}
