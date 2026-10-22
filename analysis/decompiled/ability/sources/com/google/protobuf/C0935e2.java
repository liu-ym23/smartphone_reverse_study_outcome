package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.protobuf.e2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0935e2 implements InterfaceC0979p2 {

    /* renamed from: a, reason: collision with root package name */
    public final X1 f2918a;
    public final H2 b;
    public final boolean c;
    public final S0 d;

    public C0935e2(H2 h22, S0 s0, X1 x12) {
        this.b = h22;
        this.c = s0.e(x12);
        this.d = s0;
        this.f2918a = x12;
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final void a(Object obj, F1 f12) throws CodedOutputStream$OutOfSpaceException {
        Iterator itP = this.d.c(obj).p();
        while (itP.hasNext()) {
            Map.Entry entry = (Map.Entry) itP.next();
            D0 d02 = (D0) ((X0) entry.getKey());
            if (d02.h().f2887a == WireFormat$JavaType.MESSAGE) {
                DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = d02.b;
                if (!d02.isRepeated() && !d02.isPacked()) {
                    if (entry instanceof C0993t1) {
                        int i = descriptorProtos$FieldDescriptorProto.e;
                        com.stepos.statsrpk.service.c.m(((C0993t1) entry).f2943a.getValue());
                        throw null;
                    }
                    f12.p(descriptorProtos$FieldDescriptorProto.e, entry.getValue());
                }
            }
            throw new IllegalStateException("Found invalid MessageSet item.");
        }
        ((O2) this.b).getClass();
        N2 n22 = ((GeneratedMessageLite) obj).unknownFields;
        n22.getClass();
        f12.getClass();
        for (int i6 = 0; i6 < n22.f2861a; i6++) {
            f12.p(n22.b[i6] >>> 3, n22.c[i6]);
        }
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final int b(AbstractC0932e abstractC0932e) {
        ((O2) this.b).getClass();
        N2 n22 = ((GeneratedMessageLite) abstractC0932e).unknownFields;
        int i = n22.d;
        if (i == -1) {
            int iK = 0;
            for (int i6 = 0; i6 < n22.f2861a; i6++) {
                iK += C0980q.K(3, (ByteString) n22.c[i6]) + C0980q.S(n22.b[i6] >>> 3) + C0980q.R(2) + (C0980q.R(1) * 2);
            }
            n22.d = iK;
            i = iK;
        }
        return this.c ? this.d.c(abstractC0932e).i() + i : i;
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final void c(Object obj, InterfaceC0975o2 interfaceC0975o2, R0 r02) {
        H2 h22 = this.b;
        N2 n2A = h22.a(obj);
        S0 s0 = this.d;
        Y0 y0D = s0.d(obj);
        while (interfaceC0975o2.getFieldNumber() != Integer.MAX_VALUE) {
            try {
                C0935e2 c0935e2 = this;
                InterfaceC0975o2 interfaceC0975o22 = interfaceC0975o2;
                R0 r03 = r02;
                if (!c0935e2.g(interfaceC0975o22, r03, s0, y0D, h22, n2A)) {
                    break;
                }
                this = c0935e2;
                interfaceC0975o2 = interfaceC0975o22;
                r02 = r03;
            } finally {
                ((GeneratedMessageLite) obj).unknownFields = n2A;
            }
        }
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final void d(Object obj, byte[] bArr, int i, int i6, C0948i c0948i) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        if (generatedMessageLite.unknownFields == N2.f) {
            generatedMessageLite.unknownFields = N2.c();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final int e(GeneratedMessageLite generatedMessageLite) {
        ((O2) this.b).getClass();
        int iHashCode = generatedMessageLite.unknownFields.hashCode();
        if (!this.c) {
            return iHashCode;
        }
        return this.d.c(generatedMessageLite).f2903a.hashCode() + (iHashCode * 53);
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final boolean f(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
        O2 o22 = (O2) this.b;
        o22.getClass();
        N2 n22 = generatedMessageLite.unknownFields;
        o22.getClass();
        if (!n22.equals(generatedMessageLite2.unknownFields)) {
            return false;
        }
        if (!this.c) {
            return true;
        }
        S0 s0 = this.d;
        return s0.c(generatedMessageLite).equals(s0.c(generatedMessageLite2));
    }

    public final boolean g(InterfaceC0975o2 interfaceC0975o2, R0 r02, S0 s0, Y0 y02, H2 h22, N2 n22) throws InvalidProtocolBufferException {
        int tag = interfaceC0975o2.getTag();
        X1 x12 = this.f2918a;
        if (tag != 11) {
            if ((tag & 7) != 2) {
                return interfaceC0975o2.skipField();
            }
            s0.b(r02, x12, tag >>> 3);
            return h22.b(n22, interfaceC0975o2);
        }
        ByteString bytes = null;
        int uInt32 = 0;
        while (interfaceC0975o2.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = interfaceC0975o2.getTag();
            if (tag2 == 16) {
                uInt32 = interfaceC0975o2.readUInt32();
                s0.b(r02, x12, uInt32);
            } else if (tag2 == 26) {
                bytes = interfaceC0975o2.readBytes();
            } else if (!interfaceC0975o2.skipField()) {
                break;
            }
        }
        if (interfaceC0975o2.getTag() != 12) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
        if (bytes != null) {
            ((O2) h22).getClass();
            n22.d((uInt32 << 3) | 2, bytes);
        }
        return true;
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final boolean isInitialized(Object obj) {
        return this.d.c(obj).m();
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final void makeImmutable(Object obj) {
        ((O2) this.b).getClass();
        N2 n22 = ((GeneratedMessageLite) obj).unknownFields;
        if (n22.e) {
            n22.e = false;
        }
        this.d.f(obj);
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final void mergeFrom(Object obj, Object obj2) {
        AbstractC0983q2.l(this.b, obj, obj2);
        if (this.c) {
            AbstractC0983q2.k(this.d, obj, obj2);
        }
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final Object newInstance() {
        X1 x12 = this.f2918a;
        return x12 instanceof GeneratedMessageLite ? ((GeneratedMessageLite) x12).y() : x12.q().m();
    }
}
