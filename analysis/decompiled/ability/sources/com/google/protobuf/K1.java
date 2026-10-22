package com.google.protobuf;

import java.util.AbstractMap;

/* loaded from: classes3.dex */
public final class K1 {

    /* renamed from: a, reason: collision with root package name */
    public final u1.d f2848a;

    public K1(WireFormat$FieldType wireFormat$FieldType, WireFormat$FieldType wireFormat$FieldType2) {
        String str = "";
        this.f2848a = new u1.d(wireFormat$FieldType, str, wireFormat$FieldType2, str, 10);
    }

    public static int a(u1.d dVar, Object obj, Object obj2) {
        return Y0.e((WireFormat$FieldType) dVar.d, 2, obj2) + Y0.e((WireFormat$FieldType) dVar.b, 1, obj);
    }

    public static AbstractMap.SimpleImmutableEntry b(AbstractC0972o abstractC0972o, R0 r02, I1 i12) {
        Object objC = i12.c;
        Object objC2 = i12.e;
        while (true) {
            int iD = abstractC0972o.D();
            if (iD == 0) {
                break;
            }
            WireFormat$FieldType wireFormat$FieldType = (WireFormat$FieldType) i12.b;
            if (iD == (wireFormat$FieldType.b | 8)) {
                objC = c(abstractC0972o, r02, wireFormat$FieldType, objC);
            } else {
                WireFormat$FieldType wireFormat$FieldType2 = (WireFormat$FieldType) i12.d;
                if (iD == (wireFormat$FieldType2.b | 16)) {
                    objC2 = c(abstractC0972o, r02, wireFormat$FieldType2, objC2);
                } else if (!abstractC0972o.G(iD)) {
                    break;
                }
            }
        }
        return new AbstractMap.SimpleImmutableEntry(objC, objC2);
    }

    public static Object c(AbstractC0972o abstractC0972o, R0 r02, WireFormat$FieldType wireFormat$FieldType, Object obj) {
        int iOrdinal = wireFormat$FieldType.ordinal();
        if (iOrdinal == 9) {
            throw new RuntimeException("Groups are not allowed in maps.");
        }
        if (iOrdinal == 10) {
            W1 builder = ((X1) obj).toBuilder();
            abstractC0972o.v(builder, r02);
            return builder.m();
        }
        if (iOrdinal == 13) {
            return Integer.valueOf(abstractC0972o.n());
        }
        Y0 y02 = Y0.d;
        return AbstractC1002v2.G(abstractC0972o, wireFormat$FieldType, WireFormat$Utf8Validation.b);
    }

    public static void d(C0980q c0980q, u1.d dVar, Object obj, Object obj2) throws CodedOutputStream$OutOfSpaceException {
        Y0.u(c0980q, (WireFormat$FieldType) dVar.b, 1, obj);
        Y0.u(c0980q, (WireFormat$FieldType) dVar.d, 2, obj2);
    }
}
