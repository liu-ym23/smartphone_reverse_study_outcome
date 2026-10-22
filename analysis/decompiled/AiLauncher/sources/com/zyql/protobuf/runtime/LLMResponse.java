package com.zyql.protobuf.runtime;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.zyql.protobuf.common.Content;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class LLMResponse extends GeneratedMessageLite<LLMResponse, Builder> implements LLMResponseOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 1;
    private static final LLMResponse DEFAULT_INSTANCE;
    public static final int FINISH_REASON_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 6;
    private static volatile Parser<LLMResponse> PARSER = null;
    public static final int PARTIAL_FIELD_NUMBER = 2;
    public static final int SEQUENCE_INDEX_FIELD_NUMBER = 5;
    public static final int TURN_COMPLETE_FIELD_NUMBER = 3;
    private int bitField0_;
    private Content content_;
    private String finishReason_ = "";
    private Struct metadata_;
    private boolean partial_;
    private long sequenceIndex_;
    private boolean turnComplete_;

    /* renamed from: com.zyql.protobuf.runtime.LLMResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<LLMResponse, Builder> implements LLMResponseOrBuilder {
        public Builder clearContent() {
            copyOnWrite();
            ((LLMResponse) this.instance).clearContent();
            return this;
        }

        public Builder clearFinishReason() {
            copyOnWrite();
            ((LLMResponse) this.instance).clearFinishReason();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((LLMResponse) this.instance).clearMetadata();
            return this;
        }

        public Builder clearPartial() {
            copyOnWrite();
            ((LLMResponse) this.instance).clearPartial();
            return this;
        }

        public Builder clearSequenceIndex() {
            copyOnWrite();
            ((LLMResponse) this.instance).clearSequenceIndex();
            return this;
        }

        public Builder clearTurnComplete() {
            copyOnWrite();
            ((LLMResponse) this.instance).clearTurnComplete();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public Content getContent() {
            return ((LLMResponse) this.instance).getContent();
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public String getFinishReason() {
            return ((LLMResponse) this.instance).getFinishReason();
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public ByteString getFinishReasonBytes() {
            return ((LLMResponse) this.instance).getFinishReasonBytes();
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public Struct getMetadata() {
            return ((LLMResponse) this.instance).getMetadata();
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public boolean getPartial() {
            return ((LLMResponse) this.instance).getPartial();
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public long getSequenceIndex() {
            return ((LLMResponse) this.instance).getSequenceIndex();
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public boolean getTurnComplete() {
            return ((LLMResponse) this.instance).getTurnComplete();
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public boolean hasContent() {
            return ((LLMResponse) this.instance).hasContent();
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public boolean hasFinishReason() {
            return ((LLMResponse) this.instance).hasFinishReason();
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public boolean hasMetadata() {
            return ((LLMResponse) this.instance).hasMetadata();
        }

        @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
        public boolean hasSequenceIndex() {
            return ((LLMResponse) this.instance).hasSequenceIndex();
        }

        public Builder mergeContent(Content content) {
            copyOnWrite();
            ((LLMResponse) this.instance).mergeContent(content);
            return this;
        }

        public Builder mergeMetadata(Struct struct) {
            copyOnWrite();
            ((LLMResponse) this.instance).mergeMetadata(struct);
            return this;
        }

        public Builder setContent(Content content) {
            copyOnWrite();
            ((LLMResponse) this.instance).setContent(content);
            return this;
        }

        public Builder setFinishReason(String str) {
            copyOnWrite();
            ((LLMResponse) this.instance).setFinishReason(str);
            return this;
        }

        public Builder setFinishReasonBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((LLMResponse) this.instance).setFinishReasonBytes(byteString);
            return this;
        }

        public Builder setMetadata(Struct struct) {
            copyOnWrite();
            ((LLMResponse) this.instance).setMetadata(struct);
            return this;
        }

        public Builder setPartial(boolean z10) {
            copyOnWrite();
            ((LLMResponse) this.instance).setPartial(z10);
            return this;
        }

        public Builder setSequenceIndex(long j10) {
            copyOnWrite();
            ((LLMResponse) this.instance).setSequenceIndex(j10);
            return this;
        }

        public Builder setTurnComplete(boolean z10) {
            copyOnWrite();
            ((LLMResponse) this.instance).setTurnComplete(z10);
            return this;
        }

        private Builder() {
            super(LLMResponse.DEFAULT_INSTANCE);
        }

        public Builder setContent(Content.Builder builder) {
            copyOnWrite();
            ((LLMResponse) this.instance).setContent(builder.build());
            return this;
        }

        public Builder setMetadata(Struct.Builder builder) {
            copyOnWrite();
            ((LLMResponse) this.instance).setMetadata(builder.build());
            return this;
        }
    }

    static {
        LLMResponse lLMResponse = new LLMResponse();
        DEFAULT_INSTANCE = lLMResponse;
        GeneratedMessageLite.registerDefaultInstance(LLMResponse.class, lLMResponse);
    }

    private LLMResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContent() {
        this.content_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFinishReason() {
        this.bitField0_ &= -3;
        this.finishReason_ = getDefaultInstance().getFinishReason();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPartial() {
        this.partial_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSequenceIndex() {
        this.bitField0_ &= -5;
        this.sequenceIndex_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTurnComplete() {
        this.turnComplete_ = false;
    }

    public static LLMResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeContent(Content content) {
        content.getClass();
        Content content2 = this.content_;
        if (content2 == null || content2 == Content.getDefaultInstance()) {
            this.content_ = content;
        } else {
            this.content_ = Content.newBuilder(this.content_).mergeFrom((Content.Builder) content).buildPartial();
        }
        this.bitField0_ |= 1;
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
        this.bitField0_ |= 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static LLMResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LLMResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LLMResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LLMResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<LLMResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContent(Content content) {
        content.getClass();
        this.content_ = content;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFinishReason(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.finishReason_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFinishReasonBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.finishReason_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(Struct struct) {
        struct.getClass();
        this.metadata_ = struct;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPartial(boolean z10) {
        this.partial_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSequenceIndex(long j10) {
        this.bitField0_ |= 4;
        this.sequenceIndex_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTurnComplete(boolean z10) {
        this.turnComplete_ = z10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new LLMResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0007\u0003\u0007\u0004ለ\u0001\u0005ဃ\u0002\u0006ဉ\u0003", new Object[]{"bitField0_", "content_", "partial_", "turnComplete_", "finishReason_", "sequenceIndex_", "metadata_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<LLMResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (LLMResponse.class) {
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

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public Content getContent() {
        Content content = this.content_;
        return content == null ? Content.getDefaultInstance() : content;
    }

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public String getFinishReason() {
        return this.finishReason_;
    }

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public ByteString getFinishReasonBytes() {
        return ByteString.copyFromUtf8(this.finishReason_);
    }

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public Struct getMetadata() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public boolean getPartial() {
        return this.partial_;
    }

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public long getSequenceIndex() {
        return this.sequenceIndex_;
    }

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public boolean getTurnComplete() {
        return this.turnComplete_;
    }

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public boolean hasContent() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public boolean hasFinishReason() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public boolean hasMetadata() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.zyql.protobuf.runtime.LLMResponseOrBuilder
    public boolean hasSequenceIndex() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(LLMResponse lLMResponse) {
        return DEFAULT_INSTANCE.createBuilder(lLMResponse);
    }

    public static LLMResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LLMResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LLMResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LLMResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LLMResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LLMResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static LLMResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LLMResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LLMResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LLMResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LLMResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LLMResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static LLMResponse parseFrom(InputStream inputStream) throws IOException {
        return (LLMResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LLMResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LLMResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LLMResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LLMResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static LLMResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LLMResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
