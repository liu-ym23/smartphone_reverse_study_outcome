package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class E extends AbstractC0936f {
    @Override // com.google.protobuf.InterfaceC0955j2
    public final Object a(AbstractC0972o abstractC0972o, R0 r02) throws InvalidProtocolBufferException {
        F fI = DescriptorProtos$EnumValueDescriptorProto.I();
        try {
            fI.O(abstractC0972o, r02);
            return fI.buildPartial();
        } catch (InvalidProtocolBufferException e) {
            fI.buildPartial();
            throw e;
        } catch (UninitializedMessageException e6) {
            InvalidProtocolBufferException invalidProtocolBufferExceptionA = e6.a();
            fI.buildPartial();
            throw invalidProtocolBufferExceptionA;
        } catch (IOException e9) {
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e9.getMessage(), e9);
            fI.buildPartial();
            throw invalidProtocolBufferException;
        }
    }
}
