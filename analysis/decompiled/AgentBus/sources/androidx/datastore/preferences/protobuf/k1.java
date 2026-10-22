package androidx.datastore.preferences.protobuf;

import com.google.protobuf.q2;

/* loaded from: classes.dex */
public final class k1 {
    public static j1 a(Object obj) {
        w wVar = (w) obj;
        j1 j1Var = wVar.unknownFields;
        if (j1Var != j1.f886f) {
            return j1Var;
        }
        j1 j1Var2 = new j1(0, new int[8], new Object[8], true);
        wVar.unknownFields = j1Var2;
        return j1Var2;
    }

    public static boolean b(Object obj, k kVar) throws a0, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        int i2 = kVar.f893b;
        j jVar = (j) kVar.f896e;
        int i10 = i2 >>> 3;
        int i11 = i2 & 7;
        if (i11 == 0) {
            kVar.V(0);
            ((j1) obj).c(i10 << 3, Long.valueOf(jVar.v()));
            return true;
        }
        if (i11 == 1) {
            kVar.V(1);
            ((j1) obj).c((i10 << 3) | 1, Long.valueOf(jVar.s()));
            return true;
        }
        if (i11 == 2) {
            ((j1) obj).c((i10 << 3) | 2, kVar.l());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw a0.b();
            }
            kVar.V(5);
            ((j1) obj).c((i10 << 3) | 5, Integer.valueOf(jVar.r()));
            return true;
        }
        j1 j1Var = new j1(0, new int[8], new Object[8], true);
        int i12 = i10 << 3;
        int i13 = i12 | 4;
        while (kVar.a() != Integer.MAX_VALUE && b(j1Var, kVar)) {
        }
        if (i13 != kVar.f893b) {
            throw new a0("Protocol message end-group tag did not match expected tag.");
        }
        j1Var.f891e = false;
        ((j1) obj).c(i12 | 3, j1Var);
        return true;
    }
}
