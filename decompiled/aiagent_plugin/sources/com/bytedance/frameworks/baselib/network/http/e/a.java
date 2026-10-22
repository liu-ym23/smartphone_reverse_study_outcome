package com.bytedance.frameworks.baselib.network.http.e;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SafeObjectInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends ObjectInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f8304a;

    public a(InputStream r4, Class<?>... r5) {
        super(r4);
        this.f8304a = new HashSet();
        if (r5 == null) goto L7;
        int r6 = r5.length;
        int r0 = 0;
    L5:
        if (r0 >= r6) goto L9;
        Class<?> r1 = r5[r0];
        this.f8304a.add(r1.getName());
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass r3) {
        if (r3 == null) goto L13;
        if (r3.getName() == null) goto L13;
        String r0 = r3.getName();
        if (this.f8304a.contains(r0) == false) goto L11;
        return super.resolveClass(r3);
    L11:
        return Class.forName(r0, true, ClassLoader.getSystemClassLoader().getParent());
    L13:
        return super.resolveClass(r3);
    }
}
