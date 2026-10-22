package com.google.protobuf;

/* loaded from: classes3.dex */
public abstract class H2 {
    public abstract N2 a(Object obj);

    public final boolean b(Object obj, InterfaceC0975o2 interfaceC0975o2) throws InvalidProtocolBufferException {
        int tag = interfaceC0975o2.getTag();
        int i = tag >>> 3;
        int i6 = tag & 7;
        if (i6 == 0) {
            ((N2) obj).d(i << 3, Long.valueOf(interfaceC0975o2.readInt64()));
            return true;
        }
        if (i6 == 1) {
            ((N2) obj).d((i << 3) | 1, Long.valueOf(interfaceC0975o2.readFixed64()));
            return true;
        }
        if (i6 == 2) {
            ((N2) obj).d((i << 3) | 2, interfaceC0975o2.readBytes());
            return true;
        }
        if (i6 != 3) {
            if (i6 == 4) {
                return false;
            }
            if (i6 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            ((N2) obj).d(5 | (i << 3), Integer.valueOf(interfaceC0975o2.readFixed32()));
            return true;
        }
        N2 n2C = N2.c();
        int i10 = i << 3;
        int i11 = i10 | 4;
        while (interfaceC0975o2.getFieldNumber() != Integer.MAX_VALUE && b(n2C, interfaceC0975o2)) {
        }
        if (i11 != interfaceC0975o2.getTag()) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
        if (n2C.e) {
            n2C.e = false;
        }
        ((N2) obj).d(i10 | 3, n2C);
        return true;
    }

    public abstract void c(Object obj, Object obj2);
}
