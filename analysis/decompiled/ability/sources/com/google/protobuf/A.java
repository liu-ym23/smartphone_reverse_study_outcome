package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class A extends AbstractC0936f {
    @Override // com.google.protobuf.InterfaceC0955j2
    public final Object a(AbstractC0972o abstractC0972o, R0 r02) throws InvalidProtocolBufferException {
        B bS = DescriptorProtos$EnumDescriptorProto.EnumReservedRange.g.s();
        try {
            bS.O(abstractC0972o, r02);
            return bS.m();
        } catch (InvalidProtocolBufferException e) {
            bS.m();
            throw e;
        } catch (UninitializedMessageException e6) {
            InvalidProtocolBufferException invalidProtocolBufferExceptionA = e6.a();
            bS.m();
            throw invalidProtocolBufferExceptionA;
        } catch (IOException e9) {
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e9.getMessage(), e9);
            bS.m();
            throw invalidProtocolBufferException;
        }
    }
}
