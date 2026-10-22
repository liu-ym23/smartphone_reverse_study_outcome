package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class B1 extends AbstractC0936f {
    @Override // com.google.protobuf.InterfaceC0955j2
    public final Object a(AbstractC0972o abstractC0972o, R0 r02) throws InvalidProtocolBufferException {
        C1 c1E = ListValue.e.toBuilder();
        try {
            c1E.P(abstractC0972o, r02);
            return c1E.m();
        } catch (InvalidProtocolBufferException e) {
            c1E.m();
            throw e;
        } catch (UninitializedMessageException e6) {
            InvalidProtocolBufferException invalidProtocolBufferExceptionA = e6.a();
            c1E.m();
            throw invalidProtocolBufferExceptionA;
        } catch (IOException e9) {
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e9.getMessage(), e9);
            c1E.m();
            throw invalidProtocolBufferException;
        }
    }
}
