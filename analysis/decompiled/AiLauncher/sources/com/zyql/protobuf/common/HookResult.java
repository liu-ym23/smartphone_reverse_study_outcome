package com.zyql.protobuf.common;

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
public final class HookResult extends GeneratedMessageLite<HookResult, Builder> implements HookResultOrBuilder {
    public static final int BLOCK_REASON_FIELD_NUMBER = 5;
    public static final int CONTINUE_EXECUTION_FIELD_NUMBER = 4;
    private static final HookResult DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 8;
    public static final int ERROR_FIELD_NUMBER = 9;
    public static final int HOOK_ID_FIELD_NUMBER = 2;
    public static final int INVOCATION_ID_FIELD_NUMBER = 1;
    public static final int METADATA_FIELD_NUMBER = 10;
    public static final int MODIFIED_DATA_FIELD_NUMBER = 7;
    public static final int MODIFIED_FIELD_NUMBER = 6;
    private static volatile Parser<HookResult> PARSER = null;
    public static final int POST_MODE_FIELD_NUMBER = 12;
    public static final int PRE_MODE_FIELD_NUMBER = 11;
    public static final int REASON_FIELD_NUMBER = 13;
    public static final int SUCCESS_FIELD_NUMBER = 3;
    private boolean continueExecution_;
    private long durationMs_;
    private boolean modified_;
    private int postMode_;
    private int preMode_;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String invocationId_ = "";
    private String hookId_ = "";
    private String blockReason_ = "";
    private String reason_ = "";
    private ByteString modifiedData_ = ByteString.EMPTY;
    private String error_ = "";

    /* renamed from: com.zyql.protobuf.common.HookResult$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HookResult, Builder> implements HookResultOrBuilder {
        public Builder clearBlockReason() {
            copyOnWrite();
            ((HookResult) this.instance).clearBlockReason();
            return this;
        }

        public Builder clearContinueExecution() {
            copyOnWrite();
            ((HookResult) this.instance).clearContinueExecution();
            return this;
        }

        public Builder clearDurationMs() {
            copyOnWrite();
            ((HookResult) this.instance).clearDurationMs();
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((HookResult) this.instance).clearError();
            return this;
        }

        public Builder clearHookId() {
            copyOnWrite();
            ((HookResult) this.instance).clearHookId();
            return this;
        }

        public Builder clearInvocationId() {
            copyOnWrite();
            ((HookResult) this.instance).clearInvocationId();
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((HookResult) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public Builder clearModified() {
            copyOnWrite();
            ((HookResult) this.instance).clearModified();
            return this;
        }

        public Builder clearModifiedData() {
            copyOnWrite();
            ((HookResult) this.instance).clearModifiedData();
            return this;
        }

        public Builder clearPostMode() {
            copyOnWrite();
            ((HookResult) this.instance).clearPostMode();
            return this;
        }

        public Builder clearPreMode() {
            copyOnWrite();
            ((HookResult) this.instance).clearPreMode();
            return this;
        }

        public Builder clearReason() {
            copyOnWrite();
            ((HookResult) this.instance).clearReason();
            return this;
        }

        public Builder clearSuccess() {
            copyOnWrite();
            ((HookResult) this.instance).clearSuccess();
            return this;
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((HookResult) this.instance).getMetadataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public String getBlockReason() {
            return ((HookResult) this.instance).getBlockReason();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public ByteString getBlockReasonBytes() {
            return ((HookResult) this.instance).getBlockReasonBytes();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public boolean getContinueExecution() {
            return ((HookResult) this.instance).getContinueExecution();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public long getDurationMs() {
            return ((HookResult) this.instance).getDurationMs();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public String getError() {
            return ((HookResult) this.instance).getError();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public ByteString getErrorBytes() {
            return ((HookResult) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public String getHookId() {
            return ((HookResult) this.instance).getHookId();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public ByteString getHookIdBytes() {
            return ((HookResult) this.instance).getHookIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public String getInvocationId() {
            return ((HookResult) this.instance).getInvocationId();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public ByteString getInvocationIdBytes() {
            return ((HookResult) this.instance).getInvocationIdBytes();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public int getMetadataCount() {
            return ((HookResult) this.instance).getMetadataMap().size();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((HookResult) this.instance).getMetadataMap());
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((HookResult) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((HookResult) this.instance).getMetadataMap();
            if (metadataMap.containsKey(str)) {
                return metadataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public boolean getModified() {
            return ((HookResult) this.instance).getModified();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public ByteString getModifiedData() {
            return ((HookResult) this.instance).getModifiedData();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public PostToolCallMode getPostMode() {
            return ((HookResult) this.instance).getPostMode();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public int getPostModeValue() {
            return ((HookResult) this.instance).getPostModeValue();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public PreToolCallMode getPreMode() {
            return ((HookResult) this.instance).getPreMode();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public int getPreModeValue() {
            return ((HookResult) this.instance).getPreModeValue();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public String getReason() {
            return ((HookResult) this.instance).getReason();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public ByteString getReasonBytes() {
            return ((HookResult) this.instance).getReasonBytes();
        }

        @Override // com.zyql.protobuf.common.HookResultOrBuilder
        public boolean getSuccess() {
            return ((HookResult) this.instance).getSuccess();
        }

        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((HookResult) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }

        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((HookResult) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((HookResult) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        public Builder setBlockReason(String str) {
            copyOnWrite();
            ((HookResult) this.instance).setBlockReason(str);
            return this;
        }

        public Builder setBlockReasonBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookResult) this.instance).setBlockReasonBytes(byteString);
            return this;
        }

        public Builder setContinueExecution(boolean z10) {
            copyOnWrite();
            ((HookResult) this.instance).setContinueExecution(z10);
            return this;
        }

        public Builder setDurationMs(long j10) {
            copyOnWrite();
            ((HookResult) this.instance).setDurationMs(j10);
            return this;
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((HookResult) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookResult) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setHookId(String str) {
            copyOnWrite();
            ((HookResult) this.instance).setHookId(str);
            return this;
        }

        public Builder setHookIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookResult) this.instance).setHookIdBytes(byteString);
            return this;
        }

        public Builder setInvocationId(String str) {
            copyOnWrite();
            ((HookResult) this.instance).setInvocationId(str);
            return this;
        }

        public Builder setInvocationIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookResult) this.instance).setInvocationIdBytes(byteString);
            return this;
        }

        public Builder setModified(boolean z10) {
            copyOnWrite();
            ((HookResult) this.instance).setModified(z10);
            return this;
        }

        public Builder setModifiedData(ByteString byteString) {
            copyOnWrite();
            ((HookResult) this.instance).setModifiedData(byteString);
            return this;
        }

        public Builder setPostMode(PostToolCallMode postToolCallMode) {
            copyOnWrite();
            ((HookResult) this.instance).setPostMode(postToolCallMode);
            return this;
        }

        public Builder setPostModeValue(int i10) {
            copyOnWrite();
            ((HookResult) this.instance).setPostModeValue(i10);
            return this;
        }

        public Builder setPreMode(PreToolCallMode preToolCallMode) {
            copyOnWrite();
            ((HookResult) this.instance).setPreMode(preToolCallMode);
            return this;
        }

        public Builder setPreModeValue(int i10) {
            copyOnWrite();
            ((HookResult) this.instance).setPreModeValue(i10);
            return this;
        }

        public Builder setReason(String str) {
            copyOnWrite();
            ((HookResult) this.instance).setReason(str);
            return this;
        }

        public Builder setReasonBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((HookResult) this.instance).setReasonBytes(byteString);
            return this;
        }

        public Builder setSuccess(boolean z10) {
            copyOnWrite();
            ((HookResult) this.instance).setSuccess(z10);
            return this;
        }

        private Builder() {
            super(HookResult.DEFAULT_INSTANCE);
        }
    }

    public static final class MetadataDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private MetadataDefaultEntryHolder() {
        }
    }

    static {
        HookResult hookResult = new HookResult();
        DEFAULT_INSTANCE = hookResult;
        GeneratedMessageLite.registerDefaultInstance(HookResult.class, hookResult);
    }

    private HookResult() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBlockReason() {
        this.blockReason_ = getDefaultInstance().getBlockReason();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContinueExecution() {
        this.continueExecution_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationMs() {
        this.durationMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookId() {
        this.hookId_ = getDefaultInstance().getHookId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInvocationId() {
        this.invocationId_ = getDefaultInstance().getInvocationId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModified() {
        this.modified_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModifiedData() {
        this.modifiedData_ = getDefaultInstance().getModifiedData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPostMode() {
        this.postMode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPreMode() {
        this.preMode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    public static HookResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableMetadataMap() {
        return internalGetMutableMetadata();
    }

    private MapFieldLite<String, String> internalGetMetadata() {
        return this.metadata_;
    }

    private MapFieldLite<String, String> internalGetMutableMetadata() {
        if (!this.metadata_.isMutable()) {
            this.metadata_ = this.metadata_.mutableCopy();
        }
        return this.metadata_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HookResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HookResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HookResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HookResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HookResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBlockReason(String str) {
        str.getClass();
        this.blockReason_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBlockReasonBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.blockReason_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContinueExecution(boolean z10) {
        this.continueExecution_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationMs(long j10) {
        this.durationMs_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.error_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookId(String str) {
        str.getClass();
        this.hookId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHookIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.hookId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInvocationId(String str) {
        str.getClass();
        this.invocationId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInvocationIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.invocationId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModified(boolean z10) {
        this.modified_ = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModifiedData(ByteString byteString) {
        byteString.getClass();
        this.modifiedData_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostMode(PostToolCallMode postToolCallMode) {
        this.postMode_ = postToolCallMode.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostModeValue(int i10) {
        this.postMode_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreMode(PreToolCallMode preToolCallMode) {
        this.preMode_ = preToolCallMode.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreModeValue(int i10) {
        this.preMode_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(String str) {
        str.getClass();
        this.reason_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReasonBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.reason_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess(boolean z10) {
        this.success_ = z10;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public boolean containsMetadata(String str) {
        str.getClass();
        return internalGetMetadata().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HookResult();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0000\u0001\r\r\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004\u0007\u0005Ȉ\u0006\u0007\u0007\n\b\u0002\tȈ\n2\u000b\f\f\f\rȈ", new Object[]{"invocationId_", "hookId_", "success_", "continueExecution_", "blockReason_", "modified_", "modifiedData_", "durationMs_", "error_", "metadata_", MetadataDefaultEntryHolder.defaultEntry, "preMode_", "postMode_", "reason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HookResult> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HookResult.class) {
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

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public String getBlockReason() {
        return this.blockReason_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public ByteString getBlockReasonBytes() {
        return ByteString.copyFromUtf8(this.blockReason_);
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public boolean getContinueExecution() {
        return this.continueExecution_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public long getDurationMs() {
        return this.durationMs_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public String getHookId() {
        return this.hookId_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public ByteString getHookIdBytes() {
        return ByteString.copyFromUtf8(this.hookId_);
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public String getInvocationId() {
        return this.invocationId_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public ByteString getInvocationIdBytes() {
        return ByteString.copyFromUtf8(this.invocationId_);
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        return mapFieldLiteInternalGetMetadata.containsKey(str) ? mapFieldLiteInternalGetMetadata.get(str) : str2;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetadata = internalGetMetadata();
        if (mapFieldLiteInternalGetMetadata.containsKey(str)) {
            return mapFieldLiteInternalGetMetadata.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public boolean getModified() {
        return this.modified_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public ByteString getModifiedData() {
        return this.modifiedData_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public PostToolCallMode getPostMode() {
        PostToolCallMode postToolCallModeForNumber = PostToolCallMode.forNumber(this.postMode_);
        return postToolCallModeForNumber == null ? PostToolCallMode.UNRECOGNIZED : postToolCallModeForNumber;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public int getPostModeValue() {
        return this.postMode_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public PreToolCallMode getPreMode() {
        PreToolCallMode preToolCallModeForNumber = PreToolCallMode.forNumber(this.preMode_);
        return preToolCallModeForNumber == null ? PreToolCallMode.UNRECOGNIZED : preToolCallModeForNumber;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public int getPreModeValue() {
        return this.preMode_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public String getReason() {
        return this.reason_;
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public ByteString getReasonBytes() {
        return ByteString.copyFromUtf8(this.reason_);
    }

    @Override // com.zyql.protobuf.common.HookResultOrBuilder
    public boolean getSuccess() {
        return this.success_;
    }

    public static Builder newBuilder(HookResult hookResult) {
        return DEFAULT_INSTANCE.createBuilder(hookResult);
    }

    public static HookResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HookResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HookResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HookResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HookResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HookResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HookResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HookResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HookResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HookResult parseFrom(InputStream inputStream) throws IOException {
        return (HookResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HookResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HookResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HookResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HookResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HookResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
