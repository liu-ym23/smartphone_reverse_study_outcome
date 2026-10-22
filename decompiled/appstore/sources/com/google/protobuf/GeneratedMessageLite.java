package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    protected int memoizedSerializedSize;
    protected UnknownFieldSetLite unknownFields;

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r10 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r10;
            r10[WireFormat.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;
        protected boolean isBuilt;

        public Builder(MessageType r10) {
            this.defaultInstance = r10;
            this.instance = (MessageType) r10.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            this.isBuilt = false;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        public void copyOnWrite() {
            if (this.isBuilt == false) goto L6;
            MessageType r10 = (MessageType) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            r10.visit(MergeFromVisitor.INSTANCE, this.instance);
            this.instance = r10;
            this.isBuilt = false;
            return;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite r10) {
            return internalMergeFrom((GeneratedMessageLite) r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final MessageType build() {
            MessageType r10 = (MessageType) buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MessageType buildPartial() {
            if (this.isBuilt == true) goto L5;
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        L5:
            return this.instance;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final BuilderType clear() {
            this.instance = (MessageType) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        public BuilderType internalMergeFrom(MessageType r10) {
            return (BuilderType) mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            return clone();
        }

        public BuilderType mergeFrom(MessageType r10) {
            copyOnWrite();
            this.instance.visit(MergeFromVisitor.INSTANCE, r10);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            ExtendableBuilder r10 = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            r10.mergeFrom(buildPartial());
            return r10;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            copyOnWrite();
            this.instance.dynamicMethod(MethodToInvoke.MERGE_FROM_STREAM, r10, r11);     // Catch: RuntimeException -> L5
            return this;
        L5:
            e = move-exception;
            if ((e.getCause() instanceof IOException) == true) goto L9;
            throw e;
        L9:
            throw ((IOException) e.getCause());
        }
    }

    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private T defaultInstance;

        public DefaultInstanceBasedParser(T r10) {
            this.defaultInstance = r10;
        }

        @Override // com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return parsePartialFrom(r10, r11);
        }

        @Override // com.google.protobuf.Parser
        public T parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.parsePartialFrom(this.defaultInstance, r10, r11);
        }
    }

    public static class EqualsVisitor implements Visitor {
        static final EqualsVisitor INSTANCE = null;
        static final NotEqualsException NOT_EQUALS = null;

        public static final class NotEqualsException extends RuntimeException {
            public NotEqualsException() {
            }
        }

        static {
            INSTANCE = new EqualsVisitor();
            NOT_EQUALS = new NotEqualsException();
        }

        private EqualsVisitor() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean visitBoolean(boolean r10, boolean r11, boolean r12, boolean r13) {
            if (r10 != r12) goto L6;
            if (r11 != r13) goto L6;
            return r11;
        L6:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.BooleanList visitBooleanList(Internal.BooleanList r10, Internal.BooleanList r11) {
            if (r10.equals(r11) == false) goto L6;
            return r10;
        L6:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString visitByteString(boolean r10, ByteString r11, boolean r12, ByteString r13) {
            if (r10 != r12) goto L7;
            if (r11.equals(r13) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double visitDouble(boolean r10, double r11, boolean r12, double r13) {
            if (r10 != r12) goto L7;
            if (r11 != r13) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList visitDoubleList(Internal.DoubleList r10, Internal.DoubleList r11) {
            if (r10.equals(r11) == false) goto L6;
            return r10;
        L6:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<ExtensionDescriptor> visitExtensions(FieldSet<ExtensionDescriptor> r10, FieldSet<ExtensionDescriptor> r11) {
            if (r10.equals(r11) == false) goto L6;
            return r10;
        L6:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float visitFloat(boolean r10, float r11, boolean r12, float r13) {
            if (r10 != r12) goto L7;
            if (r11 != r13) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.FloatList visitFloatList(Internal.FloatList r10, Internal.FloatList r11) {
            if (r10.equals(r11) == false) goto L6;
            return r10;
        L6:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int visitInt(boolean r10, int r11, boolean r12, int r13) {
            if (r10 != r12) goto L6;
            if (r11 != r13) goto L6;
            return r11;
        L6:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList visitIntList(Internal.IntList r10, Internal.IntList r11) {
            if (r10.equals(r11) == false) goto L6;
            return r10;
        L6:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public LazyFieldLite visitLazyMessage(LazyFieldLite r10, LazyFieldLite r11) {
            if (r10 != null) goto L6;
            if (r11 != null) goto L6;
            return null;
        L6:
            if (r10 == null) goto L14;
            if (r11 == null) goto L14;
            if (r10.equals(r11) == false) goto L12;
            return r10;
        L12:
            throw NOT_EQUALS;
        L14:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> r10, Internal.ProtobufList<T> r11) {
            if (r10.equals(r11) == false) goto L6;
            return r10;
        L6:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long visitLong(boolean r10, long r11, boolean r12, long r13) {
            if (r10 != r12) goto L7;
            if (r11 != r13) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList visitLongList(Internal.LongList r10, Internal.LongList r11) {
            if (r10.equals(r11) == false) goto L6;
            return r10;
        L6:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> r10, MapFieldLite<K, V> r11) {
            if (r10.equals(r11) == false) goto L6;
            return r10;
        L6:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T visitMessage(T r10, T r11) {
            if (r10 != null) goto L6;
            if (r11 != null) goto L6;
            return null;
        L6:
            if (r10 == null) goto L11;
            if (r11 == null) goto L11;
            ((GeneratedMessageLite) r10).equals(this, r11);
            return r10;
        L11:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofBoolean(boolean r10, Object r11, Object r12) {
            if (r10 == false) goto L7;
            if (r11.equals(r12) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofByteString(boolean r10, Object r11, Object r12) {
            if (r10 == false) goto L7;
            if (r11.equals(r12) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofDouble(boolean r10, Object r11, Object r12) {
            if (r10 == false) goto L7;
            if (r11.equals(r12) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofFloat(boolean r10, Object r11, Object r12) {
            if (r10 == false) goto L7;
            if (r11.equals(r12) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofInt(boolean r10, Object r11, Object r12) {
            if (r10 == false) goto L7;
            if (r11.equals(r12) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLazyMessage(boolean r10, Object r11, Object r12) {
            if (r10 == false) goto L7;
            if (r11.equals(r12) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLong(boolean r10, Object r11, Object r12) {
            if (r10 == false) goto L7;
            if (r11.equals(r12) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofMessage(boolean r10, Object r11, Object r12) {
            if (r10 == false) goto L7;
            if (((GeneratedMessageLite) r11).equals(this, (MessageLite) r12) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void visitOneofNotSet(boolean r10) {
            if (r10 == true) goto L5;
            return;
        L5:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofString(boolean r10, Object r11, Object r12) {
            if (r10 == false) goto L7;
            if (r11.equals(r12) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String visitString(boolean r10, String r11, boolean r12, String r13) {
            if (r10 != r12) goto L7;
            if (r11.equals(r13) == false) goto L7;
            return r11;
        L7:
            throw NOT_EQUALS;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite r10, UnknownFieldSetLite r11) {
            if (r10.equals(r11) == false) goto L6;
            return r10;
        L6:
            throw NOT_EQUALS;
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        public ExtendableBuilder(MessageType r10) {
            super(r10);
            MessageType r11 = this.instance;
            ExtendableMessage r12 = (ExtendableMessage) r11;
            r12.extensions = ((ExtendableMessage) r11).extensions.clone();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r10) {
            if (r10.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> r10, Type r11) {
            GeneratedExtension<MessageType, ?> r12 = GeneratedMessageLite.access$200(r10);
            verifyExtensionContainingType(r12);
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions.addRepeatedField(r12.descriptor, r12.singularToFieldSetType(r11));
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite buildPartial() {
            return buildPartial();
        }

        public final <Type> BuilderType clearExtension(ExtensionLite<MessageType, ?> r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$200(r10);
            verifyExtensionContainingType(r11);
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions.clearField(r11.descriptor);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public void copyOnWrite() {
            if (this.isBuilt == true) goto L5;
            return;
        L5:
            super.copyOnWrite();
            MessageType r10 = this.instance;
            ExtendableMessage r11 = (ExtendableMessage) r10;
            r11.extensions = ((ExtendableMessage) r10).extensions.clone();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r10) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r10) {
            return ((ExtendableMessage) this.instance).getExtensionCount(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r10) {
            return ((ExtendableMessage) this.instance).hasExtension(r10);
        }

        public void internalSetExtensionSet(FieldSet<ExtensionDescriptor> r10) {
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions = r10;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> r10, Type r11) {
            GeneratedExtension<MessageType, ?> r12 = GeneratedMessageLite.access$200(r10);
            verifyExtensionContainingType(r12);
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions.setField(r12.descriptor, r12.toFieldSetType(r11));
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r10, int r11) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final MessageType buildPartial() {
            if (this.isBuilt == true) goto L5;
            ((ExtendableMessage) this.instance).extensions.makeImmutable();
            return (MessageType) super.buildPartial();
        L5:
            return (MessageType) this.instance;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            return (BuilderType) super.clone();
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> r10, int r11, Type r12) {
            GeneratedExtension<MessageType, ?> r13 = GeneratedMessageLite.access$200(r10);
            verifyExtensionContainingType(r13);
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions.setRepeatedField(r13.descriptor, r11, r13.singularToFieldSetType(r12));
            return this;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions;

        public class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            public /* synthetic */ ExtensionWriter(ExtendableMessage r10, boolean r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            public void writeUntil(int r10, CodedOutputStream r11) throws IOException {
            L2:
                Map.Entry<ExtensionDescriptor, Object> r12 = this.next;
                if (r12 == null) goto L18;
                if (r12.getKey().getNumber() >= r10) goto L26;
                ExtensionDescriptor r13 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L13:
                FieldSet.writeField(r13, this.next.getValue(), r11);
            L15:
                if (this.iter.hasNext() == true) goto L16;
                this.next = null;
                goto L2
            L16:
                this.next = this.iter.next();
                goto L2
            L9:
                if (r13.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L13;
                if (r13.isRepeated() == true) goto L13;
                r11.writeMessageSetExtension(r13.getNumber(), (MessageLite) this.next.getValue());
                goto L15
            L26:
                return;
            }

            private ExtensionWriter(ExtendableMessage r10, boolean r11) {
                this.this$0 = r10;
                Iterator r12 = r10.extensions.iterator();
                this.iter = r12;
                if (r12.hasNext() == false) goto L5;
                this.next = (Map.Entry) r12.next();
            L5:
                this.messageSetWireFormat = r11;
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r10) {
            if (r10.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
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

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$200(r10);
            verifyExtensionContainingType(r11);
            Object r12 = this.extensions.getField(r11.descriptor);
            if (r12 != null) goto L7;
            return r11.defaultValue;
        L7:
            return (Type) r11.fromFieldSetType(r12);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$200(r10);
            verifyExtensionContainingType(r11);
            return this.extensions.getRepeatedFieldCount(r11.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$200(r10);
            verifyExtensionContainingType(r11);
            return this.extensions.hasField(r11.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final void makeImmutable() {
            super.makeImmutable();
            this.extensions.makeImmutable();
        }

        public final void mergeExtensionFields(MessageType r10) {
            if (this.extensions.isImmutable() == false) goto L5;
            this.extensions = this.extensions.clone();
        L5:
            this.extensions.mergeFrom(r10.extensions);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        public <MessageType extends MessageLite> boolean parseUnknownField(MessageType r10, CodedInputStream r11, ExtensionRegistryLite r12, int r13) throws IOException {
            int r14 = WireFormat.getTagWireType(r13);
            int r15 = WireFormat.getTagFieldNumber(r13);
            GeneratedExtension r16 = r12.findLiteExtensionByNumber(r10, r15);
            if (r16 != null) goto L6;
        L4:
            boolean r17 = true;
            boolean r18 = false;
        L15:
            if (r17 == true) goto L17;
            if (r18 == false) goto L31;
            int r19 = r11.pushLimit(r11.readRawVarint32());
            if (r16.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L28;
        L22:
            if (r11.getBytesUntilLimit() <= 0) goto L30;
            Internal.EnumLite r110 = r16.descriptor.getEnumType().findValueByNumber(r11.readEnum());
            if (r110 == null) goto L25;
            this.extensions.addRepeatedField(r16.descriptor, r16.singularToFieldSetType(r110));
            goto L22
        L25:
            return true;
        L30:
            r11.popLimit(r19);
        L58:
            return true;
        L28:
            if (r11.getBytesUntilLimit() <= 0) goto L30;
            this.extensions.addRepeatedField(r16.descriptor, FieldSet.readPrimitiveField(r11, r16.descriptor.getLiteType(), false));
            goto L28
        L31:
            int r111 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r16.descriptor.getLiteJavaType().ordinal()];
            if (r111 == 1) goto L42;
            if (r111 == 2) goto L36;
            Object r20 = FieldSet.readPrimitiveField(r11, r16.descriptor.getLiteType(), false);
        L55:
            if (r16.descriptor.isRepeated() == false) goto L57;
            this.extensions.addRepeatedField(r16.descriptor, r16.singularToFieldSetType(r20));
            goto L58
        L57:
            this.extensions.setField(r16.descriptor, r16.singularToFieldSetType(r20));
            goto L58
        L36:
            int r21 = r11.readEnum();
            Internal.EnumLite r22 = r16.descriptor.getEnumType().findValueByNumber(r21);
            if (r22 != null) goto L40;
            mergeVarintField(r15, r21);
            return true;
        L40:
            r20 = r22;
            goto L55
        L42:
            if (r16.descriptor.isRepeated() == true) goto L46;
            MessageLite r112 = (MessageLite) this.extensions.getField(r16.descriptor);
            if (r112 == null) goto L46;
            MessageLite.Builder r113 = r112.toBuilder();
        L47:
            if (r113 != null) goto L50;
            r113 = r16.getMessageDefaultInstance().newBuilderForType();
        L50:
            if (r16.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L52;
            r11.readGroup(r16.getNumber(), r113, r12);
        L53:
            r20 = r113.build();
            goto L55
        L52:
            r11.readMessage(r113, r12);
        L46:
            r113 = null;
            goto L47
        L17:
            return parseUnknownField(r13, r11);
        L6:
            if (r14 != FieldSet.getWireFormatForFieldType(r16.descriptor.getLiteType(), false)) goto L8;
            r17 = false;
            r18 = false;
            goto L15
        L8:
            ExtensionDescriptor r23 = r16.descriptor;
            if (r23.isRepeated == false) goto L4;
            if (r23.type.isPackable() == false) goto L4;
            if (r14 != FieldSet.getWireFormatForFieldType(r16.descriptor.getLiteType(), true)) goto L4;
            r18 = true;
            r17 = false;
            goto L15
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public /* bridge */ /* synthetic */ void visit(Visitor r10, GeneratedMessageLite r11) {
            visit(r10, (ExtendableMessage) r11);
        }

        public final void visit(Visitor r10, MessageType r11) {
            super.visit(r10, r11);
            this.extensions = r10.visitExtensions(this.extensions, r11.extensions);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r10, int r11) {
            GeneratedExtension<MessageType, ?> r12 = GeneratedMessageLite.access$200(r10);
            verifyExtensionContainingType(r12);
            return (Type) r12.singularFromFieldSetType(this.extensions.getRepeatedField(r12.descriptor, r11));
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> r10);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r10, int r11);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r10);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r10);
    }

    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        public ExtensionDescriptor(Internal.EnumLiteMap<?> r10, int r11, WireFormat.FieldType r12, boolean r13, boolean r14) {
            this.enumTypeMap = r10;
            this.number = r11;
            this.type = r12;
            this.isRepeated = r13;
            this.isPacked = r14;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return compareTo((ExtensionDescriptor) r10);
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r10, MessageLite r11) {
            return ((Builder) r10).mergeFrom((GeneratedMessageLite) r11);
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        public int compareTo(ExtensionDescriptor r10) {
            return this.number - r10.number;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final MessageLite messageDefaultInstance;

        public GeneratedExtension(ContainingType r10, Type r11, MessageLite r12, ExtensionDescriptor r13, Class r14) {
            if (r10 == null) goto L13;
            if (r13.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (r12 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = r10;
            this.defaultValue = r11;
            this.messageDefaultInstance = r12;
            this.descriptor = r13;
            return;
        L13:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public Object fromFieldSetType(Object r10) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r11 = new ArrayList();
            Iterator r12 = ((List) r10).iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r11.add(singularFromFieldSetType(r12.next()));
            goto L8
        L10:
            return r11;
        L11:
            return r10;
        L13:
            return singularFromFieldSetType(r10);
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        @Override // com.google.protobuf.ExtensionLite
        public Type getDefaultValue() {
            return this.defaultValue;
        }

        @Override // com.google.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return this.descriptor.getLiteType();
        }

        @Override // com.google.protobuf.ExtensionLite
        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return this.descriptor.getNumber();
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return this.descriptor.isRepeated;
        }

        public Object singularFromFieldSetType(Object r10) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r10;
        L5:
            return this.descriptor.enumTypeMap.findValueByNumber(((Integer) r10).intValue());
        }

        public Object singularToFieldSetType(Object r10) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r10;
        L5:
            return Integer.valueOf(((Internal.EnumLite) r10).getNumber());
        }

        public Object toFieldSetType(Object r10) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r11 = new ArrayList();
            Iterator r12 = ((List) r10).iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r11.add(singularToFieldSetType(r12.next()));
            goto L8
        L10:
            return r11;
        L11:
            return r10;
        L13:
            return singularToFieldSetType(r10);
        }
    }

    public static class HashCodeVisitor implements Visitor {
        private int hashCode;

        private HashCodeVisitor() {
            this.hashCode = 0;
        }

        public static /* synthetic */ int access$100(HashCodeVisitor r10) {
            return r10.hashCode;
        }

        public static /* synthetic */ int access$102(HashCodeVisitor r10, int r11) {
            r10.hashCode = r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean visitBoolean(boolean r10, boolean r11, boolean r12, boolean r13) {
            this.hashCode = (this.hashCode * 53) + Internal.hashBoolean(r11);
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.BooleanList visitBooleanList(Internal.BooleanList r10, Internal.BooleanList r11) {
            this.hashCode = (this.hashCode * 53) + r10.hashCode();
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString visitByteString(boolean r10, ByteString r11, boolean r12, ByteString r13) {
            this.hashCode = (this.hashCode * 53) + r11.hashCode();
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double visitDouble(boolean r10, double r11, boolean r12, double r13) {
            this.hashCode = (this.hashCode * 53) + Internal.hashLong(Double.doubleToLongBits(r11));
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList visitDoubleList(Internal.DoubleList r10, Internal.DoubleList r11) {
            this.hashCode = (this.hashCode * 53) + r10.hashCode();
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<ExtensionDescriptor> visitExtensions(FieldSet<ExtensionDescriptor> r10, FieldSet<ExtensionDescriptor> r11) {
            this.hashCode = (this.hashCode * 53) + r10.hashCode();
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float visitFloat(boolean r10, float r11, boolean r12, float r13) {
            this.hashCode = (this.hashCode * 53) + Float.floatToIntBits(r11);
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.FloatList visitFloatList(Internal.FloatList r10, Internal.FloatList r11) {
            this.hashCode = (this.hashCode * 53) + r10.hashCode();
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int visitInt(boolean r10, int r11, boolean r12, int r13) {
            this.hashCode = (this.hashCode * 53) + r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList visitIntList(Internal.IntList r10, Internal.IntList r11) {
            this.hashCode = (this.hashCode * 53) + r10.hashCode();
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public LazyFieldLite visitLazyMessage(LazyFieldLite r10, LazyFieldLite r11) {
            if (r10 == null) goto L4;
            int r12 = r10.hashCode();
        L5:
            this.hashCode = (this.hashCode * 53) + r12;
            return r10;
        L4:
            r12 = 37;
            goto L5
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> r10, Internal.ProtobufList<T> r11) {
            this.hashCode = (this.hashCode * 53) + r10.hashCode();
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long visitLong(boolean r10, long r11, boolean r12, long r13) {
            this.hashCode = (this.hashCode * 53) + Internal.hashLong(r11);
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList visitLongList(Internal.LongList r10, Internal.LongList r11) {
            this.hashCode = (this.hashCode * 53) + r10.hashCode();
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> r10, MapFieldLite<K, V> r11) {
            this.hashCode = (this.hashCode * 53) + r10.hashCode();
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T visitMessage(T r10, T r11) {
            if (r10 != null) goto L4;
            int r12 = 37;
        L8:
            this.hashCode = (this.hashCode * 53) + r12;
            return r10;
        L4:
            if ((r10 instanceof GeneratedMessageLite) == false) goto L6;
            r12 = ((GeneratedMessageLite) r10).hashCode(this);
            goto L8
        L6:
            r12 = r10.hashCode();
            goto L8
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofBoolean(boolean r10, Object r11, Object r12) {
            this.hashCode = (this.hashCode * 53) + Internal.hashBoolean(((Boolean) r11).booleanValue());
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofByteString(boolean r10, Object r11, Object r12) {
            this.hashCode = (this.hashCode * 53) + r11.hashCode();
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofDouble(boolean r10, Object r11, Object r12) {
            this.hashCode = (this.hashCode * 53) + Internal.hashLong(Double.doubleToLongBits(((Double) r11).doubleValue()));
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofFloat(boolean r10, Object r11, Object r12) {
            this.hashCode = (this.hashCode * 53) + Float.floatToIntBits(((Float) r11).floatValue());
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofInt(boolean r10, Object r11, Object r12) {
            this.hashCode = (this.hashCode * 53) + ((Integer) r11).intValue();
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLazyMessage(boolean r10, Object r11, Object r12) {
            this.hashCode = (this.hashCode * 53) + r11.hashCode();
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLong(boolean r10, Object r11, Object r12) {
            this.hashCode = (this.hashCode * 53) + Internal.hashLong(((Long) r11).longValue());
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofMessage(boolean r10, Object r11, Object r12) {
            return visitMessage((MessageLite) r11, (MessageLite) r12);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void visitOneofNotSet(boolean r10) {
            if (r10 == true) goto L5;
            return;
        L5:
            throw new IllegalStateException();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofString(boolean r10, Object r11, Object r12) {
            this.hashCode = (this.hashCode * 53) + r11.hashCode();
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String visitString(boolean r10, String r11, boolean r12, String r13) {
            this.hashCode = (this.hashCode * 53) + r11.hashCode();
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite r10, UnknownFieldSetLite r11) {
            this.hashCode = (this.hashCode * 53) + r10.hashCode();
            return r10;
        }

        public /* synthetic */ HashCodeVisitor(AnonymousClass1 r10) {
            this();
        }
    }

    public static class MergeFromVisitor implements Visitor {
        public static final MergeFromVisitor INSTANCE = null;

        static {
            INSTANCE = new MergeFromVisitor();
        }

        private MergeFromVisitor() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean visitBoolean(boolean r10, boolean r11, boolean r12, boolean r13) {
            if (r12 == true) goto L4;
            return r11;
        L4:
            return r13;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.BooleanList visitBooleanList(Internal.BooleanList r10, Internal.BooleanList r11) {
            int r12 = r10.size();
            int r13 = r11.size();
            Internal.BooleanList r14 = r10;
            r14 = r10;
            if (r12 <= 0) goto L9;
            if (r13 <= 0) goto L9;
            boolean r15 = r10.isModifiable();
            Internal.BooleanList r16 = r10;
            if (r15 == true) goto L8;
            r16 = r10.mutableCopyWithCapacity(r13 + r12);
        L8:
            r16.addAll(r11);
            r14 = r16;
        L9:
            if (r12 > 0) goto L11;
            return r11;
        L11:
            return r14;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString visitByteString(boolean r10, ByteString r11, boolean r12, ByteString r13) {
            if (r12 == true) goto L4;
            return r11;
        L4:
            return r13;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double visitDouble(boolean r10, double r11, boolean r12, double r13) {
            if (r12 == true) goto L4;
            return r11;
        L4:
            return r13;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList visitDoubleList(Internal.DoubleList r10, Internal.DoubleList r11) {
            int r12 = r10.size();
            int r13 = r11.size();
            Internal.DoubleList r14 = r10;
            r14 = r10;
            if (r12 <= 0) goto L9;
            if (r13 <= 0) goto L9;
            boolean r15 = r10.isModifiable();
            Internal.DoubleList r16 = r10;
            if (r15 == true) goto L8;
            r16 = r10.mutableCopyWithCapacity(r13 + r12);
        L8:
            r16.addAll(r11);
            r14 = r16;
        L9:
            if (r12 > 0) goto L11;
            return r11;
        L11:
            return r14;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<ExtensionDescriptor> visitExtensions(FieldSet<ExtensionDescriptor> r10, FieldSet<ExtensionDescriptor> r11) {
            if (r10.isImmutable() == false) goto L5;
            r10 = r10.clone();
        L5:
            r10.mergeFrom(r11);
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float visitFloat(boolean r10, float r11, boolean r12, float r13) {
            if (r12 == true) goto L4;
            return r11;
        L4:
            return r13;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.FloatList visitFloatList(Internal.FloatList r10, Internal.FloatList r11) {
            int r12 = r10.size();
            int r13 = r11.size();
            Internal.FloatList r14 = r10;
            r14 = r10;
            if (r12 <= 0) goto L9;
            if (r13 <= 0) goto L9;
            boolean r15 = r10.isModifiable();
            Internal.FloatList r16 = r10;
            if (r15 == true) goto L8;
            r16 = r10.mutableCopyWithCapacity(r13 + r12);
        L8:
            r16.addAll(r11);
            r14 = r16;
        L9:
            if (r12 > 0) goto L11;
            return r11;
        L11:
            return r14;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int visitInt(boolean r10, int r11, boolean r12, int r13) {
            if (r12 == true) goto L4;
            return r11;
        L4:
            return r13;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList visitIntList(Internal.IntList r10, Internal.IntList r11) {
            int r12 = r10.size();
            int r13 = r11.size();
            Internal.IntList r14 = r10;
            r14 = r10;
            if (r12 <= 0) goto L9;
            if (r13 <= 0) goto L9;
            boolean r15 = r10.isModifiable();
            Internal.IntList r16 = r10;
            if (r15 == true) goto L8;
            r16 = r10.mutableCopyWithCapacity(r13 + r12);
        L8:
            r16.addAll(r11);
            r14 = r16;
        L9:
            if (r12 > 0) goto L11;
            return r11;
        L11:
            return r14;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public LazyFieldLite visitLazyMessage(LazyFieldLite r10, LazyFieldLite r11) {
            if (r11 == null) goto L6;
            if (r10 != null) goto L5;
            r10 = new LazyFieldLite();
        L5:
            r10.merge(r11);
        L6:
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> r10, Internal.ProtobufList<T> r11) {
            int r12 = r10.size();
            int r13 = r11.size();
            if (r12 <= 0) goto L9;
            if (r13 <= 0) goto L9;
            if (r10.isModifiable() == true) goto L8;
            r10 = r10.mutableCopyWithCapacity(r13 + r12);
        L8:
            r10.addAll(r11);
        L9:
            if (r12 > 0) goto L11;
            return r11;
        L11:
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long visitLong(boolean r10, long r11, boolean r12, long r13) {
            if (r12 == true) goto L4;
            return r11;
        L4:
            return r13;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList visitLongList(Internal.LongList r10, Internal.LongList r11) {
            int r12 = r10.size();
            int r13 = r11.size();
            Internal.LongList r14 = r10;
            r14 = r10;
            if (r12 <= 0) goto L9;
            if (r13 <= 0) goto L9;
            boolean r15 = r10.isModifiable();
            Internal.LongList r16 = r10;
            if (r15 == true) goto L8;
            r16 = r10.mutableCopyWithCapacity(r13 + r12);
        L8:
            r16.addAll(r11);
            r14 = r16;
        L9:
            if (r12 > 0) goto L11;
            return r11;
        L11:
            return r14;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> r10, MapFieldLite<K, V> r11) {
            if (r11.isEmpty() == false) goto L5;
        L8:
            return r10;
        L5:
            if (r10.isMutable() == true) goto L7;
            r10 = r10.mutableCopy();
        L7:
            r10.mergeFrom(r11);
            goto L8
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T visitMessage(T r10, T r11) {
            if (r10 == null) goto L6;
            if (r11 == null) goto L6;
            return (T) r10.toBuilder().mergeFrom(r11).build();
        L6:
            if (r10 == null) goto L9;
            return r10;
        L9:
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofBoolean(boolean r10, Object r11, Object r12) {
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofByteString(boolean r10, Object r11, Object r12) {
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofDouble(boolean r10, Object r11, Object r12) {
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofFloat(boolean r10, Object r11, Object r12) {
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofInt(boolean r10, Object r11, Object r12) {
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLazyMessage(boolean r10, Object r11, Object r12) {
            if (r10 == false) goto L4;
            LazyFieldLite r13 = (LazyFieldLite) r11;
        L5:
            r13.merge((LazyFieldLite) r12);
            return r13;
        L4:
            r13 = new LazyFieldLite();
            goto L5
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLong(boolean r10, Object r11, Object r12) {
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofMessage(boolean r10, Object r11, Object r12) {
            if (r10 == true) goto L4;
            return r12;
        L4:
            return visitMessage((MessageLite) r11, (MessageLite) r12);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void visitOneofNotSet(boolean r10) {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofString(boolean r10, Object r11, Object r12) {
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String visitString(boolean r10, String r11, boolean r12, String r13) {
            if (r12 == true) goto L4;
            return r11;
        L4:
            return r13;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite r10, UnknownFieldSetLite r11) {
            if (r11 != UnknownFieldSetLite.getDefaultInstance()) goto L6;
            return r10;
        L6:
            return UnknownFieldSetLite.mutableCopyOf(r10, r11);
        }
    }

    public static final enum MethodToInvoke extends java.lang.Enum<MethodToInvoke> {
        private static final /* synthetic */ MethodToInvoke[] $VALUES = null;
        public static final MethodToInvoke GET_DEFAULT_INSTANCE = null;
        public static final MethodToInvoke GET_PARSER = null;
        public static final MethodToInvoke IS_INITIALIZED = null;
        public static final MethodToInvoke MAKE_IMMUTABLE = null;
        public static final MethodToInvoke MERGE_FROM_STREAM = null;
        public static final MethodToInvoke NEW_BUILDER = null;
        public static final MethodToInvoke NEW_MUTABLE_INSTANCE = null;
        public static final MethodToInvoke VISIT = null;

        static {
            MethodToInvoke r10 = new MethodToInvoke("IS_INITIALIZED", 0);
            IS_INITIALIZED = r10;
            MethodToInvoke r11 = new MethodToInvoke("VISIT", 1);
            VISIT = r11;
            MethodToInvoke r12 = new MethodToInvoke("MERGE_FROM_STREAM", 2);
            MERGE_FROM_STREAM = r12;
            MethodToInvoke r13 = new MethodToInvoke("MAKE_IMMUTABLE", 3);
            MAKE_IMMUTABLE = r13;
            MethodToInvoke r14 = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 4);
            NEW_MUTABLE_INSTANCE = r14;
            MethodToInvoke r15 = new MethodToInvoke("NEW_BUILDER", 5);
            NEW_BUILDER = r15;
            MethodToInvoke r16 = new MethodToInvoke("GET_DEFAULT_INSTANCE", 6);
            GET_DEFAULT_INSTANCE = r16;
            MethodToInvoke r17 = new MethodToInvoke("GET_PARSER", 7);
            GET_PARSER = r17;
            $VALUES = new MethodToInvoke[]{r10, r11, r12, r13, r14, r15, r16, r17};
        }

        private MethodToInvoke(String r10, int r11) {
            super(r10, r11);
        }

        public static MethodToInvoke valueOf(String r10) {
            return (MethodToInvoke) java.lang.Enum.valueOf(MethodToInvoke.class, r10);
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) $VALUES.clone();
        }
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final String messageClassName;

        public SerializedForm(MessageLite r10) {
            this.messageClassName = r10.getClass().getName();
            this.asBytes = r10.toByteArray();
        }

        public static SerializedForm of(MessageLite r10) {
            return new SerializedForm(r10);
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            java.lang.reflect.Field r10 = Class.forName(this.messageClassName).getDeclaredField("defaultInstance");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 NoSuchFieldException -> L10 ClassNotFoundException -> L12
            r10.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 NoSuchFieldException -> L10 ClassNotFoundException -> L12
            return ((MessageLite) r10.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        L12:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to call parsePartialFrom", e);
        L10:
            e = move-exception;
            throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e);
        L8:
            e = move-exception;
            throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e);
        }

        public Object readResolve() throws ObjectStreamException {
            java.lang.reflect.Field r10 = Class.forName(this.messageClassName).getDeclaredField("DEFAULT_INSTANCE");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 ClassNotFoundException -> L10 NoSuchFieldException -> L18
            r10.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L6 SecurityException -> L8 ClassNotFoundException -> L10 NoSuchFieldException -> L18
            return ((MessageLite) r10.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        L10:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to call parsePartialFrom", e);
        L8:
            e = move-exception;
            throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e);
        L19:
            return readResolveFallback();
        }
    }

    public interface Visitor {
        boolean visitBoolean(boolean r10, boolean r11, boolean r12, boolean r13);

        Internal.BooleanList visitBooleanList(Internal.BooleanList r10, Internal.BooleanList r11);

        ByteString visitByteString(boolean r10, ByteString r11, boolean r12, ByteString r13);

        double visitDouble(boolean r10, double r11, boolean r12, double r13);

        Internal.DoubleList visitDoubleList(Internal.DoubleList r10, Internal.DoubleList r11);

        FieldSet<ExtensionDescriptor> visitExtensions(FieldSet<ExtensionDescriptor> r10, FieldSet<ExtensionDescriptor> r11);

        float visitFloat(boolean r10, float r11, boolean r12, float r13);

        Internal.FloatList visitFloatList(Internal.FloatList r10, Internal.FloatList r11);

        int visitInt(boolean r10, int r11, boolean r12, int r13);

        Internal.IntList visitIntList(Internal.IntList r10, Internal.IntList r11);

        LazyFieldLite visitLazyMessage(LazyFieldLite r10, LazyFieldLite r11);

        <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> r10, Internal.ProtobufList<T> r11);

        long visitLong(boolean r10, long r11, boolean r12, long r13);

        Internal.LongList visitLongList(Internal.LongList r10, Internal.LongList r11);

        <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> r10, MapFieldLite<K, V> r11);

        <T extends MessageLite> T visitMessage(T r10, T r11);

        Object visitOneofBoolean(boolean r10, Object r11, Object r12);

        Object visitOneofByteString(boolean r10, Object r11, Object r12);

        Object visitOneofDouble(boolean r10, Object r11, Object r12);

        Object visitOneofFloat(boolean r10, Object r11, Object r12);

        Object visitOneofInt(boolean r10, Object r11, Object r12);

        Object visitOneofLazyMessage(boolean r10, Object r11, Object r12);

        Object visitOneofLong(boolean r10, Object r11, Object r12);

        Object visitOneofMessage(boolean r10, Object r11, Object r12);

        void visitOneofNotSet(boolean r10);

        Object visitOneofString(boolean r10, Object r11, Object r12);

        String visitString(boolean r10, String r11, boolean r12, String r13);

        UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite r10, UnknownFieldSetLite r11);
    }

    public GeneratedMessageLite() {
        this.unknownFields = UnknownFieldSetLite.getDefaultInstance();
        this.memoizedSerializedSize = -1;
    }

    public static /* synthetic */ GeneratedExtension access$200(ExtensionLite r10) {
        return checkIsLite(r10);
    }

    private static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> r10) {
        if (r10.isLite() == false) goto L7;
        return (GeneratedExtension) r10;
    L7:
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T r10) throws InvalidProtocolBufferException {
        if (r10 != null) goto L4;
    L8:
        return r10;
    L4:
        if (r10.isInitialized() == true) goto L8;
        throw r10.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(r10);
    }

    public static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    public static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    public static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    public static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    public static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    public static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        this.unknownFields = UnknownFieldSetLite.newInstance();
        return;
    }

    public static java.lang.reflect.Method getMethodOrDie(Class r10, String r11, Class... r12) {
        return r10.getMethod(r11, r12);
    L4:
        e = move-exception;
        throw new RuntimeException("Generated message class \"" + r10.getName() + "\" missing method \"" + r11 + "\".", e);
    }

    public static Object invokeOrDie(java.lang.reflect.Method r10, Object r11, Object... r12) {
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

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$IntList] */
    public static Internal.IntList mutableCopy(Internal.IntList r10) {
        int r11 = r10.size();
        if (r11 != 0) goto L5;
        int r12 = 10;
    L7:
        return r10.mutableCopyWithCapacity(r12);
    L5:
        r12 = r11 * 2;
        goto L7
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType r13, MessageLite r14, Internal.EnumLiteMap<?> r15, int r16, WireFormat.FieldType r17, boolean r18, Class r19) {
        return new GeneratedExtension(r13, Collections.emptyList(), r14, new ExtensionDescriptor(r15, r16, r17, true, r18), r19);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType r10, Type r11, MessageLite r12, Internal.EnumLiteMap<?> r13, int r14, WireFormat.FieldType r15, Class r16) {
        return new GeneratedExtension(r10, r11, r12, new ExtensionDescriptor(r13, r14, r15, false, false), r16);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r10, InputStream r11) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, ByteString r11) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry()));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T r10, InputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        int r13 = r11.read();     // Catch: IOException -> L13
        if (r13 != (-1)) goto L6;
        return null;
    L6:
        CodedInputStream r14 = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(r11, CodedInputStream.readRawVarint32(r13, r11)));
        T r15 = (T) parsePartialFrom(r10, r14, r12);
        r14.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L10
        return r15;
    L10:
        e = move-exception;
        throw e.setUnfinishedMessage(r15);
    L13:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r10, CodedInputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        T r13 = (T) r10.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        r13.dynamicMethod(MethodToInvoke.MERGE_FROM_STREAM, r11, r12);     // Catch: RuntimeException -> L5
        r13.makeImmutable();     // Catch: RuntimeException -> L5
        return r13;
    L5:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == true) goto L9;
        throw e;
    L9:
        throw ((InvalidProtocolBufferException) e.getCause());
    }

    public Object dynamicMethod(MethodToInvoke r10, Object r11) {
        return dynamicMethod(r10, r11, null);
    }

    public abstract Object dynamicMethod(MethodToInvoke r10, Object r11, Object r12);

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (getDefaultInstanceForType().getClass().isInstance(r10) == true) goto L11;
        return false;
    L11:
        visit(EqualsVisitor.INSTANCE, (GeneratedMessageLite) r10);     // Catch: EqualsVisitor.NotEqualsException -> L10
        return true;
    L10:
        return false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L6;
        HashCodeVisitor r10 = new HashCodeVisitor(null);
        visit(r10, this);
        this.memoizedHashCode = HashCodeVisitor.access$100(r10);
    L6:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if (dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.TRUE) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void makeImmutable() {
        dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
        this.unknownFields.makeImmutable();
    }

    public void mergeLengthDelimitedField(int r10, ByteString r11) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(r10, r11);
    }

    public final void mergeUnknownFields(UnknownFieldSetLite r10) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, r10);
    }

    public void mergeVarintField(int r10, int r11) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(r10, r11);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public boolean parseUnknownField(int r10, CodedInputStream r11) throws IOException {
        if (WireFormat.getTagWireType(r10) != 4) goto L6;
        return false;
    L6:
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(r10, r11);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    public void visit(Visitor r10, MessageType r11) {
        dynamicMethod(MethodToInvoke.VISIT, r10, r11);
        this.unknownFields = r10.visitUnknownFields(this.unknownFields, r11.unknownFields);
    }

    public static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T r10, boolean r11) {
        if (r10.dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.valueOf(r11)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Object dynamicMethod(MethodToInvoke r10) {
        return dynamicMethod(r10, null, null);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final BuilderType toBuilder() {
        BuilderType r10 = (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
        r10.mergeFrom(this);
        return r10;
    }

    public static final <T extends GeneratedMessageLite<T, ?>> void makeImmutable(T r10) {
        r10.dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$LongList] */
    public static Internal.LongList mutableCopy(Internal.LongList r10) {
        int r11 = r10.size();
        if (r11 != 0) goto L5;
        int r12 = 10;
    L7:
        return r10.mutableCopyWithCapacity(r12);
    L5:
        r12 = r11 * 2;
        goto L7
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, ByteString r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r10, r11, r12));
    }

    public boolean equals(EqualsVisitor r10, MessageLite r11) {
        if (this != r11) goto L6;
        return true;
    L6:
        if (getDefaultInstanceForType().getClass().isInstance(r11) == true) goto L9;
        return false;
    L9:
        visit(r10, (GeneratedMessageLite) r11);
        return true;
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r10, InputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r10, r11, r12));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, byte[] r11) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry()));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$FloatList] */
    public static Internal.FloatList mutableCopy(Internal.FloatList r10) {
        int r11 = r10.size();
        if (r11 != 0) goto L5;
        int r12 = 10;
    L7:
        return r10.mutableCopyWithCapacity(r12);
    L5:
        r12 = r11 * 2;
        goto L7
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, byte[] r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r10, r11, r12));
    }

    public int hashCode(HashCodeVisitor r10) {
        if (this.memoizedHashCode != 0) goto L6;
        int r11 = HashCodeVisitor.access$100(r10);
        HashCodeVisitor.access$102(r10, 0);
        visit(r10, this);
        this.memoizedHashCode = HashCodeVisitor.access$100(r10);
        HashCodeVisitor.access$102(r10, r11);
    L6:
        return this.memoizedHashCode;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$DoubleList] */
    public static Internal.DoubleList mutableCopy(Internal.DoubleList r10) {
        int r11 = r10.size();
        if (r11 != 0) goto L5;
        int r12 = 10;
    L7:
        return r10.mutableCopyWithCapacity(r12);
    L5:
        r12 = r11 * 2;
        goto L7
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, InputStream r11) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r10, CodedInputStream.newInstance(r11), ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r10, CodedInputStream r11) throws InvalidProtocolBufferException {
        return (T) parsePartialFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r10, ByteString r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        CodedInputStream r13 = r11.newCodedInput();
        T r14 = (T) parsePartialFrom(r10, r13, r12);
        r13.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r14;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r14);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$BooleanList] */
    public static Internal.BooleanList mutableCopy(Internal.BooleanList r10) {
        int r11 = r10.size();
        if (r11 != 0) goto L5;
        int r12 = 10;
    L7:
        return r10.mutableCopyWithCapacity(r12);
    L5:
        r12 = r11 * 2;
        goto L7
    }

    public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> r10) {
        int r11 = r10.size();
        if (r11 != 0) goto L5;
        int r12 = 10;
    L7:
        return r10.mutableCopyWithCapacity(r12);
    L5:
        r12 = r11 * 2;
        goto L7
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, InputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r10, CodedInputStream.newInstance(r11), r12));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r10, byte[] r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        CodedInputStream r13 = CodedInputStream.newInstance(r11);
        T r14 = (T) parsePartialFrom(r10, r13, r12);
        r13.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r14;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r14);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, CodedInputStream r11) throws InvalidProtocolBufferException {
        return (T) parseFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, CodedInputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r10, r11, r12));
    }
}
