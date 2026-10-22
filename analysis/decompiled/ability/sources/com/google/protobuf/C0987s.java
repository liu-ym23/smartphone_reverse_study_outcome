package com.google.protobuf;

import java.io.IOException;

/* renamed from: com.google.protobuf.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0987s extends AbstractC0936f {
    @Override // com.google.protobuf.InterfaceC0955j2
    public final Object a(AbstractC0972o abstractC0972o, R0 r02) throws InvalidProtocolBufferException {
        C0991t builder = DescriptorProtos$DescriptorProto.o.toBuilder();
        try {
            builder.Q(abstractC0972o, r02);
            return builder.m();
        } catch (InvalidProtocolBufferException e) {
            builder.m();
            throw e;
        } catch (UninitializedMessageException e6) {
            InvalidProtocolBufferException invalidProtocolBufferExceptionA = e6.a();
            builder.m();
            throw invalidProtocolBufferExceptionA;
        } catch (IOException e9) {
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e9.getMessage(), e9);
            builder.m();
            throw invalidProtocolBufferException;
        }
    }
}
