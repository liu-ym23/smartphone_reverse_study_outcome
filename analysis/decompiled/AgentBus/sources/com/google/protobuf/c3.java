package com.google.protobuf;

/* loaded from: classes.dex */
public final class c3 {
    public static b3 a(Object obj, Object obj2) {
        b3 b3VarC = (b3) obj;
        b3 b3Var = (b3) obj2;
        if (!b3Var.isEmpty()) {
            if (!b3VarC.f2321f) {
                b3VarC = b3VarC.c();
            }
            b3VarC.b();
            if (!b3Var.isEmpty()) {
                b3VarC.putAll(b3Var);
            }
        }
        return b3VarC;
    }
}
