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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class GetAgentInfoResponse extends GeneratedMessageLite<GetAgentInfoResponse, Builder> implements GetAgentInfoResponseOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    public static final int AGENT_NAME_FIELD_NUMBER = 2;
    public static final int CAPABILITIES_FIELD_NUMBER = 5;
    private static final GetAgentInfoResponse DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int METADATA_FIELD_NUMBER = 6;
    private static volatile Parser<GetAgentInfoResponse> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 4;
    private int bitField0_;
    private Struct metadata_;
    private String agentId_ = "";
    private String agentName_ = "";
    private String description_ = "";
    private String version_ = "";
    private Internal.ProtobufList<String> capabilities_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.runtime.GetAgentInfoResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GetAgentInfoResponse, Builder> implements GetAgentInfoResponseOrBuilder {
        public Builder addAllCapabilities(Iterable<String> iterable) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).addAllCapabilities(iterable);
            return this;
        }

        public Builder addCapabilities(String str) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).addCapabilities(str);
            return this;
        }

        public Builder addCapabilitiesBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).addCapabilitiesBytes(byteString);
            return this;
        }

        public Builder clearAgentId() {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).clearAgentId();
            return this;
        }

        public Builder clearAgentName() {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).clearAgentName();
            return this;
        }

        public Builder clearCapabilities() {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).clearCapabilities();
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).clearDescription();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).clearMetadata();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).clearVersion();
            return this;
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public String getAgentId() {
            return ((GetAgentInfoResponse) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public ByteString getAgentIdBytes() {
            return ((GetAgentInfoResponse) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public String getAgentName() {
            return ((GetAgentInfoResponse) this.instance).getAgentName();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public ByteString getAgentNameBytes() {
            return ((GetAgentInfoResponse) this.instance).getAgentNameBytes();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public String getCapabilities(int i10) {
            return ((GetAgentInfoResponse) this.instance).getCapabilities(i10);
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public ByteString getCapabilitiesBytes(int i10) {
            return ((GetAgentInfoResponse) this.instance).getCapabilitiesBytes(i10);
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public int getCapabilitiesCount() {
            return ((GetAgentInfoResponse) this.instance).getCapabilitiesCount();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public List<String> getCapabilitiesList() {
            return Collections.unmodifiableList(((GetAgentInfoResponse) this.instance).getCapabilitiesList());
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public String getDescription() {
            return ((GetAgentInfoResponse) this.instance).getDescription();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public ByteString getDescriptionBytes() {
            return ((GetAgentInfoResponse) this.instance).getDescriptionBytes();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public Struct getMetadata() {
            return ((GetAgentInfoResponse) this.instance).getMetadata();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public String getVersion() {
            return ((GetAgentInfoResponse) this.instance).getVersion();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public ByteString getVersionBytes() {
            return ((GetAgentInfoResponse) this.instance).getVersionBytes();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public boolean hasDescription() {
            return ((GetAgentInfoResponse) this.instance).hasDescription();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public boolean hasMetadata() {
            return ((GetAgentInfoResponse) this.instance).hasMetadata();
        }

        @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
        public boolean hasVersion() {
            return ((GetAgentInfoResponse) this.instance).hasVersion();
        }

        public Builder mergeMetadata(Struct struct) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).mergeMetadata(struct);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setAgentName(String str) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setAgentName(str);
            return this;
        }

        public Builder setAgentNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setAgentNameBytes(byteString);
            return this;
        }

        public Builder setCapabilities(int i10, String str) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setCapabilities(i10, str);
            return this;
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setMetadata(Struct struct) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setMetadata(struct);
            return this;
        }

        public Builder setVersion(String str) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setVersion(str);
            return this;
        }

        public Builder setVersionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setVersionBytes(byteString);
            return this;
        }

        private Builder() {
            super(GetAgentInfoResponse.DEFAULT_INSTANCE);
        }

        public Builder setMetadata(Struct.Builder builder) {
            copyOnWrite();
            ((GetAgentInfoResponse) this.instance).setMetadata(builder.build());
            return this;
        }
    }

    static {
        GetAgentInfoResponse getAgentInfoResponse = new GetAgentInfoResponse();
        DEFAULT_INSTANCE = getAgentInfoResponse;
        GeneratedMessageLite.registerDefaultInstance(GetAgentInfoResponse.class, getAgentInfoResponse);
    }

    private GetAgentInfoResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCapabilities(Iterable<String> iterable) {
        ensureCapabilitiesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.capabilities_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCapabilities(String str) {
        str.getClass();
        ensureCapabilitiesIsMutable();
        this.capabilities_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCapabilitiesBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        ensureCapabilitiesIsMutable();
        this.capabilities_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentName() {
        this.agentName_ = getDefaultInstance().getAgentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCapabilities() {
        this.capabilities_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.bitField0_ &= -2;
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.bitField0_ &= -3;
        this.version_ = getDefaultInstance().getVersion();
    }

    private void ensureCapabilitiesIsMutable() {
        Internal.ProtobufList<String> protobufList = this.capabilities_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.capabilities_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static GetAgentInfoResponse getDefaultInstance() {
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
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GetAgentInfoResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetAgentInfoResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GetAgentInfoResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setAgentName(String str) {
        str.getClass();
        this.agentName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.agentName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCapabilities(int i10, String str) {
        str.getClass();
        ensureCapabilitiesIsMutable();
        this.capabilities_.set(i10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.description_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(Struct struct) {
        struct.getClass();
        this.metadata_ = struct;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.version_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.version_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new GetAgentInfoResponse();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003ለ\u0000\u0004ለ\u0001\u0005Ț\u0006ဉ\u0002", new Object[]{"bitField0_", "agentId_", "agentName_", "description_", "version_", "capabilities_", "metadata_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GetAgentInfoResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GetAgentInfoResponse.class) {
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

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public String getAgentName() {
        return this.agentName_;
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public ByteString getAgentNameBytes() {
        return ByteString.copyFromUtf8(this.agentName_);
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public String getCapabilities(int i10) {
        return this.capabilities_.get(i10);
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public ByteString getCapabilitiesBytes(int i10) {
        return ByteString.copyFromUtf8(this.capabilities_.get(i10));
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public int getCapabilitiesCount() {
        return this.capabilities_.size();
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public List<String> getCapabilitiesList() {
        return this.capabilities_;
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public Struct getMetadata() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public String getVersion() {
        return this.version_;
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.version_);
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public boolean hasDescription() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public boolean hasMetadata() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.zyql.protobuf.runtime.GetAgentInfoResponseOrBuilder
    public boolean hasVersion() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(GetAgentInfoResponse getAgentInfoResponse) {
        return DEFAULT_INSTANCE.createBuilder(getAgentInfoResponse);
    }

    public static GetAgentInfoResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetAgentInfoResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GetAgentInfoResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GetAgentInfoResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GetAgentInfoResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GetAgentInfoResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GetAgentInfoResponse parseFrom(InputStream inputStream) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetAgentInfoResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetAgentInfoResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GetAgentInfoResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetAgentInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
