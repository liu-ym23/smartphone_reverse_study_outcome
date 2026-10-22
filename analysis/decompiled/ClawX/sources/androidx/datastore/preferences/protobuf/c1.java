package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c1 {
    public static b1 a(Object obj) {
        v vVar = (v) obj;
        b1 b1Var = vVar.unknownFields;
        if (b1Var != b1.f451f) {
            return b1Var;
        }
        b1 b1Var2 = new b1(0, new int[8], new Object[8], true);
        vVar.unknownFields = b1Var2;
        return b1Var2;
    }

    public static boolean b(int i8, j jVar, Object obj) throws z, com.google.crypto.tink.shaded.protobuf.b0 {
        a2.e eVar = (a2.e) jVar.f503e;
        int i9 = jVar.f501b;
        int i10 = i9 >>> 3;
        int i11 = i9 & 7;
        if (i11 == 0) {
            jVar.P(0);
            ((b1) obj).c(i10 << 3, Long.valueOf(eVar.v()));
            return true;
        }
        if (i11 == 1) {
            jVar.P(1);
            ((b1) obj).c((i10 << 3) | 1, Long.valueOf(eVar.s()));
            return true;
        }
        if (i11 == 2) {
            ((b1) obj).c((i10 << 3) | 2, jVar.h());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw z.b();
            }
            jVar.P(5);
            ((b1) obj).c(5 | (i10 << 3), Integer.valueOf(eVar.r()));
            return true;
        }
        b1 b1Var = new b1(0, new int[8], new Object[8], true);
        int i12 = i10 << 3;
        int i13 = i12 | 4;
        int i14 = i8 + 1;
        if (i14 >= 100) {
            throw new z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (jVar.a() != Integer.MAX_VALUE && b(i14, jVar, b1Var)) {
        }
        if (i13 != jVar.f501b) {
            throw new z("Protocol message end-group tag did not match expected tag.");
        }
        if (b1Var.f455e) {
            b1Var.f455e = false;
        }
        ((b1) obj).c(i12 | 3, b1Var);
        return true;
    }
}
