package com.zyql.protobuf.skull;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class Resource extends GeneratedMessageLite<Resource, Builder> implements ResourceOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 3;
    private static final Resource DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 5;
    public static final int EXTRA_FIELD_NUMBER = 7;
    public static final int MIME_TYPE_FIELD_NUMBER = 6;
    private static volatile Parser<Resource> PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int URI_FIELD_NUMBER = 4;
    private MapFieldLite<String, String> extra_ = MapFieldLite.emptyMapField();
    private String type_ = "";
    private String title_ = "";
    private String content_ = "";
    private String uri_ = "";
    private String description_ = "";
    private String mimeType_ = "";

    /* renamed from: com.zyql.protobuf.skull.Resource$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Resource, Builder> implements ResourceOrBuilder {
        public Builder clearContent() {
            copyOnWrite();
            ((Resource) this.instance).clearContent();
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((Resource) this.instance).clearDescription();
            return this;
        }

        public Builder clearExtra() {
            copyOnWrite();
            ((Resource) this.instance).getMutableExtraMap().clear();
            return this;
        }

        public Builder clearMimeType() {
            copyOnWrite();
            ((Resource) this.instance).clearMimeType();
            return this;
        }

        public Builder clearTitle() {
            copyOnWrite();
            ((Resource) this.instance).clearTitle();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((Resource) this.instance).clearType();
            return this;
        }

        public Builder clearUri() {
            copyOnWrite();
            ((Resource) this.instance).clearUri();
            return this;
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public boolean containsExtra(String str) {
            str.getClass();
            return ((Resource) this.instance).getExtraMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public String getContent() {
            return ((Resource) this.instance).getContent();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public ByteString getContentBytes() {
            return ((Resource) this.instance).getContentBytes();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public String getDescription() {
            return ((Resource) this.instance).getDescription();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public ByteString getDescriptionBytes() {
            return ((Resource) this.instance).getDescriptionBytes();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        @Deprecated
        public Map<String, String> getExtra() {
            return getExtraMap();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public int getExtraCount() {
            return ((Resource) this.instance).getExtraMap().size();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public Map<String, String> getExtraMap() {
            return Collections.unmodifiableMap(((Resource) this.instance).getExtraMap());
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public String getExtraOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> extraMap = ((Resource) this.instance).getExtraMap();
            return extraMap.containsKey(str) ? extraMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public String getExtraOrThrow(String str) {
            str.getClass();
            Map<String, String> extraMap = ((Resource) this.instance).getExtraMap();
            if (extraMap.containsKey(str)) {
                return extraMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public String getMimeType() {
            return ((Resource) this.instance).getMimeType();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public ByteString getMimeTypeBytes() {
            return ((Resource) this.instance).getMimeTypeBytes();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public String getTitle() {
            return ((Resource) this.instance).getTitle();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public ByteString getTitleBytes() {
            return ((Resource) this.instance).getTitleBytes();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public String getType() {
            return ((Resource) this.instance).getType();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public ByteString getTypeBytes() {
            return ((Resource) this.instance).getTypeBytes();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public String getUri() {
            return ((Resource) this.instance).getUri();
        }

        @Override // com.zyql.protobuf.skull.ResourceOrBuilder
        public ByteString getUriBytes() {
            return ((Resource) this.instance).getUriBytes();
        }

        public Builder putAllExtra(Map<String, String> map) {
            copyOnWrite();
            ((Resource) this.instance).getMutableExtraMap().putAll(map);
            return this;
        }

        public Builder putExtra(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((Resource) this.instance).getMutableExtraMap().put(str, str2);
            return this;
        }

        public Builder removeExtra(String str) {
            str.getClass();
            copyOnWrite();
            ((Resource) this.instance).getMutableExtraMap().remove(str);
            return this;
        }

        public Builder setContent(String str) {
            copyOnWrite();
            ((Resource) this.instance).setContent(str);
            return this;
        }

        public Builder setContentBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Resource) this.instance).setContentBytes(byteString);
            return this;
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((Resource) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Resource) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setMimeType(String str) {
            copyOnWrite();
            ((Resource) this.instance).setMimeType(str);
            return this;
        }

        public Builder setMimeTypeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Resource) this.instance).setMimeTypeBytes(byteString);
            return this;
        }

        public Builder setTitle(String str) {
            copyOnWrite();
            ((Resource) this.instance).setTitle(str);
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Resource) this.instance).setTitleBytes(byteString);
            return this;
        }

        public Builder setType(String str) {
            copyOnWrite();
            ((Resource) this.instance).setType(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Resource) this.instance).setTypeBytes(byteString);
            return this;
        }

        public Builder setUri(String str) {
            copyOnWrite();
            ((Resource) this.instance).setUri(str);
            return this;
        }

        public Builder setUriBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Resource) this.instance).setUriBytes(byteString);
            return this;
        }

        private Builder() {
            super(Resource.DEFAULT_INSTANCE);
        }
    }

    public static final class ExtraDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private ExtraDefaultEntryHolder() {
        }
    }

    static {
        Resource resource = new Resource();
        DEFAULT_INSTANCE = resource;
        GeneratedMessageLite.registerDefaultInstance(Resource.class, resource);
    }

    private Resource() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContent() {
        this.content_ = getDefaultInstance().getContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUri() {
        this.uri_ = getDefaultInstance().getUri();
    }

    public static Resource getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableExtraMap() {
        return internalGetMutableExtra();
    }

    private MapFieldLite<String, String> internalGetExtra() {
        return this.extra_;
    }

    private MapFieldLite<String, String> internalGetMutableExtra() {
        if (!this.extra_.isMutable()) {
            this.extra_ = this.extra_.mutableCopy();
        }
        return this.extra_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Resource parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Resource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Resource parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Resource> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeType(String str) {
        str.getClass();
        this.mimeType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeTypeBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.mimeType_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.title_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.type_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUri(String str) {
        str.getClass();
        this.uri_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUriBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.uri_ = byteString.toStringUtf8();
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public boolean containsExtra(String str) {
        str.getClass();
        return internalGetExtra().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Resource();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u00072", new Object[]{"type_", "title_", "content_", "uri_", "description_", "mimeType_", "extra_", ExtraDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Resource> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Resource.class) {
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

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public String getContent() {
        return this.content_;
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    @Deprecated
    public Map<String, String> getExtra() {
        return getExtraMap();
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public int getExtraCount() {
        return internalGetExtra().size();
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public Map<String, String> getExtraMap() {
        return Collections.unmodifiableMap(internalGetExtra());
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public String getExtraOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetExtra = internalGetExtra();
        return mapFieldLiteInternalGetExtra.containsKey(str) ? mapFieldLiteInternalGetExtra.get(str) : str2;
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public String getExtraOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetExtra = internalGetExtra();
        if (mapFieldLiteInternalGetExtra.containsKey(str)) {
            return mapFieldLiteInternalGetExtra.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public String getMimeType() {
        return this.mimeType_;
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public ByteString getMimeTypeBytes() {
        return ByteString.copyFromUtf8(this.mimeType_);
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public String getTitle() {
        return this.title_;
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public String getType() {
        return this.type_;
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public String getUri() {
        return this.uri_;
    }

    @Override // com.zyql.protobuf.skull.ResourceOrBuilder
    public ByteString getUriBytes() {
        return ByteString.copyFromUtf8(this.uri_);
    }

    public static Builder newBuilder(Resource resource) {
        return DEFAULT_INSTANCE.createBuilder(resource);
    }

    public static Resource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Resource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Resource parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Resource parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Resource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Resource parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Resource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Resource parseFrom(InputStream inputStream) throws IOException {
        return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Resource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Resource parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Resource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
