package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class r0 {
    public static boolean a(Object obj, InterfaceC0260h0 interfaceC0260h0) throws F {
        int tag = interfaceC0260h0.getTag();
        int i4 = tag >>> 3;
        int i5 = tag & 7;
        if (i5 == 0) {
            ((q0) obj).c(i4 << 3, Long.valueOf(interfaceC0260h0.G()));
            return true;
        }
        if (i5 == 1) {
            ((q0) obj).c((i4 << 3) | 1, Long.valueOf(interfaceC0260h0.g()));
            return true;
        }
        if (i5 == 2) {
            ((q0) obj).c((i4 << 3) | 2, interfaceC0260h0.v());
            return true;
        }
        if (i5 != 3) {
            if (i5 == 4) {
                return false;
            }
            if (i5 != 5) {
                throw F.b();
            }
            ((q0) obj).c((i4 << 3) | 5, Integer.valueOf(interfaceC0260h0.o()));
            return true;
        }
        q0 q0VarB = q0.b();
        int i6 = i4 << 3;
        int i7 = i6 | 4;
        while (interfaceC0260h0.q() != Integer.MAX_VALUE && a(q0VarB, interfaceC0260h0)) {
        }
        if (i7 != interfaceC0260h0.getTag()) {
            throw new F("Protocol message end-group tag did not match expected tag.");
        }
        q0VarB.f3531e = false;
        ((q0) obj).c(i6 | 3, q0VarB);
        return true;
    }
}
