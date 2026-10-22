package com.bytedance.location.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r1) throws InvalidProtocolBufferException;

    MessageType parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r1) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parseFrom(CodedInputStream r1) throws InvalidProtocolBufferException;

    MessageType parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r1) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteBuffer r1) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r1) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r1, int r2, int r3) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parsePartialDelimitedFrom(InputStream r1) throws InvalidProtocolBufferException;

    MessageType parsePartialDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(ByteString r1) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r1) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(InputStream r1) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r1) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r1, int r2, int r3) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;
}
