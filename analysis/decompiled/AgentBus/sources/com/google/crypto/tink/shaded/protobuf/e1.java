package com.google.crypto.tink.shaded.protobuf;

import com.google.protobuf.q2;

/* loaded from: classes.dex */
public final class e1 {
    public static d1 a(Object obj) {
        v vVar = (v) obj;
        d1 d1Var = vVar.unknownFields;
        if (d1Var != d1.f2196f) {
            return d1Var;
        }
        d1 d1VarC = d1.c();
        vVar.unknownFields = d1VarC;
        return d1VarC;
    }

    public static boolean b(Object obj, androidx.datastore.preferences.protobuf.k kVar) throws androidx.datastore.preferences.protobuf.z, b0, q2 {
        int i2 = kVar.f893b;
        androidx.datastore.preferences.protobuf.j jVar = (androidx.datastore.preferences.protobuf.j) kVar.f896e;
        int i10 = i2 >>> 3;
        int i11 = i2 & 7;
        if (i11 == 0) {
            kVar.V(0);
            ((d1) obj).d(i10 << 3, Long.valueOf(jVar.v()));
            return true;
        }
        if (i11 == 1) {
            kVar.V(1);
            ((d1) obj).d((i10 << 3) | 1, Long.valueOf(jVar.s()));
            return true;
        }
        if (i11 == 2) {
            ((d1) obj).d((i10 << 3) | 2, kVar.m());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw b0.c();
            }
            kVar.V(5);
            ((d1) obj).d((i10 << 3) | 5, Integer.valueOf(jVar.r()));
            return true;
        }
        d1 d1VarC = d1.c();
        int i12 = i10 << 3;
        int i13 = i12 | 4;
        while (kVar.a() != Integer.MAX_VALUE && b(d1VarC, kVar)) {
        }
        if (i13 != kVar.f893b) {
            throw new b0("Protocol message end-group tag did not match expected tag.");
        }
        d1VarC.f2201e = false;
        ((d1) obj).d(i12 | 3, d1VarC);
        return true;
    }
}
