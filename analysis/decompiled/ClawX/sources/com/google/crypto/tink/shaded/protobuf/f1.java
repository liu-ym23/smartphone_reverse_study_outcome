package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f1 {
    public static e1 a(Object obj) {
        w wVar = (w) obj;
        e1 e1Var = wVar.unknownFields;
        if (e1Var != e1.f1454f) {
            return e1Var;
        }
        e1 e1VarC = e1.c();
        wVar.unknownFields = e1VarC;
        return e1VarC;
    }

    public static boolean b(Object obj, androidx.datastore.preferences.protobuf.j jVar) throws androidx.datastore.preferences.protobuf.y, c0 {
        int i8 = jVar.f501b;
        a2.e eVar = (a2.e) jVar.f503e;
        int i9 = i8 >>> 3;
        int i10 = i8 & 7;
        if (i10 == 0) {
            jVar.P(0);
            ((e1) obj).d(i9 << 3, Long.valueOf(eVar.v()));
            return true;
        }
        if (i10 == 1) {
            jVar.P(1);
            ((e1) obj).d((i9 << 3) | 1, Long.valueOf(eVar.s()));
            return true;
        }
        if (i10 == 2) {
            ((e1) obj).d((i9 << 3) | 2, jVar.i());
            return true;
        }
        if (i10 != 3) {
            if (i10 == 4) {
                return false;
            }
            if (i10 != 5) {
                throw c0.c();
            }
            jVar.P(5);
            ((e1) obj).d((i9 << 3) | 5, Integer.valueOf(eVar.r()));
            return true;
        }
        e1 e1VarC = e1.c();
        int i11 = i9 << 3;
        int i12 = i11 | 4;
        while (jVar.a() != Integer.MAX_VALUE && b(e1VarC, jVar)) {
        }
        if (i12 != jVar.f501b) {
            throw new c0("Protocol message end-group tag did not match expected tag.");
        }
        e1VarC.f1458e = false;
        ((e1) obj).d(i11 | 3, e1VarC);
        return true;
    }
}
