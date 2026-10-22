package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class GeneratedMessageV3 extends GeneratedMessage.ExtendableMessage<GeneratedMessageV3> {
    private static final long serialVersionUID = 1;

    @Deprecated
    public static abstract class Builder<BuilderT extends Builder<BuilderT>> extends GeneratedMessage.ExtendableBuilder<GeneratedMessageV3, BuilderT> {
        private Builder<BuilderT>.BuilderParentImpl meAsParent;

        @Deprecated
        private class BuilderParentImpl implements BuilderParent {
            final /* synthetic */ Builder this$0;

            private BuilderParentImpl(Builder r1) {
                this.this$0 = r1;
            }

            /* synthetic */ BuilderParentImpl(Builder r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                this.this$0.onChanged();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        @Deprecated
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo47clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ AbstractMessage.BuilderParent getParentForChildren() {
            return getParentForChildren();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r1) {
            return setUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r1) {
            return setUnknownFields(r1);
        }

        @Deprecated
        public Builder() {
            super(null);
        }

        @Deprecated
        public Builder(BuilderParent r3) {
            super((BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, BuilderParent.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clone() {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.clone(), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clear() {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.clear(), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        @Deprecated
        public FieldAccessorTable internalGetFieldAccessorTable() {
            throw new UnsupportedOperationException("Should be overridden in gencode.");
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT setField(Descriptors.FieldDescriptor r1, Object r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.setField(r1, r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clearField(Descriptors.FieldDescriptor r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.clearField(r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clearOneof(Descriptors.OneofDescriptor r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.clearOneof(r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.setRepeatedField(r1, r2, r3), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.addRepeatedField(r1, r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT setUnknownFields(UnknownFieldSet r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.setUnknownFields(r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT mergeUnknownFields(UnknownFieldSet r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.mergeUnknownFields(r2), Builder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        @Deprecated
        public BuilderParent getParentForChildren() {
            if (this.meAsParent != null) goto L6;
            this.meAsParent = new BuilderParentImpl(this, null);
        L6:
            return this.meAsParent;
        }
    }

    @Deprecated
    protected interface BuilderParent extends AbstractMessage.BuilderParent {
    }

    @Deprecated
    public static abstract class ExtendableBuilder<MessageT extends ExtendableMessage<MessageT>, BuilderT extends ExtendableBuilder<MessageT, BuilderT>> extends Builder<BuilderT> implements ExtendableMessageOrBuilder<MessageT> {
        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Deprecated
        public ExtendableBuilder() {
        }

        @Deprecated
        public ExtendableBuilder(BuilderParent r3) {
            super((BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, BuilderParent.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageT, T> r1) {
            return hasExtension(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageT, List<T>> r1) {
            return getExtensionCount(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, T> r1) {
            return (T) getExtension(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, List<T>> r1, int r2) {
            return (T) getExtension(r1, r2);
        }

        @Deprecated
        public <T> BuilderT setExtension(GeneratedMessage.GeneratedExtension<MessageT, T> r1, T r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(setExtension(r1, r2), ExtendableBuilder.class, "com.obric.aiagent.plugin");
        }

        @Deprecated
        public <T> BuilderT setExtension(GeneratedMessage.GeneratedExtension<MessageT, List<T>> r1, int r2, T r3) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(setExtension(r1, r2, r3), ExtendableBuilder.class, "com.obric.aiagent.plugin");
        }

        @Deprecated
        public <T> BuilderT addExtension(GeneratedMessage.GeneratedExtension<MessageT, List<T>> r1, T r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(addExtension(r1, r2), ExtendableBuilder.class, "com.obric.aiagent.plugin");
        }

        @Deprecated
        public <T> BuilderT clearExtension(GeneratedMessage.GeneratedExtension<MessageT, T> r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(clearExtension(r2), ExtendableBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT setField(Descriptors.FieldDescriptor r1, Object r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.setField(r1, r2), ExtendableBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clearField(Descriptors.FieldDescriptor r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.clearField(r2), ExtendableBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clearOneof(Descriptors.OneofDescriptor r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.clearOneof(r2), ExtendableBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.setRepeatedField(r1, r2, r3), ExtendableBuilder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.addRepeatedField(r1, r2), ExtendableBuilder.class, "com.obric.aiagent.plugin");
        }

        @Deprecated
        public final void mergeExtensionFields(ExtendableMessage<?> r1) {
            super.mergeExtensionFields(r1);
        }
    }

    @Deprecated
    public static abstract class ExtendableMessage<MessageT extends ExtendableMessage<MessageT>> extends GeneratedMessageV3 implements ExtendableMessageOrBuilder<MessageT> {

        @Deprecated
        protected class ExtensionWriter extends GeneratedMessage.ExtendableMessage.ExtensionWriter {
            final /* synthetic */ ExtendableMessage this$0;

            /* synthetic */ ExtensionWriter(ExtendableMessage r1, boolean r2, AnonymousClass1 r3) {
                this(r1, r2);
            }

            private ExtensionWriter(ExtendableMessage r1, boolean r2) {
                this.this$0 = r1;
                super(r1, r2);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableMessage<GeneratedMessageV3>.ExtensionWriter newExtensionWriter() {
            return newExtensionWriter2();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableMessage<GeneratedMessageV3>.ExtensionWriter newMessageSetExtensionWriter() {
            return newMessageSetExtensionWriter2();
        }

        @Deprecated
        public ExtendableMessage() {
        }

        @Deprecated
        public ExtendableMessage(ExtendableBuilder<MessageT, ?> r1) {
            super(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageT, T> r1) {
            return hasExtension(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageT, List<T>> r1) {
            return getExtensionCount(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, T> r1) {
            return (T) getExtension(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, List<T>> r1, int r2) {
            return (T) getExtension(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        @Deprecated
        public FieldAccessorTable internalGetFieldAccessorTable() {
            throw new UnsupportedOperationException("Should be overridden in gencode.");
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage
        @Deprecated
        /* JADX INFO: renamed from: newExtensionWriter, reason: avoid collision after fix types in other method */
        public GeneratedMessage.ExtendableMessage<GeneratedMessageV3>.ExtensionWriter newExtensionWriter2() {
            return new ExtensionWriter(this, false, null);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage
        @Deprecated
        /* JADX INFO: renamed from: newMessageSetExtensionWriter, reason: avoid collision after fix types in other method */
        public GeneratedMessage.ExtendableMessage<GeneratedMessageV3>.ExtensionWriter newMessageSetExtensionWriter2() {
            return new ExtensionWriter(this, true, null);
        }
    }

    @Deprecated
    public interface ExtendableMessageOrBuilder<MessageT extends ExtendableMessage<MessageT>> extends GeneratedMessage.ExtendableMessageOrBuilder<GeneratedMessageV3> {
        @Deprecated
        <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, T> r1);

        @Deprecated
        <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, List<T>> r1, int r2);

        @Deprecated
        <T> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageT, List<T>> r1);

        @Deprecated
        <T> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageT, T> r1);
    }

    @Deprecated
    public static final class FieldAccessorTable extends GeneratedMessage.FieldAccessorTable {
        @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable ensureFieldAccessorsInitialized(Class r1, Class r2) {
            return ensureFieldAccessorsInitialized(r1, r2);
        }

        @Deprecated
        public FieldAccessorTable(Descriptors.Descriptor r1, String[] r2, Class<? extends GeneratedMessageV3> r3, Class<? extends Builder<?>> r4) {
            super(r1, r2, r3, r4);
        }

        @Deprecated
        public FieldAccessorTable(Descriptors.Descriptor r1, String[] r2) {
            super(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable
        @Deprecated
        public FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessage> r1, Class<? extends GeneratedMessage.Builder<?>> r2) {
            return (FieldAccessorTable) ZeusTransformUtils.preCheckCast(super.ensureFieldAccessorsInitialized(r1, r2), FieldAccessorTable.class, "com.obric.aiagent.plugin");
        }
    }

    @Deprecated
    protected static final class UnusedPrivateParameter {
        static final UnusedPrivateParameter INSTANCE = null;

        static {
            INSTANCE = new UnusedPrivateParameter();
        }

        private UnusedPrivateParameter() {
        }
    }

    @Deprecated
    public abstract Message.Builder newBuilderForType(BuilderParent r1);

    @Override // com.google.protobuf.GeneratedMessage
    @Deprecated
    public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return internalGetFieldAccessorTable();
    }

    @Deprecated
    public GeneratedMessageV3() {
    }

    @Deprecated
    public GeneratedMessageV3(Builder<?> r1) {
        super(r1);
    }

    @Deprecated
    public static Internal.IntList mutableCopy(Internal.IntList r2) {
        return (Internal.IntList) ZeusTransformUtils.preCheckCast(makeMutableCopy((Internal.IntList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.IntList.class, "com.obric.aiagent.plugin")), Internal.IntList.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public static Internal.LongList mutableCopy(Internal.LongList r2) {
        return (Internal.LongList) ZeusTransformUtils.preCheckCast(makeMutableCopy((Internal.LongList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.LongList.class, "com.obric.aiagent.plugin")), Internal.LongList.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public static Internal.FloatList mutableCopy(Internal.FloatList r2) {
        return (Internal.FloatList) ZeusTransformUtils.preCheckCast(makeMutableCopy((Internal.FloatList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.FloatList.class, "com.obric.aiagent.plugin")), Internal.FloatList.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public static Internal.DoubleList mutableCopy(Internal.DoubleList r2) {
        return (Internal.DoubleList) ZeusTransformUtils.preCheckCast(makeMutableCopy((Internal.DoubleList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.DoubleList.class, "com.obric.aiagent.plugin")), Internal.DoubleList.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public static Internal.BooleanList mutableCopy(Internal.BooleanList r2) {
        return (Internal.BooleanList) ZeusTransformUtils.preCheckCast(makeMutableCopy((Internal.BooleanList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.BooleanList.class, "com.obric.aiagent.plugin")), Internal.BooleanList.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.protobuf.GeneratedMessage
    @Deprecated
    public FieldAccessorTable internalGetFieldAccessorTable() {
        throw new UnsupportedOperationException("Should be overridden in gencode.");
    }

    @Deprecated
    public Object newInstance(UnusedPrivateParameter r1) {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    @Override // com.google.protobuf.AbstractMessage
    @Deprecated
    public Message.Builder newBuilderForType(AbstractMessage.BuilderParent r3) {
        final AbstractMessage.BuilderParent r4 = (AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin");
        return newBuilderForType(new AnonymousClass1(this, r4));
    }
}
