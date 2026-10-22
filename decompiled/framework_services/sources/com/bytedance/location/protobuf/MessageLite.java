package com.bytedance.location.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        Builder clear();

        Builder clone();

        boolean mergeDelimitedFrom(InputStream r1) throws IOException;

        boolean mergeDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException;

        Builder mergeFrom(ByteString r1) throws InvalidProtocolBufferException;

        Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

        Builder mergeFrom(CodedInputStream r1) throws IOException;

        Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException;

        Builder mergeFrom(MessageLite r1);

        Builder mergeFrom(InputStream r1) throws IOException;

        Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException;

        Builder mergeFrom(byte[] r1) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r1, int r2, int r3) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream r1) throws IOException;

    void writeTo(CodedOutputStream r1) throws IOException;

    void writeTo(OutputStream r1) throws IOException;
}
