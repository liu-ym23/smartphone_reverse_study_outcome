package com.google.protobuf;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public interface MessageLite {

    public interface Builder extends Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        Builder clear();

        Builder clone();

        /* synthetic */ MessageLite getDefaultInstanceForType();

        /* synthetic */ boolean isInitialized();

        boolean mergeDelimitedFrom(InputStream inputStream);

        boolean mergeDelimitedFrom(InputStream inputStream, u1 u1Var);

        Builder mergeFrom(MessageLite messageLite);

        Builder mergeFrom(l lVar);

        Builder mergeFrom(l lVar, u1 u1Var);

        Builder mergeFrom(o oVar);

        Builder mergeFrom(o oVar, u1 u1Var);

        Builder mergeFrom(InputStream inputStream);

        Builder mergeFrom(InputStream inputStream, u1 u1Var);

        Builder mergeFrom(byte[] bArr);

        Builder mergeFrom(byte[] bArr, int i2, int i10);

        Builder mergeFrom(byte[] bArr, int i2, int i10, u1 u1Var);

        Builder mergeFrom(byte[] bArr, u1 u1Var);
    }

    /* synthetic */ MessageLite getDefaultInstanceForType();

    p3 getParserForType();

    int getSerializedSize();

    /* synthetic */ boolean isInitialized();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    l toByteString();

    void writeDelimitedTo(OutputStream outputStream);

    void writeTo(r rVar);

    void writeTo(OutputStream outputStream);
}
