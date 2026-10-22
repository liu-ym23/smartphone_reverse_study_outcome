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
import com.zyql.protobuf.runtime.ExecutionOptions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class StartAgentRequest extends GeneratedMessageLite<StartAgentRequest, Builder> implements StartAgentRequestOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    private static final StartAgentRequest DEFAULT_INSTANCE;
    public static final int MESSAGES_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 5;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static volatile Parser<StartAgentRequest> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private Struct metadata_;
    private ExecutionOptions options_;
    private String agentId_ = "";
    private String userId_ = "";
    private String sessionId_ = "";
    private Internal.ProtobufList<Content> messages_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.runtime.StartAgentRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StartAgentRequest, Builder> implements StartAgentRequestOrBuilder {
        public Builder addAllMessages(Iterable<? extends Content> iterable) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).addAllMessages(iterable);
            return this;
        }

        public Builder addMessages(Content content) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).addMessages(content);
            return this;
        }

        public Builder clearAgentId() {
            copyOnWrite();
            ((StartAgentRequest) this.instance).clearAgentId();
            return this;
        }

        public Builder clearMessages() {
            copyOnWrite();
            ((StartAgentRequest) this.instance).clearMessages();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((StartAgentRequest) this.instance).clearMetadata();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((StartAgentRequest) this.instance).clearOptions();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((StartAgentRequest) this.instance).clearSessionId();
            return this;
        }

        public Builder clearUserId() {
            copyOnWrite();
            ((StartAgentRequest) this.instance).clearUserId();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public String getAgentId() {
            return ((StartAgentRequest) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public ByteString getAgentIdBytes() {
            return ((StartAgentRequest) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public Content getMessages(int i10) {
            return ((StartAgentRequest) this.instance).getMessages(i10);
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public int getMessagesCount() {
            return ((StartAgentRequest) this.instance).getMessagesCount();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public List<Content> getMessagesList() {
            return Collections.unmodifiableList(((StartAgentRequest) this.instance).getMessagesList());
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public Struct getMetadata() {
            return ((StartAgentRequest) this.instance).getMetadata();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public ExecutionOptions getOptions() {
            return ((StartAgentRequest) this.instance).getOptions();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public String getSessionId() {
            return ((StartAgentRequest) this.instance).getSessionId();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public ByteString getSessionIdBytes() {
            return ((StartAgentRequest) this.instance).getSessionIdBytes();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public String getUserId() {
            return ((StartAgentRequest) this.instance).getUserId();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public ByteString getUserIdBytes() {
            return ((StartAgentRequest) this.instance).getUserIdBytes();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public boolean hasMetadata() {
            return ((StartAgentRequest) this.instance).hasMetadata();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public boolean hasOptions() {
            return ((StartAgentRequest) this.instance).hasOptions();
        }

        @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
        public boolean hasSessionId() {
            return ((StartAgentRequest) this.instance).hasSessionId();
        }

        public Builder mergeMetadata(Struct struct) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).mergeMetadata(struct);
            return this;
        }

        public Builder mergeOptions(ExecutionOptions executionOptions) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).mergeOptions(executionOptions);
            return this;
        }

        public Builder removeMessages(int i10) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).removeMessages(i10);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setMessages(int i10, Content content) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setMessages(i10, content);
            return this;
        }

        public Builder setMetadata(Struct struct) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setMetadata(struct);
            return this;
        }

        public Builder setOptions(ExecutionOptions executionOptions) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setOptions(executionOptions);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        public Builder setUserId(String str) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setUserId(str);
            return this;
        }

        public Builder setUserIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setUserIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(StartAgentRequest.DEFAULT_INSTANCE);
        }

        public Builder addMessages(int i10, Content content) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).addMessages(i10, content);
            return this;
        }

        public Builder setMessages(int i10, Content.Builder builder) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setMessages(i10, builder.build());
            return this;
        }

        public Builder setMetadata(Struct.Builder builder) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setMetadata(builder.build());
            return this;
        }

        public Builder setOptions(ExecutionOptions.Builder builder) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).setOptions(builder.build());
            return this;
        }

        public Builder addMessages(Content.Builder builder) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).addMessages(builder.build());
            return this;
        }

        public Builder addMessages(int i10, Content.Builder builder) {
            copyOnWrite();
            ((StartAgentRequest) this.instance).addMessages(i10, builder.build());
            return this;
        }
    }

    static {
        StartAgentRequest startAgentRequest = new StartAgentRequest();
        DEFAULT_INSTANCE = startAgentRequest;
        GeneratedMessageLite.registerDefaultInstance(StartAgentRequest.class, startAgentRequest);
    }

    private StartAgentRequest() {
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
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessages() {
        this.messages_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.bitField0_ &= -2;
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUserId() {
        this.userId_ = getDefaultInstance().getUserId();
    }

    private void ensureMessagesIsMutable() {
        Internal.ProtobufList<Content> protobufList = this.messages_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.messages_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static StartAgentRequest getDefaultInstance() {
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
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOptions(ExecutionOptions executionOptions) {
        executionOptions.getClass();
        ExecutionOptions executionOptions2 = this.options_;
        if (executionOptions2 == null || executionOptions2 == ExecutionOptions.getDefaultInstance()) {
            this.options_ = executionOptions;
        } else {
            this.options_ = ExecutionOptions.newBuilder(this.options_).mergeFrom((ExecutionOptions.Builder) executionOptions).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StartAgentRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StartAgentRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StartAgentRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StartAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StartAgentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMessages(int i10) {
        ensureMessagesIsMutable();
        this.messages_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentId(String str) {
        str.getClass();
        this.agentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.agentId_ = byteString.toStringUtf8();
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
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(ExecutionOptions executionOptions) {
        executionOptions.getClass();
        this.options_ = executionOptions;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserId(String str) {
        str.getClass();
        this.userId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.userId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new StartAgentRequest();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003ለ\u0000\u0004\u001b\u0005ဉ\u0001\u0006ဉ\u0002", new Object[]{"bitField0_", "agentId_", "userId_", "sessionId_", "messages_", Content.class, "metadata_", "options_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StartAgentRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StartAgentRequest.class) {
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

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public Content getMessages(int i10) {
        return this.messages_.get(i10);
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public int getMessagesCount() {
        return this.messages_.size();
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public List<Content> getMessagesList() {
        return this.messages_;
    }

    public ContentOrBuilder getMessagesOrBuilder(int i10) {
        return this.messages_.get(i10);
    }

    public List<? extends ContentOrBuilder> getMessagesOrBuilderList() {
        return this.messages_;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public Struct getMetadata() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public ExecutionOptions getOptions() {
        ExecutionOptions executionOptions = this.options_;
        return executionOptions == null ? ExecutionOptions.getDefaultInstance() : executionOptions;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public String getUserId() {
        return this.userId_;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public ByteString getUserIdBytes() {
        return ByteString.copyFromUtf8(this.userId_);
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public boolean hasMetadata() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public boolean hasOptions() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.zyql.protobuf.runtime.StartAgentRequestOrBuilder
    public boolean hasSessionId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(StartAgentRequest startAgentRequest) {
        return DEFAULT_INSTANCE.createBuilder(startAgentRequest);
    }

    public static StartAgentRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StartAgentRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StartAgentRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StartAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StartAgentRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StartAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(int i10, Content content) {
        content.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(i10, content);
    }

    public static StartAgentRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StartAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StartAgentRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StartAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StartAgentRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StartAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StartAgentRequest parseFrom(InputStream inputStream) throws IOException {
        return (StartAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StartAgentRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StartAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StartAgentRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StartAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StartAgentRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StartAgentRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
