package com.google.protobuf;

/* loaded from: classes.dex */
public final class d4 {
    public static c4 a(Object obj) {
        i2 i2Var = (i2) obj;
        c4 c4Var = i2Var.unknownFields;
        if (c4Var != c4.f2327f) {
            return c4Var;
        }
        c4 c4VarC = c4.c();
        i2Var.unknownFields = c4VarC;
        return c4VarC;
    }

    public static boolean b(int i2, androidx.datastore.preferences.protobuf.k kVar, Object obj) throws androidx.datastore.preferences.protobuf.z, com.google.crypto.tink.shaded.protobuf.a0, r2 {
        int i10 = kVar.f893b;
        o oVar = (o) kVar.f896e;
        int i11 = i10 >>> 3;
        int i12 = i10 & 7;
        if (i12 == 0) {
            kVar.V(0);
            ((c4) obj).d(i11 << 3, Long.valueOf(oVar.q()));
            return true;
        }
        if (i12 == 1) {
            kVar.V(1);
            ((c4) obj).d((i11 << 3) | 1, Long.valueOf(oVar.n()));
            return true;
        }
        if (i12 == 2) {
            ((c4) obj).d((i11 << 3) | 2, kVar.n());
            return true;
        }
        if (i12 != 3) {
            if (i12 == 4) {
                return false;
            }
            if (i12 != 5) {
                throw r2.c();
            }
            kVar.V(5);
            ((c4) obj).d(5 | (i11 << 3), Integer.valueOf(oVar.m()));
            return true;
        }
        c4 c4VarC = c4.c();
        int i13 = i11 << 3;
        int i14 = i13 | 4;
        int i15 = i2 + 1;
        if (i15 >= 100) {
            throw new r2("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (kVar.a() != Integer.MAX_VALUE && b(i15, kVar, c4VarC)) {
        }
        if (i14 != kVar.f893b) {
            throw new r2("Protocol message end-group tag did not match expected tag.");
        }
        if (c4VarC.f2332e) {
            c4VarC.f2332e = false;
        }
        ((c4) obj).d(i13 | 3, c4VarC);
        return true;
    }

    public static void c(Object obj, Object obj2) {
        ((i2) obj).unknownFields = (c4) obj2;
    }
}
