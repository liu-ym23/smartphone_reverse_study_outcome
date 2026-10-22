package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.agent.FileContent;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class InlineSkill extends GeneratedMessageLite<InlineSkill, Builder> implements InlineSkillOrBuilder {
    private static final InlineSkill DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int FILES_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<InlineSkill> PARSER;
    private String name_ = "";
    private String description_ = "";
    private Internal.ProtobufList<FileContent> files_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.agent.InlineSkill$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<InlineSkill, Builder> implements InlineSkillOrBuilder {
        public Builder addAllFiles(Iterable<? extends FileContent> iterable) {
            copyOnWrite();
            ((InlineSkill) this.instance).addAllFiles(iterable);
            return this;
        }

        public Builder addFiles(FileContent fileContent) {
            copyOnWrite();
            ((InlineSkill) this.instance).addFiles(fileContent);
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((InlineSkill) this.instance).clearDescription();
            return this;
        }

        public Builder clearFiles() {
            copyOnWrite();
            ((InlineSkill) this.instance).clearFiles();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((InlineSkill) this.instance).clearName();
            return this;
        }

        @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
        public String getDescription() {
            return ((InlineSkill) this.instance).getDescription();
        }

        @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
        public ByteString getDescriptionBytes() {
            return ((InlineSkill) this.instance).getDescriptionBytes();
        }

        @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
        public FileContent getFiles(int i10) {
            return ((InlineSkill) this.instance).getFiles(i10);
        }

        @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
        public int getFilesCount() {
            return ((InlineSkill) this.instance).getFilesCount();
        }

        @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
        public List<FileContent> getFilesList() {
            return Collections.unmodifiableList(((InlineSkill) this.instance).getFilesList());
        }

        @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
        public String getName() {
            return ((InlineSkill) this.instance).getName();
        }

        @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
        public ByteString getNameBytes() {
            return ((InlineSkill) this.instance).getNameBytes();
        }

        public Builder removeFiles(int i10) {
            copyOnWrite();
            ((InlineSkill) this.instance).removeFiles(i10);
            return this;
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((InlineSkill) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((InlineSkill) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setFiles(int i10, FileContent fileContent) {
            copyOnWrite();
            ((InlineSkill) this.instance).setFiles(i10, fileContent);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((InlineSkill) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((InlineSkill) this.instance).setNameBytes(byteString);
            return this;
        }

        private Builder() {
            super(InlineSkill.DEFAULT_INSTANCE);
        }

        public Builder addFiles(int i10, FileContent fileContent) {
            copyOnWrite();
            ((InlineSkill) this.instance).addFiles(i10, fileContent);
            return this;
        }

        public Builder setFiles(int i10, FileContent.Builder builder) {
            copyOnWrite();
            ((InlineSkill) this.instance).setFiles(i10, builder.build());
            return this;
        }

        public Builder addFiles(FileContent.Builder builder) {
            copyOnWrite();
            ((InlineSkill) this.instance).addFiles(builder.build());
            return this;
        }

        public Builder addFiles(int i10, FileContent.Builder builder) {
            copyOnWrite();
            ((InlineSkill) this.instance).addFiles(i10, builder.build());
            return this;
        }
    }

    static {
        InlineSkill inlineSkill = new InlineSkill();
        DEFAULT_INSTANCE = inlineSkill;
        GeneratedMessageLite.registerDefaultInstance(InlineSkill.class, inlineSkill);
    }

    private InlineSkill() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFiles(Iterable<? extends FileContent> iterable) {
        ensureFilesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.files_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFiles(FileContent fileContent) {
        fileContent.getClass();
        ensureFilesIsMutable();
        this.files_.add(fileContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFiles() {
        this.files_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void ensureFilesIsMutable() {
        Internal.ProtobufList<FileContent> protobufList = this.files_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.files_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static InlineSkill getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static InlineSkill parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (InlineSkill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InlineSkill parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (InlineSkill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<InlineSkill> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFiles(int i10) {
        ensureFilesIsMutable();
        this.files_.remove(i10);
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
    public void setFiles(int i10, FileContent fileContent) {
        fileContent.getClass();
        ensureFilesIsMutable();
        this.files_.set(i10, fileContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new InlineSkill();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b", new Object[]{"name_", "description_", "files_", FileContent.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<InlineSkill> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (InlineSkill.class) {
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

    @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
    public FileContent getFiles(int i10) {
        return this.files_.get(i10);
    }

    @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
    public int getFilesCount() {
        return this.files_.size();
    }

    @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
    public List<FileContent> getFilesList() {
        return this.files_;
    }

    public FileContentOrBuilder getFilesOrBuilder(int i10) {
        return this.files_.get(i10);
    }

    public List<? extends FileContentOrBuilder> getFilesOrBuilderList() {
        return this.files_;
    }

    @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.zyql.protobuf.agent.InlineSkillOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public static Builder newBuilder(InlineSkill inlineSkill) {
        return DEFAULT_INSTANCE.createBuilder(inlineSkill);
    }

    public static InlineSkill parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InlineSkill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InlineSkill parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (InlineSkill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static InlineSkill parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (InlineSkill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFiles(int i10, FileContent fileContent) {
        fileContent.getClass();
        ensureFilesIsMutable();
        this.files_.add(i10, fileContent);
    }

    public static InlineSkill parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (InlineSkill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static InlineSkill parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (InlineSkill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static InlineSkill parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (InlineSkill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static InlineSkill parseFrom(InputStream inputStream) throws IOException {
        return (InlineSkill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InlineSkill parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InlineSkill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InlineSkill parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (InlineSkill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static InlineSkill parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InlineSkill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
