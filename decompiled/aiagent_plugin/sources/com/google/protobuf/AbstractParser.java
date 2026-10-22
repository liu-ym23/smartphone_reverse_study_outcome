package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;

    public AbstractParser() {
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r1) {
        return parseDelimitedFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return parseDelimitedFrom(r1, r2);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r1) {
        return parseFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return parseFrom(r1, r2);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream r1) {
        return parseFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return parseFrom(r1, r2);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r1) {
        return parseFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return parseFrom(r1, r2);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer r1) {
        return parseFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return parseFrom(r1, r2);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r1) {
        return parseFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r1, int r2, int r3) {
        return parseFrom(r1, r2, r3);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
        return parseFrom(r1, r2, r3, r4);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return parseFrom(r1, r2);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream r1) {
        return parsePartialDelimitedFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return parsePartialDelimitedFrom(r1, r2);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString r1) {
        return parsePartialFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString r1, ExtensionRegistryLite r2) {
        return parsePartialFrom(r1, r2);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r1) {
        return parsePartialFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream r1) {
        return parsePartialFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream r1, ExtensionRegistryLite r2) {
        return parsePartialFrom(r1, r2);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r1) {
        return parsePartialFrom(r1);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r1, int r2, int r3) {
        return parsePartialFrom(r1, r2, r3);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
        return parsePartialFrom(r1, r2, r3, r4);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r1, ExtensionRegistryLite r2) {
        return parsePartialFrom(r1, r2);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType r2) {
        MessageLite r1 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AbstractMessageLite.class) == false) goto L7;
        return ((AbstractMessageLite) ZeusTransformUtils.preCheckCast(r1, AbstractMessageLite.class, "com.obric.aiagent.plugin")).newUninitializedMessageException();
    L7:
        return new UninitializedMessageException(r1);
    }

    private MessageType checkMessageInitialized(MessageType r3) {
        MessageType r4 = (MessageType) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L9:
        return r4;
    L5:
        if (r4.isInitialized() == true) goto L9;
        throw newUninitializedMessageException(r4).asInvalidProtocolBufferException().setUnfinishedMessage(r4);
    }

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(CodedInputStream r2) {
        return (MessageType) ZeusTransformUtils.preCheckCast(parsePartialFrom(r2, EMPTY_REGISTRY), MessageLite.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r2, ExtensionRegistryLite r3) {
        return (MessageType) checkMessageInitialized((MessageLite) ZeusTransformUtils.preCheckCast(parsePartialFrom(r2, r3), MessageLite.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r2) {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(ByteString r2, ExtensionRegistryLite r3) {
        CodedInputStream r4 = r2.newCodedInput();     // Catch: InvalidProtocolBufferException -> L9
        MessageType r1 = (MessageType) ZeusTransformUtils.preCheckCast(parsePartialFrom(r4, r3), MessageLite.class, "com.obric.aiagent.plugin");     // Catch: InvalidProtocolBufferException -> L9
        r4.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L6
        return r1;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r1);     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw e;
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(ByteString r2) {
        return (MessageType) parsePartialFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteString r2) {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteBuffer r3, ExtensionRegistryLite r4) {
        CodedInputStream r5 = CodedInputStream.newInstance(r3);     // Catch: InvalidProtocolBufferException -> L10
        MessageLite r6 = (MessageLite) ZeusTransformUtils.preCheckCast(parsePartialFrom(r5, r4), MessageLite.class, "com.obric.aiagent.plugin");     // Catch: InvalidProtocolBufferException -> L10
        r5.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L7
    L6:
        return (MessageType) checkMessageInitialized(r6);
    L7:
        e = move-exception;
        throw e.setUnfinishedMessage(r6);     // Catch: InvalidProtocolBufferException -> L10
    L10:
        e = move-exception;
        throw e;
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteBuffer r2) {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
        CodedInputStream r5 = CodedInputStream.newInstance(r1, r2, r3);     // Catch: InvalidProtocolBufferException -> L9
        MessageType r0 = (MessageType) ZeusTransformUtils.preCheckCast(parsePartialFrom(r5, r4), MessageLite.class, "com.obric.aiagent.plugin");     // Catch: InvalidProtocolBufferException -> L9
        r5.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L6
        return r0;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r0);     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw e;
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r2, int r3, int r4) {
        return (MessageType) parsePartialFrom(r2, r3, r4, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r3, ExtensionRegistryLite r4) {
        return (MessageType) parsePartialFrom(r3, 0, r3.length, r4);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r4) {
        return (MessageType) parsePartialFrom(r4, 0, r4.length, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2, r3, r4));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r2, int r3, int r4) {
        return (MessageType) parseFrom(r2, r3, r4, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r3, ExtensionRegistryLite r4) {
        return (MessageType) parseFrom(r3, 0, r3.length, r4);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r2) {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(InputStream r2, ExtensionRegistryLite r3) {
        CodedInputStream r4 = CodedInputStream.newInstance(r2);
        MessageType r1 = (MessageType) ZeusTransformUtils.preCheckCast(parsePartialFrom(r4, r3), MessageLite.class, "com.obric.aiagent.plugin");
        r4.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r1;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r1);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(InputStream r2) {
        return (MessageType) parsePartialFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(InputStream r2) {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r3, ExtensionRegistryLite r4) {
        int r0 = r3.read();     // Catch: IOException -> L9
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        return (MessageType) parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(r3, CodedInputStream.readRawVarint32(r0, r3)), r4);
    L9:
        e = move-exception;
        throw new InvalidProtocolBufferException(e);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r2) {
        return (MessageType) parsePartialDelimitedFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (MessageType) checkMessageInitialized(parsePartialDelimitedFrom(r1, r2));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r2) {
        return (MessageType) parseDelimitedFrom(r2, EMPTY_REGISTRY);
    }
}
