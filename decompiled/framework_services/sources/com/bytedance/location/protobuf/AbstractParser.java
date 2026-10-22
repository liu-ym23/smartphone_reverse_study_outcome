package com.bytedance.location.protobuf;

import com.bytedance.location.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;

    public AbstractParser() {
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r1) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r1) throws InvalidProtocolBufferException {
        return parseFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream r1) throws InvalidProtocolBufferException {
        return parseFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r1) throws InvalidProtocolBufferException {
        return parseFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer r1) throws InvalidProtocolBufferException {
        return parseFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r1) throws InvalidProtocolBufferException {
        return parseFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r1, int r2, int r3) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2, r3);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2, r3, r4);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream r1) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString r1) throws InvalidProtocolBufferException {
        return parsePartialFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parsePartialFrom(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r1) throws InvalidProtocolBufferException {
        return parsePartialFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream r1) throws InvalidProtocolBufferException {
        return parsePartialFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parsePartialFrom(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r1) throws InvalidProtocolBufferException {
        return parsePartialFrom(r1);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r1, int r2, int r3) throws InvalidProtocolBufferException {
        return parsePartialFrom(r1, r2, r3);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        return parsePartialFrom(r1, r2, r3, r4);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parsePartialFrom(r1, r2);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType message) {
        if ((message instanceof AbstractMessageLite) == false) goto L7;
        return ((AbstractMessageLite) message).newUninitializedMessageException();
    L7:
        return new UninitializedMessageException(message);
    }

    private MessageType checkMessageInitialized(MessageType message) throws InvalidProtocolBufferException {
        if (message != null) goto L4;
    L8:
        return message;
    L4:
        if (message.isInitialized() == true) goto L8;
        throw newUninitializedMessageException(message).asInvalidProtocolBufferException().setUnfinishedMessage(message);
    }

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
        return parsePartialFrom(input, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r2, r3));
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r2) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        CodedInputStream input = data.newCodedInput();     // Catch: InvalidProtocolBufferException -> L9
        MessageType message = parsePartialFrom(input, extensionRegistry);     // Catch: InvalidProtocolBufferException -> L9
        input.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L6
        return message;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(message);     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw e;
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialFrom(ByteString r2) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(ByteString r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r2, r3));
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(ByteString r2) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(ByteBuffer r5, ExtensionRegistryLite r6) throws InvalidProtocolBufferException {
        CodedInputStream r0 = CodedInputStream.newInstance(r5);     // Catch: InvalidProtocolBufferException -> L10
        MessageType r1 = parsePartialFrom(r0, r6);     // Catch: InvalidProtocolBufferException -> L10
        r0.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L7
    L6:
        return (MessageType) checkMessageInitialized(r1);
    L7:
        e = move-exception;
        throw e.setUnfinishedMessage(r1);     // Catch: InvalidProtocolBufferException -> L10
    L10:
        e = move-exception;
        throw e;
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(ByteBuffer r2) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        CodedInputStream input = CodedInputStream.newInstance(data, off, len);     // Catch: InvalidProtocolBufferException -> L9
        MessageType message = parsePartialFrom(input, extensionRegistry);     // Catch: InvalidProtocolBufferException -> L9
        input.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L6
        return message;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(message);     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw e;
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r2, int r3, int r4) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r2, r3, r4, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r3, 0, r3.length, r4);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r4) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r4, 0, r4.length, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(byte[] r2, int r3, int r4, ExtensionRegistryLite r5) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r2, r3, r4, r5));
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(byte[] r2, int r3, int r4) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, r3, r4, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(byte[] r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r3, 0, r3.length, r4);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(byte[] r2) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        CodedInputStream codedInput = CodedInputStream.newInstance(input);
        MessageType message = parsePartialFrom(codedInput, extensionRegistry);
        codedInput.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return message;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(message);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialFrom(InputStream r2) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(InputStream r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r2, r3));
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseFrom(InputStream r2) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r4, ExtensionRegistryLite r5) throws InvalidProtocolBufferException {
        int r0 = r4.read();     // Catch: IOException -> L9
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        return (MessageType) parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(r4, CodedInputStream.readRawVarint32(r0, r4)), r5);
    L9:
        e = move-exception;
        throw new InvalidProtocolBufferException(e);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r2) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialDelimitedFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialDelimitedFrom(r2, r3));
    }

    @Override // com.bytedance.location.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r2) throws InvalidProtocolBufferException {
        return (MessageType) parseDelimitedFrom(r2, EMPTY_REGISTRY);
    }
}
