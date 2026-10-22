package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class q3 {

    /* renamed from: c, reason: collision with root package name */
    public static final q3 f2501c = new q3();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2503b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final z2 f2502a = new z2();

    public final t3 a(Class cls) {
        t3 t3VarB;
        Class cls2;
        p2.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f2503b;
        t3 t3Var = (t3) concurrentHashMap.get(cls);
        if (t3Var != null) {
            return t3Var;
        }
        z2 z2Var = this.f2502a;
        z2Var.getClass();
        Class cls3 = u3.f2561a;
        if (!i2.class.isAssignableFrom(cls) && (cls2 = u3.f2561a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        s3 s3VarA = ((y2) z2Var.f2665a).a(cls);
        int i2 = s3VarA.f2523d;
        MessageLite messageLite = s3VarA.f2520a;
        if ((i2 & 2) == 2) {
            if (i2.class.isAssignableFrom(cls)) {
                t3VarB = new h3(u3.f2563c, x1.f2625a, messageLite);
            } else {
                d4 d4Var = u3.f2562b;
                v1 v1Var = x1.f2626b;
                if (v1Var == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                t3VarB = new h3(d4Var, v1Var, messageLite);
            }
        } else if (i2.class.isAssignableFrom(cls)) {
            w1 w1Var = null;
            l3 l3Var = m3.f2441b;
            u2 u2Var = v2.f2588b;
            d4 d4Var2 = u3.f2563c;
            if (n.f.d(s3VarA.a()) != 1) {
                w1Var = x1.f2625a;
            }
            w1 w1Var2 = w1Var;
            c3 c3Var = d3.f2336b;
            if (!(s3VarA instanceof s3)) {
                int[] iArr = g3.f2364p;
                s3VarA.getClass();
                throw new ClassCastException();
            }
            t3VarB = g3.B(s3VarA, l3Var, u2Var, d4Var2, w1Var2, c3Var);
        } else {
            v1 v1Var2 = null;
            l3 l3Var2 = m3.f2440a;
            u2 u2Var2 = v2.f2587a;
            d4 d4Var3 = u3.f2562b;
            if (n.f.d(s3VarA.a()) != 1 && (v1Var2 = x1.f2626b) == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            v1 v1Var3 = v1Var2;
            c3 c3Var2 = d3.f2335a;
            if (!(s3VarA instanceof s3)) {
                int[] iArr2 = g3.f2364p;
                s3VarA.getClass();
                throw new ClassCastException();
            }
            t3VarB = g3.B(s3VarA, l3Var2, u2Var2, d4Var3, v1Var3, c3Var2);
        }
        t3 t3Var2 = (t3) concurrentHashMap.putIfAbsent(cls, t3VarB);
        return t3Var2 != null ? t3Var2 : t3VarB;
    }
}
