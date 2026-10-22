package com.google.protobuf;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class u1 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile u1 f2558b;

    /* renamed from: c, reason: collision with root package name */
    public static final u1 f2559c = new u1();

    /* renamed from: a, reason: collision with root package name */
    public final Map f2560a = Collections.EMPTY_MAP;

    public static u1 b() {
        u1 u1Var;
        q3 q3Var = q3.f2501c;
        u1 u1Var2 = f2558b;
        if (u1Var2 != null) {
            return u1Var2;
        }
        synchronized (u1.class) {
            try {
                u1Var = f2558b;
                if (u1Var == null) {
                    Class cls = s1.f2517a;
                    u1 u1Var3 = null;
                    if (cls != null) {
                        try {
                            u1Var3 = (u1) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    u1Var = u1Var3 != null ? u1Var3 : f2559c;
                    f2558b = u1Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return u1Var;
    }

    public final void a(int i2, MessageLite messageLite) {
        if (this.f2560a.get(new t1(i2, messageLite)) != null) {
            throw new ClassCastException();
        }
    }
}
