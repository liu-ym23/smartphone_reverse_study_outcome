package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessageV3 extends AbstractMessage implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected UnknownFieldSet unknownFields;

    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessage.Builder<BuilderType> {
        private BuilderParent builderParent;
        private boolean isClean;
        private Builder<BuilderType>.BuilderParentImpl meAsParent;
        private UnknownFieldSet unknownFields;

        public class BuilderParentImpl implements BuilderParent {
            final /* synthetic */ Builder this$0;

            private BuilderParentImpl(Builder r10) {
                this.this$0 = r10;
            }

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                this.this$0.onChanged();
            }

            public /* synthetic */ BuilderParentImpl(Builder r10, AnonymousClass1 r11) {
                this(r10);
            }
        }

        public Builder() {
            this(null);
        }

        public static /* synthetic */ Map access$900(Builder r10) {
            return r10.getAllFieldsMutable();
        }

        private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap r10 = new TreeMap();
            List<Descriptors.FieldDescriptor> r11 = FieldAccessorTable.access$000(internalGetFieldAccessorTable()).getFields();
            int r12 = 0;
        L4:
            if (r12 >= r11.size()) goto L21;
            Descriptors.FieldDescriptor r13 = r11.get(r12);
            Descriptors.OneofDescriptor r14 = r13.getContainingOneof();
            if (r14 == null) goto L12;
            r12 = r12 + (r14.getFieldCount() - 1);
            if (hasOneof(r14) == false) goto L20;
            r13 = getOneofFieldDescriptor(r14);
        L19:
            r10.put(r13, getField(r13));
        L20:
            r12 = r12 + 1;
            goto L4
        L12:
            if (r13.isRepeated() == false) goto L17;
            List r15 = (List) getField(r13);
            if (r15.isEmpty() == true) goto L20;
            r10.put(r13, r15);
            goto L20
        L17:
            if (hasField(r13) == true) goto L19;
        L21:
            return r10;
        }

        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        public void dispose() {
            this.builderParent = null;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return FieldAccessorTable.access$000(internalGetFieldAccessorTable());
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r10) {
            Object r11 = FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).get(this);
            if (r10.isRepeated() == true) goto L5;
            return r11;
        L5:
            return Collections.unmodifiableList((List) r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r10) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getBuilder(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
            return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r10).get(this);
        }

        public BuilderParent getParentForChildren() {
            if (this.meAsParent != null) goto L6;
            this.meAsParent = new BuilderParentImpl(this, null);
        L6:
            return this.meAsParent;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRepeated(this, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r10, int r11) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRepeatedBuilder(this, r11);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRepeatedCount(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).has(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r10) {
            return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r10).has(this);
        }

        public abstract FieldAccessorTable internalGetFieldAccessorTable();

        public MapField internalGetMapField(int r10) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        public MapField internalGetMutableMapField(int r10) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        public boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            Iterator<Descriptors.FieldDescriptor> r10 = getDescriptorForType().getFields().iterator();
        L4:
            if (r10.hasNext() == false) goto L25;
            Descriptors.FieldDescriptor r11 = r10.next();
            if (r11.isRequired() == false) goto L11;
            if (hasField(r11) == true) goto L11;
            return false;
        L11:
            if (r11.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
            if (r11.isRepeated() == true) goto L14;
            if (hasField(r11) == false) goto L4;
            if (((Message) getField(r11)).isInitialized() == true) goto L4;
            return false;
        L14:
            Iterator r12 = ((List) getField(r11)).iterator();
        L16:
            if (r12.hasNext() == false) goto L4;
            if (((Message) r12.next()).isInitialized() == true) goto L16;
            return false;
        L25:
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        public void markClean() {
            this.isClean = true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r10) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).newBuilder();
        }

        public void onBuilt() {
            if (this.builderParent == null) goto L6;
            markClean();
            return;
        }

        public final void onChanged() {
            if (this.isClean == false) goto L8;
            BuilderParent r10 = this.builderParent;
            if (r10 == null) goto L9;
            r10.markDirty();
            this.isClean = false;
            return;
        L9:
            return;
        }

        public boolean parseUnknownField(CodedInputStream r10, UnknownFieldSet.Builder r11, ExtensionRegistryLite r12, int r13) throws IOException {
            return r11.mergeFieldFrom(r13, r10);
        }

        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r10) {
            return setUnknownFields(r10);
        }

        public Builder(BuilderParent r10) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.builderParent = r10;
        }

        public BuilderType addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).addRepeated(this, r11);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        public BuilderType clearField(Descriptors.FieldDescriptor r10) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).clear(this);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        public BuilderType setField(Descriptors.FieldDescriptor r10, Object r11) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).set(this, r11);
            return this;
        }

        public BuilderType setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).setRepeated(this, r11, r12);
            return this;
        }

        public BuilderType setUnknownFields(UnknownFieldSet r10) {
            this.unknownFields = r10;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType clearOneof(Descriptors.OneofDescriptor r10) {
            FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r10).clear(this);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeUnknownFields(UnknownFieldSet r10) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(r10).build();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            BuilderType r10 = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            r10.mergeFrom(buildPartial());
            return r10;
        }
    }

    public interface BuilderParent extends AbstractMessage.BuilderParent {
    }

    public static abstract class CachedDescriptorRetriever implements ExtensionDescriptorRetriever {
        private volatile Descriptors.FieldDescriptor descriptor;

        private CachedDescriptorRetriever() {
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtensionDescriptorRetriever
        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptor != null) goto L15;
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L6:
            if (this.descriptor != null) goto L10;
            this.descriptor = loadDescriptor();     // Catch: Throwable -> L8
        L10:
            monitor-exit(this);     // Catch: Throwable -> L8
        L15:
            return this.descriptor;
        }

        public abstract Descriptors.FieldDescriptor loadDescriptor();
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<Descriptors.FieldDescriptor> extensions;

        public ExtendableBuilder() {
            this.extensions = FieldSet.emptySet();
        }

        public static /* synthetic */ FieldSet access$400(ExtendableBuilder r10) {
            return r10.buildExtensions();
        }

        private FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions.isImmutable() == false) goto L6;
            this.extensions = this.extensions.clone();
            return;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r10) {
            if (r10.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyExtensionContainingType(Extension<MessageType, ?> r10) {
            if (r10.getDescriptor().getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Extension is for type \"" + r10.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> r10, Type r11) {
            Extension<MessageType, ?> r12 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r12);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r13 = r12.getDescriptor();
            this.extensions.addRepeatedField(r13, r12.singularToReflectionType(r11));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public final <Type> BuilderType clearExtension(ExtensionLite<MessageType, ?> r10) {
            Extension<MessageType, ?> r11 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r11);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r11.getDescriptor());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map r10 = Builder.access$900(this);
            r10.putAll(this.extensions.getAllFields());
            return Collections.unmodifiableMap(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r10) {
            Extension<MessageType, ?> r11 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r11);
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            Object r13 = this.extensions.getField(r12);
            if (r13 != null) goto L15;
            if (r12.isRepeated() == false) goto L9;
            return (Type) Collections.emptyList();
        L9:
            if (r12.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L13;
            return (Type) r11.getMessageDefaultInstance();
        L13:
            return (Type) r11.fromReflectionType(r12.getDefaultValue());
        L15:
            return (Type) r11.fromReflectionType(r13);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r10) {
            Extension<MessageType, ?> r11 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r11);
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            return this.extensions.getRepeatedFieldCount(r12);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L13;
            verifyContainingType(r10);
            Object r11 = this.extensions.getField(r10);
            if (r11 == null) goto L7;
            return r11;
        L7:
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
            return DynamicMessage.getDefaultInstance(r10.getMessageType());
        L11:
            return r10.getDefaultValue();
        L13:
            return super.getField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            return this.extensions.getRepeatedField(r10, r11);
        L7:
            return super.getRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            return this.extensions.getRepeatedFieldCount(r10);
        L7:
            return super.getRepeatedFieldCount(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r10) {
            Extension<MessageType, ?> r11 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r11);
            return this.extensions.hasField(r11.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            return this.extensions.hasField(r10);
        L7:
            return super.hasField(r10);
        }

        public void internalSetExtensionSet(FieldSet<Descriptors.FieldDescriptor> r10) {
            this.extensions = r10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            if (super.isInitialized() == true) goto L5;
        L7:
            return false;
        L5:
            if (extensionsAreInitialized() == false) goto L7;
            return true;
        }

        public final void mergeExtensionFields(ExtendableMessage r10) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(ExtendableMessage.access$600(r10));
            onChanged();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public boolean parseUnknownField(CodedInputStream r10, UnknownFieldSet.Builder r11, ExtensionRegistryLite r12, int r13) throws IOException {
            return MessageReflection.mergeFieldFrom(r10, r11, r12, getDescriptorForType(), new MessageReflection.BuilderAdapter(this), r13);
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> r10, Type r11) {
            Extension<MessageType, ?> r12 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r12);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r13 = r12.getDescriptor();
            this.extensions.setField(r13, r12.toReflectionType(r11));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        public ExtendableBuilder(BuilderParent r10) {
            super(r10);
            this.extensions = FieldSet.emptySet();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(r10, r11);
            onChanged();
            return this;
        L7:
            return (BuilderType) super.addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public BuilderType clearField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r10);
            onChanged();
            return this;
        L7:
            return (BuilderType) super.clearField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public BuilderType setField(Descriptors.FieldDescriptor r10, Object r11) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            ensureExtensionsIsMutable();
            this.extensions.setField(r10, r11);
            onChanged();
            return this;
        L7:
            return (BuilderType) super.setField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public BuilderType setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(r10, r11, r12);
            onChanged();
            return this;
        L7:
            return (BuilderType) super.setRepeatedField(r10, r11, r12);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(Extension<MessageType, Type> r10) {
            return hasExtension(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.extensions = FieldSet.emptySet();
            return (BuilderType) super.clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> r10) {
            return getExtensionCount(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> r10) {
            return hasExtension(r10);
        }

        public final <Type> BuilderType clearExtension(Extension<MessageType, ?> r10) {
            return (BuilderType) clearExtension(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> r10) {
            return getExtensionCount(r10);
        }

        public <Type> BuilderType clearExtension(GeneratedMessage.GeneratedExtension<MessageType, ?> r10) {
            return (BuilderType) clearExtension(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            return (BuilderType) super.clone();
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> r10, int r11, Type r12) {
            Extension<MessageType, ?> r13 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r13);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r14 = r13.getDescriptor();
            this.extensions.setRepeatedField(r14, r11, r13.singularToReflectionType(r12));
            onChanged();
            return this;
        }

        public final <Type> BuilderType addExtension(Extension<MessageType, List<Type>> r10, Type r11) {
            return (BuilderType) addExtension(r10, r11);
        }

        public <Type> BuilderType addExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> r10, Type r11) {
            return (BuilderType) addExtension(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r10, int r11) {
            Extension<MessageType, ?> r12 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r12);
            Descriptors.FieldDescriptor r13 = r12.getDescriptor();
            return (Type) r12.singularFromReflectionType(this.extensions.getRepeatedField(r13, r11));
        }

        public final <Type> BuilderType setExtension(Extension<MessageType, Type> r10, Type r11) {
            return (BuilderType) setExtension(r10, r11);
        }

        public <Type> BuilderType setExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> r10, Type r11) {
            return (BuilderType) setExtension(r10, r11);
        }

        public final <Type> BuilderType setExtension(Extension<MessageType, List<Type>> r10, int r11, Type r12) {
            return (BuilderType) setExtension(r10, r11, r12);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, Type> r10) {
            return (Type) getExtension(r10);
        }

        public <Type> BuilderType setExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> r10, int r11, Type r12) {
            return (BuilderType) setExtension(r10, r11, r12);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> r10) {
            return (Type) getExtension(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, List<Type>> r10, int r11) {
            return (Type) getExtension(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> r10, int r11) {
            return (Type) getExtension(r10, r11);
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessageV3 implements ExtendableMessageOrBuilder<MessageType> {
        private static final long serialVersionUID = 1;
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        public class ExtensionWriter {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            public /* synthetic */ ExtensionWriter(ExtendableMessage r10, boolean r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            public void writeUntil(int r10, CodedOutputStream r11) throws IOException {
            L2:
                Map.Entry<Descriptors.FieldDescriptor, Object> r12 = this.next;
                if (r12 == null) goto L21;
                if (r12.getKey().getNumber() >= r10) goto L29;
                Descriptors.FieldDescriptor r13 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L16:
                FieldSet.writeField(r13, this.next.getValue(), r11);
            L18:
                if (this.iter.hasNext() == true) goto L19;
                this.next = null;
                goto L2
            L19:
                this.next = this.iter.next();
                goto L2
            L9:
                if (r13.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L16;
                if (r13.isRepeated() == true) goto L16;
                if ((this.next instanceof LazyField.LazyEntry) == false) goto L15;
                r11.writeRawMessageSetExtension(r13.getNumber(), ((LazyField.LazyEntry) this.next).getField().toByteString());
                goto L18
            L15:
                r11.writeMessageSetExtension(r13.getNumber(), (Message) this.next.getValue());
                goto L18
            L29:
                return;
            }

            private ExtensionWriter(ExtendableMessage r10, boolean r11) {
                this.this$0 = r10;
                Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r12 = ExtendableMessage.access$600(r10).iterator();
                this.iter = r12;
                if (r12.hasNext() == false) goto L5;
                this.next = r12.next();
            L5:
                this.messageSetWireFormat = r11;
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        public static /* synthetic */ FieldSet access$600(ExtendableMessage r10) {
            return r10.extensions;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r10) {
            if (r10.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyExtensionContainingType(Extension<MessageType, ?> r10) {
            if (r10.getDescriptor().getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Extension is for type \"" + r10.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map r10 = GeneratedMessageV3.access$800(this, false);
            r10.putAll(getExtensionFields());
            return Collections.unmodifiableMap(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map r10 = GeneratedMessageV3.access$800(this, false);
            r10.putAll(getExtensionFields());
            return Collections.unmodifiableMap(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r10) {
            Extension<MessageType, ?> r11 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r11);
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            Object r13 = this.extensions.getField(r12);
            if (r13 != null) goto L15;
            if (r12.isRepeated() == false) goto L9;
            return (Type) Collections.emptyList();
        L9:
            if (r12.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L13;
            return (Type) r11.getMessageDefaultInstance();
        L13:
            return (Type) r11.fromReflectionType(r12.getDefaultValue());
        L15:
            return (Type) r11.fromReflectionType(r13);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r10) {
            Extension<MessageType, ?> r11 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r11);
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            return this.extensions.getRepeatedFieldCount(r12);
        }

        public Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L17;
            verifyContainingType(r10);
            Object r11 = this.extensions.getField(r10);
            if (r11 == null) goto L7;
            return r11;
        L7:
            if (r10.isRepeated() == false) goto L11;
            return Collections.emptyList();
        L11:
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L15;
            return DynamicMessage.getDefaultInstance(r10.getMessageType());
        L15:
            return r10.getDefaultValue();
        L17:
            return super.getField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            return this.extensions.getRepeatedField(r10, r11);
        L7:
            return super.getRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            return this.extensions.getRepeatedFieldCount(r10);
        L7:
            return super.getRepeatedFieldCount(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r10) {
            Extension<MessageType, ?> r11 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r11);
            return this.extensions.hasField(r11.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            return this.extensions.hasField(r10);
        L7:
            return super.hasField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            if (super.isInitialized() == true) goto L5;
        L7:
            return false;
        L5:
            if (extensionsAreInitialized() == false) goto L7;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public boolean parseUnknownField(CodedInputStream r10, UnknownFieldSet.Builder r11, ExtensionRegistryLite r12, int r13) throws IOException {
            return MessageReflection.mergeFieldFrom(r10, r11, r12, getDescriptorForType(), new MessageReflection.ExtensionAdapter(this.extensions), r13);
        }

        public ExtendableMessage(ExtendableBuilder<MessageType, ?> r10) {
            super(r10);
            this.extensions = ExtendableBuilder.access$400(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(Extension<MessageType, Type> r10) {
            return hasExtension(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> r10) {
            return getExtensionCount(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> r10) {
            return hasExtension(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> r10) {
            return getExtensionCount(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r10, int r11) {
            Extension<MessageType, ?> r12 = GeneratedMessageV3.access$500(r10);
            verifyExtensionContainingType(r12);
            Descriptors.FieldDescriptor r13 = r12.getDescriptor();
            return (Type) r12.singularFromReflectionType(this.extensions.getRepeatedField(r13, r11));
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, Type> r10) {
            return (Type) getExtension(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> r10) {
            return (Type) getExtension(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, List<Type>> r10, int r11) {
            return (Type) getExtension(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> r10, int r11) {
            return (Type) getExtension(r10, r11);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageOrBuilder {
        @Override // com.google.protobuf.MessageOrBuilder
        Message getDefaultInstanceForType();

        <Type> Type getExtension(Extension<MessageType, Type> r10);

        <Type> Type getExtension(Extension<MessageType, List<Type>> r10, int r11);

        <Type> Type getExtension(ExtensionLite<MessageType, Type> r10);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r10, int r11);

        <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> r10);

        <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> r10, int r11);

        <Type> int getExtensionCount(Extension<MessageType, List<Type>> r10);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r10);

        <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> r10);

        <Type> boolean hasExtension(Extension<MessageType, Type> r10);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r10);

        <Type> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> r10);
    }

    public interface ExtensionDescriptorRetriever {
        Descriptors.FieldDescriptor getDescriptor();
    }

    public static final class FieldAccessorTable {
        private String[] camelCaseNames;
        private final Descriptors.Descriptor descriptor;
        private final FieldAccessor[] fields;
        private volatile boolean initialized;
        private final OneofAccessor[] oneofs;

        public interface FieldAccessor {
            void addRepeated(Builder r10, Object r11);

            void clear(Builder r10);

            Object get(Builder r10);

            Object get(GeneratedMessageV3 r10);

            Message.Builder getBuilder(Builder r10);

            Object getRaw(Builder r10);

            Object getRaw(GeneratedMessageV3 r10);

            Object getRepeated(Builder r10, int r11);

            Object getRepeated(GeneratedMessageV3 r10, int r11);

            Message.Builder getRepeatedBuilder(Builder r10, int r11);

            int getRepeatedCount(Builder r10);

            int getRepeatedCount(GeneratedMessageV3 r10);

            Object getRepeatedRaw(Builder r10, int r11);

            Object getRepeatedRaw(GeneratedMessageV3 r10, int r11);

            boolean has(Builder r10);

            boolean has(GeneratedMessageV3 r10);

            Message.Builder newBuilder();

            void set(Builder r10, Object r11);

            void setRepeated(Builder r10, int r11, Object r12);
        }

        public static class MapFieldAccessor implements FieldAccessor {
            private final Descriptors.FieldDescriptor field;
            private final Message mapEntryMessageDefaultInstance;

            public MapFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13) {
                this.field = r10;
                this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessageV3) GeneratedMessageV3.access$1100(GeneratedMessageV3.access$1000(r12, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
            }

            private MapField<?, ?> getMapField(GeneratedMessageV3 r10) {
                return r10.internalGetMapField(this.field.getNumber());
            }

            private MapField<?, ?> getMutableMapField(Builder r10) {
                return r10.internalGetMutableMapField(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder r10, Object r11) {
                getMutableMapField(r10).getMutableList().add((Message) r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void clear(Builder r10) {
                getMutableMapField(r10).getMutableList().clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessageV3 r10) {
                ArrayList r11 = new ArrayList();
                int r12 = 0;
            L4:
                if (r12 >= getRepeatedCount(r10)) goto L7;
                r11.add(getRepeated(r10, r12));
                r12 = r12 + 1;
                goto L4
            L7:
                return Collections.unmodifiableList(r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder r10) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessageV3 r10) {
                return get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessageV3 r10, int r11) {
                return getMapField(r10).getList().get(r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder r10, int r11) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessageV3 r10) {
                return getMapField(r10).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(GeneratedMessageV3 r10, int r11) {
                return getRepeated(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessageV3 r10) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(Builder r10, Object r11) {
                clear(r10);
                Iterator r12 = ((List) r11).iterator();
            L4:
                if (r12.hasNext() == false) goto L6;
                addRepeated(r10, r12.next());
                goto L4
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder r10, int r11, Object r12) {
                getMutableMapField(r10).getMutableList().set(r11, (Message) r12);
            }

            private MapField<?, ?> getMapField(Builder r10) {
                return r10.internalGetMapField(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder r10) {
                return get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder r10, int r11) {
                return getMapField(r10).getList().get(r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder r10) {
                return getMapField(r10).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(Builder r10, int r11) {
                return getRepeated(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(Builder r10) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object get(Builder r10) {
                ArrayList r11 = new ArrayList();
                int r12 = 0;
            L4:
                if (r12 >= getRepeatedCount(r10)) goto L7;
                r11.add(getRepeated(r10, r12));
                r12 = r12 + 1;
                goto L4
            L7:
                return Collections.unmodifiableList(r11);
            }
        }

        public static class OneofAccessor {
            private final java.lang.reflect.Method caseMethod;
            private final java.lang.reflect.Method caseMethodBuilder;
            private final java.lang.reflect.Method clearMethod;
            private final Descriptors.Descriptor descriptor;

            public OneofAccessor(Descriptors.Descriptor r10, String r11, Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13) {
                this.descriptor = r10;
                this.caseMethod = GeneratedMessageV3.access$1000(r12, "get" + r11 + "Case", new Class[0]);
                this.caseMethodBuilder = GeneratedMessageV3.access$1000(r13, "get" + r11 + "Case", new Class[0]);
                StringBuilder r14 = new StringBuilder();
                r14.append("clear");
                r14.append(r11);
                this.clearMethod = GeneratedMessageV3.access$1000(r13, r14.toString(), new Class[0]);
            }

            public void clear(Builder r10) {
                GeneratedMessageV3.access$1100(this.clearMethod, r10, new Object[0]);
            }

            public Descriptors.FieldDescriptor get(GeneratedMessageV3 r10) {
                int r11 = ((Internal.EnumLite) GeneratedMessageV3.access$1100(this.caseMethod, r10, new Object[0])).getNumber();
                if (r11 > 0) goto L5;
                return null;
            L5:
                return this.descriptor.findFieldByNumber(r11);
            }

            public boolean has(GeneratedMessageV3 r10) {
                if (((Internal.EnumLite) GeneratedMessageV3.access$1100(this.caseMethod, r10, new Object[0])).getNumber() != 0) goto L5;
                return false;
            L5:
                return true;
            }

            public boolean has(Builder r10) {
                if (((Internal.EnumLite) GeneratedMessageV3.access$1100(this.caseMethodBuilder, r10, new Object[0])).getNumber() != 0) goto L5;
                return false;
            L5:
                return true;
            }

            public Descriptors.FieldDescriptor get(Builder r10) {
                int r11 = ((Internal.EnumLite) GeneratedMessageV3.access$1100(this.caseMethodBuilder, r10, new Object[0])).getNumber();
                if (r11 > 0) goto L5;
                return null;
            L5:
                return this.descriptor.findFieldByNumber(r11);
            }
        }

        public static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private java.lang.reflect.Method addRepeatedValueMethod;
            private Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getRepeatedValueMethod;
            private java.lang.reflect.Method getRepeatedValueMethodBuilder;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method setRepeatedValueMethod;
            private boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            public RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13) {
                super(r10, r11, r12, r13);
                this.enumDescriptor = r10.getEnumType();
                this.valueOfMethod = GeneratedMessageV3.access$1000(this.type, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
                this.getValueDescriptorMethod = GeneratedMessageV3.access$1000(this.type, "getValueDescriptor", new Class[0]);
                boolean r14 = r10.getFile().supportsUnknownEnumValue();
                this.supportUnknownEnumValue = r14;
                if (r14 == false) goto L6;
                Class r15 = Integer.TYPE;
                this.getRepeatedValueMethod = GeneratedMessageV3.access$1000(r12, "get" + r11 + "Value", new Class[]{r15});
                this.getRepeatedValueMethodBuilder = GeneratedMessageV3.access$1000(r13, "get" + r11 + "Value", new Class[]{r15});
                this.setRepeatedValueMethod = GeneratedMessageV3.access$1000(r13, "set" + r11 + "Value", new Class[]{r15, r15});
                this.addRepeatedValueMethod = GeneratedMessageV3.access$1000(r13, "add" + r11 + "Value", new Class[]{r15});
                return;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder r10, Object r11) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessageV3.access$1100(this.addRepeatedValueMethod, r10, new Object[]{Integer.valueOf(((Descriptors.EnumValueDescriptor) r11).getNumber())});
                return;
            L6:
                super.addRepeated(r10, GeneratedMessageV3.access$1100(this.valueOfMethod, null, new Object[]{r11}));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessageV3 r10) {
                ArrayList r11 = new ArrayList();
                int r12 = getRepeatedCount(r10);
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L6;
                r11.add(getRepeated(r10, r13));
                r13 = r13 + 1;
                goto L3
            L6:
                return Collections.unmodifiableList(r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessageV3 r10, int r11) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r12 = ((Integer) GeneratedMessageV3.access$1100(this.getRepeatedValueMethod, r10, new Object[]{Integer.valueOf(r11)})).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r12);
            L7:
                return GeneratedMessageV3.access$1100(this.getValueDescriptorMethod, super.getRepeated(r10, r11), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder r10, int r11, Object r12) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessageV3.access$1100(this.setRepeatedValueMethod, r10, new Object[]{Integer.valueOf(r11), Integer.valueOf(((Descriptors.EnumValueDescriptor) r12).getNumber())});
                return;
            L6:
                super.setRepeated(r10, r11, GeneratedMessageV3.access$1100(this.valueOfMethod, null, new Object[]{r12}));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object get(Builder r10) {
                ArrayList r11 = new ArrayList();
                int r12 = getRepeatedCount(r10);
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L6;
                r11.add(getRepeated(r10, r13));
                r13 = r13 + 1;
                goto L3
            L6:
                return Collections.unmodifiableList(r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder r10, int r11) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r12 = ((Integer) GeneratedMessageV3.access$1100(this.getRepeatedValueMethodBuilder, r10, new Object[]{Integer.valueOf(r11)})).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r12);
            L7:
                return GeneratedMessageV3.access$1100(this.getValueDescriptorMethod, super.getRepeated(r10, r11), new Object[0]);
            }
        }

        public static class RepeatedFieldAccessor implements FieldAccessor {
            protected final java.lang.reflect.Method addRepeatedMethod;
            protected final java.lang.reflect.Method clearMethod;
            protected final java.lang.reflect.Method getCountMethod;
            protected final java.lang.reflect.Method getCountMethodBuilder;
            protected final java.lang.reflect.Method getMethod;
            protected final java.lang.reflect.Method getMethodBuilder;
            protected final java.lang.reflect.Method getRepeatedMethod;
            protected final java.lang.reflect.Method getRepeatedMethodBuilder;
            protected final java.lang.reflect.Method setRepeatedMethod;
            protected final Class type;

            public RepeatedFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13) {
                this.getMethod = GeneratedMessageV3.access$1000(r12, "get" + r11 + "List", new Class[0]);
                this.getMethodBuilder = GeneratedMessageV3.access$1000(r13, "get" + r11 + "List", new Class[0]);
                StringBuilder r14 = new StringBuilder();
                r14.append("get");
                r14.append(r11);
                String r15 = r14.toString();
                Class r16 = Integer.TYPE;
                java.lang.reflect.Method r17 = GeneratedMessageV3.access$1000(r12, r15, new Class[]{r16});
                this.getRepeatedMethod = r17;
                this.getRepeatedMethodBuilder = GeneratedMessageV3.access$1000(r13, "get" + r11, new Class[]{r16});
                Class<?> r18 = r17.getReturnType();
                this.type = r18;
                this.setRepeatedMethod = GeneratedMessageV3.access$1000(r13, "set" + r11, new Class[]{r16, r18});
                this.addRepeatedMethod = GeneratedMessageV3.access$1000(r13, "add" + r11, new Class[]{r18});
                this.getCountMethod = GeneratedMessageV3.access$1000(r12, "get" + r11 + "Count", new Class[0]);
                this.getCountMethodBuilder = GeneratedMessageV3.access$1000(r13, "get" + r11 + "Count", new Class[0]);
                StringBuilder r19 = new StringBuilder();
                r19.append("clear");
                r19.append(r11);
                this.clearMethod = GeneratedMessageV3.access$1000(r13, r19.toString(), new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder r10, Object r11) {
                GeneratedMessageV3.access$1100(this.addRepeatedMethod, r10, new Object[]{r11});
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void clear(Builder r10) {
                GeneratedMessageV3.access$1100(this.clearMethod, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessageV3 r10) {
                return GeneratedMessageV3.access$1100(this.getMethod, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder r10) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessageV3 r10) {
                return get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessageV3 r10, int r11) {
                return GeneratedMessageV3.access$1100(this.getRepeatedMethod, r10, new Object[]{Integer.valueOf(r11)});
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder r10, int r11) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessageV3 r10) {
                return ((Integer) GeneratedMessageV3.access$1100(this.getCountMethod, r10, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(GeneratedMessageV3 r10, int r11) {
                return getRepeated(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessageV3 r10) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(Builder r10, Object r11) {
                clear(r10);
                Iterator r12 = ((List) r11).iterator();
            L4:
                if (r12.hasNext() == false) goto L6;
                addRepeated(r10, r12.next());
                goto L4
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder r10, int r11, Object r12) {
                GeneratedMessageV3.access$1100(this.setRepeatedMethod, r10, new Object[]{Integer.valueOf(r11), r12});
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object get(Builder r10) {
                return GeneratedMessageV3.access$1100(this.getMethodBuilder, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder r10) {
                return get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder r10, int r11) {
                return GeneratedMessageV3.access$1100(this.getRepeatedMethodBuilder, r10, new Object[]{Integer.valueOf(r11)});
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder r10) {
                return ((Integer) GeneratedMessageV3.access$1100(this.getCountMethodBuilder, r10, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(Builder r10, int r11) {
                return getRepeated(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(Builder r10) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }
        }

        public static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            public RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13) {
                super(r10, r11, r12, r13);
                this.newBuilderMethod = GeneratedMessageV3.access$1000(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessageV3.access$1000(r13, "get" + r11 + "Builder", new Class[]{Integer.TYPE});
            }

            private Object coerceType(Object r10) {
                if (this.type.isInstance(r10) == false) goto L6;
                return r10;
            L6:
                return ((Message.Builder) GeneratedMessageV3.access$1100(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) r10).build();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder r10, Object r11) {
                super.addRepeated(r10, coerceType(r11));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder r10, int r11) {
                return (Message.Builder) GeneratedMessageV3.access$1100(this.getBuilderMethodBuilder, r10, new Object[]{Integer.valueOf(r11)});
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessageV3.access$1100(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder r10, int r11, Object r12) {
                super.setRepeated(r10, r11, coerceType(r12));
            }
        }

        public static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method getValueMethod;
            private java.lang.reflect.Method getValueMethodBuilder;
            private java.lang.reflect.Method setValueMethod;
            private boolean supportUnknownEnumValue;
            private java.lang.reflect.Method valueOfMethod;

            public SingularEnumFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13, String r14) {
                super(r10, r11, r12, r13, r14);
                this.enumDescriptor = r10.getEnumType();
                this.valueOfMethod = GeneratedMessageV3.access$1000(this.type, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
                this.getValueDescriptorMethod = GeneratedMessageV3.access$1000(this.type, "getValueDescriptor", new Class[0]);
                boolean r15 = r10.getFile().supportsUnknownEnumValue();
                this.supportUnknownEnumValue = r15;
                if (r15 == false) goto L6;
                this.getValueMethod = GeneratedMessageV3.access$1000(r12, "get" + r11 + "Value", new Class[0]);
                this.getValueMethodBuilder = GeneratedMessageV3.access$1000(r13, "get" + r11 + "Value", new Class[0]);
                this.setValueMethod = GeneratedMessageV3.access$1000(r13, "set" + r11 + "Value", new Class[]{Integer.TYPE});
                return;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessageV3 r10) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r11 = ((Integer) GeneratedMessageV3.access$1100(this.getValueMethod, r10, new Object[0])).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r11);
            L7:
                return GeneratedMessageV3.access$1100(this.getValueDescriptorMethod, super.get(r10), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(Builder r10, Object r11) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessageV3.access$1100(this.setValueMethod, r10, new Object[]{Integer.valueOf(((Descriptors.EnumValueDescriptor) r11).getNumber())});
                return;
            L6:
                super.set(r10, GeneratedMessageV3.access$1100(this.valueOfMethod, null, new Object[]{r11}));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object get(Builder r10) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r11 = ((Integer) GeneratedMessageV3.access$1100(this.getValueMethodBuilder, r10, new Object[0])).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r11);
            L7:
                return GeneratedMessageV3.access$1100(this.getValueDescriptorMethod, super.get(r10), new Object[0]);
            }
        }

        public static class SingularFieldAccessor implements FieldAccessor {
            protected final java.lang.reflect.Method caseMethod;
            protected final java.lang.reflect.Method caseMethodBuilder;
            protected final java.lang.reflect.Method clearMethod;
            protected final Descriptors.FieldDescriptor field;
            protected final java.lang.reflect.Method getMethod;
            protected final java.lang.reflect.Method getMethodBuilder;
            protected final boolean hasHasMethod;
            protected final java.lang.reflect.Method hasMethod;
            protected final java.lang.reflect.Method hasMethodBuilder;
            protected final boolean isOneofField;
            protected final java.lang.reflect.Method setMethod;
            protected final Class<?> type;

            public SingularFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13, String r14) {
                this.field = r10;
                boolean r15 = true;
                if (r10.getContainingOneof() == null) goto L5;
                boolean r16 = true;
            L6:
                this.isOneofField = r16;
                if (FieldAccessorTable.access$1200(r10.getFile()) == true) goto L13;
                if (r16 == false) goto L10;
            L12:
                r15 = false;
                goto L13
            L10:
                if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L12;
            L13:
                this.hasHasMethod = r15;
                java.lang.reflect.Method r17 = GeneratedMessageV3.access$1000(r12, "get" + r11, new Class[0]);
                this.getMethod = r17;
                this.getMethodBuilder = GeneratedMessageV3.access$1000(r13, "get" + r11, new Class[0]);
                Class<?> r18 = r17.getReturnType();
                this.type = r18;
                this.setMethod = GeneratedMessageV3.access$1000(r13, "set" + r11, new Class[]{r18});
                java.lang.reflect.Method r19 = null;
                if (r15 == false) goto L16;
                java.lang.reflect.Method r20 = GeneratedMessageV3.access$1000(r12, "has" + r11, new Class[0]);
            L17:
                this.hasMethod = r20;
                if (r15 == false) goto L20;
                java.lang.reflect.Method r21 = GeneratedMessageV3.access$1000(r13, "has" + r11, new Class[0]);
            L21:
                this.hasMethodBuilder = r21;
                this.clearMethod = GeneratedMessageV3.access$1000(r13, "clear" + r11, new Class[0]);
                if (r16 == false) goto L24;
                java.lang.reflect.Method r22 = GeneratedMessageV3.access$1000(r12, "get" + r14 + "Case", new Class[0]);
            L25:
                this.caseMethod = r22;
                if (r16 == false) goto L28;
                r19 = GeneratedMessageV3.access$1000(r13, "get" + r14 + "Case", new Class[0]);
            L28:
                this.caseMethodBuilder = r19;
                return;
            L24:
                r22 = null;
                goto L25
            L20:
                r21 = null;
                goto L21
            L16:
                r20 = null;
                goto L17
            L5:
                r16 = false;
                goto L6
            }

            private int getOneofFieldNumber(GeneratedMessageV3 r10) {
                return ((Internal.EnumLite) GeneratedMessageV3.access$1100(this.caseMethod, r10, new Object[0])).getNumber();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder r10, Object r11) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void clear(Builder r10) {
                GeneratedMessageV3.access$1100(this.clearMethod, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessageV3 r10) {
                return GeneratedMessageV3.access$1100(this.getMethod, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder r10) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessageV3 r10) {
                return get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessageV3 r10, int r11) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder r10, int r11) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessageV3 r10) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(GeneratedMessageV3 r10, int r11) {
                throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessageV3 r10) {
                if (this.hasHasMethod == true) goto L13;
                if (this.isOneofField == false) goto L11;
                if (getOneofFieldNumber(r10) == this.field.getNumber()) goto L9;
                return false;
            L9:
                return true;
            L11:
                return !get(r10).equals(this.field.getDefaultValue());
            L13:
                return ((Boolean) GeneratedMessageV3.access$1100(this.hasMethod, r10, new Object[0])).booleanValue();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(Builder r10, Object r11) {
                GeneratedMessageV3.access$1100(this.setMethod, r10, new Object[]{r11});
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder r10, int r11, Object r12) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            private int getOneofFieldNumber(Builder r10) {
                return ((Internal.EnumLite) GeneratedMessageV3.access$1100(this.caseMethodBuilder, r10, new Object[0])).getNumber();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object get(Builder r10) {
                return GeneratedMessageV3.access$1100(this.getMethodBuilder, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder r10) {
                return get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder r10, int r11) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder r10) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(Builder r10, int r11) {
                throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public boolean has(Builder r10) {
                if (this.hasHasMethod == true) goto L13;
                if (this.isOneofField == false) goto L11;
                if (getOneofFieldNumber(r10) == this.field.getNumber()) goto L9;
                return false;
            L9:
                return true;
            L11:
                return !get(r10).equals(this.field.getDefaultValue());
            L13:
                return ((Boolean) GeneratedMessageV3.access$1100(this.hasMethodBuilder, r10, new Object[0])).booleanValue();
            }
        }

        public static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            public SingularMessageFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13, String r14) {
                super(r10, r11, r12, r13, r14);
                this.newBuilderMethod = GeneratedMessageV3.access$1000(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessageV3.access$1000(r13, "get" + r11 + "Builder", new Class[0]);
            }

            private Object coerceType(Object r10) {
                if (this.type.isInstance(r10) == false) goto L6;
                return r10;
            L6:
                return ((Message.Builder) GeneratedMessageV3.access$1100(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) r10).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder r10) {
                return (Message.Builder) GeneratedMessageV3.access$1100(this.getBuilderMethodBuilder, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessageV3.access$1100(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(Builder r10, Object r11) {
                super.set(r10, coerceType(r11));
            }
        }

        public static final class SingularStringFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBytesMethod;
            private final java.lang.reflect.Method getBytesMethodBuilder;
            private final java.lang.reflect.Method setBytesMethodBuilder;

            public SingularStringFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13, String r14) {
                super(r10, r11, r12, r13, r14);
                this.getBytesMethod = GeneratedMessageV3.access$1000(r12, "get" + r11 + "Bytes", new Class[0]);
                this.getBytesMethodBuilder = GeneratedMessageV3.access$1000(r13, "get" + r11 + "Bytes", new Class[0]);
                this.setBytesMethodBuilder = GeneratedMessageV3.access$1000(r13, "set" + r11 + "Bytes", new Class[]{ByteString.class});
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessageV3 r10) {
                return GeneratedMessageV3.access$1100(this.getBytesMethod, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public void set(Builder r10, Object r11) {
                if ((r11 instanceof ByteString) == false) goto L5;
                GeneratedMessageV3.access$1100(this.setBytesMethodBuilder, r10, new Object[]{r11});
                return;
            L5:
                super.set(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder r10) {
                return GeneratedMessageV3.access$1100(this.getBytesMethodBuilder, r10, new Object[0]);
            }
        }

        public FieldAccessorTable(Descriptors.Descriptor r10, String[] r11, Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13) {
            this(r10, r11);
            ensureFieldAccessorsInitialized(r12, r13);
        }

        public static /* synthetic */ Descriptors.Descriptor access$000(FieldAccessorTable r10) {
            return r10.descriptor;
        }

        public static /* synthetic */ OneofAccessor access$100(FieldAccessorTable r10, Descriptors.OneofDescriptor r11) {
            return r10.getOneof(r11);
        }

        public static /* synthetic */ boolean access$1200(Descriptors.FileDescriptor r10) {
            return supportFieldPresence(r10);
        }

        public static /* synthetic */ FieldAccessor access$200(FieldAccessorTable r10, Descriptors.FieldDescriptor r11) {
            return r10.getField(r11);
        }

        private FieldAccessor getField(Descriptors.FieldDescriptor r10) {
            if (r10.getContainingType() != this.descriptor) goto L11;
            if (r10.isExtension() == true) goto L9;
            return this.fields[r10.getIndex()];
        L9:
            throw new IllegalArgumentException("This type does not have extensions.");
        L11:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private OneofAccessor getOneof(Descriptors.OneofDescriptor r10) {
            if (r10.getContainingType() != this.descriptor) goto L7;
            return this.oneofs[r10.getIndex()];
        L7:
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        private boolean isMapFieldEnabled(Descriptors.FieldDescriptor r10) {
            return true;
        }

        private static boolean supportFieldPresence(Descriptors.FileDescriptor r10) {
            if (r10.getSyntax() != Descriptors.FileDescriptor.Syntax.PROTO2) goto L5;
            return true;
        L5:
            return false;
        }

        public FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessageV3> r12, Class<? extends Builder> r13) {
            if (this.initialized == false) goto L5;
            return this;
        L5:
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L7:
            if (this.initialized == false) goto L12;
            monitor-exit(this);     // Catch: Throwable -> L10
            return this;
        L12:
            int r10 = this.fields.length;     // Catch: Throwable -> L10
            int r11 = 0;
            int r14 = 0;
        L13:
            String r15 = null;
            if (r14 >= r10) goto L43;
            Descriptors.FieldDescriptor r16 = this.descriptor.getFields().get(r14);     // Catch: Throwable -> L10
            if (r16.getContainingOneof() == null) goto L18;
            r15 = this.camelCaseNames[r16.getContainingOneof().getIndex() + r10];     // Catch: Throwable -> L10
        L18:
            String r17 = r15;
            if (r16.isRepeated() == false) goto L33;
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L29;
            if (r16.isMapField() == true) goto L25;
        L27:
            this.fields[r14] = new RepeatedMessageFieldAccessor(r16, this.camelCaseNames[r14], r12, r13);     // Catch: Throwable -> L10
        L42:
            r14 = r14 + 1;     // Catch: Throwable -> L10
            goto L13
        L25:
            if (isMapFieldEnabled(r16) == false) goto L27;
            this.fields[r14] = new MapFieldAccessor(r16, this.camelCaseNames[r14], r12, r13);     // Catch: Throwable -> L10
            goto L42
        L29:
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L31;
            this.fields[r14] = new RepeatedEnumFieldAccessor(r16, this.camelCaseNames[r14], r12, r13);     // Catch: Throwable -> L10
            goto L42
        L31:
            this.fields[r14] = new RepeatedFieldAccessor(r16, this.camelCaseNames[r14], r12, r13);     // Catch: Throwable -> L10
            goto L42
        L33:
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L36;
            this.fields[r14] = new SingularMessageFieldAccessor(r16, this.camelCaseNames[r14], r12, r13, r17);     // Catch: Throwable -> L10
            goto L42
        L36:
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L39;
            this.fields[r14] = new SingularEnumFieldAccessor(r16, this.camelCaseNames[r14], r12, r13, r17);     // Catch: Throwable -> L10
            goto L42
        L39:
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) goto L41;
            this.fields[r14] = new SingularStringFieldAccessor(r16, this.camelCaseNames[r14], r12, r13, r17);     // Catch: Throwable -> L10
            goto L42
        L41:
            this.fields[r14] = new SingularFieldAccessor(r16, this.camelCaseNames[r14], r12, r13, r17);     // Catch: Throwable -> L10
            goto L42
        L43:
            int r18 = this.oneofs.length;     // Catch: Throwable -> L10
        L44:
            if (r11 >= r18) goto L46;
            this.oneofs[r11] = new OneofAccessor(this.descriptor, this.camelCaseNames[r11 + r10], r12, r13);     // Catch: Throwable -> L10
            r11 = r11 + 1;     // Catch: Throwable -> L10
            goto L44
        L46:
            this.initialized = true;     // Catch: Throwable -> L10
            this.camelCaseNames = null;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return this;
        }

        public FieldAccessorTable(Descriptors.Descriptor r10, String[] r11) {
            this.descriptor = r10;
            this.camelCaseNames = r11;
            this.fields = new FieldAccessor[r10.getFields().size()];
            this.oneofs = new OneofAccessor[r10.getOneofs().size()];
            this.initialized = false;
        }
    }

    static {
    }

    public GeneratedMessageV3() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    public static /* synthetic */ java.lang.reflect.Method access$1000(Class r10, String r11, Class[] r12) {
        return getMethodOrDie(r10, r11, r12);
    }

    public static /* synthetic */ Object access$1100(java.lang.reflect.Method r10, Object r11, Object[] r12) {
        return invokeOrDie(r10, r11, r12);
    }

    public static /* synthetic */ Extension access$500(ExtensionLite r10) {
        return checkNotLite(r10);
    }

    public static /* synthetic */ Map access$800(GeneratedMessageV3 r10, boolean r11) {
        return r10.getAllFieldsMutable(r11);
    }

    private static <MessageType extends ExtendableMessage<MessageType>, T> Extension<MessageType, T> checkNotLite(ExtensionLite<MessageType, T> r10) {
        if (r10.isLite() == true) goto L7;
        return (Extension) r10;
    L7:
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    public static int computeStringSize(int r10, Object r11) {
        if ((r11 instanceof String) == false) goto L7;
        return CodedOutputStream.computeStringSize(r10, (String) r11);
    L7:
        return CodedOutputStream.computeBytesSize(r10, (ByteString) r11);
    }

    public static int computeStringSizeNoTag(Object r10) {
        if ((r10 instanceof String) == false) goto L7;
        return CodedOutputStream.computeStringSizeNoTag((String) r10);
    L7:
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r10);
    }

    public static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean r10) {
        TreeMap r11 = new TreeMap();
        List<Descriptors.FieldDescriptor> r12 = FieldAccessorTable.access$000(internalGetFieldAccessorTable()).getFields();
        int r13 = 0;
    L4:
        if (r13 >= r12.size()) goto L25;
        Descriptors.FieldDescriptor r14 = r12.get(r13);
        Descriptors.OneofDescriptor r15 = r14.getContainingOneof();
        if (r15 == null) goto L12;
        r13 = r13 + (r15.getFieldCount() - 1);
        if (hasOneof(r15) == false) goto L24;
        r14 = getOneofFieldDescriptor(r15);
    L19:
        if (r10 == true) goto L21;
    L23:
        r11.put(r14, getField(r14));
        goto L24
    L21:
        if (r14.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) goto L23;
        r11.put(r14, getFieldRaw(r14));
    L24:
        r13 = r13 + 1;
        goto L4
    L12:
        if (r14.isRepeated() == false) goto L17;
        List r16 = (List) getField(r14);
        if (r16.isEmpty() == true) goto L24;
        r11.put(r14, r16);
        goto L24
    L17:
        if (hasField(r14) == true) goto L19;
    L25:
        return r11;
    }

    private static java.lang.reflect.Method getMethodOrDie(Class r10, String r11, Class... r12) {
        return r10.getMethod(r11, r12);
    L4:
        e = move-exception;
        throw new RuntimeException("Generated message class \"" + r10.getName() + "\" missing method \"" + r11 + "\".", e);
    }

    private static Object invokeOrDie(java.lang.reflect.Method r10, Object r11, Object... r12) {
        return r10.invoke(r11, r12);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r13 = e.getCause();
        if ((r13 instanceof RuntimeException) == true) goto L14;
        if ((r13 instanceof Error) == false) goto L12;
        throw ((Error) r13);
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r13);
    L14:
        throw ((RuntimeException) r13);
    }

    public static <M extends Message> M parseDelimitedWithIOException(Parser<M> r10, InputStream r11) throws IOException {
        return r10.parseDelimitedFrom(r11);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r10, InputStream r11) throws IOException {
        return r10.parseFrom(r11);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static void writeString(CodedOutputStream r10, int r11, Object r12) throws IOException {
        if ((r12 instanceof String) == false) goto L5;
        r10.writeString(r11, (String) r12);
        return;
    L5:
        r10.writeBytes(r11, (ByteString) r12);
    }

    public static void writeStringNoTag(CodedOutputStream r10, Object r11) throws IOException {
        if ((r11 instanceof String) == false) goto L5;
        r10.writeStringNoTag((String) r11);
        return;
    L5:
        r10.writeBytesNoTag((ByteString) r11);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return FieldAccessorTable.access$000(internalGetFieldAccessorTable());
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r10) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).get(this);
    }

    public Object getFieldRaw(Descriptors.FieldDescriptor r10) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRaw(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
        return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r10).get(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<? extends GeneratedMessageV3> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRepeated(this, r11);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRepeatedCount(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = MessageReflection.getSerializedSize(this, getAllFieldsRaw());
        this.memoizedSize = r11;
        return r11;
    }

    public UnknownFieldSet getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r10) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).has(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r10) {
        return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r10).has(this);
    }

    public abstract FieldAccessorTable internalGetFieldAccessorTable();

    public MapField internalGetMapField(int r10) {
        throw new RuntimeException("No map fields found in " + getClass().getName());
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        Iterator<Descriptors.FieldDescriptor> r10 = getDescriptorForType().getFields().iterator();
    L4:
        if (r10.hasNext() == false) goto L25;
        Descriptors.FieldDescriptor r11 = r10.next();
        if (r11.isRequired() == false) goto L11;
        if (hasField(r11) == true) goto L11;
        return false;
    L11:
        if (r11.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
        if (r11.isRepeated() == true) goto L14;
        if (hasField(r11) == false) goto L4;
        if (((Message) getField(r11)).isInitialized() == true) goto L4;
        return false;
    L14:
        Iterator r12 = ((List) getField(r11)).iterator();
    L16:
        if (r12.hasNext() == false) goto L4;
        if (((Message) r12.next()).isInitialized() == true) goto L16;
        return false;
    L25:
        return true;
    }

    public void makeExtensionsImmutable() {
    }

    @Override // com.google.protobuf.AbstractMessage
    public Message.Builder newBuilderForType(final AbstractMessage.BuilderParent r10) {
        return newBuilderForType(new AnonymousClass1(this, r10));
    }

    public abstract Message.Builder newBuilderForType(BuilderParent r10);

    public boolean parseUnknownField(CodedInputStream r10, UnknownFieldSet.Builder r11, ExtensionRegistryLite r12, int r13) throws IOException {
        return r11.mergeFieldFrom(r13, r10);
    }

    public Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) throws IOException {
        MessageReflection.writeMessageTo(this, getAllFieldsRaw(), r10, false);
    }

    public GeneratedMessageV3(Builder<?> r10) {
        this.unknownFields = r10.getUnknownFields();
    }

    public static <M extends Message> M parseDelimitedWithIOException(Parser<M> r10, InputStream r11, ExtensionRegistryLite r12) throws IOException {
        return r10.parseDelimitedFrom(r11, r12);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r10, InputStream r11, ExtensionRegistryLite r12) throws IOException {
        return r10.parseFrom(r11, r12);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r10, CodedInputStream r11) throws IOException {
        return r10.parseFrom(r11);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r10, CodedInputStream r11, ExtensionRegistryLite r12) throws IOException {
        return r10.parseFrom(r11, r12);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }
}
