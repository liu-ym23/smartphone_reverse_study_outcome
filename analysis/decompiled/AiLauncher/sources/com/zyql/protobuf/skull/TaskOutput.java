package com.zyql.protobuf.skull;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.skull.Message;
import com.zyql.protobuf.skull.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class TaskOutput extends GeneratedMessageLite<TaskOutput, Builder> implements TaskOutputOrBuilder {
    public static final int ARTIFACTS_FIELD_NUMBER = 2;
    private static final TaskOutput DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    private static volatile Parser<TaskOutput> PARSER;
    private Internal.ProtobufList<Resource> artifacts_ = GeneratedMessageLite.emptyProtobufList();
    private int bitField0_;
    private Message message_;

    /* renamed from: com.zyql.protobuf.skull.TaskOutput$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<TaskOutput, Builder> implements TaskOutputOrBuilder {
        public Builder addAllArtifacts(Iterable<? extends Resource> iterable) {
            copyOnWrite();
            ((TaskOutput) this.instance).addAllArtifacts(iterable);
            return this;
        }

        public Builder addArtifacts(Resource resource) {
            copyOnWrite();
            ((TaskOutput) this.instance).addArtifacts(resource);
            return this;
        }

        public Builder clearArtifacts() {
            copyOnWrite();
            ((TaskOutput) this.instance).clearArtifacts();
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((TaskOutput) this.instance).clearMessage();
            return this;
        }

        @Override // com.zyql.protobuf.skull.TaskOutputOrBuilder
        public Resource getArtifacts(int i10) {
            return ((TaskOutput) this.instance).getArtifacts(i10);
        }

        @Override // com.zyql.protobuf.skull.TaskOutputOrBuilder
        public int getArtifactsCount() {
            return ((TaskOutput) this.instance).getArtifactsCount();
        }

        @Override // com.zyql.protobuf.skull.TaskOutputOrBuilder
        public List<Resource> getArtifactsList() {
            return Collections.unmodifiableList(((TaskOutput) this.instance).getArtifactsList());
        }

        @Override // com.zyql.protobuf.skull.TaskOutputOrBuilder
        public Message getMessage() {
            return ((TaskOutput) this.instance).getMessage();
        }

        @Override // com.zyql.protobuf.skull.TaskOutputOrBuilder
        public boolean hasMessage() {
            return ((TaskOutput) this.instance).hasMessage();
        }

        public Builder mergeMessage(Message message) {
            copyOnWrite();
            ((TaskOutput) this.instance).mergeMessage(message);
            return this;
        }

        public Builder removeArtifacts(int i10) {
            copyOnWrite();
            ((TaskOutput) this.instance).removeArtifacts(i10);
            return this;
        }

        public Builder setArtifacts(int i10, Resource resource) {
            copyOnWrite();
            ((TaskOutput) this.instance).setArtifacts(i10, resource);
            return this;
        }

        public Builder setMessage(Message message) {
            copyOnWrite();
            ((TaskOutput) this.instance).setMessage(message);
            return this;
        }

        private Builder() {
            super(TaskOutput.DEFAULT_INSTANCE);
        }

        public Builder addArtifacts(int i10, Resource resource) {
            copyOnWrite();
            ((TaskOutput) this.instance).addArtifacts(i10, resource);
            return this;
        }

        public Builder setArtifacts(int i10, Resource.Builder builder) {
            copyOnWrite();
            ((TaskOutput) this.instance).setArtifacts(i10, builder.build());
            return this;
        }

        public Builder setMessage(Message.Builder builder) {
            copyOnWrite();
            ((TaskOutput) this.instance).setMessage(builder.build());
            return this;
        }

        public Builder addArtifacts(Resource.Builder builder) {
            copyOnWrite();
            ((TaskOutput) this.instance).addArtifacts(builder.build());
            return this;
        }

        public Builder addArtifacts(int i10, Resource.Builder builder) {
            copyOnWrite();
            ((TaskOutput) this.instance).addArtifacts(i10, builder.build());
            return this;
        }
    }

    static {
        TaskOutput taskOutput = new TaskOutput();
        DEFAULT_INSTANCE = taskOutput;
        GeneratedMessageLite.registerDefaultInstance(TaskOutput.class, taskOutput);
    }

    private TaskOutput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllArtifacts(Iterable<? extends Resource> iterable) {
        ensureArtifactsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.artifacts_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addArtifacts(Resource resource) {
        resource.getClass();
        ensureArtifactsIsMutable();
        this.artifacts_.add(resource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearArtifacts() {
        this.artifacts_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureArtifactsIsMutable() {
        Internal.ProtobufList<Resource> protobufList = this.artifacts_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.artifacts_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static TaskOutput getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMessage(Message message) {
        message.getClass();
        Message message2 = this.message_;
        if (message2 == null || message2 == Message.getDefaultInstance()) {
            this.message_ = message;
        } else {
            this.message_ = Message.newBuilder(this.message_).mergeFrom((Message.Builder) message).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TaskOutput parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TaskOutput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TaskOutput parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TaskOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TaskOutput> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeArtifacts(int i10) {
        ensureArtifactsIsMutable();
        this.artifacts_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArtifacts(int i10, Resource resource) {
        resource.getClass();
        ensureArtifactsIsMutable();
        this.artifacts_.set(i10, resource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(Message message) {
        message.getClass();
        this.message_ = message;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new TaskOutput();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "message_", "artifacts_", Resource.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TaskOutput> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TaskOutput.class) {
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

    @Override // com.zyql.protobuf.skull.TaskOutputOrBuilder
    public Resource getArtifacts(int i10) {
        return this.artifacts_.get(i10);
    }

    @Override // com.zyql.protobuf.skull.TaskOutputOrBuilder
    public int getArtifactsCount() {
        return this.artifacts_.size();
    }

    @Override // com.zyql.protobuf.skull.TaskOutputOrBuilder
    public List<Resource> getArtifactsList() {
        return this.artifacts_;
    }

    public ResourceOrBuilder getArtifactsOrBuilder(int i10) {
        return this.artifacts_.get(i10);
    }

    public List<? extends ResourceOrBuilder> getArtifactsOrBuilderList() {
        return this.artifacts_;
    }

    @Override // com.zyql.protobuf.skull.TaskOutputOrBuilder
    public Message getMessage() {
        Message message = this.message_;
        return message == null ? Message.getDefaultInstance() : message;
    }

    @Override // com.zyql.protobuf.skull.TaskOutputOrBuilder
    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(TaskOutput taskOutput) {
        return DEFAULT_INSTANCE.createBuilder(taskOutput);
    }

    public static TaskOutput parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskOutput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TaskOutput parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TaskOutput parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TaskOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addArtifacts(int i10, Resource resource) {
        resource.getClass();
        ensureArtifactsIsMutable();
        this.artifacts_.add(i10, resource);
    }

    public static TaskOutput parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TaskOutput parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TaskOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TaskOutput parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TaskOutput parseFrom(InputStream inputStream) throws IOException {
        return (TaskOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TaskOutput parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TaskOutput parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TaskOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TaskOutput parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TaskOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
