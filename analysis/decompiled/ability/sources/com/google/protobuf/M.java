package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class M extends AbstractC0936f {
    @Override // com.google.protobuf.InterfaceC0955j2
    public final Object a(AbstractC0972o abstractC0972o, R0 r02) throws InvalidProtocolBufferException {
        N nJ = DescriptorProtos$FeatureSet.l.toBuilder();
        try {
            nJ.V(abstractC0972o, r02);
            return nJ.m();
        } catch (InvalidProtocolBufferException e) {
            nJ.m();
            throw e;
        } catch (UninitializedMessageException e6) {
            InvalidProtocolBufferException invalidProtocolBufferExceptionA = e6.a();
            nJ.m();
            throw invalidProtocolBufferExceptionA;
        } catch (IOException e9) {
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e9.getMessage(), e9);
            nJ.m();
            throw invalidProtocolBufferException;
        }
    }
}
