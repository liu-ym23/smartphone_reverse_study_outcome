package com.google.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r10) throws InvalidProtocolBufferException;

    MessageType parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r10) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

    MessageType parseFrom(CodedInputStream r10) throws InvalidProtocolBufferException;

    MessageType parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r10) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r10) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

    MessageType parsePartialDelimitedFrom(InputStream r10) throws InvalidProtocolBufferException;

    MessageType parsePartialDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(ByteString r10) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r10) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(InputStream r10) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r10) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException;
}
