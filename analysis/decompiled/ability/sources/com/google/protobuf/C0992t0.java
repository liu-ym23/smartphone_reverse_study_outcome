package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import java.io.IOException;

/* renamed from: com.google.protobuf.t0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0992t0 extends AbstractC0936f {
    @Override // com.google.protobuf.InterfaceC0955j2
    public final Object a(AbstractC0972o abstractC0972o, R0 r02) throws InvalidProtocolBufferException {
        C0996u0 c0996u0H = DescriptorProtos$UninterpretedOption.NamePart.g.toBuilder();
        try {
            c0996u0H.P(abstractC0972o, r02);
            return c0996u0H.m();
        } catch (InvalidProtocolBufferException e) {
            c0996u0H.m();
            throw e;
        } catch (UninitializedMessageException e6) {
            InvalidProtocolBufferException invalidProtocolBufferExceptionA = e6.a();
            c0996u0H.m();
            throw invalidProtocolBufferExceptionA;
        } catch (IOException e9) {
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e9.getMessage(), e9);
            c0996u0H.m();
            throw invalidProtocolBufferException;
        }
    }
}
