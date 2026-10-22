package com.google.protobuf;

import java.io.IOException;

/* renamed from: com.google.protobuf.r0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0984r0 extends AbstractC0936f {
    @Override // com.google.protobuf.InterfaceC0955j2
    public final Object a(AbstractC0972o abstractC0972o, R0 r02) throws InvalidProtocolBufferException {
        C0988s0 c0988s0L = DescriptorProtos$UninterpretedOption.l.toBuilder();
        try {
            c0988s0L.P(abstractC0972o, r02);
            return c0988s0L.m();
        } catch (InvalidProtocolBufferException e) {
            c0988s0L.m();
            throw e;
        } catch (UninitializedMessageException e6) {
            InvalidProtocolBufferException invalidProtocolBufferExceptionA = e6.a();
            c0988s0L.m();
            throw invalidProtocolBufferExceptionA;
        } catch (IOException e9) {
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e9.getMessage(), e9);
            c0988s0L.m();
            throw invalidProtocolBufferException;
        }
    }
}
