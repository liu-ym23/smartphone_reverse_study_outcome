package com.zyql.protobuf.runtime;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.zyql.protobuf.common.Content;
import com.zyql.protobuf.common.ContentOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class SendInputRequest extends GeneratedMessageLite<SendInputRequest, Builder> implements SendInputRequestOrBuilder {
    private static final SendInputRequest DEFAULT_INSTANCE;
    public static final int MESSAGES_FIELD_NUMBER = 2;
    public static final int METADATA_FIELD_NUMBER = 3;
    private static volatile Parser<SendInputRequest> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private Struct metadata_;
    private String sessionId_ = "";
    private Internal.ProtobufList<Content> messages_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.runtime.SendInputRequest$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<SendInputRequest, Builder> implements SendInputRequestOrBuilder {
        public Builder addAllMessages(Iterable<? extends Content> iterable) {
            copyOnWrite();
            ((SendInputRequest) this.instance).addAllMessages(iterable);
            return this;
        }

        public Builder addMessages(Content content) {
            copyOnWrite();
            ((SendInputRequest) this.instance).addMessages(content);
            return this;
        }

        public Builder clearMessages() {
            copyOnWrite();
            ((SendInputRequest) this.instance).clearMessages();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((SendInputRequest) this.instance).clearMetadata();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((SendInputRequest) this.instance).clearSessionId();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
        public Content getMessages(int i10) {
            return ((SendInputRequest) this.instance).getMessages(i10);
        }

        @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
        public int getMessagesCount() {
            return ((SendInputRequest) this.instance).getMessagesCount();
        }

        @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
        public List<Content> getMessagesList() {
            return Collections.unmodifiableList(((SendInputRequest) this.instance).getMessagesList());
        }

        @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
        public Struct getMetadata() {
            return ((SendInputRequest) this.instance).getMetadata();
        }

        @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
        public String getSessionId() {
            return ((SendInputRequest) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
        public ByteString getSessionIdBytes() {
            return ((SendInputRequest) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
        public boolean hasMetadata() {
            return ((SendInputRequest) this.instance).hasMetadata();
        }

        public Builder mergeMetadata(Struct struct) {
            copyOnWrite();
            ((SendInputRequest) this.instance).mergeMetadata(struct);
            return this;
        }

        public Builder removeMessages(int i10) {
            copyOnWrite();
            ((SendInputRequest) this.instance).removeMessages(i10);
            return this;
        }

        public Builder setMessages(int i10, Content content) {
            copyOnWrite();
            ((SendInputRequest) this.instance).setMessages(i10, content);
            return this;
        }

        public Builder setMetadata(Struct struct) {
            copyOnWrite();
            ((SendInputRequest) this.instance).setMetadata(struct);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((SendInputRequest) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((SendInputRequest) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(SendInputRequest.DEFAULT_INSTANCE);
        }

        public Builder addMessages(int i10, Content content) {
            copyOnWrite();
            ((SendInputRequest) this.instance).addMessages(i10, content);
            return this;
        }

        public Builder setMessages(int i10, Content.Builder builder) {
            copyOnWrite();
            ((SendInputRequest) this.instance).setMessages(i10, builder.build());
            return this;
        }

        public Builder setMetadata(Struct.Builder builder) {
            copyOnWrite();
            ((SendInputRequest) this.instance).setMetadata(builder.build());
            return this;
        }

        public Builder addMessages(Content.Builder builder) {
            copyOnWrite();
            ((SendInputRequest) this.instance).addMessages(builder.build());
            return this;
        }

        public Builder addMessages(int i10, Content.Builder builder) {
            copyOnWrite();
            ((SendInputRequest) this.instance).addMessages(i10, builder.build());
            return this;
        }
    }

    static {
        SendInputRequest sendInputRequest = new SendInputRequest();
        DEFAULT_INSTANCE = sendInputRequest;
        GeneratedMessageLite.registerDefaultInstance(SendInputRequest.class, sendInputRequest);
    }

    private SendInputRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMessages(Iterable<? extends Content> iterable) {
        ensureMessagesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.messages_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(Content content) {
        content.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessages() {
        this.messages_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    private void ensureMessagesIsMutable() {
        Internal.ProtobufList<Content> protobufList = this.messages_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.messages_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static SendInputRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMetadata(Struct struct) {
        struct.getClass();
        Struct struct2 = this.metadata_;
        if (struct2 == null || struct2 == Struct.getDefaultInstance()) {
            this.metadata_ = struct;
        } else {
            this.metadata_ = Struct.newBuilder(this.metadata_).mergeFrom((Struct.Builder) struct).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SendInputRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SendInputRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SendInputRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SendInputRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SendInputRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMessages(int i10) {
        ensureMessagesIsMutable();
        this.messages_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessages(int i10, Content content) {
        content.getClass();
        ensureMessagesIsMutable();
        this.messages_.set(i10, content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(Struct struct) {
        struct.getClass();
        this.metadata_ = struct;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new SendInputRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003ဉ\u0000", new Object[]{"bitField0_", "sessionId_", "messages_", Content.class, "metadata_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SendInputRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SendInputRequest.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
    public Content getMessages(int i10) {
        return this.messages_.get(i10);
    }

    @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
    public int getMessagesCount() {
        return this.messages_.size();
    }

    @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
    public List<Content> getMessagesList() {
        return this.messages_;
    }

    public ContentOrBuilder getMessagesOrBuilder(int i10) {
        return this.messages_.get(i10);
    }

    public List<? extends ContentOrBuilder> getMessagesOrBuilderList() {
        return this.messages_;
    }

    @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
    public Struct getMetadata() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.runtime.SendInputRequestOrBuilder
    public boolean hasMetadata() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(SendInputRequest sendInputRequest) {
        return DEFAULT_INSTANCE.createBuilder(sendInputRequest);
    }

    public static SendInputRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SendInputRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SendInputRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SendInputRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SendInputRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SendInputRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(int i10, Content content) {
        content.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(i10, content);
    }

    public static SendInputRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SendInputRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SendInputRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SendInputRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SendInputRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SendInputRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SendInputRequest parseFrom(InputStream inputStream) throws IOException {
        return (SendInputRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SendInputRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SendInputRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SendInputRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SendInputRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SendInputRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SendInputRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
