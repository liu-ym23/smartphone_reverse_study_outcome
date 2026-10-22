package com.bytedance.crypto.monitor.proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CryptoSDKInfo extends GeneratedMessage implements CryptoSDKInfoOrBuilder {
    private static final CryptoSDKInfo DEFAULT_INSTANCE = null;
    public static final int ERROR_TRACE_FIELD_NUMBER = 5;
    public static final int NORMAL_TRACE_FIELD_NUMBER = 4;
    private static final Parser<CryptoSDKInfo> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    public static final int TRAIN_NUM_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<ErrorTrace> errorTrace_;
    private byte memoizedIsInitialized;
    private List<NormalTrace> normalTrace_;
    private long timestamp_;
    private int trainNum_;
    private int version_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CryptoSDKInfoOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> errorTraceBuilder_;
        private List<ErrorTrace> errorTrace_;
        private RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> normalTraceBuilder_;
        private List<NormalTrace> normalTrace_;
        private long timestamp_;
        private int trainNum_;
        private int version_;

        private Builder() {
            this.normalTrace_ = Collections.emptyList();
            this.errorTrace_ = Collections.emptyList();
        }

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
            this.normalTrace_ = Collections.emptyList();
            this.errorTrace_ = Collections.emptyList();
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
        }

        private void buildPartial0(CryptoSDKInfo r5) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L5;
            CryptoSDKInfo.access$502(r5, this.version_);
            int r1 = 1;
        L7:
            if ((r0 & 2) == 0) goto L10;
            CryptoSDKInfo.access$602(r5, this.trainNum_);
            r1 = r1 | 2;
        L10:
            if ((r0 & 4) == 0) goto L12;
            CryptoSDKInfo.access$702(r5, this.timestamp_);
            r1 = r1 | 4;
        L12:
            CryptoSDKInfo.access$876(r5, r1);
            return;
        L5:
            r1 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(CryptoSDKInfo r2) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 == null) goto L5;
            List r1 = r0.build();
        L9:
            CryptoSDKInfo.access$302(r2, r1);
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r3 = this.errorTraceBuilder_;
            if (r3 == null) goto L12;
            List r4 = r3.build();
        L16:
            CryptoSDKInfo.access$402(r2, r4);
            return;
        L12:
            if ((this.bitField0_ & 16) == 0) goto L14;
            this.errorTrace_ = Collections.unmodifiableList(this.errorTrace_);
            this.bitField0_ &= -17;
        L14:
            r4 = this.errorTrace_;
            goto L16
        L5:
            if ((this.bitField0_ & 8) == 0) goto L7;
            this.normalTrace_ = Collections.unmodifiableList(this.normalTrace_);
            this.bitField0_ &= -9;
        L7:
            r1 = this.normalTrace_;
            goto L9
        }

        private void ensureErrorTraceIsMutable() {
            if ((this.bitField0_ & 16) != 0) goto L6;
            this.errorTrace_ = new ArrayList(this.errorTrace_);
            this.bitField0_ |= 16;
            return;
        }

        private void ensureNormalTraceIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.normalTrace_ = new ArrayList(this.normalTrace_);
            this.bitField0_ |= 8;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor;
        }

        private RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> internalGetErrorTraceFieldBuilder() {
            if (this.errorTraceBuilder_ != null) goto L10;
            List<ErrorTrace> r1 = this.errorTrace_;
            if ((this.bitField0_ & 16) == 0) goto L7;
            boolean r2 = true;
        L8:
            this.errorTraceBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
            this.errorTrace_ = null;
            goto L10
        L7:
            r2 = false;
        L10:
            return this.errorTraceBuilder_;
        }

        private RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> internalGetNormalTraceFieldBuilder() {
            if (this.normalTraceBuilder_ != null) goto L10;
            List<NormalTrace> r1 = this.normalTrace_;
            if ((this.bitField0_ & 8) == 0) goto L7;
            boolean r2 = true;
        L8:
            this.normalTraceBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
            this.normalTrace_ = null;
            goto L10
        L7:
            r2 = false;
        L10:
            return this.normalTraceBuilder_;
        }

        public Builder addAllErrorTrace(Iterable<? extends ErrorTrace> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L5;
            ensureErrorTraceIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.errorTrace_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder addAllNormalTrace(Iterable<? extends NormalTrace> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L5;
            ensureNormalTraceIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.normalTrace_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder addErrorTrace(int r2, ErrorTrace.Builder r3) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L5;
            ensureErrorTraceIsMutable();
            this.errorTrace_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addErrorTrace(int r2, ErrorTrace r3) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L5;
            r3.getClass();
            ensureErrorTraceIsMutable();
            this.errorTrace_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addErrorTrace(ErrorTrace.Builder r2) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L5;
            ensureErrorTraceIsMutable();
            this.errorTrace_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addErrorTrace(ErrorTrace r2) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L5;
            r2.getClass();
            ensureErrorTraceIsMutable();
            this.errorTrace_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public ErrorTrace.Builder addErrorTraceBuilder() {
            return (ErrorTrace.Builder) ZeusTransformUtils.preCheckCast(internalGetErrorTraceFieldBuilder().addBuilder(ErrorTrace.getDefaultInstance()), ErrorTrace.Builder.class, "com.obric.aiagent.plugin");
        }

        public ErrorTrace.Builder addErrorTraceBuilder(int r2) {
            return (ErrorTrace.Builder) ZeusTransformUtils.preCheckCast(internalGetErrorTraceFieldBuilder().addBuilder(r2, ErrorTrace.getDefaultInstance()), ErrorTrace.Builder.class, "com.obric.aiagent.plugin");
        }

        public Builder addNormalTrace(int r2, NormalTrace.Builder r3) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L5;
            ensureNormalTraceIsMutable();
            this.normalTrace_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addNormalTrace(int r2, NormalTrace r3) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L5;
            r3.getClass();
            ensureNormalTraceIsMutable();
            this.normalTrace_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addNormalTrace(NormalTrace.Builder r2) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L5;
            ensureNormalTraceIsMutable();
            this.normalTrace_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addNormalTrace(NormalTrace r2) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L5;
            r2.getClass();
            ensureNormalTraceIsMutable();
            this.normalTrace_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public NormalTrace.Builder addNormalTraceBuilder() {
            return (NormalTrace.Builder) ZeusTransformUtils.preCheckCast(internalGetNormalTraceFieldBuilder().addBuilder(NormalTrace.getDefaultInstance()), NormalTrace.Builder.class, "com.obric.aiagent.plugin");
        }

        public NormalTrace.Builder addNormalTraceBuilder(int r2) {
            return (NormalTrace.Builder) ZeusTransformUtils.preCheckCast(internalGetNormalTraceFieldBuilder().addBuilder(r2, NormalTrace.getDefaultInstance()), NormalTrace.Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CryptoSDKInfo build() {
            CryptoSDKInfo r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw GeneratedMessage.Builder.newUninitializedMessageException(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CryptoSDKInfo buildPartial() {
            CryptoSDKInfo r0 = new CryptoSDKInfo(this, null);
            buildPartialRepeatedFields(r0);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.version_ = 0;
            this.trainNum_ = 0;
            this.timestamp_ = 0;
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L5;
            this.normalTrace_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -9;
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r1 = this.errorTraceBuilder_;
            if (r1 != null) goto L9;
            this.errorTrace_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -17;
            return this;
        L9:
            this.errorTrace_ = null;
            r1.clear();
            goto L10
        L5:
            this.normalTrace_ = null;
            r0.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder clearErrorTrace() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L5;
            this.errorTrace_ = Collections.emptyList();
            this.bitField0_ &= -17;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
            goto L6
        }

        public Builder clearNormalTrace() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L5;
            this.normalTrace_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
            goto L6
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -5;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTrainNum() {
            this.bitField0_ &= -3;
            this.trainNum_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVersion() {
            this.bitField0_ &= -2;
            this.version_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CryptoSDKInfo getDefaultInstanceForType() {
            return CryptoSDKInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public ErrorTrace getErrorTrace(int r3) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.errorTrace_.get(r3);
        L6:
            return (ErrorTrace) ZeusTransformUtils.preCheckCast(r2, ErrorTrace.class, "com.obric.aiagent.plugin");
        L7:
            r2 = r0.getMessage(r3);
            goto L6
        }

        public ErrorTrace.Builder getErrorTraceBuilder(int r2) {
            return (ErrorTrace.Builder) ZeusTransformUtils.preCheckCast(internalGetErrorTraceFieldBuilder().getBuilder(r2), ErrorTrace.Builder.class, "com.obric.aiagent.plugin");
        }

        public List<ErrorTrace.Builder> getErrorTraceBuilderList() {
            return internalGetErrorTraceFieldBuilder().getBuilderList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getErrorTraceCount() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L7;
            return this.errorTrace_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<ErrorTrace> getErrorTraceList() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.errorTrace_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public ErrorTraceOrBuilder getErrorTraceOrBuilder(int r3) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.errorTrace_.get(r3);
        L6:
            return (ErrorTraceOrBuilder) ZeusTransformUtils.preCheckCast(r2, ErrorTraceOrBuilder.class, "com.obric.aiagent.plugin");
        L7:
            r2 = r0.getMessageOrBuilder(r3);
            goto L6
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<? extends ErrorTraceOrBuilder> getErrorTraceOrBuilderList() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.errorTrace_);
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public NormalTrace getNormalTrace(int r3) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.normalTrace_.get(r3);
        L6:
            return (NormalTrace) ZeusTransformUtils.preCheckCast(r2, NormalTrace.class, "com.obric.aiagent.plugin");
        L7:
            r2 = r0.getMessage(r3);
            goto L6
        }

        public NormalTrace.Builder getNormalTraceBuilder(int r2) {
            return (NormalTrace.Builder) ZeusTransformUtils.preCheckCast(internalGetNormalTraceFieldBuilder().getBuilder(r2), NormalTrace.Builder.class, "com.obric.aiagent.plugin");
        }

        public List<NormalTrace.Builder> getNormalTraceBuilderList() {
            return internalGetNormalTraceFieldBuilder().getBuilderList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getNormalTraceCount() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L7;
            return this.normalTrace_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<NormalTrace> getNormalTraceList() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.normalTrace_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public NormalTraceOrBuilder getNormalTraceOrBuilder(int r3) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.normalTrace_.get(r3);
        L6:
            return (NormalTraceOrBuilder) ZeusTransformUtils.preCheckCast(r2, NormalTraceOrBuilder.class, "com.obric.aiagent.plugin");
        L7:
            r2 = r0.getMessageOrBuilder(r3);
            goto L6
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<? extends NormalTraceOrBuilder> getNormalTraceOrBuilderList() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.normalTrace_);
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getTrainNum() {
            return this.trainNum_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public boolean hasTrainNum() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public boolean hasVersion() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CryptoSDKInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(CryptoSDKInfo r4) {
            if (r4 != CryptoSDKInfo.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r4.hasVersion() == false) goto L9;
            setVersion(r4.getVersion());
        L9:
            if (r4.hasTrainNum() == false) goto L12;
            setTrainNum(r4.getTrainNum());
        L12:
            if (r4.hasTimestamp() == false) goto L14;
            setTimestamp(r4.getTimestamp());
        L14:
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r1 = null;
            if (this.normalTraceBuilder_ != null) goto L24;
            if (CryptoSDKInfo.access$300(r4).isEmpty() == true) goto L34;
            if (this.normalTrace_.isEmpty() == false) goto L21;
            this.normalTrace_ = CryptoSDKInfo.access$300(r4);
            this.bitField0_ &= -9;
        L22:
            onChanged();
            goto L34
        L21:
            ensureNormalTraceIsMutable();
            this.normalTrace_.addAll(CryptoSDKInfo.access$300(r4));
        L34:
            if (this.errorTraceBuilder_ != null) goto L43;
            if (CryptoSDKInfo.access$400(r4).isEmpty() == false) goto L38;
        L51:
            mergeUnknownFields(r4.getUnknownFields());
            onChanged();
            return this;
        L38:
            if (this.errorTrace_.isEmpty() == false) goto L40;
            this.errorTrace_ = CryptoSDKInfo.access$400(r4);
            this.bitField0_ &= -17;
        L41:
            onChanged();
            goto L51
        L40:
            ensureErrorTraceIsMutable();
            this.errorTrace_.addAll(CryptoSDKInfo.access$400(r4));
            goto L41
        L43:
            if (CryptoSDKInfo.access$400(r4).isEmpty() == true) goto L51;
            if (this.errorTraceBuilder_.isEmpty() == false) goto L50;
            this.errorTraceBuilder_.dispose();
            this.errorTraceBuilder_ = null;
            this.errorTrace_ = CryptoSDKInfo.access$400(r4);
            this.bitField0_ &= -17;
            if (CryptoSDKInfo.access$1000() == false) goto L49;
            r1 = internalGetErrorTraceFieldBuilder();
        L49:
            this.errorTraceBuilder_ = r1;
            goto L51
        L50:
            this.errorTraceBuilder_.addAllMessages(CryptoSDKInfo.access$400(r4));
            goto L51
        L24:
            if (CryptoSDKInfo.access$300(r4).isEmpty() == true) goto L34;
            if (this.normalTraceBuilder_.isEmpty() == false) goto L32;
            this.normalTraceBuilder_.dispose();
            this.normalTraceBuilder_ = null;
            this.normalTrace_ = CryptoSDKInfo.access$300(r4);
            this.bitField0_ &= -9;
            if (CryptoSDKInfo.access$900() == false) goto L30;
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = internalGetNormalTraceFieldBuilder();
        L31:
            this.normalTraceBuilder_ = r0;
            goto L34
        L30:
            r0 = null;
            goto L31
        L32:
            this.normalTraceBuilder_.addAllMessages(CryptoSDKInfo.access$300(r4));
            goto L34
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r6, ExtensionRegistryLite r7) {
            r7.getClass();
            boolean r1 = false;
        L3:
            if (r1 == true) goto L40;
            int r2 = r6.readTag();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r2 == 0) goto L32;
            if (r2 == 8) goto L29;
            if (r2 == 16) goto L28;
            if (r2 != 24) goto L13;
            this.timestamp_ = r6.readInt64();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            int r3 = this.bitField0_ | 4;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
        L30:
            this.bitField0_ = r3;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L13:
            if (r2 == 34) goto L22;
            if (r2 != 42) goto L17;
            MessageLite r4 = (ErrorTrace) ZeusTransformUtils.preCheckCast(r6.readMessage(ErrorTrace.parser(), r7), ErrorTrace.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            RepeatedFieldBuilder r5 = this.errorTraceBuilder_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r5 == null) goto L21;
        L26:
            r5.addMessage(r4);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L21:
            ensureErrorTraceIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            List r8 = this.errorTrace_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
        L25:
            r8.add(r4);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L17:
            if (parseUnknownField(r6, r7, r2) == true) goto L3;
        L22:
            r4 = (NormalTrace) ZeusTransformUtils.preCheckCast(r6.readMessage(NormalTrace.parser(), r7), NormalTrace.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r5 = this.normalTraceBuilder_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r5 != null) goto L26;
            ensureNormalTraceIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r8 = this.normalTrace_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L25
        L28:
            this.trainNum_ = r6.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r3 = this.bitField0_ | 2;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L30
        L29:
            this.version_ = r6.readInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r3 = this.bitField0_ | 1;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
        L32:
            r1 = true;
            goto L3
        L35:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            onChanged();
            throw th;
        L40:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, CryptoSDKInfo.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((CryptoSDKInfo) ZeusTransformUtils.preCheckCast(r4, CryptoSDKInfo.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ AbstractMessage.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ Message.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        public Builder removeErrorTrace(int r2) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L5;
            ensureErrorTraceIsMutable();
            this.errorTrace_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public Builder removeNormalTrace(int r2) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L5;
            ensureNormalTraceIsMutable();
            this.normalTrace_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public Builder setErrorTrace(int r2, ErrorTrace.Builder r3) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L5;
            ensureErrorTraceIsMutable();
            this.errorTrace_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder setErrorTrace(int r2, ErrorTrace r3) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r0 = this.errorTraceBuilder_;
            if (r0 != null) goto L5;
            r3.getClass();
            ensureErrorTraceIsMutable();
            this.errorTrace_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
            goto L6
        }

        public Builder setNormalTrace(int r2, NormalTrace.Builder r3) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L5;
            ensureNormalTraceIsMutable();
            this.normalTrace_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder setNormalTrace(int r2, NormalTrace r3) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r0 = this.normalTraceBuilder_;
            if (r0 != null) goto L5;
            r3.getClass();
            ensureNormalTraceIsMutable();
            this.normalTrace_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
            goto L6
        }

        public Builder setTimestamp(long r1) {
            this.timestamp_ = r1;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setTrainNum(int r1) {
            this.trainNum_ = r1;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setVersion(int r1) {
            this.version_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", CryptoSDKInfo.class.getName());
        DEFAULT_INSTANCE = new CryptoSDKInfo();
        PARSER = new AnonymousClass1();
    }

    private CryptoSDKInfo() {
        this.version_ = 0;
        this.trainNum_ = 0;
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
        this.normalTrace_ = Collections.emptyList();
        this.errorTrace_ = Collections.emptyList();
    }

    private CryptoSDKInfo(GeneratedMessage.Builder<?> r3) {
        super(r3);
        this.version_ = 0;
        this.trainNum_ = 0;
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ CryptoSDKInfo(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static /* synthetic */ boolean access$1000() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$300(CryptoSDKInfo r0) {
        return r0.normalTrace_;
    }

    public static /* synthetic */ List access$302(CryptoSDKInfo r2, List r3) {
        List<NormalTrace> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        r2.normalTrace_ = r4;
        return r4;
    }

    public static /* synthetic */ List access$400(CryptoSDKInfo r0) {
        return r0.errorTrace_;
    }

    public static /* synthetic */ List access$402(CryptoSDKInfo r2, List r3) {
        List<ErrorTrace> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        r2.errorTrace_ = r4;
        return r4;
    }

    public static /* synthetic */ int access$502(CryptoSDKInfo r0, int r1) {
        r0.version_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$602(CryptoSDKInfo r0, int r1) {
        r0.trainNum_ = r1;
        return r1;
    }

    public static /* synthetic */ long access$702(CryptoSDKInfo r0, long r1) {
        r0.timestamp_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$876(CryptoSDKInfo r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
    }

    public static /* synthetic */ boolean access$900() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static CryptoSDKInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CryptoSDKInfo r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static CryptoSDKInfo parseDelimitedFrom(InputStream r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseFrom(ByteString r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseFrom(CodedInputStream r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseFrom(InputStream r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseFrom(ByteBuffer r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseFrom(byte[] r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static CryptoSDKInfo parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CryptoSDKInfo.class, "com.obric.aiagent.plugin");
    }

    public static Parser<CryptoSDKInfo> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, CryptoSDKInfo.class) == false) goto L8;
        CryptoSDKInfo r10 = (CryptoSDKInfo) ZeusTransformUtils.preCheckCast(r9, CryptoSDKInfo.class, "com.obric.aiagent.plugin");
        if (hasVersion() == r10.hasVersion()) goto L13;
        return false;
    L13:
        if (hasVersion() == false) goto L18;
        if (getVersion() == r10.getVersion()) goto L18;
        return false;
    L18:
        if (hasTrainNum() == r10.hasTrainNum()) goto L21;
        return false;
    L21:
        if (hasTrainNum() == false) goto L26;
        if (getTrainNum() == r10.getTrainNum()) goto L26;
        return false;
    L26:
        if (hasTimestamp() == r10.hasTimestamp()) goto L29;
        return false;
    L29:
        if (hasTimestamp() == false) goto L34;
        if (getTimestamp() == r10.getTimestamp()) goto L34;
        return false;
    L34:
        if (getNormalTraceList().equals(r10.getNormalTraceList()) == true) goto L37;
        return false;
    L37:
        if (getErrorTraceList().equals(r10.getErrorTraceList()) == true) goto L40;
        return false;
    L40:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L42;
        return false;
    L42:
        return true;
    L8:
        return super.equals(r9);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CryptoSDKInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public ErrorTrace getErrorTrace(int r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(this.errorTrace_.get(r2), ErrorTrace.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getErrorTraceCount() {
        return this.errorTrace_.size();
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<ErrorTrace> getErrorTraceList() {
        return this.errorTrace_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public ErrorTraceOrBuilder getErrorTraceOrBuilder(int r2) {
        return (ErrorTraceOrBuilder) ZeusTransformUtils.preCheckCast(this.errorTrace_.get(r2), ErrorTraceOrBuilder.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<? extends ErrorTraceOrBuilder> getErrorTraceOrBuilderList() {
        return this.errorTrace_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public NormalTrace getNormalTrace(int r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(this.normalTrace_.get(r2), NormalTrace.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getNormalTraceCount() {
        return this.normalTrace_.size();
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<NormalTrace> getNormalTraceList() {
        return this.normalTrace_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public NormalTraceOrBuilder getNormalTraceOrBuilder(int r2) {
        return (NormalTraceOrBuilder) ZeusTransformUtils.preCheckCast(this.normalTrace_.get(r2), NormalTraceOrBuilder.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<? extends NormalTraceOrBuilder> getNormalTraceOrBuilderList() {
        return this.normalTrace_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CryptoSDKInfo> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r1 = CodedOutputStream.computeInt32Size(1, this.version_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r1 = r1 + CodedOutputStream.computeUInt32Size(2, this.trainNum_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r1 = r1 + CodedOutputStream.computeInt64Size(3, this.timestamp_);
    L15:
        int r3 = 0;
    L17:
        if (r3 >= this.normalTrace_.size()) goto L20;
        r1 = r1 + CodedOutputStream.computeMessageSize(4, (MessageLite) ZeusTransformUtils.preCheckCast(this.normalTrace_.get(r3), MessageLite.class, "com.obric.aiagent.plugin"));
        r3 = r3 + 1;
    L20:
        if (r2 >= this.errorTrace_.size()) goto L22;
        r1 = r1 + CodedOutputStream.computeMessageSize(5, (MessageLite) ZeusTransformUtils.preCheckCast(this.errorTrace_.get(r2), MessageLite.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L20
    L22:
        int r4 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r4;
        return r4;
    L8:
        r1 = 0;
        goto L10
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getTrainNum() {
        return this.trainNum_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public boolean hasTrainNum() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public boolean hasVersion() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r0 = this.memoizedHashCode;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = getDescriptor().hashCode() + 779;
        if (hasVersion() == false) goto L9;
        r1 = (((r1 * 37) + 1) * 53) + getVersion();
    L9:
        if (hasTrainNum() == false) goto L12;
        r1 = (((r1 * 37) + 2) * 53) + getTrainNum();
    L12:
        if (hasTimestamp() == false) goto L15;
        r1 = (((r1 * 37) + 3) * 53) + Internal.hashLong(getTimestamp());
    L15:
        if (getNormalTraceCount() <= 0) goto L18;
        r1 = (((r1 * 37) + 4) * 53) + getNormalTraceList().hashCode();
    L18:
        if (getErrorTraceCount() <= 0) goto L20;
        r1 = (((r1 * 37) + 5) * 53) + getErrorTraceList().hashCode();
    L20:
        int r2 = (r1 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r2;
        return r2;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CryptoSDKInfo.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r2) {
        return new Builder((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"), null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r3) {
        return newBuilderForType((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r1 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r1);
    L6:
        return new Builder(r1).mergeFrom(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r7) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r7.writeInt32(1, this.version_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r7.writeUInt32(2, this.trainNum_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L11;
        r7.writeInt64(3, this.timestamp_);
    L11:
        int r0 = 0;
        int r2 = 0;
    L13:
        if (r2 >= this.normalTrace_.size()) goto L16;
        r7.writeMessage(4, (MessageLite) ZeusTransformUtils.preCheckCast(this.normalTrace_.get(r2), MessageLite.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
    L16:
        if (r0 >= this.errorTrace_.size()) goto L18;
        r7.writeMessage(5, (MessageLite) ZeusTransformUtils.preCheckCast(this.errorTrace_.get(r0), MessageLite.class, "com.obric.aiagent.plugin"));
        r0 = r0 + 1;
        goto L16
    L18:
        getUnknownFields().writeTo(r7);
    }
}
