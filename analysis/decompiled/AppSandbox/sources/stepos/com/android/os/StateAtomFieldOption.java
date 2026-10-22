package stepos.com.android.os;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StateAtomFieldOption extends GeneratedMessageLite<StateAtomFieldOption, Builder> implements StateAtomFieldOptionOrBuilder {
    private static final StateAtomFieldOption DEFAULT_INSTANCE;
    public static final int DEFAULT_STATE_VALUE_FIELD_NUMBER = 4;
    public static final int EXCLUSIVE_STATE_FIELD_NUMBER = 2;
    public static final int NESTED_FIELD_NUMBER = 6;
    private static volatile Parser<StateAtomFieldOption> PARSER = null;
    public static final int PRIMARY_FIELD_FIELD_NUMBER = 1;
    public static final int PRIMARY_FIELD_FIRST_UID_FIELD_NUMBER = 3;
    public static final int TRIGGER_STATE_RESET_VALUE_FIELD_NUMBER = 5;
    private int bitField0_;
    private int defaultStateValue_;
    private boolean exclusiveState_;
    private boolean nested_;
    private boolean primaryFieldFirstUid_;
    private boolean primaryField_;
    private int triggerStateResetValue_;

    private StateAtomFieldOption() {
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public boolean hasPrimaryField() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public boolean getPrimaryField() {
        return this.primaryField_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrimaryField(boolean z) {
        this.bitField0_ |= 1;
        this.primaryField_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPrimaryField() {
        this.bitField0_ &= -2;
        this.primaryField_ = false;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public boolean hasExclusiveState() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public boolean getExclusiveState() {
        return this.exclusiveState_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExclusiveState(boolean z) {
        this.bitField0_ |= 2;
        this.exclusiveState_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExclusiveState() {
        this.bitField0_ &= -3;
        this.exclusiveState_ = false;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public boolean hasPrimaryFieldFirstUid() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public boolean getPrimaryFieldFirstUid() {
        return this.primaryFieldFirstUid_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrimaryFieldFirstUid(boolean z) {
        this.bitField0_ |= 4;
        this.primaryFieldFirstUid_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPrimaryFieldFirstUid() {
        this.bitField0_ &= -5;
        this.primaryFieldFirstUid_ = false;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public boolean hasDefaultStateValue() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public int getDefaultStateValue() {
        return this.defaultStateValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultStateValue(int i) {
        this.bitField0_ |= 8;
        this.defaultStateValue_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDefaultStateValue() {
        this.bitField0_ &= -9;
        this.defaultStateValue_ = 0;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public boolean hasTriggerStateResetValue() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public int getTriggerStateResetValue() {
        return this.triggerStateResetValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTriggerStateResetValue(int i) {
        this.bitField0_ |= 16;
        this.triggerStateResetValue_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTriggerStateResetValue() {
        this.bitField0_ &= -17;
        this.triggerStateResetValue_ = 0;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public boolean hasNested() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
    public boolean getNested() {
        return this.nested_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNested(boolean z) {
        this.bitField0_ |= 32;
        this.nested_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNested() {
        this.bitField0_ &= -33;
        this.nested_ = false;
    }

    public static StateAtomFieldOption parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StateAtomFieldOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static StateAtomFieldOption parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StateAtomFieldOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StateAtomFieldOption parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StateAtomFieldOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StateAtomFieldOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StateAtomFieldOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StateAtomFieldOption parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StateAtomFieldOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StateAtomFieldOption parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StateAtomFieldOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StateAtomFieldOption parseFrom(InputStream inputStream) throws IOException {
        return (StateAtomFieldOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StateAtomFieldOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StateAtomFieldOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StateAtomFieldOption parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StateAtomFieldOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StateAtomFieldOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StateAtomFieldOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StateAtomFieldOption parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StateAtomFieldOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StateAtomFieldOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StateAtomFieldOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(StateAtomFieldOption stateAtomFieldOption) {
        return DEFAULT_INSTANCE.createBuilder(stateAtomFieldOption);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<StateAtomFieldOption, Builder> implements StateAtomFieldOptionOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(StateAtomFieldOption.DEFAULT_INSTANCE);
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public boolean hasPrimaryField() {
            return ((StateAtomFieldOption) this.instance).hasPrimaryField();
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public boolean getPrimaryField() {
            return ((StateAtomFieldOption) this.instance).getPrimaryField();
        }

        public Builder setPrimaryField(boolean z) {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).setPrimaryField(z);
            return this;
        }

        public Builder clearPrimaryField() {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).clearPrimaryField();
            return this;
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public boolean hasExclusiveState() {
            return ((StateAtomFieldOption) this.instance).hasExclusiveState();
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public boolean getExclusiveState() {
            return ((StateAtomFieldOption) this.instance).getExclusiveState();
        }

        public Builder setExclusiveState(boolean z) {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).setExclusiveState(z);
            return this;
        }

        public Builder clearExclusiveState() {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).clearExclusiveState();
            return this;
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public boolean hasPrimaryFieldFirstUid() {
            return ((StateAtomFieldOption) this.instance).hasPrimaryFieldFirstUid();
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public boolean getPrimaryFieldFirstUid() {
            return ((StateAtomFieldOption) this.instance).getPrimaryFieldFirstUid();
        }

        public Builder setPrimaryFieldFirstUid(boolean z) {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).setPrimaryFieldFirstUid(z);
            return this;
        }

        public Builder clearPrimaryFieldFirstUid() {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).clearPrimaryFieldFirstUid();
            return this;
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public boolean hasDefaultStateValue() {
            return ((StateAtomFieldOption) this.instance).hasDefaultStateValue();
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public int getDefaultStateValue() {
            return ((StateAtomFieldOption) this.instance).getDefaultStateValue();
        }

        public Builder setDefaultStateValue(int i) {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).setDefaultStateValue(i);
            return this;
        }

        public Builder clearDefaultStateValue() {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).clearDefaultStateValue();
            return this;
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public boolean hasTriggerStateResetValue() {
            return ((StateAtomFieldOption) this.instance).hasTriggerStateResetValue();
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public int getTriggerStateResetValue() {
            return ((StateAtomFieldOption) this.instance).getTriggerStateResetValue();
        }

        public Builder setTriggerStateResetValue(int i) {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).setTriggerStateResetValue(i);
            return this;
        }

        public Builder clearTriggerStateResetValue() {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).clearTriggerStateResetValue();
            return this;
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public boolean hasNested() {
            return ((StateAtomFieldOption) this.instance).hasNested();
        }

        @Override // stepos.com.android.os.StateAtomFieldOptionOrBuilder
        public boolean getNested() {
            return ((StateAtomFieldOption) this.instance).getNested();
        }

        public Builder setNested(boolean z) {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).setNested(z);
            return this;
        }

        public Builder clearNested() {
            copyOnWrite();
            ((StateAtomFieldOption) this.instance).clearNested();
            return this;
        }
    }

    /* renamed from: stepos.com.android.os.StateAtomFieldOption$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new StateAtomFieldOption();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003\u0005င\u0004\u0006ဇ\u0005", new Object[]{"bitField0_", "primaryField_", "exclusiveState_", "primaryFieldFirstUid_", "defaultStateValue_", "triggerStateResetValue_", "nested_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StateAtomFieldOption> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StateAtomFieldOption.class) {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
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

    static {
        StateAtomFieldOption stateAtomFieldOption = new StateAtomFieldOption();
        DEFAULT_INSTANCE = stateAtomFieldOption;
        GeneratedMessageLite.registerDefaultInstance(StateAtomFieldOption.class, stateAtomFieldOption);
    }

    public static StateAtomFieldOption getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<StateAtomFieldOption> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
