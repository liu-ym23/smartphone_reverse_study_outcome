package com.zyql.protobuf.skull;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.skull.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class Message extends GeneratedMessageLite<Message, Builder> implements MessageOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 2;
    private static final Message DEFAULT_INSTANCE;
    private static volatile Parser<Message> PARSER = null;
    public static final int RESOURCES_FIELD_NUMBER = 3;
    public static final int ROLE_FIELD_NUMBER = 1;
    private String role_ = "";
    private String content_ = "";
    private Internal.ProtobufList<Resource> resources_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.skull.Message$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Message, Builder> implements MessageOrBuilder {
        public Builder addAllResources(Iterable<? extends Resource> iterable) {
            copyOnWrite();
            ((Message) this.instance).addAllResources(iterable);
            return this;
        }

        public Builder addResources(Resource resource) {
            copyOnWrite();
            ((Message) this.instance).addResources(resource);
            return this;
        }

        public Builder clearContent() {
            copyOnWrite();
            ((Message) this.instance).clearContent();
            return this;
        }

        public Builder clearResources() {
            copyOnWrite();
            ((Message) this.instance).clearResources();
            return this;
        }

        public Builder clearRole() {
            copyOnWrite();
            ((Message) this.instance).clearRole();
            return this;
        }

        @Override // com.zyql.protobuf.skull.MessageOrBuilder
        public String getContent() {
            return ((Message) this.instance).getContent();
        }

        @Override // com.zyql.protobuf.skull.MessageOrBuilder
        public ByteString getContentBytes() {
            return ((Message) this.instance).getContentBytes();
        }

        @Override // com.zyql.protobuf.skull.MessageOrBuilder
        public Resource getResources(int i10) {
            return ((Message) this.instance).getResources(i10);
        }

        @Override // com.zyql.protobuf.skull.MessageOrBuilder
        public int getResourcesCount() {
            return ((Message) this.instance).getResourcesCount();
        }

        @Override // com.zyql.protobuf.skull.MessageOrBuilder
        public List<Resource> getResourcesList() {
            return Collections.unmodifiableList(((Message) this.instance).getResourcesList());
        }

        @Override // com.zyql.protobuf.skull.MessageOrBuilder
        public String getRole() {
            return ((Message) this.instance).getRole();
        }

        @Override // com.zyql.protobuf.skull.MessageOrBuilder
        public ByteString getRoleBytes() {
            return ((Message) this.instance).getRoleBytes();
        }

        public Builder removeResources(int i10) {
            copyOnWrite();
            ((Message) this.instance).removeResources(i10);
            return this;
        }

        public Builder setContent(String str) {
            copyOnWrite();
            ((Message) this.instance).setContent(str);
            return this;
        }

        public Builder setContentBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Message) this.instance).setContentBytes(byteString);
            return this;
        }

        public Builder setResources(int i10, Resource resource) {
            copyOnWrite();
            ((Message) this.instance).setResources(i10, resource);
            return this;
        }

        public Builder setRole(String str) {
            copyOnWrite();
            ((Message) this.instance).setRole(str);
            return this;
        }

        public Builder setRoleBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Message) this.instance).setRoleBytes(byteString);
            return this;
        }

        private Builder() {
            super(Message.DEFAULT_INSTANCE);
        }

        public Builder addResources(int i10, Resource resource) {
            copyOnWrite();
            ((Message) this.instance).addResources(i10, resource);
            return this;
        }

        public Builder setResources(int i10, Resource.Builder builder) {
            copyOnWrite();
            ((Message) this.instance).setResources(i10, builder.build());
            return this;
        }

        public Builder addResources(Resource.Builder builder) {
            copyOnWrite();
            ((Message) this.instance).addResources(builder.build());
            return this;
        }

        public Builder addResources(int i10, Resource.Builder builder) {
            copyOnWrite();
            ((Message) this.instance).addResources(i10, builder.build());
            return this;
        }
    }

    static {
        Message message = new Message();
        DEFAULT_INSTANCE = message;
        GeneratedMessageLite.registerDefaultInstance(Message.class, message);
    }

    private Message() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllResources(Iterable<? extends Resource> iterable) {
        ensureResourcesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.resources_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addResources(Resource resource) {
        resource.getClass();
        ensureResourcesIsMutable();
        this.resources_.add(resource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContent() {
        this.content_ = getDefaultInstance().getContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResources() {
        this.resources_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRole() {
        this.role_ = getDefaultInstance().getRole();
    }

    private void ensureResourcesIsMutable() {
        Internal.ProtobufList<Resource> protobufList = this.resources_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.resources_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Message getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Message parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Message) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Message parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Message> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeResources(int i10) {
        ensureResourcesIsMutable();
        this.resources_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContent(String str) {
        str.getClass();
        this.content_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.content_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResources(int i10, Resource resource) {
        resource.getClass();
        ensureResourcesIsMutable();
        this.resources_.set(i10, resource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRole(String str) {
        str.getClass();
        this.role_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoleBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.role_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Message();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b", new Object[]{"role_", "content_", "resources_", Resource.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Message> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Message.class) {
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

    @Override // com.zyql.protobuf.skull.MessageOrBuilder
    public String getContent() {
        return this.content_;
    }

    @Override // com.zyql.protobuf.skull.MessageOrBuilder
    public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
    }

    @Override // com.zyql.protobuf.skull.MessageOrBuilder
    public Resource getResources(int i10) {
        return this.resources_.get(i10);
    }

    @Override // com.zyql.protobuf.skull.MessageOrBuilder
    public int getResourcesCount() {
        return this.resources_.size();
    }

    @Override // com.zyql.protobuf.skull.MessageOrBuilder
    public List<Resource> getResourcesList() {
        return this.resources_;
    }

    public ResourceOrBuilder getResourcesOrBuilder(int i10) {
        return this.resources_.get(i10);
    }

    public List<? extends ResourceOrBuilder> getResourcesOrBuilderList() {
        return this.resources_;
    }

    @Override // com.zyql.protobuf.skull.MessageOrBuilder
    public String getRole() {
        return this.role_;
    }

    @Override // com.zyql.protobuf.skull.MessageOrBuilder
    public ByteString getRoleBytes() {
        return ByteString.copyFromUtf8(this.role_);
    }

    public static Builder newBuilder(Message message) {
        return DEFAULT_INSTANCE.createBuilder(message);
    }

    public static Message parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Message) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Message parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Message parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addResources(int i10, Resource resource) {
        resource.getClass();
        ensureResourcesIsMutable();
        this.resources_.add(i10, resource);
    }

    public static Message parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Message parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Message parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Message parseFrom(InputStream inputStream) throws IOException {
        return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Message parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Message parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Message parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
