package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.skull.Task;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class Handoff extends GeneratedMessageLite<Handoff, Builder> implements HandoffOrBuilder {
    private static final Handoff DEFAULT_INSTANCE;
    private static volatile Parser<Handoff> PARSER = null;
    public static final int TASK_FIELD_NUMBER = 1;
    private int bitField0_;
    private Task task_;

    /* renamed from: com.zyql.protobuf.skull.Handoff$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Handoff, Builder> implements HandoffOrBuilder {
        public Builder clearTask() {
            copyOnWrite();
            ((Handoff) this.instance).clearTask();
            return this;
        }

        @Override // com.zyql.protobuf.skull.HandoffOrBuilder
        public Task getTask() {
            return ((Handoff) this.instance).getTask();
        }

        @Override // com.zyql.protobuf.skull.HandoffOrBuilder
        public boolean hasTask() {
            return ((Handoff) this.instance).hasTask();
        }

        public Builder mergeTask(Task task) {
            copyOnWrite();
            ((Handoff) this.instance).mergeTask(task);
            return this;
        }

        public Builder setTask(Task task) {
            copyOnWrite();
            ((Handoff) this.instance).setTask(task);
            return this;
        }

        private Builder() {
            super(Handoff.DEFAULT_INSTANCE);
        }

        public Builder setTask(Task.Builder builder) {
            copyOnWrite();
            ((Handoff) this.instance).setTask(builder.build());
            return this;
        }
    }

    static {
        Handoff handoff = new Handoff();
        DEFAULT_INSTANCE = handoff;
        GeneratedMessageLite.registerDefaultInstance(Handoff.class, handoff);
    }

    private Handoff() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTask() {
        this.task_ = null;
        this.bitField0_ &= -2;
    }

    public static Handoff getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTask(Task task) {
        task.getClass();
        Task task2 = this.task_;
        if (task2 == null || task2 == Task.getDefaultInstance()) {
            this.task_ = task;
        } else {
            this.task_ = Task.newBuilder(this.task_).mergeFrom((Task.Builder) task).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Handoff parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Handoff) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Handoff parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Handoff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Handoff> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTask(Task task) {
        task.getClass();
        this.task_ = task;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Handoff();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "task_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Handoff> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Handoff.class) {
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

    @Override // com.zyql.protobuf.skull.HandoffOrBuilder
    public Task getTask() {
        Task task = this.task_;
        return task == null ? Task.getDefaultInstance() : task;
    }

    @Override // com.zyql.protobuf.skull.HandoffOrBuilder
    public boolean hasTask() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(Handoff handoff) {
        return DEFAULT_INSTANCE.createBuilder(handoff);
    }

    public static Handoff parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Handoff) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Handoff parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Handoff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Handoff parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Handoff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Handoff parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Handoff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Handoff parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Handoff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Handoff parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Handoff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Handoff parseFrom(InputStream inputStream) throws IOException {
        return (Handoff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Handoff parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Handoff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Handoff parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Handoff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Handoff parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Handoff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
