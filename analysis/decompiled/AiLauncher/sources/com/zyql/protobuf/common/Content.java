package com.zyql.protobuf.common;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.common.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class Content extends GeneratedMessageLite<Content, Builder> implements ContentOrBuilder {
    private static final Content DEFAULT_INSTANCE;
    private static volatile Parser<Content> PARSER = null;
    public static final int PARTS_FIELD_NUMBER = 2;
    public static final int ROLE_FIELD_NUMBER = 1;
    private String role_ = "";
    private Internal.ProtobufList<Part> parts_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.common.Content$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Content, Builder> implements ContentOrBuilder {
        public Builder addAllParts(Iterable<? extends Part> iterable) {
            copyOnWrite();
            ((Content) this.instance).addAllParts(iterable);
            return this;
        }

        public Builder addParts(Part part) {
            copyOnWrite();
            ((Content) this.instance).addParts(part);
            return this;
        }

        public Builder clearParts() {
            copyOnWrite();
            ((Content) this.instance).clearParts();
            return this;
        }

        public Builder clearRole() {
            copyOnWrite();
            ((Content) this.instance).clearRole();
            return this;
        }

        @Override // com.zyql.protobuf.common.ContentOrBuilder
        public Part getParts(int i10) {
            return ((Content) this.instance).getParts(i10);
        }

        @Override // com.zyql.protobuf.common.ContentOrBuilder
        public int getPartsCount() {
            return ((Content) this.instance).getPartsCount();
        }

        @Override // com.zyql.protobuf.common.ContentOrBuilder
        public List<Part> getPartsList() {
            return Collections.unmodifiableList(((Content) this.instance).getPartsList());
        }

        @Override // com.zyql.protobuf.common.ContentOrBuilder
        public String getRole() {
            return ((Content) this.instance).getRole();
        }

        @Override // com.zyql.protobuf.common.ContentOrBuilder
        public ByteString getRoleBytes() {
            return ((Content) this.instance).getRoleBytes();
        }

        public Builder removeParts(int i10) {
            copyOnWrite();
            ((Content) this.instance).removeParts(i10);
            return this;
        }

        public Builder setParts(int i10, Part part) {
            copyOnWrite();
            ((Content) this.instance).setParts(i10, part);
            return this;
        }

        public Builder setRole(String str) {
            copyOnWrite();
            ((Content) this.instance).setRole(str);
            return this;
        }

        public Builder setRoleBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Content) this.instance).setRoleBytes(byteString);
            return this;
        }

        private Builder() {
            super(Content.DEFAULT_INSTANCE);
        }

        public Builder addParts(int i10, Part part) {
            copyOnWrite();
            ((Content) this.instance).addParts(i10, part);
            return this;
        }

        public Builder setParts(int i10, Part.Builder builder) {
            copyOnWrite();
            ((Content) this.instance).setParts(i10, builder.build());
            return this;
        }

        public Builder addParts(Part.Builder builder) {
            copyOnWrite();
            ((Content) this.instance).addParts(builder.build());
            return this;
        }

        public Builder addParts(int i10, Part.Builder builder) {
            copyOnWrite();
            ((Content) this.instance).addParts(i10, builder.build());
            return this;
        }
    }

    static {
        Content content = new Content();
        DEFAULT_INSTANCE = content;
        GeneratedMessageLite.registerDefaultInstance(Content.class, content);
    }

    private Content() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllParts(Iterable<? extends Part> iterable) {
        ensurePartsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.parts_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParts(Part part) {
        part.getClass();
        ensurePartsIsMutable();
        this.parts_.add(part);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParts() {
        this.parts_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRole() {
        this.role_ = getDefaultInstance().getRole();
    }

    private void ensurePartsIsMutable() {
        Internal.ProtobufList<Part> protobufList = this.parts_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.parts_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Content getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Content parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Content) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Content parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Content) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Content> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeParts(int i10) {
        ensurePartsIsMutable();
        this.parts_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParts(int i10, Part part) {
        part.getClass();
        ensurePartsIsMutable();
        this.parts_.set(i10, part);
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
                return new Content();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"role_", "parts_", Part.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Content> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Content.class) {
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

    @Override // com.zyql.protobuf.common.ContentOrBuilder
    public Part getParts(int i10) {
        return this.parts_.get(i10);
    }

    @Override // com.zyql.protobuf.common.ContentOrBuilder
    public int getPartsCount() {
        return this.parts_.size();
    }

    @Override // com.zyql.protobuf.common.ContentOrBuilder
    public List<Part> getPartsList() {
        return this.parts_;
    }

    public PartOrBuilder getPartsOrBuilder(int i10) {
        return this.parts_.get(i10);
    }

    public List<? extends PartOrBuilder> getPartsOrBuilderList() {
        return this.parts_;
    }

    @Override // com.zyql.protobuf.common.ContentOrBuilder
    public String getRole() {
        return this.role_;
    }

    @Override // com.zyql.protobuf.common.ContentOrBuilder
    public ByteString getRoleBytes() {
        return ByteString.copyFromUtf8(this.role_);
    }

    public static Builder newBuilder(Content content) {
        return DEFAULT_INSTANCE.createBuilder(content);
    }

    public static Content parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Content) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Content parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Content) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Content parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Content) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParts(int i10, Part part) {
        part.getClass();
        ensurePartsIsMutable();
        this.parts_.add(i10, part);
    }

    public static Content parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Content) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Content) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Content parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Content) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Content parseFrom(InputStream inputStream) throws IOException {
        return (Content) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Content parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Content) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Content parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Content) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Content parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Content) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
