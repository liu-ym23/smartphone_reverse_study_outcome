package com.zyql.protobuf.runtime;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class AgentTaskStateNotification extends GeneratedMessageLite<AgentTaskStateNotification, Builder> implements AgentTaskStateNotificationOrBuilder {
    private static final AgentTaskStateNotification DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 2;
    private static volatile Parser<AgentTaskStateNotification> PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String details_ = "";
    private int state_;

    /* renamed from: com.zyql.protobuf.runtime.AgentTaskStateNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AgentTaskStateNotification, Builder> implements AgentTaskStateNotificationOrBuilder {
        public Builder clearDetails() {
            copyOnWrite();
            ((AgentTaskStateNotification) this.instance).clearDetails();
            return this;
        }

        public Builder clearState() {
            copyOnWrite();
            ((AgentTaskStateNotification) this.instance).clearState();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.AgentTaskStateNotificationOrBuilder
        public String getDetails() {
            return ((AgentTaskStateNotification) this.instance).getDetails();
        }

        @Override // com.zyql.protobuf.runtime.AgentTaskStateNotificationOrBuilder
        public ByteString getDetailsBytes() {
            return ((AgentTaskStateNotification) this.instance).getDetailsBytes();
        }

        @Override // com.zyql.protobuf.runtime.AgentTaskStateNotificationOrBuilder
        public State getState() {
            return ((AgentTaskStateNotification) this.instance).getState();
        }

        @Override // com.zyql.protobuf.runtime.AgentTaskStateNotificationOrBuilder
        public int getStateValue() {
            return ((AgentTaskStateNotification) this.instance).getStateValue();
        }

        @Override // com.zyql.protobuf.runtime.AgentTaskStateNotificationOrBuilder
        public boolean hasDetails() {
            return ((AgentTaskStateNotification) this.instance).hasDetails();
        }

        public Builder setDetails(String str) {
            copyOnWrite();
            ((AgentTaskStateNotification) this.instance).setDetails(str);
            return this;
        }

        public Builder setDetailsBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentTaskStateNotification) this.instance).setDetailsBytes(byteString);
            return this;
        }

        public Builder setState(State state) {
            copyOnWrite();
            ((AgentTaskStateNotification) this.instance).setState(state);
            return this;
        }

        public Builder setStateValue(int i10) {
            copyOnWrite();
            ((AgentTaskStateNotification) this.instance).setStateValue(i10);
            return this;
        }

        private Builder() {
            super(AgentTaskStateNotification.DEFAULT_INSTANCE);
        }
    }

    public enum State implements Internal.EnumLite {
        STATE_UNSPECIFIED(0),
        STATE_INITIALIZED(1),
        STATE_PROCESSING(2),
        STATE_COMPLETED(3),
        STATE_INTERRUPTED(4),
        UNRECOGNIZED(-1);

        public static final int STATE_COMPLETED_VALUE = 3;
        public static final int STATE_INITIALIZED_VALUE = 1;
        public static final int STATE_INTERRUPTED_VALUE = 4;
        public static final int STATE_PROCESSING_VALUE = 2;
        public static final int STATE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<State> internalValueMap = new Internal.EnumLiteMap<State>() { // from class: com.zyql.protobuf.runtime.AgentTaskStateNotification.State.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public State findValueByNumber(int i10) {
                return State.forNumber(i10);
            }
        };
        private final int value;

        public static final class StateVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new StateVerifier();

            private StateVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i10) {
                return State.forNumber(i10) != null;
            }
        }

        State(int i10) {
            this.value = i10;
        }

        public static State forNumber(int i10) {
            if (i10 == 0) {
                return STATE_UNSPECIFIED;
            }
            if (i10 == 1) {
                return STATE_INITIALIZED;
            }
            if (i10 == 2) {
                return STATE_PROCESSING;
            }
            if (i10 == 3) {
                return STATE_COMPLETED;
            }
            if (i10 != 4) {
                return null;
            }
            return STATE_INTERRUPTED;
        }

        public static Internal.EnumLiteMap<State> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return StateVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static State valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        AgentTaskStateNotification agentTaskStateNotification = new AgentTaskStateNotification();
        DEFAULT_INSTANCE = agentTaskStateNotification;
        GeneratedMessageLite.registerDefaultInstance(AgentTaskStateNotification.class, agentTaskStateNotification);
    }

    private AgentTaskStateNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDetails() {
        this.bitField0_ &= -2;
        this.details_ = getDefaultInstance().getDetails();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.state_ = 0;
    }

    public static AgentTaskStateNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AgentTaskStateNotification parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentTaskStateNotification parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AgentTaskStateNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetails(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.details_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetailsBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.details_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(State state) {
        this.state_ = state.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateValue(int i10) {
        this.state_ = i10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new AgentTaskStateNotification();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ለ\u0000", new Object[]{"bitField0_", "state_", "details_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AgentTaskStateNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AgentTaskStateNotification.class) {
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

    @Override // com.zyql.protobuf.runtime.AgentTaskStateNotificationOrBuilder
    public String getDetails() {
        return this.details_;
    }

    @Override // com.zyql.protobuf.runtime.AgentTaskStateNotificationOrBuilder
    public ByteString getDetailsBytes() {
        return ByteString.copyFromUtf8(this.details_);
    }

    @Override // com.zyql.protobuf.runtime.AgentTaskStateNotificationOrBuilder
    public State getState() {
        State stateForNumber = State.forNumber(this.state_);
        return stateForNumber == null ? State.UNRECOGNIZED : stateForNumber;
    }

    @Override // com.zyql.protobuf.runtime.AgentTaskStateNotificationOrBuilder
    public int getStateValue() {
        return this.state_;
    }

    @Override // com.zyql.protobuf.runtime.AgentTaskStateNotificationOrBuilder
    public boolean hasDetails() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(AgentTaskStateNotification agentTaskStateNotification) {
        return DEFAULT_INSTANCE.createBuilder(agentTaskStateNotification);
    }

    public static AgentTaskStateNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentTaskStateNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AgentTaskStateNotification parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AgentTaskStateNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AgentTaskStateNotification parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AgentTaskStateNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AgentTaskStateNotification parseFrom(InputStream inputStream) throws IOException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentTaskStateNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentTaskStateNotification parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AgentTaskStateNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentTaskStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
