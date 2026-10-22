package com.google.protobuf;

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

        boolean mergeDelimitedFrom(InputStream r10) throws IOException;

        boolean mergeDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException;

        Builder mergeFrom(ByteString r10) throws InvalidProtocolBufferException;

        Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

        Builder mergeFrom(CodedInputStream r10) throws IOException;

        Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException;

        Builder mergeFrom(MessageLite r10);

        Builder mergeFrom(InputStream r10) throws IOException;

        Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException;

        Builder mergeFrom(byte[] r10) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream r10) throws IOException;

    void writeTo(CodedOutputStream r10) throws IOException;

    void writeTo(OutputStream r10) throws IOException;
}
