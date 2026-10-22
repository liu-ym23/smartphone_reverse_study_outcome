package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class L2 extends AbstractC0936f {
    @Override // com.google.protobuf.InterfaceC0955j2
    public final Object a(AbstractC0972o abstractC0972o, R0 r02) throws InvalidProtocolBufferException {
        I2 i2G = M2.g();
        try {
            i2G.n(abstractC0972o);
            return i2G.k();
        } catch (InvalidProtocolBufferException e) {
            i2G.k();
            throw e;
        } catch (IOException e6) {
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e6.getMessage(), e6);
            i2G.k();
            throw invalidProtocolBufferException;
        }
    }
}
