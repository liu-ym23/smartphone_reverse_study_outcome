package com.bytedance.reparo.core;

import dalvik.system.BaseDexClassLoader;
import java.io.File;

/* JADX INFO: compiled from: PatchContainerClassLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends BaseDexClassLoader {
    public h(String r1, File r2, String r3, ClassLoader r4) {
        super(r1, r2, r3, r4);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String r1) {
        return super.findClass(r1);
    }

    public Class<?> a(String r1) {
        return findClass(r1);
    }
}
