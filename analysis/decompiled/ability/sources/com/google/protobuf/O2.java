package com.google.protobuf;

/* loaded from: classes3.dex */
public final class O2 extends H2 {
    @Override // com.google.protobuf.H2
    public final N2 a(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        N2 n22 = generatedMessageLite.unknownFields;
        if (n22 != N2.f) {
            return n22;
        }
        N2 n2C = N2.c();
        generatedMessageLite.unknownFields = n2C;
        return n2C;
    }

    @Override // com.google.protobuf.H2
    public final void c(Object obj, Object obj2) {
        ((GeneratedMessageLite) obj).unknownFields = (N2) obj2;
    }
}
