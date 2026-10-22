package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;

    public AbstractParser() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType r1) {
        if ((r1 instanceof AbstractMessageLite) == false) goto L7;
        return ((AbstractMessageLite) r1).newUninitializedMessageException();
    L7:
        return new UninitializedMessageException(r1);
    }

    private MessageType checkMessageInitialized(MessageType r2) throws InvalidProtocolBufferException {
        if (r2 != null) goto L4;
    L8:
        return r2;
    L4:
        if (r2.isInitialized() == true) goto L8;
        throw newUninitializedMessageException(r2).asInvalidProtocolBufferException().setUnfinishedMessage(r2);
    }

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    public MessageType parsePartialFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        CodedInputStream r3 = r1.newCodedInput();     // Catch: InvalidProtocolBufferException -> L9
        MessageType r0 = parsePartialFrom(r3, r2);     // Catch: InvalidProtocolBufferException -> L9
        r3.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L6
        return r0;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r0);     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2));
    }

    public MessageType parsePartialFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        CodedInputStream r3 = CodedInputStream.newInstance(r1);
        MessageType r0 = parsePartialFrom(r3, r2);
        r3.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r0;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2));
    }

    public MessageType parsePartialDelimitedFrom(InputStream r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        int r0 = r3.read();     // Catch: IOException -> L9
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        return (MessageType) parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(r3, CodedInputStream.readRawVarint32(r0, r3)), r4);
    L9:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialDelimitedFrom(r1, r2));
    }
}
