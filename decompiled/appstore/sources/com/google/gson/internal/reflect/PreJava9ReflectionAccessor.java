package com.google.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes3.dex */
final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    public PreJava9ReflectionAccessor() {
    }

    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject r10) {
        r10.setAccessible(true);
    }
}
