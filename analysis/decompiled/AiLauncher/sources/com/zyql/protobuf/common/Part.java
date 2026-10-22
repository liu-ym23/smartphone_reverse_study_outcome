package com.zyql.protobuf.common;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.common.Blob;
import com.zyql.protobuf.common.FileData;
import com.zyql.protobuf.common.FunctionCall;
import com.zyql.protobuf.common.FunctionResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class Part extends GeneratedMessageLite<Part, Builder> implements PartOrBuilder {
    private static final Part DEFAULT_INSTANCE;
    public static final int FILE_DATA_FIELD_NUMBER = 5;
    public static final int FUNCTION_CALL_FIELD_NUMBER = 3;
    public static final int FUNCTION_RESPONSE_FIELD_NUMBER = 4;
    public static final int INLINE_DATA_FIELD_NUMBER = 2;
    private static volatile Parser<Part> PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    public static final int THOUGHT_FIELD_NUMBER = 10;
    private int contentCase_ = 0;
    private Object content_;
    private boolean thought_;

    /* renamed from: com.zyql.protobuf.common.Part$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Part, Builder> implements PartOrBuilder {
        public Builder clearContent() {
            copyOnWrite();
            ((Part) this.instance).clearContent();
            return this;
        }

        public Builder clearFileData() {
            copyOnWrite();
            ((Part) this.instance).clearFileData();
            return this;
        }

        public Builder clearFunctionCall() {
            copyOnWrite();
            ((Part) this.instance).clearFunctionCall();
            return this;
        }

        public Builder clearFunctionResponse() {
            copyOnWrite();
            ((Part) this.instance).clearFunctionResponse();
            return this;
        }

        public Builder clearInlineData() {
            copyOnWrite();
            ((Part) this.instance).clearInlineData();
            return this;
        }

        public Builder clearText() {
            copyOnWrite();
            ((Part) this.instance).clearText();
            return this;
        }

        public Builder clearThought() {
            copyOnWrite();
            ((Part) this.instance).clearThought();
            return this;
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public ContentCase getContentCase() {
            return ((Part) this.instance).getContentCase();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public FileData getFileData() {
            return ((Part) this.instance).getFileData();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public FunctionCall getFunctionCall() {
            return ((Part) this.instance).getFunctionCall();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public FunctionResponse getFunctionResponse() {
            return ((Part) this.instance).getFunctionResponse();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public Blob getInlineData() {
            return ((Part) this.instance).getInlineData();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public String getText() {
            return ((Part) this.instance).getText();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public ByteString getTextBytes() {
            return ((Part) this.instance).getTextBytes();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public boolean getThought() {
            return ((Part) this.instance).getThought();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public boolean hasFileData() {
            return ((Part) this.instance).hasFileData();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public boolean hasFunctionCall() {
            return ((Part) this.instance).hasFunctionCall();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public boolean hasFunctionResponse() {
            return ((Part) this.instance).hasFunctionResponse();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public boolean hasInlineData() {
            return ((Part) this.instance).hasInlineData();
        }

        @Override // com.zyql.protobuf.common.PartOrBuilder
        public boolean hasText() {
            return ((Part) this.instance).hasText();
        }

        public Builder mergeFileData(FileData fileData) {
            copyOnWrite();
            ((Part) this.instance).mergeFileData(fileData);
            return this;
        }

        public Builder mergeFunctionCall(FunctionCall functionCall) {
            copyOnWrite();
            ((Part) this.instance).mergeFunctionCall(functionCall);
            return this;
        }

        public Builder mergeFunctionResponse(FunctionResponse functionResponse) {
            copyOnWrite();
            ((Part) this.instance).mergeFunctionResponse(functionResponse);
            return this;
        }

        public Builder mergeInlineData(Blob blob) {
            copyOnWrite();
            ((Part) this.instance).mergeInlineData(blob);
            return this;
        }

        public Builder setFileData(FileData fileData) {
            copyOnWrite();
            ((Part) this.instance).setFileData(fileData);
            return this;
        }

        public Builder setFunctionCall(FunctionCall functionCall) {
            copyOnWrite();
            ((Part) this.instance).setFunctionCall(functionCall);
            return this;
        }

        public Builder setFunctionResponse(FunctionResponse functionResponse) {
            copyOnWrite();
            ((Part) this.instance).setFunctionResponse(functionResponse);
            return this;
        }

        public Builder setInlineData(Blob blob) {
            copyOnWrite();
            ((Part) this.instance).setInlineData(blob);
            return this;
        }

        public Builder setText(String str) {
            copyOnWrite();
            ((Part) this.instance).setText(str);
            return this;
        }

        public Builder setTextBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Part) this.instance).setTextBytes(byteString);
            return this;
        }

        public Builder setThought(boolean z10) {
            copyOnWrite();
            ((Part) this.instance).setThought(z10);
            return this;
        }

        private Builder() {
            super(Part.DEFAULT_INSTANCE);
        }

        public Builder setFileData(FileData.Builder builder) {
            copyOnWrite();
            ((Part) this.instance).setFileData(builder.build());
            return this;
        }

        public Builder setFunctionCall(FunctionCall.Builder builder) {
            copyOnWrite();
            ((Part) this.instance).setFunctionCall(builder.build());
            return this;
        }

        public Builder setFunctionResponse(FunctionResponse.Builder builder) {
            copyOnWrite();
            ((Part) this.instance).setFunctionResponse(builder.build());
            return this;
        }

        public Builder setInlineData(Blob.Builder builder) {
            copyOnWrite();
            ((Part) this.instance).setInlineData(builder.build());
            return this;
        }
    }

    public enum ContentCase {
        TEXT(1),
        INLINE_DATA(2),
        FUNCTION_CALL(3),
        FUNCTION_RESPONSE(4),
        FILE_DATA(5),
        CONTENT_NOT_SET(0);

        private final int value;

        ContentCase(int i10) {
            this.value = i10;
        }

        public static ContentCase forNumber(int i10) {
            if (i10 == 0) {
                return CONTENT_NOT_SET;
            }
            if (i10 == 1) {
                return TEXT;
            }
            if (i10 == 2) {
                return INLINE_DATA;
            }
            if (i10 == 3) {
                return FUNCTION_CALL;
            }
            if (i10 == 4) {
                return FUNCTION_RESPONSE;
            }
            if (i10 != 5) {
                return null;
            }
            return FILE_DATA;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ContentCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        Part part = new Part();
        DEFAULT_INSTANCE = part;
        GeneratedMessageLite.registerDefaultInstance(Part.class, part);
    }

    private Part() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContent() {
        this.contentCase_ = 0;
        this.content_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFileData() {
        if (this.contentCase_ == 5) {
            this.contentCase_ = 0;
            this.content_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFunctionCall() {
        if (this.contentCase_ == 3) {
            this.contentCase_ = 0;
            this.content_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFunctionResponse() {
        if (this.contentCase_ == 4) {
            this.contentCase_ = 0;
            this.content_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInlineData() {
        if (this.contentCase_ == 2) {
            this.contentCase_ = 0;
            this.content_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearText() {
        if (this.contentCase_ == 1) {
            this.contentCase_ = 0;
            this.content_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearThought() {
        this.thought_ = false;
    }

    public static Part getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFileData(FileData fileData) {
        fileData.getClass();
        if (this.contentCase_ != 5 || this.content_ == FileData.getDefaultInstance()) {
            this.content_ = fileData;
        } else {
            this.content_ = FileData.newBuilder((FileData) this.content_).mergeFrom((FileData.Builder) fileData).buildPartial();
        }
        this.contentCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFunctionCall(FunctionCall functionCall) {
        functionCall.getClass();
        if (this.contentCase_ != 3 || this.content_ == FunctionCall.getDefaultInstance()) {
            this.content_ = functionCall;
        } else {
            this.content_ = FunctionCall.newBuilder((FunctionCall) this.content_).mergeFrom((FunctionCall.Builder) functionCall).buildPartial();
        }
        this.contentCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFunctionResponse(FunctionResponse functionResponse) {
        functionResponse.getClass();
        if (this.contentCase_ != 4 || this.content_ == FunctionResponse.getDefaultInstance()) {
            this.content_ = functionResponse;
        } else {
            this.content_ = FunctionResponse.newBuilder((FunctionResponse) this.content_).mergeFrom((FunctionResponse.Builder) functionResponse).buildPartial();
        }
        this.contentCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInlineData(Blob blob) {
        blob.getClass();
        if (this.contentCase_ != 2 || this.content_ == Blob.getDefaultInstance()) {
            this.content_ = blob;
        } else {
            this.content_ = Blob.newBuilder((Blob) this.content_).mergeFrom((Blob.Builder) blob).buildPartial();
        }
        this.contentCase_ = 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Part parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Part) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Part parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Part) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Part> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileData(FileData fileData) {
        fileData.getClass();
        this.content_ = fileData;
        this.contentCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFunctionCall(FunctionCall functionCall) {
        functionCall.getClass();
        this.content_ = functionCall;
        this.contentCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFunctionResponse(FunctionResponse functionResponse) {
        functionResponse.getClass();
        this.content_ = functionResponse;
        this.contentCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInlineData(Blob blob) {
        blob.getClass();
        this.content_ = blob;
        this.contentCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(String str) {
        str.getClass();
        this.contentCase_ = 1;
        this.content_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.content_ = byteString.toStringUtf8();
        this.contentCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThought(boolean z10) {
        this.thought_ = z10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Part();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\n\u0006\u0000\u0000\u0000\u0001Ȼ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\n\u0007", new Object[]{"content_", "contentCase_", Blob.class, FunctionCall.class, FunctionResponse.class, FileData.class, "thought_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Part> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Part.class) {
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

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public ContentCase getContentCase() {
        return ContentCase.forNumber(this.contentCase_);
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public FileData getFileData() {
        return this.contentCase_ == 5 ? (FileData) this.content_ : FileData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public FunctionCall getFunctionCall() {
        return this.contentCase_ == 3 ? (FunctionCall) this.content_ : FunctionCall.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public FunctionResponse getFunctionResponse() {
        return this.contentCase_ == 4 ? (FunctionResponse) this.content_ : FunctionResponse.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public Blob getInlineData() {
        return this.contentCase_ == 2 ? (Blob) this.content_ : Blob.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public String getText() {
        return this.contentCase_ == 1 ? (String) this.content_ : "";
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public ByteString getTextBytes() {
        return ByteString.copyFromUtf8(this.contentCase_ == 1 ? (String) this.content_ : "");
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public boolean getThought() {
        return this.thought_;
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public boolean hasFileData() {
        return this.contentCase_ == 5;
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public boolean hasFunctionCall() {
        return this.contentCase_ == 3;
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public boolean hasFunctionResponse() {
        return this.contentCase_ == 4;
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public boolean hasInlineData() {
        return this.contentCase_ == 2;
    }

    @Override // com.zyql.protobuf.common.PartOrBuilder
    public boolean hasText() {
        return this.contentCase_ == 1;
    }

    public static Builder newBuilder(Part part) {
        return DEFAULT_INSTANCE.createBuilder(part);
    }

    public static Part parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Part) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Part parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Part) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Part parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Part) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Part parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Part) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Part parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Part) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Part parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Part) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Part parseFrom(InputStream inputStream) throws IOException {
        return (Part) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Part parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Part) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Part parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Part) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Part parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Part) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
