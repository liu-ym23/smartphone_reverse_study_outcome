package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MemberKey.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Class<?>[] f12688a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f12689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Class<?>[] f12690c;

    static {
        f12688a = new Class[0];
    }

    public z(Method r2) {
        this(r2.getName(), r2.getParameterTypes());
    }

    public z(Constructor<?> r2) {
        this("", r2.getParameterTypes());
    }

    public z(String r1, Class<?>[] r2) {
        this.f12689b = r1;
        if (r2 != null) goto L5;
        r2 = f12688a;
    L5:
        this.f12690c = r2;
    }

    public String a() {
        return this.f12689b;
    }

    public int b() {
        return this.f12690c.length;
    }

    public String toString() {
        return this.f12689b + "(" + this.f12690c.length + "-args)";
    }

    public int hashCode() {
        return this.f12689b.hashCode() + this.f12690c.length;
    }

    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (r7 != null) goto L9;
        return false;
    L9:
        if (r7.getClass() == getClass()) goto L11;
        return false;
    L11:
        z r8 = (z) ZeusTransformUtils.preCheckCast(r7, z.class, "com.obric.aiagent.plugin");
        if (this.f12689b.equals(r8.f12689b) == true) goto L14;
        return false;
    L14:
        Class<?>[] r9 = r8.f12690c;
        int r2 = this.f12690c.length;
        if (r9.length == r2) goto L17;
        return false;
    L17:
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L23;
        if (r9[r3] != this.f12690c[r3]) goto L22;
        r3 = r3 + 1;
        goto L18
    L22:
        return false;
    L23:
        return true;
    }
}
