package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    public AbstractParser() {
    }

    private MessageType checkMessageInitialized(MessageType r10) throws InvalidProtocolBufferException {
        if (r10 != null) goto L4;
    L8:
        return r10;
    L4:
        if (r10.isInitialized() == true) goto L8;
        throw newUninitializedMessageException(r10).asInvalidProtocolBufferException().setUnfinishedMessage(r10);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType r10) {
        if ((r10 instanceof AbstractMessageLite) == false) goto L7;
        return ((AbstractMessageLite) r10).newUninitializedMessageException();
    L7:
        return new UninitializedMessageException(r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r10) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return parseFrom(r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream r10) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString r10) throws InvalidProtocolBufferException {
        return parsePartialFrom(r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return parsePartialFrom(r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialDelimitedFrom(r10, r11));
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream r10) throws InvalidProtocolBufferException {
        return parseFrom(r10);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        int r12 = r10.read();     // Catch: IOException -> L9
        if (r12 != (-1)) goto L6;
        return null;
    L6:
        return (MessageType) parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(r10, CodedInputStream.readRawVarint32(r12, r10)), r11);
    L9:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage());
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r10) throws InvalidProtocolBufferException {
        return parsePartialFrom(r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream r10) throws InvalidProtocolBufferException {
        return parsePartialFrom(r10);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r10) throws InvalidProtocolBufferException {
        return (MessageType) parseDelimitedFrom(r10, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r10) throws InvalidProtocolBufferException {
        return parseFrom(r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return parsePartialFrom(r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r10) throws InvalidProtocolBufferException {
        return parsePartialFrom(r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return parseFrom(r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
        return parsePartialFrom(r10, r11, r12);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
        return parseFrom(r10, r11, r12);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r10) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialDelimitedFrom(r10, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
        return parsePartialFrom(r10, r11, r12, r13);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
        return parseFrom(r10, r11, r12, r13);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return parsePartialFrom(r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return parseFrom(r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(CodedInputStream r10) throws InvalidProtocolBufferException {
        return parsePartialFrom(r10, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r10, r11));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        CodedInputStream r12 = r10.newCodedInput();
        MessageType r13 = parsePartialFrom(r12, r11);
        r12.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r13;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r13);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r10) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r10, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r10, r11));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r10, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(ByteString r10) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r10, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r10, r11, r12, r13));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
        CodedInputStream r14 = CodedInputStream.newInstance(r10, r11, r12);
        MessageType r15 = parsePartialFrom(r14, r13);
        r14.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r15;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r15);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r10, r11, r12, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r10, 0, r10.length, r11);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r10, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r10, r11, r12, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r10, r11));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r10, 0, r10.length, r11);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r10) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r10, 0, r10.length, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(InputStream r10) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r10, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(InputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        CodedInputStream r12 = CodedInputStream.newInstance(r10);
        MessageType r13 = parsePartialFrom(r12, r11);
        r12.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r13;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r13);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(InputStream r10) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r10, EMPTY_REGISTRY);
    }
}
