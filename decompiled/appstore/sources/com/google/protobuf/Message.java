package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface Message extends MessageLite, MessageOrBuilder {

    public interface Builder extends MessageLite.Builder, MessageOrBuilder {
        Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11);

        Message build();

        Message buildPartial();

        Builder clear();

        Builder clearField(Descriptors.FieldDescriptor r10);

        Builder clearOneof(Descriptors.OneofDescriptor r10);

        Builder clone();

        @Override // com.google.protobuf.MessageOrBuilder
        Descriptors.Descriptor getDescriptorForType();

        Builder getFieldBuilder(Descriptors.FieldDescriptor r10);

        Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r10, int r11);

        boolean mergeDelimitedFrom(InputStream r10) throws IOException;

        boolean mergeDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException;

        Builder mergeFrom(ByteString r10) throws InvalidProtocolBufferException;

        Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

        Builder mergeFrom(CodedInputStream r10) throws IOException;

        Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException;

        Builder mergeFrom(Message r10);

        Builder mergeFrom(InputStream r10) throws IOException;

        Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException;

        Builder mergeFrom(byte[] r10) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

        Builder mergeUnknownFields(UnknownFieldSet r10);

        Builder newBuilderForField(Descriptors.FieldDescriptor r10);

        Builder setField(Descriptors.FieldDescriptor r10, Object r11);

        Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12);

        Builder setUnknownFields(UnknownFieldSet r10);
    }

    boolean equals(Object r10);

    Parser<? extends Message> getParserForType();

    int hashCode();

    Builder newBuilderForType();

    Builder toBuilder();

    String toString();
}
